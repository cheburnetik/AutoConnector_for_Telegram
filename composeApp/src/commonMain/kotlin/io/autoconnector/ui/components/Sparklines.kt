package io.autoconnector.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.sp
import kotlin.math.ln
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.roundToLong

/** Settings-driven master switch for the live sparkline charts. Provided in App
 *  from `EngineSettings.drawGraphs`; when false the graph rows draw only their
 *  numeric readings and skip the per-frame Canvas animation (saves battery). */
val LocalDrawGraphs = staticCompositionLocalOf { true }

// ── tuning ────────────────────────────────────────────────────────────────────
// One new bucket per frame: the whole strip slides right by exactly one slot
// (the width of the leftmost bar) while the fresh leftmost bar grows from zero.
private const val ANIM_MS = 300_000_000L       // 0.3 s for both slide and grow
private const val LOG_MIX = 0.40               // blend: 40% log + 60% linear
private val FrameColor = Color(0x55808080)
private val PanelColor = Color(0x0C808080)
private val GridColor = Color(0x40808080)
private val LabelFill = Color(0xFFEAEEF2)
private val LabelHalo = Color(0xE0000000)

// Frame-invariant gridline label styling — these never change, so they are hoisted
// out of the per-frame draw lambda (they used to be reallocated on every frame).
private val GRID_STYLE_DARK = TextStyle(color = LabelFill, fontSize = 9.sp, fontWeight = FontWeight.Bold)
private val GRID_STYLE_HALO = TextStyle(color = LabelHalo, fontSize = 9.sp, fontWeight = FontWeight.Bold)
// The four 1px offsets that paint the white halo around each label (constant set).
private val HALO_OFFSETS = arrayOf(Offset(-1f, 0f), Offset(1f, 0f), Offset(0f, -1f), Offset(0f, 1f))

/** cubic ease-in-out: slow → fast → slow. */
private fun easeInOut(t: Float): Float =
    if (t <= 0f) 0f else if (t >= 1f) 1f
    else if (t < 0.5f) 4 * t * t * t else 1 - (-2 * t + 2).pow(3) / 2

/** smallest "nice" 1/2/5·10^k ≥ v — used for the auto-scale ceiling. */
private fun niceCeil(v: Long): Long {
    if (v <= 1) return 1
    var mag = 1L
    while (mag * 10 <= v) mag *= 10
    for (m in longArrayOf(1, 2, 5, 10)) { val c = m * mag; if (c >= v) return c }
    return 10 * mag
}

/** nearest "nice" number (1/2/3/4/5/6/8/10·10^k) — used for gridline labels. */
private fun roundNice(v: Double): Long {
    if (v <= 1.0) return 1L
    val mag = 10.0.pow(kotlin.math.floor(kotlin.math.log10(v)))
    val f = v / mag
    val nice = when {
        f < 1.5 -> 1.0; f < 2.5 -> 2.0; f < 3.5 -> 3.0; f < 4.5 -> 4.0
        f < 5.5 -> 5.0; f < 7.0 -> 6.0; f < 9.0 -> 8.0; else -> 10.0
    }
    return (nice * mag).roundToLong()
}

// ── frame-invariant geometry / gridline memoization ───────────────────────────
// The Canvas draw lambda re-runs on every animation frame (~18 fps over the 0.3 s
// slide, for up to 12 graphs every 2 s). Bar-slot geometry depends only on the
// canvas size + density, and the gridline set (values, labels, measured text
// layouts) only on that plus scaleMax — none of it changes frame-to-frame during
// the slide. We compute each once and reuse it via [GraphCache], so a slide frame
// only re-positions bar rectangles. This is pure caching: identical pixels, no
// behaviour change, and it does NOT gate the animation in any way.

/** Bar-slot geometry: slot count + left edges (pos, length n+1) + widths (wid). */
private class BarGeom(val n: Int, val pos: FloatArray, val wid: FloatArray)

