package io.autoconnector.engine.relay;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Starts the relay automatically when the phone finishes booting (and after
 * an app upgrade), so the user doesn't have to open AutoConnector for Telegram
 * by hand for the relay to come up.
 */
public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context ctx, Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if (Intent.ACTION_BOOT_COMPLETED.equals(action)
                || Intent.ACTION_MY_PACKAGE_REPLACED.equals(action)
                || "android.intent.action.LOCKED_BOOT_COMPLETED".equals(action)) {
            try {
                RelayService.start(ctx);
            } catch (Exception ignored) {
                // Boot-time start may be denied on locked devices; the user's
                // first manual launch of the app starts it anyway.
            }
        }
    }
}
