package io.autoconnector.ui

/** Device-local UTC offset for [ts], including DST in effect at that instant. */
actual fun localOffsetMs(ts: Long): Int = java.util.TimeZone.getDefault().getOffset(ts)
