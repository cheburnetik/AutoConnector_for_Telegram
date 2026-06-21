[ENGLISH](README.en.md) · [AMHARIC](README.am.md) · [ARABIC](README.ar.md) · [AZERBAIJANI](README.az.md) · [BENGALI](README.bn.md) · [BURMESE](README.my.md) · [CHINESE](README.zh.md) · [DARI](README.prs.md) · [FRENCH](README.fr.md) · [GERMAN](README.de.md) · [HAUSA](README.ha.md) · [HINDI](README.hi.md) · [INDONESIAN](README.id.md) · [ITALIAN](README.it.md) · [JAPANESE](README.ja.md) · [KAZAKH](README.kk.md) · [KOREAN](README.ko.md) · [MARATHI](README.mr.md) · [PASHTO](README.ps.md) · [PERSIAN](README.fa.md) · [POLISH](README.pl.md) · [PORTUGUESE](README.pt.md) · [PUNJABI](README.pa.md) · [RUSSIAN](README.md) · [SPANISH](README.es.md) · [TAMIL](README.ta.md) · [TELUGU](README.te.md) · [THAI](README.th.md) · [TIGRINYA](README.ti.md) · [TURKISH](README.tr.md) · [UKRAINIAN](README.uk.md) · [URDU](README.ur.md) · [UZBEK](README.uz.md) · [VIETNAMESE](README.vi.md)

