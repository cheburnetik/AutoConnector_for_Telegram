[ENGLISH](README.en.md) · [AMHARIC](README.am.md) · [ARABIC](README.ar.md) · [AZERBAIJANI](README.az.md) · [BENGALI](README.bn.md) · [BURMESE](README.my.md) · [CHINESE](README.zh.md) · [DARI](README.prs.md) · [FRENCH](README.fr.md) · [GERMAN](README.de.md) · [HAUSA](README.ha.md) · [HINDI](README.hi.md) · [INDONESIAN](README.id.md) · [ITALIAN](README.it.md) · [JAPANESE](README.ja.md) · [KAZAKH](README.kk.md) · [KOREAN](README.ko.md) · [MARATHI](README.mr.md) · [PASHTO](README.ps.md) · [PERSIAN](README.fa.md) · [POLISH](README.pl.md) · [PORTUGUESE](README.pt.md) · [PUNJABI](README.pa.md) · [RUSSIAN](README.md) · [SPANISH](README.es.md) · [TAMIL](README.ta.md) · [TELUGU](README.te.md) · [THAI](README.th.md) · [TIGRINYA](README.ti.md) · [TURKISH](README.tr.md) · [UKRAINIAN](README.uk.md) · [URDU](README.ur.md) · [UZBEK](README.uz.md) · [VIETNAMESE](README.vi.md)

