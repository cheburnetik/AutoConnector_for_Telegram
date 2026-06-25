package io.autoconnector.i18n

object It : Strings {
    override val tabConnector = "Connettore"; override val tabScan = "Scansione"
    override val tabCatalog = "Catalogo"; override val tabLogs = "Log"; override val tabMore = "Altro"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "Abbonamenti"; override val logTabScan = "Scansione"
    override val logGeneral = "Generale"; override val logEmpty = "per ora vuoto"
    override val logSessions = "Sessioni"; override val logErrorsOnly = "solo errori"; override val logNoErrors = "nessuna sessione fallita"
    override fun logSession(id: String, port: String) = "#${id} · :${port}"
    override val back = "Indietro"; override val copy = "Copia"; override val gotIt = "Ho capito"
    override val later = "Più tardi"; override val details = "Dettagli"; override val whatIsThis = "Che cos'è?"
    override val delete = "Elimina"

    override val connector = "Connettore"; override val scan = "Scansione"
    override val notConfigured = "Non configurato! Risolvi →"; override val howToSetup = "Come configurare"
    override val notifOff = "Le notifiche sono disattivate! Risolvi →"; override val enable = "Attiva"
    override fun fewProxies(n: Int) = "Proxy attivi ${n}, ricerca in corso, attendi ~15 min…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "Proxy attivi: ${alive}  (15 min: ${within}) · totale: ${total}"
    override val notifWhyTitle = "Perché le notifiche?"
    override val notifWhyBody = "Un'icona di notifica permanente indica un servizio in primo piano di Android. " +
        "Senza di essa il sistema scarica l'app dalla memoria e questa smette di cercare proxy e " +
        "di mantenere la connessione in background. Per questo le notifiche sono necessarie affinché " +
        "AutoConnector funzioni."
    override val notifEnableTitle = "Attiva le notifiche"
    override val notifEnableBody = "Senza un'icona di notifica, Android considera l'app inattiva e " +
        "la scarica dalla memoria. Allora AutoConnector smette di cercare proxy e di mantenere la " +
        "connessione in background — Telegram perde il suo collegamento.\n\nTocca \"Attiva\" e consenti " +
        "le notifiche per AutoConnector."
    override val notifPlea = "Attiva le notifiche! Senza di esse l'app non può funzionare in background — " +
        "Android la scaricherà e la ricerca dei proxy e la connessione si fermeranno."

    override val statusConnected = "Telegram connesso"; override val statusConnecting = "Connessione…"
    override val statusOffline = "Telegram non connesso"; override val statusIdle = "Telegram inattivo"
    override val nobodyConnected = "Nessuno è connesso al Connettore. "; override val howToSetupArrow = "Come configurare →"
    override val directModeViaVpn = "Modalità diretta: VPN attiva — nessun proxy"
    override val directModeOff = "Modalità diretta: proxy disattivati"
    override val directDpiSuffix = " · anti-DPI"
    override val connections = "Connessioni"; override val sockets = "Socket"; override val speed = "Velocità"
    override val traffic = "Traffico"; override val latency = "Latenza"
    override fun pcs(n: Int) = "${n} pz"
    override fun netNow(label: String) = "Rete: ${label}"
    override fun tgToConnector(n: Int) = "TG→ ${n}"
    override fun connectorToProxy(n: Int) = "proxy ${n}"
    override val trafficSec = "traffico · 60 sec"; override val trafficMin = "traffico · 60 min"
    override val latencySec = "latenza · 60 sec"; override val latencyMin = "latenza · 60 min"
    override val sec60 = "60 sec"; override val min60 = "60 min"
    override val unitSec = "s"; override val unitMin = "m"; override val unitHour = "h"; override val dash = "—"
    override val currentProxy = "Proxy attuale"; override val noActiveProxy = "nessun proxy attivo (Telegram non connesso)"
    override val host = "Host"; override val type = "Tipo"; override val secret = "Segreto"; override val antiDpi = "Anti-DPI"; override val obfEngine = "Motore di offuscamento"
    override fun activeSockets(n: Int) = "Socket Telegram attivi: ${n}"
    override val noConnections = "nessuna connessione attiva"; override val colHost = "Host"; override val colTime = "Tempo"
    override val modeWord = "Modalità"; override val directViaVpnLine = "Richieste dirette a Telegram (VPN attiva)"
    override val connModeHelp = "Le modalità (VPN, Wi-Fi, LTE, Ethernet, Bianca) ti permettono di regolare l'intensità della scansione in modo diverso e di mantenere valutazioni/statistiche degli host separate. La scheda di rete viene rilevata automaticamente; la modalità può essere impostata manualmente nelle impostazioni."

    override val scanOff = "La scansione è disattivata"; override val proxiesInBase = "Proxy nel database"
    override val total = "totale"; override val alive = "attivi"; override val dead = "morti"
    override val tgConnectedTitle = "Telegram connesso tramite"; override val successful = "riusciti"
    override val socketsHeld = "Durata dei socket"; override val over1m = ">1 min"; override val over5m = ">5 min"; override val over15m = ">15 min"
    override val scanCountTitle = "Numero di controlli proxy"; override val checked = "Controllati"
    override val forAllTime = "in totale"; override val perMinute = "al minuto"; override val perHour = "all'ora"
    override val subsCountTitle = "Numero di download degli abbonamenti"; override val downloaded = "scaricati"; override val failed = "falliti"; override val scanTraffic = "traffico scansione"; override val subTraffic = "traffico abbonamenti"; override val subTrafficGraph = "Traffico abbonamenti"
    override val checksMtproto = "Controlli MTProto (↑ ok · ↓ falliti)"

