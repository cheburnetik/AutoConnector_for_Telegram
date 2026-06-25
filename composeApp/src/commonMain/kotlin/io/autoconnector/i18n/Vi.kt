package io.autoconnector.i18n

object Vi : Strings {
    override val tabConnector = "Bộ kết nối"; override val tabScan = "Quét"
    override val tabCatalog = "Danh mục"; override val tabLogs = "Nhật ký"; override val tabMore = "Thêm"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "Đăng ký"; override val logTabScan = "Quét"
    override val logGeneral = "Chung"; override val logEmpty = "hiện chưa có gì"
    override val logSessions = "Phiên"; override val logErrorsOnly = "chỉ lỗi"; override val logNoErrors = "không có phiên thất bại"
    override fun logSession(id: String, port: String) = "#${id} · :${port}"
    override val back = "Quay lại"; override val copy = "Sao chép"; override val gotIt = "Đã hiểu"
    override val later = "Để sau"; override val details = "Chi tiết"; override val whatIsThis = "Đây là gì?"
    override val delete = "Xóa"

    override val connector = "Bộ kết nối"; override val scan = "Quét"
    override val notConfigured = "Chưa thiết lập! Sửa →"; override val howToSetup = "Cách thiết lập"
    override val notifOff = "Thông báo đang tắt! Sửa →"; override val enable = "Bật"
    override fun fewProxies(n: Int) = "Proxy còn sống ${n}, đang tìm kiếm, chờ ~15 phút…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "Proxy còn sống: ${alive}  (15 phút: ${within}) · tổng: ${total}"
    override val notifWhyTitle = "Vì sao cần thông báo?"
    override val notifWhyBody = "Biểu tượng thông báo thường trực nghĩa là một dịch vụ chạy nền (foreground service) trên Android. " +
        "Nếu không có nó, hệ thống sẽ giải phóng ứng dụng khỏi bộ nhớ và ứng dụng ngừng tìm kiếm proxy cũng như " +
        "giữ kết nối ở chế độ nền. Vì vậy thông báo là bắt buộc để " +
        "AutoConnector hoạt động."
    override val notifEnableTitle = "Bật thông báo"
    override val notifEnableBody = "Nếu không có biểu tượng thông báo, Android coi ứng dụng là không hoạt động và " +
        "giải phóng nó khỏi bộ nhớ. Khi đó AutoConnector ngừng tìm kiếm proxy và giữ " +
        "kết nối ở chế độ nền — Telegram mất liên kết.\n\nNhấn \"Bật\" và cho phép " +
        "thông báo cho AutoConnector."
    override val notifPlea = "Hãy bật thông báo! Nếu không, ứng dụng không thể chạy nền — " +
        "Android sẽ giải phóng nó và việc tìm kiếm proxy cùng kết nối sẽ dừng lại."

    override val statusConnected = "Telegram đã kết nối"; override val statusConnecting = "Đang kết nối…"
    override val statusOffline = "Telegram chưa kết nối"; override val statusIdle = "Telegram rảnh"
    override val nobodyConnected = "Không có ai kết nối vào Bộ kết nối. "; override val howToSetupArrow = "Cách thiết lập →"
    override val directModeViaVpn = "Chế độ trực tiếp: VPN đang hoạt động — không proxy"
    override val directModeOff = "Chế độ trực tiếp: proxy đã tắt"
    override val directDpiSuffix = " · chống DPI"
    override val connections = "Kết nối"; override val sockets = "Socket"; override val speed = "Tốc độ"
    override val traffic = "Lưu lượng"; override val latency = "Độ trễ"
    override fun pcs(n: Int) = "${n} cái"
    override fun netNow(label: String) = "Mạng: ${label}"
    override fun tgToConnector(n: Int) = "TG→ ${n}"
    override fun connectorToProxy(n: Int) = "proxy ${n}"
    override val trafficSec = "lưu lượng · 60 giây"; override val trafficMin = "lưu lượng · 60 phút"
    override val latencySec = "độ trễ · 60 giây"; override val latencyMin = "độ trễ · 60 phút"
    override val sec60 = "60 giây"; override val min60 = "60 phút"
    override val unitSec = "g"; override val unitMin = "p"; override val unitHour = "h"; override val dash = "—"
    override val currentProxy = "Proxy hiện tại"; override val noActiveProxy = "không có proxy đang hoạt động (Telegram chưa kết nối)"
    override val host = "Máy chủ"; override val type = "Loại"; override val secret = "Khóa bí mật"; override val antiDpi = "Chống DPI"; override val obfEngine = "Bộ máy che giấu"
    override fun activeSockets(n: Int) = "Socket Telegram đang hoạt động: ${n}"
    override val noConnections = "không có kết nối đang hoạt động"; override val colHost = "Máy chủ"; override val colTime = "Thời gian"
    override val modeWord = "Chế độ"; override val directViaVpnLine = "Yêu cầu trực tiếp đến Telegram (VPN đang hoạt động)"
    override val connModeHelp = "Các chế độ (VPN, Wi-Fi, LTE, Ethernet, White) cho phép điều chỉnh cường độ quét khác nhau và giữ riêng xếp hạng/thống kê máy chủ. Loại mạng được nhận diện tự động; chế độ có thể được đặt thủ công trong cài đặt."

    override val scanOff = "Quét đang tắt"; override val proxiesInBase = "Proxy trong cơ sở dữ liệu"
    override val total = "tổng"; override val alive = "còn sống"; override val dead = "chết"
    override val tgConnectedTitle = "Telegram đã kết nối qua"; override val successful = "thành công"
    override val socketsHeld = "Thời gian sống của socket"; override val over1m = ">1 phút"; override val over5m = ">5 phút"; override val over15m = ">15 phút"
    override val scanCountTitle = "Số lần kiểm tra proxy"; override val checked = "Đã kiểm tra"
    override val forAllTime = "tổng thời gian"; override val perMinute = "mỗi phút"; override val perHour = "mỗi giờ"
    override val subsCountTitle = "Số lần tải đăng ký"; override val downloaded = "đã tải"; override val failed = "thất bại"; override val scanTraffic = "lưu lượng quét"; override val subTraffic = "lưu lượng đăng ký"; override val subTrafficGraph = "Lưu lượng đăng ký"
    override val checksMtproto = "Kiểm tra MTProto (↑ ok · ↓ lỗi)"

