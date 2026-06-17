package io.autoconnector.i18n

object Ar : Strings {
    override val tabConnector = "الموصِّل"; override val tabScan = "الفحص"
    override val tabCatalog = "الفهرس"; override val tabLogs = "السجلات"; override val tabMore = "المزيد"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "الاشتراكات"; override val logTabScan = "الفحص"
    override val logGeneral = "عام"; override val logEmpty = "فارغ حتى الآن"
    override val logSessions = "الجلسات"; override val logErrorsOnly = "الأخطاء فقط"; override val logNoErrors = "لا توجد جلسات فاشلة"
    override fun logSession(id: String, port: String) = "#$id · :$port"
    override val back = "رجوع"; override val copy = "نسخ"; override val gotIt = "فهمت"
    override val later = "لاحقًا"; override val details = "التفاصيل"; override val whatIsThis = "ما هذا؟"
    override val delete = "حذف"

    override val connector = "الموصِّل"; override val scan = "الفحص"
    override val notConfigured = "لم يُضبَط! أصلِح ←"; override val howToSetup = "كيفية الإعداد"
    override val notifOff = "الإشعارات متوقفة! أصلِح ←"; override val enable = "تفعيل"
    override fun fewProxies(n: Int) = "البروكسيات الحية $n، جارٍ البحث، انتظر ~15 دقيقة…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "البروكسيات الحية: $alive  (15 دقيقة: $within) · الإجمالي: $total"
    override val notifWhyTitle = "لماذا الإشعارات؟"
    override val notifWhyBody = "أيقونة الإشعار الدائمة تعني خدمة أمامية في Android. " +
        "بدونها يُفرِّغ النظام التطبيق من الذاكرة فيتوقف عن البحث عن البروكسيات و" +
        "عن الإبقاء على الاتصال في الخلفية. لذلك تكون الإشعارات مطلوبة لكي " +
        "يعمل AutoConnector."
    override val notifEnableTitle = "تفعيل الإشعارات"
    override val notifEnableBody = "بدون أيقونة الإشعار، يعتبر Android التطبيق غير نشط و" +
        "يفرِّغه من الذاكرة. عندها يتوقف AutoConnector عن البحث عن البروكسيات وعن الإبقاء على " +
        "الاتصال في الخلفية — ويفقد Telegram رابطه.\n\nانقر \"تفعيل\" واسمح " +
        "بالإشعارات لـ AutoConnector."
    override val notifPlea = "فعِّل الإشعارات! بدونها لا يستطيع التطبيق العمل في الخلفية — " +
        "سيفرِّغه Android وسيتوقف البحث عن البروكسي والاتصال."

    override val statusConnected = "Telegram متصل"; override val statusConnecting = "جارٍ الاتصال…"
    override val statusOffline = "Telegram غير متصل"; override val statusIdle = "Telegram خامل"
    override val nobodyConnected = "لم يتصل أحد بالموصِّل. "; override val howToSetupArrow = "كيفية الإعداد ←"
    override val directModeViaVpn = "الوضع المباشر: VPN نشط — بلا بروكسي"
    override val directModeOff = "الوضع المباشر: البروكسيات متوقفة"
    override val directDpiSuffix = " · مضاد DPI"
    override val connections = "الاتصالات"; override val sockets = "المقابس"; override val speed = "السرعة"
    override val traffic = "البيانات"; override val latency = "زمن الاستجابة"
    override fun pcs(n: Int) = "$n قطعة"
    override fun netNow(label: String) = "الشبكة: $label"
    override fun tgToConnector(n: Int) = "TG→ $n"
    override fun connectorToProxy(n: Int) = "بروكسي $n"
    override val trafficSec = "البيانات · 60 ثانية"; override val trafficMin = "البيانات · 60 دقيقة"
    override val latencySec = "زمن الاستجابة · 60 ثانية"; override val latencyMin = "زمن الاستجابة · 60 دقيقة"
    override val sec60 = "60 ثانية"; override val min60 = "60 دقيقة"
    override val unitSec = "ث"; override val unitMin = "د"; override val unitHour = "س"; override val dash = "—"
    override val currentProxy = "البروكسي الحالي"; override val noActiveProxy = "لا يوجد بروكسي نشط (Telegram غير متصل)"
    override val host = "المضيف"; override val type = "النوع"; override val secret = "السر"; override val antiDpi = "مضاد DPI"; override val obfEngine = "محرك التمويه"
    override fun activeSockets(n: Int) = "مقابس Telegram النشطة: $n"
    override val noConnections = "لا توجد اتصالات نشطة"; override val colHost = "المضيف"; override val colTime = "الوقت"
    override val modeWord = "الوضع"; override val directViaVpnLine = "طلبات مباشرة إلى Telegram (VPN نشط)"
    override val connModeHelp = "تتيح لك الأوضاع (VPN، Wi-Fi، LTE، Ethernet، أبيض) ضبط كثافة الفحص بشكل مختلف والاحتفاظ بتقييمات/إحصاءات مضيفين منفصلة. تُكتشف بطاقة الشبكة تلقائيًا؛ ويمكن ضبط الوضع يدويًا في الإعدادات."

