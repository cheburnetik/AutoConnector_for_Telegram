package io.autoconnector.i18n

object Mr : Strings {
    override val tabConnector = "कनेक्टर"; override val tabScan = "स्कॅन"
    override val tabCatalog = "कॅटलॉग"; override val tabLogs = "लॉग"; override val tabMore = "अधिक"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "सबस्क्रिप्शन"; override val logTabScan = "स्कॅन"
    override val logGeneral = "सामान्य"; override val logEmpty = "सध्या रिकामे"
    override val logSessions = "सेशन"; override val logErrorsOnly = "फक्त त्रुटी"; override val logNoErrors = "कोणतेही अयशस्वी सेशन नाहीत"
    override fun logSession(id: String, port: String) = "#${id} · :${port}"
    override val back = "मागे"; override val copy = "कॉपी"; override val gotIt = "समजले"
    override val later = "नंतर"; override val details = "तपशील"; override val whatIsThis = "हे काय आहे?"
    override val delete = "हटवा"

    override val connector = "कनेक्टर"; override val scan = "स्कॅन"
    override val notConfigured = "सेट अप केलेले नाही! दुरुस्त करा →"; override val howToSetup = "सेट अप कसे करावे"
    override val notifOff = "सूचना बंद आहेत! दुरुस्त करा →"; override val enable = "सक्षम करा"
    override fun fewProxies(n: Int) = "जिवंत प्रॉक्सी ${n}, शोधत आहे, ~15 मिनिटे थांबा…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "जिवंत प्रॉक्सी: ${alive}  (15 मिनिटे: ${within}) · एकूण: ${total}"
    override val notifWhyTitle = "सूचना का?"
    override val notifWhyBody = "सतत दिसणारी सूचना आयकॉन म्हणजे Android फोरग्राउंड सेवा. " +
        "त्याशिवाय सिस्टीम अॅप मेमरीमधून काढून टाकते आणि ते प्रॉक्सी शोधणे आणि " +
        "पार्श्वभूमीत कनेक्शन धरून ठेवणे थांबवते. म्हणूनच AutoConnector काम करण्यासाठी " +
        "सूचना आवश्यक आहेत."
    override val notifEnableTitle = "सूचना सक्षम करा"
    override val notifEnableBody = "सूचना आयकॉनशिवाय Android अॅपला निष्क्रिय मानते आणि " +
        "ते मेमरीमधून काढून टाकते. मग AutoConnector प्रॉक्सी शोधणे आणि पार्श्वभूमीत " +
        "कनेक्शन धरून ठेवणे थांबवते — Telegram चा संपर्क तुटतो.\n\n\"सक्षम करा\" वर टॅप करा आणि " +
        "AutoConnector साठी सूचनांना परवानगी द्या."
    override val notifPlea = "सूचना सक्षम करा! त्यांच्याशिवाय अॅप पार्श्वभूमीत चालू शकत नाही — " +
        "Android ते काढून टाकेल आणि प्रॉक्सी शोध व कनेक्शन थांबेल."

    override val statusConnected = "Telegram जोडले गेले"; override val statusConnecting = "जोडत आहे…"
    override val statusOffline = "Telegram जोडलेले नाही"; override val statusIdle = "Telegram निष्क्रिय"
    override val nobodyConnected = "कोणीही कनेक्टरशी जोडलेले नाही. "; override val howToSetupArrow = "सेट अप कसे करावे →"
    override val directModeViaVpn = "थेट मोड: VPN सक्रिय — प्रॉक्सी नाही"
    override val directModeOff = "थेट मोड: प्रॉक्सी बंद"
    override val directDpiSuffix = " · अँटी-DPI"
    override val connections = "कनेक्शन"; override val sockets = "सॉकेट"; override val speed = "वेग"
    override val traffic = "ट्रॅफिक"; override val latency = "लेटन्सी"
    override fun pcs(n: Int) = "${n} नग"
    override fun netNow(label: String) = "नेटवर्क: ${label}"
    override fun tgToConnector(n: Int) = "TG→ ${n}"
    override fun connectorToProxy(n: Int) = "प्रॉक्सी ${n}"
    override val trafficSec = "ट्रॅफिक · 60 सेकंद"; override val trafficMin = "ट्रॅफिक · 60 मिनिटे"
    override val latencySec = "लेटन्सी · 60 सेकंद"; override val latencyMin = "लेटन्सी · 60 मिनिटे"
    override val sec60 = "60 सेकंद"; override val min60 = "60 मिनिटे"
    override val unitSec = "से"; override val unitMin = "मि"; override val unitHour = "ता"; override val dash = "—"
    override val currentProxy = "सध्याची प्रॉक्सी"; override val noActiveProxy = "कोणतीही सक्रिय प्रॉक्सी नाही (Telegram जोडलेले नाही)"
    override val host = "होस्ट"; override val type = "प्रकार"; override val secret = "सीक्रेट"; override val antiDpi = "अँटी-DPI"; override val obfEngine = "ऑब्फस्केशन इंजिन"
    override fun activeSockets(n: Int) = "सक्रिय Telegram सॉकेट: ${n}"
    override val noConnections = "कोणतीही सक्रिय कनेक्शन नाहीत"; override val colHost = "होस्ट"; override val colTime = "वेळ"
    override val modeWord = "मोड"; override val directViaVpnLine = "Telegram ला थेट विनंत्या (VPN सक्रिय)"
    override val connModeHelp = "मोड (VPN, Wi-Fi, LTE, Ethernet, White) तुम्हाला स्कॅन तीव्रता वेगवेगळ्या प्रकारे जुळवू देतात आणि वेगळ्या होस्ट रेटिंग/आकडेवारी ठेवतात. नेटवर्क कार्ड आपोआप ओळखले जाते; मोड सेटिंग्जमध्ये स्वतः सेट करता येतो."

    override val scanOff = "स्कॅनिंग बंद आहे"; override val proxiesInBase = "डेटाबेसमधील प्रॉक्सी"
    override val total = "एकूण"; override val alive = "जिवंत"; override val dead = "मृत"
    override val tgConnectedTitle = "Telegram याद्वारे जोडले"; override val successful = "यशस्वी"
    override val socketsHeld = "सॉकेट आयुष्य"; override val over1m = ">1 मिनिट"; override val over5m = ">5 मिनिटे"; override val over15m = ">15 मिनिटे"
    override val scanCountTitle = "प्रॉक्सी तपासणी संख्या"; override val checked = "तपासले"
    override val forAllTime = "सर्व काळ"; override val perMinute = "प्रति मिनिट"; override val perHour = "प्रति तास"
    override val subsCountTitle = "सबस्क्रिप्शन डाउनलोड संख्या"; override val downloaded = "डाउनलोड केले"; override val failed = "अयशस्वी"; override val scanTraffic = "स्कॅन ट्रॅफिक"; override val subTraffic = "सबस्क्रिप्शन ट्रॅफिक"; override val subTrafficGraph = "सबस्क्रिप्शन ट्रॅफिक"
    override val checksMtproto = "MTProto तपासण्या (↑ ठीक · ↓ अयशस्वी)"

