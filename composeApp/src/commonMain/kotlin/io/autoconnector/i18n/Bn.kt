package io.autoconnector.i18n

object Bn : Strings {
    override val tabConnector = "কানেক্টর"; override val tabScan = "স্ক্যান"
    override val tabCatalog = "ক্যাটালগ"; override val tabLogs = "লগ"; override val tabMore = "আরও"
    override val logTabTelegram = "টেলিগ্রাম"; override val logTabSubs = "সাবস্ক্রিপশন"; override val logTabScan = "স্ক্যান"
    override val logGeneral = "সাধারণ"; override val logEmpty = "এখনও খালি"
    override val logSessions = "সেশন"; override val logErrorsOnly = "শুধু ত্রুটি"; override val logNoErrors = "কোনো ব্যর্থ সেশন নেই"
    override fun logSession(id: String, port: String) = "#$id · :$port"
    override val back = "পেছনে"; override val copy = "কপি"; override val gotIt = "বুঝেছি"
    override val later = "পরে"; override val details = "বিস্তারিত"; override val whatIsThis = "এটা কী?"
    override val delete = "মুছুন"

    override val connector = "কানেক্টর"; override val scan = "স্ক্যান"
    override val notConfigured = "সেট আপ করা হয়নি! ঠিক করুন →"; override val howToSetup = "কীভাবে সেট আপ করবেন"
    override val notifOff = "নোটিফিকেশন বন্ধ! ঠিক করুন →"; override val enable = "চালু করুন"
    override fun fewProxies(n: Int) = "সচল প্রক্সি $n, খোঁজা হচ্ছে, অপেক্ষা করুন ~১৫ মিনিট…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "সচল প্রক্সি: $alive  (১৫ মিনিট: $within) · মোট: $total"
    override val notifWhyTitle = "নোটিফিকেশন কেন?"
    override val notifWhyBody = "একটি স্থায়ী নোটিফিকেশন আইকন মানে একটি অ্যান্ড্রয়েড ফোরগ্রাউন্ড সার্ভিস। " +
        "এটি ছাড়া সিস্টেম অ্যাপটিকে মেমরি থেকে সরিয়ে দেয় এবং এটি প্রক্সি খোঁজা এবং " +
        "ব্যাকগ্রাউন্ডে কানেকশন ধরে রাখা বন্ধ করে দেয়। সেজন্যই " +
        "AutoConnector কাজ করার জন্য নোটিফিকেশন প্রয়োজন।"
    override val notifEnableTitle = "নোটিফিকেশন চালু করুন"
    override val notifEnableBody = "নোটিফিকেশন আইকন ছাড়া, অ্যান্ড্রয়েড অ্যাপটিকে নিষ্ক্রিয় হিসেবে গণ্য করে এবং " +
        "মেমরি থেকে সরিয়ে দেয়। তখন AutoConnector প্রক্সি খোঁজা এবং " +
        "ব্যাকগ্রাউন্ডে কানেকশন ধরে রাখা বন্ধ করে দেয় — টেলিগ্রাম তার সংযোগ হারায়।\n\n\"চালু করুন\" ট্যাপ করুন এবং " +
        "AutoConnector-এর জন্য নোটিফিকেশন অনুমোদন করুন।"
    override val notifPlea = "নোটিফিকেশন চালু করুন! এগুলো ছাড়া অ্যাপটি ব্যাকগ্রাউন্ডে চলতে পারে না — " +
        "অ্যান্ড্রয়েড এটিকে সরিয়ে দেবে এবং প্রক্সি খোঁজা ও কানেকশন বন্ধ হয়ে যাবে।"

    override val statusConnected = "টেলিগ্রাম সংযুক্ত"; override val statusConnecting = "সংযুক্ত হচ্ছে…"
    override val statusOffline = "টেলিগ্রাম সংযুক্ত নয়"; override val statusIdle = "টেলিগ্রাম নিষ্ক্রিয়"
    override val nobodyConnected = "কেউ কানেক্টরে সংযুক্ত হয়নি। "; override val howToSetupArrow = "কীভাবে সেট আপ করবেন →"
    override val directModeViaVpn = "সরাসরি মোড: VPN সক্রিয় — প্রক্সি নেই"
    override val directModeOff = "সরাসরি মোড: প্রক্সি বন্ধ"
    override val directDpiSuffix = " · অ্যান্টি-DPI"
    override val connections = "কানেকশন"; override val sockets = "সকেট"; override val speed = "গতি"
    override val traffic = "ট্রাফিক"; override val latency = "লেটেন্সি"
    override fun pcs(n: Int) = "$n টি"
    override fun netNow(label: String) = "নেটওয়ার্ক: $label"
    override fun tgToConnector(n: Int) = "TG→ $n"
    override fun connectorToProxy(n: Int) = "প্রক্সি $n"
    override val trafficSec = "ট্রাফিক · ৬০ সেকেন্ড"; override val trafficMin = "ট্রাফিক · ৬০ মিনিট"
    override val latencySec = "লেটেন্সি · ৬০ সেকেন্ড"; override val latencyMin = "লেটেন্সি · ৬০ মিনিট"
    override val sec60 = "৬০ সেকেন্ড"; override val min60 = "৬০ মিনিট"
    override val unitSec = "সে"; override val unitMin = "মি"; override val unitHour = "ঘ"; override val dash = "—"
    override val currentProxy = "বর্তমান প্রক্সি"; override val noActiveProxy = "কোনো সক্রিয় প্রক্সি নেই (টেলিগ্রাম সংযুক্ত নয়)"
    override val host = "হোস্ট"; override val type = "টাইপ"; override val secret = "সিক্রেট"; override val antiDpi = "অ্যান্টি-DPI"; override val obfEngine = "অবফাসকেশন ইঞ্জিন"
    override fun activeSockets(n: Int) = "সক্রিয় টেলিগ্রাম সকেট: $n"
    override val noConnections = "কোনো সক্রিয় কানেকশন নেই"; override val colHost = "হোস্ট"; override val colTime = "সময়"
    override val modeWord = "মোড"; override val directViaVpnLine = "টেলিগ্রামে সরাসরি অনুরোধ (VPN সক্রিয়)"
    override val connModeHelp = "মোড (VPN, Wi-Fi, LTE, Ethernet, White) আপনাকে স্ক্যান তীব্রতা ভিন্নভাবে সেট করতে এবং আলাদা হোস্ট রেটিং/পরিসংখ্যান রাখতে দেয়। নেটওয়ার্ক কার্ড স্বয়ংক্রিয়ভাবে শনাক্ত হয়; মোড সেটিংসে ম্যানুয়ালি সেট করা যায়।"

    override val scanOff = "স্ক্যান বন্ধ"; override val proxiesInBase = "ডাটাবেসে প্রক্সি"
    override val total = "মোট"; override val alive = "সচল"; override val dead = "অচল"
    override val tgConnectedTitle = "টেলিগ্রাম সংযুক্ত হয়েছে যার মাধ্যমে"; override val successful = "সফল"
    override val socketsHeld = "সকেট আয়ুষ্কাল"; override val over1m = ">১ মিনিট"; override val over5m = ">৫ মিনিট"; override val over15m = ">১৫ মিনিট"
    override val scanCountTitle = "প্রক্সি যাচাইয়ের সংখ্যা"; override val checked = "যাচাই করা হয়েছে"
    override val forAllTime = "সর্বকালীন"; override val perMinute = "প্রতি মিনিট"; override val perHour = "প্রতি ঘণ্টা"
    override val subsCountTitle = "সাবস্ক্রিপশন ডাউনলোডের সংখ্যা"; override val downloaded = "ডাউনলোড হয়েছে"; override val failed = "ব্যর্থ"; override val scanTraffic = "স্ক্যান ট্রাফিক"; override val subTraffic = "সাবস্ক্রিপশন ট্রাফিক"; override val subTrafficGraph = "সাবস্ক্রিপশন ট্রাফিক"
    override val checksMtproto = "MTProto যাচাই (↑ ok · ↓ fail)"

