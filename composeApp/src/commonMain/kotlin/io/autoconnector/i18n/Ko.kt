package io.autoconnector.i18n

object Ko : Strings {
    override val tabConnector = "커넥터"; override val tabScan = "스캔"
    override val tabCatalog = "카탈로그"; override val tabLogs = "로그"; override val tabMore = "더 보기"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "구독"; override val logTabScan = "스캔"
    override val logGeneral = "일반"; override val logEmpty = "아직 비어 있음"
    override val logSessions = "세션"; override val logErrorsOnly = "오류만"; override val logNoErrors = "실패한 세션 없음"
    override fun logSession(id: String, port: String) = "#${id} · :${port}"
    override val back = "뒤로"; override val copy = "복사"; override val gotIt = "확인"
    override val later = "나중에"; override val details = "세부 정보"; override val whatIsThis = "이게 뭐죠?"
    override val delete = "삭제"

    override val connector = "커넥터"; override val scan = "스캔"
    override val notConfigured = "설정되지 않음! 수정 →"; override val howToSetup = "설정 방법"
    override val notifOff = "알림이 꺼져 있습니다! 수정 →"; override val enable = "켜기"
    override fun fewProxies(n: Int) = "작동 중인 프록시 ${n}개, 검색 중입니다. 약 15분 기다려 주세요…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "작동 중인 프록시: ${alive}개  (15분: ${within}개) · 전체: ${total}개"
    override val notifWhyTitle = "왜 알림이 필요한가요?"
    override val notifWhyBody = "상시 알림 아이콘은 Android 포그라운드 서비스를 의미합니다. " +
        "이것이 없으면 시스템이 앱을 메모리에서 내려버려, 백그라운드에서 프록시를 검색하고 " +
        "연결을 유지하는 작업이 멈춥니다. 그래서 AutoConnector가 작동하려면 " +
        "알림이 반드시 필요합니다."
    override val notifEnableTitle = "알림 켜기"
    override val notifEnableBody = "알림 아이콘이 없으면 Android는 앱을 비활성 상태로 간주하여 " +
        "메모리에서 내려버립니다. 그러면 AutoConnector가 백그라운드에서 프록시를 검색하고 " +
        "연결을 유지하는 작업을 멈추고 — Telegram이 연결을 잃게 됩니다.\n\n\"켜기\"를 눌러 " +
        "AutoConnector의 알림을 허용해 주세요."
    override val notifPlea = "알림을 켜 주세요! 알림이 없으면 앱이 백그라운드에서 실행될 수 없습니다 — " +
        "Android가 앱을 내려버려 프록시 검색과 연결이 멈춥니다."

    override val statusConnected = "Telegram 연결됨"; override val statusConnecting = "연결 중…"
    override val statusOffline = "Telegram 연결 안 됨"; override val statusIdle = "Telegram 대기 중"
    override val nobodyConnected = "커넥터에 연결된 것이 없습니다. "; override val howToSetupArrow = "설정 방법 →"
    override val directModeViaVpn = "직접 모드: VPN 활성 — 프록시 없음"
    override val directModeOff = "직접 모드: 프록시 꺼짐"
    override val directDpiSuffix = " · 안티-DPI"
    override val connections = "연결"; override val sockets = "소켓"; override val speed = "속도"
    override val traffic = "트래픽"; override val latency = "지연 시간"
    override fun pcs(n: Int) = "${n}개"
    override fun netNow(label: String) = "네트워크: ${label}"
    override fun tgToConnector(n: Int) = "TG→ ${n}"
    override fun connectorToProxy(n: Int) = "프록시 ${n}"
    override val trafficSec = "트래픽 · 60초"; override val trafficMin = "트래픽 · 60분"
    override val latencySec = "지연 시간 · 60초"; override val latencyMin = "지연 시간 · 60분"
    override val sec60 = "60초"; override val min60 = "60분"
    override val unitSec = "초"; override val unitMin = "분"; override val unitHour = "시간"; override val dash = "—"
    override val currentProxy = "현재 프록시"; override val noActiveProxy = "활성 프록시 없음 (Telegram 연결 안 됨)"
    override val host = "호스트"; override val type = "유형"; override val secret = "시크릿"; override val antiDpi = "안티-DPI"; override val obfEngine = "난독화 엔진"
    override fun activeSockets(n: Int) = "활성 Telegram 소켓: ${n}개"
    override val noConnections = "활성 연결 없음"; override val colHost = "호스트"; override val colTime = "시간"
    override val modeWord = "모드"; override val directViaVpnLine = "Telegram에 직접 요청 (VPN 활성)"
    override val connModeHelp = "모드(VPN, Wi-Fi, LTE, Ethernet, White)를 사용하면 스캔 강도를 각각 다르게 조정하고 호스트 평가/통계를 별도로 유지할 수 있습니다. 네트워크 종류는 자동으로 감지되며, 모드는 설정에서 수동으로 지정할 수 있습니다."

    override val scanOff = "스캔이 꺼져 있습니다"; override val proxiesInBase = "데이터베이스의 프록시"
    override val total = "전체"; override val alive = "작동"; override val dead = "죽음"
    override val tgConnectedTitle = "Telegram 연결 경로"; override val successful = "성공"
    override val socketsHeld = "소켓 유지 시간"; override val over1m = ">1분"; override val over5m = ">5분"; override val over15m = ">15분"
    override val scanCountTitle = "프록시 검사 횟수"; override val checked = "검사됨"
    override val forAllTime = "전체 기간"; override val perMinute = "분당"; override val perHour = "시간당"
    override val subsCountTitle = "구독 다운로드 횟수"; override val downloaded = "다운로드됨"; override val failed = "실패"; override val scanTraffic = "스캔 트래픽"; override val subTraffic = "구독 트래픽"; override val subTrafficGraph = "구독 트래픽"
    override val checksMtproto = "MTProto 검사 (↑ 성공 · ↓ 실패)"