    override fun catalogEmpty(mode: String) = "कॅटलॉग ${mode} सध्या रिकामे आहे. एकतर कोणताही होस्ट सापडला नाही, किंवा अॅप या मोडमध्ये कधीच चालले नाही. तुम्ही सेटिंग्जमध्ये मोड बदलू शकता. वेगवेगळ्या प्रकारच्या इंटरनेट कनेक्शनसाठी होस्ट वेगळे गोळा करण्यासाठी मोड अस्तित्वात आहेत."
    override val aliveShort = "✓ जिवंत"; override val deadShort = "✗ मृत"
    override val statusLabel = "स्थिती"; override val rating = "रेटिंग"; override val port = "पोर्ट"
    override val rttPing = "RTT (पिंग)"; override val checkedField = "तपासले"; override val okOfTotal = "यशस्वी / एकूण तपासण्या"
    override val tgConnectedField = "Telegram जोडले"; override val tgSessions = "Telegram सेशन"; override val trafficThroughProxy = "प्रॉक्सीद्वारे ट्रॅफिक"
    override val sessionsTotal = "एकूण सेशन"; override val relayNow = "आता रिले"; override val tlsDomain = "TLS डोमेन (SNI)"
    override val sourceSub = "स्रोत (सबस्क्रिप्शन)"; override val lastError = "शेवटची त्रुटी"; override val yes = "होय"; override val no = "नाही"
    override val copyAsLink = "लिंक म्हणून कॉपी करा"; override val openInTelegram = "होस्ट Telegram मध्ये उघडा"; override val makeNextRelay = "पुढील रिले करा"
    override val actCopy = "कॉपी"; override val actOpen = "उघडा"; override val actRelay = "रिले"
    override fun agoFmt(v: String) = "${v} पूर्वी"
    override val catalogTopFor = "साठी प्रॉक्सी यादी/रेटिंग"
    override val catalogModeHelpTitle = "मोड आणि रेटिंग"
    override val catalogModeHelp = "अॅप जिवंत होस्ट आणि त्यांची रेटिंग प्रत्येक नेटवर्क मोडनुसार (VPN, Wi-Fi, LTE, Ethernet आणि White) वेगवेगळी मोजते. \"White\" हा व्हाइटलिस्टसाठी वेगळा मॅन्युअल मोड आहे; ऑटो त्यावर कधीच जात नाही. त्यामुळे एकच होस्ट एका मोडमध्ये जिवंत आणि दुसऱ्यात मृत असू शकतो."
    override fun catalogInactiveWarn(section: String, active: String) =
        "तुम्ही निष्क्रिय विभाग ${section} पाहत आहात — सर्व आकडेवारी सध्या ${active} कडे जाते, इथे नाही."
    override val manageModeTitle = "मोड व्यवस्थापित करा"
    override val manageResetRating = "रेटिंग रीसेट करा"
    override fun manageResetHint(mode: String) = "खास ${mode} साठी तुम्ही जिवंत होस्टची रेटिंग आणि वापर आकडेवारी रीसेट करू शकता. जेव्हा तुम्ही पूर्णपणे वेगळ्या VPN किंवा LTE शी जोडले असता तेव्हा हे उपयुक्त आहे, जेणेकरून जुनी आकडेवारी अडथळा आणू नये. किंवा प्रॉक्सी स्कॅन सर्व काही नव्याने किती लवकर पुन्हा तपासते हे पाहण्यासाठी."
    override val manageDeleteAll = "होस्ट हटवा यामध्ये"
    override fun manageDeleteHint(mode: String) = "तुम्ही ${mode} मधून रेटिंग आणि होस्ट दोन्ही साफ करू शकता. \"प्रॉक्सी स्कॅन करा\" वैशिष्ट्य ते पुन्हा गोळा करेल. हा सबस्क्रिप्शन रीसेट नाही — तुम्ही यावर टॅप करू शकता, मग पुन्हा स्कॅनसाठी ~15 मिनिटे थांबा."
    override fun manageCopyFrom(mode: String) = "दुसऱ्या मोडमधून सर्व होस्ट आणि रेटिंग या मोडमध्ये (${mode}) कॉपी करा:"
    override val live = "जिवंत"; override val deadW = "मृत"; override val unitMs = "ms"
    override val agoMin = "मि"; override val agoHour = "ता"; override val agoDay = "दि"

    override val connectTelegram = "Telegram जोडत आहे"; override val readCarefully = "काळजीपूर्वक वाचा!"
    override val guideIntro = "हे अॅप सेट अप केल्याशिवाय काम करणार नाही. खाली दिलेल्या 3 पर्यायांपैकी कोणताही एक निवडा " +
        "आणि सूचना काळजीपूर्वक पाळा."
    override val variant1 = "पर्याय #1 — बटणे"
    override val variant1Body = "\"प्रॉक्सी {A}\" वर टॅप करा — Telegram उघडेल, प्रॉक्सी जोडण्याची पुष्टी करा. या " +
        "स्क्रीनवर परत या आणि \"प्रॉक्सी {B}\" वर टॅप करा — दुसऱ्यांदा जोडण्याची पुष्टी करा.\n\nTelegram मधील इतर कोणत्याही " +
        "जुन्या प्रॉक्सी बंद करा. नेमक्या 2 प्रॉक्सी राहिल्या पाहिजेत — {A} आणि {B} पोर्टसह. " +
        "इतर कोणत्याही संचासह AutoConnector काम करणार नाही."
    override val variant2 = "पर्याय #2 — लिंक"
    override val variant2Body = "खालील मजकूर Telegram मधील Saved Messages (किंवा कोणत्याही चॅट) मध्ये कॉपी करा — " +
        "म्हणजे तो स्वतःला पाठवा. तुमच्या संदेशातील पहिल्या लिंकवर टॅप करा — पहिली प्रॉक्सी जोडली जाते. " +
        "दुसऱ्या लिंकवर टॅप करा — दुसरी जोडली जाते. मग सर्व जुन्या प्रॉक्सी बंद करा."
    override val variant3 = "पर्याय #3 — स्वतः"
    override val variant3Body = "स्वतः एक SOCKS5 प्रॉक्सी जोडा: सर्व्हर localhost (127.0.0.1), पोर्ट {A}. " +
        "मग दुसरी प्रॉक्सी: localhost, पोर्ट {B}. कोणत्याही जुन्या प्रॉक्सी हटवा."
    override val whatNext = "पुढे काय?"
    override val whatNextBody = "Telegram मध्ये \"प्रॉक्सी आपोआप बदला\" सक्षम करा — 5 सेकंद. तुम्ही " +
        "Telegram ला जोडण्यास मदत करू शकता — सक्रिय नसलेली किंवा \"अनुपलब्ध\" म्हणून चिन्हांकित नसलेली " +
        "प्रॉक्सी (Telegram च्या आत) स्वतः टॅप करून — यामुळे Telegram जोडण्यासाठी अधिक प्रयत्न करते.\n\n{A} आणि {B} वगळता इतर सर्व जुन्या " +
        "प्रॉक्सी काढल्या आहेत याची खात्री करा. Telegram मध्ये " +
        "\"प्रॉक्सी वापरा\" वर टॅप करा.\n\nअॅप पुरेशा प्रॉक्सी शोधून डाउनलोड करत असताना थांबा " +
        "(5–15 मिनिटे). मग Telegram स्वतःहून AutoConnector शी जोडले जाते, जे " +
        "Telegram ला सर्वोत्तम प्रॉक्सीद्वारे रूट करत राहते: सत्यापित, जिवंत आणि वेगवान.\n\nजर सूचना " +
        "कठीण वाटत असतील — माफ करा, तुम्ही अॅप वापरू शकणार नाही: सर्व काही आपोआप सेट करणे " +
        "अशक्य आहे, आणि जिवंत प्रॉक्सी शोधण्यास वेळ लागतो.\n\nजर तुम्ही अॅप खूप पूर्वी डाउनलोड केले " +
        "आणि कोणत्याही जिवंत प्रॉक्सी सापडल्या नाहीत — अॅप किंवा सबस्क्रिप्शन यादी अपडेट करा. हे अॅप " +
        "स्वतःच्या प्रॉक्सी तयार करत नाही किंवा पुरवत नाही, ते फक्त डझनभर " +
        "गट आणि पानांवर इंटरनेटवर शोधते."
    override fun proxyBtn(port: Int) = "प्रॉक्सी ${port}"

