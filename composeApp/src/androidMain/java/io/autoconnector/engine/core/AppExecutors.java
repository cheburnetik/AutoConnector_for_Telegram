package io.autoconnector.engine.core;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Application-wide bounded thread pools — everything that used to allocate
 * its own ExecutorService (Activities, RelayServer, CheckRunner, the
 * foreground service's mains-check) lives here now.
 *
 * <p><b>Why queue-backed, not synchronous-handoff:</b> the previous design
 * used {@code SynchronousQueue} + {@code CallerRunsPolicy}, which meant a
 * full pool ran the task <em>on the submitter's thread</em>. When the
 * submitter was a UI Runnable (Catalog refresh, MainActivity bootstrap),
 * a saturated pool turned into an ANR and the system killed us.
 *
 * <p>Now every general-purpose pool has a fixed worker count and a bounded
 * queue. Submitting from the UI thread never blocks longer than it takes
 * to enqueue. RELAY is the one exception: it's still SynchronousQueue +
 * AbortPolicy so a stuck upstream rejects new connections instead of
 * growing threads or a queue.
 *
 * <p>All threads are daemons, named, easy to spot in {@code adb shell ps -T}.
 */
public final class AppExecutors {

    /** Activity-driven background work (Catalog refresh, autoRefreshOnce).
     *  2 fixed workers, queue size 64 — never blocks the UI. */
    public static final ThreadPoolExecutor BG = queueBacked("kbh-bg", 2, 64);

    /** Foreground service one-offs (mains-check, per-source actions). */
    public static final ThreadPoolExecutor SERVICE = queueBacked("kbh-svc", 2, 64);

    /** HTTP fetches for subscription pages. */
    public static final ThreadPoolExecutor SCAN = queueBacked("kbh-scan", 4, 64);

    /** Outbound probe network work. 16 workers, large queue — capped
     *  throughput, never threads-go-brrr. */
    public static final ThreadPoolExecutor PROBE = queueBacked("kbh-probe", 16, 1024);

    /** Incoming Telegram→upstream relays. {@code SynchronousQueue} +
     *  AbortPolicy: a stuck upstream causes new accepts to be rejected
     *  (and the accept thread closes the Telegram socket) instead of
     *  growing the pool. */
    public static final ThreadPoolExecutor RELAY = relayPool("kbh-relay", 64);

    // ----------------------------------------------------------------

    private static ThreadFactory namedDaemons(String name) {
        return new ThreadFactory() {
            private final AtomicInteger n = new AtomicInteger();
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r, name + "-" + n.incrementAndGet());
                t.setDaemon(true);
                t.setPriority(Thread.NORM_PRIORITY - 1);
                return t;
            }
        };
    }

    /** Bounded queue + fixed worker count. UI-safe submit. Excess work
     *  is silently dropped (DiscardOldestPolicy) — preferable to ANR. */
    private static ThreadPoolExecutor queueBacked(String name, int workers, int queueCap) {
        ThreadPoolExecutor exec = new ThreadPoolExecutor(
                workers, workers,
                30, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(queueCap),
                namedDaemons(name),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        exec.allowCoreThreadTimeOut(true);
        return exec;
    }

    private static ThreadPoolExecutor relayPool(String name, int max) {
        ThreadPoolExecutor exec = new ThreadPoolExecutor(
                4, max,
                60, TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                namedDaemons(name),
                new ThreadPoolExecutor.AbortPolicy());
        exec.allowCoreThreadTimeOut(true);
        return exec;
    }

    private AppExecutors() {}
}