    override fun catalogEmpty(mode: String) = "Il catalogo ${mode} è per ora vuoto. O non è stato trovato alcun host, oppure l'app non è mai stata eseguita in questa modalità. Puoi cambiare modalità nelle Impostazioni. Le modalità servono a raccogliere gli host separatamente per diversi tipi di connessione a internet."
    override val aliveShort = "✓ attivo"; override val deadShort = "✗ morto"
    override val statusLabel = "Stato"; override val rating = "Valutazione"; override val port = "Porta"
    override val rttPing = "RTT (ping)"; override val checkedField = "Controllato"; override val okOfTotal = "Controlli riusciti / totali"
    override val tgConnectedField = "Telegram connesso"; override val tgSessions = "Sessioni Telegram"; override val trafficThroughProxy = "Traffico attraverso il proxy"
    override val sessionsTotal = "Sessioni totali"; override val relayNow = "Relay ora"; override val tlsDomain = "Dominio TLS (SNI)"
    override val sourceSub = "Origine (abbonamento)"; override val lastError = "Ultimo errore"; override val yes = "sì"; override val no = "no"
    override val copyAsLink = "Copia come link"; override val openInTelegram = "Apri l'host in Telegram"; override val makeNextRelay = "Imposta come prossimo relay"
    override val actCopy = "Copia"; override val actOpen = "Apri"; override val actRelay = "Relay"
    override fun agoFmt(v: String) = "${v} fa"
    override val catalogTopFor = "Elenco/valutazione proxy per"
    override val catalogModeHelpTitle = "Modalità e valutazioni"
    override val catalogModeHelp = "L'app conta gli host attivi e le loro valutazioni SEPARATAMENTE per modalità di rete (VPN, Wi-Fi, LTE, Ethernet e Bianca). \"Bianca\" è una modalità MANUALE separata per le whitelist; la modalità automatica non vi passa mai. Quindi lo stesso host può essere attivo in una modalità e morto in un'altra."
    override fun catalogInactiveWarn(section: String, active: String) =
        "Stai visualizzando la sezione inattiva ${section} — tutte le statistiche in questo momento vanno a ${active}, non qui."
    override val manageModeTitle = "Gestisci modalità"
    override val manageResetRating = "Azzera valutazione"
    override fun manageResetHint(mode: String) = "Per ${mode} in particolare puoi azzerare la valutazione e le statistiche d'uso degli host attivi. È utile quando ti sei connesso a una VPN o LTE radicalmente diversa, così le vecchie statistiche non interferiscono. Oppure per osservare quanto velocemente la scansione proxy ricontrolla tutto da zero."
    override val manageDeleteAll = "Elimina gli host in"
    override fun manageDeleteHint(mode: String) = "Puoi cancellare sia la valutazione sia gli host stessi da ${mode}. La funzione \"Scansiona proxy\" li raccoglierà di nuovo. Non è un azzeramento degli abbonamenti — puoi toccarlo, poi attendere ~15 minuti per una nuova scansione."
    override fun manageCopyFrom(mode: String) = "Copia tutti gli host e le valutazioni in questa modalità (${mode}) da un'altra modalità:"
    override val live = "attivi"; override val deadW = "morti"; override val unitMs = "ms"
    override val agoMin = "m"; override val agoHour = "h"; override val agoDay = "g"

    override val connectTelegram = "Connessione di Telegram"; override val readCarefully = "Leggi con attenzione!"
    override val guideIntro = "Questa app non funzionerà senza configurazione. Scegli una qualsiasi delle 3 opzioni qui sotto " +
        "e segui attentamente le istruzioni."
    override val variant1 = "Opzione #1 — pulsanti"
    override val variant1Body = "Tocca \"Proxy {A}\" — Telegram si apre, conferma l'aggiunta del proxy. Torna " +
        "a questa schermata e tocca \"Proxy {B}\" — conferma l'aggiunta una seconda volta.\n\nDisattiva eventuali " +
        "altri vecchi proxy in Telegram. Devono rimanere esattamente 2 proxy — con le porte {A} e {B}. " +
        "Con qualsiasi altra configurazione AutoConnector non funzionerà."
    override val variant2 = "Opzione #2 — link"
    override val variant2Body = "Copia il testo qui sotto nei Messaggi salvati (o in qualsiasi chat) in Telegram — " +
        "cioè invialo a te stesso. Tocca il primo link nel tuo messaggio — il primo proxy viene aggiunto. " +
        "Tocca il secondo link — viene aggiunto il secondo. Poi disattiva tutti i vecchi proxy."
    override val variant3 = "Opzione #3 — manualmente"
    override val variant3Body = "Aggiungi manualmente un proxy SOCKS5: server localhost (127.0.0.1), porta {A}. " +
        "Poi un secondo proxy: localhost, porta {B}. Elimina eventuali vecchi proxy."
    override val whatNext = "E adesso?"
    override val whatNextBody = "In Telegram, attiva \"cambio automatico del proxy\" — 5 secondi. Puoi aiutare " +
        "Telegram a connettersi toccando manualmente un proxy (dentro Telegram) che NON è attivo o è contrassegnato come " +
        "\"non disponibile\" — questo fa sì che Telegram si impegni di più a connettersi.\n\nAssicurati che tutti gli altri vecchi " +
        "proxy siano rimossi, eccetto {A} e {B}. Tocca " +
        "\"Usa proxy\" in Telegram.\n\nAttendi mentre l'app trova e scarica abbastanza proxy " +
        "(5–15 minuti). Poi Telegram si connette ad AutoConnector da solo, che continuerà a instradare " +
        "Telegram attraverso i migliori proxy: verificati, attivi e veloci.\n\nSe le istruzioni sembrano " +
        "difficili — ci dispiace, non potrai usare l'app: è impossibile configurare tutto " +
        "automaticamente, e trovare proxy attivi richiede tempo.\n\nSe hai scaricato l'app molto tempo fa " +
        "e non è stato trovato alcun proxy attivo — aggiorna l'app oppure l'elenco degli abbonamenti. Questa app " +
        "non inventa né fornisce proxy propri, si limita a cercare in internet tra decine " +
        "di gruppi e pagine."
    override fun proxyBtn(port: Int) = "Proxy ${port}"

