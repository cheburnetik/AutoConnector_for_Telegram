package io.autoconnector.i18n

object Ja : Strings {
    override val tabConnector = "コネクター"; override val tabScan = "スキャン"
    override val tabCatalog = "カタログ"; override val tabLogs = "ログ"; override val tabMore = "その他"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "購読"; override val logTabScan = "スキャン"
    override val logGeneral = "全般"; override val logEmpty = "現在は空です"
    override val logSessions = "セッション"; override val logErrorsOnly = "エラーのみ"; override val logNoErrors = "失敗したセッションはありません"
    override fun logSession(id: String, port: String) = "#${id} · :${port}"
    override val back = "戻る"; override val copy = "コピー"; override val gotIt = "了解"
    override val later = "後で"; override val details = "詳細"; override val whatIsThis = "これは何？"
    override val delete = "削除"

    override val connector = "コネクター"; override val scan = "スキャン"
    override val notConfigured = "未設定です！修正 →"; override val howToSetup = "設定方法"
    override val notifOff = "通知がオフです！修正 →"; override val enable = "有効化"
    override fun fewProxies(n: Int) = "生きているプロキシ ${n} 件、検索中、約15分お待ちください…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "生きているプロキシ: ${alive}  (15分以内: ${within}) · 合計: ${total}"
    override val notifWhyTitle = "なぜ通知が必要？"
    override val notifWhyBody = "通知アイコンが常に表示されることは、Androidのフォアグラウンドサービスを意味します。" +
        "これがないとシステムがアプリをメモリから解放してしまい、プロキシの検索や" +
        "バックグラウンドでの接続の維持が止まってしまいます。だからこそ" +
        "AutoConnectorの動作には通知が必須なのです。"
    override val notifEnableTitle = "通知を有効にする"
    override val notifEnableBody = "通知アイコンがないと、Androidはアプリを非アクティブとみなし、" +
        "メモリから解放します。すると AutoConnector はプロキシの検索と" +
        "バックグラウンドでの接続維持を停止し、Telegram は接続を失います。\n\n「有効化」をタップして" +
        "AutoConnector の通知を許可してください。"
    override val notifPlea = "通知を有効にしてください！通知がないとアプリはバックグラウンドで動作できず、" +
        "Android がアプリを解放してプロキシ検索と接続が停止します。"

    override val statusConnected = "Telegram 接続中"; override val statusConnecting = "接続中…"
    override val statusOffline = "Telegram 未接続"; override val statusIdle = "Telegram 待機中"
    override val nobodyConnected = "コネクターに誰も接続していません。 "; override val howToSetupArrow = "設定方法 →"
    override val directModeViaVpn = "ダイレクトモード: VPN 有効 — プロキシなし"
    override val directModeOff = "ダイレクトモード: プロキシ オフ"
    override val directDpiSuffix = " · アンチDPI"
    override val connections = "接続"; override val sockets = "ソケット"; override val speed = "速度"
    override val traffic = "トラフィック"; override val latency = "レイテンシ"
    override fun pcs(n: Int) = "${n} 件"
    override fun netNow(label: String) = "ネットワーク: ${label}"
    override fun tgToConnector(n: Int) = "TG→ ${n}"
    override fun connectorToProxy(n: Int) = "プロキシ ${n}"
    override val trafficSec = "トラフィック · 60秒"; override val trafficMin = "トラフィック · 60分"
    override val latencySec = "レイテンシ · 60秒"; override val latencyMin = "レイテンシ · 60分"
    override val sec60 = "60秒"; override val min60 = "60分"
    override val unitSec = "秒"; override val unitMin = "分"; override val unitHour = "時間"; override val dash = "—"
    override val currentProxy = "現在のプロキシ"; override val noActiveProxy = "アクティブなプロキシがありません（Telegram 未接続）"
    override val host = "ホスト"; override val type = "タイプ"; override val secret = "シークレット"; override val antiDpi = "アンチDPI"; override val obfEngine = "難読化エンジン"
    override fun activeSockets(n: Int) = "アクティブな Telegram ソケット: ${n}"
    override val noConnections = "アクティブな接続なし"; override val colHost = "ホスト"; override val colTime = "時刻"
    override val modeWord = "モード"; override val directViaVpnLine = "Telegram へ直接リクエスト（VPN 有効）"
    override val connModeHelp = "モード（VPN、Wi-Fi、LTE、Ethernet、White）を使うと、スキャンの強度を別々に調整し、ホストの評価/統計を分けて保持できます。ネットワーク種別は自動検出されますが、モードは設定で手動指定もできます。"

    override val scanOff = "スキャンはオフです"; override val proxiesInBase = "データベース内のプロキシ"
    override val total = "合計"; override val alive = "生存"; override val dead = "停止"
    override val tgConnectedTitle = "Telegram 接続経路"; override val successful = "成功"
    override val socketsHeld = "ソケットの寿命"; override val over1m = ">1分"; override val over5m = ">5分"; override val over15m = ">15分"
    override val scanCountTitle = "プロキシチェック回数"; override val checked = "チェック済み"
    override val forAllTime = "全期間"; override val perMinute = "毎分"; override val perHour = "毎時"
    override val subsCountTitle = "購読ダウンロード回数"; override val downloaded = "ダウンロード済み"; override val failed = "失敗"; override val scanTraffic = "スキャントラフィック"; override val subTraffic = "購読トラフィック"; override val subTrafficGraph = "購読トラフィック"
    override val checksMtproto = "MTProto チェック (↑ 成功 · ↓ 失敗)"

