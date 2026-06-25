package io.autoconnector.i18n

object Hi : Strings {
    override val tabConnector = "कनेक्टर"; override val tabScan = "स्कैन"
    override val tabCatalog = "कैटलॉग"; override val tabLogs = "लॉग"; override val tabMore = "और"
    override val logTabTelegram = "टेलीग्राम"; override val logTabSubs = "सब्सक्रिप्शन"; override val logTabScan = "स्कैन"
    override val logGeneral = "सामान्य"; override val logEmpty = "अभी खाली है"
    override val logSessions = "सेशन"; override val logErrorsOnly = "केवल त्रुटियाँ"; override val logNoErrors = "कोई विफल सेशन नहीं"
    override fun logSession(id: String, port: String) = "#$id · :$port"
    override val back = "वापस"; override val copy = "कॉपी करें"; override val gotIt = "समझ गया"
    override val later = "बाद में"; override val details = "विवरण"; override val whatIsThis = "यह क्या है?"
    override val delete = "हटाएँ"

    override val connector = "कनेक्टर"; override val scan = "स्कैन"
    override val notConfigured = "सेट अप नहीं! ठीक करें →"; override val howToSetup = "सेट अप कैसे करें"
    override val notifOff = "सूचनाएँ बंद हैं! ठीक करें →"; override val enable = "चालू करें"
    override fun fewProxies(n: Int) = "लाइव प्रॉक्सी $n, खोज जारी है, ~15 मिनट प्रतीक्षा करें…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "लाइव प्रॉक्सी: $alive  (15 मिनट: $within) · कुल: $total"
    override val notifWhyTitle = "सूचनाएँ क्यों?"
    override val notifWhyBody = "एक स्थायी सूचना आइकन का अर्थ है Android फ़ोरग्राउंड सेवा। " +
        "इसके बिना सिस्टम ऐप को मेमोरी से हटा देता है और यह प्रॉक्सी खोजना तथा " +
        "बैकग्राउंड में कनेक्शन बनाए रखना बंद कर देता है। इसीलिए " +
        "AutoConnector के काम करने के लिए सूचनाएँ आवश्यक हैं।"
    override val notifEnableTitle = "सूचनाएँ चालू करें"
    override val notifEnableBody = "सूचना आइकन के बिना, Android ऐप को निष्क्रिय मानता है और " +
        "उसे मेमोरी से हटा देता है। फिर AutoConnector प्रॉक्सी खोजना तथा बैकग्राउंड में " +
        "कनेक्शन बनाए रखना बंद कर देता है — टेलीग्राम अपना लिंक खो देता है।\n\n\"चालू करें\" पर टैप करें और " +
        "AutoConnector के लिए सूचनाओं की अनुमति दें।"
    override val notifPlea = "सूचनाएँ चालू करें! इनके बिना ऐप बैकग्राउंड में नहीं चल सकता — " +
        "Android इसे हटा देगा और प्रॉक्सी खोज तथा कनेक्शन रुक जाएगा।"

    override val statusConnected = "टेलीग्राम जुड़ा हुआ"; override val statusConnecting = "जुड़ रहा है…"
    override val statusOffline = "टेलीग्राम जुड़ा नहीं"; override val statusIdle = "टेलीग्राम निष्क्रिय"
    override val nobodyConnected = "कोई भी कनेक्टर से नहीं जुड़ा। "; override val howToSetupArrow = "सेट अप कैसे करें →"
    override val directModeViaVpn = "डायरेक्ट मोड: VPN सक्रिय — कोई प्रॉक्सी नहीं"
    override val directModeOff = "डायरेक्ट मोड: प्रॉक्सी बंद"
    override val directDpiSuffix = " · एंटी-DPI"
    override val connections = "कनेक्शन"; override val sockets = "सॉकेट"; override val speed = "गति"
    override val traffic = "ट्रैफ़िक"; override val latency = "लेटेंसी"
    override fun pcs(n: Int) = "$n नग"
    override fun netNow(label: String) = "नेटवर्क: $label"
    override fun tgToConnector(n: Int) = "TG→ $n"
    override fun connectorToProxy(n: Int) = "प्रॉक्सी $n"
    override val trafficSec = "ट्रैफ़िक · 60 सेकंड"; override val trafficMin = "ट्रैफ़िक · 60 मिनट"
    override val latencySec = "लेटेंसी · 60 सेकंड"; override val latencyMin = "लेटेंसी · 60 मिनट"
    override val sec60 = "60 सेकंड"; override val min60 = "60 मिनट"
    override val unitSec = "से"; override val unitMin = "मि"; override val unitHour = "घं"; override val dash = "—"
    override val currentProxy = "वर्तमान प्रॉक्सी"; override val noActiveProxy = "कोई सक्रिय प्रॉक्सी नहीं (टेलीग्राम जुड़ा नहीं)"
    override val host = "होस्ट"; override val type = "प्रकार"; override val secret = "सीक्रेट"; override val antiDpi = "एंटी-DPI"; override val obfEngine = "ऑब्फ़सकेशन इंजन"
    override fun activeSockets(n: Int) = "सक्रिय टेलीग्राम सॉकेट: $n"
    override val noConnections = "कोई सक्रिय कनेक्शन नहीं"; override val colHost = "होस्ट"; override val colTime = "समय"
    override val modeWord = "मोड"; override val directViaVpnLine = "टेलीग्राम को डायरेक्ट अनुरोध (VPN सक्रिय)"
    override val connModeHelp = "मोड (VPN, Wi-Fi, LTE, Ethernet, White) आपको स्कैन तीव्रता को अलग-अलग ट्यून करने और अलग होस्ट रेटिंग/आँकड़े रखने देते हैं। नेटवर्क कार्ड स्वतः पहचाना जाता है; मोड को सेटिंग्स में मैन्युअल रूप से सेट किया जा सकता है।"

    override val scanOff = "स्कैनिंग बंद है"; override val proxiesInBase = "डेटाबेस में प्रॉक्सी"
    override val total = "कुल"; override val alive = "लाइव"; override val dead = "मृत"
    override val tgConnectedTitle = "टेलीग्राम इसके ज़रिए जुड़ा"; override val successful = "सफल"
    override val socketsHeld = "सॉकेट जीवनकाल"; override val over1m = ">1 मिनट"; override val over5m = ">5 मिनट"; override val over15m = ">15 मिनट"
    override val scanCountTitle = "प्रॉक्सी जाँच गिनती"; override val checked = "जाँचे गए"
    override val forAllTime = "अब तक कुल"; override val perMinute = "प्रति मिनट"; override val perHour = "प्रति घंटा"
    override val subsCountTitle = "सब्सक्रिप्शन डाउनलोड गिनती"; override val downloaded = "डाउनलोड किए गए"; override val failed = "विफल"; override val scanTraffic = "स्कैन ट्रैफ़िक"; override val subTraffic = "सब्सक्रिप्शन ट्रैफ़िक"; override val subTrafficGraph = "सब्सक्रिप्शन ट्रैफ़िक"
    override val checksMtproto = "MTProto जाँच (↑ ठीक · ↓ विफल)"

