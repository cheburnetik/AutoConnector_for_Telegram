package io.autoconnector.i18n

object Te : Strings {
    override val tabConnector = "కనెక్టర్"; override val tabScan = "స్కాన్"
    override val tabCatalog = "కేటలాగ్"; override val tabLogs = "లాగ్‌లు"; override val tabMore = "మరిన్ని"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "సబ్‌స్క్రిప్షన్‌లు"; override val logTabScan = "స్కాన్"
    override val logGeneral = "సాధారణ"; override val logEmpty = "ప్రస్తుతం ఖాళీగా ఉంది"
    override val logSessions = "సెషన్‌లు"; override val logErrorsOnly = "లోపాలు మాత్రమే"; override val logNoErrors = "విఫలమైన సెషన్‌లు లేవు"
    override fun logSession(id: String, port: String) = "#${id} · :${port}"
    override val back = "వెనుకకు"; override val copy = "కాపీ"; override val gotIt = "అర్థమైంది"
    override val later = "తరువాత"; override val details = "వివరాలు"; override val whatIsThis = "ఇది ఏమిటి?"
    override val delete = "తొలగించు"

    override val connector = "కనెక్టర్"; override val scan = "స్కాన్"
    override val notConfigured = "సెటప్ చేయలేదు! సరిచేయండి →"; override val howToSetup = "ఎలా సెటప్ చేయాలి"
    override val notifOff = "నోటిఫికేషన్‌లు ఆఫ్‌లో ఉన్నాయి! సరిచేయండి →"; override val enable = "ప్రారంభించు"
    override fun fewProxies(n: Int) = "సజీవ ప్రాక్సీలు ${n}, వెతుకుతోంది, ~15 నిమి వేచి ఉండండి…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "సజీవ ప్రాక్సీలు: ${alive}  (15 నిమి: ${within}) · మొత్తం: ${total}"
    override val notifWhyTitle = "నోటిఫికేషన్‌లు ఎందుకు?"
    override val notifWhyBody = "శాశ్వత నోటిఫికేషన్ చిహ్నం అంటే Android ఫోర్‌గ్రౌండ్ సర్వీస్. " +
        "అది లేకుండా సిస్టమ్ యాప్‌ను మెమొరీ నుండి తొలగిస్తుంది, దానివల్ల ప్రాక్సీల కోసం వెతకడం మరియు " +
        "నేపథ్యంలో కనెక్షన్‌ను నిలుపుకోవడం ఆగిపోతుంది. అందుకే " +
        "AutoConnector పనిచేయడానికి నోటిఫికేషన్‌లు అవసరం."
    override val notifEnableTitle = "నోటిఫికేషన్‌లను ప్రారంభించండి"
    override val notifEnableBody = "నోటిఫికేషన్ చిహ్నం లేకుండా, Android యాప్‌ను నిష్క్రియంగా పరిగణించి " +
        "మెమొరీ నుండి తొలగిస్తుంది. అప్పుడు AutoConnector ప్రాక్సీల కోసం వెతకడం మరియు నేపథ్యంలో " +
        "కనెక్షన్‌ను నిలుపుకోవడం ఆపేస్తుంది — Telegram తన లింక్‌ను కోల్పోతుంది.\n\n\"ప్రారంభించు\" నొక్కి " +
        "AutoConnector కోసం నోటిఫికేషన్‌లను అనుమతించండి."
    override val notifPlea = "నోటిఫికేషన్‌లను ప్రారంభించండి! అవి లేకుండా యాప్ నేపథ్యంలో పనిచేయదు — " +
        "Android దానిని తొలగిస్తుంది మరియు ప్రాక్సీ శోధన మరియు కనెక్షన్ ఆగిపోతాయి."

    override val statusConnected = "Telegram కనెక్ట్ అయింది"; override val statusConnecting = "కనెక్ట్ అవుతోంది…"
    override val statusOffline = "Telegram కనెక్ట్ కాలేదు"; override val statusIdle = "Telegram నిష్క్రియంగా ఉంది"
    override val nobodyConnected = "కనెక్టర్‌కు ఎవరూ కనెక్ట్ కాలేదు. "; override val howToSetupArrow = "ఎలా సెటప్ చేయాలి →"
    override val directModeViaVpn = "డైరెక్ట్ మోడ్: VPN సక్రియంగా ఉంది — ప్రాక్సీ లేదు"
    override val directModeOff = "డైరెక్ట్ మోడ్: ప్రాక్సీలు ఆఫ్"
    override val directDpiSuffix = " · యాంటీ-DPI"
    override val connections = "కనెక్షన్‌లు"; override val sockets = "సాకెట్‌లు"; override val speed = "వేగం"
    override val traffic = "ట్రాఫిక్"; override val latency = "లేటెన్సీ"
    override fun pcs(n: Int) = "${n} ముక్కలు"
    override fun netNow(label: String) = "నెట్‌వర్క్: ${label}"
    override fun tgToConnector(n: Int) = "TG→ ${n}"
    override fun connectorToProxy(n: Int) = "ప్రాక్సీ ${n}"
    override val trafficSec = "ట్రాఫిక్ · 60 సెకన్లు"; override val trafficMin = "ట్రాఫిక్ · 60 నిమిషాలు"
    override val latencySec = "లేటెన్సీ · 60 సెకన్లు"; override val latencyMin = "లేటెన్సీ · 60 నిమిషాలు"
    override val sec60 = "60 సెకన్లు"; override val min60 = "60 నిమిషాలు"
    override val unitSec = "సె"; override val unitMin = "ని"; override val unitHour = "గం"; override val dash = "—"
    override val currentProxy = "ప్రస్తుత ప్రాక్సీ"; override val noActiveProxy = "సక్రియ ప్రాక్సీ లేదు (Telegram కనెక్ట్ కాలేదు)"
    override val host = "హోస్ట్"; override val type = "రకం"; override val secret = "సీక్రెట్"; override val antiDpi = "యాంటీ-DPI"; override val obfEngine = "అస్పష్టీకరణ ఇంజిన్"
    override fun activeSockets(n: Int) = "సక్రియ Telegram సాకెట్‌లు: ${n}"
    override val noConnections = "సక్రియ కనెక్షన్‌లు లేవు"; override val colHost = "హోస్ట్"; override val colTime = "సమయం"
    override val modeWord = "మోడ్"; override val directViaVpnLine = "Telegram‌కు డైరెక్ట్ అభ్యర్థనలు (VPN సక్రియం)"
    override val connModeHelp = "మోడ్‌లు (VPN, Wi-Fi, LTE, Ethernet, White) స్కాన్ తీవ్రతను వేర్వేరుగా ట్యూన్ చేయడానికి మరియు వేర్వేరు హోస్ట్ రేటింగ్‌లు/గణాంకాలను విడిగా ఉంచుకోవడానికి అనుమతిస్తాయి. నెట్‌వర్క్ కార్డ్ స్వయంచాలకంగా గుర్తించబడుతుంది; మోడ్‌ను సెట్టింగ్‌లలో మాన్యువల్‌గా సెట్ చేయవచ్చు."

    override val scanOff = "స్కానింగ్ ఆఫ్‌లో ఉంది"; override val proxiesInBase = "డేటాబేస్‌లో ప్రాక్సీలు"
    override val total = "మొత్తం"; override val alive = "సజీవ"; override val dead = "మృత"
    override val tgConnectedTitle = "Telegram దీని ద్వారా కనెక్ట్ అయింది"; override val successful = "విజయవంతం"
    override val socketsHeld = "సాకెట్ జీవితకాలం"; override val over1m = ">1 నిమి"; override val over5m = ">5 నిమి"; override val over15m = ">15 నిమి"
    override val scanCountTitle = "ప్రాక్సీ తనిఖీల సంఖ్య"; override val checked = "తనిఖీ చేయబడింది"
    override val forAllTime = "మొత్తం సమయం"; override val perMinute = "నిమిషానికి"; override val perHour = "గంటకు"
    override val subsCountTitle = "సబ్‌స్క్రిప్షన్ డౌన్‌లోడ్‌ల సంఖ్య"; override val downloaded = "డౌన్‌లోడ్ చేయబడింది"; override val failed = "విఫలమైంది"; override val scanTraffic = "స్కాన్ ట్రాఫిక్"; override val subTraffic = "సబ్‌స్క్రిప్షన్ ట్రాఫిక్"; override val subTrafficGraph = "సబ్‌స్క్రిప్షన్ ట్రాఫిక్"
    override val checksMtproto = "MTProto తనిఖీలు (↑ సరి · ↓ విఫలం)"