    override fun catalogEmpty(mode: String) = "カタログ ${mode} は現在空です。ホストが見つからなかったか、このモードでアプリを一度も実行していないかのどちらかです。モードは設定で切り替えられます。モードは、異なる種類のインターネット接続ごとにホストを別々に収集するために存在します。"
    override val aliveShort = "✓ 生存"; override val deadShort = "✗ 停止"
    override val statusLabel = "状態"; override val rating = "評価"; override val port = "ポート"
    override val rttPing = "RTT (ping)"; override val checkedField = "チェック済み"; override val okOfTotal = "成功 / 総チェック数"
    override val tgConnectedField = "Telegram 接続"; override val tgSessions = "Telegram セッション"; override val trafficThroughProxy = "プロキシ経由トラフィック"
    override val sessionsTotal = "セッション合計"; override val relayNow = "現在中継中"; override val tlsDomain = "TLS ドメイン (SNI)"
    override val sourceSub = "ソース（購読）"; override val lastError = "直近のエラー"; override val yes = "はい"; override val no = "いいえ"
    override val copyAsLink = "リンクとしてコピー"; override val openInTelegram = "Telegram でホストを開く"; override val makeNextRelay = "次の中継先にする"
    override val actCopy = "コピー"; override val actOpen = "開く"; override val actRelay = "中継"
    override fun agoFmt(v: String) = "${v} 前"
    override val catalogTopFor = "プロキシ一覧/評価:"
    override val catalogModeHelpTitle = "モードと評価"
    override val catalogModeHelp = "アプリは生きているホストとその評価を、ネットワークモード（VPN、Wi-Fi、LTE、Ethernet、White）ごとに別々にカウントします。「White」はホワイトリスト用の独立した手動モードで、自動切り替えでは選択されません。そのため、同じホストがあるモードでは生存、別のモードでは停止ということがあります。"
    override fun catalogInactiveWarn(section: String, active: String) =
        "現在は非アクティブなセクション ${section} を表示しています — 今の統計はすべてここではなく ${active} に記録されます。"
    override val manageModeTitle = "モードの管理"
    override val manageResetRating = "評価をリセット"
    override fun manageResetHint(mode: String) = "${mode} に限り、生きているホストの評価と利用統計をリセットできます。まったく別の VPN や LTE に接続したときなどに便利で、古い統計が干渉しなくなります。あるいは、プロキシスキャンがゼロからどれだけ速く再チェックするかを観察するのにも使えます。"
    override val manageDeleteAll = "ホストを削除:"
    override fun manageDeleteHint(mode: String) = "${mode} から評価とホスト自体の両方を消去できます。「プロキシをスキャン」機能が再び収集します。これは購読のリセットではありません — タップした後、約15分待つと再スキャンされます。"
    override fun manageCopyFrom(mode: String) = "別のモードからこのモード（${mode}）へ、すべてのホストと評価をコピー:"
    override val live = "生存"; override val deadW = "停止"; override val unitMs = "ms"
    override val agoMin = "分"; override val agoHour = "時間"; override val agoDay = "日"

    override val connectTelegram = "Telegram を接続する"; override val readCarefully = "よく読んでください！"
    override val guideIntro = "このアプリは設定なしでは動作しません。下記の3つの選択肢のいずれか1つを選び、" +
        "手順を注意深く実行してください。"
    override val variant1 = "選択肢 #1 — ボタン"
    override val variant1Body = "「プロキシ {A}」をタップ — Telegram が開くので、プロキシの追加を確認します。" +
        "この画面に戻り「プロキシ {B}」をタップ — 2つ目の追加をもう一度確認します。\n\nTelegram 内の" +
        "他の古いプロキシはすべて無効にしてください。ポート {A} と {B} の2つのプロキシだけが残る必要があります。" +
        "それ以外の構成では AutoConnector は動作しません。"
    override val variant2 = "選択肢 #2 — リンク"
    override val variant2Body = "下のテキストを Telegram の「保存したメッセージ」（または任意のチャット）にコピーしてください — " +
        "つまり自分宛てに送信します。メッセージ内の最初のリンクをタップ — 1つ目のプロキシが追加されます。" +
        "2つ目のリンクをタップ — 2つ目が追加されます。その後、古いプロキシをすべて無効にしてください。"
    override val variant3 = "選択肢 #3 — 手動"
    override val variant3Body = "SOCKS5 プロキシを手動で追加します: サーバー localhost (127.0.0.1)、ポート {A}。" +
        "次に2つ目のプロキシ: localhost、ポート {B}。古いプロキシはすべて削除してください。"
    override val whatNext = "次は？"
    override val whatNextBody = "Telegram で「プロキシの自動切り替え」を有効にします — 5秒。アクティブでない、または" +
        "「利用不可」と表示されているプロキシを（Telegram 内で）手動でタップすることで、Telegram の接続を" +
        "後押しできます — そうすると Telegram が接続をより頑張ろうとします。\n\n{A} と {B} 以外の古い" +
        "プロキシがすべて削除されていることを確認してください。Telegram で" +
        "「プロキシを使用」をタップします。\n\nアプリが十分なプロキシを見つけてダウンロードするまで待ちます" +
        "（5〜15分）。その後 Telegram が自動的に AutoConnector に接続し、検証済みで生きていて高速な" +
        "最良のプロキシ経由で Telegram を中継し続けます。\n\n手順が難しそうに感じる場合 — " +
        "申し訳ありませんが、このアプリは使えません。すべてを自動で設定することは不可能であり、" +
        "生きているプロキシを見つけるには時間がかかります。\n\nアプリをずいぶん前にダウンロードして" +
        "生きているプロキシが見つからなかった場合 — アプリか購読リストのどちらかを更新してください。このアプリは" +
        "独自のプロキシを発明したり提供したりはせず、インターネット上の数十のグループやページを" +
        "横断して検索するだけです。"
    override fun proxyBtn(port: Int) = "プロキシ ${port}"