    override fun catalogEmpty(mode: String) = "Danh mục ${mode} hiện đang trống. Hoặc chưa tìm thấy máy chủ nào, hoặc ứng dụng chưa bao giờ chạy ở chế độ này. Bạn có thể đổi chế độ trong Cài đặt. Các chế độ tồn tại để thu thập máy chủ riêng cho từng loại kết nối internet."
    override val aliveShort = "✓ còn sống"; override val deadShort = "✗ chết"
    override val statusLabel = "Trạng thái"; override val rating = "Xếp hạng"; override val port = "Cổng"
    override val rttPing = "RTT (ping)"; override val checkedField = "Đã kiểm tra"; override val okOfTotal = "Số lần kiểm tra thành công / tổng"
    override val tgConnectedField = "Telegram đã kết nối"; override val tgSessions = "Phiên Telegram"; override val trafficThroughProxy = "Lưu lượng qua proxy"
    override val sessionsTotal = "Tổng số phiên"; override val relayNow = "Đang chuyển tiếp"; override val tlsDomain = "Tên miền TLS (SNI)"
    override val sourceSub = "Nguồn (đăng ký)"; override val lastError = "Lỗi gần nhất"; override val yes = "có"; override val no = "không"
    override val copyAsLink = "Sao chép dưới dạng liên kết"; override val openInTelegram = "Mở máy chủ trong Telegram"; override val makeNextRelay = "Đặt làm relay tiếp theo"
    override val actCopy = "Sao chép"; override val actOpen = "Mở"; override val actRelay = "Relay"
    override fun agoFmt(v: String) = "${v} trước"
    override val catalogTopFor = "Danh sách/xếp hạng proxy cho"
    override val catalogModeHelpTitle = "Chế độ & xếp hạng"
    override val catalogModeHelp = "Ứng dụng đếm máy chủ còn sống và xếp hạng của chúng RIÊNG cho từng chế độ mạng (VPN, Wi-Fi, LTE, Ethernet và White). \"White\" là chế độ THỦ CÔNG riêng dành cho danh sách trắng; chế độ tự động không bao giờ chuyển sang nó. Vì vậy cùng một máy chủ có thể còn sống ở chế độ này và chết ở chế độ khác."
    override fun catalogInactiveWarn(section: String, active: String) =
        "Bạn đang xem mục không hoạt động ${section} — mọi thống kê hiện tại đều đi vào ${active}, không phải ở đây."
    override val manageModeTitle = "Quản lý chế độ"
    override val manageResetRating = "Đặt lại xếp hạng"
    override fun manageResetHint(mode: String) = "Riêng với ${mode}, bạn có thể đặt lại xếp hạng và thống kê sử dụng của các máy chủ còn sống. Điều này hữu ích khi bạn đã kết nối với một VPN hoặc LTE hoàn toàn khác, để thống kê cũ không gây nhiễu. Hoặc để theo dõi xem việc quét proxy kiểm tra lại mọi thứ từ đầu nhanh đến đâu."
    override val manageDeleteAll = "Xóa máy chủ trong"
    override fun manageDeleteHint(mode: String) = "Bạn có thể xóa cả xếp hạng lẫn chính các máy chủ khỏi ${mode}. Tính năng \"Quét proxy\" sẽ thu thập lại chúng. Đây không phải là đặt lại đăng ký — bạn có thể nhấn vào nó, sau đó chờ ~15 phút để quét lại."
    override fun manageCopyFrom(mode: String) = "Sao chép toàn bộ máy chủ và xếp hạng vào chế độ này (${mode}) từ chế độ khác:"
    override val live = "còn sống"; override val deadW = "chết"; override val unitMs = "ms"
    override val agoMin = "p"; override val agoHour = "h"; override val agoDay = "ng"

    override val connectTelegram = "Đang kết nối Telegram"; override val readCarefully = "Hãy đọc kỹ!"
    override val guideIntro = "Ứng dụng này sẽ không hoạt động nếu chưa thiết lập. Hãy chọn một trong 3 phương án dưới đây " +
        "và làm theo hướng dẫn cẩn thận."
    override val variant1 = "Phương án #1 — nút bấm"
    override val variant1Body = "Nhấn \"Proxy {A}\" — Telegram mở ra, xác nhận thêm proxy. Quay " +
        "lại màn hình này và nhấn \"Proxy {B}\" — xác nhận thêm lần thứ hai.\n\nHãy tắt mọi " +
        "proxy cũ khác trong Telegram. Phải còn lại đúng 2 proxy — với cổng {A} và {B}. " +
        "Với bất kỳ tổ hợp nào khác, AutoConnector sẽ không hoạt động."
    override val variant2 = "Phương án #2 — liên kết"
    override val variant2Body = "Sao chép đoạn văn bản dưới đây vào Tin nhắn đã lưu (hoặc bất kỳ cuộc trò chuyện nào) trong Telegram — " +
        "tức là gửi cho chính mình. Nhấn vào liên kết đầu tiên trong tin nhắn của bạn — proxy thứ nhất được thêm. " +
        "Nhấn vào liên kết thứ hai — proxy thứ hai được thêm. Sau đó tắt tất cả proxy cũ."
    override val variant3 = "Phương án #3 — thủ công"
    override val variant3Body = "Thêm thủ công một proxy SOCKS5: máy chủ localhost (127.0.0.1), cổng {A}. " +
        "Rồi proxy thứ hai: localhost, cổng {B}. Xóa mọi proxy cũ."
    override val whatNext = "Tiếp theo là gì?"
    override val whatNextBody = "Trong Telegram, hãy bật \"tự động chuyển proxy\" — 5 giây. Bạn có thể giúp " +
        "Telegram kết nối bằng cách nhấn thủ công vào một proxy (bên trong Telegram) đang KHÔNG hoạt động hoặc bị đánh dấu " +
        "\"không khả dụng\" — điều đó khiến Telegram cố gắng kết nối mạnh hơn.\n\nHãy chắc chắn rằng mọi " +
        "proxy cũ khác đã được gỡ bỏ, ngoại trừ {A} và {B}. Nhấn " +
        "\"Sử dụng proxy\" trong Telegram.\n\nChờ trong khi ứng dụng tìm và tải đủ proxy " +
        "(5–15 phút). Sau đó Telegram tự kết nối vào AutoConnector, và nó sẽ tiếp tục định tuyến " +
        "Telegram qua những proxy tốt nhất: đã được xác minh, còn sống và nhanh.\n\nNếu hướng dẫn có vẻ " +
        "khó — xin lỗi, bạn sẽ không thể dùng ứng dụng: không thể thiết lập mọi thứ " +
        "tự động, và việc tìm proxy còn sống cần thời gian.\n\nNếu bạn đã tải ứng dụng từ lâu " +
        "mà không tìm thấy proxy còn sống nào — hãy cập nhật ứng dụng hoặc danh sách đăng ký. Ứng dụng này " +
        "không tự tạo ra hay cung cấp proxy của riêng nó, nó chỉ tìm kiếm trên internet qua hàng chục " +
        "nhóm và trang."
    override fun proxyBtn(port: Int) = "Proxy ${port}"