    override fun catalogEmpty(mode: String) = "కేటలాగ్ ${mode} ప్రస్తుతం ఖాళీగా ఉంది. ఏ హోస్ట్ కనుగొనబడలేదు, లేదా ఈ మోడ్‌లో యాప్ ఎప్పుడూ నడవలేదు. మీరు సెట్టింగ్‌లలో మోడ్‌ను మార్చవచ్చు. వేర్వేరు రకాల ఇంటర్నెట్ కనెక్షన్‌ల కోసం హోస్ట్‌లను విడిగా సేకరించడానికి మోడ్‌లు ఉన్నాయి."
    override val aliveShort = "✓ సజీవ"; override val deadShort = "✗ మృత"
    override val statusLabel = "స్థితి"; override val rating = "రేటింగ్"; override val port = "పోర్ట్"
    override val rttPing = "RTT (పింగ్)"; override val checkedField = "తనిఖీ చేయబడింది"; override val okOfTotal = "విజయవంతమైన / మొత్తం తనిఖీలు"
    override val tgConnectedField = "Telegram కనెక్ట్ అయింది"; override val tgSessions = "Telegram సెషన్‌లు"; override val trafficThroughProxy = "ప్రాక్సీ ద్వారా ట్రాఫిక్"
    override val sessionsTotal = "మొత్తం సెషన్‌లు"; override val relayNow = "ఇప్పుడు రిలే"; override val tlsDomain = "TLS డొమైన్ (SNI)"
    override val sourceSub = "మూలం (సబ్‌స్క్రిప్షన్)"; override val lastError = "చివరి లోపం"; override val yes = "అవును"; override val no = "కాదు"
    override val copyAsLink = "లింక్‌గా కాపీ చేయి"; override val openInTelegram = "హోస్ట్‌ను Telegram‌లో తెరువు"; override val makeNextRelay = "తదుపరి రిలేగా చేయి"
    override val actCopy = "కాపీ"; override val actOpen = "తెరువు"; override val actRelay = "రిలే"
    override fun agoFmt(v: String) = "${v} క్రితం"
    override val catalogTopFor = "దీని కోసం ప్రాక్సీ జాబితా/రేటింగ్"
    override val catalogModeHelpTitle = "మోడ్‌లు & రేటింగ్‌లు"
    override val catalogModeHelp = "యాప్ సజీవ హోస్ట్‌లను మరియు వాటి రేటింగ్‌లను ప్రతి నెట్‌వర్క్ మోడ్‌కు (VPN, Wi-Fi, LTE, Ethernet మరియు White) విడిగా లెక్కిస్తుంది. \"White\" అనేది వైట్‌లిస్ట్‌ల కోసం ప్రత్యేక మాన్యువల్ మోడ్; ఆటో దానికి ఎప్పుడూ మారదు. కాబట్టి ఒకే హోస్ట్ ఒక మోడ్‌లో సజీవంగా మరియు మరొక మోడ్‌లో మృతంగా ఉండవచ్చు."
    override fun catalogInactiveWarn(section: String, active: String) =
        "మీరు నిష్క్రియ విభాగం ${section} ను చూస్తున్నారు — ప్రస్తుతం అన్ని గణాంకాలు ${active} కు వెళ్తాయి, ఇక్కడకు కాదు."
    override val manageModeTitle = "మోడ్‌ను నిర్వహించు"
    override val manageResetRating = "రేటింగ్‌ను రీసెట్ చేయి"
    override fun manageResetHint(mode: String) = "ప్రత్యేకంగా ${mode} కోసం మీరు సజీవ హోస్ట్‌ల రేటింగ్ మరియు వినియోగ గణాంకాలను రీసెట్ చేయవచ్చు. మీరు పూర్తిగా భిన్నమైన VPN లేదా LTE‌కి కనెక్ట్ అయినప్పుడు ఇది ఉపయోగకరం, తద్వారా పాత గణాంకాలు అడ్డుపడవు. లేదా ప్రాక్సీ స్కాన్ ప్రతిదాన్ని మొదటి నుండి ఎంత వేగంగా మళ్లీ తనిఖీ చేస్తుందో చూడటానికి."
    override val manageDeleteAll = "దీనిలో హోస్ట్‌లను తొలగించు"
    override fun manageDeleteHint(mode: String) = "మీరు ${mode} నుండి రేటింగ్ మరియు హోస్ట్‌లను రెండింటినీ క్లియర్ చేయవచ్చు. \"ప్రాక్సీలను స్కాన్ చేయి\" ఫీచర్ వాటిని మళ్లీ సేకరిస్తుంది. ఇది సబ్‌స్క్రిప్షన్ రీసెట్ కాదు — మీరు దానిని నొక్కి, మళ్లీ స్కాన్ కోసం ~15 నిమిషాలు వేచి ఉండవచ్చు."
    override fun manageCopyFrom(mode: String) = "మరొక మోడ్ నుండి ఈ మోడ్‌లోకి (${mode}) అన్ని హోస్ట్‌లను మరియు రేటింగ్‌లను కాపీ చేయి:"
    override val live = "సజీవ"; override val deadW = "మృత"; override val unitMs = "మిసె"
    override val agoMin = "ని"; override val agoHour = "గం"; override val agoDay = "రో"

    override val connectTelegram = "Telegram కనెక్ట్ చేస్తోంది"; override val readCarefully = "జాగ్రత్తగా చదవండి!"
    override val guideIntro = "ఈ యాప్ సెటప్ లేకుండా పనిచేయదు. క్రింది 3 ఎంపికలలో ఏదైనా ఒకదాన్ని ఎంచుకుని " +
        "సూచనలను జాగ్రత్తగా అనుసరించండి."
    override val variant1 = "ఎంపిక #1 — బటన్‌లు"
    override val variant1Body = "\"ప్రాక్సీ {A}\" నొక్కండి — Telegram తెరుచుకుంటుంది, ప్రాక్సీని జోడించడాన్ని నిర్ధారించండి. ఈ " +
        "స్క్రీన్‌కు తిరిగి వచ్చి \"ప్రాక్సీ {B}\" నొక్కండి — రెండవసారి జోడించడాన్ని నిర్ధారించండి.\n\nTelegram‌లో ఏదైనా " +
        "ఇతర పాత ప్రాక్సీలను నిలిపివేయండి. ఖచ్చితంగా 2 ప్రాక్సీలు మాత్రమే మిగలాలి — {A} మరియు {B} పోర్ట్‌లతో. " +
        "ఏ ఇతర సెట్‌తోనూ AutoConnector పనిచేయదు."
    override val variant2 = "ఎంపిక #2 — లింక్‌లు"
    override val variant2Body = "క్రింది వచనాన్ని Telegram‌లోని Saved Messages (లేదా ఏదైనా చాట్)‌లోకి కాపీ చేయండి — " +
        "అంటే మీకు మీరే పంపండి. మీ సందేశంలోని మొదటి లింక్‌ను నొక్కండి — మొదటి ప్రాక్సీ జోడించబడుతుంది. " +
        "రెండవ లింక్‌ను నొక్కండి — రెండవది జోడించబడుతుంది. తరువాత అన్ని పాత ప్రాక్సీలను నిలిపివేయండి."
    override val variant3 = "ఎంపిక #3 — మాన్యువల్‌గా"
    override val variant3Body = "SOCKS5 ప్రాక్సీని మాన్యువల్‌గా జోడించండి: సర్వర్ localhost (127.0.0.1), పోర్ట్ {A}. " +
        "తరువాత రెండవ ప్రాక్సీ: localhost, పోర్ట్ {B}. ఏదైనా పాత ప్రాక్సీలను తొలగించండి."
    override val whatNext = "తరువాత ఏమిటి?"
    override val whatNextBody = "Telegram‌లో, \"ప్రాక్సీ ఆటో-స్విచ్\"ను ప్రారంభించండి — 5 సెకన్లు. సక్రియంగా లేని లేదా " +
        "\"అందుబాటులో లేదు\"గా గుర్తించబడని ప్రాక్సీని (Telegram లోపల) మాన్యువల్‌గా నొక్కడం ద్వారా మీరు Telegram కనెక్ట్ " +
        "కావడానికి సహాయపడవచ్చు — అది Telegram మరింత గట్టిగా కనెక్ట్ అవ్వడానికి ప్రయత్నించేలా చేస్తుంది.\n\n{A} మరియు {B} " +
        "తప్ప అన్ని ఇతర పాత ప్రాక్సీలు తొలగించబడ్డాయని నిర్ధారించుకోండి. Telegram‌లో " +
        "\"ప్రాక్సీని ఉపయోగించు\" నొక్కండి.\n\nయాప్ తగినన్ని ప్రాక్సీలను కనుగొని డౌన్‌లోడ్ చేసే వరకు వేచి ఉండండి " +
        "(5–15 నిమిషాలు). అప్పుడు Telegram స్వయంగా AutoConnector‌కు కనెక్ట్ అవుతుంది, ఇది " +
        "Telegram‌ను ఉత్తమ ప్రాక్సీల ద్వారా రూట్ చేస్తూనే ఉంటుంది: ధృవీకరించబడిన, సజీవ మరియు వేగవంతమైనవి.\n\nసూచనలు " +
        "కష్టంగా అనిపిస్తే — క్షమించండి, మీరు యాప్‌ను ఉపయోగించలేరు: ప్రతిదీ స్వయంచాలకంగా సెటప్ చేయడం " +
        "అసాధ్యం, మరియు సజీవ ప్రాక్సీలను కనుగొనడానికి సమయం పడుతుంది.\n\nమీరు యాప్‌ను చాలా కాలం క్రితం డౌన్‌లోడ్ చేసి " +
        "సజీవ ప్రాక్సీలు ఏవీ కనుగొనబడకపోతే — యాప్ లేదా సబ్‌స్క్రిప్షన్ జాబితాను నవీకరించండి. ఈ యాప్ " +
        "తన సొంత ప్రాక్సీలను కనిపెట్టదు లేదా అందించదు, ఇది డజన్ల కొద్దీ " +
        "సమూహాలు మరియు పేజీలలో ఇంటర్నెట్‌లో మాత్రమే వెతుకుతుంది."
    override fun proxyBtn(port: Int) = "ప్రాక్సీ ${port}"

