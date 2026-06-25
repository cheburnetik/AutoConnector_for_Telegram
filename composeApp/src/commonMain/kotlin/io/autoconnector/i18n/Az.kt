package io.autoconnector.i18n

object Az : Strings by En {
    override val tabConnector = "Konnektor"; override val tabScan = "Skan"
    override val tabCatalog = "Kataloq"; override val tabLogs = "Loglar"; override val tabMore = "Daha çox"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "Abunəliklər"; override val logTabScan = "Skan"
    override val logGeneral = "Ümumi"; override val logEmpty = "hələlik boşdur"
    override val logSessions = "Sessiyalar"; override val logErrorsOnly = "yalnız xətalı"; override val logNoErrors = "xətalı sessiya yoxdur"
    override fun logSession(id: String, port: String) = "№${id} · :${port}"
    override val back = "Geri"; override val copy = "Kopyala"; override val gotIt = "Anladım"
    override val later = "Sonra"; override val details = "Ətraflı"; override val whatIsThis = "Bu nədir?"
    override val delete = "Sil"

    override val connector = "Konnektor"; override val scan = "Skan"
    override val notConfigured = "Quraşdırılmayıb! Düzəlt →"; override val howToSetup = "Necə quraşdırmalı"
    override val notifOff = "Bildirişlər söndürülüb! Düzəlt →"; override val enable = "Aktivləşdir"
    override fun fewProxies(n: Int) = "Canlı proksilər ${n}, axtarıram, gözləyin ~15 dəq…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "Canlı proksilər: ${alive}  (15 dəq: ${within}) · cəmi: ${total}"
    override val notifWhyTitle = "Bildirişlər nəyə lazımdır?"
    override val notifWhyBody = "Daimi nişanlı bildiriş — Android foreground servisidir. " +
        "Onsuz sistem tətbiqi yaddaşdan boşaldır və o, proksi axtarmağı və fonda " +
        "bağlantını saxlamağı dayandırır. Buna görə bildirişlər AutoConnector-un işləməsi üçün vacibdir."
    override val notifEnableTitle = "Bildirişləri aktivləşdirin"
    override val notifEnableBody = "Bildiriş nişanı olmadan Android tətbiqi qeyri-aktiv sayır və " +
        "onu yaddaşdan boşaldır. Onda AutoConnector proksi axtarmağı və fonda bağlantını saxlamağı " +
        "dayandırır — Telegram əlaqəni itirir.\n\n\"Aktivləşdir\"ə toxunun və AutoConnector üçün " +
        "bildirişlərə icazə verin."
    override val notifPlea = "Bildirişləri aktivləşdirin! Onlarsız tətbiq fonda işləyə bilməz — " +
        "Android onu boşaldacaq, proksi axtarışı və bağlantı dayanacaq."

    override val statusConnected = "Telegram qoşuldu"; override val statusConnecting = "Qoşulur…"
    override val statusOffline = "Telegram qoşulmayıb"; override val statusIdle = "Telegram susur"
    override val nobodyConnected = "Konnektora heç kim qoşulmayıb. "; override val howToSetupArrow = "Necə quraşdırmalı →"
    override val directModeViaVpn = "Birbaşa rejim: VPN aktivdir — proksisiz"
    override val directModeOff = "Birbaşa rejim: proksilər söndürülüb"
    override val directDpiSuffix = " · anti-DPI"
    override val connections = "Bağlantılar"; override val sockets = "Soketlər"; override val speed = "Sürət"
    override val traffic = "Trafik"; override val latency = "Gecikmə"
    override fun pcs(n: Int) = "${n} əd"
    override fun netNow(label: String) = "Şəbəkə: ${label}"
    override fun tgToConnector(n: Int) = "TG→ ${n}"
    override fun connectorToProxy(n: Int) = "proksi ${n}"
    override val trafficSec = "trafik · 60 saniyə"; override val trafficMin = "trafik · 60 dəqiqə"
    override val latencySec = "gecikmə · 60 saniyə"; override val latencyMin = "gecikmə · 60 dəqiqə"
    override val sec60 = "60 saniyə"; override val min60 = "60 dəqiqə"
    override val unitSec = "san"; override val unitMin = "dəq"; override val unitHour = "saat"; override val dash = "—"
    override val currentProxy = "Cari proksi"; override val noActiveProxy = "aktiv proksi yoxdur (Telegram qoşulmayıb)"
    override val host = "Host"; override val type = "Növ"; override val secret = "Sirr"; override val antiDpi = "Anti-DPI"; override val obfEngine = "Obfuskasiya mühərriki"
    override fun activeSockets(n: Int) = "Aktiv Telegram soketləri: ${n}"
    override val noConnections = "aktiv bağlantı yoxdur"; override val colHost = "Host"; override val colTime = "Vaxt"
    override val modeWord = "Rejim"; override val directViaVpnLine = "Telegram-a birbaşa sorğular (VPN aktivdir)"
    override val connModeHelp = "Rejimlər (VPN, Wi-Fi, LTE, Ethernet, White) skan intensivliyini fərqli tənzimləməyə imkan verir və hostların ayrıca reytinqini/statistikasını aparır. Şəbəkə kartı avtomatik müəyyən edilir; rejim ayarlardan əl ilə təyin edilə bilər."

    override val scanOff = "Skanlama söndürülüb"; override val proxiesInBase = "Bazadakı proksilər"
    override val total = "cəmi"; override val alive = "canlı"; override val dead = "ölü"
    override val tgConnectedTitle = "Telegram qoşulurdu"; override val successful = "uğurlu"
    override val socketsHeld = "Soketlər nə qədər saxlandı"; override val over1m = ">1 dəq"; override val over5m = ">5 dəq"; override val over15m = ">15 dəq"
    override val scanCountTitle = "Proksi yoxlamalarının sayı"; override val checked = "Yoxlanıldı"
    override val forAllTime = "bütün vaxt"; override val perMinute = "dəqiqəyə"; override val perHour = "saata"
    override val subsCountTitle = "Abunəlik yükləmələrinin sayı"; override val downloaded = "yükləndi"; override val failed = "uğursuz"; override val scanTraffic = "skan trafiki"; override val subTraffic = "abunəlik trafiki"; override val subTrafficGraph = "Abunəlik trafiki"
    override val checksMtproto = "MTProto yoxlamaları (↑ ok · ↓ fail)"

