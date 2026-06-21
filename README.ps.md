[ENGLISH](README.en.md) · [AMHARIC](README.am.md) · [ARABIC](README.ar.md) · [AZERBAIJANI](README.az.md) · [BENGALI](README.bn.md) · [BURMESE](README.my.md) · [CHINESE](README.zh.md) · [DARI](README.prs.md) · [FRENCH](README.fr.md) · [GERMAN](README.de.md) · [HAUSA](README.ha.md) · [HINDI](README.hi.md) · [INDONESIAN](README.id.md) · [ITALIAN](README.it.md) · [JAPANESE](README.ja.md) · [KAZAKH](README.kk.md) · [KOREAN](README.ko.md) · [MARATHI](README.mr.md) · [PASHTO](README.ps.md) · [PERSIAN](README.fa.md) · [POLISH](README.pl.md) · [PORTUGUESE](README.pt.md) · [PUNJABI](README.pa.md) · [RUSSIAN](README.md) · [SPANISH](README.es.md) · [TAMIL](README.ta.md) · [TELUGU](README.te.md) · [THAI](README.th.md) · [TIGRINYA](README.ti.md) · [TURKISH](README.tr.md) · [UKRAINIAN](README.uk.md) · [URDU](README.ur.md) · [UZBEK](README.uz.md) · [VIETNAMESE](README.vi.md)