    override fun catalogEmpty(mode: String) = "${mode} 카탈로그가 아직 비어 있습니다. 호스트를 찾지 못했거나, 이 모드에서 앱이 한 번도 실행된 적이 없습니다. 설정에서 모드를 전환할 수 있습니다. 모드는 인터넷 연결 종류별로 호스트를 별도로 수집하기 위해 존재합니다."
    override val aliveShort = "✓ 작동"; override val deadShort = "✗ 죽음"
    override val statusLabel = "상태"; override val rating = "평가"; override val port = "포트"
    override val rttPing = "RTT (핑)"; override val checkedField = "검사됨"; override val okOfTotal = "성공 / 전체 검사"
    override val tgConnectedField = "Telegram 연결됨"; override val tgSessions = "Telegram 세션"; override val trafficThroughProxy = "프록시 경유 트래픽"
    override val sessionsTotal = "전체 세션"; override val relayNow = "현재 릴레이"; override val tlsDomain = "TLS 도메인 (SNI)"
    override val sourceSub = "출처 (구독)"; override val lastError = "마지막 오류"; override val yes = "예"; override val no = "아니요"
    override val copyAsLink = "링크로 복사"; override val openInTelegram = "Telegram에서 호스트 열기"; override val makeNextRelay = "다음 릴레이로 지정"
    override val actCopy = "복사"; override val actOpen = "열기"; override val actRelay = "릴레이"
    override fun agoFmt(v: String) = "${v} 전"
    override val catalogTopFor = "프록시 목록/평가:"
    override val catalogModeHelpTitle = "모드와 평가"
    override val catalogModeHelp = "앱은 네트워크 모드(VPN, Wi-Fi, LTE, Ethernet, White)별로 작동 중인 호스트와 그 평가를 개별적으로 집계합니다. \"White\"는 화이트리스트용 별도 수동 모드이며, 자동 전환은 절대 이 모드를 선택하지 않습니다. 따라서 같은 호스트가 한 모드에서는 작동하고 다른 모드에서는 죽어 있을 수 있습니다."
    override fun catalogInactiveWarn(section: String, active: String) =
        "비활성 섹션 ${section}을(를) 보고 있습니다 — 지금의 모든 통계는 여기가 아니라 ${active}(으)로 집계됩니다."
    override val manageModeTitle = "모드 관리"
    override val manageResetRating = "평가 초기화"
    override fun manageResetHint(mode: String) = "${mode} 모드에 한해 작동 중인 호스트의 평가와 사용 통계를 초기화할 수 있습니다. 완전히 다른 VPN이나 LTE에 연결하여 예전 통계가 방해되지 않도록 할 때 유용합니다. 또는 프록시 스캔이 처음부터 얼마나 빨리 전부 다시 검사하는지 보고 싶을 때도 쓸 수 있습니다."
    override val manageDeleteAll = "호스트 삭제:"
    override fun manageDeleteHint(mode: String) = "${mode} 모드에서 평가와 호스트 자체를 모두 지울 수 있습니다. \"프록시 스캔\" 기능이 다시 수집합니다. 이것은 구독 초기화가 아닙니다 — 눌러도 약 15분 기다리면 다시 스캔됩니다."
    override fun manageCopyFrom(mode: String) = "다른 모드의 모든 호스트와 평가를 이 모드(${mode})로 복사:"
    override val live = "작동"; override val deadW = "죽음"; override val unitMs = "ms"
    override val agoMin = "분"; override val agoHour = "시간"; override val agoDay = "일"

    override val connectTelegram = "Telegram 연결하기"; override val readCarefully = "꼼꼼히 읽어 주세요!"
    override val guideIntro = "이 앱은 설정 없이는 작동하지 않습니다. 아래 3가지 방법 중 하나를 골라 " +
        "안내를 차근차근 따라 주세요."
    override val variant1 = "방법 #1 — 버튼"
    override val variant1Body = "\"프록시 {A}\"를 누르면 — Telegram이 열리고, 프록시 추가를 확인하세요. 이 " +
        "화면으로 돌아와 \"프록시 {B}\"를 눌러 — 두 번째 추가도 확인하세요.\n\nTelegram의 다른 " +
        "예전 프록시는 모두 끄세요. 정확히 2개의 프록시만 남아야 합니다 — 포트 {A}와 {B}. " +
        "다른 구성으로는 AutoConnector가 작동하지 않습니다."
    override val variant2 = "방법 #2 — 링크"
    override val variant2Body = "아래 텍스트를 Telegram의 저장된 메시지(또는 아무 채팅)에 복사하세요 — " +
        "즉 자기 자신에게 보내세요. 메시지의 첫 번째 링크를 누르면 — 첫 번째 프록시가 추가됩니다. " +
        "두 번째 링크를 누르면 — 두 번째가 추가됩니다. 그런 다음 예전 프록시를 모두 끄세요."
    override val variant3 = "방법 #3 — 수동"
    override val variant3Body = "SOCKS5 프록시를 수동으로 추가하세요: 서버 localhost (127.0.0.1), 포트 {A}. " +
        "그다음 두 번째 프록시: localhost, 포트 {B}. 예전 프록시는 모두 삭제하세요."
    override val whatNext = "다음은 무엇인가요?"
    override val whatNextBody = "Telegram에서 \"프록시 자동 전환\"을 켜세요 — 5초면 됩니다. 활성 상태가 아니거나 " +
        "\"사용 불가\"로 표시된 프록시를 (Telegram 안에서) 직접 눌러 Telegram이 연결되도록 도울 수 " +
        "있습니다 — 그러면 Telegram이 더 적극적으로 연결을 시도합니다.\n\n{A}와 {B}를 제외한 다른 모든 " +
        "예전 프록시가 제거되었는지 확인하세요. Telegram에서 " +
        "\"프록시 사용\"을 누르세요.\n\n앱이 충분한 프록시를 찾아 다운로드하는 동안 기다리세요 " +
        "(5~15분). 그러면 Telegram이 스스로 AutoConnector에 연결되고, 이후로는 검증되고 작동하며 " +
        "빠른 최적의 프록시를 통해 Telegram을 계속 라우팅합니다.\n\n안내가 어렵게 느껴진다면 " +
        "— 죄송하지만 이 앱을 사용하실 수 없습니다: 모든 것을 자동으로 설정하는 것은 불가능하고, " +
        "작동하는 프록시를 찾는 데는 시간이 걸립니다.\n\n앱을 오래전에 다운로드했는데 " +
        "작동하는 프록시를 찾지 못했다면 — 앱이나 구독 목록을 업데이트하세요. 이 앱은 " +
        "자체 프록시를 만들거나 제공하지 않으며, 수십 개의 그룹과 페이지에 걸쳐 인터넷에서 " +
        "검색만 할 뿐입니다."
    override fun proxyBtn(port: Int) = "프록시 ${port}"

