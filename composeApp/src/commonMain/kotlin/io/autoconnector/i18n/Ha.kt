package io.autoconnector.i18n

object Ha : Strings by En {
    override val tabConnector = "Mahaɗi"; override val tabScan = "Bincike"
    override val tabCatalog = "Katalog"; override val tabLogs = "Log"; override val tabMore = "Ƙari"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "Rajista"; override val logTabScan = "Bincike"
    override val logGeneral = "Gaba ɗaya"; override val logEmpty = "babu kome a yanzu"
    override val logSessions = "Zama"; override val logErrorsOnly = "kurakurai kawai"; override val logNoErrors = "babu zaman da ya gaza"
    override fun logSession(id: String, port: String) = "#${id} · :${port}"
    override val back = "Baya"; override val copy = "Kwafa"; override val gotIt = "Na gane"
    override val later = "Daga baya"; override val details = "Cikakkun bayanai"; override val whatIsThis = "Mene ne wannan?"
    override val delete = "Share"

    override val connector = "Mahaɗi"; override val scan = "Bincike"
    override val notConfigured = "Ba a saita ba! Gyara →"; override val howToSetup = "Yadda ake saitawa"
    override val notifOff = "An kashe sanarwa! Gyara →"; override val enable = "Kunna"
    override fun fewProxies(n: Int) = "Wakilai masu rai ${n}, ina nema, jira ~15 min…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "Wakilai masu rai: ${alive}  (15 min: ${within}) · jimla: ${total}"
    override val notifWhyTitle = "Me ya sa sanarwa?"
    override val notifWhyBody = "Sanarwa mai alama ta dindindin tana nufin sabis na gaba (foreground service) na Android. " +
        "Ba tare da ita ba, tsarin yana cire manhaja daga ƙwaƙwalwa kuma ta daina neman wakilai da riƙe " +
        "haɗin a baya. Shi ya sa ake buƙatar sanarwa don AutoConnector ya yi aiki."
    override val notifEnableTitle = "Kunna sanarwa"
    override val notifEnableBody = "Ba tare da alamar sanarwa ba, Android yana ɗaukar manhaja a matsayin marar aiki kuma " +
        "yana cire ta daga ƙwaƙwalwa. Sai AutoConnector ya daina neman wakilai da riƙe haɗin a baya — Telegram " +
        "ya rasa haɗinsa.\n\nKa danna \"Kunna\" sannan ka ba da izinin sanarwa ga AutoConnector."
    override val notifPlea = "Kunna sanarwa! Ba tare da su ba manhaja ba za ta iya aiki a baya ba — " +
        "Android zai cire ta sai neman wakilai da haɗin su tsaya."

    override val statusConnected = "An haɗa Telegram"; override val statusConnecting = "Ana haɗawa…"
    override val statusOffline = "Ba a haɗa Telegram ba"; override val statusIdle = "Telegram a hutu"
    override val nobodyConnected = "Babu wanda ya haɗa da Mahaɗi. "; override val howToSetupArrow = "Yadda ake saitawa →"
    override val directModeViaVpn = "Yanayin kai tsaye: VPN yana aiki — babu wakili"
    override val directModeOff = "Yanayin kai tsaye: an kashe wakilai"
    override val directDpiSuffix = " · anti-DPI"
    override val connections = "Haɗi"; override val sockets = "Soket"; override val speed = "Gudu"
    override val traffic = "Zirga-zirga"; override val latency = "Jinkiri"
    override fun pcs(n: Int) = "${n} guda"
    override fun netNow(label: String) = "Hanyar sadarwa: ${label}"
    override fun tgToConnector(n: Int) = "TG→ ${n}"
    override fun connectorToProxy(n: Int) = "wakili ${n}"
    override val trafficSec = "zirga-zirga · 60 daƙiƙa"; override val trafficMin = "zirga-zirga · 60 minti"
    override val latencySec = "jinkiri · 60 daƙiƙa"; override val latencyMin = "jinkiri · 60 minti"
    override val sec60 = "60 daƙiƙa"; override val min60 = "60 minti"
    override val unitSec = "d"; override val unitMin = "m"; override val unitHour = "s"; override val dash = "—"
    override val currentProxy = "Wakili na yanzu"; override val noActiveProxy = "babu wakili mai aiki (ba a haɗa Telegram ba)"
    override val host = "Host"; override val type = "Nau'i"; override val secret = "Sirri"; override val antiDpi = "Anti-DPI"; override val obfEngine = "Injin ɓoyewa"
    override fun activeSockets(n: Int) = "Soket masu aiki na Telegram: ${n}"
    override val noConnections = "babu haɗin da ke aiki"; override val colHost = "Host"; override val colTime = "Lokaci"
    override val modeWord = "Yanayi"; override val directViaVpnLine = "Buƙatun kai tsaye zuwa Telegram (VPN yana aiki)"
    override val connModeHelp = "Yanayoyi (VPN, Wi-Fi, LTE, Ethernet, White) na ba ka damar daidaita ƙarfin bincike daban kuma su riƙe ƙididdiga/lissafi daban na host. Ana gano katin sadarwa ta atomatik; ana iya saita yanayi da hannu a saituna."

    override val scanOff = "An kashe bincike"; override val proxiesInBase = "Wakilai a cikin bayanai"
    override val total = "jimla"; override val alive = "masu rai"; override val dead = "matattu"
    override val tgConnectedTitle = "An haɗa Telegram ta hanyar"; override val successful = "cikin nasara"
    override val socketsHeld = "Tsawon rayuwar soket"; override val over1m = ">1 min"; override val over5m = ">5 min"; override val over15m = ">15 min"
    override val scanCountTitle = "Adadin bincikar wakilai"; override val checked = "An duba"
    override val forAllTime = "duk lokaci"; override val perMinute = "kowace minti"; override val perHour = "kowace sa'a"
    override val subsCountTitle = "Adadin saukar rajista"; override val downloaded = "an sauke"; override val failed = "ya gaza"; override val scanTraffic = "zirga-zirgan bincike"; override val subTraffic = "zirga-zirgan rajista"; override val subTrafficGraph = "Zirga-zirgan rajista"
    override val checksMtproto = "Dubawar MTProto (↑ ok · ↓ fail)"

