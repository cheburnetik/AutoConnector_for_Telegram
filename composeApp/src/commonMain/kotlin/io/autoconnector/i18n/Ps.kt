package io.autoconnector.i18n

object Ps : Strings by En {
    override val tabConnector = "نښلوونکی"; override val tabScan = "سکن"
    override val tabCatalog = "کټلاګ"; override val tabLogs = "لاګونه"; override val tabMore = "نور"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "ګډونونه"; override val logTabScan = "سکن"
    override val logGeneral = "عمومي"; override val logEmpty = "اوس مهال خالي"
    override val logSessions = "ناستې"; override val logErrorsOnly = "یوازې له تېروتنو سره"; override val logNoErrors = "د تېروتنې هیڅ ناسته نشته"
    override fun logSession(id: String, port: String) = "#${id} · :${port}"
    override val back = "شاته"; override val copy = "کاپي"; override val gotIt = "پوه شوم"
    override val later = "وروسته"; override val details = "نور جزئیات"; override val whatIsThis = "دا څه دي؟"
    override val delete = "ړنګول"

    override val connector = "نښلوونکی"; override val scan = "سکن"
    override val notConfigured = "نه دی تنظیم شوی! سم یې کړئ →"; override val howToSetup = "څنګه یې تنظیم کړو"
    override val notifOff = "خبرتیاوې بندې دي! سم یې کړئ →"; override val enable = "فعالول"
    override fun fewProxies(n: Int) = "ژوندي پراکسۍ ${n}، لټون روان دی، ~۱۵ دقیقې انتظار وکړئ…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "ژوندي پراکسۍ: ${alive}  (۱۵ دقیقې: ${within}) · ټول: ${total}"
    override val notifWhyTitle = "خبرتیاوې ولې؟"
    override val notifWhyBody = "د دایمي آیکون لرونکې خبرتیا د Android یوه foreground خدمت ده. " +
        "پرته له هغې، سیسټم اپلیکیشن له حافظې څخه ایستي او هغه د پراکسیو لټون او په شاليد کې د " +
        "اړیکې ساتل بندوي. له همدې امله د AutoConnector د کار لپاره خبرتیاوې اړینې دي."
    override val notifEnableTitle = "خبرتیاوې فعالې کړئ"
    override val notifEnableBody = "د خبرتیا آیکون پرته، Android اپلیکیشن غیرفعال ګڼي او هغه له " +
        "حافظې څخه ایستي. بیا AutoConnector د پراکسیو لټون او په شاليد کې د اړیکې ساتل بندوي — " +
        "Telegram خپله اړیکه له لاسه ورکوي.\n\nپه «فعالول» کلیک وکړئ او د AutoConnector لپاره " +
        "خبرتیاوې اجازه ورکړئ."
    override val notifPlea = "خبرتیاوې فعالې کړئ! پرته له هغو اپلیکیشن په شاليد کې نه شي کار کولی — " +
        "Android به یې وباسي، د پراکسۍ لټون او اړیکه به ودریږي."

    override val statusConnected = "Telegram وصل شو"; override val statusConnecting = "نښلول روان دي…"
    override val statusOffline = "Telegram نه دی وصل"; override val statusIdle = "Telegram چوپ دی"
    override val nobodyConnected = "هیڅوک نښلوونکي ته ونه نښلید. "; override val howToSetupArrow = "څنګه یې تنظیم کړو →"
    override val directModeViaVpn = "مستقیم حالت: VPN فعال دی — پراکسۍ نشته"
    override val directModeOff = "مستقیم حالت: پراکسۍ بندې دي"
    override val directDpiSuffix = " · ضد-DPI"
    override val connections = "اړیکې"; override val sockets = "ساکټونه"; override val speed = "سرعت"
    override val traffic = "ترافیک"; override val latency = "ځنډ"
    override fun pcs(n: Int) = "${n} دانې"
    override fun netNow(label: String) = "شبکه: ${label}"
    override fun tgToConnector(n: Int) = "TG→ ${n}"
    override fun connectorToProxy(n: Int) = "پراکسۍ ${n}"
    override val trafficSec = "ترافیک · ۶۰ ثانیې"; override val trafficMin = "ترافیک · ۶۰ دقیقې"
    override val latencySec = "ځنډ · ۶۰ ثانیې"; override val latencyMin = "ځنډ · ۶۰ دقیقې"
    override val sec60 = "۶۰ ثانیې"; override val min60 = "۶۰ دقیقې"
    override val unitSec = "ث"; override val unitMin = "دق"; override val unitHour = "س"; override val dash = "—"
    override val currentProxy = "اوسنۍ پراکسۍ"; override val noActiveProxy = "هیڅ فعاله پراکسۍ نشته (Telegram نه دی وصل)"
    override val host = "هوسټ"; override val type = "ډول"; override val secret = "راز"; override val antiDpi = "ضد-DPI"; override val obfEngine = "د پټولو انجن"
    override fun activeSockets(n: Int) = "د Telegram فعال ساکټونه: ${n}"
    override val noConnections = "هیڅ فعاله اړیکه نشته"; override val colHost = "هوسټ"; override val colTime = "وخت"
    override val modeWord = "حالت"; override val directViaVpnLine = "Telegram ته مستقیمې غوښتنې (VPN فعال دی)"
    override val connModeHelp = "حالتونه (VPN, Wi-Fi, LTE, Ethernet, White) تاسو ته اجازه درکوي چې د سکن شدت په بیلابیل ډول تنظیم کړئ او د هوسټونو جلا درجه‌بندي/احصایه ساتي. د شبکې کارت په اتومات ډول پیژندل کیږي؛ حالت په تنظیماتو کې لاسي تنظیمولی شئ."

    override val scanOff = "سکن بند دی"; override val proxiesInBase = "په ډیټابیس کې پراکسۍ"
    override val total = "ټول"; override val alive = "ژوندي"; override val dead = "مړه"
    override val tgConnectedTitle = "Telegram وصل شو له لارې"; override val successful = "بریالی"
    override val socketsHeld = "د ساکټ ژوند موده"; override val over1m = ">۱ دقیقه"; override val over5m = ">۵ دقیقې"; override val over15m = ">۱۵ دقیقې"
    override val scanCountTitle = "د پراکسۍ چکونو شمیر"; override val checked = "چک شوي"
    override val forAllTime = "د ټول وخت"; override val perMinute = "په دقیقه کې"; override val perHour = "په ساعت کې"
    override val subsCountTitle = "د ګډونونو د ډاونلوډ شمیر"; override val downloaded = "ډاونلوډ شوي"; override val failed = "ناکام"; override val scanTraffic = "د سکن ترافیک"; override val subTraffic = "د ګډون ترافیک"; override val subTrafficGraph = "د ګډون ترافیک"
    override val checksMtproto = "د MTProto چکونه (↑ ok · ↓ fail)"