    override val setupPortsTitle = "Telegram에서 포트 설정"
    override val setupPortsSub = "Telegram을 커넥터에 연결하는 방법 (포트 55001/55002)"
    override val settings = "설정"; override val settingsSub = "포트, 안티-DPI, 스캔, 네트워크, 배터리"
    override val subscriptions = "구독"; override val subscriptionsSub = "스캔할 프록시 출처"
    override val statistics = "통계"; override val statisticsSub = "프록시 데이터베이스 + 안티-DPI 기법"
    override val export = "내보내기"; override val exportSub = "작동 중인 프록시의 tg:// 링크"
    override val about = "정보"; override val aboutSub = "버전, 빌드, 다운로드, 피드백"
    override val hotkeys = "단축키"
    override val hotkeysSub = "전역 키: 프록시 복사 / 열기"
    override val hotkeysIntro = "전역 단축키는 앱 창에 포커스가 없을 때도 작동합니다. 풀에서 작동 중인 " +
        "프록시 링크(tg://)를 무작위로 골라줍니다 — 앱을 열지 않고 빠르게 프록시를 전환할 때 " +
        "유용합니다."
    override val hotkeysNote = "macOS에서는 키 캡처에 손쉬운 사용 권한이 필요할 수 있습니다 " +
        "(시스템 설정 → 개인정보 보호 및 보안 → 손쉬운 사용)."
    override val hotkeyCopyTitle = "프록시 링크 복사"
    override val hotkeyCopyDesc = "작동 중인 tg:// 링크를 무작위로 클립보드에 넣습니다."
    override val hotkeyEnable = "단축키 켜기"; override val hotkeyLetterLabel = "글자"; override val hotkeySet = "지정"; override val hotkeyReset = "초기화"
    override val hotkeyOpenTitle = "Telegram에서 프록시 열기"
    override val hotkeyOpenDesc = "작동 중인 링크를 무작위로 엽니다 — Telegram이 이를 받아 프록시 연결을 제안합니다."

