package io.autoconnector.i18n

object Pl : Strings {
    override val tabConnector = "Konektor"; override val tabScan = "Skan"
    override val tabCatalog = "Katalog"; override val tabLogs = "Logi"; override val tabMore = "Więcej"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "Subskrypcje"; override val logTabScan = "Skan"
    override val logGeneral = "Ogólne"; override val logEmpty = "na razie pusto"
    override val logSessions = "Sesje"; override val logErrorsOnly = "tylko błędy"; override val logNoErrors = "brak nieudanych sesji"
    override fun logSession(id: String, port: String) = "#${id} · :${port}"
    override val back = "Wstecz"; override val copy = "Kopiuj"; override val gotIt = "Rozumiem"
    override val later = "Później"; override val details = "Szczegóły"; override val whatIsThis = "Co to jest?"
    override val delete = "Usuń"

    override val connector = "Konektor"; override val scan = "Skan"
    override val notConfigured = "Nie skonfigurowano! Napraw →"; override val howToSetup = "Jak skonfigurować"
    override val notifOff = "Powiadomienia są wyłączone! Napraw →"; override val enable = "Włącz"
    override fun fewProxies(n: Int) = "Działające proxy ${n}, trwa wyszukiwanie, poczekaj ~15 min…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "Działające proxy: ${alive}  (15 min: ${within}) · łącznie: ${total}"
    override val notifWhyTitle = "Po co powiadomienia?"
    override val notifWhyBody = "Stała ikona powiadomienia oznacza usługę pierwszoplanową Androida. " +
        "Bez niej system usuwa aplikację z pamięci, a ona przestaje szukać proxy i " +
        "utrzymywać połączenie w tle. Dlatego powiadomienia są niezbędne, aby " +
        "AutoConnector działał."
    override val notifEnableTitle = "Włącz powiadomienia"
    override val notifEnableBody = "Bez ikony powiadomienia Android traktuje aplikację jako nieaktywną i " +
        "usuwa ją z pamięci. Wtedy AutoConnector przestaje szukać proxy i utrzymywać " +
        "połączenie w tle — Telegram traci łączność.\n\nNaciśnij \"Włącz\" i zezwól na " +
        "powiadomienia dla AutoConnector."
    override val notifPlea = "Włącz powiadomienia! Bez nich aplikacja nie może działać w tle — " +
        "Android ją usunie, a wyszukiwanie proxy i połączenie się zatrzymają."

    override val statusConnected = "Telegram połączony"; override val statusConnecting = "Łączenie…"
    override val statusOffline = "Telegram niepołączony"; override val statusIdle = "Telegram bezczynny"
    override val nobodyConnected = "Nikt nie połączył się z Konektorem. "; override val howToSetupArrow = "Jak skonfigurować →"
    override val directModeViaVpn = "Tryb bezpośredni: VPN aktywny — bez proxy"
    override val directModeOff = "Tryb bezpośredni: proxy wyłączone"
    override val directDpiSuffix = " · anty-DPI"
    override val connections = "Połączenia"; override val sockets = "Gniazda"; override val speed = "Prędkość"
    override val traffic = "Ruch"; override val latency = "Opóźnienie"
    override fun pcs(n: Int) = "${n} szt."
    override fun netNow(label: String) = "Sieć: ${label}"
    override fun tgToConnector(n: Int) = "TG→ ${n}"
    override fun connectorToProxy(n: Int) = "proxy ${n}"
    override val trafficSec = "ruch · 60 sek"; override val trafficMin = "ruch · 60 min"
    override val latencySec = "opóźnienie · 60 sek"; override val latencyMin = "opóźnienie · 60 min"
    override val sec60 = "60 sek"; override val min60 = "60 min"
    override val unitSec = "s"; override val unitMin = "m"; override val unitHour = "godz"; override val dash = "—"
    override val currentProxy = "Bieżące proxy"; override val noActiveProxy = "brak aktywnego proxy (Telegram niepołączony)"
    override val host = "Host"; override val type = "Typ"; override val secret = "Sekret"; override val antiDpi = "Anty-DPI"; override val obfEngine = "Silnik obfuskacji"
    override fun activeSockets(n: Int) = "Aktywne gniazda Telegrama: ${n}"
    override val noConnections = "brak aktywnych połączeń"; override val colHost = "Host"; override val colTime = "Czas"
    override val modeWord = "Tryb"; override val directViaVpnLine = "Bezpośrednie zapytania do Telegrama (VPN aktywny)"
    override val connModeHelp = "Tryby (VPN, Wi-Fi, LTE, Ethernet, Biały) pozwalają inaczej dostroić intensywność skanowania i utrzymywać osobne oceny/statystyki hostów. Rodzaj sieci jest wykrywany automatycznie; tryb można ustawić ręcznie w ustawieniach."

    override val scanOff = "Skanowanie jest wyłączone"; override val proxiesInBase = "Proxy w bazie danych"
    override val total = "łącznie"; override val alive = "działające"; override val dead = "martwe"
    override val tgConnectedTitle = "Telegram połączony przez"; override val successful = "udane"
    override val socketsHeld = "Czas życia gniazda"; override val over1m = ">1 min"; override val over5m = ">5 min"; override val over15m = ">15 min"
    override val scanCountTitle = "Liczba sprawdzeń proxy"; override val checked = "Sprawdzono"
    override val forAllTime = "łącznie"; override val perMinute = "na minutę"; override val perHour = "na godzinę"
    override val subsCountTitle = "Liczba pobrań subskrypcji"; override val downloaded = "pobrano"; override val failed = "nieudane"; override val scanTraffic = "ruch skanu"; override val subTraffic = "ruch subskrypcji"; override val subTrafficGraph = "Ruch subskrypcji"
    override val checksMtproto = "Sprawdzenia MTProto (↑ ok · ↓ błąd)"

