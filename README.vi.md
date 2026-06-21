[ENGLISH](README.en.md) · [AMHARIC](README.am.md) · [ARABIC](README.ar.md) · [AZERBAIJANI](README.az.md) · [BENGALI](README.bn.md) · [BURMESE](README.my.md) · [CHINESE](README.zh.md) · [DARI](README.prs.md) · [FRENCH](README.fr.md) · [GERMAN](README.de.md) · [HAUSA](README.ha.md) · [HINDI](README.hi.md) · [INDONESIAN](README.id.md) · [ITALIAN](README.it.md) · [JAPANESE](README.ja.md) · [KAZAKH](README.kk.md) · [KOREAN](README.ko.md) · [MARATHI](README.mr.md) · [PASHTO](README.ps.md) · [PERSIAN](README.fa.md) · [POLISH](README.pl.md) · [PORTUGUESE](README.pt.md) · [PUNJABI](README.pa.md) · [RUSSIAN](README.md) · [SPANISH](README.es.md) · [TAMIL](README.ta.md) · [TELUGU](README.te.md) · [THAI](README.th.md) · [TIGRINYA](README.ti.md) · [TURKISH](README.tr.md) · [UKRAINIAN](README.uk.md) · [URDU](README.ur.md) · [UZBEK](README.uz.md) · [VIETNAMESE](README.vi.md)