    override val relayPorts = "릴레이 포트"
    override val relayPortsHelp = "커넥터가 수신 대기하는 로컬 포트입니다. 이 포트를 Telegram에 " +
        "SOCKS5 프록시로 정확히 입력합니다 (127.0.0.1 : 포트). 안정성을 위해 두 개의 포트를 사용하며 — Telegram은 " +
        "두 포트 모두에 연결을 유지합니다."
    override val portA = "포트 A"; override val portB = "포트 B"
    override val antiDpiTrick = "안티-DPI 기법"
    override val antiDpiHelp = "ISP/DPI가 연결을 인식하고 차단하지 못하도록 연결을 위장하는 방법입니다." +
        "\n• \"자동 순환\"은 작동하는 기법을 스스로 고릅니다.\n• \"DPI 기법 없음\" — 일반 " +
        "연결.\n• 나머지는 특정 기법입니다 (브라우저 흉내, 패킷 분할 등)."
    override val onlyFakeTls = "FakeTLS만 (ee)"
    override val applyDpiTo = "안티-DPI 적용 대상"
    override val applyDpiHelp = "선택한 안티-DPI 기법을 적용할 대상:\n• Telegram 릴레이 — 커넥터를 통한 " +
        "실제 Telegram 연결.\n• 프록시 프로브 — 백그라운드 프록시 검사 " +
        "(그러면 검사가 실제 연결과 똑같이 동작하여 기법 통계가 더 정확해집니다).\n" +
        "• 직접 연결 시 — 프록시가 꺼져 있거나(또는 VPN이 켜져 있어 건너뛸 때) Telegram이 " +
        "자체 서버로 바로 연결될 때: 여기엔 프록시가 없으므로, 기법은 " +
        "첫 TCP 패킷(핸드셰이크)을 여러 작은 세그먼트로 분할하여 DPI가 한 번에 인식하지 못하게 하는 것으로 축소됩니다."
    override val toRelay = "Telegram 릴레이"; override val toProbes = "프록시 프로브"
    override val toDirect = "직접 연결 시"
    override val vpnSection = "VPN이 켜져 있을 때"
    override val vpnHelp = "기기에서 VPN이 활성화되어 있을 때 할 일:\n• MTProto 프록시 경유 — " +
        "Telegram이 평소처럼 발견된 프록시를 통과합니다 (VPN 위에).\n• 직접 — " +
        "커넥터는 프록시를 사용하지 않고 Telegram을 Telegram 서버에 바로 연결합니다: " +
        "VPN이 이미 접속을 제공하므로 추가 프록시 계층이 필요 없습니다 (더 빠르고 안정적). " +
        "VPN이 없으면 프록시가 평소처럼 사용됩니다."
    override val linkFormat = "프록시 링크 형식"
    override val linkFormatHelp = "프록시를 복사하고 여는 방법. tg://는 Telegram을 직접 엽니다 (Telegram Desktop 설치 필요). http (t.me)는 브라우저를 통해 열어 Telegram에서 열기를 제안합니다 — tg://가 등록되어 있지 않을 때 유용합니다."
    override val linkTg = "tg:// (Telegram 직접 열기)"; override val linkTgSub = "tg://proxy?… — Telegram을 엽니다"
    override val linkHttp = "http (t.me, 브라우저 경유)"; override val linkHttpSub = "https://t.me/proxy?… — 브라우저를 엽니다"
    override val viaMtproto = "MTProto 경유 프록시"; override val viaMtprotoSub = "VPN이 있어도 트래픽이 프록시를 통과합니다"
    override val directly = "직접 연결"; override val directlySub = "VPN 활성 시 — 프록시를 우회하여 Telegram에 바로 연결"
    override val notifications = "알림"
    override val scanCheck = "스캔 및 검사"
    override val scanCheckHelp = "• 스캔, 분 — 구독에서 프록시 목록을 다운로드하는 주기.\n" +
        "• 검사, 분 — 데이터베이스의 프록시 작동 여부를 다시 검사하는 주기.\n• 배치 크기 — " +
        "한 번에 검사할 프록시 수.\n• 병렬 — 동시에 실행할 검사 수 (많을수록 " +
        "빠르지만 네트워크와 배터리 부하가 커집니다)."
    override val scanMin = "스캔, 분"; override val checkMin = "검사, 분"; override val batchSize = "배치 크기"; override val parallel = "병렬"
    override val speedByNet = "네트워크별 스캔 강도"
    override val speedByNetHelp = "현재 네트워크에 따라 프록시를 검사하는 주기. " +
        "\"표준\" = 기본 간격. 오른쪽으로 밀면 더 드물게 (느리고 트래픽/배터리에 부드러움), " +
        "왼쪽으로 밀면 더 자주 (빠르고 공격적). 로그 스케일, 양방향 최대 ×100.\n" +
        "• VPN — 외부 VPN이 활성일 때.\n• Wi-Fi — Wi-Fi 네트워크에서.\n• LTE — 모바일 네트워크에서."
    override val intensStandard = "표준"
    override val intensSlower = "느리게"
    override val intensFaster = "빠르게"
    override val maintenance = "데이터 초기화"
    override val maintenanceHelp = "• \"카탈로그 및 통계 초기화\" — 평가, 카운터, 트래픽, " +
        "검사 로그를 0으로 만들지만 다운로드한 호스트와 구독은 유지합니다 (다음 스캔 때 " +
        "모두 다시 평가됨).\n• \"다운로드한 호스트 지우기\" — 전체 프록시 풀을 삭제하지만 " +
        "구독은 유지하여 스캔이 풀을 다시 채웁니다. 어느 쪽이든 구독은 절대 건드리지 않습니다."
    override val backupTitle = "내보내기 / 가져오기"
    override val backupHelp = "앱 데이터를 JSON으로 저장하거나 복원합니다. 포함할 항목을 " +
        "선택하세요 — 어떤 조합이든 가능:\n• 설정 — 모든 앱 매개변수.\n• 구독 — 출처 " +
        "목록 (URL + 켜기/끄기).\n• 작동 호스트 카탈로그 — 네트워크 모드별로 평가와 통계를 " +
        "포함한 모든 작동 프록시.\n\n\"내보내기\"는 완성된 JSON이 있는 페이지를 엽니다 — 복사하거나 파일로 저장하세요. " +
        "\"가져오기\" — JSON을 붙여넣거나(또는 파일을 불러와) 그 안에 있는 선택된 섹션만 적용합니다. " +
        "가져오기는 현재 데이터에 추가합니다 (지우지 않음)."
    override val backupSettings = "설정"
    override val backupSubs = "구독"
    override val backupHosts = "작동 호스트 카탈로그 (모드별)"
    override val exportWord = "내보내기"
    override val importWord = "가져오기"
    override val backupExportTitle = "데이터 내보내기"
    override val backupImportTitle = "데이터 가져오기"
    override val backupSelectExport = "내보낼 항목:"
    override val backupSelectImport = "가져올 항목:"
    override val backupCopyBtn = "복사"
    override val backupSaveFile = "파일로 저장"
    override val backupLoadFile = "파일에서 불러오기"
    override val backupDoImport = "가져오기"
    override val backupPasteLabel = "여기에 백업 JSON 붙여넣기"
    override val backupJsonLabel = "백업 JSON"
    override val backupAndroidFileNote = "여기서는 파일을 사용할 수 없습니다 — 복사 / 붙여넣기를 사용하세요."
    override val eraseAllHosts = "모든 호스트 지우기"
    override val factoryReset = "전체 초기화 (첫 실행처럼)"
    override val factoryResetConfirm = "앱을 공장 초기 상태로 완전히 초기화할까요? 모든 설정과 전체 " +
        "호스트 카탈로그가 지워지고, 구독은 기본값으로 복원됩니다. 첫 실행과 똑같습니다."
    override val resetCatalog = "카탈로그 및 통계 초기화"
    override val resetCatalogConfirm = "모든 평가, 카운터, 검사 로그를 0으로 만들까요? " +
        "다운로드한 호스트와 구독은 유지되며 다음 스캔 때 다시 평가됩니다."
    override val clearHosts = "다운로드한 호스트 지우기"
    override val clearHostsConfirm = "다운로드한 호스트(프록시) 전체 목록을 삭제할까요? " +
        "구독은 유지되며 스캔이 풀을 다시 채웁니다."
    override val doReset = "초기화"
    override val doCancel = "취소"
    override val adaptiveSpeed = "적응형 속도"
    override val adaptiveHelp = "작동 여부 검사는 기본 간격으로 실행됩니다 (\"스캔 및 검사\"에서, " +
        "네트워크 배수도 곱해짐). \"적응형 속도\"는 현재 작동 중인 프록시 수에 따라 검사를 " +
        "자동으로 빠르게 하거나 느리게 합니다.\n\n" +
        "• 작동 중이 적을 때 (\"적음\" 임계값 미만) → 간격 × \"가속\". 1 미만의 배수 = 더 " +
        "자주: 0.5 — 두 배 자주, 0.25 — 4배. 풀을 더 빨리 채웁니다.\n" +
        "• 작동 중이 많을 때 (\"많음\" 임계값 초과) → 간격 × \"감속\". 1 초과 = 더 드물게: 2 — " +
        "절반만큼, 4 — 4분의 1. 배터리와 트래픽을 절약합니다.\n" +
        "• 임계값 사이 — 기본 속도 (×1).\n\n" +
        "예시:\n" +
        "— 프록시를 더 빨리 모으기: \"가속\" 0.25 그리고/또는 \"적음\" 임계값 40.\n" +
        "— 충분할 때 배터리 절약: \"감속\" 8 그리고/또는 \"많음\" 임계값 30.\n" +
        "— 적응 끄기: 두 배수를 모두 1로 설정.\n\n" +
        "기본값: 적음 20, 가속 0.5, 많음 50, 감속 4."
    override val threshMany = "\"많음\" 임계값"; override val threshFew = "\"적음\" 임계값"; override val mulFast = "가속 ×"; override val mulLazy = "감속 ×"
    override val subIntensityTitle = "구독 강도"
    override val subIntensityHint = "구독 다운로드 사이의 일시 정지: 프록시 목록을 다시 다운로드하기까지 몇 분 (네트워크 모드별로 따로)."
    override val baseScanTitle = "기본 스캔 속도"
    override val baseScanHelp = "기준이 되는 작동 여부 검사 속도. \"적응형 속도\"와 \"모드별 " +
        "속도\" 배수는 이 값을 기준으로 계산됩니다.\n\n" +
        "• 실행 주기, 분 — 검사 패스 사이의 간격.\n" +
        "• 스레드당 배치, 호스트 — 각 스레드가 패스마다 검사하는 호스트 수.\n" +
        "• 스레드 — 동시에 실행되는 검사 수. 한 패스는 \"배치 × 스레드\"개의 호스트를 검사합니다.\n" +
        "• N분에 한 번보다 자주 호스트를 다시 스캔하지 않기 — 플러드 방지: 최근에 검사한 호스트는 " +
        "이번 패스에서 건너뜁니다.\n\n" +
        "스레드와 배치가 클수록 = 풀 성장이 빠르지만 네트워크와 배터리 부하가 커집니다."
    override val baseScanPeriod = "실행 주기, 분"
    override val baseScanBatch = "스레드당 배치, 호스트"; override val baseScanThreads = "스레드 수"
    override val adaptiveDesc = "작동 중인 프록시가 \"적음\"보다 적거나 \"많음\"보다 많으면 추가 배수를 적용합니다."
    override val fewWord = "적음"; override val manyWord = "많음"
    override fun fasterX(x: String) = "${x}배 빠르게"
    override fun slowerX(x: String) = "${x}배 느리게"
    override fun ifAliveLt(n: Int) = "작동 프록시 < ${n}이면:"
    override fun ifAliveGt(n: Int) = "작동 프록시 > ${n}이면:"
    override val disabledWord = "꺼짐"
    override val speedByModeTitle = "모드별 속도"
    override val speedByModeHelp = "각 네트워크 모드의 스캔 속도 배수로, 기본 " +
        "속도 위에 적용됩니다. \"표준\" (×1) = 기본 간격. 오른쪽 — 더 드물게 (느리고 트래픽/" +
        "배터리에 부드러움), 왼쪽 — 더 자주 (빠르고 공격적). 로그 스케일, 양방향 최대 ×100.\n\n" +
        "각 슬라이더 아래에는 적응형 속도가 적용된 패스 매개변수가 표시됩니다 — " +
        "\"작동 적음\" (× \"가속\")과 \"작동 많음\" (× \"감속\")이 각각 따로 표시됩니다.\n\n" +
        "모드:\n• VPN — 외부 VPN이 활성.\n• LTE — 모바일 네트워크.\n• Wi-Fi — Wi-Fi 네트워크.\n" +
        "• Ethernet — 유선 연결.\n• White — 수동 \"화이트\" 프록시 모드."
    override val aliveLt = "작동 <"; override val aliveGt = "작동 >"
    override val periodWord = "주기"; override val nonstopWord = "논스톱"
    override val batchWord = "배치"; override val threadsWord = "스레드"; override val scanModeOff = "스캔 꺼짐"
    override val netBattery = "네트워크 및 배터리"
    override val netBatteryHelp = "• Wi-Fi에서만 — 모바일 네트워크에서는 스캔하지 않음 (데이터 절약).\n• 충전 " +
        "중에만 — 휴대폰이 충전 중일 때만 작동.\n• 배터리 부족 시 건너뛰기 — 배터리가 " +
        "부족하면 스캔 일시 정지."
    override val onlyWifi = "Wi-Fi에서만"; override val onlyCharging = "충전 중에만"; override val skipLowBattery = "배터리 부족 시 건너뛰기"
    override val autosaved = "설정은 자동으로 저장됩니다."
    override val dpiAutoLabel = "DPI 기법 자동 순환"; override val dpiNoneLabel = "DPI 기법 없음 (일반)"
    override val experimental = "실험적 기능"
    override val experimentalHelp = "MTProto 업스트림에 대한 대체 프록싱 엔진과 진단 로그입니다. " +
        "\"끄기\"로 설정하면 기준(작동) 경로는 변경되지 않습니다. 암호화된 스트림이 " +
        "업스트림 TCP 소켓에 어떻게 쓰이는지(세그먼트 크기, 타이밍, TLS 레코드 경계)만 바뀌고 — 스트림 자체는 바이트 단위로 동일하게 유지됩니다. " +
        "실제 프록시 릴레이에만 적용됩니다 (프로브나 직접 경로에는 적용 안 됨)."
    override val expEngineTitle = "프록싱 엔진 (소켓 난독화)"
    override val expConnectTitle = "연결 엔진 (업스트림 선택)"
    override val expEngineWarn = "⚠ 실험적 모드. 연결 상태가 나빠지면 \"끄기 (기준 경로)\"로 되돌리세요."
    override val netLog = "네트워크 교환 로그 켜기"
    override val netLogSub = "누가-누구에게-언제 그리고 패킷 크기를 파일에 기록합니다 (페이로드 데이터는 없음) — " +
        "VPN이 있을 때와 없을 때의 교환 패턴을 비교하기 위함."
    override val openLogFolder = "로그 폴더 열기"; override val copyPath = "경로 복사"
    override val helpShow = "도움말"; override val helpHide = "도움말 숨기기"
    override val quickSwitchIntro = "여기서 차단 우회 기법을 고를 수 있습니다. Telegram이 " +
        "\"사용 중인 프록시가 올바르게 설정되지 않아 비활성화됩니다. 다른 프록시를 찾아 주세요\" " +
        "오류를 표시하면, 어떤 트래픽 난독화 유형이 작동하여 Telegram이 더 이상 오류를 표시하지 않는지 실험해 보세요. " +
        "split* 모드부터 시작하세요. coalesce* 모드도 작동하지만, 이를 사용하면 Telegram에서 이미지/동영상이 잘 로드되지 않습니다."
    override val quickSwitchTitle ="차단 우회"; override val quickSwitchSub = "셰이핑, 연결, 안티-DPI"