    override fun catalogEmpty(mode: String) = "Kataloq ${mode} hələlik boşdur. Ya heç bir host tapılmayıb, ya da tətbiq heç vaxt bu rejimdə işləməyib. Rejimi ayarlardan dəyişmək olar. Rejimlər internetə müxtəlif qoşulma növləri üçün hostları ayrıca toplamaq üçün düşünülüb."
    override val aliveShort = "✓ canlı"; override val deadShort = "✗ ölü"
    override val statusLabel = "Status"; override val rating = "Reytinq"; override val port = "Port"
    override val rttPing = "RTT (ping)"; override val checkedField = "Yoxlanıldı"; override val okOfTotal = "Uğurlu / ümumi yoxlama"
    override val tgConnectedField = "Telegram qoşulurdu"; override val tgSessions = "Telegram sessiyaları"; override val trafficThroughProxy = "Proksi vasitəsilə trafik"
    override val sessionsTotal = "Sessiyalar cəmi"; override val relayNow = "İndi relay"; override val tlsDomain = "TLS domeni (SNI)"
    override val sourceSub = "Mənbə (abunəlik)"; override val lastError = "Son xəta"; override val yes = "bəli"; override val no = "xeyr"
    override val copyAsLink = "Link kimi kopyala"; override val openInTelegram = "Hostu Telegram-da aç"; override val makeNextRelay = "Növbəti relay et"
    override val actCopy = "Kopyala"; override val actOpen = "Aç"; override val actRelay = "Relay"
    override fun agoFmt(v: String) = "${v} əvvəl"
    override val recentAttempts = "Son qoşulmalar və yoxlamalar"
    override val kindCheck = "yoxlama"
    override val kindTg = "telegram"
    override val histWho = "Kim"
    override val histWhen = "Nə vaxt"
    override val histReq = "Sorğu"
    override val histSess = "Sessiya"
    override val histScan = "skan"
    override val testNow = "İndi test et"
    override val testShort = "Test"
    override val testResult = "Test nəticəsi"
    override val testStop = "Stop"
    override val testingNow = "test gedir…"
    override val prewarmTitle = "Soketlərin qızdırılması (eksperiment)"
    override val prewarmHelp = "Proksiyə əvvəlcədən bir neçə açıq soket saxlamaq ki, Telegram-ın yeni " +
        "bağlantısı qoşulma/handshake mərhələsini atlasın. Eksperimentaldır: fon daim " +
        "yenidən qoşulur → trafik və bir az CPU sərfi. Saxta trafik göndərilmir (o, " +
        "real sessiyanı pozardı) — soketlər sadəcə rotasiya olunur. Ən faydalısı FakeTLS proksilərlədir."
    override val prewarmEnable = "Qızdırmanı aktivləşdir"
    override val prewarmModeDeferred = "Təxirə salınmış (yalnız TLS)"
    override val prewarmModeDeferredSub = "TCP + FakeTLS saxlayırıq; obfuscated2-init ötürmə zamanı göndərilir. DC commit olunmur — ən real variant."
    override val prewarmModeFull = "Tam handshake"
    override val prewarmModeFullSub = "Müxtəlif DC-lərə tam qoşulmuş soketləri saxlayırıq; yalnız DC/tag uyğun gələndə təkrar istifadə edirik. Daha az yaşayır."
    override val prewarmPoolLabel = "Ehtiyat soketlər"
    override val prewarmHoldLabel = "Saxla, san"
    override val prewarmNote = "Yalnız rotasiya (tətbiq səviyyəsində keepalive yoxdur). Soket saniyələr…~bir dəqiqə yaşayır, proksi/DC-dən asılıdır."
    override val prewarmStatus = "Qızdırma"
    override fun prewarmStatusVal(ready: Int, holdSecs: Int) = "${ready} hazır · ${holdSecs}san saxlayıram"
    override val prewarmStar = "Qalın narıncı = soket qızdırma hovuzundan isti verilib (qoşulma/handshake olmadan)"
    override fun prewarmTableTitle(holdSecs: Int) = "Soketlərin qızdırılması (${holdSecs}san saxlayıram)"
    override val prewarmTableHelp = "\"Soketlərin qızdırılması\" proksiyə əvvəlcədən bir neçə soket açır ki, Telegram-ın yeni " +
        "bağlantısı qoşulma/handshake mərhələsini atlasın. Bu cədvəldə qızdırılan hostlar göstərilir: soket neçə saniyə " +
        "yaşayır, Telegram onu istifadə edirmi və trafik. Aktivləşdirmək/söndürmək və tənzimləmək (rejim, soket sayı, " +
        "saxlama vaxtı) \"Daha çox → Ayarlar → „Soketlərin qızdırılması (eksperiment)“\"-dən mümkündür."
    override val prewarmNoneWarming = "hələlik qızdırılan soket yoxdur"
    override val prewarmColAge = "yaşayır"
    override val prewarmColUse = "TG-də?"
    override val prewarmInUse = "TG-də"
    override val prewarmNew = "yeni"
    override val lanShareTitle = "Lokal şəbəkədə paylaşım (veb-portal)"
    override val lanShareDesc = "Bu Wi-Fi-dakı digər cihazlara bu AutoConnector-u proksi kimi istifadə etməyə icazə verin; aşağıdakı ünvanda brauzer ən yaxşı proksilərlə səhifə alacaq."
    override val lanShareUrlsLabel = "Şəbəkə qonşuları qoşulur:"
    override val lanShareNoIp = "lokal şəbəkədə ünvan yoxdur — Wi-Fi-yə qoşulun"
    override val lanFirewallTitle = "Lokal şəbəkədə icazə ver"
    override val lanFirewallBody = "Aktivləşdirildikdə relay portları lokal şəbəkəyə açılacaq. İndi Windows (və ya digər) firewall AutoConnector-a icazə verməyi soruşa bilər — \"İcazə ver\"/\"Bəli\" seçin. Qadağan etsəniz, qonşuların AutoConnector-a trafiki bloklanacaq və səhifə/proksi əlçatmaz olacaq."
    override val lanFirewallConfirm = "Aktivləşdir"
    override val lanInfoTitle = "Bu nəyə lazımdır?"
    override val lanInfoBody = "AutoConnector-u Wi-Fi-nizdəki BİR kompüterdə və ya telefonda işə salın — və eyni şəbəkədəki bütün digər cihazlar, o cümlədən iPhone (tətbiq onu birbaşa dəstəkləmir), sadəcə brauzerdə ünvanı açıb istifadə edə bilər: Telegram-larına əlavə etmək üçün ən yaxşı proksilərlə səhifə, ya da bu cihazın özü SOCKS-proksi kimi. Bir cihaz proksiləri tapıb saxlayır, qalanları onu lokal şəbəkə üzərindən istifadə edir."
    override val volTriggerTitle = "Səs düymələri ilə triqqer"
    override val volTriggerSub = "Səs düymələrinin sürətli paterni ilə proksi dəyişdirmə"
    override val volEnableLabel = "Səs düymələrini izlə"
    override val volHelpTitle = "Bu nədir?"
    override val volHelpBody = "Android-də qlobal klaviatura hotkeyləri yoxdur, ona görə SƏS düymələri istifadə olunur. Aktiv olduqda, AutoConnector fonda səs-yuxarı/aşağı düymələrinin sürətli paternini izləyir (məsələn yuxarı-yuxarı-aşağı-aşağı). Onu tanıyanda təsadüfi yaxşı canlı proksinin tg:// linkini açır — Telegram onu tutub keçir. Tətbiqi açmadan proksiləri rotasiya etmək üçün sürətli və gözəgörünməz üsul. Səs adi qaydada işləyir (basışlar tutulmur). Əlçatımlılığa (Accessibility) giriş lazımdır (fonda düymələri oxumaq və linki açmaq üçün); siz qutunu işarələyənə qədər heç nə tələb olunmur. Aşağıda basışlar arasındakı maksimum vaxtı təyin edin; tanınan paternlər aşağıda sadalanır."
    override val volGrantTitle = "Əlçatımlılığı (Accessibility) aktivləşdirin (vacib)"
    override val volGrantBody = "Android (xüsusən 13+) Google Play XARİCİNDƏN quraşdırılan tətbiqlər üçün Accessibility-ni bloklayır — buna görə AutoConnector boz görünür və \"Tətbiq üçün giriş qadağandır\" yazır.\n\nNecə blokdan çıxarmalı:\n1. \"Tətbiq haqqında\"nı açın (aşağıdakı düymə, ya da: Ayarlar → Tətbiqlər → AutoConnector for Telegram).\n2. ⋮ (yuxarı sağda üç nöqtə) → \"Məhdud ayarlara icazə ver\" → təsdiqləyin.\n3. Qayıdın: Ayarlar → Əlçatımlılıq (Accessibility) → AutoConnector for Telegram → aktivləşdirin.\n\nƏgər \"Məhdud ayarlara icazə ver\" bəndi yoxdursa — əvvəlcə bir dəfə Accessibility-də keçidi aktivləşdirməyə cəhd edin (qadağa mesajı çıxacaq), sonra 2-ci addım əlçatan olacaq.\n\nXiaomi/MIUI, Samsung və s.-də yol bir az fərqlənə bilər — \"Tətbiq haqqında\"da eyni ⋮-ni axtarın. Android 12 və daha köhnələrdə adətən məhdudiyyət yoxdur — dərhal aktivləşdirin.\n\nSəs düymələri yalnız oxunur, heç vaxt bloklanmır."
    override val volOpenAppInfo = "\"Tətbiq haqqında\"nı aç"
    override val volAccessOn = "Əlçatımlılıq: aktivdir"
    override val volAccessOff = "Əlçatımlılıq: söndürülüb"
    override val volOpenAccess = "Əlçatımlılıq ayarlarını aç"
    override val volGapLabel = "Basışlar arası maks. ms"
    override val volPatternsTitle = "Tanınan paternlər"
    override val volPatternPick = "Patern"
    override val volPatternsLegend = "↑ = səs yuxarı, ↓ = aşağı"
    override val volNoRights = "Tətbiqin hələ səs düymələrini emal etmək hüququ YOXDUR — səhifənin aşağısındakı təlimata uyğun giriş verin."
    override val volGrantShort = "Əlçatımlılığa giriş hələ yoxdur. Bu səhifənin aşağısındakı ətraflı təlimatı oxuyun və \"Yoxla\"ya basın."
    override val volCheck = "Yoxla"
    override val volCheckOk = "✓ Hazır — giriş verildi, triqqer işləyir."
    override val volCheckFail = "✗ Giriş hələ yoxdur — yuxarıdakı addımları yerinə yetirin."
    override val volPatternsList = "↑↑↓↓ · ↓↓↑↑ · ↑↓↑↓ · ↓↑↓↑ · ↑↑↑↑ · ↓↓↓↓ · ↑↓↓↑ · ↓↑↑↓ · ↑↑↑↓↓↓ · ↓↓↓↑↑↑   (↑ = səs yuxarı, ↓ = aşağı)"
    override val histLegend = "Sütunlar — Kim: ✓/✗ TG = real Telegram qoşulması, skan = fon yoxlaması. Nə vaxt: nə qədər əvvəl. TCP/TLS/Sorğu: handshake və ilk sorğunun gecikmələri, ms. Sessiya: relay sessiyası nə qədər davam etdi. ↓/↑: host vasitəsilə qəbul / göndərilmiş bayt."
    override val tgOkTotalHint = "Telegram qoşulmaları / uğurlu / ümumi yoxlama"
    override val breadthTitle = "Host seçiminin genişliyi"
    override val breadthHelp = "Solda — ən yaxşı yoxlanmış hostlardan yapışmaq; sağda — mümkün qədər geniş müxtəlif canlı hostları sınamaq. Telegram relay portları arasında atılanda, tətbiq seçimi avtomatik genişləndirir."
    override val breadthNarrow = "yoxlanmış"
    override val breadthWide = "geniş"
    override val connTimeoutTitle = "Hosta qoşulma taymautu"
    override val connTimeoutHelp = "Növbəti proksini sınamazdan əvvəl bir apstrimi (TCP + TLS + ilk MTProto cavabı) nə qədər gözləmək."
    override val catalogTopFor = "Proksi siyahısı/reytinqi:"
    override val catalogModeHelpTitle = "Rejimlər və reytinqlər"
    override val catalogModeHelp = "Tətbiq canlı hostları və onların reytinqini hər şəbəkə rejimi üzrə AYRICA sayır (VPN, Wi-Fi, LTE, Ethernet və White). \"White\" — ağ siyahılar üçün ayrıca ƏL ilə rejimdir; avto heç vaxt ona keçmir. Buna görə eyni host bir rejimdə canlı, başqasında ölü ola bilər."
    override fun catalogInactiveWarn(section: String, active: String) =
        "İndi siz qeyri-aktiv ${section} bölməsinə baxırsınız — bütün statistika indi bura yox, ${active}-ə yığılır."
    override val manageModeTitle = "Rejimin idarəsi"
    override val manageResetRating = "Reytinqi sıfırla"
    override fun manageResetHint(mode: String) = "Xüsusi olaraq ${mode} üçün canlı hostların reytinqini və istifadə statistikasını sıfırlaya bilərsiniz. Bu, prinsipcə başqa VPN və ya LTE-yə qoşulduqda köhnə statistikanın təsir etməməsi üçün faydalıdır. Ya da proksi skanının hər şeyi sıfırdan necə sürətlə yoxladığını izləmək üçün."
    override val manageDeleteAll = "Hostları sil:"
    override fun manageDeleteHint(mode: String) = "${mode} rejimindən həm reytinqi, həm də hostların özlərini təmizləyə bilərsiniz. \"Proksi skanı\" funksiyası onları yenidən yığacaq. Bu, abunəliklərin sıfırlanması deyil — basa bilərsiniz, sonra təkrar skan üçün ~15 dəqiqə gözləyin."
    override fun manageCopyFrom(mode: String) = "Bütün hostları və reytinqləri başqa rejimdən bu rejimə (${mode}) kopyala:"
    override val live = "canlı"; override val deadW = "ölü"; override val unitMs = "ms"
    override val agoMin = "d"; override val agoHour = "s"; override val agoDay = "g"

