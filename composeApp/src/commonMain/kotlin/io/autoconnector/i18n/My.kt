package io.autoconnector.i18n

object My : Strings {
    override val tabConnector = "ချိတ်ဆက်ကိရိယာ"; override val tabScan = "စကင်"
    override val tabCatalog = "စာရင်း"; override val tabLogs = "မှတ်တမ်း"; override val tabMore = "နောက်ထပ်"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "Subscription များ"; override val logTabScan = "စကင်"
    override val logGeneral = "အထွေထွေ"; override val logEmpty = "လောလောဆယ် ဗလာဖြစ်နေသည်"
    override val logSessions = "ဆက်ရှင်များ"; override val logErrorsOnly = "အမှားများသာ"; override val logNoErrors = "ပျက်ကွက်သော ဆက်ရှင် မရှိပါ"
    override fun logSession(id: String, port: String) = "#$id · :$port"
    override val back = "နောက်သို့"; override val copy = "ကူးယူ"; override val gotIt = "နားလည်ပါပြီ"
    override val later = "နောက်မှ"; override val details = "အသေးစိတ်"; override val whatIsThis = "ဒါက ဘာလဲ။"
    override val delete = "ဖျက်"

    override val connector = "ချိတ်ဆက်ကိရိယာ"; override val scan = "စကင်"
    override val notConfigured = "မသတ်မှတ်ရသေး။ ပြင်ဆင်ရန် →"; override val howToSetup = "ဘယ်လို သတ်မှတ်မလဲ"
    override val notifOff = "အကြောင်းကြားချက်များ ပိတ်ထားသည်။ ပြင်ဆင်ရန် →"; override val enable = "ဖွင့်"
    override fun fewProxies(n: Int) = "အသက်ဝင်နေသော proxy $n ခု၊ ရှာဖွေနေသည်၊ ~၁၅ မိနစ်ခန့် စောင့်ပါ…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "အသက်ဝင် proxy: $alive  (၁၅ မိနစ်: $within) · စုစုပေါင်း: $total"
    override val notifWhyTitle = "အကြောင်းကြားချက်များ ဘာကြောင့်လဲ။"
    override val notifWhyBody = "အမြဲတမ်း အကြောင်းကြားချက် အိုင်ကွန်သည် Android foreground service ကို ဆိုလိုသည်။ " +
        "ထိုအရာမပါလျှင် စနစ်သည် အက်ပ်ကို မမ်မိုရီမှ ဖယ်ရှားပြီး proxy ရှာဖွေခြင်းနှင့် " +
        "နောက်ခံတွင် ချိတ်ဆက်မှု ထိန်းသိမ်းခြင်းကို ရပ်တန့်စေသည်။ ထို့ကြောင့် " +
        "AutoConnector အလုပ်လုပ်ရန် အကြောင်းကြားချက်များ လိုအပ်သည်။"
    override val notifEnableTitle = "အကြောင်းကြားချက်များ ဖွင့်ရန်"
    override val notifEnableBody = "အကြောင်းကြားချက် အိုင်ကွန် မပါလျှင် Android သည် အက်ပ်ကို မလှုပ်ရှားသည်ဟု သတ်မှတ်ပြီး " +
        "မမ်မိုရီမှ ဖယ်ရှားသည်။ ထိုအခါ AutoConnector သည် proxy ရှာဖွေခြင်းနှင့် နောက်ခံတွင် " +
        "ချိတ်ဆက်မှု ထိန်းသိမ်းခြင်းကို ရပ်တန့်သည် — Telegram သည် ၎င်း၏ ချိတ်ဆက်မှုကို ဆုံးရှုံးသည်။\n\n\"ဖွင့်\" ကို နှိပ်ပြီး " +
        "AutoConnector အတွက် အကြောင်းကြားချက်များကို ခွင့်ပြုပါ။"
    override val notifPlea = "အကြောင်းကြားချက်များ ဖွင့်ပါ။ ၎င်းတို့မပါလျှင် အက်ပ်သည် နောက်ခံတွင် အလုပ်မလုပ်နိုင်ပါ — " +
        "Android က ၎င်းကို ဖယ်ရှားမည်ဖြစ်ပြီး proxy ရှာဖွေခြင်းနှင့် ချိတ်ဆက်မှု ရပ်တန့်သွားမည်။"

    override val statusConnected = "Telegram ချိတ်ဆက်ပြီး"; override val statusConnecting = "ချိတ်ဆက်နေသည်…"
    override val statusOffline = "Telegram မချိတ်ဆက်ရသေး"; override val statusIdle = "Telegram အလုပ်မလုပ်"
    override val nobodyConnected = "ချိတ်ဆက်ကိရိယာသို့ မည်သူမှ မချိတ်ဆက်ထားပါ။ "; override val howToSetupArrow = "ဘယ်လို သတ်မှတ်မလဲ →"
    override val directModeViaVpn = "တိုက်ရိုက်မုဒ်: VPN အသက်ဝင် — proxy မရှိ"
    override val directModeOff = "တိုက်ရိုက်မုဒ်: proxy များ ပိတ်"
    override val directDpiSuffix = " · anti-DPI"
    override val connections = "ချိတ်ဆက်မှုများ"; override val sockets = "Socket များ"; override val speed = "အမြန်နှုန်း"
    override val traffic = "Traffic"; override val latency = "Latency"
    override fun pcs(n: Int) = "$n ခု"
    override fun netNow(label: String) = "ကွန်ရက်: $label"
    override fun tgToConnector(n: Int) = "TG→ $n"
    override fun connectorToProxy(n: Int) = "proxy $n"
    override val trafficSec = "traffic · ၆၀ စက္ကန့်"; override val trafficMin = "traffic · ၆၀ မိနစ်"
    override val latencySec = "latency · ၆၀ စက္ကန့်"; override val latencyMin = "latency · ၆၀ မိနစ်"
    override val sec60 = "၆၀ စက္ကန့်"; override val min60 = "၆၀ မိနစ်"
    override val unitSec = "စ"; override val unitMin = "မ"; override val unitHour = "နာ"; override val dash = "—"
    override val currentProxy = "လက်ရှိ proxy"; override val noActiveProxy = "အသက်ဝင် proxy မရှိ (Telegram မချိတ်ဆက်ရသေး)"
    override val host = "Host"; override val type = "အမျိုးအစား"; override val secret = "Secret"; override val antiDpi = "Anti-DPI"; override val obfEngine = "ဖုံးကွယ်ရေး အင်ဂျင်"
    override fun activeSockets(n: Int) = "အသက်ဝင် Telegram socket များ: $n"
    override val noConnections = "အသက်ဝင် ချိတ်ဆက်မှု မရှိ"; override val colHost = "Host"; override val colTime = "အချိန်"
    override val modeWord = "မုဒ်"; override val directViaVpnLine = "Telegram သို့ တိုက်ရိုက် တောင်းဆိုမှုများ (VPN အသက်ဝင်)"
    override val connModeHelp = "မုဒ်များ (VPN, Wi-Fi, LTE, Ethernet, White) သည် စကင်အပြင်းအထန်ကို မတူညီစွာ ချိန်ညှိနိုင်ပြီး သီးခြား host အဆင့်သတ်မှတ်ချက်/စာရင်းဇယားများ ထိန်းသိမ်းနိုင်စေသည်။ ကွန်ရက်ကတ်ကို အလိုအလျောက် ရှာဖွေသည်၊ မုဒ်ကို ဆက်တင်များတွင် ကိုယ်တိုင် သတ်မှတ်နိုင်သည်။"

    override val scanOff = "စကင်ဖတ်ခြင်း ပိတ်ထားသည်"; override val proxiesInBase = "ဒေတာဘေ့စ်ထဲက proxy များ"
    override val total = "စုစုပေါင်း"; override val alive = "အသက်ဝင်"; override val dead = "သေ"
    override val tgConnectedTitle = "Telegram ချိတ်ဆက်ထားသည့်နည်း"; override val successful = "အောင်မြင်"
    override val socketsHeld = "Socket သက်တမ်း"; override val over1m = ">၁ မိနစ်"; override val over5m = ">၅ မိနစ်"; override val over15m = ">၁၅ မိနစ်"
    override val scanCountTitle = "Proxy စစ်ဆေးမှု အရေအတွက်"; override val checked = "စစ်ဆေးပြီး"
    override val forAllTime = "အချိန်အားလုံး"; override val perMinute = "တစ်မိနစ်လျှင်"; override val perHour = "တစ်နာရီလျှင်"
    override val subsCountTitle = "Subscription ဒေါင်းလုဒ် အရေအတွက်"; override val downloaded = "ဒေါင်းလုဒ်ပြီး"; override val failed = "ပျက်ကွက်"; override val scanTraffic = "စကင် traffic"; override val subTraffic = "subscription traffic"; override val subTrafficGraph = "Subscription traffic"
    override val checksMtproto = "MTProto စစ်ဆေးမှု (↑ အောင် · ↓ ကျ)"

