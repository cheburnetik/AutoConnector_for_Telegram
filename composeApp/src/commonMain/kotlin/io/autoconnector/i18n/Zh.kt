package io.autoconnector.i18n

object Zh : Strings {
    override val tabConnector = "连接器"; override val tabScan = "扫描"
    override val tabCatalog = "目录"; override val tabLogs = "日志"; override val tabMore = "更多"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "订阅"; override val logTabScan = "扫描"
    override val logGeneral = "概览"; override val logEmpty = "暂时为空"
    override val logSessions = "会话"; override val logErrorsOnly = "仅错误"; override val logNoErrors = "没有失败的会话"
    override fun logSession(id: String, port: String) = "#$id · :$port"
    override val back = "返回"; override val copy = "复制"; override val gotIt = "知道了"
    override val later = "稍后"; override val details = "详情"; override val whatIsThis = "这是什么？"
    override val delete = "删除"

    override val connector = "连接器"; override val scan = "扫描"
    override val notConfigured = "尚未设置！去修复 →"; override val howToSetup = "如何设置"
    override val notifOff = "通知已关闭！去修复 →"; override val enable = "启用"
    override fun fewProxies(n: Int) = "可用代理 $n 个，正在搜索，请等待约 15 分钟…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "可用代理：$alive  （15 分钟内：$within） · 共计：$total"
    override val notifWhyTitle = "为什么需要通知？"
    override val notifWhyBody = "常驻的通知图标意味着一个 Android 前台服务。" +
        "没有它，系统会把应用从内存中卸载，使其停止搜索代理，也无法" +
        "在后台保持连接。因此通知是 " +
        "AutoConnector 正常运行的必要条件。"
    override val notifEnableTitle = "启用通知"
    override val notifEnableBody = "没有通知图标，Android 会把应用视为不活跃并" +
        "将其从内存中卸载。于是 AutoConnector 会停止搜索代理，也无法在后台保持" +
        "连接 —— Telegram 会失去其连接。\n\n点击\"启用\"并允许" +
        "AutoConnector 发送通知。"
    override val notifPlea = "请启用通知！没有通知，应用无法在后台运行 —— " +
        "Android 会将其卸载，代理搜索和连接都会停止。"

    override val statusConnected = "Telegram 已连接"; override val statusConnecting = "连接中…"
    override val statusOffline = "Telegram 未连接"; override val statusIdle = "Telegram 空闲"
    override val nobodyConnected = "没有人连接到连接器。"; override val howToSetupArrow = "如何设置 →"
    override val directModeViaVpn = "直连模式：VPN 已启用 —— 不使用代理"
    override val directModeOff = "直连模式：代理已关闭"
    override val directDpiSuffix = " · anti-DPI"
    override val connections = "连接"; override val sockets = "套接字"; override val speed = "速度"
    override val traffic = "流量"; override val latency = "延迟"
    override fun pcs(n: Int) = "$n 个"
    override fun netNow(label: String) = "网络：$label"
    override fun tgToConnector(n: Int) = "TG→ $n"
    override fun connectorToProxy(n: Int) = "代理 $n"
    override val trafficSec = "流量 · 60 秒"; override val trafficMin = "流量 · 60 分钟"
    override val latencySec = "延迟 · 60 秒"; override val latencyMin = "延迟 · 60 分钟"
    override val sec60 = "60 秒"; override val min60 = "60 分钟"
    override val unitSec = "秒"; override val unitMin = "分"; override val unitHour = "时"; override val dash = "—"
    override val currentProxy = "当前代理"; override val noActiveProxy = "无活跃代理（Telegram 未连接）"
    override val host = "主机"; override val type = "类型"; override val secret = "密钥"; override val antiDpi = "Anti-DPI"; override val obfEngine = "混淆引擎"
    override fun activeSockets(n: Int) = "活跃的 Telegram 套接字：$n"
    override val noConnections = "无活跃连接"; override val colHost = "主机"; override val colTime = "时间"
    override val modeWord = "模式"; override val directViaVpnLine = "直接向 Telegram 发起请求（VPN 已启用）"
    override val connModeHelp = "模式（VPN、Wi-Fi、LTE、Ethernet、白名单）让你为不同情况分别调节扫描强度，并分别保存各自的主机评分/统计。网络类型会自动识别；也可以在设置中手动指定模式。"