    override val setupPortsTitle = "Configura le porte in Telegram"
    override val setupPortsSub = "Come connettere Telegram al Connettore (porte 55001/55002)"
    override val settings = "Impostazioni"; override val settingsSub = "Porte, anti-DPI, scansione, rete, batteria"
    override val subscriptions = "Abbonamenti"; override val subscriptionsSub = "Origini proxy da scansionare"
    override val statistics = "Statistiche"; override val statisticsSub = "Database proxy + trucchi anti-DPI"
    override val export = "Esporta"; override val exportSub = "link tg:// dei proxy attivi"
    override val about = "Informazioni"; override val aboutSub = "Versione, build, download, feedback"
    override val hotkeys = "Scorciatoie"
    override val hotkeysSub = "Tasti globali: copia / apri un proxy"
    override val hotkeysIntro = "Le scorciatoie globali si attivano anche quando la finestra dell'app non è a fuoco. Scelgono un " +
        "link proxy attivo casuale (tg://) dal pool — utile per cambiare proxy rapidamente senza " +
        "aprire l'app."
    override val hotkeysNote = "Su macOS, la cattura dei tasti potrebbe richiedere l'autorizzazione di Accessibilità " +
        "(Impostazioni di sistema → Privacy e sicurezza → Accessibilità)."
    override val hotkeyCopyTitle = "Copia link proxy"
    override val hotkeyCopyDesc = "Mette negli appunti un link tg:// attivo casuale."
    override val hotkeyEnable = "Attiva scorciatoie"; override val hotkeyLetterLabel = "Lettera"; override val hotkeySet = "Imposta"; override val hotkeyReset = "Reimposta"
    override val hotkeyOpenTitle = "Apri proxy in Telegram"
    override val hotkeyOpenDesc = "Apre un link attivo casuale — Telegram lo intercetta e propone di connettere il proxy."