    override val setupPortsTitle = "Telegram‌లో పోర్ట్‌లను సెటప్ చేయి"
    override val setupPortsSub = "Telegram‌ను కనెక్టర్‌కు ఎలా కనెక్ట్ చేయాలి (పోర్ట్‌లు 55001/55002)"
    override val settings = "సెట్టింగ్‌లు"; override val settingsSub = "పోర్ట్‌లు, యాంటీ-DPI, స్కాన్, నెట్‌వర్క్, బ్యాటరీ"
    override val subscriptions = "సబ్‌స్క్రిప్షన్‌లు"; override val subscriptionsSub = "స్కాన్ చేయడానికి ప్రాక్సీ మూలాలు"
    override val statistics = "గణాంకాలు"; override val statisticsSub = "ప్రాక్సీ డేటాబేస్ + యాంటీ-DPI ట్రిక్‌లు"
    override val export = "ఎగుమతి"; override val exportSub = "సజీవ ప్రాక్సీల tg:// లింక్‌లు"
    override val about = "గురించి"; override val aboutSub = "వెర్షన్, బిల్డ్, డౌన్‌లోడ్, అభిప్రాయం"
    override val hotkeys = "హాట్‌కీలు"
    override val hotkeysSub = "గ్లోబల్ కీలు: ప్రాక్సీని కాపీ / తెరువు"
    override val hotkeysIntro = "యాప్ విండో ఫోకస్‌లో లేనప్పుడు కూడా గ్లోబల్ హాట్‌కీలు పనిచేస్తాయి. అవి పూల్ నుండి " +
        "యాదృచ్ఛిక సజీవ ప్రాక్సీ లింక్‌ను (tg://) ఎంచుకుంటాయి — యాప్‌ను తెరవకుండా ప్రాక్సీలను త్వరగా మార్చడానికి " +
        "ఉపయోగకరం."
    override val hotkeysNote = "macOS‌లో, కీలను క్యాప్చర్ చేయడానికి Accessibility అనుమతి అవసరం కావచ్చు " +
        "(System Settings → Privacy & Security → Accessibility)."
    override val hotkeyCopyTitle = "ప్రాక్సీ లింక్‌ను కాపీ చేయి"
    override val hotkeyCopyDesc = "యాదృచ్ఛిక సజీవ tg:// లింక్‌ను క్లిప్‌బోర్డ్‌లో ఉంచుతుంది."
    override val hotkeyEnable = "హాట్‌కీలను ప్రారంభించు"; override val hotkeyLetterLabel = "అక్షరం"; override val hotkeySet = "సెట్ చేయి"; override val hotkeyReset = "రీసెట్"
    override val hotkeyOpenTitle = "ప్రాక్సీని Telegram‌లో తెరువు"
    override val hotkeyOpenDesc = "యాదృచ్ఛిక సజీవ లింక్‌ను తెరుస్తుంది — Telegram దానిని తీసుకుని ప్రాక్సీని కనెక్ట్ చేయడానికి అందిస్తుంది."