    override fun catalogEmpty(mode: String) = "ক্যাটালগ $mode এখনও খালি। হয় কোনো হোস্ট পাওয়া যায়নি, অথবা অ্যাপটি এই মোডে কখনও চলেনি। আপনি সেটিংসে মোড পরিবর্তন করতে পারেন। বিভিন্ন ধরনের ইন্টারনেট কানেকশনের জন্য আলাদাভাবে হোস্ট সংগ্রহ করতে মোড থাকে।"
    override val aliveShort = "✓ সচল"; override val deadShort = "✗ অচল"
    override val statusLabel = "স্ট্যাটাস"; override val rating = "রেটিং"; override val port = "পোর্ট"
    override val rttPing = "RTT (পিং)"; override val checkedField = "যাচাই করা হয়েছে"; override val okOfTotal = "সফল / মোট যাচাই"
    override val tgConnectedField = "টেলিগ্রাম সংযুক্ত"; override val tgSessions = "টেলিগ্রাম সেশন"; override val trafficThroughProxy = "প্রক্সির মাধ্যমে ট্রাফিক"
    override val sessionsTotal = "মোট সেশন"; override val relayNow = "এখন রিলে"; override val tlsDomain = "TLS ডোমেইন (SNI)"
    override val sourceSub = "উৎস (সাবস্ক্রিপশন)"; override val lastError = "শেষ ত্রুটি"; override val yes = "হ্যাঁ"; override val no = "না"
    override val copyAsLink = "লিংক হিসেবে কপি"; override val openInTelegram = "টেলিগ্রামে হোস্ট খুলুন"; override val makeNextRelay = "পরবর্তী রিলে বানান"
    override val actCopy = "কপি"; override val actOpen = "খুলুন"; override val actRelay = "রিলে"
    override fun agoFmt(v: String) = "$v আগে"
    override val catalogTopFor = "প্রক্সি তালিকা/রেটিং যার জন্য"
    override val catalogModeHelpTitle = "মোড ও রেটিং"
    override val catalogModeHelp = "অ্যাপটি প্রতিটি নেটওয়ার্ক মোডের (VPN, Wi-Fi, LTE, Ethernet ও White) জন্য সচল হোস্ট ও তাদের রেটিং আলাদাভাবে গণনা করে। «White» হোয়াইটলিস্টের জন্য একটি আলাদা ম্যানুয়াল মোড; অটো কখনও এতে স্যুইচ করে না। তাই একই হোস্ট এক মোডে সচল আর অন্য মোডে অচল হতে পারে।"
    override fun catalogInactiveWarn(section: String, active: String) =
        "আপনি নিষ্ক্রিয় অংশ $section দেখছেন — এই মুহূর্তে সব পরিসংখ্যান $active-এ যাচ্ছে, এখানে নয়।"
    override val manageModeTitle = "মোড পরিচালনা"
    override val manageResetRating = "রেটিং রিসেট"
    override fun manageResetHint(mode: String) = "বিশেষভাবে $mode-এর জন্য আপনি সচল হোস্টের রেটিং ও ব্যবহার পরিসংখ্যান রিসেট করতে পারেন। এটি কাজে লাগে যখন আপনি মৌলিকভাবে ভিন্ন কোনো VPN বা LTE-তে সংযুক্ত হয়েছেন, যাতে পুরোনো পরিসংখ্যান বাধা না দেয়। অথবা প্রক্সি স্ক্যান কত দ্রুত সবকিছু নতুন করে যাচাই করে তা দেখার জন্য।"
    override val manageDeleteAll = "হোস্ট মুছুন যেখানে"
    override fun manageDeleteHint(mode: String) = "আপনি $mode থেকে রেটিং এবং হোস্ট উভয়ই মুছে ফেলতে পারেন। \"প্রক্সি স্ক্যান\" ফিচার সেগুলো আবার সংগ্রহ করবে। এটি সাবস্ক্রিপশন রিসেট নয় — আপনি এটি ট্যাপ করতে পারেন, তারপর রিস্ক্যানের জন্য ~১৫ মিনিট অপেক্ষা করুন।"
    override fun manageCopyFrom(mode: String) = "অন্য একটি মোড থেকে এই মোডে ($mode) সব হোস্ট ও রেটিং কপি করুন:"
    override val live = "সচল"; override val deadW = "অচল"; override val unitMs = "ms"
    override val agoMin = "মি"; override val agoHour = "ঘ"; override val agoDay = "দি"

    override val connectTelegram = "টেলিগ্রাম সংযুক্ত করা হচ্ছে"; override val readCarefully = "মনোযোগ দিয়ে পড়ুন!"
    override val guideIntro = "এই অ্যাপটি সেট আপ ছাড়া কাজ করবে না। নিচের ৩টি বিকল্পের যেকোনো একটি বেছে নিন " +
        "এবং নির্দেশনা মনোযোগ দিয়ে অনুসরণ করুন।"
    override val variant1 = "বিকল্প #১ — বাটন"
    override val variant1Body = "\"Proxy {A}\" ট্যাপ করুন — টেলিগ্রাম খুলবে, প্রক্সি যোগ করা নিশ্চিত করুন। এই " +
        "স্ক্রিনে ফিরে এসে \"Proxy {B}\" ট্যাপ করুন — দ্বিতীয়বার যোগ করা নিশ্চিত করুন।\n\nটেলিগ্রামে অন্য যেকোনো " +
        "পুরোনো প্রক্সি বন্ধ করুন। ঠিক ২টি প্রক্সি থাকতে হবে — পোর্ট {A} এবং {B} সহ। " +
        "অন্য কোনো সেট দিয়ে AutoConnector কাজ করবে না।"
    override val variant2 = "বিকল্প #২ — লিংক"
    override val variant2Body = "নিচের টেক্সটটি টেলিগ্রামের Saved Messages-এ (বা যেকোনো চ্যাটে) কপি করুন — " +
        "অর্থাৎ নিজেকে পাঠান। আপনার বার্তায় প্রথম লিংকটি ট্যাপ করুন — প্রথম প্রক্সি যোগ হবে। " +
        "দ্বিতীয় লিংক ট্যাপ করুন — দ্বিতীয়টি যোগ হবে। তারপর সব পুরোনো প্রক্সি বন্ধ করুন।"
    override val variant3 = "বিকল্প #৩ — ম্যানুয়ালি"
    override val variant3Body = "ম্যানুয়ালি একটি SOCKS5 প্রক্সি যোগ করুন: সার্ভার localhost (127.0.0.1), পোর্ট {A}। " +
        "তারপর একটি দ্বিতীয় প্রক্সি: localhost, পোর্ট {B}। যেকোনো পুরোনো প্রক্সি মুছুন।"
    override val whatNext = "এরপর কী?"
    override val whatNextBody = "টেলিগ্রামে \"auto-switch proxy\" চালু করুন — ৫ সেকেন্ড। আপনি একটি প্রক্সি " +
        "(টেলিগ্রামের ভেতরে) ম্যানুয়ালি ট্যাপ করে টেলিগ্রামকে সংযুক্ত হতে সাহায্য করতে পারেন যেটি সক্রিয় নয় বা " +
        "\"unavailable\" চিহ্নিত — এতে টেলিগ্রাম সংযুক্ত হতে আরও বেশি চেষ্টা করে।\n\nনিশ্চিত করুন অন্য সব পুরোনো " +
        "প্রক্সি সরানো হয়েছে, {A} এবং {B} ছাড়া। টেলিগ্রামে " +
        "\"Use proxy\" ট্যাপ করুন।\n\nঅ্যাপটি পর্যাপ্ত প্রক্সি খুঁজে ও ডাউনলোড করার সময় অপেক্ষা করুন " +
        "(৫–১৫ মিনিট)। তারপর টেলিগ্রাম নিজেই AutoConnector-এ সংযুক্ত হয়, যা " +
        "টেলিগ্রামকে সেরা প্রক্সির মাধ্যমে রুট করতে থাকবে: যাচাইকৃত, সচল এবং দ্রুত।\n\nনির্দেশনা যদি " +
        "কঠিন মনে হয় — দুঃখিত, আপনি অ্যাপটি ব্যবহার করতে পারবেন না: সবকিছু স্বয়ংক্রিয়ভাবে সেট আপ করা " +
        "অসম্ভব, এবং সচল প্রক্সি খুঁজতে সময় লাগে।\n\nআপনি যদি অনেক আগে অ্যাপটি ডাউনলোড করে থাকেন " +
        "এবং কোনো সচল প্রক্সি না পাওয়া যায় — অ্যাপ বা সাবস্ক্রিপশন তালিকা যেকোনো একটি আপডেট করুন। এই অ্যাপ " +
        "নিজের কোনো প্রক্সি উদ্ভাবন বা সরবরাহ করে না, এটি কেবল কয়েক ডজন " +
        "গ্রুপ ও পেজ জুড়ে ইন্টারনেটে খোঁজে।"
    override fun proxyBtn(port: Int) = "Proxy $port"