    override val sourceUrl = "출처 URL"
    override fun sourceAlive(alive: Int, total: Int) = "작동 ${alive}/${total}"
    override val open = "열기"; override val active = "활성"; override val inactive = "비활성"
    override val lastDownloaded = "다운로드됨"; override val notDownloaded = "아직 다운로드 안 됨"
    override fun sourceCounts(dead: Int, total: Int) =
        " 작동, ${dead} 죽음, ${total} 전체"

    override val proxyBase = "프록시 데이터베이스"
    override val totalInBase = "데이터베이스 전체"; override val aliveNow = "현재 작동"; override val deadStat = "죽음"
    override val aliveIn15 = "15분 내 작동"; override val checksAllTime = "전체 기간 검사"
    override val antiDpiTricks = "안티-DPI 기법"; override val noStatsYet = "아직 데이터 없음 — 검사/연결이 발생하면서 기법 데이터가 쌓입니다"
    override val attempts = "시도"; override val handshake = "핸드셰이크"; override val score = "점수"
    override val tgConnect = "TG 연결"; override val socketsOver1m = "소켓 >1분"
    override val over10kb = "소켓 >10KB"; override val over100kb = ">100KB"; override val workTime = "작동 시간"
    override val statsLegend = "핸드셰이크 — 성공한 핸드셰이크 (시도 대비 %) · 점수 — 값 · " +
        "\"작동 시간\" — 5KB 이상이고 1분보다 긴 소켓의 총합."
    override val resetStats = "기법 통계 초기화"