    override val relayPorts = "రిలే పోర్ట్‌లు"
    override val relayPortsHelp = "కనెక్టర్ వింటున్న స్థానిక పోర్ట్‌లు. మీరు వీటిని ఖచ్చితంగా " +
        "Telegram‌లో SOCKS5 ప్రాక్సీగా నమోదు చేస్తారు (127.0.0.1 : పోర్ట్). విశ్వసనీయత కోసం రెండు పోర్ట్‌లు ఉపయోగించబడతాయి — Telegram " +
        "రెండింటికీ కనెక్షన్‌లను నిలుపుకుంటుంది."
    override val portA = "పోర్ట్ A"; override val portB = "పోర్ట్ B"
    override val antiDpiTrick = "యాంటీ-DPI ట్రిక్"
    override val antiDpiHelp = "ISP/DPI గుర్తించి బ్లాక్ చేయకుండా కనెక్షన్‌ను మారువేషంలో ఉంచే " +
        "మార్గం.\n• \"ఆటో-రొటేట్\" స్వయంగా పనిచేసే ట్రిక్‌ను ఎంచుకుంటుంది.\n• \"DPI ట్రిక్‌లు లేవు\" — సాధారణ " +
        "కనెక్షన్.\n• మిగిలినవి నిర్దిష్ట పద్ధతులు (బ్రౌజర్ అనుకరణ, ప్యాకెట్ విభజన, మొదలైనవి)."
    override val onlyFakeTls = "FakeTLS మాత్రమే (ee)"
    override val applyDpiTo = "యాంటీ-DPI ని దీనికి వర్తింపజేయి"
    override val applyDpiHelp = "ఎంచుకున్న యాంటీ-DPI ట్రిక్‌ను దేనికి వర్తింపజేయాలి:\n• Telegram రిలే — కనెక్టర్ ద్వారా " +
        "సజీవ Telegram కనెక్షన్‌కు.\n• ప్రాక్సీ ప్రోబ్‌లు — నేపథ్య ప్రాక్సీ తనిఖీలకు " +
        "(అప్పుడు తనిఖీ నిజమైన కనెక్షన్ లాగే ప్రవర్తిస్తుంది, మరియు ట్రిక్ గణాంకాలు మరింత ఖచ్చితంగా ఉంటాయి).\n" +
        "• నేరుగా కనెక్ట్ అయినప్పుడు — ప్రాక్సీలు ఆఫ్‌లో ఉన్నప్పుడు (లేదా VPN ఆన్‌లో ఉన్నప్పుడు దాటవేయబడినప్పుడు) మరియు Telegram " +
        "నేరుగా తన సర్వర్‌లకు వెళ్తుంది: ఇక్కడ ప్రాక్సీ లేదు, కాబట్టి ట్రిక్ మొదటి TCP ప్యాకెట్‌ను (హ్యాండ్‌షేక్) " +
        "DPI ఒక రీడ్‌లో సరిపోల్చలేనట్లు అనేక చిన్న విభాగాలుగా విభజించడానికి తగ్గిస్తుంది."
    override val toRelay = "Telegram రిలే"; override val toProbes = "ప్రాక్సీ ప్రోబ్‌లు"
    override val toDirect = "నేరుగా కనెక్ట్ అయినప్పుడు"
    override val vpnSection = "VPN ఆన్‌లో ఉన్నప్పుడు"
    override val vpnHelp = "పరికరంలో VPN సక్రియంగా ఉన్నప్పుడు ఏమి చేయాలి:\n• MTProto ప్రాక్సీ ద్వారా — " +
        "Telegram ఎప్పటిలాగే కనుగొన్న ప్రాక్సీల ద్వారా వెళ్తుంది (VPN పైన).\n• నేరుగా — " +
        "కనెక్టర్ ప్రాక్సీలను ఉపయోగించదు మరియు Telegram‌ను నేరుగా Telegram సర్వర్‌లకు కనెక్ట్ చేస్తుంది: " +
        "VPN ఇప్పటికే ప్రాప్యతను అందిస్తుంది, అదనపు ప్రాక్సీ పొర అవసరం లేదు (వేగంగా మరియు మరింత స్థిరంగా). " +
        "VPN లేకుండా ప్రాక్సీలు ఎప్పటిలాగే ఉపయోగించబడతాయి."
    override val linkFormat = "ప్రాక్సీ లింక్ ఫార్మాట్"
    override val linkFormatHelp = "ప్రాక్సీలను ఎలా కాపీ చేసి తెరవాలి. tg:// Telegram‌ను నేరుగా తెరుస్తుంది (Telegram Desktop ఇన్‌స్టాల్ చేయాల్సి ఉంటుంది). http (t.me) బ్రౌజర్ ద్వారా తెరిచి Telegram‌లో తెరవడానికి అందిస్తుంది — tg:// నమోదు చేయబడకపోతే ఉపయోగకరం."
    override val linkTg = "tg:// (Telegram‌ను నేరుగా తెరువు)"; override val linkTgSub = "tg://proxy?… — Telegram‌ను తెరుస్తుంది"
    override val linkHttp = "http (t.me, బ్రౌజర్ ద్వారా)"; override val linkHttpSub = "https://t.me/proxy?… — బ్రౌజర్‌ను తెరుస్తుంది"
    override val viaMtproto = "MTProto ద్వారా ప్రాక్సీ"; override val viaMtprotoSub = "VPN ఉన్నప్పటికీ, ట్రాఫిక్ ప్రాక్సీల ద్వారా వెళ్తుంది"
    override val directly = "నేరుగా కనెక్ట్ చేయి"; override val directlySub = "VPN సక్రియంగా ఉన్నప్పుడు — ప్రాక్సీలను దాటవేసి, నేరుగా Telegram‌కు"
    override val notifications = "నోటిఫికేషన్‌లు"
    override val scanCheck = "స్కాన్ & తనిఖీ"
    override val scanCheckHelp = "• స్కాన్, నిమి — సబ్‌స్క్రిప్షన్‌ల నుండి ప్రాక్సీ జాబితాలను ఎంత తరచుగా డౌన్‌లోడ్ చేయాలి.\n" +
        "• తనిఖీ, నిమి — డేటాబేస్‌లోని ప్రాక్సీలను సజీవత్వం కోసం ఎంత తరచుగా మళ్లీ తనిఖీ చేయాలి.\n• బ్యాచ్ పరిమాణం — " +
        "ప్రతి రన్‌కు ఎన్ని ప్రాక్సీలను తనిఖీ చేయాలి.\n• సమాంతర — ఒకేసారి ఎన్ని తనిఖీలను నడపాలి (ఎక్కువ = " +
        "వేగంగా, కానీ ఎక్కువ నెట్‌వర్క్ మరియు బ్యాటరీ లోడ్)."
    override val scanMin = "స్కాన్, నిమి"; override val checkMin = "తనిఖీ, నిమి"; override val batchSize = "బ్యాచ్ పరిమాణం"; override val parallel = "సమాంతర"
    override val speedByNet = "నెట్‌వర్క్ ద్వారా స్కాన్ తీవ్రత"
    override val speedByNetHelp = "ప్రస్తుత నెట్‌వర్క్‌పై ఆధారపడి ప్రాక్సీలను ఎంత తరచుగా తనిఖీ చేయాలి. " +
        "\"ప్రామాణికం\" = ప్రాథమిక విరామం. అరుదుగా కోసం కుడివైపుకు జరపండి (నెమ్మదిగా, ట్రాఫిక్/బ్యాటరీపై మృదువుగా), " +
        "ఎక్కువ తరచుగా కోసం ఎడమవైపుకు (వేగంగా, మరింత దూకుడుగా). లాగరిథమిక్ స్కేల్, ప్రతి దిశలో ×100 వరకు.\n" +
        "• VPN — బాహ్య VPN సక్రియంగా ఉన్నప్పుడు.\n• Wi-Fi — Wi-Fi నెట్‌వర్క్‌లో.\n• LTE — మొబైల్ నెట్‌వర్క్‌లో."
    override val intensStandard = "ప్రామాణికం"
    override val intensSlower = "నెమ్మదిగా"
    override val intensFaster = "వేగంగా"
    override val maintenance = "డేటాను రీసెట్ చేయి"
    override val maintenanceHelp = "• \"కేటలాగ్ & గణాంకాలను రీసెట్ చేయి\" — రేటింగ్‌లు, కౌంటర్‌లు, ట్రాఫిక్ " +
        "మరియు తనిఖీ లాగ్‌లను సున్నా చేస్తుంది, కానీ డౌన్‌లోడ్ చేసిన హోస్ట్‌లు మరియు సబ్‌స్క్రిప్షన్‌లను ఉంచుతుంది (తదుపరి స్కాన్‌లో " +
        "ప్రతిదీ మళ్లీ రేట్ చేయబడుతుంది).\n• \"డౌన్‌లోడ్ చేసిన హోస్ట్‌లను క్లియర్ చేయి\" — మొత్తం ప్రాక్సీ పూల్‌ను తొలగిస్తుంది కానీ " +
        "సబ్‌స్క్రిప్షన్‌లను ఉంచుతుంది తద్వారా స్కాన్ పూల్‌ను తిరిగి నింపుతుంది. ఏ విధంగానూ సబ్‌స్క్రిప్షన్‌లు ఎప్పుడూ తాకబడవు."
    override val backupTitle = "ఎగుమతి / దిగుమతి"
    override val backupHelp = "యాప్ డేటాను JSON‌గా సేవ్ చేయండి లేదా పునరుద్ధరించండి. ఏమి " +
        "చేర్చాలో టిక్ చేయండి — ఏదైనా కలయిక:\n• సెట్టింగ్‌లు — అన్ని యాప్ పారామితులు.\n• సబ్‌స్క్రిప్షన్‌లు — మూల " +
        "జాబితా (URL + ఆన్/ఆఫ్).\n• సజీవ-హోస్ట్ కేటలాగ్ — ప్రతి నెట్‌వర్క్ మోడ్‌కు దాని రేటింగ్‌లు మరియు గణాంకాలతో ప్రతి సజీవ ప్రాక్సీ.\n\n\"ఎగుమతి\" సిద్ధంగా ఉన్న JSON‌తో ఒక పేజీని తెరుస్తుంది — దానిని కాపీ చేయండి లేదా ఫైల్‌కు సేవ్ చేయండి. " +
        "\"దిగుమతి\" — JSON ను పేస్ట్ చేయండి (లేదా ఫైల్‌ను లోడ్ చేయండి) మరియు అందులో ఉన్న టిక్ చేసిన విభాగాలను మాత్రమే " +
        "ఇది వర్తింపజేస్తుంది. దిగుమతి ప్రస్తుత డేటాకు చేరుస్తుంది (తుడిచివేయదు)."
    override val backupSettings = "సెట్టింగ్‌లు"
    override val backupSubs = "సబ్‌స్క్రిప్షన్‌లు"
    override val backupHosts = "సజీవ-హోస్ట్ కేటలాగ్ (మోడ్ ప్రకారం)"
    override val exportWord = "ఎగుమతి"
    override val importWord = "దిగుమతి"
    override val backupExportTitle = "డేటాను ఎగుమతి చేయి"
    override val backupImportTitle = "డేటాను దిగుమతి చేయి"
    override val backupSelectExport = "ఏమి ఎగుమతి చేయాలి:"
    override val backupSelectImport = "ఏమి దిగుమతి చేయాలి:"
    override val backupCopyBtn = "కాపీ"
    override val backupSaveFile = "ఫైల్‌కు సేవ్ చేయి"
    override val backupLoadFile = "ఫైల్ నుండి లోడ్ చేయి"
    override val backupDoImport = "దిగుమతి"
    override val backupPasteLabel = "బ్యాకప్ JSON ను ఇక్కడ పేస్ట్ చేయండి"
    override val backupJsonLabel = "బ్యాకప్ JSON"
    override val backupAndroidFileNote = "ఇక్కడ ఫైల్‌లు అందుబాటులో లేవు — కాపీ / పేస్ట్ ఉపయోగించండి."
    override val eraseAllHosts = "అన్ని హోస్ట్‌లను తుడిచివేయి"
    override val factoryReset = "ప్రతిదీ రీసెట్ చేయి (మొదటి ప్రారంభం వలె)"
    override val factoryResetConfirm = "యాప్‌ను పూర్తిగా ఫ్యాక్టరీ స్థితికి రీసెట్ చేయాలా? అన్ని సెట్టింగ్‌లు మరియు మొత్తం " +
        "హోస్ట్ కేటలాగ్ తుడిచివేయబడతాయి, సబ్‌స్క్రిప్షన్‌లు డిఫాల్ట్‌లకు పునరుద్ధరించబడతాయి. మొదటి ప్రారంభం వలెనే."
    override val resetCatalog = "కేటలాగ్ & గణాంకాలను రీసెట్ చేయి"
    override val resetCatalogConfirm = "అన్ని రేటింగ్‌లు, కౌంటర్‌లు మరియు తనిఖీ లాగ్‌లను సున్నా చేయాలా? " +
        "డౌన్‌లోడ్ చేసిన హోస్ట్‌లు మరియు సబ్‌స్క్రిప్షన్‌లు ఉంచబడతాయి మరియు తదుపరి స్కాన్‌లో మళ్లీ రేట్ చేయబడతాయి."
    override val clearHosts = "డౌన్‌లోడ్ చేసిన హోస్ట్‌లను క్లియర్ చేయి"
    override val clearHostsConfirm = "డౌన్‌లోడ్ చేసిన హోస్ట్‌ల (ప్రాక్సీల) మొత్తం జాబితాను తొలగించాలా? " +
        "సబ్‌స్క్రిప్షన్‌లు ఉంచబడతాయి మరియు స్కాన్ పూల్‌ను తిరిగి నింపుతుంది."
    override val doReset = "రీసెట్"
    override val doCancel = "రద్దు చేయి"
    override val adaptiveSpeed = "అనుకూల వేగం"
    override val adaptiveHelp = "సజీవత్వ తనిఖీలు ప్రాథమిక విరామంలో నడుస్తాయి (\"స్కాన్ & తనిఖీ\" నుండి, " +
        "నెట్‌వర్క్ మల్టిప్లయర్‌తో కూడా గుణించబడుతుంది). \"అనుకూల వేగం\" ప్రస్తుతం ఎన్ని ప్రాక్సీలు సజీవంగా ఉన్నాయో " +
        "దాని ఆధారంగా వాటిని స్వయంచాలకంగా వేగవంతం చేస్తుంది లేదా నెమ్మదిస్తుంది.\n\n" +
        "• తక్కువ సజీవ (\"తక్కువ\" పరిమితి కంటే తక్కువ) → విరామం × \"వేగవంతం\". 1 కంటే తక్కువ మల్టిప్లయర్ = ఎక్కువ " +
        "తరచుగా: 0.5 — రెట్టింపు తరచుగా, 0.25 — 4×. పూల్‌ను వేగంగా తిరిగి నింపుతుంది.\n" +
        "• ఎక్కువ సజీవ (\"ఎక్కువ\" పరిమితి కంటే ఎక్కువ) → విరామం × \"నెమ్మది\". 1 కంటే ఎక్కువ = అరుదుగా: 2 — " +
        "సగం తరచుగా, 4 — పావు. బ్యాటరీ మరియు ట్రాఫిక్‌ను ఆదా చేస్తుంది.\n" +
        "• పరిమితుల మధ్య — ప్రాథమిక వేగం (×1).\n\n" +
        "ఉదాహరణలు:\n" +
        "— ప్రాక్సీలను వేగంగా సేకరించండి: \"వేగవంతం\" 0.25 మరియు/లేదా \"తక్కువ\" పరిమితి 40.\n" +
        "— మీకు తగినన్ని ఉన్నప్పుడు బ్యాటరీని ఆదా చేయండి: \"నెమ్మది\" 8 మరియు/లేదా \"ఎక్కువ\" పరిమితి 30.\n" +
        "— అనుకూలతను నిలిపివేయండి: రెండు మల్టిప్లయర్‌లను 1 కు సెట్ చేయండి.\n\n" +
        "డిఫాల్ట్‌లు: తక్కువ 20, వేగవంతం 0.5, ఎక్కువ 50, నెమ్మది 4."
    override val threshMany = "\"ఎక్కువ\" పరిమితి"; override val threshFew = "\"తక్కువ\" పరిమితి"; override val mulFast = "వేగవంతం ×"; override val mulLazy = "నెమ్మది ×"
    override val subIntensityTitle = "సబ్‌స్క్రిప్షన్ తీవ్రత"
    override val subIntensityHint = "సబ్‌స్క్రిప్షన్ డౌన్‌లోడ్‌ల మధ్య విరామం: ప్రాక్సీ జాబితాలను మళ్లీ డౌన్‌లోడ్ చేయడానికి ఎన్ని నిమిషాలు (ప్రతి నెట్‌వర్క్ మోడ్‌కు విడిగా)."
    override val baseScanTitle = "ప్రాథమిక స్కాన్ వేగం"
    override val baseScanHelp = "సూచన సజీవత్వ-తనిఖీ వేగం. \"అనుకూల వేగం\" మరియు \"మోడ్ ద్వారా వేగం\" " +
        "మల్టిప్లయర్‌లు దీనికి సంబంధించి లెక్కించబడతాయి.\n\n" +
        "• ఎంత తరచుగా నడపాలి, నిమి — తనిఖీ పాస్‌ల మధ్య విరామం.\n" +
        "• థ్రెడ్‌కు బ్యాచ్, హోస్ట్‌లు — ప్రతి థ్రెడ్ ప్రతి పాస్‌కు ఎన్ని హోస్ట్‌లను తనిఖీ చేస్తుంది.\n" +
        "• థ్రెడ్‌లు — ఒకేసారి ఎన్ని తనిఖీలు నడుస్తాయి. ఒక పాస్ \"బ్యాచ్ × థ్రెడ్‌లు\" హోస్ట్‌లను ప్రోబ్ చేస్తుంది.\n" +
        "• ఒక హోస్ట్‌ను ప్రతి N నిమికి ఒకసారి కంటే ఎక్కువ తరచుగా మళ్లీ స్కాన్ చేయవద్దు — యాంటీ-ఫ్లడ్: ఇటీవల తనిఖీ చేసిన హోస్ట్ " +
        "ఈ పాస్‌లో దాటవేయబడుతుంది.\n\n" +
        "ఎక్కువ థ్రెడ్‌లు మరియు పెద్ద బ్యాచ్ = వేగవంతమైన పూల్ పెరుగుదల, కానీ నెట్‌వర్క్ మరియు బ్యాటరీపై భారీ లోడ్."
    override val baseScanPeriod = "ఎంత తరచుగా నడపాలి, నిమి"
    override val baseScanBatch = "థ్రెడ్‌కు బ్యాచ్, హోస్ట్‌లు"; override val baseScanThreads = "థ్రెడ్ సంఖ్య"
    override val adaptiveDesc = "సజీవ ప్రాక్సీలు \"తక్కువ\" కంటే తక్కువగా లేదా \"ఎక్కువ\" కంటే ఎక్కువగా ఉంటే, అదనపు మల్టిప్లయర్‌ను వర్తింపజేయి."
    override val fewWord = "తక్కువ"; override val manyWord = "ఎక్కువ"
    override fun fasterX(x: String) = "${x}× వేగంగా"
    override fun slowerX(x: String) = "${x}× నెమ్మదిగా"
    override fun ifAliveLt(n: Int) = "సజీవ ప్రాక్సీలు < ${n} అయితే, అప్పుడు:"
    override fun ifAliveGt(n: Int) = "సజీవ ప్రాక్సీలు > ${n} అయితే, అప్పుడు:"
    override val disabledWord = "ఆఫ్"
    override val speedByModeTitle = "మోడ్ ద్వారా వేగం"
    override val speedByModeHelp = "ప్రాథమిక వేగంపై, ప్రతి నెట్‌వర్క్ మోడ్‌కు స్కాన్-వేగం " +
        "మల్టిప్లయర్. \"ప్రామాణికం\" (×1) = ప్రాథమిక విరామం. కుడి — అరుదుగా (నెమ్మదిగా, ట్రాఫిక్/" +
        "బ్యాటరీపై మృదువుగా), ఎడమ — ఎక్కువ తరచుగా (వేగంగా, మరింత దూకుడుగా). లాగరిథమిక్ స్కేల్, ప్రతి దిశలో ×100 " +
        "వరకు.\n\n" +
        "ప్రతి స్లయిడర్ కింద అనుకూల వేగం వర్తింపజేయబడిన ఫలిత పాస్ పారామితులు ఉన్నాయి — " +
        "\"తక్కువ సజీవ\" (× \"వేగవంతం\") మరియు \"ఎక్కువ సజీవ\" (× \"నెమ్మది\") కోసం విడిగా చూపబడతాయి.\n\n" +
        "మోడ్‌లు:\n• VPN — బాహ్య VPN సక్రియంగా ఉంది.\n• LTE — మొబైల్ నెట్‌వర్క్.\n• Wi-Fi — Wi-Fi నెట్‌వర్క్.\n" +
        "• Ethernet — వైర్డ్ కనెక్షన్.\n• White — మాన్యువల్ \"white\" ప్రాక్సీ మోడ్."
    override val aliveLt = "సజీవ <"; override val aliveGt = "సజీవ >"
    override val periodWord = "వ్యవధి"; override val nonstopWord = "నిరంతరం"
    override val batchWord = "బ్యాచ్"; override val threadsWord = "థ్రెడ్‌లు"; override val scanModeOff = "స్కాన్ ఆఫ్"
    override val netBattery = "నెట్‌వర్క్ & బ్యాటరీ"
    override val netBatteryHelp = "• Wi-Fi మాత్రమే — మొబైల్ నెట్‌వర్క్‌లలో స్కాన్ చేయవద్దు (డేటాను ఆదా చేస్తుంది).\n• చార్జింగ్ " +
        "మాత్రమే — ఫోన్ చార్జింగ్‌లో ఉన్నప్పుడు మాత్రమే పనిచేయి.\n• తక్కువ బ్యాటరీలో దాటవేయి — బ్యాటరీ " +
        "తక్కువగా ఉన్నప్పుడు స్కానింగ్‌ను పాజ్ చేయి."
    override val onlyWifi = "Wi-Fi మాత్రమే"; override val onlyCharging = "చార్జింగ్ మాత్రమే"; override val skipLowBattery = "తక్కువ బ్యాటరీలో దాటవేయి"
    override val autosaved = "సెట్టింగ్‌లు స్వయంచాలకంగా సేవ్ చేయబడతాయి."
    override val dpiAutoLabel = "DPI ట్రిక్‌లను ఆటో-రొటేట్ చేయి"; override val dpiNoneLabel = "DPI ట్రిక్‌లు లేవు (సాధారణం)"
    override val experimental = "ప్రయోగాత్మకం"
    override val experimentalHelp = "MTProto అప్‌స్ట్రీమ్‌కు ప్రత్యామ్నాయ ప్రాక్సీయింగ్ ఇంజిన్‌లు మరియు ఒక డయాగ్నొస్టిక్ లాగ్. " +
        "\"ఆఫ్\"కు సెట్ చేసినప్పుడు సూచన (పనిచేసే) మార్గం మారదు. గుప్తీకరించబడిన స్ట్రీమ్ అప్‌స్ట్రీమ్ TCP సాకెట్‌కు ఎలా " +
        "వ్రాయబడుతుందో మాత్రమే మారుతుంది (విభాగ పరిమాణాలు, టైమింగ్, TLS-రికార్డ్ సరిహద్దులు) — స్ట్రీమ్ స్వయంగా బైట్-బై-బైట్ ఒకేలా ఉంటుంది. " +
        "ఇది సజీవ ప్రాక్సీ రిలేకు మాత్రమే వర్తిస్తుంది (ప్రోబ్‌లకు కాదు, డైరెక్ట్ మార్గానికి కాదు)."
    override val expEngineTitle = "ప్రాక్సీయింగ్ ఇంజిన్ (సాకెట్ అస్పష్టీకరణ)"
    override val expConnectTitle = "కనెక్ట్ ఇంజిన్ (అప్‌స్ట్రీమ్ ఎంపిక)"
    override val expEngineWarn = "⚠ ప్రయోగాత్మక మోడ్. కనెక్టివిటీ దిగజారితే, \"ఆఫ్ (సూచన మార్గం)\"కు తిరిగి మారండి."
    override val netLog = "నెట్‌వర్క్-ఎక్స్‌చేంజ్ లాగ్‌ను ప్రారంభించు"
    override val netLogSub = "ఎవరికి-ఎవరి-ఎప్పుడు మరియు ప్యాకెట్ పరిమాణాలను ఫైల్‌కు వ్రాస్తుంది (పేలోడ్ డేటా లేదు) — " +
        "VPN ఉన్నప్పుడు మరియు లేనప్పుడు ఎక్స్‌చేంజ్ నమూనాను పోల్చడానికి."
    override val openLogFolder = "లాగ్ ఫోల్డర్‌ను తెరువు"; override val copyPath = "పాత్‌ను కాపీ చేయి"
    override val helpShow = "సహాయం"; override val helpHide = "సహాయం దాచు"
    override val quickSwitchIntro = "ఇక్కడ మీరు బ్లాక్-బైపాస్ ట్రిక్‌ను ఎంచుకోవచ్చు. Telegram లోపం " +
        "“మీరు ఉపయోగిస్తున్న ప్రాక్సీ సరిగ్గా కాన్ఫిగర్ చేయబడలేదు మరియు నిలిపివేయబడుతుంది. దయచేసి మరొకటి " +
        "కనుగొనండి” చూపిస్తే, Telegram దానిని చూపించడం ఆపేలా ఏ ట్రాఫిక్-అస్పష్టీకరణ రకం పనిచేస్తుందో ప్రయోగించండి. " +
        "split* మోడ్‌లతో ప్రారంభించండి. coalesce* మోడ్‌లు కూడా పనిచేస్తాయి, కానీ వాటితో Telegram‌లో చిత్రాలు/వీడియోలు సరిగ్గా లోడ్ కావు."
    override val quickSwitchTitle ="బ్లాక్ బైపాస్"; override val quickSwitchSub = "షేపింగ్, కనెక్ట్, యాంటీ-DPI"

