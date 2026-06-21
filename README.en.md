[ENGLISH](README.en.md) · [AMHARIC](README.am.md) · [ARABIC](README.ar.md) · [AZERBAIJANI](README.az.md) · [BENGALI](README.bn.md) · [BURMESE](README.my.md) · [CHINESE](README.zh.md) · [DARI](README.prs.md) · [FRENCH](README.fr.md) · [GERMAN](README.de.md) · [HAUSA](README.ha.md) · [HINDI](README.hi.md) · [INDONESIAN](README.id.md) · [ITALIAN](README.it.md) · [JAPANESE](README.ja.md) · [KAZAKH](README.kk.md) · [KOREAN](README.ko.md) · [MARATHI](README.mr.md) · [PASHTO](README.ps.md) · [PERSIAN](README.fa.md) · [POLISH](README.pl.md) · [PORTUGUESE](README.pt.md) · [PUNJABI](README.pa.md) · [RUSSIAN](README.md) · [SPANISH](README.es.md) · [TAMIL](README.ta.md) · [TELUGU](README.te.md) · [THAI](README.th.md) · [TIGRINYA](README.ti.md) · [TURKISH](README.tr.md) · [UKRAINIAN](README.uk.md) · [URDU](README.ur.md) · [UZBEK](README.uz.md) · [VIETNAMESE](README.vi.md)

**[Download (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

# AutoConnector for Telegram

AutoConnector for Telegram — the app finds MTProto proxies on the internet by itself, checks that they are alive, and brings up a local relay through which Telegram keeps working reliably even where it is blocked. The user doesn't have to hunt for working proxies by hand — AutoConnector for Telegram continuously picks the fastest live ones and tests them specifically from your computer/phone.

In other words: it's a scanner of Telegram channels and all sorts of subscriptions with public free MTProto proxies, with auto-insertion into your Telegram. There's no need to update the Telegram client. Proxy reachability is checked from your own device and network environment. Works on Wi-Fi + LTE without a VPN.

Platforms: Android, Windows, Linux, MacBook.

The Android version works on its own, while on Windows you need to enable a proxying engine — "SPLIT..." or "COALESCING.." — in the settings, or via the button to the right of the words "Telegram connected" and the large gray/green circle. Or pick the one that works best for you personally, since blocking differs everywhere. The "COALESCING.." modes are a last resort — Telegram will start working, but sending/displaying media content in chats will break.

I recommend disabling a firewall like COMODO if you use one: it puts the app into a sandbox, and its firewall ruins outgoing connections to MTProto proxies. Or run the app in a virtual machine — there the TCP stack changes completely, and AutoConnector's behavior will be different.

Also, help Telegram switch between ports 55001 and 55002 by hand (in the proxy settings) to reach a working proxy faster and get the "Connected" label inside Telegram.

# ✨ Features

- **Auto proxy search** — scans dozens of open pages and subscriptions.
- **Liveness checks** — a real MTProto handshake, rated by speed/stability.
- **Local relay** — Telegram connects to `127.0.0.1`, and AutoConnector for
  Telegram routes traffic through the best live proxy and switches over
  if the current one goes down.
- **Anti-DPI** — a set of masking tricks (browser mimicry, packet
  splitting, FakeTLS, etc.); the "Auto-rotate" mode picks a working one by itself.
- **Detailed statistics** — live/dead proxies, speed, latency, traffic,
  the effectiveness of each anti-DPI trick.
- **Proxy catalog** — top by rating, with a detailed card per host:
  each host shows "Telegram connects / successful / total checks" and
  the last 25 attempts (TCP/TLS/total connect duration, bytes received/sent).
- **Flexible host selection** — a "breadth" slider: from "stick to the best proven
  hosts" to "try as widely as possible across the live ones"; when Telegram bounces
  between relay ports, the selection widens automatically. A separate slider — the
  connect timeout (100 ms … 15 s) — and an "upstream race" (several parallel connects).
- **12 UI languages** with auto-detection and RTL support.

> ### What's new since 1.0.19
> - **Separate host pools and ratings per network type** — VPN / Wi-Fi / LTE /
>   Ethernet / White: each connection type keeps its own pool of live proxies, so
>   Telegram is never handed something that only works under a VPN.
> - **Upstream race** — several connects in parallel, the fastest live one wins;
>   a "selection breadth" slider (from best-proven to as-wide-as-possible) with the
>   pool auto-widening when Telegram bounces between relay ports;
>   a configurable connect timeout (100 ms…15 s).
> - **Host catalog with a detailed card** — "Telegram connects / successful /
>   total checks" plus the last 25 attempts per host (TCP/TLS time,
>   connect duration, bytes received/sent).
> - **Live graphs** of speed, ping and port activity (per second and per minute)
>   plus scan graphs.
> - **Anti-DPI and proxying engines** — a set of masking tricks with an
>   "Auto-rotate" mode, an obfuscation engine, and experimental engines (split/
>   coalescing) to match a specific block.
> - **Export/import** of settings, hosts and subscriptions + a full factory reset.
> - **Fast cold start** — aggressive multi-threaded subscription download through
>   several anonymizers.
> - **26 UI languages** with auto-detection (+RTL).

# Important on first launch:

- Configure Telegram with a fixed SOCKS5 proxy localhost:55001 and localhost:55002.
- Delete the other proxies except these.
- Enable "Use proxy" in Telegram.
- Don't block notifications on Android, otherwise it won't run in the background.
- On first launch, wait ~15 minutes while it downloads and cycles through MTProto proxies and while the Telegram client itself switches over.

# If nothing works

1. If NOTHING works, use the program as an auto catalog of live proxies. With the hotkeys CTRL+WIN+ALT+P and CTRL+SHIFT+ALT+P you can quickly add a random proxy straight into your Telegram without even opening the AutoConnector window. The result is that Telegram goes directly to the proxy, without AutoConnector, but you won't have to monitor the chats where free proxies are posted and waste time checking them. Let AutoConnector live in the tray, turn off the "Connector" toggle, leave the "Scan" toggle on.

2. Try AutoConnector on another device: your phone, a friend's phone, a computer. The principle of bypassing blocks is completely different across the Windows/Android platforms. Most likely it will work on Android without any settings at all.

3. If nothing works, then temporarily enable a VPN for a day and test AutoConnector + Telegram during that day (connect Telegram through AutoConnector, specifying proxies on ports 55001 and 55002). Inside the program, tick the "When VPN is on -> proxy to MTProto" checkbox. See whether AutoConnector started working. If yes, then the conclusion is obvious — AutoConnector successfully finds proxies and successfully relays Telegram's traffic there, but if you turn the VPN off, the blocking system in your country blocks all outgoing connections too harshly. In that case you'll have to spend half an hour cycling through the tools in AutoConnector to pick a working one that can get past the blocks. The program can't yet automatically cycle through all the options (there's only the auto-rotation of anti-DPI tricks). After the experiment, turn off the VPN and return the "When VPN is on, proxy to MTProto" checkbox to the "Proxy directly" state.

