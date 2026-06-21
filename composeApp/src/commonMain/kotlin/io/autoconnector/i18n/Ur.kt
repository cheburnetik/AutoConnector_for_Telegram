package io.autoconnector.i18n

object Ur : Strings {
    override val tabConnector = "کنیکٹر"; override val tabScan = "اسکین"
    override val tabCatalog = "کیٹلاگ"; override val tabLogs = "لاگز"; override val tabMore = "مزید"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "سبسکرپشنز"; override val logTabScan = "اسکین"
    override val logGeneral = "عمومی"; override val logEmpty = "فی الحال خالی"
    override val logSessions = "سیشنز"; override val logErrorsOnly = "صرف خرابیاں"; override val logNoErrors = "کوئی ناکام سیشن نہیں"
    override fun logSession(id: String, port: String) = "#$id · :$port"
    override val back = "واپس"; override val copy = "کاپی"; override val gotIt = "سمجھ گیا"
    override val later = "بعد میں"; override val details = "تفصیلات"; override val whatIsThis = "یہ کیا ہے؟"
    override val delete = "حذف کریں"

    override val connector = "کنیکٹر"; override val scan = "اسکین"
    override val notConfigured = "ترتیب نہیں دیا گیا! ٹھیک کریں →"; override val howToSetup = "ترتیب کیسے دیں"
    override val notifOff = "اطلاعات بند ہیں! ٹھیک کریں →"; override val enable = "فعال کریں"
    override fun fewProxies(n: Int) = "زندہ پراکسیاں $n، تلاش جاری ہے، ~15 منٹ انتظار کریں…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "زندہ پراکسیاں: $alive  (15 منٹ: $within) · کل: $total"
    override val notifWhyTitle = "اطلاعات کیوں؟"
    override val notifWhyBody = "مستقل اطلاعی آئیکن کا مطلب ہے ایک Android فورگراؤنڈ سروس۔ " +
        "اس کے بغیر سسٹم ایپ کو میموری سے ہٹا دیتا ہے اور یہ پراکسیاں تلاش کرنا اور " +
        "بیک گراؤنڈ میں کنکشن برقرار رکھنا بند کر دیتی ہے۔ اسی لیے " +
        "AutoConnector کے کام کرنے کے لیے اطلاعات ضروری ہیں۔"
    override val notifEnableTitle = "اطلاعات فعال کریں"
    override val notifEnableBody = "اطلاعی آئیکن کے بغیر، Android ایپ کو غیر فعال سمجھتا ہے اور " +
        "اسے میموری سے ہٹا دیتا ہے۔ پھر AutoConnector بیک گراؤنڈ میں پراکسیاں تلاش کرنا اور " +
        "کنکشن برقرار رکھنا بند کر دیتی ہے — Telegram کا رابطہ ٹوٹ جاتا ہے۔\n\n\"فعال کریں\" پر ٹیپ کریں اور " +
        "AutoConnector کے لیے اطلاعات کی اجازت دیں۔"
    override val notifPlea = "اطلاعات فعال کریں! ان کے بغیر ایپ بیک گراؤنڈ میں نہیں چل سکتی — " +
        "Android اسے ہٹا دے گا اور پراکسی تلاش اور کنکشن رک جائیں گے۔"

    override val statusConnected = "Telegram منسلک ہے"; override val statusConnecting = "منسلک ہو رہا ہے…"
    override val statusOffline = "Telegram منسلک نہیں"; override val statusIdle = "Telegram غیر فعال"
    override val nobodyConnected = "کوئی بھی کنیکٹر سے منسلک نہیں ہوا۔ "; override val howToSetupArrow = "ترتیب کیسے دیں →"
    override val directModeViaVpn = "براہِ راست موڈ: VPN فعال — کوئی پراکسی نہیں"
    override val directModeOff = "براہِ راست موڈ: پراکسیاں بند"
    override val directDpiSuffix = " · anti-DPI"
    override val connections = "کنکشنز"; override val sockets = "ساکٹس"; override val speed = "رفتار"
    override val traffic = "ٹریفک"; override val latency = "تاخیر"
    override fun pcs(n: Int) = "$n عدد"
    override fun netNow(label: String) = "نیٹ ورک: $label"
    override fun tgToConnector(n: Int) = "TG→ $n"
    override fun connectorToProxy(n: Int) = "پراکسی $n"
    override val trafficSec = "ٹریفک · 60 سیکنڈ"; override val trafficMin = "ٹریفک · 60 منٹ"
    override val latencySec = "تاخیر · 60 سیکنڈ"; override val latencyMin = "تاخیر · 60 منٹ"
    override val sec60 = "60 سیکنڈ"; override val min60 = "60 منٹ"
    override val unitSec = "سیک"; override val unitMin = "منٹ"; override val unitHour = "گھنٹہ"; override val dash = "—"
    override val currentProxy = "موجودہ پراکسی"; override val noActiveProxy = "کوئی فعال پراکسی نہیں (Telegram منسلک نہیں)"
    override val host = "ہوسٹ"; override val type = "قسم"; override val secret = "سیکریٹ"; override val antiDpi = "Anti-DPI"; override val obfEngine = "ابہام انجن"
    override fun activeSockets(n: Int) = "فعال Telegram ساکٹس: $n"
    override val noConnections = "کوئی فعال کنکشن نہیں"; override val colHost = "ہوسٹ"; override val colTime = "وقت"
    override val modeWord = "موڈ"; override val directViaVpnLine = "Telegram کو براہِ راست درخواستیں (VPN فعال)"
    override val connModeHelp = "موڈز (VPN، Wi-Fi، LTE، Ethernet، White) آپ کو اسکین کی شدت مختلف انداز میں ترتیب دینے اور ہوسٹ کی الگ ریٹنگز/اعدادوشمار رکھنے دیتے ہیں۔ نیٹ ورک کارڈ خودکار طور پر شناخت ہوتا ہے؛ موڈ کو ترتیبات میں دستی طور پر سیٹ کیا جا سکتا ہے۔"

    override val scanOff = "اسکیننگ بند ہے"; override val proxiesInBase = "ڈیٹابیس میں پراکسیاں"
    override val total = "کل"; override val alive = "زندہ"; override val dead = "مردہ"
    override val tgConnectedTitle = "Telegram اس کے ذریعے منسلک"; override val successful = "کامیاب"
    override val socketsHeld = "ساکٹ کی مدت"; override val over1m = ">1 منٹ"; override val over5m = ">5 منٹ"; override val over15m = ">15 منٹ"
    override val scanCountTitle = "پراکسی جانچ کی تعداد"; override val checked = "جانچا گیا"
    override val forAllTime = "تمام وقت"; override val perMinute = "فی منٹ"; override val perHour = "فی گھنٹہ"
    override val subsCountTitle = "سبسکرپشن ڈاؤن لوڈز کی تعداد"; override val downloaded = "ڈاؤن لوڈ ہوا"; override val failed = "ناکام"; override val scanTraffic = "اسکین ٹریفک"; override val subTraffic = "سبسکرپشن ٹریفک"; override val subTrafficGraph = "سبسکرپشن ٹریفک"
    override val checksMtproto = "MTProto جانچ (↑ ٹھیک · ↓ ناکام)"