    override val sourceUrl = "మూల URL"
    override fun sourceAlive(alive: Int, total: Int) = "సజీవ ${alive}/${total}"
    override val open = "తెరువు"; override val active = "సక్రియం"; override val inactive = "నిష్క్రియం"
    override val lastDownloaded = "డౌన్‌లోడ్ చేయబడింది"; override val notDownloaded = "ఇంకా డౌన్‌లోడ్ చేయలేదు"
    override fun sourceCounts(dead: Int, total: Int) =
        " సజీవ, ${dead} మృత, ${total} మొత్తం"

    override val proxyBase = "ప్రాక్సీ డేటాబేస్"
    override val totalInBase = "డేటాబేస్‌లో మొత్తం"; override val aliveNow = "ఇప్పుడు సజీవ"; override val deadStat = "మృత"
    override val aliveIn15 = "15 నిమిషాల్లో సజీవ"; override val checksAllTime = "మొత్తం సమయం తనిఖీలు"
    override val antiDpiTricks = "యాంటీ-DPI ట్రిక్‌లు"; override val noStatsYet = "ఇంకా డేటా లేదు — తనిఖీలు/కనెక్షన్‌లు జరుగుతున్నప్పుడు ట్రిక్‌లు పేరుకుపోతాయి"
    override val attempts = "ప్రయత్నాలు"; override val handshake = "హ్యాండ్‌షేక్"; override val score = "స్కోర్"
    override val tgConnect = "TG కనెక్ట్"; override val socketsOver1m = "సాకెట్‌లు >1నిమి"
    override val over10kb = "సాకెట్‌లు >10KB"; override val over100kb = ">100KB"; override val workTime = "పని సమయం"
    override val statsLegend = "హ్యాండ్‌షేక్ — విజయవంతమైన హ్యాండ్‌షేక్‌లు (ప్రయత్నాల %) · స్కోర్ — విలువ · " +
        "\"పని సమయం\" — ≥5KB మరియు 1 నిమిషం కంటే ఎక్కువ ఉన్న సాకెట్‌ల మొత్తం."
    override val resetStats = "ట్రిక్ గణాంకాలను రీసెట్ చేయి"

