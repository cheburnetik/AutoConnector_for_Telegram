package io.autoconnector.i18n

object Fa : Strings {
    override val tabConnector = "رله"; override val tabScan = "اسکن"
    override val tabCatalog = "فهرست"; override val tabLogs = "گزارش‌ها"; override val tabMore = "بیشتر"
    override val logTabTelegram = "تلگرام"; override val logTabSubs = "اشتراک‌ها"; override val logTabScan = "اسکن"
    override val logGeneral = "عمومی"; override val logEmpty = "فعلاً خالی است"
    override val logSessions = "نشست‌ها"; override val logErrorsOnly = "فقط خطاها"; override val logNoErrors = "هیچ نشست ناموفقی نیست"
    override fun logSession(id: String, port: String) = "#$id · :$port"
    override val back = "بازگشت"; override val copy = "کپی"; override val gotIt = "فهمیدم"
    override val later = "بعداً"; override val details = "جزئیات"; override val whatIsThis = "این چیست؟"
    override val delete = "حذف"

    override val connector = "رله"; override val scan = "اسکن"
    override val notConfigured = "تنظیم نشده! اصلاح کنید ←"; override val howToSetup = "نحوهٔ تنظیم"
    override val notifOff = "اعلان‌ها خاموش‌اند! اصلاح کنید ←"; override val enable = "فعال‌سازی"
    override fun fewProxies(n: Int) = "پروکسی‌های زنده $n، در حال جستجو، حدود ۱۵ دقیقه صبر کنید…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "پروکسی‌های زنده: $alive  (۱۵ دقیقه: $within) · کل: $total"
    override val notifWhyTitle = "چرا اعلان‌ها؟"
    override val notifWhyBody = "آیکون اعلان دائمی به معنای یک سرویس پیش‌زمینهٔ اندروید است. " +
        "بدون آن، سیستم برنامه را از حافظه تخلیه می‌کند و جستجوی پروکسی‌ها و " +
        "نگه‌داشتن اتصال در پس‌زمینه متوقف می‌شود. به همین دلیل اعلان‌ها برای " +
        "کارکرد AutoConnector لازم‌اند."
    override val notifEnableTitle = "فعال‌سازی اعلان‌ها"
    override val notifEnableBody = "بدون آیکون اعلان، اندروید برنامه را غیرفعال در نظر می‌گیرد و " +
        "آن را از حافظه تخلیه می‌کند. آنگاه AutoConnector جستجوی پروکسی‌ها و نگه‌داشتن " +
        "اتصال در پس‌زمینه را متوقف می‌کند — و تلگرام پیوند خود را از دست می‌دهد.\n\nروی \"فعال‌سازی\" بزنید و اجازهٔ " +
        "اعلان‌ها را برای AutoConnector بدهید."
    override val notifPlea = "اعلان‌ها را فعال کنید! بدون آن‌ها برنامه نمی‌تواند در پس‌زمینه اجرا شود — " +
        "اندروید آن را تخلیه می‌کند و جستجوی پروکسی و اتصال متوقف می‌شود."

    override val statusConnected = "تلگرام متصل است"; override val statusConnecting = "در حال اتصال…"
    override val statusOffline = "تلگرام متصل نیست"; override val statusIdle = "تلگرام بی‌کار است"
    override val nobodyConnected = "کسی به رله متصل نشده است. "; override val howToSetupArrow = "نحوهٔ تنظیم ←"
    override val directModeViaVpn = "حالت مستقیم: VPN فعال است — بدون پروکسی"
    override val directModeOff = "حالت مستقیم: پروکسی‌ها خاموش"
    override val directDpiSuffix = " · anti-DPI"
    override val connections = "اتصالات"; override val sockets = "سوکت‌ها"; override val speed = "سرعت"
    override val traffic = "ترافیک"; override val latency = "تأخیر"
    override fun pcs(n: Int) = "$n عدد"
    override fun netNow(label: String) = "شبکه: $label"
    override fun tgToConnector(n: Int) = "TG→ $n"
    override fun connectorToProxy(n: Int) = "پروکسی $n"
    override val trafficSec = "ترافیک · ۶۰ ثانیه"; override val trafficMin = "ترافیک · ۶۰ دقیقه"
    override val latencySec = "تأخیر · ۶۰ ثانیه"; override val latencyMin = "تأخیر · ۶۰ دقیقه"
    override val sec60 = "۶۰ ثانیه"; override val min60 = "۶۰ دقیقه"
    override val unitSec = "ث"; override val unitMin = "د"; override val unitHour = "س"; override val dash = "—"
    override val currentProxy = "پروکسی فعلی"; override val noActiveProxy = "پروکسی فعالی نیست (تلگرام متصل نیست)"
    override val host = "میزبان"; override val type = "نوع"; override val secret = "راز"; override val antiDpi = "Anti-DPI"; override val obfEngine = "موتور مبهم‌سازی"
    override fun activeSockets(n: Int) = "سوکت‌های فعال تلگرام: $n"
    override val noConnections = "اتصال فعالی نیست"; override val colHost = "میزبان"; override val colTime = "زمان"
    override val modeWord = "حالت"; override val directViaVpnLine = "درخواست‌های مستقیم به تلگرام (VPN فعال)"
    override val connModeHelp = "حالت‌ها (VPN، Wi-Fi، LTE، Ethernet، White) به شما امکان می‌دهند شدت اسکن را به‌صورت متفاوت تنظیم کنید و رتبه‌بندی/آمار میزبان‌ها را جداگانه نگه دارید. کارت شبکه به‌طور خودکار تشخیص داده می‌شود؛ حالت را می‌توان به‌صورت دستی در تنظیمات تعیین کرد."

    override val scanOff = "اسکن خاموش است"; override val proxiesInBase = "پروکسی‌ها در پایگاه‌داده"
    override val total = "کل"; override val alive = "زنده"; override val dead = "مرده"
    override val tgConnectedTitle = "تلگرام متصل از طریق"; override val successful = "موفق"
    override val socketsHeld = "طول عمر سوکت"; override val over1m = ">۱ دقیقه"; override val over5m = ">۵ دقیقه"; override val over15m = ">۱۵ دقیقه"
    override val scanCountTitle = "تعداد بررسی پروکسی‌ها"; override val checked = "بررسی‌شده"
    override val forAllTime = "کل زمان"; override val perMinute = "در دقیقه"; override val perHour = "در ساعت"
    override val subsCountTitle = "تعداد دانلود اشتراک‌ها"; override val downloaded = "دانلود‌شده"; override val failed = "ناموفق"; override val scanTraffic = "ترافیک اسکن"; override val subTraffic = "ترافیک اشتراک"; override val subTrafficGraph = "ترافیک اشتراک"
    override val checksMtproto = "بررسی‌های MTProto (↑ موفق · ↓ ناموفق)"

