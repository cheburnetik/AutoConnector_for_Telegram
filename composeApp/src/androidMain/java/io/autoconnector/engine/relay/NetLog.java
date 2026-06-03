package io.autoconnector.engine.relay;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

/**
 * Opt-in diagnostic logger of the relay's network exchange — <b>metadata only,
 * never any payload bytes</b>. When enabled (Settings → «Включить лог сетевого
 * обмена») every Telegram session writes a compact, append-only text log of
 * <em>who talks to whom, when, and how much</em>:
 *
 * <pre>
 *   &lt;epochMs&gt; &lt;session&gt; OPEN  net=WIFI eng=frag_all dpi=… up=1.2.3.4:443 type=MT sni=… dc=2 dst=149.154.167.51:443
 *   &lt;epochMs&gt; &lt;session&gt; UP    n=64
 *   &lt;epochMs&gt; &lt;session&gt; DOWN  n=1380
 *   &lt;epochMs&gt; &lt;session&gt; CLOSE durMs=4850 up=512 down=20480 why=eof
 * </pre>
 *
 * The goal is to compare the <em>character</em> of the exchange with a VPN
 * active vs. without it (timing, burst sizes, who closes first) to understand
 * why the desktop build fails outside a VPN while Android on Wi-Fi works.
 *
 * <p>Design notes:
 * <ul>
 *   <li>{@link #enabled} is a {@code volatile} fast-path gate — when off, every
 *       logging call returns immediately, so the relay pays nothing.</li>
 *   <li>All writes serialise on {@link #LOCK}; the file is flushed per event so
 *       a crash/kill still leaves a usable trace.</li>
 *   <li>The file rotates once it passes {@link #ROTATE_BYTES} (current → .1).</li>
 *   <li>Absolutely no proxy secrets or stream bytes are written — only sizes,
 *       endpoints and timestamps.</li>
 * </ul>
 */
public final class NetLog {

    private static final long ROTATE_BYTES = 16L * 1024 * 1024;

    private static volatile boolean enabled = false;
    private static volatile File dir;       // <dataDir>/netlog

    private static final Object LOCK = new Object();
    private static Writer writer;           // guarded by LOCK
    private static long written;            // guarded by LOCK

    private NetLog() {}

    /** Bind the directory where the log lives. Call once at engine start. */
    public static void init(File dataDir) {
        dir = new File(dataDir, "netlog");
    }

    public static boolean isEnabled() {
        return enabled;
    }

    /** Absolute path of the active log file (may not exist until enabled). */
    public static File file() {
        File d = dir;
        if (d == null) return null;
        return new File(d, "netlog-current.log");
    }

    /**
     * Turn logging on/off. Turning on opens (appends to) the file and writes a
     * session-start marker; turning off flushes and closes it.
     */
    public static void setEnabled(boolean on) {
        synchronized (LOCK) {
            if (on == enabled && (!on || writer != null)) return;
            if (on) {
                if (open()) {
                    enabled = true;
                    line(null, "LOGSTART", "v=1");
                }
            } else {
                line(null, "LOGSTOP", "");
                enabled = false;
                close();
            }
        }
    }

    // === event helpers (no-ops while disabled) ===========================

    /** Session opened: endpoints + mode context. */
    public static void open(String session, String fields) {
        event(session, "OPEN", fields);
    }

    /** Telegram → upstream/DC application chunk of {@code n} bytes. */
    public static void up(String session, int n) {
        if (!enabled) return;
        event(session, "UP", "n=" + n);
    }

    /** Upstream/DC → Telegram application chunk of {@code n} bytes. */
    public static void down(String session, int n) {
        if (!enabled) return;
        event(session, "DOWN", "n=" + n);
    }

    /** Session closed: duration + byte totals + reason. */
    public static void close(String session, String fields) {
        event(session, "CLOSE", fields);
    }

    /** Free-form note tied to a session (e.g. handshake step, error reason). */
    public static void note(String session, String msg) {
        event(session, "NOTE", msg);
    }

    private static void event(String session, String kind, String fields) {
        if (!enabled) return;
        synchronized (LOCK) {
            if (!enabled || writer == null) return;
            line(session, kind, fields);
        }
    }

    // === file plumbing (all callers hold LOCK) ============================

    private static boolean open() {
        try {
            File d = dir;
            if (d == null) return false;
            d.mkdirs();
            File f = new File(d, "netlog-current.log");
            written = f.length();
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(f, true), StandardCharsets.UTF_8));
            return true;
        } catch (Exception e) {
            writer = null;
            return false;
        }
    }

    private static void close() {
        try {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        } catch (Exception ignored) {
        } finally {
            writer = null;
        }
    }

    private static void line(String session, String kind, String fields) {
        if (writer == null) return;
        StringBuilder sb = new StringBuilder(64);
        sb.append(System.currentTimeMillis()).append(' ')
          .append(session == null ? "-" : session).append(' ')
          .append(kind);
        if (fields != null && !fields.isEmpty()) sb.append(' ').append(fields);
        sb.append('\n');
        String s = sb.toString();
        try {
            writer.write(s);
            writer.flush();
            written += s.length();
            if (written >= ROTATE_BYTES) rotate();
        } catch (Exception ignored) {
        }
    }

    private static void rotate() {
        try {
            close();
            File d = dir;
            if (d == null) return;
            File cur = new File(d, "netlog-current.log");
            File prev = new File(d, "netlog.1.log");
            if (prev.exists()) prev.delete();
            cur.renameTo(prev);
            open();
        } catch (Exception ignored) {
        }
    }
}