**[Pobierz (najnowsza)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

# AutoConnector for Telegram

AutoConnector for Telegram — aplikacja sama wyszukuje w internecie proxy MTProto, sprawdza ich dostępność i uruchamia lokalny relay, przez który Telegram działa stabilnie nawet tam, gdzie jest zablokowany. Użytkownik nie musi ręcznie szukać działających proxy — AutoConnector for Telegram nieustannie dobiera najszybsze i najbardziej dostępne, testując je dokładnie z Twojego komputera/telefonu.

Innymi słowy: to skaner kanałów Telegrama i wszelkiego rodzaju subskrypcji z publicznymi, darmowymi proxy MTProto, z automatycznym podstawianiem ich do Twojego Telegrama. Nie trzeba aktualizować klienta Telegrama. Dostępność proxy jest sprawdzana dokładnie z Twojego urządzenia i Twojego środowiska sieciowego. Działa na Wi-Fi+LTE bez VPN.

Platformy: Android, Windows, Linux, MacBook.

Wersja na Androida działa samodzielnie, a w Windows trzeba ustawić silnik proxowania „SPLIT...” lub „COALESCING..” — w ustawieniach albo przyciskiem po prawej od napisu „Telegram podłączony” i dużego szarego/zielonego kółka. Albo dobierać ten, który u Ciebie osobiście będzie działał lepiej, bo blokady wszędzie są różne. Tryby „COALESCING..” są na ostateczność — w ten sposób Telegram zacznie działać, ale popsuje się wysyłanie/wyświetlanie treści multimedialnych w czatach.

Zalecam wyłączyć firewall typu COMODO, jeśli go używasz: zamyka aplikację w piaskownicy, a jego firewall psuje wychodzące połączenia do proxy MTProto. Albo uruchom aplikację w maszynie wirtualnej — tam całkowicie zmieni się stos TCP, a zachowanie AutoConnectora będzie inne.

A także pomagaj ręcznie Telegramowi przełączać się między portami 55001 i 55002 (w ustawieniach proxy), aby szybciej trafić na działające proxy i napis „Połączono” wewnątrz Telegrama.

# ✨ Możliwości

- **Automatyczne wyszukiwanie proxy** — skanuje dziesiątki otwartych stron i subskrypcji.
- **Sprawdzanie dostępności** — prawdziwy handshake MTProto, ranking według prędkości/stabilności.
- **Lokalny relay** — Telegram łączy się z `127.0.0.1`, a AutoConnector for
  Telegram kieruje ruch przez najlepsze działające proxy i przełącza się,
  jeśli bieżące padnie.
- **Anti-DPI** — zestaw sztuczek maskujących (imitacja przeglądarek, fragmentacja
  pakietów, FakeTLS i inne); tryb „Auto-przegląd” sam dobiera działający.
- **Szczegółowe statystyki** — żywe/martwe proxy, prędkość, latencja, ruch,
  skuteczność każdej sztuczki anti-DPI.
- **Katalog proxy** — top według rankingu ze szczegółową kartą każdego hosta:
  dla każdego hosta widać „połączeń Telegrama / udanych / wszystkich sprawdzeń” oraz
  historię ostatnich 25 prób (TCP/TLS/łączny czas połączenia, odebrane/wysłane bajty).
- **Elastyczny wybór hostów** — suwak „szerokości”: od „trzymaj się najlepszych sprawdzonych”
  po „próbuj jak najszerzej różnych działających”; gdy Telegram miota się po
  portach relay, wybór rozszerza się automatycznie. Osobny suwak — limit czasu
  połączenia (100 ms … 15 s) oraz „wyścig upstreamów” (kilka połączeń równolegle).
- **12 języków** interfejsu z automatycznym wykrywaniem, wsparcie RTL.

> ### Co nowego w porównaniu z 1.0.19
> - **Osobne bazy i rankingi hostów według typu sieci** — VPN / Wi-Fi / LTE /
>   Ethernet / White: każdy rodzaj połączenia prowadzi własną pulę działających proxy, aby
>   nie podstawiać Telegramowi tego, co działa tylko pod VPN.
> - **Wyścig upstreamów** — kilka połączeń równolegle, wygrywa najszybsze działające;
>   suwak „szerokości wyboru” (od najlepszych sprawdzonych po maksymalnie
>   szeroki) z automatycznym rozszerzaniem puli, gdy Telegram miota się po portach relay;
>   konfigurowalny limit czasu połączenia (100 ms…15 s).
> - **Katalog hostów ze szczegółową kartą** — „połączeń Telegrama / udanych /
>   wszystkich sprawdzeń” oraz historia ostatnich 25 prób per host (czas TCP/TLS,
>   czas połączenia, odebrane/wysłane bajty).
> - **Wykresy na żywo** prędkości, pingu i aktywności portów (w sekundach i minutach)
>   oraz wykresy skanowania.
> - **Anti-DPI i silniki proxowania** — zestaw sztuczek maskujących z
>   „Auto-przeglądem”, silnik obfuskacji i eksperymentalne silniki (split/
>   coalescing) pod konkretną blokadę.
> - **Eksport/import** ustawień, hostów i subskrypcji + pełne przywrócenie do stanu fabrycznego.
> - **Szybki zimny start** — agresywne wielowątkowe pobieranie subskrypcji przez
>   kilka anonimizatorów.
> - **26 języków** interfejsu z automatycznym wykrywaniem (+RTL).

# Przy pierwszym uruchomieniu ważne:

- Skonfigurować Telegram, wskazując stałe proxy SOCKS5 localhost:55001 i localhost:55002.
- Usuń inne proxy oprócz tych. 
- Włącz w Telegramie „Używaj proxy”.
- Nie blokować powiadomień na Androidzie, inaczej w tle nie będzie działać.
- Przy pierwszym uruchomieniu poczekaj ~15 minut, aż pobierze i przejrzy proxy MTProto i aż sam klient Telegrama się przełączy.

# Jeśli nic nie działa

1. Jeśli NIC nie działa, używaj programu jako automatycznego katalogu działających proxy. Skrótem klawiszowym CTRL+WIN+ALT+P i CTRL+SHIFT+ALT+P możesz szybko, bez otwierania okna AutoConnectora, dodać losowe proxy bezpośrednio do swojego Telegrama. Wyjdzie na to, że Telegram pójdzie wprost do proxy, bez AutoConnectora, ale nie będziesz musiał monitorować czatów, na których publikowane są darmowe proxy, i tracić czasu na ich sprawdzanie. Niech AutoConnector siedzi w tray-u, wyłącz przełącznik „Konektor”, zostaw przełącznik „Skan”. 

2. Wypróbuj AutoConnector na innym urządzeniu: telefon, telefon znajomego, komputer. Na różnych platformach Windows/Android zasada obchodzenia blokad jest zupełnie inna. Najprawdopodobniej na Androidzie zadziała bez żadnych ustawień.

3. Jeśli nic nie działa, włącz tymczasowo VPN na jeden dzień i testuj AutoConnector + Telegram przez ten dzień (Telegram podłącz przez AutoConnector, wskazując proxy na portach 55001 i 55002). Wewnątrz programu zaznacz pole „Przy włączonym VPN -> proksuj do MTProto”. Zobacz, czy AutoConnector zaczął działać? Jeśli tak, wniosek jest oczywisty — AutoConnector skutecznie wyszukuje proxy, skutecznie przekazuje tam ruch Telegrama, ale gdy VPN się wyłączy, system blokad w Twoim kraju zbyt ostro blokuje wszystkie połączenia wychodzące. W takim wypadku będziesz musiał poświęcić pół godziny na przegląd środków w AutoConnectorze, aby dobrać działający, potrafiący obejść blokady. Pełnego przeglądu wszystkich wariantów automatycznie program na razie nie potrafi (jest jedynie auto-przegląd trików anti-DPI). Po eksperymencie wyłącz VPN, a pole „Przy włączonym VPN proksuj do MTProto” przywróć do stanu „Proksuj bezpośrednio”.   

4. Alternatywa dla punktu (3). Postaw maszynę wirtualną na swoim hoście Windows/Linux. W niej uruchom Telegram + AutoConnector. Zaczęło działać idealnie nawet bez VPN? Znaczy, że Twój host psuje Twoje połączenia, a nie system blokad w Twoim kraju! Przyczyny: firewalle, antywirusy, pozostałości po VPN. Jeśli antywirus umieszcza AutoConnector w piaskownicy lub firewall blokuje nietypowe triki anti-DPI od AutoConnectora, to będziesz musiał uruchomić AutoConnector na hoście z pominięciem (wyjątki) antywirusa i firewalla. Albo wyłącz je całkowicie na czas, restartując komputer. Tak, jakkolwiek śmiesznie to brzmi, zrestartuj komputer, bo programy VPN często się zawieszają i mogą zostawić na hoście urządzenie TUN w stanie półżywym. Po restarcie nie uruchamiaj VPN, najpierw przetestuj AutoConnector.  

  5. Spróbuj obejścia blokad. Przycisk włączenia szukaj w ustawieniach lub na ekranie głównym (szukaj przycisku po prawej od dużego kółka w kolorze szarym/zielonym). Będziesz musiał poświęcić ~15 minut. Składają się one z 3 grup:  
	  - Silnik proxowania. Wypróbuj dowolny tryb Coalescing*. Najprawdopodobniej od razu zadziała. Ale przy tym nie będą się ładować obrazki/wideo w Telegramie (to nie bug, lecz funkcja/kompromis). Następnie wypróbuj tryby Split*, jeśli zadziała — obrazki się ładują. Albo przywróć do „wyłączone”.
	  - Wypróbuj „Równoległy wyścig upstreamów”. Oznacza to, że gdy Telegram wykonuje 1 połączenie do proxy, AutoConnector wykonuje 5-30 połączeń do różnych proxy MTProto i podstawia Telegramowi najlepsze. W ustawieniach aplikacji można wybrać limity czasu (3-5 s) oraz liczbę równoległych upstreamów do 30 sztuk.  
	  - Włącz „Auto-przegląd trików anti-DPI”, program sam będzie je przeglądał.
	  - Aby Telegram szybciej się przełączał, w ustawieniach proxy (w Telegramie) ręcznie co 5-10 sekund przełączaj się na kolejny port w kółko 55001->55002->55001->...  
    
6. Najmocniejsza/najszybsza kombinacja ustawień:  
	- limit czasu połączeń 5 s  
	- szerokość wyboru hostów 100%  
	- równoległych połączeń 30  
	- auto-przegląd trików DPI  
	- równoległy wyścig upstreamów  
	- silnik proxowania: Coalescing*  
	- wewnątrz Telegrama w oknie proxy co 10 sekund klikaj w nowy port, w kółko.
  
7. Polityka konfiguracji na Windows i Androidzie jest różna! Wszystko, co napisano wyżej, dotyczy głównie Windows. Na Androidzie u większości działa bez żadnych ustawień (przy dowolnych ustawieniach). W Windows jest inny stos TCP i inna aplikacja Telegrama, jest ona znacznie gorsza jakościowo niż na Androidzie. Wypróbuj jakiś inny klient Telegrama, a nie tylko oficjalny.  

8. Proszę, pisz szczegółowe raporty o błędach w dowolnym języku na https://t.me/AutoConnector_for_Telegram — platforma, jakie sposoby próbowałeś (ustawienia), czy masz firewall/antywirus, czy próbowałeś z VPN/maszyny wirtualnej. Pisz też wszelkie pozytywne recepty, co wypróbowałeś i jak to zadziałało.


## 📥 Pobierz

Wszystkie buildy — na stronie releasów: **[GitHub Releases (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

| OS | Plik | Uruchomienie |
|----|------|--------|
| **Android** | `AutoConnector_for_Telegram.apk` | zainstaluj APK (poza Google Play — zezwól na instalację ze źródła) |
| **Windows** 10/11 x64 | `AutoConnector-for-Telegram-windows-x64.zip` | rozpakuj → uruchom `AutoConnector\AutoConnector.exe` |
| **Linux** x64 | `AutoConnector-for-Telegram-linux-x64.tar.gz` | rozpakuj → `./AutoConnector/bin/AutoConnector` |
| **macOS** 11+ (Apple Silicon) | `AutoConnector-for-Telegram-macos.tar.gz` | rozpakuj → dwuklik na `AutoConnector.app` (jeśli blokuje — `xattr -dr com.apple.quarantine AutoConnector.app`) |

### 🔐 Weryfikacja autentyczności (release 1.1.0)

APK jest podpisany certyfikatem release (apksigner, schematy v1+v2+v3). Przed instalacją można sprawdzić:

- **Certyfikat podpisu (SHA-256):** `cb23a18c0cf8a23e43b5b63d199fc1440d3e4d6533e1309d3f92f273fe626a5a`
  (CN=AutoConnector for Telegram) — ten odcisk jest identyczny dla wszystkich przyszłych releasów.
- **APK SHA-256:** `d7652e7f5c3a2174a3b7805c2539df7da080765c9b0f581a7ac5943987c9b935`
- **Windows zip SHA-256:** `1d8d675936387e89038dc4943d7f99200c1b735b86e1f79bd953cd93e60f0217`
- **Linux tar.gz SHA-256:** `9160ea519309dc62750a4a930dc1aae6e20dbcefd21b426fa85b48ace6f3e8f8`
- **macOS tar.gz SHA-256:** `322082ef3f06955ed299be790bce453e47db37fca17daea54724d60698446bc7`

Weryfikacja: `apksigner verify --print-certs AutoConnector_for_Telegram.apk` (certyfikat) oraz
`sha256sum -c SHA256SUMS.txt` (integralność plików; `SHA256SUMS.txt` dołączony do releasu).

## 📸 Zrzuty ekranu

<table>
<tr>
<td align="center"><img src="docs/screenshots/connector.png" width="200"><br><sub>Konektor — aktywna sesja</sub></td>
<td align="center"><img src="docs/screenshots/scan.png" width="200"><br><sub>Skan i wykresy</sub></td>
<td align="center"><img src="docs/screenshots/catalog.png" width="200"><br><sub>Katalog proxy (według trybów)</sub></td>
<td align="center"><img src="docs/screenshots/host-card.png" width="200"><br><sub>Karta hosta + historia</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/logs.png" width="200"><br><sub>Logi relay</sub></td>
<td align="center"><img src="docs/screenshots/settings.png" width="200"><br><sub>Ustawienia</sub></td>
<td align="center"><img src="docs/screenshots/export.png" width="200"><br><sub>Eksport linków tg://</sub></td>
<td align="center"><img src="docs/screenshots/hotkeys.png" width="200"><br><sub>Skróty klawiszowe</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/guide.png" width="200"><br><sub>Przewodnik łączenia</sub></td>
<td align="center"><img src="docs/screenshots/connector-ru.png" width="200"><br><sub>Konektor · rosyjski UI</sub></td>
<td align="center"><img src="docs/screenshots/scan-ru.png" width="200"><br><sub>Skan · rosyjski UI</sub></td>
<td align="center"><sub>26 języków interfejsu<br>z automatycznym wykrywaniem</sub></td>
</tr>
</table>


## Informacja zwrotna

Błędy i uwagi przesyłaj tutaj - https://t.me/AutoConnector_for_Telegram

## 🔐 Weryfikacja podpisu

APK z releasów jest podpisany kluczem release. Sprawdzić można tak:

```bash
# Suma kontrolna (porównaj z SHA256SUMS.txt z releasu)
sha256sum AutoConnector_for_Telegram.apk

# Podpis cyfrowy i odcisk certyfikatu
apksigner verify --print-certs AutoConnector_for_Telegram.apk
```

Odcisk certyfikatu (SHA-256), którym podpisane są oficjalne buildy,
jest publikowany w opisie każdego releasu — sprawdź go, aby upewnić się, że APK
nie został podmieniony.

## 📄 Licencja

[MIT](LICENSE).