    override fun catalogEmpty(mode: String) = "Katalog ${mode} jest na razie pusty. Albo nie znaleziono żadnego hosta, albo aplikacja nigdy nie działała w tym trybie. Tryb możesz zmienić w Ustawieniach. Tryby służą do osobnego zbierania hostów dla różnych rodzajów połączenia internetowego."
    override val aliveShort = "✓ działa"; override val deadShort = "✗ martwe"
    override val statusLabel = "Status"; override val rating = "Ocena"; override val port = "Port"
    override val rttPing = "RTT (ping)"; override val checkedField = "Sprawdzono"; override val okOfTotal = "Udane / wszystkie sprawdzenia"
    override val tgConnectedField = "Telegram połączony"; override val tgSessions = "Sesje Telegrama"; override val trafficThroughProxy = "Ruch przez proxy"
    override val sessionsTotal = "Sesje łącznie"; override val relayNow = "Przekazuje teraz"; override val tlsDomain = "Domena TLS (SNI)"
    override val sourceSub = "Źródło (subskrypcja)"; override val lastError = "Ostatni błąd"; override val yes = "tak"; override val no = "nie"
    override val copyAsLink = "Kopiuj jako link"; override val openInTelegram = "Otwórz host w Telegramie"; override val makeNextRelay = "Ustaw jako następny przekaźnik"
    override val actCopy = "Kopiuj"; override val actOpen = "Otwórz"; override val actRelay = "Przekaźnik"
    override fun agoFmt(v: String) = "${v} temu"
    override val catalogTopFor = "Lista/ocena proxy dla"
    override val catalogModeHelpTitle = "Tryby i oceny"
    override val catalogModeHelp = "Aplikacja liczy działające hosty i ich oceny OSOBNO dla każdego trybu sieci (VPN, Wi-Fi, LTE, Ethernet i Biały). \"Biały\" to osobny tryb RĘCZNY dla białych list; tryb auto nigdy na niego nie przełącza. Dlatego ten sam host może być działający w jednym trybie i martwy w innym."
    override fun catalogInactiveWarn(section: String, active: String) =
        "Przeglądasz nieaktywną sekcję ${section} — wszystkie statystyki trafiają teraz do ${active}, a nie tutaj."
    override val manageModeTitle = "Zarządzaj trybem"
    override val manageResetRating = "Resetuj ocenę"
    override fun manageResetHint(mode: String) = "Dla trybu ${mode} możesz zresetować ocenę i statystyki użycia działających hostów. Przydaje się, gdy połączyłeś się z zupełnie innym VPN-em lub LTE, aby stare statystyki nie przeszkadzały. Albo żeby zobaczyć, jak szybko skan proxy sprawdza wszystko od nowa."
    override val manageDeleteAll = "Usuń hosty w"
    override fun manageDeleteHint(mode: String) = "Możesz wyczyścić zarówno ocenę, jak i same hosty z trybu ${mode}. Funkcja \"Skanuj proxy\" zbierze je ponownie. To nie jest reset subskrypcji — możesz to nacisnąć i poczekać ~15 minut na ponowne skanowanie."
    override fun manageCopyFrom(mode: String) = "Skopiuj wszystkie hosty i oceny do tego trybu (${mode}) z innego trybu:"
    override val live = "działa"; override val deadW = "martwe"; override val unitMs = "ms"
    override val agoMin = "m"; override val agoHour = "godz"; override val agoDay = "d"

    override val connectTelegram = "Łączenie Telegrama"; override val readCarefully = "Przeczytaj uważnie!"
    override val guideIntro = "Ta aplikacja nie zadziała bez konfiguracji. Wybierz jedną z 3 opcji poniżej " +
        "i postępuj uważnie według instrukcji."
    override val variant1 = "Opcja #1 — przyciski"
    override val variant1Body = "Naciśnij \"Proxy {A}\" — otworzy się Telegram, potwierdź dodanie proxy. Wróć " +
        "na ten ekran i naciśnij \"Proxy {B}\" — potwierdź dodanie po raz drugi.\n\nWyłącz wszystkie " +
        "inne stare proxy w Telegramie. Mają pozostać dokładnie 2 proxy — z portami {A} i {B}. " +
        "Przy innym zestawie AutoConnector nie zadziała."
    override val variant2 = "Opcja #2 — linki"
    override val variant2Body = "Skopiuj poniższy tekst do Zapisanych wiadomości (lub dowolnego czatu) w Telegramie — " +
        "czyli wyślij go do siebie. Naciśnij pierwszy link w swojej wiadomości — pierwsze proxy zostanie dodane. " +
        "Naciśnij drugi link — drugie zostanie dodane. Następnie wyłącz wszystkie stare proxy."
    override val variant3 = "Opcja #3 — ręcznie"
    override val variant3Body = "Ręcznie dodaj proxy SOCKS5: serwer localhost (127.0.0.1), port {A}. " +
        "Następnie drugie proxy: localhost, port {B}. Usuń wszystkie stare proxy."
    override val whatNext = "Co dalej?"
    override val whatNextBody = "W Telegramie włącz \"automatyczne przełączanie proxy\" — 5 sekund. Możesz pomóc " +
        "Telegramowi się połączyć, naciskając ręcznie (w Telegramie) proxy, które NIE jest aktywne ani oznaczone " +
        "jako \"niedostępne\" — to sprawia, że Telegram bardziej stara się połączyć.\n\nUpewnij się, że wszystkie inne stare " +
        "proxy zostały usunięte, oprócz {A} i {B}. Naciśnij " +
        "\"Użyj proxy\" w Telegramie.\n\nPoczekaj, aż aplikacja znajdzie i pobierze wystarczająco proxy " +
        "(5–15 minut). Wtedy Telegram sam połączy się z AutoConnector, który będzie nadal kierował " +
        "Telegrama przez najlepsze proxy: zweryfikowane, działające i szybkie.\n\nJeśli instrukcje wydają się " +
        "trudne — przepraszamy, nie będziesz mógł korzystać z aplikacji: nie da się wszystkiego skonfigurować " +
        "automatycznie, a znalezienie działających proxy wymaga czasu.\n\nJeśli pobrałeś aplikację dawno temu " +
        "i nie znaleziono żadnych działających proxy — zaktualizuj aplikację albo listę subskrypcji. Ta aplikacja " +
        "nie wymyśla ani nie dostarcza własnych proxy, jedynie przeszukuje internet po dziesiątkach " +
        "grup i stron."
    override fun proxyBtn(port: Int) = "Proxy ${port}"