    override val scanOff = "الفحص متوقف"; override val proxiesInBase = "البروكسيات في قاعدة البيانات"
    override val total = "الإجمالي"; override val alive = "حية"; override val dead = "ميتة"
    override val tgConnectedTitle = "Telegram متصل عبر"; override val successful = "ناجح"
    override val socketsHeld = "عمر المقبس"; override val over1m = ">1 دقيقة"; override val over5m = ">5 دقائق"; override val over15m = ">15 دقيقة"
    override val scanCountTitle = "عدد فحوص البروكسي"; override val checked = "تم الفحص"
    override val forAllTime = "كل الوقت"; override val perMinute = "في الدقيقة"; override val perHour = "في الساعة"
    override val subsCountTitle = "عدد تنزيلات الاشتراكات"; override val downloaded = "تم التنزيل"; override val failed = "فشل"; override val scanTraffic = "بيانات الفحص"; override val subTraffic = "بيانات الاشتراك"; override val subTrafficGraph = "بيانات الاشتراك"
    override val checksMtproto = "فحوص MTProto (↑ نجاح · ↓ فشل)"

    override fun catalogEmpty(mode: String) = "الفهرس $mode فارغ حتى الآن. إما أنه لم يُعثر على أي مضيف، أو أن التطبيق لم يعمل قط في هذا الوضع. يمكنك تبديل الوضع في الإعدادات. توجد الأوضاع لجمع المضيفين بشكل منفصل لأنواع مختلفة من اتصال الإنترنت."
    override val aliveShort = "✓ حية"; override val deadShort = "✗ ميتة"
    override val statusLabel = "الحالة"; override val rating = "التقييم"; override val port = "المنفذ"
    override val rttPing = "RTT (بنغ)"; override val checkedField = "تم الفحص"; override val okOfTotal = "الفحوص الناجحة / الإجمالية"
    override val tgConnectedField = "Telegram متصل"; override val tgSessions = "جلسات Telegram"; override val trafficThroughProxy = "البيانات عبر البروكسي"
    override val sessionsTotal = "إجمالي الجلسات"; override val relayNow = "الترحيل الآن"; override val tlsDomain = "نطاق TLS (SNI)"
    override val sourceSub = "المصدر (الاشتراك)"; override val lastError = "آخر خطأ"; override val yes = "نعم"; override val no = "لا"
    override val copyAsLink = "نسخ كرابط"; override val openInTelegram = "فتح المضيف في Telegram"; override val makeNextRelay = "اجعله المرحِّل التالي"
    override val actCopy = "نسخ"; override val actOpen = "فتح"; override val actRelay = "ترحيل"
    override fun agoFmt(v: String) = "منذ $v"
    override val catalogTopFor = "قائمة/تقييم البروكسي لـ"
    override val catalogModeHelpTitle = "الأوضاع والتقييمات"
    override val catalogModeHelp = "يحصي التطبيق المضيفين الأحياء وتقييماتهم بشكل منفصل لكل وضع شبكة (VPN، Wi-Fi، LTE، Ethernet والأبيض). «الأبيض» وضع يدوي منفصل للقوائم البيضاء؛ ولا يبدّل إليه الوضع التلقائي أبدًا. لذا قد يكون المضيف نفسه حيًا في وضع وميتًا في آخر."
    override fun catalogInactiveWarn(section: String, active: String) =
        "أنت تعرض القسم غير النشط $section — كل الإحصاءات الآن تذهب إلى $active، وليس هنا."
    override val manageModeTitle = "إدارة الوضع"
    override val manageResetRating = "إعادة تعيين التقييم"
    override fun manageResetHint(mode: String) = "بالنسبة لـ $mode تحديدًا يمكنك إعادة تعيين التقييم وإحصاءات استخدام المضيفين الأحياء. هذا مفيد عندما تتصل بـ VPN أو LTE مختلف جوهريًا، حتى لا تتداخل الإحصاءات القديمة. أو لمراقبة سرعة إعادة فحص البروكسي لكل شيء من الصفر."
    override val manageDeleteAll = "حذف المضيفين في"
    override fun manageDeleteHint(mode: String) = "يمكنك مسح كل من التقييم والمضيفين أنفسهم من $mode. ستجمعهم ميزة \"فحص البروكسيات\" مرة أخرى. هذا ليس إعادة تعيين للاشتراك — يمكنك النقر عليه، ثم انتظر ~15 دقيقة لإعادة الفحص."
    override fun manageCopyFrom(mode: String) = "انسخ كل المضيفين والتقييمات إلى هذا الوضع ($mode) من وضع آخر:"
    override val live = "حية"; override val deadW = "ميتة"; override val unitMs = "م.ث"
    override val agoMin = "د"; override val agoHour = "س"; override val agoDay = "ي"