    override fun catalogEmpty(mode: String) = "စာရင်း $mode သည် လောလောဆယ် ဗလာဖြစ်နေသည်။ host မတွေ့သေးခြင်း သို့မဟုတ် ဤမုဒ်တွင် အက်ပ် တစ်ခါမှ အလုပ်မလုပ်ဖူးခြင်း ဖြစ်နိုင်သည်။ မုဒ်ကို ဆက်တင်များတွင် ပြောင်းနိုင်သည်။ မုဒ်များသည် မတူညီသော အင်တာနက်ချိတ်ဆက်မှု အမျိုးအစားများအတွက် host များကို သီးခြားစုဆောင်းရန် ရှိသည်။"
    override val aliveShort = "✓ အသက်ဝင်"; override val deadShort = "✗ သေ"
    override val statusLabel = "အခြေအနေ"; override val rating = "အဆင့်သတ်မှတ်ချက်"; override val port = "Port"
    override val rttPing = "RTT (ping)"; override val checkedField = "စစ်ဆေးပြီး"; override val okOfTotal = "အောင်မြင် / စစ်ဆေးမှု စုစုပေါင်း"
    override val tgConnectedField = "Telegram ချိတ်ဆက်ပြီး"; override val tgSessions = "Telegram ဆက်ရှင်များ"; override val trafficThroughProxy = "Proxy မှတစ်ဆင့် traffic"
    override val sessionsTotal = "ဆက်ရှင် စုစုပေါင်း"; override val relayNow = "ယခု ထပ်ဆင့်ပို့"; override val tlsDomain = "TLS domain (SNI)"
    override val sourceSub = "ရင်းမြစ် (subscription)"; override val lastError = "နောက်ဆုံး အမှား"; override val yes = "ဟုတ်"; override val no = "မဟုတ်"
    override val copyAsLink = "လင့်ခ်အဖြစ် ကူးယူ"; override val openInTelegram = "Telegram တွင် host ကို ဖွင့်"; override val makeNextRelay = "နောက် ထပ်ဆင့်ပို့သူ ပြုလုပ်"
    override val actCopy = "ကူးယူ"; override val actOpen = "ဖွင့်"; override val actRelay = "ထပ်ဆင့်ပို့"
    override fun agoFmt(v: String) = "$v က"
    override val catalogTopFor = "Proxy စာရင်း/အဆင့်သတ်မှတ်ချက်"
    override val catalogModeHelpTitle = "မုဒ်များနှင့် အဆင့်သတ်မှတ်ချက်များ"
    override val catalogModeHelp = "အက်ပ်သည် အသက်ဝင် host များနှင့် ၎င်းတို့၏ အဆင့်သတ်မှတ်ချက်များကို ကွန်ရက်မုဒ်အလိုက် (VPN, Wi-Fi, LTE, Ethernet နှင့် White) သီးခြားစီ ရေတွက်သည်။ «White» သည် whitelist များအတွက် သီးခြား ကိုယ်တိုင်မုဒ် ဖြစ်သည်၊ အလိုအလျောက်က ၎င်းသို့ ဘယ်တော့မှ မပြောင်းပါ။ ထို့ကြောင့် တူညီသော host တစ်ခုသည် မုဒ်တစ်ခုတွင် အသက်ဝင်ပြီး အခြားမုဒ်တွင် သေနိုင်သည်။"
    override fun catalogInactiveWarn(section: String, active: String) =
        "သင်သည် မလှုပ်ရှားသော အပိုင်း $section ကို ကြည့်နေသည် — ယခုအချိန် စာရင်းဇယားအားလုံးသည် ဤနေရာသို့ မဟုတ်ဘဲ $active သို့ သွားသည်။"
    override val manageModeTitle = "မုဒ် စီမံ"
    override val manageResetRating = "အဆင့်သတ်မှတ်ချက် ပြန်လည်သတ်မှတ်"
    override fun manageResetHint(mode: String) = "$mode အတွက် အထူးသဖြင့် အသက်ဝင် host များ၏ အဆင့်သတ်မှတ်ချက်နှင့် အသုံးပြုမှု စာရင်းဇယားများကို ပြန်လည်သတ်မှတ်နိုင်သည်။ အခြေခံအားဖြင့် မတူညီသော VPN သို့မဟုတ် LTE နှင့် ချိတ်ဆက်လိုက်သည့်အခါ စာဟောင်းများ မနှောင့်ယှက်စေရန် အသုံးဝင်သည်။ သို့မဟုတ် proxy စကင်က အစမှ အားလုံးကို မည်မျှ မြန်မြန် ပြန်စစ်သည်ကို ကြည့်ရှုရန်လည်း ဖြစ်သည်။"
    override val manageDeleteAll = "Host များကို ဖျက်ရန်"
    override fun manageDeleteHint(mode: String) = "$mode မှ အဆင့်သတ်မှတ်ချက်နှင့် host များကိုယ်တိုင် နှစ်မျိုးလုံးကို ရှင်းနိုင်သည်။ \"Proxy စကင်\" လုပ်ဆောင်ချက်က ၎င်းတို့ကို ပြန်လည်စုဆောင်းပေးမည်။ ဤသည်မှာ subscription ပြန်လည်သတ်မှတ်ခြင်း မဟုတ်ပါ — ၎င်းကို နှိပ်ပြီး ပြန်စကင်ဖတ်ရန် ~၁၅ မိနစ်ခန့် စောင့်နိုင်သည်။"
    override fun manageCopyFrom(mode: String) = "host များနှင့် အဆင့်သတ်မှတ်ချက်အားလုံးကို အခြားမုဒ်တစ်ခုမှ ဤမုဒ် ($mode) သို့ ကူးယူ:"
    override val live = "အသက်ဝင်"; override val deadW = "သေ"; override val unitMs = "ms"
    override val agoMin = "မ"; override val agoHour = "နာ"; override val agoDay = "ရက်"

    override val connectTelegram = "Telegram ချိတ်ဆက်ခြင်း"; override val readCarefully = "ဂရုတစိုက် ဖတ်ပါ။"
    override val guideIntro = "ဤအက်ပ်သည် သတ်မှတ်ခြင်းမရှိဘဲ အလုပ်မလုပ်ပါ။ အောက်ပါ ရွေးချယ်စရာ ၃ ခုမှ တစ်ခုခုကို ရွေးပြီး " +
        "ညွှန်ကြားချက်များကို ဂရုတစိုက် လိုက်နာပါ။"
    override val variant1 = "ရွေးချယ်စရာ #၁ — ခလုတ်များ"
    override val variant1Body = "\"Proxy {A}\" ကို နှိပ်ပါ — Telegram ပွင့်လာသည်၊ proxy ထည့်ခြင်းကို အတည်ပြုပါ။ " +
        "ဤဖန်သားပြင်သို့ ပြန်လာပြီး \"Proxy {B}\" ကို နှိပ်ပါ — ဒုတိယအကြိမ် ထည့်ခြင်းကို အတည်ပြုပါ။\n\nTelegram ရှိ " +
        "အခြား proxy ဟောင်းများကို ပိတ်ပါ။ Port {A} နှင့် {B} ပါသော proxy အတိအကျ ၂ ခု ကျန်ရှိရမည်။ " +
        "အခြားအစုံအလင်နှင့်ဆိုလျှင် AutoConnector အလုပ်မလုပ်ပါ။"
    override val variant2 = "ရွေးချယ်စရာ #၂ — လင့်ခ်များ"
    override val variant2Body = "အောက်ပါ စာသားကို Telegram ရှိ Saved Messages (သို့မဟုတ် မည်သည့်ချတ်) ထဲသို့ ကူးယူပါ — " +
        "ဆိုလိုသည်မှာ ၎င်းကို ကိုယ့်ကိုယ်ကို ပို့ပါ။ သင့်မက်ဆေ့ဂျ်ထဲက ပထမလင့်ခ်ကို နှိပ်ပါ — ပထမ proxy ထည့်သွင်းပြီး။ " +
        "ဒုတိယလင့်ခ်ကို နှိပ်ပါ — ဒုတိယတစ်ခု ထည့်သွင်းပြီး။ ထို့နောက် proxy ဟောင်းအားလုံးကို ပိတ်ပါ။"
    override val variant3 = "ရွေးချယ်စရာ #၃ — ကိုယ်တိုင်"
    override val variant3Body = "SOCKS5 proxy ကို ကိုယ်တိုင် ထည့်ပါ: server localhost (127.0.0.1), port {A}။ " +
        "ထို့နောက် ဒုတိယ proxy: localhost, port {B}။ proxy ဟောင်းများ ရှိလျှင် ဖျက်ပါ။"
    override val whatNext = "နောက်ဘာဆက်လုပ်မလဲ။"
    override val whatNextBody = "Telegram တွင် \"proxy အလိုအလျောက်ပြောင်းခြင်း\" ကို ဖွင့်ပါ — ၅ စက္ကန့်။ အသက်မဝင်သော သို့မဟုတ် " +
        "\"မရရှိနိုင်\" ဟု အမှတ်အသားပြုထားသော proxy တစ်ခုကို (Telegram အတွင်း) ကိုယ်တိုင်နှိပ်ခြင်းဖြင့် Telegram ချိတ်ဆက်ရန် " +
        "ကူညီနိုင်သည် — ၎င်းသည် Telegram ကို ပိုကြိုးစား၍ ချိတ်ဆက်စေသည်။\n\n{A} နှင့် {B} မှလွဲ၍ အခြား proxy ဟောင်းအားလုံး " +
        "ဖယ်ရှားပြီးကြောင်း သေချာပါစေ။ Telegram တွင် " +
        "\"Proxy သုံးရန်\" ကို နှိပ်ပါ။\n\nအက်ပ်က proxy အလုံအလောက် ရှာဖွေ ဒေါင်းလုဒ်နေစဉ် စောင့်ပါ " +
        "(၅–၁၅ မိနစ်)။ ထို့နောက် Telegram သည် AutoConnector သို့ အလိုအလျောက် ချိတ်ဆက်မည်ဖြစ်ပြီး၊ ၎င်းသည် " +
        "Telegram ကို အကောင်းဆုံး proxy များမှတစ်ဆင့် ဆက်လက် ဦးတည်ပေးမည်: စစ်ဆေးပြီး၊ အသက်ဝင်ပြီး မြန်ဆန်သော။\n\nညွှန်ကြားချက်များ " +
        "ခက်ခဲသည်ဟု ထင်လျှင် — တောင်းပန်ပါသည်၊ သင် အက်ပ်ကို သုံးနိုင်မည် မဟုတ်ပါ: အရာအားလုံးကို အလိုအလျောက် " +
        "သတ်မှတ်ရန် မဖြစ်နိုင်ပါ၊ အသက်ဝင် proxy များ ရှာဖွေရာတွင်လည်း အချိန်ယူသည်။\n\nအက်ပ်ကို ကြာမြင့်စွာက " +
        "ဒေါင်းလုဒ်လုပ်ထားပြီး အသက်ဝင် proxy မတွေ့ပါက — အက်ပ် သို့မဟုတ် subscription စာရင်းကို အပ်ဒိတ်လုပ်ပါ။ ဤအက်ပ်သည် " +
        "မိမိ၏ proxy များကို တီထွင် သို့မဟုတ် ပေးအပ်ခြင်း မရှိပါ၊ အင်တာနက်ပေါ်ရှိ အုပ်စုနှင့် စာမျက်နှာ ဒါဇင်ပေါင်းများစွာတွင် " +
        "ရှာဖွေပေးရုံသာ ဖြစ်သည်။"
    override fun proxyBtn(port: Int) = "Proxy $port"

