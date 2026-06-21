package io.autoconnector.i18n

object Tr : Strings {
    override val tabConnector = "Bağlayıcı"; override val tabScan = "Tarama"
    override val tabCatalog = "Katalog"; override val tabLogs = "Günlükler"; override val tabMore = "Daha fazla"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "Abonelikler"; override val logTabScan = "Tarama"
    override val logGeneral = "Genel"; override val logEmpty = "şimdilik boş"
    override val logSessions = "Oturumlar"; override val logErrorsOnly = "yalnızca hatalar"; override val logNoErrors = "başarısız oturum yok"
    override fun logSession(id: String, port: String) = "#$id · :$port"
    override val back = "Geri"; override val copy = "Kopyala"; override val gotIt = "Anladım"
    override val later = "Sonra"; override val details = "Ayrıntılar"; override val whatIsThis = "Bu nedir?"
    override val delete = "Sil"

    override val connector = "Bağlayıcı"; override val scan = "Tarama"
    override val notConfigured = "Kurulmadı! Düzelt →"; override val howToSetup = "Nasıl kurulur"
    override val notifOff = "Bildirimler kapalı! Düzelt →"; override val enable = "Etkinleştir"
    override fun fewProxies(n: Int) = "Canlı proxy $n, aranıyor, ~15 dk bekleyin…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "Canlı proxy: $alive  (15 dk: $within) · toplam: $total"
    override val notifWhyTitle = "Neden bildirimler?"
    override val notifWhyBody = "Kalıcı bir bildirim simgesi bir Android ön plan hizmeti anlamına gelir. " +
        "Onsuz sistem uygulamayı bellekten boşaltır ve uygulama proxy aramayı ve " +
        "bağlantıyı arka planda tutmayı durdurur. AutoConnector'ın çalışması için " +
        "bildirimlerin gerekli olmasının nedeni budur."
    override val notifEnableTitle = "Bildirimleri etkinleştir"
    override val notifEnableBody = "Bir bildirim simgesi olmadan Android uygulamayı etkin değil olarak görür ve " +
        "bellekten boşaltır. Ardından AutoConnector proxy aramayı ve bağlantıyı arka planda tutmayı " +
        "durdurur — Telegram bağlantısını kaybeder.\n\n\"Etkinleştir\"e dokunun ve AutoConnector için " +
        "bildirimlere izin verin."
    override val notifPlea = "Bildirimleri etkinleştirin! Onlar olmadan uygulama arka planda çalışamaz — " +
        "Android onu boşaltır ve proxy araması ile bağlantı durur."

    override val statusConnected = "Telegram bağlandı"; override val statusConnecting = "Bağlanıyor…"
    override val statusOffline = "Telegram bağlı değil"; override val statusIdle = "Telegram boşta"
    override val nobodyConnected = "Bağlayıcıya kimse bağlanmadı. "; override val howToSetupArrow = "Nasıl kurulur →"
    override val directModeViaVpn = "Doğrudan mod: VPN etkin — proxy yok"
    override val directModeOff = "Doğrudan mod: proxy'ler kapalı"
    override val directDpiSuffix = " · anti-DPI"
    override val connections = "Bağlantılar"; override val sockets = "Soketler"; override val speed = "Hız"
    override val traffic = "Trafik"; override val latency = "Gecikme"
    override fun pcs(n: Int) = "$n adet"
    override fun netNow(label: String) = "Ağ: $label"
    override fun tgToConnector(n: Int) = "TG→ $n"
    override fun connectorToProxy(n: Int) = "proxy $n"
    override val trafficSec = "trafik · 60 sn"; override val trafficMin = "trafik · 60 dk"
    override val latencySec = "gecikme · 60 sn"; override val latencyMin = "gecikme · 60 dk"
    override val sec60 = "60 sn"; override val min60 = "60 dk"
    override val unitSec = "sn"; override val unitMin = "dk"; override val unitHour = "sa"; override val dash = "—"
    override val currentProxy = "Geçerli proxy"; override val noActiveProxy = "etkin proxy yok (Telegram bağlı değil)"
    override val host = "Sunucu"; override val type = "Tür"; override val secret = "Gizli anahtar"; override val antiDpi = "Anti-DPI"; override val obfEngine = "Gizleme motoru"
    override fun activeSockets(n: Int) = "Etkin Telegram soketleri: $n"
    override val noConnections = "etkin bağlantı yok"; override val colHost = "Sunucu"; override val colTime = "Süre"
    override val modeWord = "Mod"; override val directViaVpnLine = "Telegram'a doğrudan istekler (VPN etkin)"
    override val connModeHelp = "Modlar (VPN, Wi-Fi, LTE, Ethernet, White) tarama yoğunluğunu farklı şekilde ayarlamanıza ve ayrı sunucu derecelendirmeleri/istatistikleri tutmanıza olanak tanır. Ağ kartı otomatik olarak algılanır; mod ayarlardan elle ayarlanabilir."

    override val scanOff = "Tarama kapalı"; override val proxiesInBase = "Veritabanındaki proxy'ler"
    override val total = "toplam"; override val alive = "canlı"; override val dead = "ölü"
    override val tgConnectedTitle = "Telegram şununla bağlandı"; override val successful = "başarılı"
    override val socketsHeld = "Soket ömrü"; override val over1m = ">1 dk"; override val over5m = ">5 dk"; override val over15m = ">15 dk"
    override val scanCountTitle = "Proxy kontrol sayısı"; override val checked = "Kontrol edildi"
    override val forAllTime = "tüm zamanlar"; override val perMinute = "dakika başına"; override val perHour = "saat başına"
    override val subsCountTitle = "Abonelik indirme sayısı"; override val downloaded = "indirildi"; override val failed = "başarısız"; override val scanTraffic = "tarama trafiği"; override val subTraffic = "abonelik trafiği"; override val subTrafficGraph = "Abonelik trafiği"
    override val checksMtproto = "MTProto kontrolleri (↑ tamam · ↓ başarısız)"