    override val connectTelegram = "Telegram qoşulması"; override val readCarefully = "Diqqətlə oxuyun!"
    override val guideIntro = "Quraşdırma olmadan bu tətbiq işləməyəcək. Aşağıdakı 3 variantdan istənilən " +
        "birini seçin və təlimatı diqqətlə yerinə yetirin."
    override val variant1 = "Variant №1 — düymələrlə"
    override val variant1Body = "\"Proksi {A}\" düyməsinə basın — Telegram açılacaq, proksinin əlavə " +
        "edilməsini təsdiqləyin. Bu ekrana qayıdın və \"Proksi {B}\"yə basın — ikinci dəfə əlavəni " +
        "təsdiqləyin.\n\nTelegram-da bütün digər köhnə proksiləri söndürün. Tam olaraq 2 proksi qalmalıdır " +
        "— {A} və {B} portları ilə. Hər hansı başqa dəstdə AutoConnector işləməyəcək."
    override val variant2 = "Variant №2 — linklərlə"
    override val variant2Body = "Aşağıdakı mətni Telegram-da \"Seçilmişlər\"ə (və ya istənilən çata) " +
        "kopyalayın — yəni özünüzə göndərin. Mesajınızdakı ilk linkə basın — birinci proksi əlavə " +
        "olunur. İkinci linkə basın — ikinci əlavə olunur. Sonra bütün köhnə proksiləri söndürün."
    override val variant3 = "Variant №3 — əl ilə"
    override val variant3Body = "Əl ilə SOCKS5 proksi əlavə edin: server localhost (127.0.0.1), port {A}. " +
        "Sonra ikinci proksi: localhost, port {B}. Bütün köhnə proksiləri silin."
    override val whatNext = "Bəs sonra nə?"
    override val whatNextBody = "Telegram-da \"proksini avto-keçirməni\" aktivləşdirin — 5 saniyə. " +
        "Telegram-a qoşulmağa kömək etmək üçün AKTIV OLMAYAN və ya \"əlçatmaz\" işarələnmiş proksiyə " +
        "(Telegram-ın içində) əl ilə basa bilərsiniz — bu, Telegram-ın daha çox qoşulma cəhdi etməsinə " +
        "səbəb olur.\n\nƏmin olun ki, {A} və {B} istisna olmaqla bütün digər köhnə proksilər silinib. " +
        "Telegram-da \"Proksini istifadə et\"ə basın.\n\nTətbiq kifayət qədər proksi tapıb yükləyənə " +
        "qədər gözləyin (5–15 dəqiqə). Sonra Telegram özü AutoConnector-a qoşulacaq, o isə Telegram-ı " +
        "hər dəfə ən sərfəli proksilərə yönləndirəcək: yoxlanmış, canlı və sürətli.\n\nƏgər təlimat " +
        "çətin görünürsə — təəssüf, tətbiqi istifadə edə bilməyəcəksiniz: hər şeyi avtomatik quraşdırmaq " +
        "mümkün deyil, canlı proksiləri tapmaq isə vaxt aparır.\n\nƏgər tətbiqi çoxdan yükləmisinizsə " +
        "və canlı proksi tapılmayıbsa — ya tətbiqi, ya da abunəlik siyahısını yeniləyin. Bu tətbiq " +
        "proksiləri özü uydurmur və öz proksilərini təqdim etmir, sadəcə internetdə onlarla qrup və " +
        "səhifə arasında axtarır."
    override fun proxyBtn(port: Int) = "Proksi ${port}"