    override val setupPortsTitle = "Telegram मध्ये पोर्ट सेट करा"
    override val setupPortsSub = "Telegram ला कनेक्टरशी कसे जोडावे (पोर्ट 55001/55002)"
    override val settings = "सेटिंग्ज"; override val settingsSub = "पोर्ट, अँटी-DPI, स्कॅन, नेटवर्क, बॅटरी"
    override val subscriptions = "सबस्क्रिप्शन"; override val subscriptionsSub = "स्कॅन करण्यासाठी प्रॉक्सी स्रोत"
    override val statistics = "आकडेवारी"; override val statisticsSub = "प्रॉक्सी डेटाबेस + अँटी-DPI युक्त्या"
    override val export = "एक्सपोर्ट"; override val exportSub = "जिवंत प्रॉक्सींच्या tg:// लिंक"
    override val about = "बद्दल"; override val aboutSub = "आवृत्ती, बिल्ड, डाउनलोड, अभिप्राय"
    override val hotkeys = "हॉटकी"
    override val hotkeysSub = "ग्लोबल की: प्रॉक्सी कॉपी / उघडा"
    override val hotkeysIntro = "ग्लोबल हॉटकी अॅप विंडो फोकसमध्ये नसतानाही चालतात. त्या " +
        "पूलमधून एक यादृच्छिक जिवंत प्रॉक्सी लिंक (tg://) निवडतात — अॅप न उघडता प्रॉक्सी " +
        "त्वरीत बदलण्यासाठी सुलभ."
    override val hotkeysNote = "macOS वर, की कॅप्चर करण्यासाठी Accessibility परवानगी आवश्यक असू शकते " +
        "(System Settings → Privacy & Security → Accessibility)."
    override val hotkeyCopyTitle = "प्रॉक्सी लिंक कॉपी करा"
    override val hotkeyCopyDesc = "एक यादृच्छिक जिवंत tg:// लिंक क्लिपबोर्डवर ठेवते."
    override val hotkeyEnable = "हॉटकी सक्षम करा"; override val hotkeyLetterLabel = "अक्षर"; override val hotkeySet = "सेट करा"; override val hotkeyReset = "रीसेट"
    override val hotkeyOpenTitle = "Telegram मध्ये प्रॉक्सी उघडा"
    override val hotkeyOpenDesc = "एक यादृच्छिक जिवंत लिंक उघडते — Telegram ती घेते आणि प्रॉक्सी जोडण्याचा प्रस्ताव देते."