    override val scanOff = "扫描已关闭"; override val proxiesInBase = "数据库中的代理"
    override val total = "共计"; override val alive = "可用"; override val dead = "失效"
    override val tgConnectedTitle = "Telegram 已通过以下方式连接"; override val successful = "成功"
    override val socketsHeld = "套接字存活时间"; override val over1m = ">1 分钟"; override val over5m = ">5 分钟"; override val over15m = ">15 分钟"
    override val scanCountTitle = "代理检测次数"; override val checked = "已检测"
    override val forAllTime = "全部时间"; override val perMinute = "每分钟"; override val perHour = "每小时"
    override val subsCountTitle = "订阅下载次数"; override val downloaded = "已下载"; override val failed = "失败"; override val scanTraffic = "扫描流量"; override val subTraffic = "订阅流量"; override val subTrafficGraph = "订阅流量"
    override val checksMtproto = "MTProto 检测（↑ 成功 · ↓ 失败）"

    override fun catalogEmpty(mode: String) = "目录 $mode 暂时为空。可能是没有找到主机，或者应用从未在此模式下运行过。你可以在设置中切换模式。模式的存在是为了针对不同类型的网络连接分别收集主机。"
    override val aliveShort = "✓ 可用"; override val deadShort = "✗ 失效"
    override val statusLabel = "状态"; override val rating = "评分"; override val port = "端口"
    override val rttPing = "RTT（ping）"; override val checkedField = "已检测"; override val okOfTotal = "成功 / 总检测次数"
    override val tgConnectedField = "Telegram 已连接"; override val tgSessions = "Telegram 会话"; override val trafficThroughProxy = "经过代理的流量"
    override val sessionsTotal = "会话总数"; override val relayNow = "当前中继"; override val tlsDomain = "TLS 域名（SNI）"
    override val sourceSub = "来源（订阅）"; override val lastError = "最近错误"; override val yes = "是"; override val no = "否"
    override val copyAsLink = "复制为链接"; override val openInTelegram = "在 Telegram 中打开主机"; override val makeNextRelay = "设为下一个中继"
    override val actCopy = "复制"; override val actOpen = "打开"; override val actRelay = "中继"
    override fun agoFmt(v: String) = "$v 前"
    override val catalogTopFor = "代理列表/评分，针对"
    override val catalogModeHelpTitle = "模式与评分"
    override val catalogModeHelp = "应用会按网络模式（VPN、Wi-Fi、LTE、Ethernet 和白名单）分别统计可用主机及其评分。\"白名单\"是用于白名单的独立手动模式；自动选择从不会切换到它。因此同一主机可能在某个模式下可用，而在另一个模式下失效。"
    override fun catalogInactiveWarn(section: String, active: String) =
        "你正在查看非活跃的分区 $section —— 现在所有统计都计入 $active，而不是这里。"
    override val manageModeTitle = "管理模式"
    override val manageResetRating = "重置评分"
    override fun manageResetHint(mode: String) = "你可以专门针对 $mode 重置可用主机的评分和使用统计。当你切换到完全不同的 VPN 或 LTE 时这很有用，旧统计就不会造成干扰。或者用来观察代理扫描从头重新检测一切的速度。"
    override val manageDeleteAll = "删除主机，所在模式"
    override fun manageDeleteHint(mode: String) = "你可以从 $mode 中同时清除评分和主机本身。\"扫描代理\"功能会再次收集它们。这不是订阅重置 —— 你可以点击它，然后等待约 15 分钟重新扫描。"
    override fun manageCopyFrom(mode: String) = "将所有主机和评分从另一个模式复制到当前模式（$mode）："
    override val live = "可用"; override val deadW = "失效"; override val unitMs = "毫秒"
    override val agoMin = "分"; override val agoHour = "时"; override val agoDay = "天"