    override fun catalogEmpty(mode: String) = "فهرست $mode فعلاً خالی است. یا هیچ میزبانی پیدا نشده، یا برنامه هرگز در این حالت اجرا نشده است. می‌توانید حالت را در تنظیمات تغییر دهید. حالت‌ها وجود دارند تا میزبان‌ها را برای انواع مختلف اتصال اینترنت جداگانه جمع‌آوری کنند."
    override val aliveShort = "✓ زنده"; override val deadShort = "✗ مرده"
    override val statusLabel = "وضعیت"; override val rating = "رتبه"; override val port = "پورت"
    override val rttPing = "RTT (پینگ)"; override val checkedField = "بررسی‌شده"; override val okOfTotal = "بررسی‌های موفق / کل"
    override val tgConnectedField = "تلگرام متصل"; override val tgSessions = "نشست‌های تلگرام"; override val trafficThroughProxy = "ترافیک از طریق پروکسی"
    override val sessionsTotal = "کل نشست‌ها"; override val relayNow = "رله اکنون"; override val tlsDomain = "دامنهٔ TLS (SNI)"
    override val sourceSub = "منبع (اشتراک)"; override val lastError = "آخرین خطا"; override val yes = "بله"; override val no = "خیر"
    override val copyAsLink = "کپی به‌صورت لینک"; override val openInTelegram = "باز کردن میزبان در تلگرام"; override val makeNextRelay = "تعیین به‌عنوان رلهٔ بعدی"
    override val actCopy = "کپی"; override val actOpen = "باز کردن"; override val actRelay = "رله"
    override fun agoFmt(v: String) = "$v پیش"
    override val catalogTopFor = "فهرست/رتبه‌بندی پروکسی برای"
    override val catalogModeHelpTitle = "حالت‌ها و رتبه‌بندی‌ها"
    override val catalogModeHelp = "برنامه میزبان‌های زنده و رتبه‌بندی آن‌ها را به‌صورت جداگانه برای هر حالت شبکه (VPN، Wi-Fi، LTE، Ethernet و White) می‌شمارد. «White» یک حالت دستی جداگانه برای فهرست‌های سفید است؛ حالت خودکار هرگز به آن سوئیچ نمی‌کند. بنابراین یک میزبان می‌تواند در یک حالت زنده و در حالت دیگر مرده باشد."
    override fun catalogInactiveWarn(section: String, active: String) =
        "شما در حال مشاهدهٔ بخش غیرفعال $section هستید — همهٔ آمار اکنون به $active می‌رود، نه اینجا."
    override val manageModeTitle = "مدیریت حالت"
    override val manageResetRating = "بازنشانی رتبه‌بندی"
    override fun manageResetHint(mode: String) = "برای $mode به‌طور خاص می‌توانید رتبه‌بندی و آمار استفادهٔ میزبان‌های زنده را بازنشانی کنید. این هنگامی مفید است که به یک VPN یا LTE کاملاً متفاوت متصل شده‌اید، تا آمار قدیمی مزاحم نشود. یا برای تماشای اینکه اسکن پروکسی با چه سرعتی همه‌چیز را از صفر دوباره بررسی می‌کند."
    override val manageDeleteAll = "حذف میزبان‌ها در"
    override fun manageDeleteHint(mode: String) = "می‌توانید هم رتبه‌بندی و هم خود میزبان‌ها را از $mode پاک کنید. قابلیت «اسکن پروکسی‌ها» دوباره آن‌ها را جمع‌آوری می‌کند. این بازنشانی اشتراک نیست — می‌توانید روی آن بزنید، سپس حدود ۱۵ دقیقه برای اسکن مجدد صبر کنید."
    override fun manageCopyFrom(mode: String) = "کپی همهٔ میزبان‌ها و رتبه‌بندی‌ها در این حالت ($mode) از حالت دیگر:"
    override val live = "زنده"; override val deadW = "مرده"; override val unitMs = "میلی‌ثانیه"
    override val agoMin = "د"; override val agoHour = "س"; override val agoDay = "ر"

    override val connectTelegram = "اتصال تلگرام"; override val readCarefully = "با دقت بخوانید!"
    override val guideIntro = "این برنامه بدون تنظیم کار نمی‌کند. یکی از ۳ گزینهٔ زیر را انتخاب کنید " +
        "و دستورالعمل‌ها را با دقت دنبال کنید."
    override val variant1 = "گزینهٔ #۱ — دکمه‌ها"
    override val variant1Body = "روی \"پروکسی {A}\" بزنید — تلگرام باز می‌شود، افزودن پروکسی را تأیید کنید. به " +
        "این صفحه برگردید و روی \"پروکسی {B}\" بزنید — افزودن دومی را نیز تأیید کنید.\n\nهر " +
        "پروکسی قدیمی دیگری را در تلگرام غیرفعال کنید. باید دقیقاً ۲ پروکسی باقی بماند — با پورت‌های {A} و {B}. " +
        "با هر مجموعهٔ دیگری AutoConnector کار نمی‌کند."
    override val variant2 = "گزینهٔ #۲ — لینک‌ها"
    override val variant2Body = "متن زیر را در Saved Messages (یا هر گفتگویی) در تلگرام کپی کنید — " +
        "یعنی آن را برای خودتان بفرستید. روی اولین لینک در پیامتان بزنید — اولین پروکسی افزوده می‌شود. " +
        "روی لینک دوم بزنید — دومی افزوده می‌شود. سپس همهٔ پروکسی‌های قدیمی را غیرفعال کنید."
    override val variant3 = "گزینهٔ #۳ — به‌صورت دستی"
    override val variant3Body = "یک پروکسی SOCKS5 را به‌صورت دستی اضافه کنید: سرور localhost (127.0.0.1)، پورت {A}. " +
        "سپس یک پروکسی دوم: localhost، پورت {B}. هر پروکسی قدیمی را حذف کنید."
    override val whatNext = "بعد چه؟"
    override val whatNextBody = "در تلگرام، \"سوئیچ خودکار پروکسی\" را فعال کنید — ۵ ثانیه. می‌توانید به " +
        "اتصال تلگرام کمک کنید با اینکه به‌صورت دستی روی پروکسی‌ای (در داخل تلگرام) بزنید که فعال نیست یا با علامت " +
        "\"در دسترس نیست\" مشخص شده — این کار باعث می‌شود تلگرام برای اتصال بیشتر تلاش کند.\n\nمطمئن شوید همهٔ پروکسی‌های قدیمی دیگر " +
        "حذف شده‌اند، به‌جز {A} و {B}. روی " +
        "\"استفاده از پروکسی\" در تلگرام بزنید.\n\nصبر کنید تا برنامه پروکسی‌های کافی پیدا و دانلود کند " +
        "(۵ تا ۱۵ دقیقه). سپس تلگرام خودش به AutoConnector متصل می‌شود، که همچنان " +
        "تلگرام را از طریق بهترین پروکسی‌ها هدایت می‌کند: تأییدشده، زنده و سریع.\n\nاگر دستورالعمل‌ها سخت به‌نظر می‌رسند " +
        "— متأسفیم، نمی‌توانید از برنامه استفاده کنید: تنظیم خودکار همه‌چیز ممکن نیست، و یافتن پروکسی‌های زنده زمان می‌برد.\n\nاگر مدت‌ها پیش برنامه را دانلود کرده‌اید " +
        "و هیچ پروکسی زنده‌ای پیدا نشد — یا برنامه یا فهرست اشتراک را به‌روزرسانی کنید. این برنامه " +
        "پروکسی‌های خودش را اختراع یا ارائه نمی‌کند، فقط در اینترنت در میان ده‌ها " +
        "گروه و صفحه جستجو می‌کند."
    override fun proxyBtn(port: Int) = "پروکسی $port"

