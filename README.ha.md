[ENGLISH](README.en.md) · [AMHARIC](README.am.md) · [ARABIC](README.ar.md) · [AZERBAIJANI](README.az.md) · [BENGALI](README.bn.md) · [BURMESE](README.my.md) · [CHINESE](README.zh.md) · [DARI](README.prs.md) · [FRENCH](README.fr.md) · [GERMAN](README.de.md) · [HAUSA](README.ha.md) · [HINDI](README.hi.md) · [INDONESIAN](README.id.md) · [ITALIAN](README.it.md) · [JAPANESE](README.ja.md) · [KAZAKH](README.kk.md) · [KOREAN](README.ko.md) · [MARATHI](README.mr.md) · [PASHTO](README.ps.md) · [PERSIAN](README.fa.md) · [POLISH](README.pl.md) · [PORTUGUESE](README.pt.md) · [PUNJABI](README.pa.md) · [RUSSIAN](README.md) · [SPANISH](README.es.md) · [TAMIL](README.ta.md) · [TELUGU](README.te.md) · [THAI](README.th.md) · [TIGRINYA](README.ti.md) · [TURKISH](README.tr.md) · [UKRAINIAN](README.uk.md) · [URDU](README.ur.md) · [UZBEK](README.uz.md) · [VIETNAMESE](README.vi.md)

**[Sauke (na baya-bayan nan)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

# AutoConnector for Telegram

AutoConnector for Telegram — wannan manhaja tana neman MTProto proxy a kan intanet da kanta, tana tabbatar da cewa suna aiki, sannan tana kafa wani relay na cikin gida wanda ta hanyarsa Telegram ke ci gaba da aiki yadda ya kamata ko da a inda aka toshe shi. Mai amfani ba sai ya yi neman proxy masu aiki da hannu ba — AutoConnector for Telegram a koyaushe yana zaɓar masu sauri da rai, sannan yana gwada su musamman daga kwamfutarka/wayarka.

A wata ma'anar: yana scanner na tashoshin Telegram da kowane irin subscription da ke da MTProto proxy na jama'a kyauta, tare da saka su kai tsaye cikin Telegram ɗinka. Babu buƙatar sabunta abokin huldar Telegram. Ana duba isar proxy daga na'urarka da yanayin sadarwarka. Yana aiki a Wi-Fi + LTE ba tare da VPN ba.

Dandamali: Android, Windows, Linux, MacBook.

Sigar Android tana aiki da kanta, yayin da a Windows kana buƙatar kunna injin proxying — "SPLIT..." ko "COALESCING.." — a cikin saiti, ko ta hanyar maɓallin da ke dama ga kalmomin "Telegram connected" da babban da'irar mai launin toka/kore. Ko zaɓi wanda ya fi maka aiki da kanka, tunda toshewa ta bambanta a ko'ina. Hanyoyin "COALESCING.." su ne mafita ta ƙarshe — Telegram zai fara aiki, amma aikawa/nuna abun cikin media a cikin tattaunawa zai lalace.

Ina ba da shawarar kashe firewall kamar COMODO idan kana amfani da shi: yana sanya manhaja cikin sandbox, kuma firewall ɗinsa yana lalata haɗin waje zuwa MTProto proxy. Ko gudanar da manhaja a cikin virtual machine — a can TCP stack yana canzawa gaba ɗaya, kuma halayyar AutoConnector za ta bambanta.

Hakanan, taimaka wa Telegram ya canza tsakanin tashoshin 55001 da 55002 da hannu (a cikin saitin proxy) don isa ga proxy mai aiki da sauri da samun lakabin "Connected" a cikin Telegram.

# ✨ Fasaloli

- **Neman proxy ta atomatik** — yana scan ɗimbin shafuka da subscription a buɗe.
- **Dubawar rai** — handshake na MTProto na gaske, ana ƙididdiga shi bisa sauri/kwanciyar hankali.
- **Relay na cikin gida** — Telegram yana haɗawa da `127.0.0.1`, sannan AutoConnector for
  Telegram yana tura zirga-zirga ta hanyar mafi kyawun proxy mai rai kuma yana canzawa
  idan na yanzu ya faɗi.
- **Anti-DPI** — saitin dabarun ɓoyewa (kwaikwayon browser, raba
  packet, FakeTLS, da sauransu); yanayin "Auto-rotate" yana zaɓar mai aiki da kansa.
- **Cikakkun ƙididdiga** — proxy masu rai/matattu, sauri, jinkiri, zirga-zirga,
  inganci na kowace dabarar anti-DPI.
- **Katalogin proxy** — na sama bisa ƙima, tare da cikakken katin kowane host:
  kowane host yana nuna "Telegram connects / nasara / jimillar dubawa" da
  ƙoƙarin 25 na ƙarshe (TCP/TLS/jimillar lokacin haɗawa, bytes da aka karɓa/aiko).
- **Zaɓin host mai sassauci** — slider na "faɗi": daga "tsaya kan mafi kyawun host masu tabbaci"
  zuwa "gwada da faɗi gwargwadon iko a cikin masu rai"; idan Telegram yana tsallaka
  tsakanin tashoshin relay, zaɓin yana faɗaɗa ta atomatik. Wani slider daban — lokacin
  fita na haɗawa (100 ms … 15 s) — da "upstream race" (haɗi da yawa a layi ɗaya).
- **Harsuna 12 na UI** tare da gano kai-da-kai da goyon bayan RTL.

> ### Abin da ke sabo tun 1.0.19
> - **Tafkin host da ƙima daban-daban ga kowane irin sadarwa** — VPN / Wi-Fi / LTE /
>   Ethernet / White: kowane irin haɗi yana riƙe da tafkin nasa na proxy masu rai, don
>   kada a taɓa ba Telegram wani abu da ke aiki kawai a ƙarƙashin VPN.
> - **Upstream race** — haɗi da yawa a layi ɗaya, mafi sauri mai rai ya yi nasara;
>   slider na "faɗin zaɓi" (daga mafi kyau-da-tabbaci zuwa mafi-faɗi-gwargwadon iko) tare da
>   tafki mai faɗaɗa kai-da-kai idan Telegram ke tsallaka tsakanin tashoshin relay;
>   lokacin fita na haɗawa mai daidaitawa (100 ms…15 s).
> - **Katalogin host tare da cikakken kati** — "Telegram connects / nasara /
>   jimillar dubawa" tare da ƙoƙarin 25 na ƙarshe ga kowane host (lokacin TCP/TLS,
>   lokacin haɗawa, bytes da aka karɓa/aiko).
> - **Jadawalai masu rai** na sauri, ping da aikin tashar (kowane daƙiƙa da kowane minti)
>   tare da jadawalan scan.
> - **Anti-DPI da injunan proxying** — saitin dabarun ɓoyewa tare da
>   yanayin "Auto-rotate", injin obfuscation, da injuna na gwaji (split/
>   coalescing) don dacewa da takamaiman toshewa.
> - **Fitarwa/shigarwa** na saiti, host da subscription + cikakken sake saita zuwa na masana'anta.
> - **Farawa mai sanyi da sauri** — saukar subscription mai zaren da yawa mai ƙarfi ta hanyar
>   anonymizer da dama.
> - **Harsuna 26 na UI** tare da gano kai-da-kai (+RTL).

