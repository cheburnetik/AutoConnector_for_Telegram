[ENGLISH](README.en.md) · [ARABIC](README.ar.md) · [BENGALI](README.bn.md) · [BURMESE](README.my.md) · [CHINESE](README.zh.md) · [FRENCH](README.fr.md) · [GERMAN](README.de.md) · [HINDI](README.hi.md) · [INDONESIAN](README.id.md) · [ITALIAN](README.it.md) · [JAPANESE](README.ja.md) · [KOREAN](README.ko.md) · [MARATHI](README.mr.md) · [PERSIAN](README.fa.md) · [POLISH](README.pl.md) · [PORTUGUESE](README.pt.md) · [PUNJABI](README.pa.md) · [RUSSIAN](README.md) · [SPANISH](README.es.md) · [TAMIL](README.ta.md) · [TELUGU](README.te.md) · [THAI](README.th.md) · [TURKISH](README.tr.md) · [UKRAINIAN](README.uk.md) · [URDU](README.ur.md) · [VIETNAMESE](README.vi.md)

**[下载（最新版）](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

# AutoConnector for Telegram

AutoConnector for Telegram —— 应用会自动在互联网上查找 MTProto 代理，检测它们是否存活，并启动一个本地中继，让 Telegram 即使在被封锁的地方也能稳定工作。用户无需手动寻找可用代理 —— AutoConnector for Telegram 会持续挑选最快、最活跃的代理，并专门从您的电脑/手机上对它们进行测试。

换句话说：这是一个扫描器，扫描各种发布公开免费 MTProto 代理的 TG 频道和各类订阅，并自动将其填入您的 Telegram。无需更新 Telegram 客户端。代理的可用性正是从您的设备和网络环境进行检测的。在 Wi-Fi+LTE 下无需 VPN 即可工作。

平台：Android、Windows、Linux、MacBook。

Android 版本可独立工作，而在 Windows 上需要启用代理引擎 "SPLIT（拆分）..." 或 "COALESCING（合并）.."——在设置中，或者在 "Telegram 已连接" 字样与那个灰色/绿色大圆圈右侧的按钮处。或者挑选一个对您本人效果更好的引擎，因为各地的封锁方式各不相同。"COALESCING（合并）.." 模式属于万不得已的选择——这样 Telegram 会开始工作，但聊天中媒体内容的发送/显示会变差。

如果您使用 COMODO 之类的防火墙，建议将其关闭：它会把应用关进沙箱，其防火墙会破坏到 MTProto 代理的出站连接。或者在虚拟机里运行应用，那里 TCP 栈会完全改变，AutoConnector 的行为也会不同。

另外，请手动帮助 Telegram 在端口 55001 和 55002 之间切换（在代理设置中），以便更快地连上可用代理，并在 Telegram 内出现 "已连接" 字样。

# ✨ 功能

- **自动查找代理** —— 扫描数十个开放页面和订阅。
- **存活检测** —— 真实的 MTProto 握手，按速度/稳定性评分。
- **本地中继** —— Telegram 连接到 `127.0.0.1`，而 AutoConnector for
  Telegram 通过最佳的活跃代理路由流量，并在当前代理掉线时自动切换。
- **反 DPI** —— 一整套伪装技巧（模仿浏览器、分片
  数据包、FakeTLS 等）；"自动遍历" 模式会自动挑选可用的方案。
- **详细统计** —— 活跃/失效代理、速度、延迟、流量，
  以及每种反 DPI 技巧的效率。
- **代理目录** —— 按评分排名的榜单，每个主机都有详细卡片：
  每个主机可看到 "Telegram 连接数 / 成功次数 / 总检测次数"，以及
  最近 25 次尝试的历史记录（TCP/TLS/连接总时长、收发字节数）。
- **灵活的主机选择** —— "广度" 滑块：从 "坚守经过验证的最佳主机"
  到 "尽可能广泛地尝试各种活跃主机"；当 Telegram 在中继
  端口之间来回乱跳时，选择范围会自动扩大。另有一个独立滑块——连接
  超时（100 毫秒 … 15 秒）和 "上游竞速"（多个连接并行）。
- **12 种**界面语言，支持自动检测和 RTL。

> ### 相较于 1.0.19 的更新内容
> - **按网络类型分离的主机数据库与评分** —— VPN / Wi-Fi / LTE /
>   Ethernet / White：每种连接方式各自维护一套活跃代理池，以免
>   把只在 VPN 下可用的代理塞给 Telegram。
> - **上游竞速** —— 多个连接并行，最快的活跃连接获胜；"选择广度"
>   滑块（从经过验证的最佳到尽可能广泛），当 Telegram 在中继端口
>   之间乱跳时自动扩大池；可调的连接超时（100 毫秒…15 秒）。
> - **带详细卡片的主机目录** —— "Telegram 连接数 / 成功次数 /
>   总检测次数"，以及每个主机最近 25 次尝试的历史（TCP/TLS 时间、
>   连接时长、收发字节数）。
> - **实时图表**：速度、ping 和端口活动（按秒和按分钟），
>   以及扫描图表。
> - **反 DPI 与代理引擎** —— 一套带 "自动遍历" 的伪装技巧、
>   混淆引擎，以及针对具体封锁的实验性引擎（拆分/
>   合并）。
> - **导出/导入**设置、主机和订阅 + 完全恢复出厂状态。
> - **快速冷启动** —— 通过多个匿名器进行激进的多线程订阅加载。
> - **26 种**界面语言，支持自动检测（+RTL）。

# 首次启动时务必：

- 完成 Telegram 设置，指定固定的 SOCKS5 代理 localhost:55001 和 localhost:55002。
- 删除除这两个之外的其他代理。
- 在 Telegram 中开启 "使用代理"。
- 不要屏蔽 Android 上的通知，否则将无法在后台工作。
- 首次启动时请等待约 15 分钟，等它下载并遍历 MTProto 代理，并等 Telegram 客户端本身完成切换。

# 如果什么都不工作

1. 如果什么都不工作，那就把程序当作活跃代理的自动目录来用。通过快捷键 CTRL+WIN+ALT+P 和 CTRL+SHIFT+ALT+P，您可以无需打开 AutoConnector 窗口就快速把一个随机代理直接添加到您的 Telegram。这样一来，Telegram 会直接连到代理，不经过 AutoConnector，但您就无需去监控那些发布免费代理的聊天并花时间检测它们了。让 AutoConnector 待在托盘里，关闭 "Connector（连接器）" 开关，保留 "Scan（扫描）" 开关。

2. 在另一台设备上试试 AutoConnector：手机、朋友的手机、电脑。在 Windows/Android 等不同平台上，绕过封锁的原理完全不同。在 Android 上很可能无需任何设置即可工作。

3. 如果什么都不工作，那就临时开启一天 VPN，并在这一天里测试 AutoConnector + Telegram（让 Telegram 通过 AutoConnector 连接，把代理指向端口 55001 和 55002）。在程序内勾选 "开启 VPN 时 -> 代理到 MTProto"。看看 AutoConnector 是否开始工作了？如果是，那结论就很明显——AutoConnector 成功找到了代理，成功把 Telegram 的流量转发了过去，但一旦关闭 VPN，您所在国家的封锁系统就会过于严厉地封掉所有出站连接。这种情况下，您将不得不花上半小时在 AutoConnector 中逐一尝试各种手段，以挑出一个能绕过封锁的可用方案。程序目前还不能完全自动遍历所有方案（仅有反 DPI 技巧的自动遍历）。实验结束后请关闭 VPN，并把 "开启 VPN 时代理到 MTProto" 这个勾选项恢复到 "直接代理" 状态。

4. 第 (3) 点的替代方案。在您的 Windows/Linux 主机上装一个虚拟机。在其中运行 Telegram + AutoConnector。即使没有 VPN 也完美运行了？那说明是您的主机在破坏您的连接，而不是您所在国家的封锁系统！原因有：防火墙、杀毒软件、VPN 的残留。如果杀毒软件把 AutoConnector 关进沙箱，或者防火墙拦截了 AutoConnector 那些不寻常的反 DPI 技巧，那您就得在主机上把 AutoConnector 加入杀毒软件和防火墙的例外（白名单）。或者干脆暂时把它们全部关闭，并重启电脑。是的，尽管这建议听起来好笑，但请重启电脑，因为 VPN 程序经常出故障，可能会在主机上留下一个处于半死不活状态的 TUN 设备。重启后先别启动 VPN，先测试 AutoConnector。

  5. 尝试绕过封锁。开启按钮请在设置或主屏幕中寻找（找那个灰色/绿色大圆圈右侧的按钮）。您需要花约 15 分钟。它们分为 3 组：
	  - 代理引擎。试试任意一个 Coalescing（合并）* 模式。很可能立刻就能用。但此时 Telegram 里的图片/视频不会加载（这不是 bug，而是特性/折中）。接着试试 Split（拆分）* 模式，如果能用——图片就能加载。或者恢复到 "已关闭"。
	  - 试试 "上游并行竞速"。意思是当 Telegram 向代理发起 1 个连接时，AutoConnector 会向不同的 MTProto 代理发起 5-30 个连接，并把最佳的那个塞给 Telegram。在应用设置中可以选择超时（3-5 秒）和并行上游数量，最多 30 个。
	  - 开启 "反 DPI 技巧自动遍历"，程序会自行遍历它们。
	  - 为了让 Telegram 切换得更快，请在代理设置中（在 Telegram 里）每隔 5-10 秒手动循环切换到下一个端口 55001->55002->55001->...

6. 最强/最快的设置组合：
	- 连接超时 5 秒
	- 主机选择广度 100%
	- 并行连接 30 个
	- 反 DPI 技巧自动遍历
	- 上游并行竞速
	- 代理引擎：Coalescing（合并）*
	- 在 Telegram 的代理窗口里每隔 10 秒点一个新端口，循环切换。

7. Windows 和 Android 的设置策略不同！上面所写的内容主要针对 Windows。在 Android 上，大多数人无需任何设置（任意设置下）即可工作。在 Windows 上 TCP 栈不同，Telegram 应用也不同，其质量远不如 Android 版。试试其他的 Telegram 客户端，而不只是官方版。

8. 请用任何语言把详细的 bug 报告发到 https://t.me/AutoConnector_for_Telegram —— 包括平台、您尝试过哪些方法（设置）、是否有防火墙/杀毒软件、是否尝试过从 VPN/虚拟机里运行。也欢迎写下任何有效的配方，您尝试了什么、它是如何开始工作的。


## 📥 下载

所有版本都在发布页面：**[GitHub Releases (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

| 操作系统 | 文件 | 运行方式 |
|----|------|--------|
| **Android** | `AutoConnector_for_Telegram.apk` | 安装 APK（非 Google Play —— 请允许从该来源安装） |
| **Windows** 10/11 x64 | `AutoConnector-for-Telegram-windows-x64.zip` | 解压 → 运行 `AutoConnector\AutoConnector.exe` |
| **Linux** x64 | `AutoConnector-for-Telegram-linux-x64.tar.gz` | 解压 → `./AutoConnector/bin/AutoConnector` |
| **macOS** 11+（Apple Silicon） | `AutoConnector-for-Telegram-macos.tar.gz` | 解压 → 双击 `AutoConnector.app`（如被拦截 —— `xattr -dr com.apple.quarantine AutoConnector.app`） |

### 🔐 真实性验证（release 1.1.0）

APK 使用 release 证书签名（apksigner，方案 v1+v2+v3）。安装前可以核对：

- **签名证书（SHA-256）：** `cb23a18c0cf8a23e43b5b63d199fc1440d3e4d6533e1309d3f92f273fe626a5a`
  （CN=AutoConnector for Telegram）—— 该指纹对所有未来的版本都相同。
- **APK SHA-256：** `d7652e7f5c3a2174a3b7805c2539df7da080765c9b0f581a7ac5943987c9b935`
- **Windows zip SHA-256：** `1d8d675936387e89038dc4943d7f99200c1b735b86e1f79bd953cd93e60f0217`
- **Linux tar.gz SHA-256：** `9160ea519309dc62750a4a930dc1aae6e20dbcefd21b426fa85b48ace6f3e8f8`
- **macOS tar.gz SHA-256：** `322082ef3f06955ed299be790bce453e47db37fca17daea54724d60698446bc7`

验证：`apksigner verify --print-certs AutoConnector_for_Telegram.apk`（证书）以及
`sha256sum -c SHA256SUMS.txt`（文件完整性；`SHA256SUMS.txt` 随版本一并提供）。

## 📸 截图

<table>
<tr>
<td align="center"><img src="docs/screenshots/connector.png" width="200"><br><sub>连接器 —— 活动会话</sub></td>
<td align="center"><img src="docs/screenshots/scan.png" width="200"><br><sub>扫描与图表</sub></td>
<td align="center"><img src="docs/screenshots/catalog.png" width="200"><br><sub>代理目录（按模式）</sub></td>
<td align="center"><img src="docs/screenshots/host-card.png" width="200"><br><sub>主机卡片 + 历史</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/logs.png" width="200"><br><sub>中继日志</sub></td>
<td align="center"><img src="docs/screenshots/settings.png" width="200"><br><sub>设置</sub></td>
<td align="center"><img src="docs/screenshots/export.png" width="200"><br><sub>导出 tg:// 链接</sub></td>
<td align="center"><img src="docs/screenshots/hotkeys.png" width="200"><br><sub>快捷键</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/guide.png" width="200"><br><sub>连接指南</sub></td>
<td align="center"><img src="docs/screenshots/connector-ru.png" width="200"><br><sub>连接器 · 俄语界面</sub></td>
<td align="center"><img src="docs/screenshots/scan-ru.png" width="200"><br><sub>扫描 · 俄语界面</sub></td>
<td align="center"><sub>26 种界面语言<br>支持自动检测</sub></td>
</tr>
</table>


## 反馈

请把 bug 和意见发到这里 - https://t.me/AutoConnector_for_Telegram

## 🔐 签名验证

发布版中的 APK 使用 release 密钥签名。可以这样验证：

```bash
# 校验和（与版本中的 SHA256SUMS.txt 比对）
sha256sum AutoConnector_for_Telegram.apk

# 数字签名和证书指纹
apksigner verify --print-certs AutoConnector_for_Telegram.apk
```

用于签署官方版本的证书指纹（SHA-256）会
发布在每个版本的描述中 —— 请核对它，以确认 APK
未被篡改。

## 📄 许可证

[MIT](LICENSE)。
