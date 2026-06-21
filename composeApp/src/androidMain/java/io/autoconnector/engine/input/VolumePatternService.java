package io.autoconnector.engine.input;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;

import io.autoconnector.engine.core.Prefs;
import io.autoconnector.engine.db.ProxyStore;
import io.autoconnector.engine.model.ProxyEntry;

import java.util.List;
import java.util.Random;

/**
 * Accessibility service that watches volume-button presses in the background and,
 * when a configured fast-click pattern (see {@link VolumePatterns}) is detected,
 * fires a {@code tg://} link of a random good/alive host so Telegram intercepts it
 * and switches proxy. It NEVER consumes the volume keys (returns false), so volume
 * keeps working normally, and it does nothing unless the in-app toggle is on — so
 * even with accessibility granted, disabling the toggle stops all monitoring.
 *
 * Accessibility services receive global key events (with flagRequestFilterKeyEvents)
 * AND are exempt from background-activity-start limits, which is why this — not a
 * plain foreground service — is used to both detect and launch.
 */
public final class VolumePatternService extends AccessibilityService {

    private final boolean[] buf = new boolean[16];
    private int len = 0;
    private long lastPressAt = 0;
    private long lastFireAt = 0;
    private long lastFiredId = -1;
    private final Random rnd = new Random();

    @Override public void onAccessibilityEvent(AccessibilityEvent event) { /* unused */ }
    @Override public void onInterrupt() { /* unused */ }

    @Override
    protected boolean onKeyEvent(KeyEvent event) {
        try {
            // Count one press per key-down (ignore auto-repeat and key-up).
            if (event.getAction() != KeyEvent.ACTION_DOWN || event.getRepeatCount() != 0) return false;
            final boolean up;
            int kc = event.getKeyCode();
            if (kc == KeyEvent.KEYCODE_VOLUME_UP) up = true;
            else if (kc == KeyEvent.KEYCODE_VOLUME_DOWN) up = false;
            else return false;

            Prefs p = new Prefs(this);
            if (!p.volPatternEnabled()) { len = 0; return false; }

            long now = System.currentTimeMillis();
            long gap = p.volPatternGapMs();
            // A press farther than gap from the previous one starts a fresh sequence.
            if (len > 0 && (now - lastPressAt) > gap) len = 0;
            lastPressAt = now;

            if (len >= buf.length) {                       // keep the most recent presses
                System.arraycopy(buf, 1, buf, 0, buf.length - 1);
                len = buf.length - 1;
            }
            buf[len++] = up;

            // Only the user-selected pattern triggers.
            if (VolumePatterns.tailMatches(buf, len, p.volPatternIndex()) && (now - lastFireAt) > 1500) {
                lastFireAt = now;
                len = 0;                                    // consume the sequence
                fireRandomLink();
            }
        } catch (Throwable ignored) {}
        return false;   // never consume — volume buttons keep working
    }

    /** Opens a tg:// link of a random good/alive host (different from last time). */
    private void fireRandomLink() {
        try {
            ProxyStore store = ProxyStore.get(this);
            List<ProxyEntry> hosts = store.topAlive(25);   // rating-sorted, alive, not on cooldown
            if (hosts == null || hosts.isEmpty()) return;
            ProxyEntry pick = hosts.get(rnd.nextInt(hosts.size()));
            for (int tries = 0; tries < 6 && pick != null && pick.id == lastFiredId && hosts.size() > 1; tries++) {
                pick = hosts.get(rnd.nextInt(hosts.size()));
            }
            if (pick == null) return;
            lastFiredId = pick.id;
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(pick.tgLink()))
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        } catch (Throwable ignored) {}
    }
}