/** first bar 5× wide → normal by the 5th; depends only on width + density. */
private fun computeBarGeom(w: Float, d: Float): BarGeom {
    var s5 = 0.0
    for (i in 0 until 5) s5 += 5.0.pow(1 - i / 4.0)            // ≈13.07
    var normalW = 4 * d
    val n = max(6, (w / normalW - s5 + 5).toInt())
    normalW = (w / (s5 + (n - 5))).toFloat()                  // exact fit
    val pos = FloatArray(n + 1)
    val wid = FloatArray(n)
    var cx = 0f
    for (i in 0 until n) {
        val f = if (i < 5) 5.0.pow(1 - i / 4.0).toFloat() else 1f
        wid[i] = f * normalW; pos[i] = cx; cx += wid[i]
    }
    pos[n] = cx
    return BarGeom(n, pos, wid)
}

/** One drawn gridline: its y, label anchor, and the two pre-measured text layouts
 *  (dark fill + white halo) — measuring is the costly part we cache. */
private class GridLine(
    val gy: Float, val lx: Float, val ly: Float,
    val mDark: TextLayoutResult, val mHalo: TextLayoutResult,
)

/** Gridline values + formatted labels + measured layouts; depends on size, density,
 *  scaleMax and logBase only — recomputed only when one of those changes. */
private fun computeGridLines(
    w: Float, h: Float, d: Float, scaleMax: Double, logBase: Double,
    measurer: TextMeasurer, gridLabel: (Long) -> String,
): List<GridLine> {
    fun fracRaw(v: Double): Float {
        val cl = v.coerceIn(logBase, scaleMax)
        val lg = (ln(cl) - ln(logBase)) / (ln(scaleMax) - ln(logBase))
        val lin = (cl - logBase) / (scaleMax - logBase)
        return (LOG_MIX * lg + (1 - LOG_MIX) * lin).toFloat()
    }
    // 22-iteration binary search to invert fracRaw — was run every frame before.
    fun invFrac(target: Float): Long {
        var lo = logBase; var hi = scaleMax
        repeat(22) { val mid = (lo + hi) / 2; if (fracRaw(mid) < target) lo = mid else hi = mid }
        return ((lo + hi) / 2).roundToLong()
    }
    val out = ArrayList<GridLine>(2)
    val seen = HashSet<Long>()
    for (target in floatArrayOf(0.66f, 0.33f)) {
        val gv = roundNice(invFrac(target).toDouble())
        if (gv < 1 || gv.toDouble() >= scaleMax || !seen.add(gv)) continue
        val gy = h - fracRaw(gv.toDouble()) * h
        if (gy <= 2 * d || gy >= h - 2 * d) continue
        val text = gridLabel(gv)
        val mDark = measurer.measure(text, GRID_STYLE_DARK)
        val mHalo = measurer.measure(text, GRID_STYLE_HALO)
        val lx = w - 3 * d - mDark.size.width
        val ly = gy - 2 * d - mDark.size.height
        out.add(GridLine(gy, lx, ly, mDark, mHalo))
    }
    return out
}

/** Per-graph memo of the two frame-invariant pieces; remembered across frames so the
 *  draw lambda recomputes only when its keys (size/density/scaleMax/logBase) change.
 *  Keyed by direct field compare to avoid any per-frame allocation. */
private class GraphCache {
    private var gw = Float.NaN; private var gh = Float.NaN; private var gd = Float.NaN
    private var geom: BarGeom? = null
    fun geomFor(w: Float, h: Float, d: Float): BarGeom {
        val g = geom
        if (g != null && gw == w && gh == h && gd == d) return g
        val ng = computeBarGeom(w, d); geom = ng; gw = w; gh = h; gd = d; return ng
    }

