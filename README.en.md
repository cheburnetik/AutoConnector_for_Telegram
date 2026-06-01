[Русский](README.md) | **English**

# AutoConnector for Telegram (Android & Windows)

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

## 📥 Download (Android)

A ready, signed APK is on the GitHub releases page:

### **➡️ [Download the latest APK (GitHub Releases)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

The APK is digitally signed. See the [Signature verification](#-signature-verification)
section below for how to check the signature and checksum.

> The app is distributed as an APK directly (outside Google Play). AutoConnector
> for Telegram does not provide or invent proxies itself — it only searches for
> publicly available proxies across many open sources.

### Installing

1. Download the APK from the link above.
2. Android may ask you to allow installation from this source — allow it for the
   browser/file manager you install from.
3. Google Play Protect may show "Unknown app". This is a **normal** warning for
   **any** app outside Google Play, not a sign of a virus — tap "More details" →
   "Install anyway". To make sure the APK is authentic and not tampered with,
   verify the signature and checksum (section below).

The APK is signed with a stable release certificate (APK signature schemes
v2 + v3), so updates install over the previous version without reinstalling.

## 💻 Download (Windows)

The desktop version is the same engine and the same UI as on the phone (shared
Kotlin Multiplatform + Compose code). A ready `.exe` is on the releases page:

### **➡️ [Download for Windows (GitHub Releases)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

- A single `AutoConnector-Setup.exe` — **self-contained** (Java is bundled
  inside, nothing to install). Windows 10/11 x64.
- To run: double-click the `.exe`. If SmartScreen shows "Windows protected your
  PC" — click "More info" → "Run anyway".
- **Closing the window minimizes the app to the system tray** (icon near the
  clock); the relay keeps running in the background. Click the icon to restore;
  right-click → menu "Open" / "Exit".
- In Telegram Desktop set a SOCKS5 proxy `127.0.0.1` port `55001` (and `55002`),
  same as on Android.

Data (proxy database, settings) is stored in `%APPDATA%\AutoConnector`.

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