    override val relayPorts = "रिले पोर्ट"
    override val relayPortsHelp = "स्थानिक पोर्ट जे कनेक्टर ऐकतो. तुम्ही नेमके हेच " +
        "Telegram मध्ये SOCKS5 प्रॉक्सी म्हणून टाकता (127.0.0.1 : पोर्ट). विश्वासार्हतेसाठी दोन पोर्ट वापरले जातात — Telegram " +
        "दोन्हीशी कनेक्शन ठेवते."
    override val portA = "पोर्ट A"; override val portB = "पोर्ट B"
    override val antiDpiTrick = "अँटी-DPI युक्ती"
    override val antiDpiHelp = "कनेक्शन लपवण्याचा एक मार्ग जेणेकरून ISP/DPI ते ओळखू आणि " +
        "ब्लॉक करू शकत नाही.\n• \"ऑटो-रोटेट\" स्वतःच एक कार्यरत युक्ती निवडते.\n• \"DPI युक्त्या नाहीत\" — एक साधे " +
        "कनेक्शन.\n• बाकीच्या विशिष्ट तंत्रे आहेत (ब्राउझर अनुकरण, पॅकेट विभाजन इ.)."
    override val onlyFakeTls = "फक्त FakeTLS (ee)"
    override val applyDpiTo = "अँटी-DPI येथे लागू करा"
    override val applyDpiHelp = "निवडलेली अँटी-DPI युक्ती कशाला लागू करायची:\n• Telegram रिले — कनेक्टरद्वारे " +
        "जिवंत Telegram कनेक्शनला.\n• प्रॉक्सी प्रोब — पार्श्वभूमीतील प्रॉक्सी तपासण्यांना " +
        "(मग तपासणी अगदी खऱ्या कनेक्शनसारखी वागते, आणि युक्ती आकडेवारी अधिक अचूक असते).\n" +
        "• थेट जोडताना — जेव्हा प्रॉक्सी बंद असतात (किंवा VPN चालू असताना वगळल्या जातात) आणि Telegram " +
        "थेट त्याच्या सर्व्हरकडे जाते: इथे प्रॉक्सी नसते, त्यामुळे युक्ती पहिल्या TCP पॅकेटला " +
        "(हँडशेक) अनेक लहान सेगमेंटमध्ये विभाजित करण्यापुरती मर्यादित होते जेणेकरून DPI ते एका वाचनात जुळवू शकत नाही."
    override val toRelay = "Telegram रिले"; override val toProbes = "प्रॉक्सी प्रोब"
    override val toDirect = "थेट जोडताना"
    override val vpnSection = "VPN चालू असताना"
    override val vpnHelp = "डिव्हाइसवर VPN सक्रिय असताना काय करायचे:\n• MTProto प्रॉक्सीद्वारे — " +
        "Telegram नेहमीप्रमाणे सापडलेल्या प्रॉक्सीद्वारे जाते (VPN च्या वर).\n• थेट — " +
        "कनेक्टर प्रॉक्सी वापरत नाही आणि Telegram ला थेट Telegram च्या सर्व्हरशी जोडतो: " +
        "VPN आधीच प्रवेश देतो, अतिरिक्त प्रॉक्सी थर आवश्यक नाही (वेगवान आणि अधिक स्थिर). " +
        "VPN शिवाय प्रॉक्सी नेहमीप्रमाणे वापरल्या जातात."
    override val linkFormat = "प्रॉक्सी लिंक स्वरूप"
    override val linkFormatHelp = "प्रॉक्सी कशी कॉपी आणि उघडायची. tg:// थेट Telegram उघडते (Telegram Desktop इन्स्टॉल असणे आवश्यक). http (t.me) ब्राउझरद्वारे उघडते आणि Telegram मध्ये उघडण्याचा प्रस्ताव देते — tg:// नोंदणीकृत नसल्यास सुलभ."
    override val linkTg = "tg:// (थेट Telegram उघडा)"; override val linkTgSub = "tg://proxy?… — Telegram उघडते"
    override val linkHttp = "http (t.me, ब्राउझरद्वारे)"; override val linkHttpSub = "https://t.me/proxy?… — ब्राउझर उघडते"
    override val viaMtproto = "MTProto द्वारे प्रॉक्सी"; override val viaMtprotoSub = "VPN असतानाही ट्रॅफिक प्रॉक्सीद्वारे जाते"
    override val directly = "थेट जोडा"; override val directlySub = "VPN सक्रिय असताना — प्रॉक्सी टाळून, थेट Telegram कडे"
    override val notifications = "सूचना"
    override val scanCheck = "स्कॅन आणि तपासणी"
    override val scanCheckHelp = "• स्कॅन, मिनिट — सबस्क्रिप्शनमधून प्रॉक्सी याद्या किती वेळा डाउनलोड करायच्या.\n" +
        "• तपासणी, मिनिट — डेटाबेसमधील प्रॉक्सी जिवंतपणासाठी किती वेळा पुन्हा तपासायच्या.\n• बॅच आकार — " +
        "प्रत्येक रनमध्ये किती प्रॉक्सी तपासायच्या.\n• समांतर — एकाच वेळी किती तपासण्या चालवायच्या (अधिक = " +
        "वेगवान, पण नेटवर्क आणि बॅटरीवर जास्त भार)."
    override val scanMin = "स्कॅन, मिनिट"; override val checkMin = "तपासणी, मिनिट"; override val batchSize = "बॅच आकार"; override val parallel = "समांतर"
    override val speedByNet = "नेटवर्कनुसार स्कॅन तीव्रता"
    override val speedByNetHelp = "सध्याच्या नेटवर्कनुसार प्रॉक्सी किती वेळा तपासायच्या. " +
        "\"मानक\" = आधार अंतराल. कमी वारंवारतेसाठी उजवीकडे सरकवा (हळू, ट्रॅफिक/बॅटरीवर सौम्य), " +
        "अधिक वारंवारतेसाठी डावीकडे (वेगवान, अधिक आक्रमक). लॉगरिदमिक स्केल, प्रत्येक दिशेने ×100 पर्यंत.\n" +
        "• VPN — जेव्हा बाह्य VPN सक्रिय असतो.\n• Wi-Fi — Wi-Fi नेटवर्कवर.\n• LTE — मोबाइल नेटवर्कवर."
    override val intensStandard = "मानक"
    override val intensSlower = "हळू"
    override val intensFaster = "वेगवान"
    override val maintenance = "डेटा रीसेट करा"
    override val maintenanceHelp = "• \"कॅटलॉग आणि आकडेवारी रीसेट करा\" — रेटिंग, काउंटर, ट्रॅफिक " +
        "आणि तपासणी लॉग शून्य करते, पण डाउनलोड केलेले होस्ट आणि सबस्क्रिप्शन ठेवते (पुढील स्कॅनवर सर्वकाही " +
        "पुन्हा रेट केले जाते).\n• \"डाउनलोड केलेले होस्ट साफ करा\" — संपूर्ण प्रॉक्सी पूल हटवते पण " +
        "सबस्क्रिप्शन ठेवते जेणेकरून स्कॅन पूल पुन्हा भरतो. सबस्क्रिप्शनना कोणत्याही प्रकारे स्पर्श केला जात नाही."
    override val backupTitle = "एक्सपोर्ट / इम्पोर्ट"
    override val backupHelp = "अॅप डेटा JSON म्हणून जतन किंवा पुनर्संचयित करा. काय " +
        "समाविष्ट करायचे ते चिन्हांकित करा — कोणतेही संयोजन:\n• सेटिंग्ज — सर्व अॅप पॅरामीटर.\n• सबस्क्रिप्शन — स्रोत " +
        "यादी (URL + चालू/बंद).\n• जिवंत-होस्ट कॅटलॉग — प्रत्येक जिवंत प्रॉक्सी त्याच्या रेटिंग आणि आकडेवारीसह " +
        "प्रत्येक नेटवर्क मोडनुसार.\n\n\"एक्सपोर्ट\" तयार JSON असलेले पान उघडते — ते कॉपी करा किंवा फाइलमध्ये जतन करा. " +
        "\"इम्पोर्ट\" — JSON पेस्ट करा (किंवा फाइल लोड करा) आणि त्यात उपस्थित असलेले फक्त चिन्हांकित विभाग लागू होतात. " +
        "इम्पोर्ट सध्याच्या डेटामध्ये जोडते (काहीही मिटवत नाही)."
    override val backupSettings = "सेटिंग्ज"
    override val backupSubs = "सबस्क्रिप्शन"
    override val backupHosts = "जिवंत-होस्ट कॅटलॉग (मोडनुसार)"
    override val exportWord = "एक्सपोर्ट"
    override val importWord = "इम्पोर्ट"
    override val backupExportTitle = "डेटा एक्सपोर्ट करा"
    override val backupImportTitle = "डेटा इम्पोर्ट करा"
    override val backupSelectExport = "काय एक्सपोर्ट करायचे:"
    override val backupSelectImport = "काय इम्पोर्ट करायचे:"
    override val backupCopyBtn = "कॉपी"
    override val backupSaveFile = "फाइलमध्ये जतन करा"
    override val backupLoadFile = "फाइलमधून लोड करा"
    override val backupDoImport = "इम्पोर्ट"
    override val backupPasteLabel = "बॅकअप JSON येथे पेस्ट करा"
    override val backupJsonLabel = "बॅकअप JSON"
    override val backupAndroidFileNote = "फाइल इथे उपलब्ध नाहीत — कॉपी / पेस्ट वापरा."
    override val eraseAllHosts = "सर्व होस्ट मिटवा"
    override val factoryReset = "सर्वकाही रीसेट करा (पहिल्या लाँचसारखे)"
    override val factoryResetConfirm = "अॅप पूर्णपणे फॅक्टरी स्थितीत रीसेट करायचे? सर्व सेटिंग्ज आणि संपूर्ण " +
        "होस्ट कॅटलॉग मिटवले जातील, सबस्क्रिप्शन डीफॉल्टवर पुनर्संचयित होतील. अगदी पहिल्या लाँचसारखे."
    override val resetCatalog = "कॅटलॉग आणि आकडेवारी रीसेट करा"
    override val resetCatalogConfirm = "सर्व रेटिंग, काउंटर आणि तपासणी लॉग शून्य करायचे? " +
        "डाउनलोड केलेले होस्ट आणि सबस्क्रिप्शन ठेवले जातात आणि पुढील स्कॅनवर पुन्हा रेट केले जातात."
    override val clearHosts = "डाउनलोड केलेले होस्ट साफ करा"
    override val clearHostsConfirm = "डाउनलोड केलेल्या होस्टची (प्रॉक्सी) संपूर्ण यादी हटवायची? " +
        "सबस्क्रिप्शन ठेवले जातात आणि स्कॅन पूल पुन्हा भरेल."
    override val doReset = "रीसेट"
    override val doCancel = "रद्द करा"
    override val adaptiveSpeed = "अनुकूली वेग"
    override val adaptiveHelp = "जिवंतपणा तपासण्या आधार अंतरालावर चालतात (\"स्कॅन आणि तपासणी\" मधून, तसेच " +
        "नेटवर्क गुणकाने गुणाकार केल्या). \"अनुकूली वेग\" सध्या किती प्रॉक्सी जिवंत आहेत त्यानुसार त्या " +
        "आपोआप वेगवान किंवा हळू करतो.\n\n" +
        "• कमी जिवंत (\"कमी\" थ्रेशोल्डच्या खाली) → अंतराल × \"वेग-वाढ\". 1 खालील गुणक = अधिक " +
        "वेळा: 0.5 — दुप्पट वेळा, 0.25 — 4×. पूल जलद भरते.\n" +
        "• अनेक जिवंत (\"अनेक\" थ्रेशोल्डच्या वर) → अंतराल × \"वेग-घट\". 1 वरील = कमी वेळा: 2 — " +
        "अर्ध्या वेळा, 4 — एक चतुर्थांश. बॅटरी आणि ट्रॅफिक वाचवते.\n" +
        "• थ्रेशोल्डच्या दरम्यान — आधार वेग (×1).\n\n" +
        "उदाहरणे:\n" +
        "— प्रॉक्सी जलद गोळा करा: \"वेग-वाढ\" 0.25 आणि/किंवा \"कमी\" थ्रेशोल्ड 40.\n" +
        "— पुरेसे असताना बॅटरी वाचवा: \"वेग-घट\" 8 आणि/किंवा \"अनेक\" थ्रेशोल्ड 30.\n" +
        "— अनुकूलन बंद करा: दोन्ही गुणक 1 वर सेट करा.\n\n" +
        "डीफॉल्ट: कमी 20, वेग-वाढ 0.5, अनेक 50, वेग-घट 4."
    override val threshMany = "\"अनेक\" थ्रेशोल्ड"; override val threshFew = "\"कमी\" थ्रेशोल्ड"; override val mulFast = "वेग-वाढ ×"; override val mulLazy = "वेग-घट ×"
    override val subIntensityTitle = "सबस्क्रिप्शन तीव्रता"
    override val subIntensityHint = "सबस्क्रिप्शन डाउनलोडमधील विराम: प्रॉक्सी याद्या पुन्हा डाउनलोड करण्यापूर्वी किती मिनिटे (प्रत्येक नेटवर्क मोडनुसार वेगळे)."
    override val baseScanTitle = "आधार स्कॅन वेग"
    override val baseScanHelp = "संदर्भ जिवंतपणा-तपासणी वेग. \"अनुकूली वेग\" आणि \"मोडनुसार वेग\" " +
        "गुणक त्याच्या सापेक्ष मोजले जातात.\n\n" +
        "• किती वेळा चालवायचे, मिनिट — तपासणी पासमधील अंतराल.\n" +
        "• प्रति थ्रेड बॅच, होस्ट — प्रत्येक थ्रेड प्रति पास किती होस्ट तपासतो.\n" +
        "• थ्रेड — एकाच वेळी किती तपासण्या चालतात. एक पास \"बॅच × थ्रेड\" होस्ट प्रोब करतो.\n" +
        "• एका होस्टला प्रत्येक N मिनिटांपेक्षा जास्त वेळा पुन्हा स्कॅन करू नका — अँटी-फ्लड: नुकताच तपासलेला होस्ट " +
        "या पासमध्ये वगळला जातो.\n\n" +
        "अधिक थ्रेड आणि मोठा बॅच = जलद पूल वाढ, पण नेटवर्क आणि बॅटरीवर जास्त भार."
    override val baseScanPeriod = "किती वेळा चालवायचे, मिनिट"
    override val baseScanBatch = "प्रति थ्रेड बॅच, होस्ट"; override val baseScanThreads = "थ्रेड संख्या"
    override val adaptiveDesc = "जर जिवंत प्रॉक्सी \"कमी\" पेक्षा कमी किंवा \"अनेक\" पेक्षा जास्त असतील, तर अतिरिक्त गुणक लागू करा."
    override val fewWord = "कमी"; override val manyWord = "अनेक"
    override fun fasterX(x: String) = "${x}× वेगवान"
    override fun slowerX(x: String) = "${x}× हळू"
    override fun ifAliveLt(n: Int) = "जर जिवंत प्रॉक्सी < ${n}, तर:"
    override fun ifAliveGt(n: Int) = "जर जिवंत प्रॉक्सी > ${n}, तर:"
    override val disabledWord = "बंद"
    override val speedByModeTitle = "मोडनुसार वेग"
    override val speedByModeHelp = "प्रत्येक नेटवर्क मोडसाठी स्कॅन-वेग गुणक, आधार वेगाच्या वर. " +
        "\"मानक\" (×1) = आधार अंतराल. उजवीकडे — कमी वेळा (हळू, ट्रॅफिक/" +
        "बॅटरीवर सौम्य), डावीकडे — अधिक वेळा (वेगवान, अधिक आक्रमक). लॉगरिदमिक स्केल, प्रत्येक दिशेने ×100 " +
        "पर्यंत.\n\n" +
        "प्रत्येक स्लायडरखाली अनुकूली वेग लागू केलेले परिणामी पास पॅरामीटर आहेत — " +
        "\"कमी जिवंत\" (× \"वेग-वाढ\") आणि \"अनेक जिवंत\" (× \"वेग-घट\") साठी वेगळे दाखवले.\n\n" +
        "मोड:\n• VPN — बाह्य VPN सक्रिय आहे.\n• LTE — मोबाइल नेटवर्क.\n• Wi-Fi — Wi-Fi नेटवर्क.\n" +
        "• Ethernet — वायर्ड कनेक्शन.\n• White — मॅन्युअल \"white\" प्रॉक्सी मोड."
    override val aliveLt = "जिवंत <"; override val aliveGt = "जिवंत >"
    override val periodWord = "कालावधी"; override val nonstopWord = "अखंड"
    override val batchWord = "बॅच"; override val threadsWord = "थ्रेड"; override val scanModeOff = "स्कॅन बंद"
    override val netBattery = "नेटवर्क आणि बॅटरी"
    override val netBatteryHelp = "• फक्त Wi-Fi — मोबाइल नेटवर्कवर स्कॅन करू नका (डेटा वाचवते).\n• फक्त " +
        "चार्जिंग — फोन चार्ज होत असतानाच काम करा.\n• कमी बॅटरीवर वगळा — बॅटरी " +
        "कमी असताना स्कॅनिंग थांबवा."
    override val onlyWifi = "फक्त Wi-Fi"; override val onlyCharging = "फक्त चार्जिंग"; override val skipLowBattery = "कमी बॅटरीवर वगळा"
    override val autosaved = "सेटिंग्ज आपोआप जतन होतात."
    override val dpiAutoLabel = "DPI युक्त्या ऑटो-रोटेट करा"; override val dpiNoneLabel = "DPI युक्त्या नाहीत (साधे)"
    override val experimental = "प्रायोगिक"
    override val experimentalHelp = "MTProto अपस्ट्रीमला पर्यायी प्रॉक्सिंग इंजिन तसेच एक निदान लॉग. " +
        "\"बंद\" वर सेट केल्यावर संदर्भ (कार्यरत) मार्ग अपरिवर्तित राहतो. फक्त एन्क्रिप्ट केलेला प्रवाह " +
        "अपस्ट्रीम TCP सॉकेटवर कसा लिहिला जातो हे बदलते (सेगमेंट आकार, वेळ, TLS-रेकॉर्ड सीमा) — प्रवाह स्वतः बाइट-बाइट सारखाच राहतो. " +
        "फक्त जिवंत प्रॉक्सी रिलेला लागू होते (प्रोब नाही, थेट मार्ग नाही)."
    override val expEngineTitle = "प्रॉक्सिंग इंजिन (सॉकेट ऑब्फस्केशन)"
    override val expConnectTitle = "कनेक्ट इंजिन (अपस्ट्रीम निवड)"
    override val expEngineWarn = "⚠ प्रायोगिक मोड. जर कनेक्टिव्हिटी खराब झाली, तर \"बंद (संदर्भ मार्ग)\" वर परत जा."
    override val netLog = "नेटवर्क-एक्सचेंज लॉग सक्षम करा"
    override val netLogSub = "कोण-कोणाला-केव्हा आणि पॅकेट आकार फाइलमध्ये लिहितो (कोणताही पेलोड डेटा नाही) — " +
        "VPN सह विरुद्ध VPN शिवाय एक्सचेंज पॅटर्नची तुलना करण्यासाठी."
    override val openLogFolder = "लॉग फोल्डर उघडा"; override val copyPath = "पथ कॉपी करा"
    override val helpShow = "मदत"; override val helpHide = "मदत लपवा"
    override val quickSwitchIntro = "इथे तुम्ही ब्लॉक-बायपास युक्ती निवडू शकता. जर Telegram \"The proxy you are using is not configured correctly and will be disabled. Please find another " +
        "one\" ही त्रुटी दाखवत असेल, तर कोणत्या ट्रॅफिक-ऑब्फस्केशन प्रकाराने काम होते याचा प्रयोग करा जेणेकरून Telegram ती दाखवणे थांबवेल. split* " +
        "मोडपासून सुरुवात करा. coalesce* मोडही काम करतात, पण त्यांच्यासह Telegram मध्ये प्रतिमा/व्हिडिओ नीट लोड होत नाहीत."
    override val quickSwitchTitle ="ब्लॉक बायपास"; override val quickSwitchSub = "शेपिंग, कनेक्ट, अँटी-DPI"