    override val setupPortsTitle = "Thiết lập cổng trong Telegram"
    override val setupPortsSub = "Cách kết nối Telegram với Bộ kết nối (cổng 55001/55002)"
    override val settings = "Cài đặt"; override val settingsSub = "Cổng, chống DPI, quét, mạng, pin"
    override val subscriptions = "Đăng ký"; override val subscriptionsSub = "Nguồn proxy để quét"
    override val statistics = "Thống kê"; override val statisticsSub = "Cơ sở dữ liệu proxy + mẹo chống DPI"
    override val export = "Xuất"; override val exportSub = "liên kết tg:// của proxy còn sống"
    override val about = "Giới thiệu"; override val aboutSub = "Phiên bản, bản dựng, tải về, phản hồi"
    override val hotkeys = "Phím tắt"
    override val hotkeysSub = "Phím toàn cục: sao chép / mở một proxy"
    override val hotkeysIntro = "Phím tắt toàn cục hoạt động ngay cả khi cửa sổ ứng dụng không được lấy nét. Chúng chọn một " +
        "liên kết proxy còn sống ngẫu nhiên (tg://) từ nhóm — tiện để chuyển proxy nhanh mà không cần " +
        "mở ứng dụng."
    override val hotkeysNote = "Trên macOS, việc bắt phím có thể cần quyền Trợ năng (Accessibility) " +
        "(Cài đặt hệ thống → Quyền riêng tư & Bảo mật → Trợ năng)."
    override val hotkeyCopyTitle = "Sao chép liên kết proxy"
    override val hotkeyCopyDesc = "Đặt một liên kết tg:// còn sống ngẫu nhiên vào bộ nhớ tạm."
    override val hotkeyEnable = "Bật phím tắt"; override val hotkeyLetterLabel = "Chữ cái"; override val hotkeySet = "Đặt"; override val hotkeyReset = "Đặt lại"
    override val hotkeyOpenTitle = "Mở proxy trong Telegram"
    override val hotkeyOpenDesc = "Mở một liên kết còn sống ngẫu nhiên — Telegram nhận và đề nghị kết nối proxy."