    override val setupPortsTitle = "Telegram-da portların quraşdırılması"
    override val setupPortsSub = "Telegram-ı Konnektora necə qoşmalı (portlar 55001/55002)"
    override val settings = "Ayarlar"; override val settingsSub = "Portlar, anti-DPI, skan, şəbəkə, batareya"
    override val subscriptions = "Abunəliklər"; override val subscriptionsSub = "Skan üçün proksi mənbələri"
    override val statistics = "Statistika"; override val statisticsSub = "Proksi bazası + anti-DPI fəndləri"
    override val export = "İxrac"; override val exportSub = "Canlı proksilərin tg:// linkləri"
    override val about = "Proqram haqqında"; override val aboutSub = "Versiya, build, yükləmə, geribildirim"
    override val hotkeys = "Qaynar düymələr"
    override val hotkeysSub = "Qlobal düymələr: proksini kopyala / aç"
    override val hotkeysIntro = "Qlobal qaynar düymələr tətbiq pəncərəsi fokusda olmadıqda belə işləyir. " +
        "Onlar bazadan təsadüfi canlı proksi-linki (tg://) götürür. Tətbiqi açmadan proksiləri sürətlə " +
        "dəyişmək üçün rahatdır."
    override val hotkeysNote = "macOS-da düymələri tutmaq üçün Əlçatımlılıq (Accessibility) icazəsi " +
        "lazım ola bilər (Sistem Ayarları → Məxfilik və Təhlükəsizlik → Accessibility)."
    override val hotkeyCopyTitle = "Proksi linkini kopyala"
    override val hotkeyCopyDesc = "Mübadilə buferinə təsadüfi canlı tg:// link qoyur."
    override val hotkeyEnable = "Qaynar düymələri aktivləşdir"; override val hotkeyLetterLabel = "Hərf"; override val hotkeySet = "Təyin et"; override val hotkeyReset = "Sıfırla"
    override val hotkeyOpenTitle = "Proksini Telegram-da aç"
    override val hotkeyOpenDesc = "Təsadüfi canlı linki açır — Telegram onu tutub proksini qoşmağı təklif edir."