    override fun catalogEmpty(mode: String) = "Katalog ${mode} babu kome a yanzu. Ko ba a sami host ba, ko manhaja ba ta taɓa aiki a wannan yanayi ba. Kana iya canza yanayi a Saituna. Akwai yanayoyi don tara host daban-daban don nau'ikan haɗin intanet daban."
    override val aliveShort = "✓ rai"; override val deadShort = "✗ matacce"
    override val statusLabel = "Matsayi"; override val rating = "Ƙima"; override val port = "Tasha"
    override val rttPing = "RTT (ping)"; override val checkedField = "An duba"; override val okOfTotal = "Nasara / jimillar dubawa"
    override val tgConnectedField = "An haɗa Telegram"; override val tgSessions = "Zaman Telegram"; override val trafficThroughProxy = "Zirga-zirga ta wakili"
    override val sessionsTotal = "Jimlar zama"; override val relayNow = "Relay yanzu"; override val tlsDomain = "Yankin TLS (SNI)"
    override val sourceSub = "Tushe (rajista)"; override val lastError = "Kuskure na ƙarshe"; override val yes = "i"; override val no = "a'a"
    override val copyAsLink = "Kwafa a matsayin hanyar haɗi"; override val openInTelegram = "Buɗe host a Telegram"; override val makeNextRelay = "Maida relay na gaba"
    override val actCopy = "Kwafa"; override val actOpen = "Buɗe"; override val actRelay = "Relay"
    override fun agoFmt(v: String) = "${v} da suka wuce"
    override val recentAttempts = "Haɗi da dubawa na baya-bayan nan"
    override val kindCheck = "dubawa"
    override val kindTg = "telegram"
    override val histWho = "Wa"
    override val histWhen = "Yaushe"
    override val histReq = "Buƙata"
    override val histSess = "Zama"
    override val histScan = "bincike"
    override val testNow = "Gwada yanzu"
    override val testShort = "Gwaji"
    override val testResult = "Sakamakon gwaji"
    override val testStop = "Tsaya"
    override val testingNow = "ana gwaji…"
    override val prewarmTitle = "Dumama soket (gwaji)"
    override val prewarmHelp = "Riƙe soket kaɗan a buɗe gaba zuwa wakili, domin sabon haɗin Telegram ya tsallake " +
        "haɗi/handshake. Na gwaji: baya yana sake haɗawa kullum → cin zirga-zirga da kaɗan na CPU. Ba a aika " +
        "zirga-zirga na ƙarya ba (zai ɓata zaman gaske) — ana juya soket kawai. Mafi amfani da wakilan FakeTLS."
    override val prewarmEnable = "Kunna dumama"
    override val prewarmModeDeferred = "Jinkirtacce (TLS kawai)"
    override val prewarmModeDeferredSub = "Mun riƙe TCP + FakeTLS; muna aika obfuscated2-init lokacin tura bayanai. Ba a ƙulla DC ba — mafi haƙiƙa."
    override val prewarmModeFull = "Cikakken handshake"
    override val prewarmModeFullSub = "Mun riƙe soket cikakke a haɗe ta DC daban; muna sake amfani kawai idan DC/tag sun dace. Suna rayuwa kaɗan."
    override val prewarmPoolLabel = "Soket na ajiya"
    override val prewarmHoldLabel = "Riƙe, d"
    override val prewarmNote = "Juyawa kawai (babu keepalive a matakin manhaja). Soket yana rayuwa daƙiƙu…~minti, ya danganta da wakili/DC."
    override val prewarmStatus = "Dumama"
    override fun prewarmStatusVal(ready: Int, holdSecs: Int) = "${ready} a shirye · riƙe ${holdSecs}d"
    override val prewarmStar = "Lemu mai kauri = an ba da soket mai dumi daga tafkin dumama (babu haɗi/handshake)"
    override fun prewarmTableTitle(holdSecs: Int) = "Dumama soket (riƙe ${holdSecs}d)"
    override val prewarmTableHelp = "\"Dumama soket\" yana buɗe soket kaɗan gaba zuwa wakili, domin sabon haɗin Telegram " +
        "ya tsallake haɗi/handshake. Wannan tebur yana nuna host masu dumama: tsawon daƙiƙun rayuwar soket, ko Telegram " +
        "yana amfani da shi, da zirga-zirga. Ana iya kunnawa/kashewa da saitawa (yanayi, adadin soket, lokacin riƙe) a " +
        "\"Ƙari → Saituna → 'Dumama soket (gwaji)'\"."
    override val prewarmNoneWarming = "babu soket masu dumama tukuna"
    override val prewarmColAge = "rayuwa"
    override val prewarmColUse = "a TG?"
    override val prewarmInUse = "a TG"
    override val prewarmNew = "sabo"
    override val lanShareTitle = "Rabawa a cikin gida (yanar gizo)"
    override val lanShareDesc = "Bar wasu na'urori a wannan Wi-Fi su yi amfani da wannan AutoConnector a matsayin wakili; burauza a adireshin da ke ƙasa zai sami shafi mai mafi kyawun wakilai."
    override val lanShareUrlsLabel = "Maƙwabta a hanyar sadarwa suna haɗawa:"
    override val lanShareNoIp = "babu adireshi a cikin gida — haɗa da Wi-Fi"
    override val lanFirewallTitle = "Bari a cikin gida"
    override val lanFirewallBody = "Da kunnawa, port na relay za su buɗe zuwa hanyar sadarwa ta gida. Yanzu firewall na Windows (ko wani) na iya tambaya ko a bar AutoConnector — zaɓi \"Bari\"/\"Ee\". Idan ka hana, zirga-zirgan maƙwabta zuwa AutoConnector za a toshe, kuma shafi/wakili ba za su kasance ba."
    override val lanFirewallConfirm = "Kunna"
    override val lanInfoTitle = "Me ya sa wannan?"
    override val lanInfoBody = "Gudanar da AutoConnector a kwamfuta ko waya GUDA ɗaya a cikin Wi-Fi naka — sai duk sauran na'urori a hanyar sadarwa ɗaya, har da iPhone (wanda manhaja ba ta goyon baya kai tsaye), za su iya buɗe adireshin a burauza su yi amfani: shafi mai mafi kyawun wakilai don ƙarawa a Telegram nasu, ko wannan na'urar a matsayin wakilin SOCKS. Na'ura ɗaya tana nema da riƙe wakilai, sauran suna amfani da su a cikin gida."
    override val volTriggerTitle = "Jawo ta maɓallan ƙara murya"
    override val volTriggerSub = "Canza wakili ta tsari mai sauri na maɓallan murya"
    override val volEnableLabel = "Kula da maɓallan murya"
    override val volHelpTitle = "Mene ne wannan?"
    override val volHelpBody = "A Android babu maɓallan gaggawa na duniya, don haka ana amfani da maɓallan MURYA. Da kunnawa, AutoConnector a baya yana kula da tsari mai sauri na danna murya-sama/ƙasa (misali sama-sama-ƙasa-ƙasa). Da gane shi, yana buɗe hanyar tg:// ta wakili mai rai mai kyau bazuwar — Telegram yana kama ta ya canza. Hanya mai sauri da ɓoye don juya wakili ba tare da buɗe manhaja ba. Murya tana aiki kamar yadda aka saba (ba a kama dannawa ba). Ana buƙatar damar Accessibility (don karanta maɓallai a baya da buɗe hanya); ba a buƙatar kome har sai ka kunna alamar. A ƙasa saita matsakaicin lokaci tsakanin dannawa; tsarukan da ake ganewa suna a ƙasa."
    override val volGrantTitle = "Kunna Accessibility (muhimmi)"
    override val volGrantBody = "Android (musamman 13+) yana toshe Accessibility ga manhajojin da ba a girka daga Google Play ba — shi ya sa AutoConnector ke launin toka kuma yana cewa \"An hana damar manhaja\".\n\nYadda ake buɗewa:\n1. Buɗe \"Game da manhaja\" (maɓallin ƙasa, ko: Saituna → Manhajoji → AutoConnector for Telegram).\n2. Danna ⋮ (digo uku sama dama) → \"Bari saitunan da aka ƙayyade\" → tabbatar.\n3. Koma: Saituna → Accessibility → AutoConnector for Telegram → kunna.\n\nIdan babu \"Bari saitunan da aka ƙayyade\" — da farko gwada kunna maɓallin a Accessibility sau ɗaya (saƙon hana zai bayyana), sai mataki na 2 ya zama mai samuwa.\n\nA Xiaomi/MIUI, Samsung da sauransu hanya na iya bambanta kaɗan — nemi ⋮ ɗaya a \"Game da manhaja\". A Android 12 da ƙasa galibi babu ƙuntatawa — kunna kai tsaye.\n\nAna karanta maɓallan murya kawai, ba a taɓa toshe su ba."
    override val volOpenAppInfo = "Buɗe \"Game da manhaja\""
    override val volAccessOn = "Accessibility: kunne"
    override val volAccessOff = "Accessibility: kashe"
    override val volOpenAccess = "Buɗe saitunan Accessibility"
    override val volGapLabel = "Matsakaicin ms tsakanin dannawa"
    override val volPatternsTitle = "Tsarukan da ake ganewa"
    override val volPatternPick = "Tsari"
    override val volPatternsLegend = "↑ = murya sama, ↓ = ƙasa"
    override val volNoRights = "Manhaja har yanzu BA ta da damar sarrafa maɓallan murya — ba da izini bisa umarnin da ke ƙasan shafi."
    override val volGrantShort = "Babu damar Accessibility tukuna. Karanta cikakken umarni a ƙasan wannan shafi sannan danna \"Duba\"."
    override val volCheck = "Duba"
    override val volCheckOk = "✓ An gama — an ba da izini, jawo yana aiki."
    override val volCheckFail = "✗ Babu izini tukuna — yi matakan da ke sama."
    override val volPatternsList = "↑↑↓↓ · ↓↓↑↑ · ↑↓↑↓ · ↓↑↓↑ · ↑↑↑↑ · ↓↓↓↓ · ↑↓↓↑ · ↓↑↑↓ · ↑↑↑↓↓↓ · ↓↓↓↑↑↑   (↑ = murya sama, ↓ = ƙasa)"
    override val histLegend = "Ginshiƙai — Wa: ✓/✗ TG = haɗin Telegram na gaske, bincike = dubawa a baya. Yaushe: tsawon lokacin baya. TCP/TLS/Buƙata: jinkirin handshake da buƙata ta farko, ms. Zama: tsawon zaman relay. ↓/↑: an karɓa / an aika bytes ta host."
    override val tgOkTotalHint = "Haɗin Telegram / nasara / jimillar dubawa"
    override val breadthTitle = "Faɗin zaɓen host"
    override val breadthHelp = "Hagu — tsaya kan mafi kyawun host da aka duba; dama — gwada masu rai daban-daban da yawa. Lokacin da Telegram ke yawo tsakanin port na relay, manhaja tana faɗaɗa zaɓi ta atomatik."
    override val breadthNarrow = "an duba"
    override val breadthWide = "faɗi"
    override val connTimeoutTitle = "Lokacin jiran haɗin host"
    override val connTimeoutHelp = "Tsawon jiran sama ɗaya (TCP + TLS + amsa MTProto ta farko) kafin gwada wakili na gaba."
    override val catalogTopFor = "Jeri/ƙimar wakilai don"
    override val catalogModeHelpTitle = "Yanayoyi da ƙima"
    override val catalogModeHelp = "Manhaja tana ƙidaya host masu rai da ƙimarsu DABAN ta kowane yanayin sadarwa (VPN, Wi-Fi, LTE, Ethernet da White). \"White\" yanayi ne na DAN HANNU daban don farar lissafi; atomatik ba ya zuwa gare shi. Don haka host ɗaya na iya zama mai rai a yanayi ɗaya kuma matacce a wani."
    override fun catalogInactiveWarn(section: String, active: String) =
        "Kana duban sashe marar aiki ${section} — duk lissafi a yanzu yana zuwa ${active}, ba nan ba."
    override val manageModeTitle = "Sarrafa yanayi"
    override val manageResetRating = "Sake saita ƙima"
    override fun manageResetHint(mode: String) = "Musamman ga ${mode} kana iya sake saita ƙima da lissafin amfani na host masu rai. Wannan yana da amfani lokacin da ka haɗa da wani VPN ko LTE dabam ƙwarai, domin tsohon lissafi kada ya tsoma baki. Ko don kallon yadda bincikar wakili ke sake duba komai daga farko da sauri."
    override val manageDeleteAll = "Share host a cikin"
    override fun manageDeleteHint(mode: String) = "Kana iya share ƙima da host kansu daga ${mode}. Aikin \"Bincikar wakilai\" zai tara su kuma. Wannan ba sake saita rajista ba ne — kana iya dannawa, sannan jira ~15 minti don sake bincike."
    override fun manageCopyFrom(mode: String) = "Kwafa duk host da ƙima zuwa wannan yanayi (${mode}) daga wani yanayi:"
    override val live = "rai"; override val deadW = "matacce"; override val unitMs = "ms"
    override val agoMin = "m"; override val agoHour = "s"; override val agoDay = "k"