    override fun catalogEmpty(mode: String) = "Katalog $mode şimdilik boş. Ya hiç sunucu bulunamadı ya da uygulama bu modda hiç çalışmadı. Modu Ayarlar'dan değiştirebilirsiniz. Modlar, farklı internet bağlantısı türleri için sunucuları ayrı ayrı toplamak amacıyla vardır."
    override val aliveShort = "✓ canlı"; override val deadShort = "✗ ölü"
    override val statusLabel = "Durum"; override val rating = "Derecelendirme"; override val port = "Port"
    override val rttPing = "RTT (ping)"; override val checkedField = "Kontrol edildi"; override val okOfTotal = "Başarılı / toplam kontrol"
    override val tgConnectedField = "Telegram bağlandı"; override val tgSessions = "Telegram oturumları"; override val trafficThroughProxy = "Proxy üzerinden trafik"
    override val sessionsTotal = "Toplam oturum"; override val relayNow = "Şimdi aktarıyor"; override val tlsDomain = "TLS alan adı (SNI)"
    override val sourceSub = "Kaynak (abonelik)"; override val lastError = "Son hata"; override val yes = "evet"; override val no = "hayır"
    override val copyAsLink = "Bağlantı olarak kopyala"; override val openInTelegram = "Sunucuyu Telegram'da aç"; override val makeNextRelay = "Sonraki aktarıcı yap"
    override val actCopy = "Kopyala"; override val actOpen = "Aç"; override val actRelay = "Aktar"
    override fun agoFmt(v: String) = "$v önce"
    override val catalogTopFor = "Şunun için proxy listesi/derecelendirmesi"
    override val catalogModeHelpTitle = "Modlar ve derecelendirmeler"
    override val catalogModeHelp = "Uygulama canlı sunucuları ve derecelendirmelerini her ağ modu için AYRI AYRI sayar (VPN, Wi-Fi, LTE, Ethernet ve White). «White» beyaz listeler için ayrı bir ELLE mod'dur; otomatik mod ona asla geçmez. Yani aynı sunucu bir modda canlı, başka bir modda ölü olabilir."
    override fun catalogInactiveWarn(section: String, active: String) =
        "Etkin olmayan bölümü görüntülüyorsunuz: $section — şu anda tüm istatistikler buraya değil $active bölümüne gidiyor."
    override val manageModeTitle = "Modu yönet"
    override val manageResetRating = "Derecelendirmeyi sıfırla"
    override fun manageResetHint(mode: String) = "Özellikle $mode için canlı sunucuların derecelendirmesini ve kullanım istatistiklerini sıfırlayabilirsiniz. Bu, temelden farklı bir VPN veya LTE'ye bağlandığınızda eski istatistiklerin karışmaması için kullanışlıdır. Ya da proxy taramasının her şeyi sıfırdan ne kadar hızlı yeniden kontrol ettiğini izlemek için."
    override val manageDeleteAll = "Şuradaki sunucuları sil"
    override fun manageDeleteHint(mode: String) = "Hem derecelendirmeyi hem de sunucuların kendisini $mode modundan temizleyebilirsiniz. \"Proxy tara\" özelliği onları tekrar toplar. Bu bir abonelik sıfırlaması değildir — dokunabilir, ardından yeniden tarama için ~15 dakika bekleyebilirsiniz."
    override fun manageCopyFrom(mode: String) = "Tüm sunucuları ve derecelendirmeleri başka bir moddan bu moda ($mode) kopyala:"
    override val live = "canlı"; override val deadW = "ölü"; override val unitMs = "ms"
    override val agoMin = "dk"; override val agoHour = "sa"; override val agoDay = "g"

    override val connectTelegram = "Telegram bağlanıyor"; override val readCarefully = "Dikkatlice okuyun!"
    override val guideIntro = "Bu uygulama kurulmadan çalışmaz. Aşağıdaki 3 seçenekten herhangi birini seçin " +
        "ve talimatları dikkatlice izleyin."
    override val variant1 = "Seçenek #1 — düğmeler"
    override val variant1Body = "\"Proxy {A}\"ya dokunun — Telegram açılır, proxy eklemeyi onaylayın. Bu " +
        "ekrana geri dönün ve \"Proxy {B}\"ye dokunun — ikinci kez eklemeyi onaylayın.\n\nTelegram'daki " +
        "diğer eski proxy'leri devre dışı bırakın. Tam olarak 2 proxy kalmalı — {A} ve {B} portlarıyla. " +
        "Başka herhangi bir kümeyle AutoConnector çalışmaz."
    override val variant2 = "Seçenek #2 — bağlantılar"
    override val variant2Body = "Aşağıdaki metni Telegram'daki Kayıtlı Mesajlar'a (veya herhangi bir sohbete) kopyalayın — " +
        "yani kendinize gönderin. Mesajınızdaki ilk bağlantıya dokunun — ilk proxy eklenir. " +
        "İkinci bağlantıya dokunun — ikincisi eklenir. Ardından tüm eski proxy'leri devre dışı bırakın."
    override val variant3 = "Seçenek #3 — elle"
    override val variant3Body = "Bir SOCKS5 proxy'sini elle ekleyin: sunucu localhost (127.0.0.1), port {A}. " +
        "Ardından ikinci bir proxy: localhost, port {B}. Eski proxy'leri silin."
    override val whatNext = "Sonra ne olacak?"
    override val whatNextBody = "Telegram'da \"otomatik proxy değiştirme\"yi etkinleştirin — 5 saniye. Etkin " +
        "OLMAYAN veya \"kullanılamıyor\" olarak işaretlenmiş bir proxy'ye (Telegram içinde) elle dokunarak " +
        "Telegram'ın bağlanmasına yardımcı olabilirsiniz — bu, Telegram'ın bağlanmak için daha çok çabalamasını sağlar.\n\n{A} ve {B} dışında diğer tüm eski " +
        "proxy'lerin kaldırıldığından emin olun. Telegram'da " +
        "\"Proxy kullan\"a dokunun.\n\nUygulama yeterli proxy bulup indirirken bekleyin " +
        "(5–15 dakika). Ardından Telegram kendiliğinden AutoConnector'a bağlanır, bu da " +
        "Telegram'ı en iyi proxy'ler üzerinden yönlendirmeye devam eder: doğrulanmış, canlı ve hızlı.\n\nTalimatlar zor " +
        "görünüyorsa — üzgünüz, uygulamayı kullanamayacaksınız: her şeyi otomatik olarak ayarlamak " +
        "imkansızdır ve canlı proxy bulmak zaman alır.\n\nUygulamayı uzun süre önce indirdiyseniz " +
        "ve canlı proxy bulunamadıysa — ya uygulamayı ya da abonelik listesini güncelleyin. Bu uygulama " +
        "kendi proxy'lerini icat etmez veya sağlamaz, yalnızca internette düzinelerce " +
        "grup ve sayfa arasında arama yapar."
    override fun proxyBtn(port: Int) = "Proxy $port"

