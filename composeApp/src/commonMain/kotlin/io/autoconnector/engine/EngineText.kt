package io.autoconnector.engine

/**
 * Small, platform-agnostic text helpers shared by the per-platform engine
 * implementations (AndroidEngine / DesktopEngine). They operate purely on
 * commonMain types (String, LogLevel) so they live here once instead of being
 * copy-pasted byte-for-byte into each source set.
 *
 * Kept `internal` so they're visible to both engine files (same module) without
 * widening the public engine API.
 */

/** Maps a log line's leading glyph to a [LogLevel] for colouring in the UI. */
internal fun classify(line: String): LogLevel {
    val c = line.firstOrNull() ?: ' '
    return when (c) {
        '✓', '●', '≈', '→' -> LogLevel.OK
        '✗', '⨂' -> LogLevel.FAIL
        '↪' -> LogLevel.ROUTE
        '·' -> LogLevel.MUTED
        '⟳', '⚠', '⏸' -> LogLevel.WARN
        else -> LogLevel.INFO
    }
}

/** Returns the "host" part of a "host:port" string (everything before the last
 *  colon); the whole string if there's no port, "" for null. */
internal fun stripPort(hp: String?): String {
    if (hp == null) return ""
    val c = hp.lastIndexOf(':')
    return if (c > 0) hp.substring(0, c) else hp
}

/** Parses the numeric port out of a "host:port" string; 0 if absent/unparseable. */
internal fun portOf(hp: String?): Int {
    if (hp == null) return 0
    val c = hp.lastIndexOf(':')
    return if (c > 0) hp.substring(c + 1).toIntOrNull() ?: 0 else 0
}
