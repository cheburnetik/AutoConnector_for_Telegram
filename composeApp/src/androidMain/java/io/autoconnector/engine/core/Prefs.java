package io.autoconnector.engine.core;

import android.content.Context;
import android.content.SharedPreferences;

/** Thin typed wrapper over {@link SharedPreferences} for app settings. */
public class Prefs {

    private static final int DEFAULT_PORT_A = 55001;
    private static final int DEFAULT_PORT_B = 55002;

    private final SharedPreferences sp;

    public Prefs(Context ctx) {
        sp = ctx.getApplicationContext()
                .getSharedPreferences("autoconnector", Context.MODE_PRIVATE);
    }

    // --- page scanning -----------------------------------------------------

    /** How often, in minutes, to re-scan the pages. */
    public int scanIntervalMin() {
        return sp.getInt("scan_interval_min", 30);
    }

    public void setScanIntervalMin(int minutes) {
        sp.edit().putInt("scan_interval_min", minutes).apply();
    }

    // --- relay -------------------------------------------------------------

    /** Primary loopback SOCKS5 port. */
    public int relayPortA() {
        return sp.getInt("relay_port_a", DEFAULT_PORT_A);
    }

    public void setRelayPortA(int port) {
        sp.edit().putInt("relay_port_a", port).apply();
    }

    /** Secondary loopback SOCKS5 port — the failover signal lives here. */
    public int relayPortB() {
        return sp.getInt("relay_port_b", DEFAULT_PORT_B);
    }

    public void setRelayPortB(int port) {
        sp.edit().putInt("relay_port_b", port).apply();
    }

    /** Telegram SOCKS5 proxy link for a port (no secret — SOCKS5). */
    public String relayLink(int port) {
        return "tg://socks?server=127.0.0.1&port=" + port;
    }

    // --- checking schedule -------------------------------------------------

    /**
     * Platform-injected shipped default for the proxying engine
     * ({@code exp_engine_mode}). Android sets this to 0 (off — the native
     * socket path works there); desktop leaves it at 4 (coalescing/batching).
     * Set before {@link #applyShippedDefaultsOnce()} runs.
     */
    public static int SHIPPED_EXP_ENGINE = 4;

    /** How often, in minutes, the background checker re-probes proxies. */
    public int checkIntervalMin() {
        return sp.getInt("check_interval_min", 5);
    }

    /** How many parallel threads the proxy checker uses. */
    public int checkConcurrency() {
        return sp.getInt("check_concurrency", 10);
    }

    public void setCheckConcurrency(int n) {
        // Cap at 32 — past that even modern phones OOM or hit fd limits.
        sp.edit().putInt("check_concurrency", Math.max(1, Math.min(32, n))).apply();
    }

    public void setCheckIntervalMin(int minutes) {
        sp.edit().putInt("check_interval_min", minutes).apply();
    }

    /** How many proxies one background check pass probes. */
    public int checkBatch() {
        return sp.getInt("check_batch", 50);
    }

    public void setCheckBatch(int n) {
        sp.edit().putInt("check_batch", n).apply();
    }

    // --- per-network speed multipliers -------------------------------------
    // 1.0 = use base interval/batch as-is.  0.5 = twice as fast (half interval,
    // double batch).  2.0 = twice as slow.  Lets the user crank LTE down to
    // save battery while leaving Wi-Fi aggressive.

    public float speedMultiplier(NetworkMode mode) {
        switch (mode) {
            case VPN:  return sp.getFloat("speed_x_vpn", 1.0f);
            case WIFI: return sp.getFloat("speed_x_wifi", 1.0f);
            case LTE:  return sp.getFloat("speed_x_lte", 2.0f);
            default:   return 1.0f;
        }
    }