    override val connectTelegram = "连接 Telegram"; override val readCarefully = "请仔细阅读！"
    override val guideIntro = "本应用未经设置无法工作。从下面 3 个方案中任选一个，" +
        "并仔细按照说明操作。"
    override val variant1 = "方案 #1 —— 按钮"
    override val variant1Body = "点击\"代理 {A}\" —— Telegram 会打开，确认添加该代理。返回" +
        "本界面并点击\"代理 {B}\" —— 再次确认添加。\n\n关闭 Telegram 中" +
        "其他所有旧代理。必须正好保留 2 个代理 —— 端口为 {A} 和 {B}。" +
        "使用其他任何组合 AutoConnector 都无法工作。"
    override val variant2 = "方案 #2 —— 链接"
    override val variant2Body = "把下面的文本复制到 Telegram 的\"收藏夹\"（或任意聊天）中 —— " +
        "也就是发送给你自己。点击消息中的第一个链接 —— 第一个代理被添加。" +
        "点击第二个链接 —— 第二个被添加。然后关闭所有旧代理。"
    override val variant3 = "方案 #3 —— 手动"
    override val variant3Body = "手动添加一个 SOCKS5 代理：服务器 localhost（127.0.0.1），端口 {A}。" +
        "然后添加第二个代理：localhost，端口 {B}。删除所有旧代理。"
    override val whatNext = "接下来呢？"
    override val whatNextBody = "在 Telegram 中启用\"自动切换代理\" —— 5 秒。你可以帮助 " +
        "Telegram 连接：手动点击一个（在 Telegram 内）不活跃或标记为" +
        "\"不可用\"的代理 —— 这会让 Telegram 更努力地尝试连接。\n\n确保除 {A} 和 {B} 外" +
        "其他所有旧代理都已删除。在 Telegram 中点击" +
        "\"使用代理\"。\n\n等待应用找到并下载足够的代理" +
        "（5–15 分钟）。然后 Telegram 会自行连接到 AutoConnector，它会持续把 " +
        "Telegram 路由到最佳代理：已验证、可用且快速的代理。\n\n如果说明看起来" +
        "很难 —— 抱歉，你将无法使用本应用：无法做到全自动设置一切，" +
        "而且寻找可用代理需要时间。\n\n如果你很早以前下载了应用" +
        "却找不到可用代理 —— 请更新应用或更新订阅列表。本应用" +
        "不会发明或提供自己的代理，它只在互联网上跨数十个" +
        "群组和页面搜索。"
    override fun proxyBtn(port: Int) = "代理 $port"

    override val setupPortsTitle = "在 Telegram 中设置端口"
    override val setupPortsSub = "如何把 Telegram 连接到连接器（端口 55001/55002）"
    override val settings = "设置"; override val settingsSub = "端口、anti-DPI、扫描、网络、电池"
    override val subscriptions = "订阅"; override val subscriptionsSub = "要扫描的代理来源"
    override val statistics = "统计"; override val statisticsSub = "代理数据库 + anti-DPI 技巧"
    override val export = "导出"; override val exportSub = "可用代理的 tg:// 链接"
    override val about = "关于"; override val aboutSub = "版本、构建、下载、反馈"
    override val hotkeys = "热键"
    override val hotkeysSub = "全局按键：复制 / 打开代理"
    override val hotkeysIntro = "全局热键即使在应用窗口未聚焦时也会触发。它们会从代理池中挑选一个" +
        "随机的可用代理链接（tg://）—— 便于在不打开应用的情况下快速切换代理。"
    override val hotkeysNote = "在 macOS 上，捕获按键可能需要\"辅助功能\"权限" +
        "（系统设置 → 隐私与安全性 → 辅助功能）。"
    override val hotkeyCopyTitle = "复制代理链接"
    override val hotkeyCopyDesc = "把一个随机的可用 tg:// 链接放到剪贴板。"
    override val hotkeyEnable = "启用热键"; override val hotkeyLetterLabel = "字母"; override val hotkeySet = "设置"; override val hotkeyReset = "重置"
    override val hotkeyOpenTitle = "在 Telegram 中打开代理"
    override val hotkeyOpenDesc = "打开一个随机的可用链接 —— Telegram 会接收并提示连接该代理。"

