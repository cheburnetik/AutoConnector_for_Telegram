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
| **Windows** 10/11 x64 | `AutoConnector-for-Telegram-windows-x64.zip` | extract → run `AutoConnector.bat` |
| **Linux** x64 | `AutoConnector-for-Telegram-linux-x64.tar.gz` | extract → `./AutoConnector-for-Telegram/AutoConnector.sh` |
| **macOS** 11+ (Apple Silicon/Intel) | `AutoConnector-for-Telegram-macos.tar.gz` | extract → `./AutoConnector.command` (if blocked — `xattr -dr com.apple.quarantine AutoConnector-for-Telegram`) |

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
- **Proxy catalog** — top by rating, with a detailed card per host.

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