    override val setupPortsTitle = "تنظیم پورت‌ها در تلگرام"
    override val setupPortsSub = "نحوهٔ اتصال تلگرام به رله (پورت‌های 55001/55002)"
    override val settings = "تنظیمات"; override val settingsSub = "پورت‌ها، anti-DPI، اسکن، شبکه، باتری"
    override val subscriptions = "اشتراک‌ها"; override val subscriptionsSub = "منابع پروکسی برای اسکن"
    override val statistics = "آمار"; override val statisticsSub = "پایگاه‌دادهٔ پروکسی + ترفندهای anti-DPI"
    override val export = "خروجی"; override val exportSub = "لینک‌های tg:// پروکسی‌های زنده"
    override val about = "درباره"; override val aboutSub = "نسخه، بیلد، دانلود، بازخورد"
    override val hotkeys = "کلیدهای میانبر"
    override val hotkeysSub = "کلیدهای سراسری: کپی / باز کردن یک پروکسی"
    override val hotkeysIntro = "کلیدهای میانبر سراسری حتی وقتی پنجرهٔ برنامه در فوکوس نیست عمل می‌کنند. آن‌ها یک " +
        "لینک پروکسی زندهٔ تصادفی (tg://) را از استخر انتخاب می‌کنند — برای سوئیچ سریع پروکسی‌ها بدون " +
        "باز کردن برنامه مفید است."
    override val hotkeysNote = "در macOS، گرفتن کلیدها ممکن است به مجوز Accessibility نیاز داشته باشد " +
        "(System Settings ← Privacy & Security ← Accessibility)."
    override val hotkeyCopyTitle = "کپی لینک پروکسی"
    override val hotkeyCopyDesc = "یک لینک tg:// زندهٔ تصادفی را در کلیپ‌بورد قرار می‌دهد."
    override val hotkeyEnable = "فعال‌سازی کلیدهای میانبر"; override val hotkeyLetterLabel = "حرف"; override val hotkeySet = "تنظیم"; override val hotkeyReset = "بازنشانی"
    override val hotkeyOpenTitle = "باز کردن پروکسی در تلگرام"
    override val hotkeyOpenDesc = "یک لینک زندهٔ تصادفی را باز می‌کند — تلگرام آن را می‌گیرد و اتصال پروکسی را پیشنهاد می‌دهد."

