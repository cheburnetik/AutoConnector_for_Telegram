[ENGLISH](README.en.md) · [AMHARIC](README.am.md) · [ARABIC](README.ar.md) · [AZERBAIJANI](README.az.md) · [BENGALI](README.bn.md) · [BURMESE](README.my.md) · [CHINESE](README.zh.md) · [DARI](README.prs.md) · [FRENCH](README.fr.md) · [GERMAN](README.de.md) · [HAUSA](README.ha.md) · [HINDI](README.hi.md) · [INDONESIAN](README.id.md) · [ITALIAN](README.it.md) · [JAPANESE](README.ja.md) · [KAZAKH](README.kk.md) · [KOREAN](README.ko.md) · [MARATHI](README.mr.md) · [PASHTO](README.ps.md) · [PERSIAN](README.fa.md) · [POLISH](README.pl.md) · [PORTUGUESE](README.pt.md) · [PUNJABI](README.pa.md) · [RUSSIAN](README.md) · [SPANISH](README.es.md) · [TAMIL](README.ta.md) · [TELUGU](README.te.md) · [THAI](README.th.md) · [TIGRINYA](README.ti.md) · [TURKISH](README.tr.md) · [UKRAINIAN](README.uk.md) · [URDU](README.ur.md) · [UZBEK](README.uz.md) · [VIETNAMESE](README.vi.md)