    override val connectTelegram = "Haɗa Telegram"; override val readCarefully = "Karanta a hankali!"
    override val guideIntro = "Wannan manhaja ba za ta yi aiki ba tare da saitawa. Zaɓi ɗaya daga cikin " +
        "zaɓuɓɓuka 3 da ke ƙasa kuma bi umarnin a hankali."
    override val variant1 = "Zaɓi #1 — maɓallai"
    override val variant1Body = "Ka danna \"Wakili {A}\" — Telegram zai buɗe, ka tabbatar da ƙara wakili. Koma " +
        "wannan allo ka danna \"Wakili {B}\" — ka tabbatar da ƙara karo na biyu.\n\nKashe duk wasu tsofaffin " +
        "wakilai a Telegram. Dole ne kawai wakilai 2 su rage — masu port {A} da {B}. Da kowane saiti dabam " +
        "AutoConnector ba zai yi aiki ba."
    override val variant2 = "Zaɓi #2 — hanyoyin haɗi"
    override val variant2Body = "Kwafa rubutun da ke ƙasa zuwa Saƙonni Ajiyayyu (ko kowane hira) a Telegram — " +
        "wato aika wa kanka. Ka danna hanyar haɗi ta farko a saƙonka — an ƙara wakili na farko. Ka danna na " +
        "biyu — an ƙara na biyu. Sannan ka kashe duk tsofaffin wakilai."
    override val variant3 = "Zaɓi #3 — da hannu"
    override val variant3Body = "Ƙara wakilin SOCKS5 da hannu: sabar localhost (127.0.0.1), port {A}. " +
        "Sannan wakili na biyu: localhost, port {B}. Share duk wani tsohon wakili."
    override val whatNext = "Me zai biyo baya?"
    override val whatNextBody = "A Telegram, kunna \"canza wakili ta atomatik\" — daƙiƙu 5. Kana iya taimaka wa " +
        "Telegram ya haɗa ta hanyar danna wakili da hannu (cikin Telegram) wanda BA ya aiki ko an yi masa alama " +
        "\"ba ya samuwa\" — wannan yana sa Telegram ya yi ƙarin ƙoƙarin haɗawa.\n\nTabbatar duk sauran tsofaffin " +
        "wakilai an cire su, sai {A} da {B}. Danna \"Yi amfani da wakili\" a Telegram.\n\nJira yayin da manhaja ke " +
        "nema da sauke isassun wakilai (minti 5–15). Sannan Telegram da kansa zai haɗa da AutoConnector, wanda zai " +
        "ci gaba da tura Telegram ta mafi kyawun wakilai: waɗanda aka duba, masu rai da sauri.\n\nIdan umarnin ya " +
        "yi wuya — yi haƙuri, ba za ka iya amfani da manhaja ba: ba zai yiwu a saita komai ta atomatik ba, kuma " +
        "neman wakilai masu rai yana ɗaukar lokaci.\n\nIdan ka sauke manhaja tun da daɗewa kuma ba a sami wakilai " +
        "masu rai ba — sabunta ko dai manhaja ko jerin rajista. Wannan manhaja ba ta ƙirƙira ko bayar da wakilanta " +
        "ba, tana nema kawai a intanet a cikin dubban ƙungiyoyi da shafuka."
    override fun proxyBtn(port: Int) = "Wakili ${port}"