    override fun catalogEmpty(mode: String) = "कैटलॉग $mode अभी खाली है। या तो कोई होस्ट नहीं मिला, या ऐप इस मोड में कभी नहीं चला। आप मोड को सेटिंग्स में बदल सकते हैं। मोड इसलिए होते हैं ताकि अलग-अलग प्रकार के इंटरनेट कनेक्शन के लिए होस्ट अलग-अलग एकत्र किए जा सकें।"
    override val aliveShort = "✓ लाइव"; override val deadShort = "✗ मृत"
    override val statusLabel = "स्थिति"; override val rating = "रेटिंग"; override val port = "पोर्ट"
    override val rttPing = "RTT (पिंग)"; override val checkedField = "जाँचे गए"; override val okOfTotal = "सफल / कुल जाँच"
    override val tgConnectedField = "टेलीग्राम जुड़ा"; override val tgSessions = "टेलीग्राम सेशन"; override val trafficThroughProxy = "प्रॉक्सी से होकर ट्रैफ़िक"
    override val sessionsTotal = "कुल सेशन"; override val relayNow = "अभी रिले"; override val tlsDomain = "TLS डोमेन (SNI)"
    override val sourceSub = "स्रोत (सब्सक्रिप्शन)"; override val lastError = "अंतिम त्रुटि"; override val yes = "हाँ"; override val no = "नहीं"
    override val copyAsLink = "लिंक के रूप में कॉपी करें"; override val openInTelegram = "होस्ट को टेलीग्राम में खोलें"; override val makeNextRelay = "अगला रिले बनाएँ"
    override val actCopy = "कॉपी"; override val actOpen = "खोलें"; override val actRelay = "रिले"
    override fun agoFmt(v: String) = "$v पहले"
    override val catalogTopFor = "इसके लिए प्रॉक्सी सूची/रेटिंग"
    override val catalogModeHelpTitle = "मोड और रेटिंग"
    override val catalogModeHelp = "ऐप लाइव होस्ट और उनकी रेटिंग को प्रत्येक नेटवर्क मोड (VPN, Wi-Fi, LTE, Ethernet और White) के लिए अलग-अलग गिनता है। «White» व्हाइटलिस्ट के लिए एक अलग मैन्युअल मोड है; ऑटो इसमें कभी स्विच नहीं करता। इसलिए एक ही होस्ट एक मोड में लाइव और दूसरे में मृत हो सकता है।"
    override fun catalogInactiveWarn(section: String, active: String) =
        "आप निष्क्रिय खंड $section देख रहे हैं — अभी सभी आँकड़े $active में जाते हैं, यहाँ नहीं।"
    override val manageModeTitle = "मोड प्रबंधित करें"
    override val manageResetRating = "रेटिंग रीसेट करें"
    override fun manageResetHint(mode: String) = "विशेष रूप से $mode के लिए आप लाइव होस्ट की रेटिंग और उपयोग आँकड़े रीसेट कर सकते हैं। यह तब काम आता है जब आप किसी मौलिक रूप से भिन्न VPN या LTE से जुड़े हों, ताकि पुराने आँकड़े हस्तक्षेप न करें। या यह देखने के लिए कि प्रॉक्सी स्कैन सब कुछ शुरू से कितनी तेज़ी से फिर से जाँचता है।"
    override val manageDeleteAll = "इसमें होस्ट हटाएँ"
    override fun manageDeleteHint(mode: String) = "आप $mode से रेटिंग और होस्ट दोनों को साफ़ कर सकते हैं। \"प्रॉक्सी स्कैन करें\" सुविधा उन्हें फिर से एकत्र करेगी। यह सब्सक्रिप्शन रीसेट नहीं है — आप इसे टैप कर सकते हैं, फिर री-स्कैन के लिए ~15 मिनट प्रतीक्षा करें।"
    override fun manageCopyFrom(mode: String) = "सभी होस्ट और रेटिंग को किसी अन्य मोड से इस मोड ($mode) में कॉपी करें:"
    override val live = "लाइव"; override val deadW = "मृत"; override val unitMs = "मिसे"
    override val agoMin = "मि"; override val agoHour = "घं"; override val agoDay = "दि"

    override val connectTelegram = "टेलीग्राम जोड़ना"; override val readCarefully = "ध्यान से पढ़ें!"
    override val guideIntro = "यह ऐप सेट अप के बिना काम नहीं करेगा। नीचे दिए गए 3 विकल्पों में से कोई एक चुनें " +
        "और निर्देशों का ध्यानपूर्वक पालन करें।"
    override val variant1 = "विकल्प #1 — बटन"
    override val variant1Body = "\"प्रॉक्सी {A}\" पर टैप करें — टेलीग्राम खुलेगा, प्रॉक्सी जोड़ने की पुष्टि करें। इस " +
        "स्क्रीन पर वापस आएँ और \"प्रॉक्सी {B}\" पर टैप करें — दूसरी बार जोड़ने की पुष्टि करें।\n\nटेलीग्राम में कोई भी " +
        "अन्य पुराने प्रॉक्सी अक्षम करें। ठीक 2 प्रॉक्सी रहने चाहिए — पोर्ट {A} और {B} के साथ। " +
        "किसी अन्य सेट के साथ AutoConnector काम नहीं करेगा।"
    override val variant2 = "विकल्प #2 — लिंक"
    override val variant2Body = "नीचे दिए गए टेक्स्ट को टेलीग्राम में Saved Messages (या किसी चैट) में कॉपी करें — " +
        "यानी इसे स्वयं को भेजें। अपने संदेश में पहले लिंक पर टैप करें — पहला प्रॉक्सी जुड़ जाता है। " +
        "दूसरे लिंक पर टैप करें — दूसरा जुड़ जाता है। फिर सभी पुराने प्रॉक्सी अक्षम करें।"
    override val variant3 = "विकल्प #3 — मैन्युअल रूप से"
    override val variant3Body = "मैन्युअल रूप से एक SOCKS5 प्रॉक्सी जोड़ें: सर्वर localhost (127.0.0.1), पोर्ट {A}। " +
        "फिर दूसरा प्रॉक्सी: localhost, पोर्ट {B}। कोई भी पुराने प्रॉक्सी हटाएँ।"
    override val whatNext = "आगे क्या?"
    override val whatNextBody = "टेलीग्राम में \"प्रॉक्सी ऑटो-स्विच\" चालू करें — 5 सेकंड। आप किसी प्रॉक्सी (टेलीग्राम के अंदर) " +
        "पर मैन्युअल रूप से टैप करके टेलीग्राम को जुड़ने में मदद कर सकते हैं जो सक्रिय नहीं है या \"अनुपलब्ध\" " +
        "चिह्नित है — इससे टेलीग्राम जुड़ने के लिए अधिक प्रयास करता है।\n\nसुनिश्चित करें कि {A} और {B} के अलावा " +
        "सभी अन्य पुराने प्रॉक्सी हटा दिए गए हैं। टेलीग्राम में " +
        "\"प्रॉक्सी का उपयोग करें\" पर टैप करें।\n\nप्रतीक्षा करें जब तक ऐप पर्याप्त प्रॉक्सी ढूँढ़ और डाउनलोड कर लेता है " +
        "(5–15 मिनट)। फिर टेलीग्राम स्वयं AutoConnector से जुड़ जाता है, जो " +
        "टेलीग्राम को सर्वश्रेष्ठ प्रॉक्सी के माध्यम से रूट करता रहेगा: सत्यापित, लाइव और तेज़।\n\nयदि निर्देश कठिन " +
        "लगते हैं — क्षमा करें, आप ऐप का उपयोग नहीं कर पाएँगे: सब कुछ स्वचालित रूप से सेट करना " +
        "असंभव है, और लाइव प्रॉक्सी ढूँढ़ने में समय लगता है।\n\nयदि आपने ऐप बहुत पहले डाउनलोड किया था " +
        "और कोई लाइव प्रॉक्सी नहीं मिला — या तो ऐप या सब्सक्रिप्शन सूची अपडेट करें। यह ऐप " +
        "अपने प्रॉक्सी नहीं बनाता या प्रदान नहीं करता, यह केवल दर्जनों समूहों और पृष्ठों में इंटरनेट पर " +
        "खोज करता है।"
    override fun proxyBtn(port: Int) = "प्रॉक्सी $port"

