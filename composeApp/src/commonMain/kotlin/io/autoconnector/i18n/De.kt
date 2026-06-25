package io.autoconnector.i18n

object De : Strings {
    override val tabConnector = "Connector"; override val tabScan = "Scan"
    override val tabCatalog = "Katalog"; override val tabLogs = "Logs"; override val tabMore = "Mehr"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "Abonnements"; override val logTabScan = "Scan"
    override val logGeneral = "Allgemein"; override val logEmpty = "vorerst leer"
    override val logSessions = "Sitzungen"; override val logErrorsOnly = "nur Fehler"; override val logNoErrors = "keine fehlgeschlagenen Sitzungen"
    override fun logSession(id: String, port: String) = "#${id} · :${port}"
    override val back = "Zurück"; override val copy = "Kopieren"; override val gotIt = "Verstanden"
    override val later = "Später"; override val details = "Details"; override val whatIsThis = "Was ist das?"
    override val delete = "Löschen"

    override val connector = "Connector"; override val scan = "Scan"
    override val notConfigured = "Nicht eingerichtet! Beheben →"; override val howToSetup = "Einrichtung"
    override val notifOff = "Benachrichtigungen sind aus! Beheben →"; override val enable = "Aktivieren"
    override fun fewProxies(n: Int) = "Aktive Proxys ${n}, Suche läuft, warte ~15 Min…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "Aktive Proxys: ${alive}  (15 Min: ${within}) · gesamt: ${total}"
    override val notifWhyTitle = "Warum Benachrichtigungen?"
    override val notifWhyBody = "Ein dauerhaftes Benachrichtigungssymbol bedeutet einen Android-Vordergrunddienst. " +
        "Ohne ihn entlädt das System die App aus dem Speicher und sie hört auf, nach Proxys zu suchen und " +
        "die Verbindung im Hintergrund zu halten. Deshalb sind Benachrichtigungen erforderlich, damit " +
        "AutoConnector funktioniert."
    override val notifEnableTitle = "Benachrichtigungen aktivieren"
    override val notifEnableBody = "Ohne Benachrichtigungssymbol behandelt Android die App als inaktiv und " +
        "entlädt sie aus dem Speicher. Dann hört AutoConnector auf, nach Proxys zu suchen und die " +
        "Verbindung im Hintergrund zu halten — Telegram verliert seine Verbindung.\n\nTippe auf \"Aktivieren\" und erlaube " +
        "Benachrichtigungen für AutoConnector."
    override val notifPlea = "Aktiviere Benachrichtigungen! Ohne sie kann die App nicht im Hintergrund laufen — " +
        "Android entlädt sie und die Proxy-Suche sowie die Verbindung werden gestoppt."

    override val statusConnected = "Telegram verbunden"; override val statusConnecting = "Verbinde…"
    override val statusOffline = "Telegram nicht verbunden"; override val statusIdle = "Telegram inaktiv"
    override val nobodyConnected = "Niemand mit dem Connector verbunden. "; override val howToSetupArrow = "Einrichtung →"
    override val directModeViaVpn = "Direktmodus: VPN aktiv — kein Proxy"
    override val directModeOff = "Direktmodus: Proxys aus"
    override val directDpiSuffix = " · Anti-DPI"
    override val connections = "Verbindungen"; override val sockets = "Sockets"; override val speed = "Geschwindigkeit"
    override val traffic = "Datenverkehr"; override val latency = "Latenz"
    override fun pcs(n: Int) = "${n} Stk"
    override fun netNow(label: String) = "Netzwerk: ${label}"
    override fun tgToConnector(n: Int) = "TG→ ${n}"
    override fun connectorToProxy(n: Int) = "Proxy ${n}"
    override val trafficSec = "Verkehr · 60 Sek"; override val trafficMin = "Verkehr · 60 Min"
    override val latencySec = "Latenz · 60 Sek"; override val latencyMin = "Latenz · 60 Min"
    override val sec60 = "60 Sek"; override val min60 = "60 Min"
    override val unitSec = "s"; override val unitMin = "m"; override val unitHour = "h"; override val dash = "—"
    override val currentProxy = "Aktueller Proxy"; override val noActiveProxy = "kein aktiver Proxy (Telegram nicht verbunden)"
    override val host = "Host"; override val type = "Typ"; override val secret = "Secret"; override val antiDpi = "Anti-DPI"; override val obfEngine = "Verschleierungs-Engine"
    override fun activeSockets(n: Int) = "Aktive Telegram-Sockets: ${n}"
    override val noConnections = "keine aktiven Verbindungen"; override val colHost = "Host"; override val colTime = "Zeit"
    override val modeWord = "Modus"; override val directViaVpnLine = "Direkte Anfragen an Telegram (VPN aktiv)"
    override val connModeHelp = "Modi (VPN, Wi-Fi, LTE, Ethernet, White) erlauben es, die Scan-Intensität unterschiedlich einzustellen und separate Host-Bewertungen/Statistiken zu führen. Die Netzwerkart wird automatisch erkannt; der Modus kann in den Einstellungen manuell festgelegt werden."

    override val scanOff = "Scannen ist aus"; override val proxiesInBase = "Proxys in der Datenbank"
    override val total = "gesamt"; override val alive = "aktiv"; override val dead = "tot"
    override val tgConnectedTitle = "Telegram verbunden über"; override val successful = "erfolgreich"
    override val socketsHeld = "Socket-Lebensdauer"; override val over1m = ">1 Min"; override val over5m = ">5 Min"; override val over15m = ">15 Min"
    override val scanCountTitle = "Anzahl Proxy-Prüfungen"; override val checked = "Geprüft"
    override val forAllTime = "gesamte Zeit"; override val perMinute = "pro Minute"; override val perHour = "pro Stunde"
    override val subsCountTitle = "Anzahl Abonnement-Downloads"; override val downloaded = "heruntergeladen"; override val failed = "fehlgeschlagen"; override val scanTraffic = "Scan-Verkehr"; override val subTraffic = "Abonnement-Verkehr"; override val subTrafficGraph = "Abonnement-Verkehr"
    override val checksMtproto = "MTProto-Prüfungen (↑ ok · ↓ Fehler)"