    override val relayPorts = "پورت‌های رله"
    override val relayPortsHelp = "پورت‌های محلی که رله روی آن‌ها گوش می‌دهد. شما دقیقاً همین‌ها را در " +
        "تلگرام به‌عنوان پروکسی SOCKS5 وارد می‌کنید (127.0.0.1 : پورت). برای اطمینان از دو پورت استفاده می‌شود — تلگرام " +
        "اتصال به هر دو را حفظ می‌کند."
    override val portA = "پورت A"; override val portB = "پورت B"
    override val antiDpiTrick = "ترفند Anti-DPI"
    override val antiDpiHelp = "روشی برای پنهان کردن اتصال تا ISP/DPI آن را تشخیص ندهد و " +
        "مسدود نکند.\n• \"چرخش خودکار\" خودش یک ترفند کارآمد را انتخاب می‌کند.\n• \"بدون ترفند DPI\" — یک " +
        "اتصال ساده.\n• بقیه تکنیک‌های خاص هستند (تقلید مرورگر، تقسیم بسته و غیره)."
    override val onlyFakeTls = "فقط FakeTLS (ee)"
    override val applyDpiTo = "اعمال anti-DPI به"
    override val applyDpiHelp = "ترفند anti-DPI انتخاب‌شده روی چه چیزی اعمال شود:\n• رلهٔ تلگرام — روی " +
        "اتصال زندهٔ تلگرام از طریق رله.\n• بررسی پروکسی‌ها — روی بررسی‌های پس‌زمینهٔ پروکسی " +
        "(آنگاه یک بررسی دقیقاً مثل یک اتصال واقعی رفتار می‌کند و آمار ترفندها دقیق‌تر است).\n" +
        "• هنگام اتصال مستقیم — وقتی پروکسی‌ها خاموش‌اند (یا هنگام فعال بودن VPN رد می‌شوند) و تلگرام " +
        "مستقیماً به سرورهای خود می‌رود: اینجا پروکسی‌ای نیست، پس ترفند به تقسیم " +
        "اولین بستهٔ TCP (دست‌دهی) به چند بخش کوچک خلاصه می‌شود تا DPI نتواند آن را در یک خوانش تطبیق دهد."
    override val toRelay = "رلهٔ تلگرام"; override val toProbes = "بررسی پروکسی‌ها"
    override val toDirect = "هنگام اتصال مستقیم"
    override val vpnSection = "وقتی VPN روشن است"
    override val vpnHelp = "وقتی VPN روی دستگاه فعال است چه کنیم:\n• از طریق پروکسی MTProto — " +
        "تلگرام طبق معمول از پروکسی‌های یافته‌شده عبور می‌کند (روی VPN).\n• مستقیم — " +
        "رله از پروکسی‌ها استفاده نمی‌کند و تلگرام را مستقیماً به سرورهای تلگرام متصل می‌کند: " +
        "VPN از قبل دسترسی را فراهم کرده، لایهٔ اضافی پروکسی لازم نیست (سریع‌تر و پایدارتر). " +
        "بدون VPN پروکسی‌ها طبق معمول استفاده می‌شوند."
    override val linkFormat = "قالب لینک پروکسی"
    override val linkFormatHelp = "نحوهٔ کپی و باز کردن پروکسی‌ها. tg:// تلگرام را مستقیماً باز می‌کند (به نصب Telegram Desktop نیاز دارد). http (t.me) از طریق مرورگر باز می‌شود و پیشنهاد می‌دهد در تلگرام باز شود — مفید است اگر tg:// ثبت نشده باشد."
    override val linkTg = "tg:// (باز کردن مستقیم تلگرام)"; override val linkTgSub = "tg://proxy?… — تلگرام را باز می‌کند"
    override val linkHttp = "http (t.me، از طریق مرورگر)"; override val linkHttpSub = "https://t.me/proxy?… — مرورگر را باز می‌کند"
    override val viaMtproto = "پروکسی از طریق MTProto"; override val viaMtprotoSub = "حتی با VPN، ترافیک از طریق پروکسی‌ها می‌رود"
    override val directly = "اتصال مستقیم"; override val directlySub = "با VPN فعال — دور زدن پروکسی‌ها، مستقیم به تلگرام"
    override val notifications = "اعلان‌ها"
    override val scanCheck = "اسکن و بررسی"
    override val scanCheckHelp = "• اسکن، دقیقه — هر چند وقت یک‌بار فهرست‌های پروکسی از اشتراک‌ها دانلود شود.\n" +
        "• بررسی، دقیقه — هر چند وقت یک‌بار پروکسی‌های پایگاه‌داده از نظر زنده بودن دوباره بررسی شوند.\n• اندازهٔ دسته — " +
        "چند پروکسی در هر اجرا بررسی شود.\n• موازی — چند بررسی به‌طور همزمان اجرا شود (بیشتر = " +
        "سریع‌تر، اما بار شبکه و باتری بالاتر)."
    override val scanMin = "اسکن، دقیقه"; override val checkMin = "بررسی، دقیقه"; override val batchSize = "اندازهٔ دسته"; override val parallel = "موازی"
    override val speedByNet = "شدت اسکن بر اساس شبکه"
    override val speedByNetHelp = "هر چند وقت یک‌بار پروکسی‌ها بسته به شبکهٔ فعلی بررسی شوند. " +
        "\"استاندارد\" = بازهٔ پایه. به راست بکشید برای کمتر (کندتر، ملایم‌تر برای ترافیک/باتری)، " +
        "به چپ برای بیشتر (سریع‌تر، تهاجمی‌تر). مقیاس لگاریتمی، تا ×100 در هر جهت.\n" +
        "• VPN — وقتی یک VPN خارجی فعال است.\n• Wi-Fi — روی یک شبکهٔ Wi-Fi.\n• LTE — روی یک شبکهٔ موبایل."
    override val intensStandard = "استاندارد"
    override val intensSlower = "کندتر"
    override val intensFaster = "سریع‌تر"
    override val maintenance = "بازنشانی داده‌ها"
    override val maintenanceHelp = "• \"بازنشانی فهرست و آمار\" — رتبه‌بندی‌ها، شمارنده‌ها، ترافیک " +
        "و گزارش‌های بررسی را صفر می‌کند، اما میزبان‌های دانلودشده و اشتراک‌ها را نگه می‌دارد (همه‌چیز در " +
        "اسکن بعدی دوباره رتبه‌بندی می‌شود).\n• \"پاک کردن میزبان‌های دانلودشده\" — کل استخر پروکسی را حذف می‌کند اما " +
        "اشتراک‌ها را نگه می‌دارد تا اسکن استخر را دوباره پر کند. اشتراک‌ها به هیچ روشی دست‌نخورده می‌مانند."
    override val backupTitle = "خروجی / ورودی"
    override val backupHelp = "ذخیره یا بازیابی داده‌های برنامه در یک فایل JSON. آنچه را که باید " +
        "گنجانده شود تیک بزنید — هر ترکیبی:\n• تنظیمات — همهٔ پارامترهای برنامه.\n• اشتراک‌ها — فهرست " +
        "منابع (URL + روشن/خاموش).\n• فهرست میزبان‌های زنده — هر پروکسی زنده با رتبه‌بندی‌ها و آمار آن " +
        "به‌ازای هر حالت شبکه.\n\n«خروجی» محل ذخیره را می‌پرسد؛ «ورودی» می‌پرسد کدام فایل باز شود و " +
        "فقط بخش‌های تیک‌خوردهٔ موجود در آن را اعمال می‌کند. ورودی به داده‌های فعلی اضافه می‌کند (بدون پاک کردن)."
    override val backupSettings = "تنظیمات"
    override val backupSubs = "اشتراک‌ها"
    override val backupHosts = "فهرست میزبان‌های زنده (به‌ازای هر حالت)"
    override val exportWord = "خروجی"
    override val importWord = "ورودی"
    override val eraseAllHosts = "پاک کردن همهٔ میزبان‌ها"
    override val factoryReset = "بازنشانی همه‌چیز (مثل اولین اجرا)"
    override val factoryResetConfirm = "برنامه را به‌طور کامل به حالت کارخانه بازنشانی شود؟ همهٔ تنظیمات و کل " +
        "فهرست میزبان‌ها پاک می‌شود، اشتراک‌ها به پیش‌فرض‌ها برمی‌گردند. درست مثل اولین اجرا."
    override val resetCatalog = "بازنشانی فهرست و آمار"
    override val resetCatalogConfirm = "همهٔ رتبه‌بندی‌ها، شمارنده‌ها و گزارش‌های بررسی صفر شود؟ " +
        "میزبان‌های دانلودشده و اشتراک‌ها نگه داشته می‌شوند و در اسکن بعدی دوباره رتبه‌بندی می‌شوند."
    override val clearHosts = "پاک کردن میزبان‌های دانلودشده"
    override val clearHostsConfirm = "کل فهرست میزبان‌های دانلودشده (پروکسی‌ها) حذف شود؟ " +
        "اشتراک‌ها نگه داشته می‌شوند و اسکن استخر را دوباره پر می‌کند."
    override val doReset = "بازنشانی"
    override val doCancel = "لغو"
    override val adaptiveSpeed = "سرعت تطبیقی"
    override val adaptiveHelp = "بررسی‌های زنده بودن در یک بازهٔ پایه اجرا می‌شوند (از \"اسکن و بررسی\"، که در " +
        "ضریب شبکه نیز ضرب می‌شود). \"سرعت تطبیقی\" آن‌ها را بر اساس تعداد پروکسی‌های زندهٔ فعلی " +
        "به‌طور خودکار سریع‌تر یا کندتر می‌کند.\n\n" +
        "• تعداد کم زنده (زیر آستانهٔ \"کم\") ← بازه × \"تسریع\". ضریب کمتر از ۱ = بیشتر " +
        "اوقات: 0.5 — دو برابر بیشتر، 0.25 — ۴ برابر. استخر را سریع‌تر پر می‌کند.\n" +
        "• تعداد زیاد زنده (بالای آستانهٔ \"زیاد\") ← بازه × \"کندسازی\". بالای ۱ = کمتر: 2 — " +
        "نصف اوقات، 4 — یک‌چهارم. باتری و ترافیک را صرفه‌جویی می‌کند.\n" +
        "• بین آستانه‌ها — سرعت پایه (×1).\n\n" +
        "مثال‌ها:\n" +
        "— جمع‌آوری سریع‌تر پروکسی‌ها: \"تسریع\" 0.25 و/یا آستانهٔ \"کم\" 40.\n" +
        "— صرفه‌جویی باتری وقتی به‌اندازهٔ کافی دارید: \"کندسازی\" 8 و/یا آستانهٔ \"زیاد\" 30.\n" +
        "— غیرفعال کردن تطبیق: هر دو ضریب را روی 1 بگذارید.\n\n" +
        "پیش‌فرض‌ها: کم 20، تسریع 0.5، زیاد 50، کندسازی 4."
    override val threshMany = "آستانهٔ \"زیاد\""; override val threshFew = "آستانهٔ \"کم\""; override val mulFast = "تسریع ×"; override val mulLazy = "کندسازی ×"
    override val subIntensityTitle = "شدت اشتراک"
    override val subIntensityHint = "مکث بین دانلودهای اشتراک: چند دقیقه پیش از دانلود مجدد فهرست‌های پروکسی (جداگانه به‌ازای هر حالت شبکه)."
    override val baseScanTitle = "سرعت پایهٔ اسکن"
    override val baseScanHelp = "سرعت مرجع بررسی زنده بودن. «سرعت تطبیقی» و ضریب‌های «سرعت بر " +
        "اساس حالت» نسبت به آن محاسبه می‌شوند.\n\n" +
        "• هر چند وقت اجرا شود، دقیقه — بازه بین گذرهای بررسی.\n" +
        "• دسته به‌ازای هر رشته، میزبان — هر رشته در هر گذر چند میزبان را بررسی می‌کند.\n" +
        "• رشته‌ها — چند بررسی همزمان اجرا می‌شود. یک گذر «دسته × رشته‌ها» میزبان را بررسی می‌کند.\n" +
        "• یک میزبان را بیش از هر N دقیقه دوباره اسکن نکن — ضد سیلاب: یک میزبان که اخیراً بررسی شده " +
        "در این گذر رد می‌شود.\n\n" +
        "رشته‌های بیشتر و دستهٔ بزرگ‌تر = رشد سریع‌تر استخر، اما بار سنگین‌تر روی شبکه و باتری."
    override val baseScanPeriod = "هر چند وقت اجرا شود، دقیقه"
    override val baseScanBatch = "دسته به‌ازای هر رشته، میزبان"; override val baseScanThreads = "تعداد رشته‌ها"
    override val adaptiveDesc = "اگر پروکسی‌های زنده کمتر از «کم» یا بیشتر از «زیاد» باشند، یک ضریب اضافی اعمال کن."
    override val fewWord = "کم"; override val manyWord = "زیاد"
    override fun fasterX(x: String) = "$x× سریع‌تر"
    override fun slowerX(x: String) = "$x× کندتر"
    override fun ifAliveLt(n: Int) = "اگر پروکسی‌های زنده < $n، آنگاه:"
    override fun ifAliveGt(n: Int) = "اگر پروکسی‌های زنده > $n، آنگاه:"
    override val disabledWord = "خاموش"
    override val speedByModeTitle = "سرعت بر اساس حالت"
    override val speedByModeHelp = "یک ضریب سرعت اسکن برای هر حالت شبکه، روی سرعت " +
        "پایه. «استاندارد» (×1) = بازهٔ پایه. راست — کمتر (کندتر، ملایم‌تر برای ترافیک/" +
        "باتری)، چپ — بیشتر (سریع‌تر، تهاجمی‌تر). مقیاس لگاریتمی، تا ×100 در هر " +
        "جهت.\n\n" +
        "زیر هر اسلایدر پارامترهای گذر حاصل با سرعت تطبیقی اعمال‌شده آمده — " +
        "جداگانه برای «تعداد کم زنده» (× «تسریع») و «تعداد زیاد زنده» (× «کندسازی»).\n\n" +
        "حالت‌ها:\n• VPN — یک VPN خارجی فعال است.\n• LTE — شبکهٔ موبایل.\n• Wi-Fi — شبکهٔ Wi-Fi.\n" +
        "• Ethernet — اتصال سیمی.\n• White — حالت پروکسی «سفید» دستی."
    override val aliveLt = "زنده <"; override val aliveGt = "زنده >"
    override val periodWord = "دوره"; override val nonstopWord = "بی‌وقفه"
    override val batchWord = "دسته"; override val threadsWord = "رشته‌ها"; override val scanModeOff = "اسکن خاموش"
    override val netBattery = "شبکه و باتری"
    override val netBatteryHelp = "• فقط Wi-Fi — روی شبکه‌های موبایل اسکن نکن (مصرف داده را صرفه‌جویی می‌کند).\n• فقط " +
        "هنگام شارژ — فقط وقتی گوشی در حال شارژ است کار کن.\n• رد کردن در باتری کم — اسکن را وقتی " +
        "باتری کم است متوقف کن."
    override val onlyWifi = "فقط Wi-Fi"; override val onlyCharging = "فقط هنگام شارژ"; override val skipLowBattery = "رد کردن در باتری کم"
    override val autosaved = "تنظیمات به‌طور خودکار ذخیره می‌شوند."
    override val dpiAutoLabel = "چرخش خودکار ترفندهای DPI"; override val dpiNoneLabel = "بدون ترفند DPI (ساده)"
    override val experimental = "آزمایشی"
    override val experimentalHelp = "موتورهای پروکسی جایگزین برای upstream MTProto به‌علاوهٔ یک گزارش تشخیصی. " +
        "مسیر مرجع (کارآمد) هنگامی که روی «خاموش» تنظیم شود تغییر نمی‌کند. فقط نحوهٔ نوشتن جریان رمزگذاری‌شده در " +
        "سوکت TCP upstream تغییر می‌کند (اندازهٔ بخش‌ها، زمان‌بندی، مرزهای رکورد TLS) — خود جریان بایت‌به‌بایت یکسان می‌ماند. " +
        "فقط روی رلهٔ زندهٔ پروکسی اعمال می‌شود (نه بررسی‌ها، نه مسیر مستقیم)."
    override val expEngineTitle = "موتور پروکسی (مبهم‌سازی سوکت)"
    override val expConnectTitle = "موتور اتصال (انتخاب upstream)"
    override val raceWidthTitle = "اتصالات موازی"
    override val connectionSection = "اتصال و دور زدن مسدودیت"
    override val connectionSectionHelp = "موتور اتصال، upstreamهای موازی، موتور پروکسی و ترفندهای anti-DPI — همه در یک بخش."
    override val netLogSection = "گزارش تبادل شبکه"
    override val expEngineWarn = "⚠ حالت آزمایشی. اگر اتصال بدتر شد، به «خاموش (مسیر مرجع)» برگردید."
    override val netLog = "فعال‌سازی گزارش تبادل شبکه"
    override val netLogSub = "چه‌کسی-به-چه‌کسی-چه‌زمانی و اندازهٔ بسته‌ها را در یک فایل می‌نویسد (بدون دادهٔ payload) — " +
        "برای مقایسهٔ الگوی تبادل با و بدون VPN."
    override val openLogFolder = "باز کردن پوشهٔ گزارش"; override val copyPath = "کپی مسیر"
    override val helpShow = "راهنما"; override val helpHide = "پنهان کردن راهنما"
    override val quickSwitchIntro = "اینجا می‌توانید یک ترفند دور زدن مسدودیت انتخاب کنید. اگر تلگرام خطای " +
        "«پروکسی‌ای که استفاده می‌کنید درست پیکربندی نشده و غیرفعال خواهد شد. لطفاً یکی دیگر " +
        "پیدا کنید» را نشان داد، آزمایش کنید کدام نوع مبهم‌سازی ترافیک کار می‌کند تا تلگرام آن را نشان ندهد. با " +
        "حالت‌های *split شروع کنید. حالت‌های *coalesce هم کار می‌کنند، اما تصاویر/ویدئوها با آن‌ها در تلگرام بد بارگذاری می‌شوند."
    override val quickSwitchTitle ="دور زدن مسدودیت"; override val quickSwitchSub = "شکل‌دهی، اتصال، anti-DPI"