    override val setupPortsTitle = "Telegram でポートを設定する"
    override val setupPortsSub = "Telegram をコネクターに接続する方法（ポート 55001/55002）"
    override val settings = "設定"; override val settingsSub = "ポート、アンチDPI、スキャン、ネットワーク、バッテリー"
    override val subscriptions = "購読"; override val subscriptionsSub = "スキャンするプロキシソース"
    override val statistics = "統計"; override val statisticsSub = "プロキシデータベース + アンチDPI 技法"
    override val export = "エクスポート"; override val exportSub = "生きているプロキシの tg:// リンク"
    override val about = "情報"; override val aboutSub = "バージョン、ビルド、ダウンロード、フィードバック"
    override val hotkeys = "ホットキー"
    override val hotkeysSub = "グローバルキー: プロキシをコピー / 開く"
    override val hotkeysIntro = "グローバルホットキーは、アプリのウィンドウがフォーカスされていないときでも動作します。" +
        "プールから生きているプロキシのリンク（tg://）をランダムに選びます — アプリを開かずに" +
        "素早くプロキシを切り替えるのに便利です。"
    override val hotkeysNote = "macOS では、キーのキャプチャにアクセシビリティ権限が必要な場合があります" +
        "（システム設定 → プライバシーとセキュリティ → アクセシビリティ）。"
    override val hotkeyCopyTitle = "プロキシリンクをコピー"
    override val hotkeyCopyDesc = "生きている tg:// リンクをランダムにクリップボードにコピーします。"
    override val hotkeyEnable = "ホットキーを有効化"; override val hotkeyLetterLabel = "文字"; override val hotkeySet = "設定"; override val hotkeyReset = "リセット"
    override val hotkeyOpenTitle = "Telegram でプロキシを開く"
    override val hotkeyOpenDesc = "生きているリンクをランダムに開きます — Telegram がそれを取得しプロキシの接続を提案します。"