    public void setSpeedMultiplier(NetworkMode mode, float x) {
        // Full slider range: ×100 faster (0.01) .. ×100 slower (100). At the
        // fast end the scheduler switches to continuous scanning.
        x = Math.max(0.01f, Math.min(100f, x));
        String key;
        switch (mode) {
            case VPN: key = "speed_x_vpn"; break;
            case WIFI: key = "speed_x_wifi"; break;
            case LTE: key = "speed_x_lte"; break;
            default: return;
        }
        sp.edit().putFloat(key, x).apply();
    }

    /** If alive-count for current mode drops below this, the scheduler
     *  speeds up by {@link #fastSpeedMultiplier()} to refill the pool. */
    public int adaptiveAliveThreshold() {
        return sp.getInt("adaptive_alive_threshold", 30);
    }

    public void setAdaptiveAliveThreshold(int n) {
        sp.edit().putInt("adaptive_alive_threshold", Math.max(0, n)).apply();
    }

    /** Multiplier applied to interval when adaptive-fast kicks in (alive count
     *  is below {@link #adaptiveAliveThreshold()}). 0.5 = twice as fast. */
    public float fastSpeedMultiplier() {
        return sp.getFloat("adaptive_speed_x", 0.1f);
    }

    public void setFastSpeedMultiplier(float x) {
        sp.edit().putFloat("adaptive_speed_x", Math.max(0.01f, Math.min(100f, x))).apply();
    }

    /** «Хороших хостов уже достаточно» — выше этого порога сканируем редко
     *  ({@link #lazySpeedMultiplier()} ×). */
    public int lazyAliveThreshold() {
        return sp.getInt("lazy_alive_threshold", 60);
    }

    public void setLazyAliveThreshold(int n) {
        sp.edit().putInt("lazy_alive_threshold", Math.max(1, n)).apply();
    }

    /** Multiplier for the "we already have enough" mode. >1 slows down. */
    public float lazySpeedMultiplier() {
        return sp.getFloat("lazy_speed_x", 5.0f);
    }

    public void setLazySpeedMultiplier(float x) {
        sp.edit().putFloat("lazy_speed_x", Math.max(0.01f, Math.min(100f, x))).apply();
    }

    // --- intensity → effective scan parameters -----------------------------
    // Pure helpers shared by the Android relay loop, the desktop engine and the
    // settings preview, so all three derive identical numbers from one place.
    // A smaller multiplier means "more intense": shorter interval, bigger
    // batch, more parallelism — each clamped so nothing silly happens.

    /** fd/OOM ceiling for concurrent probes. */
    public static final int CONCURRENCY_CAP = 32;
    /** Effective intervals shorter than this switch the scan to continuous. */
    public static final int CONTINUOUS_BELOW_SEC = 8;

    private static float clampIntensity(float m) {
        return Math.max(0.005f, Math.min(100f, m));
    }

    /** Effective check interval in seconds = base (minutes) × intensity.
     *  Returns 0 when so small the scan should run continuously (no sleep). */
    public static int effectiveCheckSec(int baseMin, float mult) {
        float m = clampIntensity(mult);
        long sec = Math.round(Math.max(1, baseMin) * 60.0 * m);
        if (sec < CONTINUOUS_BELOW_SEC) return 0;       // super-intense → непрерывно
        return (int) Math.min(sec, 6L * 3600L);         // never longer than 6 h
    }

    /** Effective batch: more intense (smaller mult) probes more hosts per pass. */
    public static int effectiveBatch(int baseBatch, float mult) {
        float m = clampIntensity(mult);
        long b = Math.round(Math.max(1, baseBatch) / m);
        return (int) Math.max(10, Math.min(1000, b));
    }

    /** Effective parallelism: grows ~1/√intensity so it stays sane, capped. */
    public static int effectiveConcurrency(int baseConc, float mult) {
        float m = clampIntensity(mult);
        long c = Math.round(Math.max(1, baseConc) / Math.sqrt(m));
        return (int) Math.max(1, Math.min(CONCURRENCY_CAP, c));
    }