**[Download (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

# AutoConnector for Telegram

AutoConnector for Telegram — እዚ መተግበሪ ባዕሉ ኣብ ኢንተርነት MTProto proxy ይረክብ፣ ህያው ምዃኖም የረጋግጽ፣ ከምኡ’ውን Telegram እንተተኸልከለ’ውን ብዘተኣማምን ኣገባብ ክሰርሕ ዝገብር ናይ ከባቢ relay የቕውም። ተጠቃሚ ብኢዱ ዝሰርሑ proxy ክደሊ ኣየድልዮን — AutoConnector for Telegram ብቐጻሊ እቶም ዝቐልጠፉ ህያዋን ይመርጽ፣ ብፍላይ ካብ ኮምፒተርካ/ስልክኻ ኣቢሉ ይፍትኖም።

ብኻልእ ኣዘራርባ፥ እዚ ናይ Telegram ቻነላትን ኩሎም ዓይነት subscription-ታትን ምስ ህዝባዊ ናጻ MTProto proxy ዝፍትሽ scanner እዩ፣ ናብ Telegram-ካ ብኣውቶማቲክ ዝሰኩዕ። ናይ Telegram client ምሕዳስ ኣየድልን። ናይ proxy ተበጻሕነት ካብ ናትካ መሳርሒን ናይ ኔትዎርክ ከባቢኻን ይምርመር። ብዘይ VPN ኣብ Wi-Fi + LTE ይሰርሕ።

Platform-ታት፥ Android, Windows, Linux, MacBook።

ናይ Android ስሪት ባዕሉ ይሰርሕ፣ ኣብ Windows ግን ኣብ settings ሓደ proxying engine — "SPLIT..." ወይ "COALESCING.." — ከተኽፍት ኣለካ፣ ወይ ብየማን "Telegram connected" ዝብል ቃላትን እቲ ዓቢ ሰማያዊ/ቀጠልያ ዓንኬልን ዘሎ መልጎም ኣቢልካ። ወይ ድማ ምኽልካል ኣብ ኩሉ ቦታ ስለ ዝፈላለ፣ ንዓኻ ብውልቂ ዝበለጸ ዝሰርሕ ምረጽ። እቶም "COALESCING.." mode-ታት ናይ መወዳእታ ኣማራጺ እዮም — Telegram ክሰርሕ ይጅምር፣ ግን ኣብ chat-ታት media content ምልኣኽ/ምርኣይ ክብላሾ እዩ።

ከም COMODO ዝበለ firewall እንተ ትጥቀም ከተጥፍኦ እመክር፥ ነዚ መተግበሪ ናብ sandbox የእትዎ፣ እቲ firewall-ኡ ድማ ናብ MTProto proxy ዝወጹ connection-ታት የበላሹ። ወይ ነዚ መተግበሪ ኣብ virtual machine ኣካይዶ — ኣብኡ እቲ TCP stack ምሉእ ብምሉእ ይቕየር፣ ናይ AutoConnector ባህሪ ድማ ዝተፈልየ ክኸውን እዩ።

ከምኡ’ውን ናብ ዝሰርሕ proxy ቀልጢፍካ ንምብጻሕን ኣብ ውሽጢ Telegram "Connected" ዝብል ምልክት ንምርካብን ኣብ ሞንጎ port 55001ን 55002ን ብኢድካ (ኣብ proxy settings) ክትቅይር ንTelegram ሓግዞ።

# ✨ Features

- **Auto proxy search** — ዓሰርተታት ክፉታት ገጻትን subscription-ታትን ይፍትሽ።
- **Liveness checks** — ናይ ሓቂ MTProto handshake፣ ብፍጥነት/ምርግጋእ ዝምዘን።
- **Local relay** — Telegram ናብ `127.0.0.1` ይራኸብ፣ AutoConnector for
  Telegram ድማ ትራፊክ ናብቲ ዝበለጸ ህያው proxy የመሓላልፍ፣ እቲ ህልዊ እንተወዲቑ ድማ
  ይቕይር።
- **Anti-DPI** — ስብስት ናይ ምሽፋን ሜላታት (browser mimicry፣ packet
  splitting፣ FakeTLS፣ ወዘተ)፤ እቲ "Auto-rotate" mode ባዕሉ ዝሰርሕ ይመርጽ።
- **Detailed statistics** — ህያዋን/ምዉታት proxy፣ ፍጥነት፣ latency፣ ትራፊክ፣
  ናይ ነፍሲ ወከፍ anti-DPI ሜላ ውጽኢታውነት።
- **Proxy catalog** — ብደረጃ ዝለዓሉ፣ ምስ ዝርዝር ካርድ ንነፍሲ ወከፍ host፥
  ነፍሲ ወከፍ host "Telegram ይራኸብ / ዕዉት / ጠቕላላ ምርመራታት"ን
  ናይ መወዳእታ 25 ፈተነታትን (TCP/TLS/ጠቕላላ ናይ connect ግዜ፣ ዝተቐበለ/ዝተላእከ bytes) የርኢ።
- **Flexible host selection** — "breadth" slider፥ ካብ "ኣብቶም ዝበለጹ ዝተረጋገጹ
  host ጽናሕ" ክሳብ "ኣብቶም ህያዋን ብዝከኣል ዝሰፍሐ ፈትን"፤ Telegram ኣብ ሞንጎ relay port-ታት
  ክዘል ከሎ እቲ ምርጫ ብኣውቶማቲክ ይሰፍሕ። ፍሉይ slider — ናይ connect timeout
  (100 ms … 15 s) — ከምኡ’ውን "upstream race" (ብዙሓት ብተመሳሳሊ ዝኸዱ connect-ታት)።
- **12 UI ቋንቋታት** ምስ auto-detectionን RTL support።

> ### ካብ 1.0.19 ኣትሒዙ ሓዱሽ እንታይ ኣሎ
> - **ብዓይነት ኔትዎርክ ዝተፈላለዩ host pool-ታትን ደረጃታትን** — VPN / Wi-Fi / LTE /
>   Ethernet / White፥ ነፍሲ ወከፍ ዓይነት connection ናቱ ናይ ህያዋን proxy pool ይሕዝ፣ ስለዚ
>   Telegram ኣብ ትሕቲ VPN ጥራይ ዝሰርሕ ዘይኮነ ነገር ፈጺሙ ኣይወሃቦን።
> - **Upstream race** — ብዙሓት connect ብተመሳሳሊ፣ እቲ ዝቐልጠፈ ህያው ይዕወት፤
>   "selection breadth" slider (ካብ ዝበለጸ-ዝተረጋገጸ ክሳብ ብዝከኣል-ዝሰፍሐ) ምስ pool
>   Telegram ኣብ ሞንጎ relay port-ታት ክዘል ከሎ ብኣውቶማቲክ ዝሰፍሕ፤
>   ዝውቀር ናይ connect timeout (100 ms…15 s)።
> - **ምስ ዝርዝር ካርድ host catalog** — "Telegram ይራኸብ / ዕዉት /
>   ጠቕላላ ምርመራታት" ከምኡ’ውን ናይ መወዳእታ 25 ፈተነታት ንነፍሲ ወከፍ host (TCP/TLS ግዜ፣
>   ናይ connect ግዜ፣ ዝተቐበለ/ዝተላእከ bytes)።
> - **ህያው graph-ታት** ናይ ፍጥነት፣ pingን port activityን (ብካልኢትን ብደቒቕን)
>   ከምኡ’ውን ናይ scan graph-ታት።
> - **Anti-DPIን proxying engine-ታትን** — ስብስት ናይ ምሽፋን ሜላታት ምስ
>   "Auto-rotate" mode፣ obfuscation engine፣ ከምኡ’ውን ንሓደ ፍሉይ ምኽልካል ንምግጣም
>   ናይ ምፍታን (split/coalescing) engine-ታት።
> - **Export/import** ናይ settings፣ hostን subscription-ታትን + ምሉእ factory reset።
> - **ቅልጡፍ cold start** — ብብዙሓት anonymizer ኣቢሉ ጨካን multi-threaded ናይ
>   subscription download።
> - **26 UI ቋንቋታት** ምስ auto-detection (+RTL)።

# ኣብ ናይ መጀመርታ ምኽፋት ኣገዳሲ፥

- ንTelegram ብቐዋሚ SOCKS5 proxy localhost:55001ን localhost:55002ን ኣዳልዎ።
- ብጀካ እዞም ካልኦት proxy ሰርዞም።
- ኣብ Telegram "Use proxy" ኣኽፍት።
- ኣብ Android notification ኣይትዕገት፣ እንተዘይኮይኑ ኣብ background ኣይክሰርሕን።
- ኣብ ናይ መጀመርታ ምኽፋት፣ MTProto proxy ክወርድን ክዘውርን ከሎ፣ ከምኡ’ውን እቲ Telegram client ባዕሉ ክቕይር ከሎ፣ ኣስታት 15 ደቒቕ ተጸበ።

# ገለ እንተ ዘይሰሪሑ

1. ሓንቲ እኳ እንተ ዘይሰሪሓ፣ ነዚ ፕሮግራም ከም ናይ ህያዋን proxy ኣውቶማቲክ ካታሎግ ተጠቐመሉ። ብ hotkey CTRL+WIN+ALT+P ከምኡ’ውን CTRL+SHIFT+ALT+P ናይ AutoConnector መስኮት ከይከፈትካ’ውን ቀልጢፍካ ናብ Telegram-ካ ናይ ዘፈቐደ proxy ክትውስኽ ትኽእል። ውጽኢቱ ድማ Telegram ብቐጥታ ናብ proxy ይኸይድ፣ ብዘይ AutoConnector፣ ግን ናጻ proxy ዝልጠፉሎም chat-ታት ክትከታተልን ግዜ ኣጥፊእካ ክትፍትኖምን ኣየድልየካን። AutoConnector ኣብ tray ይንበር፣ "Connector" toggle ኣጥፍኣዮ፣ "Scan" toggle ድማ ብርሃ ግደፎ።

2. AutoConnector ኣብ ካልእ መሳርሒ ፈትኖ፥ ስልክኻ፣ ናይ ዓርክኻ ስልኪ፣ ኮምፒተር። ኣብ ሞንጎ Windows/Android platform-ታት ናይ ምኽልካል ምሕላፍ መትከል ፈጺሙ ዝተፈልየ እዩ። ኣብ ዝበዝሐ ኣጋጣሚ ኣብ Android ብዘይ ዝኾነ setting ክሰርሕ እዩ።

3. ገለ እንተ ዘይሰሪሑ፣ ንሓደ መዓልቲ ግዜያዊ VPN ኣኽፍት፣ ኣብታ መዓልቲ ድማ AutoConnector + Telegram ፈትኖ (Telegram ብ AutoConnector ኣቢልካ ኣራኽቦ፣ ኣብ port 55001ን 55002ን proxy ብምግላጽ)። ኣብ ውሽጢ እቲ ፕሮግራም "VPN ምስ በርሀ -> proxy ናብ MTProto" ዝብል checkbox ኣምልኽ። AutoConnector ጀሚሩ እንተ ሰሪሑ ርአ። እወ እንተኾይኑ፣ መደምደምታ ንጹር እዩ — AutoConnector proxy ብዓወት ይረክብ፣ ናይ Telegram ትራፊክ’ውን ብዓወት ናብኡ የመሓላልፍ፣ ግን VPN እንተ ኣጥፊእካዮ፣ ኣብ ሃገርካ ዘሎ ስርዓተ ምኽልካል ኩሎም ዝወጹ connection-ታት ብዕቤት ይዓግቶም። ኣብዚ ኩነታት ምኽልካል ክሓልፍ ዝኽእል ዝሰርሕ ንምምራጽ ኣብ AutoConnector ዘለዉ መሳርሒታት ንምዝዋር ፍርቂ ሰዓት ከተጥፍእ ኣለካ። እቲ ፕሮግራም ክሳብ ሕጂ ኩሎም ኣማራጺታት ብኣውቶማቲክ ክዘውር ኣይክእልን (ናይ anti-DPI ሜላታት ኣውቶማቲክ ምዝዋር ጥራይ እዩ ዘሎ)። ድሕሪ እቲ ፈተነ፣ VPN ኣጥፍኣዮ፣ ነቲ "VPN ምስ በርሀ proxy ናብ MTProto" checkbox ድማ ናብ "Proxy directly" ኩነታት መልሶ።

4. ናይ ነጥቢ (3) ኣማራጺ። ኣብ Windows/Linux host-ካ virtual machine ኣጻዕን። Telegram + AutoConnector ኣብ ውሽጡ ኣካይድ። ብዘይ VPN’ውን ብፍጹም ጀሚሩ ሰሪሑዶ? ማለት host-ካ’ዩ connection-ካ ዘበላሹ ዘሎ፣ ናይ ሃገርካ ስርዓተ ምኽልካል ኣይኮነን! ምኽንያታት፥ firewall-ታት፣ antivirus-ታት፣ ናይ VPN ተረፍ-መረፍ። እቲ antivirus AutoConnector ናብ sandbox እንተ ኣእትዩ፣ ወይ እቲ firewall ናይ AutoConnector ዘይልሙድ anti-DPI ሜላታት እንተ ዓጊቱ፣ AutoConnector ኣብ host ብምውጻእ ካብ antivirusን firewallን ብምስጋር (exception-ታት) ከተካይዶ ኣለካ። ወይ ንግዜኡ ምሉእ ብምሉእ ኣጥፍኣዮም እሞ ኮምፒተር ዳግም ኣብገሶ። እወ፣ ምምካር ዘስሕቕ’ኳ እንተኾነ፣ ኮምፒተር ዳግም ኣብገሶ፣ ምኽንያቱ VPN ፕሮግራማት መብዛሕትኡ ግዜ ይበላሸዉ ኣብ host ድማ TUN device ኣብ ፍርቂ-ህያው ኩነታት ክገድፉ ይኽእሉ። ድሕሪ ዳግም ምብጋስ፣ VPN ኣይትጀምር — ኣቐዲምካ AutoConnector ፈትኖ።

  5. ምኽልካል ንምሕላፍ ፈትን። ኣብ settings ወይ ኣብ ቀንዲ መስኮት ናይ ምኽፋት መልጎም ድለ (ብየማን እቲ ዓቢ ሰማያዊ/ቀጠልያ ዓንኬል ዘሎ መልጎም ድለ)። ኣስታት 15 ደቒቕ ከተጥፍእ ኣለካ። ኣብ 3 ጉጅለ ይኽፈሉ፥
	  - Proxying engine። ዝኾነ Coalescing* mode ፈትን። ኣብ ዝበዝሐ ኣጋጣሚ ብኡ ንብኡ ክሰርሕ እዩ። ግን ብእኡ ኣብ Telegram ምስልታት/ቪድዮታት ኣይክጽዓኑን (እዚ bug ዘይኮነ feature/ምልውዋጥ እዩ)። ቀጺልካ Split* mode-ታት ፈትን፤ እንተ ሰሪሑ — ምስልታት ይጽዓኑ። ወይ ናብ "off" መልሶ።
	  - "Parallel upstream race" ፈትን። እዚ ማለት Telegram ናብ ሓደ proxy 1 connect ክገብር ከሎ፣ AutoConnector ናብ ዝተፈላለዩ MTProto proxy 5-30 connect ይገብር ነቲ ዝበለጸ ድማ ንTelegram የረክብ። ኣብ ናይ መተግበሪ settings timeout (3-5 ሰከንድ)ን ቁጽሪ ናይ parallel upstream-ታትን ክሳብ 30 ክትመርጽ ትኽእል።
	  - "Auto-rotate anti-DPI tricks" ኣኽፍት እሞ እቲ ፕሮግራም ባዕሉ ክዘውሮም እዩ።
	  - Telegram ቀልጢፉ ክቕይር ንምግባር፣ ኣብ proxy settings (ኣብ Telegram) ኣብ ነፍሲ ወከፍ 5-10 ሰከንድ ብኢድካ ናብቲ ቀጺሉ ዘሎ port ብዙር ቀይር፥ 55001->55002->55001->...

6. እቲ ዝሓየለ/ዝቐልጠፈ ጥምረት settings፥
	- connect timeout 5s
	- host selection breadth 100%
	- 30 parallel connect-ታት
	- auto-rotate DPI tricks
	- parallel upstream race
	- proxying engine: Coalescing*
	- ኣብ ውሽጢ Telegram፣ ኣብ proxy መስኮት፣ ኣብ ነፍሲ ወከፍ 10 ሰከንድ ብዙር ሓዱሽ port ጠውቕ።

7. ናይ Windowsን Androidን ናይ ኣቐማምጣ ፖሊሲ ዝተፈልየ እዩ! ኣብ ላዕሊ ዝተጻሕፈ ኩሉ መብዛሕትኡ ንWindows ይምልከት። ኣብ Android ንዝበዝሕ ሰብ ብዘይ ዝኾነ setting (ብዝኾነ setting) ይሰርሕ። Windows ዝተፈልየ TCP stackን ዝተፈልየ Telegram appን ኣለዎ፣ እዚ ድማ ካብ Android ብጥራዩ ዝሓሰረ ብርኪ ኣለዎ። ካልእ Telegram client ፈትን፣ እቲ official ጥራይ ዘይኮነ።

8. ብኽብረትካ ዝርዝር ናይ bug report ብዝኾነ ቋንቋ ኣብ https://t.me/AutoConnector_for_Telegram ጽሓፍ — platform-ካ፣ እንታይ ዓይነት method ከም ዝፈተንካ (settings)፣ firewall/antivirus ኣለካ ድዩ፣ ካብ VPN/virtual machine ፈቲንካ ድዩ። ከምኡ’ውን ዝኾነ ኣወንታዊ ዓወት — እንታይ ፈቲንካ ከመይ ከም ዝሰርሐ ጽሓፍ።


## 📥 Download

ኩሎም build-ታት ኣብ ናይ releases ገጽ ኣለዉ፥ **[GitHub Releases (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

| OS | File | Run |
|----|------|--------|
| **Android** | `AutoConnector_for_Telegram.apk` | APK ኣጻዕን (ብወጻኢ Google Play — ካብ source ምጽዓን ፍቐድ) |
| **Windows** 10/11 x64 | `AutoConnector-for-Telegram-windows-x64.zip` | extract ግበር → `AutoConnector\AutoConnector.exe` ኣካይድ |
| **Linux** x64 | `AutoConnector-for-Telegram-linux-x64.tar.gz` | extract ግበር → `./AutoConnector/bin/AutoConnector` |
| **macOS** 11+ (Apple Silicon) | `AutoConnector-for-Telegram-macos.tar.gz` | extract ግበር → `AutoConnector.app` ብኽልተ ጠውቕ (እንተ ተዓጊቱ — `xattr -dr com.apple.quarantine AutoConnector.app`) |

### 🔐 Authenticity (release 1.1.0)

እቲ APK ብ release certificate (apksigner, schemes v1+v2+v3) ተፈሪሙ ኣሎ። ቅድሚ ምጽዓን ከተረጋግጽ ትኽእል፥

- **Signing certificate (SHA-256):** `cb23a18c0cf8a23e43b5b63d199fc1440d3e4d6533e1309d3f92f273fe626a5a`
  (CN=AutoConnector for Telegram) — እዚ fingerprint ኣብ ኩሎም መጻኢ release-ታት ሓደ ዓይነት እዩ።
- **APK SHA-256:** `d7652e7f5c3a2174a3b7805c2539df7da080765c9b0f581a7ac5943987c9b935`
- **Windows zip SHA-256:** `1d8d675936387e89038dc4943d7f99200c1b735b86e1f79bd953cd93e60f0217`
- **Linux tar.gz SHA-256:** `9160ea519309dc62750a4a930dc1aae6e20dbcefd21b426fa85b48ace6f3e8f8`
- **macOS tar.gz SHA-256:** `322082ef3f06955ed299be790bce453e47db37fca17daea54724d60698446bc7`

ብኸምዚ ኣረጋግጽ፥ `apksigner verify --print-certs AutoConnector_for_Telegram.apk` (certificate) ከምኡ’ውን
`sha256sum -c SHA256SUMS.txt` (ናይ ፋይል ጽፉፍነት፤ `SHA256SUMS.txt` ምስ release ተተሓሒዙ ኣሎ)።

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

bug-ታትን ርእይቶታትን ኣብዚ ስደድ - https://t.me/AutoConnector_for_Telegram

## 🔐 Signature verification

ካብ releases ዝመጽእ APK ብ release key ተፈሪሙ ኣሎ። ብኸምዚ ከተረጋግጾ ትኽእል፥

```bash
# Checksum (compare with SHA256SUMS.txt from the release)
sha256sum AutoConnector_for_Telegram.apk

# Digital signature and certificate fingerprint
apksigner verify --print-certs AutoConnector_for_Telegram.apk
```

ነቶም official build-ታት ንምፍራም ዝተጠቕመ certificate fingerprint (SHA-256)
ኣብ ናይ ነፍሲ ወከፍ release መግለጺ ይዝርጋሕ — እቲ APK ከም ዘይተበላሸወ ንምርግጋጽ
ኣወዳድሮ።

## 📄 License

[MIT](LICENSE).