    override val relayPorts = "中継ポート"
    override val relayPortsHelp = "コネクターが待ち受けるローカルポートです。これらをそのまま" +
        "Telegram に SOCKS5 プロキシ（127.0.0.1 : ポート）として入力します。信頼性のために2つのポートを使用し、Telegram は" +
        "両方への接続を維持します。"
    override val portA = "ポート A"; override val portB = "ポート B"
    override val antiDpiTrick = "アンチDPI 技法"
    override val antiDpiHelp = "ISP/DPI が接続を認識してブロックしないように偽装する方法です。" +
        "\n•「自動ローテーション」は動作する技法を自動で選びます。\n•「DPI 技法なし」 — 通常の" +
        "接続です。\n• その他は特定の技法です（ブラウザ模倣、パケット分割など）。"
    override val onlyFakeTls = "FakeTLS のみ (ee)"
    override val applyDpiTo = "アンチDPI を適用する対象"
    override val applyDpiHelp = "選んだアンチDPI 技法を適用する対象:\n• Telegram 中継 — コネクター経由の" +
        "実際の Telegram 接続に。\n• プロキシ探査 — バックグラウンドのプロキシチェックに" +
        "（その場合チェックが実際の接続とまったく同じ挙動になり、技法の統計がより正確になります）。\n" +
        "• 直接接続時 — プロキシがオフ（または VPN 有効時にスキップ）で Telegram が" +
        "サーバーへ直接つながるとき: ここにはプロキシがないので、技法は最初の TCP パケット" +
        "（ハンドシェイク）を複数の小さなセグメントに分割し、DPI が1回の読み取りで照合できないようにすることに限られます。"
    override val toRelay = "Telegram 中継"; override val toProbes = "プロキシ探査"
    override val toDirect = "直接接続時"
    override val vpnSection = "VPN 有効時"
    override val vpnHelp = "デバイスで VPN が有効なときの動作:\n• MTProto プロキシ経由 — " +
        "Telegram は通常どおり見つかったプロキシを通ります（VPN の上に）。\n• 直接 — " +
        "コネクターはプロキシを使わず、Telegram を Telegram のサーバーへ直接接続します: " +
        "VPN が既にアクセスを提供しているので、追加のプロキシ層は不要です（より速く安定します）。" +
        "VPN がない場合はプロキシが通常どおり使われます。"
    override val linkFormat = "プロキシリンクの形式"
    override val linkFormatHelp = "プロキシをコピー・オープンする方法。tg:// は Telegram を直接開きます（Telegram Desktop のインストールが必要）。http (t.me) はブラウザ経由で開き、Telegram で開くことを提案します — tg:// が登録されていない場合に便利です。"
    override val linkTg = "tg://（Telegram を直接開く）"; override val linkTgSub = "tg://proxy?… — Telegram を開きます"
    override val linkHttp = "http（t.me、ブラウザ経由）"; override val linkHttpSub = "https://t.me/proxy?… — ブラウザを開きます"
    override val viaMtproto = "MTProto 経由プロキシ"; override val viaMtprotoSub = "VPN 有効時でもトラフィックはプロキシを通る"
    override val directly = "直接接続"; override val directlySub = "VPN 有効時 — プロキシを迂回し Telegram へ直接"
    override val notifications = "通知"
    override val scanCheck = "スキャンとチェック"
    override val scanCheckHelp = "• スキャン（分） — 購読からプロキシ一覧をダウンロードする頻度。\n" +
        "• チェック（分） — データベース内のプロキシの生存を再チェックする頻度。\n• バッチサイズ — " +
        "1回の実行でチェックするプロキシ数。\n• 並列 — 同時に実行するチェック数（多いほど" +
        "速いが、ネットワークとバッテリーの負荷が高くなる）。"
    override val scanMin = "スキャン（分）"; override val checkMin = "チェック（分）"; override val batchSize = "バッチサイズ"; override val parallel = "並列"
    override val speedByNet = "ネットワーク別スキャン強度"
    override val speedByNetHelp = "現在のネットワークに応じてプロキシをチェックする頻度です。" +
        "「標準」= 基準間隔。右にスライドするとより稀に（遅く、トラフィック/バッテリーに優しい）、" +
        "左にすると頻繁に（速く、より積極的に）。対数スケールで、各方向最大 ×100。\n" +
        "• VPN — 外部 VPN が有効なとき。\n• Wi-Fi — Wi-Fi ネットワーク上。\n• LTE — モバイルネットワーク上。"
    override val intensStandard = "標準"
    override val intensSlower = "遅く"
    override val intensFaster = "速く"
    override val maintenance = "データのリセット"
    override val maintenanceHelp = "•「カタログと統計をリセット」 — 評価、カウンター、トラフィック、" +
        "チェックログをゼロにしますが、ダウンロード済みのホストと購読は保持します（次回のスキャンで" +
        "すべて再評価されます）。\n•「ダウンロード済みホストを消去」 — プロキシプール全体を削除しますが" +
        "購読は保持するので、スキャンがプールを再充填します。どちらの場合も購読には一切手を付けません。"
    override val backupTitle = "エクスポート / インポート"
    override val backupHelp = "アプリのデータを JSON として保存または復元します。含める項目に" +
        "チェックを入れてください — 任意の組み合わせ:\n• 設定 — すべてのアプリパラメータ。\n• 購読 — ソース" +
        "一覧（URL + オン/オフ）。\n• 生存ホストカタログ — ネットワークモードごとの、評価と統計を含む" +
        "すべての生きているプロキシ。\n\n「エクスポート」は出来上がった JSON のページを開きます — コピーするかファイルに保存してください。" +
        "「インポート」 — JSON を貼り付ける（またはファイルを読み込む）と、その中に含まれチェックされたセクションのみ適用されます。" +
        "インポートは現在のデータに追加します（消去はしません）。"
    override val backupSettings = "設定"
    override val backupSubs = "購読"
    override val backupHosts = "生存ホストカタログ（モード別）"
    override val exportWord = "エクスポート"
    override val importWord = "インポート"
    override val backupExportTitle = "データをエクスポート"
    override val backupImportTitle = "データをインポート"
    override val backupSelectExport = "エクスポートする項目:"
    override val backupSelectImport = "インポートする項目:"
    override val backupCopyBtn = "コピー"
    override val backupSaveFile = "ファイルに保存"
    override val backupLoadFile = "ファイルから読み込み"
    override val backupDoImport = "インポート"
    override val backupPasteLabel = "バックアップ JSON をここに貼り付け"
    override val backupJsonLabel = "バックアップ JSON"
    override val backupAndroidFileNote = "ここではファイルを利用できません — コピー / 貼り付けを使ってください。"
    override val eraseAllHosts = "すべてのホストを消去"
    override val factoryReset = "すべてリセット（初回起動と同じ）"
    override val factoryResetConfirm = "アプリを工場出荷状態に完全リセットしますか？すべての設定と" +
        "ホストカタログ全体が消去され、購読は既定値に戻ります。初回起動とまったく同じです。"
    override val resetCatalog = "カタログと統計をリセット"
    override val resetCatalogConfirm = "すべての評価、カウンター、チェックログをゼロにしますか？" +
        "ダウンロード済みのホストと購読は保持され、次回のスキャンで再評価されます。"
    override val clearHosts = "ダウンロード済みホストを消去"
    override val clearHostsConfirm = "ダウンロード済みホスト（プロキシ）の一覧全体を削除しますか？" +
        "購読は保持され、スキャンがプールを再充填します。"
    override val doReset = "リセット"
    override val doCancel = "キャンセル"
    override val adaptiveSpeed = "適応速度"
    override val adaptiveHelp = "生存チェックは基準間隔（「スキャンとチェック」から、ネットワーク係数も" +
        "掛けられる）で実行されます。「適応速度」は、現在生きているプロキシの数に基づいて" +
        "自動的に高速化または低速化します。\n\n" +
        "• 生存が少ない（「少ない」しきい値を下回る）→ 間隔 ×「高速化」。1未満の倍率 = より" +
        "頻繁: 0.5 — 2倍頻繁、0.25 — 4倍。プールをより速く再充填します。\n" +
        "• 生存が多い（「多い」しきい値を上回る）→ 間隔 ×「低速化」。1より上 = より稀: 2 — " +
        "半分の頻度、4 — 4分の1。バッテリーとトラフィックを節約します。\n" +
        "• しきい値の間 — 基準速度（×1）。\n\n" +
        "例:\n" +
        "— プロキシをより速く集める:「高速化」0.25 および/または「少ない」しきい値 40。\n" +
        "— 十分にあるときバッテリーを節約:「低速化」8 および/または「多い」しきい値 30。\n" +
        "— 適応を無効化: 両方の倍率を 1 に設定。\n\n" +
        "既定値: 少ない 20、高速化 0.5、多い 50、低速化 4。"
    override val threshMany = "「多い」しきい値"; override val threshFew = "「少ない」しきい値"; override val mulFast = "高速化 ×"; override val mulLazy = "低速化 ×"
    override val subIntensityTitle = "購読の強度"
    override val subIntensityHint = "購読ダウンロードの間隔: プロキシ一覧を再ダウンロードするまでの分数（ネットワークモードごとに別々）。"
    override val baseScanTitle = "基準スキャン速度"
    override val baseScanHelp = "基準となる生存チェック速度です。「適応速度」と「モード別速度」の" +
        "倍率はこれを基準に計算されます。\n\n" +
        "• 実行頻度（分） — チェック実行の間隔。\n" +
        "• スレッドあたりバッチ（ホスト） — 各スレッドが1回のパスでチェックするホスト数。\n" +
        "• スレッド数 — 同時に実行するチェック数。1パスで「バッチ × スレッド数」のホストを探査します。\n" +
        "• N分に1回より頻繁に同じホストを再スキャンしない — フラッド防止: 最近チェックしたホストは" +
        "このパスでスキップされます。\n\n" +
        "スレッドが多くバッチが大きいほど = プールの成長が速いが、ネットワークとバッテリーへの負荷が重くなります。"
    override val baseScanPeriod = "実行頻度（分）"
    override val baseScanBatch = "スレッドあたりバッチ（ホスト）"; override val baseScanThreads = "スレッド数"
    override val adaptiveDesc = "生きているプロキシが「少ない」より少ない、または「多い」より多い場合、追加の倍率を適用します。"
    override val fewWord = "少ない"; override val manyWord = "多い"
    override fun fasterX(x: String) = "${x}× 速く"
    override fun slowerX(x: String) = "${x}× 遅く"
    override fun ifAliveLt(n: Int) = "生きているプロキシが ${n} 未満なら:"
    override fun ifAliveGt(n: Int) = "生きているプロキシが ${n} より多いなら:"
    override val disabledWord = "オフ"
    override val speedByModeTitle = "モード別速度"
    override val speedByModeHelp = "各ネットワークモードのスキャン速度倍率で、基準速度の" +
        "上に適用されます。「標準」（×1）= 基準間隔。右 — より稀（遅く、トラフィック/" +
        "バッテリーに優しい）、左 — より頻繁（速く、より積極的）。対数スケールで、各方向最大 ×100。\n\n" +
        "各スライダーの下には、適応速度を適用した結果のパスパラメータが表示されます — " +
        "「生存が少ない」（×「高速化」）と「生存が多い」（×「低速化」）で別々に表示。\n\n" +
        "モード:\n• VPN — 外部 VPN が有効。\n• LTE — モバイルネットワーク。\n• Wi-Fi — Wi-Fi ネットワーク。\n" +
        "• Ethernet — 有線接続。\n• White — 手動「white」プロキシモード。"
    override val aliveLt = "生存 <"; override val aliveGt = "生存 >"
    override val periodWord = "間隔"; override val nonstopWord = "連続"
    override val batchWord = "バッチ"; override val threadsWord = "スレッド"; override val scanModeOff = "スキャン オフ"
    override val netBattery = "ネットワークとバッテリー"
    override val netBatteryHelp = "• Wi-Fi のみ — モバイルネットワークではスキャンしない（データを節約）。\n• 充電中" +
        "のみ — 端末の充電中のみ動作。\n• バッテリー残量が少ないときスキップ — バッテリーが" +
        "少ないときスキャンを一時停止。"
    override val onlyWifi = "Wi-Fi のみ"; override val onlyCharging = "充電中のみ"; override val skipLowBattery = "バッテリー残量が少ないときスキップ"
    override val autosaved = "設定は自動的に保存されます。"
    override val dpiAutoLabel = "DPI 技法の自動ローテーション"; override val dpiNoneLabel = "DPI 技法なし（通常）"
    override val experimental = "実験的機能"
    override val experimentalHelp = "MTProto アップストリームに代わる別のプロキシエンジンと診断ログ。" +
        "「オフ」に設定すると、基準となる（動作する）経路は変更されません。暗号化されたストリームが" +
        "アップストリーム TCP ソケットへ書き込まれる方法（セグメントサイズ、タイミング、TLS レコード境界）だけが変わり — ストリーム自体はバイト単位で同一のままです。" +
        "実際のプロキシ中継のみに適用されます（探査や直接経路には適用されません）。"
    override val expEngineTitle = "プロキシエンジン（ソケット難読化）"
    override val expConnectTitle = "接続エンジン（アップストリーム選択）"
    override val expEngineWarn = "⚠ 実験モードです。接続が悪化した場合は「オフ（基準経路）」に戻してください。"
    override val netLog = "ネットワーク交換ログを有効化"
    override val netLogSub = "誰が・誰に・いつ、およびパケットサイズをファイルに記録します（ペイロードデータは記録しません）— " +
        "VPN ありとなしで交換パターンを比較するため。"
    override val openLogFolder = "ログフォルダを開く"; override val copyPath = "パスをコピー"
    override val helpShow = "ヘルプ"; override val helpHide = "ヘルプを隠す"
    override val quickSwitchIntro = "ここでブロック回避の技法を選べます。Telegram が" +
        "「使用中のプロキシは正しく設定されていないため無効になります。別のものを探してください」" +
        "というエラーを表示する場合、どのトラフィック難読化タイプが効くか試して、Telegram が" +
        "それを表示しなくなるようにしてください。まず split* モードから始めてください。coalesce* モードも動作しますが、それらでは Telegram で画像/動画の読み込みがうまくいきません。"
    override val quickSwitchTitle ="ブロック回避"; override val quickSwitchSub = "シェイピング、接続、アンチDPI"

