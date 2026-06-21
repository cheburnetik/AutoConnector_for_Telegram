package io.autoconnector.i18n

object Id : Strings {
    override val tabConnector = "Konektor"; override val tabScan = "Pindai"
    override val tabCatalog = "Katalog"; override val tabLogs = "Log"; override val tabMore = "Lainnya"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "Langganan"; override val logTabScan = "Pindai"
    override val logGeneral = "Umum"; override val logEmpty = "masih kosong"
    override val logSessions = "Sesi"; override val logErrorsOnly = "hanya kesalahan"; override val logNoErrors = "tidak ada sesi yang gagal"
    override fun logSession(id: String, port: String) = "#$id · :$port"
    override val back = "Kembali"; override val copy = "Salin"; override val gotIt = "Mengerti"
    override val later = "Nanti"; override val details = "Detail"; override val whatIsThis = "Apa ini?"
    override val delete = "Hapus"

    override val connector = "Konektor"; override val scan = "Pindai"
    override val notConfigured = "Belum disiapkan! Perbaiki →"; override val howToSetup = "Cara menyiapkan"
    override val notifOff = "Notifikasi mati! Perbaiki →"; override val enable = "Aktifkan"
    override fun fewProxies(n: Int) = "Proksi aktif $n, sedang mencari, tunggu ~15 mnt…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "Proksi aktif: $alive  (15 mnt: $within) · total: $total"
    override val notifWhyTitle = "Mengapa perlu notifikasi?"
    override val notifWhyBody = "Ikon notifikasi yang menetap berarti layanan latar depan Android. " +
        "Tanpa itu sistem akan mengeluarkan aplikasi dari memori dan aplikasi berhenti mencari proksi serta " +
        "menjaga koneksi di latar belakang. Itulah sebabnya notifikasi diperlukan agar " +
        "AutoConnector dapat bekerja."
    override val notifEnableTitle = "Aktifkan notifikasi"
    override val notifEnableBody = "Tanpa ikon notifikasi, Android menganggap aplikasi tidak aktif dan " +
        "mengeluarkannya dari memori. Kemudian AutoConnector berhenti mencari proksi dan menjaga " +
        "koneksi di latar belakang — Telegram kehilangan tautannya.\n\nKetuk \"Aktifkan\" dan izinkan " +
        "notifikasi untuk AutoConnector."
    override val notifPlea = "Aktifkan notifikasi! Tanpanya aplikasi tidak dapat berjalan di latar belakang — " +
        "Android akan mengeluarkannya dan pencarian proksi serta koneksi akan berhenti."

    override val statusConnected = "Telegram terhubung"; override val statusConnecting = "Menghubungkan…"
    override val statusOffline = "Telegram tidak terhubung"; override val statusIdle = "Telegram menganggur"
    override val nobodyConnected = "Tidak ada yang terhubung ke Konektor. "; override val howToSetupArrow = "Cara menyiapkan →"
    override val directModeViaVpn = "Mode langsung: VPN aktif — tanpa proksi"
    override val directModeOff = "Mode langsung: proksi mati"
    override val directDpiSuffix = " · anti-DPI"
    override val connections = "Koneksi"; override val sockets = "Soket"; override val speed = "Kecepatan"
    override val traffic = "Trafik"; override val latency = "Latensi"
    override fun pcs(n: Int) = "$n bh"
    override fun netNow(label: String) = "Jaringan: $label"
    override fun tgToConnector(n: Int) = "TG→ $n"
    override fun connectorToProxy(n: Int) = "proksi $n"
    override val trafficSec = "trafik · 60 dtk"; override val trafficMin = "trafik · 60 mnt"
    override val latencySec = "latensi · 60 dtk"; override val latencyMin = "latensi · 60 mnt"
    override val sec60 = "60 dtk"; override val min60 = "60 mnt"
    override val unitSec = "d"; override val unitMin = "m"; override val unitHour = "j"; override val dash = "—"
    override val currentProxy = "Proksi saat ini"; override val noActiveProxy = "tidak ada proksi aktif (Telegram tidak terhubung)"
    override val host = "Host"; override val type = "Tipe"; override val secret = "Secret"; override val antiDpi = "Anti-DPI"; override val obfEngine = "Mesin obfuskasi"
    override fun activeSockets(n: Int) = "Soket Telegram aktif: $n"
    override val noConnections = "tidak ada koneksi aktif"; override val colHost = "Host"; override val colTime = "Waktu"
    override val modeWord = "Mode"; override val directViaVpnLine = "Permintaan langsung ke Telegram (VPN aktif)"
    override val connModeHelp = "Mode (VPN, Wi-Fi, LTE, Ethernet, White) memungkinkan Anda menyetel intensitas pindai secara berbeda dan menyimpan peringkat/statistik host terpisah. Kartu jaringan dideteksi secara otomatis; mode dapat diatur manual di pengaturan."

    override val scanOff = "Pemindaian mati"; override val proxiesInBase = "Proksi dalam basis data"
    override val total = "total"; override val alive = "aktif"; override val dead = "mati"
    override val tgConnectedTitle = "Telegram terhubung melalui"; override val successful = "berhasil"
    override val socketsHeld = "Masa hidup soket"; override val over1m = ">1 mnt"; override val over5m = ">5 mnt"; override val over15m = ">15 mnt"
    override val scanCountTitle = "Jumlah pemeriksaan proksi"; override val checked = "Diperiksa"
    override val forAllTime = "sepanjang waktu"; override val perMinute = "per menit"; override val perHour = "per jam"
    override val subsCountTitle = "Jumlah unduhan langganan"; override val downloaded = "terunduh"; override val failed = "gagal"; override val scanTraffic = "trafik pindai"; override val subTraffic = "trafik langganan"; override val subTrafficGraph = "Trafik langganan"
    override val checksMtproto = "Pemeriksaan MTProto (↑ ok · ↓ gagal)"