    override val setupPortsTitle = "Saita port a Telegram"
    override val setupPortsSub = "Yadda ake haɗa Telegram da Mahaɗi (port 55001/55002)"
    override val settings = "Saituna"; override val settingsSub = "Port, anti-DPI, bincike, sadarwa, baturi"
    override val subscriptions = "Rajista"; override val subscriptionsSub = "Tushen wakilai don bincike"
    override val statistics = "Ƙididdiga"; override val statisticsSub = "Bayanan wakilai + dabarun anti-DPI"
    override val export = "Fitarwa"; override val exportSub = "Hanyoyin tg:// na wakilai masu rai"
    override val about = "Game da"; override val aboutSub = "Sigar, ginawa, sauke, ra'ayi"
    override val hotkeys = "Maɓallan gaggawa"
    override val hotkeysSub = "Maɓallan duniya: kwafa / buɗe wakili"
    override val hotkeysIntro = "Maɓallan gaggawa na duniya suna aiki ko da tagar manhaja ba ta cikin mayar da hankali. " +
        "Suna ɗaukar hanyar wakili mai rai bazuwar (tg://) daga tafki — mai amfani don canza wakili da sauri ba tare " +
        "da buɗe manhaja ba."
    override val hotkeysNote = "A macOS, kama maɓallai na iya buƙatar izinin Accessibility " +
        "(System Settings → Privacy & Security → Accessibility)."
    override val hotkeyCopyTitle = "Kwafa hanyar haɗin wakili"
    override val hotkeyCopyDesc = "Yana sanya hanyar tg:// mai rai bazuwar a cikin allo."
    override val hotkeyEnable = "Kunna maɓallan gaggawa"; override val hotkeyLetterLabel = "Harafi"; override val hotkeySet = "Saita"; override val hotkeyReset = "Sake saita"
    override val hotkeyOpenTitle = "Buɗe wakili a Telegram"
    override val hotkeyOpenDesc = "Yana buɗe hanyar haɗi mai rai bazuwar — Telegram zai kama ta ya ba da shawarar haɗa wakili."