4. An alternative to point (3). Install a virtual machine on your Windows/Linux host. Run Telegram + AutoConnector inside it. Did it start working perfectly even without a VPN? That means your host is ruining your connections, not the blocking system in your country! Causes: firewalls, antiviruses, leftovers from a VPN. If the antivirus puts AutoConnector into a sandbox, or the firewall blocks AutoConnector's unusual anti-DPI tricks, then you'll have to run AutoConnector on the host bypassing the antivirus and firewall (exceptions). Or turn them off entirely for a while and reboot the computer. Yes, funny as it is to advise, reboot the computer, because VPN programs often glitch and can leave a TUN device on the host in a half-alive state. After the reboot, don't start the VPN — test AutoConnector first.

  5. Try bypassing the blocks. Look for the enable button in the settings or on the main screen (look for the button to the right of the large gray/green circle). You'll have to spend ~15 minutes. They consist of 3 groups:
	  - Proxying engine. Try any Coalescing* mode. It will most likely work right away. But images/videos won't load in Telegram with it (this isn't a bug, but a feature/trade-off). Next, try the Split* modes; if it works — images load. Or set it back to "off".
	  - Try "Parallel upstream race". This means that when Telegram makes 1 connect to a proxy, AutoConnector makes 5-30 connects to different MTProto proxies and hands Telegram the best one. In the app settings you can choose timeouts (3-5 sec) and the number of parallel upstreams, up to 30.
	  - Enable "Auto-rotate anti-DPI tricks", and the program will cycle through them by itself.
	  - To make Telegram switch faster, in the proxy settings (in Telegram) manually switch to the next port in a loop every 5-10 seconds: 55001->55002->55001->...

6. The most powerful/fastest combination of settings:
	- connect timeout 5s
	- host selection breadth 100%
	- 30 parallel connects
	- auto-rotate DPI tricks
	- parallel upstream race
	- proxying engine: Coalescing*
	- inside Telegram, in the proxy window, tap a new port every 10 seconds, in a loop.