    override val sourceUrl = "ソース URL"
    override fun sourceAlive(alive: Int, total: Int) = "生存 ${alive}/${total}"
    override val open = "開く"; override val active = "アクティブ"; override val inactive = "非アクティブ"
    override val lastDownloaded = "ダウンロード済み"; override val notDownloaded = "まだダウンロードされていません"
    override fun sourceCounts(dead: Int, total: Int) =
        " 生存、${dead} 停止、${total} 合計"

    override val proxyBase = "プロキシデータベース"
    override val totalInBase = "データベース内の合計"; override val aliveNow = "現在生存"; override val deadStat = "停止"
    override val aliveIn15 = "15分以内に生存"; override val checksAllTime = "全期間のチェック"
    override val antiDpiTricks = "アンチDPI 技法"; override val noStatsYet = "まだデータがありません — 技法はチェック/接続が発生するにつれて蓄積されます"
    override val attempts = "試行"; override val handshake = "ハンドシェイク"; override val score = "スコア"
    override val tgConnect = "TG 接続"; override val socketsOver1m = "ソケット >1分"
    override val over10kb = "ソケット >10KB"; override val over100kb = ">100KB"; override val workTime = "稼働時間"
    override val statsLegend = "ハンドシェイク — 成功したハンドシェイク（試行に対する%）· スコア — 値 · " +
        "「稼働時間」 — 5KB 以上かつ1分より長いソケットの合計。"
    override val resetStats = "技法の統計をリセット"