    override fun catalogEmpty(mode: String) = "کیٹلاگ $mode فی الحال خالی ہے۔ یا تو کوئی ہوسٹ نہیں ملا، یا ایپ اس موڈ میں کبھی نہیں چلی۔ آپ ترتیبات میں موڈ تبدیل کر سکتے ہیں۔ موڈز اس لیے موجود ہیں کہ مختلف قسم کے انٹرنیٹ کنکشن کے لیے ہوسٹس الگ الگ جمع کیے جائیں۔"
    override val aliveShort = "✓ زندہ"; override val deadShort = "✗ مردہ"
    override val statusLabel = "حالت"; override val rating = "ریٹنگ"; override val port = "پورٹ"
    override val rttPing = "RTT (ping)"; override val checkedField = "جانچا گیا"; override val okOfTotal = "کامیاب / کل جانچ"
    override val tgConnectedField = "Telegram منسلک"; override val tgSessions = "Telegram سیشنز"; override val trafficThroughProxy = "پراکسی کے ذریعے ٹریفک"
    override val sessionsTotal = "کل سیشنز"; override val relayNow = "ابھی ریلے"; override val tlsDomain = "TLS ڈومین (SNI)"
    override val sourceSub = "ماخذ (سبسکرپشن)"; override val lastError = "آخری خرابی"; override val yes = "ہاں"; override val no = "نہیں"
    override val copyAsLink = "لنک کے طور پر کاپی کریں"; override val openInTelegram = "ہوسٹ Telegram میں کھولیں"; override val makeNextRelay = "اگلا ریلے بنائیں"
    override val actCopy = "کاپی"; override val actOpen = "کھولیں"; override val actRelay = "ریلے"
    override fun agoFmt(v: String) = "$v پہلے"
    override val catalogTopFor = "پراکسی فہرست/ریٹنگ برائے"
    override val catalogModeHelpTitle = "موڈز اور ریٹنگز"
    override val catalogModeHelp = "ایپ زندہ ہوسٹس اور ان کی ریٹنگز کو ہر نیٹ ورک موڈ (VPN، Wi-Fi، LTE، Ethernet اور White) کے لیے الگ الگ گنتی ہے۔ «White» وائٹ لسٹ کے لیے ایک الگ دستی موڈ ہے؛ خودکار اس پر کبھی نہیں جاتا۔ لہٰذا ایک ہی ہوسٹ ایک موڈ میں زندہ اور دوسرے میں مردہ ہو سکتا ہے۔"
    override fun catalogInactiveWarn(section: String, active: String) =
        "آپ غیر فعال سیکشن $section دیکھ رہے ہیں — ابھی تمام اعدادوشمار $active میں جا رہے ہیں، یہاں نہیں۔"
    override val manageModeTitle = "موڈ کا انتظام"
    override val manageResetRating = "ریٹنگ ری سیٹ کریں"
    override fun manageResetHint(mode: String) = "خاص طور پر $mode کے لیے آپ زندہ ہوسٹس کی ریٹنگ اور استعمال کے اعدادوشمار ری سیٹ کر سکتے ہیں۔ یہ اس وقت کارآمد ہے جب آپ بنیادی طور پر مختلف VPN یا LTE سے منسلک ہوئے ہوں، تاکہ پرانے اعدادوشمار مداخلت نہ کریں۔ یا یہ دیکھنے کے لیے کہ پراکسی اسکین کتنی تیزی سے سب کچھ نئے سرے سے دوبارہ جانچتا ہے۔"
    override val manageDeleteAll = "ہوسٹس حذف کریں اس میں"
    override fun manageDeleteHint(mode: String) = "آپ $mode سے ریٹنگ اور ہوسٹس دونوں کو صاف کر سکتے ہیں۔ \"پراکسیاں اسکین کریں\" خصوصیت انہیں دوبارہ جمع کرے گی۔ یہ سبسکرپشن ری سیٹ نہیں ہے — آپ اس پر ٹیپ کر سکتے ہیں، پھر دوبارہ اسکین کے لیے ~15 منٹ انتظار کریں۔"
    override fun manageCopyFrom(mode: String) = "تمام ہوسٹس اور ریٹنگز کو اس موڈ ($mode) میں دوسرے موڈ سے کاپی کریں:"
    override val live = "زندہ"; override val deadW = "مردہ"; override val unitMs = "ملی سیکنڈ"
    override val agoMin = "منٹ"; override val agoHour = "گھنٹہ"; override val agoDay = "دن"

    override val connectTelegram = "Telegram منسلک کرنا"; override val readCarefully = "غور سے پڑھیں!"
    override val guideIntro = "یہ ایپ ترتیب کے بغیر کام نہیں کرے گی۔ نیچے دیے گئے 3 اختیارات میں سے کوئی ایک منتخب کریں " +
        "اور ہدایات پر غور سے عمل کریں۔"
    override val variant1 = "اختیار #1 — بٹن"
    override val variant1Body = "\"Proxy {A}\" پر ٹیپ کریں — Telegram کھلتا ہے، پراکسی شامل کرنے کی تصدیق کریں۔ " +
        "اس اسکرین پر واپس آئیں اور \"Proxy {B}\" پر ٹیپ کریں — دوسری بار شامل کرنے کی تصدیق کریں۔\n\nTelegram میں کوئی بھی " +
        "دیگر پرانی پراکسیاں غیر فعال کریں۔ بالکل 2 پراکسیاں باقی رہنی چاہئیں — پورٹ {A} اور {B} کے ساتھ۔ " +
        "کسی اور سیٹ کے ساتھ AutoConnector کام نہیں کرے گا۔"
    override val variant2 = "اختیار #2 — لنکس"
    override val variant2Body = "نیچے کا متن Telegram میں Saved Messages (یا کسی بھی چیٹ) میں کاپی کریں — " +
        "یعنی اسے خود کو بھیجیں۔ اپنے پیغام میں پہلے لنک پر ٹیپ کریں — پہلی پراکسی شامل ہو جاتی ہے۔ " +
        "دوسرے لنک پر ٹیپ کریں — دوسری شامل ہو جاتی ہے۔ پھر تمام پرانی پراکسیاں غیر فعال کریں۔"
    override val variant3 = "اختیار #3 — دستی طور پر"
    override val variant3Body = "ایک SOCKS5 پراکسی دستی طور پر شامل کریں: سرور localhost (127.0.0.1)، پورٹ {A}۔ " +
        "پھر دوسری پراکسی: localhost، پورٹ {B}۔ کوئی بھی پرانی پراکسیاں حذف کریں۔"
    override val whatNext = "اگلا کیا؟"
    override val whatNextBody = "Telegram میں، \"پراکسی کی خودکار تبدیلی\" فعال کریں — 5 سیکنڈ۔ آپ " +
        "Telegram کو منسلک ہونے میں مدد کر سکتے ہیں اگر دستی طور پر (Telegram کے اندر) ایسی پراکسی پر ٹیپ کریں جو فعال نہ ہو یا " +
        "\"دستیاب نہیں\" نشان زد ہو — اس سے Telegram منسلک ہونے کی زیادہ کوشش کرتا ہے۔\n\nیقینی بنائیں کہ تمام دیگر پرانی " +
        "پراکسیاں ہٹا دی گئی ہیں، سوائے {A} اور {B} کے۔ Telegram میں " +
        "\"پراکسی استعمال کریں\" پر ٹیپ کریں۔\n\nانتظار کریں جب تک ایپ کافی پراکسیاں تلاش اور ڈاؤن لوڈ کرتی ہے " +
        "(5–15 منٹ)۔ پھر Telegram خود بخود AutoConnector سے منسلک ہو جاتا ہے، جو " +
        "Telegram کو بہترین پراکسیوں کے ذریعے روٹ کرتا رہے گا: تصدیق شدہ، زندہ اور تیز۔\n\nاگر ہدایات " +
        "مشکل لگیں — معذرت، آپ ایپ استعمال نہیں کر سکیں گے: ہر چیز خودکار طور پر ترتیب دینا " +
        "ناممکن ہے، اور زندہ پراکسیاں تلاش کرنے میں وقت لگتا ہے۔\n\nاگر آپ نے ایپ بہت پہلے ڈاؤن لوڈ کی تھی " +
        "اور کوئی زندہ پراکسی نہیں ملی — یا تو ایپ یا سبسکرپشن فہرست اپ ڈیٹ کریں۔ یہ ایپ " +
        "اپنی پراکسیاں ایجاد یا فراہم نہیں کرتی، یہ صرف درجنوں گروپوں اور صفحات میں انٹرنیٹ پر تلاش کرتی ہے۔"
    override fun proxyBtn(port: Int) = "Proxy $port"

