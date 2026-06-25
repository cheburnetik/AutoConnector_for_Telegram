package io.autoconnector.i18n

object Ta : Strings {
    override val tabConnector = "இணைப்பான்"; override val tabScan = "ஸ்கேன்"
    override val tabCatalog = "பட்டியல்"; override val tabLogs = "பதிவுகள்"; override val tabMore = "மேலும்"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "சந்தாக்கள்"; override val logTabScan = "ஸ்கேன்"
    override val logGeneral = "பொது"; override val logEmpty = "இப்போதைக்கு காலியாக உள்ளது"
    override val logSessions = "அமர்வுகள்"; override val logErrorsOnly = "பிழைகள் மட்டும்"; override val logNoErrors = "தோல்வியடைந்த அமர்வுகள் இல்லை"
    override fun logSession(id: String, port: String) = "#${id} · :${port}"
    override val back = "பின்செல்"; override val copy = "நகலெடு"; override val gotIt = "புரிந்தது"
    override val later = "பிறகு"; override val details = "விவரங்கள்"; override val whatIsThis = "இது என்ன?"
    override val delete = "நீக்கு"

    override val connector = "இணைப்பான்"; override val scan = "ஸ்கேன்"
    override val notConfigured = "அமைக்கப்படவில்லை! சரிசெய் →"; override val howToSetup = "எப்படி அமைப்பது"
    override val notifOff = "அறிவிப்புகள் அணைக்கப்பட்டுள்ளன! சரிசெய் →"; override val enable = "இயக்கு"
    override fun fewProxies(n: Int) = "செயலில் உள்ள ப்ராக்ஸிகள் ${n}, தேடுகிறது, ~15 நிமிடம் காத்திருக்கவும்…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "செயலில் உள்ள ப்ராக்ஸிகள்: ${alive}  (15 நிமிடம்: ${within}) · மொத்தம்: ${total}"
    override val notifWhyTitle = "ஏன் அறிவிப்புகள்?"
    override val notifWhyBody = "நிலையான அறிவிப்பு ஐகான் என்பது Android முன்னணி சேவையைக் குறிக்கிறது. " +
        "அது இல்லாமல், கணினி பயன்பாட்டை நினைவகத்திலிருந்து அகற்றிவிடும், மேலும் அது ப்ராக்ஸிகளைத் தேடுவதையும் " +
        "பின்னணியில் இணைப்பைப் பராமரிப்பதையும் நிறுத்திவிடும். அதனால்தான் AutoConnector செயல்பட " +
        "அறிவிப்புகள் அவசியம்."
    override val notifEnableTitle = "அறிவிப்புகளை இயக்கவும்"
    override val notifEnableBody = "அறிவிப்பு ஐகான் இல்லாமல், Android பயன்பாட்டைச் செயலற்றதாகக் கருதி " +
        "அதை நினைவகத்திலிருந்து அகற்றிவிடும். அப்போது AutoConnector ப்ராக்ஸிகளைத் தேடுவதையும் பின்னணியில் " +
        "இணைப்பைப் பராமரிப்பதையும் நிறுத்திவிடும் — Telegram தனது இணைப்பை இழக்கும்.\n\n\"இயக்கு\" என்பதை தட்டி " +
        "AutoConnector-க்கு அறிவிப்புகளை அனுமதிக்கவும்."
    override val notifPlea = "அறிவிப்புகளை இயக்கவும்! அவை இல்லாமல் பயன்பாடு பின்னணியில் இயங்க முடியாது — " +
        "Android அதை அகற்றிவிடும், ப்ராக்ஸி தேடலும் இணைப்பும் நிற்கும்."

    override val statusConnected = "Telegram இணைக்கப்பட்டது"; override val statusConnecting = "இணைக்கிறது…"
    override val statusOffline = "Telegram இணைக்கப்படவில்லை"; override val statusIdle = "Telegram செயலற்று உள்ளது"
    override val nobodyConnected = "இணைப்பானுடன் யாரும் இணைக்கப்படவில்லை. "; override val howToSetupArrow = "எப்படி அமைப்பது →"
    override val directModeViaVpn = "நேரடி பயன்முறை: VPN செயலில் — ப்ராக்ஸி இல்லை"
    override val directModeOff = "நேரடி பயன்முறை: ப்ராக்ஸிகள் அணைக்கப்பட்டன"
    override val directDpiSuffix = " · எதிர்-DPI"
    override val connections = "இணைப்புகள்"; override val sockets = "சாக்கெட்டுகள்"; override val speed = "வேகம்"
    override val traffic = "டிராஃபிக்"; override val latency = "தாமதம்"
    override fun pcs(n: Int) = "${n} எண்"
    override fun netNow(label: String) = "நெட்வொர்க்: ${label}"
    override fun tgToConnector(n: Int) = "TG→ ${n}"
    override fun connectorToProxy(n: Int) = "ப்ராக்ஸி ${n}"
    override val trafficSec = "டிராஃபிக் · 60 வினாடி"; override val trafficMin = "டிராஃபிக் · 60 நிமிடம்"
    override val latencySec = "தாமதம் · 60 வினாடி"; override val latencyMin = "தாமதம் · 60 நிமிடம்"
    override val sec60 = "60 வினாடி"; override val min60 = "60 நிமிடம்"
    override val unitSec = "வி"; override val unitMin = "நி"; override val unitHour = "ம"; override val dash = "—"
    override val currentProxy = "தற்போதைய ப்ராக்ஸி"; override val noActiveProxy = "செயலில் ப்ராக்ஸி இல்லை (Telegram இணைக்கப்படவில்லை)"
    override val host = "ஹோஸ்ட்"; override val type = "வகை"; override val secret = "ரகசியம்"; override val antiDpi = "எதிர்-DPI"; override val obfEngine = "மறைப்பு என்ஜின்"
    override fun activeSockets(n: Int) = "செயலில் உள்ள Telegram சாக்கெட்டுகள்: ${n}"
    override val noConnections = "செயலில் இணைப்புகள் இல்லை"; override val colHost = "ஹோஸ்ட்"; override val colTime = "நேரம்"
    override val modeWord = "பயன்முறை"; override val directViaVpnLine = "Telegram-க்கு நேரடி கோரிக்கைகள் (VPN செயலில்)"
    override val connModeHelp = "பயன்முறைகள் (VPN, Wi-Fi, LTE, Ethernet, White) ஸ்கேன் தீவிரத்தை வெவ்வேறு வகையில் அமைக்கவும், தனித்தனி ஹோஸ்ட் மதிப்பீடுகள்/புள்ளிவிவரங்களை வைத்திருக்கவும் உதவுகின்றன. நெட்வொர்க் வகை தானாகவே கண்டறியப்படுகிறது; பயன்முறையை அமைப்புகளில் கைமுறையாக அமைக்கலாம்."

    override val scanOff = "ஸ்கேனிங் அணைக்கப்பட்டது"; override val proxiesInBase = "தரவுத்தளத்தில் ப்ராக்ஸிகள்"
    override val total = "மொத்தம்"; override val alive = "செயலில்"; override val dead = "செயலற்றது"
    override val tgConnectedTitle = "Telegram இணைக்கப்பட்டது வழியாக"; override val successful = "வெற்றிகரமானது"
    override val socketsHeld = "சாக்கெட் வாழ்நாள்"; override val over1m = ">1 நிமிடம்"; override val over5m = ">5 நிமிடம்"; override val over15m = ">15 நிமிடம்"
    override val scanCountTitle = "ப்ராக்ஸி சோதனைகளின் எண்ணிக்கை"; override val checked = "சரிபார்க்கப்பட்டது"
    override val forAllTime = "எல்லா நேரமும்"; override val perMinute = "நிமிடத்திற்கு"; override val perHour = "மணிக்கு"
    override val subsCountTitle = "சந்தா பதிவிறக்கங்களின் எண்ணிக்கை"; override val downloaded = "பதிவிறக்கப்பட்டது"; override val failed = "தோல்வியடைந்தது"; override val scanTraffic = "ஸ்கேன் டிராஃபிக்"; override val subTraffic = "சந்தா டிராஃபிக்"; override val subTrafficGraph = "சந்தா டிராஃபிக்"
    override val checksMtproto = "MTProto சோதனைகள் (↑ சரி · ↓ தோல்வி)"