    /** Combined intensity for the current connection + adaptive alive-state —
     *  the same three-tier logic the schedulers use, centralised so interval,
     *  batch and concurrency all read one multiplier. */
    public float currentScanMult(NetworkMode net, int alive) {
        float mult = speedMultiplier(net);
        if (BurstMode.isActive()) return Math.min(mult, 0.25f);
        if (alive < adaptiveAliveThreshold()) mult *= fastSpeedMultiplier();
        else if (alive > lazyAliveThreshold()) mult *= lazySpeedMultiplier();
        return mult;
    }

    // --- master switches ---------------------------------------------------

    /** Top-level on/off — when false, no relay, no scan, no probes. */
    public boolean appEnabled() { return sp.getBoolean("app_enabled", true); }
    public void setAppEnabled(boolean v) { sp.edit().putBoolean("app_enabled", v).apply(); }

    /** Background MTProto probes (mains-check, foreground bursts, workers). */
    public boolean scanEnabled() { return sp.getBoolean("scan_enabled", true); }
    public void setScanEnabled(boolean v) { sp.edit().putBoolean("scan_enabled", v).apply(); }

    /** When false the foreground service falls back to the IMPORTANCE_MIN
     *  channel — Android still shows SOMETHING in the notification drawer
     *  (it's mandatory for foreground services), but it's collapsed, silent,
     *  no lockscreen entry, no app badge. */
    public boolean notificationsEnabled() {
        return sp.getBoolean("notifications_enabled", true);
    }
    public void setNotificationsEnabled(boolean v) {
        sp.edit().putBoolean("notifications_enabled", v).apply();
    }

    // --- proxy bypass mode -------------------------------------------------

    public enum ProxyMode {
        /** Always go through MTProto upstream. Default. */
        USE_PROXIES("use", "Использовать прокси"),
        /** Never use proxies — relay acts as a thin SOCKS5→Telegram-DC tunnel. */
        DISABLED("disabled", "Отключить (прямой выход)"),
        /** Use proxies normally, but skip them while VPN is active. */
        DISABLED_ON_VPN("vpn_only", "Отключать при VPN");

        public final String code;
        public final String label;
        ProxyMode(String code, String label) { this.code = code; this.label = label; }

        public static ProxyMode fromCode(String c) {
            for (ProxyMode m : values()) if (m.code.equals(c)) return m;
            return USE_PROXIES;
        }
    }

    public ProxyMode proxyMode() {
        return ProxyMode.fromCode(sp.getString("proxy_mode", ProxyMode.USE_PROXIES.code));
    }

    public void setProxyMode(ProxyMode m) {
        sp.edit().putString("proxy_mode", m.code).apply();
    }

    /** True when the relay should bypass all upstreams given current network. */
    public boolean shouldBypassProxies() {
        ProxyMode m = proxyMode();
        if (m == ProxyMode.DISABLED) return true;
        if (m == ProxyMode.DISABLED_ON_VPN
                && NetworkMonitor.currentMode() == NetworkMode.VPN) return true;
        return false;
    }

    // --- battery saving ----------------------------------------------------

    /** Run background scan/check only on an unmetered (Wi-Fi) network. */
    public boolean wifiOnly() {
        return sp.getBoolean("wifi_only", false);
    }

    public void setWifiOnly(boolean v) {
        sp.edit().putBoolean("wifi_only", v).apply();
    }

    /** Run background scan/check only while charging. */
    public boolean chargingOnly() {
        return sp.getBoolean("charging_only", false);
    }

    public void setChargingOnly(boolean v) {
        sp.edit().putBoolean("charging_only", v).apply();
    }

    /** Skip background scan/check when the battery is low. */
    public boolean skipLowBattery() {
        return sp.getBoolean("skip_low_battery", false);
    }

    public void setSkipLowBattery(boolean v) {
        sp.edit().putBoolean("skip_low_battery", v).apply();
    }

    // --- automatic-schedule tracking --------------------------------------