    override val connectTelegram = "توصيل Telegram"; override val readCarefully = "اقرأ بعناية!"
    override val guideIntro = "لن يعمل هذا التطبيق بدون إعداد. اختر أيًا من الخيارات الثلاثة أدناه " +
        "واتبع التعليمات بعناية."
    override val variant1 = "الخيار رقم 1 — الأزرار"
    override val variant1Body = "انقر \"بروكسي {A}\" — يُفتح Telegram، أكِّد إضافة البروكسي. ارجع " +
        "إلى هذه الشاشة وانقر \"بروكسي {B}\" — أكِّد الإضافة للمرة الثانية.\n\nعطِّل أي " +
        "بروكسيات قديمة أخرى في Telegram. يجب أن يبقى بالضبط بروكسيان — بالمنفذين {A} و {B}. " +
        "مع أي مجموعة أخرى لن يعمل AutoConnector."
    override val variant2 = "الخيار رقم 2 — الروابط"
    override val variant2Body = "انسخ النص أدناه إلى الرسائل المحفوظة (أو أي محادثة) في Telegram — " +
        "أي أرسله إلى نفسك. انقر الرابط الأول في رسالتك — تُضاف البروكسي الأولى. " +
        "انقر الرابط الثاني — تُضاف الثانية. ثم عطِّل كل البروكسيات القديمة."
    override val variant3 = "الخيار رقم 3 — يدويًا"
    override val variant3Body = "أضف يدويًا بروكسي SOCKS5: الخادم localhost (127.0.0.1)، المنفذ {A}. " +
        "ثم بروكسي ثانية: localhost، المنفذ {B}. احذف أي بروكسيات قديمة."
    override val whatNext = "ما التالي؟"
    override val whatNextBody = "في Telegram، فعِّل \"التبديل التلقائي للبروكسي\" — 5 ثوانٍ. يمكنك مساعدة " +
        "Telegram على الاتصال بالنقر يدويًا على بروكسي (داخل Telegram) غير نشط أو مُعلَّم " +
        "\"غير متاح\" — فهذا يجعل Telegram يحاول الاتصال بجهد أكبر.\n\nتأكد أن كل البروكسيات القديمة " +
        "الأخرى محذوفة، باستثناء {A} و {B}. انقر " +
        "\"استخدام البروكسي\" في Telegram.\n\nانتظر بينما يعثر التطبيق على بروكسيات كافية ويُنزِّلها " +
        "(5–15 دقيقة). ثم يتصل Telegram بـ AutoConnector من تلقاء نفسه، والذي سيواصل توجيه " +
        "Telegram عبر أفضل البروكسيات: الموثَّقة والحية والسريعة.\n\nإذا بدت التعليمات " +
        "صعبة — نعتذر، لن تتمكن من استخدام التطبيق: من المستحيل إعداد كل شيء " +
        "تلقائيًا، والعثور على بروكسيات حية يستغرق وقتًا.\n\nإذا نزَّلت التطبيق منذ زمن طويل " +
        "ولم يُعثر على أي بروكسيات حية — حدِّث إما التطبيق أو قائمة الاشتراكات. هذا التطبيق " +
        "لا يخترع أو يوفِّر بروكسيات خاصة به، إنما يبحث فقط في الإنترنت عبر عشرات " +
        "المجموعات والصفحات."
    override fun proxyBtn(port: Int) = "بروكسي $port"

    override val setupPortsTitle = "إعداد المنافذ في Telegram"
    override val setupPortsSub = "كيفية توصيل Telegram بالموصِّل (المنفذان 55001/55002)"
    override val settings = "الإعدادات"; override val settingsSub = "المنافذ، مضاد DPI، الفحص، الشبكة، البطارية"
    override val subscriptions = "الاشتراكات"; override val subscriptionsSub = "مصادر البروكسي للفحص"
    override val statistics = "الإحصاءات"; override val statisticsSub = "قاعدة بيانات البروكسي + حيل مضاد DPI"
    override val export = "تصدير"; override val exportSub = "روابط tg:// للبروكسيات الحية"
    override val about = "حول"; override val aboutSub = "الإصدار، البناء، التنزيل، الملاحظات"
    override val hotkeys = "اختصارات المفاتيح"
    override val hotkeysSub = "مفاتيح عامة: نسخ / فتح بروكسي"
    override val hotkeysIntro = "تعمل اختصارات المفاتيح العامة حتى عندما لا تكون نافذة التطبيق في البؤرة. تختار " +
        "رابط بروكسي حي عشوائي (tg://) من المجمَّع — مفيد للتبديل السريع للبروكسيات دون " +
        "فتح التطبيق."
    override val hotkeysNote = "على macOS، قد يتطلب التقاط المفاتيح إذن إمكانية الوصول " +
        "(إعدادات النظام ← الخصوصية والأمان ← إمكانية الوصول)."
    override val hotkeyCopyTitle = "نسخ رابط البروكسي"
    override val hotkeyCopyDesc = "يضع رابط tg:// حي عشوائي في الحافظة."
    override val hotkeyEnable = "تفعيل الاختصارات"; override val hotkeyLetterLabel = "حرف"; override val hotkeySet = "تعيين"; override val hotkeyReset = "إعادة تعيين"
    override val hotkeyOpenTitle = "فتح البروكسي في Telegram"
    override val hotkeyOpenDesc = "يفتح رابطًا حيًا عشوائيًا — يلتقطه Telegram ويعرض توصيل البروكسي."