    override fun aliveLinks(n: Int) = "సజీవ లింక్‌లు: ${n}"
    override val copyAll = "అన్నీ కాపీ చేయి"
    override val openRandom = "యాదృచ్ఛికంగా తెరువు"; override val copyRandom = "యాదృచ్ఛికంగా కాపీ చేయి"; override val allShort = "అన్నీ"
    override val copyTop = "TOP కాపీ చేయి"; override val randomHost = "యాదృచ్ఛిక హోస్ట్"
    override val exportToFile = "ఫైల్‌కు ఎగుమతి చేయి"; override val exportSaved = "ఫైల్‌కు సేవ్ చేయబడింది:"
    override val dlNow = "ఇప్పుడు డౌన్‌లోడ్ చేయి"
    override fun downloadingFmt(sec: Long) = "డౌన్‌లోడ్ అవుతోంది… ${sec}సె"
    override val cancel = "రద్దు చేయి"
    override val deleteConfirmTitle = "సబ్‌స్క్రిప్షన్‌ను తొలగించాలా?"
    override val subscriptionsAddHint = "సబ్‌స్క్రిప్షన్‌లు లేదా ప్రాక్సీ లింక్‌లను జోడించండి →"
    override val addSourcesTitle = "జోడించు"
    override val addSubsLabel = "సబ్‌స్క్రిప్షన్‌లు (లైన్‌కు ఒక URL)"
    override val addSubsHelp = "చెల్లుబాటు అయ్యే URL ఉన్న ప్రతి లైన్ దాని స్వంత సబ్‌స్క్రిప్షన్ అవుతుంది మరియు కాలానుగుణంగా పొందబడుతుంది."
    override val addProxiesLabel = "సిద్ధంగా ఉన్న ప్రాక్సీ లింక్‌లు (స్థిర జాబితా)"
    override val addProxiesHelp = "నిర్దిష్ట ప్రాక్సీలకు లింక్‌ల బ్యాచ్‌ను పేస్ట్ చేయండి (tg://proxy, https://t.me/proxy, …). ఇది సబ్‌స్క్రిప్షన్ కాదు — జాబితా ఎప్పుడూ డౌన్‌లోడ్ చేయబడదు, ప్రాక్సీలు కేవలం కేటలాగ్‌కు జోడించబడతాయి."
    override val addButton = "జోడించు"
    override fun addedFmt(subs: Int, proxies: Int) = "జోడించబడింది: ${subs} సబ్‌స్క్రిప్షన్‌లు, ${proxies} ప్రాక్సీలు"
    override val perSecond = "సెకనుకు"
    override val graphSpeed = "వేగం"
    override val graphVolume = "పరిమాణం"
    override val graphLatency = "పింగ్"
    override val graphConnects = "కనెక్ట్‌లు"
    override val scanNow = "ఇప్పుడు స్కాన్ చేయి"; override val scanOnShort = "స్కాన్ ఆన్"
    override val scanRunning = "స్కాన్ నడుస్తోంది"; override val scanIdle = "స్కాన్ నిష్క్రియం"; override val scanOffState = "స్కాన్ ఆఫ్"; override val scanBatchPerThread = "థ్రెడ్‌కు బ్యాచ్"; override val scanPassHosts = "పాస్‌లో హోస్ట్‌లు"; override val minRescanLabel = "ఒక హోస్ట్‌ను ప్రతి N నిమికి ఒకసారి కంటే ఎక్కువ తరచుగా మళ్లీ స్కాన్ చేయవద్దు"
    override val scanPlanTitle = "ప్రణాళిక"; override val scanNowTitle = "ఇప్పుడు"; override val currentScheduleTitle = "ప్రస్తుత షెడ్యూల్"
    override val scheduleWord = "షెడ్యూల్"; override val unitPcsPerSec = "ముక్కలు/సె"
    override val scanNowThreadsLabel = "ఇప్పుడు నడుస్తున్న థ్రెడ్‌లు"; override val scanNowPerThreadLabel = "థ్రెడ్‌కు తనిఖీలు (ప్రణాళిక)"; override val scanNowElapsedLabel = "నడుస్తున్న సమయం"
    override val scanOkGraph = "విజయవంతమైన స్కాన్‌లు"; override val scanFailGraph = "విఫలమైన స్కాన్‌లు"; override val scanTrafficGraph = "స్కాన్ ట్రాఫిక్"; override val scanAliveGraph = "మొత్తం సజీవ ప్రాక్సీలు"; override val scanPingGraph = "పింగ్"; override val threadsGraph = "థ్రెడ్‌లు"
    override val scanEvery = "ప్రతి"; override val scanNextRun = "తదుపరి రన్"
    override val scanThreads = "థ్రెడ్‌లు"; override val scanBatch = "బ్యాచ్"
    override val scanElapsed = "నడుస్తోంది"; override val scanIdleNow = "—"
    override val effForFew = "తక్కువ ఉన్నప్పుడు"; override val effForMany = "ఎక్కువ ఉన్నప్పుడు"
    override val effCheck = "తనిఖీ"; override val effBatch = "బ్యాచ్"; override val effPar = "సమాంతర"
    override val effContinuous = "నిరంతర"; override val secShort = "సె"; override val minShort = "నిమి"

    override val appTagline = "క్రాస్-ప్లాట్‌ఫారమ్ ఆటో-కనెక్టర్: ఇది Telegram పనిచేసే MTProto ప్రాక్సీలను " +
        "కనుగొంటుంది, తనిఖీ చేస్తుంది మరియు నడుపుతుంది."
    override val version = "వెర్షన్"; override val buildDate = "బిల్డ్ తేదీ"
    override val downloadSources = "డౌన్‌లోడ్ & మూలాలు"; override val openOnGithub = "GitHub‌లో తెరువు"
    override val feedbackBugs = "అభిప్రాయం & బగ్ నివేదికలు"; override val writeTelegram = "Telegram‌లో వ్రాయండి"

    override val language = "భాష"; override val langAuto = "ఆటో (సిస్టమ్)"; override val langRu = "Русский"; override val langEn = "English"
    override val langFa = "فارسی"; override val langZh = "简体中文"; override val langAr = "العربية"; override val langUr = "اردو"
    override val langTr = "Türkçe"; override val langId = "Bahasa Indonesia"; override val langHi = "हिन्दी"; override val langBn = "বাংলা"; override val langMy = "မြန်မာ"
    override val langWord = "భాష"
    override val raceWidthTitle = "సమాంతర కనెక్ట్‌లు"
    override val connectionSection = "కనెక్షన్ & బ్లాక్ బైపాస్"
    override val connectionSectionHelp = "కనెక్ట్ ఇంజిన్, సమాంతర అప్‌స్ట్రీమ్‌లు, ప్రాక్సీయింగ్ ఇంజిన్ మరియు యాంటీ-DPI ట్రిక్‌లు — అన్నీ ఒకే విభాగంలో."
    override val netLogSection = "నెట్‌వర్క్ ఎక్స్‌చేంజ్ లాగ్"
    override val platform = "ప్లాట్‌ఫారమ్"