    override fun catalogEmpty(mode: String) = "Katalog ${mode} ist vorerst leer. Entweder wurde kein Host gefunden, oder die App lief in diesem Modus noch nie. Du kannst den Modus in den Einstellungen wechseln. Modi dienen dazu, Hosts für verschiedene Arten von Internetverbindungen separat zu sammeln."
    override val aliveShort = "✓ aktiv"; override val deadShort = "✗ tot"
    override val statusLabel = "Status"; override val rating = "Bewertung"; override val port = "Port"
    override val rttPing = "RTT (Ping)"; override val checkedField = "Geprüft"; override val okOfTotal = "Erfolgreiche / gesamte Prüfungen"
    override val tgConnectedField = "Telegram verbunden"; override val tgSessions = "Telegram-Sitzungen"; override val trafficThroughProxy = "Verkehr über Proxy"
    override val sessionsTotal = "Sitzungen gesamt"; override val relayNow = "Relay jetzt"; override val tlsDomain = "TLS-Domain (SNI)"
    override val sourceSub = "Quelle (Abonnement)"; override val lastError = "Letzter Fehler"; override val yes = "ja"; override val no = "nein"
    override val copyAsLink = "Als Link kopieren"; override val openInTelegram = "Host in Telegram öffnen"; override val makeNextRelay = "Zum nächsten Relay machen"
    override val actCopy = "Kopieren"; override val actOpen = "Öffnen"; override val actRelay = "Relay"
    override fun agoFmt(v: String) = "vor ${v}"
    override val catalogTopFor = "Proxy-Liste/Bewertung für"
    override val catalogModeHelpTitle = "Modi & Bewertungen"
    override val catalogModeHelp = "Die App zählt aktive Hosts und ihre Bewertungen GETRENNT pro Netzwerkmodus (VPN, Wi-Fi, LTE, Ethernet und White). \"White\" ist ein separater MANUELLER Modus für Whitelists; die Automatik wechselt nie dorthin. Derselbe Host kann also in einem Modus aktiv und in einem anderen tot sein."
    override fun catalogInactiveWarn(section: String, active: String) =
        "Du betrachtest den inaktiven Bereich ${section} — alle Statistiken gehen gerade an ${active}, nicht hierher."
    override val manageModeTitle = "Modus verwalten"
    override val manageResetRating = "Bewertung zurücksetzen"
    override fun manageResetHint(mode: String) = "Speziell für ${mode} kannst du die Bewertung und Nutzungsstatistik der aktiven Hosts zurücksetzen. Das ist praktisch, wenn du dich mit einem grundlegend anderen VPN oder LTE verbunden hast, damit alte Statistiken nicht stören. Oder um zu beobachten, wie schnell der Proxy-Scan alles von Grund auf neu prüft."
    override val manageDeleteAll = "Hosts löschen in"
    override fun manageDeleteHint(mode: String) = "Du kannst sowohl die Bewertung als auch die Hosts selbst aus ${mode} löschen. Die Funktion \"Proxys scannen\" sammelt sie erneut. Das ist kein Abonnement-Reset — du kannst darauf tippen und dann ~15 Minuten auf einen erneuten Scan warten."
    override fun manageCopyFrom(mode: String) = "Alle Hosts und Bewertungen aus einem anderen Modus in diesen Modus (${mode}) kopieren:"
    override val live = "aktiv"; override val deadW = "tot"; override val unitMs = "ms"
    override val agoMin = "m"; override val agoHour = "h"; override val agoDay = "T"

    override val connectTelegram = "Telegram verbinden"; override val readCarefully = "Sorgfältig lesen!"
    override val guideIntro = "Diese App funktioniert nicht ohne Einrichtung. Wähle eine der 3 unten stehenden Optionen " +
        "und folge der Anleitung sorgfältig."
    override val variant1 = "Option #1 — Schaltflächen"
    override val variant1Body = "Tippe auf \"Proxy {A}\" — Telegram öffnet sich, bestätige das Hinzufügen des Proxys. Komm " +
        "zu diesem Bildschirm zurück und tippe auf \"Proxy {B}\" — bestätige ein zweites Mal das Hinzufügen.\n\nDeaktiviere alle " +
        "anderen alten Proxys in Telegram. Genau 2 Proxys müssen übrig bleiben — mit den Ports {A} und {B}. " +
        "Mit einer anderen Konfiguration funktioniert AutoConnector nicht."
    override val variant2 = "Option #2 — Links"
    override val variant2Body = "Kopiere den untenstehenden Text in die Gespeicherten Nachrichten (oder einen beliebigen Chat) in Telegram — " +
        "d.h. sende ihn an dich selbst. Tippe auf den ersten Link in deiner Nachricht — der erste Proxy wird hinzugefügt. " +
        "Tippe auf den zweiten Link — der zweite wird hinzugefügt. Deaktiviere dann alle alten Proxys."
    override val variant3 = "Option #3 — manuell"
    override val variant3Body = "Füge manuell einen SOCKS5-Proxy hinzu: Server localhost (127.0.0.1), Port {A}. " +
        "Dann einen zweiten Proxy: localhost, Port {B}. Lösche alle alten Proxys."
    override val whatNext = "Was kommt als Nächstes?"
    override val whatNextBody = "Aktiviere in Telegram \"Proxy automatisch wechseln\" — 5 Sekunden. Du kannst Telegram " +
        "beim Verbinden helfen, indem du manuell auf einen Proxy (innerhalb von Telegram) tippst, der NICHT aktiv ist oder als " +
        "\"nicht verfügbar\" markiert ist — das bringt Telegram dazu, sich stärker um eine Verbindung zu bemühen.\n\nStelle sicher, dass alle anderen alten " +
        "Proxys entfernt sind, außer {A} und {B}. Tippe in Telegram auf " +
        "\"Proxy verwenden\".\n\nWarte, während die App genügend Proxys findet und herunterlädt " +
        "(5–15 Minuten). Dann verbindet sich Telegram von selbst mit AutoConnector, der Telegram " +
        "weiterhin über die besten Proxys leitet: verifiziert, aktiv und schnell.\n\nWenn die Anleitung " +
        "schwer erscheint — leider kannst du die App dann nicht nutzen: Es ist unmöglich, alles " +
        "automatisch einzurichten, und das Finden aktiver Proxys braucht Zeit.\n\nWenn du die App vor langer Zeit " +
        "heruntergeladen hast und keine aktiven Proxys gefunden wurden — aktualisiere entweder die App oder die Abonnement-Liste. Diese App " +
        "erfindet oder stellt keine eigenen Proxys bereit, sie durchsucht nur das Internet über Dutzende " +
        "von Gruppen und Seiten."
    override fun proxyBtn(port: Int) = "Proxy ${port}"

