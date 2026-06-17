[ENGLISH](README.en.md) · [ARABIC](README.ar.md) · [BENGALI](README.bn.md) · [BURMESE](README.my.md) · [CHINESE](README.zh.md) · [FRENCH](README.fr.md) · [GERMAN](README.de.md) · [HINDI](README.hi.md) · [INDONESIAN](README.id.md) · [ITALIAN](README.it.md) · [JAPANESE](README.ja.md) · [KOREAN](README.ko.md) · [MARATHI](README.mr.md) · [PERSIAN](README.fa.md) · [POLISH](README.pl.md) · [PORTUGUESE](README.pt.md) · [PUNJABI](README.pa.md) · [RUSSIAN](README.md) · [SPANISH](README.es.md) · [TAMIL](README.ta.md) · [TELUGU](README.te.md) · [THAI](README.th.md) · [TURKISH](README.tr.md) · [UKRAINIAN](README.uk.md) · [URDU](README.ur.md) · [VIETNAMESE](README.vi.md)

**[ダウンロード（最新版）](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

# AutoConnector for Telegram

AutoConnector for Telegram は、インターネット上から MTProto プロキシを自動的に見つけ出し、生きているかどうかを検証して、ローカルリレーを立ち上げるアプリケーションです。このリレーを通すことで、Telegram がブロックされている場所でも安定して動作します。ユーザーが手動で使えるプロキシを探す必要はありません。AutoConnector for Telegram は、最も高速で生きているプロキシを常に選び出し、まさにあなたのコンピューター／スマートフォンからそれらをテストします。

言い換えれば、これは公開された無料の MTProto プロキシを掲載している Telegram チャンネルやあらゆるサブスクリプションをスキャンし、あなたの Telegram に自動で設定するスキャナーです。Telegram クライアントを更新する必要はありません。プロキシの可用性は、まさにあなたのデバイスとネットワーク環境から検証されます。VPN なしで WiFi+LTE で動作します。

対応プラットフォーム: Android、Windows、Linux、MacBook。

Android 版は単体で動作しますが、Windows ではプロキシ化エンジン「スプリット…」または「コアレッシング…」を有効にする必要があります。設定の中、または「Telegram 接続済み」という文字と大きなグレー／グリーンの円の右側にあるボタンから設定できます。あるいは、ブロックの方式は場所ごとに異なるため、あなたの環境で最もよく動作するものを選んでください。「コアレッシング…」モードは最終手段です。これにより Telegram は動作し始めますが、チャット内でのメディアコンテンツの送信／表示が損なわれます。

COMODO のようなファイアウォールを使っている場合は、無効にすることをおすすめします。アプリをサンドボックスに閉じ込め、そのファイアウォールが MTProto プロキシへの送信接続を壊してしまうためです。あるいはアプリを仮想マシンで起動してください。そこでは TCP スタックが完全に変わり、AutoConnector の挙動も変わります。

さらに、より早く動作するプロキシと Telegram 内の「接続済み」表示にたどり着くために、Telegram がポート 55001 と 55002 を切り替えるのを手動で手伝ってください（プロキシ設定にて）。

# ✨ 機能

- **プロキシの自動検索** — 数十の公開ページとサブスクリプションをスキャンします。
- **生存確認** — 実際の MTProto ハンドシェイクを行い、速度／安定性でランク付けします。
- **ローカルリレー** — Telegram は `127.0.0.1` に接続し、AutoConnector for
  Telegram が最良の生きたプロキシ経由でトラフィックをルーティングし、
  現在のものがダウンした場合は切り替えます。
- **アンチ DPI** — マスキングのトリック集（ブラウザ偽装、パケット分割、
  FakeTLS など）。「自動総当たり」モードが動作するものを自動で選びます。
- **詳細な統計** — 生存／死亡プロキシ、速度、レイテンシ、トラフィック、
  各アンチ DPI トリックの効果。
- **プロキシカタログ** — ランキング上位とホストごとの詳細カード:
  ホストごとに「Telegram 接続数／成功数／全チェック数」と
  直近 25 回の試行履歴（TCP/TLS／接続の総所要時間、受信／送信バイト数）が確認できます。
- **柔軟なホスト選択** — 「広さ」のスライダー: 「実績のあるベストなものに絞る」から
  「できるだけ広くさまざまな生きたものを試す」まで。Telegram がリレーの
  ポート間を行き来しているときは、選択範囲が自動的に広がります。別のスライダーで
  接続タイムアウト（100 ミリ秒 … 15 秒）と「アップストリームレース」（複数の接続を並列）を設定できます。
- **12 言語**のインターフェース、自動判定、RTL 対応。

> ### 1.0.19 からの新機能
> - **ネットワークタイプ別のホスト用の独立したデータベースとランキング** — VPN / Wi-Fi / LTE /
>   Ethernet / White: 各接続種別が独自の生きたプロキシのプールを保持し、
>   VPN 下でしか動作しないものを Telegram に渡さないようにします。
> - **アップストリームレース** — 複数の接続を並列に行い、最も速い生きたものが勝ちます。
>   「選択の広さ」のスライダー（実績のあるベストなものから最大限に広いものまで）と、
>   Telegram がリレーのポート間を行き来しているときの自動プール拡張、
>   設定可能な接続タイムアウト（100 ミリ秒…15 秒）。
> - **詳細カード付きのホストカタログ** — 「Telegram 接続数／成功数／
>   全チェック数」とホストごとの直近 25 回の試行履歴（TCP/TLS 時間、
>   接続の所要時間、受信／送信バイト数）。
> - **ライブグラフ** — 速度、ping、ポートのアクティビティ（秒・分単位）、
>   およびスキャンのグラフ。
> - **アンチ DPI とプロキシ化エンジン** — 「自動総当たり」付きのマスキングトリック集、
>   難読化エンジン、および特定のブロックに対応する実験的エンジン（スプリット／
>   コアレッシング）。
> - 設定、ホスト、サブスクリプションの**エクスポート／インポート** + 工場出荷状態への完全リセット。
> - **高速なコールドスタート** — 複数のアノニマイザーを介したアグレッシブな
>   マルチスレッドのサブスクリプション読み込み。
> - **26 言語**のインターフェース、自動判定（+RTL）。

# 初回起動時に重要なこと:

- Telegram の設定を行い、固定の SOCKS5 プロキシ localhost:55001 と localhost:55002 を指定してください。
- これら以外のプロキシは削除してください。
- Telegram で「プロキシを使用する」を有効にしてください。
- Android では通知をブロックしないでください。さもないとバックグラウンドで動作しません。
- 初回起動時は、MTProto プロキシのダウンロードと総当たりが終わり、Telegram クライアント自体が切り替わるまで約 15 分待ってください。

# 何も動作しない場合

1. もし「何も」動作しないなら、本プログラムを生きたプロキシの自動カタログとして使ってください。ホットキー CTRL+WIN+ALT+P と CTRL+SHIFT+ALT+P で、AutoConnector のウィンドウを開かずに、ランダムなプロキシを素早くあなたの Telegram に直接追加できます。その場合、Telegram は AutoConnector を介さずプロキシへ直接つながりますが、無料プロキシが投稿されるチャットを監視してその検証に時間を費やす必要がなくなります。AutoConnector はトレイに常駐させ、「コネクター」のトグルをオフにし、「スキャン」のトグルだけをオンにしておきましょう。

2. AutoConnector を別のデバイスで試してください: 自分のスマホ、友人のスマホ、コンピューター。Windows/Android といったプラットフォームごとに、ブロック回避の仕組みはまったく異なります。おそらく Android では何の設定もなしに動作します。

3. それでも何も動作しないなら、一時的に 1 日だけ VPN を有効にして、その日のうちに AutoConnector + Telegram をテストしてください（Telegram は AutoConnector 経由で接続し、ポート 55001 と 55002 のプロキシを指定）。プログラム内で「VPN 有効時 → MTProto へプロキシする」のチェックボックスをオンにしてください。AutoConnector は動作し始めましたか? もしそうなら、結論は明らかです。AutoConnector はプロキシの検索に成功し、Telegram のトラフィックをそこへ転送することに成功していますが、VPN を切ると、あなたの国のブロックシステムがすべての送信接続をあまりに厳しく遮断しているのです。その場合、AutoConnector で 30 分ほどかけて手段を総当たりし、ブロックを回避できる動作するものを見つける必要があります。プログラムはまだすべての選択肢を完全に自動で総当たりすることはできません（アンチ DPI トリックの自動総当たりがあるだけです）。実験のあとは VPN を切り、「VPN 有効時に MTProto へプロキシする」のチェックボックスは「直接プロキシする」の状態に戻してください。

4. （3）の代替案。あなたの Windows/Linux ホスト上に仮想マシンを用意してください。その中で Telegram + AutoConnector を起動します。VPN なしでも完璧に動作し始めましたか? それなら、あなたの国のブロックシステムではなく、あなたのホストが接続を壊しているということです! 原因: ファイアウォール、アンチウイルス、VPN の残骸。アンチウイルスが AutoConnector をサンドボックスに入れたり、ファイアウォールが AutoConnector の珍しいアンチ DPI トリックをブロックしたりする場合は、ホスト上でアンチウイルスとファイアウォールを迂回（例外）して AutoConnector を有効にする必要があります。あるいは、コンピューターを再起動してそれらを一時的に完全に無効にしてください。そう、おかしな助言に聞こえるかもしれませんが、コンピューターを再起動してください。VPN プログラムはしばしば不具合を起こし、ホスト上に TUN デバイスを半死状態で残すことがあるからです。再起動後は VPN を起動せず、まず AutoConnector をテストしてください。

  5. ブロック回避を試してください。有効化ボタンは設定の中、またはメイン画面にあります（大きなグレー／グリーンの円の右側にあるボタンを探してください）。約 15 分の時間を割く必要があります。これらは 3 つのグループから成ります:
	  - プロキシ化エンジン。いずれかのコアレッシング* モードを試してください。おそらくすぐに動作し始めます。ただしその場合、Telegram で画像／動画が読み込まれなくなります（これはバグではなく仕様／妥協です）。次にスプリット* モードを試してください。動作すれば画像も読み込まれます。あるいは「無効」に戻してください。
	  - 「並列アップストリームレース」を試してください。これは、Telegram がプロキシへ 1 つの接続を行うとき、AutoConnector が異なる MTProto プロキシへ 5〜30 の接続を行い、Telegram に最良のものを差し出すという意味です。アプリの設定で、タイムアウト（3〜5 秒）と並列アップストリーム数を最大 30 まで選べます。
	  - 「アンチ DPI トリックの自動総当たり」を有効にしてください。プログラムが自動でそれらを総当たりします。
	  - Telegram がより早く切り替わるように、（Telegram の）プロキシ設定で 5〜10 秒ごとに手動で次のポートへ循環的に切り替えてください 55001->55002->55001->...

6. 最も強力／高速な設定の組み合わせ:
	- 接続タイムアウト 5 秒
	- ホスト選択の広さ 100%
	- 並列接続数 30
	- DPI トリックの自動総当たり
	- 並列アップストリームレース
	- プロキシ化エンジン: コアレッシング*
	- Telegram 内のプロキシ画面で 10 秒ごとに新しいポートを循環的にタップ。

7. Windows と Android では設定方針が異なります! 上に書いたことは主に Windows に関するものです。Android ではほとんどの人が何の設定もなしに（どんな設定でも）動作します。Windows では TCP スタックが異なり、Telegram アプリも異なります。これは Android より品質がずっと劣ります。公式クライアントだけでなく、別の Telegram クライアントを試してみてください。

8. どうか詳細なバグレポートを、どんな言語でも構いませんので https://t.me/AutoConnector_for_Telegram に書いてください。プラットフォーム、どんな手段を試したか（設定）、ファイアウォール／アンチウイルスを使っているか、VPN／仮想マシンから試したか。うまくいったレシピなど、ポジティブな情報もぜひ書いてください。何を試してどう動作したか。


## 📥 ダウンロード

すべてのビルドはリリースページにあります: **[GitHub Releases (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

| OS | ファイル | 起動方法 |
|----|------|--------|
| **Android** | `AutoConnector_for_Telegram.apk` | APK をインストール（Google Play 外 — 提供元からのインストールを許可してください） |
| **Windows** 10/11 x64 | `AutoConnector-for-Telegram-windows-x64.zip` | 展開 → `AutoConnector\AutoConnector.exe` を起動 |
| **Linux** x64 | `AutoConnector-for-Telegram-linux-x64.tar.gz` | 展開 → `./AutoConnector/bin/AutoConnector` |
| **macOS** 11+ (Apple Silicon) | `AutoConnector-for-Telegram-macos.tar.gz` | 展開 → `AutoConnector.app` をダブルクリック（ブロックされる場合は `xattr -dr com.apple.quarantine AutoConnector.app`） |

### 🔐 真正性の検証（release 1.1.0）

APK は release 証明書で署名されています（apksigner、スキーム v1+v2+v3）。インストール前に照合できます:

- **署名証明書（SHA-256）:** `cb23a18c0cf8a23e43b5b63d199fc1440d3e4d6533e1309d3f92f273fe626a5a`
  (CN=AutoConnector for Telegram) — この指紋は今後のすべてのリリースで同一です。
- **APK SHA-256:** `d7652e7f5c3a2174a3b7805c2539df7da080765c9b0f581a7ac5943987c9b935`
- **Windows zip SHA-256:** `1d8d675936387e89038dc4943d7f99200c1b735b86e1f79bd953cd93e60f0217`
- **Linux tar.gz SHA-256:** `9160ea519309dc62750a4a930dc1aae6e20dbcefd21b426fa85b48ace6f3e8f8`
- **macOS tar.gz SHA-256:** `322082ef3f06955ed299be790bce453e47db37fca17daea54724d60698446bc7`

検証: `apksigner verify --print-certs AutoConnector_for_Telegram.apk`（証明書）と
`sha256sum -c SHA256SUMS.txt`（ファイルの完全性。`SHA256SUMS.txt` はリリースに添付されています）。

## 📸 スクリーンショット

<table>
<tr>
<td align="center"><img src="docs/screenshots/connector.png" width="200"><br><sub>コネクター — アクティブなセッション</sub></td>
<td align="center"><img src="docs/screenshots/scan.png" width="200"><br><sub>スキャンとグラフ</sub></td>
<td align="center"><img src="docs/screenshots/catalog.png" width="200"><br><sub>プロキシカタログ（モード別）</sub></td>
<td align="center"><img src="docs/screenshots/host-card.png" width="200"><br><sub>ホストカード + 履歴</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/logs.png" width="200"><br><sub>リレーのログ</sub></td>
<td align="center"><img src="docs/screenshots/settings.png" width="200"><br><sub>設定</sub></td>
<td align="center"><img src="docs/screenshots/export.png" width="200"><br><sub>tg:// リンクのエクスポート</sub></td>
<td align="center"><img src="docs/screenshots/hotkeys.png" width="200"><br><sub>ホットキー</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/guide.png" width="200"><br><sub>接続ガイド</sub></td>
<td align="center"><img src="docs/screenshots/connector-ru.png" width="200"><br><sub>コネクター · ロシア語 UI</sub></td>
<td align="center"><img src="docs/screenshots/scan-ru.png" width="200"><br><sub>スキャン · ロシア語 UI</sub></td>
<td align="center"><sub>26 言語のインターフェース<br>自動判定付き</sub></td>
</tr>
</table>


## フィードバック

バグや意見はこちらへ - https://t.me/AutoConnector_for_Telegram

## 🔐 署名の検証

リリースの APK は release キーで署名されています。次のように検証できます:

```bash
# チェックサム（リリースの SHA256SUMS.txt と比較してください）
sha256sum AutoConnector_for_Telegram.apk

# デジタル署名と証明書の指紋
apksigner verify --print-certs AutoConnector_for_Telegram.apk
```

公式ビルドの署名に使われている証明書の指紋（SHA-256）は、各リリースの説明に
公開されています。APK がすり替えられていないことを確認するために、それと
照合してください。

## 📄 ライセンス

[MIT](LICENSE)。