    override val relayPorts = "Cổng relay"
    override val relayPortsHelp = "Các cổng cục bộ mà Bộ kết nối lắng nghe. Bạn nhập chính xác chúng vào " +
        "Telegram như một proxy SOCKS5 (127.0.0.1 : cổng). Hai cổng được dùng để tăng độ tin cậy — Telegram " +
        "giữ kết nối tới cả hai."
    override val portA = "Cổng A"; override val portB = "Cổng B"
    override val antiDpiTrick = "Mẹo chống DPI"
    override val antiDpiHelp = "Một cách ngụy trang kết nối để ISP/DPI không nhận diện và " +
        "chặn nó.\n• \"Tự động luân phiên\" sẽ tự chọn một mẹo đang hoạt động.\n• \"Không dùng mẹo DPI\" — một " +
        "kết nối thông thường.\n• Phần còn lại là các kỹ thuật cụ thể (giả trình duyệt, chia nhỏ gói tin, v.v.)."
    override val onlyFakeTls = "Chỉ FakeTLS (ee)"
    override val applyDpiTo = "Áp dụng chống DPI cho"
    override val applyDpiHelp = "Áp dụng mẹo chống DPI đã chọn cho cái gì:\n• Relay Telegram — cho " +
        "kết nối Telegram thực qua Bộ kết nối.\n• Thăm dò proxy — cho việc kiểm tra proxy ở nền " +
        "(khi đó việc kiểm tra hoạt động giống hệt một kết nối thực, và thống kê mẹo chính xác hơn).\n" +
        "• Khi kết nối trực tiếp — khi proxy bị tắt (hoặc bỏ qua khi VPN bật) và Telegram " +
        "đi thẳng tới máy chủ của nó: ở đây không có proxy, nên mẹo thu lại thành việc chia " +
        "gói TCP đầu tiên (handshake) thành nhiều đoạn nhỏ để DPI không thể khớp nó trong một lần đọc."
    override val toRelay = "Relay Telegram"; override val toProbes = "Thăm dò proxy"
    override val toDirect = "Khi kết nối trực tiếp"
    override val vpnSection = "Khi VPN đang bật"
    override val vpnHelp = "Làm gì khi VPN đang hoạt động trên thiết bị:\n• Qua proxy MTProto — " +
        "Telegram đi qua các proxy đã tìm thấy như bình thường (trên nền VPN).\n• Trực tiếp — Bộ " +
        "kết nối KHÔNG dùng proxy và kết nối Telegram thẳng tới máy chủ của Telegram: " +
        "VPN đã cung cấp quyền truy cập, nên không cần thêm lớp proxy (nhanh và ổn định hơn). " +
        "Khi không có VPN, proxy được dùng như bình thường."
    override val linkFormat = "Định dạng liên kết proxy"
    override val linkFormatHelp = "Cách sao chép và mở proxy. tg:// mở Telegram trực tiếp (cần cài Telegram Desktop). http (t.me) mở qua trình duyệt và đề nghị mở trong Telegram — tiện khi tg:// chưa được đăng ký."
    override val linkTg = "tg:// (mở Telegram trực tiếp)"; override val linkTgSub = "tg://proxy?… — mở Telegram"
    override val linkHttp = "http (t.me, qua trình duyệt)"; override val linkHttpSub = "https://t.me/proxy?… — mở trình duyệt"
    override val viaMtproto = "Proxy qua MTProto"; override val viaMtprotoSub = "ngay cả khi có VPN, lưu lượng vẫn đi qua proxy"
    override val directly = "Kết nối trực tiếp"; override val directlySub = "khi VPN đang hoạt động — bỏ qua proxy, đi thẳng tới Telegram"
    override val notifications = "Thông báo"
    override val scanCheck = "Quét & kiểm tra"
    override val scanCheckHelp = "• Quét, phút — tần suất tải danh sách proxy từ các đăng ký.\n" +
        "• Kiểm tra, phút — tần suất kiểm tra lại tình trạng sống của proxy trong cơ sở dữ liệu.\n• Kích thước lô — " +
        "số proxy kiểm tra mỗi lần chạy.\n• Song song — số lần kiểm tra chạy cùng lúc (nhiều hơn = " +
        "nhanh hơn, nhưng tải mạng và pin cao hơn)."
    override val scanMin = "Quét, phút"; override val checkMin = "Kiểm tra, phút"; override val batchSize = "Kích thước lô"; override val parallel = "Song song"
    override val speedByNet = "Cường độ quét theo mạng"
    override val speedByNetHelp = "Tần suất kiểm tra proxy tùy theo mạng hiện tại. " +
        "\"Tiêu chuẩn\" = khoảng cơ sở. Trượt sang phải để thưa hơn (chậm hơn, nhẹ nhàng hơn với lưu lượng/pin), " +
        "sang trái để thường xuyên hơn (nhanh hơn, mạnh mẽ hơn). Thang logarit, lên tới ×100 mỗi chiều.\n" +
        "• VPN — khi có VPN bên ngoài đang hoạt động.\n• Wi-Fi — trên mạng Wi-Fi.\n• LTE — trên mạng di động."
    override val intensStandard = "tiêu chuẩn"
    override val intensSlower = "chậm hơn"
    override val intensFaster = "nhanh hơn"
    override val maintenance = "Đặt lại dữ liệu"
    override val maintenanceHelp = "• \"Đặt lại danh mục & thống kê\" — đưa về 0 xếp hạng, bộ đếm, lưu lượng " +
        "và nhật ký kiểm tra, nhưng giữ lại các máy chủ đã tải và đăng ký (mọi thứ được xếp hạng lại ở " +
        "lần quét tiếp theo).\n• \"Xóa máy chủ đã tải\" — xóa toàn bộ nhóm proxy nhưng giữ " +
        "đăng ký để việc quét nạp lại nhóm. Đăng ký không bao giờ bị động đến trong cả hai trường hợp."
    override val backupTitle = "Xuất / Nhập"
    override val backupHelp = "Lưu hoặc khôi phục dữ liệu ứng dụng dưới dạng JSON. Đánh dấu những gì cần " +
        "đưa vào — bất kỳ tổ hợp nào:\n• Cài đặt — tất cả tham số ứng dụng.\n• Đăng ký — danh sách nguồn " +
        "(URL + bật/tắt).\n• Danh mục máy chủ còn sống — mọi proxy còn sống với xếp hạng và thống kê " +
        "THEO từng chế độ mạng.\n\n\"Xuất\" mở một trang với JSON sẵn sàng — sao chép hoặc lưu vào tệp. " +
        "\"Nhập\" — dán JSON (hoặc tải tệp) và nó chỉ áp dụng những mục được đánh dấu có mặt trong " +
        "đó. Nhập sẽ THÊM vào dữ liệu hiện có (không xóa)."
    override val backupSettings = "Cài đặt"
    override val backupSubs = "Đăng ký"
    override val backupHosts = "Danh mục máy chủ còn sống (theo chế độ)"
    override val exportWord = "Xuất"
    override val importWord = "Nhập"
    override val backupExportTitle = "Xuất dữ liệu"
    override val backupImportTitle = "Nhập dữ liệu"
    override val backupSelectExport = "Xuất những gì:"
    override val backupSelectImport = "Nhập những gì:"
    override val backupCopyBtn = "Sao chép"
    override val backupSaveFile = "Lưu vào tệp"
    override val backupLoadFile = "Tải từ tệp"
    override val backupDoImport = "Nhập"
    override val backupPasteLabel = "Dán JSON sao lưu vào đây"
    override val backupJsonLabel = "JSON sao lưu"
    override val backupAndroidFileNote = "Tệp không khả dụng ở đây — hãy dùng Sao chép / Dán."
    override val eraseAllHosts = "Xóa tất cả máy chủ"
    override val factoryReset = "Đặt lại tất cả (như lần khởi chạy đầu tiên)"
    override val factoryResetConfirm = "Đặt lại hoàn toàn ứng dụng về trạng thái gốc? TẤT CẢ cài đặt và toàn bộ " +
        "danh mục máy chủ sẽ bị xóa, đăng ký được khôi phục về mặc định. Giống như lần khởi chạy đầu tiên."
    override val resetCatalog = "Đặt lại danh mục & thống kê"
    override val resetCatalogConfirm = "Đưa về 0 tất cả xếp hạng, bộ đếm và nhật ký kiểm tra? " +
        "Máy chủ đã tải và đăng ký được giữ lại và xếp hạng lại ở lần quét tiếp theo."
    override val clearHosts = "Xóa máy chủ đã tải"
    override val clearHostsConfirm = "Xóa toàn bộ danh sách máy chủ (proxy) đã tải? " +
        "Đăng ký được giữ lại và việc quét sẽ nạp lại nhóm."
    override val doReset = "Đặt lại"
    override val doCancel = "Hủy"
    override val adaptiveSpeed = "Tốc độ thích ứng"
    override val adaptiveHelp = "Việc kiểm tra tình trạng sống chạy theo khoảng cơ sở (từ \"Quét & kiểm tra\", cũng " +
        "được nhân với hệ số mạng). \"Tốc độ thích ứng\" tăng hoặc giảm tốc độ chúng " +
        "tự động dựa trên số proxy hiện đang còn sống.\n\n" +
        "• ÍT còn sống (dưới ngưỡng \"Ít\") → khoảng × \"Tăng tốc\". Hệ số dưới 1 = thường " +
        "xuyên hơn: 0.5 — gấp đôi tần suất, 0.25 — gấp 4. Nạp lại nhóm nhanh hơn.\n" +
        "• NHIỀU còn sống (trên ngưỡng \"Nhiều\") → khoảng × \"Giảm tốc\". Trên 1 = thưa hơn: 2 — " +
        "một nửa tần suất, 4 — một phần tư. Tiết kiệm pin và lưu lượng.\n" +
        "• Giữa hai ngưỡng — tốc độ cơ sở (×1).\n\n" +
        "Ví dụ:\n" +
        "— Thu thập proxy nhanh hơn: \"Tăng tốc\" 0.25 và/hoặc ngưỡng \"Ít\" 40.\n" +
        "— Tiết kiệm pin khi đã đủ: \"Giảm tốc\" 8 và/hoặc ngưỡng \"Nhiều\" 30.\n" +
        "— Tắt thích ứng: đặt cả hai hệ số về 1.\n\n" +
        "Mặc định: Ít 20, Tăng tốc 0.5, Nhiều 50, Giảm tốc 4."
    override val threshMany = "Ngưỡng \"Nhiều\""; override val threshFew = "Ngưỡng \"Ít\""; override val mulFast = "Tăng tốc ×"; override val mulLazy = "Giảm tốc ×"
    override val subIntensityTitle = "Cường độ đăng ký"
    override val subIntensityHint = "Khoảng nghỉ giữa các lần tải đăng ký: bao nhiêu phút trước khi tải lại danh sách proxy (riêng cho từng chế độ mạng)."
    override val baseScanTitle = "Tốc độ quét cơ sở"
    override val baseScanHelp = "Tốc độ kiểm tra tình trạng sống tham chiếu. \"Tốc độ thích ứng\" và các hệ số \"Tốc độ " +
        "theo chế độ\" được tính tương đối với nó.\n\n" +
        "• Tần suất chạy, phút — khoảng giữa các lượt kiểm tra.\n" +
        "• Lô mỗi luồng, máy chủ — mỗi luồng kiểm tra bao nhiêu máy chủ mỗi lượt.\n" +
        "• Luồng — bao nhiêu lần kiểm tra chạy cùng lúc. Một lượt thăm dò \"lô × luồng\" máy chủ.\n" +
        "• Đừng quét lại một máy chủ thường xuyên hơn mỗi N phút — chống tràn: một máy chủ vừa được kiểm tra sẽ bị " +
        "bỏ qua trong lượt này.\n\n" +
        "Nhiều luồng hơn và lô lớn hơn = nhóm tăng nhanh hơn, nhưng tải nặng hơn lên mạng và pin."
    override val baseScanPeriod = "Tần suất chạy, phút"
    override val baseScanBatch = "Lô mỗi luồng, máy chủ"; override val baseScanThreads = "Số luồng"
    override val adaptiveDesc = "Nếu proxy còn sống ít hơn \"ít\" hoặc nhiều hơn \"nhiều\", áp dụng một hệ số bổ sung."
    override val fewWord = "Ít"; override val manyWord = "Nhiều"
    override fun fasterX(x: String) = "nhanh hơn ${x}×"
    override fun slowerX(x: String) = "chậm hơn ${x}×"
    override fun ifAliveLt(n: Int) = "Nếu proxy còn sống < ${n}, thì:"
    override fun ifAliveGt(n: Int) = "Nếu proxy còn sống > ${n}, thì:"
    override val disabledWord = "tắt"
    override val speedByModeTitle = "Tốc độ theo chế độ"
    override val speedByModeHelp = "Hệ số tốc độ quét cho mỗi chế độ mạng, trên nền tốc độ cơ " +
        "sở. \"Tiêu chuẩn\" (×1) = khoảng cơ sở. Phải — thưa hơn (chậm hơn, nhẹ nhàng hơn với lưu lượng/" +
        "pin), trái — thường xuyên hơn (nhanh hơn, mạnh mẽ hơn). Thang logarit, lên tới ×100 mỗi " +
        "chiều.\n\n" +
        "Dưới mỗi thanh trượt là tham số lượt kết quả với tốc độ thích ứng đã áp dụng — " +
        "hiển thị riêng cho \"ít còn sống\" (× \"Tăng tốc\") và \"nhiều còn sống\" (× \"Giảm tốc\").\n\n" +
        "Chế độ:\n• VPN — VPN bên ngoài đang hoạt động.\n• LTE — mạng di động.\n• Wi-Fi — mạng Wi-Fi.\n" +
        "• Ethernet — kết nối có dây.\n• White — chế độ proxy \"trắng\" thủ công."
    override val aliveLt = "còn sống <"; override val aliveGt = "còn sống >"
    override val periodWord = "chu kỳ"; override val nonstopWord = "không ngừng"
    override val batchWord = "lô"; override val threadsWord = "luồng"; override val scanModeOff = "quét tắt"
    override val netBattery = "Mạng & pin"
    override val netBatteryHelp = "• Chỉ Wi-Fi — không quét trên mạng di động (tiết kiệm dữ liệu).\n• Chỉ khi " +
        "sạc — chỉ hoạt động khi điện thoại đang sạc.\n• Bỏ qua khi pin yếu — tạm dừng quét khi " +
        "pin yếu."
    override val onlyWifi = "Chỉ Wi-Fi"; override val onlyCharging = "Chỉ khi sạc"; override val skipLowBattery = "Bỏ qua khi pin yếu"
    override val autosaved = "Cài đặt được lưu tự động."
    override val dpiAutoLabel = "Tự động luân phiên mẹo DPI"; override val dpiNoneLabel = "Không dùng mẹo DPI (thông thường)"
    override val experimental = "Thử nghiệm"
    override val experimentalHelp = "Các bộ máy proxy thay thế cho luồng lên MTProto cùng một nhật ký chẩn đoán. " +
        "Đường tham chiếu (đang hoạt động) không thay đổi khi đặt thành \"Tắt\". Chỉ CÁCH luồng đã mã hóa được ghi vào " +
        "socket TCP lên thay đổi (kích thước đoạn, định thời, ranh giới bản ghi TLS) — bản thân luồng vẫn giống hệt từng byte. " +
        "Chỉ áp dụng cho relay proxy thực (không phải thăm dò, không phải đường trực tiếp)."
    override val expEngineTitle = "Bộ máy proxy (che giấu socket)"
    override val expConnectTitle = "Bộ máy kết nối (chọn luồng lên)"
    override val expEngineWarn = "⚠ Chế độ thử nghiệm. Nếu khả năng kết nối kém đi, hãy chuyển lại về \"Tắt (đường tham chiếu)\"."
    override val netLog = "Bật nhật ký trao đổi mạng"
    override val netLogSub = "Ghi AI-VỚI-AI-KHI-NÀO và kích thước gói vào một tệp (KHÔNG có dữ liệu tải) — " +
        "để so sánh mẫu trao đổi khi có và không có VPN."
    override val openLogFolder = "Mở thư mục nhật ký"; override val copyPath = "Sao chép đường dẫn"
    override val helpShow = "Trợ giúp"; override val helpHide = "Ẩn trợ giúp"
    override val quickSwitchIntro = "Tại đây bạn có thể chọn một mẹo vượt chặn. Nếu Telegram hiển thị lỗi " +
        "“The proxy you are using is not configured correctly and will be disabled. Please find another " +
        "one”, hãy thử nghiệm xem loại che giấu lưu lượng nào hoạt động để Telegram ngừng hiển thị nó. Bắt đầu " +
        "với các chế độ split*. Các chế độ coalesce* cũng hoạt động, nhưng hình ảnh/video tải kém trong Telegram với chúng."
    override val quickSwitchTitle ="Vượt chặn"; override val quickSwitchSub = "Định hình, kết nối, chống DPI"

