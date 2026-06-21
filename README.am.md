[ENGLISH](README.en.md) · [AMHARIC](README.am.md) · [ARABIC](README.ar.md) · [AZERBAIJANI](README.az.md) · [BENGALI](README.bn.md) · [BURMESE](README.my.md) · [CHINESE](README.zh.md) · [DARI](README.prs.md) · [FRENCH](README.fr.md) · [GERMAN](README.de.md) · [HAUSA](README.ha.md) · [HINDI](README.hi.md) · [INDONESIAN](README.id.md) · [ITALIAN](README.it.md) · [JAPANESE](README.ja.md) · [KAZAKH](README.kk.md) · [KOREAN](README.ko.md) · [MARATHI](README.mr.md) · [PASHTO](README.ps.md) · [PERSIAN](README.fa.md) · [POLISH](README.pl.md) · [PORTUGUESE](README.pt.md) · [PUNJABI](README.pa.md) · [RUSSIAN](README.md) · [SPANISH](README.es.md) · [TAMIL](README.ta.md) · [TELUGU](README.te.md) · [THAI](README.th.md) · [TIGRINYA](README.ti.md) · [TURKISH](README.tr.md) · [UKRAINIAN](README.uk.md) · [URDU](README.ur.md) · [UZBEK](README.uz.md) · [VIETNAMESE](README.vi.md)