    override val sourceUrl = "स्रोत URL"
    override fun sourceAlive(alive: Int, total: Int) = "जिवंत ${alive}/${total}"
    override val open = "उघडा"; override val active = "सक्रिय"; override val inactive = "निष्क्रिय"
    override val lastDownloaded = "डाउनलोड केले"; override val notDownloaded = "अद्याप डाउनलोड केले नाही"
    override fun sourceCounts(dead: Int, total: Int) =
        " जिवंत, ${dead} मृत, ${total} एकूण"

    override val proxyBase = "प्रॉक्सी डेटाबेस"
    override val totalInBase = "डेटाबेसमध्ये एकूण"; override val aliveNow = "आता जिवंत"; override val deadStat = "मृत"
    override val aliveIn15 = "15 मिनिटांत जिवंत"; override val checksAllTime = "सर्व काळातील तपासण्या"
    override val antiDpiTricks = "अँटी-DPI युक्त्या"; override val noStatsYet = "अद्याप डेटा नाही — तपासण्या/कनेक्शन होताना युक्त्या जमा होतात"
    override val attempts = "प्रयत्न"; override val handshake = "हँडशेक"; override val score = "स्कोअर"
    override val tgConnect = "TG कनेक्ट"; override val socketsOver1m = "सॉकेट >1मिनिट"
    override val over10kb = "सॉकेट >10KB"; override val over100kb = ">100KB"; override val workTime = "कार्य वेळ"
    override val statsLegend = "हँडशेक — यशस्वी हँडशेक (प्रयत्नांच्या %) · स्कोअर — मूल्य · " +
        "\"कार्य वेळ\" — ≥5KB आणि 1 मिनिटापेक्षा जास्त लांब सॉकेटवरील एकूण."
    override val resetStats = "युक्ती आकडेवारी रीसेट करा"