    override val setupPortsTitle = "टेलीग्राम में पोर्ट सेट अप करें"
    override val setupPortsSub = "टेलीग्राम को कनेक्टर से कैसे जोड़ें (पोर्ट 55001/55002)"
    override val settings = "सेटिंग्स"; override val settingsSub = "पोर्ट, एंटी-DPI, स्कैन, नेटवर्क, बैटरी"
    override val subscriptions = "सब्सक्रिप्शन"; override val subscriptionsSub = "स्कैन करने के लिए प्रॉक्सी स्रोत"
    override val statistics = "आँकड़े"; override val statisticsSub = "प्रॉक्सी डेटाबेस + एंटी-DPI तरकीबें"
    override val export = "एक्सपोर्ट"; override val exportSub = "लाइव प्रॉक्सी के tg:// लिंक"
    override val about = "जानकारी"; override val aboutSub = "संस्करण, बिल्ड, डाउनलोड, फ़ीडबैक"
    override val hotkeys = "हॉटकी"
    override val hotkeysSub = "ग्लोबल कुंजियाँ: प्रॉक्सी कॉपी / खोलें"
    override val hotkeysIntro = "ग्लोबल हॉटकी तब भी काम करती हैं जब ऐप विंडो फ़ोकस में न हो। वे पूल से एक " +
        "यादृच्छिक लाइव प्रॉक्सी लिंक (tg://) चुनती हैं — ऐप खोले बिना तेज़ी से प्रॉक्सी स्विच करने के लिए " +
        "उपयोगी।"
    override val hotkeysNote = "macOS पर, कुंजियाँ कैप्चर करने के लिए Accessibility अनुमति आवश्यक हो सकती है " +
        "(System Settings → Privacy & Security → Accessibility)।"
    override val hotkeyCopyTitle = "प्रॉक्सी लिंक कॉपी करें"
    override val hotkeyCopyDesc = "क्लिपबोर्ड पर एक यादृच्छिक लाइव tg:// लिंक रखता है।"
    override val hotkeyEnable = "हॉटकी चालू करें"; override val hotkeyLetterLabel = "अक्षर"; override val hotkeySet = "सेट करें"; override val hotkeyReset = "रीसेट"
    override val hotkeyOpenTitle = "प्रॉक्सी को टेलीग्राम में खोलें"
    override val hotkeyOpenDesc = "एक यादृच्छिक लाइव लिंक खोलता है — टेलीग्राम इसे ग्रहण कर प्रॉक्सी जोड़ने का प्रस्ताव देता है।"