**[Download (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

# AutoConnector for Telegram

AutoConnector for Telegram — መተግበሪያው በራሱ በበይነ መረቡ ላይ MTProto proxy ያገኛል፣ በሕይወት መኖራቸውን ያረጋግጣል፣ እና Telegram በታገደበት ቦታም እንኳ በአስተማማኝ ሁኔታ መሥራቱን የሚቀጥልበትን አካባቢያዊ relay ያስነሳል። ተጠቃሚው የሚሠሩ proxy በእጅ ማደን አያስፈልገውም — AutoConnector for Telegram ሁልጊዜ በጣም ፈጣን የሆኑትንና በሕይወት ያሉትን እየመረጠ፣ በተለይ ከእርስዎ ኮምፒውተር/ስልክ እያረጋገጣቸው ይሄዳል።

በሌላ አነጋገር፦ ይህ ይፋዊ ነፃ MTProto proxy ያላቸውን የTelegram ቻናሎችንና ሁሉንም ዓይነት subscription የሚቃኝ መሣሪያ ሲሆን፣ በቀጥታ ወደ የእርስዎ Telegram ያስገባል። የTelegram client ማዘመን አያስፈልግም። የproxy ተደራሽነት ከራስዎ መሣሪያና የአውታረ መረብ አካባቢ ይረጋገጣል። ያለ VPN በWi-Fi + LTE ይሠራል።

መድረኮች፦ Android, Windows, Linux, MacBook.

የAndroid ስሪት በራሱ ይሠራል፣ በWindows ግን በቅንብሮች ውስጥ — "SPLIT..." ወይም "COALESCING.." — proxying engine ማብራት ያስፈልግዎታል፣ ወይም "Telegram connected" ከሚለው ጽሑፍና ከትልቁ ግራጫ/አረንጓዴ ክብ በስተቀኝ ባለው ቁልፍ በኩል። ወይም እገዳ በየቦታው ስለሚለያይ፣ ለእርስዎ ግል በተሻለ የሚሠራውን ይምረጡ። "COALESCING.." ሁነታዎች የመጨረሻ አማራጭ ናቸው — Telegram መሥራት ይጀምራል፣ ነገር ግን በቻቶች ውስጥ media content መላክ/ማሳየት ይበላሻል።

እንደ COMODO ያለ firewall የሚጠቀሙ ከሆነ ማጥፋቱን እመክራለሁ፦ መተግበሪያውን sandbox ውስጥ ያስገባል፣ እና firewall-ሱ ወደ MTProto proxy የሚወጡ ግንኙነቶችን ያበላሻል። ወይም መተግበሪያውን በ virtual machine ውስጥ ያሂዱ — እዚያ የTCP stack ሙሉ በሙሉ ይለወጣል፣ እና የAutoConnector ባሕርይ የተለየ ይሆናል።

እንዲሁም፣ የሚሠራ proxy በፍጥነት ለመድረስና በTelegram ውስጥ "Connected" የሚለውን ምልክት ለማግኘት፣ Telegram በ port 55001 እና 55002 መካከል በእጅ (በproxy ቅንብሮች) እንዲቀያየር ይርዱት።

# ✨ Features

- **Auto proxy search** — በደርዘን የሚቆጠሩ ክፍት ገጾችንና subscription ይቃኛል።
- **Liveness checks** — እውነተኛ የMTProto handshake፣ በፍጥነት/መረጋጋት የተደረደረ።
- **Local relay** — Telegram ከ `127.0.0.1` ጋር ይገናኛል፣ እና AutoConnector for
  Telegram traffic-ን በጣም ጥሩ በሆነ በሕይወት ባለ proxy በኩል ያስተላልፋል፣ የአሁኑ ከወደቀም
  ይቀያይራል።
- **Anti-DPI** — የመሸፋፈኛ ስልቶች ስብስብ (browser mimicry, packet
  splitting, FakeTLS, ወዘተ)፤ "Auto-rotate" ሁነታ የሚሠራውን በራሱ ይመርጣል።
- **Detailed statistics** — በሕይወት/የሞቱ proxy, ፍጥነት, ዘገምታ (latency), traffic,
  የእያንዳንዱ anti-DPI ስልት ውጤታማነት።
- **Proxy catalog** — በደረጃ የላቁ፣ ለእያንዳንዱ host ዝርዝር ካርድ ያለው፦
  እያንዳንዱ host "Telegram connects / successful / total checks"-ን እና
  የመጨረሻዎቹን 25 ሙከራዎች ያሳያል (TCP/TLS/total connect duration, የተቀበሉ/የተላኩ bytes)።
- **Flexible host selection** — "breadth" slider፦ ከ"በተረጋገጡ ምርጥ host ላይ
  ቆይ" እስከ "በሕይወት ባሉት መካከል በተቻለ መጠን ሰፊ ሞክር"፤ Telegram በrelay port-ዎች
  መካከል ሲወዛወዝ፣ ምርጫው በራሱ ይሰፋል። የተለየ slider — የconnect timeout
  (100 ms … 15 s) — እና "upstream race" (በርካታ ትይዩ connect-ዎች)።
- **12 UI languages** auto-detection እና የRTL ድጋፍ ያላቸው።

> ### What's new since 1.0.19
> - **Separate host pools and ratings per network type** — VPN / Wi-Fi / LTE /
>   Ethernet / White: እያንዳንዱ የግንኙነት ዓይነት የራሱን በሕይወት ያሉ proxy pool ይይዛል፣ ስለዚህ
>   Telegram በVPN ሥር ብቻ የሚሠራ ነገር ፈጽሞ አይሰጠውም።
> - **Upstream race** — በርካታ connect-ዎች በትይዩ፣ በሕይወት ያለው በጣም ፈጣኑ ያሸንፋል፤
>   "selection breadth" slider (ከተረጋገጠ ምርጥ እስከ በተቻለ መጠን ሰፊ) pool-ሱ
>   Telegram በrelay port-ዎች መካከል ሲወዛወዝ በራሱ ይሰፋል፤
>   ሊዋቀር የሚችል connect timeout (100 ms…15 s)።
> - **Host catalog with a detailed card** — "Telegram connects / successful /
>   total checks" ሲደመር ለእያንዳንዱ host የመጨረሻዎቹ 25 ሙከራዎች (TCP/TLS time,
>   connect duration, የተቀበሉ/የተላኩ bytes)።
> - **Live graphs** of speed, ping እና port activity (በሰከንድ እና በደቂቃ)
>   ሲደመር የscan graphs።
> - **Anti-DPI and proxying engines** — "Auto-rotate" ሁነታ ያለው የመሸፋፈኛ ስልቶች
>   ስብስብ፣ obfuscation engine, እና የሙከራ engine-ዎች (split/
>   coalescing) ለተለየ እገዳ ለማስማማት።
> - **Export/import** የቅንብሮች፣ host-ዎች እና subscription + ሙሉ factory reset።
> - **Fast cold start** — በበርካታ anonymizer በኩል ሀይለኛ multi-threaded subscription download።
> - **26 UI languages** auto-detection ያላቸው (+RTL)።

# Important on first launch:

- Telegram-ን በቋሚ SOCKS5 proxy localhost:55001 እና localhost:55002 ያዋቅሩ።
- ከእነዚህ ውጭ ያሉትን ሌሎች proxy-ዎች ይሰርዙ።
- በTelegram ውስጥ "Use proxy"-ን ያብሩ።
- በAndroid ላይ notification-ን አያግዱ፣ አለበለዚያ background ውስጥ አይሠራም።
- በመጀመሪያ ማስነሻ ላይ፣ MTProto proxy-ዎችን እያወረደ እና እየዞረ ሲሄድ እንዲሁም የTelegram client ራሱ ሲቀያይር፣ ~15 ደቂቃ ይጠብቁ።

# If nothing works

1. ምንም ነገር ካልሠራ፣ ፕሮግራሙን በሕይወት ያሉ proxy-ዎች ራስ-ሰር catalog አድርገው ይጠቀሙበት። በቁልፍ ጥምሮች CTRL+WIN+ALT+P እና CTRL+SHIFT+ALT+P የAutoConnector መስኮትን እንኳ ሳይከፍቱ በዘፈቀደ የተመረጠ proxy በቀጥታ ወደ የእርስዎ Telegram በፍጥነት ማከል ይችላሉ። ውጤቱ Telegram ያለ AutoConnector በቀጥታ ወደ proxy መሄዱ ነው፣ ነገር ግን ነፃ proxy የሚለጠፉባቸውን ቻቶች መከታተልና በማረጋገጥ ጊዜ ማባከን አያስፈልግዎትም። AutoConnector በtray ውስጥ ይኑር፣ "Connector" toggle-ን አጥፉ፣ "Scan" toggle-ን ብሩ ይተዉት።

2. AutoConnector-ን በሌላ መሣሪያ ላይ ይሞክሩ፦ የእርስዎ ስልክ፣ የጓደኛ ስልክ፣ ኮምፒውተር። የእገዳን ማለፊያ መርህ በWindows/Android መድረኮች መካከል ፍጹም የተለየ ነው። ምናልባት በAndroid ላይ ምንም ቅንብር ሳያስፈልገው ይሠራል።

3. ምንም ካልሠራ፣ ለአንድ ቀን VPN ለጊዜው ያብሩና በዚያ ቀን ውስጥ AutoConnector + Telegram-ን ይፈትሹ (Telegram-ን በport 55001 እና 55002 proxy እየገለጹ በAutoConnector በኩል ያገናኙ)። በፕሮግራሙ ውስጥ "When VPN is on -> proxy to MTProto" የሚለውን checkbox ምልክት ያድርጉ። AutoConnector መሥራት መጀመሩን ይመልከቱ። ከጀመረ መደምደሚያው ግልጽ ነው — AutoConnector proxy-ዎችን በተሳካ ሁኔታ ያገኛል እና የTelegram-ን traffic ወደዚያ በተሳካ ሁኔታ ያስተላልፋል፣ ነገር ግን VPN-ን ካጠፉ፣ በአገርዎ ያለው የእገዳ ሥርዓት ሁሉንም የሚወጡ ግንኙነቶችን በጣም ጠንካራ በሆነ መንገድ ያግዳል። በዚያ ሁኔታ እገዳዎችን ማለፍ የሚችል የሚሠራ መሣሪያ ለመምረጥ በAutoConnector ውስጥ ያሉትን መሣሪያዎች በመዞር ግማሽ ሰዓት ማሳለፍ ይኖርብዎታል። ፕሮግራሙ ገና ሁሉንም አማራጮች በራሱ መዞር አይችልም (የanti-DPI ስልቶች ራስ-ሰር rotation ብቻ አለ)። ከሙከራው በኋላ VPN-ን አጥፉና "When VPN is on, proxy to MTProto" checkbox-ን ወደ "Proxy directly" ሁኔታ ይመልሱት።

4. ለነጥብ (3) አማራጭ። በWindows/Linux host-ዎ ላይ virtual machine ይጫኑ። በውስጡ Telegram + AutoConnector ያሂዱ። ያለ VPN እንኳ ፍጹም መሥራት ጀመረ? ይህ ማለት የእርስዎ host ግንኙነቶችዎን እያበላሸ ነው፣ በአገርዎ ያለው የእገዳ ሥርዓት አይደለም! ምክንያቶች፦ firewall-ዎች፣ antivirus-ዎች፣ ከVPN የቀሩ ነገሮች። antivirus AutoConnector-ን sandbox ውስጥ ካስገባ፣ ወይም firewall የAutoConnector ያልተለመዱ anti-DPI ስልቶችን ካገደ፣ AutoConnector-ን antivirus እና firewall-ን በማለፍ (exceptions) በhost ላይ ማሄድ ይኖርብዎታል። ወይም ለጊዜው ሙሉ በሙሉ አጥፍተው ኮምፒውተሩን እንደገና ያስነሱ። አዎ፣ መምከሩ አስቂኝ ቢሆንም፣ ኮምፒውተሩን እንደገና ያስነሱ፣ ምክንያቱም VPN ፕሮግራሞች ብዙ ጊዜ ይበላሻሉ እና TUN device-ን በhost ላይ በግማሽ-ሕያው ሁኔታ ሊተዉ ይችላሉ። ከreboot በኋላ VPN-ን አያስነሱ — መጀመሪያ AutoConnector-ን ይፈትሹ።

  5. እገዳዎችን ለማለፍ ይሞክሩ። የማብሪያ ቁልፉን በቅንብሮች ውስጥ ወይም በዋናው ማያ ገጽ ላይ ይፈልጉ (ከትልቁ ግራጫ/አረንጓዴ ክብ በስተቀኝ ያለውን ቁልፍ ይፈልጉ)። ~15 ደቂቃ ማሳለፍ ይኖርብዎታል። እነዚህ በ3 ቡድኖች ይከፈላሉ፦
	  - Proxying engine. ማንኛውንም Coalescing* ሁነታ ይሞክሩ። ምናልባት ወዲያውኑ ይሠራል። ነገር ግን በዚህ ምስሎች/ቪዲዮዎች በTelegram ውስጥ አይጫኑም (ይህ bug ሳይሆን feature/ስምምነት ነው)። ቀጥሎ Split* ሁነታዎችን ይሞክሩ፤ ከሠራ — ምስሎች ይጫናሉ። ወይም ወደ "off" ይመልሱት።
	  - "Parallel upstream race"-ን ይሞክሩ። ይህ ማለት Telegram ወደ proxy 1 connect ሲያደርግ፣ AutoConnector ወደ የተለያዩ MTProto proxy-ዎች 5-30 connect ያደርግና በጣም ጥሩውን ለTelegram ይሰጣል። በመተግበሪያ ቅንብሮች ውስጥ timeout (3-5 ሰከንድ) እና የትይዩ upstream ብዛት፣ እስከ 30 ድረስ መምረጥ ይችላሉ።
	  - "Auto-rotate anti-DPI tricks"-ን ያብሩ፣ እና ፕሮግራሙ በራሱ ይዞራቸዋል።
	  - Telegram በፍጥነት እንዲቀያየር፣ በproxy ቅንብሮች (በTelegram ውስጥ) በየ 5-10 ሰከንዱ በዙር ወደ ቀጣዩ port በእጅ ይቀያይሩ፦ 55001->55002->55001->...

6. በጣም ሀይለኛው/ፈጣኑ የቅንብሮች ጥምር፦
	- connect timeout 5s
	- host selection breadth 100%
	- 30 ትይዩ connect-ዎች
	- auto-rotate DPI tricks
	- parallel upstream race
	- proxying engine: Coalescing*
	- በTelegram ውስጥ፣ በproxy መስኮት ውስጥ፣ በየ 10 ሰከንዱ በዙር አዲስ port ይንኩ።

7. በWindows እና በAndroid ላይ ያለው የውቅረት ፖሊሲ የተለየ ነው! ከላይ የተጻፈው ሁሉ በብዛት Windows-ን ይመለከታል። በAndroid ላይ ለአብዛኞቹ ሰዎች ያለ ምንም ቅንብር (በማንኛውም ቅንብር) ይሠራል። Windows የተለየ TCP stack እና የተለየ Telegram መተግበሪያ አለው፣ ይህም ከAndroid በጥራት በጣም የከፋ ነው። ይፋዊውን ብቻ ሳይሆን ሌላ የTelegram client ይሞክሩ።

8. እባክዎ ዝርዝር የbug report በማንኛውም ቋንቋ በ https://t.me/AutoConnector_for_Telegram ይጻፉ — መድረክዎን፣ የትኞቹን ዘዴዎች እንደሞከሩ (ቅንብሮች)፣ firewall/antivirus ካለዎት፣ ከVPN/virtual machine እንደሞከሩ። እንዲሁም ማንኛውንም አወንታዊ የምግብ አሰራር ይጻፉ — ምን እንደሞከሩና እንዴት መሥራት እንደጀመረ።


## 📥 Download

ሁሉም build-ዎች በreleases ገጽ ላይ ናቸው፦ **[GitHub Releases (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

| OS | File | Run |
|----|------|--------|
| **Android** | `AutoConnector_for_Telegram.apk` | APK-ን ይጫኑ (ከGoogle Play ውጭ — ከምንጭ መጫንን ይፍቀዱ) |
| **Windows** 10/11 x64 | `AutoConnector-for-Telegram-windows-x64.zip` | ይክፈቱ → `AutoConnector\AutoConnector.exe` ያሂዱ |
| **Linux** x64 | `AutoConnector-for-Telegram-linux-x64.tar.gz` | ይክፈቱ → `./AutoConnector/bin/AutoConnector` |
| **macOS** 11+ (Apple Silicon) | `AutoConnector-for-Telegram-macos.tar.gz` | ይክፈቱ → `AutoConnector.app`-ን ሁለት ጊዜ ይጫኑ (ከታገደ — `xattr -dr com.apple.quarantine AutoConnector.app`) |

### 🔐 Authenticity (release 1.1.0)

APK-ሱ በrelease certificate ተፈርሟል (apksigner, schemes v1+v2+v3)። ከመጫንዎ በፊት ማረጋገጥ ይችላሉ፦

- **Signing certificate (SHA-256):** `cb23a18c0cf8a23e43b5b63d199fc1440d3e4d6533e1309d3f92f273fe626a5a`
  (CN=AutoConnector for Telegram) — ይህ fingerprint በሁሉም ወደፊት በሚወጡ release-ዎች ላይ ተመሳሳይ ነው።
- **APK SHA-256:** `d7652e7f5c3a2174a3b7805c2539df7da080765c9b0f581a7ac5943987c9b935`
- **Windows zip SHA-256:** `1d8d675936387e89038dc4943d7f99200c1b735b86e1f79bd953cd93e60f0217`
- **Linux tar.gz SHA-256:** `9160ea519309dc62750a4a930dc1aae6e20dbcefd21b426fa85b48ace6f3e8f8`
- **macOS tar.gz SHA-256:** `322082ef3f06955ed299be790bce453e47db37fca17daea54724d60698446bc7`

በሚከተለው ያረጋግጡ፦ `apksigner verify --print-certs AutoConnector_for_Telegram.apk` (certificate) እና
`sha256sum -c SHA256SUMS.txt` (የፋይል ትክክለኛነት፤ `SHA256SUMS.txt` ከrelease ጋር ተያይዟል)።

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

bug-ዎችንና አስተያየቶችን እዚህ ይላኩ - https://t.me/AutoConnector_for_Telegram

## 🔐 Signature verification

ከreleases የመጣው APK በrelease key ተፈርሟል። እንደሚከተለው ማረጋገጥ ይችላሉ፦

```bash
# Checksum (compare with SHA256SUMS.txt from the release)
sha256sum AutoConnector_for_Telegram.apk

# Digital signature and certificate fingerprint
apksigner verify --print-certs AutoConnector_for_Telegram.apk
```

ይፋዊ build-ዎችን ለመፈረም የተጠቀመበት የcertificate fingerprint (SHA-256)
በእያንዳንዱ release መግለጫ ውስጥ ይታተማል — APK አለመበረዙን ለማረጋገጥ
ያወዳድሩት።

## 📄 License

[MIT](LICENSE).
