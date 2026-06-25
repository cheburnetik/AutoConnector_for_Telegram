package io.autoconnector.engine.relay;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Tiny pub/sub channel the relay's connections write progress lines into,
 * and that the UI (MainActivity log, foreground notification) subscribes to.
 *
 * <p>Listeners get every line synchronously on the emitter's thread; UI
 * subscribers should marshal back to the main thread themselves.
 */
public final class RelayLog {

    public interface Listener {
        /** @param session "<port>#<id>" for a specific Telegram connection,
         *                 or null for a general (non-session) relay line. */
        void onLine(String session, String line);
    }

    private static final List<Listener> listeners = new CopyOnWriteArrayList<>();

    /** Per-thread session tag. A RelayConnection sets it once for its whole
     *  lifetime (all its log lines run on that thread), so plain emit() calls
     *  are auto-tagged without threading a session arg through every call. */
    private static final ThreadLocal<String> SESSION = new ThreadLocal<>();

    public static void setSession(String session) { SESSION.set(session); }
    public static void clearSession() { SESSION.remove(); }

    public static void register(Listener l) {
        listeners.add(l);
    }

    public static void unregister(Listener l) {
        listeners.remove(l);
    }

    /** Auto-tags with the calling thread's session (set via {@link #setSession}). */
    public static void emit(String line) {
        emit(SESSION.get(), line);
    }

    /** Line tied to a specific Telegram connection ({@code session}). */
    public static void emit(String session, String line) {
        // Skip immediately when no UI is bound — fast path while the activity
        // is backgrounded, so background workers don't pay any cost.
        if (listeners.isEmpty()) return;
        for (Listener l : listeners) {
            try {
                l.onLine(session, line);
            } catch (Exception ignored) {
            }
        }
    }

    private RelayLog() {}
}