    override fun catalogEmpty(mode: String) = "பட்டியல் ${mode} இப்போதைக்கு காலியாக உள்ளது. ஹோஸ்ட் எதுவும் கண்டறியப்படவில்லை, அல்லது இந்த பயன்முறையில் பயன்பாடு ஒருபோதும் இயங்கவில்லை. அமைப்புகளில் பயன்முறையை மாற்றலாம். வெவ்வேறு வகையான இணைய இணைப்புகளுக்கு ஹோஸ்ட்களைத் தனித்தனியாக சேகரிக்க பயன்முறைகள் உள்ளன."
    override val aliveShort = "✓ செயலில்"; override val deadShort = "✗ செயலற்றது"
    override val statusLabel = "நிலை"; override val rating = "மதிப்பீடு"; override val port = "போர்ட்"
    override val rttPing = "RTT (ping)"; override val checkedField = "சரிபார்க்கப்பட்டது"; override val okOfTotal = "வெற்றிகரமான / மொத்த சோதனைகள்"
    override val tgConnectedField = "Telegram இணைக்கப்பட்டது"; override val tgSessions = "Telegram அமர்வுகள்"; override val trafficThroughProxy = "ப்ராக்ஸி வழியான டிராஃபிக்"
    override val sessionsTotal = "மொத்த அமர்வுகள்"; override val relayNow = "இப்போது ரிலே"; override val tlsDomain = "TLS டொமைன் (SNI)"
    override val sourceSub = "மூலம் (சந்தா)"; override val lastError = "கடைசி பிழை"; override val yes = "ஆம்"; override val no = "இல்லை"
    override val copyAsLink = "இணைப்பாக நகலெடு"; override val openInTelegram = "Telegram-இல் ஹோஸ்டைத் திற"; override val makeNextRelay = "அடுத்த ரிலேயாக்கு"
    override val actCopy = "நகலெடு"; override val actOpen = "திற"; override val actRelay = "ரிலே"
    override fun agoFmt(v: String) = "${v} முன்பு"
    override val catalogTopFor = "ப்ராக்ஸி பட்டியல்/மதிப்பீடு"
    override val catalogModeHelpTitle = "பயன்முறைகள் & மதிப்பீடுகள்"
    override val catalogModeHelp = "பயன்பாடு செயலில் உள்ள ஹோஸ்ட்களையும் அவற்றின் மதிப்பீடுகளையும் ஒவ்வொரு நெட்வொர்க் பயன்முறைக்கும் தனித்தனியாக (VPN, Wi-Fi, LTE, Ethernet மற்றும் White) எண்ணுகிறது. \"White\" என்பது அனுமதிப்பட்டியல்களுக்கான தனி கைமுறை பயன்முறை; தானியங்கி அதற்கு ஒருபோதும் மாறாது. எனவே ஒரே ஹோஸ்ட் ஒரு பயன்முறையில் செயலிலும் மற்றொன்றில் செயலற்றதாகவும் இருக்கலாம்."
    override fun catalogInactiveWarn(section: String, active: String) =
        "நீங்கள் செயலற்ற பிரிவு ${section} ஐப் பார்க்கிறீர்கள் — இப்போது எல்லா புள்ளிவிவரங்களும் ${active}-க்குச் செல்கின்றன, இங்கே அல்ல."
    override val manageModeTitle = "பயன்முறையை நிர்வகி"
    override val manageResetRating = "மதிப்பீட்டை மீட்டமை"
    override fun manageResetHint(mode: String) = "குறிப்பாக ${mode}-க்கு செயலில் உள்ள ஹோஸ்ட்களின் மதிப்பீட்டையும் பயன்பாட்டு புள்ளிவிவரங்களையும் மீட்டமைக்கலாம். அடிப்படையில் வேறுபட்ட VPN அல்லது LTE-உடன் இணைக்கும்போது இது வசதியாக இருக்கும், அதனால் பழைய புள்ளிவிவரங்கள் இடையூறு செய்யாது. அல்லது ப்ராக்ஸி ஸ்கேன் எவ்வளவு வேகமாக எல்லாவற்றையும் புதிதாக மீண்டும் சரிபார்க்கிறது என்பதைப் பார்க்க."
    override val manageDeleteAll = "ஹோஸ்ட்களை நீக்கு"
    override fun manageDeleteHint(mode: String) = "${mode}-இலிருந்து மதிப்பீட்டையும் ஹோஸ்ட்களையும் அழிக்கலாம். \"ப்ராக்ஸிகளை ஸ்கேன் செய்\" அம்சம் அவற்றை மீண்டும் சேகரிக்கும். இது சந்தா மீட்டமைப்பு அல்ல — அதை தட்டி, மீண்டும் ஸ்கேன் செய்ய ~15 நிமிடம் காத்திருக்கலாம்."
    override fun manageCopyFrom(mode: String) = "மற்றொரு பயன்முறையிலிருந்து இந்த பயன்முறைக்கு (${mode}) எல்லா ஹோஸ்ட்களையும் மதிப்பீடுகளையும் நகலெடு:"
    override val live = "செயலில்"; override val deadW = "செயலற்றது"; override val unitMs = "மிவி"
    override val agoMin = "நி"; override val agoHour = "ம"; override val agoDay = "நா"

    override val connectTelegram = "Telegram-ஐ இணைக்கிறது"; override val readCarefully = "கவனமாகப் படிக்கவும்!"
    override val guideIntro = "இந்த பயன்பாடு அமைப்பு இல்லாமல் வேலை செய்யாது. கீழே உள்ள 3 விருப்பங்களில் ஏதேனும் ஒன்றைத் தேர்ந்தெடுத்து " +
        "வழிமுறைகளை கவனமாகப் பின்பற்றவும்."
    override val variant1 = "விருப்பம் #1 — பொத்தான்கள்"
    override val variant1Body = "\"ப்ராக்ஸி {A}\" என்பதைத் தட்டவும் — Telegram திறக்கிறது, ப்ராக்ஸி சேர்ப்பதை உறுதிசெய்யவும். இந்தத் " +
        "திரைக்குத் திரும்பி \"ப்ராக்ஸி {B}\" என்பதைத் தட்டவும் — இரண்டாவது முறையும் சேர்ப்பதை உறுதிசெய்யவும்.\n\nTelegram-இல் வேறு " +
        "எந்தப் பழைய ப்ராக்ஸிகளையும் முடக்கவும். சரியாக 2 ப்ராக்ஸிகள் இருக்க வேண்டும் — {A} மற்றும் {B} போர்ட்களுடன். " +
        "வேறு எந்த அமைப்பிலும் AutoConnector வேலை செய்யாது."
    override val variant2 = "விருப்பம் #2 — இணைப்புகள்"
    override val variant2Body = "கீழே உள்ள உரையை Telegram-இல் Saved Messages-க்கு (அல்லது எந்த அரட்டைக்கும்) நகலெடுக்கவும் — " +
        "அதாவது அதை உங்களுக்கே அனுப்பவும். உங்கள் செய்தியில் முதல் இணைப்பைத் தட்டவும் — முதல் ப்ராக்ஸி சேர்க்கப்படுகிறது. " +
        "இரண்டாவது இணைப்பைத் தட்டவும் — இரண்டாவது சேர்க்கப்படுகிறது. பின்னர் எல்லா பழைய ப்ராக்ஸிகளையும் முடக்கவும்."
    override val variant3 = "விருப்பம் #3 — கைமுறையாக"
    override val variant3Body = "SOCKS5 ப்ராக்ஸியை கைமுறையாகச் சேர்க்கவும்: சர்வர் localhost (127.0.0.1), போர்ட் {A}. " +
        "பின்னர் இரண்டாவது ப்ராக்ஸி: localhost, போர்ட் {B}. பழைய ப்ராக்ஸிகளை நீக்கவும்."
    override val whatNext = "அடுத்து என்ன?"
    override val whatNextBody = "Telegram-இல், \"ப்ராக்ஸியை தானாக மாற்று\" என்பதை இயக்கவும் — 5 வினாடிகள். செயலில் இல்லாத அல்லது " +
        "\"கிடைக்கவில்லை\" எனக் குறிக்கப்பட்ட ப்ராக்ஸியை (Telegram-க்குள்) கைமுறையாகத் தட்டுவதன் மூலம் Telegram இணைக்க உதவலாம் — " +
        "அது Telegram-ஐ இணைக்க அதிக முயற்சி செய்ய வைக்கிறது.\n\n{A} மற்றும் {B} தவிர மற்ற எல்லா பழைய " +
        "ப்ராக்ஸிகளும் அகற்றப்பட்டுள்ளன என்பதை உறுதிசெய்யவும். Telegram-இல் " +
        "\"ப்ராக்ஸியைப் பயன்படுத்து\" என்பதைத் தட்டவும்.\n\nபயன்பாடு போதுமான ப்ராக்ஸிகளைக் கண்டுபிடித்து பதிவிறக்கும் வரை " +
        "காத்திருக்கவும் (5–15 நிமிடங்கள்). பின்னர் Telegram தானாகவே AutoConnector-உடன் இணைக்கிறது, அது Telegram-ஐ " +
        "சிறந்த ப்ராக்ஸிகள் வழியாக தொடர்ந்து வழிநடத்தும்: சரிபார்க்கப்பட்ட, செயலில் உள்ள, வேகமான.\n\nவழிமுறைகள் கடினமாகத் " +
        "தோன்றினால் — மன்னிக்கவும், உங்களால் பயன்பாட்டைப் பயன்படுத்த முடியாது: எல்லாவற்றையும் தானாக அமைப்பது சாத்தியமில்லை, " +
        "மேலும் செயலில் உள்ள ப்ராக்ஸிகளைக் கண்டுபிடிக்க நேரம் எடுக்கும்.\n\nநீங்கள் நீண்ட காலத்திற்கு முன்பு பயன்பாட்டைப் " +
        "பதிவிறக்கி, செயலில் உள்ள ப்ராக்ஸிகள் எதுவும் கண்டறியப்படவில்லை என்றால் — பயன்பாட்டை அல்லது சந்தா பட்டியலைப் " +
        "புதுப்பிக்கவும். இந்த பயன்பாடு தனது சொந்த ப்ராக்ஸிகளைக் கண்டுபிடிக்காது அல்லது வழங்காது, அது டஜன் கணக்கான " +
        "குழுக்கள் மற்றும் பக்கங்களில் இணையத்தை மட்டுமே தேடுகிறது."
    override fun proxyBtn(port: Int) = "ப்ராக்ஸி ${port}"