    override val setupPortsTitle = "Ports in Telegram einrichten"
    override val setupPortsSub = "Wie man Telegram mit dem Connector verbindet (Ports 55001/55002)"
    override val settings = "Einstellungen"; override val settingsSub = "Ports, Anti-DPI, Scan, Netzwerk, Akku"
    override val subscriptions = "Abonnements"; override val subscriptionsSub = "Proxy-Quellen zum Scannen"
    override val statistics = "Statistik"; override val statisticsSub = "Proxy-Datenbank + Anti-DPI-Tricks"
    override val export = "Export"; override val exportSub = "tg://-Links aktiver Proxys"
    override val about = "Über"; override val aboutSub = "Version, Build, Download, Feedback"
    override val hotkeys = "Tastenkürzel"
    override val hotkeysSub = "Globale Tasten: Proxy kopieren / öffnen"
    override val hotkeysIntro = "Globale Tastenkürzel funktionieren auch, wenn das App-Fenster nicht im Fokus ist. Sie wählen einen " +
        "zufälligen aktiven Proxy-Link (tg://) aus dem Pool — praktisch zum schnellen Wechseln von Proxys, ohne " +
        "die App zu öffnen."
    override val hotkeysNote = "Unter macOS kann das Erfassen von Tasten die Bedienungshilfen-Berechtigung erfordern " +
        "(Systemeinstellungen → Datenschutz & Sicherheit → Bedienungshilfen)."
    override val hotkeyCopyTitle = "Proxy-Link kopieren"
    override val hotkeyCopyDesc = "Legt einen zufälligen aktiven tg://-Link in die Zwischenablage."
    override val hotkeyEnable = "Tastenkürzel aktivieren"; override val hotkeyLetterLabel = "Buchstabe"; override val hotkeySet = "Festlegen"; override val hotkeyReset = "Zurücksetzen"
    override val hotkeyOpenTitle = "Proxy in Telegram öffnen"
    override val hotkeyOpenDesc = "Öffnet einen zufälligen aktiven Link — Telegram übernimmt ihn und bietet an, den Proxy zu verbinden."