    override val setupPortsTitle = "টেলিগ্রামে পোর্ট সেট আপ করুন"
    override val setupPortsSub = "কীভাবে টেলিগ্রামকে কানেক্টরে সংযুক্ত করবেন (পোর্ট 55001/55002)"
    override val settings = "সেটিংস"; override val settingsSub = "পোর্ট, অ্যান্টি-DPI, স্ক্যান, নেটওয়ার্ক, ব্যাটারি"
    override val subscriptions = "সাবস্ক্রিপশন"; override val subscriptionsSub = "স্ক্যান করার জন্য প্রক্সি উৎস"
    override val statistics = "পরিসংখ্যান"; override val statisticsSub = "প্রক্সি ডাটাবেস + অ্যান্টি-DPI কৌশল"
    override val export = "এক্সপোর্ট"; override val exportSub = "সচল প্রক্সির tg:// লিংক"
    override val about = "সম্পর্কে"; override val aboutSub = "সংস্করণ, বিল্ড, ডাউনলোড, প্রতিক্রিয়া"
    override val hotkeys = "হটকি"
    override val hotkeysSub = "গ্লোবাল কি: প্রক্সি কপি / খুলুন"
    override val hotkeysIntro = "গ্লোবাল হটকি অ্যাপ উইন্ডো ফোকাসে না থাকলেও কাজ করে। এগুলো পুল থেকে " +
        "একটি র‍্যান্ডম সচল প্রক্সি লিংক (tg://) বেছে নেয় — অ্যাপ না খুলে দ্রুত প্রক্সি " +
        "স্যুইচ করার জন্য সুবিধাজনক।"
    override val hotkeysNote = "macOS-এ, কি ক্যাপচার করার জন্য Accessibility অনুমতি প্রয়োজন হতে পারে " +
        "(System Settings → Privacy & Security → Accessibility)।"
    override val hotkeyCopyTitle = "প্রক্সি লিংক কপি"
    override val hotkeyCopyDesc = "একটি র‍্যান্ডম সচল tg:// লিংক ক্লিপবোর্ডে রাখে।"
    override val hotkeyEnable = "হটকি চালু করুন"; override val hotkeyLetterLabel = "অক্ষর"; override val hotkeySet = "সেট"; override val hotkeyReset = "রিসেট"
    override val hotkeyOpenTitle = "টেলিগ্রামে প্রক্সি খুলুন"
    override val hotkeyOpenDesc = "একটি র‍্যান্ডম সচল লিংক খোলে — টেলিগ্রাম এটি ধরে এবং প্রক্সি সংযুক্ত করার প্রস্তাব দেয়।"