    override fun catalogEmpty(mode: String) = "کټلاګ ${mode} اوس مهال خالي دی. یا هیڅ هوسټ ونه موندل شو، یا اپلیکیشن هیڅکله په دې حالت کې نه دی کار کړی. حالت په تنظیماتو کې بدلولی شئ. حالتونه ځکه شته چې د انټرنیټ د بیلابیلو ډول اړیکو لپاره هوسټونه جلا جلا راټول کړي."
    override val aliveShort = "✓ ژوندی"; override val deadShort = "✗ مړ"
    override val statusLabel = "حالت"; override val rating = "درجه"; override val port = "پورټ"
    override val rttPing = "RTT (پنګ)"; override val checkedField = "چک شوی"; override val okOfTotal = "بریالي / ټول چکونه"
    override val tgConnectedField = "Telegram وصل شو"; override val tgSessions = "د Telegram ناستې"; override val trafficThroughProxy = "د پراکسۍ له لارې ترافیک"
    override val sessionsTotal = "ټولې ناستې"; override val relayNow = "اوس ریلې"; override val tlsDomain = "د TLS ډومین (SNI)"
    override val sourceSub = "سرچینه (ګډون)"; override val lastError = "وروستۍ تېروتنه"; override val yes = "هو"; override val no = "نه"
    override val copyAsLink = "د لینک په توګه کاپي کړئ"; override val openInTelegram = "هوسټ په Telegram کې پرانیزئ"; override val makeNextRelay = "راتلونکی ریلې یې جوړ کړئ"
    override val actCopy = "کاپي"; override val actOpen = "پرانیستل"; override val actRelay = "ریلې"
    override fun agoFmt(v: String) = "${v} دمخه"
    override val catalogTopFor = "د پراکسیو لیست/درجه‌بندي د"
    override val catalogModeHelpTitle = "حالتونه او درجه‌بندي"
    override val catalogModeHelp = "اپلیکیشن ژوندي هوسټونه او د هغوی درجه‌بندي د هرې شبکې حالت لپاره جلا جلا (VPN, Wi-Fi, LTE, Ethernet او White) شمیري. «White» د سپینو لیستونو لپاره یو جلا لاسي حالت دی؛ اتومات هیڅکله هغه ته نه اوړي. نو همغه هوسټ کیدای شي په یو حالت کې ژوندی او په بل کې مړ وي."
    override fun catalogInactiveWarn(section: String, active: String) =
        "تاسو اوس غیرفعاله برخه ${section} ګورئ — ټوله احصایه همدا اوس ${active} ته ځي، دلته نه."
    override val manageModeTitle = "د حالت اداره"
    override val manageResetRating = "درجه صفر کړئ"
    override fun manageResetHint(mode: String) = "د ${mode} لپاره په ځانګړي ډول کولی شئ د ژوندیو هوسټونو درجه او د کارونې احصایه صفر کړئ. دا ګټوره ده کله چې تاسو بل بیخي بل VPN یا LTE ته وصل شوي یاست، ترڅو زاړه احصایه مداخله ونه کړي. یا د دې لیدلو لپاره چې د پراکسۍ سکن څومره ژر هرڅه له سره چک کوي."
    override val manageDeleteAll = "هوسټونه ړنګ کړئ په"
    override fun manageDeleteHint(mode: String) = "تاسو کولی شئ هم درجه او هم پخپله هوسټونه له ${mode} څخه پاک کړئ. د «پراکسۍ سکن» فیچر به یې بیا راټول کړي. دا د ګډونونو صفرول نه دي — کلیک یې کولی شئ، بیا د بیا سکن لپاره ~۱۵ دقیقې انتظار وکړئ."
    override fun manageCopyFrom(mode: String) = "ټول هوسټونه او درجه‌بندي په دې حالت (${mode}) کې له بل حالت څخه کاپي کړئ:"
    override val live = "ژوندی"; override val deadW = "مړ"; override val unitMs = "ms"
    override val agoMin = "دق"; override val agoHour = "س"; override val agoDay = "ورځ"

    override val connectTelegram = "د Telegram نښلول"; override val readCarefully = "په پاملرنه ولولئ!"
    override val guideIntro = "دا اپلیکیشن پرته له تنظیم نه کار کوي. لاندې له ۳ اختیارونو څخه " +
        "هر یو وټاکئ او لارښوونې په پاملرنه ترسره کړئ."
    override val variant1 = "اختیار #۱ — تڼۍ"
    override val variant1Body = "په «پراکسۍ {A}» کلیک وکړئ — Telegram پرانیستل کیږي، د پراکسۍ زیاتول " +
        "تایید کړئ. دې پردې ته راستون شئ او په «پراکسۍ {B}» کلیک وکړئ — دویم ځل زیاتول تایید کړئ.\n\n" +
        "په Telegram کې هره بله زړه پراکسۍ بنده کړئ. باید دقیقاً ۲ پراکسۍ پاتې شي — د پورټونو {A} او {B} " +
        "سره. د بل هر سیټ سره AutoConnector کار نه کوي."
    override val variant2 = "اختیار #۲ — لینکونه"
    override val variant2Body = "لاندې متن په Telegram کې خوندي پیغامونو (یا هر چټ) ته کاپي کړئ — " +
        "یعنې ځان ته یې ولیږئ. په خپل پیغام کې لومړی لینک کلیک کړئ — لومړۍ پراکسۍ زیاتیږي. " +
        "دویم لینک کلیک کړئ — دویمه زیاتیږي. بیا ټولې زړې پراکسۍ بندې کړئ."
    override val variant3 = "اختیار #۳ — لاسي"
    override val variant3Body = "د SOCKS5 پراکسۍ لاسي زیاته کړئ: سرور localhost (127.0.0.1)، پورټ {A}. " +
        "بیا دویمه پراکسۍ: localhost، پورټ {B}. هره زړه پراکسۍ ړنګه کړئ."
    override val whatNext = "بیا څه؟"
    override val whatNextBody = "په Telegram کې «د پراکسۍ اتومات بدلون» فعال کړئ — ۵ ثانیې. تاسو کولی شئ " +
        "Telegram سره د نښلولو مرسته وکړئ که په لاسي ډول هغه پراکسۍ کلیک کړئ (د Telegram دننه) چې فعاله " +
        "نه ده یا «نشته» نښه شوې — دا Telegram اړ باسي چې د نښلولو لپاره ډیر هڅه وکړي.\n\n" +
        "ډاډ ترلاسه کړئ چې له {A} او {B} پرته نورې ټولې زړې پراکسۍ ړنګې شوي. په Telegram کې " +
        "«پراکسۍ وکاروئ» کلیک کړئ.\n\nانتظار وکړئ ترڅو اپلیکیشن کافي پراکسۍ ومومي او ډاونلوډ کړي " +
        "(۵–۱۵ دقیقې). بیا Telegram پخپله AutoConnector ته وصل کیږي، چې Telegram به تل د غوره پراکسیو " +
        "له لارې مسیر کوي: تایید شوي، ژوندي او چټک.\n\nکه لارښوونې ستونزمنې ښکاري — بښنه غواړو، تاسو به " +
        "ونه شئ کولی اپلیکیشن وکاروئ: هرڅه په اتومات ډول تنظیمول ناشوني دي، او د ژوندیو پراکسیو موندل " +
        "وخت نیسي.\n\nکه تاسو ډیر وخت دمخه اپلیکیشن ډاونلوډ کړی وي او هیڅ ژوندۍ پراکسۍ ونه موندل شوه — " +
        "یا اپلیکیشن یا د ګډونونو لیست تازه کړئ. دا اپلیکیشن خپلې پراکسۍ نه جوړوي او نه وړاندې کوي، " +
        "یوازې په انټرنیټ کې د لسګونو ګروپونو او پاڼو په منځ کې لټوي."
    override fun proxyBtn(port: Int) = "پراکسۍ ${port}"