    override val setupPortsTitle = "Skonfiguruj porty w Telegramie"
    override val setupPortsSub = "Jak połączyć Telegram z Konektorem (porty 55001/55002)"
    override val settings = "Ustawienia"; override val settingsSub = "Porty, anty-DPI, skan, sieć, bateria"
    override val subscriptions = "Subskrypcje"; override val subscriptionsSub = "Źródła proxy do skanowania"
    override val statistics = "Statystyki"; override val statisticsSub = "Baza proxy + sztuczki anty-DPI"
    override val export = "Eksport"; override val exportSub = "linki tg:// działających proxy"
    override val about = "O aplikacji"; override val aboutSub = "Wersja, kompilacja, pobieranie, opinie"
    override val hotkeys = "Skróty klawiszowe"
    override val hotkeysSub = "Globalne klawisze: kopiuj / otwórz proxy"
    override val hotkeysIntro = "Globalne skróty klawiszowe działają nawet wtedy, gdy okno aplikacji nie jest aktywne. Wybierają " +
        "losowy link działającego proxy (tg://) z puli — przydatne do szybkiego przełączania proxy bez " +
        "otwierania aplikacji."
    override val hotkeysNote = "W macOS przechwytywanie klawiszy może wymagać uprawnienia Dostępność " +
        "(Ustawienia systemowe → Prywatność i bezpieczeństwo → Dostępność)."
    override val hotkeyCopyTitle = "Kopiuj link proxy"
    override val hotkeyCopyDesc = "Umieszcza losowy działający link tg:// w schowku."
    override val hotkeyEnable = "Włącz skróty klawiszowe"; override val hotkeyLetterLabel = "Litera"; override val hotkeySet = "Ustaw"; override val hotkeyReset = "Resetuj"
    override val hotkeyOpenTitle = "Otwórz proxy w Telegramie"
    override val hotkeyOpenDesc = "Otwiera losowy działający link — Telegram go przechwytuje i proponuje połączenie proxy."