    private var rw = Float.NaN; private var rh = Float.NaN; private var rd = Float.NaN
    private var rScale = Double.NaN; private var rBase = Double.NaN
    private var grid: List<GridLine>? = null
    fun gridFor(
        w: Float, h: Float, d: Float, scaleMax: Double, logBase: Double,
        measurer: TextMeasurer, gridLabel: (Long) -> String,
    ): List<GridLine> {
        val g = grid
        if (g != null && rw == w && rh == h && rd == d && rScale == scaleMax && rBase == logBase) return g
        val ng = computeGridLines(w, h, d, scaleMax, logBase, measurer, gridLabel)
        grid = ng; rw = w; rh = h; rd = d; rScale = scaleMax; rBase = logBase; return ng
    }
}

/**
 * Live bar graph: newest bar on the LEFT and 5× wide, shrinking logarithmically
 * to normal by the 5th bar; bars fade to 50% toward the right.
 *
 * Animation (one new bucket per push, 0.3 s): every existing bar slides right by
 * exactly one slot — from where it sat last push to its new slot — on an
 * ease-in-out curve, so the whole strip glides right by the width of the leftmost
 * bar. At the same time the brand-new leftmost bar grows from zero to its full
 * height (ease-out). Both finish together; then the strip is drawn at rest. The
 * frame pump only runs while that 0.3 s is in flight and only while the graph is
 * on-screen (it leaves composition otherwise).
 *
 * @param values 60 samples, OLDEST at index 0, NEWEST at the end; 0 = no bar.
 * @param tick   monotonic bucket id of the NEWEST sample (epoch seconds for a
 *   per-second graph, epoch minutes for a per-minute one). The animation fires
 *   when this advances — never on poll cadence — which is what keeps it smooth.
 */
