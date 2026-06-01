package io.autoconnector.engine.core;

/**
 * Compact "N sec / N мин / N ч / N д" formatter the UI uses for live
 * counters: seconds always tick, but the magnitude rolls up to minutes,
 * hours and days so the string never grows past ~12 chars.
 */
public final class Durations {

    /** Formats a duration given in seconds. */
    public static String human(long sec) {
        if (sec < 0) sec = 0;
        if (sec < 60) return sec + " сек";
        if (sec < 3600) return (sec / 60) + " мин " + (sec % 60) + " сек";
        if (sec < 86400) return (sec / 3600) + " ч " + ((sec % 3600) / 60) + " мин";
        return (sec / 86400) + " д " + ((sec % 86400) / 3600) + " ч";
    }

    /** Single-token compact form: {@code "42с"}, {@code "12м42с"}, {@code "2ч15м"}, {@code "3д4ч"}. */
    public static String compact(long sec) {
        if (sec < 0) sec = 0;
        if (sec < 60) return sec + "с";
        if (sec < 3600) {
            long m = sec / 60, s = sec % 60;
            return s > 0 ? m + "м" + s + "с" : m + "м";
        }
        if (sec < 86400) {
            long h = sec / 3600, m = (sec % 3600) / 60;
            return m > 0 ? h + "ч" + m + "м" : h + "ч";
        }
        long d = sec / 86400, h = (sec % 86400) / 3600;
        return h > 0 ? d + "д" + h + "ч" : d + "д";
    }

    private Durations() {}
}