    override val setupPortsTitle = "Telegram میں پورٹس ترتیب دیں"
    override val setupPortsSub = "Telegram کو کنیکٹر سے کیسے منسلک کریں (پورٹس 55001/55002)"
    override val settings = "ترتیبات"; override val settingsSub = "پورٹس، anti-DPI، اسکین، نیٹ ورک، بیٹری"
    override val subscriptions = "سبسکرپشنز"; override val subscriptionsSub = "اسکین کرنے کے لیے پراکسی ماخذ"
    override val statistics = "اعدادوشمار"; override val statisticsSub = "پراکسی ڈیٹابیس + anti-DPI تدابیر"
    override val export = "برآمد"; override val exportSub = "زندہ پراکسیوں کے tg:// لنکس"
    override val about = "بارے میں"; override val aboutSub = "ورژن، بلڈ، ڈاؤن لوڈ، رائے"
    override val hotkeys = "ہاٹ کیز"
    override val hotkeysSub = "عالمی کیز: پراکسی کاپی / کھولیں"
    override val hotkeysIntro = "عالمی ہاٹ کیز اس وقت بھی کام کرتی ہیں جب ایپ ونڈو فوکس میں نہ ہو۔ یہ پول سے " +
        "ایک بے ترتیب زندہ پراکسی لنک (tg://) منتخب کرتی ہیں — ایپ کھولے بغیر تیزی سے پراکسیاں تبدیل کرنے کے لیے " +
        "کارآمد۔"
    override val hotkeysNote = "macOS پر، کیز کیپچر کرنے کے لیے Accessibility اجازت درکار ہو سکتی ہے " +
        "(System Settings → Privacy & Security → Accessibility)۔"
    override val hotkeyCopyTitle = "پراکسی لنک کاپی کریں"
    override val hotkeyCopyDesc = "ایک بے ترتیب زندہ tg:// لنک کلپ بورڈ پر رکھتا ہے۔"
    override val hotkeyEnable = "ہاٹ کیز فعال کریں"; override val hotkeyLetterLabel = "حرف"; override val hotkeySet = "سیٹ"; override val hotkeyReset = "ری سیٹ"
    override val hotkeyOpenTitle = "پراکسی Telegram میں کھولیں"
    override val hotkeyOpenDesc = "ایک بے ترتیب زندہ لنک کھولتا ہے — Telegram اسے پکڑ کر پراکسی منسلک کرنے کی پیشکش کرتا ہے۔"