    override val relayPorts = "Relay-Ports"
    override val relayPortsHelp = "Lokale Ports, auf denen der Connector lauscht. Genau diese gibst du in " +
        "Telegram als SOCKS5-Proxy ein (127.0.0.1 : Port). Zwei Ports werden für Zuverlässigkeit verwendet — Telegram " +
        "hält Verbindungen zu beiden."
    override val portA = "Port A"; override val portB = "Port B"
    override val antiDpiTrick = "Anti-DPI-Trick"
    override val antiDpiHelp = "Eine Methode, die Verbindung zu tarnen, damit der ISP/DPI sie nicht erkennt und " +
        "blockiert.\n• \"Auto-Rotation\" wählt selbst einen funktionierenden Trick.\n• \"Keine DPI-Tricks\" — eine einfache " +
        "Verbindung.\n• Die übrigen sind spezifische Techniken (Browser-Nachahmung, Paketaufteilung usw.)."
    override val onlyFakeTls = "Nur FakeTLS (ee)"
    override val applyDpiTo = "Anti-DPI anwenden auf"
    override val applyDpiHelp = "Worauf der gewählte Anti-DPI-Trick angewendet wird:\n• Telegram-Relay — auf die " +
        "aktive Telegram-Verbindung über den Connector.\n• Proxy-Prüfungen — auf Proxy-Prüfungen im Hintergrund " +
        "(dann verhält sich eine Prüfung wie eine echte Verbindung, und die Trick-Statistik ist genauer).\n" +
        "• Bei direkter Verbindung — wenn Proxys aus sind (oder bei aktivem VPN übersprungen werden) und Telegram " +
        "direkt zu seinen Servern geht: Hier gibt es keinen Proxy, daher reduziert sich der Trick auf das Aufteilen des " +
        "ersten TCP-Pakets (des Handshakes) in mehrere kleine Segmente, damit DPI es nicht in einem Lesevorgang zuordnen kann."
    override val toRelay = "Telegram-Relay"; override val toProbes = "Proxy-Prüfungen"
    override val toDirect = "Bei direkter Verbindung"
    override val vpnSection = "Wenn VPN aktiv ist"
    override val vpnHelp = "Was zu tun ist, wenn ein VPN auf dem Gerät aktiv ist:\n• Über MTProto-Proxy — " +
        "Telegram läuft wie gewohnt über die gefundenen Proxys (zusätzlich zum VPN).\n• Direkt — der " +
        "Connector verwendet KEINE Proxys und verbindet Telegram direkt mit Telegrams Servern: Das " +
        "VPN bietet bereits Zugang, die zusätzliche Proxy-Schicht ist nicht nötig (schneller und stabiler). " +
        "Ohne VPN werden Proxys wie gewohnt verwendet."
    override val linkFormat = "Proxy-Link-Format"
    override val linkFormatHelp = "Wie Proxys kopiert und geöffnet werden. tg:// öffnet Telegram direkt (benötigt installiertes Telegram Desktop). http (t.me) öffnet über den Browser und bietet an, in Telegram zu öffnen — praktisch, wenn tg:// nicht registriert ist."
    override val linkTg = "tg:// (Telegram direkt öffnen)"; override val linkTgSub = "tg://proxy?… — öffnet Telegram"
    override val linkHttp = "http (t.me, über Browser)"; override val linkHttpSub = "https://t.me/proxy?… — öffnet Browser"
    override val viaMtproto = "Proxy über MTProto"; override val viaMtprotoSub = "auch mit VPN läuft der Verkehr über Proxys"
    override val directly = "Direkt verbinden"; override val directlySub = "bei aktivem VPN — Proxys umgehen, direkt zu Telegram"
    override val notifications = "Benachrichtigungen"
    override val scanCheck = "Scannen & Prüfen"
    override val scanCheckHelp = "• Scan, Min — wie oft Proxy-Listen aus Abonnements heruntergeladen werden.\n" +
        "• Prüfung, Min — wie oft Proxys in der Datenbank auf Aktivität geprüft werden.\n• Stapelgröße — " +
        "wie viele Proxys pro Durchlauf geprüft werden.\n• Parallel — wie viele Prüfungen gleichzeitig laufen (mehr = " +
        "schneller, aber höhere Netzwerk- und Akkulast)."
    override val scanMin = "Scan, Min"; override val checkMin = "Prüfung, Min"; override val batchSize = "Stapelgröße"; override val parallel = "Parallel"
    override val speedByNet = "Scan-Intensität nach Netzwerk"
    override val speedByNetHelp = "Wie oft Proxys je nach aktuellem Netzwerk geprüft werden. " +
        "\"Standard\" = Basisintervall. Nach rechts schieben für seltener (langsamer, schonender für Verkehr/Akku), " +
        "nach links für häufiger (schneller, aggressiver). Logarithmische Skala, bis zu ×100 in jede Richtung.\n" +
        "• VPN — wenn ein externes VPN aktiv ist.\n• Wi-Fi — in einem Wi-Fi-Netzwerk.\n• LTE — in einem Mobilfunknetz."
    override val intensStandard = "Standard"
    override val intensSlower = "langsamer"
    override val intensFaster = "schneller"
    override val maintenance = "Daten zurücksetzen"
    override val maintenanceHelp = "• \"Katalog & Statistik zurücksetzen\" — setzt Bewertungen, Zähler, Verkehr " +
        "und Prüfprotokolle auf null, behält aber die heruntergeladenen Hosts und Abonnements (beim nächsten Scan wird alles neu bewertet).\n• \"Heruntergeladene Hosts löschen\" — löscht den gesamten Proxy-Pool, behält aber " +
        "Abonnements, sodass der Scan den Pool wieder auffüllt. Abonnements werden in keinem Fall angetastet."
    override val backupTitle = "Export / Import"
    override val backupHelp = "App-Daten als JSON speichern oder wiederherstellen. Hake an, was " +
        "enthalten sein soll — beliebige Kombination:\n• Einstellungen — alle App-Parameter.\n• Abonnements — die Quell-Liste (URL + an/aus).\n• Katalog aktiver Hosts — jeder aktive Proxy mit seinen Bewertungen und Statistiken " +
        "PRO Netzwerkmodus.\n\n\"Export\" öffnet eine Seite mit dem fertigen JSON — kopiere es oder speichere es in einer Datei. " +
        "\"Import\" — füge JSON ein (oder lade eine Datei) und es werden nur die angehakten, darin enthaltenen Abschnitte angewendet. Import FÜGT zu den aktuellen Daten HINZU (kein Löschen)."
    override val backupSettings = "Einstellungen"
    override val backupSubs = "Abonnements"
    override val backupHosts = "Katalog aktiver Hosts (pro Modus)"
    override val exportWord = "Export"
    override val importWord = "Import"
    override val backupExportTitle = "Daten exportieren"
    override val backupImportTitle = "Daten importieren"
    override val backupSelectExport = "Was exportieren:"
    override val backupSelectImport = "Was importieren:"
    override val backupCopyBtn = "Kopieren"
    override val backupSaveFile = "In Datei speichern"
    override val backupLoadFile = "Aus Datei laden"
    override val backupDoImport = "Import"
    override val backupPasteLabel = "Backup-JSON hier einfügen"
    override val backupJsonLabel = "Backup-JSON"
    override val backupAndroidFileNote = "Dateien sind hier nicht verfügbar — verwende Kopieren / Einfügen."
    override val eraseAllHosts = "Alle Hosts löschen"
    override val factoryReset = "Alles zurücksetzen (wie beim ersten Start)"
    override val factoryResetConfirm = "Die App vollständig auf den Werkszustand zurücksetzen? ALLE Einstellungen und der gesamte " +
        "Host-Katalog werden gelöscht, Abonnements auf die Standardwerte zurückgesetzt. Genau wie beim ersten Start."
    override val resetCatalog = "Katalog & Statistik zurücksetzen"
    override val resetCatalogConfirm = "Alle Bewertungen, Zähler und Prüfprotokolle auf null setzen? " +
        "Heruntergeladene Hosts und Abonnements bleiben erhalten und werden beim nächsten Scan neu bewertet."
    override val clearHosts = "Heruntergeladene Hosts löschen"
    override val clearHostsConfirm = "Die gesamte Liste heruntergeladener Hosts (Proxys) löschen? " +
        "Abonnements bleiben erhalten und der Scan füllt den Pool wieder auf."
    override val doReset = "Zurücksetzen"
    override val doCancel = "Abbrechen"
    override val adaptiveSpeed = "Adaptive Geschwindigkeit"
    override val adaptiveHelp = "Aktivitätsprüfungen laufen in einem Basisintervall (aus \"Scannen & Prüfen\", auch " +
        "multipliziert mit dem Netzwerk-Multiplikator). \"Adaptive Geschwindigkeit\" beschleunigt oder verlangsamt sie " +
        "automatisch je nachdem, wie viele Proxys derzeit aktiv sind.\n\n" +
        "• WENIGE aktiv (unter dem Schwellenwert \"Wenige\") → Intervall × \"Beschleunigung\". Ein Multiplikator unter 1 = " +
        "häufiger: 0,5 — doppelt so oft, 0,25 — 4×. Füllt den Pool schneller auf.\n" +
        "• VIELE aktiv (über dem Schwellenwert \"Viele\") → Intervall × \"Verlangsamung\". Über 1 = seltener: 2 — " +
        "halb so oft, 4 — ein Viertel. Spart Akku und Verkehr.\n" +
        "• Zwischen den Schwellenwerten — Basisgeschwindigkeit (×1).\n\n" +
        "Beispiele:\n" +
        "— Proxys schneller sammeln: \"Beschleunigung\" 0,25 und/oder Schwellenwert \"Wenige\" 40.\n" +
        "— Akku sparen, wenn du genug hast: \"Verlangsamung\" 8 und/oder Schwellenwert \"Viele\" 30.\n" +
        "— Anpassung deaktivieren: beide Multiplikatoren auf 1 setzen.\n\n" +
        "Standardwerte: Wenige 20, Beschleunigung 0,5, Viele 50, Verlangsamung 4."
    override val threshMany = "Schwellenwert \"Viele\""; override val threshFew = "Schwellenwert \"Wenige\""; override val mulFast = "Beschleunigung ×"; override val mulLazy = "Verlangsamung ×"
    override val subIntensityTitle = "Abonnement-Intensität"
    override val subIntensityHint = "Pause zwischen Abonnement-Downloads: wie viele Minuten vor dem erneuten Herunterladen der Proxy-Listen (separat pro Netzwerkmodus)."
    override val baseScanTitle = "Basis-Scangeschwindigkeit"
    override val baseScanHelp = "Die Referenzgeschwindigkeit der Aktivitätsprüfung. \"Adaptive Geschwindigkeit\" und die Multiplikatoren \"Geschwindigkeit nach " +
        "Modus\" werden relativ dazu berechnet.\n\n" +
        "• Wie oft ausführen, Min — Intervall zwischen Prüfdurchläufen.\n" +
        "• Stapel pro Thread, Hosts — wie viele Hosts jeder Thread pro Durchlauf prüft.\n" +
        "• Threads — wie viele Prüfungen gleichzeitig laufen. Ein Durchlauf prüft \"Stapel × Threads\" Hosts.\n" +
        "• Einen Host nicht öfter als alle N Min erneut scannen — Anti-Flood: ein kürzlich geprüfter Host wird " +
        "in diesem Durchlauf übersprungen.\n\n" +
        "Mehr Threads und ein größerer Stapel = schnelleres Pool-Wachstum, aber höhere Last für Netzwerk und Akku."
    override val baseScanPeriod = "Wie oft ausführen, Min"
    override val baseScanBatch = "Stapel pro Thread, Hosts"; override val baseScanThreads = "Anzahl Threads"
    override val adaptiveDesc = "Wenn aktive Proxys weniger als \"wenige\" oder mehr als \"viele\" sind, einen zusätzlichen Multiplikator anwenden."
    override val fewWord = "Wenige"; override val manyWord = "Viele"
    override fun fasterX(x: String) = "${x}× schneller"
    override fun slowerX(x: String) = "${x}× langsamer"
    override fun ifAliveLt(n: Int) = "Wenn aktive Proxys < ${n}, dann:"
    override fun ifAliveGt(n: Int) = "Wenn aktive Proxys > ${n}, dann:"
    override val disabledWord = "aus"
    override val speedByModeTitle = "Geschwindigkeit nach Modus"
    override val speedByModeHelp = "Ein Scan-Geschwindigkeitsmultiplikator für jeden Netzwerkmodus, zusätzlich zur Basis" +
        "geschwindigkeit. \"Standard\" (×1) = das Basisintervall. Rechts — seltener (langsamer, schonender für Verkehr/" +
        "Akku), links — häufiger (schneller, aggressiver). Logarithmische Skala, bis zu ×100 in jede " +
        "Richtung.\n\n" +
        "Unter jedem Schieberegler stehen die resultierenden Durchlaufparameter mit angewendeter adaptiver Geschwindigkeit — " +
        "getrennt für \"wenige aktiv\" (× \"Beschleunigung\") und \"viele aktiv\" (× \"Verlangsamung\").\n\n" +
        "Modi:\n• VPN — ein externes VPN ist aktiv.\n• LTE — Mobilfunknetz.\n• Wi-Fi — Wi-Fi-Netzwerk.\n" +
        "• Ethernet — kabelgebundene Verbindung.\n• White — manueller \"White\"-Proxy-Modus."
    override val aliveLt = "aktiv <"; override val aliveGt = "aktiv >"
    override val periodWord = "Periode"; override val nonstopWord = "ununterbrochen"
    override val batchWord = "Stapel"; override val threadsWord = "Threads"; override val scanModeOff = "Scan aus"
    override val netBattery = "Netzwerk & Akku"
    override val netBatteryHelp = "• Nur Wi-Fi — nicht in Mobilfunknetzen scannen (spart Daten).\n• Nur beim " +
        "Laden — nur arbeiten, während das Telefon lädt.\n• Bei niedrigem Akku überspringen — Scannen pausieren, wenn der " +
        "Akku niedrig ist."
    override val onlyWifi = "Nur Wi-Fi"; override val onlyCharging = "Nur beim Laden"; override val skipLowBattery = "Bei niedrigem Akku überspringen"
    override val autosaved = "Einstellungen werden automatisch gespeichert."
    override val dpiAutoLabel = "DPI-Tricks automatisch rotieren"; override val dpiNoneLabel = "Keine DPI-Tricks (einfach)"
    override val experimental = "Experimentell"
    override val experimentalHelp = "Alternative Proxy-Engines zum MTProto-Upstream plus ein Diagnoseprotokoll. " +
        "Der Referenzpfad (funktionierend) bleibt unverändert, wenn auf \"Aus\" gesetzt. Nur WIE der verschlüsselte Datenstrom in den " +
        "Upstream-TCP-Socket geschrieben wird, ändert sich (Segmentgrößen, Timing, TLS-Record-Grenzen) — der Datenstrom selbst bleibt Byte für Byte identisch. " +
        "Gilt nur für das aktive Proxy-Relay (nicht für Prüfungen, nicht für den direkten Pfad)."
    override val expEngineTitle = "Proxy-Engine (Socket-Verschleierung)"
    override val expConnectTitle = "Connect-Engine (Upstream-Auswahl)"
    override val expEngineWarn = "⚠ Experimenteller Modus. Wenn die Verbindung schlechter wird, wechsle zurück zu \"Aus (Referenzpfad)\"."
    override val netLog = "Netzwerkaustausch-Protokoll aktivieren"
    override val netLogSub = "Schreibt WER-AN-WEN-WANN und Paketgrößen in eine Datei (KEINE Nutzdaten) — " +
        "um das Austauschmuster mit vs. ohne VPN zu vergleichen."
    override val openLogFolder = "Protokollordner öffnen"; override val copyPath = "Pfad kopieren"
    override val helpShow = "Hilfe"; override val helpHide = "Hilfe ausblenden"
    override val quickSwitchIntro = "Hier kannst du einen Trick zur Blockadeumgehung wählen. Wenn Telegram den Fehler " +
        "„Der von dir verwendete Proxy ist nicht korrekt konfiguriert und wird deaktiviert. Bitte finde einen anderen“ " +
        "anzeigt, experimentiere damit, welcher Verkehrsverschleierungstyp funktioniert, damit Telegram ihn nicht mehr anzeigt. Beginne " +
        "mit den split*-Modi. Die coalesce*-Modi funktionieren auch, aber Bilder/Videos werden damit in Telegram schlecht geladen."
    override val quickSwitchTitle ="Blockadeumgehung"; override val quickSwitchSub = "Fragmentierung, Connect, Anti-DPI"