    override val setupPortsTitle = "Telegram-இல் போர்ட்களை அமை"
    override val setupPortsSub = "Telegram-ஐ இணைப்பானுடன் எவ்வாறு இணைப்பது (போர்ட்கள் 55001/55002)"
    override val settings = "அமைப்புகள்"; override val settingsSub = "போர்ட்கள், எதிர்-DPI, ஸ்கேன், நெட்வொர்க், பேட்டரி"
    override val subscriptions = "சந்தாக்கள்"; override val subscriptionsSub = "ஸ்கேன் செய்ய ப்ராக்ஸி மூலங்கள்"
    override val statistics = "புள்ளிவிவரங்கள்"; override val statisticsSub = "ப்ராக்ஸி தரவுத்தளம் + எதிர்-DPI தந்திரங்கள்"
    override val export = "ஏற்றுமதி"; override val exportSub = "செயலில் உள்ள ப்ராக்ஸிகளின் tg:// இணைப்புகள்"
    override val about = "பற்றி"; override val aboutSub = "பதிப்பு, பில்ட், பதிவிறக்கம், கருத்து"
    override val hotkeys = "ஹாட்கீகள்"
    override val hotkeysSub = "உலகளாவிய விசைகள்: ப்ராக்ஸியை நகலெடு / திற"
    override val hotkeysIntro = "பயன்பாட்டு சாளரம் கவனத்தில் இல்லாதபோதும் உலகளாவிய ஹாட்கீகள் செயல்படும். அவை குளத்திலிருந்து " +
        "சீரற்ற செயலில் உள்ள ப்ராக்ஸி இணைப்பை (tg://) தேர்வு செய்கின்றன — பயன்பாட்டைத் திறக்காமல் ப்ராக்ஸிகளை விரைவாக " +
        "மாற்ற வசதியாக உள்ளது."
    override val hotkeysNote = "macOS-இல், விசைகளைப் பிடிக்க Accessibility அனுமதி தேவைப்படலாம் " +
        "(System Settings → Privacy & Security → Accessibility)."
    override val hotkeyCopyTitle = "ப்ராக்ஸி இணைப்பை நகலெடு"
    override val hotkeyCopyDesc = "சீரற்ற செயலில் உள்ள tg:// இணைப்பை கிளிப்போர்டில் வைக்கிறது."
    override val hotkeyEnable = "ஹாட்கீகளை இயக்கு"; override val hotkeyLetterLabel = "எழுத்து"; override val hotkeySet = "அமை"; override val hotkeyReset = "மீட்டமை"
    override val hotkeyOpenTitle = "Telegram-இல் ப்ராக்ஸியைத் திற"
    override val hotkeyOpenDesc = "சீரற்ற செயலில் உள்ள இணைப்பைத் திறக்கிறது — Telegram அதைப் பிடித்து ப்ராக்ஸியை இணைக்க முன்வைக்கிறது."