    override val relayPorts = "Relay portları"
    override val relayPortsHelp = "Konnektorun dinlədiyi lokal portlar. Məhz onları Telegram-da SOCKS5 " +
        "proksi kimi göstərirsiniz (127.0.0.1 : port). İki port etibarlılıq üçün lazımdır — Telegram " +
        "hər ikisinə bağlantı saxlayır."
    override val portA = "Port A"; override val portB = "Port B"
    override val antiDpiTrick = "Anti-DPI fəndi"
    override val antiDpiHelp = "Bağlantını maskalamaq üsulu ki, provayder/DPI onu tanıyıb bloklamasın.\n" +
        "• \"Avto-seçim\" özü işləyən fəndi tapır.\n• \"DPI fəndsiz\" — adi bağlantı.\n• Qalanları " +
        "konkret üsullardır (brauzer imitasiyası, paketlərin bölünməsi və s.)."
    override val onlyFakeTls = "Yalnız FakeTLS (ee)"
    override val applyDpiTo = "Anti-DPI-ni tətbiq et:"
    override val applyDpiHelp = "Seçilmiş anti-DPI fəndini nəyə tətbiq etmək:\n• Telegram relayına — " +
        "Konnektor vasitəsilə canlı Telegram bağlantısına.\n• Proksi zondlarına — fon proksi " +
        "yoxlamalarına (onda yoxlama real bağlantı kimi davranır və fənd statistikası daha dəqiq olur).\n" +
        "• Birbaşa qoşularkən — proksilər söndürüldükdə (və ya VPN açıq olanda atılanda) və Telegram " +
        "birbaşa serverlərə gedəndə: burada proksi yoxdur, ona görə fənd ilk TCP paketinin (handshake) " +
        "bir neçə kiçik seqmentə bölünməsinə gəlib çıxır ki, DPI onu bir oxumada tanımasın."
    override val toRelay = "Telegram relayına"; override val toProbes = "Proksi zondlarına"
    override val toDirect = "Birbaşa qoşularkən"
    override val vpnSection = "VPN açıq olanda"
    override val vpnHelp = "Cihazda VPN aktiv olanda nə etmək:\n• MTProto proksi vasitəsilə — Telegram " +
        "həmişəki kimi tapılan proksilərdən keçir (VPN-in üstündən).\n• Birbaşa — Konnektor proksiləri " +
        "İSTİFADƏ ETMİR və Telegram-ı birbaşa Telegram serverlərinə qoşur: VPN artıq giriş verir, " +
        "əlavə proksi qatı lazım deyil (daha sürətli və sabit). VPN-siz proksilər həmişəki kimi istifadə olunur."
    override val linkFormat = "Proksi link formatı"
    override val linkFormatHelp = "Proksiləri necə kopyalamaq və açmaq. tg:// birbaşa Telegram-da açılır (quraşdırılmış Telegram Desktop lazımdır). http (t.me) brauzer vasitəsilə açılır və Telegram-da açmağı təklif edir — tg:// işləmirsə faydalıdır."
    override val linkTg = "tg:// (birbaşa Telegram-da)"; override val linkTgSub = "tg://proxy?… — Telegram-ı açır"
    override val linkHttp = "http (t.me, brauzer vasitəsilə)"; override val linkHttpSub = "https://t.me/proxy?… — brauzeri açır"
    override val viaMtproto = "MTProto vasitəsilə proksiləmə"; override val viaMtprotoSub = "VPN-də belə trafik proksilərdən keçir"
    override val directly = "Birbaşa proksiləmə"; override val directlySub = "VPN aktiv olanda — proksiləri ötərək, birbaşa Telegram-a"
    override val notifications = "Bildirişlər"
    override val scanCheck = "Skan və yoxlama"
    override val scanCheckHelp = "• Skan, dəq — proksi siyahılarını abunəliklərdən nə qədər tez-tez yükləmək.\n" +
        "• Yoxlama, dəq — bazadakı proksiləri canlılığa nə qədər tez-tez təkrar yoxlamaq.\n• Paket ölçüsü — " +
        "bir keçiddə neçə proksi yoxlamaq.\n• Paralel — neçə yoxlamanı eyni anda aparmaq (çox = daha sürətli, " +
        "amma şəbəkə və batareyaya yük daha yüksək)."
    override val scanMin = "Skan, dəq"; override val checkMin = "Yoxlama, dəq"; override val batchSize = "Paket ölçüsü"; override val parallel = "Paralel"
    override val speedByNet = "Şəbəkəyə görə skan intensivliyi"
    override val speedByNetHelp = "Cari şəbəkədən asılı olaraq proksiləri nə qədər tez-tez yoxlamaq. " +
        "\"Standart\" = baza interval. Sağa sürüşdürmə — daha nadir (yavaş, trafik/batareyaya qənaətli), " +
        "sola — daha tez-tez (sürətli, aqressiv). Loqarifmik şkala, hər tərəfə ×100-ə qədər.\n" +
        "• VPN — xarici VPN aktiv olanda.\n• Wi-Fi — Wi-Fi şəbəkəsində.\n• LTE — mobil şəbəkədə."
    override val intensStandard = "standart"
    override val intensSlower = "daha yavaş"
    override val intensFaster = "daha sürətli"
    override val maintenance = "Məlumatların sıfırlanması"
    override val maintenanceHelp = "• \"Kataloqu və statistikanı sıfırla\" — reytinqləri, sayğacları, " +
        "trafiki və yoxlama loglarını sıfırlayır, amma yüklənmiş hostları və abunəlikləri saxlayır (hər şey " +
        "növbəti skanda yenidən qiymətləndirilir).\n• \"Yüklənmiş hostları təmizlə\" — bütün proksi " +
        "hovuzunu silir, amma abunəlikləri saxlayır ki, skan hovuzu yenidən yığsın. Abunəliklərə heç bir halda toxunulmur."
    override val backupTitle = "İxrac / İdxal"
    override val backupHelp = "Tətbiq məlumatlarını JSON kimi saxlamaq və ya bərpa etmək. Nəyin daxil " +
        "ediləcəyini işarələyin — istənilən kombinasiya:\n• Ayarlar — bütün tətbiq parametrləri.\n" +
        "• Abunəliklər — mənbə siyahısı (URL + açıq/söndürülü).\n• Canlı host kataloqu — hər canlı " +
        "proksi öz reytinqi və statistikası ilə hər şəbəkə rejimi ÜZRƏ.\n\n\"İxrac\" hazır JSON ilə " +
        "səhifə açır — onu kopyalayın və ya fayla saxlayın. \"İdxal\" — JSON yapışdırın (və ya fayl " +
        "yükləyin), yalnız mətndə olan işarələnmiş bölmələr tətbiq olunur. İdxal cari məlumatlara ƏLAVƏ " +
        "EDİR (silmir)."
    override val backupSettings = "Ayarlar"
    override val backupSubs = "Abunəliklər"
    override val backupHosts = "Canlı host kataloqu (rejimlər üzrə)"
    override val exportWord = "İxrac"
    override val importWord = "İdxal"
    override val backupExportTitle = "Məlumatların ixracı"
    override val backupImportTitle = "Məlumatların idxalı"
    override val backupSelectExport = "Nəyi ixrac etmək:"
    override val backupSelectImport = "Nəyi idxal etmək:"
    override val backupCopyBtn = "Kopyala"
    override val backupSaveFile = "Fayla saxla"
    override val backupLoadFile = "Fayldan yüklə"
    override val backupDoImport = "İdxal et"
    override val backupPasteLabel = "Backup JSON-u bura yapışdırın"
    override val backupJsonLabel = "Backup JSON"
    override val backupAndroidFileNote = "Fayllar burada əlçatan deyil — Kopyala / Yapışdır istifadə edin."
    override val eraseAllHosts = "Bütün hostları sil"
    override val factoryReset = "Hər şeyi sıfırla (ilk işə salınma kimi)"
    override val factoryResetConfirm = "Tətbiqi tam zavod vəziyyətinə sıfırlamaq? BÜTÜN ayarlar və bütün " +
        "host kataloqu silinəcək, abunəliklər standart vəziyyətə qayıdacaq. Bu, ilk işə salınma kimidir."
    override val factoryResetDone = "Hər şey sıfırlandı. Tətbiqi bağlayıb yenidən işə salın."
    override val resetCatalog = "Kataloqu və statistikanı sıfırla"
    override val resetCatalogConfirm = "Bütün reytinqləri, sayğacları və yoxlama loglarını sıfırlamaq? " +
        "Yüklənmiş hostlar və abunəliklər saxlanılır və növbəti skanda yenidən qiymətləndirilir."
    override val clearHosts = "Yüklənmiş hostları təmizlə"
    override val clearHostsConfirm = "Yüklənmiş hostların (proksilərin) bütün siyahısını silmək? " +
        "Abunəliklər saxlanılır və skan hovuzu yenidən yığacaq."
    override val doReset = "Sıfırla"
    override val doCancel = "Ləğv et"
    override val adaptiveSpeed = "Adaptiv sürət"
    override val adaptiveHelp = "Canlılıq yoxlamaları baza intervalı ilə gedir (\"Skan və yoxlama\"dan, " +
        "həmçinin şəbəkə multiplikatoruna vurulur). \"Adaptiv sürət\" hazırda neçə proksinin canlı " +
        "olmasından asılı olaraq onları özü sürətləndirir və ya yavaşladır.\n\n" +
        "• Canlı AZ (\"Az\" həddindən aşağı) → interval × \"Sürətləndirmə\". 1-dən kiçik multiplikator = " +
        "daha tez-tez: 0.5 — iki dəfə tez-tez, 0.25 — 4 dəfə. Hovuzu daha tez doldurur.\n" +
        "• Canlı ÇOX (\"Çox\" həddindən yuxarı) → interval × \"Yavaşlatma\". 1-dən böyük = daha nadir: " +
        "2 — iki dəfə nadir, 4 — dörd dəfə. Batareya və trafikə qənaət edir.\n" +
        "• Hədlər arasında — baza sürət (×1).\n\n" +
        "Nümunələr:\n" +
        "— Proksiləri daha tez yığmaq: \"Sürətləndirmə\" 0.25 və/və ya \"Az\" həddi 40.\n" +
        "— Kifayət qədər olanda batareyaya qənaət: \"Yavaşlatma\" 8 və/və ya \"Çox\" həddi 30.\n" +
        "— Adaptasiyanı söndürmək: hər iki multiplikatoru 1 edin.\n\n" +
        "Defolt: Az 20, Sürətləndirmə 0.5, Çox 50, Yavaşlatma 4."
    override val threshMany = "\"Az\" həddi"; override val threshFew = "\"Çox\" həddi"; override val mulFast = "Sürətləndirmə ×"; override val mulLazy = "Yavaşlatma ×"
    override val subIntensityTitle = "Abunəlik intensivliyi"
    override val subIntensityHint = "Abunəlik yükləmələri arasında pauza: proksi siyahılarını neçə dəqiqədən bir yenidən yükləmək (hər şəbəkə rejimi üçün ayrıca)."
    override val baseScanTitle = "Baza skan sürəti"
    override val baseScanHelp = "Proksilərin canlılığa yoxlanmasının istinad sürəti. \"Adaptiv sürət\" və " +
        "\"Rejimlərə görə sürət\" multiplikatorları ona nisbətən hesablanır.\n\n" +
        "• Neçə dəqiqədən bir işə salmaq — yoxlama keçidləri arasında interval.\n" +
        "• Axına paket, host — hər axın bir keçiddə neçə host yoxlayır.\n" +
        "• Axın sayı — neçə yoxlama eyni anda gedir. Bir keçiddə \"paket × axın\" host yoxlanılır.\n" +
        "• Hostu N dəqiqədən tez-tez skan etmə — flood mühafizəsi: bu yaxınlarda yoxlanmış host bu " +
        "keçidə düşmür.\n\n" +
        "Daha çox axın və böyük paket = hovuzun daha tez böyüməsi, amma şəbəkə və batareyaya daha ağır yük."
    override val baseScanPeriod = "Neçə dəqiqədən bir işə salmaq"
    override val baseScanBatch = "Axına paket, host"; override val baseScanThreads = "Axın sayı"
    override val adaptiveDesc = "Canlı proksilər \"az\"dan az və ya \"çox\"dan çoxdursa — əlavə multiplikator tətbiq et."
    override val fewWord = "Az"; override val manyWord = "Çox"
    override fun fasterX(x: String) = "${x}× daha sürətli"
    override fun slowerX(x: String) = "${x}× daha yavaş"
    override fun ifAliveLt(n: Int) = "Canlı proksilər < ${n} əd olarsa, onda:"
    override fun ifAliveGt(n: Int) = "Canlı proksilər > ${n} əd olarsa, onda:"
    override val disabledWord = "söndürülüb"
    override val speedByModeTitle = "Rejimlərə görə sürət"
    override val speedByModeHelp = "Baza sürətin üstündən hər şəbəkə rejimi üçün skan-sürət multiplikatoru. " +
        "\"Standart\" (×1) = baza interval. Sağa — daha nadir (yavaş, trafik/batareyaya qənaətli), " +
        "sola — daha tez-tez (sürətli, aqressiv). Loqarifmik şkala, hər tərəfə ×100-ə qədər.\n\n" +
        "Hər sürüşdürücünün altında — adaptiv sürət nəzərə alınmaqla yekun keçid parametrləri: ayrıca " +
        "\"canlı az\" (× \"Sürətləndirmə\") və \"canlı çox\" (× \"Yavaşlatma\") halı üçün.\n\n" +
        "Rejimlər:\n• VPN — xarici VPN aktivdir.\n• LTE — mobil şəbəkə.\n• Wi-Fi — Wi-Fi şəbəkəsi.\n" +
        "• Ethernet — kabel bağlantısı.\n• White — əl ilə \"ağ\" proksi rejimi."
    override val aliveLt = "canlı <"; override val aliveGt = "canlı >"
    override val periodWord = "period"; override val nonstopWord = "fasiləsiz"
    override val batchWord = "paket"; override val threadsWord = "axın"; override val scanModeOff = "skan söndürülüb"
    override val netBattery = "Şəbəkə və batareya"
    override val netBatteryHelp = "• Yalnız Wi-Fi — mobil şəbəkədə skan etmə (trafikə qənaət).\n" +
        "• Yalnız enerji dolarkən — yalnız telefon enerji dolanda işlə.\n• Aşağı zaryadda ötür — batareya " +
        "az olanda skanı dayandır."
    override val onlyWifi = "Yalnız Wi-Fi"; override val onlyCharging = "Yalnız enerji dolarkən"; override val skipLowBattery = "Aşağı zaryadda ötür"
    override val autosaved = "Ayarlar avtomatik saxlanılır."
    override val dpiAutoLabel = "DPI fəndlərinin avto-seçimi"; override val dpiNoneLabel = "DPI fəndsiz (adi)"
    override val experimental = "Eksperimental"
    override val experimentalHelp = "MTProto proksiyə alternativ proksiləmə mühərrikləri və diaqnostik log. " +
        "\"Söndürülüb\" zamanı istinad (işləyən) yol dəyişmir. Yalnız şifrlənmiş axının apstrim TCP soketinə " +
        "NECƏ yazılması dəyişir (seqment ölçüləri, tayminq, TLS-record sərhədləri) — axının özü bayt-bayt eynidir. " +
        "Yalnız canlı proksi relayına tətbiq olunur (zondlara və birbaşa yola yox)."
    override val expEngineTitle = "Proksiləmə mühərriki (soket obfuskasiyası)"
    override val expConnectTitle = "Qoşulma mühərriki (apstrim seçimi)"
    override val raceWidthTitle = "Paralel qoşulmalar"
    override val connectionSection = "Bağlantı və blok keçməsi"
    override val connectionSectionHelp = "Qoşulma mühərriki, paralel apstrimlərin sayı, proksiləmə mühərriki və anti-DPI fəndləri — hamısı bir bölmədə."
    override val netLogSection = "Şəbəkə mübadiləsi logu"
    override val expEngineWarn = "⚠ Eksperimental rejim. Əlaqə pisləşsə — \"Söndürülüb (istinad yol)\"a qayıdın."
    override val netLog = "Şəbəkə mübadiləsi logunu aktivləşdir"
    override val netLogSub = "Fayla KİM-KİMƏ-NƏ VAXT və paket ölçülərini yazır (məzmun olmadan) — " +
        "mübadilə xarakterini VPN ilə və onsuz müqayisə etmək üçün."
    override val openLogFolder = "Log qovluğunu aç"; override val copyPath = "Yolu kopyala"
    override val quickSwitchTitle = "Blok keçməsi"; override val quickSwitchSub = "Bölünmə, qoşulma, anti-DPI"
    override val helpShow = "Kömək"; override val helpHide = "Köməyi gizlət"
    override val quickSwitchIntro = "Burada blok keçmə fəndlərini seçə bilərsiniz. Əgər Telegram " +
        "“The proxy you are using is not configured correctly and will be disabled. Please find another " +
        "one” xətasını verirsə, hansı trafik obfuskasiya növünün işlədiyini eksperimental yolla seçin " +
        "ki, Telegram bu xətanı verməsin. split* rejimlərindən başlayın. coalesce* rejimləri də işləyir, " +
        "amma onlarla Telegram-da şəkillər/videolar pis yüklənir."