    override fun aliveLinks(n: Int) = "जिवंत लिंक: ${n}"
    override val copyAll = "सर्व कॉपी करा"
    override val openRandom = "यादृच्छिक उघडा"; override val copyRandom = "यादृच्छिक कॉपी करा"; override val allShort = "सर्व"
    override val copyTop = "TOP कॉपी करा"; override val randomHost = "यादृच्छिक होस्ट"
    override val exportToFile = "फाइलमध्ये एक्सपोर्ट करा"; override val exportSaved = "फाइलमध्ये जतन केले:"
    override val dlNow = "आता डाउनलोड करा"
    override fun downloadingFmt(sec: Long) = "डाउनलोड करत आहे… ${sec}से"
    override val cancel = "रद्द करा"
    override val deleteConfirmTitle = "सबस्क्रिप्शन हटवायचे?"
    override val subscriptionsAddHint = "सबस्क्रिप्शन किंवा प्रॉक्सी लिंक जोडा →"
    override val addSourcesTitle = "जोडा"
    override val addSubsLabel = "सबस्क्रिप्शन (प्रति ओळ एक URL)"
    override val addSubsHelp = "वैध URL असलेली प्रत्येक ओळ स्वतःचे सबस्क्रिप्शन बनते आणि वेळोवेळी मिळवली जाते."
    override val addProxiesLabel = "तयार प्रॉक्सी लिंक (निश्चित यादी)"
    override val addProxiesHelp = "विशिष्ट प्रॉक्सींना (tg://proxy, https://t.me/proxy, …) लिंकचा एक संच पेस्ट करा. हे सबस्क्रिप्शन नाही — यादी कधीही डाउनलोड केली जात नाही, प्रॉक्सी फक्त कॅटलॉगमध्ये जोडल्या जातात."
    override val addButton = "जोडा"
    override fun addedFmt(subs: Int, proxies: Int) = "जोडले: ${subs} सबस्क्रिप्शन, ${proxies} प्रॉक्सी"
    override val perSecond = "प्रति सेकंद"
    override val graphSpeed = "वेग"
    override val graphVolume = "खंड"
    override val graphLatency = "पिंग"
    override val graphConnects = "कनेक्ट"
    override val scanNow = "आता स्कॅन करा"; override val scanOnShort = "स्कॅन चालू"
    override val scanRunning = "स्कॅन चालू आहे"; override val scanIdle = "स्कॅन निष्क्रिय"; override val scanOffState = "स्कॅन बंद"; override val scanBatchPerThread = "बॅच/थ्रेड"; override val scanPassHosts = "पासमधील होस्ट"; override val minRescanLabel = "एका होस्टला प्रत्येक N मिनिटांपेक्षा जास्त वेळा पुन्हा स्कॅन करू नका"
    override val scanPlanTitle = "योजना"; override val scanNowTitle = "आता"; override val currentScheduleTitle = "सध्याचे वेळापत्रक"
    override val scheduleWord = "वेळापत्रक"; override val unitPcsPerSec = "नग/से"
    override val scanNowThreadsLabel = "आता चालू असलेले थ्रेड"; override val scanNowPerThreadLabel = "प्रति थ्रेड तपासण्या (योजना)"; override val scanNowElapsedLabel = "चालण्याची वेळ"
    override val scanOkGraph = "यशस्वी स्कॅन"; override val scanFailGraph = "अयशस्वी स्कॅन"; override val scanTrafficGraph = "स्कॅन ट्रॅफिक"; override val scanAliveGraph = "एकूण जिवंत प्रॉक्सी"; override val scanPingGraph = "पिंग"; override val threadsGraph = "थ्रेड"
    override val scanEvery = "प्रत्येक"; override val scanNextRun = "पुढील रन"
    override val scanThreads = "थ्रेड"; override val scanBatch = "बॅच"
    override val scanElapsed = "चालू"; override val scanIdleNow = "—"
    override val effForFew = "कमी असताना"; override val effForMany = "अनेक असताना"
    override val effCheck = "तपासणी"; override val effBatch = "बॅच"; override val effPar = "समांतर"
    override val effContinuous = "अखंड"; override val secShort = "से"; override val minShort = "मिनिट"

    override val appTagline = "क्रॉस-प्लॅटफॉर्म ऑटो-कनेक्टर: ते MTProto प्रॉक्सी शोधते, तपासते आणि चालवते " +
        "ज्याद्वारे Telegram काम करते."
    override val version = "आवृत्ती"; override val buildDate = "बिल्ड तारीख"
    override val downloadSources = "डाउनलोड आणि स्रोत"; override val openOnGithub = "GitHub वर उघडा"
    override val feedbackBugs = "अभिप्राय आणि बग अहवाल"; override val writeTelegram = "Telegram वर लिहा"

    override val language = "भाषा"; override val langAuto = "ऑटो (सिस्टीम)"; override val langRu = "Русский"; override val langEn = "English"
    override val langFa = "فارسی"; override val langZh = "简体中文"; override val langAr = "العربية"; override val langUr = "اردو"
    override val langTr = "Türkçe"; override val langId = "Bahasa Indonesia"; override val langHi = "हिन्दी"; override val langBn = "বাংলা"; override val langMy = "မြန်မာ"
    override val langWord = "भाषा"
    override val raceWidthTitle = "समांतर कनेक्ट"
    override val connectionSection = "कनेक्शन आणि ब्लॉक बायपास"
    override val connectionSectionHelp = "कनेक्ट इंजिन, समांतर अपस्ट्रीम, प्रॉक्सिंग इंजिन आणि अँटी-DPI युक्त्या — सर्व एका विभागात."
    override val netLogSection = "नेटवर्क एक्सचेंज लॉग"
    override val platform = "प्लॅटफॉर्म"