    override val relayPorts = "Porte relay"
    override val relayPortsHelp = "Porte locali su cui il Connettore è in ascolto. Inserisci esattamente queste in " +
        "Telegram come proxy SOCKS5 (127.0.0.1 : porta). Si usano due porte per affidabilità — Telegram " +
        "mantiene le connessioni a entrambe."
    override val portA = "Porta A"; override val portB = "Porta B"
    override val antiDpiTrick = "Trucco anti-DPI"
    override val antiDpiHelp = "Un modo per mascherare la connessione affinché l'ISP/DPI non la riconosca e " +
        "la blocchi.\n• \"Rotazione automatica\" sceglie da solo un trucco funzionante.\n• \"Nessun trucco DPI\" — una connessione " +
        "semplice.\n• Gli altri sono tecniche specifiche (imitazione del browser, frammentazione dei pacchetti, ecc.)."
    override val onlyFakeTls = "Solo FakeTLS (ee)"
    override val applyDpiTo = "Applica anti-DPI a"
    override val applyDpiHelp = "A cosa applicare il trucco anti-DPI scelto:\n• Relay Telegram — alla " +
        "connessione Telegram attiva tramite il Connettore.\n• Sonde proxy — ai controlli proxy in background " +
        "(così un controllo si comporta esattamente come una connessione reale, e le statistiche dei trucchi sono più accurate).\n" +
        "• In connessione diretta — quando i proxy sono disattivati (o saltati mentre una VPN è attiva) e Telegram " +
        "va dritto ai suoi server: qui non c'è proxy, quindi il trucco si riduce a frammentare il " +
        "primo pacchetto TCP (l'handshake) in diversi piccoli segmenti, così il DPI non può individuarlo in una sola lettura."
    override val toRelay = "Relay Telegram"; override val toProbes = "Sonde proxy"
    override val toDirect = "In connessione diretta"
    override val vpnSection = "Quando la VPN è attiva"
    override val vpnHelp = "Cosa fare quando una VPN è attiva sul dispositivo:\n• Tramite proxy MTProto — " +
        "Telegram passa attraverso i proxy trovati come al solito (sopra la VPN).\n• Direttamente — il " +
        "Connettore NON usa i proxy e connette Telegram direttamente ai server di Telegram: la " +
        "VPN fornisce già l'accesso, il livello proxy aggiuntivo non serve (più veloce e più stabile). " +
        "Senza una VPN i proxy vengono usati come al solito."
    override val linkFormat = "Formato link proxy"
    override val linkFormatHelp = "Come copiare e aprire i proxy. tg:// apre Telegram direttamente (richiede Telegram Desktop installato). http (t.me) apre tramite browser e propone di aprire in Telegram — utile se tg:// non è registrato."
    override val linkTg = "tg:// (apre Telegram direttamente)"; override val linkTgSub = "tg://proxy?… — apre Telegram"
    override val linkHttp = "http (t.me, via browser)"; override val linkHttpSub = "https://t.me/proxy?… — apre il browser"
    override val viaMtproto = "Proxy via MTProto"; override val viaMtprotoSub = "anche con VPN, il traffico passa attraverso i proxy"
    override val directly = "Connetti direttamente"; override val directlySub = "con VPN attiva — aggira i proxy, dritto a Telegram"
    override val notifications = "Notifiche"
    override val scanCheck = "Scansiona e controlla"
    override val scanCheckHelp = "• Scansione, min — ogni quanto scaricare gli elenchi proxy dagli abbonamenti.\n" +
        "• Controllo, min — ogni quanto ricontrollare la vitalità dei proxy nel database.\n• Dimensione lotto — " +
        "quanti proxy controllare per esecuzione.\n• Parallelo — quanti controlli eseguire contemporaneamente (più = " +
        "più veloce, ma maggior carico su rete e batteria)."
    override val scanMin = "Scansione, min"; override val checkMin = "Controllo, min"; override val batchSize = "Dimensione lotto"; override val parallel = "Parallelo"
    override val speedByNet = "Intensità scansione per rete"
    override val speedByNetHelp = "Ogni quanto controllare i proxy a seconda della rete attuale. " +
        "\"Standard\" = intervallo base. Sposta a destra per controlli più rari (più lenti, più delicati su traffico/batteria), " +
        "a sinistra per più frequenti (più veloci, più aggressivi). Scala logaritmica, fino a ×100 in ciascun senso.\n" +
        "• VPN — quando una VPN esterna è attiva.\n• Wi-Fi — su una rete Wi-Fi.\n• LTE — su una rete mobile."
    override val intensStandard = "standard"
    override val intensSlower = "più lento"
    override val intensFaster = "più veloce"
    override val maintenance = "Azzera dati"
    override val maintenanceHelp = "• \"Azzera catalogo e statistiche\" — azzera valutazioni, contatori, traffico " +
        "e log dei controlli, ma mantiene gli host scaricati e gli abbonamenti (tutto viene rivalutato " +
        "alla prossima scansione).\n• \"Cancella host scaricati\" — elimina l'intero pool di proxy ma mantiene " +
        "gli abbonamenti, così la scansione riempie di nuovo il pool. Gli abbonamenti non vengono mai toccati in nessun caso."
    override val backupTitle = "Esporta / Importa"
    override val backupHelp = "Salva o ripristina i dati dell'app come JSON. Spunta cosa " +
        "includere — qualsiasi combinazione:\n• Impostazioni — tutti i parametri dell'app.\n• Abbonamenti — l'elenco delle origini " +
        "(URL + on/off).\n• Catalogo host attivi — ogni proxy attivo con le sue valutazioni e statistiche " +
        "PER modalità di rete.\n\n\"Esporta\" apre una pagina con il JSON pronto — copialo o salvalo in un file. " +
        "\"Importa\" — incolla il JSON (o carica un file) e applica solo le sezioni spuntate presenti " +
        "in esso. L'importazione AGGIUNGE ai dati attuali (nessuna cancellazione)."
    override val backupSettings = "Impostazioni"
    override val backupSubs = "Abbonamenti"
    override val backupHosts = "Catalogo host attivi (per modalità)"
    override val exportWord = "Esporta"
    override val importWord = "Importa"
    override val backupExportTitle = "Esporta dati"
    override val backupImportTitle = "Importa dati"
    override val backupSelectExport = "Cosa esportare:"
    override val backupSelectImport = "Cosa importare:"
    override val backupCopyBtn = "Copia"
    override val backupSaveFile = "Salva su file"
    override val backupLoadFile = "Carica da file"
    override val backupDoImport = "Importa"
    override val backupPasteLabel = "Incolla qui il JSON del backup"
    override val backupJsonLabel = "JSON del backup"
    override val backupAndroidFileNote = "I file non sono disponibili qui — usa Copia / Incolla."
    override val eraseAllHosts = "Cancella tutti gli host"
    override val factoryReset = "Reimposta tutto (come al primo avvio)"
    override val factoryResetConfirm = "Reimpostare completamente l'app allo stato di fabbrica? TUTTE le impostazioni e l'intero " +
        "catalogo degli host verranno cancellati, gli abbonamenti ripristinati ai valori predefiniti. Proprio come al primo avvio."
    override val resetCatalog = "Azzera catalogo e statistiche"
    override val resetCatalogConfirm = "Azzerare tutte le valutazioni, i contatori e i log dei controlli? " +
        "Gli host scaricati e gli abbonamenti vengono mantenuti e rivalutati alla prossima scansione."
    override val clearHosts = "Cancella host scaricati"
    override val clearHostsConfirm = "Eliminare l'intero elenco degli host (proxy) scaricati? " +
        "Gli abbonamenti vengono mantenuti e la scansione riempirà di nuovo il pool."
    override val doReset = "Reimposta"
    override val doCancel = "Annulla"
    override val adaptiveSpeed = "Velocità adattiva"
    override val adaptiveHelp = "I controlli di vitalità vengono eseguiti a un intervallo base (da \"Scansiona e controlla\", anche " +
        "moltiplicato per il moltiplicatore di rete). \"Velocità adattiva\" li accelera o li rallenta " +
        "automaticamente in base a quanti proxy sono attivi al momento.\n\n" +
        "• POCHI attivi (sotto la soglia \"Pochi\") → intervallo × \"Accelera\". Un moltiplicatore inferiore a 1 = più " +
        "spesso: 0.5 — il doppio delle volte, 0.25 — 4×. Riempie il pool più velocemente.\n" +
        "• MOLTI attivi (sopra la soglia \"Molti\") → intervallo × \"Rallenta\". Sopra 1 = più raro: 2 — " +
        "metà delle volte, 4 — un quarto. Risparmia batteria e traffico.\n" +
        "• Tra le soglie — velocità base (×1).\n\n" +
        "Esempi:\n" +
        "— Raccogliere proxy più velocemente: \"Accelera\" 0.25 e/o soglia \"Pochi\" 40.\n" +
        "— Risparmiare batteria quando ne hai abbastanza: \"Rallenta\" 8 e/o soglia \"Molti\" 30.\n" +
        "— Disattivare l'adattamento: imposta entrambi i moltiplicatori a 1.\n\n" +
        "Valori predefiniti: Pochi 20, Accelera 0.5, Molti 50, Rallenta 4."
    override val threshMany = "Soglia \"Molti\""; override val threshFew = "Soglia \"Pochi\""; override val mulFast = "Accelera ×"; override val mulLazy = "Rallenta ×"
    override val subIntensityTitle = "Intensità abbonamenti"
    override val subIntensityHint = "Pausa tra i download degli abbonamenti: quanti minuti prima di riscaricare gli elenchi proxy (separatamente per modalità di rete)."
    override val baseScanTitle = "Velocità di scansione base"
    override val baseScanHelp = "La velocità di riferimento del controllo di vitalità. \"Velocità adattiva\" e i moltiplicatori \"Velocità per " +
        "modalità\" sono calcolati rispetto a essa.\n\n" +
        "• Ogni quanto eseguire, min — intervallo tra i passaggi di controllo.\n" +
        "• Lotto per thread, host — quanti host controlla ogni thread per passaggio.\n" +
        "• Thread — quanti controlli vengono eseguiti contemporaneamente. Un passaggio sonda \"lotto × thread\" host.\n" +
        "• Non riscansionare un host più spesso di ogni N min — anti-flood: un host controllato di recente viene " +
        "saltato in questo passaggio.\n\n" +
        "Più thread e un lotto più grande = crescita del pool più veloce, ma carico maggiore su rete e batteria."
    override val baseScanPeriod = "Ogni quanto eseguire, min"
    override val baseScanBatch = "Lotto per thread, host"; override val baseScanThreads = "Numero di thread"
    override val adaptiveDesc = "Se i proxy attivi sono meno di \"pochi\" o più di \"molti\", applica un moltiplicatore aggiuntivo."
    override val fewWord = "Pochi"; override val manyWord = "Molti"
    override fun fasterX(x: String) = "${x}× più veloce"
    override fun slowerX(x: String) = "${x}× più lento"
    override fun ifAliveLt(n: Int) = "Se i proxy attivi < ${n}, allora:"
    override fun ifAliveGt(n: Int) = "Se i proxy attivi > ${n}, allora:"
    override val disabledWord = "disattivato"
    override val speedByModeTitle = "Velocità per modalità"
    override val speedByModeHelp = "Un moltiplicatore della velocità di scansione per ogni modalità di rete, oltre alla velocità " +
        "base. \"Standard\" (×1) = l'intervallo base. Destra — più raro (più lento, più delicato su traffico/" +
        "batteria), sinistra — più spesso (più veloce, più aggressivo). Scala logaritmica, fino a ×100 in ciascun " +
        "senso.\n\n" +
        "Sotto ogni cursore ci sono i parametri di passaggio risultanti con la velocità adattiva applicata — " +
        "mostrati separatamente per \"pochi attivi\" (× \"Accelera\") e \"molti attivi\" (× \"Rallenta\").\n\n" +
        "Modalità:\n• VPN — una VPN esterna è attiva.\n• LTE — rete mobile.\n• Wi-Fi — rete Wi-Fi.\n" +
        "• Ethernet — connessione cablata.\n• Bianca — modalità proxy \"bianca\" manuale."
    override val aliveLt = "attivi <"; override val aliveGt = "attivi >"
    override val periodWord = "periodo"; override val nonstopWord = "non-stop"
    override val batchWord = "lotto"; override val threadsWord = "thread"; override val scanModeOff = "scansione off"
    override val netBattery = "Rete e batteria"
    override val netBatteryHelp = "• Solo Wi-Fi — non scansionare su reti mobili (risparmia dati).\n• Solo in " +
        "carica — funziona solo mentre il telefono è in carica.\n• Salta con batteria scarica — sospendi la scansione quando la " +
        "batteria è bassa."
    override val onlyWifi = "Solo Wi-Fi"; override val onlyCharging = "Solo in carica"; override val skipLowBattery = "Salta con batteria scarica"
    override val autosaved = "Le impostazioni vengono salvate automaticamente."
    override val dpiAutoLabel = "Rotazione automatica trucchi DPI"; override val dpiNoneLabel = "Nessun trucco DPI (semplice)"
    override val experimental = "Sperimentale"
    override val experimentalHelp = "Motori di proxy alternativi all'upstream MTProto più un log diagnostico. " +
        "Il percorso di riferimento (funzionante) resta invariato quando impostato su \"Off\". Cambia solo COME il flusso cifrato viene scritto " +
        "sul socket TCP upstream (dimensioni dei segmenti, tempistiche, confini dei record TLS) — il flusso stesso resta identico byte per byte. " +
        "Si applica solo al relay proxy attivo (non alle sonde, non al percorso diretto)."
    override val expEngineTitle = "Motore di proxy (offuscamento socket)"
    override val expConnectTitle = "Motore di connessione (selezione upstream)"
    override val expEngineWarn = "⚠ Modalità sperimentale. Se la connettività peggiora, torna a \"Off (percorso di riferimento)\"."
    override val netLog = "Attiva log dello scambio di rete"
    override val netLogSub = "Scrive CHI-A-CHI-QUANDO e le dimensioni dei pacchetti in un file (NESSUN dato di payload) — " +
        "per confrontare il pattern dello scambio con e senza una VPN."
    override val openLogFolder = "Apri cartella dei log"; override val copyPath = "Copia percorso"
    override val helpShow = "Aiuto"; override val helpHide = "Nascondi aiuto"
    override val quickSwitchIntro = "Qui puoi scegliere un trucco per aggirare i blocchi. Se Telegram mostra l'errore " +
        "\"The proxy you are using is not configured correctly and will be disabled. Please find another " +
        "one\", sperimenta quale tipo di offuscamento del traffico funziona affinché Telegram smetta di mostrarlo. Inizia " +
        "con le modalità split*. Anche le modalità coalesce* funzionano, ma con esse immagini/video si caricano male in Telegram."
    override val quickSwitchTitle ="Aggiramento blocchi"; override val quickSwitchSub = "Shaping, connessione, anti-DPI"