    override val sourceUrl = "Mənbə URL"
    override fun sourceAlive(alive: Int, total: Int) = "canlı ${alive}/${total}"
    override val open = "Aç"; override val active = "Aktiv"; override val inactive = "Qeyri-aktiv"
    override val lastDownloaded = "Yükləndi"; override val notDownloaded = "hələ yüklənməyib"
    override fun sourceCounts(dead: Int, total: Int) =
        " canlı, ${dead} ölü, ${total} cəmi"

    override val proxyBase = "Proksi bazası"
    override val totalInBase = "Bazada cəmi"; override val aliveNow = "İndi canlı"; override val deadStat = "Ölü"
    override val aliveIn15 = "15 dəqiqədə canlı"; override val checksAllTime = "Bütün vaxt yoxlamalar"
    override val antiDpiTricks = "Anti-DPI fəndləri"; override val noStatsYet = "hələ məlumat yoxdur — fəndlər yoxlamalar/qoşulmalar getdikcə toplanır"
    override val attempts = "Cəhd"; override val handshake = "Handshake"; override val score = "Bal"
    override val tgConnect = "TG qoşulma"; override val socketsOver1m = "Soketlər >1dəq"
    override val over10kb = "Soketlər >10KB"; override val over100kb = ">100KB"; override val workTime = "İş vaxtı"
    override val statsLegend = "Handshake — uğurlu handshake (cəhdlərin %-i) · Bal — dəyər · " +
        "\"İş vaxtı\" — ≥5KB və 1 dəqiqədən uzun soketlər üzrə cəmi."
    override val resetStats = "Fənd statistikasını sıfırla"

