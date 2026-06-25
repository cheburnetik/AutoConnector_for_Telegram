package io.autoconnector.i18n

object Uz : Strings by En {
    override val tabConnector = "Konnektor"; override val tabScan = "Skan"
    override val tabCatalog = "Katalog"; override val tabLogs = "Loglar"; override val tabMore = "Yana"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "Obunalar"; override val logTabScan = "Skan"
    override val logGeneral = "Umumiy"; override val logEmpty = "hozircha bo‘sh"
    override val logSessions = "Sessiyalar"; override val logErrorsOnly = "faqat xatoliklar bilan"; override val logNoErrors = "xatolik bo‘lgan sessiyalar yo‘q"
    override fun logSession(id: String, port: String) = "№${id} · :${port}"
    override val back = "Orqaga"; override val copy = "Nusxa olish"; override val gotIt = "Tushunarli"
    override val later = "Keyinroq"; override val details = "Batafsil"; override val whatIsThis = "Bu nima?"
    override val delete = "O‘chirish"

    override val connector = "Konnektor"; override val scan = "Skan"
    override val notConfigured = "Sozlanmagan! Tuzatish →"; override val howToSetup = "Qanday sozlash"
    override val notifOff = "Bildirishnomalar o‘chiq! Tuzatish →"; override val enable = "Yoqish"
    override fun fewProxies(n: Int) = "Tirik proksilar ${n}, qidirilmoqda, ~15 daqiqa kuting…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "Tirik proksilar: ${alive}  (15 daq: ${within}) · jami: ${total}"
    override val notifWhyTitle = "Bildirishnomalar nega kerak?"
    override val notifWhyBody = "Doimiy belgili bildirishnoma — bu Android foreground-xizmati. " +
        "Usiz tizim ilovani xotiradan chiqarib yuboradi va u proksi qidirishni hamda " +
        "ulanishni fonda ushlab turishni to‘xtatadi. Shuning uchun AutoConnector ishlashi uchun " +
        "bildirishnomalar majburiy."
    override val notifEnableTitle = "Bildirishnomalarni yoqing"
    override val notifEnableBody = "Bildirishnoma-belgisiz Android ilovani nofaol deb hisoblaydi va " +
        "uni xotiradan chiqarib yuboradi. Shunda AutoConnector proksi qidirishni va ulanishni " +
        "fonda ushlab turishni to‘xtatadi — Telegram aloqasini yo‘qotadi.\n\n«Yoqish»ni bosing va " +
        "AutoConnector uchun bildirishnomalarga ruxsat bering."
    override val notifPlea = "Bildirishnomalarni yoqing! Ularsiz ilova fon rejimida ishlay olmaydi — " +
        "Android uni chiqarib yuboradi, proksi qidiruvi va ulanish to‘xtaydi."

    override val statusConnected = "Telegram ulangan"; override val statusConnecting = "Ulanmoqda…"
    override val statusOffline = "Telegram ulanmagan"; override val statusIdle = "Telegram jim"
    override val nobodyConnected = "Konnektorga hech kim ulanmadi. "; override val howToSetupArrow = "Qanday sozlash →"
    override val directModeViaVpn = "To‘g‘ridan-to‘g‘ri rejim: VPN faol — proksisiz"
    override val directModeOff = "To‘g‘ridan-to‘g‘ri rejim: proksilar o‘chiq"
    override val directDpiSuffix = " · anti-DPI"
    override val connections = "Ulanishlar"; override val sockets = "Soketlar"; override val speed = "Tezlik"
    override val traffic = "Trafik"; override val latency = "Kechikish"
    override fun pcs(n: Int) = "${n} dona"
    override fun netNow(label: String) = "Tarmoq: ${label}"
    override fun tgToConnector(n: Int) = "TG→ ${n}"
    override fun connectorToProxy(n: Int) = "proksi ${n}"
    override val trafficSec = "trafik · 60 soniya"; override val trafficMin = "trafik · 60 daqiqa"
    override val latencySec = "kechikish · 60 soniya"; override val latencyMin = "kechikish · 60 daqiqa"
    override val sec60 = "60 soniya"; override val min60 = "60 daqiqa"
    override val unitSec = "son"; override val unitMin = "daq"; override val unitHour = "soat"; override val dash = "—"
    override val currentProxy = "Joriy proksi"; override val noActiveProxy = "faol proksi yo‘q (Telegram ulanmagan)"
    override val host = "Xost"; override val type = "Turi"; override val secret = "Maxfiy kalit"; override val antiDpi = "Anti-DPI"; override val obfEngine = "Obfuskatsiya dvigateli"
    override fun activeSockets(n: Int) = "Faol Telegram soketlar: ${n}"
    override val noConnections = "faol ulanishlar yo‘q"; override val colHost = "Xost"; override val colTime = "Vaqt"
    override val modeWord = "Rejim"; override val directViaVpnLine = "VPN tufayli Telegramga to‘g‘ridan-to‘g‘ri so‘rovlar"
    override val connModeHelp = "Rejimlar (VPN, Wi-Fi, LTE, Ethernet, White) skanlash intensivligini har xil sozlash imkonini beradi va xostlarning alohida reytingi/statistikasini yuritadi. Tarmoq kartasi avtomatik aniqlanadi; rejimni sozlamalarda qo‘lda belgilash mumkin."

    override val scanOff = "Skanlash o‘chiq"; override val proxiesInBase = "Bazadagi proksilar"
    override val total = "jami"; override val alive = "tirik"; override val dead = "o‘lik"
    override val tgConnectedTitle = "Telegram ulangan"; override val successful = "muvaffaqiyatli"
    override val socketsHeld = "Soketlar qancha turdi"; override val over1m = ">1 daq"; override val over5m = ">5 daq"; override val over15m = ">15 daq"
    override val scanCountTitle = "Proksi skanlari soni"; override val checked = "Tekshirildi"
    override val forAllTime = "butun vaqt davomida"; override val perMinute = "daqiqasiga"; override val perHour = "soatiga"
    override val subsCountTitle = "Obuna yuklamalari soni"; override val downloaded = "yuklandi"; override val failed = "muvaffaqiyatsiz"; override val scanTraffic = "skan trafigi"; override val subTraffic = "obuna trafigi"; override val subTrafficGraph = "Obuna trafigi"
    override val checksMtproto = "MTProto tekshiruvlari (↑ ok · ↓ fail)"