    override val relayPorts = "ரிலே போர்ட்கள்"
    override val relayPortsHelp = "இணைப்பான் கேட்கும் உள்ளூர் போர்ட்கள். இவற்றையே நீங்கள் Telegram-இல் " +
        "SOCKS5 ப்ராக்ஸியாக (127.0.0.1 : போர்ட்) உள்ளிடுகிறீர்கள். நம்பகத்தன்மைக்காக இரண்டு போர்ட்கள் பயன்படுத்தப்படுகின்றன — Telegram " +
        "இரண்டிற்கும் இணைப்புகளை வைத்திருக்கிறது."
    override val portA = "போர்ட் A"; override val portB = "போர்ட் B"
    override val antiDpiTrick = "எதிர்-DPI தந்திரம்"
    override val antiDpiHelp = "ISP/DPI இணைப்பை அடையாளம் கண்டு தடுக்காதவாறு அதை மறைக்கும் ஒரு வழி." +
        "\n• \"தானாக-சுழற்று\" வேலை செய்யும் தந்திரத்தைத் தானே தேர்வு செய்கிறது.\n• \"DPI தந்திரங்கள் இல்லை\" — ஒரு சாதாரண " +
        "இணைப்பு.\n• மீதமுள்ளவை குறிப்பிட்ட நுட்பங்கள் (உலாவி பாசாங்கு, பாக்கெட் பிரித்தல், போன்றவை)."
    override val onlyFakeTls = "FakeTLS மட்டும் (ee)"
    override val applyDpiTo = "எதிர்-DPI-ஐ பயன்படுத்து"
    override val applyDpiHelp = "தேர்ந்தெடுக்கப்பட்ட எதிர்-DPI தந்திரத்தை எதற்குப் பயன்படுத்துவது:\n• Telegram ரிலே — இணைப்பான் " +
        "வழியாக செயலில் உள்ள Telegram இணைப்புக்கு.\n• ப்ராக்ஸி சோதனைகள் — பின்னணி ப்ராக்ஸி சோதனைகளுக்கு " +
        "(அப்போது ஒரு சோதனை உண்மையான இணைப்பைப் போலவே நடந்துகொள்கிறது, மேலும் தந்திர புள்ளிவிவரங்கள் மிகவும் துல்லியமாக இருக்கும்).\n" +
        "• நேரடியாக இணைக்கும்போது — ப்ராக்ஸிகள் அணைக்கப்படும்போது (அல்லது VPN இயக்கத்தில் இருக்கும்போது தவிர்க்கப்படும்போது) மற்றும் Telegram " +
        "அதன் சர்வர்களுக்கு நேராகச் செல்லும்போது: இங்கே ப்ராக்ஸி இல்லை, எனவே தந்திரம் " +
        "முதல் TCP பாக்கெட்டை (handshake) DPI ஒரே வாசிப்பில் பொருத்த முடியாதவாறு பல சிறிய பகுதிகளாகப் பிரிப்பதாகச் சுருங்குகிறது."
    override val toRelay = "Telegram ரிலே"; override val toProbes = "ப்ராக்ஸி சோதனைகள்"
    override val toDirect = "நேரடியாக இணைக்கும்போது"
    override val vpnSection = "VPN இயக்கத்தில் இருக்கும்போது"
    override val vpnHelp = "சாதனத்தில் VPN செயலில் இருக்கும்போது என்ன செய்வது:\n• MTProto ப்ராக்ஸி வழியாக — " +
        "Telegram கண்டறியப்பட்ட ப்ராக்ஸிகள் வழியாக வழக்கம் போல் செல்கிறது (VPN மேல்).\n• நேரடியாக — " +
        "இணைப்பான் ப்ராக்ஸிகளைப் பயன்படுத்தாமல் Telegram-ஐ Telegram-இன் சர்வர்களுக்கு நேராக இணைக்கிறது: " +
        "VPN ஏற்கனவே அணுகலை வழங்குகிறது, கூடுதல் ப்ராக்ஸி அடுக்கு தேவையில்லை (வேகமானது மற்றும் நிலையானது). " +
        "VPN இல்லாமல் ப்ராக்ஸிகள் வழக்கம் போல் பயன்படுத்தப்படுகின்றன."
    override val linkFormat = "ப்ராக்ஸி இணைப்பு வடிவம்"
    override val linkFormatHelp = "ப்ராக்ஸிகளை எவ்வாறு நகலெடுப்பது மற்றும் திறப்பது. tg:// Telegram-ஐ நேரடியாகத் திறக்கிறது (Telegram Desktop நிறுவப்பட்டிருக்க வேண்டும்). http (t.me) உலாவி வழியாகத் திறந்து Telegram-இல் திறக்க முன்வைக்கிறது — tg:// பதிவு செய்யப்படவில்லை என்றால் வசதியாக இருக்கும்."
    override val linkTg = "tg:// (Telegram-ஐ நேரடியாகத் திற)"; override val linkTgSub = "tg://proxy?… — Telegram-ஐத் திறக்கிறது"
    override val linkHttp = "http (t.me, உலாவி வழியாக)"; override val linkHttpSub = "https://t.me/proxy?… — உலாவியைத் திறக்கிறது"
    override val viaMtproto = "MTProto வழியாக ப்ராக்ஸி"; override val viaMtprotoSub = "VPN-உடன் கூட, டிராஃபிக் ப்ராக்ஸிகள் வழியாகச் செல்கிறது"
    override val directly = "நேரடியாக இணை"; override val directlySub = "VPN செயலில் இருக்கும்போது — ப்ராக்ஸிகளைத் தவிர்த்து, Telegram-க்கு நேராக"
    override val notifications = "அறிவிப்புகள்"
    override val scanCheck = "ஸ்கேன் & சரிபார்"
    override val scanCheckHelp = "• ஸ்கேன், நிமிடம் — சந்தாக்களிலிருந்து ப்ராக்ஸி பட்டியல்களை எவ்வளவு அடிக்கடி பதிவிறக்குவது.\n" +
        "• சரிபார், நிமிடம் — தரவுத்தளத்தில் உள்ள ப்ராக்ஸிகளின் செயல்பாட்டை எவ்வளவு அடிக்கடி மீண்டும் சரிபார்ப்பது.\n• தொகுதி அளவு — " +
        "ஒரு ஓட்டத்திற்கு எத்தனை ப்ராக்ஸிகளைச் சரிபார்ப்பது.\n• இணை — ஒரே நேரத்தில் எத்தனை சோதனைகளை இயக்குவது (அதிகம் = " +
        "வேகமானது, ஆனால் அதிக நெட்வொர்க் மற்றும் பேட்டரி சுமை)."
    override val scanMin = "ஸ்கேன், நிமிடம்"; override val checkMin = "சரிபார், நிமிடம்"; override val batchSize = "தொகுதி அளவு"; override val parallel = "இணை"
    override val speedByNet = "நெட்வொர்க் வாரியான ஸ்கேன் தீவிரம்"
    override val speedByNetHelp = "தற்போதைய நெட்வொர்க்கைப் பொறுத்து ப்ராக்ஸிகளை எவ்வளவு அடிக்கடி சரிபார்ப்பது. " +
        "\"நிலையானது\" = அடிப்படை இடைவெளி. அரிதாகச் செய்ய (மெதுவாக, டிராஃபிக்/பேட்டரிக்கு மென்மையாக) வலதுபுறம் இழுக்கவும், " +
        "அடிக்கடி செய்ய (வேகமாக, அதிக தீவிரமாக) இடதுபுறம். மடக்கை அளவு, ஒவ்வொரு பக்கமும் ×100 வரை.\n" +
        "• VPN — வெளிப்புற VPN செயலில் இருக்கும்போது.\n• Wi-Fi — Wi-Fi நெட்வொர்க்கில்.\n• LTE — மொபைல் நெட்வொர்க்கில்."
    override val intensStandard = "நிலையானது"
    override val intensSlower = "மெதுவாக"
    override val intensFaster = "வேகமாக"
    override val maintenance = "தரவை மீட்டமை"
    override val maintenanceHelp = "• \"பட்டியல் & புள்ளிவிவரங்களை மீட்டமை\" — மதிப்பீடுகள், கவுண்டர்கள், டிராஃபிக் " +
        "மற்றும் சோதனை பதிவுகளை பூஜ்ஜியமாக்குகிறது, ஆனால் பதிவிறக்கப்பட்ட ஹோஸ்ட்களையும் சந்தாக்களையும் வைத்திருக்கிறது (அடுத்த ஸ்கேனில் " +
        "எல்லாமே மீண்டும் மதிப்பிடப்படும்).\n• \"பதிவிறக்கப்பட்ட ஹோஸ்ட்களை அழி\" — முழு ப்ராக்ஸி குளத்தையும் நீக்குகிறது ஆனால் " +
        "சந்தாக்களை வைத்திருக்கிறது, அதனால் ஸ்கேன் குளத்தை மீண்டும் நிரப்புகிறது. சந்தாக்கள் எந்த வகையிலும் தொடப்படுவதில்லை."
    override val backupTitle = "ஏற்றுமதி / இறக்குமதி"
    override val backupHelp = "பயன்பாட்டுத் தரவை JSON ஆகச் சேமிக்கவும் அல்லது மீட்டமைக்கவும். எதைச் சேர்ப்பது என்பதைத் " +
        "தேர்வு செய்யவும் — எந்த சேர்க்கையும்:\n• அமைப்புகள் — அனைத்து பயன்பாட்டு அளவுருக்களும்.\n• சந்தாக்கள் — மூலப் " +
        "பட்டியல் (URL + இயக்கு/அணை).\n• செயலில் உள்ள-ஹோஸ்ட் பட்டியல் — ஒவ்வொரு நெட்வொர்க் பயன்முறைக்கும் அதன் மதிப்பீடுகள் மற்றும் புள்ளிவிவரங்களுடன் " +
        "ஒவ்வொரு செயலில் உள்ள ப்ராக்ஸியும்.\n\n\"ஏற்றுமதி\" தயாரான JSON உள்ள பக்கத்தைத் திறக்கிறது — அதை நகலெடுக்கவும் அல்லது கோப்பில் சேமிக்கவும். " +
        "\"இறக்குமதி\" — JSON-ஐ ஒட்டவும் (அல்லது கோப்பை ஏற்றவும்) அது அதில் உள்ள தேர்வு செய்யப்பட்ட பிரிவுகளை மட்டுமே பயன்படுத்துகிறது. " +
        "இறக்குமதி தற்போதைய தரவுடன் சேர்க்கிறது (அழிப்பு இல்லை)."
    override val backupSettings = "அமைப்புகள்"
    override val backupSubs = "சந்தாக்கள்"
    override val backupHosts = "செயலில் உள்ள-ஹோஸ்ட் பட்டியல் (பயன்முறை வாரியாக)"
    override val exportWord = "ஏற்றுமதி"
    override val importWord = "இறக்குமதி"
    override val backupExportTitle = "தரவை ஏற்றுமதி செய்"
    override val backupImportTitle = "தரவை இறக்குமதி செய்"
    override val backupSelectExport = "எதை ஏற்றுமதி செய்வது:"
    override val backupSelectImport = "எதை இறக்குமதி செய்வது:"
    override val backupCopyBtn = "நகலெடு"
    override val backupSaveFile = "கோப்பில் சேமி"
    override val backupLoadFile = "கோப்பிலிருந்து ஏற்று"
    override val backupDoImport = "இறக்குமதி"
    override val backupPasteLabel = "காப்புப்பிரதி JSON-ஐ இங்கே ஒட்டவும்"
    override val backupJsonLabel = "காப்புப்பிரதி JSON"
    override val backupAndroidFileNote = "இங்கே கோப்புகள் கிடைக்கவில்லை — நகலெடு / ஒட்டு பயன்படுத்தவும்."
    override val eraseAllHosts = "அனைத்து ஹோஸ்ட்களையும் அழி"
    override val factoryReset = "அனைத்தையும் மீட்டமை (முதல் தொடக்கம் போல)"
    override val factoryResetConfirm = "பயன்பாட்டை தொழிற்சாலை நிலைக்கு முழுமையாக மீட்டமைக்கவா? அனைத்து அமைப்புகளும் முழு " +
        "ஹோஸ்ட் பட்டியலும் அழிக்கப்படும், சந்தாக்கள் இயல்புநிலைகளுக்கு மீட்டமைக்கப்படும். முதல் தொடக்கம் போலவே."
    override val resetCatalog = "பட்டியல் & புள்ளிவிவரங்களை மீட்டமை"
    override val resetCatalogConfirm = "அனைத்து மதிப்பீடுகள், கவுண்டர்கள் மற்றும் சோதனை பதிவுகளை பூஜ்ஜியமாக்கவா? " +
        "பதிவிறக்கப்பட்ட ஹோஸ்ட்களும் சந்தாக்களும் வைத்திருக்கப்பட்டு அடுத்த ஸ்கேனில் மீண்டும் மதிப்பிடப்படும்."
    override val clearHosts = "பதிவிறக்கப்பட்ட ஹோஸ்ட்களை அழி"
    override val clearHostsConfirm = "பதிவிறக்கப்பட்ட ஹோஸ்ட்களின் (ப்ராக்ஸிகள்) முழு பட்டியலையும் நீக்கவா? " +
        "சந்தாக்கள் வைத்திருக்கப்படும், மேலும் ஸ்கேன் குளத்தை மீண்டும் நிரப்பும்."
    override val doReset = "மீட்டமை"
    override val doCancel = "ரத்து செய்"
    override val adaptiveSpeed = "தகவமைப்பு வேகம்"
    override val adaptiveHelp = "செயல்பாட்டு சோதனைகள் அடிப்படை இடைவெளியில் இயங்குகின்றன (\"ஸ்கேன் & சரிபார்\"-இலிருந்து, " +
        "நெட்வொர்க் பெருக்கியால் பெருக்கப்படும்). \"தகவமைப்பு வேகம்\" தற்போது எத்தனை ப்ராக்ஸிகள் செயலில் உள்ளன என்பதைப் பொறுத்து " +
        "அவற்றை தானாக வேகப்படுத்துகிறது அல்லது மெதுவாக்குகிறது.\n\n" +
        "• குறைவான செயலில் (\"குறைவு\" வரம்புக்குக் கீழே) → இடைவெளி × \"வேகப்படுத்தல்\". 1-க்குக் கீழே உள்ள பெருக்கி = அதிக " +
        "அடிக்கடி: 0.5 — இரண்டு மடங்கு அடிக்கடி, 0.25 — 4×. குளத்தை வேகமாக நிரப்புகிறது.\n" +
        "• அதிக செயலில் (\"அதிகம்\" வரம்புக்கு மேலே) → இடைவெளி × \"மெதுவாக்கல்\". 1-க்கு மேலே = அரிதாக: 2 — " +
        "பாதி அடிக்கடி, 4 — கால்வாசி. பேட்டரியும் டிராஃபிக்கும் சேமிக்கிறது.\n" +
        "• வரம்புகளுக்கு இடையில் — அடிப்படை வேகம் (×1).\n\n" +
        "எடுத்துக்காட்டுகள்:\n" +
        "— ப்ராக்ஸிகளை வேகமாகச் சேகரிக்க: \"வேகப்படுத்தல்\" 0.25 மற்றும்/அல்லது \"குறைவு\" வரம்பு 40.\n" +
        "— போதுமானது இருக்கும்போது பேட்டரியைச் சேமிக்க: \"மெதுவாக்கல்\" 8 மற்றும்/அல்லது \"அதிகம்\" வரம்பு 30.\n" +
        "— தகவமைப்பை முடக்க: இரண்டு பெருக்கிகளையும் 1 ஆக அமைக்கவும்.\n\n" +
        "இயல்புநிலைகள்: குறைவு 20, வேகப்படுத்தல் 0.5, அதிகம் 50, மெதுவாக்கல் 4."
    override val threshMany = "\"அதிகம்\" வரம்பு"; override val threshFew = "\"குறைவு\" வரம்பு"; override val mulFast = "வேகப்படுத்தல் ×"; override val mulLazy = "மெதுவாக்கல் ×"
    override val subIntensityTitle = "சந்தா தீவிரம்"
    override val subIntensityHint = "சந்தா பதிவிறக்கங்களுக்கு இடையிலான இடைவெளி: ப்ராக்ஸி பட்டியல்களை மீண்டும் பதிவிறக்கும் முன் எத்தனை நிமிடங்கள் (ஒவ்வொரு நெட்வொர்க் பயன்முறைக்கும் தனித்தனியாக)."
    override val baseScanTitle = "அடிப்படை ஸ்கேன் வேகம்"
    override val baseScanHelp = "குறிப்பு செயல்பாட்டு-சோதனை வேகம். \"தகவமைப்பு வேகம்\" மற்றும் \"பயன்முறை வாரியான " +
        "வேகம்\" பெருக்கிகள் இதைப் பொறுத்தே கணக்கிடப்படுகின்றன.\n\n" +
        "• எவ்வளவு அடிக்கடி இயக்குவது, நிமிடம் — சோதனை ஓட்டங்களுக்கு இடையிலான இடைவெளி.\n" +
        "• ஒரு நூலுக்கு தொகுதி, ஹோஸ்ட்கள் — ஒவ்வொரு நூலும் ஒரு ஓட்டத்திற்கு எத்தனை ஹோஸ்ட்களைச் சரிபார்க்கிறது.\n" +
        "• நூல்கள் — ஒரே நேரத்தில் எத்தனை சோதனைகள் இயங்குகின்றன. ஒரு ஓட்டம் \"தொகுதி × நூல்கள்\" ஹோஸ்ட்களைச் சோதிக்கிறது.\n" +
        "• ஒரு ஹோஸ்டை ஒவ்வொரு N நிமிடத்திற்கு ஒரு முறையை விட அடிக்கடி மீண்டும் ஸ்கேன் செய்யாதே — எதிர்-ஃப்ளட்: சமீபத்தில் சரிபார்க்கப்பட்ட ஹோஸ்ட் " +
        "இந்த ஓட்டத்தில் தவிர்க்கப்படுகிறது.\n\n" +
        "அதிக நூல்களும் பெரிய தொகுதியும் = வேகமான குள வளர்ச்சி, ஆனால் நெட்வொர்க் மற்றும் பேட்டரியில் அதிக சுமை."
    override val baseScanPeriod = "எவ்வளவு அடிக்கடி இயக்குவது, நிமிடம்"
    override val baseScanBatch = "ஒரு நூலுக்கு தொகுதி, ஹோஸ்ட்கள்"; override val baseScanThreads = "நூல் எண்ணிக்கை"
    override val adaptiveDesc = "செயலில் உள்ள ப்ராக்ஸிகள் \"குறைவை\" விடக் குறைவாகவோ \"அதிகத்தை\" விட அதிகமாகவோ இருந்தால், கூடுதல் பெருக்கியைப் பயன்படுத்து."
    override val fewWord = "குறைவு"; override val manyWord = "அதிகம்"
    override fun fasterX(x: String) = "${x}× வேகமாக"
    override fun slowerX(x: String) = "${x}× மெதுவாக"
    override fun ifAliveLt(n: Int) = "செயலில் உள்ள ப்ராக்ஸிகள் < ${n} எனில்:"
    override fun ifAliveGt(n: Int) = "செயலில் உள்ள ப்ராக்ஸிகள் > ${n} எனில்:"
    override val disabledWord = "அணை"
    override val speedByModeTitle = "பயன்முறை வாரியான வேகம்"
    override val speedByModeHelp = "அடிப்படை வேகத்திற்கு மேல், ஒவ்வொரு நெட்வொர்க் பயன்முறைக்கும் ஒரு ஸ்கேன்-வேக " +
        "பெருக்கி. \"நிலையானது\" (×1) = அடிப்படை இடைவெளி. வலது — அரிதாக (மெதுவாக, டிராஃபிக்/" +
        "பேட்டரிக்கு மென்மையாக), இடது — அடிக்கடி (வேகமாக, அதிக தீவிரமாக). மடக்கை அளவு, ஒவ்வொரு பக்கமும் ×100 " +
        "வரை.\n\n" +
        "ஒவ்வொரு ஸ்லைடருக்கும் கீழே தகவமைப்பு வேகம் பயன்படுத்தப்பட்ட விளைவான ஓட்ட அளவுருக்கள் உள்ளன — " +
        "\"குறைவான செயலில்\" (× \"வேகப்படுத்தல்\") மற்றும் \"அதிக செயலில்\" (× \"மெதுவாக்கல்\") ஆகியவற்றுக்குத் தனித்தனியாகக் காட்டப்படுகின்றன.\n\n" +
        "பயன்முறைகள்:\n• VPN — வெளிப்புற VPN செயலில் உள்ளது.\n• LTE — மொபைல் நெட்வொர்க்.\n• Wi-Fi — Wi-Fi நெட்வொர்க்.\n" +
        "• Ethernet — கம்பி இணைப்பு.\n• White — கைமுறை \"white\" ப்ராக்ஸி பயன்முறை."
    override val aliveLt = "செயலில் <"; override val aliveGt = "செயலில் >"
    override val periodWord = "காலம்"; override val nonstopWord = "இடைவிடாது"
    override val batchWord = "தொகுதி"; override val threadsWord = "நூல்கள்"; override val scanModeOff = "ஸ்கேன் அணை"
    override val netBattery = "நெட்வொர்க் & பேட்டரி"
    override val netBatteryHelp = "• Wi-Fi மட்டும் — மொபைல் நெட்வொர்க்குகளில் ஸ்கேன் செய்யாதே (தரவைச் சேமிக்கிறது).\n• சார்ஜிங் " +
        "மட்டும் — தொலைபேசி சார்ஜ் ஆகும்போது மட்டும் வேலை செய்.\n• பேட்டரி குறைவாக இருக்கும்போது தவிர் — பேட்டரி " +
        "குறைவாக இருக்கும்போது ஸ்கேனிங்கை இடைநிறுத்து."
    override val onlyWifi = "Wi-Fi மட்டும்"; override val onlyCharging = "சார்ஜிங் மட்டும்"; override val skipLowBattery = "பேட்டரி குறைவாக இருக்கும்போது தவிர்"
    override val autosaved = "அமைப்புகள் தானாகச் சேமிக்கப்படுகின்றன."
    override val dpiAutoLabel = "DPI தந்திரங்களை தானாக-சுழற்று"; override val dpiNoneLabel = "DPI தந்திரங்கள் இல்லை (சாதாரண)"
    override val experimental = "சோதனைப்பூர்வம்"
    override val experimentalHelp = "MTProto அப்ஸ்ட்ரீமுக்கு மாற்று ப்ராக்ஸி என்ஜின்கள் மற்றும் ஒரு கண்டறிதல் பதிவு. " +
        "\"அணை\" எனஅமைக்கப்படும்போது குறிப்பு (வேலை செய்யும்) பாதை மாறாமல் இருக்கும். மறைகுறியாக்கப்பட்ட ஸ்ட்ரீம் அப்ஸ்ட்ரீம் TCP சாக்கெட்டில் " +
        "எவ்வாறு எழுதப்படுகிறது என்பது மட்டுமே மாறுகிறது (பகுதி அளவுகள், நேரம், TLS-பதிவு எல்லைகள்) — ஸ்ட்ரீம் தானே பைட்-க்கு-பைட் ஒரே மாதிரியாக இருக்கும். " +
        "செயலில் உள்ள ப்ராக்ஸி ரிலேக்கு மட்டுமே பொருந்தும் (சோதனைகளுக்கு அல்ல, நேரடி பாதைக்கு அல்ல)."
    override val expEngineTitle = "ப்ராக்ஸி என்ஜின் (சாக்கெட் மறைப்பு)"
    override val expConnectTitle = "இணைப்பு என்ஜின் (அப்ஸ்ட்ரீம் தேர்வு)"
    override val expEngineWarn = "⚠ சோதனைப்பூர்வ பயன்முறை. இணைப்புத்திறன் மோசமடைந்தால், \"அணை (குறிப்பு பாதை)\"-க்குத் திரும்பவும்."
    override val netLog = "நெட்வொர்க்-பரிமாற்ற பதிவை இயக்கு"
    override val netLogSub = "யாருக்கு-யாரிடமிருந்து-எப்போது மற்றும் பாக்கெட் அளவுகளை ஒரு கோப்பில் எழுதுகிறது (பேலோட் தரவு இல்லை) — " +
        "VPN-உடன் எதிராக VPN இல்லாமல் பரிமாற்ற முறையை ஒப்பிட."
    override val openLogFolder = "பதிவு கோப்புறையைத் திற"; override val copyPath = "பாதையை நகலெடு"
    override val helpShow = "உதவி"; override val helpHide = "உதவியை மறை"
    override val quickSwitchIntro = "இங்கே நீங்கள் தடை-தவிர்ப்பு தந்திரத்தைத் தேர்வு செய்யலாம். Telegram “The proxy you are " +
        "using is not configured correctly and will be disabled. Please find another one” என்ற பிழையைக் காட்டினால், " +
        "Telegram அதைக் காட்டுவதை நிறுத்த எந்த டிராஃபிக்-மறைப்பு வகை வேலை செய்கிறது என்பதைச் சோதிக்கவும். split* " +
        "பயன்முறைகளுடன் தொடங்கவும். coalesce* பயன்முறைகளும் வேலை செய்கின்றன, ஆனால் அவற்றுடன் Telegram-இல் படங்கள்/வீடியோக்கள் சரியாக ஏற்றப்படாது."
    override val quickSwitchTitle ="தடை தவிர்ப்பு"; override val quickSwitchSub = "வடிவமைப்பு, இணைப்பு, எதிர்-DPI"