    override fun aliveLinks(n: Int) = "Canlı linklər: ${n}"
    override val copyAll = "Hamısını kopyala"
    override val openRandom = "Təsadüfi aç"; override val copyRandom = "Təsadüfi kopyala"; override val allShort = "HAMISI"
    override val copyTop = "TOP-u kopyala"; override val randomHost = "Təsadüfi host"
    override val exportToFile = "Fayla ixrac"; override val exportSaved = "Fayla saxlanıldı:"
    override val dlNow = "İndi yüklə"
    override fun downloadingFmt(sec: Long) = "Yüklənir… ${sec} san"
    override val cancel = "Ləğv et"
    override val deleteConfirmTitle = "Abunəliyi silmək?"
    override val subscriptionsAddHint = "Abunəliklər və ya proksi-linklər əlavə et →"
    override val addSourcesTitle = "Əlavə et"
    override val addSubsLabel = "Abunəliklər (URL, hər sətirdə bir)"
    override val addSubsHelp = "Düzgün URL olan hər sətir ayrıca abunəlik olur və dövri olaraq yüklənir."
    override val addProxiesLabel = "Hazır proksi-linklər (sabit siyahı)"
    override val addProxiesHelp = "Konkret proksilərə bir dəstə link yapışdırın (tg://proxy, https://t.me/proxy, …). Bu, abunəlik DEYİL — siyahı yüklənmir, proksilər sadəcə kataloqa əlavə olunur."
    override val addButton = "Əlavə et"
    override fun addedFmt(subs: Int, proxies: Int) = "Əlavə edildi: abunəlik ${subs}, proksi ${proxies}"
    override val perSecond = "saniyəyə"
    override val graphSpeed = "Sürət"
    override val graphVolume = "Həcm"
    override val graphLatency = "Ping"
    override val graphConnects = "Qoşulmalar"
    override val scanNow = "İndi skan et"; override val scanOnShort = "Skan açıq"
    override val scanRunning = "Skan gedir"; override val scanIdle = "Skan idle"; override val scanOffState = "Skan OFF"; override val scanBatchPerThread = "Paket/axın"; override val scanPassHosts = "Keçiddə host"; override val minRescanLabel = "Hostu N dəqiqədən tez-tez skan etmə"
    override val scanPlanTitle = "Plan"; override val scanNowTitle = "İndi"; override val currentScheduleTitle = "Cari cədvəl"
    override val scheduleWord = "Cədvəl"; override val unitPcsPerSec = "əd/san"
    override val scanNowThreadsLabel = "İndi işləyən axınlar"; override val scanNowPerThreadLabel = "Axına yoxlama (plan)"; override val scanNowElapsedLabel = "İş vaxtı"
    override val scanOkGraph = "Uğurlu skanlar"; override val scanFailGraph = "Uğursuz skanlar"; override val scanTrafficGraph = "Skan trafiki"; override val scanAliveGraph = "Canlı proksilər cəmi"; override val scanPingGraph = "Ping"; override val threadsGraph = "Axınlar"
    override val scanEvery = "Period"; override val scanNextRun = "Növbəti işə salınma"
    override val scanThreads = "Axınlar"; override val scanBatch = "Paketdə"
    override val scanElapsed = "İşləyir"; override val scanIdleNow = "—"
    override val effForFew = "\"Az\" olanda"; override val effForMany = "\"Çox\" olanda"
    override val effCheck = "Yoxlama"; override val effBatch = "Paket"; override val effPar = "Paralel"
    override val effContinuous = "fasiləsiz"; override val secShort = "san"; override val minShort = "dəq"