    override fun catalogEmpty(mode: String) = "Katalog ${mode} hozircha bo‘sh. Yo hech qanday xost topilmadi, yoki dastur bu rejimda hech qachon ishlamagan. Rejimni sozlamalardan almashtirish mumkin. Rejimlar internetga ulanishning turli xil turlari uchun xostlarni alohida yig‘ish maqsadida o‘ylab topilgan."
    override val aliveShort = "✓ tirik"; override val deadShort = "✗ o‘lik"
    override val statusLabel = "Holat"; override val rating = "Reyting"; override val port = "Port"
    override val rttPing = "RTT (ping)"; override val checkedField = "Tekshirilgan"; override val okOfTotal = "Muvaffaqiyatli / jami tekshiruvlar"
    override val tgConnectedField = "Telegram ulangan"; override val tgSessions = "Telegram sessiyalari"; override val trafficThroughProxy = "Proksi orqali trafik"
    override val sessionsTotal = "Jami sessiyalar"; override val relayNow = "Hozir rele"; override val tlsDomain = "TLS-domen (SNI)"
    override val sourceSub = "Manba (obuna)"; override val lastError = "Oxirgi xatolik"; override val yes = "ha"; override val no = "yo‘q"
    override val copyAsLink = "Havola sifatida nusxa olish"; override val openInTelegram = "Xostni Telegramda ochish"; override val makeNextRelay = "Keyingi rele qilish"
    override val actCopy = "Nusxa"; override val actOpen = "Ochish"; override val actRelay = "Releda"
    override fun agoFmt(v: String) = "${v} oldin"
    override val recentAttempts = "Oxirgi ulanishlar va tekshiruvlar"
    override val kindCheck = "tekshiruv"
    override val kindTg = "telegram"
    override val histWho = "Kim"
    override val histWhen = "Qachon"
    override val histReq = "So‘rov"
    override val histSess = "Sessiya"
    override val histScan = "skan"
    override val testNow = "Hozir test qilish"
    override val testShort = "Test"
    override val testResult = "Test natijasi"
    override val testStop = "To‘xtatish"
    override val testingNow = "test ketmoqda…"
    override val prewarmTitle = "Soketlarni isitish (tajriba)"
    override val prewarmHelp = "Proksiga oldindan bir nechta soketni ochiq ushlab turish, shunda yangi " +
        "Telegram ulanishi ulanish/qo‘l berishni o‘tkazib yuboradi. Tajribaviy: fon doimiy " +
        "qayta ulanadi → trafik sarfi va biroz CPU. Soxta trafik yuborilmaydi (u haqiqiy " +
        "sessiyani buzar edi) — soketlar shunchaki aylantiriladi. Eng foydalisi FakeTLS-proksi bilan."
    override val prewarmEnable = "Isitishni yoqish"
    override val prewarmModeDeferred = "Kechiktirilgan (faqat TLS)"
    override val prewarmModeDeferredSub = "TCP + FakeTLS ushlanadi; obfuscated2-init uzatishda yuboriladi. DC commit qilinmaydi — eng realistik."
    override val prewarmModeFull = "To‘liq qo‘l berishish"
    override val prewarmModeFullSub = "Turli DC bo‘yicha to‘liq ulangan soketlar ushlanadi; faqat DC/tag mos kelganda qayta ishlatiladi. Kamroq yashaydi."
    override val prewarmPoolLabel = "Zaxiraga soketlar"
    override val prewarmHoldLabel = "Ushlab turish, son"
    override val prewarmNote = "Faqat aylantirish (ilova darajasida keepalive yo‘q). Soket bir necha soniya…~bir daqiqa yashaydi, proksi/DC ga bog‘liq."
    override val prewarmStatus = "Isitish"
    override fun prewarmStatusVal(ready: Int, holdSecs: Int) = "${ready} tayyor · ${holdSecs}s ushlanmoqda"
    override val prewarmStar = "Qalin to‘q sariq = soket isitish pulidan iliq holda berilgan (ulanish/qo‘l berishishsiz)"
    override fun prewarmTableTitle(holdSecs: Int) = "Soketlarni isitish (${holdSecs}s ushlanmoqda)"
    override val prewarmTableHelp = "«Soketlarni isitish» proksiga oldindan bir nechta soketni ochadi, shunda yangi " +
        "Telegram ulanishi ulanish/qo‘l berishni o‘tkazib yuboradi. Bu jadvalda isitilayotgan xostlar ko‘rsatiladi: soket necha soniya " +
        "yashaydi, uni Telegram ishlatyaptimi va trafik. Yoqish/o‘chirish va sozlash (rejim, soketlar soni, " +
        "ushlab turish vaqti) «Yana → Sozlamalar → „Soketlarni isitish (tajriba)“» da mumkin."
    override val prewarmNoneWarming = "hozircha isitilayotgan soketlar yo‘q"
    override val prewarmColAge = "yashaydi"
    override val prewarmColUse = "TG da?"
    override val prewarmInUse = "TG da"
    override val prewarmNew = "yangi"
    override val lanShareTitle = "Mahalliy tarmoqda ulashish (veb-portal)"
    override val lanShareDesc = "Ushbu Wi-Fi dagi boshqa qurilmalarga ushbu AutoKonnektorni proksi sifatida ishlatishga ruxsat berish; quyidagi manzildagi brauzer eng yaxshi proksilar bilan sahifani oladi."
    override val lanShareUrlsLabel = "Tarmoqdagi qo‘shnilar shunday ulanadi:"
    override val lanShareNoIp = "mahalliy tarmoqda manzil yo‘q — Wi-Fi ga ulaning"
    override val lanFirewallTitle = "Mahalliy tarmoqda ruxsat berish"
    override val lanFirewallBody = "Yoqilganda rele portlari mahalliy tarmoqqa ochiladi. Hozir Windows (yoki boshqa) faervoli AutoConnector ga ruxsat berishni so‘rashi mumkin — «Ruxsat berish»/«Ha»ni tanlang. Agar rad etsangiz, qo‘shnilarning AutoKonnektorga trafigi bloklanadi va sahifa/proksi mavjud bo‘lmaydi."
    override val lanFirewallConfirm = "Yoqish"
    override val lanInfoTitle = "Bu nima uchun?"
    override val lanInfoBody = "AutoKonnektorni Wi-Fi dagi BITTA kompyuter yoki telefonda ishga tushiring — va o‘sha tarmoqdagi boshqa barcha qurilmalar, jumladan iPhone (ilova to‘g‘ridan-to‘g‘ri qo‘llab-quvvatlamaydi), brauzerda manzilni ochib foydalanishi mumkin: ularning Telegramiga qo‘shish uchun eng yaxshi proksilar bilan sahifa, yoki shu qurilmaning o‘zi SOCKS-proksi sifatida. Bitta qurilma proksini topadi va ushlab turadi, qolganlari undan mahalliy tarmoq orqali foydalanadi."
    override val volTriggerTitle = "Ovoz tugmalari bilan trigger"
    override val volTriggerSub = "Ovoz tugmalarining tez patterni bilan proksini almashtirish"
    override val volEnableLabel = "Ovoz tugmalarini kuzatish"
    override val volHelpTitle = "Bu nima?"
    override val volHelpBody = "Android da global klaviatura xotkeylari yo‘q, shuning uchun OVOZ tugmalari ishlatiladi. Yoqilganda AutoKonnektor fonda ovoz-tepa/past bosishlarning tez patternini kuzatadi (masalan tepa-tepa-past-past). Uni tanib, tasodifiy yaxshi tirik proksining tg://-havolasini ochadi — Telegram uni ushlab oladi va almashadi. Ilovani ochmasdan proksini aylantirishning tez, sezilmas usuli. Ovoz odatdagidek ishlaydi (bosishlar ushlanmaydi). Accessibility kerak (fonda tugmalarni o‘qish va havola ochish uchun); belgini yoqmaguningizcha hech narsa so‘ralmaydi. Quyida bosishlar orasidagi maksimal vaqtni belgilang; tanib olinadigan patternlar pastda sanab o‘tilgan."
    override val volGrantTitle = "Accessibility ni yoqing (muhim)"
    override val volGrantBody = "Android (ayniqsa 13+) Google Play dan EMAS o‘rnatilgan ilovalar uchun Accessibility ni bloklaydi — shuning uchun AutoConnector kulrang va «Ilovaga ruxsat berilmagan» deb yozadi.\n\nQanday ochish:\n1. «Ilova haqida»ni oching (quyidagi tugma yoki: Sozlamalar → Ilovalar → AutoConnector for Telegram).\n2. ⋮ (yuqori o‘ngdagi uch nuqta) → «Cheklangan sozlamalarga ruxsat berish» → tasdiqlang.\n3. Qayting: Sozlamalar → Accessibility → AutoConnector for Telegram → yoqing.\n\nAgar «Cheklangan sozlamalarga ruxsat berish» bandi bo‘lmasa — avval Accessibility da bir marta tugmani yoqishga urinib ko‘ring (taqiq haqida xabar chiqadi), keyin 2-qadam mavjud bo‘ladi.\n\nXiaomi/MIUI, Samsung va boshqalarda yo‘l biroz farq qilishi mumkin — «Ilova haqida»da o‘sha ⋮ ni qidiring. Android 12 va undan eskida odatda cheklov yo‘q — darrov yoqing.\n\nOvoz tugmalari faqat o‘qiladi, hech qachon bloklanmaydi."
    override val volOpenAppInfo = "«Ilova haqida»ni ochish"
    override val volAccessOn = "Accessibility: yoqilgan"
    override val volAccessOff = "Accessibility: o‘chiq"
    override val volOpenAccess = "Accessibility sozlamalarini ochish"
    override val volGapLabel = "Bosishlar orasida maks. ms"
    override val volPatternsTitle = "Tanib olinadigan patternlar"
    override val volPatternPick = "Pattern"
    override val volPatternsLegend = "↑ = ovoz tepaga, ↓ = pastga"
    override val volNoRights = "Ilovada hozircha ovoz tugmalarini qayta ishlash huquqi YO‘Q — sahifa pastidagi yo‘riqnoma bo‘yicha ruxsat bering."
    override val volGrantShort = "Accessibility ga hozircha ruxsat yo‘q. Ushbu sahifa pastidagi batafsil yo‘riqnomani o‘qing va «Tekshirish»ni bosing."
    override val volCheck = "Tekshirish"
    override val volCheckOk = "✓ Tayyor — ruxsat berildi, trigger ishlaydi."
    override val volCheckFail = "✗ Hozircha ruxsat yo‘q — yuqoridagi qadamlarni bajaring."
    override val volPatternsList = "↑↑↓↓ · ↓↓↑↑ · ↑↓↑↓ · ↓↑↓↑ · ↑↑↑↑ · ↓↓↓↓ · ↑↓↓↑ · ↓↑↑↓ · ↑↑↑↓↓↓ · ↓↓↓↑↑↑   (↑ = ovoz tepaga, ↓ = pastga)"
    override val histLegend = "Ustunlar — Kim: ✓/✗ TG = haqiqiy Telegram ulanishi, skan = fon tekshiruvi. Qachon: qancha vaqt oldin. TCP/TLS/So‘rov: qo‘l berishish va birinchi so‘rov kechikishlari, ms. Sessiya: rele sessiyasi qancha davom etgani. ↓/↑: xost orqali qabul qilingan / yuborilgan baytlar."
    override val tgOkTotalHint = "Telegram ulanishlari / muvaffaqiyatli / jami tekshiruvlar"
    override val breadthTitle = "Xostlarni tanlash kengligi"
    override val breadthHelp = "Chapda — eng yaxshi tekshirilgan xostlarga yopishish; o‘ngda — turli tirik xostlarni iloji boricha keng sinash. Telegram rele portlari bo‘ylab tashlanganda, dastur tanlovni avtomatik kengaytiradi."
    override val breadthNarrow = "tekshirilgan"
    override val breadthWide = "kengroq"
    override val connTimeoutTitle = "Xostga ulanish taymauti"
    override val connTimeoutHelp = "Keyingi proksini sinashdan oldin bitta apstrimni (TCP + TLS + birinchi MTProto javobi) qancha kutish kerakligi."
    override val catalogTopFor = "Proksilar ro‘yxati/reytingi"
    override val catalogModeHelpTitle = "Rejimlar va reytinglar"
    override val catalogModeHelp = "Dastur tirik xostlarni va ularning reytingini har bir tarmoq rejimi bo‘yicha ALOHIDA hisoblaydi (VPN, Wi-Fi, LTE, Ethernet va White). «White» — oq ro‘yxatlar uchun alohida QO‘LDAGI rejim; avto unga hech qachon o‘tmaydi. Shuning uchun bitta xost bir rejimda tirik, boshqasida o‘lik bo‘lishi mumkin."
    override fun catalogInactiveWarn(section: String, active: String) =
        "Siz hozir nofaol ${section} bo‘limini ko‘ryapsiz — barcha statistika ayni paytda bu yerga emas, ${active} ga yig‘iladi."
    override val manageModeTitle = "Rejimni boshqarish"
    override val manageResetRating = "Reytingni nolga tushirish"
    override fun manageResetHint(mode: String) = "Aynan ${mode} uchun tirik xostlarning reytingi va foydalanish statistikasini nolga tushirishingiz mumkin. Bu mutlaqo boshqa VPN yoki LTE ga ulanganingizda, eski statistika xalaqit bermasligi uchun foydali. Yoki proksi skani hammasini noldan qanchalik tez tekshirishini kuzatish uchun."
    override val manageDeleteAll = "Xostlarni o‘chirish:"
    override fun manageDeleteHint(mode: String) = "${mode} dan ham reytingni, ham xostlarning o‘zini tozalash mumkin. «Proksi skani» funksiyasi ularni qaytadan yig‘adi. Bu obunalarni nolga tushirish emas — bosish mumkin, so‘ng qayta skan uchun ~15 daqiqa kuting."
    override fun manageCopyFrom(mode: String) = "Barcha xostlar va reytinglarni boshqa rejimdan shu rejimga (${mode}) nusxalash:"
    override val live = "tirik"; override val deadW = "o‘lik"; override val unitMs = "ms"
    override val agoMin = "daq"; override val agoHour = "soat"; override val agoDay = "kun"