@Composable
fun LiveBarGraph(
    values: LongArray,
    color: Color,
    tick: Long,
    modifier: Modifier = Modifier,
    minScale: Long = 10,
    logBase: Double = 1.0,
    gridLabel: (Long) -> String = { it.toString() },
) {
    val d = LocalDensity.current.density
    val measurer = rememberTextMeasurer()
    // Survives across frames/recompositions; holds the memoized bar geometry and
    // gridline layouts so the per-frame draw only moves bar rectangles.
    val cache = remember { GraphCache() }

    var peak = 0L
    for (v in values) if (v > peak) peak = v
    val peakState = rememberUpdatedState(peak)

    var scaleMax by remember { mutableStateOf(max(minScale, niceCeil(peak)).toDouble()) }
    var animStart by remember { mutableStateOf(0L) }   // frame-nanos of the live slide; 0 = idle
    var frameN by remember { mutableStateOf(0L) }
    var prevTick by remember { mutableStateOf(tick) }
    var shift by remember { mutableStateOf(1) }
    var pending by remember { mutableStateOf(false) }  // tick advanced; arm on next frame
    var lastAnimValues by remember { mutableStateOf(values) }  // data at the previous tick

    // Auto-scale: instant zoom-out when a sample overflows; shrink (zoom-in) only
    // every ~6 s so the bars don't jitter. Never below minScale.
    LaunchedEffect(Unit) {
        var i = 0
        while (true) {
            val p = peakState.value
            if (p.toDouble() > scaleMax) scaleMax = niceCeil(p).toDouble()
            else if (i % 6 == 0) {
                val t = max(minScale, niceCeil(max(minScale, p))).toDouble()
                if (t < scaleMax) scaleMax = t
            }
            i++
            kotlinx.coroutines.delay(1000)
        }
    }
    // Detect a new bucket SYNCHRONOUSLY during composition (not from a lagging
    // effect), so the very first frame after the data rolls is already drawn at
    // the slide's START position (progress 0). Arming from an effect instead drew
    // one frame at the FINAL slot first — that is the "jump to place, snap back
    // left, slide right" glitch. We slide by exactly however many buckets rolled
    // (1 normally; 2 if a poll was skipped). [tick] is a clock/bucket id, so this
    // never fires on poll cadence; per-minute graphs pass a minute tick.
    if (tick != prevTick) {
        val delta = (tick - prevTick).toInt()
        prevTick = tick
        // Only animate when the data ACTUALLY changed. When the app is idle
        // (scan off, Telegram off) the buckets are constant tick-to-tick, so we
        // skip the ~300 ms 60 fps frame-pump below entirely — that pump, under
        // software rendering, was burning 10-20% CPU at idle. A static graph
        // looks identical whether it "slides" constant bars or not.
        val changed = !values.contentEquals(lastAnimValues)
        lastAnimValues = values
        if (delta in 1..4 && changed) { shift = delta; pending = true } else pending = false
    }

    LaunchedEffect(tick) {
        if (pending) {
            val start = withFrameNanos { it }
            animStart = start; frameN = start; pending = false
            while ((withFrameNanos { frameN = it; it } - start) < ANIM_MS) { /* pump */ }
            animStart = 0L
        }
    }

    Box(modifier.clip(RoundedCornerShape(8.dp(d)))) {
        Canvas(Modifier.fillMaxSize()) {
            val w = size.width; val h = size.height
            val r = 8 * d
            drawRoundRect(PanelColor, Offset(0f, 0f), Size(w, h), CornerRadius(r, r))

            // bar slot geometry (first bar 5× wide → normal by the 5th): size+density
            // only, so it's memoized and reused frame-to-frame.
            val geom = cache.geomFor(w, h, d)
            val n = geom.n; val pos = geom.pos; val wid = geom.wid

            val minH = max(7 * d, 0.16f * h)
            val zeroH = 4 * d   // a zero sample still shows a 4 px stub and animates
            fun fracRaw(v: Double): Float {
                val cl = v.coerceIn(logBase, scaleMax)
                val lg = (ln(cl) - ln(logBase)) / (ln(scaleMax) - ln(logBase))
                val lin = (cl - logBase) / (scaleMax - logBase)
                return (LOG_MIX * lg + (1 - LOG_MIX) * lin).toFloat()
            }
            // Zero → a 2 px stub (never hidden), so it slides and grows in just
            // like a real bar; positive values clamp up to minH.
            fun barH(v: Long): Float = if (v <= 0L) zeroH else max(minH, fracRaw(v.toDouble()) * h)
            // newest at series[0]
            // Draw only COMPLETED buckets: the very newest element is the still-
            // filling current bucket whose height keeps changing, which made the
            // leftmost bar wobble and "correct" when it shifted. series(0) = the
            // last COMPLETE bucket (one before the current), so every drawn bar
            // already has its final height.
            fun series(i: Int): Long { val idx = values.size - 2 - i; return if (idx >= 0) values[idx] else 0L }

            fun drawBar(x: Float, bw: Float, v: Long, hpx: Float) {
                if (hpx < 0f) return
                val posFrac = ((x) / w).coerceIn(0f, 1f)
                val alpha = 1f - 0.5f * posFrac
                val top = h - min(h, hpx)
                val br = min(bw / 2.4f, 3.5f * d)
                drawRoundRect(
                    color = color.copy(alpha = alpha),
                    topLeft = Offset(x + 0.5f, top),
                    size = Size((bw - 1f).coerceAtLeast(1f), min(h, hpx)),
                    cornerRadius = CornerRadius(br, br),
                )
            }

            val s = shift.coerceIn(1, n)
            val animating = pending || (animStart != 0L && frameN - animStart < ANIM_MS)
            if (!animating) {
                // at rest: every bar on its own slot.
                for (i in 0 until n) drawBar(pos[i], wid[i], series(i), barH(series(i)))
            } else {
                // progress 0 on the data-change frame (and until the pump arms
                // animStart next frame) — the strip starts the slide from where it
                // actually sat, never from the final slot.
                val elapsed = if (pending || animStart == 0L) 0L else frameN - animStart
                val t = (elapsed / ANIM_MS.toFloat()).coerceIn(0f, 1f)
                // ONE eased progress for BOTH the slide and the grow, so the new
                // bar rises in perfect lockstep with the strip sliding right.
                val slideP = easeInOut(t)
                val growP = slideP
                // Old bars: slot i (s..n-1) holds the bar that s buckets ago sat
                // at slot i-s; interpolate its position AND width across.
                for (slot in s until n) {
                    val hpx = barH(series(slot)); if (hpx < 0f) continue
                    val src = slot - s
                    val bx = pos[src] + (pos[slot] - pos[src]) * slideP
                    val bw = wid[src] + (wid[slot] - wid[src]) * slideP
                    drawBar(bx, bw, series(slot), hpx)
                }
                // The s freshly-arrived leftmost bars grow in place from zero.
                for (slot in 0 until min(s, n)) {
                    val hpx = barH(series(slot)); if (hpx >= 0f) drawBar(pos[slot], wid[slot], series(slot), hpx * growP)
                }
            }

            // gridlines + haloed bold labels with units, at round values. Values,
            // labels and the two measured text layouts depend only on scaleMax/size/
            // density, so they're memoized; a slide frame just re-draws them in place.
            for (g in cache.gridFor(w, h, d, scaleMax, logBase, measurer, gridLabel)) {
                drawLine(GridColor, Offset(2 * d, g.gy), Offset(w - 2 * d, g.gy), strokeWidth = max(1f, 1.1f * d))
                for (off in HALO_OFFSETS) drawText(g.mHalo, topLeft = Offset(g.lx + off.x, g.ly + off.y))
                drawText(g.mDark, topLeft = Offset(g.lx, g.ly))
            }

            // strong rounded frame on top.
            drawRoundRect(FrameColor, Offset(0f, 0f), Size(w, h), CornerRadius(r, r),
                style = Stroke(width = max(1.2f, 1.4f * d)))
        }
    }
}

