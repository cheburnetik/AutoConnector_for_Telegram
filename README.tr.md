[ENGLISH](README.en.md) · [ARABIC](README.ar.md) · [BENGALI](README.bn.md) · [BURMESE](README.my.md) · [CHINESE](README.zh.md) · [FRENCH](README.fr.md) · [GERMAN](README.de.md) · [HINDI](README.hi.md) · [INDONESIAN](README.id.md) · [ITALIAN](README.it.md) · [JAPANESE](README.ja.md) · [KOREAN](README.ko.md) · [MARATHI](README.mr.md) · [PERSIAN](README.fa.md) · [POLISH](README.pl.md) · [PORTUGUESE](README.pt.md) · [PUNJABI](README.pa.md) · [RUSSIAN](README.md) · [SPANISH](README.es.md) · [TAMIL](README.ta.md) · [TELUGU](README.te.md) · [THAI](README.th.md) · [TURKISH](README.tr.md) · [UKRAINIAN](README.uk.md) · [URDU](README.ur.md) · [VIETNAMESE](README.vi.md)

**[İndir (en son)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

# AutoConnector for Telegram

AutoConnector for Telegram — uygulama internette MTProto-proxy'leri kendisi bulur, bunların canlı olup olmadığını kontrol eder ve Telegram'ın engellendiği yerlerde bile sorunsuz çalışmasını sağlayan yerel bir relay başlatır. Kullanıcının çalışan proxy'leri elle araması gerekmez — AutoConnector for Telegram sürekli olarak en hızlı ve canlı olanları seçer ve bunları tam olarak sizin bilgisayarınızdan/telefonunuzdan test eder.

Başka bir deyişle: bu, herkese açık ücretsiz MTProto proxy'leri yayınlayan tg-kanallarının ve her türlü aboneliğin bir tarayıcısıdır ve bunları otomatik olarak Telegram'ınıza ekler. Telegram istemcisini güncellemeniz gerekmez. Proxy'lerin erişilebilirliğini tam olarak sizin cihazınızdan ve ağ ortamınızdan kontrol eder. VPN olmadan WiFi+LTE üzerinde çalışır.

Platformlar: Android, Windows, Linux, MacBook.

Android sürümü kendi kendine çalışır, ancak Windows'ta proxy motoru olan "SPLIT..." veya "COALESCING.."yi kurmanız gerekir — ayarlarda ya da "Telegram bağlandı" yazısı ile büyük gri/yeşil dairenin sağındaki düğmeyle. Ya da bizzat sizde daha iyi çalışacak olanı seçin, çünkü engellemeler her yerde farklıdır. "COALESCING.." modları son çare içindir — bu şekilde Telegram çalışmaya başlar, ancak sohbetlerdeki medya içeriğinin gönderilmesi/gösterilmesi bozulur.

Eğer COMODO gibi bir güvenlik duvarı kullanıyorsanız onu kapatmanızı öneririm: uygulamayı bir kum havuzuna (sandbox) hapseder ve güvenlik duvarı MTProto proxy'lerine giden bağlantıları bozar. Ya da uygulamayı bir sanal makinede çalıştırın, orada TCP yığını tamamen değişir, AutoConnector'ın davranışı farklı olacaktır.

Ayrıca, çalışan bir proxy'ye ve Telegram içindeki "Bağlandı" yazısına daha hızlı ulaşmak için Telegram'ın 55001 ve 55002 portları arasında (proxy ayarlarında) geçiş yapmasına elle yardım edin.

# ✨ Özellikler

- **Otomatik proxy araması** — onlarca açık sayfayı ve aboneliği tarar.
- **Canlılık kontrolü** — gerçek MTProto-handshake, hız/kararlılık derecelendirmesi.
- **Yerel relay** — Telegram `127.0.0.1`'e bağlanır, AutoConnector for
  Telegram ise trafiği en iyi canlı proxy üzerinden yönlendirir ve mevcut olan
  düşerse geçiş yapar.
- **Anti-DPI** — bir dizi maskeleme hilesi (tarayıcı taklidi, paket
  parçalama, FakeTLS vb.); «Otomatik deneme» modu çalışanı kendisi seçer.
- **Ayrıntılı istatistikler** — canlı/ölü proxy'ler, hız, gecikme, trafik,
  her anti-DPI hilesinin etkinliği.
- **Proxy kataloğu** — her host için ayrıntılı kart ile derecelendirmeye göre en iyiler:
  her host için «Telegram bağlantısı / başarılı / toplam kontrol» ve
  son 25 denemenin geçmişi (TCP/TLS/toplam bağlantı süresi, alınan/gönderilen bayt) görünür.
- **Esnek host seçimi** — «genişlik» kaydırıcısı: «en iyi denenmişlere bağlı kalmaktan»
  «mümkün olduğunca geniş şekilde farklı canlıları denemeye» kadar; Telegram relay
  portları arasında gidip geldiğinde seçim otomatik olarak genişler. Ayrı bir kaydırıcı —
  bağlantı zaman aşımı (100 ms … 15 s) ve «upstream yarışı» (birkaç bağlantı paralel olarak).
- **12 dil** arayüzü, otomatik algılama ile, RTL desteği.

> ### 1.0.19'a kıyasla yenilikler
> - **Ağ türüne göre ayrı host veritabanları ve derecelendirmeleri** — VPN / Wi-Fi / LTE /
>   Ethernet / White: her bağlantı türü kendi canlı proxy havuzunu tutar, böylece
>   yalnızca VPN altında çalışan şeyleri Telegram'a sunmaz.
> - **Upstream yarışı** — birkaç bağlantı paralel olarak, en hızlı canlı olan
>   kazanır; «seçim genişliği» kaydırıcısı (en iyi denenmişlerden mümkün olduğunca
>   geniş olana kadar) ve Telegram relay portları arasında gidip geldiğinde havuzun otomatik
>   genişlemesi; ayarlanabilir bağlantı zaman aşımı (100 ms…15 s).
> - **Ayrıntılı kartlı host kataloğu** — «Telegram bağlantısı / başarılı /
>   toplam kontrol» ve host başına son 25 denemenin geçmişi (TCP/TLS süresi,
>   bağlantı süresi, alınan/gönderilen bayt).
> - **Canlı grafikler** — hız, ping ve port etkinliği (saniye ve dakika bazında)
>   ve tarama grafikleri.
> - **Anti-DPI ve proxy motorları** — «Otomatik deneme» ile bir dizi maskeleme hilesi,
>   obfuskasyon motoru ve belirli bir engellemeye yönelik deneysel motorlar (split/
>   coalescing).
> - **Ayarların, hostların ve aboneliklerin dışa/içe aktarımı** + fabrika ayarlarına tam sıfırlama.
> - **Hızlı soğuk başlatma** — birkaç anonimleştirici üzerinden aboneliklerin agresif
>   çok iş parçacıklı indirilmesi.
> - **26 dil** arayüzü, otomatik algılama ile (+RTL).

# İlk çalıştırmada önemli:

- Telegram'ı, sabit SOCKS5 proxy olarak localhost:55001 ve localhost:55002'yi belirterek ayarlayın.
- Bunların dışındaki diğer proxy'leri silin.
- Telegram'da "Proxy kullan" seçeneğini etkinleştirin.
- Android'de bildirimleri engellemeyin, aksi takdirde arka planda çalışmaz.
- İlk çalıştırmada, MTProto proxy'leri indirip deneyene ve Telegram istemcisinin kendisi geçiş yapana kadar ~15 dakika bekleyin.

# Hiçbir şey çalışmıyorsa

1. HİÇBİR ŞEY çalışmıyorsa, programı canlı proxy'lerin otomatik kataloğu olarak kullanın. CTRL+WIN+ALT+P ve CTRL+SHIFT+ALT+P kısayollarıyla, AutoConnector penceresini açmadan hızlıca rastgele bir proxy'yi doğrudan Telegram'ınıza ekleyebilirsiniz. Böylece Telegram, AutoConnector olmadan doğrudan proxy'ye gider, ancak ücretsiz proxy yayınlanan sohbetleri izlemeniz ve bunları kontrol etmek için zaman harcamanız gerekmez. AutoConnector tepside yaşasın, "Konnektör" anahtarını kapatın, "Tarama" anahtarını açık bırakın.

2. AutoConnector'ı başka bir cihazda deneyin: telefon, arkadaşınızın telefonu, bilgisayar. Farklı platformlarda Windows/Android'de engelleri aşma prensibi tamamen farklıdır. Büyük olasılıkla Android'de herhangi bir ayar yapmadan çalışacaktır.

3. Hiçbir şey çalışmıyorsa, bir günlüğüne VPN'i geçici olarak açın ve o gün boyunca AutoConnector + Telegram'ı test edin (Telegram'ı AutoConnector üzerinden bağlayın, proxy'leri 55001 ve 55002 portlarında belirterek). Program içinde "VPN açıkken -> MTProto'ya proxy yap" onay kutusunu etkinleştirin. Bakalım, AutoConnector çalışmaya başladı mı? Eğer evet ise, sonuç açıktır — AutoConnector proxy'leri başarıyla buluyor, Telegram trafiğini oraya başarıyla aktarıyor, ancak VPN kapatılırsa ülkenizdeki engelleme sistemi tüm giden bağlantıları çok sert engelliyor demektir. Bu durumda, engelleri aşabilen çalışan birini seçmek için AutoConnector'daki seçenekleri denemeye yarım saat harcamanız gerekecek. Tüm seçenekleri otomatik olarak tamamen denemeyi program henüz beceremiyor (yalnızca anti-DPI hilelerinin otomatik denemesi mevcut). Denemeden sonra VPN'i kapatın ve "VPN açıkken MTProto'ya proxy yap" onay kutusunu "Doğrudan proxy yap" durumuna geri getirin.

4. (3) maddesine alternatif. Windows/Linux hostunuza bir sanal makine kurun. İçinde Telegram + AutoConnector'ı çalıştırın. VPN olmadan bile mükemmel çalışmaya mı başladı? Demek ki bağlantılarınızı bozan, ülkenizdeki engelleme sistemi değil, hostunuz! Nedenleri: güvenlik duvarları, antivirüsler, VPN kalıntıları. Antivirüs AutoConnector'ı kum havuzuna koyuyorsa ya da güvenlik duvarı AutoConnector'ın alışılmadık anti-DPI hilelerini engelliyorsa, AutoConnector'ı hostta antivirüs ve güvenlik duvarının dışında (istisnalar) çalıştırmanız gerekecek. Ya da bilgisayarı yeniden başlatarak onları bir süreliğine tamamen kapatın. Evet, tavsiye etmek ne kadar komik olsa da, bilgisayarı yeniden başlatın, çünkü VPN programları sık sık hata verir ve hostta bir TUN aygıtını yarı canlı durumda bırakabilir. Yeniden başlattıktan sonra VPN'i çalıştırmayın, önce AutoConnector'ı test edin.

  5. Engelleri aşmayı deneyin. Açma düğmesini ayarlarda ya da ana ekranda arayın (büyük gri/yeşil dairenin sağındaki düğmeyi arayın). ~15 dakika ayırmanız gerekecek. 3 gruptan oluşurlar:
	  - Proxy motoru. Herhangi bir Coalescing* modunu deneyin. Büyük olasılıkla hemen çalışacaktır. Ancak bu durumda Telegram'da resimler/videolar yüklenmeyecek (bu bir hata değil, bir özellik/ödün). Sonra Split* modlarını deneyin, çalışırsa resimler yüklenir. Ya da "kapalı"ya geri getirin.
	  - "Paralel upstream yarışı"nı deneyin. Bu, Telegram proxy'ye 1 bağlantı yaptığında, AutoConnector'ın farklı MTProto proxy'lerine 5-30 bağlantı yapması ve Telegram'a en iyisini sunması demektir. Uygulama ayarlarında zaman aşımlarını (3-5 sn) ve paralel upstream sayısını 30 adede kadar seçebilirsiniz.
	  - "anti-DPI hilelerinin otomatik denemesi"ni etkinleştirin, program onları kendisi deneyecek.
	  - Telegram'ın daha hızlı geçiş yapması için, proxy ayarlarında (Telegram'da) her 5-10 saniyede bir sonraki porta döngüsel olarak elle geçin 55001->55002->55001->...