    override val relayPorts = "ریلے پورٹس"
    override val relayPortsHelp = "مقامی پورٹس جن پر کنیکٹر سنتا ہے۔ آپ بالکل یہی Telegram میں " +
        "SOCKS5 پراکسی (127.0.0.1 : پورٹ) کے طور پر داخل کرتے ہیں۔ اعتبار کے لیے دو پورٹس استعمال ہوتے ہیں — Telegram " +
        "دونوں کے ساتھ کنکشن برقرار رکھتا ہے۔"
    override val portA = "پورٹ A"; override val portB = "پورٹ B"
    override val antiDpiTrick = "Anti-DPI تدبیر"
    override val antiDpiHelp = "کنکشن کو چھپانے کا ایک طریقہ تاکہ ISP/DPI اسے پہچان کر " +
        "بلاک نہ کر سکے۔\n• \"خودکار گردش\" خود ایک کام کرنے والی تدبیر منتخب کرتا ہے۔\n• \"کوئی DPI تدبیر نہیں\" — ایک سادہ " +
        "کنکشن۔\n• باقی مخصوص تکنیکیں ہیں (براؤزر کی نقل، پیکٹ تقسیم، وغیرہ)۔"
    override val onlyFakeTls = "صرف FakeTLS (ee)"
    override val applyDpiTo = "anti-DPI لاگو کریں اس پر"
    override val applyDpiHelp = "منتخب کردہ anti-DPI تدبیر کس پر لاگو کرنی ہے:\n• Telegram ریلے — کنیکٹر کے ذریعے " +
        "زندہ Telegram کنکشن پر۔\n• پراکسی جانچ — بیک گراؤنڈ پراکسی جانچ پر " +
        "(پھر جانچ بالکل حقیقی کنکشن کی طرح برتاؤ کرتی ہے، اور تدبیر کے اعدادوشمار زیادہ درست ہوتے ہیں)۔\n" +
        "• براہِ راست منسلک ہوتے وقت — جب پراکسیاں بند ہوں (یا VPN آن ہونے پر چھوڑ دی گئی ہوں) اور Telegram " +
        "سیدھا اپنے سرورز پر جائے: یہاں کوئی پراکسی نہیں ہے، لہٰذا تدبیر صرف پہلے TCP پیکٹ " +
        "(ہینڈ شیک) کو کئی چھوٹے حصوں میں تقسیم کرنے تک محدود ہو جاتی ہے تاکہ DPI اسے ایک ہی بار میں نہ پہچان سکے۔"
    override val toRelay = "Telegram ریلے"; override val toProbes = "پراکسی جانچ"
    override val toDirect = "براہِ راست منسلک ہوتے وقت"
    override val vpnSection = "جب VPN آن ہو"
    override val vpnHelp = "جب ڈیوائس پر VPN فعال ہو تو کیا کرنا ہے:\n• MTProto پراکسی کے ذریعے — " +
        "Telegram معمول کے مطابق ملنے والی پراکسیوں سے گزرتا ہے (VPN کے اوپر)۔\n• براہِ راست — " +
        "کنیکٹر پراکسیاں استعمال نہیں کرتا اور Telegram کو سیدھا Telegram کے سرورز سے منسلک کرتا ہے: " +
        "VPN پہلے ہی رسائی فراہم کرتا ہے، اضافی پراکسی پرت کی ضرورت نہیں (تیز تر اور زیادہ مستحکم)۔ " +
        "VPN کے بغیر پراکسیاں معمول کے مطابق استعمال ہوتی ہیں۔"
    override val linkFormat = "پراکسی لنک فارمیٹ"
    override val linkFormatHelp = "پراکسیاں کیسے کاپی اور کھولنی ہیں۔ tg:// Telegram کو براہِ راست کھولتا ہے (Telegram Desktop انسٹال ہونا ضروری ہے)۔ http (t.me) براؤزر کے ذریعے کھلتا ہے اور Telegram میں کھولنے کی پیشکش کرتا ہے — اگر tg:// رجسٹرڈ نہ ہو تو کارآمد۔"
    override val linkTg = "tg:// (Telegram براہِ راست کھولیں)"; override val linkTgSub = "tg://proxy?… — Telegram کھولتا ہے"
    override val linkHttp = "http (t.me، براؤزر کے ذریعے)"; override val linkHttpSub = "https://t.me/proxy?… — براؤزر کھولتا ہے"
    override val viaMtproto = "MTProto کے ذریعے پراکسی"; override val viaMtprotoSub = "VPN کے ساتھ بھی، ٹریفک پراکسیوں سے گزرتی ہے"
    override val directly = "براہِ راست منسلک کریں"; override val directlySub = "VPN فعال ہونے پر — پراکسیوں کو نظرانداز کریں، سیدھا Telegram تک"
    override val notifications = "اطلاعات"
    override val scanCheck = "اسکین اور جانچ"
    override val scanCheckHelp = "• اسکین، منٹ — سبسکرپشنز سے پراکسی فہرستیں کتنی بار ڈاؤن لوڈ کرنی ہیں۔\n" +
        "• جانچ، منٹ — ڈیٹابیس میں پراکسیوں کی زندگی کے لیے کتنی بار دوبارہ جانچنا ہے۔\n• بیچ سائز — " +
        "ہر دور میں کتنی پراکسیاں جانچنی ہیں۔\n• متوازی — ایک ساتھ کتنی جانچیں چلانی ہیں (زیادہ = " +
        "تیز تر، لیکن نیٹ ورک اور بیٹری پر زیادہ بوجھ)۔"
    override val scanMin = "اسکین، منٹ"; override val checkMin = "جانچ، منٹ"; override val batchSize = "بیچ سائز"; override val parallel = "متوازی"
    override val speedByNet = "نیٹ ورک کے لحاظ سے اسکین کی شدت"
    override val speedByNetHelp = "موجودہ نیٹ ورک کے لحاظ سے پراکسیاں کتنی بار جانچنی ہیں۔ " +
        "\"معیاری\" = بنیادی وقفہ۔ کم بار کے لیے دائیں سرکائیں (سست، ٹریفک/بیٹری پر نرم)، " +
        "زیادہ بار کے لیے بائیں (تیز تر، زیادہ جارحانہ)۔ لاگرتھمک پیمانہ، ہر طرف ×100 تک۔\n" +
        "• VPN — جب کوئی بیرونی VPN فعال ہو۔\n• Wi-Fi — Wi-Fi نیٹ ورک پر۔\n• LTE — موبائل نیٹ ورک پر۔"
    override val intensStandard = "معیاری"
    override val intensSlower = "سست"
    override val intensFaster = "تیز تر"
    override val maintenance = "ڈیٹا ری سیٹ کریں"
    override val maintenanceHelp = "• \"کیٹلاگ اور اعدادوشمار ری سیٹ کریں\" — ریٹنگز، شمار، ٹریفک " +
        "اور جانچ لاگز کو صفر کرتا ہے، لیکن ڈاؤن لوڈ شدہ ہوسٹس اور سبسکرپشنز رکھتا ہے (اگلے اسکین پر " +
        "ہر چیز دوبارہ ریٹ ہوتی ہے)۔\n• \"ڈاؤن لوڈ شدہ ہوسٹس صاف کریں\" — پورا پراکسی پول حذف کرتا ہے لیکن " +
        "سبسکرپشنز رکھتا ہے تاکہ اسکین پول دوبارہ بھرے۔ سبسکرپشنز کو کسی بھی صورت میں ہاتھ نہیں لگایا جاتا۔"
    override val backupTitle = "برآمد / درآمد"
    override val backupHelp = "ایپ ڈیٹا کو ایک واحد JSON فائل میں محفوظ یا بحال کریں۔ شامل کرنے کے لیے " +
        "نشان زد کریں — کوئی بھی امتزاج:\n• ترتیبات — تمام ایپ پیرامیٹرز۔\n• سبسکرپشنز — ماخذ " +
        "فہرست (URL + آن/آف)۔\n• زندہ-ہوسٹ کیٹلاگ — ہر زندہ پراکسی اپنی ریٹنگز اور اعدادوشمار کے ساتھ " +
        "ہر نیٹ ورک موڈ کے لیے۔\n\n«برآمد» پوچھتا ہے کہاں محفوظ کرنا ہے؛ «درآمد» پوچھتا ہے کون سی فائل کھولنی ہے اور " +
        "اس میں موجود صرف نشان زد سیکشنز لاگو کرتا ہے۔ درآمد موجودہ ڈیٹا میں اضافہ کرتا ہے (مٹاتا نہیں)۔"
    override val backupSettings = "ترتیبات"
    override val backupSubs = "سبسکرپشنز"
    override val backupHosts = "زندہ-ہوسٹ کیٹلاگ (ہر موڈ)"
    override val exportWord = "برآمد"
    override val importWord = "درآمد"
    override val eraseAllHosts = "تمام ہوسٹس مٹائیں"
    override val factoryReset = "سب کچھ ری سیٹ کریں (پہلے لانچ کی طرح)"
    override val factoryResetConfirm = "ایپ کو مکمل طور پر فیکٹری حالت میں ری سیٹ کریں؟ تمام ترتیبات اور پورا " +
        "ہوسٹ کیٹلاگ مٹا دیا جائے گا، سبسکرپشنز ڈیفالٹ پر بحال۔ بالکل پہلے لانچ کی طرح۔"
    override val resetCatalog = "کیٹلاگ اور اعدادوشمار ری سیٹ کریں"
    override val resetCatalogConfirm = "تمام ریٹنگز، شمار اور جانچ لاگز صفر کریں؟ " +
        "ڈاؤن لوڈ شدہ ہوسٹس اور سبسکرپشنز رکھے جاتے ہیں اور اگلے اسکین پر دوبارہ ریٹ ہوتے ہیں۔"
    override val clearHosts = "ڈاؤن لوڈ شدہ ہوسٹس صاف کریں"
    override val clearHostsConfirm = "ڈاؤن لوڈ شدہ ہوسٹس (پراکسیوں) کی پوری فہرست حذف کریں؟ " +
        "سبسکرپشنز رکھی جاتی ہیں اور اسکین پول دوبارہ بھرے گا۔"
    override val doReset = "ری سیٹ"
    override val doCancel = "منسوخ"
    override val adaptiveSpeed = "موافق رفتار"
    override val adaptiveHelp = "زندگی کی جانچیں ایک بنیادی وقفے پر چلتی ہیں (\"اسکین اور جانچ\" سے، نیٹ ورک کے " +
        "ضارب سے بھی ضرب ہو کر)۔ \"موافق رفتار\" انہیں اس بنیاد پر خود بخود تیز یا سست کرتا ہے " +
        "کہ ابھی کتنی پراکسیاں زندہ ہیں۔\n\n" +
        "• کم زندہ (\"کم\" حد سے نیچے) → وقفہ × \"تیزی\"۔ 1 سے کم ضارب = زیادہ " +
        "بار: 0.5 — دوگنا بار، 0.25 — 4×۔ پول کو تیزی سے بھرتا ہے۔\n" +
        "• زیادہ زندہ (\"زیادہ\" حد سے اوپر) → وقفہ × \"سستی\"۔ 1 سے اوپر = کم بار: 2 — " +
        "آدھا بار، 4 — چوتھائی۔ بیٹری اور ٹریفک بچاتا ہے۔\n" +
        "• حدود کے درمیان — بنیادی رفتار (×1)۔\n\n" +
        "مثالیں:\n" +
        "— پراکسیاں تیزی سے جمع کریں: \"تیزی\" 0.25 اور/یا \"کم\" حد 40۔\n" +
        "— کافی ہونے پر بیٹری بچائیں: \"سستی\" 8 اور/یا \"زیادہ\" حد 30۔\n" +
        "— موافقت بند کریں: دونوں ضاربوں کو 1 پر سیٹ کریں۔\n\n" +
        "ڈیفالٹ: کم 20، تیزی 0.5، زیادہ 50، سستی 4۔"
    override val threshMany = "\"زیادہ\" حد"; override val threshFew = "\"کم\" حد"; override val mulFast = "تیزی ×"; override val mulLazy = "سستی ×"
    override val subIntensityTitle = "سبسکرپشن کی شدت"
    override val subIntensityHint = "سبسکرپشن ڈاؤن لوڈز کے درمیان وقفہ: پراکسی فہرستیں دوبارہ ڈاؤن لوڈ کرنے سے پہلے کتنے منٹ (ہر نیٹ ورک موڈ کے لیے الگ)۔"
    override val baseScanTitle = "بنیادی اسکین رفتار"
    override val baseScanHelp = "حوالہ زندگی-جانچ رفتار۔ «موافق رفتار» اور «موڈ کے لحاظ سے رفتار» " +
        "ضاربین اس کے نسبت سے شمار ہوتے ہیں۔\n\n" +
        "• کتنی بار چلانا ہے، منٹ — جانچ کے دوروں کے درمیان وقفہ۔\n" +
        "• فی تھریڈ بیچ، ہوسٹس — ہر تھریڈ فی دور کتنے ہوسٹس جانچتا ہے۔\n" +
        "• تھریڈز — ایک ساتھ کتنی جانچیں چلتی ہیں۔ ایک دور «بیچ × تھریڈز» ہوسٹس کی جانچ کرتا ہے۔\n" +
        "• کسی ہوسٹ کو N منٹ سے زیادہ بار دوبارہ اسکین نہ کریں — اینٹی فلڈ: حال ہی میں جانچا گیا ہوسٹ " +
        "اس دور میں چھوڑ دیا جاتا ہے۔\n\n" +
        "زیادہ تھریڈز اور بڑا بیچ = پول کی تیز تر نمو، لیکن نیٹ ورک اور بیٹری پر بھاری بوجھ۔"
    override val baseScanPeriod = "کتنی بار چلانا ہے، منٹ"
    override val baseScanBatch = "فی تھریڈ بیچ، ہوسٹس"; override val baseScanThreads = "تھریڈ کی تعداد"
    override val adaptiveDesc = "اگر زندہ پراکسیاں «کم» سے کم یا «زیادہ» سے زیادہ ہوں، تو ایک اضافی ضارب لاگو کریں۔"
    override val fewWord = "کم"; override val manyWord = "زیادہ"
    override fun fasterX(x: String) = "$x× تیز تر"
    override fun slowerX(x: String) = "$x× سست"
    override fun ifAliveLt(n: Int) = "اگر زندہ پراکسیاں < $n ہوں، تو:"
    override fun ifAliveGt(n: Int) = "اگر زندہ پراکسیاں > $n ہوں، تو:"
    override val disabledWord = "بند"
    override val speedByModeTitle = "موڈ کے لحاظ سے رفتار"
    override val speedByModeHelp = "ہر نیٹ ورک موڈ کے لیے ایک اسکین-رفتار ضارب، بنیادی رفتار کے اوپر۔ " +
        "«معیاری» (×1) = بنیادی وقفہ۔ دائیں — کم بار (سست، ٹریفک/" +
        "بیٹری پر نرم)، بائیں — زیادہ بار (تیز تر، زیادہ جارحانہ)۔ لاگرتھمک پیمانہ، ہر طرف ×100 " +
        "تک۔\n\n" +
        "ہر سلائیڈر کے نیچے موافق رفتار لاگو ہونے کے ساتھ نتیجہ خیز دور کے پیرامیٹرز ہیں — " +
        "«کم زندہ» (× «تیزی») اور «زیادہ زندہ» (× «سستی») کے لیے الگ الگ دکھائے گئے۔\n\n" +
        "موڈز:\n• VPN — ایک بیرونی VPN فعال ہے۔\n• LTE — موبائل نیٹ ورک۔\n• Wi-Fi — Wi-Fi نیٹ ورک۔\n" +
        "• Ethernet — تار والا کنکشن۔\n• White — دستی «white» پراکسی موڈ۔"
    override val aliveLt = "زندہ <"; override val aliveGt = "زندہ >"
    override val periodWord = "وقفہ"; override val nonstopWord = "بلا توقف"
    override val batchWord = "بیچ"; override val threadsWord = "تھریڈز"; override val scanModeOff = "اسکین بند"
    override val netBattery = "نیٹ ورک اور بیٹری"
    override val netBatteryHelp = "• صرف Wi-Fi — موبائل نیٹ ورک پر اسکین نہ کریں (ڈیٹا بچاتا ہے)۔\n• صرف " +
        "چارجنگ — صرف فون چارج ہوتے وقت کام کریں۔\n• کم بیٹری پر چھوڑیں — بیٹری کم ہونے پر " +
        "اسکیننگ روکیں۔"
    override val onlyWifi = "صرف Wi-Fi"; override val onlyCharging = "صرف چارجنگ"; override val skipLowBattery = "کم بیٹری پر چھوڑیں"
    override val autosaved = "ترتیبات خود بخود محفوظ ہوتی ہیں۔"
    override val dpiAutoLabel = "DPI تدابیر خودکار گردش"; override val dpiNoneLabel = "کوئی DPI تدبیر نہیں (سادہ)"
    override val experimental = "تجرباتی"
    override val experimentalHelp = "MTProto اپ اسٹریم کے متبادل پراکسی انجن کے علاوہ ایک تشخیصی لاگ۔ " +
        "حوالہ (کام کرنے والا) راستہ تبدیل نہیں ہوتا جب «بند» پر سیٹ ہو۔ صرف یہ تبدیل ہوتا ہے کہ خفیہ کردہ اسٹریم " +
        "اپ اسٹریم TCP ساکٹ پر کیسے لکھی جاتی ہے (سیگمنٹ سائز، ٹائمنگ، TLS-ریکارڈ کی حدود) — اسٹریم خود بائٹ-بہ-بائٹ یکساں رہتی ہے۔ " +
        "صرف زندہ پراکسی ریلے پر لاگو ہوتا ہے (جانچ پر نہیں، براہِ راست راستے پر نہیں)۔"
    override val expEngineTitle = "پراکسی انجن (ساکٹ ابہام)"
    override val expConnectTitle = "کنیکٹ انجن (اپ اسٹریم انتخاب)"
    override val raceWidthTitle = "متوازی کنیکٹس"
    override val connectionSection = "کنکشن اور بلاک بائی پاس"
    override val connectionSectionHelp = "کنیکٹ انجن، متوازی اپ اسٹریمز، پراکسی انجن اور anti-DPI تدابیر — سب ایک سیکشن میں۔"
    override val netLogSection = "نیٹ ورک تبادلہ لاگ"
    override val expEngineWarn = "⚠ تجرباتی موڈ۔ اگر کنیکٹیویٹی خراب ہو، تو «بند (حوالہ راستہ)» پر واپس جائیں۔"
    override val netLog = "نیٹ ورک-تبادلہ لاگ فعال کریں"
    override val netLogSub = "کس سے کس کو کب اور پیکٹ سائز کو ایک فائل میں لکھتا ہے (کوئی پے لوڈ ڈیٹا نہیں) — " +
        "VPN کے ساتھ بمقابلہ بغیر تبادلے کے انداز کا موازنہ کرنے کے لیے۔"
    override val openLogFolder = "لاگ فولڈر کھولیں"; override val copyPath = "راستہ کاپی کریں"
    override val helpShow = "مدد"; override val helpHide = "مدد چھپائیں"
    override val quickSwitchIntro = "یہاں آپ ایک بلاک-بائی پاس تدبیر منتخب کر سکتے ہیں۔ اگر Telegram خرابی دکھائے " +
        "“The proxy you are using is not configured correctly and will be disabled. Please find another " +
        "one”، تو تجربہ کریں کہ کون سی ٹریفک-ابہام قسم کام کرتی ہے تاکہ Telegram اسے دکھانا بند کرے۔ " +
        "split* موڈز سے شروع کریں۔ coalesce* موڈز بھی کام کرتے ہیں، لیکن ان کے ساتھ Telegram میں تصاویر/ویڈیوز خراب لوڈ ہوتی ہیں۔"
    override val quickSwitchTitle ="بلاک بائی پاس"; override val quickSwitchSub = "شیپنگ، کنیکٹ، anti-DPI"

