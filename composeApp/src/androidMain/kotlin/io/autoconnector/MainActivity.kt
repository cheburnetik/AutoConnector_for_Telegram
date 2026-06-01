package io.autoconnector

import android.Manifest
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import io.autoconnector.ui.App

/** Process-wide engine so Activity recreation never spins up a second poller. */
object EngineHolder {
    @Volatile private var engine: AndroidEngine? = null
    fun get(ctx: Context): AndroidEngine =
        engine ?: synchronized(this) {
            engine ?: AndroidEngine(ctx.applicationContext).also { it.start(); engine = it }
        }
}

class MainActivity : ComponentActivity() {

    private val notifPermLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val engine = EngineHolder.get(this)
        if (Build.VERSION.SDK_INT >= 33) {
            notifPermLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
        setContent { App(engine) }
    }
}