    override val sourceUrl = "Quell-URL"
    override fun sourceAlive(alive: Int, total: Int) = "aktiv ${alive}/${total}"
    override val open = "Öffnen"; override val active = "Aktiv"; override val inactive = "Inaktiv"
    override val lastDownloaded = "Heruntergeladen"; override val notDownloaded = "noch nicht heruntergeladen"
    override fun sourceCounts(dead: Int, total: Int) =
        " aktiv, ${dead} tot, ${total} gesamt"

    override val proxyBase = "Proxy-Datenbank"
    override val totalInBase = "Gesamt in der Datenbank"; override val aliveNow = "Jetzt aktiv"; override val deadStat = "Tot"
    override val aliveIn15 = "Aktiv in 15 Min"; override val checksAllTime = "Prüfungen gesamt"
    override val antiDpiTricks = "Anti-DPI-Tricks"; override val noStatsYet = "noch keine Daten — Tricks sammeln sich an, wenn Prüfungen/Verbindungen erfolgen"
    override val attempts = "Versuche"; override val handshake = "Handshake"; override val score = "Wert"
    override val tgConnect = "TG-Verbindung"; override val socketsOver1m = "Sockets >1Min"
    override val over10kb = "Sockets >10KB"; override val over100kb = ">100KB"; override val workTime = "Arbeitszeit"
    override val statsLegend = "Handshake — erfolgreiche Handshakes (% der Versuche) · Wert — Score · " +
        "\"Arbeitszeit\" — gesamt über Sockets ≥5KB und länger als 1 Minute."
    override val resetStats = "Trick-Statistik zurücksetzen"

