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
        void onLine(String line);
    }

    private static final List<Listener> listeners = new CopyOnWriteArrayList<>();

    public static void register(Listener l) {
        listeners.add(l);
    }

    public static void unregister(Listener l) {
        listeners.remove(l);
    }

    public static void emit(String line) {
        // Skip immediately when no UI is bound — fast path while the activity
        // is backgrounded, so background workers don't pay any cost.
        if (listeners.isEmpty()) return;
        for (Listener l : listeners) {
            try {
                l.onLine(line);
            } catch (Exception ignored) {
            }
        }
    }

    public static boolean hasListeners() {
        return !listeners.isEmpty();
    }

    private RelayLog() {}
}