    override val appTagline = "Kross-platform avto-konnektor: Telegram-ın işlədiyi MTProto proksiləri " +
        "özü tapır, yoxlayır və qaldırır."
    override val version = "Versiya"; override val buildDate = "Build tarixi"; override val platform = "Platforma"
    override val downloadSources = "Yükləmə və mənbələr"; override val openOnGithub = "GitHub-da aç"
    override val feedbackBugs = "Geribildirim və baq-hesabatlar"; override val writeTelegram = "Telegram-da yaz"

    override val language = "Dil"; override val langAuto = "Avto (sistemdəki kimi)"; override val langRu = "Русский"; override val langEn = "English"
    override val langWord = "Dil"

    override val scanModeTitle = "Şəbəkə rejimi"; override val scanModeAuto = "Avto"; override val scanModeManualLabel = "Əl ilə"
    override val activeModeLabel = "Aktiv rejim"; override val formingListLabel = "Siyahı formalaşır"; override val catalogModeTabs = "Rejim"
    override val resetModeRatings = "Host reytinqlərini sıfırla"; override val forgetModeHosts = "Rejim hostlarını unut"
    override val exportModeTitle = "Rejimlər üzrə ixrac"; override val modePickerTitle = "Rejim"
    override val modeHelp = "Hər şəbəkə rejimində — ayrıca proksi reytinqi və öz skan + abunəlik yükləmə intensivliyi. \"Avto\" rejimi aktiv şəbəkəyə görə müəyyən edir. \"Əl ilə\" — rejimi özünüz təyin edirsiniz (avtonun heç vaxt seçmədiyi White daxil)."
    override val autoSelect = "Avto seçim"; override val manualSelect = "Əl ilə seçim"
    override val connStatsTitle = "İndi bağlantılar"; override val connOnPort = "Portdakı bağlantılar"; override val outgoingConns = "Gedən bağlantılar"
    override val modeChoice = "Rejim seçimi"; override val autoChoice = "avto seçim"; override val manualChoice = "əl ilə sabit"
    override val directOnVpn = "VPN-də TG-yə birbaşa qoşulma"; override val onWord = "açıq"; override val offWord = "söndürülü"
    override val directStateActive = "aktiv"; override val directStateOff = "ayarlarda söndürülüb"; override val directStateIdle = "ayarlarda açıq, amma aktiv deyil"
    override val wpHintTitle = "White nədir?"
    override val wpHint = "White — WhitePages: əl ilə şəbəkə rejimi. Yalnız əl ilə açılır (avto-seçim onu qoymur). " +
        "Ayrıca host reytinqi aparır, abunəlikləri yükləyir və VPN/Wi-Fi/LTE-dən asılı olmayaraq skan edir."

    // tray
    override val trayOpenWindow = "Pəncərəni aç"
    override val trayRefreshSubs = "Abunəlikləri yenilə"
    override val trayExit = "Çıxış"
    override fun trayConnectorLabel(on: Boolean) =
        if (on) "Konnektor: AÇIQ (söndür)" else "Konnektor: SÖNÜLÜ (aç)"
    override fun trayScanLabel(on: Boolean) =
        if (on) "Skan: AÇIQ (söndür)" else "Skan: SÖNÜLÜ (aç)"
    override fun trayLive(n: Int) = "Canlı proksilər: ${n}"
    override val appearance = "Görünüş"
    override val themeLabel = "Tema"
    override val themeAuto = "Avtomatik (sistemə uyğun)"
    override val themeLight = "İşıqlı"
    override val themeDark = "Qaranlıq"
    override val drawGraphsLabel = "Qrafikləri çək"
    override val drawGraphsSub = "Bağlayıcı və Skan tablarında canlı qrafiklər — batareyaya qənaət üçün söndürün"
}