    override fun aliveLinks(n: Int) = "Aktive Links: ${n}"
    override val copyAll = "Alle kopieren"
    override val openRandom = "Zufälligen öffnen"; override val copyRandom = "Zufälligen kopieren"; override val allShort = "ALLE"
    override val copyTop = "TOP kopieren"; override val randomHost = "Zufälliger Host"
    override val exportToFile = "In Datei exportieren"; override val exportSaved = "In Datei gespeichert:"
    override val dlNow = "Jetzt herunterladen"
    override fun downloadingFmt(sec: Long) = "Lädt herunter… ${sec}s"
    override val cancel = "Abbrechen"
    override val deleteConfirmTitle = "Abonnement löschen?"
    override val subscriptionsAddHint = "Abonnements oder Proxy-Links hinzufügen →"
    override val addSourcesTitle = "Hinzufügen"
    override val addSubsLabel = "Abonnements (eine URL pro Zeile)"
    override val addSubsHelp = "Jede Zeile mit einer gültigen URL wird zu einem eigenen Abonnement und wird regelmäßig abgerufen."
    override val addProxiesLabel = "Fertige Proxy-Links (feste Liste)"
    override val addProxiesHelp = "Füge eine Reihe von Links zu bestimmten Proxys ein (tg://proxy, https://t.me/proxy, …). Das ist KEIN Abonnement — die Liste wird nie heruntergeladen, die Proxys werden einfach zum Katalog hinzugefügt."
    override val addButton = "Hinzufügen"
    override fun addedFmt(subs: Int, proxies: Int) = "Hinzugefügt: ${subs} Abonnements, ${proxies} Proxys"
    override val perSecond = "pro Sek"
    override val graphSpeed = "Geschwindigkeit"
    override val graphVolume = "Volumen"
    override val graphLatency = "Ping"
    override val graphConnects = "Verbindungen"
    override val scanNow = "Jetzt scannen"; override val scanOnShort = "Scan an"
    override val scanRunning = "Scan läuft"; override val scanIdle = "Scan inaktiv"; override val scanOffState = "Scan AUS"; override val scanBatchPerThread = "Stapel/Thread"; override val scanPassHosts = "Hosts im Durchlauf"; override val minRescanLabel = "Einen Host nicht öfter als alle N Min erneut scannen"
    override val scanPlanTitle = "Plan"; override val scanNowTitle = "Jetzt"; override val currentScheduleTitle = "Aktueller Zeitplan"
    override val scheduleWord = "Zeitplan"; override val unitPcsPerSec = "Stk/s"
    override val scanNowThreadsLabel = "Aktuell laufende Threads"; override val scanNowPerThreadLabel = "Prüfungen pro Thread (Plan)"; override val scanNowElapsedLabel = "Laufzeit"
    override val scanOkGraph = "Erfolgreiche Scans"; override val scanFailGraph = "Fehlgeschlagene Scans"; override val scanTrafficGraph = "Scan-Verkehr"; override val scanAliveGraph = "Aktive Proxys gesamt"; override val scanPingGraph = "Ping"; override val threadsGraph = "Threads"
    override val scanEvery = "Alle"; override val scanNextRun = "Nächster Lauf"
    override val scanThreads = "Threads"; override val scanBatch = "Stapel"
    override val scanElapsed = "Laufend"; override val scanIdleNow = "—"
    override val effForFew = "Bei wenigen"; override val effForMany = "Bei vielen"
    override val effCheck = "Prüfung"; override val effBatch = "Stapel"; override val effPar = "Parallel"
    override val effContinuous = "kontinuierlich"; override val secShort = "s"; override val minShort = "Min"

    override val appTagline = "Plattformübergreifender Auto-Connector: findet, prüft und betreibt MTProto-Proxys, " +
        "über die Telegram funktioniert."
    override val version = "Version"; override val buildDate = "Build-Datum"
    override val downloadSources = "Download & Quellen"; override val openOnGithub = "Auf GitHub öffnen"
    override val feedbackBugs = "Feedback & Fehlerberichte"; override val writeTelegram = "Auf Telegram schreiben"

    override val language = "Sprache"; override val langAuto = "Automatisch (System)"; override val langRu = "Русский"; override val langEn = "English"
    override val langFa = "فارسی"; override val langZh = "简体中文"; override val langAr = "العربية"; override val langUr = "اردو"
    override val langTr = "Türkçe"; override val langId = "Bahasa Indonesia"; override val langHi = "हिन्दी"; override val langBn = "বাংলা"; override val langMy = "မြန်မာ"
    override val langWord = "Sprache"
    override val raceWidthTitle = "Parallele Verbindungen"
    override val connectionSection = "Verbindung & Blockadeumgehung"
    override val connectionSectionHelp = "Connect-Engine, parallele Upstreams, Proxy-Engine und Anti-DPI-Tricks — alles in einem Abschnitt."
    override val netLogSection = "Netzwerkaustausch-Protokoll"
    override val platform = "Plattform"