6. En güçlü/en hızlı ayar kombinasyonu:
	- bağlantı zaman aşımı 5s
	- host seçim genişliği %100
	- paralel bağlantı sayısı 30
	- DPI hilelerinin otomatik denemesi
	- paralel upstream yarışı
	- proxy motoru: Coalescing*
	- Telegram içinde proxy penceresinde her 10 saniyede bir yeni porta, döngüsel olarak tıklayın.

7. Windows ve Android'de ayar politikası farklıdır! Yukarıda yazılan her şey esas olarak Windows'la ilgilidir. Android'de çoğu kişide herhangi bir ayar olmadan çalışır (herhangi bir ayarda). Windows'ta farklı bir TCP yığını ve farklı bir Telegram uygulaması vardır, kalite olarak Android'den çok daha kötüdür. Yalnızca resmî olmayı değil, başka bir Telegram istemcisini deneyin.

8. Lütfen https://t.me/AutoConnector_for_Telegram adresine herhangi bir dilde ayrıntılı hata raporları yazın - platform, hangi yöntemleri denediniz (ayarlar), güvenlik duvarınız/antivirüsünüz var mı, VPN'den/sanal makineden denediniz mi. Ayrıca neyi denediğinizi ve nasıl çalıştığını içeren olumlu tarifleri de yazın.