    override val setupPortsTitle = "Telegram တွင် port များ သတ်မှတ်ရန်"
    override val setupPortsSub = "Telegram ကို ချိတ်ဆက်ကိရိယာ (port 55001/55002) သို့ ချိတ်ဆက်နည်း"
    override val settings = "ဆက်တင်များ"; override val settingsSub = "Port, anti-DPI, စကင်, ကွန်ရက်, ဘက်ထရီ"
    override val subscriptions = "Subscription များ"; override val subscriptionsSub = "စကင်ဖတ်ရန် proxy ရင်းမြစ်များ"
    override val statistics = "စာရင်းဇယားများ"; override val statisticsSub = "Proxy ဒေတာဘေ့စ် + anti-DPI နည်းများ"
    override val export = "ထုတ်ယူ"; override val exportSub = "အသက်ဝင် proxy များ၏ tg:// လင့်ခ်များ"
    override val about = "အကြောင်း"; override val aboutSub = "ဗားရှင်း, build, ဒေါင်းလုဒ်, တုံ့ပြန်ချက်"
    override val hotkeys = "Hotkey များ"
    override val hotkeysSub = "Global ကီးများ: proxy ကို ကူးယူ / ဖွင့်"
    override val hotkeysIntro = "Global hotkey များသည် အက်ပ်ဝင်းဒိုး focus မဖြစ်နေသည့်အခါတွင်လည်း အလုပ်လုပ်သည်။ ၎င်းတို့သည် " +
        "pool မှ ကျပန်း အသက်ဝင် proxy လင့်ခ် (tg://) တစ်ခုကို ရွေးသည် — အက်ပ်ကို မဖွင့်ဘဲ proxy များ မြန်မြန် " +
        "ပြောင်းရန် အသုံးဝင်သည်။"
    override val hotkeysNote = "macOS တွင် ကီးများ ဖမ်းယူရန် Accessibility ခွင့်ပြုချက် လိုအပ်နိုင်သည် " +
        "(System Settings → Privacy & Security → Accessibility)။"
    override val hotkeyCopyTitle = "Proxy လင့်ခ် ကူးယူ"
    override val hotkeyCopyDesc = "ကျပန်း အသက်ဝင် tg:// လင့်ခ်တစ်ခုကို clipboard ပေါ်တွင် တင်ပေးသည်။"
    override val hotkeyEnable = "Hotkey များ ဖွင့်"; override val hotkeyLetterLabel = "စာလုံး"; override val hotkeySet = "သတ်မှတ်"; override val hotkeyReset = "ပြန်လည်သတ်မှတ်"
    override val hotkeyOpenTitle = "Telegram တွင် proxy ဖွင့်"
    override val hotkeyOpenDesc = "ကျပန်း အသက်ဝင် လင့်ခ်တစ်ခုကို ဖွင့်သည် — Telegram က ၎င်းကို ဖမ်းယူပြီး proxy ချိတ်ဆက်ရန် ကမ်းလှမ်းသည်။"