    override val connectTelegram = "Telegramni ulash"; override val readCarefully = "Diqqat bilan o‘qing!"
    override val guideIntro = "Sozlashsiz bu ilova ishlamaydi. Quyidagi 3 ta variantdan istalganini " +
        "tanlang va yo‘riqnomani diqqat bilan bajaring."
    override val variant1 = "Variant №1 — tugmalar bilan"
    override val variant1Body = "«Proksi {A}» tugmasini bosing — Telegram ochiladi, proksi qo‘shishga " +
        "rozi bo‘ling. Ushbu oynaga qayting va «Proksi {B}»ni bosing — ikkinchi marta qo‘shishga " +
        "rozi bo‘ling.\n\nTelegramda boshqa eski proksilarni o‘chiring. Aniq 2 ta proksi qolishi " +
        "kerak — {A} va {B} portlari bilan. Boshqa har qanday to‘plamda AutoConnector ishlamaydi."
    override val variant2 = "Variant №2 — havolalar bilan"
    override val variant2Body = "Quyidagi matnni Telegramdagi «Saqlangan xabarlar»ga (yoki istalgan chatga) " +
        "nusxalang — ya’ni o‘zingizga yuboring. Xabaringizdagi birinchi havolani bosing — birinchi " +
        "proksi qo‘shiladi. Ikkinchi havolani bosing — ikkinchisi qo‘shiladi. So‘ng barcha eski proksilarni o‘chiring."
    override val variant3 = "Variant №3 — qo‘lda"
    override val variant3Body = "SOCKS5 proksini qo‘lda qo‘shing: server localhost (127.0.0.1), port {A}. " +
        "So‘ng ikkinchi proksi: localhost, port {B}. Har qanday eski proksilarni o‘chiring."
    override val whatNext = "Keyin nima?"
    override val whatNextBody = "Telegramda «proksini avto-almashtirish»ni yoqing — 5 soniya. " +
        "Faol BO‘LMAGAN yoki «mavjud emas» deb belgilangan proksini (Telegram ichida) qo‘lda " +
        "bosib, Telegramga ulanishga yordam berishingiz mumkin — shunda Telegram ulanishga ko‘proq " +
        "urinadi.\n\nBarcha boshqa eski proksilar olib tashlanganiga ishonch hosil qiling, {A} va {B} dan tashqari. " +
        "Telegramda «Proksidan foydalanish»ni bosing.\n\nIlova yetarlicha proksini topib yuklab " +
        "olguncha kuting (5–15 daqiqa). So‘ng Telegram AutoConnector ga o‘zi ulanadi, u esa " +
        "Telegramni har safar eng yaxshi proksilarga ulab turadi: tekshirilgan, tirik va " +
        "tez.\n\nAgar yo‘riqnoma qiyin tuyulsa — afsus, ilovadan foydalana olmaysiz: hamma narsani " +
        "avtomatik sozlash mumkin emas, tirik proksilarni qidirish esa vaqt oladi.\n\nAgar ilovani " +
        "ancha oldin yuklab olgan bo‘lsangiz va tirik proksilar topilmasa — yoki ilovani, yoki " +
        "obunalar ro‘yxatini yangilang. Bu ilova proksilarni o‘zi o‘ylab topmaydi va o‘zinikini " +
        "taqdim etmaydi, faqat internetda o‘nlab guruh va sahifalar bo‘ylab qidiradi."
    override fun proxyBtn(port: Int) = "Proksi ${port}"