## 📥 İndir

Tüm derlemeler — sürümler sayfasında: **[GitHub Releases (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

| İşletim sistemi | Dosya | Çalıştırma |
|----|------|--------|
| **Android** | `AutoConnector_for_Telegram.apk` | APK'yı kurun (Google Play dışında — kaynaktan kuruluma izin verin) |
| **Windows** 10/11 x64 | `AutoConnector-for-Telegram-windows-x64.zip` | açın → `AutoConnector\AutoConnector.exe` çalıştırın |
| **Linux** x64 | `AutoConnector-for-Telegram-linux-x64.tar.gz` | açın → `./AutoConnector/bin/AutoConnector` |
| **macOS** 11+ (Apple Silicon) | `AutoConnector-for-Telegram-macos.tar.gz` | açın → `AutoConnector.app`'e çift tıklayın (engellerse — `xattr -dr com.apple.quarantine AutoConnector.app`) |

### 🔐 Özgünlük doğrulama (release 1.1.0)

APK, release sertifikasıyla imzalanmıştır (apksigner, şemalar v1+v2+v3). Kurmadan önce karşılaştırabilirsiniz:

- **İmza sertifikası (SHA-256):** `cb23a18c0cf8a23e43b5b63d199fc1440d3e4d6533e1309d3f92f273fe626a5a`
  (CN=AutoConnector for Telegram) — bu parmak izi gelecekteki tüm sürümler için aynıdır.
- **APK SHA-256:** `d7652e7f5c3a2174a3b7805c2539df7da080765c9b0f581a7ac5943987c9b935`
- **Windows zip SHA-256:** `1d8d675936387e89038dc4943d7f99200c1b735b86e1f79bd953cd93e60f0217`
- **Linux tar.gz SHA-256:** `9160ea519309dc62750a4a930dc1aae6e20dbcefd21b426fa85b48ace6f3e8f8`
- **macOS tar.gz SHA-256:** `322082ef3f06955ed299be790bce453e47db37fca17daea54724d60698446bc7`

Doğrulama: `apksigner verify --print-certs AutoConnector_for_Telegram.apk` (sertifika) ve
`sha256sum -c SHA256SUMS.txt` (dosya bütünlüğü; `SHA256SUMS.txt` sürüme eklenmiştir).

## 📸 Ekran görüntüleri

<table>
<tr>
<td align="center"><img src="docs/screenshots/connector.png" width="200"><br><sub>Konnektör — etkin oturum</sub></td>
<td align="center"><img src="docs/screenshots/scan.png" width="200"><br><sub>Tarama ve grafikler</sub></td>
<td align="center"><img src="docs/screenshots/catalog.png" width="200"><br><sub>Proxy kataloğu (modlara göre)</sub></td>
<td align="center"><img src="docs/screenshots/host-card.png" width="200"><br><sub>Host kartı + geçmiş</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/logs.png" width="200"><br><sub>Relay günlükleri</sub></td>
<td align="center"><img src="docs/screenshots/settings.png" width="200"><br><sub>Ayarlar</sub></td>
<td align="center"><img src="docs/screenshots/export.png" width="200"><br><sub>tg://-bağlantılarının dışa aktarımı</sub></td>
<td align="center"><img src="docs/screenshots/hotkeys.png" width="200"><br><sub>Kısayol tuşları</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/guide.png" width="200"><br><sub>Bağlantı kılavuzu</sub></td>
<td align="center"><img src="docs/screenshots/connector-ru.png" width="200"><br><sub>Konnektör · Rusça arayüz</sub></td>
<td align="center"><img src="docs/screenshots/scan-ru.png" width="200"><br><sub>Tarama · Rusça arayüz</sub></td>
<td align="center"><sub>26 arayüz dili<br>otomatik algılama ile</sub></td>
</tr>
</table>


## Geri bildirim

Hataları ve görüşlerinizi buraya gönderin - https://t.me/AutoConnector_for_Telegram

## 🔐 İmza doğrulama

Sürümlerdeki APK, release anahtarıyla imzalanmıştır. Şöyle doğrulayabilirsiniz:

```bash
# Sağlama toplamı (sürümdeki SHA256SUMS.txt ile karşılaştırın)
sha256sum AutoConnector_for_Telegram.apk

# Dijital imza ve sertifika parmak izi
apksigner verify --print-certs AutoConnector_for_Telegram.apk
```

Resmî derlemelerin imzalandığı sertifika parmak izi (SHA-256), her sürümün
açıklamasında yayınlanır — APK'nın değiştirilmediğinden emin olmak için bunu
karşılaştırın.

## 📄 Lisans

[MIT](LICENSE).