**[ډاونلوډ (وروستی)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

# AutoConnector for Telegram

AutoConnector for Telegram — اپ پخپله په انټرنیټ کې د MTProto proxy لټوي، ګوري چې ژوندي وي، او یو ځایی relay پورته کوي چې له لارې یې Telegram حتی هلته هم په ډاډمنه توګه کار کوي چیرته چې بند وي. کاروونکی اړ نه دی چې په لاسي ډول د کارکوونکو proxy پسې وګرځي — AutoConnector for Telegram په دوامداره توګه تر ټولو چټک او ژوندي غوره کوي او په ځانګړي ډول یې ستاسو له کمپیوټر/تلیفون څخه ازمویي.

په بل عبارت: دا د Telegram چینلونو او هر ډول subscription لپاره یو سکینر دی چې عامه وړیا MTProto proxy لري، او په اوتومات ډول یې ستاسو Telegram ته ننباسي. د Telegram client اپډیټ کولو ته اړتیا نشته. د proxy رسېدنه ستاسو له خپله وسیلې او شبکې چاپیریال څخه چک کیږي. پرته له VPN، په Wi-Fi + LTE کې کار کوي.

پلیټفارمونه: Android، Windows، Linux، MacBook.

د Android نسخه پخپله کار کوي، خو په Windows کې اړتیا ده چې په تنظیماتو کې د proxy کولو انجن — "SPLIT..." یا "COALESCING.." — فعال کړئ، یا د "Telegram connected" کلماتو او لوی خړ/شین دایره څخه ښي خوا د تڼۍ له لارې. یا هغه غوره کړئ چې ستاسو لپاره په شخصي توګه ښه کار کوي، ځکه چې بندیزونه په هر ځای کې توپیر لري. د "COALESCING.." حالتونه وروستۍ چاره ده — Telegram به کار پیل کړي، خو په چټونو کې د media منځپانګې لیږل/ښودل به خراب شي.

سپارښتنه کوم چې که د COMODO په څیر firewall کاروئ، هغه بند کړئ: دا اپ په یوه sandbox کې اچوي، او د هغه firewall د MTProto proxy ته د وتلو اړیکې خرابوي. یا اپ په یوه virtual machine کې پرانیزئ — هلته د TCP stack بشپړ بدلیږي، او د AutoConnector چلند به بل ډول وي.

همدارنګه، Telegram سره مرسته وکړئ چې د 55001 او 55002 portونو ترمنځ په لاس واوړي (د proxy په تنظیماتو کې) ترڅو ژر یو کارکوونکي proxy ته ورسیږي او د Telegram دننه د "Connected" نښه ترلاسه کړي.

# ✨ ځانګړتیاوې

- **اوتومات د proxy لټون** — د لسګونو پرانیستو پاڼو او subscriptionونو سکین کوي.
- **د ژوندي والي چکونه** — یو ریښتینی MTProto handshake، چې د سرعت/ثبات له مخې درجه بندي کیږي.
- **ځایی relay** — Telegram `127.0.0.1` سره وصل کیږي، او AutoConnector for
  Telegram ترافیک د تر ټولو ښه ژوندي proxy له لارې لیږي او که اوسنی له کاره ولویږي
  بل ته اوړي.
- **Anti-DPI** — د پټولو ترفندونو یوه ټولګه (د browser نقل، د packet
  وېشنه، FakeTLS، او نور)؛ د "Auto-rotate" حالت پخپله یو کارکوونکی غوره کوي.
- **تفصيلي احصايې** — ژوندي/مړه proxy، سرعت، تاخیر، ترافیک،
  د هر anti-DPI ترفند اغېزمنتیا.
- **د proxy کتلاګ** — د درجې له مخې غوره، د هر host لپاره تفصيلي کارت سره:
  هر host "Telegram وصلیږي / بریالي / ټول چکونه" او
  وروستۍ 25 هڅې ښيي (TCP/TLS/ټول د وصل وخت، ترلاسه شوي/لیږل شوي bytes).
- **د host د انعطاف وړ غوراوی** — د "پراخوالي" یو slider: له "تر ټولو ثابت شوي
  hostونو سره پاتې شه" نه تر "د ژوندیو ترمنځ تر هغه ځایه چې ممکن وي پراخه هڅه وکړه"؛ کله چې Telegram د
  relay portونو ترمنځ ولاړ شي، غوراوی پخپله پراخیږي. یو جلا slider — د
  وصل timeout (100 ms … 15 s) — او یو "upstream race" (څو موازي وصلونه).
- **12 د UI ژبې** د اوتومات کشف او RTL ملاتړ سره.

> ### له 1.0.19 وروسته نوي څه دي
> - **د هر شبکې ډول لپاره جلا د host حوضونه او درجې** — VPN / Wi-Fi / LTE /
>   Ethernet / White: د هر وصل ډول خپل د ژوندیو proxy حوض ساتي، نو
>   Telegram ته هیڅکله داسې شی نه ورکول کیږي چې یوازې د VPN لاندې کار کوي.
> - **Upstream race** — څو وصلونه په موازي ډول، تر ټولو چټک ژوندی ګټونکی دی؛
>   د "د غوراوي پراخوالی" یو slider (له تر ټولو ثابت نه تر تر څومره چې ممکن پراخه) چې
>   کله Telegram د relay portونو ترمنځ ولاړ شي حوض پخپله پراخیږي؛
>   د تنظیم وړ د وصل timeout (100 ms…15 s).
> - **د host کتلاګ تفصيلي کارت سره** — "Telegram وصلیږي / بریالي /
>   ټول چکونه" په علاوه د هر host لپاره وروستۍ 25 هڅې (د TCP/TLS وخت،
>   د وصل موده، ترلاسه شوي/لیږل شوي bytes).
> - **ژوندي ګرافونه** د سرعت، ping او د port فعالیت (په هره ثانیه او هره دقیقه کې)
>   په علاوه د سکین ګرافونه.
> - **Anti-DPI او د proxy کولو انجنونه** — د پټولو ترفندونو یوه ټولګه د
>   "Auto-rotate" حالت سره، د obfuscation انجن، او تجربوي انجنونه (split/
>   coalescing) چې له یوه ځانګړي بندیز سره برابر شي.
> - **د تنظیماتو، hostونو او subscriptionونو ساتنه/راوړل** + بشپړ factory reset.
> - **چټک سوړ پیل** — د څو anonymizer له لارې د subscription د جاهلانه څو-threaded ډاونلوډ.
> - **26 د UI ژبې** د اوتومات کشف سره (+RTL).

# په لومړي ځل پرانیستلو کې مهم:

- Telegram د یوه ثابت SOCKS5 proxy localhost:55001 او localhost:55002 سره تنظیم کړئ.
- له دې پرته نور proxyونه پاک کړئ.
- په Telegram کې "Use proxy" فعال کړئ.
- په Android کې اطلاعات (notifications) مه بندوئ، که نه نو په شالید کې به نه ځغلي.
- په لومړي پرانیستلو کې ~15 دقیقې انتظار وکړئ ترڅو دا د MTProto proxy ډاونلوډ او پرې وګرځي او ترڅو پخپله د Telegram client واوړي.

# که هیڅ کار ونکړي

1. که هیڅ کار ونکړي، پروګرام د ژوندیو proxy د اوتومات کتلاګ په توګه وکاروئ. د CTRL+WIN+ALT+P او CTRL+SHIFT+ALT+P میانبرونو (hotkeys) سره تاسو کولی شئ په چټکۍ سره یو ناڅاپي proxy مستقیم خپل Telegram ته اضافه کړئ، حتی پرته له دې چې د AutoConnector کړکۍ پرانیزئ. پایله دا ده چې Telegram مستقیم proxy ته ځي، پرته له AutoConnector، خو تاسو به اړ نه یاست هغه چټونه وڅارئ چیرته چې وړیا proxy خپریږي او د دوی په چک کولو کې وخت ضایع کړئ. پرېږدئ چې AutoConnector په tray کې واوسي، د "Connector" تڼۍ بنده کړئ، د "Scan" تڼۍ پرانیستې پرېږدئ.

2. AutoConnector په بله وسیله وازمویئ: خپل تلیفون، د یوه ملګري تلیفون، یو کمپیوټر. د بندیزونو د تېرولو اصول د Windows/Android پلیټفارمونو ترمنځ بشپړ توپیر لري. ډېر احتمال شته چې په Android کې به پرته له هر ډول تنظیماتو کار وکړي.

3. که هیڅ کار ونکړي، نو د یوې ورځې لپاره موقتاً VPN فعال کړئ او په هغه ورځ کې AutoConnector + Telegram وازمویئ (Telegram د AutoConnector له لارې وصل کړئ، په 55001 او 55002 portونو کې proxy ټاکلو سره). د پروګرام دننه، د "When VPN is on -> proxy to MTProto" بکس نښه کړئ. وګورئ چې AutoConnector کار پیل کړ که نه. که هو، نو پایله څرګنده ده — AutoConnector په بریالیتوب سره proxy مومي او د Telegram ترافیک هلته په بریالیتوب سره relay کوي، خو که VPN بند کړئ، ستاسو په هیواد کې د بندیز سیسټم ټول وتلونکي اړیکې هم ډېر سختۍ سره بندوي. په دې حالت کې به مجبور شئ چې نیم ساعت په AutoConnector کې پر وسیلو وګرځئ ترڅو یو کارکوونکی غوره کړئ چې له بندیزونو تېرېدلی شي. پروګرام لا تر اوسه نشي کولی په اوتومات ډول ټول اختیارونه وڅیړي (یوازې د anti-DPI ترفندونو اوتومات-rotation شته). د تجربې وروسته، VPN بند کړئ او د "When VPN is on, proxy to MTProto" بکس بیرته "Proxy directly" حالت ته راوګرځوئ.