    override val setupPortsTitle = "Telegram'da portları kur"
    override val setupPortsSub = "Telegram'ı Bağlayıcıya nasıl bağlanır (portlar 55001/55002)"
    override val settings = "Ayarlar"; override val settingsSub = "Portlar, anti-DPI, tarama, ağ, pil"
    override val subscriptions = "Abonelikler"; override val subscriptionsSub = "Taranacak proxy kaynakları"
    override val statistics = "İstatistikler"; override val statisticsSub = "Proxy veritabanı + anti-DPI hileleri"
    override val export = "Dışa aktar"; override val exportSub = "canlı proxy'lerin tg:// bağlantıları"
    override val about = "Hakkında"; override val aboutSub = "Sürüm, derleme, indirme, geri bildirim"
    override val hotkeys = "Kısayol tuşları"
    override val hotkeysSub = "Genel tuşlar: proxy kopyala / aç"
    override val hotkeysIntro = "Genel kısayol tuşları, uygulama penceresi odakta olmasa bile çalışır. Havuzdan " +
        "rastgele bir canlı proxy bağlantısı (tg://) seçerler — uygulamayı açmadan hızlıca proxy " +
        "değiştirmek için kullanışlıdır."
    override val hotkeysNote = "macOS'ta tuşları yakalamak Erişilebilirlik iznini gerektirebilir " +
        "(Sistem Ayarları → Gizlilik ve Güvenlik → Erişilebilirlik)."
    override val hotkeyCopyTitle = "Proxy bağlantısını kopyala"
    override val hotkeyCopyDesc = "Rastgele bir canlı tg:// bağlantısını panoya koyar."
    override val hotkeyEnable = "Kısayol tuşlarını etkinleştir"; override val hotkeyLetterLabel = "Harf"; override val hotkeySet = "Ayarla"; override val hotkeyReset = "Sıfırla"
    override val hotkeyOpenTitle = "Proxy'yi Telegram'da aç"
    override val hotkeyOpenDesc = "Rastgele bir canlı bağlantı açar — Telegram onu yakalar ve proxy'yi bağlamayı önerir."