    override val sourceUrl = "URL منبع"
    override fun sourceAlive(alive: Int, total: Int) = "زنده $alive/$total"
    override val open = "باز کردن"; override val active = "فعال"; override val inactive = "غیرفعال"
    override val lastDownloaded = "دانلود‌شده"; override val notDownloaded = "هنوز دانلود نشده"
    override fun sourceCounts(dead: Int, total: Int) =
        " زنده، $dead مرده، $total کل"

    override val proxyBase = "پایگاه‌دادهٔ پروکسی"
    override val totalInBase = "کل در پایگاه‌داده"; override val aliveNow = "زنده اکنون"; override val deadStat = "مرده"
    override val aliveIn15 = "زنده در ۱۵ دقیقه"; override val checksAllTime = "بررسی‌های کل زمان"
    override val antiDpiTricks = "ترفندهای Anti-DPI"; override val noStatsYet = "هنوز داده‌ای نیست — ترفندها با انجام بررسی‌ها/اتصالات انباشته می‌شوند"
    override val attempts = "تلاش‌ها"; override val handshake = "دست‌دهی"; override val score = "امتیاز"
    override val tgConnect = "اتصال TG"; override val socketsOver1m = "سوکت‌های >۱دقیقه"
    override val over10kb = "سوکت‌های >10KB"; override val over100kb = ">100KB"; override val workTime = "زمان کار"
    override val statsLegend = "دست‌دهی — دست‌دهی‌های موفق (٪ از تلاش‌ها) · امتیاز — مقدار · " +
        "\"زمان کار\" — مجموع روی سوکت‌های ≥5KB و طولانی‌تر از ۱ دقیقه."
    override val resetStats = "بازنشانی آمار ترفندها"