    override val relayPorts = "منافذ الترحيل"
    override val relayPortsHelp = "المنافذ المحلية التي يستمع عليها الموصِّل. تُدخل هذه بالضبط في " +
        "Telegram كبروكسي SOCKS5 (127.0.0.1 : المنفذ). يُستخدم منفذان للموثوقية — يبقي Telegram " +
        "اتصالات على كليهما."
    override val portA = "المنفذ A"; override val portB = "المنفذ B"
    override val antiDpiTrick = "حيلة مضاد DPI"
    override val antiDpiHelp = "طريقة لتمويه الاتصال حتى لا يتعرّف عليه مزوّد الخدمة/DPI و" +
        "يحجبه.\n• \"تدوير تلقائي\" يختار حيلة عاملة بنفسه.\n• \"بلا حيل DPI\" — اتصال " +
        "عادي.\n• الباقي تقنيات محددة (محاكاة المتصفح، تجزئة الحزم، إلخ)."
    override val onlyFakeTls = "FakeTLS فقط (ee)"
    override val applyDpiTo = "تطبيق مضاد DPI على"
    override val applyDpiHelp = "ما الذي يُطبَّق عليه حيلة مضاد DPI المختارة:\n• ترحيل Telegram — على " +
        "اتصال Telegram الحي عبر الموصِّل.\n• فحوص البروكسي — على فحوص البروكسي في الخلفية " +
        "(عندها يتصرف الفحص تمامًا كاتصال حقيقي، وتكون إحصاءات الحيل أدق).\n" +
        "• عند الاتصال المباشر — عندما تكون البروكسيات متوقفة (أو متجاوَزة أثناء تشغيل VPN) ويذهب " +
        "Telegram مباشرة إلى خوادمه: لا يوجد بروكسي هنا، لذا تتلخص الحيلة في تجزئة " +
        "حزمة TCP الأولى (المصافحة) إلى عدة أجزاء صغيرة حتى لا يستطيع DPI مطابقتها في قراءة واحدة."
    override val toRelay = "ترحيل Telegram"; override val toProbes = "فحوص البروكسي"
    override val toDirect = "عند الاتصال المباشر"
    override val vpnSection = "عند تشغيل VPN"
    override val vpnHelp = "ما الذي يجب فعله عندما يكون VPN نشطًا على الجهاز:\n• عبر بروكسي MTProto — " +
        "يذهب Telegram عبر البروكسيات الموجودة كالمعتاد (فوق VPN).\n• مباشرة — " +
        "لا يستخدم الموصِّل البروكسيات ويوصل Telegram مباشرة بخوادم Telegram: " +
        "يوفِّر VPN الوصول بالفعل، ولا حاجة لطبقة بروكسي إضافية (أسرع وأكثر استقرارًا). " +
        "بدون VPN تُستخدم البروكسيات كالمعتاد."
    override val linkFormat = "تنسيق رابط البروكسي"
    override val linkFormatHelp = "كيفية نسخ وفتح البروكسيات. يفتح tg:// تطبيق Telegram مباشرة (يتطلب تثبيت Telegram Desktop). يفتح http (t.me) عبر المتصفح ويعرض الفتح في Telegram — مفيد إذا لم يكن tg:// مُسجَّلًا."
    override val linkTg = "tg:// (فتح Telegram مباشرة)"; override val linkTgSub = "tg://proxy?… — يفتح Telegram"
    override val linkHttp = "http (t.me، عبر المتصفح)"; override val linkHttpSub = "https://t.me/proxy?… — يفتح المتصفح"
    override val viaMtproto = "بروكسي عبر MTProto"; override val viaMtprotoSub = "حتى مع VPN، تمر البيانات عبر البروكسيات"
    override val directly = "اتصال مباشر"; override val directlySub = "مع تشغيل VPN — تجاوز البروكسيات، مباشرة إلى Telegram"
    override val notifications = "الإشعارات"
    override val scanCheck = "الفحص والتحقق"
    override val scanCheckHelp = "• الفحص، دقيقة — كل كم تُنزَّل قوائم البروكسي من الاشتراكات.\n" +
        "• التحقق، دقيقة — كل كم تُعاد فحص البروكسيات في قاعدة البيانات للتأكد من حيويتها.\n• حجم الدفعة — " +
        "كم بروكسي يُفحص في كل تشغيل.\n• المتوازي — كم فحصًا يُشغَّل في وقت واحد (أكثر = " +
        "أسرع، لكن حمل أعلى على الشبكة والبطارية)."
    override val scanMin = "الفحص، دقيقة"; override val checkMin = "التحقق، دقيقة"; override val batchSize = "حجم الدفعة"; override val parallel = "المتوازي"
    override val speedByNet = "كثافة الفحص حسب الشبكة"
    override val speedByNetHelp = "كل كم تُفحص البروكسيات حسب الشبكة الحالية. " +
        "\"قياسي\" = الفترة الأساسية. مرِّر يمينًا لجعله أندر (أبطأ، أرفق بالبيانات/البطارية)، " +
        "ويسارًا لجعله أكثر تكرارًا (أسرع، أكثر عدوانية). مقياس لوغاريتمي، حتى ×100 في كل اتجاه.\n" +
        "• VPN — عندما يكون VPN خارجي نشطًا.\n• Wi-Fi — على شبكة Wi-Fi.\n• LTE — على شبكة محمولة."
    override val intensStandard = "قياسي"
    override val intensSlower = "أبطأ"
    override val intensFaster = "أسرع"
    override val maintenance = "إعادة تعيين البيانات"
    override val maintenanceHelp = "• \"إعادة تعيين الفهرس والإحصاءات\" — تصفِّر التقييمات والعدادات والبيانات " +
        "وسجلات الفحص، لكنها تحتفظ بالمضيفين المنزَّلين والاشتراكات (يُعاد تقييم كل شيء عند " +
        "الفحص التالي).\n• \"مسح المضيفين المنزَّلين\" — يحذف مجمَّع البروكسي بأكمله لكنه يحتفظ ب" +
        "الاشتراكات حتى يعيد الفحص ملء المجمَّع. لا تُمَس الاشتراكات أبدًا في كلتا الحالتين."
    override val backupTitle = "تصدير / استيراد"
    override val backupHelp = "احفظ أو استعِد بيانات التطبيق في ملف JSON واحد. حدِّد ما تريد " +
        "تضمينه — أي مزيج:\n• الإعدادات — كل معاملات التطبيق.\n• الاشتراكات — قائمة المصادر " +
        "(URL + تشغيل/إيقاف).\n• فهرس المضيفين الأحياء — كل بروكسي حي مع تقييماته وإحصاءاته " +
        "لكل وضع شبكة.\n\nيسأل «التصدير» أين يحفظ؛ ويسأل «الاستيراد» أي ملف يفتح و" +
        "يطبِّق فقط الأقسام المحددة الموجودة فيه. الاستيراد يضيف إلى البيانات الحالية (بلا مسح)."
    override val backupSettings = "الإعدادات"
    override val backupSubs = "الاشتراكات"
    override val backupHosts = "فهرس المضيفين الأحياء (لكل وضع)"
    override val exportWord = "تصدير"
    override val importWord = "استيراد"
    override val eraseAllHosts = "مسح كل المضيفين"
    override val factoryReset = "إعادة تعيين كل شيء (كأول تشغيل)"
    override val factoryResetConfirm = "إعادة تعيين التطبيق بالكامل إلى حالة المصنع؟ ستُمسح كل الإعدادات وفهرس " +
        "المضيفين بأكمله، وتُستعاد الاشتراكات إلى الافتراضيات. تمامًا كأول تشغيل."
    override val resetCatalog = "إعادة تعيين الفهرس والإحصاءات"
    override val resetCatalogConfirm = "تصفير كل التقييمات والعدادات وسجلات الفحص؟ " +
        "يُحتفظ بالمضيفين المنزَّلين والاشتراكات ويُعاد تقييمها عند الفحص التالي."
    override val clearHosts = "مسح المضيفين المنزَّلين"
    override val clearHostsConfirm = "حذف القائمة الكاملة للمضيفين المنزَّلين (البروكسيات)؟ " +
        "يُحتفظ بالاشتراكات وسيعيد الفحص ملء المجمَّع."
    override val doReset = "إعادة تعيين"
    override val doCancel = "إلغاء"
    override val adaptiveSpeed = "السرعة التكيفية"
    override val adaptiveHelp = "تعمل فحوص الحيوية بفترة أساسية (من \"الفحص والتحقق\"، مضروبة أيضًا " +
        "في مضاعِف الشبكة). \"السرعة التكيفية\" تسرِّعها أو تبطئها " +
        "تلقائيًا بناءً على عدد البروكسيات الحية حاليًا.\n\n" +
        "• قليل حي (دون عتبة \"قليل\") ← الفترة × \"التسريع\". مضاعِف دون 1 = " +
        "أكثر تكرارًا: 0.5 — ضعف التكرار، 0.25 — 4×. يملأ المجمَّع أسرع.\n" +
        "• كثير حي (فوق عتبة \"كثير\") ← الفترة × \"الإبطاء\". فوق 1 = أندر: 2 — " +
        "نصف التكرار، 4 — الربع. يوفِّر البطارية والبيانات.\n" +
        "• بين العتبتين — السرعة الأساسية (×1).\n\n" +
        "أمثلة:\n" +
        "— جمع البروكسيات أسرع: \"التسريع\" 0.25 و/أو عتبة \"قليل\" 40.\n" +
        "— توفير البطارية عند الاكتفاء: \"الإبطاء\" 8 و/أو عتبة \"كثير\" 30.\n" +
        "— تعطيل التكيف: اضبط كلا المضاعِفين على 1.\n\n" +
        "الافتراضيات: قليل 20، التسريع 0.5، كثير 50، الإبطاء 4."
    override val threshMany = "عتبة \"كثير\""; override val threshFew = "عتبة \"قليل\""; override val mulFast = "التسريع ×"; override val mulLazy = "الإبطاء ×"
    override val subIntensityTitle = "كثافة الاشتراكات"
    override val subIntensityHint = "توقف بين تنزيلات الاشتراكات: كم دقيقة قبل إعادة تنزيل قوائم البروكسي (بشكل منفصل لكل وضع شبكة)."
    override val baseScanTitle = "سرعة الفحص الأساسية"
    override val baseScanHelp = "السرعة المرجعية لفحص الحيوية. تُحسَب «السرعة التكيفية» ومضاعِفات «السرعة " +
        "حسب الوضع» بالنسبة إليها.\n\n" +
        "• كل كم تُشغَّل، دقيقة — الفترة بين مرات الفحص.\n" +
        "• الدفعة لكل خيط، مضيف — كم مضيفًا يفحص كل خيط في كل مرة.\n" +
        "• الخيوط — كم فحصًا يُشغَّل في وقت واحد. تفحص المرة «الدفعة × الخيوط» مضيفًا.\n" +
        "• لا تُعِد فحص مضيف أكثر من كل N دقيقة — مضاد إغراق: يُتخطّى مضيف فُحص حديثًا " +
        "في هذه المرة.\n\n" +
        "خيوط أكثر ودفعة أكبر = نمو أسرع للمجمَّع، لكن حمل أثقل على الشبكة والبطارية."
    override val baseScanPeriod = "كل كم تُشغَّل، دقيقة"
    override val baseScanBatch = "الدفعة لكل خيط، مضيف"; override val baseScanThreads = "عدد الخيوط"
    override val adaptiveDesc = "إذا كانت البروكسيات الحية أقل من «قليل» أو أكثر من «كثير»، طبِّق مضاعِفًا إضافيًا."
    override val fewWord = "قليل"; override val manyWord = "كثير"
    override fun fasterX(x: String) = "×$x أسرع"
    override fun slowerX(x: String) = "×$x أبطأ"
    override fun ifAliveLt(n: Int) = "إذا كانت البروكسيات الحية < $n، إذًا:"
    override fun ifAliveGt(n: Int) = "إذا كانت البروكسيات الحية > $n، إذًا:"
    override val disabledWord = "متوقف"
    override val speedByModeTitle = "السرعة حسب الوضع"
    override val speedByModeHelp = "مضاعِف سرعة فحص لكل وضع شبكة، فوق السرعة " +
        "الأساسية. «قياسي» (×1) = الفترة الأساسية. يمينًا — أندر (أبطأ، أرفق بالبيانات/" +
        "البطارية)، يسارًا — أكثر تكرارًا (أسرع، أكثر عدوانية). مقياس لوغاريتمي، حتى ×100 في كل " +
        "اتجاه.\n\n" +
        "تحت كل شريط تمرير معاملات المرة الناتجة مع تطبيق السرعة التكيفية — " +
        "معروضة بشكل منفصل لـ «قليل حي» (× «التسريع») و«كثير حي» (× «الإبطاء»).\n\n" +
        "الأوضاع:\n• VPN — VPN خارجي نشط.\n• LTE — شبكة محمولة.\n• Wi-Fi — شبكة Wi-Fi.\n" +
        "• Ethernet — اتصال سلكي.\n• الأبيض — وضع البروكسي «الأبيض» اليدوي."
    override val aliveLt = "حي <"; override val aliveGt = "حي >"
    override val periodWord = "الفترة"; override val nonstopWord = "بلا توقف"
    override val batchWord = "الدفعة"; override val threadsWord = "الخيوط"; override val scanModeOff = "الفحص متوقف"
    override val netBattery = "الشبكة والبطارية"
    override val netBatteryHelp = "• Wi-Fi فقط — لا تفحص على الشبكات المحمولة (يوفِّر البيانات).\n• الشحن " +
        "فقط — اعمل فقط أثناء شحن الهاتف.\n• تخطٍّ عند انخفاض البطارية — أوقف الفحص مؤقتًا عندما تكون " +
        "البطارية منخفضة."
    override val onlyWifi = "Wi-Fi فقط"; override val onlyCharging = "الشحن فقط"; override val skipLowBattery = "تخطٍّ عند انخفاض البطارية"
    override val autosaved = "تُحفظ الإعدادات تلقائيًا."
    override val dpiAutoLabel = "تدوير تلقائي لحيل DPI"; override val dpiNoneLabel = "بلا حيل DPI (عادي)"
    override val experimental = "تجريبي"
    override val experimentalHelp = "محركات بروكسي بديلة لمنبع MTProto بالإضافة إلى سجل تشخيصي. " +
        "المسار المرجعي (العامل) لا يتغير عند ضبطه على «إيقاف». يتغير فقط كيفية كتابة التدفق المشفَّر إلى " +
        "مقبس TCP المنبع (أحجام الأجزاء، التوقيت، حدود سجلات TLS) — يبقى التدفق نفسه متطابقًا بايتًا ببايت. " +
        "ينطبق على ترحيل البروكسي الحي فقط (لا على الفحوص، ولا على المسار المباشر)."
    override val expEngineTitle = "محرك البروكسي (تمويه المقبس)"
    override val expConnectTitle = "محرك الاتصال (اختيار المنبع)"
    override val raceWidthTitle = "اتصالات متوازية"
    override val connectionSection = "الاتصال وتجاوز الحجب"
    override val connectionSectionHelp = "محرك الاتصال، المنابع المتوازية، محرك البروكسي وحيل مضاد DPI — كلها في قسم واحد."
    override val netLogSection = "سجل تبادل الشبكة"
    override val expEngineWarn = "⚠ وضع تجريبي. إذا ساء الاتصال، عُد إلى «إيقاف (المسار المرجعي)»."
    override val netLog = "تفعيل سجل تبادل الشبكة"
    override val netLogSub = "يكتب من-إلى-من-ومتى وأحجام الحزم إلى ملف (بلا بيانات الحمولة) — " +
        "لمقارنة نمط التبادل مع وبدون VPN."
    override val openLogFolder = "فتح مجلد السجل"; override val copyPath = "نسخ المسار"
    override val helpShow = "مساعدة"; override val helpHide = "إخفاء المساعدة"
    override val quickSwitchIntro = "هنا يمكنك اختيار حيلة لتجاوز الحجب. إذا أظهر Telegram الخطأ " +
        "“البروكسي الذي تستخدمه غير مُهيَّأ بشكل صحيح وسيُعطَّل. يرجى البحث عن واحد " +
        "آخر”، جرِّب أي نوع من تمويه البيانات يعمل حتى يتوقف Telegram عن إظهاره. ابدأ " +
        "بأوضاع split*. تعمل أوضاع coalesce* أيضًا، لكن الصور/الفيديوهات تُحمَّل بشكل سيئ في Telegram معها."
    override val quickSwitchTitle ="تجاوز الحجب"; override val quickSwitchSub = "التشكيل، الاتصال، مضاد DPI"

