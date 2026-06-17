[ENGLISH](README.en.md) · [ARABIC](README.ar.md) · [BENGALI](README.bn.md) · [BURMESE](README.my.md) · [CHINESE](README.zh.md) · [FRENCH](README.fr.md) · [GERMAN](README.de.md) · [HINDI](README.hi.md) · [INDONESIAN](README.id.md) · [ITALIAN](README.it.md) · [JAPANESE](README.ja.md) · [KOREAN](README.ko.md) · [MARATHI](README.mr.md) · [PERSIAN](README.fa.md) · [POLISH](README.pl.md) · [PORTUGUESE](README.pt.md) · [PUNJABI](README.pa.md) · [RUSSIAN](README.md) · [SPANISH](README.es.md) · [TAMIL](README.ta.md) · [TELUGU](README.te.md) · [THAI](README.th.md) · [TURKISH](README.tr.md) · [UKRAINIAN](README.uk.md) · [URDU](README.ur.md) · [VIETNAMESE](README.vi.md)

**[Download (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

# AutoConnector for Telegram

AutoConnector for Telegram — 앱이 직접 인터넷에서 MTProto 프록시를 찾아 작동 여부를 확인하고 로컬 릴레이를 띄워, 그 릴레이를 통해 Telegram이 차단된 곳에서도 안정적으로 작동하게 합니다. 사용자가 직접 작동하는 프록시를 찾을 필요가 없습니다 — AutoConnector for Telegram이 가장 빠르고 살아 있는 프록시를 계속 골라내며, 바로 당신의 컴퓨터/휴대폰에서 테스트합니다.

다시 말해: 이것은 공개된 무료 MTProto 프록시가 올라오는 텔레그램 채널과 온갖 구독 소스를 스캔하여, 당신의 Telegram에 자동으로 넣어 주는 스캐너입니다. Telegram 클라이언트를 업데이트할 필요가 없습니다. 프록시 가용성은 바로 당신의 기기와 네트워크 환경에서 확인합니다. VPN 없이 WiFi+LTE에서 작동합니다.

플랫폼: Android, Windows, Linux, MacBook.

안드로이드 버전은 그 자체로 작동하지만, Windows에서는 프록시 엔진 "스플릿..." 또는 "코알레싱.."을 설정해야 합니다 — 설정에서 켜거나, "Telegram 연결됨"이라는 문구와 큰 회색/녹색 원의 오른쪽에 있는 버튼으로 켭니다. 또는 차단 방식이 곳곳마다 다르므로, 당신에게 가장 잘 작동하는 것을 직접 골라야 합니다. "코알레싱.." 모드는 최후의 수단입니다 — 이렇게 하면 Telegram이 작동하기 시작하지만, 채팅에서 미디어 콘텐츠의 전송/표시가 망가집니다.

COMODO 같은 방화벽을 사용한다면 끄는 것을 권장합니다: 앱을 샌드박스에 가두고, 그 방화벽이 MTProto 프록시로 나가는 연결을 망가뜨립니다. 또는 앱을 가상 머신에서 실행하세요 — 거기서는 TCP 스택이 완전히 바뀌어, AutoConnector의 동작이 달라집니다.

또한 더 빠르게 작동하는 프록시와 Telegram 내부의 "연결됨" 문구에 도달하려면, Telegram이 포트 55001과 55002 사이를 전환하도록 직접 도와주세요(프록시 설정에서).

# ✨ 기능

- **프록시 자동 검색** — 수십 개의 공개 페이지와 구독을 스캔합니다.
- **작동 여부 확인** — 실제 MTProto 핸드셰이크, 속도/안정성 기준 순위.
- **로컬 릴레이** — Telegram은 `127.0.0.1`에 연결하고, AutoConnector for
  Telegram은 가장 좋은 살아 있는 프록시를 통해 트래픽을 라우팅하며, 현재 프록시가
  죽으면 전환합니다.
- **안티-DPI** — 위장 기법 모음(브라우저 모방, 패킷 분할,
  FakeTLS 등); "자동 순회" 모드는 작동하는 것을 직접 골라냅니다.
- **상세 통계** — 살아 있는/죽은 프록시, 속도, 레이턴시, 트래픽,
  각 안티-DPI 기법의 효율.
- **프록시 카탈로그** — 순위 상위 목록과 호스트별 상세 카드:
  각 호스트마다 "Telegram 연결 수 / 성공 / 전체 검사 수"와
  최근 25회 시도 기록(TCP/TLS/전체 연결 소요 시간, 수신/송신 바이트)을 볼 수 있습니다.
- **유연한 호스트 선택** — "폭" 슬라이더: "검증된 최상의 것만 유지"부터
  "가능한 한 넓게 다양한 살아 있는 것을 시도"까지; Telegram이 릴레이 포트를
  이리저리 헤맬 때 선택 폭이 자동으로 넓어집니다. 별도의 슬라이더로 연결
  타임아웃(100ms … 15s)과 "업스트림 경쟁"(여러 연결을 병렬로)을 조절합니다.
- **12개 언어** 인터페이스, 자동 감지, RTL 지원.

> ### 1.0.19 대비 새로운 점
> - **네트워크 유형별 분리된 호스트 데이터베이스와 순위** — VPN / Wi-Fi / LTE /
>   Ethernet / White: 각 연결 종류마다 자체적인 살아 있는 프록시 풀을 유지하여,
>   VPN에서만 작동하는 것을 Telegram에 넣지 않도록 합니다.
> - **업스트림 경쟁** — 여러 연결을 병렬로 시도하여 가장 빠른 살아 있는 것이
>   이깁니다; "선택 폭" 슬라이더(검증된 최상의 것부터 가능한 한 넓은 것까지)와
>   Telegram이 릴레이 포트를 헤맬 때 풀을 자동으로 넓히는 기능;
>   조절 가능한 연결 타임아웃(100ms…15s).
> - **상세 카드가 있는 호스트 카탈로그** — "Telegram 연결 수 / 성공 /
>   전체 검사 수"와 호스트별 최근 25회 시도 기록(TCP/TLS 시간,
>   연결 소요 시간, 수신/송신 바이트).
> - **실시간 그래프** — 속도, 핑, 포트 활동(초·분 단위)
>   그리고 스캔 그래프.
> - **안티-DPI 및 프록시 엔진** — "자동 순회"가 있는 위장 기법 모음,
>   난독화 엔진, 그리고 특정 차단에 맞춘 실험적 엔진(스플릿/
>   코알레싱).
> - **설정, 호스트, 구독의 내보내기/가져오기** + 공장 초기 상태로의 완전 초기화.
> - **빠른 콜드 스타트** — 여러 익명화 도구를 통한 공격적인 멀티스레드 구독 다운로드.
> - **26개 언어** 인터페이스, 자동 감지(+RTL).

# 처음 실행할 때 중요한 점:

- 고정 SOCKS5 프록시 localhost:55001과 localhost:55002를 지정하여 Telegram을 설정하세요.
- 이 두 개를 제외한 다른 프록시는 삭제하세요.
- Telegram에서 "프록시 사용"을 켜세요.
- 안드로이드에서 알림을 차단하지 마세요. 그렇지 않으면 백그라운드에서 작동하지 않습니다.
- 처음 실행할 때는 MTProto 프록시를 다운로드하고 순회하며, Telegram 클라이언트 자체가 전환될 때까지 약 15분 기다리세요.

# 아무것도 작동하지 않을 때

1. 만약 아무것도 작동하지 않는다면, 이 프로그램을 살아 있는 프록시의 자동 카탈로그로 사용하세요. 단축키 CTRL+WIN+ALT+P와 CTRL+SHIFT+ALT+P로 AutoConnector 창을 열지 않고도 무작위 프록시를 빠르게 바로 Telegram에 추가할 수 있습니다. 이렇게 하면 Telegram이 AutoConnector 없이 프록시로 직접 가게 되지만, 무료 프록시가 올라오는 채팅을 모니터링하고 그것들을 확인하는 데 시간을 쓸 필요가 없게 됩니다. AutoConnector를 트레이에 두고, "Connector" 토글을 끄고, "Scan" 토글은 켜둔 채로 두세요.

2. 다른 기기에서 AutoConnector를 시도해 보세요: 휴대폰, 친구의 휴대폰, 컴퓨터. Windows/Android 플랫폼마다 차단 우회 원리가 완전히 다릅니다. Android에서는 아무 설정 없이도 작동할 가능성이 높습니다.

3. 아무것도 작동하지 않는다면, 하루 동안 임시로 VPN을 켜고 그 하루 동안 AutoConnector + Telegram을 테스트하세요(Telegram은 포트 55001과 55002의 프록시를 지정하여 AutoConnector를 통해 연결). 프로그램 안에서 "VPN이 켜져 있을 때 -> MTProto로 프록시" 체크박스를 켜세요. AutoConnector가 작동하기 시작했나요? 그렇다면 결론은 분명합니다 — AutoConnector는 프록시를 성공적으로 찾고 Telegram 트래픽을 성공적으로 그곳으로 전달하지만, VPN을 끄면 당신 나라의 차단 시스템이 모든 나가는 연결을 너무 강하게 차단하는 것입니다. 그런 경우에는 차단을 우회할 수 있는 작동하는 수단을 고르기 위해 AutoConnector에서 30분 정도 시간을 들여 수단들을 순회해야 합니다. 모든 옵션을 자동으로 완전히 순회하는 기능은 아직 없습니다(anti-DPI 트릭의 자동 순회만 있습니다). 실험이 끝나면 VPN을 끄고 "VPN이 켜져 있을 때 MTProto로 프록시" 체크박스를 "직접 프록시" 상태로 되돌리세요.

4. (3)의 대안. 당신의 Windows/Linux 호스트에 가상 머신을 설치하세요. 그 안에서 Telegram + AutoConnector를 실행하세요. VPN 없이도 완벽하게 작동하기 시작했나요? 그렇다면 당신 나라의 차단 시스템이 아니라, 당신의 호스트가 연결을 망가뜨리고 있는 것입니다! 원인: 방화벽, 안티바이러스, VPN 잔재물. 안티바이러스가 AutoConnector를 샌드박스에 넣거나, 방화벽이 AutoConnector의 비정상적인 anti-DPI 트릭을 차단한다면, 호스트에서 안티바이러스와 방화벽을 우회(예외)하여 AutoConnector를 켜야 합니다. 또는 컴퓨터를 재부팅하여 잠시 동안 아예 꺼두세요. 그렇습니다, 우습게 들릴지 몰라도 컴퓨터를 재부팅하세요 — VPN 프로그램은 자주 오작동하며 호스트에 TUN 장치를 반쯤 살아 있는 상태로 남길 수 있습니다. 재부팅 후에는 VPN을 실행하지 말고, 먼저 AutoConnector를 테스트하세요.

  5. 차단 우회를 시도해 보세요. 켜는 버튼은 설정이나 메인 화면에서 찾으세요(큰 회색/녹색 원의 오른쪽에 있는 버튼을 찾으세요). 약 15분 정도 시간을 들여야 합니다. 이것은 3개 그룹으로 구성됩니다:
	  - 프록시 엔진. 아무 코알레싱* 모드나 시도해 보세요. 바로 작동할 가능성이 높습니다. 다만 그러면 Telegram에서 사진/영상이 로드되지 않습니다(이것은 버그가 아니라 기능/타협입니다). 그다음 스플릿* 모드를 시도하세요. 작동하면 사진이 로드됩니다. 또는 "꺼짐"으로 되돌리세요.
	  - "업스트림 병렬 경쟁"을 시도하세요. 이것은 Telegram이 프록시로 1개의 연결을 할 때, AutoConnector가 서로 다른 MTProto 프록시로 5-30개의 연결을 만들어 Telegram에게 가장 좋은 것을 넣어 준다는 뜻입니다. 앱 설정에서 타임아웃(3-5초)과 병렬 업스트림 수를 최대 30개까지 선택할 수 있습니다.
	  - "anti-DPI 트릭 자동 순회"를 켜세요. 프로그램이 직접 그것들을 순회합니다.
	  - Telegram이 더 빠르게 전환하도록, (Telegram의) 프록시 설정에서 5-10초마다 직접 다음 포트로 순환하며 전환하세요 55001->55002->55001->...

6. 가장 강력하고/빠른 설정 조합:
	- 연결 타임아웃 5초
	- 호스트 선택 폭 100%
	- 병렬 연결 30개
	- DPI 트릭 자동 순회
	- 업스트림 병렬 경쟁
	- 프록시 엔진: 코알레싱*
	- Telegram 안의 프록시 창에서 10초마다 새 포트를 순환하며 누르세요.

7. Windows와 Android의 설정 정책은 다릅니다! 위에 쓴 모든 것은 주로 Windows에 해당합니다. Android에서는 대부분의 사람에게 어떤 설정으로도(설정과 무관하게) 작동합니다. Windows는 TCP 스택이 다르고 Telegram 앱도 다른데, Android보다 품질이 훨씬 나쁩니다. 공식 클라이언트만이 아니라 다른 Telegram 클라이언트도 시도해 보세요.

8. 어떤 언어로든 자세한 버그 리포트를 https://t.me/AutoConnector_for_Telegram 에 적어 주세요 - 플랫폼, 어떤 방법을 시도했는지(설정), 방화벽/안티바이러스가 있는지, VPN/가상 머신에서 시도했는지. 무엇을 시도해서 어떻게 작동하게 되었는지 긍정적인 레시피도 적어 주세요.


## 📥 다운로드

모든 빌드는 릴리스 페이지에 있습니다: **[GitHub Releases (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

| OS | 파일 | 실행 |
|----|------|--------|
| **Android** | `AutoConnector_for_Telegram.apk` | APK 설치(Google Play 외부 — 출처에서의 설치를 허용하세요) |
| **Windows** 10/11 x64 | `AutoConnector-for-Telegram-windows-x64.zip` | 압축 해제 → `AutoConnector\AutoConnector.exe` 실행 |
| **Linux** x64 | `AutoConnector-for-Telegram-linux-x64.tar.gz` | 압축 해제 → `./AutoConnector/bin/AutoConnector` |
| **macOS** 11+ (Apple Silicon) | `AutoConnector-for-Telegram-macos.tar.gz` | 압축 해제 → `AutoConnector.app` 더블 클릭(차단되면 — `xattr -dr com.apple.quarantine AutoConnector.app`) |

### 🔐 진위 확인 (release 1.1.0)

APK는 release 인증서로 서명되어 있습니다(apksigner, v1+v2+v3 방식). 설치 전에 대조할 수 있습니다:

- **서명 인증서 (SHA-256):** `cb23a18c0cf8a23e43b5b63d199fc1440d3e4d6533e1309d3f92f273fe626a5a`
  (CN=AutoConnector for Telegram) — 이 지문은 모든 향후 릴리스에서 동일합니다.
- **APK SHA-256:** `d7652e7f5c3a2174a3b7805c2539df7da080765c9b0f581a7ac5943987c9b935`
- **Windows zip SHA-256:** `1d8d675936387e89038dc4943d7f99200c1b735b86e1f79bd953cd93e60f0217`
- **Linux tar.gz SHA-256:** `9160ea519309dc62750a4a930dc1aae6e20dbcefd21b426fa85b48ace6f3e8f8`
- **macOS tar.gz SHA-256:** `322082ef3f06955ed299be790bce453e47db37fca17daea54724d60698446bc7`

확인: `apksigner verify --print-certs AutoConnector_for_Telegram.apk`(인증서) 그리고
`sha256sum -c SHA256SUMS.txt`(파일 무결성; `SHA256SUMS.txt`는 릴리스에 첨부되어 있습니다).

## 📸 스크린샷

<table>
<tr>
<td align="center"><img src="docs/screenshots/connector.png" width="200"><br><sub>Connector — 활성 세션</sub></td>
<td align="center"><img src="docs/screenshots/scan.png" width="200"><br><sub>스캔과 그래프</sub></td>
<td align="center"><img src="docs/screenshots/catalog.png" width="200"><br><sub>프록시 카탈로그(모드별)</sub></td>
<td align="center"><img src="docs/screenshots/host-card.png" width="200"><br><sub>호스트 카드 + 기록</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/logs.png" width="200"><br><sub>릴레이 로그</sub></td>
<td align="center"><img src="docs/screenshots/settings.png" width="200"><br><sub>설정</sub></td>
<td align="center"><img src="docs/screenshots/export.png" width="200"><br><sub>tg:// 링크 내보내기</sub></td>
<td align="center"><img src="docs/screenshots/hotkeys.png" width="200"><br><sub>단축키</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/guide.png" width="200"><br><sub>연결 가이드</sub></td>
<td align="center"><img src="docs/screenshots/connector-ru.png" width="200"><br><sub>Connector · 러시아어 UI</sub></td>
<td align="center"><img src="docs/screenshots/scan-ru.png" width="200"><br><sub>스캔 · 러시아어 UI</sub></td>
<td align="center"><sub>26개 언어 인터페이스<br>자동 감지 지원</sub></td>
</tr>
</table>


## 피드백

버그와 의견은 여기로 보내 주세요 - https://t.me/AutoConnector_for_Telegram

## 🔐 서명 확인

릴리스의 APK는 release 키로 서명되어 있습니다. 다음과 같이 확인할 수 있습니다:

```bash
# 체크섬 (릴리스의 SHA256SUMS.txt와 비교하세요)
sha256sum AutoConnector_for_Telegram.apk

# 디지털 서명과 인증서 지문
apksigner verify --print-certs AutoConnector_for_Telegram.apk
```

공식 빌드를 서명한 인증서 지문(SHA-256)은 각 릴리스 설명에
게시됩니다 — APK가 변조되지 않았음을 확인하려면 그것을 대조하세요.

## 📄 라이선스

[MIT](LICENSE).