    override fun aliveLinks(n: Int) = "لینک‌های زنده: $n"
    override val copyAll = "کپی همه"
    override val openRandom = "باز کردن تصادفی"; override val copyRandom = "کپی تصادفی"; override val allShort = "همه"
    override val copyTop = "کپی برترین‌ها"; override val randomHost = "میزبان تصادفی"
    override val exportToFile = "خروجی به فایل"; override val exportSaved = "در فایل ذخیره شد:"
    override val dlNow = "اکنون دانلود کن"
    override fun downloadingFmt(sec: Long) = "در حال دانلود… ${sec}ث"
    override val cancel = "لغو"
    override val deleteConfirmTitle = "اشتراک حذف شود؟"
    override val subscriptionsAddHint = "اشتراک‌ها یا لینک‌های پروکسی اضافه کنید ←"
    override val addSourcesTitle = "افزودن"
    override val addSubsLabel = "اشتراک‌ها (هر URL در یک خط)"
    override val addSubsHelp = "هر خط با یک URL معتبر به اشتراک مستقل خود تبدیل می‌شود و به‌صورت دوره‌ای واکشی می‌شود."
    override val addProxiesLabel = "لینک‌های پروکسی آماده (فهرست ثابت)"
    override val addProxiesHelp = "دسته‌ای از لینک‌ها به پروکسی‌های مشخص را بچسبانید (tg://proxy، https://t.me/proxy، …). این اشتراک نیست — فهرست هرگز دانلود نمی‌شود، پروکسی‌ها فقط به فهرست افزوده می‌شوند."
    override val addButton = "افزودن"
    override fun addedFmt(subs: Int, proxies: Int) = "افزوده شد: $subs اشتراک، $proxies پروکسی"
    override val perSecond = "در ثانیه"
    override val graphSpeed = "سرعت"
    override val graphVolume = "حجم"
    override val graphLatency = "پینگ"
    override val graphConnects = "اتصالات"
    override val scanNow = "اکنون اسکن کن"; override val scanOnShort = "اسکن روشن"
    override val scanRunning = "اسکن در حال اجرا"; override val scanIdle = "اسکن بی‌کار"; override val scanOffState = "اسکن خاموش"; override val scanBatchPerThread = "دسته/رشته"; override val scanPassHosts = "میزبان‌ها در گذر"; override val minRescanLabel = "یک میزبان را بیش از هر N دقیقه دوباره اسکن نکن"
    override val scanPlanTitle = "برنامه"; override val scanNowTitle = "اکنون"; override val currentScheduleTitle = "زمان‌بندی فعلی"
    override val scheduleWord = "زمان‌بندی"; override val unitPcsPerSec = "عدد/ث"
    override val scanNowThreadsLabel = "رشته‌های در حال اجرا اکنون"; override val scanNowPerThreadLabel = "بررسی به‌ازای هر رشته (برنامه)"; override val scanNowElapsedLabel = "زمان اجرا"
    override val scanOkGraph = "اسکن‌های موفق"; override val scanFailGraph = "اسکن‌های ناموفق"; override val scanTrafficGraph = "ترافیک اسکن"; override val scanAliveGraph = "کل پروکسی‌های زنده"; override val scanPingGraph = "پینگ"; override val threadsGraph = "رشته‌ها"
    override val scanEvery = "هر"; override val scanNextRun = "اجرای بعدی"
    override val scanThreads = "رشته‌ها"; override val scanBatch = "دسته"
    override val scanElapsed = "در حال اجرا"; override val scanIdleNow = "—"
    override val effForFew = "هنگام کم"; override val effForMany = "هنگام زیاد"
    override val effCheck = "بررسی"; override val effBatch = "دسته"; override val effPar = "موازی"
    override val effContinuous = "پیوسته"; override val secShort = "ث"; override val minShort = "دقیقه"

    override val appTagline = "رله‌کنندهٔ خودکار چندسکویی: پروکسی‌های MTProto را که تلگرام از طریق آن‌ها " +
        "کار می‌کند پیدا، بررسی و اجرا می‌کند."
    override val version = "نسخه"; override val buildDate = "تاریخ بیلد"; override val platform = "پلتفرم"
    override val downloadSources = "دانلود و منابع"; override val openOnGithub = "باز کردن در GitHub"
    override val feedbackBugs = "بازخورد و گزارش اشکال"; override val writeTelegram = "نوشتن در تلگرام"

    override val language = "زبان"; override val langAuto = "خودکار (سیستم)"; override val langRu = "Русский"; override val langEn = "English"
    override val langFa = "فارسی"; override val langZh = "简体中文"; override val langAr = "العربية"; override val langUr = "اردو"
    override val langTr = "Türkçe"; override val langId = "Bahasa Indonesia"; override val langHi = "हिन्दी"; override val langBn = "বাংলা"; override val langMy = "မြန်မာ"
    override val langWord = "زبان"