    override val relayPorts = "ထပ်ဆင့်ပို့ port များ"
    override val relayPortsHelp = "ချိတ်ဆက်ကိရိယာ နားထောင်နေသော local port များ။ ၎င်းတို့ကိုပင် Telegram တွင် " +
        "SOCKS5 proxy (127.0.0.1 : port) အဖြစ် အတိအကျ ထည့်ရသည်။ ယုံကြည်စိတ်ချရမှုအတွက် port နှစ်ခု သုံးသည် — Telegram သည် " +
        "နှစ်ခုလုံးသို့ ချိတ်ဆက်မှုများ ထိန်းသိမ်းသည်။"
    override val portA = "Port A"; override val portB = "Port B"
    override val antiDpiTrick = "Anti-DPI နည်း"
    override val antiDpiHelp = "ISP/DPI က မမှတ်မိ၍ မပိတ်နိုင်စေရန် ချိတ်ဆက်မှုကို ဖုံးကွယ်သည့်နည်း။\n• \"အလိုအလျောက်လှည့်\" သည် " +
        "အလုပ်လုပ်သော နည်းတစ်ခုကို ၎င်းကိုယ်တိုင် ရွေးသည်။\n• \"DPI နည်းမရှိ\" — ရိုးရိုး " +
        "ချိတ်ဆက်မှု။\n• ကျန်အရာများသည် တိကျသော နည်းပညာများ ဖြစ်သည် (browser အယောင်ဆောင်ခြင်း, packet ခွဲခြင်း, စသည်)။"
    override val onlyFakeTls = "FakeTLS သာ (ee)"
    override val applyDpiTo = "Anti-DPI ကို သက်ရောက်စေရန်"
    override val applyDpiHelp = "ရွေးချယ်ထားသော anti-DPI နည်းကို ဘာသို့ သက်ရောက်စေမည်:\n• Telegram ထပ်ဆင့်ပို့ — ချိတ်ဆက်ကိရိယာမှတစ်ဆင့် " +
        "အသက်ဝင်နေသော Telegram ချိတ်ဆက်မှုသို့။\n• Proxy စစ်ဆေးမှုများ — နောက်ခံ proxy စစ်ဆေးမှုများသို့ " +
        "(ထိုအခါ စစ်ဆေးမှုသည် တကယ့်ချိတ်ဆက်မှုနှင့်အတူတူ ပြုမူပြီး၊ နည်း၏ စာရင်းဇယားများ ပိုတိကျသည်)။\n" +
        "• တိုက်ရိုက်ချိတ်ဆက်သည့်အခါ — proxy များ ပိတ်ထားသည့်အခါ (သို့မဟုတ် VPN ဖွင့်စဉ် ကျော်လွှားသည့်အခါ) နှင့် Telegram သည် " +
        "၎င်း၏ ဆာဗာများသို့ တိုက်ရိုက် သွားသည့်အခါ: ဤနေရာတွင် proxy မရှိသဖြင့်၊ နည်းသည် ပထမ TCP packet " +
        "(handshake) ကို DPI က တစ်ကြိမ်ဖတ်ရှုမှုဖြင့် မကိုက်ညီနိုင်စေရန် segment သေးငယ်များစွာ ခွဲခြားခြင်းသို့ လျှော့ချသွားသည်။"
    override val toRelay = "Telegram ထပ်ဆင့်ပို့"; override val toProbes = "Proxy စစ်ဆေးမှုများ"
    override val toDirect = "တိုက်ရိုက်ချိတ်ဆက်သည့်အခါ"
    override val vpnSection = "VPN ဖွင့်ထားသည့်အခါ"
    override val vpnHelp = "စက်ပစ္စည်းတွင် VPN အသက်ဝင်နေသည့်အခါ ဘာလုပ်မည်:\n• MTProto proxy မှတစ်ဆင့် — " +
        "Telegram သည် တွေ့ရှိသော proxy များမှတစ်ဆင့် ပုံမှန်အတိုင်း သွားသည် (VPN အပေါ်တွင်)။\n• တိုက်ရိုက် — " +
        "ချိတ်ဆက်ကိရိယာသည် proxy များ မသုံးဘဲ Telegram ကို Telegram ၏ ဆာဗာများသို့ တိုက်ရိုက်ချိတ်ဆက်သည်: " +
        "VPN က ဝင်ရောက်ခွင့်ကို ပေးပြီးဖြစ်၍ ထပ်ဆောင်း proxy အလွှာ မလိုအပ်ပါ (ပိုမြန်ပြီး တည်ငြိမ်သည်)။ " +
        "VPN မရှိလျှင် proxy များကို ပုံမှန်အတိုင်း သုံးသည်။"
    override val linkFormat = "Proxy လင့်ခ် ပုံစံ"
    override val linkFormatHelp = "Proxy များကို ကူးယူ၊ ဖွင့်နည်း။ tg:// သည် Telegram ကို တိုက်ရိုက်ဖွင့်သည် (Telegram Desktop ထည့်သွင်းထားရန် လိုသည်)။ http (t.me) သည် browser မှတစ်ဆင့်ဖွင့်ပြီး Telegram တွင် ဖွင့်ရန် ကမ်းလှမ်းသည် — tg:// မှတ်ပုံတင်မထားလျှင် အသုံးဝင်သည်။"
    override val linkTg = "tg:// (Telegram တိုက်ရိုက်ဖွင့်)"; override val linkTgSub = "tg://proxy?… — Telegram ဖွင့်သည်"
    override val linkHttp = "http (t.me, browser မှတစ်ဆင့်)"; override val linkHttpSub = "https://t.me/proxy?… — browser ဖွင့်သည်"
    override val viaMtproto = "MTProto မှတစ်ဆင့် proxy"; override val viaMtprotoSub = "VPN ရှိနေလျှင်ပင် traffic သည် proxy များမှတစ်ဆင့် သွားသည်"
    override val directly = "တိုက်ရိုက် ချိတ်ဆက်"; override val directlySub = "VPN အသက်ဝင်နေစဉ် — proxy များကို ကျော်လွှားပြီး Telegram သို့ တိုက်ရိုက်"
    override val notifications = "အကြောင်းကြားချက်များ"
    override val scanCheck = "စကင်နှင့် စစ်ဆေး"
    override val scanCheckHelp = "• စကင်, မိနစ် — subscription များမှ proxy စာရင်းများ မည်မျှ မကြာခဏ ဒေါင်းလုဒ်လုပ်မည်။\n" +
        "• စစ်ဆေး, မိနစ် — ဒေတာဘေ့စ်ရှိ proxy များ အသက်ဝင်/မဝင် မည်မျှ မကြာခဏ ပြန်စစ်မည်။\n• Batch အရွယ် — " +
        "တစ်ကြိမ်လျှင် proxy မည်မျှ စစ်ဆေးမည်။\n• ပြိုင်တူ — တစ်ပြိုင်နက် စစ်ဆေးမှု မည်မျှ လုပ်မည် (များလေ = " +
        "မြန်လေ၊ ဒါပေမယ့် ကွန်ရက်နှင့် ဘက်ထရီ ဝန်ပိုလေ)။"
    override val scanMin = "စကင်, မိနစ်"; override val checkMin = "စစ်ဆေး, မိနစ်"; override val batchSize = "Batch အရွယ်"; override val parallel = "ပြိုင်တူ"
    override val speedByNet = "ကွန်ရက်အလိုက် စကင်အပြင်းအထန်"
    override val speedByNetHelp = "လက်ရှိ ကွန်ရက်ပေါ်မူတည်၍ proxy များ မည်မျှ မကြာခဏ စစ်ဆေးမည်။ " +
        "\"စံ\" = အခြေခံ ကြားကာလ။ ညာဘက်သို့ ဆွဲလျှင် ပိုနည်း (ပိုနှေး၊ traffic/ဘက်ထရီ ပိုသက်သာ)၊ " +
        "ဘယ်ဘက်သို့ ပိုခဏ (ပိုမြန်၊ ပိုပြင်းထန်)။ Logarithmic စကေး၊ နှစ်ဖက်လုံး ×၁၀၀ အထိ။\n" +
        "• VPN — ပြင်ပ VPN အသက်ဝင်နေသည့်အခါ။\n• Wi-Fi — Wi-Fi ကွန်ရက်တွင်။\n• LTE — မိုဘိုင်းကွန်ရက်တွင်။"
    override val intensStandard = "စံ"
    override val intensSlower = "ပိုနှေး"
    override val intensFaster = "ပိုမြန်"
    override val maintenance = "ဒေတာ ပြန်လည်သတ်မှတ်"
    override val maintenanceHelp = "• \"စာရင်းနှင့် စာရင်းဇယားများ ပြန်လည်သတ်မှတ်\" — အဆင့်သတ်မှတ်ချက်, ကောင်တာ, traffic " +
        "နှင့် စစ်ဆေးမှု မှတ်တမ်းများကို သုညပြုသည်၊ ဒါပေမယ့် ဒေါင်းလုဒ်လုပ်ထားသော host များနှင့် subscription များကို ထိန်းသိမ်းသည် (နောက် " +
        "စကင်တွင် အားလုံး ပြန်အဆင့်သတ်မှတ်သည်)။\n• \"ဒေါင်းလုဒ်လုပ်ထားသော host များ ရှင်း\" — proxy pool တစ်ခုလုံးကို " +
        "ဖျက်သည် ဒါပေမယ့် စကင်က pool ပြန်ဖြည့်နိုင်စေရန် subscription များကို ထိန်းသိမ်းသည်။ subscription များကို မည်သည့်နည်းနှင့်မှ မထိပါ။"
    override val backupTitle = "ထုတ်ယူ / တင်သွင်း"
    override val backupHelp = "အက်ပ်ဒေတာကို JSON ဖိုင်တစ်ခုတည်းတွင် သိမ်း သို့မဟုတ် ပြန်လည်ရယူ။ ဘာထည့်မည်ကို " +
        "အမှန်ခြစ်ပါ — မည်သည့်ပေါင်းစပ်မှုမဆို:\n• ဆက်တင်များ — အက်ပ်အညွှန်းကိန်းအားလုံး။\n• Subscription များ — ရင်းမြစ် " +
        "စာရင်း (URL + ဖွင့်/ပိတ်)။\n• အသက်ဝင် host စာရင်း — အသက်ဝင် proxy တိုင်းကို ၎င်း၏ အဆင့်သတ်မှတ်ချက်နှင့် စာရင်းဇယားများနှင့်အတူ " +
        "ကွန်ရက်မုဒ်အလိုက်။\n\n«ထုတ်ယူ» က ဘယ်နေရာ သိမ်းမည်ကို မေးသည်၊ «တင်သွင်း» က မည်သည့်ဖိုင် ဖွင့်မည်ကို မေးပြီး " +
        "၎င်းထဲ၌ ရှိသော အမှန်ခြစ်ထားသည့် အပိုင်းများကိုသာ သက်ရောက်စေသည်။ တင်သွင်းခြင်းသည် လက်ရှိ ဒေတာသို့ ပေါင်းထည့်သည် (ဖျက်ခြင်း မရှိ)။"
    override val backupSettings = "ဆက်တင်များ"
    override val backupSubs = "Subscription များ"
    override val backupHosts = "အသက်ဝင် host စာရင်း (မုဒ်အလိုက်)"
    override val exportWord = "ထုတ်ယူ"
    override val importWord = "တင်သွင်း"
    override val eraseAllHosts = "Host အားလုံး ဖျက်"
    override val factoryReset = "အားလုံး ပြန်လည်သတ်မှတ် (ပထမအကြိမ် စတင်သကဲ့သို့)"
    override val factoryResetConfirm = "အက်ပ်ကို စက်ရုံအခြေအနေသို့ အပြည့်အဝ ပြန်လည်သတ်မှတ်မလား။ ဆက်တင်အားလုံးနှင့် " +
        "host စာရင်းတစ်ခုလုံး ဖျက်ခံရမည်၊ subscription များကို မူရင်းအတိုင်း ပြန်လည်ရယူမည်။ ပထမအကြိမ် စတင်သကဲ့သို့။"
    override val resetCatalog = "စာရင်းနှင့် စာရင်းဇယားများ ပြန်လည်သတ်မှတ်"
    override val resetCatalogConfirm = "အဆင့်သတ်မှတ်ချက်, ကောင်တာနှင့် စစ်ဆေးမှု မှတ်တမ်းအားလုံးကို သုညပြုမလား။ " +
        "ဒေါင်းလုဒ်လုပ်ထားသော host များနှင့် subscription များကို ထိန်းသိမ်းပြီး နောက်စကင်တွင် ပြန်အဆင့်သတ်မှတ်သည်။"
    override val clearHosts = "ဒေါင်းလုဒ်လုပ်ထားသော host များ ရှင်း"
    override val clearHostsConfirm = "ဒေါင်းလုဒ်လုပ်ထားသော host (proxy) စာရင်းတစ်ခုလုံးကို ဖျက်မလား။ " +
        "Subscription များကို ထိန်းသိမ်းပြီး စကင်က pool ပြန်ဖြည့်မည်။"
    override val doReset = "ပြန်လည်သတ်မှတ်"
    override val doCancel = "ပယ်ဖျက်"
    override val adaptiveSpeed = "လိုက်လျောညီထွေ အမြန်နှုန်း"
    override val adaptiveHelp = "အသက်ဝင်မှု စစ်ဆေးမှုများသည် အခြေခံ ကြားကာလတွင် အလုပ်လုပ်သည် (\"စကင်နှင့် စစ်ဆေး\" မှ၊ " +
        "ကွန်ရက် မြှောက်ဖော်ကိန်းဖြင့်လည်း မြှောက်သည်)။ \"လိုက်လျောညီထွေ အမြန်နှုန်း\" သည် လက်ရှိ အသက်ဝင်နေသော proxy အရေအတွက် " +
        "ပေါ်မူတည်၍ ၎င်းတို့ကို အလိုအလျောက် မြန်စေ သို့မဟုတ် နှေးစေသည်။\n\n" +
        "• အသက်ဝင် နည်း (\"နည်း\" အဆင့်အောက်) → ကြားကာလ × \"မြန်စေ\"။ ၁ အောက် မြှောက်ဖော်ကိန်း = ပို " +
        "ခဏ: 0.5 — နှစ်ဆ ပိုခဏ၊ 0.25 — ၄ဆ။ pool ကို ပိုမြန်မြန် ဖြည့်သည်။\n" +
        "• အသက်ဝင် များ (\"များ\" အဆင့်အထက်) → ကြားကာလ × \"နှေးစေ\"။ ၁ အထက် = ပိုနည်း: 2 — " +
        "ထက်ဝက် ပိုနည်း၊ 4 — လေးပုံတစ်ပုံ။ ဘက်ထရီနှင့် traffic သက်သာစေသည်။\n" +
        "• အဆင့်များကြား — အခြေခံ အမြန်နှုန်း (×၁)။\n\n" +
        "ဥပမာများ:\n" +
        "— proxy ပိုမြန်မြန် စုဆောင်း: \"မြန်စေ\" 0.25 နှင့်/သို့မဟုတ် \"နည်း\" အဆင့် 40။\n" +
        "— လုံလောက်သည့်အခါ ဘက်ထရီ ချွေတာ: \"နှေးစေ\" 8 နှင့်/သို့မဟုတ် \"များ\" အဆင့် 30။\n" +
        "— လိုက်လျောညီထွေမှု ပိတ်: မြှောက်ဖော်ကိန်း နှစ်ခုလုံးကို 1 သို့ သတ်မှတ်။\n\n" +
        "မူရင်းတန်ဖိုးများ: နည်း 20, မြန်စေ 0.5, များ 50, နှေးစေ 4။"
    override val threshMany = "\"များ\" အဆင့်"; override val threshFew = "\"နည်း\" အဆင့်"; override val mulFast = "မြန်စေ ×"; override val mulLazy = "နှေးစေ ×"
    override val subIntensityTitle = "Subscription အပြင်းအထန်"
    override val subIntensityHint = "Subscription ဒေါင်းလုဒ်များကြား ခေတ္တရပ်: proxy စာရင်းများ ပြန်ဒေါင်းလုဒ်ရန် မိနစ်မည်မျှ ကြာမည် (ကွန်ရက်မုဒ်အလိုက် သီးခြားစီ)။"
    override val baseScanTitle = "အခြေခံ စကင် အမြန်နှုန်း"
    override val baseScanHelp = "ကိုးကားရန် အသက်ဝင်မှု-စစ်ဆေးမှု အမြန်နှုန်း။ «လိုက်လျောညီထွေ အမြန်နှုန်း» နှင့် «မုဒ်အလိုက် " +
        "အမြန်နှုန်း» မြှောက်ဖော်ကိန်းများကို ၎င်းနှင့် နှိုင်းယှဉ်၍ တွက်သည်။\n\n" +
        "• မည်မျှ မကြာခဏ လုပ်မည်, မိနစ် — စစ်ဆေးမှု အကြိမ်များကြား ကြားကာလ။\n" +
        "• Thread တစ်ခုလျှင် batch, host — thread တစ်ခုစီသည် တစ်ကြိမ်လျှင် host မည်မျှ စစ်ဆေးသည်။\n" +
        "• Thread များ — တစ်ပြိုင်နက် စစ်ဆေးမှု မည်မျှ လုပ်သည်။ တစ်ကြိမ်လျှင် «batch × thread» host များ စစ်သည်။\n" +
        "• Host တစ်ခုကို N မိနစ်တိုင်းထက် ပို၍ မစစ်နှင့် — anti-flood: မကြာသေးမီက စစ်ဆေးထားသော host ကို " +
        "ဤကြိမ်တွင် ကျော်လွှားသည်။\n\n" +
        "Thread ပိုများပြီး batch ပိုကြီးခြင်း = pool ပိုမြန်မြန် တိုးတက်သည် ဒါပေမယ့် ကွန်ရက်နှင့် ဘက်ထရီပေါ် ဝန် ပိုလေးသည်။"
    override val baseScanPeriod = "မည်မျှ မကြာခဏ လုပ်မည်, မိနစ်"
    override val baseScanBatch = "Thread တစ်ခုလျှင် batch, host"; override val baseScanThreads = "Thread အရေအတွက်"
    override val adaptiveDesc = "အသက်ဝင် proxy များသည် «နည်း» ထက် နည်းလျှင် သို့မဟုတ် «များ» ထက် များလျှင် ထပ်ဆောင်း မြှောက်ဖော်ကိန်း သက်ရောက်စေသည်။"
    override val fewWord = "နည်း"; override val manyWord = "များ"
    override fun fasterX(x: String) = "$x× ပိုမြန်"
    override fun slowerX(x: String) = "$x× ပိုနှေး"
    override fun ifAliveLt(n: Int) = "အသက်ဝင် proxy < $n ဆိုလျှင်:"
    override fun ifAliveGt(n: Int) = "အသက်ဝင် proxy > $n ဆိုလျှင်:"
    override val disabledWord = "ပိတ်"
    override val speedByModeTitle = "မုဒ်အလိုက် အမြန်နှုန်း"
    override val speedByModeHelp = "အခြေခံ အမြန်နှုန်းအပေါ်တွင် ကွန်ရက်မုဒ်တစ်ခုစီအတွက် စကင်-အမြန်နှုန်း မြှောက်ဖော်ကိန်း။ " +
        "«စံ» (×၁) = အခြေခံ ကြားကာလ။ ညာ — ပိုနည်း (ပိုနှေး၊ traffic/" +
        "ဘက်ထရီ ပိုသက်သာ)၊ ဘယ် — ပိုခဏ (ပိုမြန်၊ ပိုပြင်းထန်)။ Logarithmic စကေး၊ နှစ်ဖက်လုံး ×၁၀၀ " +
        "အထိ။\n\n" +
        "ဆလိုက်ဒါတစ်ခုစီအောက်တွင် လိုက်လျောညီထွေ အမြန်နှုန်း သက်ရောက်ထားသော ကြိမ်-ပါရာမီတာများ ရှိသည် — " +
        "«အသက်ဝင် နည်း» (× «မြန်စေ») နှင့် «အသက်ဝင် များ» (× «နှေးစေ») အတွက် သီးခြားစီ ပြသည်။\n\n" +
        "မုဒ်များ:\n• VPN — ပြင်ပ VPN အသက်ဝင်။\n• LTE — မိုဘိုင်းကွန်ရက်။\n• Wi-Fi — Wi-Fi ကွန်ရက်။\n" +
        "• Ethernet — ကြိုးတပ် ချိတ်ဆက်မှု။\n• White — ကိုယ်တိုင် «white» proxy မုဒ်။"
    override val aliveLt = "အသက်ဝင် <"; override val aliveGt = "အသက်ဝင် >"
    override val periodWord = "ကာလ"; override val nonstopWord = "မရပ်"
    override val batchWord = "batch"; override val threadsWord = "thread များ"; override val scanModeOff = "စကင် ပိတ်"
    override val netBattery = "ကွန်ရက်နှင့် ဘက်ထရီ"
    override val netBatteryHelp = "• Wi-Fi သာ — မိုဘိုင်းကွန်ရက်တွင် မစကင်နှင့် (ဒေတာ ချွေတာသည်)။\n• အားသွင်းနေချိန် " +
        "သာ — ဖုန်း အားသွင်းနေစဉ်သာ အလုပ်လုပ်ပါ။\n• ဘက်ထရီ နည်းချိန် ကျော်လွှား — ဘက်ထရီ နည်းသည့်အခါ စကင်ကို " +
        "ခေတ္တရပ်ပါ။"
    override val onlyWifi = "Wi-Fi သာ"; override val onlyCharging = "အားသွင်းနေချိန် သာ"; override val skipLowBattery = "ဘက်ထရီ နည်းချိန် ကျော်လွှား"
    override val autosaved = "ဆက်တင်များကို အလိုအလျောက် သိမ်းသည်။"
    override val dpiAutoLabel = "DPI နည်းများ အလိုအလျောက်လှည့်"; override val dpiNoneLabel = "DPI နည်းမရှိ (ရိုးရိုး)"
    override val experimental = "စမ်းသပ်"
    override val experimentalHelp = "MTProto upstream သို့ အစားထိုး proxy အင်ဂျင်များနှင့် ရောဂါရှာ မှတ်တမ်း။ " +
        "«ပိတ်» သို့ သတ်မှတ်ထားသည့်အခါ ကိုးကား (အလုပ်လုပ်နေသော) လမ်းကြောင်း မပြောင်းလဲပါ။ စာဝှက်ထားသော stream ကို " +
        "upstream TCP socket သို့ ရေးသားပုံ (segment အရွယ်, အချိန်ကိုက်, TLS-record နယ်နိမိတ်များ) သာ ပြောင်းသည် — stream ကိုယ်တိုင်က byte-for-byte တူညီနေသည်။ " +
        "အသက်ဝင် proxy ထပ်ဆင့်ပို့မှုသို့သာ သက်ရောက်သည် (စစ်ဆေးမှုများ မဟုတ်၊ တိုက်ရိုက်လမ်းကြောင်း မဟုတ်)။"
    override val expEngineTitle = "Proxy အင်ဂျင် (socket ဖုံးကွယ်ခြင်း)"
    override val expConnectTitle = "ချိတ်ဆက် အင်ဂျင် (upstream ရွေးချယ်ခြင်း)"
    override val raceWidthTitle = "ပြိုင်တူ ချိတ်ဆက်မှုများ"
    override val connectionSection = "ချိတ်ဆက်မှုနှင့် block ကျော်လွှားခြင်း"
    override val connectionSectionHelp = "ချိတ်ဆက် အင်ဂျင်, ပြိုင်တူ upstream များ, proxy အင်ဂျင်နှင့် anti-DPI နည်းများ — အားလုံး အပိုင်းတစ်ခုတည်းတွင်။"
    override val netLogSection = "ကွန်ရက် ဖလှယ်မှု မှတ်တမ်း"
    override val expEngineWarn = "⚠ စမ်းသပ်မုဒ်။ ချိတ်ဆက်မှု ပိုဆိုးလာပါက «ပိတ် (ကိုးကားလမ်းကြောင်း)» သို့ ပြန်ပြောင်းပါ။"
    override val netLog = "ကွန်ရက်-ဖလှယ်မှု မှတ်တမ်း ဖွင့်"
    override val netLogSub = "မည်သူ-မည်သူ့ထံ-မည်သည့်အချိန် နှင့် packet အရွယ်များကို ဖိုင်တစ်ခုသို့ ရေးသည် (payload ဒေတာ မပါ) — " +
        "VPN ဖြင့်/မဖြင့် ဖလှယ်မှု ပုံစံကို နှိုင်းယှဉ်ရန်။"
    override val openLogFolder = "မှတ်တမ်း ဖိုလ်ဒါ ဖွင့်"; override val copyPath = "Path ကူးယူ"
    override val helpShow = "အကူအညီ"; override val helpHide = "အကူအညီ ဖွက်"
    override val quickSwitchIntro = "ဤနေရာတွင် block-ကျော်လွှား နည်းတစ်ခု ရွေးနိုင်သည်။ Telegram က " +
        "“The proxy you are using is not configured correctly and will be disabled. Please find another " +
        "one” အမှားကို ပြလျှင် Telegram မပြတော့သည်အထိ မည်သည့် traffic-ဖုံးကွယ်ခြင်း အမျိုးအစား အလုပ်လုပ်သည်ကို " +
        "စမ်းသပ်ပါ။ split* မုဒ်များဖြင့် စတင်ပါ။ coalesce* မုဒ်များလည်း အလုပ်လုပ်သည် ဒါပေမယ့် ၎င်းတို့ဖြင့် Telegram တွင် ဓာတ်ပုံ/ဗီဒီယိုများ ညံ့ဖျင်းစွာ load ဖြစ်သည်။"
    override val quickSwitchTitle ="Block ကျော်လွှား"; override val quickSwitchSub = "Shaping, ချိတ်ဆက်, anti-DPI"