    override fun catalogEmpty(mode: String) = "Katalog $mode masih kosong. Entah belum ada host yang ditemukan, atau aplikasi belum pernah berjalan dalam mode ini. Anda dapat mengubah mode di Pengaturan. Mode ada untuk mengumpulkan host secara terpisah untuk berbagai jenis koneksi internet."
    override val aliveShort = "✓ aktif"; override val deadShort = "✗ mati"
    override val statusLabel = "Status"; override val rating = "Peringkat"; override val port = "Port"
    override val rttPing = "RTT (ping)"; override val checkedField = "Diperiksa"; override val okOfTotal = "Pemeriksaan berhasil / total"
    override val tgConnectedField = "Telegram terhubung"; override val tgSessions = "Sesi Telegram"; override val trafficThroughProxy = "Trafik melalui proksi"
    override val sessionsTotal = "Total sesi"; override val relayNow = "Relai sekarang"; override val tlsDomain = "Domain TLS (SNI)"
    override val sourceSub = "Sumber (langganan)"; override val lastError = "Kesalahan terakhir"; override val yes = "ya"; override val no = "tidak"
    override val copyAsLink = "Salin sebagai tautan"; override val openInTelegram = "Buka host di Telegram"; override val makeNextRelay = "Jadikan relai berikutnya"
    override val actCopy = "Salin"; override val actOpen = "Buka"; override val actRelay = "Relai"
    override fun agoFmt(v: String) = "$v lalu"
    override val catalogTopFor = "Daftar/peringkat proksi untuk"
    override val catalogModeHelpTitle = "Mode & peringkat"
    override val catalogModeHelp = "Aplikasi menghitung host aktif dan peringkatnya SECARA TERPISAH per mode jaringan (VPN, Wi-Fi, LTE, Ethernet dan White). «White» adalah mode MANUAL terpisah untuk daftar putih; auto tidak pernah beralih ke sana. Jadi host yang sama bisa aktif dalam satu mode dan mati dalam mode lain."
    override fun catalogInactiveWarn(section: String, active: String) =
        "Anda sedang melihat bagian tidak aktif $section — semua statistik saat ini masuk ke $active, bukan ke sini."
    override val manageModeTitle = "Kelola mode"
    override val manageResetRating = "Atur ulang peringkat"
    override fun manageResetHint(mode: String) = "Khusus untuk $mode Anda dapat mengatur ulang peringkat dan statistik penggunaan host aktif. Ini berguna saat Anda terhubung ke VPN atau LTE yang sangat berbeda, agar statistik lama tidak mengganggu. Atau untuk melihat seberapa cepat pemindaian proksi memeriksa ulang semuanya dari awal."
    override val manageDeleteAll = "Hapus host di"
    override fun manageDeleteHint(mode: String) = "Anda dapat menghapus baik peringkat maupun host itu sendiri dari $mode. Fitur \"Pindai proksi\" akan mengumpulkannya lagi. Ini bukan pengaturan ulang langganan — Anda dapat mengetuknya, lalu tunggu ~15 menit untuk pemindaian ulang."
    override fun manageCopyFrom(mode: String) = "Salin semua host dan peringkat ke mode ini ($mode) dari mode lain:"
    override val live = "aktif"; override val deadW = "mati"; override val unitMs = "md"
    override val agoMin = "m"; override val agoHour = "j"; override val agoDay = "h"

    override val connectTelegram = "Menghubungkan Telegram"; override val readCarefully = "Baca dengan saksama!"
    override val guideIntro = "Aplikasi ini tidak akan bekerja tanpa pengaturan. Pilih salah satu dari 3 opsi di bawah " +
        "dan ikuti petunjuknya dengan saksama."
    override val variant1 = "Opsi #1 — tombol"
    override val variant1Body = "Ketuk \"Proksi {A}\" — Telegram terbuka, konfirmasikan penambahan proksi. Kembali " +
        "ke layar ini dan ketuk \"Proksi {B}\" — konfirmasikan penambahan kedua kalinya.\n\nNonaktifkan " +
        "proksi lama lainnya di Telegram. Harus tersisa tepat 2 proksi — dengan port {A} dan {B}. " +
        "Dengan susunan lain AutoConnector tidak akan bekerja."
    override val variant2 = "Opsi #2 — tautan"
    override val variant2Body = "Salin teks di bawah ke Pesan Tersimpan (atau obrolan apa pun) di Telegram — " +
        "yaitu kirim ke diri sendiri. Ketuk tautan pertama di pesan Anda — proksi pertama ditambahkan. " +
        "Ketuk tautan kedua — yang kedua ditambahkan. Lalu nonaktifkan semua proksi lama."
    override val variant3 = "Opsi #3 — manual"
    override val variant3Body = "Tambahkan proksi SOCKS5 secara manual: server localhost (127.0.0.1), port {A}. " +
        "Lalu proksi kedua: localhost, port {B}. Hapus proksi lama mana pun."
    override val whatNext = "Apa selanjutnya?"
    override val whatNextBody = "Di Telegram, aktifkan \"alih-otomatis proksi\" — 5 detik. Anda dapat membantu " +
        "Telegram terhubung dengan mengetuk manual sebuah proksi (di dalam Telegram) yang TIDAK aktif atau ditandai " +
        "\"tidak tersedia\" — itu membuat Telegram berusaha lebih keras untuk terhubung.\n\nPastikan semua proksi lama " +
        "lainnya dihapus, kecuali {A} dan {B}. Ketuk " +
        "\"Gunakan proksi\" di Telegram.\n\nTunggu sementara aplikasi menemukan dan mengunduh cukup proksi " +
        "(5–15 menit). Lalu Telegram terhubung ke AutoConnector dengan sendirinya, yang akan terus merutekan " +
        "Telegram melalui proksi terbaik: terverifikasi, aktif dan cepat.\n\nJika petunjuknya tampak " +
        "sulit — maaf, Anda tidak akan dapat menggunakan aplikasi ini: tidak mungkin menyiapkan semuanya " +
        "secara otomatis, dan menemukan proksi aktif membutuhkan waktu.\n\nJika Anda mengunduh aplikasi ini lama " +
        "lalu dan tidak ada proksi aktif yang ditemukan — perbarui aplikasinya atau daftar langganan. Aplikasi ini " +
        "tidak menciptakan atau menyediakan proksinya sendiri, ia hanya mencari di internet di puluhan " +
        "grup dan halaman."
    override fun proxyBtn(port: Int) = "Proksi $port"