4. د (3) بدیل. په خپل Windows/Linux host کې یو virtual machine نصب کړئ. د هغه دننه Telegram + AutoConnector پرانیزئ. ایا حتی پرته له VPN هم بشپړ کار پیل کړ؟ دا پدې مانا ده چې ستاسو host ستاسو اړیکې خرابوي، نه ستاسو په هیواد کې د بندیز سیسټم! لاملونه: firewallونه، antivirusونه، د VPN پاتې شوني. که antivirus AutoConnector یوه sandbox ته واچوي، یا firewall د AutoConnector غیرعادي anti-DPI ترفندونه بند کړي، نو تاسو به اړ شئ چې AutoConnector په host کې د antivirus او firewall له شاوخوا تېرولو سره وچلوئ (استثناوې). یا یې د یوې مودې لپاره بشپړ بند کړئ او کمپیوټر بیا پیل کړئ. هو، که څه هم خندني ده چې مشوره ورکړل شي، کمپیوټر بیا پیل کړئ، ځکه چې د VPN پروګرامونه ډېر وخت ګډوډي کوي او کولی شي په host کې یو TUN وسیله په نیم-ژوندي حالت کې پرېږدي. له بیا پیل وروسته، VPN مه پیلوئ — لومړی AutoConnector وازمویئ.

  5. هڅه وکړئ چې بندیزونه تېر کړئ. د فعالولو تڼۍ په تنظیماتو کې یا په اصلي پرده کې ولټوئ (هغه تڼۍ ولټوئ چې د لوی خړ/شین دایرې ښي خوا کې ده). تاسو به ~15 دقیقې وخت مصرف کړئ. دوی له 3 ډلو څخه جوړ دي:
	  - د proxy کولو انجن. هر Coalescing* حالت وازمویئ. ډېر احتمال شته چې سمدستي به کار وکړي. خو په Telegram کې به انځورونه/ویډیوګانې ورسره نه پورته کیږي (دا یو bug نه دی، بلکې یوه ځانګړتیا/تبادله ده). بیا، Split* حالتونه وازمویئ؛ که کار وکړي — انځورونه پورته کیږي. یا یې بیرته "off" ته راوګرځوئ.
	  - "Parallel upstream race" وازمویئ. دا پدې مانا ده چې کله Telegram یو proxy ته 1 وصل کوي، AutoConnector مختلفو MTProto proxy ته 5-30 وصلونه کوي او تر ټولو ښه یې Telegram ته ورکوي. د اپ په تنظیماتو کې تاسو کولی شئ timeoutونه (3-5 ثانیې) او د موازي upstreamونو شمیر، تر 30 پورې، وټاکئ.
	  - "Auto-rotate anti-DPI tricks" فعال کړئ، او پروګرام به پخپله پرې وګرځي.
	  - د دې لپاره چې Telegram ژر واوړي، د proxy په تنظیماتو کې (په Telegram کې) هر 5-10 ثانیې وروسته په لاسي ډول بل port ته په لوپ کې واوړئ: 55001->55002->55001->...

6. د تنظیماتو تر ټولو پیاوړی/چټک ترکیب:
	- د وصل timeout 5s
	- د host د غوراوي پراخوالی 100%
	- 30 موازي وصلونه
	- auto-rotate DPI ترفندونه
	- parallel upstream race
	- د proxy کولو انجن: Coalescing*
	- د Telegram دننه، د proxy په کړکۍ کې، هر 10 ثانیې یو نوی port ووهئ، په لوپ کې.

7. په Windows او Android کې د تنظیماتو پالیسي توپیر لري! هر څه چې پورته لیکل شوي ډېری یې د Windows پورې اړه لري. په Android کې د ډېری خلکو لپاره پرته له هر ډول تنظیماتو کار کوي (د هر ډول تنظیماتو سره). Windows یو بل TCP stack او یو بل د Telegram اپ لري، چې له Android څخه په کیفیت کې ډېر بدتر دی. کوم بل د Telegram client وازمویئ، نه یوازې رسمي.

8. مهرباني وکړئ تفصيلي د bug راپورونه په هره ژبه دلته ولیکئ https://t.me/AutoConnector_for_Telegram — ستاسو پلیټفارم، کوم میتودونه چې مو ازمویلي (تنظیمات)، ایا تاسو firewall/antivirus لرئ، ایا تاسو له VPN/virtual machine څخه ازمویلي. همدارنګه هر مثبت ترکیب ولیکئ — څه مو ازمویل او څنګه یې کار پیل کړ.


## 📥 ډاونلوډ