    override val setupPortsTitle = "په Telegram کې د پورټونو تنظیم"
    override val setupPortsSub = "څنګه Telegram نښلوونکي ته وصل کړئ (پورټونه 55001/55002)"
    override val settings = "تنظیمات"; override val settingsSub = "پورټونه، ضد-DPI، سکن، شبکه، بطرۍ"
    override val subscriptions = "ګډونونه"; override val subscriptionsSub = "د سکن لپاره د پراکسۍ سرچینې"
    override val statistics = "احصایه"; override val statisticsSub = "د پراکسۍ ډیټابیس + د ضد-DPI ترفندونه"
    override val export = "صادرول"; override val exportSub = "د ژوندیو پراکسیو tg:// لینکونه"
    override val about = "په اړه"; override val aboutSub = "نسخه، بیلډ، ډاونلوډ، نظر"
    override val hotkeys = "تود کیلي"
    override val hotkeysSub = "نړیوال کیلي: د پراکسۍ کاپي / پرانیستل"
    override val hotkeysIntro = "نړیوال تود کیلي حتی هغه وخت کار کوي کله چې د اپلیکیشن کړکۍ په فوکس کې " +
        "نه وي. هغوی له پول څخه یوه تصادفي ژوندۍ پراکسۍ لینک (tg://) اخلي — د اپلیکیشن پرته د پراکسیو " +
        "د چټک بدلون لپاره ګټور."
    override val hotkeysNote = "په macOS کې، د کیليو نیول ممکن د Accessibility اجازې ته اړتیا ولري " +
        "(System Settings → Privacy & Security → Accessibility)."
    override val hotkeyCopyTitle = "د پراکسۍ لینک کاپي کړئ"
    override val hotkeyCopyDesc = "یو تصادفي ژوندی tg:// لینک کلیپ بورډ ته ږدي."
    override val hotkeyEnable = "تود کیلي فعال کړئ"; override val hotkeyLetterLabel = "توری"; override val hotkeySet = "ټاکل"; override val hotkeyReset = "بیا ترتیب"
    override val hotkeyOpenTitle = "پراکسۍ په Telegram کې پرانیزئ"
    override val hotkeyOpenDesc = "یو تصادفي ژوندی لینک پرانیزي — Telegram یې نیسي او د پراکسۍ نښلول وړاندیز کوي."