    override val relayPorts = "रिले पोर्ट"
    override val relayPortsHelp = "स्थानीय पोर्ट जिन पर कनेक्टर सुनता है। आप टेलीग्राम में ठीक यही " +
        "SOCKS5 प्रॉक्सी के रूप में दर्ज करते हैं (127.0.0.1 : पोर्ट)। विश्वसनीयता के लिए दो पोर्ट उपयोग होते हैं — टेलीग्राम " +
        "दोनों से कनेक्शन बनाए रखता है।"
    override val portA = "पोर्ट A"; override val portB = "पोर्ट B"
    override val antiDpiTrick = "एंटी-DPI तरकीब"
    override val antiDpiHelp = "कनेक्शन को छिपाने का एक तरीका ताकि ISP/DPI इसे पहचान कर " +
        "ब्लॉक न कर सके।\n• \"ऑटो-रोटेट\" स्वयं एक कार्यशील तरकीब चुनता है।\n• \"कोई DPI तरकीब नहीं\" — एक सादा " +
        "कनेक्शन।\n• बाकी विशिष्ट तकनीकें हैं (ब्राउज़र की नकल, पैकेट विभाजन, आदि)।"
    override val onlyFakeTls = "केवल FakeTLS (ee)"
    override val applyDpiTo = "एंटी-DPI इस पर लागू करें"
    override val applyDpiHelp = "चुनी गई एंटी-DPI तरकीब को किस पर लागू करना है:\n• टेलीग्राम रिले — कनेक्टर के " +
        "माध्यम से लाइव टेलीग्राम कनेक्शन पर।\n• प्रॉक्सी प्रोब — बैकग्राउंड प्रॉक्सी जाँच पर " +
        "(तब एक जाँच ठीक वैसे ही व्यवहार करती है जैसे एक वास्तविक कनेक्शन, और तरकीब आँकड़े अधिक सटीक होते हैं)।\n" +
        "• डायरेक्ट जुड़ते समय — जब प्रॉक्सी बंद हों (या VPN चालू होने पर छोड़ दिए गए हों) और टेलीग्राम " +
        "सीधे अपने सर्वर पर जाता है: यहाँ कोई प्रॉक्सी नहीं है, इसलिए तरकीब पहले TCP पैकेट " +
        "(हैंडशेक) को कई छोटे खंडों में विभाजित करने तक सीमित हो जाती है ताकि DPI इसे एक रीड में मिला न सके।"
    override val toRelay = "टेलीग्राम रिले"; override val toProbes = "प्रॉक्सी प्रोब"
    override val toDirect = "डायरेक्ट जुड़ते समय"
    override val vpnSection = "जब VPN चालू हो"
    override val vpnHelp = "डिवाइस पर VPN सक्रिय होने पर क्या करें:\n• MTProto प्रॉक्सी के ज़रिए — " +
        "टेलीग्राम हमेशा की तरह मिले हुए प्रॉक्सी से होकर जाता है (VPN के ऊपर)।\n• डायरेक्ट — " +
        "कनेक्टर प्रॉक्सी का उपयोग नहीं करता और टेलीग्राम को सीधे टेलीग्राम के सर्वर से जोड़ता है: " +
        "VPN पहले से पहुँच प्रदान करता है, अतिरिक्त प्रॉक्सी परत की ज़रूरत नहीं (तेज़ और अधिक स्थिर)। " +
        "VPN के बिना प्रॉक्सी हमेशा की तरह उपयोग होते हैं।"
    override val linkFormat = "प्रॉक्सी लिंक प्रारूप"
    override val linkFormatHelp = "प्रॉक्सी को कैसे कॉपी और खोलें। tg:// टेलीग्राम को सीधे खोलता है (Telegram Desktop इंस्टॉल होना चाहिए)। http (t.me) ब्राउज़र के ज़रिए खोलता है और टेलीग्राम में खोलने का प्रस्ताव देता है — उपयोगी जब tg:// पंजीकृत न हो।"
    override val linkTg = "tg:// (टेलीग्राम सीधे खोलें)"; override val linkTgSub = "tg://proxy?… — टेलीग्राम खोलता है"
    override val linkHttp = "http (t.me, ब्राउज़र के ज़रिए)"; override val linkHttpSub = "https://t.me/proxy?… — ब्राउज़र खोलता है"
    override val viaMtproto = "MTProto के ज़रिए प्रॉक्सी"; override val viaMtprotoSub = "VPN के साथ भी, ट्रैफ़िक प्रॉक्सी से होकर जाता है"
    override val directly = "डायरेक्ट जुड़ें"; override val directlySub = "VPN सक्रिय होने पर — प्रॉक्सी छोड़ें, सीधे टेलीग्राम तक"
    override val notifications = "सूचनाएँ"
    override val scanCheck = "स्कैन और जाँच"
    override val scanCheckHelp = "• स्कैन, मिनट — सब्सक्रिप्शन से प्रॉक्सी सूचियाँ कितनी बार डाउनलोड करें।\n" +
        "• जाँच, मिनट — डेटाबेस में प्रॉक्सी को जीवंतता के लिए कितनी बार फिर से जाँचें।\n• बैच आकार — " +
        "प्रति रन कितने प्रॉक्सी जाँचें।\n• समानांतर — एक साथ कितनी जाँचें चलाएँ (अधिक = " +
        "तेज़, पर नेटवर्क और बैटरी पर अधिक भार)।"
    override val scanMin = "स्कैन, मिनट"; override val checkMin = "जाँच, मिनट"; override val batchSize = "बैच आकार"; override val parallel = "समानांतर"
    override val speedByNet = "नेटवर्क के अनुसार स्कैन तीव्रता"
    override val speedByNetHelp = "वर्तमान नेटवर्क के आधार पर प्रॉक्सी कितनी बार जाँचें। " +
        "\"मानक\" = आधार अंतराल। दाएँ खिसकाएँ कम के लिए (धीमा, ट्रैफ़िक/बैटरी पर नरम), " +
        "बाएँ अधिक बार के लिए (तेज़, अधिक आक्रामक)। लॉगरिदमिक स्केल, प्रत्येक दिशा में ×100 तक।\n" +
        "• VPN — जब बाहरी VPN सक्रिय हो।\n• Wi-Fi — Wi-Fi नेटवर्क पर।\n• LTE — मोबाइल नेटवर्क पर।"
    override val intensStandard = "मानक"
    override val intensSlower = "धीमा"
    override val intensFaster = "तेज़"
    override val maintenance = "डेटा रीसेट करें"
    override val maintenanceHelp = "• \"कैटलॉग और आँकड़े रीसेट करें\" — रेटिंग, काउंटर, ट्रैफ़िक " +
        "और जाँच लॉग शून्य करता है, पर डाउनलोड किए गए होस्ट और सब्सक्रिप्शन रखता है (अगले स्कैन पर " +
        "सब कुछ फिर से रेट होता है)।\n• \"डाउनलोड किए गए होस्ट साफ़ करें\" — पूरे प्रॉक्सी पूल को हटाता है पर " +
        "सब्सक्रिप्शन रखता है ताकि स्कैन पूल को फिर भर दे। सब्सक्रिप्शन किसी भी तरह कभी नहीं छुए जाते।"
    override val backupTitle = "एक्सपोर्ट / इम्पोर्ट"
    override val backupHelp = "ऐप डेटा को एक ही JSON फ़ाइल में सहेजें या पुनर्स्थापित करें। टिक करें कि क्या " +
        "शामिल करना है — कोई भी संयोजन:\n• सेटिंग्स — सभी ऐप पैरामीटर।\n• सब्सक्रिप्शन — स्रोत " +
        "सूची (URL + चालू/बंद)।\n• लाइव-होस्ट कैटलॉग — प्रत्येक नेटवर्क मोड के अनुसार प्रत्येक लाइव प्रॉक्सी अपनी रेटिंग और आँकड़ों " +
        "के साथ।\n\n«एक्सपोर्ट» पूछता है कहाँ सहेजें; «इम्पोर्ट» पूछता है कौन सी फ़ाइल खोलें और " +
        "उसमें मौजूद केवल टिक किए गए खंड लागू करता है। इम्पोर्ट वर्तमान डेटा में जोड़ता है (कोई मिटाव नहीं)।"
    override val backupSettings = "सेटिंग्स"
    override val backupSubs = "सब्सक्रिप्शन"
    override val backupHosts = "लाइव-होस्ट कैटलॉग (प्रति मोड)"
    override val exportWord = "एक्सपोर्ट"
    override val importWord = "इम्पोर्ट"
    override val eraseAllHosts = "सभी होस्ट मिटाएँ"
    override val factoryReset = "सब कुछ रीसेट करें (पहली बार चलाने जैसा)"
    override val factoryResetConfirm = "ऐप को पूरी तरह फ़ैक्टरी स्थिति में रीसेट करें? सभी सेटिंग्स और पूरा " +
        "होस्ट कैटलॉग मिटा दिया जाएगा, सब्सक्रिप्शन डिफ़ॉल्ट पर पुनर्स्थापित होंगे। बिल्कुल पहली बार चलाने जैसा।"
    override val resetCatalog = "कैटलॉग और आँकड़े रीसेट करें"
    override val resetCatalogConfirm = "सभी रेटिंग, काउंटर और जाँच लॉग शून्य करें? " +
        "डाउनलोड किए गए होस्ट और सब्सक्रिप्शन रखे जाते हैं और अगले स्कैन पर फिर से रेट होते हैं।"
    override val clearHosts = "डाउनलोड किए गए होस्ट साफ़ करें"
    override val clearHostsConfirm = "डाउनलोड किए गए होस्ट (प्रॉक्सी) की पूरी सूची हटाएँ? " +
        "सब्सक्रिप्शन रखे जाते हैं और स्कैन पूल को फिर भर देगा।"
    override val doReset = "रीसेट"
    override val doCancel = "रद्द करें"
    override val adaptiveSpeed = "अनुकूली गति"
    override val adaptiveHelp = "जीवंतता जाँच एक आधार अंतराल पर चलती हैं (\"स्कैन और जाँच\" से, नेटवर्क " +
        "गुणक से भी गुणित)। \"अनुकूली गति\" इन्हें इस आधार पर स्वचालित रूप से तेज़ या धीमा करती है कि " +
        "अभी कितने प्रॉक्सी लाइव हैं।\n\n" +
        "• कम लाइव (\"कम\" थ्रेशोल्ड से नीचे) → अंतराल × \"तेज़ी\"। 1 से कम गुणक = अधिक " +
        "बार: 0.5 — दोगुनी बार, 0.25 — 4×। पूल को तेज़ी से भरता है।\n" +
        "• अधिक लाइव (\"अधिक\" थ्रेशोल्ड से ऊपर) → अंतराल × \"धीमापन\"। 1 से ऊपर = कम बार: 2 — " +
        "आधी बार, 4 — एक चौथाई। बैटरी और ट्रैफ़िक बचाता है।\n" +
        "• थ्रेशोल्ड के बीच — आधार गति (×1)।\n\n" +
        "उदाहरण:\n" +
        "— प्रॉक्सी तेज़ी से एकत्र करें: \"तेज़ी\" 0.25 और/या \"कम\" थ्रेशोल्ड 40।\n" +
        "— पर्याप्त होने पर बैटरी बचाएँ: \"धीमापन\" 8 और/या \"अधिक\" थ्रेशोल्ड 30।\n" +
        "— अनुकूलन अक्षम करें: दोनों गुणक 1 पर सेट करें।\n\n" +
        "डिफ़ॉल्ट: कम 20, तेज़ी 0.5, अधिक 50, धीमापन 4।"
    override val threshMany = "\"अधिक\" थ्रेशोल्ड"; override val threshFew = "\"कम\" थ्रेशोल्ड"; override val mulFast = "तेज़ी ×"; override val mulLazy = "धीमापन ×"
    override val subIntensityTitle = "सब्सक्रिप्शन तीव्रता"
    override val subIntensityHint = "सब्सक्रिप्शन डाउनलोड के बीच विराम: प्रॉक्सी सूचियाँ फिर से डाउनलोड करने से पहले कितने मिनट (प्रत्येक नेटवर्क मोड के लिए अलग)।"
    override val baseScanTitle = "आधार स्कैन गति"
    override val baseScanHelp = "संदर्भ जीवंतता-जाँच गति। «अनुकूली गति» और «मोड के अनुसार गति» " +
        "गुणक इसके सापेक्ष परिकलित होते हैं।\n\n" +
        "• कितनी बार चलाएँ, मिनट — जाँच पास के बीच अंतराल।\n" +
        "• प्रति थ्रेड बैच, होस्ट — प्रत्येक थ्रेड प्रति पास कितने होस्ट जाँचता है।\n" +
        "• थ्रेड — एक साथ कितनी जाँचें चलती हैं। एक पास «बैच × थ्रेड» होस्ट प्रोब करता है।\n" +
        "• किसी होस्ट को हर N मिनट से अधिक बार री-स्कैन न करें — एंटी-फ़्लड: हाल ही में जाँचा गया होस्ट " +
        "इस पास में छोड़ दिया जाता है।\n\n" +
        "अधिक थ्रेड और बड़ा बैच = तेज़ पूल वृद्धि, पर नेटवर्क और बैटरी पर अधिक भार।"
    override val baseScanPeriod = "कितनी बार चलाएँ, मिनट"
    override val baseScanBatch = "प्रति थ्रेड बैच, होस्ट"; override val baseScanThreads = "थ्रेड गिनती"
    override val adaptiveDesc = "यदि लाइव प्रॉक्सी «कम» से कम या «अधिक» से अधिक हैं, तो एक अतिरिक्त गुणक लागू करें।"
    override val fewWord = "कम"; override val manyWord = "अधिक"
    override fun fasterX(x: String) = "$x× तेज़"
    override fun slowerX(x: String) = "$x× धीमा"
    override fun ifAliveLt(n: Int) = "यदि लाइव प्रॉक्सी < $n, तो:"
    override fun ifAliveGt(n: Int) = "यदि लाइव प्रॉक्सी > $n, तो:"
    override val disabledWord = "बंद"
    override val speedByModeTitle = "मोड के अनुसार गति"
    override val speedByModeHelp = "प्रत्येक नेटवर्क मोड के लिए एक स्कैन-गति गुणक, आधार " +
        "गति के ऊपर। «मानक» (×1) = आधार अंतराल। दाएँ — कम बार (धीमा, ट्रैफ़िक/" +
        "बैटरी पर नरम), बाएँ — अधिक बार (तेज़, अधिक आक्रामक)। लॉगरिदमिक स्केल, प्रत्येक दिशा में ×100 " +
        "तक।\n\n" +
        "प्रत्येक स्लाइडर के नीचे अनुकूली गति लागू होने के साथ परिणामी पास पैरामीटर हैं — " +
        "«कम लाइव» (× «तेज़ी») और «अधिक लाइव» (× «धीमापन») के लिए अलग-अलग दिखाए गए।\n\n" +
        "मोड:\n• VPN — एक बाहरी VPN सक्रिय है।\n• LTE — मोबाइल नेटवर्क।\n• Wi-Fi — Wi-Fi नेटवर्क।\n" +
        "• Ethernet — वायर्ड कनेक्शन।\n• White — मैन्युअल «व्हाइट» प्रॉक्सी मोड।"
    override val aliveLt = "लाइव <"; override val aliveGt = "लाइव >"
    override val periodWord = "अवधि"; override val nonstopWord = "नॉनस्टॉप"
    override val batchWord = "बैच"; override val threadsWord = "थ्रेड"; override val scanModeOff = "स्कैन बंद"
    override val netBattery = "नेटवर्क और बैटरी"
    override val netBatteryHelp = "• केवल Wi-Fi — मोबाइल नेटवर्क पर स्कैन न करें (डेटा बचाता है)।\n• केवल चार्जिंग " +
        "के समय — केवल फ़ोन चार्ज होते समय काम करें।\n• कम बैटरी पर छोड़ें — बैटरी कम होने पर स्कैनिंग रोकें।"
    override val onlyWifi = "केवल Wi-Fi"; override val onlyCharging = "केवल चार्जिंग के समय"; override val skipLowBattery = "कम बैटरी पर छोड़ें"
    override val autosaved = "सेटिंग्स स्वचालित रूप से सहेजी जाती हैं।"
    override val dpiAutoLabel = "DPI तरकीबें ऑटो-रोटेट"; override val dpiNoneLabel = "कोई DPI तरकीब नहीं (सादा)"
    override val experimental = "प्रयोगात्मक"
    override val experimentalHelp = "MTProto अपस्ट्रीम के विकल्प प्रॉक्सी इंजन और एक डायग्नोस्टिक लॉग। " +
        "«बंद» पर सेट होने पर संदर्भ (कार्यशील) पथ अपरिवर्तित रहता है। केवल यह बदलता है कि एन्क्रिप्टेड स्ट्रीम " +
        "अपस्ट्रीम TCP सॉकेट पर कैसे लिखी जाती है (खंड आकार, समय, TLS-रिकॉर्ड सीमाएँ) — स्ट्रीम स्वयं बाइट-दर-बाइट समान रहती है। " +
        "केवल लाइव प्रॉक्सी रिले पर लागू (प्रोब नहीं, डायरेक्ट पथ नहीं)।"
    override val expEngineTitle = "प्रॉक्सी इंजन (सॉकेट ऑब्फ़सकेशन)"
    override val expConnectTitle = "कनेक्ट इंजन (अपस्ट्रीम चयन)"
    override val raceWidthTitle = "समानांतर कनेक्ट"
    override val connectionSection = "कनेक्शन और ब्लॉक बायपास"
    override val connectionSectionHelp = "कनेक्ट इंजन, समानांतर अपस्ट्रीम, प्रॉक्सी इंजन और एंटी-DPI तरकीबें — सब एक खंड में।"
    override val netLogSection = "नेटवर्क विनिमय लॉग"
    override val expEngineWarn = "⚠ प्रयोगात्मक मोड। यदि कनेक्टिविटी बिगड़ती है, तो «बंद (संदर्भ पथ)» पर वापस स्विच करें।"
    override val netLog = "नेटवर्क-विनिमय लॉग चालू करें"
    override val netLogSub = "किसको-किससे-कब और पैकेट आकार एक फ़ाइल में लिखता है (कोई पेलोड डेटा नहीं) — " +
        "VPN के साथ बनाम बिना विनिमय पैटर्न की तुलना के लिए।"
    override val openLogFolder = "लॉग फ़ोल्डर खोलें"; override val copyPath = "पथ कॉपी करें"
    override val helpShow = "मदद"; override val helpHide = "मदद छिपाएँ"
    override val quickSwitchIntro = "यहाँ आप एक ब्लॉक-बायपास तरकीब चुन सकते हैं। यदि टेलीग्राम त्रुटि दिखाता है " +
        "“The proxy you are using is not configured correctly and will be disabled. Please find another " +
        "one”, तो यह आज़माएँ कि कौन सा ट्रैफ़िक-ऑब्फ़सकेशन प्रकार काम करता है ताकि टेलीग्राम इसे दिखाना बंद करे। " +
        "split* मोड से शुरू करें। coalesce* मोड भी काम करते हैं, पर इनसे टेलीग्राम में चित्र/वीडियो ठीक से लोड नहीं होते।"
    override val quickSwitchTitle ="ब्लॉक बायपास"; override val quickSwitchSub = "शेपिंग, कनेक्ट, एंटी-DPI"