    override val sourceUrl = "மூல URL"
    override fun sourceAlive(alive: Int, total: Int) = "செயலில் ${alive}/${total}"
    override val open = "திற"; override val active = "செயலில்"; override val inactive = "செயலற்றது"
    override val lastDownloaded = "பதிவிறக்கப்பட்டது"; override val notDownloaded = "இன்னும் பதிவிறக்கப்படவில்லை"
    override fun sourceCounts(dead: Int, total: Int) =
        " செயலில், ${dead} செயலற்றது, ${total} மொத்தம்"

    override val proxyBase = "ப்ராக்ஸி தரவுத்தளம்"
    override val totalInBase = "தரவுத்தளத்தில் மொத்தம்"; override val aliveNow = "இப்போது செயலில்"; override val deadStat = "செயலற்றது"
    override val aliveIn15 = "15 நிமிடத்தில் செயலில்"; override val checksAllTime = "எல்லா நேர சோதனைகள்"
    override val antiDpiTricks = "எதிர்-DPI தந்திரங்கள்"; override val noStatsYet = "இன்னும் தரவு இல்லை — சோதனைகள்/இணைப்புகள் நிகழும்போது தந்திரங்கள் சேரும்"
    override val attempts = "முயற்சிகள்"; override val handshake = "Handshake"; override val score = "மதிப்பெண்"
    override val tgConnect = "TG இணைப்பு"; override val socketsOver1m = "சாக்கெட்டுகள் >1நிமிடம்"
    override val over10kb = "சாக்கெட்டுகள் >10KB"; override val over100kb = ">100KB"; override val workTime = "வேலை நேரம்"
    override val statsLegend = "Handshake — வெற்றிகரமான handshakes (முயற்சிகளில் %) · மதிப்பெண் — மதிப்பு · " +
        "\"வேலை நேரம்\" — ≥5KB மற்றும் 1 நிமிடத்திற்கு மேல் நீளமான சாக்கெட்டுகளின் மொத்தம்."
    override val resetStats = "தந்திர புள்ளிவிவரங்களை மீட்டமை"