    override val relayPorts = "রিলে পোর্ট"
    override val relayPortsHelp = "কানেক্টর যে লোকাল পোর্টে শোনে। আপনি এগুলোই টেলিগ্রামে " +
        "একটি SOCKS5 প্রক্সি হিসেবে দেন (127.0.0.1 : পোর্ট)। নির্ভরযোগ্যতার জন্য দুটি পোর্ট ব্যবহার হয় — টেলিগ্রাম " +
        "উভয়ের সাথে কানেকশন ধরে রাখে।"
    override val portA = "পোর্ট A"; override val portB = "পোর্ট B"
    override val antiDpiTrick = "অ্যান্টি-DPI কৌশল"
    override val antiDpiHelp = "কানেকশনকে ছদ্মবেশ দেওয়ার একটি উপায় যাতে ISP/DPI এটি চিনতে এবং " +
        "ব্লক করতে না পারে।\n• \"Auto-rotate\" নিজেই একটি কার্যকর কৌশল বেছে নেয়।\n• \"No DPI tricks\" — একটি সাধারণ " +
        "কানেকশন।\n• বাকিগুলো নির্দিষ্ট কৌশল (ব্রাউজার অনুকরণ, প্যাকেট বিভাজন ইত্যাদি)।"
    override val onlyFakeTls = "শুধু FakeTLS (ee)"
    override val applyDpiTo = "অ্যান্টি-DPI প্রয়োগ করুন"
    override val applyDpiHelp = "নির্বাচিত অ্যান্টি-DPI কৌশল কোথায় প্রয়োগ করবেন:\n• টেলিগ্রাম রিলে — কানেক্টরের মাধ্যমে " +
        "সচল টেলিগ্রাম কানেকশনে।\n• প্রক্সি প্রোব — ব্যাকগ্রাউন্ড প্রক্সি যাচাইয়ে " +
        "(তখন একটি যাচাই ঠিক একটি বাস্তব কানেকশনের মতো আচরণ করে, এবং কৌশলের পরিসংখ্যান আরও নির্ভুল হয়)।\n" +
        "• সরাসরি সংযুক্ত হলে — যখন প্রক্সি বন্ধ থাকে (বা VPN চালু থাকায় এড়ানো হয়) এবং টেলিগ্রাম " +
        "সরাসরি তার সার্ভারে যায়: এখানে কোনো প্রক্সি নেই, তাই কৌশলটি কেবল " +
        "প্রথম TCP প্যাকেটকে (হ্যান্ডশেক) কয়েকটি ছোট সেগমেন্টে বিভক্ত করায় সীমাবদ্ধ থাকে যাতে DPI একবারে এটি মেলাতে না পারে।"
    override val toRelay = "টেলিগ্রাম রিলে"; override val toProbes = "প্রক্সি প্রোব"
    override val toDirect = "সরাসরি সংযুক্ত হলে"
    override val vpnSection = "VPN চালু থাকলে"
    override val vpnHelp = "ডিভাইসে VPN সক্রিয় থাকলে কী করতে হবে:\n• MTProto প্রক্সির মাধ্যমে — " +
        "টেলিগ্রাম যথারীতি পাওয়া প্রক্সির মাধ্যমে যায় (VPN-এর উপরে)।\n• সরাসরি — " +
        "কানেক্টর প্রক্সি ব্যবহার করে না এবং টেলিগ্রামকে সরাসরি টেলিগ্রামের সার্ভারে সংযুক্ত করে: " +
        "VPN ইতিমধ্যে অ্যাক্সেস দেয়, অতিরিক্ত প্রক্সি স্তর প্রয়োজন নেই (দ্রুত ও আরও স্থিতিশীল)। " +
        "VPN ছাড়া প্রক্সি যথারীতি ব্যবহৃত হয়।"
    override val linkFormat = "প্রক্সি লিংক ফরম্যাট"
    override val linkFormatHelp = "কীভাবে প্রক্সি কপি ও খুলবেন। tg:// সরাসরি টেলিগ্রাম খোলে (Telegram Desktop ইনস্টল থাকা প্রয়োজন)। http (t.me) ব্রাউজারের মাধ্যমে খোলে এবং টেলিগ্রামে খোলার প্রস্তাব দেয় — tg:// নিবন্ধিত না থাকলে সুবিধাজনক।"
    override val linkTg = "tg:// (সরাসরি টেলিগ্রাম খুলুন)"; override val linkTgSub = "tg://proxy?… — টেলিগ্রাম খোলে"
    override val linkHttp = "http (t.me, ব্রাউজারের মাধ্যমে)"; override val linkHttpSub = "https://t.me/proxy?… — ব্রাউজার খোলে"
    override val viaMtproto = "MTProto-এর মাধ্যমে প্রক্সি"; override val viaMtprotoSub = "VPN থাকলেও, ট্রাফিক প্রক্সির মাধ্যমে যায়"
    override val directly = "সরাসরি সংযুক্ত হন"; override val directlySub = "VPN সক্রিয় থাকলে — প্রক্সি এড়িয়ে, সরাসরি টেলিগ্রামে"
    override val notifications = "নোটিফিকেশন"
    override val scanCheck = "স্ক্যান ও যাচাই"
    override val scanCheckHelp = "• স্ক্যান, মিনিট — সাবস্ক্রিপশন থেকে কত ঘন ঘন প্রক্সি তালিকা ডাউনলোড করতে হবে।\n" +
        "• যাচাই, মিনিট — সচলতার জন্য ডাটাবেসের প্রক্সি কত ঘন ঘন পুনরায় যাচাই করতে হবে।\n• ব্যাচ আকার — " +
        "প্রতি রানে কতটি প্রক্সি যাচাই করতে হবে।\n• সমান্তরাল — একসাথে কতটি যাচাই চালাতে হবে (বেশি = " +
        "দ্রুত, কিন্তু নেটওয়ার্ক ও ব্যাটারিতে বেশি চাপ)।"
    override val scanMin = "স্ক্যান, মিনিট"; override val checkMin = "যাচাই, মিনিট"; override val batchSize = "ব্যাচ আকার"; override val parallel = "সমান্তরাল"
    override val speedByNet = "নেটওয়ার্ক অনুযায়ী স্ক্যান তীব্রতা"
    override val speedByNetHelp = "বর্তমান নেটওয়ার্কের উপর নির্ভর করে কত ঘন ঘন প্রক্সি যাচাই করতে হবে। " +
        "\"স্ট্যান্ডার্ড\" = বেস ইন্টারভ্যাল। আরও কম ঘন ঘন (ধীর, ট্রাফিক/ব্যাটারির প্রতি কোমল) করতে ডানে সরান, " +
        "আরও ঘন ঘন (দ্রুত, আরও আক্রমণাত্মক) করতে বামে। লগারিদমিক স্কেল, প্রতিদিকে ×১০০ পর্যন্ত।\n" +
        "• VPN — যখন বাহ্যিক VPN সক্রিয় থাকে।\n• Wi-Fi — Wi-Fi নেটওয়ার্কে।\n• LTE — মোবাইল নেটওয়ার্কে।"
    override val intensStandard = "স্ট্যান্ডার্ড"
    override val intensSlower = "ধীর"
    override val intensFaster = "দ্রুত"
    override val maintenance = "ডেটা রিসেট"
    override val maintenanceHelp = "• \"ক্যাটালগ ও পরিসংখ্যান রিসেট\" — রেটিং, কাউন্টার, ট্রাফিক " +
        "ও যাচাই লগ শূন্য করে, কিন্তু ডাউনলোড করা হোস্ট ও সাবস্ক্রিপশন রাখে (পরবর্তী স্ক্যানে সবকিছু " +
        "পুনরায় রেট করা হয়)।\n• \"ডাউনলোড করা হোস্ট মুছুন\" — পুরো প্রক্সি পুল মুছে দেয় কিন্তু " +
        "সাবস্ক্রিপশন রাখে যাতে স্ক্যান পুল আবার ভরে। যেভাবেই হোক সাবস্ক্রিপশন কখনও স্পর্শ করা হয় না।"
    override val backupTitle = "এক্সপোর্ট / ইম্পোর্ট"
    override val backupHelp = "একটি একক JSON ফাইলে অ্যাপ ডেটা সংরক্ষণ বা পুনরুদ্ধার করুন। কী " +
        "অন্তর্ভুক্ত করবেন টিক দিন — যেকোনো সমন্বয়:\n• সেটিংস — সব অ্যাপ প্যারামিটার।\n• সাবস্ক্রিপশন — উৎস " +
        "তালিকা (URL + চালু/বন্ধ)।\n• সচল-হোস্ট ক্যাটালগ — প্রতি নেটওয়ার্ক মোড অনুযায়ী রেটিং ও পরিসংখ্যান " +
        "সহ প্রতিটি সচল প্রক্সি।\n\n«এক্সপোর্ট» কোথায় সংরক্ষণ করবে জিজ্ঞেস করে; «ইম্পোর্ট» কোন ফাইল খুলবে জিজ্ঞেস করে এবং " +
        "এতে থাকা শুধু টিক করা অংশগুলো প্রয়োগ করে। ইম্পোর্ট বর্তমান ডেটার সাথে যোগ করে (কিছু মোছে না)।"
    override val backupSettings = "সেটিংস"
    override val backupSubs = "সাবস্ক্রিপশন"
    override val backupHosts = "সচল-হোস্ট ক্যাটালগ (প্রতি মোড)"
    override val exportWord = "এক্সপোর্ট"
    override val importWord = "ইম্পোর্ট"
    override val eraseAllHosts = "সব হোস্ট মুছুন"
    override val factoryReset = "সবকিছু রিসেট করুন (প্রথম চালুর মতো)"
    override val factoryResetConfirm = "অ্যাপটি সম্পূর্ণরূপে ফ্যাক্টরি অবস্থায় রিসেট করবেন? সব সেটিংস ও সম্পূর্ণ " +
        "হোস্ট ক্যাটালগ মুছে যাবে, সাবস্ক্রিপশন ডিফল্টে পুনরুদ্ধার হবে। ঠিক প্রথম চালুর মতো।"
    override val resetCatalog = "ক্যাটালগ ও পরিসংখ্যান রিসেট"
    override val resetCatalogConfirm = "সব রেটিং, কাউন্টার ও যাচাই লগ শূন্য করবেন? " +
        "ডাউনলোড করা হোস্ট ও সাবস্ক্রিপশন রাখা হয় এবং পরবর্তী স্ক্যানে পুনরায় রেট করা হয়।"
    override val clearHosts = "ডাউনলোড করা হোস্ট মুছুন"
    override val clearHostsConfirm = "ডাউনলোড করা হোস্টের (প্রক্সি) সম্পূর্ণ তালিকা মুছবেন? " +
        "সাবস্ক্রিপশন রাখা হয় এবং স্ক্যান পুল আবার ভরবে।"
    override val doReset = "রিসেট"
    override val doCancel = "বাতিল"
    override val adaptiveSpeed = "অ্যাডাপটিভ গতি"
    override val adaptiveHelp = "সচলতা যাচাই একটি বেস ইন্টারভ্যালে চলে (\"স্ক্যান ও যাচাই\" থেকে, নেটওয়ার্ক " +
        "গুণক দিয়েও গুণিত)। \"অ্যাডাপটিভ গতি\" বর্তমানে কতটি প্রক্সি সচল তার উপর ভিত্তি করে এগুলোকে " +
        "স্বয়ংক্রিয়ভাবে দ্রুত বা ধীর করে।\n\n" +
        "• কম সচল (\"কম\" সীমার নিচে) → ইন্টারভ্যাল × \"গতি-বৃদ্ধি\"। ১-এর নিচের গুণক = আরও " +
        "ঘন ঘন: 0.5 — দ্বিগুণ ঘন ঘন, 0.25 — ৪×। পুল দ্রুত ভরে।\n" +
        "• বেশি সচল (\"বেশি\" সীমার উপরে) → ইন্টারভ্যাল × \"গতি-হ্রাস\"। ১-এর উপরে = আরও কম: 2 — " +
        "অর্ধেক ঘন ঘন, 4 — এক-চতুর্থাংশ। ব্যাটারি ও ট্রাফিক সাশ্রয় করে।\n" +
        "• সীমাগুলোর মাঝে — বেস গতি (×1)।\n\n" +
        "উদাহরণ:\n" +
        "— প্রক্সি দ্রুত সংগ্রহ করুন: \"গতি-বৃদ্ধি\" 0.25 এবং/অথবা \"কম\" সীমা 40।\n" +
        "— যথেষ্ট থাকলে ব্যাটারি সাশ্রয় করুন: \"গতি-হ্রাস\" 8 এবং/অথবা \"বেশি\" সীমা 30।\n" +
        "— অ্যাডাপটেশন বন্ধ করুন: উভয় গুণক 1 সেট করুন।\n\n" +
        "ডিফল্ট: কম 20, গতি-বৃদ্ধি 0.5, বেশি 50, গতি-হ্রাস 4।"
    override val threshMany = "\"বেশি\" সীমা"; override val threshFew = "\"কম\" সীমা"; override val mulFast = "গতি-বৃদ্ধি ×"; override val mulLazy = "গতি-হ্রাস ×"
    override val subIntensityTitle = "সাবস্ক্রিপশন তীব্রতা"
    override val subIntensityHint = "সাবস্ক্রিপশন ডাউনলোডের মধ্যে বিরতি: প্রক্সি তালিকা পুনরায় ডাউনলোড করার আগে কত মিনিট (প্রতি নেটওয়ার্ক মোড অনুযায়ী আলাদা)।"
    override val baseScanTitle = "বেস স্ক্যান গতি"
    override val baseScanHelp = "রেফারেন্স সচলতা-যাচাই গতি। «অ্যাডাপটিভ গতি» এবং «মোড অনুযায়ী " +
        "গতি» গুণকগুলো এর সাপেক্ষে গণনা করা হয়।\n\n" +
        "• কত ঘন ঘন চালাতে হবে, মিনিট — যাচাই পাসের মধ্যে ইন্টারভ্যাল।\n" +
        "• প্রতি থ্রেডে ব্যাচ, হোস্ট — প্রতিটি থ্রেড প্রতি পাসে কতটি হোস্ট যাচাই করে।\n" +
        "• থ্রেড — একসাথে কতটি যাচাই চলে। একটি পাস «ব্যাচ × থ্রেড» হোস্ট প্রোব করে।\n" +
        "• প্রতি N মিনিটের চেয়ে ঘন ঘন কোনো হোস্ট রিস্ক্যান করবেন না — অ্যান্টি-ফ্লাড: সম্প্রতি যাচাই করা হোস্ট " +
        "এই পাসে এড়ানো হয়।\n\n" +
        "বেশি থ্রেড ও বড় ব্যাচ = পুল দ্রুত বাড়ে, কিন্তু নেটওয়ার্ক ও ব্যাটারিতে বেশি চাপ।"
    override val baseScanPeriod = "কত ঘন ঘন চালাতে হবে, মিনিট"
    override val baseScanBatch = "প্রতি থ্রেডে ব্যাচ, হোস্ট"; override val baseScanThreads = "থ্রেড সংখ্যা"
    override val adaptiveDesc = "সচল প্রক্সি «কম»-এর চেয়ে কম বা «বেশি»-এর চেয়ে বেশি হলে, একটি অতিরিক্ত গুণক প্রয়োগ করুন।"
    override val fewWord = "কম"; override val manyWord = "বেশি"
    override fun fasterX(x: String) = "$x× দ্রুত"
    override fun slowerX(x: String) = "$x× ধীর"
    override fun ifAliveLt(n: Int) = "সচল প্রক্সি < $n হলে, তবে:"
    override fun ifAliveGt(n: Int) = "সচল প্রক্সি > $n হলে, তবে:"
    override val disabledWord = "বন্ধ"
    override val speedByModeTitle = "মোড অনুযায়ী গতি"
    override val speedByModeHelp = "প্রতিটি নেটওয়ার্ক মোডের জন্য বেস গতির উপরে একটি স্ক্যান-গতি গুণক। " +
        "«স্ট্যান্ডার্ড» (×1) = বেস ইন্টারভ্যাল। ডান — আরও কম (ধীর, ট্রাফিক/" +
        "ব্যাটারির প্রতি কোমল), বাম — আরও ঘন ঘন (দ্রুত, আরও আক্রমণাত্মক)। লগারিদমিক স্কেল, প্রতিদিকে ×১০০ " +
        "পর্যন্ত।\n\n" +
        "প্রতিটি স্লাইডারের নিচে অ্যাডাপটিভ গতি প্রয়োগসহ ফলাফল পাস প্যারামিটার আছে — " +
        "«কম সচল» (× «গতি-বৃদ্ধি») এবং «বেশি সচল» (× «গতি-হ্রাস») এর জন্য আলাদাভাবে দেখানো হয়।\n\n" +
        "মোড:\n• VPN — একটি বাহ্যিক VPN সক্রিয়।\n• LTE — মোবাইল নেটওয়ার্ক।\n• Wi-Fi — Wi-Fi নেটওয়ার্ক।\n" +
        "• Ethernet — তারযুক্ত কানেকশন।\n• White — ম্যানুয়াল «white» প্রক্সি মোড।"
    override val aliveLt = "সচল <"; override val aliveGt = "সচল >"
    override val periodWord = "পিরিয়ড"; override val nonstopWord = "নিরবচ্ছিন্ন"
    override val batchWord = "ব্যাচ"; override val threadsWord = "থ্রেড"; override val scanModeOff = "স্ক্যান বন্ধ"
    override val netBattery = "নেটওয়ার্ক ও ব্যাটারি"
    override val netBatteryHelp = "• শুধু Wi-Fi — মোবাইল নেটওয়ার্কে স্ক্যান করবেন না (ডেটা সাশ্রয়)।\n• শুধু " +
        "চার্জিং — শুধু ফোন চার্জ হওয়ার সময় কাজ করুন।\n• ব্যাটারি কম হলে এড়িয়ে যান — " +
        "ব্যাটারি কম হলে স্ক্যান বিরতি দিন।"
    override val onlyWifi = "শুধু Wi-Fi"; override val onlyCharging = "শুধু চার্জিং"; override val skipLowBattery = "ব্যাটারি কম হলে এড়িয়ে যান"
    override val autosaved = "সেটিংস স্বয়ংক্রিয়ভাবে সংরক্ষিত হয়।"
    override val dpiAutoLabel = "DPI কৌশল অটো-রোটেট"; override val dpiNoneLabel = "কোনো DPI কৌশল নয় (সাধারণ)"
    override val experimental = "পরীক্ষামূলক"
    override val experimentalHelp = "MTProto আপস্ট্রিমের বিকল্প প্রক্সিং ইঞ্জিন এবং একটি ডায়াগনস্টিক লগ। " +
        "«বন্ধ» সেট করা থাকলে রেফারেন্স (কার্যকর) পথ অপরিবর্তিত থাকে। শুধু এনক্রিপ্টেড স্ট্রিম আপস্ট্রিম TCP সকেটে " +
        "কীভাবে লেখা হয় তা পরিবর্তিত হয় (সেগমেন্ট আকার, টাইমিং, TLS-রেকর্ড সীমানা) — স্ট্রিম নিজে বাইট-বাই-বাইট অভিন্ন থাকে। " +
        "শুধু সচল প্রক্সি রিলেতে প্রযোজ্য (প্রোব নয়, সরাসরি পথ নয়)।"
    override val expEngineTitle = "প্রক্সিং ইঞ্জিন (সকেট অবফাসকেশন)"
    override val expConnectTitle = "কানেক্ট ইঞ্জিন (আপস্ট্রিম নির্বাচন)"
    override val raceWidthTitle = "সমান্তরাল কানেক্ট"
    override val connectionSection = "কানেকশন ও ব্লক বাইপাস"
    override val connectionSectionHelp = "কানেক্ট ইঞ্জিন, সমান্তরাল আপস্ট্রিম, প্রক্সিং ইঞ্জিন এবং অ্যান্টি-DPI কৌশল — সবই এক বিভাগে।"
    override val netLogSection = "নেটওয়ার্ক বিনিময় লগ"
    override val expEngineWarn = "⚠ পরীক্ষামূলক মোড। সংযোগ খারাপ হলে, «বন্ধ (রেফারেন্স পথ)»-এ ফিরে যান।"
    override val netLog = "নেটওয়ার্ক-বিনিময় লগ চালু করুন"
    override val netLogSub = "কে-কাকে-কখন এবং প্যাকেট আকার একটি ফাইলে লেখে (কোনো পেলোড ডেটা নয়) — " +
        "VPN সহ ও VPN ছাড়া বিনিময় প্যাটার্ন তুলনা করতে।"
    override val openLogFolder = "লগ ফোল্ডার খুলুন"; override val copyPath = "পাথ কপি"
    override val helpShow = "সাহায্য"; override val helpHide = "সাহায্য লুকান"
    override val quickSwitchIntro = "এখানে আপনি একটি ব্লক-বাইপাস কৌশল বেছে নিতে পারেন। টেলিগ্রাম যদি ত্রুটি দেখায় " +
        "“The proxy you are using is not configured correctly and will be disabled. Please find another " +
        "one”, তাহলে কোন ট্রাফিক-অবফাসকেশন টাইপ কাজ করে তা নিয়ে পরীক্ষা করুন যাতে টেলিগ্রাম এটি দেখানো বন্ধ করে। " +
        "split* মোড দিয়ে শুরু করুন। coalesce* মোডও কাজ করে, কিন্তু এগুলো দিয়ে টেলিগ্রামে ছবি/ভিডিও খারাপভাবে লোড হয়।"
    override val quickSwitchTitle ="ব্লক বাইপাস"; override val quickSwitchSub = "শেপিং, কানেক্ট, অ্যান্টি-DPI"