    override val sourceUrl = "URL nguồn"
    override fun sourceAlive(alive: Int, total: Int) = "còn sống ${alive}/${total}"
    override val open = "Mở"; override val active = "Hoạt động"; override val inactive = "Không hoạt động"
    override val lastDownloaded = "Đã tải"; override val notDownloaded = "chưa tải"
    override fun sourceCounts(dead: Int, total: Int) =
        " còn sống, ${dead} chết, ${total} tổng"

    override val proxyBase = "Cơ sở dữ liệu proxy"
    override val totalInBase = "Tổng trong cơ sở dữ liệu"; override val aliveNow = "Còn sống hiện tại"; override val deadStat = "Chết"
    override val aliveIn15 = "Còn sống trong 15 phút"; override val checksAllTime = "Số lần kiểm tra tổng cộng"
    override val antiDpiTricks = "Mẹo chống DPI"; override val noStatsYet = "chưa có dữ liệu — mẹo tích lũy khi kiểm tra/kết nối diễn ra"
    override val attempts = "Số lần thử"; override val handshake = "Bắt tay"; override val score = "Điểm"
    override val tgConnect = "Kết nối TG"; override val socketsOver1m = "Socket >1 phút"
    override val over10kb = "Socket >10KB"; override val over100kb = ">100KB"; override val workTime = "Thời gian làm việc"
    override val statsLegend = "Bắt tay — số lần bắt tay thành công (% trên số lần thử) · Điểm — giá trị · " +
        "\"Thời gian làm việc\" — tổng trên các socket ≥5KB và dài hơn 1 phút."
    override val resetStats = "Đặt lại thống kê mẹo"