    override val sourceUrl = "URL origine"
    override fun sourceAlive(alive: Int, total: Int) = "attivi ${alive}/${total}"
    override val open = "Apri"; override val active = "Attivo"; override val inactive = "Inattivo"
    override val lastDownloaded = "Scaricato"; override val notDownloaded = "non ancora scaricato"
    override fun sourceCounts(dead: Int, total: Int) =
        " attivi, ${dead} morti, ${total} totali"

    override val proxyBase = "Database proxy"
    override val totalInBase = "Totale nel database"; override val aliveNow = "Attivi ora"; override val deadStat = "Morti"
    override val aliveIn15 = "Attivi in 15 min"; override val checksAllTime = "Controlli totali"
    override val antiDpiTricks = "Trucchi anti-DPI"; override val noStatsYet = "ancora nessun dato — i trucchi si accumulano con i controlli/le connessioni"
    override val attempts = "Tentativi"; override val handshake = "Handshake"; override val score = "Punteggio"
    override val tgConnect = "Connessione TG"; override val socketsOver1m = "Socket >1min"
    override val over10kb = "Socket >10KB"; override val over100kb = ">100KB"; override val workTime = "Tempo di lavoro"
    override val statsLegend = "Handshake — handshake riusciti (% dei tentativi) · Punteggio — valore · " +
        "\"Tempo di lavoro\" — totale sui socket ≥5KB e più lunghi di 1 minuto."
    override val resetStats = "Azzera statistiche dei trucchi"