    override val setupPortsTitle = "Siapkan port di Telegram"
    override val setupPortsSub = "Cara menghubungkan Telegram ke Konektor (port 55001/55002)"
    override val settings = "Pengaturan"; override val settingsSub = "Port, anti-DPI, pindai, jaringan, baterai"
    override val subscriptions = "Langganan"; override val subscriptionsSub = "Sumber proksi untuk dipindai"
    override val statistics = "Statistik"; override val statisticsSub = "Basis data proksi + trik anti-DPI"
    override val export = "Ekspor"; override val exportSub = "Tautan tg:// proksi aktif"
    override val about = "Tentang"; override val aboutSub = "Versi, build, unduh, masukan"
    override val hotkeys = "Pintasan"
    override val hotkeysSub = "Tombol global: salin / buka proksi"
    override val hotkeysIntro = "Pintasan global aktif bahkan saat jendela aplikasi tidak fokus. Pintasan ini memilih " +
        "tautan proksi aktif (tg://) secara acak dari kumpulan — berguna untuk beralih proksi dengan cepat tanpa " +
        "membuka aplikasi."
    override val hotkeysNote = "Di macOS, menangkap tombol mungkin memerlukan izin Aksesibilitas " +
        "(Pengaturan Sistem → Privasi & Keamanan → Aksesibilitas)."
    override val hotkeyCopyTitle = "Salin tautan proksi"
    override val hotkeyCopyDesc = "Menaruh tautan tg:// aktif acak ke papan klip."
    override val hotkeyEnable = "Aktifkan pintasan"; override val hotkeyLetterLabel = "Huruf"; override val hotkeySet = "Setel"; override val hotkeyReset = "Atur ulang"
    override val hotkeyOpenTitle = "Buka proksi di Telegram"
    override val hotkeyOpenDesc = "Membuka tautan aktif acak — Telegram menangkapnya dan menawarkan untuk menghubungkan proksi."