    override val relayPorts = "Porty przekaźnika"
    override val relayPortsHelp = "Lokalne porty, na których nasłuchuje Konektor. To dokładnie one wpisujesz w " +
        "Telegramie jako proxy SOCKS5 (127.0.0.1 : port). Dla niezawodności używane są dwa porty — Telegram " +
        "utrzymuje połączenia z oboma."
    override val portA = "Port A"; override val portB = "Port B"
    override val antiDpiTrick = "Sztuczka anty-DPI"
    override val antiDpiHelp = "Sposób na zamaskowanie połączenia, aby dostawca/DPI go nie rozpoznał i " +
        "nie zablokował.\n• \"Automatyczna rotacja\" sama wybiera działającą sztuczkę.\n• \"Bez sztuczek DPI\" — zwykłe " +
        "połączenie.\n• Pozostałe to konkretne techniki (naśladowanie przeglądarki, dzielenie pakietów itd.)."
    override val onlyFakeTls = "Tylko FakeTLS (ee)"
    override val applyDpiTo = "Zastosuj anty-DPI do"
    override val applyDpiHelp = "Do czego zastosować wybraną sztuczkę anty-DPI:\n• Przekaźnik Telegrama — do " +
        "aktywnego połączenia Telegrama przez Konektor.\n• Sondowania proxy — do sprawdzeń proxy w tle " +
        "(wtedy sprawdzenie zachowuje się jak prawdziwe połączenie, a statystyki sztuczek są dokładniejsze).\n" +
        "• Przy połączeniu bezpośrednim — gdy proxy są wyłączone (lub pominięte przy włączonym VPN) i Telegram " +
        "łączy się prosto ze swoimi serwerami: nie ma tu proxy, więc sztuczka sprowadza się do podziału " +
        "pierwszego pakietu TCP (handshake) na kilka małych segmentów, aby DPI nie mógł go dopasować w jednym odczycie."
    override val toRelay = "Przekaźnik Telegrama"; override val toProbes = "Sondowania proxy"
    override val toDirect = "Przy połączeniu bezpośrednim"
    override val vpnSection = "Gdy VPN jest włączony"
    override val vpnHelp = "Co robić, gdy na urządzeniu aktywny jest VPN:\n• Przez proxy MTProto — " +
        "Telegram idzie przez znalezione proxy jak zwykle (na wierzchu VPN-a).\n• Bezpośrednio — " +
        "Konektor NIE używa proxy i łączy Telegrama prosto z serwerami Telegrama: " +
        "VPN już zapewnia dostęp, dodatkowa warstwa proxy nie jest potrzebna (szybciej i stabilniej). " +
        "Bez VPN proxy są używane jak zwykle."
    override val linkFormat = "Format linku proxy"
    override val linkFormatHelp = "Jak kopiować i otwierać proxy. tg:// otwiera Telegram bezpośrednio (wymaga zainstalowanego Telegram Desktop). http (t.me) otwiera przez przeglądarkę i proponuje otwarcie w Telegramie — przydatne, gdy tg:// nie jest zarejestrowane."
    override val linkTg = "tg:// (otwórz Telegram bezpośrednio)"; override val linkTgSub = "tg://proxy?… — otwiera Telegram"
    override val linkHttp = "http (t.me, przez przeglądarkę)"; override val linkHttpSub = "https://t.me/proxy?… — otwiera przeglądarkę"
    override val viaMtproto = "Proxy przez MTProto"; override val viaMtprotoSub = "nawet z VPN ruch idzie przez proxy"
    override val directly = "Połącz bezpośrednio"; override val directlySub = "przy aktywnym VPN — omiń proxy, prosto do Telegrama"
    override val notifications = "Powiadomienia"
    override val scanCheck = "Skan i sprawdzanie"
    override val scanCheckHelp = "• Skan, min — jak często pobierać listy proxy z subskrypcji.\n" +
        "• Sprawdzanie, min — jak często ponownie sprawdzać żywotność proxy w bazie.\n• Rozmiar partii — " +
        "ile proxy sprawdzać na jeden przebieg.\n• Równolegle — ile sprawdzeń uruchamiać naraz (więcej = " +
        "szybciej, ale większe obciążenie sieci i baterii)."
    override val scanMin = "Skan, min"; override val checkMin = "Sprawdzanie, min"; override val batchSize = "Rozmiar partii"; override val parallel = "Równolegle"
    override val speedByNet = "Intensywność skanu wg sieci"
    override val speedByNetHelp = "Jak często sprawdzać proxy w zależności od bieżącej sieci. " +
        "\"Standard\" = bazowy interwał. Przesuń w prawo dla rzadszego (wolniej, oszczędniej dla ruchu/baterii), " +
        "w lewo dla częstszego (szybciej, agresywniej). Skala logarytmiczna, do ×100 w każdą stronę.\n" +
        "• VPN — gdy aktywny jest zewnętrzny VPN.\n• Wi-Fi — w sieci Wi-Fi.\n• LTE — w sieci mobilnej."
    override val intensStandard = "standard"
    override val intensSlower = "wolniej"
    override val intensFaster = "szybciej"
    override val maintenance = "Resetuj dane"
    override val maintenanceHelp = "• \"Resetuj katalog i statystyki\" — zeruje oceny, liczniki, ruch " +
        "i logi sprawdzeń, ale zachowuje pobrane hosty i subskrypcje (wszystko jest oceniane ponownie przy " +
        "następnym skanie).\n• \"Wyczyść pobrane hosty\" — usuwa całą pulę proxy, ale zachowuje " +
        "subskrypcje, aby skan ponownie napełnił pulę. Subskrypcje nigdy nie są naruszane w żadnym przypadku."
    override val backupTitle = "Eksport / Import"
    override val backupHelp = "Zapisz lub przywróć dane aplikacji jako JSON. Zaznacz, co " +
        "uwzględnić — dowolna kombinacja:\n• Ustawienia — wszystkie parametry aplikacji.\n• Subskrypcje — lista " +
        "źródeł (URL + wł./wył.).\n• Katalog działających hostów — każde działające proxy z ocenami i statystykami " +
        "DLA każdego trybu sieci.\n\n\"Eksport\" otwiera stronę z gotowym JSON — skopiuj go lub zapisz do pliku. " +
        "\"Import\" — wklej JSON (lub wczytaj plik), a zastosuje tylko zaznaczone sekcje obecne " +
        "w nim. Import DODAJE do bieżących danych (bez kasowania)."
    override val backupSettings = "Ustawienia"
    override val backupSubs = "Subskrypcje"
    override val backupHosts = "Katalog działających hostów (wg trybu)"
    override val exportWord = "Eksport"
    override val importWord = "Import"
    override val backupExportTitle = "Eksportuj dane"
    override val backupImportTitle = "Importuj dane"
    override val backupSelectExport = "Co eksportować:"
    override val backupSelectImport = "Co importować:"
    override val backupCopyBtn = "Kopiuj"
    override val backupSaveFile = "Zapisz do pliku"
    override val backupLoadFile = "Wczytaj z pliku"
    override val backupDoImport = "Import"
    override val backupPasteLabel = "Wklej tutaj JSON kopii zapasowej"
    override val backupJsonLabel = "JSON kopii zapasowej"
    override val backupAndroidFileNote = "Pliki nie są tu dostępne — użyj Kopiuj / Wklej."
    override val eraseAllHosts = "Usuń wszystkie hosty"
    override val factoryReset = "Zresetuj wszystko (jak przy pierwszym uruchomieniu)"
    override val factoryResetConfirm = "Całkowicie zresetować aplikację do stanu fabrycznego? WSZYSTKIE ustawienia i cały " +
        "katalog hostów zostaną wymazane, subskrypcje przywrócone do domyślnych. Tak jak przy pierwszym uruchomieniu."
    override val resetCatalog = "Resetuj katalog i statystyki"
    override val resetCatalogConfirm = "Wyzerować wszystkie oceny, liczniki i logi sprawdzeń? " +
        "Pobrane hosty i subskrypcje są zachowane i oceniane ponownie przy następnym skanie."
    override val clearHosts = "Wyczyść pobrane hosty"
    override val clearHostsConfirm = "Usunąć całą listę pobranych hostów (proxy)? " +
        "Subskrypcje są zachowane, a skan ponownie napełni pulę."
    override val doReset = "Resetuj"
    override val doCancel = "Anuluj"
    override val adaptiveSpeed = "Prędkość adaptacyjna"
    override val adaptiveHelp = "Sprawdzenia żywotności działają w bazowym interwale (z \"Skan i sprawdzanie\", " +
        "dodatkowo pomnożonym przez mnożnik sieci). \"Prędkość adaptacyjna\" automatycznie je przyspiesza lub spowalnia " +
        "w zależności od tego, ile proxy jest aktualnie działających.\n\n" +
        "• MAŁO działających (poniżej progu \"Mało\") → interwał × \"Przyspieszenie\". Mnożnik poniżej 1 = " +
        "częściej: 0,5 — dwa razy częściej, 0,25 — 4×. Szybciej napełnia pulę.\n" +
        "• DUŻO działających (powyżej progu \"Dużo\") → interwał × \"Spowolnienie\". Powyżej 1 = rzadziej: 2 — " +
        "o połowę rzadziej, 4 — czterokrotnie. Oszczędza baterię i ruch.\n" +
        "• Między progami — prędkość bazowa (×1).\n\n" +
        "Przykłady:\n" +
        "— Szybciej zbieraj proxy: \"Przyspieszenie\" 0,25 i/lub próg \"Mało\" 40.\n" +
        "— Oszczędzaj baterię, gdy masz dość: \"Spowolnienie\" 8 i/lub próg \"Dużo\" 30.\n" +
        "— Wyłącz adaptację: ustaw oba mnożniki na 1.\n\n" +
        "Domyślnie: Mało 20, Przyspieszenie 0,5, Dużo 50, Spowolnienie 4."
    override val threshMany = "Próg \"Dużo\""; override val threshFew = "Próg \"Mało\""; override val mulFast = "Przyspieszenie ×"; override val mulLazy = "Spowolnienie ×"
    override val subIntensityTitle = "Intensywność subskrypcji"
    override val subIntensityHint = "Przerwa między pobraniami subskrypcji: ile minut przed ponownym pobraniem list proxy (osobno dla każdego trybu sieci)."
    override val baseScanTitle = "Bazowa prędkość skanu"
    override val baseScanHelp = "Referencyjna prędkość sprawdzania żywotności. \"Prędkość adaptacyjna\" oraz mnożniki \"Prędkość " +
        "wg trybu\" są liczone względem niej.\n\n" +
        "• Jak często uruchamiać, min — interwał między przebiegami sprawdzeń.\n" +
        "• Partia na wątek, hosty — ile hostów sprawdza każdy wątek na przebieg.\n" +
        "• Wątki — ile sprawdzeń działa naraz. Przebieg sonduje \"partia × wątki\" hostów.\n" +
        "• Nie skanuj hosta częściej niż co N min — anty-flood: niedawno sprawdzony host jest " +
        "pomijany w tym przebiegu.\n\n" +
        "Więcej wątków i większa partia = szybszy wzrost puli, ale większe obciążenie sieci i baterii."
    override val baseScanPeriod = "Jak często uruchamiać, min"
    override val baseScanBatch = "Partia na wątek, hosty"; override val baseScanThreads = "Liczba wątków"
    override val adaptiveDesc = "Jeśli działających proxy jest mniej niż \"mało\" lub więcej niż \"dużo\", zastosuj dodatkowy mnożnik."
    override val fewWord = "Mało"; override val manyWord = "Dużo"
    override fun fasterX(x: String) = "${x}× szybciej"
    override fun slowerX(x: String) = "${x}× wolniej"
    override fun ifAliveLt(n: Int) = "Jeśli działających proxy < ${n}, to:"
    override fun ifAliveGt(n: Int) = "Jeśli działających proxy > ${n}, to:"
    override val disabledWord = "wył."
    override val speedByModeTitle = "Prędkość wg trybu"
    override val speedByModeHelp = "Mnożnik prędkości skanu dla każdego trybu sieci, na wierzchu prędkości " +
        "bazowej. \"Standard\" (×1) = bazowy interwał. W prawo — rzadziej (wolniej, oszczędniej dla ruchu/" +
        "baterii), w lewo — częściej (szybciej, agresywniej). Skala logarytmiczna, do ×100 w każdą " +
        "stronę.\n\n" +
        "Pod każdym suwakiem są wynikowe parametry przebiegu z zastosowaną prędkością adaptacyjną — " +
        "pokazane osobno dla \"mało działających\" (× \"Przyspieszenie\") i \"dużo działających\" (× \"Spowolnienie\").\n\n" +
        "Tryby:\n• VPN — aktywny jest zewnętrzny VPN.\n• LTE — sieć mobilna.\n• Wi-Fi — sieć Wi-Fi.\n" +
        "• Ethernet — połączenie przewodowe.\n• Biały — ręczny tryb \"białego\" proxy."
    override val aliveLt = "działa <"; override val aliveGt = "działa >"
    override val periodWord = "okres"; override val nonstopWord = "non-stop"
    override val batchWord = "partia"; override val threadsWord = "wątki"; override val scanModeOff = "skan wył."
    override val netBattery = "Sieć i bateria"
    override val netBatteryHelp = "• Tylko Wi-Fi — nie skanuj w sieciach mobilnych (oszczędza dane).\n• Tylko " +
        "podczas ładowania — działaj tylko, gdy telefon się ładuje.\n• Pomiń przy niskiej baterii — wstrzymaj skanowanie, gdy " +
        "bateria jest niska."
    override val onlyWifi = "Tylko Wi-Fi"; override val onlyCharging = "Tylko podczas ładowania"; override val skipLowBattery = "Pomiń przy niskiej baterii"
    override val autosaved = "Ustawienia są zapisywane automatycznie."
    override val dpiAutoLabel = "Automatyczna rotacja sztuczek DPI"; override val dpiNoneLabel = "Bez sztuczek DPI (zwykłe)"
    override val experimental = "Eksperymentalne"
    override val experimentalHelp = "Alternatywne silniki proxy względem upstreamu MTProto oraz log diagnostyczny. " +
        "Referencyjna (działająca) ścieżka pozostaje niezmieniona przy ustawieniu \"Wył.\". Zmienia się tylko TO, JAK zaszyfrowany strumień jest zapisywany do " +
        "gniazda TCP upstreamu (rozmiary segmentów, czasy, granice rekordów TLS) — sam strumień pozostaje bajt w bajt identyczny. " +
        "Dotyczy tylko aktywnego przekaźnika proxy (nie sondowań, nie ścieżki bezpośredniej)."
    override val expEngineTitle = "Silnik proxy (obfuskacja gniazda)"
    override val expConnectTitle = "Silnik łączenia (wybór upstreamu)"
    override val expEngineWarn = "⚠ Tryb eksperymentalny. Jeśli łączność się pogorszy, przełącz z powrotem na \"Wył. (ścieżka referencyjna)\"."
    override val netLog = "Włącz log wymiany sieciowej"
    override val netLogSub = "Zapisuje KTO-DO-KOGO-KIEDY oraz rozmiary pakietów do pliku (BEZ danych ładunku) — " +
        "aby porównać wzorzec wymiany z VPN-em i bez niego."
    override val openLogFolder = "Otwórz folder logów"; override val copyPath = "Kopiuj ścieżkę"
    override val helpShow = "Pomoc"; override val helpHide = "Ukryj pomoc"
    override val quickSwitchIntro = "Tutaj możesz wybrać sztuczkę obejścia blokady. Jeśli Telegram pokazuje błąd " +
        "„The proxy you are using is not configured correctly and will be disabled. Please find another " +
        "one”, eksperymentuj z tym, który typ obfuskacji ruchu działa, aby Telegram przestał go pokazywać. Zacznij " +
        "od trybów split*. Tryby coalesce* też działają, ale obrazy/filmy ładują się przy nich w Telegramie słabo."
    override val quickSwitchTitle ="Obejście blokady"; override val quickSwitchSub = "Kształtowanie, łączenie, anty-DPI"