    override val relayPorts = "د ریلې پورټونه"
    override val relayPortsHelp = "هغه محلي پورټونه چې نښلوونکی یې اوري. تاسو دقیقاً همدا په Telegram کې " +
        "د SOCKS5 پراکسۍ په توګه ورکوئ (127.0.0.1 : پورټ). د باوري والي لپاره دوه پورټونه کارول کیږي — " +
        "Telegram دواړو ته اړیکې ساتي."
    override val portA = "پورټ A"; override val portB = "پورټ B"
    override val antiDpiTrick = "د ضد-DPI ترفند"
    override val antiDpiHelp = "د اړیکې پټولو لاره ترڅو ISP/DPI یې ونه پیژني او بند یې نه کړي.\n" +
        "• «اتومات-څرخ» پخپله یو کاري ترفند ټاکي.\n• «هیڅ DPI ترفند» — ساده اړیکه.\n" +
        "• پاتې — ځانګړي تخنیکونه (د براوزر تقلید، د پاکټونو ویشل، او داسې نور)."
    override val onlyFakeTls = "یوازې FakeTLS (ee)"
    override val applyDpiTo = "ضد-DPI پلي کړئ په"
    override val applyDpiHelp = "ټاکل شوی ضد-DPI ترفند چیرته پلي کړئ:\n• د Telegram ریلې — د نښلوونکي " +
        "له لارې د Telegram ژوندۍ اړیکې ته.\n• د پراکسۍ ازموینې — د شاليد د پراکسۍ چکونو ته (بیا چک " +
        "هم هغسې چلیږي لکه ریښتینې اړیکه، او د ترفند احصایه دقیقتره ده).\n" +
        "• کله چې مستقیم نښلیږي — کله چې پراکسۍ بندې وي (یا د VPN پر مهال پریښودل کیږي) او Telegram " +
        "مستقیماً خپلو سرورونو ته ځي: دلته پراکسۍ نشته، نو ترفند یوازې د لومړي TCP پاکټ (هند‌شیک) په " +
        "څو وړو ټوټو ویشلو ته راکمیږي ترڅو DPI یې په یوه لوست کې ونه پیژني."
    override val toRelay = "د Telegram ریلې"; override val toProbes = "د پراکسۍ ازموینې"
    override val toDirect = "کله چې مستقیم نښلیږي"
    override val vpnSection = "کله چې VPN فعال وي"
    override val vpnHelp = "څه وکړئ کله چې په وسیله کې VPN فعال وي:\n• د MTProto پراکسۍ له لارې — " +
        "Telegram لکه عادت موندل شویو پراکسیو له لارې ځي (د VPN پورته).\n• مستقیماً — نښلوونکی پراکسۍ " +
        "نه کاروي او Telegram مستقیماً د Telegram سرورونو ته وصلوي: VPN لا دمخه لاسرسی ورکوي، اضافي " +
        "د پراکسۍ پرت ته اړتیا نشته (چټک او باثباته). د VPN پرته پراکسۍ لکه عادت کارول کیږي."
    override val linkFormat = "د پراکسۍ لینک بڼه"
    override val linkFormatHelp = "پراکسۍ څنګه کاپي او پرانیستل. tg:// مستقیماً Telegram پرانیزي (نصب شوي Telegram Desktop ته اړتیا ده). http (t.me) د براوزر له لارې پرانیزي او په Telegram کې پرانیستل وړاندیز کوي — ګټور دی که tg:// ثبت نه وي."
    override val linkTg = "tg:// (مستقیماً Telegram پرانیزي)"; override val linkTgSub = "tg://proxy?… — Telegram پرانیزي"
    override val linkHttp = "http (t.me، د براوزر له لارې)"; override val linkHttpSub = "https://t.me/proxy?… — براوزر پرانیزي"
    override val viaMtproto = "د MTProto له لارې پراکسۍ"; override val viaMtprotoSub = "حتی د VPN سره، ترافیک د پراکسیو له لارې ځي"
    override val directly = "مستقیماً وصل کړئ"; override val directlySub = "د فعال VPN سره — پراکسۍ پریږدئ، مستقیماً Telegram ته"
    override val notifications = "خبرتیاوې"
    override val scanCheck = "سکن او چک"
    override val scanCheckHelp = "• سکن، دقیقه — څومره ځله د ګډونونو څخه د پراکسۍ لیستونه ډاونلوډ کړئ.\n" +
        "• چک، دقیقه — څومره ځله د ډیټابیس پراکسۍ د ژوندي والي لپاره بیا چک کړئ.\n• د دستې اندازه — " +
        "په هر چلولو کې څومره پراکسۍ چک کړئ.\n• موازي — په یو وخت کې څومره چکونه چلوئ (ډیر = چټک، " +
        "خو په شبکه او بطرۍ ډیر بار)."
    override val scanMin = "سکن، دقیقه"; override val checkMin = "چک، دقیقه"; override val batchSize = "د دستې اندازه"; override val parallel = "موازي"
    override val speedByNet = "د شبکې له مخې د سکن شدت"
    override val speedByNetHelp = "د اوسنۍ شبکې له مخې څومره ځله پراکسۍ چک کړئ. " +
        "«معیاري» = بنسټیز فاصله. ښي خوا ته ولغوئ د کم شدت لپاره (ورو، د ترافیک/بطرۍ سره نرم)، " +
        "کیڼ خوا ته د ډیر شدت لپاره (چټک، تیز). لوګاریتمیک مقیاس، تر ×۱۰۰ پورې هرې خوا ته.\n" +
        "• VPN — کله چې بهرنی VPN فعال وي.\n• Wi-Fi — په Wi-Fi شبکه کې.\n• LTE — په ګرځنده شبکه کې."
    override val intensStandard = "معیاري"
    override val intensSlower = "ورو"
    override val intensFaster = "چټک"
    override val maintenance = "ډیټا صفر کړئ"
    override val maintenanceHelp = "• «کټلاګ او احصایه صفر کړئ» — درجه‌بندي، شمیرونه، ترافیک او د چک " +
        "لاګونه صفروي، خو ډاونلوډ شوي هوسټونه او ګډونونه ساتي (هرڅه په راتلونکي سکن کې بیا درجه‌بندي " +
        "کیږي).\n• «ډاونلوډ شوي هوسټونه پاک کړئ» — ټول د پراکسۍ پول ړنګوي خو ګډونونه ساتي ترڅو سکن " +
        "پول بیا ډک کړي. ګډونونه په هیڅ حالت کې نه لمس کیږي."
    override val backupTitle = "صادرول / واردول"
    override val backupHelp = "د اپلیکیشن ډیټا د JSON په توګه خوندي یا بیرته راوړئ. وټاکئ چې څه شامل " +
        "کړئ — هره ترکیب:\n• تنظیمات — د اپلیکیشن ټول پارامترونه.\n• ګډونونه — د سرچینو لیست " +
        "(URL + روښانه/بند).\n• د ژوندیو هوسټونو کټلاګ — هره ژوندۍ پراکسۍ له خپلې درجه‌بندي او احصایې " +
        "سره د هرې شبکې حالت لپاره.\n\n«صادرول» یوه پاڼه له چمتو JSON سره پرانیزي — کاپي یې کړئ یا فایل " +
        "ته خوندي کړئ. «واردول» — JSON پیسټ کړئ (یا فایل بار کړئ) او یوازې هغه نښه شوي برخې پلي کیږي " +
        "چې پکې شته. واردول اوسني ډیټا ته زیاتوي (نه پاکوي)."
    override val backupSettings = "تنظیمات"
    override val backupSubs = "ګډونونه"
    override val backupHosts = "د ژوندیو هوسټونو کټلاګ (د حالت له مخې)"
    override val exportWord = "صادرول"
    override val importWord = "واردول"
    override val backupExportTitle = "ډیټا صادرول"
    override val backupImportTitle = "ډیټا واردول"
    override val backupSelectExport = "څه صادر کړئ:"
    override val backupSelectImport = "څه وارد کړئ:"
    override val backupCopyBtn = "کاپي"
    override val backupSaveFile = "فایل ته خوندي کړئ"
    override val backupLoadFile = "له فایل بار کړئ"
    override val backupDoImport = "واردول"
    override val backupPasteLabel = "د بیک‌اپ JSON دلته پیسټ کړئ"
    override val backupJsonLabel = "د بیک‌اپ JSON"
    override val backupAndroidFileNote = "فایلونه دلته شتون نلري — کاپي / پیسټ وکاروئ."
    override val eraseAllHosts = "ټول هوسټونه ړنګ کړئ"
    override val factoryReset = "هرڅه صفر کړئ (لکه لومړی پیل)"
    override val factoryResetConfirm = "اپلیکیشن بشپړ فابریکې حالت ته بیرته کړئ؟ ټول تنظیمات او ټول د " +
        "هوسټونو کټلاګ به پاک شي، ګډونونه به معیاري حالت ته بیرته شي. لکه لومړی پیل."
    override val resetCatalog = "کټلاګ او احصایه صفر کړئ"
    override val resetCatalogConfirm = "ټوله درجه‌بندي، شمیرونه او د چک لاګونه صفر کړئ؟ " +
        "ډاونلوډ شوي هوسټونه او ګډونونه ساتل کیږي او په راتلونکي سکن کې بیا درجه‌بندي کیږي."
    override val clearHosts = "ډاونلوډ شوي هوسټونه پاک کړئ"
    override val clearHostsConfirm = "د ډاونلوډ شویو هوسټونو (پراکسیو) ټول لیست ړنګ کړئ؟ " +
        "ګډونونه ساتل کیږي او سکن به پول بیا ډک کړي."
    override val doReset = "صفر کړئ"
    override val doCancel = "لغوه"
    override val adaptiveSpeed = "تطبیقي سرعت"
    override val adaptiveHelp = "د ژوندي والي چکونه په بنسټیز فاصله چلیږي (له «سکن او چک»، د شبکې په " +
        "ضرب‌کوونکي هم ضرب شوی). «تطبیقي سرعت» پخپله هغوی ګړندي یا ورو کوي د دې پر بنسټ چې اوس مهال " +
        "څومره پراکسۍ ژوندي دي.\n\n" +
        "• لږ ژوندي (د «لږ» له حد لاندې) → فاصله × «ګړندي‌کول». له ۱ کوچنی ضرب‌کوونکی = ډیر ځله: " +
        "0.5 — دوه چنده ډیر، 0.25 — ۴×. پول ژر ډکوي.\n" +
        "• ډیر ژوندي (د «ډیر» له حد پورته) → فاصله × «ورو‌کول». له ۱ لوی = لږ ځله: 2 — نیمایي ځله، " +
        "4 — څلورمه برخه. بطرۍ او ترافیک ساتي.\n" +
        "• د حدونو ترمنځ — بنسټیز سرعت (×۱).\n\n" +
        "بیلګې:\n" +
        "— پراکسۍ ژر راټول کړئ: «ګړندي‌کول» 0.25 او/یا د «لږ» حد ۴۰.\n" +
        "— کله چې بس وي بطرۍ وساتئ: «ورو‌کول» 8 او/یا د «ډیر» حد ۳۰.\n" +
        "— تطبیق بند کړئ: دواړه ضرب‌کوونکي ۱ کړئ.\n\n" +
        "اصلي ارزښتونه: لږ ۲۰، ګړندي‌کول 0.5، ډیر ۵۰، ورو‌کول 4."
    override val threshMany = "د «ډیر» حد"; override val threshFew = "د «لږ» حد"; override val mulFast = "ګړندي‌کول ×"; override val mulLazy = "ورو‌کول ×"
    override val subIntensityTitle = "د ګډونونو شدت"
    override val subIntensityHint = "د ګډونونو د ډاونلوډونو ترمنځ ځنډ: د پراکسۍ لیستونو د بیا ډاونلوډ دمخه څو دقیقې (د هرې شبکې حالت لپاره جلا)."
    override val baseScanTitle = "بنسټیز د سکن سرعت"
    override val baseScanHelp = "د ژوندي والي د چک معیاري سرعت. «تطبیقي سرعت» او د «د حالت له مخې " +
        "سرعت» ضرب‌کوونکي د هغه له مخې محاسبه کیږي.\n\n" +
        "• څومره ځله چلول، دقیقه — د چک د پاسونو ترمنځ فاصله.\n" +
        "• په هر تار دسته، هوسټونه — هر تار په هر پاس کې څومره هوسټونه چک کوي.\n" +
        "• تارونه — په یو وخت کې څومره چکونه چلیږي. یو پاس «دسته × تارونه» هوسټونه ازموي.\n" +
        "• یو هوسټ له هرو N دقیقو ډیر ځله بیا سکن مه کوئ — ضد-فلود: نوی چک شوی هوسټ په دې پاس کې " +
        "پریښودل کیږي.\n\n" +
        "ډیر تارونه او لویه دسته = د پول چټک ودې، خو په شبکه او بطرۍ درنه بار."
    override val baseScanPeriod = "څومره ځله چلول، دقیقه"
    override val baseScanBatch = "په هر تار دسته، هوسټونه"; override val baseScanThreads = "د تارونو شمیر"
    override val adaptiveDesc = "که ژوندي پراکسۍ له «لږ» کم یا له «ډیر» زیاتې وي، یو اضافي ضرب‌کوونکی پلی کړئ."
    override val fewWord = "لږ"; override val manyWord = "ډیر"
    override fun fasterX(x: String) = "${x}× چټک"
    override fun slowerX(x: String) = "${x}× ورو"
    override fun ifAliveLt(n: Int) = "که ژوندي پراکسۍ < ${n}، نو:"
    override fun ifAliveGt(n: Int) = "که ژوندي پراکسۍ > ${n}، نو:"
    override val disabledWord = "بند"
    override val speedByModeTitle = "د حالت له مخې سرعت"
    override val speedByModeHelp = "د هرې شبکې حالت لپاره د سکن سرعت ضرب‌کوونکی، د بنسټیز سرعت پورته. " +
        "«معیاري» (×۱) = بنسټیزه فاصله. ښي — لږ ځله (ورو، د ترافیک/بطرۍ سره نرم)، کیڼ — ډیر ځله " +
        "(چټک، تیز). لوګاریتمیک مقیاس، تر ×۱۰۰ پورې هرې خوا ته.\n\n" +
        "د هر سلایډر لاندې د تطبیقي سرعت په پلي کولو سره د پاس پایلې پارامترونه دي — جلا جلا د «لږ " +
        "ژوندي» (× «ګړندي‌کول») او «ډیر ژوندي» (× «ورو‌کول») لپاره ښودل کیږي.\n\n" +
        "حالتونه:\n• VPN — بهرنی VPN فعال دی.\n• LTE — ګرځنده شبکه.\n• Wi-Fi — د Wi-Fi شبکه.\n" +
        "• Ethernet — سیمي اړیکه.\n• White — لاسي «سپین» د پراکسۍ حالت."
    override val aliveLt = "ژوندي <"; override val aliveGt = "ژوندي >"
    override val periodWord = "موده"; override val nonstopWord = "بې‌ودریدو"
    override val batchWord = "دسته"; override val threadsWord = "تارونه"; override val scanModeOff = "سکن بند"
    override val netBattery = "شبکه او بطرۍ"
    override val netBatteryHelp = "• یوازې Wi-Fi — په ګرځنده شبکو سکن مه کوئ (ډیټا ساتي).\n• یوازې د " +
        "چارج پر مهال — یوازې هغه وخت کار کوئ کله چې تلیفون چارج کیږي.\n• د کم بطرۍ پر مهال پریږدئ — " +
        "کله چې بطرۍ کمه وي سکن ودروئ."
    override val onlyWifi = "یوازې Wi-Fi"; override val onlyCharging = "یوازې د چارج پر مهال"; override val skipLowBattery = "د کم بطرۍ پر مهال پریږدئ"
    override val autosaved = "تنظیمات په اتومات ډول خوندي کیږي."
    override val dpiAutoLabel = "د DPI ترفندونه اتومات-څرخ"; override val dpiNoneLabel = "هیڅ DPI ترفند (ساده)"
    override val experimental = "تجربوي"
    override val experimentalHelp = "د MTProto اپ‌سټریم لپاره بدیل د پراکسۍ انجنونه او یو تشخیصي لاګ. " +
        "د «بند» پر مهال معیاري (کاري) لاره نه بدلیږي. یوازې دا بدلیږي چې پټ شوی جریان څنګه اپ‌سټریم TCP " +
        "ساکټ ته لیکل کیږي (د سګمنټ اندازې، تایمنګ، د TLS-record پولې) — پخپله جریان بایټ‌په‌بایټ همغه پاتې کیږي. " +
        "یوازې د ژوندۍ پراکسۍ ریلې ته پلي کیږي (نه ازموینو، نه مستقیمې لارې)."
    override val expEngineTitle = "د پراکسۍ انجن (د ساکټ پټونه)"
    override val expConnectTitle = "د نښلولو انجن (د اپ‌سټریم ټاکنه)"
    override val expEngineWarn = "⚠ تجربوي حالت. که اړیکه بدتره شي، بیرته «بند (معیاري لاره)» ته واوړئ."
    override val netLog = "د شبکې تبادلې لاګ فعال کړئ"
    override val netLogSub = "په فایل کې څوک-چاته-کله او د پاکټونو اندازې لیکي (د پیلوډ ډیټا پرته) — " +
        "ترڅو د VPN سره او پرته د تبادلې بڼه پرتله کړي."
    override val openLogFolder = "د لاګ فولډر پرانیزئ"; override val copyPath = "مسیر کاپي کړئ"
    override val helpShow = "مرسته"; override val helpHide = "مرسته پټه کړئ"
    override val quickSwitchIntro = "دلته تاسو کولی شئ د بند تیریدو ترفند وټاکئ. که Telegram دا تېروتنه " +
        "وښيي «The proxy you are using is not configured correctly and will be disabled. Please find another " +
        "one»، تجربه وکړئ چې د ترافیک کوم ډول پټونه کار کوي ترڅو Telegram یې نور ونه ښيي. د split* " +
        "حالتونو سره پیل وکړئ. coalesce* حالتونه هم کار کوي، خو د هغوی سره په Telegram کې انځورونه/ویډیوګانې ښه نه بارېږي."
    override val quickSwitchTitle = "د بند تیریدل"; override val quickSwitchSub = "شکل‌ورکونه، نښلول، ضد-DPI"