    override val relayPorts = "Aktarma portları"
    override val relayPortsHelp = "Bağlayıcının dinlediği yerel portlar. Bunları Telegram'a tam olarak bir " +
        "SOCKS5 proxy olarak girersiniz (127.0.0.1 : port). Güvenilirlik için iki port kullanılır — Telegram " +
        "her ikisine de bağlantı tutar."
    override val portA = "Port A"; override val portB = "Port B"
    override val antiDpiTrick = "Anti-DPI hilesi"
    override val antiDpiHelp = "ISS/DPI'nin bağlantıyı tanımayıp engellememesi için bağlantıyı gizleme " +
        "yöntemi.\n• \"Otomatik döndürme\" çalışan bir hileyi kendisi seçer.\n• \"DPI hilesi yok\" — düz " +
        "bir bağlantı.\n• Geri kalanlar belirli tekniklerdir (tarayıcı taklidi, paket bölme vb.)."
    override val onlyFakeTls = "Yalnızca FakeTLS (ee)"
    override val applyDpiTo = "Anti-DPI'yi şuna uygula"
    override val applyDpiHelp = "Seçilen anti-DPI hilesinin neye uygulanacağı:\n• Telegram aktarımı — Bağlayıcı " +
        "üzerinden canlı Telegram bağlantısına.\n• Proxy yoklamaları — arka plandaki proxy kontrollerine " +
        "(o zaman bir kontrol tıpkı gerçek bir bağlantı gibi davranır ve hile istatistikleri daha doğru olur).\n" +
        "• Doğrudan bağlanırken — proxy'ler kapalıyken (veya VPN açıkken atlandığında) ve Telegram " +
        "doğrudan sunucularına gittiğinde: burada proxy yoktur, dolayısıyla hile ilk TCP paketini " +
        "(el sıkışmayı) DPI'nin tek bir okumada eşleştirememesi için birkaç küçük segmente bölmeye indirgenir."
    override val toRelay = "Telegram aktarımı"; override val toProbes = "Proxy yoklamaları"
    override val toDirect = "Doğrudan bağlanırken"
    override val vpnSection = "VPN açıkken"
    override val vpnHelp = "Cihazda bir VPN etkin olduğunda ne yapılacağı:\n• MTProto proxy üzerinden — " +
        "Telegram bulunan proxy'ler üzerinden her zamanki gibi gider (VPN'in üstünde).\n• Doğrudan — " +
        "Bağlayıcı proxy KULLANMAZ ve Telegram'ı doğrudan Telegram'ın sunucularına bağlar: " +
        "VPN zaten erişim sağlar, ekstra proxy katmanı gerekmez (daha hızlı ve daha kararlı). " +
        "VPN olmadan proxy'ler her zamanki gibi kullanılır."
    override val linkFormat = "Proxy bağlantı biçimi"
    override val linkFormatHelp = "Proxy'lerin nasıl kopyalanıp açılacağı. tg:// Telegram'ı doğrudan açar (Telegram Desktop'ın kurulu olması gerekir). http (t.me) tarayıcı üzerinden açar ve Telegram'da açmayı önerir — tg:// kayıtlı değilse kullanışlıdır."
    override val linkTg = "tg:// (Telegram'ı doğrudan aç)"; override val linkTgSub = "tg://proxy?… — Telegram'ı açar"
    override val linkHttp = "http (t.me, tarayıcı üzerinden)"; override val linkHttpSub = "https://t.me/proxy?… — tarayıcıyı açar"
    override val viaMtproto = "MTProto üzerinden proxy"; override val viaMtprotoSub = "VPN ile bile trafik proxy'ler üzerinden gider"
    override val directly = "Doğrudan bağlan"; override val directlySub = "VPN etkinken — proxy'leri atla, doğrudan Telegram'a"
    override val notifications = "Bildirimler"
    override val scanCheck = "Tara ve kontrol et"
    override val scanCheckHelp = "• Tarama, dk — proxy listelerinin aboneliklerden ne sıklıkla indirileceği.\n" +
        "• Kontrol, dk — veritabanındaki proxy'lerin canlılık için ne sıklıkla yeniden kontrol edileceği.\n• Grup boyutu — " +
        "her çalıştırmada kaç proxy kontrol edileceği.\n• Paralel — aynı anda kaç kontrolün çalıştırılacağı (daha fazla = " +
        "daha hızlı, ama daha yüksek ağ ve pil yükü)."
    override val scanMin = "Tarama, dk"; override val checkMin = "Kontrol, dk"; override val batchSize = "Grup boyutu"; override val parallel = "Paralel"
    override val speedByNet = "Ağa göre tarama yoğunluğu"
    override val speedByNetHelp = "Geçerli ağa bağlı olarak proxy'lerin ne sıklıkla kontrol edileceği. " +
        "\"Standart\" = temel aralık. Daha seyrek için sağa kaydırın (daha yavaş, trafik/pil için daha nazik), " +
        "daha sık için sola (daha hızlı, daha agresif). Logaritmik ölçek, her yönde ×100'e kadar.\n" +
        "• VPN — harici bir VPN etkin olduğunda.\n• Wi-Fi — bir Wi-Fi ağında.\n• LTE — bir mobil ağda."
    override val intensStandard = "standart"
    override val intensSlower = "daha yavaş"
    override val intensFaster = "daha hızlı"
    override val maintenance = "Verileri sıfırla"
    override val maintenanceHelp = "• \"Katalog ve istatistikleri sıfırla\" — derecelendirmeleri, sayaçları, trafiği " +
        "ve kontrol günlüklerini sıfırlar, ancak indirilen sunucuları ve abonelikleri korur (her şey bir sonraki " +
        "taramada yeniden derecelendirilir).\n• \"İndirilen sunucuları temizle\" — tüm proxy havuzunu siler ama " +
        "abonelikleri korur, böylece tarama havuzu yeniden doldurur. Abonelikler her iki durumda da asla dokunulmaz."
    override val backupTitle = "Dışa aktar / İçe aktar"
    override val backupHelp = "Uygulama verilerini tek bir JSON dosyasında kaydedin veya geri yükleyin. Neyin " +
        "dahil edileceğini işaretleyin — herhangi bir kombinasyon:\n• Ayarlar — tüm uygulama parametreleri.\n• Abonelikler — kaynak " +
        "listesi (URL + açık/kapalı).\n• Canlı sunucu kataloğu — her canlı proxy, derecelendirmeleri ve istatistikleriyle " +
        "ağ modu BAŞINA.\n\n«Dışa aktar» nereye kaydedileceğini sorar; «İçe aktar» hangi dosyanın açılacağını sorar ve " +
        "yalnızca içindeki işaretli bölümleri uygular. İçe aktarma geçerli verilere EKLER (silme yok)."
    override val backupSettings = "Ayarlar"
    override val backupSubs = "Abonelikler"
    override val backupHosts = "Canlı sunucu kataloğu (mod başına)"
    override val exportWord = "Dışa aktar"
    override val importWord = "İçe aktar"
    override val eraseAllHosts = "Tüm sunucuları sil"
    override val factoryReset = "Her şeyi sıfırla (ilk açılış gibi)"
    override val factoryResetConfirm = "Uygulama tamamen fabrika durumuna sıfırlansın mı? TÜM ayarlar ve tüm " +
        "sunucu kataloğu silinecek, abonelikler varsayılanlara geri yüklenecek. Tıpkı bir ilk açılış gibi."
    override val resetCatalog = "Katalog ve istatistikleri sıfırla"
    override val resetCatalogConfirm = "Tüm derecelendirmeler, sayaçlar ve kontrol günlükleri sıfırlansın mı? " +
        "İndirilen sunucular ve abonelikler korunur ve bir sonraki taramada yeniden derecelendirilir."
    override val clearHosts = "İndirilen sunucuları temizle"
    override val clearHostsConfirm = "İndirilen sunucuların (proxy'lerin) tüm listesi silinsin mi? " +
        "Abonelikler korunur ve tarama havuzu yeniden doldurur."
    override val doReset = "Sıfırla"
    override val doCancel = "İptal"
    override val adaptiveSpeed = "Uyarlanabilir hız"
    override val adaptiveHelp = "Canlılık kontrolleri temel bir aralıkta çalışır (\"Tara ve kontrol et\"ten, ayrıca " +
        "ağ çarpanıyla çarpılır). \"Uyarlanabilir hız\" şu anda kaç proxy'nin canlı olduğuna bağlı olarak " +
        "onları otomatik olarak hızlandırır veya yavaşlatır.\n\n" +
        "• AZ canlı (\"Az\" eşiğinin altında) → aralık × \"Hızlandırma\". 1'in altındaki bir çarpan = daha " +
        "sık: 0.5 — iki kat sık, 0.25 — 4×. Havuzu daha hızlı doldurur.\n" +
        "• ÇOK canlı (\"Çok\" eşiğinin üstünde) → aralık × \"Yavaşlatma\". 1'in üstü = daha seyrek: 2 — " +
        "yarı sıklık, 4 — çeyrek. Pil ve trafik tasarrufu sağlar.\n" +
        "• Eşikler arasında — temel hız (×1).\n\n" +
        "Örnekler:\n" +
        "— Proxy'leri daha hızlı topla: \"Hızlandırma\" 0.25 ve/veya \"Az\" eşiği 40.\n" +
        "— Yeterince olduğunda pil tasarrufu yap: \"Yavaşlatma\" 8 ve/veya \"Çok\" eşiği 30.\n" +
        "— Uyarlamayı kapat: her iki çarpanı da 1 olarak ayarla.\n\n" +
        "Varsayılanlar: Az 20, Hızlandırma 0.5, Çok 50, Yavaşlatma 4."
    override val threshMany = "\"Çok\" eşiği"; override val threshFew = "\"Az\" eşiği"; override val mulFast = "Hızlandırma ×"; override val mulLazy = "Yavaşlatma ×"
    override val subIntensityTitle = "Abonelik yoğunluğu"
    override val subIntensityHint = "Abonelik indirmeleri arasındaki duraklama: proxy listelerini yeniden indirmeden önce kaç dakika (ağ modu başına ayrı ayrı)."
    override val baseScanTitle = "Temel tarama hızı"
    override val baseScanHelp = "Referans canlılık kontrol hızı. «Uyarlanabilir hız» ve «Moda göre hız» " +
        "çarpanları buna göre hesaplanır.\n\n" +
        "• Ne sıklıkla çalıştırılır, dk — kontrol geçişleri arasındaki aralık.\n" +
        "• İş parçacığı başına grup, sunucu — her iş parçacığının geçiş başına kaç sunucu kontrol ettiği.\n" +
        "• İş parçacıkları — aynı anda kaç kontrol çalışır. Bir geçiş «grup × iş parçacığı» sunucuyu yoklar.\n" +
        "• Bir sunucuyu her N dakikadan daha sık yeniden tarama — taşma önleme: yakın zamanda kontrol edilen bir sunucu " +
        "bu geçişte atlanır.\n\n" +
        "Daha fazla iş parçacığı ve daha büyük bir grup = daha hızlı havuz büyümesi, ama ağ ve pil üzerinde daha ağır yük."
    override val baseScanPeriod = "Ne sıklıkla çalıştırılır, dk"
    override val baseScanBatch = "İş parçacığı başına grup, sunucu"; override val baseScanThreads = "İş parçacığı sayısı"
    override val adaptiveDesc = "Canlı proxy'ler «az»dan az veya «çok»tan fazlaysa, ekstra bir çarpan uygula."
    override val fewWord = "Az"; override val manyWord = "Çok"
    override fun fasterX(x: String) = "$x× daha hızlı"
    override fun slowerX(x: String) = "$x× daha yavaş"
    override fun ifAliveLt(n: Int) = "Canlı proxy < $n ise, o zaman:"
    override fun ifAliveGt(n: Int) = "Canlı proxy > $n ise, o zaman:"
    override val disabledWord = "kapalı"
    override val speedByModeTitle = "Moda göre hız"
    override val speedByModeHelp = "Temel hızın üstüne, her ağ modu için bir tarama hızı çarpanı. " +
        "«Standart» (×1) = temel aralık. Sağ — daha seyrek (daha yavaş, trafik/pil için daha nazik), " +
        "sol — daha sık (daha hızlı, daha agresif). Logaritmik ölçek, her yönde ×100'e kadar.\n\n" +
        "Her kaydırıcının altında, uyarlanabilir hız uygulanmış sonuç geçiş parametreleri vardır — " +
        "«az canlı» (× «Hızlandırma») ve «çok canlı» (× «Yavaşlatma») için ayrı ayrı gösterilir.\n\n" +
        "Modlar:\n• VPN — harici bir VPN etkin.\n• LTE — mobil ağ.\n• Wi-Fi — Wi-Fi ağı.\n" +
        "• Ethernet — kablolu bağlantı.\n• White — elle «white» proxy modu."
    override val aliveLt = "canlı <"; override val aliveGt = "canlı >"
    override val periodWord = "periyot"; override val nonstopWord = "durmaksızın"
    override val batchWord = "grup"; override val threadsWord = "iş parçacıkları"; override val scanModeOff = "tarama kapalı"
    override val netBattery = "Ağ ve pil"
    override val netBatteryHelp = "• Yalnızca Wi-Fi — mobil ağlarda tarama yapma (veri tasarrufu).\n• Yalnızca " +
        "şarjda — yalnızca telefon şarj olurken çalış.\n• Düşük pilde atla — pil düşük olduğunda taramayı " +
        "duraklat."
    override val onlyWifi = "Yalnızca Wi-Fi"; override val onlyCharging = "Yalnızca şarjda"; override val skipLowBattery = "Düşük pilde atla"
    override val autosaved = "Ayarlar otomatik olarak kaydedilir."
    override val dpiAutoLabel = "DPI hilelerini otomatik döndür"; override val dpiNoneLabel = "DPI hilesi yok (düz)"
    override val experimental = "Deneysel"
    override val experimentalHelp = "MTProto akışına alternatif proxy motorları ve bir tanılama günlüğü. " +
        "«Kapalı» olarak ayarlandığında referans (çalışan) yol değişmez. Yalnızca şifreli akışın akışa nasıl yazıldığı " +
        "değişir TCP soketine (segment boyutları, zamanlama, TLS kayıt sınırları) — akışın kendisi bayt bayt aynı kalır. " +
        "Yalnızca canlı proxy aktarımına uygulanır (yoklamalara değil, doğrudan yola değil)."
    override val expEngineTitle = "Proxy motoru (soket gizleme)"
    override val expConnectTitle = "Bağlantı motoru (akış seçimi)"
    override val raceWidthTitle = "Paralel bağlantılar"
    override val connectionSection = "Bağlantı ve engel aşma"
    override val connectionSectionHelp = "Bağlantı motoru, paralel akışlar, proxy motoru ve anti-DPI hileleri — hepsi tek bir bölümde."
    override val netLogSection = "Ağ değişim günlüğü"
    override val expEngineWarn = "⚠ Deneysel mod. Bağlantı kötüleşirse «Kapalı (referans yol)»a geri dönün."
    override val netLog = "Ağ değişim günlüğünü etkinleştir"
    override val netLogSub = "KİME-KİMDEN-NE ZAMAN ve paket boyutlarını bir dosyaya yazar (yük verisi YOK) — " +
        "değişim modelini VPN ile ve VPN olmadan karşılaştırmak için."
    override val openLogFolder = "Günlük klasörünü aç"; override val copyPath = "Yolu kopyala"
    override val helpShow = "Yardım"; override val helpHide = "Yardımı gizle"
    override val quickSwitchIntro = "Burada bir engel aşma hilesi seçebilirsiniz. Telegram şu hatayı gösterirse " +
        "“The proxy you are using is not configured correctly and will be disabled. Please find another " +
        "one”, Telegram'ın bunu göstermeyi bırakması için hangi trafik gizleme türünün işe yaradığını " +
        "deneyin. split* modlarıyla başlayın. coalesce* modları da çalışır, ama onlarla Telegram'da resimler/videolar kötü yüklenir."
    override val quickSwitchTitle ="Engel aşma"; override val quickSwitchSub = "Şekillendirme, bağlantı, anti-DPI"