# Muhimmi a farawa ta farko:

- Saita Telegram da SOCKS5 proxy kafaffe localhost:55001 da localhost:55002.
- Goge sauran proxy in ban da waɗannan.
- Kunna "Use proxy" a cikin Telegram.
- Kada ka toshe sanarwa a Android, in ba haka ba ba zai gudana a baya ba.
- A farawa ta farko, jira kusan minti 15 yayin da yake saukarwa da kewaya MTProto proxy kuma yayin da abokin huldar Telegram da kansa yake canzawa.

# Idan babu abin da ke aiki

1. Idan BABU abin da ke aiki, yi amfani da shirin a matsayin katalogin proxy masu rai na atomatik. Tare da hotkeys CTRL+WIN+ALT+P da CTRL+SHIFT+ALT+P za ka iya ƙara proxy bazuwar cikin sauri kai tsaye cikin Telegram ɗinka ba tare da ma buɗe taga AutoConnector ba. Sakamakon shi ne Telegram zai tafi kai tsaye zuwa proxy, ba tare da AutoConnector ba, amma ba sai ka sa ido kan tattaunawar da ake buga proxy kyauta ka ɓata lokaci kana dubansu ba. Bari AutoConnector ya zauna a cikin tray, kashe maɓallin "Connector", bar maɓallin "Scan" a kunne.

2. Gwada AutoConnector a kan wata na'ura: wayarka, wayar aboki, kwamfuta. Ƙa'idar ƙetare toshewa ta bambanta gaba ɗaya tsakanin dandamali na Windows/Android. Wataƙila zai yi aiki a Android ba tare da wani saiti ba ko kaɗan.