    override val relayPorts = "Port relai"
    override val relayPortsHelp = "Port lokal yang didengarkan Konektor. Anda memasukkan tepat port ini di " +
        "Telegram sebagai proksi SOCKS5 (127.0.0.1 : port). Dua port digunakan untuk keandalan — Telegram " +
        "menjaga koneksi ke keduanya."
    override val portA = "Port A"; override val portB = "Port B"
    override val antiDpiTrick = "Trik anti-DPI"
    override val antiDpiHelp = "Cara menyamarkan koneksi agar ISP/DPI tidak mengenali dan " +
        "memblokirnya.\n• \"Putar otomatis\" memilih trik yang berfungsi sendiri.\n• \"Tanpa trik DPI\" — koneksi " +
        "biasa.\n• Sisanya adalah teknik spesifik (peniruan peramban, pemecahan paket, dll.)."
    override val onlyFakeTls = "Hanya FakeTLS (ee)"
    override val applyDpiTo = "Terapkan anti-DPI ke"
    override val applyDpiHelp = "Apa yang akan diterapkan trik anti-DPI terpilih:\n• Relai Telegram — ke " +
        "koneksi Telegram langsung melalui Konektor.\n• Probe proksi — ke pemeriksaan proksi latar belakang " +
        "(maka pemeriksaan berperilaku persis seperti koneksi nyata, dan statistik trik lebih akurat).\n" +
        "• Saat terhubung langsung — saat proksi mati (atau dilewati selama VPN aktif) dan Telegram " +
        "langsung ke servernya: di sini tidak ada proksi, jadi trik tersebut menyusut menjadi pemecahan " +
        "paket TCP pertama (handshake) menjadi beberapa segmen kecil agar DPI tidak dapat mencocokkannya dalam satu pembacaan."
    override val toRelay = "Relai Telegram"; override val toProbes = "Probe proksi"
    override val toDirect = "Saat terhubung langsung"
    override val vpnSection = "Saat VPN aktif"
    override val vpnHelp = "Apa yang harus dilakukan saat VPN aktif di perangkat:\n• Melalui proksi MTProto — " +
        "Telegram melewati proksi yang ditemukan seperti biasa (di atas VPN).\n• Langsung — " +
        "Konektor TIDAK menggunakan proksi dan menghubungkan Telegram langsung ke server Telegram: " +
        "VPN sudah menyediakan akses, lapisan proksi tambahan tidak diperlukan (lebih cepat dan lebih stabil). " +
        "Tanpa VPN proksi digunakan seperti biasa."
    override val linkFormat = "Format tautan proksi"
    override val linkFormatHelp = "Cara menyalin dan membuka proksi. tg:// membuka Telegram langsung (perlu Telegram Desktop terpasang). http (t.me) membuka melalui peramban dan menawarkan untuk membuka di Telegram — berguna jika tg:// tidak terdaftar."
    override val linkTg = "tg:// (buka Telegram langsung)"; override val linkTgSub = "tg://proxy?… — membuka Telegram"
    override val linkHttp = "http (t.me, via peramban)"; override val linkHttpSub = "https://t.me/proxy?… — membuka peramban"
    override val viaMtproto = "Proksi via MTProto"; override val viaMtprotoSub = "bahkan dengan VPN, trafik melewati proksi"
    override val directly = "Hubungkan langsung"; override val directlySub = "dengan VPN aktif — lewati proksi, langsung ke Telegram"
    override val notifications = "Notifikasi"
    override val scanCheck = "Pindai & periksa"
    override val scanCheckHelp = "• Pindai, mnt — seberapa sering mengunduh daftar proksi dari langganan.\n" +
        "• Periksa, mnt — seberapa sering memeriksa ulang keaktifan proksi dalam basis data.\n• Ukuran batch — " +
        "berapa banyak proksi yang diperiksa per proses.\n• Paralel — berapa banyak pemeriksaan yang dijalankan sekaligus (lebih banyak = " +
        "lebih cepat, tetapi beban jaringan dan baterai lebih tinggi)."
    override val scanMin = "Pindai, mnt"; override val checkMin = "Periksa, mnt"; override val batchSize = "Ukuran batch"; override val parallel = "Paralel"
    override val speedByNet = "Intensitas pindai per jaringan"
    override val speedByNetHelp = "Seberapa sering memeriksa proksi tergantung jaringan saat ini. " +
        "\"Standar\" = interval dasar. Geser ke kanan untuk lebih jarang (lebih lambat, lebih hemat trafik/baterai), " +
        "ke kiri untuk lebih sering (lebih cepat, lebih agresif). Skala logaritmik, hingga ×100 ke tiap arah.\n" +
        "• VPN — saat VPN eksternal aktif.\n• Wi-Fi — pada jaringan Wi-Fi.\n• LTE — pada jaringan seluler."
    override val intensStandard = "standar"
    override val intensSlower = "lebih lambat"
    override val intensFaster = "lebih cepat"
    override val maintenance = "Atur ulang data"
    override val maintenanceHelp = "• \"Atur ulang katalog & statistik\" — menolkan peringkat, penghitung, trafik " +
        "dan log pemeriksaan, tetapi menjaga host dan langganan yang terunduh (semuanya dinilai ulang pada " +
        "pemindaian berikutnya).\n• \"Hapus host terunduh\" — menghapus seluruh kumpulan proksi tetapi menjaga " +
        "langganan agar pemindaian mengisi ulang kumpulan. Langganan tidak pernah disentuh dengan cara apa pun."
    override val backupTitle = "Ekspor / Impor"
    override val backupHelp = "Simpan atau pulihkan data aplikasi dalam satu berkas JSON. Centang apa yang akan " +
        "disertakan — kombinasi apa pun:\n• Pengaturan — semua parameter aplikasi.\n• Langganan — daftar " +
        "sumber (URL + nyala/mati).\n• Katalog host aktif — setiap proksi aktif dengan peringkat dan statistiknya " +
        "PER mode jaringan.\n\n«Ekspor» menanyakan tempat menyimpan; «Impor» menanyakan berkas mana yang akan dibuka dan " +
        "menerapkan hanya bagian yang dicentang yang ada di dalamnya. Impor MENAMBAH ke data saat ini (tanpa menghapus)."
    override val backupSettings = "Pengaturan"
    override val backupSubs = "Langganan"
    override val backupHosts = "Katalog host aktif (per mode)"
    override val exportWord = "Ekspor"
    override val importWord = "Impor"
    override val eraseAllHosts = "Hapus semua host"
    override val factoryReset = "Atur ulang semuanya (seperti peluncuran pertama)"
    override val factoryResetConfirm = "Atur ulang aplikasi sepenuhnya ke keadaan pabrik? SEMUA pengaturan dan seluruh " +
        "katalog host akan dihapus, langganan dipulihkan ke bawaan. Persis seperti peluncuran pertama."
    override val resetCatalog = "Atur ulang katalog & statistik"
    override val resetCatalogConfirm = "Nolkan semua peringkat, penghitung dan log pemeriksaan? " +
        "Host dan langganan yang terunduh tetap dijaga dan dinilai ulang pada pemindaian berikutnya."
    override val clearHosts = "Hapus host terunduh"
    override val clearHostsConfirm = "Hapus seluruh daftar host (proksi) yang terunduh? " +
        "Langganan dijaga dan pemindaian akan mengisi ulang kumpulan."
    override val doReset = "Atur ulang"
    override val doCancel = "Batal"
    override val adaptiveSpeed = "Kecepatan adaptif"
    override val adaptiveHelp = "Pemeriksaan keaktifan berjalan pada interval dasar (dari \"Pindai & periksa\", juga " +
        "dikalikan dengan pengali jaringan). \"Kecepatan adaptif\" mempercepat atau memperlambatnya " +
        "secara otomatis berdasarkan berapa banyak proksi yang saat ini aktif.\n\n" +
        "• SEDIKIT aktif (di bawah ambang \"Sedikit\") → interval × \"Percepat\". Pengali di bawah 1 = lebih " +
        "sering: 0.5 — dua kali lebih sering, 0.25 — 4×. Mengisi ulang kumpulan lebih cepat.\n" +
        "• BANYAK aktif (di atas ambang \"Banyak\") → interval × \"Perlambat\". Di atas 1 = lebih jarang: 2 — " +
        "setengah sesering, 4 — seperempat. Menghemat baterai dan trafik.\n" +
        "• Di antara ambang — kecepatan dasar (×1).\n\n" +
        "Contoh:\n" +
        "— Kumpulkan proksi lebih cepat: \"Percepat\" 0.25 dan/atau ambang \"Sedikit\" 40.\n" +
        "— Hemat baterai saat sudah cukup: \"Perlambat\" 8 dan/atau ambang \"Banyak\" 30.\n" +
        "— Nonaktifkan adaptasi: setel kedua pengali ke 1.\n\n" +
        "Bawaan: Sedikit 20, Percepat 0.5, Banyak 50, Perlambat 4."
    override val threshMany = "Ambang \"Banyak\""; override val threshFew = "Ambang \"Sedikit\""; override val mulFast = "Percepat ×"; override val mulLazy = "Perlambat ×"
    override val subIntensityTitle = "Intensitas langganan"
    override val subIntensityHint = "Jeda antara unduhan langganan: berapa menit sebelum mengunduh ulang daftar proksi (terpisah per mode jaringan)."
    override val baseScanTitle = "Kecepatan pindai dasar"
    override val baseScanHelp = "Kecepatan pemeriksaan keaktifan acuan. «Kecepatan adaptif» dan pengali «Kecepatan per " +
        "mode» dihitung relatif terhadapnya.\n\n" +
        "• Seberapa sering dijalankan, mnt — interval antara proses pemeriksaan.\n" +
        "• Batch per utas, host — berapa banyak host yang diperiksa tiap utas per proses.\n" +
        "• Utas — berapa banyak pemeriksaan yang berjalan sekaligus. Satu proses memeriksa «batch × utas» host.\n" +
        "• Jangan pindai ulang host lebih sering dari setiap N mnt — anti-banjir: host yang baru saja diperiksa " +
        "dilewati pada proses ini.\n\n" +
        "Lebih banyak utas dan batch lebih besar = pertumbuhan kumpulan lebih cepat, tetapi beban lebih berat pada jaringan dan baterai."
    override val baseScanPeriod = "Seberapa sering dijalankan, mnt"
    override val baseScanBatch = "Batch per utas, host"; override val baseScanThreads = "Jumlah utas"
    override val adaptiveDesc = "Jika proksi aktif kurang dari «sedikit» atau lebih dari «banyak», terapkan pengali tambahan."
    override val fewWord = "Sedikit"; override val manyWord = "Banyak"
    override fun fasterX(x: String) = "$x× lebih cepat"
    override fun slowerX(x: String) = "$x× lebih lambat"
    override fun ifAliveLt(n: Int) = "Jika proksi aktif < $n, maka:"
    override fun ifAliveGt(n: Int) = "Jika proksi aktif > $n, maka:"
    override val disabledWord = "mati"
    override val speedByModeTitle = "Kecepatan per mode"
    override val speedByModeHelp = "Pengali kecepatan pindai untuk tiap mode jaringan, di atas kecepatan " +
        "dasar. «Standar» (×1) = interval dasar. Kanan — lebih jarang (lebih lambat, lebih hemat trafik/" +
        "baterai), kiri — lebih sering (lebih cepat, lebih agresif). Skala logaritmik, hingga ×100 ke tiap " +
        "arah.\n\n" +
        "Di bawah tiap penggeser ada parameter proses hasil dengan kecepatan adaptif diterapkan — " +
        "ditampilkan terpisah untuk «sedikit aktif» (× «Percepat») dan «banyak aktif» (× «Perlambat»).\n\n" +
        "Mode:\n• VPN — VPN eksternal aktif.\n• LTE — jaringan seluler.\n• Wi-Fi — jaringan Wi-Fi.\n" +
        "• Ethernet — koneksi kabel.\n• White — mode proksi «white» manual."
    override val aliveLt = "aktif <"; override val aliveGt = "aktif >"
    override val periodWord = "periode"; override val nonstopWord = "tanpa henti"
    override val batchWord = "batch"; override val threadsWord = "utas"; override val scanModeOff = "pindai mati"
    override val netBattery = "Jaringan & baterai"
    override val netBatteryHelp = "• Hanya Wi-Fi — jangan memindai pada jaringan seluler (menghemat data).\n• Hanya " +
        "saat mengisi daya — bekerja hanya saat ponsel sedang diisi daya.\n• Lewati saat baterai lemah — jeda pemindaian saat " +
        "baterai lemah."
    override val onlyWifi = "Hanya Wi-Fi"; override val onlyCharging = "Hanya saat mengisi daya"; override val skipLowBattery = "Lewati saat baterai lemah"
    override val autosaved = "Pengaturan disimpan secara otomatis."
    override val dpiAutoLabel = "Putar otomatis trik DPI"; override val dpiNoneLabel = "Tanpa trik DPI (biasa)"
    override val experimental = "Eksperimental"
    override val experimentalHelp = "Mesin proksi alternatif untuk upstream MTProto plus log diagnostik. " +
        "Jalur acuan (yang berfungsi) tidak berubah saat disetel ke «Mati». Hanya CARA aliran terenkripsi ditulis ke " +
        "soket TCP upstream yang berubah (ukuran segmen, pewaktuan, batas rekaman TLS) — aliran itu sendiri tetap identik bita demi bita. " +
        "Berlaku hanya untuk relai proksi langsung (bukan probe, bukan jalur langsung)."
    override val expEngineTitle = "Mesin proksi (obfuskasi soket)"
    override val expConnectTitle = "Mesin koneksi (pemilihan upstream)"
    override val raceWidthTitle = "Koneksi paralel"
    override val connectionSection = "Koneksi & lewati blokir"
    override val connectionSectionHelp = "Mesin koneksi, upstream paralel, mesin proksi dan trik anti-DPI — semua dalam satu bagian."
    override val netLogSection = "Log pertukaran jaringan"
    override val expEngineWarn = "⚠ Mode eksperimental. Jika konektivitas memburuk, kembali ke «Mati (jalur acuan)»."
    override val netLog = "Aktifkan log pertukaran jaringan"
    override val netLogSub = "Menulis SIAPA-KE-SIAPA-KAPAN dan ukuran paket ke berkas (TANPA data muatan) — " +
        "untuk membandingkan pola pertukaran dengan vs. tanpa VPN."
    override val openLogFolder = "Buka folder log"; override val copyPath = "Salin jalur"
    override val helpShow = "Bantuan"; override val helpHide = "Sembunyikan bantuan"
    override val quickSwitchIntro = "Di sini Anda dapat memilih trik lewati blokir. Jika Telegram menampilkan kesalahan " +
        "“The proxy you are using is not configured correctly and will be disabled. Please find another " +
        "one”, bereksperimenlah dengan jenis obfuskasi trafik mana yang berfungsi agar Telegram berhenti menampilkannya. Mulai " +
        "dengan mode split*. Mode coalesce* juga berfungsi, tetapi gambar/video memuat buruk di Telegram dengannya."
    override val quickSwitchTitle ="Lewati blokir"; override val quickSwitchSub = "Pembentukan, koneksi, anti-DPI"