    override val sourceUrl = "URL źródła"
    override fun sourceAlive(alive: Int, total: Int) = "działa ${alive}/${total}"
    override val open = "Otwórz"; override val active = "Aktywne"; override val inactive = "Nieaktywne"
    override val lastDownloaded = "Pobrano"; override val notDownloaded = "jeszcze nie pobrano"
    override fun sourceCounts(dead: Int, total: Int) =
        " działa, ${dead} martwe, ${total} łącznie"

    override val proxyBase = "Baza proxy"
    override val totalInBase = "Łącznie w bazie"; override val aliveNow = "Działa teraz"; override val deadStat = "Martwe"
    override val aliveIn15 = "Działa w 15 min"; override val checksAllTime = "Sprawdzenia łącznie"
    override val antiDpiTricks = "Sztuczki anty-DPI"; override val noStatsYet = "brak danych — sztuczki gromadzą się w miarę sprawdzeń/połączeń"
    override val attempts = "Próby"; override val handshake = "Handshake"; override val score = "Wynik"
    override val tgConnect = "Połączenie TG"; override val socketsOver1m = "Gniazda >1min"
    override val over10kb = "Gniazda >10KB"; override val over100kb = ">100KB"; override val workTime = "Czas pracy"
    override val statsLegend = "Handshake — udane handshake'i (% prób) · Wynik — wartość · " +
        "\"Czas pracy\" — łącznie dla gniazd ≥5KB i dłuższych niż 1 minuta."
    override val resetStats = "Resetuj statystyki sztuczek"