    override val sourceUrl = "ရင်းမြစ် URL"
    override fun sourceAlive(alive: Int, total: Int) = "အသက်ဝင် $alive/$total"
    override val open = "ဖွင့်"; override val active = "အသက်ဝင်"; override val inactive = "မလှုပ်ရှား"
    override val lastDownloaded = "ဒေါင်းလုဒ်ပြီး"; override val notDownloaded = "မဒေါင်းလုဒ်ရသေး"
    override fun sourceCounts(dead: Int, total: Int) =
        " အသက်ဝင်, $dead သေ, $total စုစုပေါင်း"

    override val proxyBase = "Proxy ဒေတာဘေ့စ်"
    override val totalInBase = "ဒေတာဘေ့စ်ထဲ စုစုပေါင်း"; override val aliveNow = "ယခု အသက်ဝင်"; override val deadStat = "သေ"
    override val aliveIn15 = "၁၅ မိနစ်အတွင်း အသက်ဝင်"; override val checksAllTime = "စစ်ဆေးမှု အချိန်အားလုံး"
    override val antiDpiTricks = "Anti-DPI နည်းများ"; override val noStatsYet = "ဒေတာ မရှိသေး — စစ်ဆေးမှု/ချိတ်ဆက်မှု ဖြစ်ပေါ်စဉ် နည်းများ စုဆောင်းသည်"
    override val attempts = "ကြိုးပမ်းမှုများ"; override val handshake = "Handshake"; override val score = "ရမှတ်"
    override val tgConnect = "TG ချိတ်ဆက်"; override val socketsOver1m = "Socket >၁မိနစ်"
    override val over10kb = "Socket >10KB"; override val over100kb = ">100KB"; override val workTime = "အလုပ်ချိန်"
    override val statsLegend = "Handshake — အောင်မြင်သော handshake များ (ကြိုးပမ်းမှု၏ %) · ရမှတ် — တန်ဖိုး · " +
        "\"အလုပ်ချိန်\" — socket ≥5KB နှင့် ၁ မိနစ်ထက် ကြာသော socket များ၏ စုစုပေါင်း။"
    override val resetStats = "နည်း စာရင်းဇယားများ ပြန်လည်သတ်မှတ်"