    override val setupPortsTitle = "Telegramda portlarni sozlash"
    override val setupPortsSub = "Telegramni Konnektorga qanday ulash (55001/55002 portlari)"
    override val settings = "Sozlamalar"; override val settingsSub = "Portlar, anti-DPI, skan, tarmoq, batareya"
    override val subscriptions = "Obunalar"; override val subscriptionsSub = "Skan uchun proksi manbalari"
    override val statistics = "Statistika"; override val statisticsSub = "Proksi bazasi + anti-DPI hiylalari"
    override val export = "Eksport"; override val exportSub = "tirik proksilarning tg:// havolalari"
    override val about = "Dastur haqida"; override val aboutSub = "Versiya, build, yuklab olish, fikr-mulohaza"
    override val hotkeys = "Tezkor tugmalar"
    override val hotkeysSub = "Global tugmalar: proksini nusxalash / ochish"
    override val hotkeysIntro = "Global tezkor tugmalar ilova oynasi fokusda bo‘lmasa ham ishlaydi. " +
        "Ular bazadan tasodifiy tirik proksi havolasini (tg://) oladi — ilovani ochmasdan proksini " +
        "tez almashtirish uchun qulay."
    override val hotkeysNote = "macOS da tugmalarni ushlab olish uchun Accessibility ruxsati kerak " +
        "bo‘lishi mumkin (Tizim sozlamalari → Maxfiylik va xavfsizlik → Accessibility)."
    override val hotkeyCopyTitle = "Proksi havolasini nusxalash"
    override val hotkeyCopyDesc = "Tasodifiy tirik tg:// havolasini buferga qo‘yadi."
    override val hotkeyEnable = "Tezkor tugmalarni yoqish"; override val hotkeyLetterLabel = "Harf"; override val hotkeySet = "Belgilash"; override val hotkeyReset = "Tiklash"
    override val hotkeyOpenTitle = "Proksini Telegramda ochish"
    override val hotkeyOpenDesc = "Tasodifiy tirik havolani ochadi — Telegram uni ushlab oladi va proksini ulashni taklif qiladi."