    public long lastScanRunMs() {
        return sp.getLong("last_scan_run", 0);
    }

    public void setLastScanRun(long ms) {
        sp.edit().putLong("last_scan_run", ms).apply();
    }

    public long lastCheckRunMs() {
        return sp.getLong("last_check_run", 0);
    }

    public void setLastCheckRun(long ms) {
        sp.edit().putLong("last_check_run", ms).apply();
    }

    public long lastRescheduleMs() {
        return sp.getLong("last_reschedule", 0);
    }

    public void setLastReschedule(long ms) {
        sp.edit().putLong("last_reschedule", ms).apply();
    }

    /** Process-wide "Telegram has ever connected through the relay" timestamp. */
    public long lastTelegramConnectMs() {
        return sp.getLong("last_tg_connect", 0);
    }

    public void setLastTelegramConnect(long ms) {
        sp.edit().putLong("last_tg_connect", ms).apply();
    }

    /** "Telegram has connected via the relay's port A" timestamp. */
    public long lastTelegramConnectPortAMs() {
        return sp.getLong("last_tg_connect_a", 0);
    }

    public void setLastTelegramConnectPortA(long ms) {
        sp.edit().putLong("last_tg_connect_a", ms).apply();
    }

    /** "Telegram has connected via the relay's port B" timestamp. */
    public long lastTelegramConnectPortBMs() {
        return sp.getLong("last_tg_connect_b", 0);
    }

    public void setLastTelegramConnectPortB(long ms) {
        sp.edit().putLong("last_tg_connect_b", ms).apply();
    }

    // --- anti-DPI / handshake mode ----------------------------------------

    /** Index into {@link io.autoconnector.engine.net.HandshakeMode#values()}. */
    public int handshakeMode() {
        return sp.getInt("handshake_mode", 0);
    }

    public void setHandshakeMode(int ordinal) {
        sp.edit().putInt("handshake_mode", Math.max(0, ordinal)).apply();
    }

    /** Restrict upstream selection to {@code ee}-FakeTLS proxies only. */
    public boolean onlyFakeTls() {
        return sp.getBoolean("only_fake_tls", false);
    }

    public void setOnlyFakeTls(boolean v) {
        sp.edit().putBoolean("only_fake_tls", v).apply();
    }

    /** Apply the anti-DPI handshake trick to the live Telegram relay. */
    public boolean dpiApplyRelay() { return sp.getBoolean("dpi_relay", true); }
    public void setDpiApplyRelay(boolean v) { sp.edit().putBoolean("dpi_relay", v).apply(); }

    /** Apply the anti-DPI handshake trick to background proxy probes too. */
    public boolean dpiApplyProbes() { return sp.getBoolean("dpi_probes", true); }
    public void setDpiApplyProbes(boolean v) { sp.edit().putBoolean("dpi_probes", v).apply(); }

    /**
     * Apply a TCP-level anti-DPI trick to the DIRECT connection used in bypass
     * mode (proxies disabled, or skipped while VPN is on). There is no FakeTLS
     * upstream to mimic here, so the trick degrades to splitting the very first
     * outbound segment (Telegram's obfuscated2 handshake) across several small
     * TCP packets — enough to defeat single-segment signature matching. Off by
     * default: a direct connection usually doesn't need it. */
    public boolean dpiApplyDirect() { return sp.getBoolean("dpi_direct", false); }
    public void setDpiApplyDirect(boolean v) { sp.edit().putBoolean("dpi_direct", v).apply(); }

    /** UI language code: "auto" (follow system) / "ru" / "en". */
    public String lang() { return sp.getString("ui_lang", "auto"); }
    public void setLang(String code) { sp.edit().putString("ui_lang", code).apply(); }

    // --- experimental upstream engine -------------------------------------