    override val relayPorts = "Port na relay"
    override val relayPortsHelp = "Port na gida da Mahaɗi ke sauraro. Su ne ainihin abin da ka shigar a Telegram a " +
        "matsayin wakilin SOCKS5 (127.0.0.1 : port). Ana amfani da port biyu don tabbaci — Telegram yana riƙe haɗi zuwa biyun."
    override val portA = "Port A"; override val portB = "Port B"
    override val antiDpiTrick = "Dabarar anti-DPI"
    override val antiDpiHelp = "Hanyar ɓoye haɗin domin mai bayar da intanet/DPI ya kasa gane shi ya toshe shi.\n" +
        "• \"Juya ta atomatik\" da kanta tana zaɓen dabarar da ke aiki.\n• \"Babu dabarun DPI\" — haɗi na yau da " +
        "kullun.\n• Sauran su ne dabaru takamaiman (kwaikwayon burauza, raba fakiti da sauransu)."
    override val onlyFakeTls = "FakeTLS kawai (ee)"
    override val applyDpiTo = "Yi amfani da anti-DPI ga"
    override val applyDpiHelp = "Ga me za a yi amfani da dabarar anti-DPI da aka zaɓa:\n• Relay na Telegram — ga " +
        "haɗin Telegram na gaske ta Mahaɗi.\n• Binciken wakili — ga dubawar wakili a baya (sai dubawa ta yi kama da " +
        "haɗi na gaske, kuma lissafin dabaru ya fi daidai).\n• Lokacin haɗawa kai tsaye — lokacin da aka kashe " +
        "wakilai (ko aka tsallake yayin VPN) kuma Telegram ya tafi kai tsaye zuwa sabarsa: babu wakili nan, don " +
        "haka dabarar ta zama raba fakitin TCP na farko (handshake) zuwa ƙananan sassa domin DPI ya kasa gane shi a karatu ɗaya."
    override val toRelay = "Relay na Telegram"; override val toProbes = "Binciken wakili"
    override val toDirect = "Lokacin haɗawa kai tsaye"
    override val vpnSection = "Lokacin da VPN ke kunne"
    override val vpnHelp = "Me za a yi lokacin da VPN ke aiki a na'ura:\n• Ta wakilin MTProto — Telegram yana tafiya " +
        "ta wakilan da aka samu kamar yadda aka saba (a kan VPN).\n• Kai tsaye — Mahaɗi BA ya amfani da wakilai " +
        "kuma yana haɗa Telegram kai tsaye zuwa sabar Telegram: VPN ya riga ya bayar da damar shiga, ba a buƙatar " +
        "ƙarin sashen wakili (mai sauri da kwanciyar hankali). Ba tare da VPN ana amfani da wakilai kamar yadda aka saba."
    override val linkFormat = "Tsarin hanyar haɗin wakili"
    override val linkFormatHelp = "Yadda ake kwafa da buɗe wakilai. tg:// yana buɗe Telegram kai tsaye (ana buƙatar Telegram Desktop a girka). http (t.me) yana buɗe ta burauza kuma yana ba da shawarar buɗewa a Telegram — mai amfani idan tg:// ba a rajista ba."
    override val linkTg = "tg:// (buɗe Telegram kai tsaye)"; override val linkTgSub = "tg://proxy?… — yana buɗe Telegram"
    override val linkHttp = "http (t.me, ta burauza)"; override val linkHttpSub = "https://t.me/proxy?… — yana buɗe burauza"
    override val viaMtproto = "Wakili ta MTProto"; override val viaMtprotoSub = "ko da VPN, zirga-zirga na tafiya ta wakilai"
    override val directly = "Haɗa kai tsaye"; override val directlySub = "tare da VPN mai aiki — ƙetare wakilai, kai tsaye zuwa Telegram"
    override val notifications = "Sanarwa"
    override val scanCheck = "Bincike da dubawa"
    override val scanCheckHelp = "• Bincike, min — sau nawa za a sauke jerin wakilai daga rajista.\n" +
        "• Dubawa, min — sau nawa za a sake duba wakilan da ke bayanai don rai.\n• Girman tari — wakilai nawa za " +
        "a duba a gudu ɗaya.\n• Tare — dubawa nawa za a gudanar lokaci ɗaya (ƙari = sauri, amma ƙarin nauyi a " +
        "sadarwa da baturi)."
    override val scanMin = "Bincike, min"; override val checkMin = "Dubawa, min"; override val batchSize = "Girman tari"; override val parallel = "Tare"
    override val speedByNet = "Ƙarfin bincike ta hanyar sadarwa"
    override val speedByNetHelp = "Sau nawa za a duba wakilai ya danganta da hanyar sadarwa ta yanzu. \"Matsayi\" = " +
        "tsakanin asali. Zura dama don ƙalilan (a hankali, mai sauƙi ga zirga-zirga/baturi), hagu don yawan lokaci " +
        "(sauri, mai ƙarfi). Ma'aunin logarithmic, har ×100 kowace hanya.\n• VPN — lokacin da VPN na waje ke aiki.\n" +
        "• Wi-Fi — a hanyar Wi-Fi.\n• LTE — a hanyar wayar hannu."
    override val intensStandard = "matsayi"
    override val intensSlower = "a hankali"
    override val intensFaster = "da sauri"
    override val maintenance = "Sake saita bayanai"
    override val maintenanceHelp = "• \"Sake saita katalog da ƙididdiga\" — yana sifirta ƙima, masu ƙidaya, " +
        "zirga-zirga da log na dubawa, amma yana riƙe host da rajista da aka sauke (ana sake ƙimanta komai a " +
        "bincike na gaba).\n• \"Share host da aka sauke\" — yana share dukan tafkin wakilai amma yana riƙe rajista " +
        "domin bincike ya cika tafki kuma. Ba a taɓa taɓa rajista a kowace hanya ba."
    override val backupTitle = "Fitarwa / Shigarwa"
    override val backupHelp = "Ajiye ko maido da bayanan manhaja a matsayin JSON. Yi alama ga abin da za a " +
        "haɗa — kowane haɗi:\n• Saituna — duk sigogin manhaja.\n• Rajista — jerin tushe (URL + kunne/kashe).\n" +
        "• Katalogin host masu rai — kowane wakili mai rai da ƙimominsa da lissafi TA kowane yanayin sadarwa.\n\n" +
        "\"Fitarwa\" yana buɗe shafi mai JSON a shirye — kwafa shi ko ajiye zuwa fayil. \"Shigarwa\" — liƙa JSON " +
        "(ko loda fayil) sai ya yi amfani da sassan da aka yi wa alama da ke cikinsa kawai. Shigarwa tana ƘARA wa " +
        "bayanan yanzu (babu share)."
    override val backupSettings = "Saituna"
    override val backupSubs = "Rajista"
    override val backupHosts = "Katalogin host masu rai (ta yanayi)"
    override val exportWord = "Fitarwa"
    override val importWord = "Shigarwa"
    override val backupExportTitle = "Fitar da bayanai"
    override val backupImportTitle = "Shigar da bayanai"
    override val backupSelectExport = "Me za a fitar:"
    override val backupSelectImport = "Me za a shigar:"
    override val backupCopyBtn = "Kwafa"
    override val backupSaveFile = "Ajiye zuwa fayil"
    override val backupLoadFile = "Loda daga fayil"
    override val backupDoImport = "Shigar"
    override val backupPasteLabel = "Liƙa JSON na ajiya nan"
    override val backupJsonLabel = "JSON na ajiya"
    override val backupAndroidFileNote = "Fayiloli ba sa nan — yi amfani da Kwafa / Liƙa."
    override val eraseAllHosts = "Share dukan host"
    override val factoryReset = "Sake saita komai (kamar farkon ƙaddamarwa)"
    override val factoryResetConfirm = "Sake saita manhaja gaba ɗaya zuwa yanayin masana'anta? Za a share DUK " +
        "saituna da dukan katalogin host, a maido da rajista zuwa tsoho. Kamar farkon ƙaddamarwa."
    override val factoryResetDone = "An sake saita komai. Rufe manhaja sannan ka sake buɗewa."
    override val resetCatalog = "Sake saita katalog da ƙididdiga"
    override val resetCatalogConfirm = "A sifirta duk ƙima, masu ƙidaya da log na dubawa? " +
        "Ana riƙe host da rajista da aka sauke kuma ana sake ƙimanta su a bincike na gaba."
    override val clearHosts = "Share host da aka sauke"
    override val clearHostsConfirm = "Share dukan jerin host (wakilai) da aka sauke? " +
        "Ana riƙe rajista kuma bincike zai cika tafki."
    override val doReset = "Sake saita"
    override val doCancel = "Soke"
    override val adaptiveSpeed = "Gudun daidaitawa"
    override val adaptiveHelp = "Dubawar rai tana gudana a tsakanin asali (daga \"Bincike da dubawa\", har an " +
        "ninka da ninkin sadarwa). \"Gudun daidaitawa\" da kansa yana sauri ko jinkirta su gwargwadon yawan " +
        "wakilan da ke rai a yanzu.\n\n" +
        "• KAƊAN masu rai (ƙasa da iyakar \"Kaɗan\") → tsakani × \"Hanzari\". Ninki ƙasa da 1 = yawan lokaci: " +
        "0.5 — sau biyu, 0.25 — sau 4. Yana cika tafki da sauri.\n" +
        "• DA YAWA masu rai (sama da iyakar \"Da yawa\") → tsakani × \"Jinkiri\". Sama da 1 = ƙalilan: 2 — rabin " +
        "lokaci, 4 — kashi ɗaya cikin huɗu. Yana adana baturi da zirga-zirga.\n" +
        "• Tsakanin iyakoki — gudun asali (×1).\n\n" +
        "Misalai:\n" +
        "— Tara wakilai da sauri: \"Hanzari\" 0.25 da/ko iyakar \"Kaɗan\" 40.\n" +
        "— Adana baturi idan kana da isasshe: \"Jinkiri\" 8 da/ko iyakar \"Da yawa\" 30.\n" +
        "— Kashe daidaitawa: saita ninka biyu zuwa 1.\n\n" +
        "Tsoho: Kaɗan 20, Hanzari 0.5, Da yawa 50, Jinkiri 4."
    override val threshMany = "Iyakar \"Da yawa\""; override val threshFew = "Iyakar \"Kaɗan\""; override val mulFast = "Hanzari ×"; override val mulLazy = "Jinkiri ×"
    override val subIntensityTitle = "Ƙarfin rajista"
    override val subIntensityHint = "Hutu tsakanin saukar rajista: minti nawa kafin a sake sauke jerin wakilai (daban ga kowane yanayin sadarwa)."
    override val baseScanTitle = "Gudun bincike na asali"
    override val baseScanHelp = "Gudun dubawar rai na tushe. Ana lissafa \"Gudun daidaitawa\" da ninka na \"Gudu " +
        "ta yanayi\" gwargwadonsa.\n\n" +
        "• Sau nawa za a gudu, min — tsakani tsakanin wucewar dubawa.\n" +
        "• Tari kowace zare, host — host nawa kowace zare ke dubawa a wucewa ɗaya.\n" +
        "• Adadin zare — dubawa nawa ke gudana lokaci ɗaya. Wucewa tana duba \"tari × zare\" host.\n" +
        "• Kada a sake bincikar host fiye da kowane N min — kariya daga ambaliya: host da aka duba kwanan nan za a " +
        "tsallake a wannan wucewa.\n\n" +
        "Ƙarin zare da babban tari = sauri girman tafki, amma ƙarin nauyi a sadarwa da baturi."
    override val baseScanPeriod = "Sau nawa za a gudu, min"
    override val baseScanBatch = "Tari kowace zare, host"; override val baseScanThreads = "Adadin zare"
    override val adaptiveDesc = "Idan wakilai masu rai sun yi ƙasa da \"kaɗan\" ko sama da \"da yawa\", yi amfani da ƙarin ninki."
    override val fewWord = "Kaɗan"; override val manyWord = "Da yawa"
    override fun fasterX(x: String) = "${x}× da sauri"
    override fun slowerX(x: String) = "${x}× a hankali"
    override fun ifAliveLt(n: Int) = "Idan wakilai masu rai < ${n}, to:"
    override fun ifAliveGt(n: Int) = "Idan wakilai masu rai > ${n}, to:"
    override val disabledWord = "kashe"
    override val speedByModeTitle = "Gudu ta yanayi"
    override val speedByModeHelp = "Ninkin gudun bincike ga kowane yanayin sadarwa, a kan gudun asali. \"Matsayi\" " +
        "(×1) = tsakanin asali. Dama — ƙalilan (a hankali, mai sauƙi ga zirga-zirga/baturi), hagu — yawan lokaci " +
        "(sauri, mai ƙarfi). Ma'aunin logarithmic, har ×100 kowace hanya.\n\n" +
        "Ƙarƙashin kowane sliders akwai sigogin wucewa da aka samu da gudun daidaitawa — an nuna daban ga \"kaɗan " +
        "masu rai\" (× \"Hanzari\") da \"masu rai da yawa\" (× \"Jinkiri\").\n\n" +
        "Yanayoyi:\n• VPN — VPN na waje yana aiki.\n• LTE — hanyar wayar hannu.\n• Wi-Fi — hanyar Wi-Fi.\n" +
        "• Ethernet — haɗin waya.\n• White — yanayin wakilin \"fari\" na hannu."
    override val aliveLt = "rai <"; override val aliveGt = "rai >"
    override val periodWord = "lokaci"; override val nonstopWord = "ba tsayawa"
    override val batchWord = "tari"; override val threadsWord = "zare"; override val scanModeOff = "an kashe bincike"
    override val netBattery = "Sadarwa da baturi"
    override val netBatteryHelp = "• Wi-Fi kawai — kada a bincika a hanyar wayar hannu (adana bayanai).\n• Lokacin " +
        "caji kawai — yi aiki kawai yayin caji wayar.\n• Tsallake idan baturi yayi ƙasa — dakatar da bincike " +
        "lokacin da baturi yayi ƙasa."
    override val onlyWifi = "Wi-Fi kawai"; override val onlyCharging = "Lokacin caji kawai"; override val skipLowBattery = "Tsallake idan baturi yayi ƙasa"
    override val autosaved = "Ana ajiye saituna ta atomatik."
    override val dpiAutoLabel = "Juya dabarun DPI ta atomatik"; override val dpiNoneLabel = "Babu dabarun DPI (na yau da kullun)"
    override val experimental = "Gwaji"
    override val experimentalHelp = "Injunan wakilci na dabam ga sama na MTProto da log na bincike. Hanyar tushe " +
        "(mai aiki) ba ta canzawa lokacin da aka saita \"Kashe\". Kawai YADDA ake rubuta rafin ɓoye zuwa soketin " +
        "TCP na sama ne ke canzawa (girman sassa, tsari na lokaci, iyakokin TLS-record) — rafin kansa ya rage iri " +
        "ɗaya byte-da-byte. Yana shafar relay na wakili na gaske kawai (ba binciken, ba hanyar kai tsaye)."
    override val expEngineTitle = "Injin wakilci (ɓoye soket)"
    override val expConnectTitle = "Injin haɗi (zaɓen sama)"
    override val expEngineWarn = "⚠ Yanayin gwaji. Idan haɗi ya yi muni, koma \"Kashe (hanyar tushe)\"."
    override val netLog = "Kunna log na musayar sadarwa"
    override val netLogSub = "Yana rubuta WA-WA-YAUSHE da girman fakiti zuwa fayil (BABU bayanan payload) — " +
        "don kwatanta tsarin musaya da VPN da kuma ba tare da shi ba."
    override val openLogFolder = "Buɗe babban fayil ɗin log"; override val copyPath = "Kwafa hanya"
    override val helpShow = "Taimako"; override val helpHide = "Ɓoye taimako"
    override val quickSwitchIntro = "Anan kana iya zaɓen dabarar ƙetare toshewa. Idan Telegram ya nuna kuskuren " +
        "“The proxy you are using is not configured correctly and will be disabled. Please find another one”, " +
        "gwada nau'in ɓoye zirga-zirga da ke aiki domin Telegram ya daina nuna shi. Fara da yanayin split*. " +
        "Yanayin coalesce* suma suna aiki, amma hotuna/bidiyo suna lodawa da wahala a Telegram da su."
    override val quickSwitchTitle = "Ƙetare toshewa"; override val quickSwitchSub = "Tsarawa, haɗi, anti-DPI"