    override val scanModeTitle = "नेटवर्क मोड"; override val scanModeAuto = "ऑटो"; override val scanModeManualLabel = "मॅन्युअल"
    override val activeModeLabel = "सक्रिय मोड"; override val formingListLabel = "यादी तयार करत आहे"; override val catalogModeTabs = "मोड"
    override val resetModeRatings = "होस्ट रेटिंग रीसेट करा"; override val forgetModeHosts = "मोड होस्ट विसरा"
    override val exportModeTitle = "मोडनुसार एक्सपोर्ट"; override val modePickerTitle = "मोड"
    override val modeHelp = "प्रत्येक नेटवर्क मोड स्वतःची प्रॉक्सी रेटिंग आणि स्वतःची स्कॅन + सबस्क्रिप्शन-डाउनलोड तीव्रता ठेवतो. \"ऑटो\" सक्रिय नेटवर्कवरून मोड निवडतो. \"मॅन्युअल\" तुम्हाला स्वतः कोणताही मोड निवडू देतो (White सह, जो ऑटो कधीच निवडत नाही)."
    override val autoSelect = "ऑटो निवड"; override val manualSelect = "मॅन्युअल निवड"
    override val connStatsTitle = "आता कनेक्शन"; override val connOnPort = "पोर्टवरील कनेक्शन"; override val outgoingConns = "जाणारी कनेक्शन"
    override val modeChoice = "मोड निवड"; override val autoChoice = "ऑटो-निवड"; override val manualChoice = "मॅन्युअल निश्चित"
    override val directOnVpn = "VPN वर TG ला थेट कनेक्ट"; override val onWord = "चालू"; override val offWord = "बंद"
    override val directStateActive = "सक्रिय"; override val directStateOff = "सेटिंग्जमध्ये बंद"; override val directStateIdle = "सेटिंग्जमध्ये चालू, पण सक्रिय नाही"
    override val wpHintTitle = "White म्हणजे काय?"
    override val wpHint = "White — WhitePages: एक मॅन्युअल नेटवर्क प्रोफाइल. फक्त हाताने सक्षम केले जाते (ऑटो-निवड ते कधीच निवडत नाही). " +
        "स्वतःची होस्ट रेटिंग ठेवते, सबस्क्रिप्शन डाउनलोड करते आणि VPN/Wi-Fi/LTE पासून स्वतंत्रपणे स्कॅन करते."