    override val sourceUrl = "ماخذ URL"
    override fun sourceAlive(alive: Int, total: Int) = "زندہ $alive/$total"
    override val open = "کھولیں"; override val active = "فعال"; override val inactive = "غیر فعال"
    override val lastDownloaded = "ڈاؤن لوڈ ہوا"; override val notDownloaded = "ابھی ڈاؤن لوڈ نہیں ہوا"
    override fun sourceCounts(dead: Int, total: Int) =
        " زندہ، $dead مردہ، $total کل"

    override val proxyBase = "پراکسی ڈیٹابیس"
    override val totalInBase = "ڈیٹابیس میں کل"; override val aliveNow = "ابھی زندہ"; override val deadStat = "مردہ"
    override val aliveIn15 = "15 منٹ میں زندہ"; override val checksAllTime = "تمام وقت کی جانچیں"
    override val antiDpiTricks = "Anti-DPI تدابیر"; override val noStatsYet = "ابھی کوئی ڈیٹا نہیں — جانچ/کنکشن ہونے پر تدابیر جمع ہوتی ہیں"
    override val attempts = "کوششیں"; override val handshake = "ہینڈ شیک"; override val score = "اسکور"
    override val tgConnect = "TG کنیکٹ"; override val socketsOver1m = "ساکٹس >1منٹ"
    override val over10kb = "ساکٹس >10KB"; override val over100kb = ">100KB"; override val workTime = "کام کا وقت"
    override val statsLegend = "ہینڈ شیک — کامیاب ہینڈ شیکس (کوششوں کا %) · اسکور — قدر · " +
        "\"کام کا وقت\" — ساکٹس ≥5KB اور 1 منٹ سے طویل پر کل۔"
    override val resetStats = "تدبیر کے اعدادوشمار ری سیٹ کریں"