    override val sourceUrl = "URL sumber"
    override fun sourceAlive(alive: Int, total: Int) = "aktif $alive/$total"
    override val open = "Buka"; override val active = "Aktif"; override val inactive = "Tidak aktif"
    override val lastDownloaded = "Terunduh"; override val notDownloaded = "belum terunduh"
    override fun sourceCounts(dead: Int, total: Int) =
        " aktif, $dead mati, $total total"

    override val proxyBase = "Basis data proksi"
    override val totalInBase = "Total dalam basis data"; override val aliveNow = "Aktif sekarang"; override val deadStat = "Mati"
    override val aliveIn15 = "Aktif dalam 15 mnt"; override val checksAllTime = "Pemeriksaan sepanjang waktu"
    override val antiDpiTricks = "Trik anti-DPI"; override val noStatsYet = "belum ada data — trik terakumulasi saat pemeriksaan/koneksi terjadi"
    override val attempts = "Percobaan"; override val handshake = "Handshake"; override val score = "Skor"
    override val tgConnect = "Koneksi TG"; override val socketsOver1m = "Soket >1mnt"
    override val over10kb = "Soket >10KB"; override val over100kb = ">100KB"; override val workTime = "Waktu kerja"
    override val statsLegend = "Handshake — handshake berhasil (% dari percobaan) · Skor — nilai · " +
        "\"Waktu kerja\" — total atas soket ≥5KB dan lebih lama dari 1 menit."
    override val resetStats = "Atur ulang statistik trik"