    override val recentAttempts = "अलीकडील कनेक्शन आणि तपासण्या"
    override val kindCheck = "तपासणी"
    override val kindTg = "टेलिग्राम"
    override val histWho = "कोण"
    override val histWhen = "केव्हा"
    override val histReq = "विनंती"
    override val histSess = "सेशन"
    override val histScan = "स्कॅन"
    override val testNow = "आता चाचणी करा"
    override val testShort = "चाचणी"
    override val testResult = "चाचणी निकाल"
    override val testStop = "थांबा"
    override val testingNow = "चाचणी सुरू आहे…"
    override val prewarmTitle = "सॉकेट प्रीवॉर्म (प्रयोग)"
    override val prewarmHelp = "प्रॉक्सीशी काही सॉकेट आधीच उघडे ठेवा जेणेकरून नवीन Telegram कनेक्शन " +
        "कनेक्ट/हँडशेक वगळेल. प्रायोगिक: पार्श्वभूमी सतत पुन्हा जोडते → ट्रॅफिक खर्च आणि थोडा CPU. बनावट " +
        "ट्रॅफिक पाठवला जात नाही (तो खरे सेशन तोडेल) — सॉकेट फक्त फिरवले जातात. FakeTLS प्रॉक्सीसह सर्वात उपयुक्त."
    override val prewarmEnable = "प्रीवॉर्म सक्षम करा"
    override val prewarmModeDeferred = "विलंबित (फक्त TLS)"
    override val prewarmModeDeferredSub = "TCP + FakeTLS धरून ठेवतो; obfuscated2-init प्रसारणाच्या वेळी पाठवतो. DC कमिट होत नाही — सर्वात वास्तववादी."
    override val prewarmModeFull = "पूर्ण हँडशेक"
    override val prewarmModeFullSub = "वेगवेगळ्या DC नुसार पूर्णपणे जोडलेले सॉकेट धरून ठेवतो; फक्त DC/tag जुळल्यासच पुन्हा वापरतो. कमी काळ टिकतात."
    override val prewarmPoolLabel = "राखीव सॉकेट"
    override val prewarmHoldLabel = "धरून ठेवा, से"
    override val prewarmNote = "फक्त रोटेशन (अॅप स्तरावर keepalive नाही). सॉकेट काही सेकंद…~मिनिट टिकतो, प्रॉक्सी/DC वर अवलंबून."
    override val prewarmStatus = "प्रीवॉर्म"
    override fun prewarmStatusVal(ready: Int, holdSecs: Int) = "${ready} तयार · ${holdSecs}से धरतो"
    override val prewarmStar = "ठळक नारिंगी = सॉकेट प्रीवॉर्म पूलमधून उबदार दिला गेला (कनेक्ट/हँडशेकशिवाय)"
    override fun prewarmTableTitle(holdSecs: Int) = "सॉकेट प्रीवॉर्म (${holdSecs}से धरतो)"
    override val prewarmTableHelp = "\"सॉकेट प्रीवॉर्म\" प्रॉक्सीशी काही सॉकेट आधीच उघडते जेणेकरून नवीन Telegram " +
        "कनेक्शन कनेक्ट/हँडशेक वगळेल. या तक्त्यात प्रीवॉर्म होणारे होस्ट दाखवले आहेत: सॉकेट किती सेकंद टिकतो, " +
        "Telegram तो वापरते का, आणि ट्रॅफिक. \"अधिक → सेटिंग्ज → „सॉकेट प्रीवॉर्म (प्रयोग)“\" मध्ये सक्षम/बंद " +
        "आणि कॉन्फिगर (मोड, सॉकेट संख्या, धरून ठेवण्याची वेळ) करता येते."
    override val prewarmNoneWarming = "अद्याप प्रीवॉर्म होणारे सॉकेट नाहीत"
    override val prewarmColAge = "आयुष्य"
    override val prewarmColUse = "TG मध्ये?"
    override val prewarmInUse = "TG मध्ये"
    override val prewarmNew = "नवीन"
    override val lanShareTitle = "स्थानिक नेटवर्कवर शेअरिंग (वेब पोर्टल)"
    override val lanShareDesc = "या Wi-Fi मधील इतर डिव्हाइसना या AutoConnector ला प्रॉक्सी म्हणून वापरण्याची परवानगी द्या; खालील पत्त्यावरील ब्राउझरला सर्वोत्तम प्रॉक्सी असलेले पान मिळेल."
    override val lanShareUrlsLabel = "नेटवर्कमधील शेजारी जोडतात:"
    override val lanShareNoIp = "स्थानिक नेटवर्कवर पत्ता नाही — Wi-Fi शी जोडा"
    override val lanFirewallTitle = "स्थानिक नेटवर्कवर परवानगी द्या"
    override val lanFirewallBody = "सक्षम केल्यावर रिले पोर्ट स्थानिक नेटवर्कवर उघडतील. आता Windows (किंवा इतर) फायरवॉल AutoConnector ला परवानगी द्यायची का विचारू शकतो — \"परवानगी द्या\"/\"होय\" निवडा. नाकारल्यास, शेजाऱ्यांचा AutoConnector कडे जाणारा ट्रॅफिक ब्लॉक होईल आणि पान/प्रॉक्सी अनुपलब्ध राहतील."
    override val lanFirewallConfirm = "सक्षम करा"
    override val lanInfoTitle = "हे कशासाठी?"
    override val lanInfoBody = "तुमच्या Wi-Fi मधील एकाच संगणकावर किंवा फोनवर AutoConnector चालवा — आणि त्याच नेटवर्कमधील इतर सर्व डिव्हाइस, iPhone सह (ज्याला अॅप थेट समर्थन देत नाही), फक्त ब्राउझरमध्ये पत्ता उघडून वापरू शकतात: त्यांच्या Telegram मध्ये जोडण्यासाठी सर्वोत्तम प्रॉक्सी असलेले पान, किंवा हेच डिव्हाइस SOCKS प्रॉक्सी म्हणून. एक डिव्हाइस प्रॉक्सी शोधते आणि धरून ठेवते, बाकीचे ते स्थानिक नेटवर्कवर वापरतात."
    override val volTriggerTitle = "व्हॉल्यूम बटणांनी ट्रिगर"
    override val volTriggerSub = "व्हॉल्यूम कीच्या जलद पॅटर्नने प्रॉक्सी स्विच करा"
    override val volEnableLabel = "व्हॉल्यूम बटणांवर लक्ष ठेवा"
    override val volHelpTitle = "हे काय आहे?"
    override val volHelpBody = "Android वर ग्लोबल कीबोर्ड हॉटकी नाहीत, म्हणून व्हॉल्यूम बटणे वापरली जातात. सक्षम असताना, AutoConnector पार्श्वभूमीत व्हॉल्यूम-वर/खाली दाबण्याच्या जलद पॅटर्नवर (उदा. वर-वर-खाली-खाली) लक्ष ठेवतो. तो ओळखल्यावर, तो एका यादृच्छिक चांगल्या जिवंत प्रॉक्सीची tg:// लिंक उघडतो — Telegram ती घेते आणि स्विच करते. अॅप न उघडता प्रॉक्सी फिरवण्याचा जलद, अदृश्य मार्ग. व्हॉल्यूम नेहमीप्रमाणे काम करते (दाबणे रोखले जात नाही). Accessibility प्रवेश आवश्यक आहे (पार्श्वभूमीत की वाचण्यासाठी आणि लिंक उघडण्यासाठी); तुम्ही चेकबॉक्स सक्षम करेपर्यंत काहीही मागितले जात नाही. खाली दाबण्यांमधील कमाल वेळ सेट करा; ओळखले जाणारे पॅटर्न तळाशी सूचीबद्ध आहेत."
    override val volGrantTitle = "Accessibility सक्षम करा (महत्त्वाचे)"
    override val volGrantBody = "Android (विशेषतः 13+) Google Play मधून न इन्स्टॉल केलेल्या अॅप्ससाठी Accessibility ब्लॉक करते — म्हणून AutoConnector धूसर दिसतो आणि \"अॅपसाठी प्रवेश नाकारला\" असे दाखवतो.\n\nअनब्लॉक कसे करावे:\n1. \"अॅप माहिती\" उघडा (खालील बटण, किंवा: सेटिंग्ज → अॅप्स → AutoConnector for Telegram).\n2. ⋮ (वरच्या उजवीकडे तीन ठिपके) → \"प्रतिबंधित सेटिंग्जना परवानगी द्या\" → पुष्टी करा.\n3. परत या: सेटिंग्ज → Accessibility → AutoConnector for Telegram → सक्षम करा.\n\nजर \"प्रतिबंधित सेटिंग्जना परवानगी द्या\" हा पर्याय नसेल — आधी एकदा Accessibility मधील स्विच सक्षम करण्याचा प्रयत्न करा (नकाराचा संदेश दिसेल), मग पायरी 2 उपलब्ध होईल.\n\nXiaomi/MIUI, Samsung इत्यादींवर मार्ग थोडा वेगळा असू शकतो — \"अॅप माहिती\" मध्ये तोच ⋮ शोधा. Android 12 आणि जुन्यावर सहसा निर्बंध नसतो — लगेच सक्षम करा.\n\nव्हॉल्यूम की फक्त वाचल्या जातात, कधीही ब्लॉक केल्या जात नाहीत."
    override val volOpenAppInfo = "\"अॅप माहिती\" उघडा"
    override val volAccessOn = "Accessibility: सक्षम"
    override val volAccessOff = "Accessibility: बंद"
    override val volOpenAccess = "Accessibility सेटिंग्ज उघडा"
    override val volGapLabel = "दाबण्यांमधील कमाल ms"
    override val volPatternsTitle = "ओळखले जाणारे पॅटर्न"
    override val volPatternPick = "पॅटर्न"
    override val volPatternsLegend = "↑ = व्हॉल्यूम वर, ↓ = खाली"
    override val volNoRights = "अॅपकडे अद्याप व्हॉल्यूम बटणे हाताळण्याचे अधिकार नाहीत — पानाच्या तळातील सूचनेनुसार प्रवेश द्या."
    override val volGrantShort = "Accessibility प्रवेश अद्याप नाही. या पानाच्या तळातील तपशीलवार सूचना वाचा आणि \"तपासा\" वर टॅप करा."
    override val volCheck = "तपासा"
    override val volCheckOk = "✓ झाले — प्रवेश दिला, ट्रिगर काम करतो."
    override val volCheckFail = "✗ अद्याप प्रवेश नाही — वरील पायऱ्या पूर्ण करा."
    override val volPatternsList = "↑↑↓↓ · ↓↓↑↑ · ↑↓↑↓ · ↓↑↓↑ · ↑↑↑↑ · ↓↓↓↓ · ↑↓↓↑ · ↓↑↑↓ · ↑↑↑↓↓↓ · ↓↓↓↑↑↑   (↑ = व्हॉल्यूम वर, ↓ = खाली)"
    override val histLegend = "स्तंभ — कोण: ✓/✗ TG = खरा Telegram कनेक्ट, स्कॅन = पार्श्वभूमी तपासणी. केव्हा: किती वेळापूर्वी. TCP/TLS/विनंती: हँडशेक आणि पहिल्या विनंतीचा विलंब, ms. सेशन: रिले सेशन किती काळ टिकले. ↓/↑: होस्टद्वारे मिळालेले / पाठवलेले बाइट."
    override val tgOkTotalHint = "Telegram कनेक्शन / यशस्वी / एकूण तपासण्या"
    override val breadthTitle = "होस्ट निवडीची व्याप्ती"
    override val breadthHelp = "डावीकडे — सर्वोत्तम सत्यापित होस्टला धरून राहा; उजवीकडे — शक्य तितक्या विस्तृतपणे वेगवेगळे जिवंत होस्ट वापरून पाहा. जेव्हा Telegram रिले पोर्टमध्ये धावपळ करते, तेव्हा प्रोग्राम आपोआप निवड विस्तृत करतो."
    override val breadthNarrow = "सत्यापित"
    override val breadthWide = "विस्तृत"
    override val connTimeoutTitle = "होस्ट कनेक्ट टाइमआउट"
    override val connTimeoutHelp = "पुढील प्रॉक्सी वापरून पाहण्यापूर्वी एका अपस्ट्रीमसाठी (TCP + TLS + पहिले MTProto उत्तर) किती वेळ थांबायचे."
    override val factoryResetDone = "सर्वकाही रीसेट झाले. अॅप बंद करा आणि पुन्हा सुरू करा."
}