    override fun aliveLinks(n: Int) = "Link attivi: ${n}"
    override val copyAll = "Copia tutto"
    override val openRandom = "Apri casuale"; override val copyRandom = "Copia casuale"; override val allShort = "TUTTI"
    override val copyTop = "Copia TOP"; override val randomHost = "Host casuale"
    override val exportToFile = "Esporta su file"; override val exportSaved = "Salvato su file:"
    override val dlNow = "Scarica ora"
    override fun downloadingFmt(sec: Long) = "Download… ${sec}s"
    override val cancel = "Annulla"
    override val deleteConfirmTitle = "Eliminare l'abbonamento?"
    override val subscriptionsAddHint = "Aggiungi abbonamenti o link proxy →"
    override val addSourcesTitle = "Aggiungi"
    override val addSubsLabel = "Abbonamenti (un URL per riga)"
    override val addSubsHelp = "Ogni riga con un URL valido diventa un abbonamento a sé e viene scaricata periodicamente."
    override val addProxiesLabel = "Link proxy pronti (elenco fisso)"
    override val addProxiesHelp = "Incolla un gruppo di link a proxy specifici (tg://proxy, https://t.me/proxy, …). Questo NON è un abbonamento — l'elenco non viene mai scaricato, i proxy vengono semplicemente aggiunti al catalogo."
    override val addButton = "Aggiungi"
    override fun addedFmt(subs: Int, proxies: Int) = "Aggiunti: ${subs} abbonamenti, ${proxies} proxy"
    override val perSecond = "al sec"
    override val graphSpeed = "Velocità"
    override val graphVolume = "Volume"
    override val graphLatency = "Ping"
    override val graphConnects = "Connessioni"
    override val scanNow = "Scansiona ora"; override val scanOnShort = "Scansione on"
    override val scanRunning = "Scansione in corso"; override val scanIdle = "Scansione inattiva"; override val scanOffState = "Scansione OFF"; override val scanBatchPerThread = "Lotto/thread"; override val scanPassHosts = "Host nel passaggio"; override val minRescanLabel = "Non riscansionare un host più spesso di ogni N min"
    override val scanPlanTitle = "Piano"; override val scanNowTitle = "Ora"; override val currentScheduleTitle = "Programmazione attuale"
    override val scheduleWord = "Programmazione"; override val unitPcsPerSec = "pz/s"
    override val scanNowThreadsLabel = "Thread in esecuzione ora"; override val scanNowPerThreadLabel = "Controlli per thread (piano)"; override val scanNowElapsedLabel = "Tempo di esecuzione"
    override val scanOkGraph = "Scansioni riuscite"; override val scanFailGraph = "Scansioni fallite"; override val scanTrafficGraph = "Traffico scansione"; override val scanAliveGraph = "Proxy attivi totali"; override val scanPingGraph = "Ping"; override val threadsGraph = "Thread"
    override val scanEvery = "Ogni"; override val scanNextRun = "Prossima esecuzione"
    override val scanThreads = "Thread"; override val scanBatch = "Lotto"
    override val scanElapsed = "In esecuzione"; override val scanIdleNow = "—"
    override val effForFew = "Quando pochi"; override val effForMany = "Quando molti"
    override val effCheck = "Controllo"; override val effBatch = "Lotto"; override val effPar = "Parallelo"
    override val effContinuous = "continuo"; override val secShort = "s"; override val minShort = "min"

    override val appTagline = "Connettore automatico multipiattaforma: trova, controlla ed esegue proxy MTProto " +
        "attraverso cui Telegram funziona."
    override val version = "Versione"; override val buildDate = "Data build"
    override val downloadSources = "Download e origini"; override val openOnGithub = "Apri su GitHub"
    override val feedbackBugs = "Feedback e segnalazione bug"; override val writeTelegram = "Scrivi su Telegram"

    override val language = "Lingua"; override val langAuto = "Automatica (sistema)"; override val langRu = "Русский"; override val langEn = "English"
    override val langFa = "فارسی"; override val langZh = "简体中文"; override val langAr = "العربية"; override val langUr = "اردو"
    override val langTr = "Türkçe"; override val langId = "Bahasa Indonesia"; override val langHi = "हिन्दी"; override val langBn = "বাংলা"; override val langMy = "မြန်မာ"
    override val langWord = "Lingua"
    override val raceWidthTitle = "Connessioni parallele"
    override val connectionSection = "Connessione e aggiramento blocchi"
    override val connectionSectionHelp = "Motore di connessione, upstream paralleli, motore di proxy e trucchi anti-DPI — tutto in un'unica sezione."
    override val netLogSection = "Log scambio di rete"
    override val platform = "Piattaforma"