7. The configuration policy on Windows and Android is different! Everything written above mostly concerns Windows. On Android it works for most people without any settings (with any settings). Windows has a different TCP stack and a different Telegram app, which is much worse in quality than Android. Try some other Telegram client, not just the official one.

8. Please write detailed bug reports in any language at https://t.me/AutoConnector_for_Telegram — your platform, which methods you tried (settings), whether you have a firewall/antivirus, whether you tried from a VPN/virtual machine. Also write any positive recipes — what you tried and how it started working.


## 📥 Download

All builds are on the releases page: **[GitHub Releases (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

| OS | File | Run |
|----|------|--------|
| **Android** | `AutoConnector_for_Telegram.apk` | install the APK (outside Google Play — allow install from source) |
| **Windows** 10/11 x64 | `AutoConnector-for-Telegram-windows-x64.zip` | extract → run `AutoConnector\AutoConnector.exe` |
| **Linux** x64 | `AutoConnector-for-Telegram-linux-x64.tar.gz` | extract → `./AutoConnector/bin/AutoConnector` |
| **macOS** 11+ (Apple Silicon) | `AutoConnector-for-Telegram-macos.tar.gz` | extract → double-click `AutoConnector.app` (if blocked — `xattr -dr com.apple.quarantine AutoConnector.app`) |

### 🔐 Authenticity (release 1.1.0)

The APK is signed with a release certificate (apksigner, schemes v1+v2+v3). Before installing you can verify:

- **Signing certificate (SHA-256):** `cb23a18c0cf8a23e43b5b63d199fc1440d3e4d6533e1309d3f92f273fe626a5a`
  (CN=AutoConnector for Telegram) — this fingerprint is identical across all future releases.
- **APK SHA-256:** `d7652e7f5c3a2174a3b7805c2539df7da080765c9b0f581a7ac5943987c9b935`
- **Windows zip SHA-256:** `1d8d675936387e89038dc4943d7f99200c1b735b86e1f79bd953cd93e60f0217`
- **Linux tar.gz SHA-256:** `9160ea519309dc62750a4a930dc1aae6e20dbcefd21b426fa85b48ace6f3e8f8`
- **macOS tar.gz SHA-256:** `322082ef3f06955ed299be790bce453e47db37fca17daea54724d60698446bc7`

Verify with: `apksigner verify --print-certs AutoConnector_for_Telegram.apk` (certificate) and
`sha256sum -c SHA256SUMS.txt` (file integrity; `SHA256SUMS.txt` is attached to the release).

## 📸 Screenshots

<table>
<tr>
<td align="center"><img src="docs/screenshots/connector.png" width="200"><br><sub>Connector — active session</sub></td>
<td align="center"><img src="docs/screenshots/scan.png" width="200"><br><sub>Scan and graphs</sub></td>
<td align="center"><img src="docs/screenshots/catalog.png" width="200"><br><sub>Proxy catalog (by mode)</sub></td>
<td align="center"><img src="docs/screenshots/host-card.png" width="200"><br><sub>Host card + history</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/logs.png" width="200"><br><sub>Relay logs</sub></td>
<td align="center"><img src="docs/screenshots/settings.png" width="200"><br><sub>Settings</sub></td>
<td align="center"><img src="docs/screenshots/export.png" width="200"><br><sub>Export of tg:// links</sub></td>
<td align="center"><img src="docs/screenshots/hotkeys.png" width="200"><br><sub>Hotkeys</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/guide.png" width="200"><br><sub>Connection guide</sub></td>
<td align="center"><img src="docs/screenshots/connector-ru.png" width="200"><br><sub>Connector · Russian UI</sub></td>
<td align="center"><img src="docs/screenshots/scan-ru.png" width="200"><br><sub>Scan · Russian UI</sub></td>
<td align="center"><sub>26 UI languages<br>with auto-detection</sub></td>
</tr>
</table>


## Feedback

Send bugs and remarks here - https://t.me/AutoConnector_for_Telegram

## 🔐 Signature verification

The APK from releases is signed with a release key. You can verify it like this:

```bash
# Checksum (compare with SHA256SUMS.txt from the release)
sha256sum AutoConnector_for_Telegram.apk

# Digital signature and certificate fingerprint
apksigner verify --print-certs AutoConnector_for_Telegram.apk
```

The certificate fingerprint (SHA-256) used to sign the official builds is
published in each release's description — compare it to make sure the APK
hasn't been tampered with.

## 📄 License

[MIT](LICENSE).