    override fun aliveLinks(n: Int) = "အသက်ဝင် လင့်ခ်များ: $n"
    override val copyAll = "အားလုံး ကူးယူ"
    override val openRandom = "ကျပန်း ဖွင့်"; override val copyRandom = "ကျပန်း ကူးယူ"; override val allShort = "အားလုံး"
    override val copyTop = "TOP ကူးယူ"; override val randomHost = "ကျပန်း host"
    override val exportToFile = "ဖိုင်သို့ ထုတ်ယူ"; override val exportSaved = "ဖိုင်သို့ သိမ်းပြီး:"
    override val dlNow = "ယခု ဒေါင်းလုဒ်"
    override fun downloadingFmt(sec: Long) = "ဒေါင်းလုဒ်လုပ်နေသည်… ${sec}s"
    override val cancel = "ပယ်ဖျက်"
    override val deleteConfirmTitle = "Subscription ဖျက်မလား။"
    override val subscriptionsAddHint = "Subscription များ သို့မဟုတ် proxy လင့်ခ်များ ထည့် →"
    override val addSourcesTitle = "ထည့်"
    override val addSubsLabel = "Subscription များ (တစ်ကြောင်းလျှင် URL တစ်ခု)"
    override val addSubsHelp = "မှန်ကန်သော URL ပါသော တစ်ကြောင်းစီသည် ၎င်း၏ subscription ဖြစ်လာပြီး အချိန်အလိုက် fetch လုပ်သည်။"
    override val addProxiesLabel = "အသင့်ဖြစ် proxy လင့်ခ်များ (သတ်မှတ်စာရင်း)"
    override val addProxiesHelp = "တိကျသော proxy များသို့ လင့်ခ်အစုတစ်ခု ကူးထည့်ပါ (tg://proxy, https://t.me/proxy, …)။ ဤသည် subscription မဟုတ်ပါ — စာရင်းကို ဘယ်တော့မှ မဒေါင်းလုဒ်ပါ၊ proxy များကို စာရင်းသို့ ထည့်ရုံသာ ဖြစ်သည်။"
    override val addButton = "ထည့်"
    override fun addedFmt(subs: Int, proxies: Int) = "ထည့်ပြီး: subscription $subs ခု, proxy $proxies ခု"
    override val perSecond = "တစ်စက္ကန့်လျှင်"
    override val graphSpeed = "အမြန်နှုန်း"
    override val graphVolume = "ပမာဏ"
    override val graphLatency = "Ping"
    override val graphConnects = "ချိတ်ဆက်မှုများ"
    override val scanNow = "ယခု စကင်"; override val scanOnShort = "စကင် ဖွင့်"
    override val scanRunning = "စကင် လုပ်နေသည်"; override val scanIdle = "စကင် အလုပ်မလုပ်"; override val scanOffState = "စကင် ပိတ်"; override val scanBatchPerThread = "Batch/thread"; override val scanPassHosts = "တစ်ကြိမ်တွင် host"; override val minRescanLabel = "Host တစ်ခုကို N မိနစ်တိုင်းထက် ပို၍ မစစ်နှင့်"
    override val scanPlanTitle = "အစီအစဉ်"; override val scanNowTitle = "ယခု"; override val currentScheduleTitle = "လက်ရှိ အချိန်ဇယား"
    override val scheduleWord = "အချိန်ဇယား"; override val unitPcsPerSec = "ခု/စက္ကန့်"
    override val scanNowThreadsLabel = "ယခု အလုပ်လုပ်နေသော thread"; override val scanNowPerThreadLabel = "Thread တစ်ခုလျှင် စစ်ဆေးမှု (အစီအစဉ်)"; override val scanNowElapsedLabel = "လုပ်ဆောင်ချိန်"
    override val scanOkGraph = "အောင်မြင်သော စကင်များ"; override val scanFailGraph = "ပျက်ကွက်သော စကင်များ"; override val scanTrafficGraph = "စကင် traffic"; override val scanAliveGraph = "အသက်ဝင် proxy စုစုပေါင်း"; override val scanPingGraph = "Ping"; override val threadsGraph = "Thread များ"
    override val scanEvery = "တိုင်း"; override val scanNextRun = "နောက်တစ်ကြိမ်"
    override val scanThreads = "Thread များ"; override val scanBatch = "Batch"
    override val scanElapsed = "လုပ်နေသည်"; override val scanIdleNow = "—"
    override val effForFew = "နည်းသည့်အခါ"; override val effForMany = "များသည့်အခါ"
    override val effCheck = "စစ်ဆေး"; override val effBatch = "Batch"; override val effPar = "ပြိုင်တူ"
    override val effContinuous = "ဆက်တိုက်"; override val secShort = "စ"; override val minShort = "မိနစ်"

    override val appTagline = "Cross-platform auto-connector: Telegram အလုပ်လုပ်နိုင်စေသော MTProto proxy များကို " +
        "ရှာဖွေ, စစ်ဆေး, လည်ပတ်စေသည်။"
    override val version = "ဗားရှင်း"; override val buildDate = "Build နေ့စွဲ"; override val platform = "Platform"
    override val downloadSources = "ဒေါင်းလုဒ်နှင့် ရင်းမြစ်များ"; override val openOnGithub = "GitHub တွင် ဖွင့်"
    override val feedbackBugs = "တုံ့ပြန်ချက်နှင့် bug အစီရင်ခံ"; override val writeTelegram = "Telegram တွင် ရေးပါ"

    override val language = "ဘာသာစကား"; override val langAuto = "အလိုအလျောက် (စနစ်)"; override val langRu = "Русский"; override val langEn = "English"
    override val langFa = "فارسی"; override val langZh = "简体中文"; override val langAr = "العربية"; override val langUr = "اردو"
    override val langTr = "Türkçe"; override val langId = "Bahasa Indonesia"; override val langHi = "हिन्दी"; override val langBn = "বাংলা"; override val langMy = "မြန်မာ"
    override val langWord = "ဘာသာစကား"