    override fun aliveLinks(n: Int) = "செயலில் உள்ள இணைப்புகள்: ${n}"
    override val copyAll = "அனைத்தையும் நகலெடு"
    override val openRandom = "சீரற்றதைத் திற"; override val copyRandom = "சீரற்றதை நகலெடு"; override val allShort = "அனைத்தும்"
    override val copyTop = "TOP நகலெடு"; override val randomHost = "சீரற்ற ஹோஸ்ட்"
    override val exportToFile = "கோப்பில் ஏற்றுமதி செய்"; override val exportSaved = "கோப்பில் சேமிக்கப்பட்டது:"
    override val dlNow = "இப்போது பதிவிறக்கு"
    override fun downloadingFmt(sec: Long) = "பதிவிறக்குகிறது… ${sec}வி"
    override val cancel = "ரத்து செய்"
    override val deleteConfirmTitle = "சந்தாவை நீக்கவா?"
    override val subscriptionsAddHint = "சந்தாக்கள் அல்லது ப்ராக்ஸி இணைப்புகளைச் சேர் →"
    override val addSourcesTitle = "சேர்"
    override val addSubsLabel = "சந்தாக்கள் (ஒரு வரிக்கு ஒரு URL)"
    override val addSubsHelp = "சரியான URL உள்ள ஒவ்வொரு வரியும் அதன் சொந்த சந்தாவாகிறது மற்றும் அவ்வப்போது பெறப்படுகிறது."
    override val addProxiesLabel = "தயாரான ப்ராக்ஸி இணைப்புகள் (நிலையான பட்டியல்)"
    override val addProxiesHelp = "குறிப்பிட்ட ப்ராக்ஸிகளுக்கான இணைப்புகளின் தொகுப்பை ஒட்டவும் (tg://proxy, https://t.me/proxy, …). இது சந்தா அல்ல — பட்டியல் ஒருபோதும் பதிவிறக்கப்படாது, ப்ராக்ஸிகள் வெறுமனே பட்டியலில் சேர்க்கப்படுகின்றன."
    override val addButton = "சேர்"
    override fun addedFmt(subs: Int, proxies: Int) = "சேர்க்கப்பட்டது: ${subs} சந்தாக்கள், ${proxies} ப்ராக்ஸிகள்"
    override val perSecond = "வினாடிக்கு"
    override val graphSpeed = "வேகம்"
    override val graphVolume = "அளவு"
    override val graphLatency = "Ping"
    override val graphConnects = "இணைப்புகள்"
    override val scanNow = "இப்போது ஸ்கேன் செய்"; override val scanOnShort = "ஸ்கேன் இயக்கு"
    override val scanRunning = "ஸ்கேன் இயங்குகிறது"; override val scanIdle = "ஸ்கேன் செயலற்றது"; override val scanOffState = "ஸ்கேன் அணை"; override val scanBatchPerThread = "தொகுதி/நூல்"; override val scanPassHosts = "ஓட்டத்தில் ஹோஸ்ட்கள்"; override val minRescanLabel = "ஒரு ஹோஸ்டை ஒவ்வொரு N நிமிடத்திற்கு ஒரு முறையை விட அடிக்கடி மீண்டும் ஸ்கேன் செய்யாதே"
    override val scanPlanTitle = "திட்டம்"; override val scanNowTitle = "இப்போது"; override val currentScheduleTitle = "தற்போதைய அட்டவணை"
    override val scheduleWord = "அட்டவணை"; override val unitPcsPerSec = "எண்/வி"
    override val scanNowThreadsLabel = "இப்போது இயங்கும் நூல்கள்"; override val scanNowPerThreadLabel = "ஒரு நூலுக்கு சோதனைகள் (திட்டம்)"; override val scanNowElapsedLabel = "இயங்கும் நேரம்"
    override val scanOkGraph = "வெற்றிகரமான ஸ்கேன்கள்"; override val scanFailGraph = "தோல்வியடைந்த ஸ்கேன்கள்"; override val scanTrafficGraph = "ஸ்கேன் டிராஃபிக்"; override val scanAliveGraph = "செயலில் உள்ள மொத்த ப்ராக்ஸிகள்"; override val scanPingGraph = "Ping"; override val threadsGraph = "நூல்கள்"
    override val scanEvery = "ஒவ்வொரு"; override val scanNextRun = "அடுத்த ஓட்டம்"
    override val scanThreads = "நூல்கள்"; override val scanBatch = "தொகுதி"
    override val scanElapsed = "இயங்குகிறது"; override val scanIdleNow = "—"
    override val effForFew = "குறைவாக இருக்கும்போது"; override val effForMany = "அதிகமாக இருக்கும்போது"
    override val effCheck = "சரிபார்"; override val effBatch = "தொகுதி"; override val effPar = "இணை"
    override val effContinuous = "தொடர்ச்சியான"; override val secShort = "வி"; override val minShort = "நிமிடம்"

    override val appTagline = "குறுக்கு-தள தானியங்கி-இணைப்பான்: Telegram வேலை செய்யும் MTProto ப்ராக்ஸிகளைக் " +
        "கண்டுபிடித்து, சரிபார்த்து, இயக்குகிறது."
    override val version = "பதிப்பு"; override val buildDate = "பில்ட் தேதி"
    override val downloadSources = "பதிவிறக்கம் & மூலங்கள்"; override val openOnGithub = "GitHub-இல் திற"
    override val feedbackBugs = "கருத்து & பிழை அறிக்கைகள்"; override val writeTelegram = "Telegram-இல் எழுது"

    override val language = "மொழி"; override val langAuto = "தானியங்கி (கணினி)"; override val langRu = "Русский"; override val langEn = "English"
    override val langFa = "فارسی"; override val langZh = "简体中文"; override val langAr = "العربية"; override val langUr = "اردو"
    override val langTr = "Türkçe"; override val langId = "Bahasa Indonesia"; override val langHi = "हिन्दी"; override val langBn = "বাংলা"; override val langMy = "မြန်မာ"
    override val langWord = "மொழி"
    override val raceWidthTitle = "இணை இணைப்புகள்"
    override val connectionSection = "இணைப்பு & தடை தவிர்ப்பு"
    override val connectionSectionHelp = "இணைப்பு என்ஜின், இணை அப்ஸ்ட்ரீம்கள், ப்ராக்ஸி என்ஜின் மற்றும் எதிர்-DPI தந்திரங்கள் — அனைத்தும் ஒரே பிரிவில்."
    override val netLogSection = "நெட்வொர்க் பரிமாற்ற பதிவு"
    override val platform = "தளம்"