    override val relayPorts = "Rele portlari"
    override val relayPortsHelp = "Konnektor tinglaydigan mahalliy portlar. Aynan ularni Telegramda " +
        "SOCKS5-proksi sifatida ko‘rsatasiz (127.0.0.1 : port). Ishonchlilik uchun ikkita port " +
        "ishlatiladi — Telegram ikkalasiga ulanishni ushlab turadi."
    override val portA = "Port A"; override val portB = "Port B"
    override val antiDpiTrick = "Anti-DPI hiylasi"
    override val antiDpiHelp = "Provayder/DPI uni tanib olmasligi va bloklamasligi uchun ulanishni " +
        "niqoblash usuli.\n• «Avto-saralash» ishlaydigan hiylani o‘zi tanlaydi.\n• «DPI-hiylalarsiz» — " +
        "oddiy ulanish.\n• Qolganlari — aniq usullar (brauzerga taqlid, paketlarni bo‘lish va h.k.)."
    override val onlyFakeTls = "Faqat FakeTLS (ee)"
    override val applyDpiTo = "Anti-DPI ni qo‘llash:"
    override val applyDpiHelp = "Tanlangan anti-DPI hiylasini nimaga qo‘llash:\n• Telegram releyiga — " +
        "Konnektor orqali tirik Telegram ulanishiga.\n• Proksi probalariga — fon proksi tekshiruvlariga " +
        "(shunda tekshiruv huddi haqiqiy ulanishdek harakat qiladi va hiyla statistikasi aniqroq).\n" +
        "• To‘g‘ridan-to‘g‘ri ulanishda — proksilar o‘chirilganda (yoki VPN da o‘tkazib yuborilganda) va " +
        "Telegram to‘g‘ridan-to‘g‘ri serverlarga borganda: bu yerda proksi yo‘q, shuning uchun hiyla " +
        "birinchi TCP-paketni (qo‘l berishni) bir nechta mayda segmentlarga bo‘lishga kelib taqaladi, " +
        "shunda DPI uni bitta o‘qishda tanib ololmaydi."
    override val toRelay = "Telegram releyiga"; override val toProbes = "Proksi probalariga"
    override val toDirect = "To‘g‘ridan-to‘g‘ri ulanishda"
    override val vpnSection = "VPN yoqilganda"
    override val vpnHelp = "Qurilmada VPN faol bo‘lganda nima qilish:\n• MTProto-proksi orqali — " +
        "Telegram odatdagidek topilgan proksilar orqali boradi (VPN ustida).\n• To‘g‘ridan-to‘g‘ri — " +
        "Konnektor proksilarni ISHLATMAYDI va Telegramni to‘g‘ridan-to‘g‘ri Telegram serverlariga ulaydi: " +
        "VPN allaqachon kirish beradi, ortiqcha proksi qatlami kerak emas (tezroq va barqarorroq). " +
        "VPN siz proksilar odatdagidek ishlatiladi."
    override val linkFormat = "Proksi havolalari formati"
    override val linkFormatHelp = "Proksilarni qanday nusxalash va ochish. tg:// to‘g‘ridan-to‘g‘ri Telegramda ochiladi (Telegram Desktop o‘rnatilgan bo‘lishi kerak). http (t.me) brauzer orqali ochiladi va Telegramda ochishni taklif qiladi — agar tg:// ochilmasa qulay."
    override val linkTg = "tg:// (to‘g‘ridan-to‘g‘ri Telegramda)"; override val linkTgSub = "tg://proxy?… — Telegramni ochadi"
    override val linkHttp = "http (t.me, brauzer orqali)"; override val linkHttpSub = "https://t.me/proxy?… — brauzerni ochadi"
    override val viaMtproto = "MTProto orqali proksilash"; override val viaMtprotoSub = "VPN bilan ham trafik proksilar orqali boradi"
    override val directly = "To‘g‘ridan-to‘g‘ri proksilash"; override val directlySub = "VPN faol bo‘lganda — proksilarni chetlab, to‘g‘ridan Telegramga"
    override val notifications = "Bildirishnomalar"
    override val scanCheck = "Skan va tekshiruv"
    override val scanCheckHelp = "• Skan, daq — obunalardan proksi ro‘yxatlarini qanchalik tez-tez yuklash.\n" +
        "• Tekshiruv, daq — bazadagi proksilarni tiriklikka qanchalik tez-tez qayta tekshirish.\n• Pachka hajmi — " +
        "bir o‘tishda qancha proksini tekshirish.\n• Parallel — bir vaqtning o‘zida qancha tekshiruv " +
        "bajarish (ko‘proq = tezroq, lekin tarmoq va batareyaga yuk yuqori)."
    override val scanMin = "Skan, daq"; override val checkMin = "Tekshiruv, daq"; override val batchSize = "Pachka hajmi"; override val parallel = "Parallel"
    override val speedByNet = "Tarmoq bo‘yicha skan intensivligi"
    override val speedByNetHelp = "Joriy tarmoqqa qarab proksilarni qanchalik tez-tez tekshirish. " +
        "«Standart» = bazaviy interval. O‘ngga surish — kamroq (sekinroq, trafik/batareyaga ehtiyot), " +
        "chapga — tez-tez (tezroq, agressivroq). Logarifmik shkala, har tomonga ×100 gacha.\n" +
        "• VPN — tashqi VPN faol bo‘lganda.\n• Wi-Fi — Wi-Fi tarmog‘ida.\n• LTE — mobil tarmoqda."
    override val intensStandard = "standart"
    override val intensSlower = "sekinroq"
    override val intensFaster = "tezroq"
    override val maintenance = "Ma’lumotlarni tiklash"
    override val maintenanceHelp = "• «Katalog va statistikani tiklash» — reytinglar, hisoblagichlar, " +
        "trafik va tekshiruv loglarini nolga tushiradi, lekin yuklangan xostlar va obunalarni saqlaydi " +
        "(keyingi skanda hammasi qayta baholanadi).\n• «Yuklangan xostlarni tozalash» — butun proksi " +
        "pulini o‘chiradi, lekin obunalarni qoldiradi, shunda skan pulni qayta to‘ldiradi. Obunalar hech " +
        "qaysi holatda tegilmaydi."
    override val backupTitle = "Eksport / Import"
    override val backupHelp = "Ilova ma’lumotlarini JSON sifatida saqlash yoki tiklash. Nimani " +
        "kiritishni belgilang — istalgan kombinatsiya:\n• Sozlamalar — ilovaning barcha parametrlari.\n" +
        "• Obunalar — manbalar ro‘yxati (URL + yoq/o‘chir).\n• Tirik xostlar katalogi — har bir tirik " +
        "proksi reyting va statistikasi bilan tarmoq REJIMI bo‘yicha.\n\n«Eksport» tayyor JSON bilan " +
        "sahifani ochadi — uni nusxalang yoki faylga saqlang. «Import» — JSON ni joylashtiring (yoki fayl " +
        "yuklang), faqat matnda mavjud belgilangan bo‘limlar qo‘llaniladi. Import joriy ma’lumotlarga " +
        "QO‘SHADI (o‘chirmaydi)."
    override val backupSettings = "Sozlamalar"
    override val backupSubs = "Obunalar"
    override val backupHosts = "Tirik xostlar katalogi (rejimlar bo‘yicha)"
    override val exportWord = "Eksport"
    override val importWord = "Import"
    override val backupExportTitle = "Ma’lumotlarni eksport"
    override val backupImportTitle = "Ma’lumotlarni import"
    override val backupSelectExport = "Nimani eksport qilish:"
    override val backupSelectImport = "Nimani import qilish:"
    override val backupCopyBtn = "Nusxa olish"
    override val backupSaveFile = "Faylga saqlash"
    override val backupLoadFile = "Fayldan yuklash"
    override val backupDoImport = "Import qilish"
    override val backupPasteLabel = "Zaxira JSON ni shu yerga joylashtiring"
    override val backupJsonLabel = "Zaxira JSON"
    override val backupAndroidFileNote = "Fayllar bu yerda mavjud emas — Nusxa olish / Joylashtirishdan foydalaning."
    override val eraseAllHosts = "Barcha xostlarni o‘chirish"
    override val factoryReset = "Hammasini tiklash (birinchi ishga tushirishdek)"
    override val factoryResetConfirm = "Ilovani to‘liq zavod holatiga qaytarishmi? BARCHA sozlamalar va " +
        "butun xostlar katalogi o‘chiriladi, obunalar standartga tiklanadi. Aynan birinchi ishga tushirishdek."
    override val factoryResetDone = "Hammasi tiklandi. Ilovani yoping va qaytadan ishga tushiring."
    override val resetCatalog = "Katalog va statistikani tiklash"
    override val resetCatalogConfirm = "Barcha reytinglar, hisoblagichlar va tekshiruv loglarini nolga tushirishmi? " +
        "Yuklangan xostlar va obunalar saqlanadi va keyingi skanda qayta baholanadi."
    override val clearHosts = "Yuklangan xostlarni tozalash"
    override val clearHostsConfirm = "Yuklangan xostlar (proksilar) ro‘yxatini butunlay o‘chirishmi? " +
        "Obunalar saqlanadi va skan pulni qayta to‘ldiradi."
    override val doReset = "Tiklash"
    override val doCancel = "Bekor qilish"
    override val adaptiveSpeed = "Adaptiv tezlik"
    override val adaptiveHelp = "Tiriklik tekshiruvlari bazaviy interval bilan ketadi («Skan va tekshiruv» " +
        "bo‘limidan, yana tarmoq ko‘paytuvchisiga ko‘paytirilgan). «Adaptiv tezlik» hozir qancha proksi " +
        "tirikligiga qarab ularni o‘zi tezlashtiradi yoki sekinlashtiradi.\n\n" +
        "• Tiriklar KAM («Kam» chegarasidan past) → interval × «Tezlashtirish». 1 dan kichik ko‘paytuvchi = " +
        "tez-tez: 0.5 — ikki barobar tez-tez, 0.25 — 4 barobar. Pul tezroq to‘ladi.\n" +
        "• Tiriklar KO‘P («Ko‘p» chegarasidan baland) → interval × «Sekinlashtirish». 1 dan katta = kamroq: " +
        "2 — ikki barobar kamroq, 4 — chorak. Batareya va trafikni tejaydi.\n" +
        "• Chegaralar orasida — bazaviy tezlik (×1).\n\n" +
        "Misollar:\n" +
        "— Proksilarni tezroq yig‘ish: «Tezlashtirish» 0.25 va/yoki «Kam» chegarasi 40.\n" +
        "— Yetarli bo‘lganda batareyani tejash: «Sekinlashtirish» 8 va/yoki «Ko‘p» chegarasi 30.\n" +
        "— Adaptatsiyani o‘chirish: ikkala ko‘paytuvchini 1 qiling.\n\n" +
        "Standart: Kam 20, Tezlashtirish 0.5, Ko‘p 50, Sekinlashtirish 4."
    override val threshMany = "«Kam» chegarasi"; override val threshFew = "«Ko‘p» chegarasi"; override val mulFast = "Tezlashtirish ×"; override val mulLazy = "Sekinlashtirish ×"
    override val subIntensityTitle = "Obunalar intensivligi"
    override val subIntensityHint = "Obuna yuklamalari orasidagi pauza: proksi ro‘yxatlarini necha daqiqada qayta yuklash (har bir tarmoq rejimi uchun alohida)."
    override val baseScanTitle = "Bazaviy skan tezligi"
    override val baseScanHelp = "Proksini tiriklikka tekshirishning tayanch tezligi. «Adaptiv tezlik» va " +
        "«Rejimlar bo‘yicha tezlik» ko‘paytuvchilari undan hisoblanadi.\n\n" +
        "• Necha daqiqada ishga tushirish — tekshiruv o‘tishlari orasidagi interval.\n" +
        "• Oqimga pachka, xost — har bir oqim bir o‘tishda qancha xost tekshiradi.\n" +
        "• Oqimlar soni — bir vaqtning o‘zida qancha tekshiruv ketadi. O‘tishda «pachka × oqimlar» xost " +
        "tekshiriladi.\n" +
        "• Xostni N daqiqada bir martadan tez-tez skanlamaslik — flooddan himoya: yaqinda tekshirilgan " +
        "xost o‘tishga tushmaydi.\n\n" +
        "Ko‘proq oqim va kattaroq pachka = pul tezroq to‘ladi, lekin tarmoq va batareyaga yuk yuqori."
    override val baseScanPeriod = "Necha daqiqada ishga tushirish"
    override val baseScanBatch = "Oqimga pachka, xost"; override val baseScanThreads = "Oqimlar soni"
    override val adaptiveDesc = "Agar tirik proksilar «kam»dan kam yoki «ko‘p»dan ko‘p bo‘lsa — o‘zining qo‘shimcha koeffitsiyentini qo‘llash."
    override val fewWord = "Kam"; override val manyWord = "Ko‘p"
    override fun fasterX(x: String) = "${x}× tezroq"
    override fun slowerX(x: String) = "${x}× sekinroq"
    override fun ifAliveLt(n: Int) = "Agar tirik proksilar < ${n} bo‘lsa:"
    override fun ifAliveGt(n: Int) = "Agar tirik proksilar > ${n} bo‘lsa:"
    override val disabledWord = "o‘chiq"
    override val speedByModeTitle = "Rejimlar bo‘yicha tezlik"
    override val speedByModeHelp = "Bazaviy tezlik ustiga har bir tarmoq rejimi uchun skan tezligi " +
        "ko‘paytuvchisi. «Standart» (×1) = bazaviy interval. O‘ngga — kamroq (sekinroq, trafik/" +
        "batareyaga ehtiyot), chapga — tez-tez (tezroq, agressivroq). Logarifmik shkala, har tomonga " +
        "×100 gacha.\n\n" +
        "Har bir slayder ostida — adaptiv tezlik hisobga olingan yakuniy o‘tish parametrlari: " +
        "«tirik kam» (× «Tezlashtirish») va «tirik ko‘p» (× «Sekinlashtirish») uchun alohida.\n\n" +
        "Rejimlar:\n• VPN — tashqi VPN faol.\n• LTE — mobil tarmoq.\n• Wi-Fi — Wi-Fi tarmoq.\n" +
        "• Ethernet — simli ulanish.\n• White — «oq» proksilarning qo‘ldagi rejimi."
    override val aliveLt = "tirik <"; override val aliveGt = "tirik >"
    override val periodWord = "davr"; override val nonstopWord = "to‘xtovsiz"
    override val batchWord = "pachka"; override val threadsWord = "oqimlar"; override val scanModeOff = "skan o‘chiq"
    override val netBattery = "Tarmoq va batareya"
    override val netBatteryHelp = "• Faqat Wi-Fi — mobil tarmoqda skanlamaslik (trafik tejaladi).\n• Faqat " +
        "zaryadda — faqat telefon zaryadlanayotganda ishlash.\n• Past zaryadda o‘tkazib yuborish — " +
        "batareya zaryadi past bo‘lganda skanni to‘xtatib turish."
    override val onlyWifi = "Faqat Wi-Fi"; override val onlyCharging = "Faqat zaryadda"; override val skipLowBattery = "Past zaryadda o‘tkazib yuborish"
    override val autosaved = "Sozlamalar avtomatik saqlanadi."
    override val dpiAutoLabel = "DPI-hiylalarni avto-saralash"; override val dpiNoneLabel = "DPI-hiylalarsiz (oddiy)"
    override val experimental = "Tajribaviy"
    override val experimentalHelp = "MTProto-proksiga muqobil proksilash dvigatellari va diagnostik log. " +
        "«O‘chiq» bo‘lganda etalon (ishlaydigan) yo‘l o‘zgarmaydi. Faqat shifrlangan oqimning apstrim " +
        "TCP-soketiga QANDAY yozilishi o‘zgaradi (segmentlar hajmi, tayming, TLS-record chegaralari) — oqimning o‘zi baytma-bayt aynan o‘sha. " +
        "Faqat proksi orqali tirik releyga qo‘llaniladi (probalarga emas, to‘g‘ridan-to‘g‘ri yo‘lga emas)."
    override val expEngineTitle = "Proksilash dvigateli (soket obfuskatsiyasi)"
    override val expConnectTitle = "Ulanish dvigateli (apstrim tanlash)"
    override val expEngineWarn = "⚠ Tajribaviy rejim. Agar aloqa yomonlashsa — «O‘chiq (etalon yo‘l)»ga qayting."
    override val netLog = "Tarmoq almashinuvi logini yoqish"
    override val netLogSub = "Faylga KIM-KIMGA-QACHON va paketlar hajmini yozadi (ma’lumot tarkibisiz) — " +
        "VPN bilan va usiz almashinuv xarakterini solishtirish uchun."
    override val openLogFolder = "Log papkasini ochish"; override val copyPath = "Yo‘lni nusxalash"
    override val helpShow = "Yordam"; override val helpHide = "Yordamni yashirish"
    override val quickSwitchIntro = "Bu yerda bloklarni chetlab o‘tish hiylasini tanlashingiz mumkin. Agar " +
        "Telegram “The proxy you are using is not configured correctly and will be disabled. Please find " +
        "another one” xatosini chiqarsa, Telegram uni ko‘rsatmasligi uchun qaysi trafik-obfuskatsiya turi " +
        "ishlashini tajriba yo‘li bilan tanlang. split* rejimlaridan boshlang. coalesce* rejimlari ham " +
        "ishlaydi, lekin ular bilan Telegramda rasm/video yomon yuklanadi."
    override val quickSwitchTitle ="Bloklarni chetlab o‘tish"; override val quickSwitchSub = "Bo‘lish, ulanish, anti-DPI"