**[Tải về (mới nhất)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

# AutoConnector for Telegram

AutoConnector for Telegram — ứng dụng tự động tìm các proxy MTProto trên internet, kiểm tra xem chúng còn hoạt động hay không và dựng lên một relay cục bộ, qua đó Telegram chạy ổn định ngay cả ở những nơi nó bị chặn. Người dùng không cần tự tay tìm proxy hoạt động — AutoConnector for Telegram liên tục chọn ra những proxy nhanh nhất và còn sống, kiểm thử chúng chính từ máy tính/điện thoại của bạn.

Nói cách khác: đây là một trình quét các kênh Telegram và đủ loại đăng ký (subscription) chứa proxy MTProto miễn phí công khai, với tính năng tự động cắm chúng vào Telegram của bạn. Không cần cập nhật ứng dụng Telegram. Khả năng truy cập của proxy được kiểm tra chính từ thiết bị và môi trường mạng của bạn. Hoạt động trên Wi-Fi+LTE mà không cần VPN.

Nền tảng: Android, Windows, Linux, MacBook.

Phiên bản Android tự nó hoạt động, còn trên Windows bạn cần bật động cơ proxy "SPLIT..." hoặc "COALESCING.." — trong phần cài đặt hoặc nút ở bên phải dòng chữ "Telegram đã kết nối" và vòng tròn lớn màu xám/xanh. Hoặc bạn tự chọn cái nào chạy tốt hơn với bạn, vì việc chặn ở mỗi nơi mỗi khác. Các chế độ "COALESCING.." dùng cho trường hợp bí bách — như vậy Telegram sẽ bắt đầu hoạt động, nhưng việc gửi/hiển thị nội dung media trong các cuộc trò chuyện sẽ bị hỏng.

Tôi khuyên bạn nên tắt tường lửa kiểu như COMODO nếu bạn dùng: nó đẩy ứng dụng vào sandbox và tường lửa của nó làm hỏng các kết nối đi ra tới proxy MTProto. Hoặc chạy ứng dụng trong máy ảo, ở đó toàn bộ ngăn xếp TCP sẽ thay đổi hoàn toàn, hành vi của AutoConnector sẽ khác đi.

Và bạn cũng hãy giúp Telegram chuyển đổi thủ công giữa các cổng 55001 và 55002 (trong cài đặt proxy), để nhanh chóng đạt được một proxy hoạt động và dòng chữ "Đã kết nối" bên trong Telegram.

# ✨ Tính năng

- **Tự động tìm proxy** — quét hàng chục trang và đăng ký công khai.
- **Kiểm tra còn sống** — thực hiện MTProto-handshake thật, xếp hạng theo tốc độ/độ ổn định.
- **Relay cục bộ** — Telegram kết nối tới `127.0.0.1`, còn AutoConnector for
  Telegram định tuyến lưu lượng qua proxy còn sống tốt nhất và chuyển sang cái khác,
  nếu cái hiện tại sập.
- **Anti-DPI** — bộ mẹo ngụy trang (giả lập trình duyệt, phân mảnh
  gói tin, FakeTLS, v.v.); chế độ «Tự động dò» tự nó chọn ra cái hoạt động.
- **Thống kê chi tiết** — proxy sống/chết, tốc độ, độ trễ, lưu lượng,
  hiệu quả của từng mẹo anti-DPI.
- **Danh mục proxy** — top theo xếp hạng với thẻ chi tiết cho từng host:
  với mỗi host bạn thấy «số kết nối Telegram / số thành công / tổng số lần kiểm tra» và
  lịch sử 25 lần thử gần nhất (thời lượng kết nối TCP/TLS/tổng thể, số byte nhận/gửi).
- **Lựa chọn host linh hoạt** — thanh trượt «độ rộng»: từ «bám vào những cái tốt nhất đã được kiểm chứng»
  đến «thử rộng nhất có thể các proxy sống khác nhau»; khi Telegram nhảy loạn giữa
  các cổng relay, lựa chọn được mở rộng tự động. Một thanh trượt riêng — timeout
  kết nối (100 ms … 15 s) và «đua upstream» (nhiều kết nối song song).
- **12 ngôn ngữ** giao diện với tự động phát hiện, hỗ trợ RTL.

> ### Có gì mới so với 1.0.19
> - **Cơ sở dữ liệu và xếp hạng host riêng theo loại mạng** — VPN / Wi-Fi / LTE /
>   Ethernet / White: mỗi loại kết nối duy trì một pool proxy sống riêng, để
>   không cắm cho Telegram những thứ chỉ hoạt động dưới VPN.
> - **Đua upstream** — nhiều kết nối song song, cái còn sống nhanh nhất chiến thắng;
>   thanh trượt «độ rộng lựa chọn» (từ những cái tốt nhất đã kiểm chứng đến rộng nhất
>   có thể) với việc tự động mở rộng pool, khi Telegram nhảy loạn giữa các cổng relay;
>   timeout kết nối tùy chỉnh (100 ms…15 s).
> - **Danh mục host với thẻ chi tiết** — «số kết nối Telegram / số thành công /
>   tổng số lần kiểm tra» và lịch sử 25 lần thử gần nhất theo host (thời gian TCP/TLS,
>   thời lượng kết nối, số byte nhận/gửi).
> - **Đồ thị trực tiếp** về tốc độ, ping và hoạt động cổng (theo giây và theo phút)
>   và đồ thị quét.
> - **Anti-DPI và các động cơ proxy** — bộ mẹo ngụy trang với
>   «Tự động dò», động cơ làm rối (obfuscation) và các động cơ thử nghiệm (split/
>   coalescing) cho từng kiểu chặn cụ thể.
> - **Xuất/nhập** cài đặt, host và đăng ký + khôi phục hoàn toàn về trạng thái gốc.
> - **Khởi động lạnh nhanh** — tải đăng ký đa luồng quyết liệt qua
>   nhiều dịch vụ ẩn danh.
> - **26 ngôn ngữ** giao diện với tự động phát hiện (+RTL).

# Khi chạy lần đầu, điều quan trọng:

- Tiến hành cài đặt Telegram, chỉ định proxy SOCKS5 cố định localhost:55001 và localhost:55002.
- Hãy xóa các proxy khác, chỉ giữ những cái này.
- Bật trong Telegram tùy chọn "Sử dụng proxy".
- Không chặn thông báo trên Android, nếu không nó sẽ không hoạt động trong nền.
- Khi chạy lần đầu hãy chờ ~15 phút, trong khi nó tải về và dò các proxy MTProto và trong khi chính client Telegram chuyển đổi.

# Nếu không có gì hoạt động

1. Nếu KHÔNG có gì hoạt động, hãy dùng chương trình như một danh mục tự động các proxy sống. Bằng phím tắt CTRL+WIN+ALT+P và CTRL+SHIFT+ALT+P bạn có thể nhanh chóng, không cần mở cửa sổ AutoConnector, thêm một proxy ngẫu nhiên thẳng vào Telegram của bạn. Như vậy Telegram sẽ đi thẳng tới proxy, không qua AutoConnector, nhưng bạn sẽ không cần phải theo dõi các cuộc trò chuyện nơi người ta đăng proxy miễn phí và tốn thời gian kiểm tra chúng. Hãy để AutoConnector sống trong khay (tray), tắt công tắc "Коннектор" (Connector), giữ công tắc "Скан" (Scan).

2. Hãy thử AutoConnector trên một thiết bị khác: điện thoại, điện thoại của bạn bè, máy tính. Trên các nền tảng Windows/Android nguyên lý vượt chặn hoàn toàn khác nhau. Nhiều khả năng trên Android nó sẽ hoạt động mà không cần bất kỳ cài đặt nào.

3. Nếu không có gì hoạt động, thì hãy tạm bật VPN một ngày và kiểm thử AutoConnector + Telegram trong ngày đó (kết nối Telegram qua AutoConnector, chỉ định proxy ở các cổng 55001 và 55002). Bên trong chương trình hãy bật dấu tick "Khi đang bật VPN -> proxy tới MTProto". Hãy xem, AutoConnector đã bắt đầu hoạt động chưa? Nếu rồi, thì kết luận rõ ràng — AutoConnector tìm proxy thành công, chuyển tiếp lưu lượng Telegram tới đó thành công, nhưng nếu tắt VPN thì hệ thống chặn ở nước bạn chặn quá gắt tất cả các kết nối đi ra. Trong trường hợp đó bạn sẽ phải bỏ ra nửa giờ để dò các phương tiện trong AutoConnector, để chọn ra cái hoạt động được, có khả năng vượt chặn. Chương trình hiện chưa biết tự động dò hết tất cả các phương án (chỉ có sẵn việc tự động dò các mẹo anti-DPI). Sau thử nghiệm hãy tắt VPN và đưa dấu tick "Khi đang bật VPN, proxy tới MTProto" về lại trạng thái "Proxy trực tiếp".

4. Phương án thay thế cho mục (3). Hãy cài máy ảo trên host Windows/Linux của bạn. Trong đó chạy Telegram + AutoConnector. Nó bắt đầu hoạt động hoàn hảo ngay cả khi không có VPN? Vậy là host của bạn làm hỏng các kết nối của bạn, chứ không phải hệ thống chặn ở nước bạn! Nguyên nhân: tường lửa, phần mềm diệt virus, tàn dư từ VPN. Nếu phần mềm diệt virus đặt AutoConnector vào sandbox, hoặc tường lửa chặn các mẹo anti-DPI bất thường từ AutoConnector, thì bạn sẽ phải bật AutoConnector trên host bằng cách đi vòng (ngoại lệ) khỏi phần mềm diệt virus và tường lửa. Hoặc tắt hẳn chúng một thời gian, sau khi khởi động lại máy tính. Vâng, dù lời khuyên này nghe có vẻ buồn cười, hãy khởi động lại máy tính, vì các chương trình VPN thường bị lỗi và có thể để lại trên host một thiết bị TUN ở trạng thái dở sống dở chết. Sau khi khởi động lại đừng chạy VPN, hãy kiểm thử AutoConnector trước.

  5. Hãy thử việc vượt chặn. Nút bật bạn tìm trong cài đặt hoặc trên màn hình chính (tìm nút ở bên phải vòng tròn lớn màu xám/xanh). Bạn sẽ phải dành ra ~15 phút. Chúng gồm 3 nhóm:
	  - Động cơ proxy. Hãy thử bất kỳ chế độ Coalescing* nào. Nhiều khả năng nó sẽ hoạt động ngay. Nhưng khi đó hình ảnh/video trong Telegram sẽ không tải (đây không phải lỗi, mà là tính năng/sự đánh đổi). Tiếp theo hãy thử các chế độ Split*, nếu hoạt động — hình ảnh sẽ tải được. Hoặc đưa về "tắt".
	  - Hãy thử "Đua upstream song song". Nghĩa là khi Telegram tạo 1 kết nối tới proxy, AutoConnector tạo 5-30 kết nối tới các proxy MTProto khác nhau và cắm cho Telegram cái tốt nhất. Trong cài đặt ứng dụng có thể chọn timeout (3-5 giây) và số upstream song song lên tới 30 cái.
	  - Hãy bật "Tự động dò các mẹo anti-DPI", chương trình sẽ tự dò chúng.
	  - Để Telegram chuyển đổi nhanh hơn, trong cài đặt proxy (trong Telegram) hãy tự tay cứ mỗi 5-10 giây chuyển sang cổng tiếp theo theo vòng tròn 55001->55002->55001->...

6. Tổ hợp cài đặt mạnh nhất/nhanh nhất:
	- timeout kết nối 5s
	- độ rộng lựa chọn host 100%
	- kết nối song song 30
	- tự động dò các mẹo DPI
	- đua upstream song song
	- động cơ proxy: Coalescing*
	- bên trong Telegram, trong cửa sổ proxy cứ mỗi 10 giây hãy bấm vào cổng mới, theo vòng tròn.

7. Chính sách cài đặt trên Windows và Android khác nhau! Tất cả những gì viết ở trên chủ yếu liên quan đến Windows. Trên Android với đa số mọi người nó hoạt động mà không cần bất kỳ cài đặt nào (với bất kỳ cài đặt nào). Trên Windows ngăn xếp TCP khác và ứng dụng Telegram khác, nó kém hơn nhiều về chất lượng so với Android. Hãy thử một client Telegram khác, chứ không chỉ client chính thức.

8. Xin hãy viết các báo cáo lỗi chi tiết bằng bất kỳ ngôn ngữ nào tại https://t.me/AutoConnector_for_Telegram - nền tảng, bạn đã thử những cách nào (cài đặt), bạn có tường lửa/phần mềm diệt virus không, bạn đã thử từ VPN/máy ảo chưa. Hãy viết cả những công thức tích cực, bạn đã thử gì và nó đã hoạt động ra sao.


## 📥 Tải về

Tất cả các bản build — ở trang releases: **[GitHub Releases (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

| Hệ điều hành | Tệp | Khởi chạy |
|----|------|--------|
| **Android** | `AutoConnector_for_Telegram.apk` | cài đặt APK (ngoài Google Play — hãy cho phép cài từ nguồn) |
| **Windows** 10/11 x64 | `AutoConnector-for-Telegram-windows-x64.zip` | giải nén → chạy `AutoConnector\AutoConnector.exe` |
| **Linux** x64 | `AutoConnector-for-Telegram-linux-x64.tar.gz` | giải nén → `./AutoConnector/bin/AutoConnector` |
| **macOS** 11+ (Apple Silicon) | `AutoConnector-for-Telegram-macos.tar.gz` | giải nén → double-click vào `AutoConnector.app` (nếu bị chặn — `xattr -dr com.apple.quarantine AutoConnector.app`) |

### 🔐 Kiểm tra tính xác thực (release 1.1.0)

APK được ký bằng chứng chỉ release (apksigner, các sơ đồ v1+v2+v3). Trước khi cài có thể đối chiếu:

- **Chứng chỉ ký (SHA-256):** `cb23a18c0cf8a23e43b5b63d199fc1440d3e4d6533e1309d3f92f273fe626a5a`
  (CN=AutoConnector for Telegram) — dấu vân tay này giống nhau cho mọi release tương lai.
- **APK SHA-256:** `d7652e7f5c3a2174a3b7805c2539df7da080765c9b0f581a7ac5943987c9b935`
- **Windows zip SHA-256:** `1d8d675936387e89038dc4943d7f99200c1b735b86e1f79bd953cd93e60f0217`
- **Linux tar.gz SHA-256:** `9160ea519309dc62750a4a930dc1aae6e20dbcefd21b426fa85b48ace6f3e8f8`
- **macOS tar.gz SHA-256:** `322082ef3f06955ed299be790bce453e47db37fca17daea54724d60698446bc7`

Kiểm tra: `apksigner verify --print-certs AutoConnector_for_Telegram.apk` (chứng chỉ) và
`sha256sum -c SHA256SUMS.txt` (tính toàn vẹn của các tệp; `SHA256SUMS.txt` đính kèm trong release).

## 📸 Ảnh chụp màn hình

<table>
<tr>
<td align="center"><img src="docs/screenshots/connector.png" width="200"><br><sub>Connector — phiên đang hoạt động</sub></td>
<td align="center"><img src="docs/screenshots/scan.png" width="200"><br><sub>Quét và đồ thị</sub></td>
<td align="center"><img src="docs/screenshots/catalog.png" width="200"><br><sub>Danh mục proxy (theo chế độ)</sub></td>
<td align="center"><img src="docs/screenshots/host-card.png" width="200"><br><sub>Thẻ host + lịch sử</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/logs.png" width="200"><br><sub>Log của relay</sub></td>
<td align="center"><img src="docs/screenshots/settings.png" width="200"><br><sub>Cài đặt</sub></td>
<td align="center"><img src="docs/screenshots/export.png" width="200"><br><sub>Xuất các liên kết tg://</sub></td>
<td align="center"><img src="docs/screenshots/hotkeys.png" width="200"><br><sub>Phím tắt</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/guide.png" width="200"><br><sub>Hướng dẫn kết nối</sub></td>
<td align="center"><img src="docs/screenshots/connector-ru.png" width="200"><br><sub>Connector · giao diện tiếng Nga</sub></td>
<td align="center"><img src="docs/screenshots/scan-ru.png" width="200"><br><sub>Quét · giao diện tiếng Nga</sub></td>
<td align="center"><sub>26 ngôn ngữ giao diện<br>với tự động phát hiện</sub></td>
</tr>
</table>


## Phản hồi

Lỗi và góp ý hãy gửi về đây - https://t.me/AutoConnector_for_Telegram

## 🔐 Kiểm tra chữ ký

APK từ các release được ký bằng khóa release. Có thể kiểm tra như sau:

```bash
# Tổng kiểm tra (so sánh với SHA256SUMS.txt từ release)
sha256sum AutoConnector_for_Telegram.apk

# Chữ ký số và dấu vân tay chứng chỉ
apksigner verify --print-certs AutoConnector_for_Telegram.apk
```

Dấu vân tay chứng chỉ (SHA-256) dùng để ký các bản build chính thức
được công bố trong phần mô tả của mỗi release — hãy đối chiếu nó để chắc chắn rằng APK
không bị thay thế.

## 📄 Giấy phép

[MIT](LICENSE).