    override val scanModeTitle = "Modalità di rete"; override val scanModeAuto = "Automatica"; override val scanModeManualLabel = "Manuale"
    override val activeModeLabel = "Modalità attiva"; override val formingListLabel = "Costruzione elenco"; override val catalogModeTabs = "Modalità"
    override val resetModeRatings = "Azzera valutazioni host"; override val forgetModeHosts = "Dimentica host modalità"
    override val exportModeTitle = "Esporta per modalità"; override val modePickerTitle = "Modalità"
    override val modeHelp = "Ogni modalità di rete mantiene le proprie valutazioni proxy e la propria intensità di scansione + download abbonamenti. \"Automatica\" sceglie la modalità dalla rete attiva. \"Manuale\" ti permette di scegliere tu stesso qualsiasi modalità (inclusa Bianca, che la modalità automatica non seleziona mai)."
    override val autoSelect = "Selezione automatica"; override val manualSelect = "Selezione manuale"
    override val connStatsTitle = "Connessioni ora"; override val connOnPort = "Connessioni sulla porta"; override val outgoingConns = "Connessioni in uscita"
    override val modeChoice = "Selezione modalità"; override val autoChoice = "selezione automatica"; override val manualChoice = "fissa manuale"
    override val directOnVpn = "Connessione diretta a TG su VPN"; override val onWord = "on"; override val offWord = "off"
    override val directStateActive = "attiva"; override val directStateOff = "disattivata nelle impostazioni"; override val directStateIdle = "attiva nelle impostazioni, ma non operativa"
    override val wpHintTitle = "Cos'è Bianca?"
    override val wpHint = "Bianca — WhitePages: un profilo di rete manuale. Attivata solo a mano (la selezione automatica non la sceglie mai). " +
        "Mantiene le proprie valutazioni degli host, scarica abbonamenti e scansiona indipendentemente da VPN/Wi-Fi/LTE."