    override val sourceUrl = "د سرچینې URL"
    override fun sourceAlive(alive: Int, total: Int) = "ژوندي ${alive}/${total}"
    override val open = "پرانیستل"; override val active = "فعال"; override val inactive = "غیرفعال"
    override val lastDownloaded = "ډاونلوډ شوی"; override val notDownloaded = "تراوسه ډاونلوډ نه دی شوی"
    override fun sourceCounts(dead: Int, total: Int) =
        " ژوندي، ${dead} مړه، ${total} ټول"

    override val proxyBase = "د پراکسۍ ډیټابیس"
    override val totalInBase = "په ډیټابیس کې ټول"; override val aliveNow = "اوس ژوندي"; override val deadStat = "مړه"
    override val aliveIn15 = "په ۱۵ دقیقو کې ژوندي"; override val checksAllTime = "د ټول وخت چکونه"
    override val antiDpiTricks = "د ضد-DPI ترفندونه"; override val noStatsYet = "تراوسه هیڅ ډیټا نشته — ترفندونه د چکونو/اړیکو په پرمختګ سره راټولیږي"
    override val attempts = "هڅې"; override val handshake = "Handshake"; override val score = "ټکی"
    override val tgConnect = "TG نښلول"; override val socketsOver1m = "ساکټونه >۱دقیقه"
    override val over10kb = "ساکټونه >10KB"; override val over100kb = ">100KB"; override val workTime = "د کار وخت"
    override val statsLegend = "Handshake — بریالي هند‌شیکونه (د هڅو ٪) · ټکی — ارزښت · " +
        "«د کار وخت» — ټول د ≥5KB او له ۱ دقیقې اوږدو ساکټونو."
    override val resetStats = "د ترفند احصایه صفر کړئ"