    override val sourceUrl = "Kaynak URL"
    override fun sourceAlive(alive: Int, total: Int) = "canlı $alive/$total"
    override val open = "Aç"; override val active = "Etkin"; override val inactive = "Etkin değil"
    override val lastDownloaded = "İndirildi"; override val notDownloaded = "henüz indirilmedi"
    override fun sourceCounts(dead: Int, total: Int) =
        " canlı, $dead ölü, $total toplam"

    override val proxyBase = "Proxy veritabanı"
    override val totalInBase = "Veritabanında toplam"; override val aliveNow = "Şu anda canlı"; override val deadStat = "Ölü"
    override val aliveIn15 = "15 dakikada canlı"; override val checksAllTime = "Tüm zamanların kontrolleri"
    override val antiDpiTricks = "Anti-DPI hileleri"; override val noStatsYet = "henüz veri yok — kontroller/bağlantılar oldukça hileler birikir"
    override val attempts = "Denemeler"; override val handshake = "El sıkışma"; override val score = "Puan"
    override val tgConnect = "TG bağlantısı"; override val socketsOver1m = "Soketler >1dk"
    override val over10kb = "Soketler >10KB"; override val over100kb = ">100KB"; override val workTime = "Çalışma süresi"
    override val statsLegend = "El sıkışma — başarılı el sıkışmalar (denemelerin %'si) · Puan — değer · " +
        "\"Çalışma süresi\" — ≥5KB ve 1 dakikadan uzun soketler üzerinden toplam."
    override val resetStats = "Hile istatistiklerini sıfırla"