    override val sourceUrl = "উৎস URL"
    override fun sourceAlive(alive: Int, total: Int) = "সচল $alive/$total"
    override val open = "খুলুন"; override val active = "সক্রিয়"; override val inactive = "নিষ্ক্রিয়"
    override val lastDownloaded = "ডাউনলোড হয়েছে"; override val notDownloaded = "এখনও ডাউনলোড হয়নি"
    override fun sourceCounts(dead: Int, total: Int) =
        " সচল, $dead অচল, $total মোট"

    override val proxyBase = "প্রক্সি ডাটাবেস"
    override val totalInBase = "ডাটাবেসে মোট"; override val aliveNow = "এখন সচল"; override val deadStat = "অচল"
    override val aliveIn15 = "১৫ মিনিটে সচল"; override val checksAllTime = "সর্বকালীন যাচাই"
    override val antiDpiTricks = "অ্যান্টি-DPI কৌশল"; override val noStatsYet = "এখনও কোনো ডেটা নেই — যাচাই/কানেকশন হওয়ার সাথে সাথে কৌশল জমা হয়"
    override val attempts = "প্রচেষ্টা"; override val handshake = "হ্যান্ডশেক"; override val score = "স্কোর"
    override val tgConnect = "TG কানেক্ট"; override val socketsOver1m = "সকেট >১মিনিট"
    override val over10kb = "সকেট >10KB"; override val over100kb = ">100KB"; override val workTime = "কাজের সময়"
    override val statsLegend = "হ্যান্ডশেক — সফল হ্যান্ডশেক (প্রচেষ্টার %) · স্কোর — মান · " +
        "\"কাজের সময়\" — ≥5KB এবং ১ মিনিটের বেশি দীর্ঘ সকেটগুলোর মোট।"
    override val resetStats = "কৌশল পরিসংখ্যান রিসেট"