    override fun aliveLinks(n: Int) = "Liên kết còn sống: ${n}"
    override val copyAll = "Sao chép tất cả"
    override val openRandom = "Mở ngẫu nhiên"; override val copyRandom = "Sao chép ngẫu nhiên"; override val allShort = "TẤT CẢ"
    override val copyTop = "Sao chép TOP"; override val randomHost = "Máy chủ ngẫu nhiên"
    override val exportToFile = "Xuất ra tệp"; override val exportSaved = "Đã lưu vào tệp:"
    override val dlNow = "Tải ngay"
    override fun downloadingFmt(sec: Long) = "Đang tải… ${sec}g"
    override val cancel = "Hủy"
    override val deleteConfirmTitle = "Xóa đăng ký?"
    override val subscriptionsAddHint = "Thêm đăng ký hoặc liên kết proxy →"
    override val addSourcesTitle = "Thêm"
    override val addSubsLabel = "Đăng ký (mỗi URL một dòng)"
    override val addSubsHelp = "Mỗi dòng có URL hợp lệ trở thành một đăng ký riêng và được tải định kỳ."
    override val addProxiesLabel = "Liên kết proxy sẵn sàng (danh sách cố định)"
    override val addProxiesHelp = "Dán một loạt liên kết tới các proxy cụ thể (tg://proxy, https://t.me/proxy, …). Đây KHÔNG phải là đăng ký — danh sách không bao giờ được tải về, các proxy chỉ được thêm vào danh mục."
    override val addButton = "Thêm"
    override fun addedFmt(subs: Int, proxies: Int) = "Đã thêm: ${subs} đăng ký, ${proxies} proxy"
    override val perSecond = "mỗi giây"
    override val graphSpeed = "Tốc độ"
    override val graphVolume = "Dung lượng"
    override val graphLatency = "Ping"
    override val graphConnects = "Kết nối"
    override val scanNow = "Quét ngay"; override val scanOnShort = "Quét bật"
    override val scanRunning = "Quét đang chạy"; override val scanIdle = "Quét rảnh"; override val scanOffState = "Quét TẮT"; override val scanBatchPerThread = "Lô/luồng"; override val scanPassHosts = "Máy chủ trong lượt"; override val minRescanLabel = "Đừng quét lại một máy chủ thường xuyên hơn mỗi N phút"
    override val scanPlanTitle = "Kế hoạch"; override val scanNowTitle = "Hiện tại"; override val currentScheduleTitle = "Lịch trình hiện tại"
    override val scheduleWord = "Lịch trình"; override val unitPcsPerSec = "cái/g"
    override val scanNowThreadsLabel = "Luồng đang chạy hiện tại"; override val scanNowPerThreadLabel = "Số lần kiểm tra mỗi luồng (kế hoạch)"; override val scanNowElapsedLabel = "Thời gian chạy"
    override val scanOkGraph = "Quét thành công"; override val scanFailGraph = "Quét thất bại"; override val scanTrafficGraph = "Lưu lượng quét"; override val scanAliveGraph = "Tổng proxy còn sống"; override val scanPingGraph = "Ping"; override val threadsGraph = "Luồng"
    override val scanEvery = "Mỗi"; override val scanNextRun = "Lần chạy tiếp theo"
    override val scanThreads = "Luồng"; override val scanBatch = "Lô"
    override val scanElapsed = "Đang chạy"; override val scanIdleNow = "—"
    override val effForFew = "Khi ít"; override val effForMany = "Khi nhiều"
    override val effCheck = "Kiểm tra"; override val effBatch = "Lô"; override val effPar = "Song song"
    override val effContinuous = "liên tục"; override val secShort = "g"; override val minShort = "phút"

    override val appTagline = "Bộ tự động kết nối đa nền tảng: nó tìm, kiểm tra và chạy các proxy MTProto " +
        "mà Telegram hoạt động qua đó."
    override val version = "Phiên bản"; override val buildDate = "Ngày dựng"
    override val downloadSources = "Tải về & nguồn"; override val openOnGithub = "Mở trên GitHub"
    override val feedbackBugs = "Phản hồi & báo lỗi"; override val writeTelegram = "Nhắn tin trên Telegram"

    override val language = "Ngôn ngữ"; override val langAuto = "Tự động (hệ thống)"; override val langRu = "Русский"; override val langEn = "English"
    override val langFa = "فارسی"; override val langZh = "简体中文"; override val langAr = "العربية"; override val langUr = "اردو"
    override val langTr = "Türkçe"; override val langId = "Bahasa Indonesia"; override val langHi = "हिन्दी"; override val langBn = "বাংলা"; override val langMy = "မြန်မာ"
    override val langWord = "Ngôn ngữ"
    override val raceWidthTitle = "Kết nối song song"
    override val connectionSection = "Kết nối & vượt chặn"
    override val connectionSectionHelp = "Bộ máy kết nối, luồng lên song song, bộ máy proxy và mẹo chống DPI — tất cả trong một mục."
    override val netLogSection = "Nhật ký trao đổi mạng"
    override val platform = "Nền tảng"