// ── compact unit formatters for gridline labels ───────────────────────────────

/** bytes-rate → "200 KB/s" / "1 MB/s". */
fun fmtSpeed(b: Long): String = when {
    b >= 1_000_000_000 -> "${b / 1_000_000_000} GB/s"
    b >= 1_000_000 -> "${b / 1_000_000} MB/s"
    b >= 1_000 -> "${b / 1_000} KB/s"
    else -> "$b B/s"
}

/** latency ms → roll over to seconds once ≥ 1000 ms ("1.5 s"), else "450 ms". */
fun fmtLatency(ms: Long): String = when {
    ms >= 1_000 && ms % 1_000 == 0L -> "${ms / 1_000} s"
    ms >= 1_000 -> "${ms / 1_000}.${(ms % 1_000) / 100} s"
    else -> "$ms ms"
}

// ── "A · B unit" pair formatters for the per-second · per-minute left readings ──
// Both values share ONE unit, picked from the larger of the two.

private fun fmtNum(v: Double): String =
    if (v >= 10.0 || v == v.toLong().toDouble()) v.roundToLong().toString()
    else ((v * 10).roundToLong() / 10.0).toString()

private fun bytesPair(a: Long, b: Long, suffix: String): String {
    val m = max(a, b)
    val div: Double; val u: String
    when {
        m >= 1_000_000_000 -> { div = 1e9; u = "GB" }
        m >= 1_000_000 -> { div = 1e6; u = "MB" }
        m >= 1_000 -> { div = 1e3; u = "KB" }
        else -> { div = 1.0; u = "B" }
    }
    return "${fmtNum(a / div)} · ${fmtNum(b / div)} $u$suffix"
}

/** "3 · 43 KB/s" — per-second · per-minute speed, shared unit. */
fun fmtSpeedPair(a: Long, b: Long): String = bytesPair(a, b, "/s")

/** "200 · 210 ms" or "1.2 · 1.5 s" — per-second · per-minute latency. */
fun fmtLatencyPair(a: Long, b: Long): String {
    val m = max(a, b)
    return if (m >= 1000) "${fmtNum(a / 1000.0)} · ${fmtNum(b / 1000.0)} s" else "$a · $b ms"
}

// local dp helper (Dp value; density only taken to keep call sites uniform)
private fun Int.dp(@Suppress("UNUSED_PARAMETER") d: Float) = androidx.compose.ui.unit.Dp(this.toFloat())