    override fun aliveLinks(n: Int) = "작동 링크: ${n}개"
    override val copyAll = "모두 복사"
    override val openRandom = "무작위 열기"; override val copyRandom = "무작위 복사"; override val allShort = "전체"
    override val copyTop = "TOP 복사"; override val randomHost = "무작위 호스트"
    override val exportToFile = "파일로 내보내기"; override val exportSaved = "파일에 저장됨:"
    override val dlNow = "지금 다운로드"
    override fun downloadingFmt(sec: Long) = "다운로드 중… ${sec}초"
    override val cancel = "취소"
    override val deleteConfirmTitle = "구독을 삭제할까요?"
    override val subscriptionsAddHint = "구독 또는 프록시 링크 추가 →"
    override val addSourcesTitle = "추가"
    override val addSubsLabel = "구독 (한 줄에 URL 하나)"
    override val addSubsHelp = "유효한 URL이 있는 각 줄은 자체 구독이 되어 주기적으로 가져옵니다."
    override val addProxiesLabel = "완성된 프록시 링크 (고정 목록)"
    override val addProxiesHelp = "특정 프록시 링크 묶음을 붙여넣으세요 (tg://proxy, https://t.me/proxy, …). 이것은 구독이 아닙니다 — 목록은 절대 다운로드되지 않으며, 프록시는 카탈로그에 추가될 뿐입니다."
    override val addButton = "추가"
    override fun addedFmt(subs: Int, proxies: Int) = "추가됨: 구독 ${subs}개, 프록시 ${proxies}개"
    override val perSecond = "초당"
    override val graphSpeed = "속도"
    override val graphVolume = "용량"
    override val graphLatency = "핑"
    override val graphConnects = "연결"
    override val scanNow = "지금 스캔"; override val scanOnShort = "스캔 켜기"
    override val scanRunning = "스캔 실행 중"; override val scanIdle = "스캔 대기 중"; override val scanOffState = "스캔 꺼짐"; override val scanBatchPerThread = "배치/스레드"; override val scanPassHosts = "패스당 호스트"; override val minRescanLabel = "N분에 한 번보다 자주 호스트를 다시 스캔하지 않기"
    override val scanPlanTitle = "계획"; override val scanNowTitle = "현재"; override val currentScheduleTitle = "현재 스케줄"
    override val scheduleWord = "스케줄"; override val unitPcsPerSec = "개/초"
    override val scanNowThreadsLabel = "현재 실행 중인 스레드"; override val scanNowPerThreadLabel = "스레드당 검사 (계획)"; override val scanNowElapsedLabel = "실행 시간"
    override val scanOkGraph = "성공한 스캔"; override val scanFailGraph = "실패한 스캔"; override val scanTrafficGraph = "스캔 트래픽"; override val scanAliveGraph = "작동 프록시 전체"; override val scanPingGraph = "핑"; override val threadsGraph = "스레드"
    override val scanEvery = "주기"; override val scanNextRun = "다음 실행"
    override val scanThreads = "스레드"; override val scanBatch = "배치"
    override val scanElapsed = "실행 중"; override val scanIdleNow = "—"
    override val effForFew = "적을 때"; override val effForMany = "많을 때"
    override val effCheck = "검사"; override val effBatch = "배치"; override val effPar = "병렬"
    override val effContinuous = "연속"; override val secShort = "초"; override val minShort = "분"

    override val appTagline = "크로스 플랫폼 자동 커넥터: Telegram이 작동할 수 있는 MTProto 프록시를 " +
        "찾고, 검사하고, 실행합니다."
    override val version = "버전"; override val buildDate = "빌드 날짜"
    override val downloadSources = "다운로드 및 소스"; override val openOnGithub = "GitHub에서 열기"
    override val feedbackBugs = "피드백 및 버그 신고"; override val writeTelegram = "Telegram으로 문의"

    override val language = "언어"; override val langAuto = "자동 (시스템)"; override val langRu = "Русский"; override val langEn = "English"
    override val langFa = "فارسی"; override val langZh = "简体中文"; override val langAr = "العربية"; override val langUr = "اردو"
    override val langTr = "Türkçe"; override val langId = "Bahasa Indonesia"; override val langHi = "हिन्दी"; override val langBn = "বাংলা"; override val langMy = "မြန်မာ"
    override val langWord = "언어"
    override val raceWidthTitle = "병렬 연결"
    override val connectionSection = "연결 및 차단 우회"
    override val connectionSectionHelp = "연결 엔진, 병렬 업스트림, 프록싱 엔진, 안티-DPI 기법 — 모두 한 섹션에 있습니다."
    override val netLogSection = "네트워크 교환 로그"
    override val platform = "플랫폼"