    override fun aliveLinks(n: Int) = "Canlı bağlantılar: $n"
    override val copyAll = "Tümünü kopyala"
    override val openRandom = "Rastgele aç"; override val copyRandom = "Rastgele kopyala"; override val allShort = "TÜMÜ"
    override val copyTop = "EN İYİyi kopyala"; override val randomHost = "Rastgele sunucu"
    override val exportToFile = "Dosyaya aktar"; override val exportSaved = "Dosyaya kaydedildi:"
    override val dlNow = "Şimdi indir"
    override fun downloadingFmt(sec: Long) = "İndiriliyor… ${sec}sn"
    override val cancel = "İptal"
    override val deleteConfirmTitle = "Abonelik silinsin mi?"
    override val subscriptionsAddHint = "Abonelik veya proxy bağlantıları ekleyin →"
    override val addSourcesTitle = "Ekle"
    override val addSubsLabel = "Abonelikler (satır başına bir URL)"
    override val addSubsHelp = "Geçerli bir URL içeren her satır kendi aboneliği olur ve periyodik olarak getirilir."
    override val addProxiesLabel = "Hazır proxy bağlantıları (sabit liste)"
    override val addProxiesHelp = "Belirli proxy'lere yönelik bir grup bağlantı yapıştırın (tg://proxy, https://t.me/proxy, …). Bu bir abonelik DEĞİLDİR — liste asla indirilmez, proxy'ler yalnızca kataloğa eklenir."
    override val addButton = "Ekle"
    override fun addedFmt(subs: Int, proxies: Int) = "Eklendi: $subs abonelik, $proxies proxy"
    override val perSecond = "saniye başına"
    override val graphSpeed = "Hız"
    override val graphVolume = "Hacim"
    override val graphLatency = "Ping"
    override val graphConnects = "Bağlantılar"
    override val scanNow = "Şimdi tara"; override val scanOnShort = "Tarama açık"
    override val scanRunning = "Tarama çalışıyor"; override val scanIdle = "Tarama boşta"; override val scanOffState = "Tarama KAPALI"; override val scanBatchPerThread = "Grup/iş parçacığı"; override val scanPassHosts = "Geçişteki sunucular"; override val minRescanLabel = "Bir sunucuyu her N dakikadan daha sık yeniden tarama"
    override val scanPlanTitle = "Plan"; override val scanNowTitle = "Şimdi"; override val currentScheduleTitle = "Geçerli zamanlama"
    override val scheduleWord = "Zamanlama"; override val unitPcsPerSec = "adet/sn"
    override val scanNowThreadsLabel = "Şu anda çalışan iş parçacıkları"; override val scanNowPerThreadLabel = "İş parçacığı başına kontrol (plan)"; override val scanNowElapsedLabel = "Çalışma süresi"
    override val scanOkGraph = "Başarılı taramalar"; override val scanFailGraph = "Başarısız taramalar"; override val scanTrafficGraph = "Tarama trafiği"; override val scanAliveGraph = "Toplam canlı proxy"; override val scanPingGraph = "Ping"; override val threadsGraph = "İş parçacıkları"
    override val scanEvery = "Her"; override val scanNextRun = "Sonraki çalıştırma"
    override val scanThreads = "İş parçacıkları"; override val scanBatch = "Grup"
    override val scanElapsed = "Çalışıyor"; override val scanIdleNow = "—"
    override val effForFew = "Az olduğunda"; override val effForMany = "Çok olduğunda"
    override val effCheck = "Kontrol"; override val effBatch = "Grup"; override val effPar = "Paralel"
    override val effContinuous = "sürekli"; override val secShort = "sn"; override val minShort = "dk"

    override val appTagline = "Çapraz platform otomatik bağlayıcı: Telegram'ın üzerinden çalıştığı MTProto " +
        "proxy'lerini bulur, kontrol eder ve çalıştırır."
    override val version = "Sürüm"; override val buildDate = "Derleme tarihi"; override val platform = "Platform"
    override val downloadSources = "İndirme ve kaynaklar"; override val openOnGithub = "GitHub'da aç"
    override val feedbackBugs = "Geri bildirim ve hata raporları"; override val writeTelegram = "Telegram'dan yaz"

    override val language = "Dil"; override val langAuto = "Otomatik (sistem)"; override val langRu = "Русский"; override val langEn = "English"
    override val langFa = "فارسی"; override val langZh = "简体中文"; override val langAr = "العربية"; override val langUr = "اردو"
    override val langTr = "Türkçe"; override val langId = "Bahasa Indonesia"; override val langHi = "हिन्दी"; override val langBn = "বাংলা"; override val langMy = "မြန်မာ"
    override val langWord = "Dil"