ټول buildونه د releases پاڼه کې دي: **[GitHub Releases (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

| OS | فایل | چلول |
|----|------|--------|
| **Android** | `AutoConnector_for_Telegram.apk` | APK نصب کړئ (له Google Play بهر — له سرچینې نصب ته اجازه ورکړئ) |
| **Windows** 10/11 x64 | `AutoConnector-for-Telegram-windows-x64.zip` | استخراج → `AutoConnector\AutoConnector.exe` وچلوئ |
| **Linux** x64 | `AutoConnector-for-Telegram-linux-x64.tar.gz` | استخراج → `./AutoConnector/bin/AutoConnector` |
| **macOS** 11+ (Apple Silicon) | `AutoConnector-for-Telegram-macos.tar.gz` | استخراج → دوه ځله `AutoConnector.app` کلیک کړئ (که بند وي — `xattr -dr com.apple.quarantine AutoConnector.app`) |

### 🔐 اصلیت (release 1.1.0)

APK د یوه release سند (apksigner، schemes v1+v2+v3) سره لاسلیک شوی. له نصبولو وړاندې تاسو کولی شئ تایید کړئ:

- **د لاسلیک سند (SHA-256):** `cb23a18c0cf8a23e43b5b63d199fc1440d3e4d6533e1309d3f92f273fe626a5a`
  (CN=AutoConnector for Telegram) — دا د ګوتو نښه د ټولو راتلونکو releaseونو په اوږدو کې یو شان ده.
- **APK SHA-256:** `d7652e7f5c3a2174a3b7805c2539df7da080765c9b0f581a7ac5943987c9b935`
- **Windows zip SHA-256:** `1d8d675936387e89038dc4943d7f99200c1b735b86e1f79bd953cd93e60f0217`
- **Linux tar.gz SHA-256:** `9160ea519309dc62750a4a930dc1aae6e20dbcefd21b426fa85b48ace6f3e8f8`
- **macOS tar.gz SHA-256:** `322082ef3f06955ed299be790bce453e47db37fca17daea54724d60698446bc7`

تایید یې وکړئ په: `apksigner verify --print-certs AutoConnector_for_Telegram.apk` (سند) او
`sha256sum -c SHA256SUMS.txt` (د فایل بشپړتیا؛ `SHA256SUMS.txt` د release سره ضمیمه دی).

## 📸 سکرین شاټونه

<table>
<tr>
<td align="center"><img src="docs/screenshots/connector.png" width="200"><br><sub>Connector — فعاله ناسته</sub></td>
<td align="center"><img src="docs/screenshots/scan.png" width="200"><br><sub>سکین او ګرافونه</sub></td>
<td align="center"><img src="docs/screenshots/catalog.png" width="200"><br><sub>د proxy کتلاګ (د حالت له مخې)</sub></td>
<td align="center"><img src="docs/screenshots/host-card.png" width="200"><br><sub>د host کارت + تاریخچه</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/logs.png" width="200"><br><sub>د relay logونه</sub></td>
<td align="center"><img src="docs/screenshots/settings.png" width="200"><br><sub>تنظیمات</sub></td>
<td align="center"><img src="docs/screenshots/export.png" width="200"><br><sub>د tg:// لینکونو صادرول</sub></td>
<td align="center"><img src="docs/screenshots/hotkeys.png" width="200"><br><sub>میانبرونه (Hotkeys)</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/guide.png" width="200"><br><sub>د وصل لارښود</sub></td>
<td align="center"><img src="docs/screenshots/connector-ru.png" width="200"><br><sub>Connector · روسي UI</sub></td>
<td align="center"><img src="docs/screenshots/scan-ru.png" width="200"><br><sub>سکین · روسي UI</sub></td>
<td align="center"><sub>26 د UI ژبې<br>د اوتومات کشف سره</sub></td>
</tr>
</table>


## نظرونه

bugونه او نظرونه دلته واستوئ - https://t.me/AutoConnector_for_Telegram

## 🔐 د لاسلیک تایید

له releases څخه APK د یوه release کیلي سره لاسلیک شوی. تاسو کولی شئ په دې ډول یې تایید کړئ:

```bash
# Checksum (compare with SHA256SUMS.txt from the release)
sha256sum AutoConnector_for_Telegram.apk

# Digital signature and certificate fingerprint
apksigner verify --print-certs AutoConnector_for_Telegram.apk
```

د سند د ګوتو نښه (SHA-256) چې د رسمي buildونو لاسلیک لپاره کارول کیږي د
هر release په تشریح کې خپره شوې — له هغه سره یې پرتله کړئ ترڅو ډاډ ترلاسه کړئ چې APK
بدلون نه دی موندلی.

## 📄 جواز (License)

[MIT](LICENSE).