    override val scanModeTitle = "నెట్‌వర్క్ మోడ్"; override val scanModeAuto = "ఆటో"; override val scanModeManualLabel = "మాన్యువల్"
    override val activeModeLabel = "సక్రియ మోడ్"; override val formingListLabel = "జాబితాను రూపొందిస్తోంది"; override val catalogModeTabs = "మోడ్"
    override val resetModeRatings = "హోస్ట్ రేటింగ్‌లను రీసెట్ చేయి"; override val forgetModeHosts = "మోడ్ హోస్ట్‌లను మర్చిపో"
    override val exportModeTitle = "మోడ్ ద్వారా ఎగుమతి"; override val modePickerTitle = "మోడ్"
    override val modeHelp = "ప్రతి నెట్‌వర్క్ మోడ్ దాని స్వంత ప్రాక్సీ రేటింగ్‌లను మరియు దాని స్వంత స్కాన్ + సబ్‌స్క్రిప్షన్-డౌన్‌లోడ్ తీవ్రతను ఉంచుతుంది. \"ఆటో\" సక్రియ నెట్‌వర్క్ నుండి మోడ్‌ను ఎంచుకుంటుంది. \"మాన్యువల్\" మీకు ఏదైనా మోడ్‌ను మీరే ఎంచుకోవడానికి అనుమతిస్తుంది (ఆటో ఎప్పుడూ ఎంచుకోని White‌తో సహా)."
    override val autoSelect = "ఆటో ఎంపిక"; override val manualSelect = "మాన్యువల్ ఎంపిక"
    override val connStatsTitle = "ఇప్పుడు కనెక్షన్‌లు"; override val connOnPort = "పోర్ట్‌లో కనెక్షన్‌లు"; override val outgoingConns = "బయటకు వెళ్లే కనెక్షన్‌లు"
    override val modeChoice = "మోడ్ ఎంపిక"; override val autoChoice = "ఆటో-ఎంపిక"; override val manualChoice = "మాన్యువల్ స్థిరం"
    override val directOnVpn = "VPN‌లో TG‌కి డైరెక్ట్ కనెక్ట్"; override val onWord = "ఆన్"; override val offWord = "ఆఫ్"
    override val directStateActive = "సక్రియం"; override val directStateOff = "సెట్టింగ్‌లలో ఆఫ్"; override val directStateIdle = "సెట్టింగ్‌లలో ఆన్, కానీ సక్రియం కాదు"
    override val wpHintTitle = "White అంటే ఏమిటి?"
    override val wpHint = "White — WhitePages: ఒక మాన్యువల్ నెట్‌వర్క్ ప్రొఫైల్. చేతితో మాత్రమే ప్రారంభించబడుతుంది (ఆటో-ఎంపిక దానిని ఎప్పుడూ ఎంచుకోదు). " +
        "దాని స్వంత హోస్ట్ రేటింగ్‌లను ఉంచుతుంది, సబ్‌స్క్రిప్షన్‌లను డౌన్‌లోడ్ చేస్తుంది మరియు VPN/Wi-Fi/LTE‌తో సంబంధం లేకుండా స్వతంత్రంగా స్కాన్ చేస్తుంది."