    override val scanModeTitle = "Chế độ mạng"; override val scanModeAuto = "Tự động"; override val scanModeManualLabel = "Thủ công"
    override val activeModeLabel = "Chế độ hoạt động"; override val formingListLabel = "Đang lập danh sách"; override val catalogModeTabs = "Chế độ"
    override val resetModeRatings = "Đặt lại xếp hạng máy chủ"; override val forgetModeHosts = "Quên máy chủ của chế độ"
    override val exportModeTitle = "Xuất theo chế độ"; override val modePickerTitle = "Chế độ"
    override val modeHelp = "Mỗi chế độ mạng giữ riêng xếp hạng proxy và cường độ quét + tải đăng ký riêng. \"Tự động\" chọn chế độ từ mạng đang hoạt động. \"Thủ công\" cho phép bạn tự chọn bất kỳ chế độ nào (kể cả White, mà chế độ tự động không bao giờ chọn)."
    override val autoSelect = "Chọn tự động"; override val manualSelect = "Chọn thủ công"
    override val connStatsTitle = "Kết nối hiện tại"; override val connOnPort = "Kết nối trên cổng"; override val outgoingConns = "Kết nối đi ra"
    override val modeChoice = "Lựa chọn chế độ"; override val autoChoice = "tự động chọn"; override val manualChoice = "cố định thủ công"
    override val directOnVpn = "Kết nối trực tiếp tới TG khi có VPN"; override val onWord = "bật"; override val offWord = "tắt"
    override val directStateActive = "đang hoạt động"; override val directStateOff = "tắt trong cài đặt"; override val directStateIdle = "bật trong cài đặt, nhưng không hoạt động"
    override val wpHintTitle = "White là gì?"
    override val wpHint = "White — WhitePages: một hồ sơ mạng thủ công. Chỉ được bật bằng tay (chế độ tự chọn không bao giờ chọn nó). " +
        "Giữ riêng xếp hạng máy chủ, tải đăng ký và quét độc lập với VPN/Wi-Fi/LTE."