    override val scanModeTitle = "Ağ modu"; override val scanModeAuto = "Otomatik"; override val scanModeManualLabel = "Elle"
    override val activeModeLabel = "Etkin mod"; override val formingListLabel = "Liste oluşturuluyor"; override val catalogModeTabs = "Mod"
    override val resetModeRatings = "Sunucu derecelendirmelerini sıfırla"; override val forgetModeHosts = "Mod sunucularını unut"
    override val exportModeTitle = "Moda göre dışa aktar"; override val modePickerTitle = "Mod"
    override val modeHelp = "Her ağ modu kendi proxy derecelendirmelerini ve kendi tarama + abonelik indirme yoğunluğunu tutar. «Otomatik» modu etkin ağdan seçer. «Elle» herhangi bir modu kendiniz seçmenizi sağlar (otomatiğin asla seçmediği White dahil)."
    override val autoSelect = "Otomatik seç"; override val manualSelect = "Elle seç"
    override val connStatsTitle = "Şu anki bağlantılar"; override val connOnPort = "Porttaki bağlantılar"; override val outgoingConns = "Giden bağlantılar"
    override val modeChoice = "Mod seçimi"; override val autoChoice = "otomatik seçim"; override val manualChoice = "elle sabit"
    override val directOnVpn = "VPN'de TG'ye doğrudan bağlan"; override val onWord = "açık"; override val offWord = "kapalı"
    override val directStateActive = "etkin"; override val directStateOff = "ayarlarda kapalı"; override val directStateIdle = "ayarlarda açık, ama etkin değil"
    override val wpHintTitle = "White nedir?"
    override val wpHint = "White — WhitePages: elle bir ağ profili. Yalnızca elle etkinleştirilir (otomatik seçim asla seçmez). " +
        "Kendi sunucu derecelendirmelerini tutar, abonelikleri indirir ve VPN/Wi-Fi/LTE'den bağımsız olarak tarar."