    override fun aliveLinks(n: Int) = "Działające linki: ${n}"
    override val copyAll = "Kopiuj wszystko"
    override val openRandom = "Otwórz losowe"; override val copyRandom = "Kopiuj losowe"; override val allShort = "WSZYSTKIE"
    override val copyTop = "Kopiuj TOP"; override val randomHost = "Losowy host"
    override val exportToFile = "Eksportuj do pliku"; override val exportSaved = "Zapisano do pliku:"
    override val dlNow = "Pobierz teraz"
    override fun downloadingFmt(sec: Long) = "Pobieranie… ${sec}s"
    override val cancel = "Anuluj"
    override val deleteConfirmTitle = "Usunąć subskrypcję?"
    override val subscriptionsAddHint = "Dodaj subskrypcje lub linki proxy →"
    override val addSourcesTitle = "Dodaj"
    override val addSubsLabel = "Subskrypcje (jeden URL na linię)"
    override val addSubsHelp = "Każda linia z prawidłowym URL staje się osobną subskrypcją i jest okresowo pobierana."
    override val addProxiesLabel = "Gotowe linki proxy (stała lista)"
    override val addProxiesHelp = "Wklej partię linków do konkretnych proxy (tg://proxy, https://t.me/proxy, …). To NIE jest subskrypcja — lista nigdy nie jest pobierana, proxy są po prostu dodawane do katalogu."
    override val addButton = "Dodaj"
    override fun addedFmt(subs: Int, proxies: Int) = "Dodano: ${subs} subskrypcji, ${proxies} proxy"
    override val perSecond = "na sek"
    override val graphSpeed = "Prędkość"
    override val graphVolume = "Objętość"
    override val graphLatency = "Ping"
    override val graphConnects = "Połączenia"
    override val scanNow = "Skanuj teraz"; override val scanOnShort = "Skan wł."
    override val scanRunning = "Skan działa"; override val scanIdle = "Skan bezczynny"; override val scanOffState = "Skan WYŁ."; override val scanBatchPerThread = "Partia/wątek"; override val scanPassHosts = "Hosty w przebiegu"; override val minRescanLabel = "Nie skanuj hosta częściej niż co N min"
    override val scanPlanTitle = "Plan"; override val scanNowTitle = "Teraz"; override val currentScheduleTitle = "Bieżący harmonogram"
    override val scheduleWord = "Harmonogram"; override val unitPcsPerSec = "szt/s"
    override val scanNowThreadsLabel = "Wątki działające teraz"; override val scanNowPerThreadLabel = "Sprawdzenia na wątek (plan)"; override val scanNowElapsedLabel = "Czas działania"
    override val scanOkGraph = "Udane skany"; override val scanFailGraph = "Nieudane skany"; override val scanTrafficGraph = "Ruch skanu"; override val scanAliveGraph = "Działające proxy łącznie"; override val scanPingGraph = "Ping"; override val threadsGraph = "Wątki"
    override val scanEvery = "Co"; override val scanNextRun = "Następne uruchomienie"
    override val scanThreads = "Wątki"; override val scanBatch = "Partia"
    override val scanElapsed = "Działa"; override val scanIdleNow = "—"
    override val effForFew = "Gdy mało"; override val effForMany = "Gdy dużo"
    override val effCheck = "Sprawdzanie"; override val effBatch = "Partia"; override val effPar = "Równolegle"
    override val effContinuous = "ciągłe"; override val secShort = "s"; override val minShort = "min"

    override val appTagline = "Wieloplatformowy auto-konektor: znajduje, sprawdza i uruchamia proxy MTProto, " +
        "przez które działa Telegram."
    override val version = "Wersja"; override val buildDate = "Data kompilacji"
    override val downloadSources = "Pobieranie i źródła"; override val openOnGithub = "Otwórz na GitHub"
    override val feedbackBugs = "Opinie i zgłaszanie błędów"; override val writeTelegram = "Napisz na Telegramie"

    override val language = "Język"; override val langAuto = "Automatyczny (systemowy)"; override val langRu = "Русский"; override val langEn = "English"
    override val langFa = "فارسی"; override val langZh = "简体中文"; override val langAr = "العربية"; override val langUr = "اردو"
    override val langTr = "Türkçe"; override val langId = "Bahasa Indonesia"; override val langHi = "हिन्दी"; override val langBn = "বাংলা"; override val langMy = "မြန်မာ"
    override val langWord = "Język"
    override val raceWidthTitle = "Równoległe połączenia"
    override val connectionSection = "Połączenie i obejście blokady"
    override val connectionSectionHelp = "Silnik łączenia, równoległe upstreamy, silnik proxy i sztuczki anty-DPI — wszystko w jednej sekcji."
    override val netLogSection = "Log wymiany sieciowej"
    override val platform = "Platforma"