**[Download (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

# AutoConnector for Telegram

AutoConnector for Telegram — dastur internetda MTProto proxylarni o'zi topadi, ularning tirik ekanini tekshiradi va lokal relay (uzatgich) ko'taradi, u orqali Telegram bloklangan joylarda ham ishonchli ishlashda davom etadi. Foydalanuvchi ishlaydigan proxylarni qo'lda izlashi shart emas — AutoConnector for Telegram uzluksiz ravishda eng tez tiriklarini tanlaydi va ularni aynan sizning kompyuteringiz/telefoningizdan sinab ko'radi.

Boshqacha aytganda: bu — ommaviy bepul MTProto proxylar joylangan Telegram kanallari va har xil obunalarni skanerlovchi vosita bo'lib, ularni sizning Telegramingizga avtomatik kiritadi. Telegram klientini yangilash shart emas. Proxyning yetib borishi sizning o'z qurilmangiz va tarmoq muhitingizdan tekshiriladi. VPN'siz Wi-Fi + LTE ustida ishlaydi.

Platformalar: Android, Windows, Linux, MacBook.

Android versiyasi o'zicha ishlaydi, Windows'da esa sozlamalarda proxylash dvigatelini — "SPLIT..." yoki "COALESCING.." — yoqishingiz kerak, yoki "Telegram connected" so'zlari va katta kulrang/yashil doiraning o'ng tomonidagi tugma orqali. Yoki shaxsan o'zingiz uchun eng yaxshi ishlaydiganini tanlang, chunki bloklash hamma joyda har xil. "COALESCING.." rejimlari — oxirgi chora: Telegram ishlay boshlaydi, lekin chatlarda media-kontentni yuborish/ko'rsatish buziladi.

Agar COMODO kabi firewalldan foydalansangiz, uni o'chirishni tavsiya qilaman: u dasturni sandbox (qum quti)ga soladi va uning firewalli MTProto proxylariga chiquvchi ulanishlarni buzadi. Yoki dasturni virtual mashinada ishga tushiring — u yerda TCP-stek butunlay o'zgaradi va AutoConnector'ning xatti-harakati boshqacha bo'ladi.

Shuningdek, Telegramga 55001 va 55002 portlari o'rtasida qo'lda almashishga yordam bering (proxy sozlamalarida) — bu ishlaydigan proxyga tezroq yetib borish va Telegram ichida "Connected" yorlig'ini olishga yordam beradi.

# ✨ Imkoniyatlar

- **Avtomatik proxy qidiruvi** — o'nlab ochiq sahifalar va obunalarni skanerlaydi.
- **Tiriklik tekshiruvlari** — haqiqiy MTProto handshake, tezlik/barqarorlik bo'yicha baholanadi.
- **Lokal relay** — Telegram `127.0.0.1` manziliga ulanadi, AutoConnector for
  Telegram esa trafikni eng yaxshi tirik proxy orqali yo'naltiradi va joriy proxy
  ishdan chiqsa, boshqasiga o'tadi.
- **Anti-DPI** — niqoblash usullari to'plami (brauzerga taqlid qilish, paketlarni
  bo'lish, FakeTLS va h.k.); "Auto-rotate" rejimi ishlaydiganini o'zi tanlaydi.
- **Batafsil statistika** — tirik/o'lik proxylar, tezlik, kechikish, trafik,
  har bir anti-DPI usulining samaradorligi.
- **Proxy katalogi** — reyting bo'yicha eng yaxshilar, har bir host uchun batafsil karta:
  har bir host "Telegram ulanadi / muvaffaqiyatli / jami tekshiruvlar"ni va
  oxirgi 25 ta urinishni ko'rsatadi (TCP/TLS/jami ulanish davomiyligi, qabul qilingan/yuborilgan baytlar).
- **Hostlarni moslashuvchan tanlash** — "kenglik" slayderi: "faqat eng yaxshi
  isbotlangan hostlarga yopishish"dan tortib "tiriklar orasida imkon qadar keng sinab ko'rish"gacha;
  Telegram relay portlari o'rtasida sakraganda tanlov avtomatik kengayadi. Alohida slayder —
  ulanish taymauti (100 ms … 15 s) — va "upstream poygasi" (bir nechta parallel ulanishlar).
- **12 ta UI tili** avtomatik aniqlash va RTL qo'llab-quvvatlash bilan.

> ### 1.0.19 dan beri yangiliklar
> - **Tarmoq turi bo'yicha alohida host pullari va reytinglar** — VPN / Wi-Fi / LTE /
>   Ethernet / White: har bir ulanish turi o'zining tirik proxylar pulini saqlaydi, shuning uchun
>   Telegramga hech qachon faqat VPN ostida ishlaydigan narsa berilmaydi.
> - **Upstream poygasi** — bir nechta ulanish parallel, eng tez tirigi g'olib chiqadi;
>   "tanlov kengligi" slayderi (eng yaxshi isbotlangandan to imkon qadar kenggacha) va
>   Telegram relay portlari o'rtasida sakraganda pul avtomatik kengayadi;
>   sozlanadigan ulanish taymauti (100 ms…15 s).
> - **Batafsil kartali host katalogi** — "Telegram ulanadi / muvaffaqiyatli /
>   jami tekshiruvlar" hamda har bir host bo'yicha oxirgi 25 ta urinish (TCP/TLS vaqti,
>   ulanish davomiyligi, qabul qilingan/yuborilgan baytlar).
> - **Tezlik, ping va port faolligining jonli grafiklari** (soniyada va daqiqada)
>   hamda skan grafiklari.
> - **Anti-DPI va proxylash dvigatellari** — "Auto-rotate" rejimli niqoblash usullari
>   to'plami, obfuskatsiya dvigateli va aniq bir blokga moslash uchun eksperimental
>   dvigatellar (split/coalescing).
> - Sozlamalar, hostlar va obunalarni **eksport/import** qilish + to'liq zavod sozlamalariga qaytarish.
> - **Tez sovuq start** — bir nechta anonimayzer orqali agressiv ko'p oqimli obuna yuklab olish.
> - **26 ta UI tili** avtomatik aniqlash bilan (+RTL).

# Birinchi ishga tushirishda muhim:

- Telegramni qat'iy SOCKS5 proxy localhost:55001 va localhost:55002 bilan sozlang.
- Bulardan boshqa proxylarni o'chiring.
- Telegramda "Use proxy"ni yoqing.
- Android'da bildirishnomalarni bloklamang, aks holda u fonda ishlamaydi.
- Birinchi ishga tushirishda ~15 daqiqa kuting — u MTProto proxylarni yuklab olib, ular orasidan aylanib chiqarkan va Telegram klientining o'zi o'tib olarkan.

# Agar hech narsa ishlamasa

1. Agar HECH NARSA ishlamasa, dasturni tirik proxylarning avtomatik katalogi sifatida ishlating. CTRL+WIN+ALT+P va CTRL+SHIFT+ALT+P qaynoq tugmalari yordamida AutoConnector oynasini ochmasdan ham tasodifiy proxyni to'g'ridan-to'g'ri Telegramingizga tez qo'shishingiz mumkin. Natijada Telegram proxyga to'g'ridan-to'g'ri, AutoConnector'siz boradi, lekin bepul proxylar joylanadigan chatlarni kuzatib, ularni tekshirib vaqt sarflashingizga to'g'ri kelmaydi. AutoConnector treyda yashasin, "Connector" tumblerini o'chiring, "Scan" tumblerini yoqiq qoldiring.

2. AutoConnector'ni boshqa qurilmada sinab ko'ring: telefoningizda, do'stingizning telefonida, kompyuterda. Bloklarni chetlab o'tish printsipi Windows/Android platformalarida butunlay boshqacha. Ehtimol, Android'da u hech qanday sozlamalarsiz ishlaydi.

3. Agar hech narsa ishlamasa, bir kunga VPN'ni vaqtincha yoqib qo'ying va o'sha kun davomida AutoConnector + Telegramni sinab ko'ring (Telegramni AutoConnector orqali ulang, 55001 va 55002 portlaridagi proxylarni ko'rsatib). Dastur ichida "When VPN is on -> proxy to MTProto" katagiga belgi qo'ying. AutoConnector ishlay boshladimi, ko'ring. Agar ha bo'lsa, xulosa aniq — AutoConnector proxylarni muvaffaqiyatli topadi va Telegram trafigini u yerga muvaffaqiyatli uzatadi, lekin VPN'ni o'chirsangiz, mamlakatingizdagi bloklash tizimi barcha chiquvchi ulanishlarni juda qattiq bloklaydi. Bunday holatda bloklarni chetlab o'tadigan ishlaydigan vositani tanlash uchun AutoConnector'dagi vositalarni yarim soat aylantirib chiqishga to'g'ri keladi. Dastur hozircha barcha variantlarni avtomatik aylantirib chiqa olmaydi (faqat anti-DPI usullarining avto-rotatsiyasi bor). Tajribadan so'ng VPN'ni o'chiring va "When VPN is on, proxy to MTProto" katagini "Proxy directly" holatiga qaytaring.

4. (3)-bandga muqobil. Windows/Linux hostingizga virtual mashina o'rnating. Uning ichida Telegram + AutoConnector'ni ishga tushiring. VPN'siz ham mukammal ishlay boshladimi? Demak, sizning ulanishlaringizni mamlakatingizdagi bloklash tizimi emas, balki hostingiz buzayotgan ekan! Sabablari: firewall'lar, antiviruslar, VPN'dan qolgan qoldiqlar. Agar antivirus AutoConnector'ni sandboxga solsa, yoki firewall AutoConnector'ning g'ayrioddiy anti-DPI usullarini bloklasa, AutoConnector'ni hostda antivirus va firewall'ni chetlab o'tib ishga tushirishga to'g'ri keladi (istisnolar). Yoki ularni bir muddatga butunlay o'chirib, kompyuterni qayta yuklang. Ha, maslahat berish kulgili bo'lsa-da, kompyuterni qayta yuklang, chunki VPN dasturlari ko'pincha xato beradi va hostda TUN qurilmasini yarim tirik holatda qoldirishi mumkin. Qayta yuklashdan so'ng VPN'ni ishga tushirmang — avval AutoConnector'ni sinab ko'ring.

  5. Bloklarni chetlab o'tishga harakat qiling. Yoqish tugmasini sozlamalarda yoki asosiy ekranda qidiring (katta kulrang/yashil doiraning o'ng tomonidagi tugmani qidiring). ~15 daqiqa sarflashingizga to'g'ri keladi. Ular 3 guruhdan iborat:
	  - Proxylash dvigateli. Istalgan Coalescing* rejimini sinab ko'ring. Ehtimol darrov ishlaydi. Lekin u bilan Telegramda rasmlar/videolar yuklanmaydi (bu xato emas, balki feature/savdo-sotiq). Keyin Split* rejimlarini sinab ko'ring; agar ishlasa — rasmlar yuklanadi. Yoki uni "off" holatiga qaytaring.
	  - "Parallel upstream race"ni sinab ko'ring. Bu shuni anglatadiki, Telegram proxyga 1 ta ulanish qilganda, AutoConnector turli MTProto proxylarga 5-30 ta ulanish qiladi va Telegramga eng yaxshisini beradi. Dastur sozlamalarida taymautlar (3-5 soniya) va parallel upstreamlar sonini, 30 tagacha tanlashingiz mumkin.
	  - "Auto-rotate anti-DPI tricks"ni yoqing, dastur ularni o'zi aylantirib chiqadi.
	  - Telegram tezroq o'tib olishi uchun proxy sozlamalarida (Telegramda) har 5-10 soniyada keyingi portga halqa bo'yicha qo'lda almashing: 55001->55002->55001->...

6. Sozlamalarning eng kuchli/tez kombinatsiyasi:
	- ulanish taymauti 5s
	- host tanlash kengligi 100%
	- 30 ta parallel ulanish
	- anti-DPI usullarini avto-rotatsiya
	- parallel upstream race
	- proxylash dvigateli: Coalescing*
	- Telegram ichida, proxy oynasida har 10 soniyada yangi portga, halqa bo'yicha bosing.

7. Windows va Android'dagi konfiguratsiya siyosati har xil! Yuqorida yozilganlarning hammasi asosan Windows'ga taalluqli. Android'da u ko'pchilik uchun hech qanday sozlamalarsiz (har qanday sozlamalar bilan) ishlaydi. Windows'da boshqacha TCP-stek va boshqacha Telegram dasturi bor, u sifat jihatidan Android'dan ancha yomon. Faqat rasmiy emas, balki boshqa bir Telegram klientini sinab ko'ring.

8. Iltimos, batafsil xato hisobotlarini istalgan tilda https://t.me/AutoConnector_for_Telegram manziliga yozing — platformangiz, qaysi usullarni sinaganingiz (sozlamalar), firewall/antivirusingiz bor-yo'qligi, VPN/virtual mashinadan sinab ko'rganingiz yoki yo'qligi. Shuningdek, har qanday ijobiy retseptlarni yozing — nimani sinab ko'rdingiz va u qanday ishlay boshladi.


## 📥 Yuklab olish

Barcha buildlar relizlar sahifasida: **[GitHub Releases (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

| OS | Fayl | Ishga tushirish |
|----|------|--------|
| **Android** | `AutoConnector_for_Telegram.apk` | APK'ni o'rnating (Google Play'dan tashqari — manbadan o'rnatishga ruxsat bering) |
| **Windows** 10/11 x64 | `AutoConnector-for-Telegram-windows-x64.zip` | chiqaring → `AutoConnector\AutoConnector.exe`ni ishga tushiring |
| **Linux** x64 | `AutoConnector-for-Telegram-linux-x64.tar.gz` | chiqaring → `./AutoConnector/bin/AutoConnector` |
| **macOS** 11+ (Apple Silicon) | `AutoConnector-for-Telegram-macos.tar.gz` | chiqaring → `AutoConnector.app`ni ikki marta bosing (agar bloklansa — `xattr -dr com.apple.quarantine AutoConnector.app`) |

### 🔐 Haqiqiylik (reliz 1.1.0)

APK reliz sertifikati bilan imzolangan (apksigner, sxemalar v1+v2+v3). O'rnatishdan oldin tekshirishingiz mumkin:

- **Imzolovchi sertifikat (SHA-256):** `cb23a18c0cf8a23e43b5b63d199fc1440d3e4d6533e1309d3f92f273fe626a5a`
  (CN=AutoConnector for Telegram) — bu barmoq izi barcha kelajakdagi relizlarda bir xil.
- **APK SHA-256:** `d7652e7f5c3a2174a3b7805c2539df7da080765c9b0f581a7ac5943987c9b935`
- **Windows zip SHA-256:** `1d8d675936387e89038dc4943d7f99200c1b735b86e1f79bd953cd93e60f0217`
- **Linux tar.gz SHA-256:** `9160ea519309dc62750a4a930dc1aae6e20dbcefd21b426fa85b48ace6f3e8f8`
- **macOS tar.gz SHA-256:** `322082ef3f06955ed299be790bce453e47db37fca17daea54724d60698446bc7`

Tekshirish uchun: `apksigner verify --print-certs AutoConnector_for_Telegram.apk` (sertifikat) va
`sha256sum -c SHA256SUMS.txt` (fayl yaxlitligi; `SHA256SUMS.txt` relizga biriktirilgan).

## 📸 Skrinshotlar

<table>
<tr>
<td align="center"><img src="docs/screenshots/connector.png" width="200"><br><sub>Connector — faol sessiya</sub></td>
<td align="center"><img src="docs/screenshots/scan.png" width="200"><br><sub>Skan va grafiklar</sub></td>
<td align="center"><img src="docs/screenshots/catalog.png" width="200"><br><sub>Proxy katalogi (rejim bo'yicha)</sub></td>
<td align="center"><img src="docs/screenshots/host-card.png" width="200"><br><sub>Host kartasi + tarix</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/logs.png" width="200"><br><sub>Relay loglari</sub></td>
<td align="center"><img src="docs/screenshots/settings.png" width="200"><br><sub>Sozlamalar</sub></td>
<td align="center"><img src="docs/screenshots/export.png" width="200"><br><sub>tg:// havolalarini eksport qilish</sub></td>
<td align="center"><img src="docs/screenshots/hotkeys.png" width="200"><br><sub>Qaynoq tugmalar</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/guide.png" width="200"><br><sub>Ulanish bo'yicha qo'llanma</sub></td>
<td align="center"><img src="docs/screenshots/connector-ru.png" width="200"><br><sub>Connector · Ruscha UI</sub></td>
<td align="center"><img src="docs/screenshots/scan-ru.png" width="200"><br><sub>Skan · Ruscha UI</sub></td>
<td align="center"><sub>26 ta UI tili<br>avtomatik aniqlash bilan</sub></td>
</tr>
</table>


## Fikr-mulohaza

Xatolar va izohlarni shu yerga yuboring - https://t.me/AutoConnector_for_Telegram

## 🔐 Imzoni tekshirish

Relizlardagi APK reliz kaliti bilan imzolangan. Uni shunday tekshirishingiz mumkin:

```bash
# Checksum (compare with SHA256SUMS.txt from the release)
sha256sum AutoConnector_for_Telegram.apk

# Digital signature and certificate fingerprint
apksigner verify --print-certs AutoConnector_for_Telegram.apk
```

Rasmiy buildlarni imzolash uchun ishlatilgan sertifikat barmoq izi (SHA-256)
har bir relizning tavsifida e'lon qilingan — APK buzilmaganiga ishonch hosil qilish
uchun uni solishtiring.

## 📄 Litsenziya

[MIT](LICENSE).