    override val sourceUrl = "URL na tushe"
    override fun sourceAlive(alive: Int, total: Int) = "rai ${alive}/${total}"
    override val open = "Buɗe"; override val active = "Mai aiki"; override val inactive = "Mara aiki"
    override val lastDownloaded = "An sauke"; override val notDownloaded = "ba a sauke ba tukuna"
    override fun sourceCounts(dead: Int, total: Int) =
        " rai, ${dead} matattu, ${total} jimla"

    override val proxyBase = "Bayanan wakilai"
    override val totalInBase = "Jimla a bayanai"; override val aliveNow = "Masu rai yanzu"; override val deadStat = "Matattu"
    override val aliveIn15 = "Masu rai cikin 15 min"; override val checksAllTime = "Dubawa duk lokaci"
    override val antiDpiTricks = "Dabarun anti-DPI"; override val noStatsYet = "babu bayanai tukuna — dabaru suna taruwa yayin dubawa/haɗi"
    override val attempts = "Ƙoƙari"; override val handshake = "Handshake"; override val score = "Maki"
    override val tgConnect = "Haɗin TG"; override val socketsOver1m = "Soket >1min"
    override val over10kb = "Soket >10KB"; override val over100kb = ">100KB"; override val workTime = "Lokacin aiki"
    override val statsLegend = "Handshake — handshake masu nasara (% na ƙoƙari) · Maki — daraja · " +
        "\"Lokacin aiki\" — jimla a kan soket ≥5KB kuma sama da minti 1."
    override val resetStats = "Sake saita ƙididdigar dabaru"