    override val sourceUrl = "عنوان URL للمصدر"
    override fun sourceAlive(alive: Int, total: Int) = "حية $alive/$total"
    override val open = "فتح"; override val active = "نشط"; override val inactive = "غير نشط"
    override val lastDownloaded = "تم التنزيل"; override val notDownloaded = "لم يُنزَّل بعد"
    override fun sourceCounts(dead: Int, total: Int) =
        " حية، $dead ميتة، $total الإجمالي"

    override val proxyBase = "قاعدة بيانات البروكسي"
    override val totalInBase = "الإجمالي في قاعدة البيانات"; override val aliveNow = "حية الآن"; override val deadStat = "ميتة"
    override val aliveIn15 = "حية خلال 15 دقيقة"; override val checksAllTime = "الفحوص كل الوقت"
    override val antiDpiTricks = "حيل مضاد DPI"; override val noStatsYet = "لا بيانات بعد — تتراكم الحيل مع حدوث الفحوص/الاتصالات"
    override val attempts = "المحاولات"; override val handshake = "المصافحة"; override val score = "النتيجة"
    override val tgConnect = "اتصال TG"; override val socketsOver1m = "مقابس >1دقيقة"
    override val over10kb = "مقابس >10KB"; override val over100kb = ">100KB"; override val workTime = "وقت العمل"
    override val statsLegend = "المصافحة — مصافحات ناجحة (% من المحاولات) · النتيجة — القيمة · " +
        "\"وقت العمل\" — الإجمالي عبر المقابس ≥5KB والأطول من دقيقة واحدة."
    override val resetStats = "إعادة تعيين إحصاءات الحيل"