    override val relayPorts = "中继端口"
    override val relayPortsHelp = "连接器监听的本地端口。你在 Telegram 中作为 SOCKS5 代理" +
        "（127.0.0.1 : 端口）填写的正是这些端口。使用两个端口是为了可靠性 —— Telegram " +
        "会同时保持对两者的连接。"
    override val portA = "端口 A"; override val portB = "端口 B"
    override val antiDpiTrick = "Anti-DPI 技巧"
    override val antiDpiHelp = "一种伪装连接的方式，使 ISP/DPI 无法识别并" +
        "屏蔽它。\n• \"自动轮换\"会自行挑选一个有效技巧。\n• \"无 DPI 技巧\" —— 普通" +
        "连接。\n• 其余的是具体技术（浏览器模拟、分包等）。"
    override val onlyFakeTls = "仅 FakeTLS（ee）"
    override val applyDpiTo = "将 anti-DPI 应用于"
    override val applyDpiHelp = "把所选 anti-DPI 技巧应用于哪里：\n• Telegram 中继 —— 应用于" +
        "经过连接器的实时 Telegram 连接。\n• 代理探测 —— 应用于后台代理检测" +
        "（这样检测的行为就和真实连接一样，技巧统计也更准确）。\n" +
        "• 直连时 —— 当代理关闭（或在 VPN 开启时被跳过），且 Telegram " +
        "直接连接其服务器时：这里没有代理，因此技巧退化为把" +
        "第一个 TCP 数据包（握手）拆分成若干小段，使 DPI 无法在一次读取中匹配它。"
    override val toRelay = "Telegram 中继"; override val toProbes = "代理探测"
    override val toDirect = "直连时"
    override val vpnSection = "当 VPN 开启时"
    override val vpnHelp = "设备上启用 VPN 时该怎么做：\n• 通过 MTProto 代理 —— " +
        "Telegram 像往常一样经过找到的代理（在 VPN 之上）。\n• 直连 —— " +
        "连接器\"不\"使用代理，直接把 Telegram 连接到 Telegram 的服务器：" +
        "VPN 已经提供了访问，多余的代理层并不需要（更快更稳定）。" +
        "没有 VPN 时照常使用代理。"
    override val linkFormat = "代理链接格式"
    override val linkFormatHelp = "如何复制和打开代理。tg:// 直接打开 Telegram（需要安装 Telegram Desktop）。http（t.me）通过浏览器打开并提示在 Telegram 中打开 —— 当 tg:// 未注册时很有用。"
    override val linkTg = "tg://（直接打开 Telegram）"; override val linkTgSub = "tg://proxy?… —— 打开 Telegram"
    override val linkHttp = "http（t.me，通过浏览器）"; override val linkHttpSub = "https://t.me/proxy?… —— 打开浏览器"
    override val viaMtproto = "通过 MTProto 代理"; override val viaMtprotoSub = "即使开启 VPN，流量也经过代理"
    override val directly = "直接连接"; override val directlySub = "在 VPN 启用时 —— 绕过代理，直连 Telegram"
    override val notifications = "通知"
    override val scanCheck = "扫描与检测"
    override val scanCheckHelp = "• 扫描，分钟 —— 多久从订阅下载一次代理列表。\n" +
        "• 检测，分钟 —— 多久重新检测一次数据库中代理的可用性。\n• 批量大小 —— " +
        "每次运行检测多少个代理。\n• 并行数 —— 同时运行多少个检测（越多 = " +
        "越快，但网络和电池负载越高）。"
    override val scanMin = "扫描，分钟"; override val checkMin = "检测，分钟"; override val batchSize = "批量大小"; override val parallel = "并行数"
    override val speedByNet = "按网络的扫描强度"
    override val speedByNetHelp = "根据当前网络多久检测一次代理。" +
        "\"标准\" = 基准间隔。向右滑动表示更稀疏（更慢，更省流量/电池），" +
        "向左表示更频繁（更快，更激进）。对数刻度，两个方向最多 ×100。\n" +
        "• VPN —— 当外部 VPN 启用时。\n• Wi-Fi —— 在 Wi-Fi 网络上。\n• LTE —— 在移动网络上。"
    override val intensStandard = "标准"
    override val intensSlower = "更慢"
    override val intensFaster = "更快"
    override val maintenance = "重置数据"
    override val maintenanceHelp = "• \"重置目录与统计\" —— 把评分、计数器、流量" +
        "和检测日志清零，但保留已下载的主机和订阅（下次扫描时一切会重新评分）。\n" +
        "• \"清除已下载的主机\" —— 删除整个代理池，但保留" +
        "订阅，让扫描重新填充池。无论哪种方式订阅都不会被改动。"
    override val backupTitle = "导出 / 导入"
    override val backupHelp = "把应用数据保存或恢复到单个 JSON 文件中。勾选要" +
        "包含的内容 —— 任意组合：\n• 设置 —— 所有应用参数。\n• 订阅 —— 来源" +
        "列表（URL + 开/关）。\n• 可用主机目录 —— 每个可用代理及其评分和统计，" +
        "\"按\"网络模式。\n\n\"导出\"会询问保存位置；\"导入\"会询问打开哪个文件，并" +
        "只应用其中存在的已勾选分区。导入会\"添加\"到当前数据（不会清除）。"
    override val backupSettings = "设置"
    override val backupSubs = "订阅"
    override val backupHosts = "可用主机目录（按模式）"
    override val exportWord = "导出"
    override val importWord = "导入"
    override val eraseAllHosts = "清除所有主机"
    override val factoryReset = "全部重置（如同首次启动）"
    override val factoryResetConfirm = "将应用完全恢复到出厂状态？\"所有\"设置和整个" +
        "主机目录都将被清除，订阅恢复为默认值。就像首次启动一样。"
    override val resetCatalog = "重置目录与统计"
    override val resetCatalogConfirm = "把所有评分、计数器和检测日志清零？" +
        "已下载的主机和订阅会保留，并在下次扫描时重新评分。"
    override val clearHosts = "清除已下载的主机"
    override val clearHostsConfirm = "删除整个已下载主机（代理）列表？" +
        "订阅会保留，扫描会重新填充代理池。"
    override val doReset = "重置"
    override val doCancel = "取消"
    override val adaptiveSpeed = "自适应速度"
    override val adaptiveHelp = "可用性检测以基准间隔运行（来自\"扫描与检测\"，还会" +
        "乘以网络倍率）。\"自适应速度\"会根据当前有多少代理可用，" +
        "自动加快或放慢检测。\n\n" +
        "• 可用数\"少\"（低于\"少\"阈值）→ 间隔 × \"加速\"。倍率小于 1 = 更" +
        "频繁：0.5 —— 频率加倍，0.25 —— ×4。更快填充代理池。\n" +
        "• 可用数\"多\"（高于\"多\"阈值）→ 间隔 × \"减速\"。大于 1 = 更稀疏：2 —— " +
        "频率减半，4 —— 四分之一。省电省流量。\n" +
        "• 在两个阈值之间 —— 基准速度（×1）。\n\n" +
        "示例：\n" +
        "—— 更快收集代理：\"加速\" 0.25 和/或\"少\"阈值 40。\n" +
        "—— 在数量足够时省电：\"减速\" 8 和/或\"多\"阈值 30。\n" +
        "—— 关闭自适应：把两个倍率都设为 1。\n\n" +
        "默认值：少 20，加速 0.5，多 50，减速 4。"
    override val threshMany = "\"多\"阈值"; override val threshFew = "\"少\"阈值"; override val mulFast = "加速 ×"; override val mulLazy = "减速 ×"
    override val subIntensityTitle = "订阅强度"
    override val subIntensityHint = "订阅下载之间的暂停：重新下载代理列表前要等多少分钟（按网络模式分别设置）。"
    override val baseScanTitle = "基准扫描速度"
    override val baseScanHelp = "参考的可用性检测速度。\"自适应速度\"和\"按模式" +
        "的速度\"倍率都相对于它计算。\n\n" +
        "• 多久运行一次，分钟 —— 检测轮次之间的间隔。\n" +
        "• 每线程批量，主机数 —— 每个线程每轮检测多少主机。\n" +
        "• 线程数 —— 同时运行多少个检测。一轮探测\"批量 × 线程\"个主机。\n" +
        "• 同一主机的重新扫描不超过每 N 分钟一次 —— 防洪：本轮会跳过最近检测过的主机。\n\n" +
        "更多线程和更大批量 = 代理池增长更快，但网络和电池负载更重。"
    override val baseScanPeriod = "多久运行一次，分钟"
    override val baseScanBatch = "每线程批量，主机数"; override val baseScanThreads = "线程数"
    override val adaptiveDesc = "如果可用代理少于\"少\"或多于\"多\"，则应用额外的倍率。"
    override val fewWord = "少"; override val manyWord = "多"
    override fun fasterX(x: String) = "快 $x×"
    override fun slowerX(x: String) = "慢 $x×"
    override fun ifAliveLt(n: Int) = "如果可用代理 < $n，则："
    override fun ifAliveGt(n: Int) = "如果可用代理 > $n，则："
    override val disabledWord = "关闭"
    override val speedByModeTitle = "按模式的速度"
    override val speedByModeHelp = "在基准速度之上，为每个网络模式设置的扫描速度倍率。" +
        "\"标准\"（×1）= 基准间隔。右 —— 更稀疏（更慢，更省流量/" +
        "电池），左 —— 更频繁（更快，更激进）。对数刻度，两个方向最多 ×100。\n\n" +
        "每个滑块下方是应用了自适应速度后得出的轮次参数 —— " +
        "分别针对\"可用数少\"（× \"加速\"）和\"可用数多\"（× \"减速\"）显示。\n\n" +
        "模式：\n• VPN —— 外部 VPN 启用。\n• LTE —— 移动网络。\n• Wi-Fi —— Wi-Fi 网络。\n" +
        "• Ethernet —— 有线连接。\n• 白名单 —— 手动\"白名单\"代理模式。"
    override val aliveLt = "可用 <"; override val aliveGt = "可用 >"
    override val periodWord = "周期"; override val nonstopWord = "不间断"
    override val batchWord = "批量"; override val threadsWord = "线程"; override val scanModeOff = "扫描关闭"
    override val netBattery = "网络与电池"
    override val netBatteryHelp = "• 仅 Wi-Fi —— 不在移动网络上扫描（省流量）。\n• 仅充电时 —— " +
        "只在手机充电时工作。\n• 低电量时跳过 —— 电池电量低时暂停扫描。"
    override val onlyWifi = "仅 Wi-Fi"; override val onlyCharging = "仅充电时"; override val skipLowBattery = "低电量时跳过"
    override val autosaved = "设置会自动保存。"
    override val dpiAutoLabel = "自动轮换 DPI 技巧"; override val dpiNoneLabel = "无 DPI 技巧（普通）"
    override val experimental = "实验性"
    override val experimentalHelp = "相对于 MTProto 上游的替代代理引擎，外加一个诊断日志。" +
        "设为\"关闭\"时，参考（可用）路径保持不变。只改变加密流\"如何\"写入" +
        "上游 TCP 套接字（分段大小、时序、TLS 记录边界）—— 流本身保持逐字节相同。" +
        "仅应用于实时代理中继（不包括探测，也不包括直连路径）。"
    override val expEngineTitle = "代理引擎（套接字混淆）"
    override val expConnectTitle = "连接引擎（上游选择）"
    override val raceWidthTitle = "并行连接"
    override val connectionSection = "连接与封锁绕过"
    override val connectionSectionHelp = "连接引擎、并行上游、代理引擎和 anti-DPI 技巧 —— 全部集中在一个区域。"
    override val netLogSection = "网络交换日志"
    override val expEngineWarn = "⚠ 实验模式。如果连通性变差，请切回\"关闭（参考路径）\"。"
    override val netLog = "启用网络交换日志"
    override val netLogSub = "把谁-对谁-何时以及数据包大小写入文件（\"不\"包含载荷数据）—— " +
        "用于对比有 VPN 与无 VPN 时的交换模式。"
    override val openLogFolder = "打开日志文件夹"; override val copyPath = "复制路径"
    override val helpShow = "帮助"; override val helpHide = "隐藏帮助"
    override val quickSwitchIntro = "在这里你可以挑选一个封锁绕过技巧。如果 Telegram 显示错误" +
        "\"你正在使用的代理配置不正确，将被禁用。请寻找另一个" +
        "\"，请尝试哪种流量混淆类型有效，使 Telegram 不再显示它。先从 " +
        "split* 模式开始。coalesce* 模式也有效，但在 Telegram 中图片/视频用它们加载得不好。"
    override val quickSwitchTitle ="封锁绕过"; override val quickSwitchSub = "整形、连接、anti-DPI"