    /**
     * Experimental upstream proxying engine code (see
     * {@link io.autoconnector.engine.relay.WireShaper.Mode}). 0 = OFF =
     * reference path (default). Non-zero modes reshape how the obfuscated2
     * stream is written to the upstream TCP socket (segment sizes, flush
     * cadence, TLS-record boundaries) without touching a single stream byte.
     */
    // Default = 4 (WireShaper.Mode.COALESCE_DELAY): coalescing/batching is the
    // shipped default proxying engine.
    public int expEngineMode() { return sp.getInt("exp_engine_mode", SHIPPED_EXP_ENGINE); }
    public void setExpEngineMode(int code) {
        sp.edit().putInt("exp_engine_mode", Math.max(0, code)).apply();
    }

    /** Diagnostic network-exchange log (metadata only — no payload bytes). */
    public boolean netLogEnabled() { return sp.getBoolean("net_log_enabled", false); }
    public void setNetLogEnabled(boolean v) {
        sp.edit().putBoolean("net_log_enabled", v).apply();
    }

    /**
     * Experimental upstream-acquisition strategy (see
     * {@link io.autoconnector.engine.relay.RelayConnectMode}). 0 = OFF =
     * reference serial trial. Non-zero modes change how fast the relay finds a
     * working upstream proxy for a fresh Telegram connection.
     */
    public int relayConnectMode() { return sp.getInt("relay_connect_mode", 0); }
    public void setRelayConnectMode(int code) {
        sp.edit().putInt("relay_connect_mode", Math.max(0, code)).apply();
    }

    /**
     * One-time migration of shipped defaults. A plain {@code getInt(key, 4)}
     * default only helps brand-new installs — existing users already have
     * {@code exp_engine_mode} written (the settings screen auto-saves), so they
     * would never pick up a changed default. This bumps a {@code defaults_v}
     * marker and, on first run of a build that raised it, forces the new
     * default once; afterwards the user's own choice is respected.
     */
    public void applyShippedDefaultsOnce() {
        int v = sp.getInt("defaults_v", 0);
        if (v < 1) {
            // v1: coalescing/batching becomes the default proxying engine.
            sp.edit().putInt("exp_engine_mode", 4).putInt("defaults_v", 1).apply();
            v = 1;
        }
        if (v < 2) {
            // v2: the shipped proxying-engine default is now platform-specific —
            // OFF on Android (native path works), coalescing on desktop. Force
            // the platform default once; afterwards the user's choice is kept.
            sp.edit().putInt("exp_engine_mode", SHIPPED_EXP_ENGINE).putInt("defaults_v", 2).apply();
            v = 2;
        }
        if (v < 3) {
            // v3: desktop default moved from coalescing to «Сплит первого пакета»
            // (code 12); Android stays OFF. Re-apply the platform default once.
            sp.edit().putInt("exp_engine_mode", SHIPPED_EXP_ENGINE).putInt("defaults_v", 3).apply();
            v = 3;
        }
        if (v < 4) {
            // v4: refreshed scan-tuning baseline requested by the user. Applied
            // once so existing installs pick it up; afterwards the user's own
            // edits in Settings are respected.
            sp.edit()
              .putInt("scan_interval_min", 30)
              .putInt("check_interval_min", 5)
              .putInt("check_batch", 50)
              .putInt("check_concurrency", 10)
              .putInt("adaptive_alive_threshold", 30)
              .putFloat("adaptive_speed_x", 0.1f)   // «мало» → ×10 быстрее
              .putInt("lazy_alive_threshold", 60)
              .putFloat("lazy_speed_x", 5.0f)        // «много» → ×5 медленнее
              .putInt("defaults_v", 4).apply();
            v = 4;
        }
        if (v < 5) {
            // v5: desktop/non-Android default proxying engine → «Сплит первого
            // пакета ×3» (code 14). Android stays OFF (SHIPPED_EXP_ENGINE=0).
            sp.edit().putInt("exp_engine_mode", SHIPPED_EXP_ENGINE).putInt("defaults_v", 5).apply();
        }
    }
}
