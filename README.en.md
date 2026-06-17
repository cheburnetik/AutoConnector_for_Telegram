[Русский](README.md) | **English**

# AutoConnector for Telegram

**AutoConnector for Telegram** is an auto-connector: the app finds MTProto
proxies on the internet, checks that they are alive, and runs a local relay
through which Telegram keeps working even where it is blocked. You don't have
to hunt for working proxies by hand — AutoConnector for Telegram continuously
picks the fastest live ones.

In other words: it's a scanner of Telegram channels and various subscriptions
with public free MTProto proxies, auto-filling them into your Telegram. You
don't need to update the Telegram client. Proxy reachability is checked from
**your** device and network. Works on Wi-Fi + LTE without a VPN.

## Important on first launch:

- configure Telegram with a fixed SOCKS5 proxy from AutoConnector:
  `localhost:55001` and `localhost:55002`
- do not block notifications, otherwise it won't run in the background
- on first launch, wait ~15 minutes while it downloads and tests MTProto
  proxies and while the Telegram client itself switches over

## 📥 Download

All builds are on the releases page: **[GitHub Releases (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

| OS | File | Run |
|----|------|-----|
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

## ✨ Features

- **Auto proxy search** — scans dozens of open pages and subscriptions.
- **Liveness checks** — a real MTProto handshake, rated by speed/stability.
- **Local relay** — Telegram connects to `127.0.0.1`, and AutoConnector for
  Telegram routes traffic through the best live proxy, switching if the current
  one goes down.
- **Anti-DPI** — a set of masking tricks (browser mimicry, packet splitting,
  FakeTLS, etc.); the "Auto-rotate" mode picks a working one by itself.
- **Detailed statistics** — live/dead proxies, speed, latency, traffic, and the
  effectiveness of each anti-DPI trick.
- **Proxy catalog** — top by rating, with a detailed card per host: each host
  shows "Telegram connects / successful / total checks" and the last 25 attempts
  (TCP/TLS/total connect time, bytes received/sent).
- **Flexible host selection** — a "breadth" slider from "stick to the best proven
  hosts" to "try as widely as possible across all alive hosts"; when Telegram
  keeps switching relay ports the search widens automatically. Plus a per-host
  connect-timeout slider (100 ms … 15 s) and an "upstream race" (several parallel
  connects).
- **12 UI languages** with auto-detection and RTL support.

> ### What's new since 1.0.19
> - **Separate host pools and ratings per network type** — VPN / Wi-Fi / LTE /
>   Ethernet / White: each connection type keeps its own pool of live proxies, so
>   Telegram is never handed a host that only works under a VPN.
> - **Upstream race** — several connects in parallel, the fastest live one wins; a
>   "selection breadth" slider (from best-proven to as-wide-as-possible) with the
>   pool auto-widening when Telegram bounces between relay ports; a configurable
>   connect timeout (100 ms…15 s).
> - **Host catalog with a detailed card** — "Telegram connects / successful / total
>   checks" plus the last 25 attempts per host (TCP/TLS time, total connect
>   duration, bytes received/sent).
> - **Live graphs** of speed, ping and port activity (per second and per minute)
>   plus scan graphs.
> - **Anti-DPI and proxying engines** — a set of masking tricks with an
>   "Auto-rotate" mode, an obfuscation engine, and experimental engines
>   (split/coalescing) to match a specific block.
> - **Export/import** of settings, hosts and subscriptions + a full factory reset.
> - **Fast cold start** — aggressive multi-threaded subscription download through
>   several anonymizers.
> - **12 UI languages** with auto-detection (+RTL).

## 📸 Screenshots

<table>
<tr>
<td align="center"><img src="docs/screenshots/connector.png" width="200"><br><sub>Connector — Telegram connected</sub></td>
<td align="center"><img src="docs/screenshots/scan.png" width="200"><br><sub>Scan & statistics</sub></td>
<td align="center"><img src="docs/screenshots/catalog.png" width="200"><br><sub>Proxy catalog</sub></td>
<td align="center"><img src="docs/screenshots/logs.png" width="200"><br><sub>Relay logs</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/settings.png" width="200"><br><sub>Settings</sub></td>
<td align="center"><img src="docs/screenshots/subscriptions.png" width="200"><br><sub>Subscriptions (sources)</sub></td>
<td align="center"><img src="docs/screenshots/export.png" width="200"><br><sub>Export tg:// links</sub></td>
<td align="center"><img src="docs/screenshots/connector-active.png" width="200"><br><sub>Connector — active session</sub></td>
</tr>
</table>

## Feedback

Send bugs and suggestions here — https://t.me/AutoConnector_for_Telegram

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
