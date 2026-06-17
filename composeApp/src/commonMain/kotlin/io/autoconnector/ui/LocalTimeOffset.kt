package io.autoconnector.ui

/**
 * Local-timezone UTC offset (in milliseconds) for the given epoch instant.
 * Log timestamps are rendered in the computer's LOCAL time (not UTC) by adding
 * this offset before splitting the epoch into hours/minutes/seconds.
 */
expect fun localOffsetMs(ts: Long): Int