    override val sourceUrl = "स्रोत URL"
    override fun sourceAlive(alive: Int, total: Int) = "लाइव $alive/$total"
    override val open = "खोलें"; override val active = "सक्रिय"; override val inactive = "निष्क्रिय"
    override val lastDownloaded = "डाउनलोड किया गया"; override val notDownloaded = "अभी डाउनलोड नहीं किया"
    override fun sourceCounts(dead: Int, total: Int) =
        " लाइव, $dead मृत, $total कुल"

    override val proxyBase = "प्रॉक्सी डेटाबेस"
    override val totalInBase = "डेटाबेस में कुल"; override val aliveNow = "अभी लाइव"; override val deadStat = "मृत"
    override val aliveIn15 = "15 मिनट में लाइव"; override val checksAllTime = "अब तक की जाँचें"
    override val antiDpiTricks = "एंटी-DPI तरकीबें"; override val noStatsYet = "अभी कोई डेटा नहीं — जाँच/कनेक्शन होने पर तरकीबें जमा होती हैं"
    override val attempts = "प्रयास"; override val handshake = "हैंडशेक"; override val score = "स्कोर"
    override val tgConnect = "TG कनेक्ट"; override val socketsOver1m = "सॉकेट >1मिनट"
    override val over10kb = "सॉकेट >10KB"; override val over100kb = ">100KB"; override val workTime = "कार्य समय"
    override val statsLegend = "हैंडशेक — सफल हैंडशेक (प्रयासों का %) · स्कोर — मान · " +
        "\"कार्य समय\" — सॉकेट ≥5KB और 1 मिनट से लंबे पर कुल।"
    override val resetStats = "तरकीब आँकड़े रीसेट करें"

