[ENGLISH](README.en.md) · [ARABIC](README.ar.md) · [BENGALI](README.bn.md) · [BURMESE](README.my.md) · [CHINESE](README.zh.md) · [FRENCH](README.fr.md) · [GERMAN](README.de.md) · [HINDI](README.hi.md) · [INDONESIAN](README.id.md) · [ITALIAN](README.it.md) · [JAPANESE](README.ja.md) · [KOREAN](README.ko.md) · [MARATHI](README.mr.md) · [PERSIAN](README.fa.md) · [POLISH](README.pl.md) · [PORTUGUESE](README.pt.md) · [PUNJABI](README.pa.md) · [RUSSIAN](README.md) · [SPANISH](README.es.md) · [TAMIL](README.ta.md) · [TELUGU](README.te.md) · [THAI](README.th.md) · [TURKISH](README.tr.md) · [UKRAINIAN](README.uk.md) · [URDU](README.ur.md) · [VIETNAMESE](README.vi.md)

**[Download (terbaru)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

# AutoConnector for Telegram

AutoConnector for Telegram — aplikasi ini sendiri yang menemukan proxy MTProto di internet, memeriksa keaktifannya, dan menyalakan relay lokal yang membuat Telegram bekerja stabil bahkan di tempat di mana Telegram diblokir. Pengguna tidak perlu mencari proxy yang berfungsi secara manual — AutoConnector for Telegram terus-menerus memilih yang tercepat dan teraktif, mengujinya tepat dari komputer/ponsel Anda.

Dengan kata lain: ini adalah pemindai kanal tg dan berbagai langganan dengan proxy MTProto gratis publik, dengan penyisipan otomatis ke Telegram Anda. Anda tidak perlu memperbarui klien Telegram. Ketersediaan proxy diperiksa tepat dari perangkat dan lingkungan jaringan Anda. Bekerja di WiFi+LTE tanpa VPN.

Platform: Android, Windows, Linux, MacBook.

Versi Android bekerja dengan sendirinya, sedangkan di Windows Anda perlu mengatur mesin proxy "SPLIT..." atau "COALESCING.." — di pengaturan atau pada tombol di sebelah kanan tulisan "Telegram terhubung" dan lingkaran besar abu-abu/hijau. Atau pilihlah yang secara pribadi paling baik bekerja untuk Anda, karena pemblokiran berbeda-beda di setiap tempat. Mode "COALESCING.." sebagai upaya terakhir — dengan begitu Telegram akan mulai bekerja, tetapi pengiriman/penampilan konten media di chat akan rusak.

Saya sarankan untuk mematikan firewall semacam COMODO jika Anda menggunakannya: ia memasukkan aplikasi ke dalam sandbox dan firewall-nya merusak koneksi keluar ke proxy MTProto. Atau jalankan aplikasi di mesin virtual, di sana TCP stack akan berubah sepenuhnya, sehingga perilaku AutoConnector akan berbeda.

Selain itu, bantu juga Telegram secara manual untuk beralih antara port 55001 dan 55002 (di pengaturan proxy), agar lebih cepat mencapai proxy yang berfungsi dan munculnya tulisan "Terhubung" di dalam Telegram.

# ✨ Kemampuan

- **Pencarian proxy otomatis** — memindai puluhan halaman dan langganan terbuka.
- **Pemeriksaan keaktifan** — handshake MTProto nyata, peringkat berdasarkan kecepatan/stabilitas.
- **Relay lokal** — Telegram terhubung ke `127.0.0.1`, sedangkan AutoConnector for
  Telegram merutekan lalu lintas melalui proxy hidup terbaik dan beralih,
  jika yang sekarang mati.
- **Anti-DPI** — sekumpulan trik penyamaran (meniru browser, pemecahan
  paket, FakeTLS dll.); mode «Iterasi otomatis» sendiri memilih yang berfungsi.
- **Statistik terperinci** — proxy hidup/mati, kecepatan, latensi, lalu lintas,
  efektivitas setiap trik anti-DPI.
- **Katalog proxy** — peringkat teratas dengan kartu detail untuk setiap host:
  untuk setiap host terlihat «koneksi Telegram / berhasil / total pemeriksaan» dan
  riwayat 25 percobaan terakhir (TCP/TLS/total durasi koneksi, byte diterima/dikirim).
- **Pemilihan host yang fleksibel** — penggeser «keluasan»: dari «berpegang pada yang terbaik dan teruji»
  hingga «mencoba seluas mungkin berbagai yang hidup»; ketika Telegram berpindah-pindah antar
  port relay, pemilihan diperluas secara otomatis. Penggeser terpisah — timeout
  koneksi (100 md … 15 d) dan «balapan upstream» (beberapa koneksi paralel).
- **12 bahasa** antarmuka dengan deteksi otomatis, dukungan RTL.

> ### Apa yang baru dibandingkan 1.0.19
> - **Basis dan peringkat host terpisah berdasarkan jenis jaringan** — VPN / Wi-Fi / LTE /
>   Ethernet / White: setiap jenis koneksi memiliki kumpulan proxy hidupnya sendiri, agar
>   tidak menyodorkan kepada Telegram sesuatu yang hanya bekerja di bawah VPN.
> - **Balapan upstream** — beberapa koneksi paralel, yang menang adalah yang
>   hidup tercepat; penggeser «keluasan pemilihan» (dari yang terbaik dan teruji hingga semaksimal
>   mungkin luas) dengan perluasan kumpulan otomatis, ketika Telegram berpindah-pindah antar port relay;
>   timeout koneksi yang dapat disetel (100 md…15 d).
> - **Katalog host dengan kartu terperinci** — «koneksi Telegram / berhasil /
>   total pemeriksaan» dan riwayat 25 percobaan terakhir per host (waktu TCP/TLS,
>   durasi koneksi, byte diterima/dikirim).
> - **Grafik langsung** kecepatan, ping, dan aktivitas port (per detik dan menit)
>   serta grafik pemindaian.
> - **Anti-DPI dan mesin proxy** — sekumpulan trik penyamaran dengan
>   «Iterasi otomatis», mesin obfuskasi dan mesin eksperimental (split/
>   coalescing) untuk pemblokiran tertentu.
> - **Ekspor/impor** pengaturan, host, dan langganan + reset penuh ke tampilan pabrik.
> - **Cold start cepat** — pemuatan langganan multithread agresif melalui
>   beberapa anonymizer.
> - **26 bahasa** antarmuka dengan deteksi otomatis (+RTL).

# Saat pertama kali menjalankan, penting:

- Lakukan pengaturan Telegram, dengan menetapkan proxy SOCKS5 tetap localhost:55001 dan localhost:55002.
- Hapus proxy lain selain ini.
- Aktifkan "Gunakan proxy" di Telegram.
- Jangan memblokir notifikasi di Android, jika tidak, aplikasi tidak akan bekerja di latar belakang.
- Saat pertama kali menjalankan, tunggu ~15 menit sampai mengunduh dan mengiterasi proxy MTProto serta sampai klien Telegram sendiri beralih.

# Jika tidak ada yang berfungsi

1. Jika TIDAK ADA yang berfungsi, gunakan program sebagai katalog otomatis proxy hidup. Dengan hotkey CTRL+WIN+ALT+P dan CTRL+SHIFT+ALT+P Anda dapat dengan cepat tanpa membuka jendela AutoConnector menambahkan proxy acak langsung ke Telegram Anda. Hasilnya, Telegram akan langsung menuju proxy, tanpa AutoConnector, tetapi Anda tidak perlu memantau chat tempat proxy gratis dipublikasikan dan membuang waktu untuk memeriksanya. Biarkan AutoConnector hidup di tray, matikan sakelar "Konektor", biarkan sakelar "Scan".

2. Coba AutoConnector di perangkat lain: ponsel, ponsel teman, komputer. Pada platform yang berbeda Windows/Android prinsip pintas pemblokiran benar-benar berbeda. Kemungkinan besar di Android akan bekerja tanpa pengaturan apa pun.

3. Jika tidak ada yang berfungsi, maka aktifkan VPN sementara selama satu hari dan uji AutoConnector + Telegram pada hari itu (hubungkan Telegram melalui AutoConnector, dengan menetapkan proxy pada port 55001 dan 55002). Di dalam program aktifkan centang "Saat VPN aktif -> proxy ke MTProto". Lihat, apakah AutoConnector mulai bekerja? Jika ya, maka kesimpulannya jelas — AutoConnector berhasil mencari proxy, berhasil meneruskan lalu lintas Telegram ke sana, tetapi jika VPN dimatikan, maka sistem pemblokiran di negara Anda terlalu keras memblokir semua koneksi keluar. Dalam kasus itu Anda harus menghabiskan setengah jam untuk mengiterasi cara-cara di AutoConnector, untuk menemukan yang berfungsi, yang mampu memintas pemblokiran. Program belum bisa mengiterasi semua varian secara otomatis sepenuhnya (hanya ada iterasi otomatis trik anti-DPI). Setelah eksperimen, matikan VPN dan kembalikan centang "Saat VPN aktif proxy ke MTProto" ke keadaan "Proxy langsung".

4. Alternatif untuk poin (3). Pasang mesin virtual di host Windows/Linux Anda. Di dalamnya jalankan Telegram + AutoConnector. Mulai bekerja sempurna bahkan tanpa VPN? Berarti host Anda yang merusak koneksi Anda, bukan sistem pemblokiran di negara Anda! Penyebab: firewall, antivirus, sisa-sisa dari VPN. Jika antivirus menempatkan AutoConnector ke sandbox, atau firewall memblokir trik anti-DPI tidak biasa dari AutoConnector, maka Anda harus mengaktifkan AutoConnector di host melalui (pengecualian) antivirus dan firewall. Atau matikan keduanya sama sekali untuk sementara, dengan me-reboot komputer. Ya, betapa pun lucunya menyarankan, reboot komputer, karena program VPN sering bermasalah dan dapat meninggalkan perangkat TUN di host dalam keadaan setengah hidup. Setelah reboot jangan menjalankan VPN, uji AutoConnector terlebih dahulu.

  5. Coba pintas pemblokiran. Tombol pengaktifannya cari di pengaturan atau di layar utama (cari tombol di sebelah kanan lingkaran besar berwarna abu-abu/hijau). Anda harus meluangkan ~15 menit. Mereka terdiri dari 3 grup:
	  - Mesin proxy. Coba mode Coalescing* mana pun. Kemungkinan besar langsung berfungsi. Tetapi dengan begitu gambar/video tidak akan dimuat di Telegram (ini bukan bug, melainkan fitur/kompromi). Selanjutnya coba mode Split*, jika berfungsi — gambar dimuat. Atau kembalikan ke "dinonaktifkan".
	  - Coba "Balapan upstream paralel". Ini berarti ketika Telegram membuat 1 koneksi ke proxy, AutoConnector membuat 5-30 koneksi ke berbagai proxy MTProto dan menyodorkan yang terbaik kepada Telegram. Di pengaturan aplikasi Anda dapat memilih timeout (3-5 dtk) dan jumlah upstream paralel hingga 30 buah.
	  - Aktifkan "Iterasi otomatis trik anti-DPI", program sendiri yang akan mengiterasinya.
	  - Agar Telegram beralih lebih cepat, di pengaturan proxy (di Telegram) secara manual setiap 5-10 detik beralihlah ke port berikutnya secara melingkar 55001->55002->55001->...

6. Kombinasi pengaturan yang paling kuat/cepat:
	- timeout koneksi 5d
	- keluasan pemilihan host 100%
	- koneksi paralel 30
	- iterasi otomatis trik DPI
	- balapan upstream paralel
	- mesin proxy: Coalescing*
	- di dalam Telegram pada jendela proxy setiap 10 detik klik port baru, secara melingkar.

7. Kebijakan pengaturan di Windows dan Android berbeda! Semua yang tertulis di atas terutama menyangkut Windows. Di Android pada kebanyakan orang berfungsi tanpa pengaturan apa pun (dengan pengaturan apa pun). Di Windows TCP stack berbeda dan aplikasi Telegram berbeda, kualitasnya jauh lebih buruk dibandingkan Android. Coba klien Telegram lain, bukan hanya yang resmi.

8. Mohon tulis laporan bug yang terperinci dalam bahasa apa pun di https://t.me/AutoConnector_for_Telegram — platform, cara apa saja yang sudah dicoba (pengaturan), apakah Anda memiliki firewall/antivirus, apakah sudah mencoba dari VPN/mesin virtual. Tulis juga resep positif apa pun, apa yang dicoba dan bagaimana ia bisa berfungsi.


## 📥 Unduh

Semua build — di halaman rilis: **[GitHub Releases (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

| OS | Berkas | Menjalankan |
|----|------|--------|
| **Android** | `AutoConnector_for_Telegram.apk` | pasang APK (di luar Google Play — izinkan instalasi dari sumber) |
| **Windows** 10/11 x64 | `AutoConnector-for-Telegram-windows-x64.zip` | ekstrak → jalankan `AutoConnector\AutoConnector.exe` |
| **Linux** x64 | `AutoConnector-for-Telegram-linux-x64.tar.gz` | ekstrak → `./AutoConnector/bin/AutoConnector` |
| **macOS** 11+ (Apple Silicon) | `AutoConnector-for-Telegram-macos.tar.gz` | ekstrak → klik dua kali pada `AutoConnector.app` (jika diblokir — `xattr -dr com.apple.quarantine AutoConnector.app`) |

### 🔐 Verifikasi keaslian (release 1.1.0)

APK ditandatangani dengan sertifikat release (apksigner, skema v1+v2+v3). Sebelum instalasi Anda dapat mencocokkan:

- **Sertifikat penandatanganan (SHA-256):** `cb23a18c0cf8a23e43b5b63d199fc1440d3e4d6533e1309d3f92f273fe626a5a`
  (CN=AutoConnector for Telegram) — sidik jari ini sama untuk semua rilis mendatang.
- **APK SHA-256:** `d7652e7f5c3a2174a3b7805c2539df7da080765c9b0f581a7ac5943987c9b935`
- **Windows zip SHA-256:** `1d8d675936387e89038dc4943d7f99200c1b735b86e1f79bd953cd93e60f0217`
- **Linux tar.gz SHA-256:** `9160ea519309dc62750a4a930dc1aae6e20dbcefd21b426fa85b48ace6f3e8f8`
- **macOS tar.gz SHA-256:** `322082ef3f06955ed299be790bce453e47db37fca17daea54724d60698446bc7`

Verifikasi: `apksigner verify --print-certs AutoConnector_for_Telegram.apk` (sertifikat) dan
`sha256sum -c SHA256SUMS.txt` (integritas berkas; `SHA256SUMS.txt` dilampirkan pada rilis).

## 📸 Tangkapan layar

<table>
<tr>
<td align="center"><img src="docs/screenshots/connector.png" width="200"><br><sub>Konektor — sesi aktif</sub></td>
<td align="center"><img src="docs/screenshots/scan.png" width="200"><br><sub>Scan dan grafik</sub></td>
<td align="center"><img src="docs/screenshots/catalog.png" width="200"><br><sub>Katalog proxy (berdasarkan mode)</sub></td>
<td align="center"><img src="docs/screenshots/host-card.png" width="200"><br><sub>Kartu host + riwayat</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/logs.png" width="200"><br><sub>Log relay</sub></td>
<td align="center"><img src="docs/screenshots/settings.png" width="200"><br><sub>Pengaturan</sub></td>
<td align="center"><img src="docs/screenshots/export.png" width="200"><br><sub>Ekspor tautan tg://</sub></td>
<td align="center"><img src="docs/screenshots/hotkeys.png" width="200"><br><sub>Tombol pintas</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/guide.png" width="200"><br><sub>Panduan koneksi</sub></td>
<td align="center"><img src="docs/screenshots/connector-ru.png" width="200"><br><sub>Konektor · UI Rusia</sub></td>
<td align="center"><img src="docs/screenshots/scan-ru.png" width="200"><br><sub>Scan · UI Rusia</sub></td>
<td align="center"><sub>26 bahasa antarmuka<br>dengan deteksi otomatis</sub></td>
</tr>
</table>


## Umpan balik

Bug dan komentar kirimkan ke sini - https://t.me/AutoConnector_for_Telegram

## 🔐 Verifikasi tanda tangan

APK dari rilis ditandatangani dengan kunci release. Cara memeriksanya:

```bash
# Checksum (bandingkan dengan SHA256SUMS.txt dari rilis)
sha256sum AutoConnector_for_Telegram.apk

# Tanda tangan digital dan sidik jari sertifikat
apksigner verify --print-certs AutoConnector_for_Telegram.apk
```

Sidik jari sertifikat (SHA-256), yang digunakan untuk menandatangani build resmi,
dipublikasikan dalam deskripsi setiap rilis — cocokkan untuk memastikan bahwa APK
tidak diganti.

## 📄 Lisensi

[MIT](LICENSE).
