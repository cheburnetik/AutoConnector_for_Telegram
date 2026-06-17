package io.autoconnector.engine.io;

import io.autoconnector.engine.core.NetworkMode;
import io.autoconnector.engine.core.Prefs;
import io.autoconnector.engine.db.ProxyStore;
import io.autoconnector.engine.model.ModeStats;
import io.autoconnector.engine.model.ProxyEntry;
import io.autoconnector.engine.model.ProxyType;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Universal backup payload — pure build/parse over {@link ProxyStore} +
 * {@link Prefs}, with NO file I/O and NO platform calls. Both DesktopEngine and
 * AndroidEngine share it: the JSON is shown in a text field (copy / save / paste
 * / load) by the UI, so the engine only needs to turn the selected sections into
 * a string and fold a string back in.
 */
public final class BackupIo {

    private BackupIo() {}

    /** Result of an import: a human-readable status line plus flags telling the
     *  caller which live views need refreshing afterwards. */
    public static final class ImportResult {
        public final String status;
        public final boolean subsChanged;
        public final boolean hostsChanged;
        public ImportResult(String status, boolean subsChanged, boolean hostsChanged) {
            this.status = status;
            this.subsChanged = subsChanged;
            this.hostsChanged = hostsChanged;
        }
    }

    /** Builds the backup JSON for the requested sections. Never touches disk. */
    public static String build(ProxyStore store, Prefs prefs,
                               boolean settings, boolean subs, boolean hosts) {
        LinkedHashMap<String, Object> root = new LinkedHashMap<>();
        root.put("app", "AutoConnectorForTelegram");
        root.put("v", 1);
        if (settings) root.put("settings", prefs.exportSettings());
        if (subs) {
            ArrayList<Object> arr = new ArrayList<>();
            for (ProxyStore.Source s : store.listSources()) {
                LinkedHashMap<String, Object> m = new LinkedHashMap<>();
                m.put("url", s.url);
                m.put("enabled", s.enabled);
                arr.add(m);
            }
            root.put("subscriptions", arr);
        }
        if (hosts) root.put("hosts", collectHosts(store));
        return Json.encode(root);
    }

    private static List<Object> collectHosts(ProxyStore store) {
        ArrayList<Object> out = new ArrayList<>();
        for (ProxyEntry p : store.aliveHostsAnyMode()) {
            LinkedHashMap<String, Object> h = new LinkedHashMap<>();
            h.put("host", p.host);
            h.put("port", p.port);
            h.put("type", p.type.name());
            h.put("secret", p.secret);
            h.put("source", p.source);
            LinkedHashMap<String, Object> modes = new LinkedHashMap<>();
            for (Map.Entry<NetworkMode, ModeStats> e : store.modeStatsAll(p.id).entrySet()) {
                ModeStats st = e.getValue();
                if (st.lastCheck <= 0 && !st.alive) continue;   // skip never-probed modes
                LinkedHashMap<String, Object> ms = new LinkedHashMap<>();
                ms.put("alive", st.alive);
                ms.put("rtt", st.rttMs);
                ms.put("score", st.score);
                ms.put("successes", st.successes);
                ms.put("failures", st.failures);
                ms.put("lastCheck", st.lastCheck);
                ms.put("lastOk", st.lastOk);
                ms.put("tg", st.tgConnections);
                ms.put("sessionMs", st.totalSessionMs);
                ms.put("bytes", st.bytesRelayed);
                modes.put(e.getKey().code, ms);
            }
            h.put("modes", modes);
            out.add(h);
        }
        return out;
    }

    /** Parses {@code text} and applies only the requested sections that are
     *  actually present in the payload. Returns null status when the text is
     *  not a recognizable backup (caller reports the error). */
    public static ImportResult importInto(ProxyStore store, Prefs prefs, String text,
                                          boolean settings, boolean subs, boolean hosts) {
        Map<String, Object> root = Json.parseObject(text);
        ArrayList<String> done = new ArrayList<>();
        boolean subsChanged = false, hostsChanged = false;

        Object sett = root.get("settings");
        if (settings && sett instanceof Map) {
            LinkedHashMap<String, String> sm = new LinkedHashMap<>();
            for (Map.Entry<?, ?> en : ((Map<?, ?>) sett).entrySet()) {
                if (en.getKey() != null) sm.put(en.getKey().toString(),
                        en.getValue() == null ? "" : en.getValue().toString());
            }
            int n = prefs.importSettings(sm);
            done.add("настройки (" + n + ")");
        }

        Object subList = root.get("subscriptions");
        if (subs && subList instanceof List) {
            int n = 0;
            for (Object item : (List<?>) subList) {
                if (!(item instanceof Map)) continue;
                Map<?, ?> mm = (Map<?, ?>) item;
                Object url = mm.get("url");
                if (url == null) continue;
                long id = store.upsertSource(url.toString());
                Object en = mm.get("enabled");
                if (id > 0 && en instanceof Boolean) store.setSourceEnabled(id, (Boolean) en);
                n++;
            }
            subsChanged = true;
            done.add("подписки (" + n + ")");
        }

        Object hostList = root.get("hosts");
        if (hosts && hostList instanceof List) {
            int n = 0;
            for (Object item : (List<?>) hostList) {
                if (!(item instanceof Map)) continue;
                Map<?, ?> mm = (Map<?, ?>) item;
                Object host = mm.get("host");
                if (host == null) continue;
                int port = asInt(mm.get("port"), -1);
                if (port < 0) continue;
                ProxyType type;
                try { type = ProxyType.valueOf(str(mm.get("type"), "MTPROTO")); }
                catch (Throwable t) { type = ProxyType.MTPROTO; }
                ProxyEntry entry = new ProxyEntry(type, host.toString(), port,
                        mm.get("secret") == null ? null : mm.get("secret").toString(),
                        mm.get("source") == null ? null : mm.get("source").toString());
                long id = store.importHost(entry);
                if (id <= 0) continue;
                Object modes = mm.get("modes");
                if (modes instanceof Map) {
                    for (Map.Entry<?, ?> me : ((Map<?, ?>) modes).entrySet()) {
                        if (!(me.getValue() instanceof Map)) continue;
                        Map<?, ?> ms = (Map<?, ?>) me.getValue();
                        store.importModeStats(
                                id, String.valueOf(me.getKey()),
                                Boolean.TRUE.equals(ms.get("alive")),
                                asInt(ms.get("rtt"), -1),
                                asDouble(ms.get("score"), 0.0),
                                asInt(ms.get("successes"), 0),
                                asInt(ms.get("failures"), 0),
                                asLong(ms.get("lastCheck"), 0L),
                                asLong(ms.get("lastOk"), 0L),
                                asLong(ms.get("tg"), 0L),
                                asLong(ms.get("sessionMs"), 0L),
                                asLong(ms.get("bytes"), 0L));
                    }
                }
                n++;
            }
            hostsChanged = true;
            done.add("хосты (" + n + ")");
        }

        if (done.isEmpty()) return new ImportResult(null, false, false);
        return new ImportResult(String.join(", ", done), subsChanged, hostsChanged);
    }

    private static int asInt(Object o, int dflt) {
        return o instanceof Number ? ((Number) o).intValue() : dflt;
    }
    private static long asLong(Object o, long dflt) {
        return o instanceof Number ? ((Number) o).longValue() : dflt;
    }
    private static double asDouble(Object o, double dflt) {
        return o instanceof Number ? ((Number) o).doubleValue() : dflt;
    }
    private static String str(Object o, String dflt) {
        return o == null ? dflt : o.toString();
    }
}