    override fun aliveLinks(n: Int) = "ژوندي لینکونه: ${n}"
    override val copyAll = "ټول کاپي کړئ"
    override val openRandom = "تصادفي پرانیزئ"; override val copyRandom = "تصادفي کاپي کړئ"; override val allShort = "ټول"
    override val copyTop = "TOP کاپي کړئ"; override val randomHost = "تصادفي هوسټ"
    override val exportToFile = "فایل ته صادرول"; override val exportSaved = "فایل ته خوندي شو:"
    override val dlNow = "اوس ډاونلوډ کړئ"
    override fun downloadingFmt(sec: Long) = "ډاونلوډ روان دی… ${sec}ث"
    override val cancel = "لغوه"
    override val deleteConfirmTitle = "ګډون ړنګ کړئ؟"
    override val subscriptionsAddHint = "ګډونونه یا د پراکسۍ لینکونه زیات کړئ →"
    override val addSourcesTitle = "زیاتول"
    override val addSubsLabel = "ګډونونه (په هر کرښه یو URL)"
    override val addSubsHelp = "هره کرښه له سم URL سره خپله جلا ګډون کیږي او په دوره‌یي ډول راوړل کیږي."
    override val addProxiesLabel = "چمتو د پراکسۍ لینکونه (ثابت لیست)"
    override val addProxiesHelp = "د ځانګړو پراکسیو لینکونو یوه ډله پیسټ کړئ (tg://proxy, https://t.me/proxy, …). دا ګډون نه دی — لیست هیڅکله نه ډاونلوډ کیږي، پراکسۍ یوازې کټلاګ ته زیاتیږي."
    override val addButton = "زیاتول"
    override fun addedFmt(subs: Int, proxies: Int) = "زیات شول: ${subs} ګډونونه، ${proxies} پراکسۍ"
    override val perSecond = "په ثانیه کې"
    override val graphSpeed = "سرعت"
    override val graphVolume = "حجم"
    override val graphLatency = "Ping"
    override val graphConnects = "نښلونه"
    override val scanNow = "اوس سکن کړئ"; override val scanOnShort = "سکن روښانه"
    override val scanRunning = "سکن روان دی"; override val scanIdle = "سکن بیکار"; override val scanOffState = "سکن بند"; override val scanBatchPerThread = "دسته/تار"; override val scanPassHosts = "په پاس کې هوسټونه"; override val minRescanLabel = "یو هوسټ له هرو N دقیقو ډیر ځله بیا سکن مه کوئ"
    override val scanPlanTitle = "پلان"; override val scanNowTitle = "اوس"; override val currentScheduleTitle = "اوسنی مهال‌ویش"
    override val scheduleWord = "مهال‌ویش"; override val unitPcsPerSec = "دانه/ث"
    override val scanNowThreadsLabel = "اوس چلیدونکي تارونه"; override val scanNowPerThreadLabel = "په هر تار چکونه (پلان)"; override val scanNowElapsedLabel = "د کار وخت"
    override val scanOkGraph = "بریالي سکنونه"; override val scanFailGraph = "ناکام سکنونه"; override val scanTrafficGraph = "د سکن ترافیک"; override val scanAliveGraph = "ټول ژوندي پراکسۍ"; override val scanPingGraph = "Ping"; override val threadsGraph = "تارونه"
    override val scanEvery = "هر"; override val scanNextRun = "راتلونکی چلول"
    override val scanThreads = "تارونه"; override val scanBatch = "دسته"
    override val scanElapsed = "روان دی"; override val scanIdleNow = "—"
    override val effForFew = "کله چې لږ"; override val effForMany = "کله چې ډیر"
    override val effCheck = "چک"; override val effBatch = "دسته"; override val effPar = "موازي"
    override val effContinuous = "دوامداره"; override val secShort = "ث"; override val minShort = "دقیقه"

    override val appTagline = "کراس-پلیټفارم اتومات-نښلوونکی: د MTProto پراکسۍ مومي، چک کوي او چلوي " +
        "چې Telegram یې له لارې کار کوي."
    override val version = "نسخه"; override val buildDate = "د بیلډ نیټه"
    override val downloadSources = "ډاونلوډ او سرچینې"; override val openOnGithub = "په GitHub کې پرانیزئ"
    override val feedbackBugs = "نظر او د بګ راپورونه"; override val writeTelegram = "په Telegram کې ولیکئ"

    override val language = "ژبه"; override val langAuto = "اتومات (سیسټم)"
    override val langWord = "ژبه"
    override val raceWidthTitle = "موازي نښلونه"
    override val connectionSection = "اړیکه او د بند تیریدل"
    override val connectionSectionHelp = "د نښلولو انجن، موازي اپ‌سټریمونه، د پراکسۍ انجن او ضد-DPI ترفندونه — ټول په یوه برخه کې."
    override val netLogSection = "د شبکې تبادلې لاګ"
    override val platform = "پلیټفارم"