    override val recentAttempts = "Son bağlantılar ve kontroller"
    override val kindCheck = "kontrol"
    override val kindTg = "telegram"
    override val histWho = "Kim"
    override val histWhen = "Ne zaman"
    override val histReq = "İstek"
    override val histSess = "Oturum"
    override val histScan = "tarama"
    override val testNow = "Şimdi test et"
    override val testShort = "Test"
    override val testResult = "Test sonucu"
    override val testStop = "Durdur"
    override val testingNow = "test ediliyor…"
    override val prewarmTitle = "Soketleri ön ısıt (deneysel)"
    override val prewarmHelp = "Yeni bir Telegram bağlantısının bağlanma/el sıkışmayı atlayabilmesi için önceden " +
        "birkaç üst akış proxy soketini bağlı tutar. Deneysel: arka planda sürekli yeniden bağlanır, bu yüzden " +
        "trafik ve biraz CPU harcar. Sahte trafik gönderilmez (gerçek oturumu bozardı) — soketler yalnızca " +
        "döndürülür. En çok FakeTLS proxy'leriyle kullanışlıdır."
    override val prewarmEnable = "Ön ısıtmayı etkinleştir"
    override val prewarmModeDeferred = "Ertelenmiş (yalnızca TLS)"
    override val prewarmModeDeferredSub = "TCP + FakeTLS tut; başlatmayı devirde tamamla. DC bağlanmaz — en gerçekçi."
    override val prewarmModeFull = "Tam el sıkışma"
    override val prewarmModeFullSub = "DC'ler arasında tam bağlı soketler tut; yalnızca DC/etiket eşleşmesinde yeniden kullanılır. Daha kısa ömürlü."
    override val prewarmPoolLabel = "Yedek soketler"
    override val prewarmHoldLabel = "Her birini tut, sn"
    override val prewarmNote = "Yalnızca döndürme (uygulama düzeyinde keepalive yok). Bir soket, proxy/DC'ye bağlı olarak saniyelerce ila ~bir dakika sürer."
    override val prewarmStatus = "Ön ısıtma"
    override fun prewarmStatusVal(ready: Int, holdSecs: Int) = "$ready hazır · tut ${holdSecs}sn"
    override val prewarmStar = "Kalın turuncu = ön ısıtma havuzundan sıcak olarak devredilen soket (bağlanma/el sıkışma atlandı)"
    override fun prewarmTableTitle(holdSecs: Int) = "Ön ısıtılan soketler (tut ${holdSecs}sn)"
    override val prewarmTableHelp = "\"Soketleri ön ısıt\", yeni bir Telegram bağlantısının bağlanma/el sıkışmayı " +
        "atlayabilmesi için önceden birkaç proxy soketi açar. Bu tablo ısıtılan soketleri listeler: her birinin ne " +
        "kadar süredir yaşadığı, Telegram'ın onu kullanıp kullanmadığı ve trafik. Daha fazla → Ayarlar → " +
        "\"Soketleri ön ısıt (deneysel)\" bölümünden açıp/kapatabilir ve yapılandırabilirsiniz (mod, soket sayısı, tutma süresi)."
    override val prewarmNoneWarming = "henüz ısıtılan soket yok"
    override val prewarmColAge = "yaş"
    override val prewarmColUse = "TG'de?"
    override val prewarmInUse = "TG'de"
    override val prewarmNew = "yeni"
    override val lanShareTitle = "Yerel ağ üzerinden paylaş (web portalı)"
    override val lanShareDesc = "Bu Wi-Fi'deki diğer cihazların bu AutoConnector'ı proxy olarak kullanmasına izin verin; aşağıdaki adresi açan bir tarayıcı en iyi proxy'lerin bulunduğu bir sayfa alır."
    override val lanShareUrlsLabel = "Komşular şuradan bağlanır:"
    override val lanShareNoIp = "yerel ağ adresi yok — Wi-Fi'ye bağlanın"
    override val lanFirewallTitle = "Yerel ağda izin ver"
    override val lanFirewallBody = "Bunu etkinleştirmek aktarma portlarını yerel ağınıza açar. Windows (veya başka bir) güvenlik duvarı şimdi AutoConnector'a izin verilip verilmeyeceğini sorabilir — İzin Ver / Evet'i seçin. Reddederseniz, komşuların AutoConnector'a giden trafiği engellenir ve sayfa/proxy erişilemez olur."
    override val lanFirewallConfirm = "Etkinleştir"
    override val lanInfoTitle = "Bu ne işe yarar?"
    override val lanInfoBody = "AutoConnector'ı Wi-Fi'nizdeki TEK bir bilgisayarda veya telefonda çalıştırın; aynı ağdaki diğer her cihaz — bu uygulamanın doğrudan desteklemediği iPhone dahil — adresi yalnızca bir tarayıcıda açıp kullanabilir: Telegram'larına eklemek için en iyi proxy'lerin bulunduğu bir sayfa veya bu cihazın kendisi bir SOCKS proxy olarak. Bir cihaz proxy'leri bulup tutar; geri kalanı bunu yerel ağ üzerinden ödünç alır."
    override val volTriggerTitle = "Ses tuşu tetikleyicisi"
    override val volTriggerSub = "Hızlı bir ses tuşu deseniyle proxy değiştir"
    override val volEnableLabel = "Ses tuşlarını izle"
    override val volHelpTitle = "Bu nedir?"
    override val volHelpBody = "Android'de genel klavye kısayol tuşları yoktur, bu yüzden bunun yerine SES tuşları kullanılır. Etkinken AutoConnector arka planda hızlı bir Ses Aç/Kıs basma desenini (örneğin yukarı-yukarı-aşağı-aşağı) izler. Birini tanıdığında, rastgele iyi, canlı bir proxy'nin tg:// bağlantısını açar; böylece Telegram onu yakalar ve geçiş yapar — uygulamayı açmadan proxy döndürmenin hızlı, göze çarpmayan bir yolu. Ses normal çalışmaya devam eder (basışlar yutulmaz). Bu, Erişilebilirlik erişimi gerektirir (ses tuşlarını arka planda okumak ve bağlantıyı başlatmak için); siz anahtarı etkinleştirene kadar hiçbir şey istenmez. Aşağıda basışlar arasındaki maksimum süreyi ayarlayın; tanınan desenler en altta listelenir."
    override val volGrantTitle = "Erişilebilirliği etkinleştir (önemli)"
    override val volGrantBody = "Android (özellikle 13+) Google Play'den YÜKLENMEMİŞ uygulamalar için Erişilebilirliği engeller — bu yüzden AutoConnector soluk görünür ve \"Kısıtlanmış ayar\" / \"erişime izin verilmiyor\" yazar.\n\nEngeli kaldırma:\n1. \"Uygulama bilgileri\"ni açın (aşağıdaki düğme veya Ayarlar → Uygulamalar → AutoConnector for Telegram).\n2. ⋮ menüsüne (sağ üst) dokunun → \"Kısıtlanmış ayarlara izin ver\" → onaylayın.\n3. Geri dönün: Ayarlar → Erişilebilirlik → AutoConnector for Telegram → açın.\n\n\"Kısıtlanmış ayarlara izin ver\" görmüyorsanız, önce Erişilebilirlik'te bir kez açmayı deneyin (engellenmiş mesajını alırsınız), ardından 2. adım görünür.\n\nXiaomi/MIUI, Samsung vb.'de yol biraz farklı olabilir — \"Uygulama bilgileri\"nde aynı ⋮'yi arayın. Android 12 ve daha eskisinde genellikle kısıtlama yoktur — yalnızca Erişilebilirlik'te etkinleştirin.\n\nSes tuşları yalnızca gözlemlenir, asla engellenmez."
    override val volOpenAppInfo = "Uygulama bilgilerini aç"
    override val volAccessOn = "Erişilebilirlik: verildi"
    override val volAccessOff = "Erişilebilirlik: verilmedi"
    override val volOpenAccess = "Erişilebilirlik ayarlarını aç"
    override val volGapLabel = "Basışlar arası maks. ms"
    override val volPatternsTitle = "Tanınan desenler"
    override val volPatternPick = "Desen"
    override val volPatternsLegend = "↑ = ses aç, ↓ = ses kıs"
    override val volNoRights = "Uygulamanın henüz ses tuşlarını işleme izni YOK — bu sayfanın altındaki adımları kullanarak erişim verin."
    override val volGrantShort = "Henüz Erişilebilirlik erişimi yok. Bu sayfanın altındaki ayrıntılı adımları okuyun, ardından \"Kontrol et\"e dokunun."
    override val volCheck = "Kontrol et"
    override val volCheckOk = "✓ Tamam — erişim verildi, tetikleyici çalışıyor."
    override val volCheckFail = "✗ Hâlâ erişim yok — yukarıdaki adımları tamamlayın."
    override val volPatternsList = "↑↑↓↓ · ↓↓↑↑ · ↑↓↑↓ · ↓↑↓↑ · ↑↑↑↑ · ↓↓↓↓ · ↑↓↓↑ · ↓↑↑↓ · ↑↑↑↓↓↓ · ↓↓↓↑↑↑   (↑ = ses aç, ↓ = ses kıs)"
    override val histLegend = "Sütunlar — Kim: ✓/✗ TG = gerçek Telegram bağlantısı, tarama = arka plan kontrolü. Ne zaman: ne kadar önce. TCP/TLS/İstek: el sıkışma ve ilk istek gecikmesi, ms. Oturum: aktarma oturumunun ne kadar sürdüğü. ↓/↑: sunucu üzerinden alınan / gönderilen bayt."
    override val tgOkTotalHint = "Telegram bağlantıları / başarılı / toplam kontroller"
    override val breadthTitle = "Sunucu seçim genişliği"
    override val breadthHelp = "Sol = en iyi kanıtlanmış sunucularda kal; sağ = tüm canlı sunucular arasında olabildiğince geniş dene. Telegram aktarma portlarını sürekli değiştirdiğinde uygulama aramayı otomatik olarak genişletir."
    override val breadthNarrow = "kanıtlanmış"
    override val breadthWide = "en geniş"
    override val connTimeoutTitle = "Sunucu başına bağlanma zaman aşımı"
    override val connTimeoutHelp = "Bir sonraki proxy'ye geçmeden önce bir üst akış (TCP + TLS + ilk MTProto yanıtı) için ne kadar beklenecek."
    override val backupExportTitle = "Verileri dışa aktar"
    override val backupImportTitle = "Verileri içe aktar"
    override val backupSelectExport = "Ne dışa aktarılacak:"
    override val backupSelectImport = "Ne içe aktarılacak:"
    override val backupCopyBtn = "Kopyala"
    override val backupSaveFile = "Dosyaya kaydet"
    override val backupLoadFile = "Dosyadan yükle"
    override val backupDoImport = "İçe aktar"
    override val backupPasteLabel = "Yedek JSON'unu buraya yapıştırın"
    override val backupJsonLabel = "Yedek JSON"
    override val backupAndroidFileNote = "Dosyalar burada kullanılamaz — Kopyala / Yapıştır kullanın."
    override val factoryResetDone = "Her şey sıfırlandı. Lütfen uygulamayı kapatıp tekrar açın."
}