    override val sourceUrl = "来源 URL"
    override fun sourceAlive(alive: Int, total: Int) = "可用 $alive/$total"
    override val open = "打开"; override val active = "活跃"; override val inactive = "非活跃"
    override val lastDownloaded = "已下载"; override val notDownloaded = "尚未下载"
    override fun sourceCounts(dead: Int, total: Int) =
        " 可用，$dead 失效，$total 共计"

    override val proxyBase = "代理数据库"
    override val totalInBase = "数据库共计"; override val aliveNow = "当前可用"; override val deadStat = "失效"
    override val aliveIn15 = "15 分钟内可用"; override val checksAllTime = "全部检测次数"
    override val antiDpiTricks = "Anti-DPI 技巧"; override val noStatsYet = "暂无数据 —— 随着检测/连接发生，技巧数据会累积"
    override val attempts = "尝试"; override val handshake = "握手"; override val score = "分数"
    override val tgConnect = "TG 连接"; override val socketsOver1m = "套接字 >1分钟"
    override val over10kb = "套接字 >10KB"; override val over100kb = ">100KB"; override val workTime = "工作时间"
    override val statsLegend = "握手 —— 成功的握手（占尝试的 %）· 分数 —— 数值 · " +
        "\"工作时间\" —— 在 ≥5KB 且超过 1 分钟的套接字上的总和。"
    override val resetStats = "重置技巧统计"