    override val scanModeTitle = "네트워크 모드"; override val scanModeAuto = "자동"; override val scanModeManualLabel = "수동"
    override val activeModeLabel = "활성 모드"; override val formingListLabel = "목록 구성 중"; override val catalogModeTabs = "모드"
    override val resetModeRatings = "호스트 평가 초기화"; override val forgetModeHosts = "모드 호스트 잊기"
    override val exportModeTitle = "모드별 내보내기"; override val modePickerTitle = "모드"
    override val modeHelp = "각 네트워크 모드는 자체 프록시 평가와 자체 스캔 + 구독 다운로드 강도를 유지합니다. \"자동\"은 활성 네트워크에서 모드를 고릅니다. \"수동\"은 원하는 모드를 직접 선택할 수 있습니다 (자동이 절대 선택하지 않는 White 포함)."
    override val autoSelect = "자동 선택"; override val manualSelect = "수동 선택"
    override val connStatsTitle = "현재 연결"; override val connOnPort = "포트별 연결"; override val outgoingConns = "발신 연결"
    override val modeChoice = "모드 선택"; override val autoChoice = "자동 선택"; override val manualChoice = "수동 고정"
    override val directOnVpn = "VPN 시 TG에 직접 연결"; override val onWord = "켜짐"; override val offWord = "꺼짐"
    override val directStateActive = "활성"; override val directStateOff = "설정에서 꺼짐"; override val directStateIdle = "설정에서 켜짐, 하지만 비활성"
    override val wpHintTitle = "White란 무엇인가요?"
    override val wpHint = "White — WhitePages: 수동 네트워크 프로필. 손으로만 켤 수 있습니다 (자동 선택은 절대 고르지 않음). " +
        "자체 호스트 평가를 유지하고, VPN/Wi-Fi/LTE와 독립적으로 구독을 다운로드하며 스캔합니다."