    override fun aliveLinks(n: Int) = "Hanyoyin haɗi masu rai: ${n}"
    override val copyAll = "Kwafa duka"
    override val openRandom = "Buɗe bazuwar"; override val copyRandom = "Kwafa bazuwar"; override val allShort = "DUKA"
    override val copyTop = "Kwafa TOP"; override val randomHost = "Host bazuwar"
    override val exportToFile = "Fitar zuwa fayil"; override val exportSaved = "An ajiye zuwa fayil:"
    override val dlNow = "Sauke yanzu"
    override fun downloadingFmt(sec: Long) = "Ana saukewa… ${sec}d"
    override val cancel = "Soke"
    override val deleteConfirmTitle = "Share rajista?"
    override val subscriptionsAddHint = "Ƙara rajista ko hanyoyin wakili →"
    override val addSourcesTitle = "Ƙara"
    override val addSubsLabel = "Rajista (URL ɗaya kowane layi)"
    override val addSubsHelp = "Kowane layi mai URL ingantacce yana zama rajista nasa kuma ana saukar da shi lokaci-lokaci."
    override val addProxiesLabel = "Hanyoyin wakili shirye (jeri tsayayye)"
    override val addProxiesHelp = "Liƙa tari na hanyoyi zuwa wakilai takamaiman (tg://proxy, https://t.me/proxy, …). Wannan BA rajista ba ne — ba a taɓa sauke jeri ba, ana ƙara wakilai a katalog kawai."
    override val addButton = "Ƙara"
    override fun addedFmt(subs: Int, proxies: Int) = "An ƙara: rajista ${subs}, wakilai ${proxies}"
    override val perSecond = "kowace daƙiƙa"
    override val graphSpeed = "Gudu"
    override val graphVolume = "Yawa"
    override val graphLatency = "Ping"
    override val graphConnects = "Haɗi"
    override val scanNow = "Bincika yanzu"; override val scanOnShort = "Bincike kunne"
    override val scanRunning = "Bincike na tafiya"; override val scanIdle = "Bincike a hutu"; override val scanOffState = "Bincike KASHE"; override val scanBatchPerThread = "Tari/zare"; override val scanPassHosts = "Host a wucewa"; override val minRescanLabel = "Kada a sake bincikar host fiye da kowane N min"
    override val scanPlanTitle = "Shiri"; override val scanNowTitle = "Yanzu"; override val currentScheduleTitle = "Jadawalin yanzu"
    override val scheduleWord = "Jadawali"; override val unitPcsPerSec = "guda/d"
    override val scanNowThreadsLabel = "Zare da ke gudana yanzu"; override val scanNowPerThreadLabel = "Dubawa kowace zare (shiri)"; override val scanNowElapsedLabel = "Lokacin gudana"
    override val scanOkGraph = "Bincike masu nasara"; override val scanFailGraph = "Bincike da suka gaza"; override val scanTrafficGraph = "Zirga-zirgan bincike"; override val scanAliveGraph = "Jimillar wakilai masu rai"; override val scanPingGraph = "Ping"; override val threadsGraph = "Zare"
    override val scanEvery = "Kowane"; override val scanNextRun = "Gudu na gaba"
    override val scanThreads = "Zare"; override val scanBatch = "Tari"
    override val scanElapsed = "Yana gudana"; override val scanIdleNow = "—"
    override val effForFew = "Lokacin kaɗan"; override val effForMany = "Lokacin da yawa"
    override val effCheck = "Dubawa"; override val effBatch = "Tari"; override val effPar = "Tare"
    override val effContinuous = "ci gaba"; override val secShort = "d"; override val minShort = "min"

