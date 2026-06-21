package io.autoconnector.engine.check;

import io.autoconnector.engine.db.ProxyStore;
import io.autoconnector.engine.model.ProxyEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * On-demand "test this host now" for the catalog detail page: runs a few REAL
 * probes against one host, logs each outcome into the host's attempt history
 * (so the table shows fresh rows), and exposes live progress + a compact summary
 * for the UI. Shared by both platforms — {@link HealthChecker} is platform-neutral.
 * Single-flight: starting a new test stops any running one.
 */
public final class HostTester {

    private static final int ATTEMPTS = 3;

    private static volatile Thread worker;
    private static volatile long testingId = 0;
    private static volatile boolean running = false;
    private static volatile String summary = "";

    private HostTester() {}

    public static long testingId() { return testingId; }
    public static boolean running() { return running; }
    public static String summary() { return summary; }

    public static synchronized void start(ProxyStore store, ProxyEntry p, int timeoutMs) {
        if (store == null || p == null) return;
        stop();
        final long id = p.id;
        testingId = id;
        running = true;
        summary = "testing " + p.host + ":" + p.port + " …";
        final int to = Math.max(2000, Math.min(15000, timeoutMs));
        worker = new Thread(() -> {
            HealthChecker hc = new HealthChecker(to);
            int ok = 0, total = 0;
            List<String> conn = new ArrayList<>(), hs = new ArrayList<>();
            for (int i = 0; i < ATTEMPTS && running; i++) {
                total++;
                HealthChecker.Result r;
                try { r = hc.check(p); } catch (Throwable t) { r = null; }
                boolean good = r != null && r.ok();
                if (good) ok++;
                int cms = (r != null) ? r.connectMs : -1;
                int tms = (r != null) ? r.rttMs : -1;
                conn.add(cms >= 0 ? String.valueOf(cms) : "—");
                hs.add(good && tms >= 0 ? String.valueOf(tms) : "—");
                // kind=0 (check) so it shows in the host history table as a fresh row.
                try { store.logAttempt(id, 0, good, cms, -1, good ? tms : -1, 0, 0, 0); } catch (Throwable ignored) {}
                summary = build(ok, total, conn, hs, true);
                try { Thread.sleep(500); } catch (InterruptedException e) { break; }
            }
            summary = build(ok, total, conn, hs, false);
            running = false;
        }, "host-test");
        worker.setDaemon(true);
        worker.start();
    }

    public static synchronized void stop() {
        running = false;
        Thread w = worker;
        if (w != null) { w.interrupt(); worker = null; }
    }

    /** Per-attempt: "OK 2/3 · connect 120/135/— ms · handshake 340/360/— ms". */
    private static String build(int ok, int total, List<String> conn, List<String> hs, boolean ongoing) {
        String head = (ok > 0 ? "OK " : "NO LINK · ") + ok + "/" + total;
        return head + " · connect " + join(conn) + " ms · handshake " + join(hs) + " ms"
                + (ongoing ? " …" : "");
    }

    private static String join(List<String> l) {
        if (l.isEmpty()) return "—";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < l.size(); i++) { if (i > 0) sb.append('/'); sb.append(l.get(i)); }
        return sb.toString();
    }
}