    override val sourceUrl = "Manba URL"
    override fun sourceAlive(alive: Int, total: Int) = "tirik ${alive}/${total}"
    override val open = "Ochish"; override val active = "Faol"; override val inactive = "Nofaol"
    override val lastDownloaded = "Yuklangan"; override val notDownloaded = "hali yuklanmagan"
    override fun sourceCounts(dead: Int, total: Int) =
        " tirik, ${dead} o‘lik, ${total} jami"

    override val proxyBase = "Proksi bazasi"
    override val totalInBase = "Bazada jami"; override val aliveNow = "Hozir tirik"; override val deadStat = "O‘lik"
    override val aliveIn15 = "15 daqiqada tirik"; override val checksAllTime = "Butun vaqtdagi tekshiruvlar"
    override val antiDpiTricks = "Anti-DPI hiylalari"; override val noStatsYet = "hali ma’lumot yo‘q — hiylalar tekshiruvlar/ulanishlar davomida to‘planadi"
    override val attempts = "Urinishlar"; override val handshake = "Handshake"; override val score = "Ball"
    override val tgConnect = "TG-ulanish"; override val socketsOver1m = "Soketlar >1daq"
    override val over10kb = "Soketlar >10KB"; override val over100kb = ">100KB"; override val workTime = "Ish vaqti"
    override val statsLegend = "Handshake — muvaffaqiyatli qo‘l berishlar (urinishlardan %) · Ball — qiymat · " +
        "«Ish vaqti» — soketlar bo‘yicha ≥5KB va 1 daqiqadan uzunlar jami."
    override val resetStats = "Hiylalar statistikasini tiklash"