    override val appTagline = "Mahaɗin kai-tsaye mai jituwa: yana nemo, yana dubawa kuma yana gudanar da wakilan " +
        "MTProto da Telegram ke aiki ta su."
    override val version = "Sigar"; override val buildDate = "Ranar ginawa"
    override val downloadSources = "Sauke da tushe"; override val openOnGithub = "Buɗe a GitHub"
    override val feedbackBugs = "Ra'ayi da rahoton kwaro"; override val writeTelegram = "Rubuta a Telegram"

    override val language = "Harshe"; override val langAuto = "Atomatik (tsarin)"; override val langRu = "Русский"; override val langEn = "English"
    override val langFa = "فارسی"; override val langZh = "简体中文"; override val langAr = "العربية"; override val langUr = "اردو"
    override val langTr = "Türkçe"; override val langId = "Bahasa Indonesia"; override val langHi = "हिन्दी"; override val langBn = "বাংলা"; override val langMy = "မြန်မာ"
    override val langWord = "Harshe"
    override val raceWidthTitle = "Haɗin tare"
    override val connectionSection = "Haɗi da ƙetare toshewa"
    override val connectionSectionHelp = "Injin haɗi, sama da yawa tare, injin wakilci da dabarun anti-DPI — duka a sashe ɗaya."
    override val netLogSection = "Log na musayar sadarwa"
    override val platform = "Dandamali"

    override val scanModeTitle = "Yanayin sadarwa"; override val scanModeAuto = "Atomatik"; override val scanModeManualLabel = "Da hannu"
    override val activeModeLabel = "Yanayin aiki"; override val formingListLabel = "Ana ginin jeri"; override val catalogModeTabs = "Yanayi"
    override val resetModeRatings = "Sake saita ƙimar host"; override val forgetModeHosts = "Manta host na yanayi"
    override val exportModeTitle = "Fitarwa ta yanayi"; override val modePickerTitle = "Yanayi"
    override val modeHelp = "Kowane yanayin sadarwa yana riƙe ƙimar wakili nasa da ƙarfin bincike + saukar rajista nasa. \"Atomatik\" yana zaɓen yanayi daga hanyar sadarwa ta aiki. \"Da hannu\" yana ba ka damar zaɓen kowane yanayi da kanka (har da White, wanda atomatik ba ya taɓa zaɓa)."
    override val autoSelect = "Zaɓe na atomatik"; override val manualSelect = "Zaɓe da hannu"
    override val connStatsTitle = "Haɗi yanzu"; override val connOnPort = "Haɗi a port"; override val outgoingConns = "Haɗin fita"
    override val modeChoice = "Zaɓen yanayi"; override val autoChoice = "zaɓe atomatik"; override val manualChoice = "tsayayye da hannu"
    override val directOnVpn = "Haɗi kai tsaye zuwa TG akan VPN"; override val onWord = "kunne"; override val offWord = "kashe"
    override val directStateActive = "yana aiki"; override val directStateOff = "an kashe a saituna"; override val directStateIdle = "an kunna a saituna, amma ba ya aiki"
    override val wpHintTitle = "Menene White?"
    override val wpHint = "White — WhitePages: yanayin sadarwa na hannu. Ana kunna shi da hannu kawai (zaɓe na atomatik ba ya zaɓarsa). " +
        "Yana riƙe ƙimar host nasa, yana sauke rajista kuma yana bincike ba tare da dogaro ga VPN/Wi-Fi/LTE ba."

    // tray
    override val trayOpenWindow = "Buɗe taga"
    override val trayRefreshSubs = "Sabunta rajista"
    override val trayExit = "Fita"
    override fun trayConnectorLabel(on: Boolean) =
        if (on) "Mahaɗi: KUNNE (kashe)" else "Mahaɗi: KASHE (kunna)"
    override fun trayScanLabel(on: Boolean) =
        if (on) "Bincike: KUNNE (kashe)" else "Bincike: KASHE (kunna)"
    override fun trayLive(n: Int) = "Wakilai masu rai: ${n}"
    override val appearance = "Kamanni"
    override val themeLabel = "Jigo"
    override val themeAuto = "Atomatik (daidai da tsarin)"
    override val themeLight = "Haske"
    override val themeDark = "Duhu"
    override val drawGraphsLabel = "Zana jadawali"
    override val drawGraphsSub = "Jadawalin kai tsaye a shafukan Connector da Scan — kashe don adana baturi"
}
