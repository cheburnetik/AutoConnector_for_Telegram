[ENGLISH](README.en.md) · [AMHARIC](README.am.md) · [ARABIC](README.ar.md) · [AZERBAIJANI](README.az.md) · [BENGALI](README.bn.md) · [BURMESE](README.my.md) · [CHINESE](README.zh.md) · [DARI](README.prs.md) · [FRENCH](README.fr.md) · [GERMAN](README.de.md) · [HAUSA](README.ha.md) · [HINDI](README.hi.md) · [INDONESIAN](README.id.md) · [ITALIAN](README.it.md) · [JAPANESE](README.ja.md) · [KAZAKH](README.kk.md) · [KOREAN](README.ko.md) · [MARATHI](README.mr.md) · [PASHTO](README.ps.md) · [PERSIAN](README.fa.md) · [POLISH](README.pl.md) · [PORTUGUESE](README.pt.md) · [PUNJABI](README.pa.md) · [RUSSIAN](README.md) · [SPANISH](README.es.md) · [TAMIL](README.ta.md) · [TELUGU](README.te.md) · [THAI](README.th.md) · [TIGRINYA](README.ti.md) · [TURKISH](README.tr.md) · [UKRAINIAN](README.uk.md) · [URDU](README.ur.md) · [UZBEK](README.uz.md) · [VIETNAMESE](README.vi.md)