    override fun aliveLinks(n: Int) = "Tirik havolalar: ${n}"
    override val copyAll = "Hammasini nusxalash"
    override val openRandom = "Tasodifiyni ochish"; override val copyRandom = "Tasodifiyni nusxalash"; override val allShort = "HAMMASI"
    override val copyTop = "TOP nusxalash"; override val randomHost = "Tasodifiy xost"
    override val exportToFile = "Faylga eksport"; override val exportSaved = "Faylga saqlandi:"
    override val dlNow = "Hozir yuklash"
    override fun downloadingFmt(sec: Long) = "Yuklanmoqda… ${sec}s"
    override val cancel = "Bekor qilish"
    override val deleteConfirmTitle = "Obunani o‘chirishmi?"
    override val subscriptionsAddHint = "Obunalar yoki proksi-havolalar qo‘shing →"
    override val addSourcesTitle = "Qo‘shish"
    override val addSubsLabel = "Obunalar (har satrda bitta URL)"
    override val addSubsHelp = "To‘g‘ri URL bo‘lgan har bir satr alohida obunaga aylanadi va vaqti-vaqti bilan yuklanadi."
    override val addProxiesLabel = "Tayyor proksi-havolalar (fiks ro‘yxat)"
    override val addProxiesHelp = "Aniq proksilarga havolalar pachkasini joylashtiring (tg://proxy, https://t.me/proxy, …). Bu obuna EMAS — ro‘yxat yuklanmaydi, proksilar shunchaki katalogga qo‘shiladi."
    override val addButton = "Qo‘shish"
    override fun addedFmt(subs: Int, proxies: Int) = "Qo‘shildi: ${subs} obuna, ${proxies} proksi"
    override val perSecond = "soniyasiga"
    override val graphSpeed = "Tezlik"
    override val graphVolume = "Hajm"
    override val graphLatency = "Ping"
    override val graphConnects = "Ulanishlar"
    override val scanNow = "Hozir skanlash"; override val scanOnShort = "Skan yoqilgan"
    override val scanRunning = "Skan ketmoqda"; override val scanIdle = "Skan idle"; override val scanOffState = "Skan OFF"; override val scanBatchPerThread = "Pachka/oqim"; override val scanPassHosts = "O‘tishdagi xostlar"; override val minRescanLabel = "Xostni N daqiqada bir martadan tez-tez skanlamaslik"
    override val scanPlanTitle = "Reja"; override val scanNowTitle = "Hozir"; override val currentScheduleTitle = "Joriy jadval"
    override val scheduleWord = "Jadval"; override val unitPcsPerSec = "dona/s"
    override val scanNowThreadsLabel = "Hozir ishga tushgan oqimlar"; override val scanNowPerThreadLabel = "1 oqimga tekshiruv (reja)"; override val scanNowElapsedLabel = "Ish vaqti"
    override val scanOkGraph = "Muvaffaqiyatli skanlar"; override val scanFailGraph = "Muvaffaqiyatsiz skanlar"; override val scanTrafficGraph = "Skan trafigi"; override val scanAliveGraph = "Jami tirik proksilar"; override val scanPingGraph = "Ping"; override val threadsGraph = "Oqimlar"
    override val scanEvery = "Davr"; override val scanNextRun = "Keyingi ishga tushish"
    override val scanThreads = "Oqimlar"; override val scanBatch = "Pachkada"
    override val scanElapsed = "Ishlamoqda"; override val scanIdleNow = "—"
    override val effForFew = "«Kam»da"; override val effForMany = "«Ko‘p»da"
    override val effCheck = "Tekshiruv"; override val effBatch = "Pachka"; override val effPar = "Parallel"
    override val effContinuous = "uzluksiz"; override val secShort = "s"; override val minShort = "daq"