    override fun aliveLinks(n: Int) = "زندہ لنکس: $n"
    override val copyAll = "سب کاپی کریں"
    override val openRandom = "بے ترتیب کھولیں"; override val copyRandom = "بے ترتیب کاپی کریں"; override val allShort = "سب"
    override val copyTop = "TOP کاپی کریں"; override val randomHost = "بے ترتیب ہوسٹ"
    override val exportToFile = "فائل میں برآمد کریں"; override val exportSaved = "فائل میں محفوظ:"
    override val dlNow = "ابھی ڈاؤن لوڈ کریں"
    override fun downloadingFmt(sec: Long) = "ڈاؤن لوڈ ہو رہا ہے… ${sec}سیک"
    override val cancel = "منسوخ"
    override val deleteConfirmTitle = "سبسکرپشن حذف کریں؟"
    override val subscriptionsAddHint = "سبسکرپشنز یا پراکسی لنکس شامل کریں →"
    override val addSourcesTitle = "شامل کریں"
    override val addSubsLabel = "سبسکرپشنز (فی لائن ایک URL)"
    override val addSubsHelp = "درست URL والی ہر لائن اپنی سبسکرپشن بن جاتی ہے اور وقتاً فوقتاً حاصل کی جاتی ہے۔"
    override val addProxiesLabel = "تیار پراکسی لنکس (ثابت فہرست)"
    override val addProxiesHelp = "مخصوص پراکسیوں کے لنکس کا ایک بیچ چسپاں کریں (tg://proxy، https://t.me/proxy، …)۔ یہ سبسکرپشن نہیں ہے — فہرست کبھی ڈاؤن لوڈ نہیں ہوتی، پراکسیاں صرف کیٹلاگ میں شامل ہو جاتی ہیں۔"
    override val addButton = "شامل کریں"
    override fun addedFmt(subs: Int, proxies: Int) = "شامل ہوئے: $subs سبسکرپشنز، $proxies پراکسیاں"
    override val perSecond = "فی سیکنڈ"
    override val graphSpeed = "رفتار"
    override val graphVolume = "حجم"
    override val graphLatency = "Ping"
    override val graphConnects = "کنیکٹس"
    override val scanNow = "ابھی اسکین کریں"; override val scanOnShort = "اسکین آن"
    override val scanRunning = "اسکین چل رہا ہے"; override val scanIdle = "اسکین غیر فعال"; override val scanOffState = "اسکین بند"; override val scanBatchPerThread = "بیچ/تھریڈ"; override val scanPassHosts = "دور میں ہوسٹس"; override val minRescanLabel = "کسی ہوسٹ کو N منٹ سے زیادہ بار دوبارہ اسکین نہ کریں"
    override val scanPlanTitle = "منصوبہ"; override val scanNowTitle = "ابھی"; override val currentScheduleTitle = "موجودہ شیڈول"
    override val scheduleWord = "شیڈول"; override val unitPcsPerSec = "عدد/سیک"
    override val scanNowThreadsLabel = "ابھی چلنے والے تھریڈز"; override val scanNowPerThreadLabel = "فی تھریڈ جانچیں (منصوبہ)"; override val scanNowElapsedLabel = "چلنے کا وقت"
    override val scanOkGraph = "کامیاب اسکین"; override val scanFailGraph = "ناکام اسکین"; override val scanTrafficGraph = "اسکین ٹریفک"; override val scanAliveGraph = "کل زندہ پراکسیاں"; override val scanPingGraph = "Ping"; override val threadsGraph = "تھریڈز"
    override val scanEvery = "ہر"; override val scanNextRun = "اگلا دور"
    override val scanThreads = "تھریڈز"; override val scanBatch = "بیچ"
    override val scanElapsed = "چل رہا ہے"; override val scanIdleNow = "—"
    override val effForFew = "جب کم"; override val effForMany = "جب زیادہ"
    override val effCheck = "جانچ"; override val effBatch = "بیچ"; override val effPar = "متوازی"
    override val effContinuous = "مسلسل"; override val secShort = "سیک"; override val minShort = "منٹ"

    override val appTagline = "کراس-پلیٹ فارم آٹو-کنیکٹر: یہ MTProto پراکسیاں تلاش، جانچ اور چلاتا ہے " +
        "جن کے ذریعے Telegram کام کرتا ہے۔"
    override val version = "ورژن"; override val buildDate = "بلڈ تاریخ"; override val platform = "پلیٹ فارم"
    override val downloadSources = "ڈاؤن لوڈ اور ماخذ"; override val openOnGithub = "GitHub پر کھولیں"
    override val feedbackBugs = "رائے اور بگ رپورٹس"; override val writeTelegram = "Telegram پر لکھیں"

    override val language = "زبان"; override val langAuto = "خودکار (سسٹم)"; override val langRu = "Русский"; override val langEn = "English"
    override val langFa = "فارسی"; override val langZh = "简体中文"; override val langAr = "العربية"; override val langUr = "اردو"
    override val langTr = "Türkçe"; override val langId = "Bahasa Indonesia"; override val langHi = "हिन्दी"; override val langBn = "বাংলা"; override val langMy = "မြန်မာ"
    override val langWord = "زبان"