    override fun aliveLinks(n: Int) = "可用链接：$n"
    override val copyAll = "全部复制"
    override val openRandom = "随机打开"; override val copyRandom = "随机复制"; override val allShort = "全部"
    override val copyTop = "复制 TOP"; override val randomHost = "随机主机"
    override val exportToFile = "导出到文件"; override val exportSaved = "已保存到文件："
    override val dlNow = "立即下载"
    override fun downloadingFmt(sec: Long) = "下载中… ${sec}秒"
    override val cancel = "取消"
    override val deleteConfirmTitle = "删除订阅？"
    override val subscriptionsAddHint = "添加订阅或代理链接 →"
    override val addSourcesTitle = "添加"
    override val addSubsLabel = "订阅（每行一个 URL）"
    override val addSubsHelp = "每一行有效的 URL 都会成为一个独立订阅，并被定期获取。"
    override val addProxiesLabel = "现成代理链接（固定列表）"
    override val addProxiesHelp = "粘贴一批指向具体代理的链接（tg://proxy、https://t.me/proxy、…）。这\"不是\"订阅 —— 该列表从不下载，这些代理只是被添加到目录中。"
    override val addButton = "添加"
    override fun addedFmt(subs: Int, proxies: Int) = "已添加：$subs 个订阅，$proxies 个代理"
    override val perSecond = "每秒"
    override val graphSpeed = "速度"
    override val graphVolume = "流量"
    override val graphLatency = "Ping"
    override val graphConnects = "连接数"
    override val scanNow = "立即扫描"; override val scanOnShort = "扫描开"
    override val scanRunning = "扫描运行中"; override val scanIdle = "扫描空闲"; override val scanOffState = "扫描已关闭"; override val scanBatchPerThread = "批量/线程"; override val scanPassHosts = "每轮主机数"; override val minRescanLabel = "同一主机的重新扫描不超过每 N 分钟一次"
    override val scanPlanTitle = "计划"; override val scanNowTitle = "现在"; override val currentScheduleTitle = "当前排程"
    override val scheduleWord = "排程"; override val unitPcsPerSec = "个/秒"
    override val scanNowThreadsLabel = "当前运行的线程"; override val scanNowPerThreadLabel = "每线程检测数（计划）"; override val scanNowElapsedLabel = "运行时间"
    override val scanOkGraph = "成功扫描"; override val scanFailGraph = "失败扫描"; override val scanTrafficGraph = "扫描流量"; override val scanAliveGraph = "可用代理总数"; override val scanPingGraph = "Ping"; override val threadsGraph = "线程"
    override val scanEvery = "每隔"; override val scanNextRun = "下次运行"
    override val scanThreads = "线程"; override val scanBatch = "批量"
    override val scanElapsed = "运行中"; override val scanIdleNow = "—"
    override val effForFew = "当数量少时"; override val effForMany = "当数量多时"
    override val effCheck = "检测"; override val effBatch = "批量"; override val effPar = "并行"
    override val effContinuous = "连续"; override val secShort = "秒"; override val minShort = "分钟"