    override val scanModeTitle = "Netzwerkmodus"; override val scanModeAuto = "Auto"; override val scanModeManualLabel = "Manuell"
    override val activeModeLabel = "Aktiver Modus"; override val formingListLabel = "Liste wird erstellt"; override val catalogModeTabs = "Modus"
    override val resetModeRatings = "Host-Bewertungen zurücksetzen"; override val forgetModeHosts = "Modus-Hosts vergessen"
    override val exportModeTitle = "Export nach Modus"; override val modePickerTitle = "Modus"
    override val modeHelp = "Jeder Netzwerkmodus führt eigene Proxy-Bewertungen und eine eigene Scan- + Abonnement-Download-Intensität. \"Auto\" wählt den Modus anhand des aktiven Netzwerks. \"Manuell\" lässt dich jeden Modus selbst wählen (einschließlich White, das die Automatik nie auswählt)."
    override val autoSelect = "Automatische Auswahl"; override val manualSelect = "Manuelle Auswahl"
    override val connStatsTitle = "Verbindungen jetzt"; override val connOnPort = "Verbindungen auf Port"; override val outgoingConns = "Ausgehende Verbindungen"
    override val modeChoice = "Modus-Auswahl"; override val autoChoice = "automatische Auswahl"; override val manualChoice = "manuell fest"
    override val directOnVpn = "Direkte Verbindung zu TG bei VPN"; override val onWord = "an"; override val offWord = "aus"
    override val directStateActive = "aktiv"; override val directStateOff = "in Einstellungen aus"; override val directStateIdle = "in Einstellungen an, aber nicht aktiv"
    override val wpHintTitle = "Was ist White?"
    override val wpHint = "White — WhitePages: ein manuelles Netzwerkprofil. Nur von Hand aktiviert (die automatische Auswahl wählt es nie). " +
        "Führt eigene Host-Bewertungen, lädt Abonnements herunter und scannt unabhängig von VPN/Wi-Fi/LTE."