    override val appTagline = "Kross-platformali avto-konnektor: o‘zi Telegram ishlaydigan MTProto " +
        "proksilarni topadi, tekshiradi va ko‘taradi."
    override val version = "Versiya"; override val buildDate = "Build sanasi"
    override val downloadSources = "Yuklab olish va manbalar"; override val openOnGithub = "GitHub da ochish"
    override val feedbackBugs = "Fikr-mulohaza va bag-hisobotlar"; override val writeTelegram = "Telegramga yozish"

    override val language = "Til"; override val langAuto = "Avto (tizimdagidek)"; override val langRu = "Русский"; override val langEn = "English"
    override val langWord = "Til"
    override val raceWidthTitle = "Parallel ulanishlar"
    override val connectionSection = "Ulanish va bloklarni chetlab o‘tish"
    override val connectionSectionHelp = "Ulanish dvigateli, parallel apstrimlar soni, proksilash dvigateli va anti-DPI hiylalari — barchasi bitta bo‘limda."
    override val netLogSection = "Tarmoq almashinuvi logi"
    override val platform = "Platforma"

    override val scanModeTitle = "Tarmoq rejimi"; override val scanModeAuto = "Avto"; override val scanModeManualLabel = "Qo‘lda"
    override val activeModeLabel = "Faol rejim"; override val formingListLabel = "Ro‘yxat shakllanmoqda"; override val catalogModeTabs = "Rejim"
    override val resetModeRatings = "Xost reytinglarini tiklash"; override val forgetModeHosts = "Rejim xostlarini unutish"
    override val exportModeTitle = "Rejimlar bo‘yicha eksport"; override val modePickerTitle = "Rejim"
    override val modeHelp = "Har bir tarmoq rejimida — alohida proksi reytingi va o‘ziga xos skanlash hamda obuna yuklash intensivligi. «Avto» rejimni faol tarmoq bo‘yicha aniqlaydi. «Qo‘lda» — rejimni o‘zingiz belgilaysiz (jumladan White, uni avto hech qachon tanlamaydi)."
    override val autoSelect = "Avto tanlash"; override val manualSelect = "Qo‘lda tanlash"
    override val connStatsTitle = "Hozir ulanishlar"; override val connOnPort = "Portdagi ulanishlar"; override val outgoingConns = "Chiquvchi ulanishlar"
    override val modeChoice = "Rejim tanlash"; override val autoChoice = "avto tanlash"; override val manualChoice = "qo‘lda qat’iy"
    override val directOnVpn = "VPN da TG ga to‘g‘ridan-to‘g‘ri ulanish"; override val onWord = "yoq"; override val offWord = "o‘chiq"
    override val directStateActive = "faol"; override val directStateOff = "sozlamalarda o‘chirilgan"; override val directStateIdle = "sozlamalarda yoqilgan, lekin faol emas"
    override val wpHintTitle = "White nima?"
    override val wpHint = "White — WhitePages: qo‘ldagi tarmoq rejimi. Faqat qo‘lda yoqiladi (avto-tanlash uni qo‘ymaydi). " +
        "Alohida xost reytingini yuritadi, obunalarni yuklaydi va VPN/Wi-Fi/LTE dan mustaqil ravishda skanlaydi."

    // tray
    override val trayOpenWindow = "Oynani ochish"
    override val trayRefreshSubs = "Obunalarni yangilash"
    override val trayExit = "Chiqish"
    override fun trayConnectorLabel(on: Boolean) =
        if (on) "Konnektor: YONIQ (o‘chirish)" else "Konnektor: O‘CHIQ (yoqish)"
    override fun trayScanLabel(on: Boolean) =
        if (on) "Skan: YONIQ (o‘chirish)" else "Skan: O‘CHIQ (yoqish)"
    override fun trayLive(n: Int) = "Tirik proksilar: ${n}"
    override val appearance = "Ko‘rinish"
    override val themeLabel = "Mavzu"
    override val themeAuto = "Avto (tizimga mos)"
    override val themeLight = "Yorug‘"
    override val themeDark = "Qorong‘i"
    override val drawGraphsLabel = "Grafiklarni chizish"
    override val drawGraphsSub = "Ulagich va Skanerlash bo‘limlarida jonli grafiklar — batareyani tejash uchun o‘chiring"
}