    override val scanModeTitle = "ကွန်ရက်မုဒ်"; override val scanModeAuto = "အလိုအလျောက်"; override val scanModeManualLabel = "ကိုယ်တိုင်"
    override val activeModeLabel = "အသက်ဝင် မုဒ်"; override val formingListLabel = "စာရင်း တည်ဆောက်နေသည်"; override val catalogModeTabs = "မုဒ်"
    override val resetModeRatings = "Host အဆင့်သတ်မှတ်ချက်များ ပြန်လည်သတ်မှတ်"; override val forgetModeHosts = "မုဒ် host များ မေ့ပစ်"
    override val exportModeTitle = "မုဒ်အလိုက် ထုတ်ယူ"; override val modePickerTitle = "မုဒ်"
    override val modeHelp = "ကွန်ရက်မုဒ်တစ်ခုစီသည် ၎င်း၏ ကိုယ်ပိုင် proxy အဆင့်သတ်မှတ်ချက်များနှင့် ၎င်း၏ ကိုယ်ပိုင် စကင် + subscription-ဒေါင်းလုဒ် အပြင်းအထန်ကို ထိန်းသိမ်းသည်။ «အလိုအလျောက်» သည် အသက်ဝင်ကွန်ရက်မှ မုဒ်ကို ရွေးသည်။ «ကိုယ်တိုင်» သည် မည်သည့်မုဒ်မဆို ကိုယ်တိုင် ရွေးခွင့်ပြုသည် (အလိုအလျောက်က ဘယ်တော့မှ မရွေးသော White အပါအဝင်)။"
    override val autoSelect = "အလိုအလျောက် ရွေး"; override val manualSelect = "ကိုယ်တိုင် ရွေး"
    override val connStatsTitle = "ယခု ချိတ်ဆက်မှုများ"; override val connOnPort = "Port ပေါ်ရှိ ချိတ်ဆက်မှုများ"; override val outgoingConns = "ထွက်သွားသော ချိတ်ဆက်မှုများ"
    override val modeChoice = "မုဒ် ရွေးချယ်ခြင်း"; override val autoChoice = "အလိုအလျောက်-ရွေး"; override val manualChoice = "ကိုယ်တိုင် သတ်မှတ်"
    override val directOnVpn = "VPN တွင် TG သို့ တိုက်ရိုက်ချိတ်ဆက်"; override val onWord = "ဖွင့်"; override val offWord = "ပိတ်"
    override val directStateActive = "အသက်ဝင်"; override val directStateOff = "ဆက်တင်တွင် ပိတ်"; override val directStateIdle = "ဆက်တင်တွင် ဖွင့်၊ ဒါပေမယ့် မလှုပ်ရှား"
    override val wpHintTitle = "White ဆိုတာ ဘာလဲ။"
    override val wpHint = "White — WhitePages: ကိုယ်တိုင် ကွန်ရက် ပရိုဖိုင်။ လက်ဖြင့်သာ ဖွင့်သည် (အလိုအလျောက်-ရွေးက ဘယ်တော့မှ မရွေး)။ " +
        "၎င်း၏ ကိုယ်ပိုင် host အဆင့်သတ်မှတ်ချက်များ ထိန်းသိမ်းသည်၊ subscription များ ဒေါင်းလုဒ်လုပ်ပြီး VPN/Wi-Fi/LTE နှင့် သီးခြားစွာ စကင်ဖတ်သည်။"