    override val scanModeTitle = "நெட்வொர்க் பயன்முறை"; override val scanModeAuto = "தானியங்கி"; override val scanModeManualLabel = "கைமுறை"
    override val activeModeLabel = "செயலில் உள்ள பயன்முறை"; override val formingListLabel = "பட்டியலை உருவாக்குகிறது"; override val catalogModeTabs = "பயன்முறை"
    override val resetModeRatings = "ஹோஸ்ட் மதிப்பீடுகளை மீட்டமை"; override val forgetModeHosts = "பயன்முறை ஹோஸ்ட்களை மற"
    override val exportModeTitle = "பயன்முறை வாரியான ஏற்றுமதி"; override val modePickerTitle = "பயன்முறை"
    override val modeHelp = "ஒவ்வொரு நெட்வொர்க் பயன்முறையும் தனது சொந்த ப்ராக்ஸி மதிப்பீடுகளையும் தனது சொந்த ஸ்கேன் + சந்தா-பதிவிறக்க தீவிரத்தையும் வைத்திருக்கிறது. \"தானியங்கி\" செயலில் உள்ள நெட்வொர்க்கிலிருந்து பயன்முறையைத் தேர்வு செய்கிறது. \"கைமுறை\" எந்த பயன்முறையையும் நீங்களே தேர்வு செய்ய அனுமதிக்கிறது (White உட்பட, இதை தானியங்கி ஒருபோதும் தேர்வு செய்யாது)."
    override val autoSelect = "தானியங்கி தேர்வு"; override val manualSelect = "கைமுறை தேர்வு"
    override val connStatsTitle = "இப்போது இணைப்புகள்"; override val connOnPort = "போர்ட்டில் இணைப்புகள்"; override val outgoingConns = "வெளிச்செல்லும் இணைப்புகள்"
    override val modeChoice = "பயன்முறை தேர்வு"; override val autoChoice = "தானியங்கி-தேர்வு"; override val manualChoice = "கைமுறை நிலையானது"
    override val directOnVpn = "VPN-இல் TG-க்கு நேரடி இணைப்பு"; override val onWord = "இயக்கு"; override val offWord = "அணை"
    override val directStateActive = "செயலில்"; override val directStateOff = "அமைப்புகளில் அணைக்கப்பட்டது"; override val directStateIdle = "அமைப்புகளில் இயக்கப்பட்டது, ஆனால் செயலில் இல்லை"
    override val wpHintTitle = "White என்றால் என்ன?"
    override val wpHint = "White — WhitePages: ஒரு கைமுறை நெட்வொர்க் சுயவிவரம். கையால் மட்டுமே இயக்கப்படுகிறது (தானியங்கி-தேர்வு அதை ஒருபோதும் தேர்வு செய்யாது). " +
        "தனது சொந்த ஹோஸ்ட் மதிப்பீடுகளை வைத்திருக்கிறது, சந்தாக்களைப் பதிவிறக்குகிறது மற்றும் VPN/Wi-Fi/LTE-ஐ சார்ந்து இல்லாமல் சுயாதீனமாக ஸ்கேன் செய்கிறது."