    override val recentAttempts = "ఇటీవలి కనెక్ట్‌లు & తనిఖీలు"
    override val kindCheck = "తనిఖీ"
    override val kindTg = "Telegram"
    override val histWho = "ఎవరు"
    override val histWhen = "ఎప్పుడు"
    override val histReq = "అభ్యర్థన"
    override val histSess = "సెషన్"
    override val histScan = "స్కాన్"
    override val testNow = "ఇప్పుడు పరీక్షించు"
    override val testShort = "పరీక్ష"
    override val testResult = "పరీక్ష ఫలితం"
    override val testStop = "ఆపు"
    override val testingNow = "పరీక్షిస్తోంది…"
    override val prewarmTitle = "సాకెట్‌లను ముందుగా వేడిచేయి (ప్రయోగాత్మకం)"
    override val prewarmHelp = "కొన్ని అప్‌స్ట్రీమ్ ప్రాక్సీ సాకెట్‌లను ముందుగానే కనెక్ట్ చేసి ఉంచు, తద్వారా కొత్త " +
        "Telegram కనెక్షన్ కనెక్ట్/హ్యాండ్‌షేక్‌ను దాటవేయవచ్చు. ప్రయోగాత్మకం: ఇది నేపథ్యంలో నిరంతరం " +
        "మళ్లీ కనెక్ట్ అవుతూ ఉంటుంది, కాబట్టి ట్రాఫిక్ మరియు కొంత CPU ఖర్చు అవుతుంది. నకిలీ ట్రాఫిక్ " +
        "పంపబడదు (అది నిజమైన సెషన్‌ను పాడుచేస్తుంది) — సాకెట్‌లు కేవలం రొటేట్ చేయబడతాయి. " +
        "FakeTLS ప్రాక్సీలతో అత్యంత ఉపయోగకరం."
    override val prewarmEnable = "ముందుగా వేడిచేయడాన్ని ప్రారంభించు"
    override val prewarmModeDeferred = "వాయిదా (TLS మాత్రమే)"
    override val prewarmModeDeferredSub = "TCP + FakeTLS ను ఉంచు; హ్యాండ్-ఆఫ్ సమయంలో init పూర్తి చేయి. DC కమిట్ చేయబడదు — అత్యంత వాస్తవికం."
    override val prewarmModeFull = "పూర్తి హ్యాండ్‌షేక్"
    override val prewarmModeFullSub = "DC‌ల అంతటా పూర్తిగా కనెక్ట్ చేయబడిన సాకెట్‌లను ఉంచు; DC/tag సరిపోలినప్పుడు మాత్రమే మళ్లీ ఉపయోగించబడతాయి. తక్కువ జీవితకాలం."
    override val prewarmPoolLabel = "స్టాండ్‌బై సాకెట్‌లు"
    override val prewarmHoldLabel = "ప్రతిదాన్ని ఉంచు, సె"
    override val prewarmNote = "రొటేషన్ మాత్రమే (యాప్-స్థాయి keepalive లేదు). ప్రాక్సీ/DC ఆధారంగా ఒక సాకెట్ సెకన్ల నుండి ~ఒక నిమిషం వరకు జీవిస్తుంది."
    override val prewarmStatus = "ముందు-వేడి"
    override fun prewarmStatusVal(ready: Int, holdSecs: Int) = "${ready} సిద్ధం · ${holdSecs}సె ఉంచుతోంది"
    override val prewarmStar = "మందమైన నారింజ = ముందు-వేడి పూల్ నుండి వెచ్చగా అందించబడిన సాకెట్ (కనెక్ట్/హ్యాండ్‌షేక్ దాటవేయబడింది)"
    override fun prewarmTableTitle(holdSecs: Int) = "సాకెట్‌లను ముందుగా వేడిచేయి (${holdSecs}సె ఉంచుతోంది)"
    override val prewarmTableHelp = "\"సాకెట్‌లను ముందుగా వేడిచేయి\" కొన్ని ప్రాక్సీ సాకెట్‌లను ముందుగానే తెరుస్తుంది, తద్వారా కొత్త " +
        "Telegram కనెక్షన్ కనెక్ట్/హ్యాండ్‌షేక్‌ను దాటవేయవచ్చు. ఈ పట్టిక వేడిచేయబడుతున్న సాకెట్‌లను చూపిస్తుంది: ప్రతి ఒక్కటి " +
        "ఎంతకాలం జీవించింది, Telegram దాన్ని ఉపయోగిస్తోందా, మరియు ట్రాఫిక్. దీన్ని మరిన్ని → సెట్టింగ్‌లు → " +
        "\"సాకెట్‌లను ముందుగా వేడిచేయి (ప్రయోగాత్మకం)\"‌లో ఆన్/ఆఫ్ చేసి కాన్ఫిగర్ చేయవచ్చు (మోడ్, సాకెట్‌ల సంఖ్య, ఉంచే సమయం)."
    override val prewarmNoneWarming = "ఇంకా ఏ సాకెట్‌లు వేడి కావడం లేదు"
    override val prewarmColAge = "వయసు"
    override val prewarmColUse = "TG‌లో?"
    override val prewarmInUse = "TG‌లో"
    override val prewarmNew = "కొత్త"
    override val lanShareTitle = "LAN ద్వారా పంచు (వెబ్ పోర్టల్)"
    override val lanShareDesc = "ఈ Wi-Fi‌లోని ఇతర పరికరాలు ఈ AutoConnector‌ను ప్రాక్సీగా ఉపయోగించడానికి అనుమతించు; క్రింది చిరునామాను తెరిచే బ్రౌజర్ ఉత్తమ ప్రాక్సీల పేజీని పొందుతుంది."
    override val lanShareUrlsLabel = "పొరుగువారు ఇక్కడ కనెక్ట్ అవుతారు:"
    override val lanShareNoIp = "స్థానిక-నెట్‌వర్క్ చిరునామా లేదు — Wi-Fi‌కి కనెక్ట్ అవ్వండి"
    override val lanFirewallTitle = "స్థానిక నెట్‌వర్క్‌లో అనుమతించు"
    override val lanFirewallBody = "దీన్ని ప్రారంభించడం రిలే పోర్ట్‌లను మీ స్థానిక నెట్‌వర్క్‌కు తెరుస్తుంది. Windows (లేదా మరొక) ఫైర్‌వాల్ ఇప్పుడు AutoConnector‌ను అనుమతించాలా అని అడగవచ్చు — అనుమతించు / అవును ఎంచుకోండి. మీరు దాన్ని తిరస్కరిస్తే, AutoConnector‌కు పొరుగువారి ట్రాఫిక్ బ్లాక్ చేయబడుతుంది మరియు పేజీ/ప్రాక్సీ చేరుకోలేరు."
    override val lanFirewallConfirm = "ప్రారంభించు"
    override val lanInfoTitle = "ఇది దేనికోసం?"
    override val lanInfoBody = "మీ Wi-Fi‌లో ఒకే ఒక కంప్యూటర్ లేదా ఫోన్‌లో AutoConnector‌ను నడపండి, మరియు అదే నెట్‌వర్క్‌లోని ప్రతి ఇతర పరికరం — ఈ యాప్ నేరుగా మద్దతు ఇవ్వని iPhone‌తో సహా — బ్రౌజర్‌లో చిరునామాను తెరిచి దాన్ని ఉపయోగించవచ్చు: వారి Telegram‌కు జోడించడానికి ఉత్తమ ప్రాక్సీల పేజీ, లేదా ఈ పరికరమే SOCKS ప్రాక్సీగా. ఒక పరికరం ప్రాక్సీలను కనుగొని ఉంచుతుంది; మిగిలినవి LAN ద్వారా దాన్ని అరువు తీసుకుంటాయి."
    override val volTriggerTitle = "వాల్యూమ్-బటన్ ట్రిగ్గర్"
    override val volTriggerSub = "వేగవంతమైన వాల్యూమ్-కీ నమూనాతో ప్రాక్సీని మార్చు"
    override val volEnableLabel = "వాల్యూమ్ బటన్‌లను గమనించు"
    override val volHelpTitle = "ఇది ఏమిటి?"
    override val volHelpBody = "Android‌లో గ్లోబల్ కీబోర్డ్ హాట్‌కీలు లేవు, కాబట్టి ఇది బదులుగా వాల్యూమ్ బటన్‌లను ఉపయోగిస్తుంది. ప్రారంభించబడినప్పుడు, AutoConnector నేపథ్యంలో వేగవంతమైన వాల్యూమ్-అప్/డౌన్ నొక్కుల నమూనా (ఉదా. అప్-అప్-డౌన్-డౌన్) కోసం గమనిస్తుంది. దాన్ని గుర్తించినప్పుడు, అది యాదృచ్ఛిక మంచి, సజీవ ప్రాక్సీ యొక్క tg:// లింక్‌ను తెరుస్తుంది, తద్వారా Telegram దాన్ని తీసుకుని మారుతుంది — యాప్‌ను తెరవకుండా ప్రాక్సీని రొటేట్ చేయడానికి వేగవంతమైన, నిశ్శబ్ద మార్గం. వాల్యూమ్ సాధారణంగా పనిచేస్తూనే ఉంటుంది (నొక్కులు మింగబడవు). దీనికి Accessibility ప్రాప్యత అవసరం (నేపథ్యంలో వాల్యూమ్ కీలను చదవడానికి మరియు లింక్‌ను ప్రారంభించడానికి); మీరు టోగుల్‌ను ప్రారంభించే వరకు ఏదీ అభ్యర్థించబడదు. నొక్కుల మధ్య గరిష్ట సమయాన్ని క్రింద సెట్ చేయండి; గుర్తించబడిన నమూనాలు దిగువన జాబితా చేయబడ్డాయి."
    override val volGrantTitle = "Accessibility ను ప్రారంభించండి (ముఖ్యమైనది)"
    override val volGrantBody = "Android (ముఖ్యంగా 13+) Google Play నుండి ఇన్‌స్టాల్ చేయని యాప్‌లకు Accessibility ను బ్లాక్ చేస్తుంది — అందుకే AutoConnector బూడిద రంగులో ఉంది మరియు \"నిరోధిత సెట్టింగ్\" / \"ప్రాప్యత అనుమతించబడలేదు\" అని చూపిస్తుంది.\n\nఅన్‌బ్లాక్ చేయడం ఎలా:\n1. \"యాప్ సమాచారం\" తెరవండి (క్రింది బటన్, లేదా సెట్టింగ్‌లు → యాప్‌లు → AutoConnector for Telegram).\n2. ⋮ మెను (కుడి-ఎగువన) నొక్కండి → \"నిరోధిత సెట్టింగ్‌లను అనుమతించు\" → నిర్ధారించండి.\n3. తిరిగి వెళ్లండి: సెట్టింగ్‌లు → Accessibility → AutoConnector for Telegram → దాన్ని ఆన్ చేయండి.\n\n\"నిరోధిత సెట్టింగ్‌లను అనుమతించు\" మీకు కనిపించకపోతే, ముందుగా Accessibility‌లో దాన్ని ఒకసారి ఆన్ చేయడానికి ప్రయత్నించండి (మీకు బ్లాక్ చేయబడిన సందేశం వస్తుంది), తరువాత దశ 2 కనిపిస్తుంది.\n\nXiaomi/MIUI, Samsung మొదలైన వాటిలో మార్గం కొద్దిగా భిన్నంగా ఉండవచ్చు — \"యాప్ సమాచారం\"‌లో అదే ⋮ కోసం చూడండి. Android 12 మరియు పాతవాటిలో సాధారణంగా ఎటువంటి నిరోధం లేదు — Accessibility‌లో దాన్ని ఆన్ చేయండి.\n\nవాల్యూమ్ కీలు కేవలం గమనించబడతాయి, ఎప్పుడూ బ్లాక్ చేయబడవు."
    override val volOpenAppInfo = "యాప్ సమాచారం తెరువు"
    override val volAccessOn = "Accessibility: మంజూరు చేయబడింది"
    override val volAccessOff = "Accessibility: మంజూరు చేయలేదు"
    override val volOpenAccess = "Accessibility సెట్టింగ్‌లను తెరువు"
    override val volGapLabel = "నొక్కుల మధ్య గరిష్ట మిసె"
    override val volPatternsTitle = "గుర్తించబడిన నమూనాలు"
    override val volPatternPick = "నమూనా"
    override val volPatternsLegend = "↑ = వాల్యూమ్ అప్, ↓ = వాల్యూమ్ డౌన్"
    override val volNoRights = "వాల్యూమ్ బటన్‌లను నిర్వహించడానికి యాప్‌కు ఇంకా అనుమతి లేదు — ఈ పేజీ దిగువన ఉన్న దశలను ఉపయోగించి ప్రాప్యతను మంజూరు చేయండి."
    override val volGrantShort = "ఇంకా Accessibility ప్రాప్యత లేదు. ఈ పేజీ దిగువన ఉన్న వివరణాత్మక దశలను చదివి, తరువాత \"తనిఖీ\" నొక్కండి."
    override val volCheck = "తనిఖీ"
    override val volCheckOk = "✓ పూర్తయింది — ప్రాప్యత మంజూరు చేయబడింది, ట్రిగ్గర్ పనిచేస్తుంది."
    override val volCheckFail = "✗ ఇంకా ప్రాప్యత లేదు — పైన ఉన్న దశలను పూర్తి చేయండి."
    override val volPatternsList = "↑↑↓↓ · ↓↓↑↑ · ↑↓↑↓ · ↓↑↓↑ · ↑↑↑↑ · ↓↓↓↓ · ↑↓↓↑ · ↓↑↑↓ · ↑↑↑↓↓↓ · ↓↓↓↑↑↑   (↑ = వాల్యూమ్ అప్, ↓ = వాల్యూమ్ డౌన్)"
    override val histLegend = "నిలువు వరుసలు — ఎవరు: ✓/✗ TG = నిజమైన Telegram కనెక్ట్, స్కాన్ = నేపథ్య తనిఖీ. ఎప్పుడు: ఎంత కాలం క్రితం. TCP/TLS/అభ్యర్థన: హ్యాండ్‌షేక్ & మొదటి-అభ్యర్థన లేటెన్సీ, మిసె. సెషన్: రిలే సెషన్ ఎంతకాలం కొనసాగింది. ↓/↑: హోస్ట్ ద్వారా అందుకున్న / పంపిన బైట్‌లు."
    override val tgOkTotalHint = "Telegram కనెక్ట్‌లు / విజయవంతమైనవి / మొత్తం తనిఖీలు"
    override val breadthTitle = "హోస్ట్ ఎంపిక వెడల్పు"
    override val breadthHelp = "ఎడమ = ఉత్తమ నిరూపితమైన హోస్ట్‌లకు అంటిపెట్టుకుని ఉండు; కుడి = అన్ని సజీవ హోస్ట్‌ల అంతటా వీలైనంత విస్తృతంగా ప్రయత్నించు. Telegram రిలే పోర్ట్‌లను మారుస్తూనే ఉన్నప్పుడు యాప్ శోధనను స్వయంచాలకంగా విస్తరిస్తుంది."
    override val breadthNarrow = "నిరూపితం"
    override val breadthWide = "విస్తృతం"
    override val connTimeoutTitle = "ప్రతి-హోస్ట్ కనెక్ట్ టైమ్‌అవుట్"
    override val connTimeoutHelp = "తదుపరి ప్రాక్సీకి వెళ్లే ముందు ఒక అప్‌స్ట్రీమ్ (TCP + TLS + మొదటి MTProto ప్రత్యుత్తరం) కోసం ఎంతకాలం వేచి ఉండాలి."
    override val factoryResetDone = "ప్రతిదీ రీసెట్ చేయబడింది. దయచేసి యాప్‌ను మూసివేసి మళ్లీ తెరవండి."
}