    override fun aliveLinks(n: Int) = "Tautan aktif: $n"
    override val copyAll = "Salin semua"
    override val openRandom = "Buka acak"; override val copyRandom = "Salin acak"; override val allShort = "SEMUA"
    override val copyTop = "Salin TERATAS"; override val randomHost = "Host acak"
    override val exportToFile = "Ekspor ke berkas"; override val exportSaved = "Disimpan ke berkas:"
    override val dlNow = "Unduh sekarang"
    override fun downloadingFmt(sec: Long) = "Mengunduh… ${sec}d"
    override val cancel = "Batal"
    override val deleteConfirmTitle = "Hapus langganan?"
    override val subscriptionsAddHint = "Tambahkan langganan atau tautan proksi →"
    override val addSourcesTitle = "Tambah"
    override val addSubsLabel = "Langganan (satu URL per baris)"
    override val addSubsHelp = "Setiap baris dengan URL yang valid menjadi langganan tersendiri dan diambil secara berkala."
    override val addProxiesLabel = "Tautan proksi siap (daftar tetap)"
    override val addProxiesHelp = "Tempel sekumpulan tautan ke proksi tertentu (tg://proxy, https://t.me/proxy, …). Ini BUKAN langganan — daftar tidak pernah diunduh, proksi hanya ditambahkan ke katalog."
    override val addButton = "Tambah"
    override fun addedFmt(subs: Int, proxies: Int) = "Ditambahkan: $subs langganan, $proxies proksi"
    override val perSecond = "per dtk"
    override val graphSpeed = "Kecepatan"
    override val graphVolume = "Volume"
    override val graphLatency = "Ping"
    override val graphConnects = "Koneksi"
    override val scanNow = "Pindai sekarang"; override val scanOnShort = "Pindai nyala"
    override val scanRunning = "Pindai berjalan"; override val scanIdle = "Pindai menganggur"; override val scanOffState = "Pindai MATI"; override val scanBatchPerThread = "Batch/utas"; override val scanPassHosts = "Host dalam proses"; override val minRescanLabel = "Jangan pindai ulang host lebih sering dari setiap N mnt"
    override val scanPlanTitle = "Rencana"; override val scanNowTitle = "Sekarang"; override val currentScheduleTitle = "Jadwal saat ini"
    override val scheduleWord = "Jadwal"; override val unitPcsPerSec = "bh/d"
    override val scanNowThreadsLabel = "Utas berjalan sekarang"; override val scanNowPerThreadLabel = "Pemeriksaan per utas (rencana)"; override val scanNowElapsedLabel = "Waktu berjalan"
    override val scanOkGraph = "Pindai berhasil"; override val scanFailGraph = "Pindai gagal"; override val scanTrafficGraph = "Trafik pindai"; override val scanAliveGraph = "Total proksi aktif"; override val scanPingGraph = "Ping"; override val threadsGraph = "Utas"
    override val scanEvery = "Setiap"; override val scanNextRun = "Jalankan berikutnya"
    override val scanThreads = "Utas"; override val scanBatch = "Batch"
    override val scanElapsed = "Berjalan"; override val scanIdleNow = "—"
    override val effForFew = "Saat sedikit"; override val effForMany = "Saat banyak"
    override val effCheck = "Periksa"; override val effBatch = "Batch"; override val effPar = "Paralel"
    override val effContinuous = "berkelanjutan"; override val secShort = "d"; override val minShort = "mnt"

    override val appTagline = "Auto-konektor lintas platform: menemukan, memeriksa dan menjalankan proksi MTProto " +
        "yang dilalui Telegram."
    override val version = "Versi"; override val buildDate = "Tanggal build"; override val platform = "Platform"
    override val downloadSources = "Unduh & sumber"; override val openOnGithub = "Buka di GitHub"
    override val feedbackBugs = "Masukan & laporan bug"; override val writeTelegram = "Tulis di Telegram"

    override val language = "Bahasa"; override val langAuto = "Otomatis (sistem)"; override val langRu = "Русский"; override val langEn = "English"
    override val langFa = "فارسی"; override val langZh = "简体中文"; override val langAr = "العربية"; override val langUr = "اردو"
    override val langTr = "Türkçe"; override val langId = "Bahasa Indonesia"; override val langHi = "हिन्दी"; override val langBn = "বাংলা"; override val langMy = "မြန်မာ"
    override val langWord = "Bahasa"