    override fun aliveLinks(n: Int) = "生存リンク: ${n}"
    override val copyAll = "すべてコピー"
    override val openRandom = "ランダムに開く"; override val copyRandom = "ランダムにコピー"; override val allShort = "すべて"
    override val copyTop = "トップをコピー"; override val randomHost = "ランダムホスト"
    override val exportToFile = "ファイルにエクスポート"; override val exportSaved = "ファイルに保存しました:"
    override val dlNow = "今すぐダウンロード"
    override fun downloadingFmt(sec: Long) = "ダウンロード中… ${sec}秒"
    override val cancel = "キャンセル"
    override val deleteConfirmTitle = "購読を削除しますか？"
    override val subscriptionsAddHint = "購読またはプロキシリンクを追加 →"
    override val addSourcesTitle = "追加"
    override val addSubsLabel = "購読（1行に1つの URL）"
    override val addSubsHelp = "有効な URL を含む各行が、それぞれ独立した購読となり、定期的に取得されます。"
    override val addProxiesLabel = "出来合いのプロキシリンク（固定リスト）"
    override val addProxiesHelp = "特定のプロキシへのリンクをまとめて貼り付けます（tg://proxy、https://t.me/proxy、…）。これは購読ではありません — リストはダウンロードされず、プロキシがカタログに追加されるだけです。"
    override val addButton = "追加"
    override fun addedFmt(subs: Int, proxies: Int) = "追加: 購読 ${subs} 件、プロキシ ${proxies} 件"
    override val perSecond = "毎秒"
    override val graphSpeed = "速度"
    override val graphVolume = "容量"
    override val graphLatency = "Ping"
    override val graphConnects = "接続数"
    override val scanNow = "今すぐスキャン"; override val scanOnShort = "スキャン オン"
    override val scanRunning = "スキャン実行中"; override val scanIdle = "スキャン待機中"; override val scanOffState = "スキャン オフ"; override val scanBatchPerThread = "バッチ/スレッド"; override val scanPassHosts = "パス内のホスト"; override val minRescanLabel = "N分に1回より頻繁に同じホストを再スキャンしない"
    override val scanPlanTitle = "計画"; override val scanNowTitle = "現在"; override val currentScheduleTitle = "現在のスケジュール"
    override val scheduleWord = "スケジュール"; override val unitPcsPerSec = "件/秒"
    override val scanNowThreadsLabel = "現在実行中のスレッド"; override val scanNowPerThreadLabel = "スレッドあたりのチェック（計画）"; override val scanNowElapsedLabel = "実行時間"
    override val scanOkGraph = "成功したスキャン"; override val scanFailGraph = "失敗したスキャン"; override val scanTrafficGraph = "スキャントラフィック"; override val scanAliveGraph = "生きているプロキシ合計"; override val scanPingGraph = "Ping"; override val threadsGraph = "スレッド"
    override val scanEvery = "間隔"; override val scanNextRun = "次回実行"
    override val scanThreads = "スレッド"; override val scanBatch = "バッチ"
    override val scanElapsed = "実行中"; override val scanIdleNow = "—"
    override val effForFew = "少ないとき"; override val effForMany = "多いとき"
    override val effCheck = "チェック"; override val effBatch = "バッチ"; override val effPar = "並列"
    override val effContinuous = "連続"; override val secShort = "秒"; override val minShort = "分"

    override val appTagline = "クロスプラットフォームの自動コネクター: Telegram が動作するための MTProto プロキシを" +
        "見つけ、チェックし、実行します。"
    override val version = "バージョン"; override val buildDate = "ビルド日"
    override val downloadSources = "ダウンロードとソース"; override val openOnGithub = "GitHub で開く"
    override val feedbackBugs = "フィードバックとバグ報告"; override val writeTelegram = "Telegram で連絡"

    override val language = "言語"; override val langAuto = "自動（システム）"; override val langRu = "Русский"; override val langEn = "English"
    override val langFa = "فارسی"; override val langZh = "简体中文"; override val langAr = "العربية"; override val langUr = "اردو"
    override val langTr = "Türkçe"; override val langId = "Bahasa Indonesia"; override val langHi = "हिन्दी"; override val langBn = "বাংলা"; override val langMy = "မြန်မာ"
    override val langWord = "言語"
    override val raceWidthTitle = "並列接続"
    override val connectionSection = "接続とブロック回避"
    override val connectionSectionHelp = "接続エンジン、並列アップストリーム、プロキシエンジン、アンチDPI 技法 — すべてが1つのセクションに。"
    override val netLogSection = "ネットワーク交換ログ"
    override val platform = "プラットフォーム"