    override val recentAttempts = "Kết nối & kiểm tra gần đây"
    override val kindCheck = "kiểm tra"
    override val kindTg = "telegram"
    override val histWho = "Ai"
    override val histWhen = "Khi nào"
    override val histReq = "Yêu cầu"
    override val histSess = "Phiên"
    override val histScan = "quét"
    override val testNow = "Kiểm tra ngay"
    override val testShort = "Kiểm tra"
    override val testResult = "Kết quả kiểm tra"
    override val testStop = "Dừng"
    override val testingNow = "đang kiểm tra…"
    override val prewarmTitle = "Làm nóng trước socket (thử nghiệm)"
    override val prewarmHelp = "Giữ sẵn vài socket tới proxy được mở từ trước để một kết nối Telegram mới " +
        "có thể bỏ qua bước kết nối/bắt tay. Thử nghiệm: chế độ nền liên tục kết nối lại → tốn lưu lượng " +
        "và một chút CPU. Không gửi lưu lượng giả (nó sẽ làm hỏng phiên thực) — các socket chỉ được luân " +
        "phiên. Hữu ích nhất với proxy FakeTLS."
    override val prewarmEnable = "Bật làm nóng trước"
    override val prewarmModeDeferred = "Trì hoãn (chỉ TLS)"
    override val prewarmModeDeferredSub = "Giữ TCP + FakeTLS; gửi nốt phần init khi bàn giao. Không cam kết DC — thực tế nhất."
    override val prewarmModeFull = "Bắt tay đầy đủ"
    override val prewarmModeFullSub = "Giữ các socket đã kết nối hoàn toàn trên nhiều DC; chỉ tái sử dụng khi khớp DC/tag. Sống ngắn hơn."
    override val prewarmPoolLabel = "Socket dự phòng"
    override val prewarmHoldLabel = "Giữ mỗi cái, g"
    override val prewarmNote = "Chỉ luân phiên (không keepalive ở cấp ứng dụng). Một socket sống vài giây…~một phút, tùy proxy/DC."
    override val prewarmStatus = "Làm nóng"
    override fun prewarmStatusVal(ready: Int, holdSecs: Int) = "${ready} sẵn sàng · giữ ${holdSecs}g"
    override val prewarmStar = "Cam đậm = socket được bàn giao ấm từ nhóm làm nóng trước (bỏ qua kết nối/bắt tay)"
    override fun prewarmTableTitle(holdSecs: Int) = "Làm nóng trước socket (giữ ${holdSecs}g)"
    override val prewarmTableHelp = "\"Làm nóng trước socket\" mở sẵn vài socket tới proxy để một kết nối Telegram mới " +
        "có thể bỏ qua bước kết nối/bắt tay. Bảng này liệt kê các socket đang được làm nóng: mỗi socket đã sống " +
        "bao nhiêu giây, Telegram có đang dùng nó không, và lưu lượng. Bật/tắt và cấu hình (chế độ, số socket, " +
        "thời gian giữ) trong \"Thêm → Cài đặt → Làm nóng trước socket (thử nghiệm)\"."
    override val prewarmNoneWarming = "chưa có socket nào đang được làm nóng"
    override val prewarmColAge = "tuổi thọ"
    override val prewarmColUse = "trong TG?"
    override val prewarmInUse = "trong TG"
    override val prewarmNew = "mới"
    override val lanShareTitle = "Chia sẻ qua mạng LAN (cổng web)"
    override val lanShareDesc = "Cho phép các thiết bị khác trong Wi-Fi này dùng AutoConnector này làm proxy; trình duyệt mở địa chỉ bên dưới sẽ nhận một trang với các proxy tốt nhất."
    override val lanShareUrlsLabel = "Thiết bị cùng mạng kết nối tại:"
    override val lanShareNoIp = "không có địa chỉ trong mạng cục bộ — hãy kết nối Wi-Fi"
    override val lanFirewallTitle = "Cho phép trong mạng cục bộ"
    override val lanFirewallBody = "Khi bật, các cổng relay sẽ mở ra mạng cục bộ. Lúc này tường lửa Windows (hoặc loại khác) có thể hỏi có cho phép AutoConnector không — hãy chọn \"Cho phép\"/\"Có\". Nếu từ chối, lưu lượng của các thiết bị lân cận tới AutoConnector sẽ bị chặn, và trang/proxy sẽ không truy cập được."
    override val lanFirewallConfirm = "Bật"
    override val lanInfoTitle = "Cái này để làm gì?"
    override val lanInfoBody = "Chạy AutoConnector trên MỘT máy tính hoặc điện thoại trong Wi-Fi của bạn — và mọi thiết bị khác trong cùng mạng, kể cả iPhone (mà ứng dụng không hỗ trợ trực tiếp), đều có thể chỉ cần mở địa chỉ trong trình duyệt và dùng: một trang với các proxy tốt nhất để thêm vào Telegram của họ, hoặc chính thiết bị này như một proxy SOCKS. Một thiết bị tìm và giữ các proxy, những thiết bị còn lại dùng nó qua mạng cục bộ."
    override val volTriggerTitle = "Kích hoạt bằng nút âm lượng"
    override val volTriggerSub = "Chuyển proxy bằng một chuỗi phím âm lượng nhanh"
    override val volEnableLabel = "Theo dõi các nút âm lượng"
    override val volHelpTitle = "Đây là gì?"
    override val volHelpBody = "Trên Android không có phím tắt bàn phím toàn cục, nên ứng dụng dùng các nút ÂM LƯỢNG thay thế. Khi được bật, AutoConnector theo dõi ở chế độ nền một chuỗi nhấn Tăng/Giảm âm lượng nhanh (ví dụ lên-lên-xuống-xuống). Khi nhận diện được, nó mở một liên kết tg:// của một proxy tốt còn sống ngẫu nhiên — Telegram bắt lấy và chuyển sang. Một cách nhanh và kín đáo để luân phiên proxy mà không cần mở ứng dụng. Âm lượng vẫn hoạt động bình thường (các lần nhấn không bị chặn). Cần quyền Trợ năng (Accessibility) (để đọc phím ở nền và mở liên kết); không có gì được yêu cầu cho đến khi bạn bật công tắc. Đặt thời gian tối đa giữa các lần nhấn bên dưới; các mẫu được nhận diện được liệt kê ở dưới cùng."
    override val volGrantTitle = "Bật Trợ năng (quan trọng)"
    override val volGrantBody = "Android (đặc biệt là 13+) chặn Trợ năng (Accessibility) cho các ứng dụng KHÔNG cài từ Google Play — vì vậy AutoConnector bị làm mờ và hiển thị \"Cài đặt bị hạn chế\" / \"không được phép truy cập\".\n\nCách bỏ chặn:\n1. Mở \"Thông tin ứng dụng\" (nút bên dưới, hoặc: Cài đặt → Ứng dụng → AutoConnector for Telegram).\n2. Nhấn menu ⋮ (ba chấm trên cùng bên phải) → \"Cho phép cài đặt bị hạn chế\" → xác nhận.\n3. Quay lại: Cài đặt → Trợ năng → AutoConnector for Telegram → bật nó lên.\n\nNếu không thấy mục \"Cho phép cài đặt bị hạn chế\" — trước tiên hãy thử bật công tắc một lần trong Trợ năng (bạn sẽ thấy thông báo bị chặn), sau đó bước 2 sẽ xuất hiện.\n\nTrên Xiaomi/MIUI, Samsung, v.v. đường dẫn có thể hơi khác — hãy tìm cùng biểu tượng ⋮ trong \"Thông tin ứng dụng\". Trên Android 12 trở về trước thường không có hạn chế — cứ bật ngay trong Trợ năng.\n\nCác phím âm lượng chỉ được quan sát, không bao giờ bị chặn."
    override val volOpenAppInfo = "Mở \"Thông tin ứng dụng\""
    override val volAccessOn = "Trợ năng: đã bật"
    override val volAccessOff = "Trợ năng: chưa bật"
    override val volOpenAccess = "Mở cài đặt Trợ năng"
    override val volGapLabel = "Tối đa ms giữa các lần nhấn"
    override val volPatternsTitle = "Các mẫu được nhận diện"
    override val volPatternPick = "Mẫu"
    override val volPatternsLegend = "↑ = tăng âm lượng, ↓ = giảm âm lượng"
    override val volNoRights = "Ứng dụng CHƯA có quyền xử lý các nút âm lượng — hãy cấp quyền theo hướng dẫn ở cuối trang."
    override val volGrantShort = "Chưa có quyền Trợ năng. Hãy đọc hướng dẫn chi tiết ở cuối trang này, rồi nhấn \"Kiểm tra\"."
    override val volCheck = "Kiểm tra"
    override val volCheckOk = "✓ Xong — đã cấp quyền, kích hoạt hoạt động."
    override val volCheckFail = "✗ Vẫn chưa có quyền — hãy hoàn thành các bước ở trên."
    override val volPatternsList = "↑↑↓↓ · ↓↓↑↑ · ↑↓↑↓ · ↓↑↓↑ · ↑↑↑↑ · ↓↓↓↓ · ↑↓↓↑ · ↓↑↑↓ · ↑↑↑↓↓↓ · ↓↓↓↑↑↑   (↑ = tăng âm lượng, ↓ = giảm âm lượng)"
    override val histLegend = "Các cột — Ai: ✓/✗ TG = kết nối Telegram thực, quét = kiểm tra ở nền. Khi nào: cách đây bao lâu. TCP/TLS/Yêu cầu: độ trễ bắt tay và yêu cầu đầu tiên, ms. Phiên: phiên relay kéo dài bao lâu. ↓/↑: số byte nhận / gửi qua máy chủ."
    override val tgOkTotalHint = "Số kết nối Telegram / thành công / tổng số lần kiểm tra"
    override val breadthTitle = "Độ rộng lựa chọn máy chủ"
    override val breadthHelp = "Trái — bám vào các máy chủ tốt nhất đã được kiểm chứng; phải — thử rộng nhất có thể trên mọi máy chủ còn sống. Khi Telegram liên tục đổi cổng relay, ứng dụng tự động mở rộng lựa chọn."
    override val breadthNarrow = "đã kiểm chứng"
    override val breadthWide = "rộng nhất"
    override val connTimeoutTitle = "Thời gian chờ kết nối mỗi máy chủ"
    override val connTimeoutHelp = "Chờ một luồng lên bao lâu (TCP + TLS + phản hồi MTProto đầu tiên) trước khi thử proxy tiếp theo."
    override val factoryResetDone = "Đã đặt lại mọi thứ. Hãy đóng ứng dụng và mở lại."

    // tray
    override val trayOpenWindow = "Mở cửa sổ"
    override val trayRefreshSubs = "Làm mới đăng ký"
    override val trayExit = "Thoát"
    override fun trayConnectorLabel(on: Boolean) =
        if (on) "Bộ kết nối: BẬT (tắt)" else "Bộ kết nối: TẮT (bật)"
    override fun trayScanLabel(on: Boolean) =
        if (on) "Quét: BẬT (tắt)" else "Quét: TẮT (bật)"
    override fun trayLive(n: Int) = "Proxy còn sống: ${n}"
    override val appearance = "Giao diện"
    override val themeLabel = "Chủ đề"
    override val themeAuto = "Tự động (theo hệ thống)"
    override val themeLight = "Sáng"
    override val themeDark = "Tối"
    override val drawGraphsLabel = "Vẽ biểu đồ"
    override val drawGraphsSub = "Biểu đồ trực tiếp trên tab Bộ kết nối và Quét — tắt để tiết kiệm pin"
}