3. Idan babu abin da ke aiki, to kunna VPN na ɗan lokaci na rana ɗaya ka gwada AutoConnector + Telegram a cikin wannan ranar (haɗa Telegram ta hanyar AutoConnector, kana ƙayyade proxy a tashoshin 55001 da 55002). A cikin shirin, sanya alama a akwatin "When VPN is on -> proxy to MTProto". Duba ko AutoConnector ya fara aiki. Idan haka ne, to ƙarshen a bayyane yake — AutoConnector yana samun proxy cikin nasara kuma yana relay zirga-zirgar Telegram zuwa can cikin nasara, amma idan ka kashe VPN, tsarin toshewa a ƙasarka yana toshe duk haɗin waje da tsanani sosai. A wannan yanayin za ka buƙaci ɓata rabin sa'a kana kewaya kayan aikin AutoConnector don zaɓar mai aiki da zai iya ƙetare toshewa. Shirin har yanzu ba zai iya kewaya duk zaɓuɓɓuka ta atomatik ba (akwai kawai juyawar dabarun anti-DPI ta atomatik). Bayan gwajin, kashe VPN ka mayar da akwatin "When VPN is on, proxy to MTProto" zuwa yanayin "Proxy directly".

4. Madadin maki na (3). Sanya virtual machine a kan host ɗin Windows/Linux ɗinka. Gudanar da Telegram + AutoConnector a cikinsa. Shin ya fara aiki sosai ko da ba tare da VPN ba? Wannan yana nufin host ɗinka yana lalata haɗinka, ba tsarin toshewa a ƙasarka ba! Dalilai: firewall, antivirus, ragowar VPN. Idan antivirus ya sanya AutoConnector cikin sandbox, ko firewall ya toshe dabarun anti-DPI na AutoConnector da ba a saba ba, to za ka buƙaci gudanar da AutoConnector a kan host ta hanyar ƙetare antivirus da firewall (banbance-banbance). Ko kashe su gaba ɗaya na ɗan lokaci ka sake kunna kwamfutar. Ee, ko da abin dariya ne a ba da shawara, sake kunna kwamfutar, domin shirye-shiryen VPN sukan yi glitch kuma za su iya barin na'urar TUN a kan host a cikin yanayin rabin-rai. Bayan sake kunnawa, kada ka fara VPN — gwada AutoConnector da farko.

  5. Gwada ƙetare toshewa. Nemi maɓallin kunnawa a cikin saiti ko a babban allo (nemi maɓallin da ke dama ga babban da'irar mai launin toka/kore). Za ka buƙaci ɓata kusan minti 15. Sun ƙunshi ƙungiyoyi 3:
	  - Injin proxying. Gwada kowane yanayin Coalescing*. Wataƙila zai yi aiki nan da nan. Amma hotuna/bidiyo ba za su loda a Telegram da shi ba (wannan ba kwaro ba ne, sai dai fasali/cinikayya). Na gaba, gwada yanayin Split*; idan ya yi aiki — hotuna suna loda. Ko mayar da shi zuwa "off".
	  - Gwada "Parallel upstream race". Wannan yana nufin cewa idan Telegram ya yi haɗi 1 zuwa proxy, AutoConnector yana yin haɗi 5-30 zuwa MTProto proxy daban-daban kuma yana ba Telegram mafi kyau. A cikin saitin manhaja za ka iya zaɓar timeouts (3-5 daƙiƙa) da adadin upstream a layi ɗaya, har zuwa 30.
	  - Kunna "Auto-rotate anti-DPI tricks", sannan shirin zai kewaya su da kansa.
	  - Don sa Telegram ya canza da sauri, a cikin saitin proxy (a cikin Telegram) canza da hannu zuwa tashar gaba a cikin madauki kowane daƙiƙa 5-10: 55001->55002->55001->...

6. Mafi ƙarfi/sauri haɗin saiti:
	- lokacin fita na haɗawa 5s
	- faɗin zaɓin host 100%
	- haɗi 30 a layi ɗaya
	- juya dabarun DPI ta atomatik
	- parallel upstream race
	- injin proxying: Coalescing*
	- a cikin Telegram, a cikin taga proxy, danna sabuwar tashar kowane daƙiƙa 10, a cikin madauki.

7. Manufar saiti a Windows da Android ta bambanta! Duk abin da aka rubuta a sama galibi ya shafi Windows. A Android yana aiki ga yawancin mutane ba tare da wani saiti ba (da kowane saiti). Windows yana da TCP stack daban da manhajar Telegram daban, wadda ta fi ta Android muni sosai a inganci. Gwada wani abokin huldar Telegram, ba kawai na hukuma ba.

8. Don Allah rubuta cikakkun rahotannin kwaro a kowane harshe a https://t.me/AutoConnector_for_Telegram — dandamalinka, waɗanne hanyoyi ka gwada (saiti), ko kana da firewall/antivirus, ko ka gwada daga VPN/virtual machine. Hakanan rubuta kowane sahihiyar girki — abin da ka gwada da yadda ya fara aiki.


## 📥 Sauke

Duk builds suna a shafin releases: **[GitHub Releases (na baya-bayan nan)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

| OS | Fayil | Gudanarwa |
|----|------|--------|
| **Android** | `AutoConnector_for_Telegram.apk` | sanya APK (a waje da Google Play — bar shigarwa daga tushe) |
| **Windows** 10/11 x64 | `AutoConnector-for-Telegram-windows-x64.zip` | fitar → gudanar da `AutoConnector\AutoConnector.exe` |
| **Linux** x64 | `AutoConnector-for-Telegram-linux-x64.tar.gz` | fitar → `./AutoConnector/bin/AutoConnector` |
| **macOS** 11+ (Apple Silicon) | `AutoConnector-for-Telegram-macos.tar.gz` | fitar → danna sau biyu `AutoConnector.app` (idan an toshe — `xattr -dr com.apple.quarantine AutoConnector.app`) |

### 🔐 Sahihanci (release 1.1.0)

An sa hannu kan APK da takardar shaidar release (apksigner, schemes v1+v2+v3). Kafin shigarwa za ka iya tabbatarwa:

- **Takardar shaidar sa hannu (SHA-256):** `cb23a18c0cf8a23e43b5b63d199fc1440d3e4d6533e1309d3f92f273fe626a5a`
  (CN=AutoConnector for Telegram) — wannan fingerprint iri ɗaya ne a duk releases na gaba.
- **APK SHA-256:** `d7652e7f5c3a2174a3b7805c2539df7da080765c9b0f581a7ac5943987c9b935`
- **Windows zip SHA-256:** `1d8d675936387e89038dc4943d7f99200c1b735b86e1f79bd953cd93e60f0217`
- **Linux tar.gz SHA-256:** `9160ea519309dc62750a4a930dc1aae6e20dbcefd21b426fa85b48ace6f3e8f8`
- **macOS tar.gz SHA-256:** `322082ef3f06955ed299be790bce453e47db37fca17daea54724d60698446bc7`

Tabbatar da: `apksigner verify --print-certs AutoConnector_for_Telegram.apk` (takardar shaida) da
`sha256sum -c SHA256SUMS.txt` (amincin fayil; an haɗa `SHA256SUMS.txt` da release).

## 📸 Hotunan allo

<table>
<tr>
<td align="center"><img src="docs/screenshots/connector.png" width="200"><br><sub>Connector — zaman aiki</sub></td>
<td align="center"><img src="docs/screenshots/scan.png" width="200"><br><sub>Scan da jadawalai</sub></td>
<td align="center"><img src="docs/screenshots/catalog.png" width="200"><br><sub>Katalogin proxy (bisa yanayi)</sub></td>
<td align="center"><img src="docs/screenshots/host-card.png" width="200"><br><sub>Katin host + tarihi</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/logs.png" width="200"><br><sub>Logs na relay</sub></td>
<td align="center"><img src="docs/screenshots/settings.png" width="200"><br><sub>Saiti</sub></td>
<td align="center"><img src="docs/screenshots/export.png" width="200"><br><sub>Fitar da hanyoyin tg://</sub></td>
<td align="center"><img src="docs/screenshots/hotkeys.png" width="200"><br><sub>Hotkeys</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/guide.png" width="200"><br><sub>Jagorar haɗi</sub></td>
<td align="center"><img src="docs/screenshots/connector-ru.png" width="200"><br><sub>Connector · UI na Rashanci</sub></td>
<td align="center"><img src="docs/screenshots/scan-ru.png" width="200"><br><sub>Scan · UI na Rashanci</sub></td>
<td align="center"><sub>Harsuna 26 na UI<br>tare da gano kai-da-kai</sub></td>
</tr>
</table>


## Ra'ayoyi

Aiko da kwaro da ra'ayoyi anan - https://t.me/AutoConnector_for_Telegram

## 🔐 Tabbatar da sa hannu

An sa hannu kan APK daga releases da maɓallin release. Za ka iya tabbatar da shi kamar haka:

```bash
# Checksum (kwatanta da SHA256SUMS.txt daga release)
sha256sum AutoConnector_for_Telegram.apk

# Sa hannu na dijital da fingerprint na takardar shaida
apksigner verify --print-certs AutoConnector_for_Telegram.apk
```

Fingerprint na takardar shaida (SHA-256) da aka yi amfani da shi don sa hannu kan builds na hukuma
ana buga shi a cikin bayanin kowane release — kwatanta shi don tabbatar da cewa ba a yi wa APK
zagon ƙasa ba.

## 📄 Lasisi

[MIT](LICENSE).