    override val scanModeTitle = "ネットワークモード"; override val scanModeAuto = "自動"; override val scanModeManualLabel = "手動"
    override val activeModeLabel = "アクティブモード"; override val formingListLabel = "リスト構築中"; override val catalogModeTabs = "モード"
    override val resetModeRatings = "ホスト評価をリセット"; override val forgetModeHosts = "モードのホストを忘れる"
    override val exportModeTitle = "モード別エクスポート"; override val modePickerTitle = "モード"
    override val modeHelp = "各ネットワークモードは独自のプロキシ評価と、独自のスキャン + 購読ダウンロード強度を保持します。「自動」はアクティブなネットワークからモードを選びます。「手動」では任意のモードを自分で選べます（自動では選ばれない White を含む）。"
    override val autoSelect = "自動選択"; override val manualSelect = "手動選択"
    override val connStatsTitle = "現在の接続"; override val connOnPort = "ポート上の接続"; override val outgoingConns = "発信接続"
    override val modeChoice = "モード選択"; override val autoChoice = "自動選択"; override val manualChoice = "手動固定"
    override val directOnVpn = "VPN 上で TG へ直接接続"; override val onWord = "オン"; override val offWord = "オフ"
    override val directStateActive = "アクティブ"; override val directStateOff = "設定でオフ"; override val directStateIdle = "設定でオン、ただし非アクティブ"
    override val wpHintTitle = "White とは？"
    override val wpHint = "White — WhitePages: 手動のネットワークプロファイルです。手動でのみ有効になります（自動選択では決して選ばれません）。" +
        "独自のホスト評価を保持し、VPN/Wi-Fi/LTE とは独立して購読をダウンロードしスキャンします。"