    override val scanModeTitle = "Mode jaringan"; override val scanModeAuto = "Otomatis"; override val scanModeManualLabel = "Manual"
    override val activeModeLabel = "Mode aktif"; override val formingListLabel = "Menyusun daftar"; override val catalogModeTabs = "Mode"
    override val resetModeRatings = "Atur ulang peringkat host"; override val forgetModeHosts = "Lupakan host mode"
    override val exportModeTitle = "Ekspor per mode"; override val modePickerTitle = "Mode"
    override val modeHelp = "Setiap mode jaringan menyimpan peringkat proksinya sendiri serta intensitas pindai + unduhan langganannya sendiri. «Otomatis» memilih mode dari jaringan aktif. «Manual» memungkinkan Anda memilih mode apa pun sendiri (termasuk White, yang tidak pernah dipilih auto)."
    override val autoSelect = "Pilih otomatis"; override val manualSelect = "Pilih manual"
    override val connStatsTitle = "Koneksi sekarang"; override val connOnPort = "Koneksi pada port"; override val outgoingConns = "Koneksi keluar"
    override val modeChoice = "Pemilihan mode"; override val autoChoice = "pilih otomatis"; override val manualChoice = "tetap manual"
    override val directOnVpn = "Koneksi langsung ke TG saat VPN"; override val onWord = "nyala"; override val offWord = "mati"
    override val directStateActive = "aktif"; override val directStateOff = "mati di pengaturan"; override val directStateIdle = "nyala di pengaturan, tetapi tidak aktif"
    override val wpHintTitle = "Apa itu White?"
    override val wpHint = "White — WhitePages: profil jaringan manual. Diaktifkan hanya secara manual (pilih otomatis tidak pernah memilihnya). " +
        "Menyimpan peringkat hostnya sendiri, mengunduh langganan dan memindai secara independen dari VPN/Wi-Fi/LTE."