    override fun aliveLinks(n: Int) = "সচল লিংক: $n"
    override val copyAll = "সব কপি"
    override val openRandom = "র‍্যান্ডম খুলুন"; override val copyRandom = "র‍্যান্ডম কপি"; override val allShort = "সব"
    override val copyTop = "TOP কপি"; override val randomHost = "র‍্যান্ডম হোস্ট"
    override val exportToFile = "ফাইলে এক্সপোর্ট"; override val exportSaved = "ফাইলে সংরক্ষিত:"
    override val dlNow = "এখন ডাউনলোড"
    override fun downloadingFmt(sec: Long) = "ডাউনলোড হচ্ছে… ${sec}s"
    override val cancel = "বাতিল"
    override val deleteConfirmTitle = "সাবস্ক্রিপশন মুছবেন?"
    override val subscriptionsAddHint = "সাবস্ক্রিপশন বা প্রক্সি লিংক যোগ করুন →"
    override val addSourcesTitle = "যোগ করুন"
    override val addSubsLabel = "সাবস্ক্রিপশন (প্রতি লাইনে একটি URL)"
    override val addSubsHelp = "একটি বৈধ URL সহ প্রতিটি লাইন তার নিজস্ব সাবস্ক্রিপশন হয়ে যায় এবং পর্যায়ক্রমে আনা হয়।"
    override val addProxiesLabel = "প্রস্তুত প্রক্সি লিংক (নির্দিষ্ট তালিকা)"
    override val addProxiesHelp = "নির্দিষ্ট প্রক্সির লিংকের একটি ব্যাচ পেস্ট করুন (tg://proxy, https://t.me/proxy, …)। এটি সাবস্ক্রিপশন নয় — তালিকাটি কখনও ডাউনলোড হয় না, প্রক্সিগুলো কেবল ক্যাটালগে যোগ করা হয়।"
    override val addButton = "যোগ করুন"
    override fun addedFmt(subs: Int, proxies: Int) = "যোগ হয়েছে: $subs সাবস্ক্রিপশন, $proxies প্রক্সি"
    override val perSecond = "প্রতি সেকেন্ড"
    override val graphSpeed = "গতি"
    override val graphVolume = "ভলিউম"
    override val graphLatency = "পিং"
    override val graphConnects = "কানেক্ট"
    override val scanNow = "এখন স্ক্যান"; override val scanOnShort = "স্ক্যান চালু"
    override val scanRunning = "স্ক্যান চলছে"; override val scanIdle = "স্ক্যান নিষ্ক্রিয়"; override val scanOffState = "স্ক্যান বন্ধ"; override val scanBatchPerThread = "ব্যাচ/থ্রেড"; override val scanPassHosts = "পাসে হোস্ট"; override val minRescanLabel = "প্রতি N মিনিটের চেয়ে ঘন ঘন কোনো হোস্ট রিস্ক্যান করবেন না"
    override val scanPlanTitle = "পরিকল্পনা"; override val scanNowTitle = "এখন"; override val currentScheduleTitle = "বর্তমান শিডিউল"
    override val scheduleWord = "শিডিউল"; override val unitPcsPerSec = "টি/সে"
    override val scanNowThreadsLabel = "এখন চলমান থ্রেড"; override val scanNowPerThreadLabel = "প্রতি থ্রেডে যাচাই (পরিকল্পনা)"; override val scanNowElapsedLabel = "চলমান সময়"
    override val scanOkGraph = "সফল স্ক্যান"; override val scanFailGraph = "ব্যর্থ স্ক্যান"; override val scanTrafficGraph = "স্ক্যান ট্রাফিক"; override val scanAliveGraph = "মোট সচল প্রক্সি"; override val scanPingGraph = "পিং"; override val threadsGraph = "থ্রেড"
    override val scanEvery = "প্রতি"; override val scanNextRun = "পরবর্তী রান"
    override val scanThreads = "থ্রেড"; override val scanBatch = "ব্যাচ"
    override val scanElapsed = "চলমান"; override val scanIdleNow = "—"
    override val effForFew = "যখন কম"; override val effForMany = "যখন বেশি"
    override val effCheck = "যাচাই"; override val effBatch = "ব্যাচ"; override val effPar = "সমান্তরাল"
    override val effContinuous = "নিরবচ্ছিন্ন"; override val secShort = "সে"; override val minShort = "মিনিট"

    override val appTagline = "ক্রস-প্ল্যাটফর্ম অটো-কানেক্টর: এটি MTProto প্রক্সি খুঁজে, যাচাই করে ও চালায় " +
        "যেগুলোর মাধ্যমে টেলিগ্রাম কাজ করে।"
    override val version = "সংস্করণ"; override val buildDate = "বিল্ড তারিখ"; override val platform = "প্ল্যাটফর্ম"
    override val downloadSources = "ডাউনলোড ও উৎস"; override val openOnGithub = "GitHub-এ খুলুন"
    override val feedbackBugs = "প্রতিক্রিয়া ও বাগ রিপোর্ট"; override val writeTelegram = "টেলিগ্রামে লিখুন"

    override val language = "ভাষা"; override val langAuto = "স্বয়ংক্রিয় (সিস্টেম)"; override val langRu = "Русский"; override val langEn = "English"
    override val langFa = "فارسی"; override val langZh = "简体中文"; override val langAr = "العربية"; override val langUr = "اردو"
    override val langTr = "Türkçe"; override val langId = "Bahasa Indonesia"; override val langHi = "हिन्दी"; override val langBn = "বাংলা"; override val langMy = "မြန်မာ"
    override val langWord = "ভাষা"

    override val scanModeTitle = "নেটওয়ার্ক মোড"; override val scanModeAuto = "অটো"; override val scanModeManualLabel = "ম্যানুয়াল"
    override val activeModeLabel = "সক্রিয় মোড"; override val formingListLabel = "তালিকা তৈরি হচ্ছে"; override val catalogModeTabs = "মোড"
    override val resetModeRatings = "হোস্ট রেটিং রিসেট"; override val forgetModeHosts = "মোড হোস্ট ভুলে যান"
    override val exportModeTitle = "মোড অনুযায়ী এক্সপোর্ট"; override val modePickerTitle = "মোড"
    override val modeHelp = "প্রতিটি নেটওয়ার্ক মোড তার নিজস্ব প্রক্সি রেটিং এবং নিজস্ব স্ক্যান + সাবস্ক্রিপশন-ডাউনলোড তীব্রতা রাখে। «অটো» সক্রিয় নেটওয়ার্ক থেকে মোড বেছে নেয়। «ম্যানুয়াল» আপনাকে নিজে যেকোনো মোড বেছে নিতে দেয় (White সহ, যা অটো কখনও নির্বাচন করে না)।"
    override val autoSelect = "অটো নির্বাচন"; override val manualSelect = "ম্যানুয়াল নির্বাচন"
    override val connStatsTitle = "এখন কানেকশন"; override val connOnPort = "পোর্টে কানেকশন"; override val outgoingConns = "বহির্গামী কানেকশন"
    override val modeChoice = "মোড নির্বাচন"; override val autoChoice = "অটো-নির্বাচন"; override val manualChoice = "ম্যানুয়াল নির্দিষ্ট"
    override val directOnVpn = "VPN-এ TG-তে সরাসরি কানেক্ট"; override val onWord = "চালু"; override val offWord = "বন্ধ"
    override val directStateActive = "সক্রিয়"; override val directStateOff = "সেটিংসে বন্ধ"; override val directStateIdle = "সেটিংসে চালু, কিন্তু সক্রিয় নয়"
    override val wpHintTitle = "White কী?"
    override val wpHint = "White — WhitePages: একটি ম্যানুয়াল নেটওয়ার্ক প্রোফাইল। শুধু হাতে চালু করা হয় (অটো-নির্বাচন কখনও এটি বেছে নেয় না)। " +
        "নিজস্ব হোস্ট রেটিং রাখে, সাবস্ক্রিপশন ডাউনলোড করে এবং VPN/Wi-Fi/LTE থেকে স্বাধীনভাবে স্ক্যান করে।"

