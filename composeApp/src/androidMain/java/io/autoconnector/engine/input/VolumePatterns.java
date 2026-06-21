package io.autoconnector.engine.input;

/**
 * The fast volume-button click patterns that trigger a Telegram proxy hand-off.
 * Pure logic (no Android) so it's testable and also compiles for desktop. Each
 * pattern is a sequence of presses: {@code true} = Volume UP, {@code false} =
 * Volume DOWN. All have at least 4 presses.
 */
public final class VolumePatterns {

    private VolumePatterns() {}

    private static final boolean U = true, D = false;

    /** 10 distinct patterns (≥4 presses). */
    public static final boolean[][] PATTERNS = {
        {U, U, D, D},          // up up · down down
        {D, D, U, U},          // down down · up up
        {U, D, U, D},          // up down up down
        {D, U, D, U},          // down up down up
        {U, U, U, U},          // four up
        {D, D, D, D},          // four down
        {U, D, D, U},          // up · down down · up
        {D, U, U, D},          // down · up up · down
        {U, U, U, D, D, D},    // three up · three down
        {D, D, D, U, U, U},    // three down · three up
    };

    /** Longest pattern length — callers keep at least this many recent presses. */
    public static final int MAX_LEN = 6;

    /** True if the TAIL of {@code buf[0..len)} exactly equals pattern {@code idx}. */
    public static boolean tailMatches(boolean[] buf, int len, int idx) {
        if (idx < 0 || idx >= PATTERNS.length) return false;
        boolean[] p = PATTERNS[idx];
        if (len < p.length) return false;
        for (int k = 0; k < p.length; k++) {
            if (buf[len - p.length + k] != p[k]) return false;
        }
        return true;
    }

    /** Index of the pattern that exactly equals the TAIL of {@code buf[0..len)}
     *  (most-recent press at {@code buf[len-1]}), or -1 if none matches. */
    public static int matchTail(boolean[] buf, int len) {
        for (int pi = 0; pi < PATTERNS.length; pi++) {
            boolean[] p = PATTERNS[pi];
            if (len < p.length) continue;
            boolean ok = true;
            for (int k = 0; k < p.length; k++) {
                if (buf[len - p.length + k] != p[k]) { ok = false; break; }
            }
            if (ok) return pi;
        }
        return -1;
    }
}