    override val recentAttempts = "မကြာသေးမီက ချိတ်ဆက်မှုနှင့် စစ်ဆေးမှုများ"
    override val kindCheck = "စစ်ဆေး"
    override val kindTg = "telegram"
    override val histWho = "ဘယ်သူ"
    override val histWhen = "အချိန်"
    override val histReq = "တောင်းဆို"
    override val histSess = "ဆက်ရှင်"
    override val histScan = "စကင်"
    override val testNow = "ယခု စမ်းသပ်"
    override val testShort = "စမ်းသပ်"
    override val testResult = "စမ်းသပ်မှု ရလဒ်"
    override val testStop = "ရပ်"
    override val testingNow = "စမ်းသပ်နေသည်…"
    override val prewarmTitle = "Socket ကြိုနွေးခြင်း (စမ်းသပ်)"
    override val prewarmHelp = "proxy သို့ socket အနည်းငယ်ကို ကြိုတင် ဖွင့်ထားခြင်းဖြင့် Telegram ချိတ်ဆက်မှုအသစ်တစ်ခုသည် " +
        "connect/handshake ကို ကျော်နိုင်စေသည်။ စမ်းသပ်ချက်: နောက်ခံတွင် အဆက်မပြတ် ပြန်ချိတ်ဆက်နေသည် → traffic နှင့် CPU " +
        "အနည်းငယ် ကုန်သည်။ အတုအယောင် traffic မပို့ပါ (၎င်းသည် တကယ့်ဆက်ရှင်ကို ပျက်စီးစေမည်) — socket များကို ရိုးရိုး " +
        "လှည့်ပတ်သည်သာ။ FakeTLS proxy များနှင့် အသုံးအဝင်ဆုံး။"
    override val prewarmEnable = "ကြိုနွေးခြင်း ဖွင့်"
    override val prewarmModeDeferred = "ရွှေ့ဆိုင်း (TLS သာ)"
    override val prewarmModeDeferredSub = "TCP + FakeTLS ထိန်းသည်; obfuscated2-init ကို လွှဲပြောင်းချိန်တွင် ဖြည့်ပို့သည်။ DC မ commit လုပ်ပါ — အပြည့်အဝ ဆီလျော်ဆုံး။"
    override val prewarmModeFull = "Handshake အပြည့်"
    override val prewarmModeFullSub = "မတူညီသော DC များအလိုက် အပြည့်အဝ ချိတ်ဆက်ထားသော socket များ ထိန်းသည်; DC/tag ကိုက်ညီမှသာ ပြန်သုံးသည်။ သက်တမ်း ပိုတိုသည်။"
    override val prewarmPoolLabel = "အရံ socket များ"
    override val prewarmHoldLabel = "တစ်ခုစီ ထိန်း, စက္ကန့်"
    override val prewarmNote = "လှည့်ပတ်ခြင်းသာ (အက်ပ်အဆင့် keepalive မရှိ)။ Socket သည် စက္ကန့်အနည်းငယ်…~တစ်မိနစ်ခန့် သက်တမ်းရှိ၊ proxy/DC ပေါ် မူတည်သည်။"
    override val prewarmStatus = "ကြိုနွေး"
    override fun prewarmStatusVal(ready: Int, holdSecs: Int) = "${ready} အသင့် · ${holdSecs}စ ထိန်း"
    override val prewarmStar = "လိမ္မော်ရောင် ထူ = ကြိုနွေး pool မှ နွေးထွေးစွာ ပေးအပ်လိုက်သော socket (connect/handshake မပါ)"
    override fun prewarmTableTitle(holdSecs: Int) = "Socket ကြိုနွေးခြင်း (${holdSecs}စ ထိန်း)"
    override val prewarmTableHelp = "«Socket ကြိုနွေးခြင်း» သည် proxy သို့ socket အနည်းငယ်ကို ကြိုတင်ဖွင့်ပေးပြီး Telegram " +
        "ချိတ်ဆက်မှုအသစ်တစ်ခုသည် connect/handshake ကို ကျော်နိုင်စေသည်။ ဤဇယားတွင် ကြိုနွေးနေသော host များ ပြသည်: socket တစ်ခု " +
        "စက္ကန့်မည်မျှ သက်တမ်းရှိ၊ Telegram က ၎င်းကို သုံးနေသလား၊ နှင့် traffic။ ဖွင့်/ပိတ်ခြင်းနှင့် (မုဒ်, socket အရေအတွက်, " +
        "ထိန်းချိန်) ချိန်ညှိခြင်းကို «နောက်ထပ် → ဆက်တင်များ → „Socket ကြိုနွေးခြင်း (စမ်းသပ်)“» တွင် လုပ်နိုင်သည်။"
    override val prewarmNoneWarming = "ကြိုနွေးနေသော socket မရှိသေး"
    override val prewarmColAge = "သက်တမ်း"
    override val prewarmColUse = "TG တွင်လား။"
    override val prewarmInUse = "TG တွင်"
    override val prewarmNew = "အသစ်"
    override val lanShareTitle = "LAN ပေါ်တွင် မျှဝေ (web portal)"
    override val lanShareDesc = "ဤ Wi-Fi ရှိ အခြားစက်ပစ္စည်းများကို ဤ AutoConnector ကို proxy အဖြစ် သုံးခွင့်ပြုသည်; အောက်ပါ လိပ်စာသို့ browser ဖြင့် ဝင်လျှင် အကောင်းဆုံး proxy များပါသော စာမျက်နှာ ရရှိမည်။"
    override val lanShareUrlsLabel = "အိမ်နီးချင်းများ ချိတ်ဆက်ရန်:"
    override val lanShareNoIp = "local ကွန်ရက် လိပ်စာ မရှိ — Wi-Fi သို့ ချိတ်ဆက်ပါ"
    override val lanFirewallTitle = "Local ကွန်ရက်တွင် ခွင့်ပြု"
    override val lanFirewallBody = "ဖွင့်လိုက်လျှင် ထပ်ဆင့်ပို့ port များသည် local ကွန်ရက်သို့ ပွင့်မည်။ ယခု Windows (သို့မဟုတ် အခြား) firewall က AutoConnector ကို ခွင့်ပြုမလားဟု မေးနိုင်သည် — «ခွင့်ပြု»/«ဟုတ်» ကို ရွေးပါ။ ငြင်းပယ်လျှင် AutoConnector သို့ အိမ်နီးချင်းများ၏ traffic ကို ပိတ်ဆို့မည်ဖြစ်ပြီး စာမျက်နှာ/proxy ကို မရရှိနိုင်ပါ။"
    override val lanFirewallConfirm = "ဖွင့်"
    override val lanInfoTitle = "ဒါက ဘာအတွက်လဲ။"
    override val lanInfoBody = "သင့် Wi-Fi ရှိ ကွန်ပျူတာ သို့မဟုတ် ဖုန်း တစ်လုံးတည်းတွင် AutoConnector ကို လည်ပတ်ပါ — ထို့နောက် တူညီသော ကွန်ရက်ရှိ အခြားစက်ပစ္စည်းအားလုံး၊ (ဤအက်ပ် တိုက်ရိုက် မထောက်ပံ့သော) iPhone အပါအဝင်၊ browser တွင် လိပ်စာကို ဖွင့်ပြီး သုံးနိုင်သည်: ၎င်းတို့၏ Telegram တွင် ထည့်ရန် အကောင်းဆုံး proxy များပါသော စာမျက်နှာ၊ သို့မဟုတ် ဤစက်ပစ္စည်းကိုယ်တိုင်ကို SOCKS proxy အဖြစ်။ စက်ပစ္စည်းတစ်လုံးက proxy များ ရှာဖွေ ထိန်းသိမ်းပြီး၊ ကျန်အရာများက ၎င်းကို local ကွန်ရက်မှတစ်ဆင့် သုံးသည်။"
    override val volTriggerTitle = "Volume ခလုတ် trigger"
    override val volTriggerSub = "Volume ကီး pattern မြန်မြန်ဖြင့် proxy ပြောင်းခြင်း"
    override val volEnableLabel = "Volume ခလုတ်များ စောင့်ကြည့်"
    override val volHelpTitle = "ဒါက ဘာလဲ။"
    override val volHelpBody = "Android တွင် global keyboard hotkey မရှိသဖြင့် ၎င်းအစား VOLUME ခလုတ်များကို သုံးသည်။ ဖွင့်ထားစဉ် AutoConnector သည် Volume-တိုး/လျှော့ နှိပ်မှု pattern မြန်မြန် (ဥပမာ တိုး-တိုး-လျှော့-လျှော့) ကို နောက်ခံတွင် စောင့်ကြည့်သည်။ တစ်ခုကို မှတ်မိသည့်အခါ ကျပန်း ကောင်းမွန် အသက်ဝင်သော proxy တစ်ခု၏ tg:// လင့်ခ်ကို ဖွင့်ပေးသဖြင့် Telegram က ၎င်းကို ဖမ်းယူပြီး ပြောင်းသည် — အက်ပ်ကို မဖွင့်ဘဲ proxy လှည့်ရန် မြန်ဆန် မထင်ရှားသော နည်းလမ်း။ Volume သည် ပုံမှန်အတိုင်း ဆက်အလုပ်လုပ်သည် (နှိပ်မှုများ မဖမ်းယူပါ)။ ၎င်းသည် Accessibility ဝင်ရောက်ခွင့် လိုအပ်သည် (နောက်ခံတွင် volume ကီးများ ဖတ်ရန်နှင့် လင့်ခ် ဖွင့်ရန်); switch ကို မဖွင့်မချင်း ဘာမှ မတောင်းဆိုပါ။ နှိပ်မှုများကြား အများဆုံးအချိန်ကို အောက်တွင် သတ်မှတ်ပါ; မှတ်မိသော pattern များကို အောက်ဆုံးတွင် ဖော်ပြထားသည်။"
    override val volGrantTitle = "Accessibility ဖွင့် (အရေးကြီး)"
    override val volGrantBody = "Android (အထူးသဖြင့် 13+) သည် Google Play မှ မထည့်သွင်းထားသော အက်ပ်များအတွက် Accessibility ကို ပိတ်ဆို့သည် — ထို့ကြောင့် AutoConnector သည် မီးခိုးရောင်ဖြစ်ပြီး «Restricted setting» / «ဝင်ရောက်ခွင့် မပြု» ဟု ပြသည်။\n\nဖွင့်နည်း:\n1. «App info» ကို ဖွင့်ပါ (အောက်ပါ ခလုတ်၊ သို့မဟုတ်: Settings → Apps → AutoConnector for Telegram)။\n2. ⋮ (အပေါ်ညာ အစက်သုံးစက်) ကို နှိပ် → «Allow restricted settings» → အတည်ပြုပါ။\n3. ပြန်သွားပါ: Settings → Accessibility → AutoConnector for Telegram → ဖွင့်ပါ။\n\n«Allow restricted settings» မတွေ့လျှင် — ဦးစွာ Accessibility တွင် switch ကို တစ်ကြိမ် ဖွင့်ကြည့်ပါ (ပိတ်ဆို့ထားသော မက်ဆေ့ဂျ် ပေါ်လာမည်)၊ ထို့နောက် အဆင့် 2 ရရှိနိုင်မည်။\n\nXiaomi/MIUI, Samsung စသည်တို့တွင် လမ်းကြောင်း အနည်းငယ် ကွဲပြားနိုင်သည် — «App info» ထဲတွင် တူညီသော ⋮ ကို ရှာပါ။ Android 12 နှင့် အဟောင်းများတွင် ကန့်သတ်ချက် များသောအားဖြင့် မရှိ — Accessibility တွင် ချက်ချင်း ဖွင့်ပါ။\n\nVolume ကီးများကို စောင့်ကြည့်ရုံသာ၊ ဘယ်တော့မှ မပိတ်ဆို့ပါ။"
    override val volOpenAppInfo = "App info ဖွင့်"
    override val volAccessOn = "Accessibility: ခွင့်ပြုပြီး"
    override val volAccessOff = "Accessibility: ခွင့်မပြုရသေး"
    override val volOpenAccess = "Accessibility ဆက်တင်များ ဖွင့်"
    override val volGapLabel = "နှိပ်မှုများကြား အများဆုံး ms"
    override val volPatternsTitle = "မှတ်မိသော pattern များ"
    override val volPatternPick = "Pattern"
    override val volPatternsLegend = "↑ = volume တိုး, ↓ = volume လျှော့"
    override val volNoRights = "အက်ပ်တွင် volume ခလုတ်များ ကိုင်တွယ်ရန် ခွင့်ပြုချက် မရှိသေး — စာမျက်နှာအောက်ရှိ ညွှန်ကြားချက်အတိုင်း ဝင်ရောက်ခွင့် ပေးပါ။"
    override val volGrantShort = "Accessibility ဝင်ရောက်ခွင့် မရသေး။ ဤစာမျက်နှာအောက်ရှိ အသေးစိတ် ညွှန်ကြားချက်ကို ဖတ်ပြီး «စစ်ဆေး» ကို နှိပ်ပါ။"
    override val volCheck = "စစ်ဆေး"
    override val volCheckOk = "✓ ပြီး — ဝင်ရောက်ခွင့် ရပြီ၊ trigger အလုပ်လုပ်သည်။"
    override val volCheckFail = "✗ ဝင်ရောက်ခွင့် မရသေး — အထက်ပါ အဆင့်များ ပြီးအောင်လုပ်ပါ။"
    override val volPatternsList = "↑↑↓↓ · ↓↓↑↑ · ↑↓↑↓ · ↓↑↓↑ · ↑↑↑↑ · ↓↓↓↓ · ↑↓↓↑ · ↓↑↑↓ · ↑↑↑↓↓↓ · ↓↓↓↑↑↑   (↑ = volume တိုး, ↓ = volume လျှော့)"
    override val histLegend = "ကော်လံများ — ဘယ်သူ: ✓/✗ TG = တကယ့် Telegram ချိတ်ဆက်မှု, စကင် = နောက်ခံ စစ်ဆေးမှု။ အချိန်: လွန်ခဲ့သည့်အချိန်။ TCP/TLS/တောင်းဆို: handshake နှင့် ပထမတောင်းဆိုမှု နှောင့်နှေးချိန်, ms။ ဆက်ရှင်: ထပ်ဆင့်ပို့ ဆက်ရှင် ကြာချိန်။ ↓/↑: host မှတစ်ဆင့် လက်ခံ / ပို့ bytes။"
    override val tgOkTotalHint = "Telegram ချိတ်ဆက်မှု / အောင်မြင် / စစ်ဆေးမှု စုစုပေါင်း"
    override val breadthTitle = "Host ရွေးချယ်မှု အကျယ်"
    override val breadthHelp = "ဘယ်ဘက် — အကောင်းဆုံး စစ်ဆေးပြီး host များကို ကိုင်စွဲ; ညာဘက် — အသက်ဝင်သော အမျိုးမျိုးကို တတ်နိုင်သမျှ ကျယ်ကျယ် စမ်းသပ်။ Telegram သည် ထပ်ဆင့်ပို့ port များကြား ပြောင်းနေသည့်အခါ အက်ပ်သည် ရွေးချယ်မှုကို အလိုအလျောက် ချဲ့ထွင်သည်။"
    override val breadthNarrow = "သက်သေပြ"
    override val breadthWide = "အကျယ်ဆုံး"
    override val connTimeoutTitle = "Host တစ်ခုစီ ချိတ်ဆက် timeout"
    override val connTimeoutHelp = "နောက် proxy ကို မစမ်းမီ upstream တစ်ခု (TCP + TLS + ပထမ MTProto တုံ့ပြန်ချက်) ကို မည်မျှ စောင့်မည်။"

    override val backupExportTitle = "ဒေတာ ထုတ်ယူ"
    override val backupImportTitle = "ဒေတာ တင်သွင်း"
    override val backupSelectExport = "ဘာ ထုတ်ယူမည်:"
    override val backupSelectImport = "ဘာ တင်သွင်းမည်:"
    override val backupCopyBtn = "ကူးယူ"
    override val backupSaveFile = "ဖိုင်သို့ သိမ်း"
    override val backupLoadFile = "ဖိုင်မှ ဖွင့်"
    override val backupDoImport = "တင်သွင်း"
    override val backupPasteLabel = "Backup JSON ကို ဤနေရာတွင် ကူးထည့်ပါ"
    override val backupJsonLabel = "Backup JSON"
    override val backupAndroidFileNote = "ဤနေရာတွင် ဖိုင်များ မရရှိ — ကူးယူ / ကူးထည့် ကို သုံးပါ။"

    override val factoryResetDone = "အားလုံး ပြန်လည်သတ်မှတ်ပြီး။ အက်ပ်ကို ပိတ်ပြီး ပြန်ဖွင့်ပါ။"
}