    override val recentAttempts = "সাম্প্রতিক কানেকশন ও যাচাই"
    override val kindCheck = "যাচাই"
    override val kindTg = "টেলিগ্রাম"
    override val histWho = "কে"
    override val histWhen = "কখন"
    override val histReq = "অনুরোধ"
    override val histSess = "সেশন"
    override val histScan = "স্ক্যান"
    override val testNow = "এখন পরীক্ষা করুন"
    override val testShort = "পরীক্ষা"
    override val testResult = "পরীক্ষার ফলাফল"
    override val testStop = "থামান"
    override val testingNow = "পরীক্ষা চলছে…"
    override val prewarmTitle = "সকেট প্রিওয়ার্ম (পরীক্ষামূলক)"
    override val prewarmHelp = "প্রক্সিতে কয়েকটি সকেট আগে থেকে খোলা রাখুন, যাতে নতুন টেলিগ্রাম কানেকশন " +
        "কানেক্ট/হ্যান্ডশেক এড়িয়ে যায়। পরীক্ষামূলক: ব্যাকগ্রাউন্ড অবিরত পুনঃসংযুক্ত হয় → ট্রাফিক ও সামান্য " +
        "CPU খরচ। ভুয়া ট্রাফিক পাঠানো হয় না (এটি বাস্তব সেশন নষ্ট করত) — সকেট কেবল রোটেট হয়। " +
        "FakeTLS প্রক্সির সাথে সবচেয়ে কার্যকর।"
    override val prewarmEnable = "প্রিওয়ার্ম চালু করুন"
    override val prewarmModeDeferred = "বিলম্বিত (শুধু TLS)"
    override val prewarmModeDeferredSub = "TCP + FakeTLS ধরে রাখি; obfuscated2-init ডেটা পাঠানোর সময় পাঠাই। DC কমিট হয় না — সবচেয়ে বাস্তবসম্মত।"
    override val prewarmModeFull = "সম্পূর্ণ হ্যান্ডশেক"
    override val prewarmModeFullSub = "বিভিন্ন DC-তে সম্পূর্ণ সংযুক্ত সকেট ধরে রাখি; শুধু DC/tag মিললে পুনঃব্যবহার করি। কম সময় বাঁচে।"
    override val prewarmPoolLabel = "রিজার্ভ সকেট"
    override val prewarmHoldLabel = "ধরে রাখুন, সে"
    override val prewarmNote = "শুধু রোটেশন (অ্যাপ-স্তরে keepalive নেই)। সকেট কয়েক সেকেন্ড…~এক মিনিট বাঁচে, প্রক্সি/DC-এর উপর নির্ভর করে।"
    override val prewarmStatus = "প্রিওয়ার্ম"
    override fun prewarmStatusVal(ready: Int, holdSecs: Int) = "${ready} প্রস্তুত · ${holdSecs}সে ধরে রাখি"
    override val prewarmStar = "গাঢ় কমলা = প্রিওয়ার্ম পুল থেকে উষ্ণ সকেট দেওয়া হয়েছে (কানেক্ট/হ্যান্ডশেক ছাড়া)"
    override fun prewarmTableTitle(holdSecs: Int) = "সকেট প্রিওয়ার্ম (${holdSecs}সে ধরে রাখি)"
    override val prewarmTableHelp = "«সকেট প্রিওয়ার্ম» প্রক্সিতে কয়েকটি সকেট আগে থেকে খোলে, যাতে নতুন টেলিগ্রাম " +
        "কানেকশন কানেক্ট/হ্যান্ডশেক এড়িয়ে যায়। এই টেবিলে প্রিওয়ার্ম হোস্ট দেখানো হয়: সকেট কত সেকেন্ড " +
        "বাঁচে, টেলিগ্রাম এটি ব্যবহার করছে কিনা, এবং ট্রাফিক। «আরও → সেটিংস → „সকেট প্রিওয়ার্ম (পরীক্ষামূলক)“»-এ " +
        "চালু/বন্ধ ও কনফিগার (মোড, সকেট সংখ্যা, ধরে রাখার সময়) করা যায়।"
    override val prewarmNoneWarming = "এখনও কোনো প্রিওয়ার্ম সকেট নেই"
    override val prewarmColAge = "বয়স"
    override val prewarmColUse = "TG-তে?"
    override val prewarmInUse = "TG-তে"
    override val prewarmNew = "নতুন"
    override val lanShareTitle = "লোকাল নেটওয়ার্কে শেয়ার (ওয়েব পোর্টাল)"
    override val lanShareDesc = "এই Wi-Fi-এর অন্য ডিভাইসগুলোকে এই AutoConnector-কে প্রক্সি হিসেবে ব্যবহার করতে দিন; নিচের ঠিকানায় ব্রাউজার সেরা প্রক্সিসহ একটি পেজ পাবে।"
    override val lanShareUrlsLabel = "নেটওয়ার্ক প্রতিবেশীরা সংযুক্ত হয়:"
    override val lanShareNoIp = "লোকাল নেটওয়ার্কে কোনো ঠিকানা নেই — Wi-Fi-তে সংযুক্ত হন"
    override val lanFirewallTitle = "লোকাল নেটওয়ার্কে অনুমতি দিন"
    override val lanFirewallBody = "চালু করলে রিলে পোর্ট লোকাল নেটওয়ার্কে খুলবে। এখন Windows (বা অন্য) ফায়ারওয়াল জিজ্ঞেস করতে পারে AutoConnector-কে অনুমতি দেবেন কিনা — «অনুমতি দিন»/«হ্যাঁ» বেছে নিন। অস্বীকার করলে, AutoConnector-এ প্রতিবেশীদের ট্রাফিক ব্লক হবে এবং পেজ/প্রক্সি অনুপলব্ধ হবে।"
    override val lanFirewallConfirm = "চালু করুন"
    override val lanInfoTitle = "এটা কেন?"
    override val lanInfoBody = "আপনার Wi-Fi-এর একটিমাত্র কম্পিউটার বা ফোনে AutoConnector চালান — এবং একই নেটওয়ার্কের বাকি সব ডিভাইস, iPhone সহ (যা অ্যাপটি সরাসরি সমর্থন করে না), কেবল ব্রাউজারে ঠিকানাটি খুলে ব্যবহার করতে পারবে: তাদের টেলিগ্রামে যোগ করার জন্য সেরা প্রক্সিসহ একটি পেজ, অথবা এই ডিভাইসটিকেই একটি SOCKS প্রক্সি হিসেবে। একটি ডিভাইস প্রক্সি খুঁজে ও ধরে রাখে, বাকিরা লোকাল নেটওয়ার্কে এটি ব্যবহার করে।"
    override val volTriggerTitle = "ভলিউম বাটন ট্রিগার"
    override val volTriggerSub = "ভলিউম কি-এর দ্রুত প্যাটার্নে প্রক্সি স্যুইচ করা"
    override val volEnableLabel = "ভলিউম বাটন পর্যবেক্ষণ করুন"
    override val volHelpTitle = "এটা কী?"
    override val volHelpBody = "Android-এ গ্লোবাল কীবোর্ড হটকি নেই, তাই ভলিউম বাটন ব্যবহার করা হয়। চালু থাকলে, AutoConnector ব্যাকগ্রাউন্ডে ভলিউম-আপ/ডাউন চাপের দ্রুত প্যাটার্ন পর্যবেক্ষণ করে (যেমন আপ-আপ-ডাউন-ডাউন)। এটি শনাক্ত করে, এটি একটি র‍্যান্ডম ভালো সচল প্রক্সির tg:// লিংক খোলে — টেলিগ্রাম এটি ধরে নেয় এবং স্যুইচ করে। অ্যাপ না খুলে প্রক্সি রোটেট করার একটি দ্রুত অদৃশ্য উপায়। ভলিউম যথারীতি কাজ করে (চাপ ধরে রাখা হয় না)। Accessibility অ্যাক্সেস প্রয়োজন (ব্যাকগ্রাউন্ডে কি পড়তে এবং লিংক খুলতে); চেকবক্স চালু না করা পর্যন্ত কিছুই অনুরোধ করা হয় না। নিচে চাপের মধ্যে সর্বোচ্চ সময় সেট করুন; শনাক্তযোগ্য প্যাটার্ন নিচে তালিকাভুক্ত।"
    override val volGrantTitle = "Accessibility চালু করুন (গুরুত্বপূর্ণ)"
    override val volGrantBody = "Android (বিশেষত 13+) Google Play থেকে নয় এমন অ্যাপের জন্য Accessibility ব্লক করে — তাই AutoConnector ধূসর এবং «অ্যাপের জন্য অ্যাক্সেস নিষিদ্ধ» দেখায়।\n\nকীভাবে আনব্লক করবেন:\n১. «অ্যাপ সম্পর্কে» খুলুন (নিচের বাটন, অথবা: Settings → Apps → AutoConnector for Telegram)।\n২. ⋮ (উপরে ডানে তিন বিন্দু) ট্যাপ করুন → «সীমাবদ্ধ সেটিংস অনুমোদন করুন» → নিশ্চিত করুন।\n৩. ফিরে যান: Settings → Accessibility → AutoConnector for Telegram → চালু করুন।\n\nযদি «সীমাবদ্ধ সেটিংস অনুমোদন করুন» অপশন না থাকে — প্রথমে একবার Accessibility-তে টগল চালু করার চেষ্টা করুন (নিষেধের বার্তা আসবে), তারপর ধাপ ২ উপলব্ধ হবে।\n\nXiaomi/MIUI, Samsung ইত্যাদিতে পথ সামান্য ভিন্ন হতে পারে — «অ্যাপ সম্পর্কে»-তে সেই একই ⋮ খুঁজুন। Android 12 ও পুরোনোতে সাধারণত সীমাবদ্ধতা নেই — সরাসরি চালু করুন।\n\nভলিউম কি শুধু পড়া হয়, কখনও ব্লক করা হয় না।"
    override val volOpenAppInfo = "«অ্যাপ সম্পর্কে» খুলুন"
    override val volAccessOn = "Accessibility: চালু"
    override val volAccessOff = "Accessibility: বন্ধ"
    override val volOpenAccess = "Accessibility সেটিংস খুলুন"
    override val volGapLabel = "চাপের মধ্যে সর্বোচ্চ ms"
    override val volPatternsTitle = "শনাক্তযোগ্য প্যাটার্ন"
    override val volPatternPick = "প্যাটার্ন"
    override val volPatternsLegend = "↑ = ভলিউম আপ, ↓ = ডাউন"
    override val volNoRights = "অ্যাপটির এখনও ভলিউম বাটন প্রসেস করার অনুমতি নেই — পেজের নিচের নির্দেশনা অনুযায়ী অ্যাক্সেস দিন।"
    override val volGrantShort = "Accessibility-তে এখনও অ্যাক্সেস নেই। এই পেজের নিচের বিস্তারিত নির্দেশনা পড়ুন এবং «যাচাই করুন» ট্যাপ করুন।"
    override val volCheck = "যাচাই করুন"
    override val volCheckOk = "✓ সম্পন্ন — অ্যাক্সেস দেওয়া হয়েছে, ট্রিগার কাজ করছে।"
    override val volCheckFail = "✗ এখনও অ্যাক্সেস নেই — উপরের ধাপগুলো সম্পন্ন করুন।"
    override val volPatternsList = "↑↑↓↓ · ↓↓↑↑ · ↑↓↑↓ · ↓↑↓↑ · ↑↑↑↑ · ↓↓↓↓ · ↑↓↓↑ · ↓↑↑↓ · ↑↑↑↓↓↓ · ↓↓↓↑↑↑   (↑ = ভলিউম আপ, ↓ = ডাউন)"
    override val histLegend = "কলাম — কে: ✓/✗ TG = বাস্তব টেলিগ্রাম কানেক্ট, স্ক্যান = ব্যাকগ্রাউন্ড যাচাই। কখন: কত আগে। TCP/TLS/অনুরোধ: হ্যান্ডশেক ও প্রথম অনুরোধের বিলম্ব, ms। সেশন: রিলে সেশন কতক্ষণ চলেছে। ↓/↑: হোস্টের মাধ্যমে গৃহীত / প্রেরিত বাইট।"
    override val tgOkTotalHint = "টেলিগ্রাম কানেকশন / সফল / মোট যাচাই"
    override val breadthTitle = "হোস্ট নির্বাচনের ব্যাপ্তি"
    override val breadthHelp = "বামে — সেরা যাচাইকৃত হোস্টে থাকুন; ডানে — যথাসম্ভব ব্যাপকভাবে বিভিন্ন সচল হোস্ট চেষ্টা করুন। টেলিগ্রাম যখন রিলে পোর্টগুলোর মধ্যে ছোটাছুটি করে, প্রোগ্রাম স্বয়ংক্রিয়ভাবে নির্বাচন প্রসারিত করে।"
    override val breadthNarrow = "যাচাইকৃত"
    override val breadthWide = "আরও ব্যাপক"
    override val connTimeoutTitle = "হোস্ট কানেক্ট টাইমআউট"
    override val connTimeoutHelp = "পরবর্তী প্রক্সি চেষ্টা করার আগে একটি আপস্ট্রিমের (TCP + TLS + প্রথম MTProto প্রতিক্রিয়া) জন্য কতক্ষণ অপেক্ষা করতে হবে।"
    override val factoryResetDone = "সবকিছু রিসেট হয়েছে। অ্যাপটি বন্ধ করুন এবং আবার চালু করুন।"
    override val backupExportTitle = "ডেটা এক্সপোর্ট"
    override val backupImportTitle = "ডেটা ইম্পোর্ট"
    override val backupSelectExport = "কী এক্সপোর্ট করবেন:"
    override val backupSelectImport = "কী ইম্পোর্ট করবেন:"
    override val backupCopyBtn = "কপি"
    override val backupSaveFile = "ফাইলে সংরক্ষণ"
    override val backupLoadFile = "ফাইল থেকে লোড"
    override val backupDoImport = "ইম্পোর্ট করুন"
    override val backupPasteLabel = "এখানে ব্যাকআপ JSON পেস্ট করুন"
    override val backupJsonLabel = "ব্যাকআপ JSON"
    override val backupAndroidFileNote = "এখানে ফাইল অনুপলব্ধ — কপি / পেস্ট ব্যবহার করুন।"

    // tray
    override val trayOpenWindow = "উইন্ডো খুলুন"
    override val trayRefreshSubs = "সাবস্ক্রিপশন রিফ্রেশ করুন"
    override val trayExit = "প্রস্থান"
    override fun trayConnectorLabel(on: Boolean) =
        if (on) "কানেক্টর: চালু (বন্ধ করুন)" else "কানেক্টর: বন্ধ (চালু করুন)"
    override fun trayScanLabel(on: Boolean) =
        if (on) "স্ক্যান: চালু (বন্ধ করুন)" else "স্ক্যান: বন্ধ (চালু করুন)"
    override fun trayLive(n: Int) = "সচল প্রক্সি: ${n}"
    override val appearance = "চেহারা"
    override val themeLabel = "থিম"
    override val themeAuto = "স্বয়ংক্রিয় (সিস্টেম অনুযায়ী)"
    override val themeLight = "হালকা"
    override val themeDark = "গাঢ়"
    override val drawGraphsLabel = "গ্রাফ আঁকুন"
    override val drawGraphsSub = "সংযোগকারী ও স্ক্যান ট্যাবে লাইভ চার্ট — ব্যাটারি বাঁচাতে বন্ধ করুন"
}