    override val scanModeTitle = "حالت شبکه"; override val scanModeAuto = "خودکار"; override val scanModeManualLabel = "دستی"
    override val activeModeLabel = "حالت فعال"; override val formingListLabel = "در حال ساخت فهرست"; override val catalogModeTabs = "حالت"
    override val resetModeRatings = "بازنشانی رتبه‌بندی میزبان‌ها"; override val forgetModeHosts = "فراموش کردن میزبان‌های حالت"
    override val exportModeTitle = "خروجی بر اساس حالت"; override val modePickerTitle = "حالت"
    override val modeHelp = "هر حالت شبکه رتبه‌بندی پروکسی خود و شدت اسکن + دانلود اشتراک خود را نگه می‌دارد. «خودکار» حالت را از شبکهٔ فعال انتخاب می‌کند. «دستی» به شما امکان می‌دهد هر حالتی را خودتان انتخاب کنید (از جمله White، که خودکار هرگز انتخاب نمی‌کند)."
    override val autoSelect = "انتخاب خودکار"; override val manualSelect = "انتخاب دستی"
    override val connStatsTitle = "اتصالات اکنون"; override val connOnPort = "اتصالات روی پورت"; override val outgoingConns = "اتصالات خروجی"
    override val modeChoice = "انتخاب حالت"; override val autoChoice = "انتخاب خودکار"; override val manualChoice = "ثابت دستی"
    override val directOnVpn = "اتصال مستقیم به TG روی VPN"; override val onWord = "روشن"; override val offWord = "خاموش"
    override val directStateActive = "فعال"; override val directStateOff = "در تنظیمات خاموش"; override val directStateIdle = "در تنظیمات روشن، اما فعال نیست"
    override val wpHintTitle = "White چیست؟"
    override val wpHint = "White — WhitePages: یک پروفایل شبکهٔ دستی. فقط با دست فعال می‌شود (انتخاب خودکار هرگز آن را برنمی‌گزیند). " +
        "رتبه‌بندی میزبان‌های خود را نگه می‌دارد، اشتراک‌ها را دانلود می‌کند و مستقل از VPN/Wi-Fi/LTE اسکن می‌کند."