    override val recentAttempts = "Connessioni e controlli recenti"
    override val kindCheck = "controllo"
    override val kindTg = "telegram"
    override val histWho = "Chi"
    override val histWhen = "Quando"
    override val histReq = "Richiesta"
    override val histSess = "Sessione"
    override val histScan = "scansione"
    override val testNow = "Testa ora"
    override val testShort = "Test"
    override val testResult = "Risultato del test"
    override val testStop = "Stop"
    override val testingNow = "test in corso…"
    override val prewarmTitle = "Pre-riscaldamento socket (sperimentale)"
    override val prewarmHelp = "Mantieni alcuni socket proxy upstream già connessi in anticipo, così una nuova " +
        "connessione Telegram può saltare il connect/handshake. Sperimentale: il background si riconnette " +
        "di continuo → consuma traffico e un po' di CPU. Non viene inviato traffico finto (romperebbe la " +
        "sessione reale) — i socket vengono semplicemente ruotati. Più utile con i proxy FakeTLS."
    override val prewarmEnable = "Attiva il pre-riscaldamento"
    override val prewarmModeDeferred = "Differito (solo TLS)"
    override val prewarmModeDeferredSub = "Manteniamo TCP + FakeTLS; l'obfuscated2-init viene completato al passaggio. Nessun DC vincolato — il più realistico."
    override val prewarmModeFull = "Handshake completo"
    override val prewarmModeFullSub = "Manteniamo socket completamente connessi su diversi DC; riutilizzati solo se DC/tag coincidono. Durano meno."
    override val prewarmPoolLabel = "Socket di riserva"
    override val prewarmHoldLabel = "Mantieni ciascuno, s"
    override val prewarmNote = "Solo rotazione (nessun keepalive a livello di app). Un socket dura da pochi secondi a ~un minuto, a seconda del proxy/DC."
    override val prewarmStatus = "Pre-riscaldamento"
    override fun prewarmStatusVal(ready: Int, holdSecs: Int) = "$ready pronti · tengo per ${holdSecs}s"
    override val prewarmStar = "Arancione in grassetto = socket consegnato caldo dal pool di pre-riscaldamento (saltato connect/handshake)"
    override fun prewarmTableTitle(holdSecs: Int) = "Pre-riscaldamento socket (tengo per ${holdSecs}s)"
    override val prewarmTableHelp = "«Pre-riscaldamento socket» apre in anticipo alcuni socket verso il proxy, così una nuova " +
        "connessione Telegram può saltare il connect/handshake. Questa tabella elenca i socket in riscaldamento: quanti secondi " +
        "vive ciascun socket, se Telegram lo sta usando e il traffico. Puoi attivarlo/disattivarlo e configurarlo (modalità, numero " +
        "di socket, tempo di mantenimento) in «Altro → Impostazioni → „Pre-riscaldamento socket (sperimentale)“»."
    override val prewarmNoneWarming = "ancora nessun socket in riscaldamento"
    override val prewarmColAge = "età"
    override val prewarmColUse = "in TG?"
    override val prewarmInUse = "in TG"
    override val prewarmNew = "nuovo"
    override val lanShareTitle = "Condivisione sulla rete locale (portale web)"
    override val lanShareDesc = "Consenti ad altri dispositivi su questo Wi-Fi di usare questo AutoConnector come proxy; un browser che apre l'indirizzo qui sotto riceve una pagina con i migliori proxy."
    override val lanShareUrlsLabel = "I vicini di rete si connettono a:"
    override val lanShareNoIp = "nessun indirizzo nella rete locale — connettiti al Wi-Fi"
    override val lanFirewallTitle = "Consenti sulla rete locale"
    override val lanFirewallBody = "Attivandolo, le porte del relay si apriranno sulla tua rete locale. Il firewall di Windows (o un altro) potrebbe ora chiedere se consentire AutoConnector — scegli «Consenti»/«Sì». Se lo rifiuti, il traffico dei vicini verso AutoConnector sarà bloccato e la pagina/il proxy non saranno raggiungibili."
    override val lanFirewallConfirm = "Attiva"
    override val lanInfoTitle = "A cosa serve?"
    override val lanInfoBody = "Esegui AutoConnector su UN SOLO computer o telefono nel tuo Wi-Fi — e tutti gli altri dispositivi sulla stessa rete, incluso un iPhone (che l'app non supporta direttamente), potranno semplicemente aprire l'indirizzo in un browser e usarlo: una pagina con i migliori proxy da aggiungere al loro Telegram, oppure questo stesso dispositivo come proxy SOCKS. Un dispositivo trova e mantiene i proxy, gli altri lo usano tramite la rete locale."
    override val volTriggerTitle = "Attivazione con i tasti del volume"
    override val volTriggerSub = "Cambia proxy con una sequenza rapida dei tasti del volume"
    override val volEnableLabel = "Monitora i tasti del volume"
    override val volHelpTitle = "Che cos'è?"
    override val volHelpBody = "Su Android non ci sono scorciatoie da tastiera globali, quindi si usano i tasti del VOLUME. Quando è attivo, AutoConnector monitora in background una sequenza rapida di pressioni volume-su/giù (ad esempio su-su-giù-giù). Riconosciuta la sequenza, apre un link tg:// di un proxy attivo e valido a caso — Telegram lo intercetta e cambia. Un modo rapido e discreto per ruotare i proxy senza aprire l'app. Il volume continua a funzionare normalmente (le pressioni non vengono intercettate). Serve l'accesso all'Accessibility (per leggere i tasti in background e aprire il link); non viene richiesto nulla finché non attivi l'opzione. Imposta qui sotto il tempo massimo tra le pressioni; le sequenze riconosciute sono elencate in fondo."
    override val volGrantTitle = "Attiva l'Accessibility (importante)"
    override val volGrantBody = "Android (specialmente 13+) blocca l'Accessibility per le app installate NON da Google Play — per questo AutoConnector è disattivato e mostra «Impostazione con restrizioni» / «accesso non consentito».\n\nCome sbloccare:\n1. Apri «Informazioni app» (pulsante qui sotto, oppure: Impostazioni → App → AutoConnector for Telegram).\n2. Tocca il menu ⋮ (tre puntini in alto a destra) → «Consenti impostazioni con restrizioni» → conferma.\n3. Torna indietro: Impostazioni → Accessibility → AutoConnector for Telegram → attivalo.\n\nSe non vedi «Consenti impostazioni con restrizioni», prova prima ad attivare una volta l'interruttore nell'Accessibility (apparirà il messaggio di blocco), poi comparirà il passaggio 2.\n\nSu Xiaomi/MIUI, Samsung ecc. il percorso può variare leggermente — cerca lo stesso ⋮ in «Informazioni app». Su Android 12 e versioni precedenti di solito non c'è restrizione — attivalo subito.\n\nI tasti del volume vengono solo letti, mai bloccati."
    override val volOpenAppInfo = "Apri «Informazioni app»"
    override val volAccessOn = "Accessibility: attiva"
    override val volAccessOff = "Accessibility: non attiva"
    override val volOpenAccess = "Apri le impostazioni di Accessibility"
    override val volGapLabel = "Ms max tra le pressioni"
    override val volPatternsTitle = "Sequenze riconosciute"
    override val volPatternPick = "Sequenza"
    override val volPatternsLegend = "↑ = volume su, ↓ = volume giù"
    override val volNoRights = "L'app NON ha ancora il permesso di gestire i tasti del volume — concedi l'accesso seguendo i passaggi in fondo a questa pagina."
    override val volGrantShort = "Ancora nessun accesso all'Accessibility. Leggi i passaggi dettagliati in fondo a questa pagina, poi tocca «Verifica»."
    override val volCheck = "Verifica"
    override val volCheckOk = "✓ Fatto — accesso concesso, l'attivazione funziona."
    override val volCheckFail = "✗ Ancora nessun accesso — completa i passaggi qui sopra."
    override val volPatternsList = "↑↑↓↓ · ↓↓↑↑ · ↑↓↑↓ · ↓↑↓↑ · ↑↑↑↑ · ↓↓↓↓ · ↑↓↓↑ · ↓↑↑↓ · ↑↑↑↓↓↓ · ↓↓↓↑↑↑   (↑ = volume su, ↓ = volume giù)"
    override val histLegend = "Colonne — Chi: ✓/✗ TG = connessione Telegram reale, scansione = controllo in background. Quando: quanto tempo fa. TCP/TLS/Richiesta: latenza dell'handshake e della prima richiesta, ms. Sessione: quanto è durata la sessione di relay. ↓/↑: byte ricevuti / inviati attraverso l'host."
    override val tgOkTotalHint = "Connessioni Telegram / riuscite / totale controlli"
    override val breadthTitle = "Ampiezza nella scelta degli host"
    override val breadthHelp = "A sinistra — attieniti ai migliori host comprovati; a destra — prova il più ampiamente possibile tra tutti gli host attivi. Quando Telegram continua a saltare da una porta di relay all'altra, l'app amplia automaticamente la scelta."
    override val breadthNarrow = "comprovati"
    override val breadthWide = "più ampio"
    override val connTimeoutTitle = "Timeout di connessione per host"
    override val connTimeoutHelp = "Quanto attendere un singolo upstream (TCP + TLS + prima risposta MTProto) prima di passare al proxy successivo."
    override val factoryResetDone = "Tutto è stato reimpostato. Chiudi l'app e riaprila."

    // tray
    override val trayOpenWindow = "Apri finestra"
    override val trayRefreshSubs = "Aggiorna abbonamenti"
    override val trayExit = "Esci"
    override fun trayConnectorLabel(on: Boolean) =
        if (on) "Connettore: ON (spegni)" else "Connettore: OFF (accendi)"
    override fun trayScanLabel(on: Boolean) =
        if (on) "Scansione: ON (spegni)" else "Scansione: OFF (accendi)"
    override fun trayLive(n: Int) = "Proxy attivi: ${n}"
    override val appearance = "Aspetto"
    override val themeLabel = "Tema"
    override val themeAuto = "Automatico (come il sistema)"
    override val themeLight = "Chiaro"
    override val themeDark = "Scuro"
    override val drawGraphsLabel = "Disegna grafici"
    override val drawGraphsSub = "Grafici in tempo reale nelle schede Connector e Scan — disattiva per risparmiare batteria"
}