    override val recentAttempts = "最近の接続とチェック"
    override val kindCheck = "チェック"
    override val kindTg = "Telegram"
    override val histWho = "誰"
    override val histWhen = "いつ"
    override val histReq = "リクエスト"
    override val histSess = "セッション"
    override val histScan = "スキャン"
    override val testNow = "今すぐテスト"
    override val testShort = "テスト"
    override val testResult = "テスト結果"
    override val testStop = "停止"
    override val testingNow = "テスト中…"
    override val prewarmTitle = "ソケットのプリウォーム（実験的機能）"
    override val prewarmHelp = "新しい Telegram 接続が接続/ハンドシェイクをスキップできるよう、プロキシへのソケットを" +
        "あらかじめいくつか開いたまま保持します。実験的: バックグラウンドで常に再接続するため、トラフィックと" +
        "少しの CPU を消費します。偽のトラフィックは送信されません（実際のセッションを壊してしまうため）— " +
        "ソケットは単にローテーションされるだけです。FakeTLS プロキシで最も役立ちます。"
    override val prewarmEnable = "プリウォームを有効化"
    override val prewarmModeDeferred = "遅延（TLS のみ）"
    override val prewarmModeDeferredSub = "TCP + FakeTLS を保持し、obfuscated2-init は引き渡し時に送ります。DC はコミットしません — 最も現実的です。"
    override val prewarmModeFull = "完全なハンドシェイク"
    override val prewarmModeFullSub = "異なる DC へ完全に接続したソケットを保持し、DC/tag が一致したときのみ再利用します。寿命は短めです。"
    override val prewarmPoolLabel = "予備ソケット数"
    override val prewarmHoldLabel = "保持時間、秒"
    override val prewarmNote = "ローテーションのみ（アプリレベルの keepalive なし）。ソケットの寿命は数秒〜約1分で、プロキシ/DC によって変わります。"
    override val prewarmStatus = "プリウォーム"
    override fun prewarmStatusVal(ready: Int, holdSecs: Int) = "${ready} 準備完了 · ${holdSecs}秒保持"
    override val prewarmStar = "太字のオレンジ = プリウォームプールから温かいソケットが引き渡された（接続/ハンドシェイクなし）"
    override fun prewarmTableTitle(holdSecs: Int) = "ソケットのプリウォーム（${holdSecs}秒保持）"
    override val prewarmTableHelp = "「ソケットのプリウォーム」は、新しい Telegram 接続が接続/ハンドシェイクをスキップできるよう、" +
        "プロキシへのソケットをあらかじめいくつか開きます。この表にはプリウォーム中のホストが表示されます: " +
        "各ソケットが何秒生きているか、Telegram が使用しているか、そしてトラフィック。有効/無効の切り替えと設定" +
        "（モード、ソケット数、保持時間）は「その他 → 設定 → 『ソケットのプリウォーム（実験的機能）』」で行えます。"
    override val prewarmNoneWarming = "プリウォーム中のソケットはまだありません"
    override val prewarmColAge = "経過"
    override val prewarmColUse = "TG で?"
    override val prewarmInUse = "TG で"
    override val prewarmNew = "新規"
    override val lanShareTitle = "ローカルネットワークで共有（ウェブポータル）"
    override val lanShareDesc = "この Wi-Fi 上の他のデバイスがこの AutoConnector をプロキシとして使えるようにします。" +
        "下のアドレスを開いたブラウザに、最良のプロキシのページが表示されます。"
    override val lanShareUrlsLabel = "同じネットワークの相手はここに接続:"
    override val lanShareNoIp = "ローカルネットワークのアドレスがありません — Wi-Fi に接続してください"
    override val lanFirewallTitle = "ローカルネットワークで許可"
    override val lanFirewallBody = "有効にすると、中継ポートがローカルネットワークに開かれます。このとき Windows" +
        "（または他の）ファイアウォールが AutoConnector を許可するか尋ねることがあります — 「許可」/「はい」を選んでください。" +
        "拒否すると、相手から AutoConnector へのトラフィックがブロックされ、ページ/プロキシに到達できなくなります。"
    override val lanFirewallConfirm = "有効化"
    override val lanInfoTitle = "これは何のため？"
    override val lanInfoBody = "AutoConnector を Wi-Fi 上の1台のコンピューターまたはスマートフォンで実行すれば、" +
        "同じネットワーク上の他のすべてのデバイス（このアプリが直接サポートしない iPhone を含む）が、" +
        "ブラウザでアドレスを開くだけで利用できます: 各自の Telegram に追加する最良のプロキシのページ、" +
        "またはこのデバイス自体を SOCKS プロキシとして。1台のデバイスがプロキシを見つけて保持し、" +
        "残りはローカルネットワーク経由でそれを利用します。"
    override val volTriggerTitle = "音量ボタントリガー"
    override val volTriggerSub = "音量キーの素早いパターンでプロキシを切り替え"
    override val volEnableLabel = "音量ボタンを監視"
    override val volHelpTitle = "これは何？"
    override val volHelpBody = "Android にはグローバルなキーボードホットキーがないため、代わりに音量ボタンを使います。" +
        "有効にすると、AutoConnector はバックグラウンドで音量アップ/ダウンの素早い押下パターン" +
        "（例: アップ-アップ-ダウン-ダウン）を監視します。それを認識すると、ランダムな良質で生きているプロキシの" +
        "tg:// リンクを開き — Telegram がそれを取得して切り替えます。アプリを開かずに素早く目立たず" +
        "プロキシをローテーションする方法です。音量は通常どおり動作します（押下は奪われません）。" +
        "Accessibility 権限が必要です（バックグラウンドで音量キーを読み、リンクを開くため）。" +
        "トグルを有効にするまで何も要求されません。下で押下間の最大時間を設定してください。" +
        "認識されるパターンは下部に一覧表示されます。"
    override val volGrantTitle = "Accessibility を有効にする（重要）"
    override val volGrantBody = "Android（特に 13+）は、Google Play 以外からインストールされたアプリの Accessibility を" +
        "ブロックします — そのため AutoConnector はグレーアウトし「アクセスが許可されていません」と表示されます。\n\n" +
        "ブロック解除の方法:\n1. 「アプリ情報」を開きます（下のボタン、または: 設定 → アプリ → AutoConnector for Telegram）。\n" +
        "2. ⋮（右上の3点メニュー）→「制限された設定を許可」→ 確認します。\n" +
        "3. 戻ります: 設定 → Accessibility → AutoConnector for Telegram → 有効にします。\n\n" +
        "「制限された設定を許可」が表示されない場合 — まず Accessibility でトグルを一度オンにしてみてください" +
        "（ブロックのメッセージが表示されます）。その後、手順2が利用できるようになります。\n\n" +
        "Xiaomi/MIUI、Samsung などではパスが少し異なる場合があります —「アプリ情報」内の同じ ⋮ を探してください。" +
        "Android 12 以前では通常制限がないので、すぐに有効にできます。\n\n" +
        "音量キーは読み取られるだけで、決してブロックされません。"
    override val volOpenAppInfo = "「アプリ情報」を開く"
    override val volAccessOn = "Accessibility: 有効"
    override val volAccessOff = "Accessibility: 無効"
    override val volOpenAccess = "Accessibility 設定を開く"
    override val volGapLabel = "押下間の最大 ms"
    override val volPatternsTitle = "認識されるパターン"
    override val volPatternPick = "パターン"
    override val volPatternsLegend = "↑ = 音量アップ、↓ = 音量ダウン"
    override val volNoRights = "アプリにはまだ音量ボタンを処理する権限がありません — ページ下部の手順に従ってアクセスを許可してください。"
    override val volGrantShort = "まだ Accessibility アクセスがありません。このページ下部の詳しい手順を読み、「確認」をタップしてください。"
    override val volCheck = "確認"
    override val volCheckOk = "✓ 完了 — アクセスが許可され、トリガーが動作します。"
    override val volCheckFail = "✗ まだアクセスがありません — 上記の手順を実行してください。"
    override val volPatternsList = "↑↑↓↓ · ↓↓↑↑ · ↑↓↑↓ · ↓↑↓↑ · ↑↑↑↑ · ↓↓↓↓ · ↑↓↓↑ · ↓↑↑↓ · ↑↑↑↓↓↓ · ↓↓↓↑↑↑   (↑ = 音量アップ、↓ = 音量ダウン)"
    override val histLegend = "列 — 誰: ✓/✗ TG = 実際の Telegram 接続、スキャン = バックグラウンドチェック。" +
        "いつ: 何分前か。TCP/TLS/リクエスト: ハンドシェイクと最初のリクエストの遅延、ms。" +
        "セッション: 中継セッションの継続時間。↓/↑: ホスト経由で受信/送信したバイト数。"
    override val tgOkTotalHint = "Telegram 接続 / 成功 / 総チェック数"
    override val breadthTitle = "ホスト選択の幅"
    override val breadthHelp = "左 — 最良の実証済みホストにこだわる。右 — 生きている様々なホストをできるだけ広く試す。" +
        "Telegram が中継ポートを行き来するとき、アプリは自動的に選択範囲を広げます。"
    override val breadthNarrow = "実証済み"
    override val breadthWide = "より広く"
    override val connTimeoutTitle = "ホストごとの接続タイムアウト"
    override val connTimeoutHelp = "次のプロキシを試す前に、1つのアップストリーム（TCP + TLS + 最初の MTProto 応答）をどれだけ待つか。"
    override val factoryResetDone = "すべてリセットされました。アプリを閉じて、もう一度開いてください。"

    // tray
    override val trayOpenWindow = "ウィンドウを開く"
    override val trayRefreshSubs = "購読を更新"
    override val trayExit = "終了"
    override fun trayConnectorLabel(on: Boolean) =
        if (on) "コネクター: オン（オフにする）" else "コネクター: オフ（オンにする）"
    override fun trayScanLabel(on: Boolean) =
        if (on) "スキャン: オン（オフにする）" else "スキャン: オフ（オンにする）"
    override fun trayLive(n: Int) = "生きているプロキシ: ${n}"
    override val appearance = "外観"
    override val themeLabel = "テーマ"
    override val themeAuto = "自動（システムに合わせる）"
    override val themeLight = "ライト"
    override val themeDark = "ダーク"
    override val drawGraphsLabel = "グラフを描画"
    override val drawGraphsSub = "コネクターとスキャンのタブにリアルタイムのグラフを表示 — バッテリー節約のためオフにします"
}