    override val scanModeTitle = "Tryb sieci"; override val scanModeAuto = "Auto"; override val scanModeManualLabel = "Ręczny"
    override val activeModeLabel = "Aktywny tryb"; override val formingListLabel = "Budowanie listy"; override val catalogModeTabs = "Tryb"
    override val resetModeRatings = "Resetuj oceny hostów"; override val forgetModeHosts = "Zapomnij hosty trybu"
    override val exportModeTitle = "Eksport wg trybu"; override val modePickerTitle = "Tryb"
    override val modeHelp = "Każdy tryb sieci utrzymuje własne oceny proxy oraz własną intensywność skanu + pobierania subskrypcji. \"Auto\" wybiera tryb na podstawie aktywnej sieci. \"Ręczny\" pozwala samodzielnie wybrać dowolny tryb (w tym Biały, którego auto nigdy nie wybiera)."
    override val autoSelect = "Wybór automatyczny"; override val manualSelect = "Wybór ręczny"
    override val connStatsTitle = "Połączenia teraz"; override val connOnPort = "Połączenia na porcie"; override val outgoingConns = "Połączenia wychodzące"
    override val modeChoice = "Wybór trybu"; override val autoChoice = "auto-wybór"; override val manualChoice = "ręcznie ustalony"
    override val directOnVpn = "Bezpośrednie połączenie z TG przy VPN"; override val onWord = "wł."; override val offWord = "wył."
    override val directStateActive = "aktywne"; override val directStateOff = "wyłączone w ustawieniach"; override val directStateIdle = "włączone w ustawieniach, ale nieaktywne"
    override val wpHintTitle = "Czym jest Biały?"
    override val wpHint = "Biały — WhitePages: ręczny profil sieci. Włączany wyłącznie ręcznie (auto-wybór nigdy go nie wybiera). " +
        "Utrzymuje własne oceny hostów, pobiera subskrypcje i skanuje niezależnie od VPN/Wi-Fi/LTE."

    // host detail history + selection sliders
    override val recentAttempts = "Ostatnie połączenia i sprawdzenia"
    override val kindCheck = "sprawdzenie"
    override val kindTg = "telegram"
    override val histWho = "Kto"
    override val histWhen = "Kiedy"
    override val histReq = "Zapytanie"
    override val histSess = "Sesja"
    override val histScan = "skan"
    override val testNow = "Testuj teraz"
    override val testShort = "Test"
    override val testResult = "Wynik testu"
    override val testStop = "Stop"
    override val testingNow = "trwa test…"

    // pre-warm standby sockets
    override val prewarmTitle = "Rozgrzewanie gniazd (eksperyment)"
    override val prewarmHelp = "Utrzymuj z wyprzedzeniem otwartych kilka gniazd do proxy, aby nowe " +
        "połączenie Telegrama mogło pominąć łączenie/handshake. Eksperymentalnie: tło ciągle się " +
        "łączy ponownie → zużywa ruch i trochę CPU. Fałszywy ruch nie jest wysyłany (zepsułby " +
        "prawdziwą sesję) — gniazda są po prostu rotowane. Najbardziej przydatne z proxy FakeTLS."
    override val prewarmEnable = "Włącz rozgrzewanie"
    override val prewarmModeDeferred = "Odroczone (tylko TLS)"
    override val prewarmModeDeferredSub = "Trzymamy TCP + FakeTLS; init obfuscated2 dosyłamy przy przekazaniu. DC nie jest zatwierdzane — najbardziej realistyczne."
    override val prewarmModeFull = "Pełny handshake"
    override val prewarmModeFullSub = "Trzymamy w pełni połączone gniazda po różnych DC; używamy ponownie tylko przy zgodności DC/tag. Żyją krócej."
    override val prewarmPoolLabel = "Gniazda w zapasie"
    override val prewarmHoldLabel = "Trzymaj, s"
    override val prewarmNote = "Tylko rotacja (bez keepalive na poziomie aplikacji). Gniazdo żyje od sekund do ~minuty, zależnie od proxy/DC."
    override val prewarmStatus = "Rozgrzewanie"
    override fun prewarmStatusVal(ready: Int, holdSecs: Int) = "${ready} gotowe · trzymam ${holdSecs}s"
    override val prewarmStar = "Pogrubiony pomarańczowy = gniazdo przekazane ciepłe z puli rozgrzewania (pominięto łączenie/handshake)"
    override fun prewarmTableTitle(holdSecs: Int) = "Rozgrzewanie gniazd (trzymam ${holdSecs}s)"
    override val prewarmTableHelp = "\"Rozgrzewanie gniazd\" otwiera z wyprzedzeniem kilka gniazd do proxy, aby nowe " +
        "połączenie Telegrama mogło pominąć łączenie/handshake. Ta tabela pokazuje rozgrzewane hosty: ile sekund " +
        "żyje gniazdo, czy używa go Telegram, oraz ruch. Włączyć/wyłączyć i skonfigurować (tryb, liczbę gniazd, " +
        "czas trzymania) można w \"Więcej → Ustawienia → „Rozgrzewanie gniazd (eksperyment)“\"."
    override val prewarmNoneWarming = "brak rozgrzewanych gniazd"
    override val prewarmColAge = "wiek"
    override val prewarmColUse = "w TG?"
    override val prewarmInUse = "w TG"
    override val prewarmNew = "nowe"

    // LAN sharing / web portal
    override val lanShareTitle = "Udostępnianie w sieci lokalnej (portal WWW)"
    override val lanShareDesc = "Pozwól innym urządzeniom w tej sieci Wi-Fi używać tego AutoConnector jako proxy; przeglądarka otwierająca poniższy adres otrzyma stronę z najlepszymi proxy."
    override val lanShareUrlsLabel = "Sąsiedzi łączą się pod:"
    override val lanShareNoIp = "brak adresu w sieci lokalnej — połącz się z Wi-Fi"
    override val lanFirewallTitle = "Zezwól w sieci lokalnej"
    override val lanFirewallBody = "Po włączeniu porty przekaźnika otworzą się do sieci lokalnej. Zapora Windows (lub inna) może teraz zapytać, czy zezwolić AutoConnector — wybierz Zezwól / Tak. Jeśli odmówisz, ruch sąsiadów do AutoConnector zostanie zablokowany, a strona/proxy będą niedostępne."
    override val lanFirewallConfirm = "Włącz"
    override val lanInfoTitle = "Do czego to służy?"
    override val lanInfoBody = "Uruchom AutoConnector na JEDNYM komputerze lub telefonie w swojej sieci Wi-Fi, a każde inne urządzenie w tej samej sieci — w tym iPhone, którego ta aplikacja nie obsługuje bezpośrednio — może po prostu otworzyć adres w przeglądarce i z niego korzystać: strona z najlepszymi proxy do dodania do ich Telegrama, albo samo to urządzenie jako proxy SOCKS. Jedno urządzenie znajduje i utrzymuje proxy; reszta wypożycza je przez sieć lokalną."