    override fun aliveLinks(n: Int) = "الروابط الحية: $n"
    override val copyAll = "نسخ الكل"
    override val openRandom = "فتح عشوائي"; override val copyRandom = "نسخ عشوائي"; override val allShort = "الكل"
    override val copyTop = "نسخ الأفضل"; override val randomHost = "مضيف عشوائي"
    override val exportToFile = "تصدير إلى ملف"; override val exportSaved = "حُفظ في الملف:"
    override val dlNow = "تنزيل الآن"
    override fun downloadingFmt(sec: Long) = "جارٍ التنزيل… ${sec}ث"
    override val cancel = "إلغاء"
    override val deleteConfirmTitle = "حذف الاشتراك؟"
    override val subscriptionsAddHint = "أضف اشتراكات أو روابط بروكسي ←"
    override val addSourcesTitle = "إضافة"
    override val addSubsLabel = "الاشتراكات (URL واحد لكل سطر)"
    override val addSubsHelp = "كل سطر يحتوي على URL صالح يصبح اشتراكًا خاصًا به ويُجلب دوريًا."
    override val addProxiesLabel = "روابط بروكسي جاهزة (قائمة ثابتة)"
    override val addProxiesHelp = "الصق دفعة من الروابط لبروكسيات محددة (tg://proxy، https://t.me/proxy، …). هذا ليس اشتراكًا — لا تُنزَّل القائمة أبدًا، تُضاف البروكسيات فقط إلى الفهرس."
    override val addButton = "إضافة"
    override fun addedFmt(subs: Int, proxies: Int) = "أُضيف: $subs اشتراكات، $proxies بروكسيات"
    override val perSecond = "في الثانية"
    override val graphSpeed = "السرعة"
    override val graphVolume = "الحجم"
    override val graphLatency = "بنغ"
    override val graphConnects = "اتصالات"
    override val scanNow = "افحص الآن"; override val scanOnShort = "الفحص"
    override val scanRunning = "الفحص يعمل"; override val scanIdle = "الفحص خامل"; override val scanOffState = "الفحص متوقف"; override val scanBatchPerThread = "الدفعة/الخيط"; override val scanPassHosts = "المضيفون في المرة"; override val minRescanLabel = "لا تُعِد فحص مضيف أكثر من كل N دقيقة"
    override val scanPlanTitle = "الخطة"; override val scanNowTitle = "الآن"; override val currentScheduleTitle = "الجدول الحالي"
    override val scheduleWord = "الجدول"; override val unitPcsPerSec = "قطعة/ث"
    override val scanNowThreadsLabel = "الخيوط العاملة الآن"; override val scanNowPerThreadLabel = "الفحوص لكل خيط (الخطة)"; override val scanNowElapsedLabel = "وقت التشغيل"
    override val scanOkGraph = "فحوص ناجحة"; override val scanFailGraph = "فحوص فاشلة"; override val scanTrafficGraph = "بيانات الفحص"; override val scanAliveGraph = "إجمالي البروكسيات الحية"; override val scanPingGraph = "بنغ"; override val threadsGraph = "الخيوط"
    override val scanEvery = "كل"; override val scanNextRun = "التشغيل التالي"
    override val scanThreads = "الخيوط"; override val scanBatch = "الدفعة"
    override val scanElapsed = "يعمل"; override val scanIdleNow = "—"
    override val effForFew = "عند القلة"; override val effForMany = "عند الكثرة"
    override val effCheck = "التحقق"; override val effBatch = "الدفعة"; override val effPar = "المتوازي"
    override val effContinuous = "مستمر"; override val secShort = "ث"; override val minShort = "دقيقة"