    override val appTagline = "跨平台自动连接器：它会寻找、检测并运行 " +
        "Telegram 借以工作的 MTProto 代理。"
    override val version = "版本"; override val buildDate = "构建日期"; override val platform = "平台"
    override val downloadSources = "下载与来源"; override val openOnGithub = "在 GitHub 上打开"
    override val feedbackBugs = "反馈与错误报告"; override val writeTelegram = "在 Telegram 上联系"

    override val language = "语言"; override val langAuto = "自动（跟随系统）"; override val langRu = "Русский"; override val langEn = "English"
    override val langFa = "فارسی"; override val langZh = "简体中文"; override val langAr = "العربية"; override val langUr = "اردو"
    override val langTr = "Türkçe"; override val langId = "Bahasa Indonesia"; override val langHi = "हिन्दी"; override val langBn = "বাংলা"; override val langMy = "မြန်မာ"
    override val langWord = "语言"

    override val scanModeTitle = "网络模式"; override val scanModeAuto = "自动"; override val scanModeManualLabel = "手动"
    override val activeModeLabel = "活跃模式"; override val formingListLabel = "正在构建列表"; override val catalogModeTabs = "模式"
    override val resetModeRatings = "重置主机评分"; override val forgetModeHosts = "忘记模式主机"
    override val exportModeTitle = "按模式导出"; override val modePickerTitle = "模式"
    override val modeHelp = "每个网络模式都保留自己的代理评分以及自己的扫描 + 订阅下载强度。\"自动\"会根据当前活跃网络挑选模式。\"手动\"让你自行选择任意模式（包括自动从不选择的白名单）。"
    override val autoSelect = "自动选择"; override val manualSelect = "手动选择"
    override val connStatsTitle = "当前连接"; override val connOnPort = "端口上的连接"; override val outgoingConns = "传出连接"
    override val modeChoice = "模式选择"; override val autoChoice = "自动选择"; override val manualChoice = "手动固定"
    override val directOnVpn = "VPN 时直连 TG"; override val onWord = "开"; override val offWord = "关"
    override val directStateActive = "活跃"; override val directStateOff = "在设置中关闭"; override val directStateIdle = "在设置中开启，但未活跃"
    override val wpHintTitle = "什么是白名单？"
    override val wpHint = "白名单 —— WhitePages：一个手动网络配置。仅手动启用（自动选择从不会选中它）。" +
        "它保留自己的主机评分，独立于 VPN/Wi-Fi/LTE 下载订阅并扫描。"
}