    override val recentAttempts = "Koneksi & pemeriksaan terakhir"
    override val kindCheck = "pemeriksaan"
    override val kindTg = "telegram"
    override val histWho = "Siapa"
    override val histWhen = "Kapan"
    override val histReq = "Permintaan"
    override val histSess = "Sesi"
    override val histScan = "pindai"
    override val testNow = "Uji sekarang"
    override val testShort = "Uji"
    override val testResult = "Hasil uji"
    override val testStop = "Berhenti"
    override val testingNow = "menguji…"
    override val prewarmTitle = "Pemanasan soket (eksperimental)"
    override val prewarmHelp = "Menjaga beberapa soket proksi upstream tetap terhubung di muka agar koneksi " +
        "Telegram baru dapat melewati connect/handshake. Eksperimental: latar terus menyambung ulang → " +
        "menghabiskan trafik dan sedikit CPU. Trafik palsu tidak dikirim (itu akan merusak sesi nyata) — " +
        "soket hanya dirotasi. Paling berguna dengan proksi FakeTLS."
    override val prewarmEnable = "Aktifkan pemanasan"
    override val prewarmModeDeferred = "Ditunda (hanya TLS)"
    override val prewarmModeDeferredSub = "Menjaga TCP + FakeTLS; menyelesaikan init saat serah terima. DC tidak dikomit — paling realistis."
    override val prewarmModeFull = "Handshake penuh"
    override val prewarmModeFullSub = "Menjaga soket yang tersambung penuh lintas DC; dipakai ulang hanya saat DC/tag cocok. Berumur lebih pendek."
    override val prewarmPoolLabel = "Soket cadangan"
    override val prewarmHoldLabel = "Tahan tiap, dtk"
    override val prewarmNote = "Hanya rotasi (tanpa keepalive di tingkat aplikasi). Soket bertahan beberapa detik hingga ~satu menit tergantung proksi/DC."
    override val prewarmStatus = "Pemanasan"
    override fun prewarmStatusVal(ready: Int, holdSecs: Int) = "${ready} siap · tahan ${holdSecs}d"
    override val prewarmStar = "Oranye tebal = soket diserahkan dalam keadaan hangat dari kumpulan pemanasan (melewati connect/handshake)"
    override fun prewarmTableTitle(holdSecs: Int) = "Soket pemanasan (tahan ${holdSecs}d)"
    override val prewarmTableHelp = "\"Pemanasan soket\" membuka beberapa soket proksi di muka agar koneksi Telegram baru " +
        "dapat melewati connect/handshake. Tabel ini mencantumkan soket yang sedang dipanaskan: berapa lama tiap " +
        "soket hidup, apakah Telegram memakainya, dan trafik. Nyalakan/matikan dan atur (mode, jumlah soket, " +
        "waktu tahan) di Lainnya → Pengaturan → \"Pemanasan soket (eksperimental)\"."
    override val prewarmNoneWarming = "belum ada soket yang dipanaskan"
    override val prewarmColAge = "umur"
    override val prewarmColUse = "di TG?"
    override val prewarmInUse = "di TG"
    override val prewarmNew = "baru"
    override val lanShareTitle = "Bagikan via LAN (portal web)"
    override val lanShareDesc = "Biarkan perangkat lain di Wi-Fi ini menggunakan AutoConnector ini sebagai proksi; peramban yang membuka alamat di bawah mendapat halaman berisi proksi terbaik."
    override val lanShareUrlsLabel = "Tetangga terhubung di:"
    override val lanShareNoIp = "tidak ada alamat jaringan lokal — sambungkan ke Wi-Fi"
    override val lanFirewallTitle = "Izinkan di jaringan lokal"
    override val lanFirewallBody = "Mengaktifkan ini membuka port relai ke jaringan lokal Anda. Firewall Windows (atau lainnya) mungkin kini menanyakan apakah mengizinkan AutoConnector — pilih Izinkan / Ya. Jika Anda menolaknya, trafik tetangga ke AutoConnector akan diblokir dan halaman/proksi tidak dapat dijangkau."
    override val lanFirewallConfirm = "Aktifkan"
    override val lanInfoTitle = "Untuk apa ini?"
    override val lanInfoBody = "Jalankan AutoConnector di SATU komputer atau ponsel pada Wi-Fi Anda, dan setiap perangkat lain di jaringan yang sama — termasuk iPhone, yang tidak didukung langsung oleh aplikasi ini — cukup membuka alamat di peramban dan menggunakannya: halaman berisi proksi terbaik untuk ditambahkan ke Telegram mereka, atau perangkat ini sendiri sebagai proksi SOCKS. Satu perangkat menemukan dan menjaga proksi; sisanya meminjamnya melalui LAN."
    override val volTriggerTitle = "Pemicu tombol volume"
    override val volTriggerSub = "Ganti proksi dengan pola cepat tombol volume"
    override val volEnableLabel = "Pantau tombol volume"
    override val volHelpTitle = "Apa ini?"
    override val volHelpBody = "Di Android tidak ada pintasan keyboard global, jadi ini menggunakan tombol VOLUME. Saat aktif, AutoConnector memantau pola cepat penekanan Volume-Naik/Turun (mis. naik-naik-turun-turun) di latar belakang. Saat mengenalinya, ia membuka tautan tg:// dari proksi acak yang baik dan aktif sehingga Telegram menangkapnya dan beralih — cara cepat dan tidak mencolok untuk merotasi proksi tanpa membuka aplikasi. Volume tetap bekerja normal (penekanan tidak ditelan). Ini memerlukan akses Accessibility (untuk membaca tombol volume di latar belakang dan membuka tautan); tidak ada yang diminta sampai Anda mengaktifkan sakelarnya. Atur waktu maksimum antara penekanan di bawah; pola yang dikenali tercantum di bagian bawah."
    override val volGrantTitle = "Aktifkan Accessibility (penting)"
    override val volGrantBody = "Android (terutama 13+) memblokir Accessibility untuk aplikasi yang TIDAK dipasang dari Google Play — itulah sebabnya AutoConnector berwarna abu-abu dan menampilkan \"Pengaturan dibatasi\" / \"akses tidak diizinkan\".\n\nCara membuka blokir:\n1. Buka \"Info aplikasi\" (tombol di bawah, atau Pengaturan → Aplikasi → AutoConnector for Telegram).\n2. Ketuk menu ⋮ (kanan atas) → \"Izinkan pengaturan dibatasi\" → konfirmasi.\n3. Kembali: Pengaturan → Accessibility → AutoConnector for Telegram → nyalakan.\n\nJika Anda tidak melihat \"Izinkan pengaturan dibatasi\", coba dulu nyalakan sekali di Accessibility (Anda akan mendapat pesan terblokir), lalu langkah 2 muncul.\n\nPada Xiaomi/MIUI, Samsung, dll. jalurnya bisa sedikit berbeda — cari ⋮ yang sama di \"Info aplikasi\". Pada Android 12 dan lebih lama biasanya tidak ada batasan — cukup aktifkan di Accessibility.\n\nTombol volume hanya diamati, tidak pernah diblokir."
    override val volOpenAppInfo = "Buka Info aplikasi"
    override val volAccessOn = "Accessibility: diberikan"
    override val volAccessOff = "Accessibility: tidak diberikan"
    override val volOpenAccess = "Buka pengaturan Accessibility"
    override val volGapLabel = "Maks md antara penekanan"
    override val volPatternsTitle = "Pola yang dikenali"
    override val volPatternPick = "Pola"
    override val volPatternsLegend = "↑ = volume naik, ↓ = volume turun"
    override val volNoRights = "Aplikasi BELUM memiliki izin untuk menangani tombol volume — berikan akses menggunakan langkah-langkah di bagian bawah halaman ini."
    override val volGrantShort = "Belum ada akses Accessibility. Baca langkah terperinci di bagian bawah halaman ini, lalu ketuk \"Periksa\"."
    override val volCheck = "Periksa"
    override val volCheckOk = "✓ Selesai — akses diberikan, pemicu berfungsi."
    override val volCheckFail = "✗ Masih tidak ada akses — selesaikan langkah di atas."
    override val volPatternsList = "↑↑↓↓ · ↓↓↑↑ · ↑↓↑↓ · ↓↑↓↑ · ↑↑↑↑ · ↓↓↓↓ · ↑↓↓↑ · ↓↑↑↓ · ↑↑↑↓↓↓ · ↓↓↓↑↑↑   (↑ = volume naik, ↓ = turun)"
    override val histLegend = "Kolom — Siapa: ✓/✗ TG = koneksi Telegram nyata, pindai = pemeriksaan latar. Kapan: berapa lama lalu. TCP/TLS/Permintaan: latensi handshake & permintaan pertama, md. Sesi: berapa lama sesi relai berlangsung. ↓/↑: bita diterima / dikirim melalui host."
    override val tgOkTotalHint = "Koneksi Telegram / berhasil / total pemeriksaan"
    override val breadthTitle = "Keluasan pemilihan host"
    override val breadthHelp = "Kiri = berpegang pada host terverifikasi terbaik; kanan = mencoba seluas mungkin di seluruh host aktif. Saat Telegram terus berganti port relai, aplikasi memperluas pencarian secara otomatis."
    override val breadthNarrow = "terverifikasi"
    override val breadthWide = "terluas"
    override val connTimeoutTitle = "Batas waktu koneksi per host"
    override val connTimeoutHelp = "Berapa lama menunggu satu upstream (TCP + TLS + balasan MTProto pertama) sebelum lanjut ke proksi berikutnya."
    override val backupExportTitle = "Ekspor data"
    override val backupImportTitle = "Impor data"
    override val backupSelectExport = "Apa yang akan diekspor:"
    override val backupSelectImport = "Apa yang akan diimpor:"
    override val backupCopyBtn = "Salin"
    override val backupSaveFile = "Simpan ke berkas"
    override val backupLoadFile = "Muat dari berkas"
    override val backupDoImport = "Impor"
    override val backupPasteLabel = "Tempel JSON cadangan di sini"
    override val backupJsonLabel = "JSON cadangan"
    override val backupAndroidFileNote = "Berkas tidak tersedia di sini — gunakan Salin / Tempel."
    override val factoryResetDone = "Semuanya telah diatur ulang. Tutup aplikasi dan buka lagi."
}