    // host detail history + selection sliders
    override val recentAttempts = "آخرین اتصال‌ها و بررسی‌ها"
    override val kindCheck = "بررسی"
    override val kindTg = "تلگرام"
    override val histWho = "چه‌کسی"
    override val histWhen = "چه‌زمانی"
    override val histReq = "درخواست"
    override val histSess = "نشست"
    override val histScan = "اسکن"
    override val testNow = "اکنون تست کن"
    override val testShort = "تست"
    override val testResult = "نتیجهٔ تست"
    override val testStop = "توقف"
    override val testingNow = "در حال تست…"
    override val prewarmTitle = "پیش‌گرم کردن سوکت‌ها (آزمایشی)"
    override val prewarmHelp = "چند سوکت پروکسی upstream را از پیش متصل نگه می‌دارد تا یک اتصال جدید " +
        "تلگرام بتواند مرحلهٔ اتصال/دست‌دهی را رد کند. آزمایشی: در پس‌زمینه مدام دوباره وصل می‌شود، پس " +
        "کمی ترافیک و CPU مصرف می‌کند. هیچ ترافیک ساختگی فرستاده نمی‌شود (که نشست واقعی را خراب می‌کرد) — " +
        "سوکت‌ها فقط چرخش می‌یابند. بیشترین کاربرد را با پروکسی‌های FakeTLS دارد."
    override val prewarmEnable = "فعال‌سازی پیش‌گرم"
    override val prewarmModeDeferred = "تعویقی (فقط TLS)"
    override val prewarmModeDeferredSub = "TCP + FakeTLS را نگه می‌دارد؛ راه‌اندازی در زمان تحویل تکمیل می‌شود. هیچ DC تثبیت نمی‌شود — واقع‌گرایانه‌ترین."
    override val prewarmModeFull = "دست‌دهی کامل"
    override val prewarmModeFullSub = "سوکت‌های کاملاً متصل را در میان DCها نگه می‌دارد؛ فقط هنگام تطابق DC/tag دوباره استفاده می‌شود. عمر کوتاه‌تری دارند."
    override val prewarmPoolLabel = "سوکت‌های آماده‌به‌کار"
    override val prewarmHoldLabel = "نگه‌داری هر کدام، ث"
    override val prewarmNote = "فقط چرخش (بدون keepalive در سطح برنامه). یک سوکت بسته به پروکسی/DC از چند ثانیه تا حدود یک دقیقه دوام می‌آورد."
    override val prewarmStatus = "پیش‌گرم"
    override fun prewarmStatusVal(ready: Int, holdSecs: Int) = "${ready} آماده · نگه‌داری ${holdSecs}ث"
    override val prewarmStar = "نارنجی پررنگ = سوکتی که گرم از استخر پیش‌گرم تحویل داده شده (اتصال/دست‌دهی رد شد)"
    override fun prewarmTableTitle(holdSecs: Int) = "سوکت‌های پیش‌گرم (نگه‌داری ${holdSecs}ث)"
    override val prewarmTableHelp = "«سوکت‌های پیش‌گرم» چند سوکت پروکسی را از پیش باز می‌کند تا یک اتصال جدید " +
        "تلگرام بتواند مرحلهٔ اتصال/دست‌دهی را رد کند. این جدول سوکت‌های در حال گرم‌شدن را فهرست می‌کند: هر " +
        "کدام چند وقت زنده بوده، آیا تلگرام از آن استفاده می‌کند، و ترافیک. روشن/خاموش کردن و پیکربندی آن " +
        "(حالت، تعداد سوکت‌ها، زمان نگه‌داری) در «بیشتر ← تنظیمات ← „سوکت‌های پیش‌گرم (آزمایشی)“» است."
    override val prewarmNoneWarming = "هنوز سوکتی در حال گرم‌شدن نیست"
    override val prewarmColAge = "عمر"
    override val prewarmColUse = "در TG؟"
    override val prewarmInUse = "در TG"
    override val prewarmNew = "جدید"
    override val lanShareTitle = "اشتراک‌گذاری در شبکهٔ محلی (پورتال وب)"
    override val lanShareDesc = "به دستگاه‌های دیگر روی این Wi-Fi اجازه دهید از این AutoConnector به‌عنوان پروکسی استفاده کنند؛ مرورگری که آدرس زیر را باز کند صفحه‌ای از بهترین پروکسی‌ها دریافت می‌کند."
    override val lanShareUrlsLabel = "همسایه‌های شبکه از این آدرس متصل می‌شوند:"
    override val lanShareNoIp = "آدرس شبکهٔ محلی وجود ندارد — به Wi-Fi متصل شوید"
    override val lanFirewallTitle = "اجازه در شبکهٔ محلی"
    override val lanFirewallBody = "فعال‌سازی این، پورت‌های رله را به شبکهٔ محلی شما باز می‌کند. اکنون فایروال Windows (یا فایروال دیگر) ممکن است بپرسد که آیا AutoConnector مجاز است — گزینهٔ Allow / Yes را انتخاب کنید. اگر رد کنید، ترافیک همسایه‌ها به AutoConnector مسدود می‌شود و صفحه/پروکسی در دسترس نخواهد بود."
    override val lanFirewallConfirm = "فعال‌سازی"
    override val lanInfoTitle = "این برای چیست؟"
    override val lanInfoBody = "AutoConnector را روی یک کامپیوتر یا تلفن در Wi-Fi خود اجرا کنید، و هر دستگاه دیگری در همان شبکه — از جمله iPhone، که این برنامه مستقیماً از آن پشتیبانی نمی‌کند — می‌تواند فقط آدرس را در مرورگر باز کند و از آن استفاده کند: صفحه‌ای از بهترین پروکسی‌ها برای افزودن به تلگرامشان، یا خودِ این دستگاه به‌عنوان پروکسی SOCKS. یک دستگاه پروکسی‌ها را پیدا و نگه می‌دارد؛ بقیه آن را روی شبکهٔ محلی قرض می‌گیرند."
    override val volTriggerTitle = "تریگر دکمه‌های صدا"
    override val volTriggerSub = "تعویض پروکسی با یک الگوی سریع کلیدهای صدا"
    override val volEnableLabel = "پایش دکمه‌های صدا"
    override val volHelpTitle = "این چیست؟"
    override val volHelpBody = "در اندروید کلیدهای میانبر سراسری صفحه‌کلید وجود ندارد، پس این قابلیت به‌جای آن از دکمه‌های صدا استفاده می‌کند. وقتی فعال است، AutoConnector در پس‌زمینه به‌دنبال یک الگوی سریع فشردن صدا-بالا/پایین می‌گردد (مثلاً بالا-بالا-پایین-پایین). هنگام تشخیص آن، یک لینک tg:// از یک پروکسی خوب و زندهٔ تصادفی را باز می‌کند تا تلگرام آن را بگیرد و سوئیچ کند — راهی سریع و نامحسوس برای چرخش پروکسی بدون باز کردن برنامه. صدا به‌طور عادی کار می‌کند (فشارها بلعیده نمی‌شوند). این به دسترسی Accessibility نیاز دارد (برای خواندن کلیدهای صدا در پس‌زمینه و باز کردن لینک)؛ تا زمانی که کلید را فعال نکنید چیزی درخواست نمی‌شود. حداکثر زمان بین فشارها را در پایین تنظیم کنید؛ الگوهای شناخته‌شده در پایین فهرست شده‌اند."
    override val volGrantTitle = "فعال‌سازی Accessibility (مهم)"
    override val volGrantBody = "اندروید (به‌ویژه ۱۳ به بالا) Accessibility را برای برنامه‌هایی که از Google Play نصب نشده‌اند مسدود می‌کند — به همین دلیل AutoConnector خاکستری شده و می‌گوید \"Restricted setting\" / \"access not allowed\".\n\nنحوهٔ رفع مسدودیت:\n۱. \"App info\" را باز کنید (دکمهٔ پایین، یا Settings → Apps → AutoConnector for Telegram).\n۲. روی منوی ⋮ (بالا-راست) بزنید → \"Allow restricted settings\" → تأیید کنید.\n۳. برگردید: Settings → Accessibility → AutoConnector for Telegram → آن را روشن کنید.\n\nاگر \"Allow restricted settings\" را نمی‌بینید، ابتدا یک‌بار آن را در Accessibility روشن کنید (پیام مسدودیت را می‌گیرید)، سپس گام ۲ ظاهر می‌شود.\n\nروی Xiaomi/MIUI، Samsung و غیره مسیر ممکن است کمی متفاوت باشد — همان ⋮ را در \"App info\" پیدا کنید. روی Android 12 و قدیمی‌تر معمولاً محدودیتی نیست — کافی است آن را در Accessibility فعال کنید.\n\nکلیدهای صدا فقط مشاهده می‌شوند، هرگز مسدود نمی‌شوند."
    override val volOpenAppInfo = "باز کردن App info"
    override val volAccessOn = "Accessibility: اعطا شد"
    override val volAccessOff = "Accessibility: اعطا نشده"
    override val volOpenAccess = "باز کردن تنظیمات Accessibility"
    override val volGapLabel = "حداکثر میلی‌ثانیه بین فشارها"
    override val volPatternsTitle = "الگوهای شناخته‌شده"
    override val volPatternPick = "الگو"
    override val volPatternsLegend = "↑ = صدا بالا، ↓ = صدا پایین"
    override val volNoRights = "برنامه هنوز مجوز مدیریت دکمه‌های صدا را ندارد — با گام‌های پایین این صفحه دسترسی بدهید."
    override val volGrantShort = "هنوز دسترسی Accessibility نیست. گام‌های مفصل پایین این صفحه را بخوانید، سپس روی \"بررسی\" بزنید."
    override val volCheck = "بررسی"
    override val volCheckOk = "✓ انجام شد — دسترسی اعطا شد، تریگر کار می‌کند."
    override val volCheckFail = "✗ هنوز دسترسی نیست — گام‌های بالا را کامل کنید."
    override val volPatternsList = "↑↑↓↓ · ↓↓↑↑ · ↑↓↑↓ · ↓↑↓↑ · ↑↑↑↑ · ↓↓↓↓ · ↑↓↓↑ · ↓↑↑↓ · ↑↑↑↓↓↓ · ↓↓↓↑↑↑   (↑ = صدا بالا، ↓ = صدا پایین)"
    override val histLegend = "ستون‌ها — چه‌کسی: ✓/✗ TG = اتصال واقعی تلگرام، اسکن = بررسی پس‌زمینه. چه‌زمانی: چند وقت پیش. TCP/TLS/درخواست: تأخیر دست‌دهی و اولین درخواست، میلی‌ثانیه. نشست: نشست رله چقدر دوام آورد. ↓/↑: بایت دریافتی / ارسالی از طریق میزبان."
    override val tgOkTotalHint = "اتصالات تلگرام / موفق / کل بررسی‌ها"
    override val breadthTitle = "گستردگی انتخاب میزبان"
    override val breadthHelp = "چپ = به بهترین میزبان‌های اثبات‌شده پایبند بمان؛ راست = تا حد ممکن گسترده در میان همهٔ میزبان‌های زنده امتحان کن. وقتی تلگرام مدام پورت‌های رله را عوض می‌کند، برنامه جستجو را به‌طور خودکار گسترده می‌کند."
    override val breadthNarrow = "اثبات‌شده"
    override val breadthWide = "گسترده‌ترین"
    override val connTimeoutTitle = "مهلت اتصال به‌ازای هر میزبان"
    override val connTimeoutHelp = "چه مدت برای یک upstream (TCP + TLS + اولین پاسخ MTProto) صبر شود پیش از رفتن به پروکسی بعدی."
    // backup-page strings
    override val backupExportTitle = "خروجی داده‌ها"
    override val backupImportTitle = "ورودی داده‌ها"
    override val backupSelectExport = "چه چیزی خروجی گرفته شود:"
    override val backupSelectImport = "چه چیزی وارد شود:"
    override val backupCopyBtn = "کپی"
    override val backupSaveFile = "ذخیره در فایل"
    override val backupLoadFile = "بارگذاری از فایل"
    override val backupDoImport = "وارد کردن"
    override val backupPasteLabel = "JSON پشتیبان را اینجا بچسبانید"
    override val backupJsonLabel = "JSON پشتیبان"
    override val backupAndroidFileNote = "فایل‌ها اینجا در دسترس نیستند — از کپی / چسباندن استفاده کنید."
    override val factoryResetDone = "همه‌چیز بازنشانی شد. لطفاً برنامه را ببندید و دوباره باز کنید."
}