    // volume-button trigger (Android)
    override val volTriggerTitle = "Wyzwalacz przyciskami głośności"
    override val volTriggerSub = "Przełączanie proxy szybkim wzorcem klawiszy głośności"
    override val volEnableLabel = "Obserwuj przyciski głośności"
    override val volHelpTitle = "Co to jest?"
    override val volHelpBody = "W Androidzie nie ma globalnych skrótów klawiaturowych, więc zamiast nich używane są przyciski GŁOŚNOŚCI. Gdy włączone, AutoConnector obserwuje w tle szybki wzorzec naciśnięć głośności w górę/w dół (np. góra-góra-dół-dół). Po rozpoznaniu otwiera link tg:// losowego dobrego, działającego proxy, aby Telegram go przechwycił i przełączył — szybki, dyskretny sposób na rotację proxy bez otwierania aplikacji. Głośność działa normalnie (naciśnięcia nie są przechwytywane). Wymaga dostępu do Accessibility (aby czytać klawisze głośności w tle i uruchamiać link); nic nie jest żądane, dopóki nie włączysz przełącznika. Ustaw poniżej maksymalny czas między naciśnięciami; rozpoznawane wzorce są wymienione na dole."
    override val volGrantTitle = "Włącz Accessibility (ważne)"
    override val volGrantBody = "Android (zwłaszcza 13+) blokuje Accessibility dla aplikacji zainstalowanych SPOZA Google Play — dlatego AutoConnector jest wyszarzony i pokazuje \"Ustawienie ograniczone\" / \"dostęp niedozwolony\".\n\nJak odblokować:\n1. Otwórz \"Informacje o aplikacji\" (przycisk poniżej lub Ustawienia → Aplikacje → AutoConnector for Telegram).\n2. Naciśnij menu ⋮ (prawy górny róg) → \"Zezwól na ustawienia ograniczone\" → potwierdź.\n3. Wróć: Ustawienia → Accessibility → AutoConnector for Telegram → włącz.\n\nJeśli nie widzisz \"Zezwól na ustawienia ograniczone\", najpierw spróbuj raz włączyć przełącznik w Accessibility (pojawi się komunikat o blokadzie), wtedy pojawi się krok 2.\n\nNa Xiaomi/MIUI, Samsung itp. ścieżka może się nieco różnić — szukaj tego samego ⋮ w \"Informacje o aplikacji\". W Androidzie 12 i starszych zwykle nie ma ograniczeń — po prostu włącz to w Accessibility.\n\nKlawisze głośności są tylko odczytywane, nigdy nie blokowane."
    override val volOpenAppInfo = "Otwórz Informacje o aplikacji"
    override val volAccessOn = "Accessibility: przyznana"
    override val volAccessOff = "Accessibility: nieprzyznana"
    override val volOpenAccess = "Otwórz ustawienia Accessibility"
    override val volGapLabel = "Maks. ms między naciśnięciami"
    override val volPatternsTitle = "Rozpoznawane wzorce"
    override val volPatternPick = "Wzorzec"
    override val volPatternsLegend = "↑ = głośność w górę, ↓ = w dół"
    override val volNoRights = "Aplikacja NIE ma jeszcze uprawnień do obsługi przycisków głośności — przyznaj dostęp według kroków na dole tej strony."
    override val volGrantShort = "Brak jeszcze dostępu do Accessibility. Przeczytaj szczegółowe kroki na dole tej strony, a następnie naciśnij \"Sprawdź\"."
    override val volCheck = "Sprawdź"
    override val volCheckOk = "✓ Gotowe — dostęp przyznany, wyzwalacz działa."
    override val volCheckFail = "✗ Wciąż brak dostępu — wykonaj powyższe kroki."
    override val volPatternsList = "↑↑↓↓ · ↓↓↑↑ · ↑↓↑↓ · ↓↑↓↑ · ↑↑↑↑ · ↓↓↓↓ · ↑↓↓↑ · ↓↑↑↓ · ↑↑↑↓↓↓ · ↓↓↓↑↑↑   (↑ = głośność w górę, ↓ = w dół)"

    // catalog host-card history legend + selection breadth + connect timeout
    override val histLegend = "Kolumny — Kto: ✓/✗ TG = prawdziwe połączenie Telegrama, skan = sprawdzenie w tle. Kiedy: ile czasu temu. TCP/TLS/Zapytanie: opóźnienia handshake'u i pierwszego zapytania, ms. Sesja: jak długo trwała sesja przekaźnika. ↓/↑: bajty odebrane / wysłane przez host."
    override val tgOkTotalHint = "Połączenia Telegrama / udane / wszystkie sprawdzenia"
    override val breadthTitle = "Szerokość wyboru hostów"
    override val breadthHelp = "Po lewej — trzymaj się najlepszych sprawdzonych hostów; po prawej — próbuj jak najszerzej spośród wszystkich działających. Gdy Telegram ciągle przełącza porty przekaźnika, aplikacja automatycznie poszerza wybór."
    override val breadthNarrow = "sprawdzone"
    override val breadthWide = "najszersze"
    override val connTimeoutTitle = "Limit czasu połączenia z hostem"
    override val connTimeoutHelp = "Jak długo czekać na jeden upstream (TCP + TLS + pierwsza odpowiedź MTProto), zanim przejdzie się do następnego proxy."

    // shown after a factory reset
    override val factoryResetDone = "Wszystko zostało zresetowane. Zamknij aplikację i otwórz ją ponownie."
}