    override val scanModeTitle = "د شبکې حالت"; override val scanModeAuto = "اتومات"; override val scanModeManualLabel = "لاسي"
    override val activeModeLabel = "فعال حالت"; override val formingListLabel = "لیست جوړیږي"; override val catalogModeTabs = "حالت"
    override val resetModeRatings = "د هوسټونو درجه صفر کړئ"; override val forgetModeHosts = "د حالت هوسټونه هیر کړئ"
    override val exportModeTitle = "د حالت له مخې صادرول"; override val modePickerTitle = "حالت"
    override val modeHelp = "هر د شبکې حالت خپله د پراکسۍ درجه‌بندي او خپل د سکن + د ګډون ډاونلوډ شدت ساتي. «اتومات» حالت له فعالې شبکې ټاکي. «لاسي» تاسو ته اجازه درکوي چې پخپله هر حالت وټاکئ (په شمول د White، چې اتومات یې هیڅکله نه ټاکي)."
    override val autoSelect = "اتومات ټاکنه"; override val manualSelect = "لاسي ټاکنه"
    override val connStatsTitle = "اوس اړیکې"; override val connOnPort = "په پورټ اړیکې"; override val outgoingConns = "وتونکي اړیکې"
    override val modeChoice = "د حالت ټاکنه"; override val autoChoice = "اتومات-ټاکنه"; override val manualChoice = "لاسي ثابت"
    override val directOnVpn = "د VPN پر مهال TG ته مستقیم نښلول"; override val onWord = "روښانه"; override val offWord = "بند"
    override val directStateActive = "فعال"; override val directStateOff = "په تنظیماتو کې بند"; override val directStateIdle = "په تنظیماتو کې روښانه، خو فعال نه"
    override val wpHintTitle = "White څه دی؟"
    override val wpHint = "White — WhitePages: یو لاسي د شبکې پروفایل. یوازې په لاس فعالیږي (اتومات-ټاکنه یې هیڅکله نه ټاکي). " +
        "خپله د هوسټونو درجه‌بندي ساتي، ګډونونه ډاونلوډوي او د VPN/Wi-Fi/LTE خپلواکه سکن کوي."