    override val scanModeTitle = "نیٹ ورک موڈ"; override val scanModeAuto = "خودکار"; override val scanModeManualLabel = "دستی"
    override val activeModeLabel = "فعال موڈ"; override val formingListLabel = "فہرست بن رہی ہے"; override val catalogModeTabs = "موڈ"
    override val resetModeRatings = "ہوسٹ ریٹنگز ری سیٹ کریں"; override val forgetModeHosts = "موڈ ہوسٹس بھول جائیں"
    override val exportModeTitle = "موڈ کے لحاظ سے برآمد"; override val modePickerTitle = "موڈ"
    override val modeHelp = "ہر نیٹ ورک موڈ اپنی پراکسی ریٹنگز اور اپنی اسکین + سبسکرپشن-ڈاؤن لوڈ شدت رکھتا ہے۔ «خودکار» فعال نیٹ ورک سے موڈ منتخب کرتا ہے۔ «دستی» آپ کو خود کوئی بھی موڈ منتخب کرنے دیتا ہے (بشمول White، جسے خودکار کبھی منتخب نہیں کرتا)۔"
    override val autoSelect = "خودکار انتخاب"; override val manualSelect = "دستی انتخاب"
    override val connStatsTitle = "ابھی کنکشنز"; override val connOnPort = "پورٹ پر کنکشنز"; override val outgoingConns = "بیرونی کنکشنز"
    override val modeChoice = "موڈ انتخاب"; override val autoChoice = "خودکار انتخاب"; override val manualChoice = "دستی ثابت"
    override val directOnVpn = "VPN پر TG سے براہِ راست کنیکٹ"; override val onWord = "آن"; override val offWord = "آف"
    override val directStateActive = "فعال"; override val directStateOff = "ترتیبات میں بند"; override val directStateIdle = "ترتیبات میں آن، لیکن فعال نہیں"
    override val wpHintTitle = "White کیا ہے؟"
    override val wpHint = "White — WhitePages: ایک دستی نیٹ ورک پروفائل۔ صرف ہاتھ سے فعال ہوتا ہے (خودکار-انتخاب اسے کبھی نہیں چنتا)۔ " +
        "اپنی ہوسٹ ریٹنگز رکھتا ہے، سبسکرپشنز ڈاؤن لوڈ کرتا ہے اور VPN/Wi-Fi/LTE سے آزادانہ اسکین کرتا ہے۔"

