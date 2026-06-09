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

### 🔐 Authenticity (release 1.0.61)

The APK is signed with a release certificate (apksigner, schemes v1+v2+v3). Before installing you can verify:

- **Signing certificate (SHA-256):** `cb23a18c0cf8a23e43b5b63d199fc1440d3e4d6533e1309d3f92f273fe626a5a`
  (CN=AutoConnector for Telegram) — this fingerprint is identical across all future releases.
- **APK SHA-256:** `2db3f036ac130e5dad5a171792fff2d69acb3a19b90786f7e8b189bc611d918e`
- **Windows zip SHA-256:** `afb08bd2c991ca3520ba94a620e3af5ffcc8274747c864a36265a7c93ecc9f2b`
- **Linux tar.gz SHA-256:** `2a329a0a9e9b7892da9dd3437d5764e6ed209ce3d3acd6c69ff6dc6cd23f8354`
- **macOS tar.gz SHA-256:** `f96ca244eea22834ca6ea8e19b1c377f80efaf6c9857f8f8cdb0d405933f938a`

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