    override val recentAttempts = "최근 연결 및 검사"
    override val kindCheck = "검사"
    override val kindTg = "텔레그램"
    override val histWho = "누구"
    override val histWhen = "언제"
    override val histReq = "요청"
    override val histSess = "세션"
    override val histScan = "스캔"
    override val testNow = "지금 테스트"
    override val testShort = "테스트"
    override val testResult = "테스트 결과"
    override val testStop = "정지"
    override val testingNow = "테스트 중…"
    override val prewarmTitle = "소켓 예열 (실험적)"
    override val prewarmHelp = "프록시로 향하는 소켓 몇 개를 미리 열어 두어, 새로운 Telegram 연결이 " +
        "연결/핸드셰이크를 건너뛸 수 있게 합니다. 실험적: 백그라운드에서 계속 재연결하므로 → 트래픽과 " +
        "약간의 CPU를 소모합니다. 가짜 트래픽은 보내지 않으며 (그러면 실제 세션이 손상됩니다) — 소켓을 " +
        "단순히 순환할 뿐입니다. FakeTLS 프록시에서 가장 유용합니다."
    override val prewarmEnable = "예열 켜기"
    override val prewarmModeDeferred = "지연 (TLS만)"
    override val prewarmModeDeferredSub = "TCP + FakeTLS를 유지하고; 인계 시점에 obfuscated2-init을 마저 보냅니다. DC는 커밋하지 않음 — 가장 현실적입니다."
    override val prewarmModeFull = "전체 핸드셰이크"
    override val prewarmModeFullSub = "여러 DC에 걸쳐 완전히 연결된 소켓을 유지하고; DC/tag가 일치할 때만 재사용합니다. 수명이 더 짧습니다."
    override val prewarmPoolLabel = "예비 소켓"
    override val prewarmHoldLabel = "유지 시간, 초"
    override val prewarmNote = "순환만 함 (앱 레벨 keepalive 없음). 소켓은 프록시/DC에 따라 몇 초에서 약 1분 정도 유지됩니다."
    override val prewarmStatus = "예열"
    override fun prewarmStatusVal(ready: Int, holdSecs: Int) = "${ready}개 준비 · ${holdSecs}초 유지"
    override val prewarmStar = "굵은 주황색 = 예열 풀에서 따뜻한 상태로 인계된 소켓 (연결/핸드셰이크 생략)"
    override fun prewarmTableTitle(holdSecs: Int) = "소켓 예열 (${holdSecs}초 유지)"
    override val prewarmTableHelp = "\"소켓 예열\"은 새로운 Telegram 연결이 연결/핸드셰이크를 건너뛸 수 있도록 프록시 소켓 " +
        "몇 개를 미리 엽니다. 이 표에는 예열 중인 호스트가 표시됩니다: 각 소켓이 얼마나 오래 유지되었는지, " +
        "Telegram이 사용 중인지, 그리고 트래픽. \"더 보기 → 설정 → '소켓 예열 (실험적)'\"에서 켜고 끄거나 " +
        "설정(모드, 소켓 수, 유지 시간)을 변경할 수 있습니다."
    override val prewarmNoneWarming = "아직 예열 중인 소켓 없음"
    override val prewarmColAge = "수명"
    override val prewarmColUse = "TG에서?"
    override val prewarmInUse = "TG에서"
    override val prewarmNew = "신규"
    override val lanShareTitle = "로컬 네트워크 공유 (웹 포털)"
    override val lanShareDesc = "이 Wi-Fi의 다른 기기들이 이 AutoConnector를 프록시로 사용하도록 허용합니다; 아래 주소를 여는 브라우저는 최적의 프록시 페이지를 받게 됩니다."
    override val lanShareUrlsLabel = "네트워크 이웃은 다음으로 연결:"
    override val lanShareNoIp = "로컬 네트워크 주소 없음 — Wi-Fi에 연결하세요"
    override val lanFirewallTitle = "로컬 네트워크에서 허용"
    override val lanFirewallBody = "이를 켜면 릴레이 포트가 로컬 네트워크로 열립니다. 이제 Windows(또는 다른) 방화벽이 AutoConnector를 허용할지 물을 수 있습니다 — \"허용\"/\"예\"를 선택하세요. 거부하면 AutoConnector로 향하는 이웃의 트래픽이 차단되어 페이지/프록시에 접근할 수 없게 됩니다."
    override val lanFirewallConfirm = "켜기"
    override val lanInfoTitle = "이게 무엇에 쓰이나요?"
    override val lanInfoBody = "Wi-Fi의 한 대의 컴퓨터나 휴대폰에서 AutoConnector를 실행하세요 — 그러면 같은 네트워크의 다른 모든 기기가, 이 앱을 직접 지원하지 않는 iPhone을 포함하여, 브라우저에서 주소를 열어 사용할 수 있습니다: 자신의 Telegram에 추가할 최적의 프록시 페이지, 또는 이 기기 자체를 SOCKS 프록시로. 한 기기가 프록시를 찾아 유지하고, 나머지는 로컬 네트워크를 통해 그것을 빌려 씁니다."
    override val volTriggerTitle = "볼륨 버튼 트리거"
    override val volTriggerSub = "빠른 볼륨 키 패턴으로 프록시 전환"
    override val volEnableLabel = "볼륨 버튼 감시"
    override val volHelpTitle = "이게 뭐죠?"
    override val volHelpBody = "Android에는 전역 키보드 단축키가 없으므로, 대신 볼륨 버튼을 사용합니다. 켜져 있으면 AutoConnector가 백그라운드에서 빠른 볼륨 업/다운 누름 패턴(예: 업-업-다운-다운)을 감시합니다. 패턴을 인식하면, 무작위로 양호하고 작동 중인 프록시의 tg:// 링크를 열어 Telegram이 이를 받아 전환하도록 합니다 — 앱을 열지 않고 프록시를 빠르고 은밀하게 바꾸는 방법입니다. 볼륨은 평소처럼 작동합니다 (누름이 가로채이지 않음). 이 기능에는 접근성(Accessibility) 권한이 필요합니다 (백그라운드에서 볼륨 키를 읽고 링크를 실행하기 위해); 토글을 켜기 전까지는 아무것도 요청하지 않습니다. 아래에서 누름 사이의 최대 시간을 설정하세요; 인식되는 패턴은 하단에 나열되어 있습니다."
    override val volGrantTitle = "접근성(Accessibility) 켜기 (중요)"
    override val volGrantBody = "Android(특히 13 이상)는 Google Play에서 설치하지 않은 앱의 접근성(Accessibility)을 차단합니다 — 그래서 AutoConnector가 회색으로 표시되고 \"제한된 설정\" / \"접근이 허용되지 않음\"이라고 나옵니다.\n\n차단 해제 방법:\n1. \"앱 정보\"를 여세요 (아래 버튼, 또는 설정 → 앱 → AutoConnector for Telegram).\n2. ⋮ 메뉴(오른쪽 위)를 누르세요 → \"제한된 설정 허용\" → 확인.\n3. 돌아가기: 설정 → 접근성(Accessibility) → AutoConnector for Telegram → 켜기.\n\n\"제한된 설정 허용\"이 보이지 않으면, 먼저 접근성에서 토글을 한 번 켜 보세요 (차단 메시지가 나타납니다), 그러면 2단계가 나타납니다.\n\nXiaomi/MIUI, Samsung 등에서는 경로가 약간 다를 수 있습니다 — \"앱 정보\"에서 같은 ⋮를 찾으세요. Android 12 이하에서는 보통 제한이 없습니다 — 접근성에서 바로 켜세요.\n\n볼륨 키는 관찰만 되며 절대 차단되지 않습니다."
    override val volOpenAppInfo = "\"앱 정보\" 열기"
    override val volAccessOn = "접근성(Accessibility): 켜짐"
    override val volAccessOff = "접근성(Accessibility): 꺼짐"
    override val volOpenAccess = "접근성(Accessibility) 설정 열기"
    override val volGapLabel = "누름 사이 최대 ms"
    override val volPatternsTitle = "인식되는 패턴"
    override val volPatternPick = "패턴"
    override val volPatternsLegend = "↑ = 볼륨 업, ↓ = 볼륨 다운"
    override val volNoRights = "앱이 아직 볼륨 버튼을 처리할 권한이 없습니다 — 이 페이지 하단의 단계에 따라 접근을 허용하세요."
    override val volGrantShort = "아직 접근성(Accessibility) 접근 권한이 없습니다. 이 페이지 하단의 자세한 단계를 읽고 \"확인\"을 누르세요."
    override val volCheck = "확인"
    override val volCheckOk = "✓ 완료 — 접근 권한이 부여되어 트리거가 작동합니다."
    override val volCheckFail = "✗ 아직 접근 권한이 없습니다 — 위 단계를 완료하세요."
    override val volPatternsList = "↑↑↓↓ · ↓↓↑↑ · ↑↓↑↓ · ↓↑↓↑ · ↑↑↑↑ · ↓↓↓↓ · ↑↓↓↑ · ↓↑↑↓ · ↑↑↑↓↓↓ · ↓↓↓↑↑↑   (↑ = 볼륨 업, ↓ = 볼륨 다운)"
    override val histLegend = "열 — 누구: ✓/✗ TG = 실제 Telegram 연결, 스캔 = 백그라운드 검사. 언제: 얼마나 전. TCP/TLS/요청: 핸드셰이크 및 첫 요청 지연, ms. 세션: 릴레이 세션이 지속된 시간. ↓/↑: 호스트를 통해 수신/송신한 바이트."
    override val tgOkTotalHint = "Telegram 연결 / 성공 / 전체 검사"
    override val breadthTitle = "호스트 선택 폭"
    override val breadthHelp = "왼쪽 — 검증된 최적 호스트를 고수; 오른쪽 — 작동 중인 다양한 호스트를 최대한 넓게 시도. Telegram이 릴레이 포트를 계속 바꿀 때 앱이 자동으로 선택 폭을 넓힙니다."
    override val breadthNarrow = "검증됨"
    override val breadthWide = "더 넓게"
    override val connTimeoutTitle = "호스트별 연결 타임아웃"
    override val connTimeoutHelp = "다음 프록시로 넘어가기 전에 하나의 업스트림(TCP + TLS + 첫 MTProto 응답)을 얼마나 기다릴지."
    override val factoryResetDone = "모두 초기화되었습니다. 앱을 닫고 다시 여세요."
}