    override val recentAttempts = "சமீபத்திய இணைப்புகள் & சோதனைகள்"
    override val kindCheck = "சோதனை"
    override val kindTg = "Telegram"
    override val histWho = "யார்"
    override val histWhen = "எப்போது"
    override val histReq = "கோரிக்கை"
    override val histSess = "அமர்வு"
    override val histScan = "ஸ்கேன்"
    override val testNow = "இப்போது சோதி"
    override val testShort = "சோதி"
    override val testResult = "சோதனை முடிவு"
    override val testStop = "நிறுத்து"
    override val testingNow = "சோதிக்கிறது…"
    override val prewarmTitle = "சாக்கெட் முன்சூடாக்கம் (சோதனைப்பூர்வம்)"
    override val prewarmHelp = "புதிய Telegram இணைப்பு இணைப்பு/ஹேண்ட்ஷேக்கைத் தவிர்க்கும் வகையில் ப்ராக்ஸிக்கு " +
        "சில சாக்கெட்களை முன்கூட்டியே திறந்து வைத்திருக்கவும். சோதனைப்பூர்வம்: பின்னணி தொடர்ந்து மீண்டும் இணைக்கிறது → " +
        "டிராஃபிக் மற்றும் சிறிது CPU செலவாகும். போலி டிராஃபிக் அனுப்பப்படாது (அது உண்மையான அமர்வைச் சிதைக்கும்) — " +
        "சாக்கெட்கள் வெறுமனே சுழற்றப்படுகின்றன. FakeTLS ப்ராக்ஸிகளுடன் மிகவும் பயனுள்ளது."
    override val prewarmEnable = "முன்சூடாக்கத்தை இயக்கு"
    override val prewarmModeDeferred = "ஒத்திவைக்கப்பட்டது (TLS மட்டும்)"
    override val prewarmModeDeferredSub = "TCP + FakeTLS வைத்திருக்கிறோம்; obfuscated2-init-ஐ ஒப்படைப்பின் போது அனுப்புகிறோம். DC ஒப்படைக்கப்படாது — மிகவும் யதார்த்தமானது."
    override val prewarmModeFull = "முழு ஹேண்ட்ஷேக்"
    override val prewarmModeFullSub = "வெவ்வேறு DC முழுவதும் முழுமையாக இணைக்கப்பட்ட சாக்கெட்களை வைத்திருக்கிறோம்; DC/tag பொருந்தும்போது மட்டுமே மீண்டும் பயன்படுத்துகிறோம். குறைந்த நேரம் வாழ்கின்றன."
    override val prewarmPoolLabel = "காப்பு சாக்கெட்கள்"
    override val prewarmHoldLabel = "ஒவ்வொன்றையும் வைத்திரு, வி"
    override val prewarmNote = "சுழற்சி மட்டும் (பயன்பாட்டு-நிலை keepalive இல்லை). ப்ராக்ஸி/DC-ஐப் பொறுத்து சாக்கெட் சில வினாடிகள்…~ஒரு நிமிடம் வாழ்கிறது."
    override val prewarmStatus = "முன்சூடாக்கம்"
    override fun prewarmStatusVal(ready: Int, holdSecs: Int) = "${ready} தயார் · ${holdSecs}வி வைத்திருக்கிறேன்"
    override val prewarmStar = "தடிமனான ஆரஞ்சு = முன்சூடாக்கக் குளத்திலிருந்து சூடாக ஒப்படைக்கப்பட்ட சாக்கெட் (இணைப்பு/ஹேண்ட்ஷேக் தவிர்க்கப்பட்டது)"
    override fun prewarmTableTitle(holdSecs: Int) = "சாக்கெட் முன்சூடாக்கம் (${holdSecs}வி வைத்திருக்கிறேன்)"
    override val prewarmTableHelp = "\"சாக்கெட் முன்சூடாக்கம்\" புதிய Telegram இணைப்பு இணைப்பு/ஹேண்ட்ஷேக்கைத் தவிர்க்கும் வகையில் " +
        "சில ப்ராக்ஸி சாக்கெட்களை முன்கூட்டியே திறக்கிறது. முன்சூடாக்கப்படும் சாக்கெட்கள் இந்த அட்டவணையில் பட்டியலிடப்படுகின்றன: ஒவ்வொன்றும் எத்தனை " +
        "நேரம் வாழ்ந்தது, Telegram அதைப் பயன்படுத்துகிறதா, மற்றும் டிராஃபிக். மேலும் → அமைப்புகள் → \"சாக்கெட் முன்சூடாக்கம் (சோதனைப்பூர்வம்)\"-இல் " +
        "இதை இயக்கலாம்/அணைக்கலாம் மற்றும் அமைக்கலாம் (பயன்முறை, சாக்கெட் எண்ணிக்கை, வைத்திருக்கும் நேரம்)."
    override val prewarmNoneWarming = "இன்னும் முன்சூடாக்கப்படும் சாக்கெட்கள் இல்லை"
    override val prewarmColAge = "வயது"
    override val prewarmColUse = "TG-இல்?"
    override val prewarmInUse = "TG-இல்"
    override val prewarmNew = "புதியது"
    override val lanShareTitle = "LAN வழியாக பகிர் (வலை போர்டல்)"
    override val lanShareDesc = "இந்த Wi-Fi-இல் உள்ள மற்ற சாதனங்கள் இந்த AutoConnector-ஐ ப்ராக்ஸியாகப் பயன்படுத்த அனுமதிக்கவும்; கீழே உள்ள முகவரியைத் திறக்கும் உலாவி சிறந்த ப்ராக்ஸிகளின் பக்கத்தைப் பெறும்."
    override val lanShareUrlsLabel = "அண்டை சாதனங்கள் இங்கே இணைக்கின்றன:"
    override val lanShareNoIp = "உள்ளூர்-நெட்வொர்க் முகவரி இல்லை — Wi-Fi-உடன் இணைக்கவும்"
    override val lanFirewallTitle = "உள்ளூர் நெட்வொர்க்கில் அனுமதி"
    override val lanFirewallBody = "இதை இயக்குவது ரிலே போர்ட்களை உங்கள் உள்ளூர் நெட்வொர்க்கிற்குத் திறக்கிறது. Windows (அல்லது வேறு) ஃபயர்வால் இப்போது AutoConnector-ஐ அனுமதிக்கவா எனக் கேட்கலாம் — அனுமதி / ஆம் என்பதைத் தேர்வு செய்யவும். நீங்கள் மறுத்தால், AutoConnector-க்கான அண்டை சாதனங்களின் டிராஃபிக் தடுக்கப்படும், மேலும் பக்கம்/ப்ராக்ஸி அணுக முடியாது."
    override val lanFirewallConfirm = "இயக்கு"
    override val lanInfoTitle = "இது எதற்கு?"
    override val lanInfoBody = "உங்கள் Wi-Fi-இல் ஒரே ஒரு கணினி அல்லது தொலைபேசியில் AutoConnector-ஐ இயக்கவும் — அதே நெட்வொர்க்கில் உள்ள மற்ற ஒவ்வொரு சாதனமும், இந்தப் பயன்பாடு நேரடியாக ஆதரிக்காத iPhone உட்பட, உலாவியில் முகவரியைத் திறந்து அதைப் பயன்படுத்தலாம்: அவர்களின் Telegram-இல் சேர்க்க சிறந்த ப்ராக்ஸிகளின் பக்கம், அல்லது இந்த சாதனத்தையே ஒரு SOCKS ப்ராக்ஸியாக. ஒரு சாதனம் ப்ராக்ஸிகளைக் கண்டுபிடித்து வைத்திருக்கிறது; மற்றவை LAN வழியாக அதைக் கடன் வாங்குகின்றன."
    override val volTriggerTitle = "ஒலியளவு-பொத்தான் தூண்டுதல்"
    override val volTriggerSub = "வேகமான ஒலியளவு-விசை வடிவத்துடன் ப்ராக்ஸியை மாற்று"
    override val volEnableLabel = "ஒலியளவு பொத்தான்களைக் கண்காணி"
    override val volHelpTitle = "இது என்ன?"
    override val volHelpBody = "Android-இல் உலகளாவிய விசைப்பலகை ஹாட்கீகள் இல்லை, எனவே இது ஒலியளவு பொத்தான்களைப் பயன்படுத்துகிறது. இயக்கப்பட்டிருக்கும்போது, AutoConnector பின்னணியில் வேகமான ஒலியளவு-மேல்/கீழ் அழுத்தங்களின் வடிவத்தை (எ.கா. மேல்-மேல்-கீழ்-கீழ்) கண்காணிக்கிறது. ஒன்றை அடையாளம் கண்டால், அது சீரற்ற நல்ல, செயலில் உள்ள ப்ராக்ஸியின் tg:// இணைப்பைத் திறக்கிறது, அதனால் Telegram அதை எடுத்து மாறுகிறது — பயன்பாட்டைத் திறக்காமல் ப்ராக்ஸியைச் சுழற்ற விரைவான, மறைவான வழி. ஒலியளவு வழக்கம் போல் வேலை செய்கிறது (அழுத்தங்கள் விழுங்கப்படுவதில்லை). இதற்கு Accessibility அணுகல் தேவை (பின்னணியில் ஒலியளவு விசைகளைப் படிக்கவும் இணைப்பைத் திறக்கவும்); நீங்கள் நிலைமாற்றியை இயக்கும் வரை எதுவும் கோரப்படாது. கீழே அழுத்தங்களுக்கு இடையிலான அதிகபட்ச நேரத்தை அமைக்கவும்; அடையாளம் காணப்படும் வடிவங்கள் கீழே பட்டியலிடப்பட்டுள்ளன."
    override val volGrantTitle = "Accessibility-ஐ இயக்கு (முக்கியம்)"
    override val volGrantBody = "Android (குறிப்பாக 13+) Google Play-இலிருந்து நிறுவப்படாத பயன்பாடுகளுக்கு Accessibility-ஐத் தடுக்கிறது — அதனால்தான் AutoConnector சாம்பல் நிறமாகி \"கட்டுப்படுத்தப்பட்ட அமைப்பு\" / \"அணுகல் அனுமதிக்கப்படவில்லை\" எனக் காட்டுகிறது.\n\nதடையை நீக்குவது எப்படி:\n1. \"பயன்பாட்டுத் தகவல்\"-ஐத் திறக்கவும் (கீழே உள்ள பொத்தான், அல்லது அமைப்புகள் → பயன்பாடுகள் → AutoConnector for Telegram).\n2. ⋮ மெனுவை (மேல்-வலது) தட்டவும் → \"கட்டுப்படுத்தப்பட்ட அமைப்புகளை அனுமதி\" → உறுதிப்படுத்தவும்.\n3. திரும்பிச் செல்லவும்: அமைப்புகள் → Accessibility → AutoConnector for Telegram → அதை இயக்கவும்.\n\n\"கட்டுப்படுத்தப்பட்ட அமைப்புகளை அனுமதி\" தெரியவில்லை என்றால், முதலில் Accessibility-இல் ஒரு முறை இயக்க முயற்சிக்கவும் (தடுக்கப்பட்ட செய்தியைப் பெறுவீர்கள்), பின்னர் படி 2 தோன்றும்.\n\nXiaomi/MIUI, Samsung போன்றவற்றில் பாதை சற்று வேறுபடலாம் — \"பயன்பாட்டுத் தகவல்\"-இல் அதே ⋮-ஐத் தேடவும். Android 12 மற்றும் பழையதில் வழக்கமாக கட்டுப்பாடு இல்லை — Accessibility-இல் அதை நேரடியாக இயக்கவும்.\n\nஒலியளவு விசைகள் கவனிக்கப்படுகின்றன மட்டுமே, ஒருபோதும் தடுக்கப்படுவதில்லை."
    override val volOpenAppInfo = "பயன்பாட்டுத் தகவலைத் திற"
    override val volAccessOn = "Accessibility: வழங்கப்பட்டது"
    override val volAccessOff = "Accessibility: வழங்கப்படவில்லை"
    override val volOpenAccess = "Accessibility அமைப்புகளைத் திற"
    override val volGapLabel = "அழுத்தங்களுக்கு இடையே அதிகபட்ச மிவி"
    override val volPatternsTitle = "அடையாளம் காணப்படும் வடிவங்கள்"
    override val volPatternPick = "வடிவம்"
    override val volPatternsLegend = "↑ = ஒலியளவு மேல், ↓ = ஒலியளவு கீழ்"
    override val volNoRights = "ஒலியளவு பொத்தான்களைக் கையாள பயன்பாட்டுக்கு இன்னும் அனுமதி இல்லை — இந்தப் பக்கத்தின் கீழே உள்ள படிகளைப் பயன்படுத்தி அணுகலை வழங்கவும்."
    override val volGrantShort = "இன்னும் Accessibility அணுகல் இல்லை. இந்தப் பக்கத்தின் கீழே உள்ள விரிவான படிகளைப் படித்து, பின்னர் \"சரிபார்\"-ஐத் தட்டவும்."
    override val volCheck = "சரிபார்"
    override val volCheckOk = "✓ முடிந்தது — அணுகல் வழங்கப்பட்டது, தூண்டுதல் வேலை செய்கிறது."
    override val volCheckFail = "✗ இன்னும் அணுகல் இல்லை — மேலே உள்ள படிகளை முடிக்கவும்."
    override val volPatternsList = "↑↑↓↓ · ↓↓↑↑ · ↑↓↑↓ · ↓↑↓↑ · ↑↑↑↑ · ↓↓↓↓ · ↑↓↓↑ · ↓↑↑↓ · ↑↑↑↓↓↓ · ↓↓↓↑↑↑   (↑ = ஒலியளவு மேல், ↓ = ஒலியளவு கீழ்)"
    override val histLegend = "பத்திகள் — யார்: ✓/✗ TG = உண்மையான Telegram இணைப்பு, ஸ்கேன் = பின்னணி சோதனை. எப்போது: எவ்வளவு நேரத்திற்கு முன். TCP/TLS/கோரிக்கை: ஹேண்ட்ஷேக் & முதல்-கோரிக்கை தாமதம், மிவி. அமர்வு: ரிலே அமர்வு எவ்வளவு நேரம் நீடித்தது. ↓/↑: ஹோஸ்ட் வழியாக பெறப்பட்ட / அனுப்பப்பட்ட பைட்டுகள்."
    override val tgOkTotalHint = "Telegram இணைப்புகள் / வெற்றிகரமான / மொத்த சோதனைகள்"
    override val breadthTitle = "ஹோஸ்ட் தேர்வு அகலம்"
    override val breadthHelp = "இடது = நிரூபிக்கப்பட்ட சிறந்த ஹோஸ்ட்களுடன் ஒட்டிக்கொள்; வலது = செயலில் உள்ள எல்லா ஹோஸ்ட்களிலும் முடிந்தவரை பரந்த அளவில் முயற்சி செய். Telegram ரிலே போர்ட்களை தொடர்ந்து மாற்றும்போது பயன்பாடு தானாகவே தேடலை விரிவாக்குகிறது."
    override val breadthNarrow = "நிரூபிக்கப்பட்டது"
    override val breadthWide = "பரந்தது"
    override val connTimeoutTitle = "ஹோஸ்ட்-வாரியான இணைப்பு நேரக்கெடு"
    override val connTimeoutHelp = "அடுத்த ப்ராக்ஸிக்குச் செல்வதற்கு முன் ஒரு அப்ஸ்ட்ரீமுக்காக (TCP + TLS + முதல் MTProto பதில்) எவ்வளவு நேரம் காத்திருப்பது."
    override val factoryResetDone = "எல்லாம் மீட்டமைக்கப்பட்டது. பயன்பாட்டை மூடி மீண்டும் திறக்கவும்."

    // tray
    override val trayOpenWindow = "சாளரத்தைத் திற"
    override val trayRefreshSubs = "சந்தாக்களைப் புதுப்பி"
    override val trayExit = "வெளியேறு"
    override fun trayConnectorLabel(on: Boolean) =
        if (on) "இணைப்பான்: ஆன் (அணைக்க)" else "இணைப்பான்: ஆஃப் (இயக்க)"
    override fun trayScanLabel(on: Boolean) =
        if (on) "ஸ்கேன்: ஆன் (அணைக்க)" else "ஸ்கேன்: ஆஃப் (இயக்க)"
    override fun trayLive(n: Int) = "செயலில் ப்ராக்ஸிகள்: ${n}"
    override val appearance = "தோற்றம்"
    override val themeLabel = "தீம்"
    override val themeAuto = "தானியங்கி (கணினிக்கு ஏற்ப)"
    override val themeLight = "வெளிர்"
    override val themeDark = "இருள்"
    override val drawGraphsLabel = "வரைபடங்களை வரையவும்"
    override val drawGraphsSub = "இணைப்பான் மற்றும் ஸ்கேன் தாவல்களில் நேரடி விளக்கப்படங்கள் — பேட்டரியை சேமிக்க அணைக்கவும்"
}