    override val recentAttempts = "وروستي نښلونه او چکونه"
    override val kindCheck = "چک"
    override val kindTg = "تلیګرام"
    override val histWho = "څوک"
    override val histWhen = "کله"
    override val histReq = "غوښتنه"
    override val histSess = "ناسته"
    override val histScan = "سکن"
    override val testNow = "اوس ازموینه وکړئ"
    override val testShort = "ازموینه"
    override val testResult = "د ازموینې پایله"
    override val testStop = "ودرول"
    override val testingNow = "ازموینه روانه ده…"
    override val prewarmTitle = "د ساکټونو تودول (تجربه)"
    override val prewarmHelp = "د پراکسۍ څو ساکټونه له مخکې پرانیستي وساتئ، ترڅو د Telegram نوې اړیکه " +
        "نښلول/هند‌شیک پریږدي. تجربوي: شاليد په دوامداره ډول بیا نښلیږي → د ترافیک لګښت او لږ CPU. " +
        "جعلي ترافیک نه لیږل کیږي (هغه به ریښتینه ناسته ماته کړي) — ساکټونه یوازې څرخیږي. تر ټولو ګټور د FakeTLS پراکسۍ سره."
    override val prewarmEnable = "تودول فعال کړئ"
    override val prewarmModeDeferred = "ځنډول شوی (یوازې TLS)"
    override val prewarmModeDeferredSub = "TCP + FakeTLS ساتو؛ obfuscated2-init د لیږد پر مهال لیږو. DC نه کمیټ کیږي — تر ټولو ریښتینی."
    override val prewarmModeFull = "بشپړ هند‌شیک"
    override val prewarmModeFullSub = "د بیلابیلو DC له مخې بشپړ وصل ساکټونه ساتو؛ یوازې د DC/tag سمون پر مهال بیا کاروو. لږ ژوند کوي."
    override val prewarmPoolLabel = "ساکټونه ذخیره"
    override val prewarmHoldLabel = "ساتل، ث"
    override val prewarmNote = "یوازې څرخ (د اپلیکیشن په کچه keepalive پرته). ساکټ ثانیې…~یوه دقیقه ژوند کوي، په پراکسۍ/DC پورې اړه لري."
    override val prewarmStatus = "تودول"
    override fun prewarmStatusVal(ready: Int, holdSecs: Int) = "${ready} چمتو · ساتل ${holdSecs}ث"
    override val prewarmStar = "ډبل نارنجي = ساکټ له تودولو پول څخه ګرم ورکړل شوی (د نښلولو/هند‌شیک پرته)"
    override fun prewarmTableTitle(holdSecs: Int) = "د ساکټونو تودول (ساتل ${holdSecs}ث)"
    override val prewarmTableHelp = "«د ساکټونو تودول» له مخکې د پراکسۍ څو ساکټونه پرانیزي، ترڅو د Telegram نوې " +
        "اړیکه نښلول/هند‌شیک پریږدي. په دې جدول کې تودیدونکي هوسټونه ښودل کیږي: ساکټ څو ثانیې ژوند کوي، " +
        "ایا Telegram یې کاروي، او ترافیک. فعالول/بندول او تنظیمول (حالت، د ساکټونو شمیر، د ساتلو وخت) " +
        "په «نور → تنظیمات → „د ساکټونو تودول (تجربه)“» کې شونی دی."
    override val prewarmNoneWarming = "تراوسه هیڅ تودیدونکی ساکټ نشته"
    override val prewarmColAge = "ژوند کوي"
    override val prewarmColUse = "په TG؟"
    override val prewarmInUse = "په TG"
    override val prewarmNew = "نوی"
    override val lanShareTitle = "په محلي شبکه کې شریکول (ویب پورټال)"
    override val lanShareDesc = "نورو وسیلو ته په همدې Wi-Fi کې اجازه ورکړئ چې دا AutoConnector د پراکسۍ په توګه وکاروي؛ لاندې پته کې براوزر به د غوره پراکسیو پاڼه ترلاسه کړي."
    override val lanShareUrlsLabel = "د شبکې ګاونډیان نښلیږي:"
    override val lanShareNoIp = "په محلي شبکه کې پته نشته — Wi-Fi ته وصل شئ"
    override val lanFirewallTitle = "په محلي شبکه کې اجازه ورکړئ"
    override val lanFirewallBody = "د فعالولو پر مهال د ریلې پورټونه محلي شبکې ته خلاصیږي. اوس ممکن د Windows فایروال (یا بل) وپوښتي چې AutoConnector ته اجازه ورکړي — «اجازه»/«هو» وټاکئ. که منع کړئ، د ګاونډیانو ترافیک به AutoConnector ته بند شي، او پاڼه/پراکسۍ به شتون ونلري."
    override val lanFirewallConfirm = "فعالول"
    override val lanInfoTitle = "دا ولې؟"
    override val lanInfoBody = "AutoConnector په یوه کمپیوټر یا تلیفون کې ستاسو په Wi-Fi کې پیل کړئ — او نورې ټولې وسیلې په همدې شبکه کې، په شمول د iPhone (چې اپلیکیشن یې مستقیماً نه ملاتړ کوي)، کولی شي یوازې په براوزر کې پته پرانیزي او وکاروي: د غوره پراکسیو پاڼه چې د هغوی Telegram ته زیاتې شي، یا پخپله دا وسیله د SOCKS پراکسۍ په توګه. یوه وسیله پراکسۍ مومي او ساتي، نورې یې په محلي شبکه کاروي."
    override val volTriggerTitle = "د غږ تڼیو ټرigر"
    override val volTriggerSub = "د غږ کیليو په چټک نمونه د پراکسۍ بدلون"
    override val volEnableLabel = "د غږ تڼیو څارنه"
    override val volHelpTitle = "دا څه دي؟"
    override val volHelpBody = "په Android کې نړیوال د کیبورډ تود کیلي نشته، نو د غږ تڼۍ کارول کیږي. کله چې فعال وي، AutoConnector په شاليد کې د غږ-پورته/ښکته فشارونو چټک نمونه څاري (لکه پورته-پورته-ښکته-ښکته). د هغې په پیژندلو سره، د یوه تصادفي ښه ژوندي پراکسۍ tg:// لینک پرانیزي — Telegram یې نیسي او بدلیږي. د اپلیکیشن د پرانیستلو پرته د پراکسۍ د څرخولو چټکه پټه لاره. غږ په عادي ډول کار کوي (فشارونه نه نیول کیږي). د Accessibility لاسرسي ته اړتیا ده (ترڅو په شاليد کې کیلي ولولي او لینک پرانیزي)؛ تر هغه چې علامه فعاله نکړئ هیڅ نه غوښتل کیږي. لاندې د فشارونو ترمنځ اعظمي وخت وټاکئ؛ پیژندل شوي نمونې لاندې لیست شوي."
    override val volGrantTitle = "Accessibility فعال کړئ (مهم)"
    override val volGrantBody = "Android (په ځانګړي ډول 13+) د Google Play پرته نصب شویو اپلیکیشنونو لپاره Accessibility بندوي — نو AutoConnector خړ دی او وايي «اپلیکیشن ته لاسرسی منع دی».\n\nڅنګه یې خلاص کړئ:\n1. «د اپ معلومات» پرانیزئ (لاندې تڼۍ، یا: تنظیمات → اپلیکیشنونه → AutoConnector for Telegram).\n2. ⋮ (پورته ښي درې ټکي) کلیک کړئ → «محدود تنظیمات اجازه ورکړئ» → تایید کړئ.\n3. بیرته راشئ: تنظیمات → Accessibility → AutoConnector for Telegram → فعال کړئ.\n\nکه د «محدود تنظیمات اجازه ورکړئ» توکی نشته — لومړی یو ځل په Accessibility کې سویچ فعالول هڅه کړئ (د منعې پیغام راځي)، بیا ګام 2 شونی کیږي.\n\nپه Xiaomi/MIUI، Samsung او نورو کې لاره لږ توپیر کولی شي — همغه ⋮ په «د اپ معلومات» کې ولټوئ. په Android 12 او زاړه کې معمولاً محدودیت نشته — مستقیماً فعال کړئ.\n\nد غږ کیلي یوازې لوستل کیږي، هیڅکله نه بندیږي."
    override val volOpenAppInfo = "«د اپ معلومات» پرانیزئ"
    override val volAccessOn = "Accessibility: فعال"
    override val volAccessOff = "Accessibility: بند"
    override val volOpenAccess = "د Accessibility تنظیمات پرانیزئ"
    override val volGapLabel = "د فشارونو ترمنځ اعظمي ms"
    override val volPatternsTitle = "پیژندل شوي نمونې"
    override val volPatternPick = "نمونه"
    override val volPatternsLegend = "↑ = غږ پورته، ↓ = ښکته"
    override val volNoRights = "اپلیکیشن تراوسه د غږ تڼیو د پروسس حق نلري — د پاڼې په پای کې د لارښوونې له مخې لاسرسی ورکړئ."
    override val volGrantShort = "تراوسه Accessibility لاسرسی نشته. د دې پاڼې په پای کې تفصیلي لارښوونه ولولئ او «وګورئ» کلیک کړئ."
    override val volCheck = "وګورئ"
    override val volCheckOk = "✓ چمتو — لاسرسی ورکړل شو، ټرigر کار کوي."
    override val volCheckFail = "✗ تراوسه لاسرسی نشته — پورتني ګامونه ترسره کړئ."
    override val histLegend = "کالمونه — څوک: ✓/✗ TG = د Telegram ریښتینی نښلون، سکن = د شاليد چک. کله: څومره دمخه. TCP/TLS/غوښتنه: د هند‌شیک او لومړۍ غوښتنې ځنډونه، ms. ناسته: د ریلې ناسته څومره وخت ووته. ↓/↑: د هوسټ له لارې ترلاسه شوي / لیږل شوي بایټونه."
    override val tgOkTotalHint = "د Telegram نښلونه / بریالي / ټول چکونه"
    override val breadthTitle = "د هوسټ ټاکنې پراخوالی"
    override val breadthHelp = "کیڼ — د غوره تایید شویو هوسټونو سره پاتې کیدل؛ ښي — د بیلابیلو ژوندیو ډیر پراخه ازموینه. کله چې Telegram د ریلې پورټونو ترمنځ منډې وهي، اپلیکیشن په اتومات ډول ټاکنه پراخوي."
    override val breadthNarrow = "تایید شوي"
    override val breadthWide = "پراخ"
    override val connTimeoutTitle = "هوسټ ته د نښلون مهلت"
    override val connTimeoutHelp = "د راتلونکې پراکسۍ د ازموینې دمخه څومره یو اپ‌سټریم (TCP + TLS + لومړی MTProto ځواب) انتظار وکړئ."
    override val factoryResetDone = "هرڅه صفر شول. اپلیکیشن وتړئ او بیا یې پیل کړئ."

    // tray
    override val trayOpenWindow = "کړکۍ پرانیستل"
    override val trayRefreshSubs = "ګډونونه تازه کول"
    override val trayExit = "وتل"
    override fun trayConnectorLabel(on: Boolean) =
        if (on) "نښلوونکی: روښانه (بندول)" else "نښلوونکی: بند (روښانول)"
    override fun trayScanLabel(on: Boolean) =
        if (on) "سکن: روښانه (بندول)" else "سکن: بند (روښانول)"
    override fun trayLive(n: Int) = "ژوندي پراکسۍ: ${n}"
    override val appearance = "بڼه"
    override val themeLabel = "تیم"
    override val themeAuto = "اتومات (د سیسټم سره سم)"
    override val themeLight = "روښانه"
    override val themeDark = "تیاره"
    override val drawGraphsLabel = "ګرافونه جوړول"
    override val drawGraphsSub = "د نښلوونکي او سکن ټبونو کې ژوندي چارټونه — د بطرۍ ساتلو لپاره یې بند کړئ"
}