**[Download (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

# AutoConnector for Telegram

AutoConnector for Telegram — tətbiq internetdə MTProto proxy-ləri özü tapır, onların canlı olduğunu yoxlayır və yerli relay qaldırır; bu relay sayəsində Telegram, hətta bloklandığı yerlərdə belə etibarlı şəkildə işləməyə davam edir. İstifadəçinin işlək proxy-ləri əl ilə axtarmasına ehtiyac yoxdur — AutoConnector for Telegram fasiləsiz olaraq ən sürətli canlı proxy-ləri seçir və onları məhz sizin kompüterinizdən/telefonunuzdan yoxlayır.

Başqa sözlə: bu, ictimai pulsuz MTProto proxy-lərin paylaşıldığı Telegram kanallarının və hər cür abunəliklərin skanneridir; tapılanlar avtomatik olaraq sizin Telegram-a əlavə olunur. Telegram klientini yeniləməyə ehtiyac yoxdur. Proxy-nin əlçatanlığı məhz sizin cihazınızdan və şəbəkə mühitinizdən yoxlanılır. VPN olmadan Wi-Fi + LTE üzərində işləyir.

Platformalar: Android, Windows, Linux, MacBook.

Android versiyası özü-özlüyündə işləyir, Windows-da isə tənzimləmələrdə proxy mühərrikini — "SPLIT..." və ya "COALESCING.." — aktiv etmək lazımdır; bunu "Telegram connected" sözlərinin və böyük boz/yaşıl dairənin sağındakı düymə vasitəsilə də etmək olar. Yaxud şəxsən sizin üçün ən yaxşı işləyəni seçin, çünki bloklama hər yerdə fərqlidir. "COALESCING.." rejimləri son çarədir — Telegram işləməyə başlayacaq, lakin söhbətlərdə media kontentin göndərilməsi/göstərilməsi pozulacaq.

COMODO kimi bir firewall istifadə edirsinizsə, onu söndürməyi tövsiyə edirəm: o, tətbiqi sandbox-a salır və onun firewall-u MTProto proxy-lərə gedən çıxış bağlantılarını korlayır. Yaxud tətbiqi virtual maşında işlədin — orada TCP stek tamamilə dəyişir və AutoConnector-un davranışı fərqli olacaq.

Həmçinin, işlək proxy-yə daha tez çatmaq və Telegram daxilində "Connected" yazısını almaq üçün Telegram-a 55001 və 55002 portları arasında əl ilə (proxy tənzimləmələrində) keçid etməyə kömək edin.

# ✨ İmkanlar

- **Avtomatik proxy axtarışı** — onlarla açıq səhifəni və abunəliyi skan edir.
- **Canlılıq yoxlamaları** — real MTProto handshake, sürət/sabitliyə görə qiymətləndirilir.
- **Yerli relay** — Telegram `127.0.0.1`-ə qoşulur, AutoConnector for
  Telegram isə trafiki ən yaxşı canlı proxy üzərindən yönləndirir və
  cari proxy düşərsə, başqasına keçir.
- **Anti-DPI** — maskalama üsulları dəsti (brauzer təqlidi, paket
  bölünməsi, FakeTLS və s.); "Auto-rotate" rejimi işləyən üsulu özü seçir.
- **Ətraflı statistika** — canlı/ölü proxy-lər, sürət, gecikmə, trafik,
  hər anti-DPI üsulunun effektivliyi.
- **Proxy kataloqu** — reytinqə görə ilk sıralar, hər host üçün ətraflı kart:
  hər host "Telegram qoşulur / uğurlu / ümumi yoxlama" göstərir, eləcə də
  son 25 cəhdi (TCP/TLS/ümumi qoşulma müddəti, alınan/göndərilən baytlar).
- **Elastik host seçimi** — "geniş­lik" sürgüsü: "yalnız ən sınanmış ən
  yaxşı host-lara sadiq qal"-dan tutmuş "canlılar arasında mümkün qədər geniş
  yoxla"-yadək; Telegram relay portları arasında atılıb-düşəndə seçim
  avtomatik genişlənir. Ayrıca bir sürgü — qoşulma timeout-u (100 ms … 15 s) —
  və "upstream race" (bir neçə paralel qoşulma).
- **12 interfeys dili** avtomatik aşkarlama və RTL dəstəyi ilə.

> ### 1.0.19-dan bəri yeniliklər
> - **Şəbəkə tipinə görə ayrıca host hovuzları və reytinqlər** — VPN / Wi-Fi / LTE /
>   Ethernet / White: hər bağlantı tipi öz canlı proxy hovuzunu saxlayır, beləcə
>   Telegram-a yalnız VPN altında işləyən bir şey heç vaxt verilmir.
> - **Upstream race** — bir neçə qoşulma paralel gedir, ən sürətli canlı olan udur;
>   "seçim genişliyi" sürgüsü (ən sınanmışdan tutmuş mümkün qədər geniş olana) və
>   Telegram relay portları arasında atılıb-düşəndə hovuzun avtomatik genişlənməsi;
>   tənzimlənən qoşulma timeout-u (100 ms…15 s).
> - **Ətraflı kartlı host kataloqu** — "Telegram qoşulur / uğurlu /
>   ümumi yoxlama" və hər host üzrə son 25 cəhd (TCP/TLS vaxtı,
>   qoşulma müddəti, alınan/göndərilən baytlar).
> - **Sürət, ping və port aktivliyinin canlı qrafikləri** (saniyəlik və dəqiqəlik)
>   üstəgəl skan qrafikləri.
> - **Anti-DPI və proxy mühərrikləri** — "Auto-rotate" rejimli maskalama üsulları
>   dəsti, obfuskasiya mühərriki və konkret bloklamaya uyğunlaşmaq üçün
>   eksperimental mühərriklər (split/coalescing).
> - Tənzimləmələrin, host-ların və abunəliklərin **eksport/importu** + tam fabrik sıfırlaması.
> - **Sürətli soyuq başlanğıc** — bir neçə anonimləşdirici üzərindən aqressiv
>   çoxax (multi-threaded) abunəlik yükləməsi.
> - **26 interfeys dili** avtomatik aşkarlama ilə (+RTL).

# İlk işə salışda vacibdir:

- Telegram-ı sabit SOCKS5 proxy localhost:55001 və localhost:55002 ilə konfiqurasiya edin.
- Bunlardan başqa digər proxy-ləri silin.
- Telegram-da "Use proxy"-ni aktiv edin.
- Android-də bildirişləri bloklamayın, əks halda fonda işləməyəcək.
- İlk işə salışda təxminən 15 dəqiqə gözləyin, bu müddətdə o, MTProto proxy-ləri yükləyib bir-bir sınaqdan keçirir və Telegram klienti özü onlara keçir.

# Heç nə işləmirsə

1. Əgər HEÇ NƏ işləmirsə, proqramı canlı proxy-lərin avtomatik kataloqu kimi istifadə edin. CTRL+WIN+ALT+P və CTRL+SHIFT+ALT+P qaynar düymələri ilə AutoConnector pəncərəsini açmadan belə təsadüfi bir proxy-ni birbaşa Telegram-ınıza tez əlavə edə bilərsiniz. Nəticədə Telegram AutoConnector olmadan birbaşa proxy-yə gedir, amma pulsuz proxy-lərin paylaşıldığı söhbətləri izləyib onları yoxlamağa vaxt itirməyəcəksiniz. Qoy AutoConnector tray-da qalsın, "Connector" açarını söndürün, "Scan" açarını isə açıq saxlayın.

2. AutoConnector-u başqa cihazda sınayın: telefonunuzda, dostunuzun telefonunda, kompüterdə. Bloklamanı keçmə prinsipi Windows/Android platformalarında tamamilə fərqlidir. Çox güman ki, Android-də heç bir tənzimləmə olmadan işləyəcək.

3. Heç nə işləmirsə, onda müvəqqəti olaraq bir günlük VPN aktiv edin və həmin gün ərzində AutoConnector + Telegram-ı sınaqdan keçirin (Telegram-ı AutoConnector üzərindən qoşun, 55001 və 55002 portlarında proxy-ləri göstərərək). Proqram daxilində "When VPN is on -> proxy to MTProto" qutusunu işarələyin. AutoConnector işləməyə başladımı, baxın. Əgər bəli, onda nəticə aydındır — AutoConnector proxy-ləri uğurla tapır və Telegram-ın trafikini ora uğurla relay edir, lakin VPN-i söndürsəniz, ölkənizdəki bloklama sistemi bütün çıxış bağlantılarını da çox sərt şəkildə bloklayır. Bu halda bloklamanı keçə bilən işlək bir konfiqurasiya seçmək üçün AutoConnector-dakı vasitələri yarım saat bir-bir sınamalı olacaqsınız. Proqram hələ ki bütün variantları avtomatik olaraq bir-bir sına bilmir (yalnız anti-DPI üsullarının avtomatik rotasiyası var). Təcrübədən sonra VPN-i söndürün və "When VPN is on, proxy to MTProto" qutusunu "Proxy directly" vəziyyətinə qaytarın.

4. (3) bəndinə alternativ. Windows/Linux host-unuza virtual maşın quraşdırın. Telegram + AutoConnector-u onun içində işlədin. VPN olmadan belə əla işləməyə başladımı? Bu o deməkdir ki, bağlantılarınızı ölkənizdəki bloklama sistemi yox, host-unuz korlayır! Səbəblər: firewall-lar, antiviruslar, VPN-dən qalan qalıqlar. Antivirus AutoConnector-u sandbox-a salırsa və ya firewall AutoConnector-un qeyri-adi anti-DPI üsullarını bloklayırsa, onda AutoConnector-u host-da antivirus və firewall-ı keçərək işlətməli olacaqsınız (istisnalar). Yaxud onları bir müddət tamamilə söndürüb kompüteri yenidən başladın. Bəli, məsləhət vermək nə qədər gülməli olsa da, kompüteri yenidən başladın, çünki VPN proqramları çox vaxt nasazlıq edir və host-da bir TUN cihazını yarı-canlı vəziyyətdə qoya bilər. Yenidən başlatdıqdan sonra VPN-i işə salmayın — əvvəlcə AutoConnector-u sınaqdan keçirin.

  5. Bloklamanı keçməyə cəhd edin. Aktivləşdirmə düyməsini tənzimləmələrdə və ya əsas ekranda axtarın (böyük boz/yaşıl dairənin sağındakı düyməni axtarın). Təxminən 15 dəqiqə sərf etməli olacaqsınız. Onlar 3 qrupdan ibarətdir:
	  - Proxy mühərriki. İstənilən Coalescing* rejimini sınayın. Çox güman ki, dərhal işləyəcək. Amma onunla Telegram-da şəkillər/videolar yüklənməyəcək (bu, baq deyil, xüsusiyyət/güzəştdir). Sonra Split* rejimlərini sınayın; əgər işləyirsə — şəkillər yüklənir. Yaxud yenidən "off"-a qaytarın.
	  - "Parallel upstream race"-i sınayın. Bu o deməkdir ki, Telegram proxy-yə 1 qoşulma edəndə, AutoConnector müxtəlif MTProto proxy-lərə 5-30 qoşulma edir və Telegram-a ən yaxşısını verir. Tətbiqin tənzimləmələrində timeout-ları (3-5 san) və paralel upstream sayını 30-a qədər seçə bilərsiniz.
	  - "Auto-rotate anti-DPI tricks"-i aktiv edin, proqram onları özü bir-bir keçəcək.
	  - Telegram-ın daha tez keçməsi üçün proxy tənzimləmələrində (Telegram daxilində) hər 5-10 saniyədən bir əl ilə növbəti porta dövrə şəklində keçin: 55001->55002->55001->...

6. Ən güclü/ən sürətli tənzimləmə kombinasiyası:
	- qoşulma timeout-u 5s
	- host seçim genişliyi 100%
	- 30 paralel qoşulma
	- auto-rotate DPI tricks
	- parallel upstream race
	- proxy mühərriki: Coalescing*
	- Telegram daxilində, proxy pəncərəsində hər 10 saniyədən bir yeni porta dövrə şəklində toxunun.

7. Windows və Android-də konfiqurasiya siyasəti fərqlidir! Yuxarıda yazılanların hamısı əsasən Windows-a aiddir. Android-də əksər insanlar üçün heç bir tənzimləmə olmadan (istənilən tənzimləmə ilə) işləyir. Windows-da fərqli TCP stek və fərqli Telegram tətbiqi var ki, keyfiyyətcə Android-dən xeyli pisdir. Yalnız rəsmi olanı deyil, başqa bir Telegram klientini də sınayın.

8. Lütfən, ətraflı baq hesabatlarını istənilən dildə bura yazın: https://t.me/AutoConnector_for_Telegram — platformanız, hansı üsulları (tənzimləmələri) sınadığınız, firewall/antivirusunuzun olub-olmadığı, VPN/virtual maşından sınayıb-sınamadığınız. Həmçinin istənilən müsbət reseptləri yazın — nə sınadınız və necə işləməyə başladı.


## 📥 Download

Bütün build-lər releases səhifəsindədir: **[GitHub Releases (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

| OS | File | Run |
|----|------|--------|
| **Android** | `AutoConnector_for_Telegram.apk` | APK-nı quraşdırın (Google Play-dən kənar — mənbədən quraşdırmaya icazə verin) |
| **Windows** 10/11 x64 | `AutoConnector-for-Telegram-windows-x64.zip` | çıxarın → `AutoConnector\AutoConnector.exe`-ni işə salın |
| **Linux** x64 | `AutoConnector-for-Telegram-linux-x64.tar.gz` | çıxarın → `./AutoConnector/bin/AutoConnector` |
| **macOS** 11+ (Apple Silicon) | `AutoConnector-for-Telegram-macos.tar.gz` | çıxarın → `AutoConnector.app`-a iki dəfə klikləyin (bloklanırsa — `xattr -dr com.apple.quarantine AutoConnector.app`) |

### 🔐 Həqiqilik (release 1.1.0)

APK release sertifikatı ilə imzalanıb (apksigner, schemes v1+v2+v3). Quraşdırmadan əvvəl yoxlaya bilərsiniz:

- **İmzalama sertifikatı (SHA-256):** `cb23a18c0cf8a23e43b5b63d199fc1440d3e4d6533e1309d3f92f273fe626a5a`
  (CN=AutoConnector for Telegram) — bu barmaq izi bütün gələcək release-lərdə eynidir.
- **APK SHA-256:** `d7652e7f5c3a2174a3b7805c2539df7da080765c9b0f581a7ac5943987c9b935`
- **Windows zip SHA-256:** `1d8d675936387e89038dc4943d7f99200c1b735b86e1f79bd953cd93e60f0217`
- **Linux tar.gz SHA-256:** `9160ea519309dc62750a4a930dc1aae6e20dbcefd21b426fa85b48ace6f3e8f8`
- **macOS tar.gz SHA-256:** `322082ef3f06955ed299be790bce453e47db37fca17daea54724d60698446bc7`

Yoxlama üçün: `apksigner verify --print-certs AutoConnector_for_Telegram.apk` (sertifikat) və
`sha256sum -c SHA256SUMS.txt` (faylların bütövlüyü; `SHA256SUMS.txt` release-ə əlavə olunub).

## 📸 Ekran görüntüləri

<table>
<tr>
<td align="center"><img src="docs/screenshots/connector.png" width="200"><br><sub>Connector — aktiv sessiya</sub></td>
<td align="center"><img src="docs/screenshots/scan.png" width="200"><br><sub>Skan və qrafiklər</sub></td>
<td align="center"><img src="docs/screenshots/catalog.png" width="200"><br><sub>Proxy kataloqu (rejimə görə)</sub></td>
<td align="center"><img src="docs/screenshots/host-card.png" width="200"><br><sub>Host kartı + tarixçə</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/logs.png" width="200"><br><sub>Relay logları</sub></td>
<td align="center"><img src="docs/screenshots/settings.png" width="200"><br><sub>Tənzimləmələr</sub></td>
<td align="center"><img src="docs/screenshots/export.png" width="200"><br><sub>tg:// linklərinin eksportu</sub></td>
<td align="center"><img src="docs/screenshots/hotkeys.png" width="200"><br><sub>Qaynar düymələr</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/guide.png" width="200"><br><sub>Qoşulma təlimatı</sub></td>
<td align="center"><img src="docs/screenshots/connector-ru.png" width="200"><br><sub>Connector · Rus interfeysi</sub></td>
<td align="center"><img src="docs/screenshots/scan-ru.png" width="200"><br><sub>Skan · Rus interfeysi</sub></td>
<td align="center"><sub>26 interfeys dili<br>avtomatik aşkarlama ilə</sub></td>
</tr>
</table>


## Əks əlaqə

Baqları və qeydləri bura göndərin - https://t.me/AutoConnector_for_Telegram

## 🔐 İmzanın yoxlanması

Releases-dən gələn APK release açarı ilə imzalanıb. Onu belə yoxlaya bilərsiniz:

```bash
# Checksum (compare with SHA256SUMS.txt from the release)
sha256sum AutoConnector_for_Telegram.apk

# Digital signature and certificate fingerprint
apksigner verify --print-certs AutoConnector_for_Telegram.apk
```

Rəsmi build-ləri imzalamaq üçün istifadə olunan sertifikatın barmaq izi (SHA-256)
hər release-in təsvirində dərc olunur — APK-nın dəyişdirilmədiyinə əmin olmaq üçün
onu müqayisə edin.

## 📄 Lisenziya

[MIT](LICENSE).