    override val recentAttempts = "Letzte Verbindungen & Prüfungen"
    override val kindCheck = "Prüfung"
    override val kindTg = "Telegram"
    override val histWho = "Wer"
    override val histWhen = "Wann"
    override val histReq = "Anfrage"
    override val histSess = "Sitzung"
    override val histScan = "Scan"
    override val testNow = "Jetzt testen"
    override val testShort = "Test"
    override val testResult = "Testergebnis"
    override val testStop = "Stopp"
    override val testingNow = "teste…"
    override val prewarmTitle = "Sockets vorwärmen (experimentell)"
    override val prewarmHelp = "Einige Upstream-Proxy-Sockets im Voraus verbunden halten, damit eine neue " +
        "Telegram-Verbindung den Connect/Handshake überspringen kann. Experimentell: Es verbindet sich " +
        "ständig im Hintergrund neu → verbraucht Datenverkehr und etwas CPU. Es wird kein gefälschter Verkehr " +
        "gesendet (das würde die echte Sitzung beschädigen) — die Sockets werden nur rotiert. Am nützlichsten mit FakeTLS-Proxys."
    override val prewarmEnable = "Vorwärmen aktivieren"
    override val prewarmModeDeferred = "Verzögert (nur TLS)"
    override val prewarmModeDeferredSub = "TCP + FakeTLS halten; die Initialisierung erst bei der Übergabe abschließen. Kein DC festgelegt — am realistischsten."
    override val prewarmModeFull = "Voller Handshake"
    override val prewarmModeFullSub = "Vollständig verbundene Sockets über verschiedene DCs halten; nur bei DC/Tag-Übereinstimmung wiederverwendet. Kürzere Lebensdauer."
    override val prewarmPoolLabel = "Sockets in Reserve"
    override val prewarmHoldLabel = "Halten, s"
    override val prewarmNote = "Nur Rotation (kein Keepalive auf App-Ebene). Ein Socket lebt Sekunden bis ~eine Minute, je nach Proxy/DC."
    override val prewarmStatus = "Vorwärmen"
    override fun prewarmStatusVal(ready: Int, holdSecs: Int) = "$ready bereit · halte ${holdSecs}s"
    override val prewarmStar = "Fett orange = Socket warm aus dem Vorwärm-Pool übergeben (Connect/Handshake übersprungen)"
    override fun prewarmTableTitle(holdSecs: Int) = "Sockets vorwärmen (halte ${holdSecs}s)"
    override val prewarmTableHelp = "\"Sockets vorwärmen\" öffnet einige Proxy-Sockets im Voraus, damit eine neue " +
        "Telegram-Verbindung den Connect/Handshake überspringen kann. Diese Tabelle listet die vorgewärmten Sockets auf: wie lange " +
        "jeder lebt, ob Telegram ihn nutzt, und den Verkehr. Ein-/ausschalten und konfigurieren (Modus, Anzahl der Sockets, " +
        "Haltezeit) kannst du unter \"Mehr → Einstellungen → \"Sockets vorwärmen (experimentell)\"\"."
    override val prewarmNoneWarming = "noch keine Sockets im Vorwärmen"
    override val prewarmColAge = "Alter"
    override val prewarmColUse = "in TG?"
    override val prewarmInUse = "in TG"
    override val prewarmNew = "neu"
    override val lanShareTitle = "Im LAN teilen (Webportal)"
    override val lanShareDesc = "Anderen Geräten in diesem Wi-Fi erlauben, diesen AutoConnector als Proxy zu nutzen; ein Browser, der die Adresse unten öffnet, erhält eine Seite mit den besten Proxys."
    override val lanShareUrlsLabel = "Nachbarn verbinden sich unter:"
    override val lanShareNoIp = "keine Adresse im lokalen Netzwerk — verbinde dich mit Wi-Fi"
    override val lanFirewallTitle = "Im lokalen Netzwerk erlauben"
    override val lanFirewallBody = "Das Aktivieren öffnet die Relay-Ports für dein lokales Netzwerk. Die Windows-Firewall (oder eine andere) fragt jetzt möglicherweise, ob AutoConnector erlaubt werden soll — wähle Zulassen / Ja. Wenn du es verweigerst, wird der Verkehr der Nachbarn zu AutoConnector blockiert und die Seite/der Proxy ist nicht erreichbar."
    override val lanFirewallConfirm = "Aktivieren"
    override val lanInfoTitle = "Wozu ist das?"
    override val lanInfoBody = "Führe AutoConnector auf EINEM Computer oder Telefon in deinem Wi-Fi aus, und jedes andere Gerät im selben Netzwerk — einschließlich eines iPhones, das diese App nicht direkt unterstützt — kann die Adresse einfach im Browser öffnen und nutzen: eine Seite mit den besten Proxys zum Hinzufügen in ihr Telegram, oder dieses Gerät selbst als SOCKS-Proxy. Ein Gerät findet und hält die Proxys, die übrigen leihen es sich über das LAN."
    override val volTriggerTitle = "Lautstärketasten-Auslöser"
    override val volTriggerSub = "Proxy mit einem schnellen Lautstärketasten-Muster wechseln"
    override val volEnableLabel = "Lautstärketasten überwachen"
    override val volHelpTitle = "Was ist das?"
    override val volHelpBody = "Unter Android gibt es keine globalen Tastatur-Hotkeys, daher werden stattdessen die LAUTSTÄRKE-Tasten verwendet. Wenn aktiviert, überwacht AutoConnector im Hintergrund ein schnelles Muster von Lauter/Leiser-Drücken (z.B. lauter-lauter-leiser-leiser). Erkennt es eines, öffnet es einen tg://-Link eines zufälligen guten, aktiven Proxys, damit Telegram ihn übernimmt und wechselt — eine schnelle, dezente Art, den Proxy zu rotieren, ohne die App zu öffnen. Die Lautstärke funktioniert weiterhin normal (die Tastendrücke werden nicht abgefangen). Dafür ist Accessibility-Zugriff nötig (um die Lautstärketasten im Hintergrund zu lesen und den Link zu öffnen); nichts wird angefragt, bis du den Schalter aktivierst. Stelle unten die maximale Zeit zwischen Tastendrücken ein; die erkannten Muster sind unten aufgeführt."
    override val volGrantTitle = "Accessibility aktivieren (wichtig)"
    override val volGrantBody = "Android (besonders 13+) blockiert Accessibility für Apps, die NICHT aus Google Play installiert wurden — deshalb ist AutoConnector ausgegraut und zeigt \"Eingeschränkte Einstellung\" / \"Zugriff nicht erlaubt\".\n\nSo entsperrst du:\n1. Öffne \"App-Info\" (Schaltfläche unten, oder: Einstellungen → Apps → AutoConnector for Telegram).\n2. Tippe auf das ⋮-Menü (oben rechts) → \"Eingeschränkte Einstellungen zulassen\" → bestätige.\n3. Geh zurück: Einstellungen → Accessibility → AutoConnector for Telegram → schalte es ein.\n\nWenn du \"Eingeschränkte Einstellungen zulassen\" nicht siehst, versuche zuerst, es einmal in Accessibility einzuschalten (du erhältst die Sperrmeldung), dann erscheint Schritt 2.\n\nBei Xiaomi/MIUI, Samsung usw. kann der Pfad leicht abweichen — suche nach demselben ⋮ in \"App-Info\". Bei Android 12 und älter gibt es meist keine Einschränkung — aktiviere es einfach in Accessibility.\n\nDie Lautstärketasten werden nur beobachtet, niemals blockiert."
    override val volOpenAppInfo = "App-Info öffnen"
    override val volAccessOn = "Accessibility: gewährt"
    override val volAccessOff = "Accessibility: nicht gewährt"
    override val volOpenAccess = "Accessibility-Einstellungen öffnen"
    override val volGapLabel = "Max. ms zwischen Tastendrücken"
    override val volPatternsTitle = "Erkannte Muster"
    override val volPatternPick = "Muster"
    override val volPatternsLegend = "↑ = lauter, ↓ = leiser"
    override val volNoRights = "Die App hat noch KEINE Berechtigung, die Lautstärketasten zu verarbeiten — erteile den Zugriff mit den Schritten am Ende dieser Seite."
    override val volGrantShort = "Noch kein Accessibility-Zugriff. Lies die ausführlichen Schritte am Ende dieser Seite und tippe dann auf \"Prüfen\"."
    override val volCheck = "Prüfen"
    override val volCheckOk = "✓ Fertig — Zugriff gewährt, der Auslöser funktioniert."
    override val volCheckFail = "✗ Immer noch kein Zugriff — führe die Schritte oben aus."
    override val volPatternsList = "↑↑↓↓ · ↓↓↑↑ · ↑↓↑↓ · ↓↑↓↑ · ↑↑↑↑ · ↓↓↓↓ · ↑↓↓↑ · ↓↑↑↓ · ↑↑↑↓↓↓ · ↓↓↓↑↑↑   (↑ = lauter, ↓ = leiser)"
    override val histLegend = "Spalten — Wer: ✓/✗ TG = echte Telegram-Verbindung, Scan = Hintergrundprüfung. Wann: vor wie lange. TCP/TLS/Anfrage: Handshake- & Erstanfrage-Latenz, ms. Sitzung: wie lange die Relay-Sitzung dauerte. ↓/↑: über den Host empfangene / gesendete Bytes."
    override val tgOkTotalHint = "Telegram-Verbindungen / erfolgreiche / gesamte Prüfungen"
    override val breadthTitle = "Breite der Host-Auswahl"
    override val breadthHelp = "Links = bei den besten bewährten Hosts bleiben; rechts = so breit wie möglich über alle aktiven Hosts probieren. Wenn Telegram ständig die Relay-Ports wechselt, erweitert die App die Suche automatisch."
    override val breadthNarrow = "bewährt"
    override val breadthWide = "am breitesten"
    override val connTimeoutTitle = "Connect-Timeout pro Host"
    override val connTimeoutHelp = "Wie lange auf einen Upstream (TCP + TLS + erste MTProto-Antwort) gewartet wird, bevor zum nächsten Proxy gewechselt wird."
    override val factoryResetDone = "Alles wurde zurückgesetzt. Bitte schließe die App und öffne sie erneut."

    // tray
    override val trayOpenWindow = "Fenster öffnen"
    override val trayRefreshSubs = "Abonnements aktualisieren"
    override val trayExit = "Beenden"
    override fun trayConnectorLabel(on: Boolean) =
        if (on) "Connector: AN (ausschalten)" else "Connector: AUS (einschalten)"
    override fun trayScanLabel(on: Boolean) =
        if (on) "Scan: AN (ausschalten)" else "Scan: AUS (einschalten)"
    override fun trayLive(n: Int) = "Aktive Proxys: ${n}"
    override val appearance = "Erscheinungsbild"
    override val themeLabel = "Design"
    override val themeAuto = "Automatisch (System folgen)"
    override val themeLight = "Hell"
    override val themeDark = "Dunkel"
    override val drawGraphsLabel = "Diagramme zeichnen"
    override val drawGraphsSub = "Live-Diagramme auf den Tabs Connector und Scan — zum Energiesparen ausschalten"
}