    override fun aliveLinks(n: Int) = "लाइव लिंक: $n"
    override val copyAll = "सभी कॉपी करें"
    override val openRandom = "यादृच्छिक खोलें"; override val copyRandom = "यादृच्छिक कॉपी करें"; override val allShort = "सभी"
    override val copyTop = "TOP कॉपी करें"; override val randomHost = "यादृच्छिक होस्ट"
    override val exportToFile = "फ़ाइल में एक्सपोर्ट करें"; override val exportSaved = "फ़ाइल में सहेजा गया:"
    override val dlNow = "अभी डाउनलोड करें"
    override fun downloadingFmt(sec: Long) = "डाउनलोड हो रहा है… ${sec}से"
    override val cancel = "रद्द करें"
    override val deleteConfirmTitle = "सब्सक्रिप्शन हटाएँ?"
    override val subscriptionsAddHint = "सब्सक्रिप्शन या प्रॉक्सी लिंक जोड़ें →"
    override val addSourcesTitle = "जोड़ें"
    override val addSubsLabel = "सब्सक्रिप्शन (प्रति पंक्ति एक URL)"
    override val addSubsHelp = "एक वैध URL वाली प्रत्येक पंक्ति अपना सब्सक्रिप्शन बनती है और समय-समय पर लाई जाती है।"
    override val addProxiesLabel = "तैयार प्रॉक्सी लिंक (स्थिर सूची)"
    override val addProxiesHelp = "विशिष्ट प्रॉक्सी के लिंकों का एक बैच पेस्ट करें (tg://proxy, https://t.me/proxy, …)। यह सब्सक्रिप्शन नहीं है — सूची कभी डाउनलोड नहीं की जाती, प्रॉक्सी बस कैटलॉग में जोड़े जाते हैं।"
    override val addButton = "जोड़ें"
    override fun addedFmt(subs: Int, proxies: Int) = "जोड़े गए: $subs सब्सक्रिप्शन, $proxies प्रॉक्सी"
    override val perSecond = "प्रति सेकंड"
    override val graphSpeed = "गति"
    override val graphVolume = "वॉल्यूम"
    override val graphLatency = "पिंग"
    override val graphConnects = "कनेक्ट"
    override val scanNow = "अभी स्कैन करें"; override val scanOnShort = "स्कैन चालू"
    override val scanRunning = "स्कैन चल रहा है"; override val scanIdle = "स्कैन निष्क्रिय"; override val scanOffState = "स्कैन बंद"; override val scanBatchPerThread = "बैच/थ्रेड"; override val scanPassHosts = "पास में होस्ट"; override val minRescanLabel = "किसी होस्ट को हर N मिनट से अधिक बार री-स्कैन न करें"
    override val scanPlanTitle = "योजना"; override val scanNowTitle = "अभी"; override val currentScheduleTitle = "वर्तमान शेड्यूल"
    override val scheduleWord = "शेड्यूल"; override val unitPcsPerSec = "नग/से"
    override val scanNowThreadsLabel = "अभी चल रहे थ्रेड"; override val scanNowPerThreadLabel = "प्रति थ्रेड जाँच (योजना)"; override val scanNowElapsedLabel = "चलने का समय"
    override val scanOkGraph = "सफल स्कैन"; override val scanFailGraph = "विफल स्कैन"; override val scanTrafficGraph = "स्कैन ट्रैफ़िक"; override val scanAliveGraph = "कुल लाइव प्रॉक्सी"; override val scanPingGraph = "पिंग"; override val threadsGraph = "थ्रेड"
    override val scanEvery = "हर"; override val scanNextRun = "अगला रन"
    override val scanThreads = "थ्रेड"; override val scanBatch = "बैच"
    override val scanElapsed = "चल रहा है"; override val scanIdleNow = "—"
    override val effForFew = "जब कम हों"; override val effForMany = "जब अधिक हों"
    override val effCheck = "जाँच"; override val effBatch = "बैच"; override val effPar = "समानांतर"
    override val effContinuous = "निरंतर"; override val secShort = "से"; override val minShort = "मिनट"

    override val appTagline = "क्रॉस-प्लेटफ़ॉर्म ऑटो-कनेक्टर: यह MTProto प्रॉक्सी ढूँढ़ता, जाँचता और चलाता है " +
        "जिनके ज़रिए टेलीग्राम काम करता है।"
    override val version = "संस्करण"; override val buildDate = "बिल्ड तिथि"; override val platform = "प्लेटफ़ॉर्म"
    override val downloadSources = "डाउनलोड और स्रोत"; override val openOnGithub = "GitHub पर खोलें"
    override val feedbackBugs = "फ़ीडबैक और बग रिपोर्ट"; override val writeTelegram = "टेलीग्राम पर लिखें"

    override val language = "भाषा"; override val langAuto = "स्वचालित (सिस्टम)"; override val langRu = "Русский"; override val langEn = "English"
    override val langFa = "فارسی"; override val langZh = "简体中文"; override val langAr = "العربية"; override val langUr = "اردو"
    override val langTr = "Türkçe"; override val langId = "Bahasa Indonesia"; override val langHi = "हिन्दी"; override val langBn = "বাংলা"; override val langMy = "မြန်မာ"
    override val langWord = "भाषा"

    override val scanModeTitle = "नेटवर्क मोड"; override val scanModeAuto = "ऑटो"; override val scanModeManualLabel = "मैन्युअल"
    override val activeModeLabel = "सक्रिय मोड"; override val formingListLabel = "सूची बन रही है"; override val catalogModeTabs = "मोड"
    override val resetModeRatings = "होस्ट रेटिंग रीसेट करें"; override val forgetModeHosts = "मोड होस्ट भूलें"
    override val exportModeTitle = "मोड के अनुसार एक्सपोर्ट"; override val modePickerTitle = "मोड"
    override val modeHelp = "प्रत्येक नेटवर्क मोड अपनी प्रॉक्सी रेटिंग और अपनी स्कैन + सब्सक्रिप्शन-डाउनलोड तीव्रता रखता है। «ऑटो» सक्रिय नेटवर्क से मोड चुनता है। «मैन्युअल» आपको कोई भी मोड स्वयं चुनने देता है (White सहित, जिसे ऑटो कभी नहीं चुनता)।"
    override val autoSelect = "ऑटो चयन"; override val manualSelect = "मैन्युअल चयन"
    override val connStatsTitle = "अभी कनेक्शन"; override val connOnPort = "पोर्ट पर कनेक्शन"; override val outgoingConns = "आउटगोइंग कनेक्शन"
    override val modeChoice = "मोड चयन"; override val autoChoice = "ऑटो-चयन"; override val manualChoice = "मैन्युअल स्थिर"
    override val directOnVpn = "VPN पर TG से डायरेक्ट कनेक्ट"; override val onWord = "चालू"; override val offWord = "बंद"
    override val directStateActive = "सक्रिय"; override val directStateOff = "सेटिंग्स में बंद"; override val directStateIdle = "सेटिंग्स में चालू, पर सक्रिय नहीं"
    override val wpHintTitle = "White क्या है?"
    override val wpHint = "White — WhitePages: एक मैन्युअल नेटवर्क प्रोफ़ाइल। केवल हाथ से चालू (ऑटो-चयन इसे कभी नहीं चुनता)। " +
        "अपनी होस्ट रेटिंग रखता है, सब्सक्रिप्शन डाउनलोड करता है और VPN/Wi-Fi/LTE से स्वतंत्र रूप से स्कैन करता है।"