    override val recentAttempts = "حالیہ کنکشن اور جانچ"
    override val kindCheck = "جانچ"
    override val kindTg = "Telegram"
    override val histWho = "کون"
    override val histWhen = "کب"
    override val histReq = "درخواست"
    override val histSess = "سیشن"
    override val histScan = "اسکین"
    override val testNow = "ابھی ٹیسٹ کریں"
    override val testShort = "ٹیسٹ"
    override val testResult = "ٹیسٹ کا نتیجہ"
    override val testStop = "روکیں"
    override val testingNow = "ٹیسٹ ہو رہا ہے…"
    override val prewarmTitle = "ساکٹس پیشگی گرم کرنا (تجرباتی)"
    override val prewarmHelp = "پراکسی سے چند اپ اسٹریم ساکٹس پہلے سے کھلے رکھیں تاکہ نیا Telegram " +
        "کنکشن کنیکٹ/ہینڈ شیک چھوڑ سکے۔ تجرباتی: یہ بیک گراؤنڈ میں مسلسل دوبارہ منسلک ہوتا ہے، اس لیے " +
        "ٹریفک اور تھوڑا CPU خرچ کرتا ہے۔ کوئی جعلی ٹریفک نہیں بھیجی جاتی (یہ حقیقی سیشن خراب کر دیتی) — " +
        "ساکٹس صرف گردش کرتے ہیں۔ FakeTLS پراکسیوں کے ساتھ سب سے زیادہ مفید۔"
    override val prewarmEnable = "پیشگی گرمی فعال کریں"
    override val prewarmModeDeferred = "مؤخر (صرف TLS)"
    override val prewarmModeDeferredSub = "TCP + FakeTLS رکھتے ہیں؛ init حوالگی کے وقت مکمل کرتے ہیں۔ کوئی DC کمٹ نہیں ہوتا — سب سے زیادہ حقیقت پسندانہ۔"
    override val prewarmModeFull = "مکمل ہینڈ شیک"
    override val prewarmModeFullSub = "مختلف DC پر مکمل منسلک ساکٹس رکھتے ہیں؛ صرف DC/tag مماثلت پر دوبارہ استعمال ہوتے ہیں۔ کم زندہ رہتے ہیں۔"
    override val prewarmPoolLabel = "ریزرو ساکٹس"
    override val prewarmHoldLabel = "ہر ایک رکھیں، سیکنڈ"
    override val prewarmNote = "صرف گردش (ایپ سطح پر کوئی keepalive نہیں)۔ ساکٹ پراکسی/DC کے مطابق سیکنڈز…~ایک منٹ زندہ رہتا ہے۔"
    override val prewarmStatus = "پیشگی گرمی"
    override fun prewarmStatusVal(ready: Int, holdSecs: Int) = "${ready} تیار · ${holdSecs}س رکھے"
    override val prewarmStar = "موٹا نارنجی = ساکٹ پیشگی گرمی کے پول سے گرم دیا گیا (کنیکٹ/ہینڈ شیک کے بغیر)"
    override fun prewarmTableTitle(holdSecs: Int) = "ساکٹس پیشگی گرم کرنا (${holdSecs}س رکھے)"
    override val prewarmTableHelp = "«ساکٹس پیشگی گرم کرنا» پراکسی سے چند ساکٹس پہلے سے کھولتا ہے تاکہ نیا " +
        "Telegram کنکشن کنیکٹ/ہینڈ شیک چھوڑ سکے۔ اس ٹیبل میں گرم کیے جانے والے ہوسٹس دکھائے گئے ہیں: ہر ساکٹ " +
        "کتنے سیکنڈ زندہ رہا، کیا Telegram اسے استعمال کر رہا ہے، اور ٹریفک۔ اسے فعال/غیر فعال کرنا اور ترتیب دینا " +
        "(موڈ، ساکٹس کی تعداد، رکھنے کا وقت) «مزید → ترتیبات → „ساکٹس پیشگی گرم کرنا (تجرباتی)“» میں ممکن ہے۔"
    override val prewarmNoneWarming = "ابھی کوئی ساکٹ گرم نہیں ہو رہا"
    override val prewarmColAge = "عمر"
    override val prewarmColUse = "TG میں؟"
    override val prewarmInUse = "TG میں"
    override val prewarmNew = "نیا"
    override val lanShareTitle = "LAN پر شیئر کریں (ویب پورٹل)"
    override val lanShareDesc = "اس Wi-Fi پر دیگر آلات کو اس AutoConnector کو بطور پراکسی استعمال کرنے دیں؛ نیچے دیے گئے پتے کو کھولنے والا براؤزر بہترین پراکسیوں کا صفحہ حاصل کرے گا۔"
    override val lanShareUrlsLabel = "پڑوسی یہاں منسلک ہوں:"
    override val lanShareNoIp = "کوئی مقامی نیٹ ورک ایڈریس نہیں — Wi-Fi سے منسلک ہوں"
    override val lanFirewallTitle = "مقامی نیٹ ورک پر اجازت دیں"
    override val lanFirewallBody = "اسے فعال کرنے سے ریلے پورٹس آپ کے مقامی نیٹ ورک پر کھل جائیں گے۔ اب Windows (یا کوئی اور) فائر وال پوچھ سکتا ہے کہ AutoConnector کو اجازت دی جائے — «اجازت دیں»/«ہاں» منتخب کریں۔ اگر آپ انکار کریں تو پڑوسیوں کی AutoConnector تک ٹریفک بلاک ہو جائے گی اور صفحہ/پراکسی قابلِ رسائی نہیں ہوں گے۔"
    override val lanFirewallConfirm = "فعال کریں"
    override val lanInfoTitle = "یہ کس لیے ہے؟"
    override val lanInfoBody = "AutoConnector کو اپنے Wi-Fi پر ایک ہی کمپیوٹر یا فون پر چلائیں — اور اسی نیٹ ورک کے باقی تمام آلات، بشمول iPhone (جسے یہ ایپ براہِ راست سپورٹ نہیں کرتی)، بس براؤزر میں پتہ کھول کر استعمال کر سکتے ہیں: ان کے Telegram میں شامل کرنے کے لیے بہترین پراکسیوں کا صفحہ، یا یہی آلہ بطور SOCKS پراکسی۔ ایک آلہ پراکسیاں تلاش کرکے رکھتا ہے، باقی انہیں مقامی نیٹ ورک پر مستعار لیتے ہیں۔"
    override val volTriggerTitle = "والیوم-بٹن ٹرگر"
    override val volTriggerSub = "تیز والیوم-کی پیٹرن سے پراکسی تبدیل کریں"
    override val volEnableLabel = "والیوم بٹن دیکھیں"
    override val volHelpTitle = "یہ کیا ہے؟"
    override val volHelpBody = "Android پر کوئی عالمی کی بورڈ ہاٹ کیز نہیں، اس لیے اس کے بجائے والیوم بٹن استعمال ہوتے ہیں۔ جب فعال ہو، AutoConnector بیک گراؤنڈ میں والیوم-اوپر/نیچے دباؤ کے تیز پیٹرن (مثلاً اوپر-اوپر-نیچے-نیچے) کی نگرانی کرتا ہے۔ اسے پہچان کر، یہ کسی بے ترتیب اچھے زندہ پراکسی کا tg:// لنک کھولتا ہے تاکہ Telegram اسے پکڑ کر تبدیل ہو جائے — ایپ کھولے بغیر پراکسی گھمانے کا ایک تیز، غیر محسوس طریقہ۔ والیوم معمول کے مطابق کام کرتا رہتا ہے (دباؤ نگلے نہیں جاتے)۔ اس کے لیے Accessibility رسائی درکار ہے (بیک گراؤنڈ میں والیوم کیز پڑھنے اور لنک کھولنے کے لیے)؛ جب تک آپ ٹوگل فعال نہ کریں کچھ نہیں مانگا جاتا۔ نیچے دباؤ کے درمیان زیادہ سے زیادہ وقت سیٹ کریں؛ تسلیم شدہ پیٹرنز نیچے درج ہیں۔"
    override val volGrantTitle = "Accessibility فعال کریں (اہم)"
    override val volGrantBody = "Android (خاص طور پر 13+) Google Play کے علاوہ سے انسٹال کی گئی ایپس کے لیے Accessibility بلاک کرتا ہے — اسی لیے AutoConnector دھندلا ہے اور «Restricted setting» / «رسائی کی اجازت نہیں» لکھتا ہے۔\n\nبلاک کیسے ہٹائیں:\n1. «App info» کھولیں (نیچے بٹن، یا: ترتیبات → ایپس → AutoConnector for Telegram)۔\n2. ⋮ مینو (اوپر دائیں تین نقطے) پر ٹیپ کریں → «Allow restricted settings» → تصدیق کریں۔\n3. واپس جائیں: ترتیبات → Accessibility → AutoConnector for Telegram → اسے فعال کریں۔\n\nاگر «Allow restricted settings» نظر نہ آئے — پہلے ایک بار Accessibility میں ٹوگل فعال کرنے کی کوشش کریں (بلاک کا پیغام آئے گا)، پھر مرحلہ 2 ظاہر ہو جائے گا۔\n\nXiaomi/MIUI، Samsung وغیرہ پر راستہ تھوڑا مختلف ہو سکتا ہے — «App info» میں وہی ⋮ تلاش کریں۔ Android 12 اور پرانے پر عموماً کوئی پابندی نہیں — اسے سیدھا فعال کریں۔\n\nوالیوم کیز صرف پڑھی جاتی ہیں، کبھی بلاک نہیں ہوتیں۔"
    override val volOpenAppInfo = "App info کھولیں"
    override val volAccessOn = "Accessibility: دی گئی"
    override val volAccessOff = "Accessibility: نہیں دی گئی"
    override val volOpenAccess = "Accessibility ترتیبات کھولیں"
    override val volGapLabel = "دباؤ کے درمیان زیادہ سے زیادہ ملی سیکنڈ"
    override val volPatternsTitle = "تسلیم شدہ پیٹرنز"
    override val volPatternPick = "پیٹرن"
    override val volPatternsLegend = "↑ = والیوم اوپر، ↓ = والیوم نیچے"
    override val volNoRights = "ایپ کے پاس ابھی والیوم بٹن سنبھالنے کی اجازت نہیں ہے — اس صفحے کے نیچے دیے گئے مراحل کے مطابق رسائی دیں۔"
    override val volGrantShort = "ابھی Accessibility رسائی نہیں۔ اس صفحے کے نیچے تفصیلی مراحل پڑھیں، پھر «جانچیں» پر ٹیپ کریں۔"
    override val volCheck = "جانچیں"
    override val volCheckOk = "✓ ہو گیا — رسائی دے دی گئی، ٹرگر کام کرتا ہے۔"
    override val volCheckFail = "✗ ابھی بھی رسائی نہیں — اوپر دیے گئے مراحل مکمل کریں۔"
    override val volPatternsList = "↑↑↓↓ · ↓↓↑↑ · ↑↓↑↓ · ↓↑↓↑ · ↑↑↑↑ · ↓↓↓↓ · ↑↓↓↑ · ↓↑↑↓ · ↑↑↑↓↓↓ · ↓↓↓↑↑↑   (↑ = والیوم اوپر، ↓ = نیچے)"
    override val histLegend = "کالمز — کون: ✓/✗ TG = حقیقی Telegram کنکشن، اسکین = بیک گراؤنڈ جانچ۔ کب: کتنا پہلے۔ TCP/TLS/درخواست: ہینڈ شیک اور پہلی درخواست کی تاخیر، ملی سیکنڈ۔ سیشن: ریلے سیشن کتنی دیر چلا۔ ↓/↑: ہوسٹ کے ذریعے موصول / بھیجے گئے بائٹس۔"
    override val tgOkTotalHint = "Telegram کنکشنز / کامیاب / کل جانچ"
    override val breadthTitle = "ہوسٹ انتخاب کی وسعت"
    override val breadthHelp = "بائیں = بہترین آزمودہ ہوسٹس پر قائم رہیں؛ دائیں = تمام زندہ ہوسٹس میں زیادہ سے زیادہ وسیع پیمانے پر آزمائیں۔ جب Telegram ریلے پورٹس کے درمیان بھٹکتا رہتا ہے، تو ایپ خود بخود تلاش کو وسیع کر دیتی ہے۔"
    override val breadthNarrow = "آزمودہ"
    override val breadthWide = "وسیع ترین"
    override val connTimeoutTitle = "فی ہوسٹ کنیکٹ ٹائم آؤٹ"
    override val connTimeoutHelp = "اگلی پراکسی آزمانے سے پہلے ایک اپ اسٹریم (TCP + TLS + پہلا MTProto جواب) کا کتنا انتظار کرنا ہے۔"
    override val backupExportTitle = "ڈیٹا برآمد کریں"
    override val backupImportTitle = "ڈیٹا درآمد کریں"
    override val backupSelectExport = "کیا برآمد کرنا ہے:"
    override val backupSelectImport = "کیا درآمد کرنا ہے:"
    override val backupCopyBtn = "کاپی کریں"
    override val backupSaveFile = "فائل میں محفوظ کریں"
    override val backupLoadFile = "فائل سے لوڈ کریں"
    override val backupDoImport = "درآمد"
    override val backupPasteLabel = "بیک اپ JSON یہاں چسپاں کریں"
    override val backupJsonLabel = "بیک اپ JSON"
    override val backupAndroidFileNote = "یہاں فائلیں دستیاب نہیں — کاپی / پیسٹ استعمال کریں۔"
    override val factoryResetDone = "سب کچھ ری سیٹ ہو گیا۔ براہِ کرم ایپ بند کرکے دوبارہ کھولیں۔"
}