    override val appTagline = "موصِّل تلقائي متعدد المنصات: يعثر على بروكسيات MTProto ويفحصها ويشغِّلها " +
        "ليعمل Telegram عبرها."
    override val version = "الإصدار"; override val buildDate = "تاريخ البناء"; override val platform = "المنصة"
    override val downloadSources = "التنزيل والمصادر"; override val openOnGithub = "فتح على GitHub"
    override val feedbackBugs = "الملاحظات وتقارير الأخطاء"; override val writeTelegram = "راسلنا على Telegram"

    override val language = "اللغة"; override val langAuto = "تلقائي (النظام)"; override val langRu = "Русский"; override val langEn = "English"
    override val langFa = "فارسی"; override val langZh = "简体中文"; override val langAr = "العربية"; override val langUr = "اردو"
    override val langTr = "Türkçe"; override val langId = "Bahasa Indonesia"; override val langHi = "हिन्दी"; override val langBn = "বাংলা"; override val langMy = "မြန်မာ"
    override val langWord = "اللغة"

    override val scanModeTitle = "وضع الشبكة"; override val scanModeAuto = "تلقائي"; override val scanModeManualLabel = "يدوي"
    override val activeModeLabel = "الوضع النشط"; override val formingListLabel = "بناء القائمة"; override val catalogModeTabs = "الوضع"
    override val resetModeRatings = "إعادة تعيين تقييمات المضيفين"; override val forgetModeHosts = "نسيان مضيفي الوضع"
    override val exportModeTitle = "تصدير حسب الوضع"; override val modePickerTitle = "الوضع"
    override val modeHelp = "يحتفظ كل وضع شبكة بتقييمات البروكسي الخاصة به وكثافة الفحص + تنزيل الاشتراكات الخاصة به. يختار «تلقائي» الوضع من الشبكة النشطة. يتيح لك «يدوي» اختيار أي وضع بنفسك (بما في ذلك الأبيض، الذي لا يختاره التلقائي أبدًا)."
    override val autoSelect = "اختيار تلقائي"; override val manualSelect = "اختيار يدوي"
    override val connStatsTitle = "الاتصالات الآن"; override val connOnPort = "الاتصالات على المنفذ"; override val outgoingConns = "الاتصالات الصادرة"
    override val modeChoice = "اختيار الوضع"; override val autoChoice = "اختيار تلقائي"; override val manualChoice = "ثابت يدوي"
    override val directOnVpn = "اتصال مباشر بـ TG على VPN"; override val onWord = "تشغيل"; override val offWord = "إيقاف"
    override val directStateActive = "نشط"; override val directStateOff = "متوقف في الإعدادات"; override val directStateIdle = "مفعَّل في الإعدادات، لكن غير نشط"
    override val wpHintTitle = "ما هو الأبيض؟"
    override val wpHint = "الأبيض — WhitePages: ملف شبكة يدوي. يُفعَّل يدويًا فقط (لا يختاره الاختيار التلقائي أبدًا). " +
        "يحتفظ بتقييمات مضيفيه الخاصة، وينزِّل الاشتراكات ويفحص بشكل مستقل عن VPN/Wi-Fi/LTE."
}