    override val recentAttempts = "हाल के कनेक्ट और जाँच"
    override val kindCheck = "जाँच"
    override val kindTg = "टेलीग्राम"
    override val histWho = "कौन"
    override val histWhen = "कब"
    override val histReq = "अनुरोध"
    override val histSess = "सेशन"
    override val histScan = "स्कैन"
    override val testNow = "अभी परीक्षण करें"
    override val testShort = "परीक्षण"
    override val testResult = "परीक्षण परिणाम"
    override val testStop = "रोकें"
    override val testingNow = "परीक्षण हो रहा है…"
    override val prewarmTitle = "सॉकेट प्री-वार्म (प्रयोगात्मक)"
    override val prewarmHelp = "कुछ अपस्ट्रीम प्रॉक्सी सॉकेट पहले से जुड़े रखें ताकि नया टेलीग्राम " +
        "कनेक्शन कनेक्ट/हैंडशेक छोड़ सके। प्रयोगात्मक: यह बैकग्राउंड में लगातार फिर से जुड़ता रहता है, " +
        "इसलिए ट्रैफ़िक और थोड़ा CPU खर्च होता है। कोई फ़र्ज़ी ट्रैफ़िक नहीं भेजा जाता (वह वास्तविक सेशन " +
        "को खराब कर देता) — सॉकेट बस घुमाए जाते हैं। FakeTLS प्रॉक्सी के साथ सबसे उपयोगी।"
    override val prewarmEnable = "प्री-वार्म चालू करें"
    override val prewarmModeDeferred = "स्थगित (केवल TLS)"
    override val prewarmModeDeferredSub = "TCP + FakeTLS बनाए रखें; हैंड-ऑफ़ पर init पूरा करें। कोई DC कमिट नहीं — सबसे यथार्थवादी।"
    override val prewarmModeFull = "पूर्ण हैंडशेक"
    override val prewarmModeFullSub = "विभिन्न DC पर पूरी तरह जुड़े सॉकेट बनाए रखें; केवल DC/tag मेल खाने पर पुनः उपयोग। कम जीवनकाल।"
    override val prewarmPoolLabel = "स्टैंडबाय सॉकेट"
    override val prewarmHoldLabel = "प्रत्येक रखें, से"
    override val prewarmNote = "केवल रोटेशन (ऐप-स्तर पर कोई keepalive नहीं)। सॉकेट प्रॉक्सी/DC के अनुसार कुछ सेकंड से ~एक मिनट तक जीवित रहता है।"
    override val prewarmStatus = "प्री-वार्म"
    override fun prewarmStatusVal(ready: Int, holdSecs: Int) = "${ready} तैयार · ${holdSecs}से रखे"
    override val prewarmStar = "गाढ़ा नारंगी = सॉकेट प्री-वार्म पूल से गर्म दिया गया (कनेक्ट/हैंडशेक छोड़ा गया)"
    override fun prewarmTableTitle(holdSecs: Int) = "सॉकेट प्री-वार्म (${holdSecs}से रखे)"
    override val prewarmTableHelp = "\"सॉकेट प्री-वार्म\" पहले से कुछ प्रॉक्सी सॉकेट खोलता है ताकि नया " +
        "टेलीग्राम कनेक्शन कनेक्ट/हैंडशेक छोड़ सके। यह तालिका वार्म किए जा रहे सॉकेट दिखाती है: प्रत्येक " +
        "कितने समय जीवित रहा, क्या टेलीग्राम इसका उपयोग कर रहा है, और ट्रैफ़िक। इसे «और → सेटिंग्स → " +
        "\"सॉकेट प्री-वार्म (प्रयोगात्मक)\"» में चालू/बंद और कॉन्फ़िगर (मोड, सॉकेट संख्या, होल्ड समय) करें।"
    override val prewarmNoneWarming = "अभी कोई सॉकेट वार्म नहीं हो रहा"
    override val prewarmColAge = "आयु"
    override val prewarmColUse = "TG में?"
    override val prewarmInUse = "TG में"
    override val prewarmNew = "नया"
    override val lanShareTitle = "लोकल नेटवर्क पर साझा करें (वेब पोर्टल)"
    override val lanShareDesc = "इस Wi-Fi पर अन्य डिवाइसों को इस AutoConnector को प्रॉक्सी के रूप में उपयोग करने दें; नीचे दिए पते को खोलने वाला ब्राउज़र सर्वश्रेष्ठ प्रॉक्सी का पृष्ठ पाएगा।"
    override val lanShareUrlsLabel = "नेटवर्क पड़ोसी यहाँ जुड़ें:"
    override val lanShareNoIp = "लोकल नेटवर्क पता नहीं — Wi-Fi से जुड़ें"
    override val lanFirewallTitle = "लोकल नेटवर्क पर अनुमति दें"
    override val lanFirewallBody = "इसे चालू करने से रिले पोर्ट आपके लोकल नेटवर्क पर खुल जाते हैं। अब Windows (या अन्य) फ़ायरवॉल पूछ सकता है कि AutoConnector को अनुमति दें या नहीं — \"अनुमति दें\"/\"हाँ\" चुनें। यदि आप मना करते हैं, तो AutoConnector तक पड़ोसियों का ट्रैफ़िक ब्लॉक हो जाएगा और पृष्ठ/प्रॉक्सी पहुँच में नहीं होगा।"
    override val lanFirewallConfirm = "चालू करें"
    override val lanInfoTitle = "यह किसलिए है?"
    override val lanInfoBody = "अपने Wi-Fi पर एक ही कंप्यूटर या फ़ोन पर AutoConnector चलाएँ, और उसी नेटवर्क पर हर दूसरा डिवाइस — iPhone सहित, जिसे यह ऐप सीधे समर्थन नहीं करता — बस ब्राउज़र में पता खोलकर इसका उपयोग कर सकता है: अपने टेलीग्राम में जोड़ने के लिए सर्वश्रेष्ठ प्रॉक्सी का पृष्ठ, या यह डिवाइस स्वयं एक SOCKS प्रॉक्सी के रूप में। एक डिवाइस प्रॉक्सी ढूँढ़ता और बनाए रखता है; बाकी इसे लोकल नेटवर्क पर उधार लेते हैं।"
    override val volTriggerTitle = "वॉल्यूम-बटन ट्रिगर"
    override val volTriggerSub = "तेज़ वॉल्यूम-कुंजी पैटर्न से प्रॉक्सी बदलें"
    override val volEnableLabel = "वॉल्यूम बटन देखें"
    override val volHelpTitle = "यह क्या है?"
    override val volHelpBody = "Android पर कोई ग्लोबल कीबोर्ड हॉटकी नहीं होती, इसलिए यह वॉल्यूम बटन का उपयोग करता है। चालू होने पर, AutoConnector बैकग्राउंड में वॉल्यूम-अप/डाउन दबाने के तेज़ पैटर्न (जैसे ऊपर-ऊपर-नीचे-नीचे) पर नज़र रखता है। पहचानने पर, यह किसी यादृच्छिक अच्छे, लाइव प्रॉक्सी का tg:// लिंक खोलता है ताकि टेलीग्राम इसे ग्रहण कर स्विच कर ले — ऐप खोले बिना प्रॉक्सी घुमाने का तेज़, विवेकपूर्ण तरीका। वॉल्यूम सामान्य रूप से काम करता रहता है (दबाव निगले नहीं जाते)। इसके लिए Accessibility पहुँच आवश्यक है (बैकग्राउंड में वॉल्यूम कुंजियाँ पढ़ने और लिंक खोलने के लिए); टॉगल चालू करने तक कुछ भी नहीं माँगा जाता। नीचे दबावों के बीच अधिकतम समय सेट करें; पहचाने जाने वाले पैटर्न सबसे नीचे सूचीबद्ध हैं।"
    override val volGrantTitle = "Accessibility चालू करें (महत्वपूर्ण)"
    override val volGrantBody = "Android (विशेषकर 13+) उन ऐप्स के लिए Accessibility ब्लॉक करता है जो Google Play से इंस्टॉल नहीं किए गए — इसीलिए AutoConnector धूसर है और \"प्रतिबंधित सेटिंग\" / \"पहुँच की अनुमति नहीं\" दिखाता है।\n\nअनब्लॉक कैसे करें:\n1. \"App info\" खोलें (नीचे बटन, या सेटिंग्स → ऐप्स → AutoConnector for Telegram)।\n2. ⋮ मेनू (ऊपर-दाएँ) पर टैप करें → \"प्रतिबंधित सेटिंग्स की अनुमति दें\" → पुष्टि करें।\n3. वापस जाएँ: सेटिंग्स → Accessibility → AutoConnector for Telegram → इसे चालू करें।\n\nयदि \"प्रतिबंधित सेटिंग्स की अनुमति दें\" न दिखे, तो पहले एक बार Accessibility में इसे चालू करने का प्रयास करें (आपको ब्लॉक संदेश मिलेगा), फिर चरण 2 दिखता है।\n\nXiaomi/MIUI, Samsung आदि पर रास्ता थोड़ा भिन्न हो सकता है — \"App info\" में वही ⋮ ढूँढ़ें। Android 12 और पुराने पर आमतौर पर कोई प्रतिबंध नहीं होता — बस इसे Accessibility में चालू करें।\n\nवॉल्यूम कुंजियाँ केवल देखी जाती हैं, कभी ब्लॉक नहीं की जातीं।"
    override val volOpenAppInfo = "\"App info\" खोलें"
    override val volAccessOn = "Accessibility: दी गई"
    override val volAccessOff = "Accessibility: नहीं दी गई"
    override val volOpenAccess = "Accessibility सेटिंग्स खोलें"
    override val volGapLabel = "दबावों के बीच अधिकतम ms"
    override val volPatternsTitle = "पहचाने जाने वाले पैटर्न"
    override val volPatternPick = "पैटर्न"
    override val volPatternsLegend = "↑ = वॉल्यूम ऊपर, ↓ = वॉल्यूम नीचे"
    override val volNoRights = "ऐप के पास वॉल्यूम बटन संभालने की अनुमति अभी नहीं है — इस पृष्ठ के नीचे दिए चरणों का उपयोग कर पहुँच दें।"
    override val volGrantShort = "अभी कोई Accessibility पहुँच नहीं। इस पृष्ठ के नीचे विस्तृत चरण पढ़ें, फिर \"जाँचें\" पर टैप करें।"
    override val volCheck = "जाँचें"
    override val volCheckOk = "✓ हो गया — पहुँच दी गई, ट्रिगर काम करता है।"
    override val volCheckFail = "✗ अभी भी पहुँच नहीं — ऊपर के चरण पूरे करें।"
    override val volPatternsList = "↑↑↓↓ · ↓↓↑↑ · ↑↓↑↓ · ↓↑↓↑ · ↑↑↑↑ · ↓↓↓↓ · ↑↓↓↑ · ↓↑↑↓ · ↑↑↑↓↓↓ · ↓↓↓↑↑↑   (↑ = वॉल्यूम ऊपर, ↓ = नीचे)"
    override val histLegend = "कॉलम — कौन: ✓/✗ TG = वास्तविक टेलीग्राम कनेक्ट, स्कैन = बैकग्राउंड जाँच। कब: कितने समय पहले। TCP/TLS/अनुरोध: हैंडशेक और पहले अनुरोध की लेटेंसी, ms। सेशन: रिले सेशन कितने समय चला। ↓/↑: होस्ट से होकर प्राप्त / भेजे बाइट।"
    override val tgOkTotalHint = "टेलीग्राम कनेक्ट / सफल / कुल जाँच"
    override val breadthTitle = "होस्ट चयन विस्तार"
    override val breadthHelp = "बाएँ = सर्वश्रेष्ठ सिद्ध होस्ट पर टिके रहें; दाएँ = सभी लाइव होस्ट में यथासंभव व्यापक रूप से आज़माएँ। जब टेलीग्राम रिले पोर्ट बदलता रहता है, तो ऐप स्वतः खोज विस्तृत कर देता है।"
    override val breadthNarrow = "सिद्ध"
    override val breadthWide = "व्यापकतम"
    override val connTimeoutTitle = "प्रति-होस्ट कनेक्ट टाइमआउट"
    override val connTimeoutHelp = "अगले प्रॉक्सी पर जाने से पहले एक अपस्ट्रीम (TCP + TLS + पहला MTProto उत्तर) के लिए कितनी देर प्रतीक्षा करें।"
    override val backupExportTitle = "डेटा एक्सपोर्ट"
    override val backupImportTitle = "डेटा इम्पोर्ट"
    override val backupSelectExport = "क्या एक्सपोर्ट करें:"
    override val backupSelectImport = "क्या इम्पोर्ट करें:"
    override val backupCopyBtn = "कॉपी करें"
    override val backupSaveFile = "फ़ाइल में सहेजें"
    override val backupLoadFile = "फ़ाइल से लोड करें"
    override val backupDoImport = "इम्पोर्ट"
    override val backupPasteLabel = "बैकअप JSON यहाँ पेस्ट करें"
    override val backupJsonLabel = "बैकअप JSON"
    override val backupAndroidFileNote = "यहाँ फ़ाइलें उपलब्ध नहीं — कॉपी / पेस्ट का उपयोग करें।"
    override val factoryResetDone = "सब कुछ रीसेट हो गया। कृपया ऐप बंद करें और फिर से खोलें।"

    // tray
    override val trayOpenWindow = "विंडो खोलें"
    override val trayRefreshSubs = "सब्सक्रिप्शन रिफ्रेश करें"
    override val trayExit = "बाहर निकलें"
    override fun trayConnectorLabel(on: Boolean) =
        if (on) "कनेक्टर: चालू (बंद करें)" else "कनेक्टर: बंद (चालू करें)"
    override fun trayScanLabel(on: Boolean) =
        if (on) "स्कैन: चालू (बंद करें)" else "स्कैन: बंद (चालू करें)"
    override fun trayLive(n: Int) = "लाइव प्रॉक्सी: ${n}"
    override val appearance = "रूप"
    override val themeLabel = "थीम"
    override val themeAuto = "स्वतः (सिस्टम के अनुसार)"
    override val themeLight = "हल्का"
    override val themeDark = "गहरा"
    override val drawGraphsLabel = "ग्राफ़ बनाएं"
    override val drawGraphsSub = "Connector और Scan टैब पर लाइव चार्ट — बैटरी बचाने के लिए बंद करें"
}
