package io.autoconnector.i18n

object Kk : Strings by En {
    override val tabConnector = "Коннектор"; override val tabScan = "Скан"
    override val tabCatalog = "Каталог"; override val tabLogs = "Логтар"; override val tabMore = "Тағы"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "Жазылымдар"; override val logTabScan = "Скан"
    override val logGeneral = "Жалпы"; override val logEmpty = "әзірге бос"
    override val logSessions = "Сессиялар"; override val logErrorsOnly = "тек қателермен"; override val logNoErrors = "қателі сессиялар жоқ"
    override fun logSession(id: String, port: String) = "№${id} · :${port}"
    override val back = "Артқа"; override val copy = "Көшіру"; override val gotIt = "Түсінікті"
    override val later = "Кейінірек"; override val details = "Толығырақ"; override val whatIsThis = "Бұл не?"
    override val delete = "Жою"

    override val connector = "Коннектор"; override val scan = "Скан"
    override val notConfigured = "Бапталмаған! Түзету →"; override val howToSetup = "Қалай баптау"
    override val notifOff = "Хабарландырулар өшірулі! Түзету →"; override val enable = "Қосу"
    override fun fewProxies(n: Int) = "Тірі прокси ${n}, іздеудемін, ~15 мин күтіңіз…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "Тірі прокси: ${alive}  (15 мин: ${within}) · барлығы: ${total}"
    override val notifWhyTitle = "Хабарландырулар не үшін?"
    override val notifWhyBody = "Тұрақты белгішесі бар хабарландыру — бұл Android foreground-қызметі. " +
        "Онсыз жүйе қолданбаны жадтан түсіріп тастайды да, ол прокси іздеуді және фондағы " +
        "байланысты ұстап тұруды тоқтатады. Сондықтан AutoConnector жұмысы үшін хабарландырулар міндетті."
    override val notifEnableTitle = "Хабарландыруларды қосыңыз"
    override val notifEnableBody = "Хабарландыру белгішесінсіз Android қолданбаны белсенді емес деп санап, " +
        "оны жадтан түсіреді. Сонда AutoConnector прокси іздеуді және фондағы байланысты ұстауды " +
        "тоқтатады — Telegram байланысын жоғалтады.\n\n\"Қосу\" түймесін басып, AutoConnector үшін " +
        "хабарландыруларға рұқсат беріңіз."
    override val notifPlea = "Хабарландыруларды қосыңыз! Онсыз қолданба фондық режимде жұмыс істей " +
        "алмайды — Android оны түсіреді, прокси іздеу мен байланыс тоқтайды."

    override val statusConnected = "Telegram қосылды"; override val statusConnecting = "Қосылуда…"
    override val statusOffline = "Telegram қосылмаған"; override val statusIdle = "Telegram үнсіз"
    override val nobodyConnected = "Коннекторға ешкім қосылмады. "; override val howToSetupArrow = "Қалай баптау →"
    override val directModeViaVpn = "Тікелей режим: VPN белсенді — проксисіз"
    override val directModeOff = "Тікелей режим: прокси өшірулі"
    override val directDpiSuffix = " · анти-DPI"
    override val connections = "Қосылымдар"; override val sockets = "Сокеттер"; override val speed = "Жылдамдық"
    override val traffic = "Трафик"; override val latency = "Кідіріс"
    override fun pcs(n: Int) = "${n} дана"
    override fun netNow(label: String) = "Желі: ${label}"
    override fun tgToConnector(n: Int) = "TG→ ${n}"
    override fun connectorToProxy(n: Int) = "прокси ${n}"
    override val trafficSec = "трафик · 60 секунд"; override val trafficMin = "трафик · 60 минут"
    override val latencySec = "кідіріс · 60 секунд"; override val latencyMin = "кідіріс · 60 минут"
    override val sec60 = "60 секунд"; override val min60 = "60 минут"
    override val unitSec = "сек"; override val unitMin = "мин"; override val unitHour = "сағ"; override val dash = "—"
    override val currentProxy = "Ағымдағы прокси"; override val noActiveProxy = "белсенді прокси жоқ (Telegram қосылмаған)"
    override val host = "Хост"; override val type = "Түрі"; override val secret = "Құпия"; override val antiDpi = "Анти-DPI"; override val obfEngine = "Обфускация қозғалтқышы"
    override fun activeSockets(n: Int) = "Telegram белсенді сокеттері: ${n}"
    override val noConnections = "белсенді байланыстар жоқ"; override val colHost = "Хост"; override val colTime = "Уақыт"
    override val modeWord = "Режим"; override val directViaVpnLine = "VPN-ге байланысты Telegram-ға тікелей сұраулар"
    override val connModeHelp = "Режимдер (VPN, Wi-Fi, LTE, Ethernet, White) сканерлеу қарқынын әртүрлі баптауға мүмкіндік береді және хосттардың жеке рейтингін/статистикасын жүргізеді. Желі картасы автоматты түрде анықталады; режимді баптауларда қолмен орнатуға болады."

    override val scanOff = "Сканерлеу өшірулі"; override val proxiesInBase = "Дерекқордағы прокси"
    override val total = "барлығы"; override val alive = "тірі"; override val dead = "өлі"
    override val tgConnectedTitle = "Telegram қосылып тұрды"; override val successful = "сәтті"
    override val socketsHeld = "Сокеттер қанша ұсталды"; override val over1m = ">1 мин"; override val over5m = ">5 мин"; override val over15m = ">15 мин"
    override val scanCountTitle = "Прокси скандарының саны"; override val checked = "Тексерілді"
    override val forAllTime = "бар уақытта"; override val perMinute = "минутына"; override val perHour = "сағатына"
    override val subsCountTitle = "Жазылым жүктеулерінің саны"; override val downloaded = "жүктелді"; override val failed = "сәтсіз"; override val scanTraffic = "скан трафигі"; override val subTraffic = "жазылым трафигі"; override val subTrafficGraph = "Жазылым трафигі"
    override val checksMtproto = "MTProto тексерулері (↑ ok · ↓ fail)"

    override fun catalogEmpty(mode: String) = "Каталог ${mode} әзірге бос. Не бірде-бір хост табылмады, не бағдарлама бұл режимде ешқашан жұмыс істемеген. Режимді баптаулардан ауыстыруға болады. Режимдер интернетке қосылудың әртүрлі түрлері үшін хосттарды бөлек жинау мақсатында ойлап табылған."
    override val aliveShort = "✓ тірі"; override val deadShort = "✗ өлі"
    override val statusLabel = "Күй"; override val rating = "Рейтинг"; override val port = "Порт"
    override val rttPing = "RTT (пинг)"; override val checkedField = "Тексерілді"; override val okOfTotal = "Сәтті / барлық тексеру"
    override val tgConnectedField = "Telegram қосылып тұрды"; override val tgSessions = "Telegram сессиялары"; override val trafficThroughProxy = "Прокси арқылы трафик"
    override val sessionsTotal = "Барлық сессиялар"; override val relayNow = "Қазір реле"; override val tlsDomain = "TLS домені (SNI)"
    override val sourceSub = "Дереккөз (жазылым)"; override val lastError = "Соңғы қате"; override val yes = "иә"; override val no = "жоқ"
    override val copyAsLink = "Сілтеме ретінде көшіру"; override val openInTelegram = "Хостты Telegram-да ашу"; override val makeNextRelay = "Келесі реле ету"
    override val actCopy = "Көшіру"; override val actOpen = "Ашу"; override val actRelay = "Релеге"
    override fun agoFmt(v: String) = "${v} бұрын"
    override val catalogTopFor = "Прокси тізімі/рейтингі:"
    override val catalogModeHelpTitle = "Режимдер мен рейтингтер"
    override val catalogModeHelp = "Бағдарлама тірі хосттар мен олардың рейтингін әр желі режимі бойынша БӨЛЕК санайды (VPN, Wi-Fi, LTE, Ethernet және White). \"White\" — ақ тізімдерге арналған жеке ҚОЛМЕН режим; авто оған ешқашан ауыспайды. Сондықтан бір хост бір режимде тірі, басқа режимде өлі болуы мүмкін."
    override fun catalogInactiveWarn(section: String, active: String) =
        "Қазір сіз белсенді емес ${section} бөлімін қарап тұрсыз — барлық статистика дәл қазір осында емес, ${active} ішіне жиналуда."
    override val manageModeTitle = "Режимді басқару"
    override val manageResetRating = "Рейтингті нөлдеу"
    override fun manageResetHint(mode: String) = "${mode} үшін жеке тірі хосттардың рейтингі мен пайдалану статистикасын нөлдеуге болады. Бұл түбегейлі басқа VPN немесе LTE-ге қосылғанда ескі статистика кедергі келтірмеуі үшін пайдалы. Немесе прокси сканы бәрін нөлден қаншалықты тез тексеретінін бақылау үшін."
    override val manageDeleteAll = "Хосттарды жою:"
    override fun manageDeleteHint(mode: String) = "${mode} ішінен рейтингті де, хосттардың өзін де тазалауға болады. \"Прокси сканы\" функциясы оларды қайтадан жинайды. Бұл жазылымдарды нөлдеу емес — басуға болады, содан кейін қайта скан үшін ~15 минут күтіңіз."
    override fun manageCopyFrom(mode: String) = "Барлық хосттар мен рейтингтерді басқа режимнен осы режимге (${mode}) көшіру:"
    override val live = "тірі"; override val deadW = "өлі"; override val unitMs = "мс"
    override val agoMin = "м"; override val agoHour = "с"; override val agoDay = "к"

    override val connectTelegram = "Telegram-ды қосу"; override val readCarefully = "Мұқият оқыңыз!"
    override val guideIntro = "Бапталмай бұл қолданба жұмыс істемейді. Төмендегі 3 нұсқаның " +
        "кез келген бірін таңдап, нұсқаулықты ұқыпты орындаңыз."
    override val variant1 = "Нұсқа №1 — түймелермен"
    override val variant1Body = "\"Прокси {A}\" түймесін басыңыз — Telegram ашылады, проксиді қосуға " +
        "келісіңіз. Осы терезеге оралып, \"Прокси {B}\" түймесін басыңыз — екінші рет қосуға " +
        "келісіңіз.\n\nTelegram-да басқа ескі проксилерді өшіріңіз, егер болса. Дәл 2 прокси " +
        "қалуы керек — {A} және {B} порттарымен. Кез келген басқа жиынтықпен AutoConnector жұмыс істемейді."
    override val variant2 = "Нұсқа №2 — сілтемелермен"
    override val variant2Body = "Төмендегі мәтінді Telegram-дағы \"Таңдаулылар\" (немесе кез келген чат) " +
        "ішіне көшіріңіз — яғни өзіңізге жіберіңіз. Хабарламадағы бірінші сілтемені басыңыз — бірінші " +
        "прокси қосылады. Екінші сілтемені басыңыз — екіншісі қосылады. Содан кейін барлық ескі проксиді өшіріңіз."
    override val variant3 = "Нұсқа №3 — қолмен"
    override val variant3Body = "SOCKS5 түріндегі проксиді қолмен қосыңыз: сервер localhost (127.0.0.1), " +
        "порт {A}. Содан кейін екінші прокси: localhost, порт {B}. Кез келген ескі проксиді жойыңыз."
    override val whatNext = "Әрі қарай ше?"
    override val whatNextBody = "Telegram-да \"проксиді авто-ауыстыруды\" қосыңыз — 5 секунд. Сіз " +
        "Telegram-ға қосылуға көмектесе аласыз: Telegram ішінде белсенді ЕМЕС немесе \"қолжетімсіз\" " +
        "деп белгіленген проксиді қолмен басыңыз — сонда Telegram қосылуға көбірек әрекет жасайды." +
        "\n\nБарлық басқа ескі проксилердің {A} және {B}-дан басқасы жойылғанына көз жеткізіңіз. " +
        "Telegram-да \"Проксиді пайдалану\" батырмасын басыңыз.\n\nҚолданба жеткілікті прокси тауып, " +
        "жүктегенше күтіңіз (5–15 минут). Содан кейін Telegram өзі AutoConnector-ге қосылады, ол " +
        "Telegram-ды әрдайым ең тиімді проксилерге қосады: тексерілген, тірі және жылдам.\n\nЕгер " +
        "нұсқаулық қиын көрінсе — өкінішке орай, қолданбаны пайдалана алмайсыз: бәрін автоматты түрде " +
        "баптау мүмкін емес, ал тірі прокси іздеу уақыт алады.\n\nЕгер қолданбаны баяғыда жүктеп, тірі " +
        "прокси табылмаса — қолданбаны не жазылым тізімін жаңартыңыз. Бұл қолданба проксиді ойдан " +
        "шығармайды әрі өз проксисін бермейді, тек интернеттен ондаған топтар мен беттер арасынан іздейді."
    override fun proxyBtn(port: Int) = "Прокси ${port}"

    override val setupPortsTitle = "Telegram-да порттарды баптау"
    override val setupPortsSub = "Telegram-ды Коннекторға қалай қосу керек (порттар 55001/55002)"
    override val settings = "Баптаулар"; override val settingsSub = "Порттар, анти-DPI, скан, желі, батарея"
    override val subscriptions = "Жазылымдар"; override val subscriptionsSub = "Скан үшін прокси дереккөздері"
    override val statistics = "Статистика"; override val statisticsSub = "Прокси дерекқоры + анти-DPI айлалары"
    override val export = "Экспорт"; override val exportSub = "Тірі проксилердің tg:// сілтемелері"
    override val about = "Бағдарлама туралы"; override val aboutSub = "Нұсқа, құрастыру, жүктеу, кері байланыс"
    override val hotkeys = "Ыстық пернелер"
    override val hotkeysSub = "Жаһандық пернелер: проксиді көшіру / ашу"
    override val hotkeysIntro = "Жаһандық ыстық пернелер қолданба терезесі фокуста болмаса да жұмыс істейді. " +
        "Олар дерекқордан кездейсоқ тірі прокси-сілтемені (tg://) алады — қолданбаны ашпай проксиді " +
        "жылдам ауыстыруға ыңғайлы."
    override val hotkeysNote = "macOS-та пернелерді ұстау үшін \"Accessibility\" рұқсаты қажет болуы " +
        "мүмкін (Жүйелік баптаулар → Құпиялылық және қауіпсіздік → Accessibility)."
    override val hotkeyCopyTitle = "Прокси сілтемесін көшіру"
    override val hotkeyCopyDesc = "Кездейсоқ тірі tg://-сілтемені аралық сақтағышқа салады."
    override val hotkeyEnable = "Ыстық пернелерді қосу"; override val hotkeyLetterLabel = "Әріп"; override val hotkeySet = "Орнату"; override val hotkeyReset = "Тастау"
    override val hotkeyOpenTitle = "Проксиді Telegram-да ашу"
    override val hotkeyOpenDesc = "Кездейсоқ тірі сілтемені ашады — Telegram оны ұстап, проксиді қосуды ұсынады."

    override val relayPorts = "Реле порттары"
    override val relayPortsHelp = "Коннектор тыңдайтын жергілікті порттар. Дәл осыларды сіз Telegram-да " +
        "SOCKS5-прокси ретінде көрсетесіз (127.0.0.1 : порт). Сенімділік үшін екі порт қажет — Telegram " +
        "екеуіне де байланыс ұстайды."
    override val portA = "Порт A"; override val portB = "Порт B"
    override val antiDpiTrick = "Анти-DPI айласы"
    override val antiDpiHelp = "Провайдер/DPI байланысты танып, бұғаттамауы үшін оны жасырудың тәсілі.\n" +
        "• \"Авто-таңдау\" жұмыс істейтін айланы өзі таңдайды.\n• \"DPI-айлаларсыз\" — қарапайым " +
        "байланыс.\n• Қалғаны — нақты әдістер (браузерлерді еліктеу, пакеттерді бөлшектеу т.б.)."
    override val onlyFakeTls = "Тек FakeTLS (ee)"
    override val applyDpiTo = "Анти-DPI қолдану:"
    override val applyDpiHelp = "Таңдалған анти-DPI айласын неге қолдану керек:\n• Telegram релесіне — " +
        "Коннектор арқылы тірі Telegram байланысына.\n• Прокси сынамаларына — фондық прокси " +
        "тексерулеріне (сонда тексеру нақты байланыс сияқты әрекет етеді, ал айлалар статистикасы " +
        "дәлірек).\n• Тікелей қосылғанда — прокси өшірулі болғанда (немесе VPN кезінде өткізіп " +
        "жіберілгенде) және Telegram серверлерге тікелей баратын кезде: мұнда прокси жоқ, сондықтан " +
        "айла бірінші TCP-пакетті (қол алысуды) бірнеше ұсақ сегментке бөлуге саяды, осылайша DPI оны " +
        "бір оқуда тани алмайды."
    override val toRelay = "Telegram релесіне"; override val toProbes = "Прокси сынамаларына"
    override val toDirect = "Тікелей қосылғанда"
    override val vpnSection = "VPN қосулы кезде"
    override val vpnHelp = "Құрылғыда VPN белсенді болғанда не істеу керек:\n• MTProto-прокси арқылы — " +
        "Telegram әдеттегідей табылған проксилер арқылы жүреді (VPN үстінен).\n• Тікелей — Коннектор " +
        "проксиді ПАЙДАЛАНБАЙДЫ және Telegram-ды Telegram серверлеріне тікелей қосады: VPN қол " +
        "жеткізуді әлдеқашан береді, артық прокси қабаты қажет емес (жылдамырақ әрі тұрақтырақ). " +
        "VPN-сіз проксилер әдеттегідей пайдаланылады."
    override val linkFormat = "Прокси сілтемелерінің пішімі"
    override val linkFormatHelp = "Проксиді қалай көшіру және ашу. tg:// тікелей Telegram-да ашылады (орнатылған Telegram Desktop қажет). http (t.me) браузер арқылы ашылып, Telegram-да ашуды ұсынады — егер tg:// ашылмаса пайдалы."
    override val linkTg = "tg:// (тікелей Telegram-да)"; override val linkTgSub = "tg://proxy?… — Telegram-ды ашады"
    override val linkHttp = "http (t.me, браузер арқылы)"; override val linkHttpSub = "https://t.me/proxy?… — браузерді ашады"
    override val viaMtproto = "MTProto арқылы проксилеу"; override val viaMtprotoSub = "VPN кезінде де трафик прокси арқылы жүреді"
    override val directly = "Тікелей проксилеу"; override val directlySub = "VPN белсенді кезде — проксиді айналып, тікелей Telegram-ға"
    override val notifications = "Хабарландырулар"
    override val scanCheck = "Скан және тексеру"
    override val scanCheckHelp = "• Скан, мин — жазылымдардан прокси тізімдерін қаншалықты жиі жүктеу керек.\n" +
        "• Тексеру, мин — дерекқордағы проксиді тірілікке қаншалықты жиі қайта тексеру керек.\n" +
        "• Топтама өлшемі — бір жүгірісте қанша проксиді тексеру керек.\n• Қатарлас — қанша тексеруді " +
        "бір мезгілде орындау керек (көбірек = жылдамырақ, бірақ желі мен батареяға жүктеме жоғары)."
    override val scanMin = "Скан, мин"; override val checkMin = "Тексеру, мин"; override val batchSize = "Топтама өлшемі"; override val parallel = "Қатарлас"
    override val speedByNet = "Желі бойынша скан қарқыны"
    override val speedByNetHelp = "Ағымдағы желіге байланысты проксиді қаншалықты жиі тексеру керек. " +
        "\"Стандарт\" = базалық аралық. Оңға жылжыту — сирегірек (баяуырақ, трафик/батареяға " +
        "үнемдірек), солға — жиірек (жылдамырақ, агрессивтірек). Логарифмдік шкала, әр жаққа ×100-ге " +
        "дейін.\n• VPN — сыртқы VPN белсенді кезде.\n• Wi-Fi — Wi-Fi желісінде.\n• LTE — мобильді желіде."
    override val intensStandard = "стандарт"
    override val intensSlower = "баяуырақ"
    override val intensFaster = "жылдамырақ"
    override val maintenance = "Деректерді тастау"
    override val maintenanceHelp = "• \"Каталог пен статистиканы тастау\" — бағаларды, есептегіштерді, " +
        "трафик пен тексеру логтарын нөлдейді, бірақ жүктелген хосттар мен жазылымдарды сақтайды " +
        "(келесі сканда бәрі қайта бағаланады).\n• \"Жүктелген хосттарды тазалау\" — бүкіл прокси пулын " +
        "жояды, бірақ скан пулды қайта жинауы үшін жазылымдарды қалдырады. Жазылымдар екі жағдайда да тиілмейді."
    override val backupTitle = "Экспорт / Импорт"
    override val backupHelp = "Қолданба деректерін JSON ретінде сақтау немесе қалпына келтіру. " +
        "Не қосуды белгілеңіз — кез келген тіркесім:\n• Баптаулар — қолданбаның барлық параметрлері.\n" +
        "• Жазылымдар — дереккөздер тізімі (URL + қос/өшір).\n• Тірі хосттар каталогы — әр желі режимі " +
        "БОЙЫНША бағалары мен статистикасы бар барлық тірі прокси.\n\n\"Экспорт\" дайын JSON-мен бетті " +
        "ашады — оны көшіріңіз немесе файлға сақтаңыз. \"Импорт\" — JSON-ды қойыңыз (немесе файлды " +
        "жүктеңіз), тек мәтінде бар белгіленген бөлімдер қолданылады. Импорт ағымдағы деректерге " +
        "ҚОСАДЫ (өшірмейді)."
    override val backupSettings = "Баптаулар"
    override val backupSubs = "Жазылымдар"
    override val backupHosts = "Тірі хосттар каталогы (режимдер бойынша)"
    override val exportWord = "Экспорт"
    override val importWord = "Импорт"
    override val backupExportTitle = "Деректерді экспорттау"
    override val backupImportTitle = "Деректерді импорттау"
    override val backupSelectExport = "Нені экспорттау:"
    override val backupSelectImport = "Нені импорттау:"
    override val backupCopyBtn = "Көшіру"
    override val backupSaveFile = "Файлға сақтау"
    override val backupLoadFile = "Файлдан жүктеу"
    override val backupDoImport = "Импорттау"
    override val backupPasteLabel = "Сақтық көшірменің JSON-ын осында қойыңыз"
    override val backupJsonLabel = "Сақтық көшірме JSON"
    override val backupAndroidFileNote = "Файлдар мұнда қолжетімсіз — Көшіру / Қою қолданыңыз."
    override val eraseAllHosts = "Барлық хостты өшіру"
    override val factoryReset = "Бәрін тастау (алғашқы іске қосудағыдай)"
    override val factoryResetConfirm = "Қолданбаны зауыттық күйге толық тастау керек пе? БАРЛЫҚ баптаулар " +
        "мен бүкіл хосттар каталогы өшіріледі, жазылымдар әдепкіге оралады. Алғашқы іске қосу сияқты."
    override val resetCatalog = "Каталог пен статистиканы тастау"
    override val resetCatalogConfirm = "Барлық бағаларды, есептегіштер мен тексеру логтарын нөлдеу керек пе? " +
        "Жүктелген хосттар мен жазылымдар сақталады әрі келесі сканда қайта бағаланады."
    override val clearHosts = "Жүктелген хосттарды тазалау"
    override val clearHostsConfirm = "Жүктелген хосттардың (проксилердің) бүкіл тізімін жою керек пе? " +
        "Жазылымдар сақталады әрі скан пулды қайта жинайды."
    override val doReset = "Тастау"
    override val doCancel = "Бас тарту"
    override val adaptiveSpeed = "Бейімделгіш жылдамдық"
    override val adaptiveHelp = "Тірілік тексерулері базалық аралықпен жүреді (\"Скан және тексеру\" " +
        "бөлімінен, желі көбейткішіне де көбейтілген). \"Бейімделгіш жылдамдық\" қазір қанша прокси " +
        "тірі екеніне қарай оларды өзі жылдамдатады немесе баяулатады.\n\n" +
        "• Тірі АЗ (\"Аз\" табалдырығынан төмен) → аралық × \"Жылдамдату\". 1-ден кіші көбейткіш = " +
        "жиірек: 0.5 — екі есе жиі, 0.25 — 4 есе. Пул жылдамырақ толады.\n" +
        "• Тірі КӨП (\"Көп\" табалдырығынан жоғары) → аралық × \"Баяулату\". 1-ден үлкен = сирегірек: " +
        "2 — екі есе сирек, 4 — төрт есе. Батарея мен трафикті үнемдейді.\n" +
        "• Табалдырықтар арасында — базалық жылдамдық (×1).\n\n" +
        "Мысалдар:\n" +
        "— Проксиді жылдамырақ жинау: \"Жылдамдату\" 0.25 және/немесе \"Аз\" табалдырығы 40.\n" +
        "— Жеткілікті болғанда батареяны үнемдеу: \"Баяулату\" 8 және/немесе \"Көп\" табалдырығы 30.\n" +
        "— Бейімделуді өшіру: екі көбейткішті де 1-ге қою.\n\n" +
        "Әдепкі: Аз 20, Жылдамдату 0.5, Көп 50, Баяулату 4."
    override val threshMany = "\"Аз\" табалдырығы"; override val threshFew = "\"Көп\" табалдырығы"; override val mulFast = "Жылдамдату ×"; override val mulLazy = "Баяулату ×"
    override val subIntensityTitle = "Жазылым қарқыны"
    override val subIntensityHint = "Жазылым жүктеулері арасындағы үзіліс: прокси тізімдерін қанша минут сайын қайта жүктеу керек (әр желі режиміне бөлек)."
    override val baseScanTitle = "Базалық скан жылдамдығы"
    override val baseScanHelp = "Тірілікке тексерудің тірек жылдамдығы. \"Бейімделгіш жылдамдық\" пен " +
        "\"Режимдер бойынша жылдамдық\" көбейткіштері осыған қатысты есептеледі.\n\n" +
        "• Қанша минут сайын іске қосу — тексеру өтулерінің аралығы.\n" +
        "• Ағынға топтама, хост — әр ағын бір өтуде қанша хостты тексереді.\n" +
        "• Ағын саны — бір мезгілде қанша тексеру жүреді. Бір өтуде \"топтама × ағындар\" хост " +
        "тексеріледі.\n" +
        "• Хостты N минутта бір реттен жиі сканерлемеу — флудтан қорғау: жуырда тексерілген хост осы " +
        "өтуге кірмейді.\n\n" +
        "Көбірек ағын мен үлкенірек топтама = пул жылдамырақ толады, бірақ желі мен батареяға жүктеме ауырырақ."
    override val baseScanPeriod = "Қанша минут сайын іске қосу"
    override val baseScanBatch = "Ағынға топтама, хост"; override val baseScanThreads = "Ағын саны"
    override val adaptiveDesc = "Егер тірі прокси \"аз\"-дан кем немесе \"көп\"-тен артық болса — өзінің қосымша коэффициентін қосу."
    override val fewWord = "Аз"; override val manyWord = "Көп"
    override fun fasterX(x: String) = "${x} есе жылдам"
    override fun slowerX(x: String) = "${x} есе баяу"
    override fun ifAliveLt(n: Int) = "Егер тірі прокси < ${n} дана болса, онда:"
    override fun ifAliveGt(n: Int) = "Егер тірі прокси > ${n} дана болса, онда:"
    override val disabledWord = "өшірулі"
    override val speedByModeTitle = "Режимдер бойынша жылдамдық"
    override val speedByModeHelp = "Базалық жылдамдықтың үстінен әр желі режиміне арналған скан " +
        "жылдамдығының көбейткіші. \"Стандарт\" (×1) = базалық аралық. Оңға — сирегірек (баяуырақ, " +
        "трафик/батареяға үнемдірек), солға — жиірек (жылдамырақ, агрессивтірек). Логарифмдік шкала, " +
        "әр жаққа ×100-ге дейін.\n\n" +
        "Әр жүгірткінің астында — бейімделгіш жылдамдықты ескере отырып өтудің қорытынды параметрлері: " +
        "\"тірі аз\" (× \"Жылдамдату\") және \"тірі көп\" (× \"Баяулату\") жағдайларына бөлек.\n\n" +
        "Режимдер:\n• VPN — сыртқы VPN белсенді.\n• LTE — мобильді желі.\n• Wi-Fi — Wi-Fi желісі.\n" +
        "• Ethernet — сымды байланыс.\n• White — \"ақ\" проксилердің қолмен режимі."
    override val aliveLt = "тірі <"; override val aliveGt = "тірі >"
    override val periodWord = "кезең"; override val nonstopWord = "үздіксіз"
    override val batchWord = "топтама"; override val threadsWord = "ағындар"; override val scanModeOff = "скан өшірулі"
    override val netBattery = "Желі және батарея"
    override val netBatteryHelp = "• Тек Wi-Fi арқылы — мобильді желіде сканерлемеу (трафикті үнемдеу).\n" +
        "• Тек зарядта — телефон зарядта тұрғанда ғана жұмыс істеу.\n• Заряд аз кезде өткізіп жіберу — " +
        "батарея заряды аз кезде сканды кідірту."
    override val onlyWifi = "Тек Wi-Fi арқылы"; override val onlyCharging = "Тек зарядта"; override val skipLowBattery = "Заряд аз кезде өткізіп жіберу"
    override val autosaved = "Баптаулар автоматты түрде сақталады."
    override val dpiAutoLabel = "DPI-айлаларын авто-таңдау"; override val dpiNoneLabel = "DPI-айлаларсыз (қарапайым)"
    override val experimental = "Эксперименттік"
    override val experimentalHelp = "MTProto-проксиге балама проксилеу қозғалтқыштары мен диагностикалық лог. " +
        "Эталондық (жұмыс істейтін) жол \"Өшірулі\" кезде өзгермейді. Тек шифрланған ағынның апстрим " +
        "TCP-сокетіне ҚАЛАЙ жазылатыны өзгереді (сегмент өлшемдері, тайминг, TLS-records шекаралары) — " +
        "ағынның өзі байтпа-байт сол күйінде. Прокси арқылы тірі релеге ғана қолданылады (сынамаларға да, тікелей шығуға да емес)."
    override val expEngineTitle = "Проксилеу қозғалтқышы (сокеттер обфускациясы)"
    override val expConnectTitle = "Қосылу қозғалтқышы (апстрим іздеу)"
    override val expEngineWarn = "⚠ Эксперименттік режим. Егер байланыс нашарласа — \"Өшірулі (эталондық жол)\" қайтарыңыз."
    override val netLog = "Желілік алмасу логын қосу"
    override val netLogSub = "Файлға КІМ-КІМГЕ-ҚАШАН және пакет өлшемдерін жазады (деректер мазмұнынсыз) — " +
        "VPN-мен және онсыз алмасу сипатын салыстыру үшін."
    override val openLogFolder = "Лог қалтасын ашу"; override val copyPath = "Жолды көшіру"
    override val helpShow = "Анықтама"; override val helpHide = "Анықтаманы жасыру"
    override val quickSwitchIntro = "Мұнда сіз бұғаттауды айналып өту айласын таңдай аласыз. Егер Telegram " +
        "\"The proxy you are using is not configured correctly and will be disabled. Please find another " +
        "one\" қатесін берсе, трафик обфускациясының қай түрі жұмыс істеп, Telegram бұл қатені бермейтінін " +
        "эксперимент жасап табыңыз. split* режимдерінен бастаңыз. coalesce* режимдері де жұмыс істейді, " +
        "бірақ олармен Telegram-да суреттер/видеолар нашар жүктеледі."
    override val quickSwitchTitle = "Бұғаттауды айналып өту"; override val quickSwitchSub = "Бөлшектеу, қосылу, анти-DPI"

    override val sourceUrl = "Дереккөз URL"
    override fun sourceAlive(alive: Int, total: Int) = "тірі ${alive}/${total}"
    override val open = "Ашу"; override val active = "Белсенді"; override val inactive = "Белсенді емес"
    override val lastDownloaded = "Жүктелді"; override val notDownloaded = "әлі жүктелмеген"
    override fun sourceCounts(dead: Int, total: Int) =
        " тірі, ${dead} өлі, ${total} барлығы"

    override val proxyBase = "Прокси дерекқоры"
    override val totalInBase = "Дерекқорда барлығы"; override val aliveNow = "Қазір тірі"; override val deadStat = "Өлі"
    override val aliveIn15 = "15 минутта тірі"; override val checksAllTime = "Бар уақыттағы тексерулер"
    override val antiDpiTricks = "Анти-DPI айлалары"; override val noStatsYet = "әлі деректер жоқ — айлалар тексерулер/қосылымдар барысында жинақталады"
    override val attempts = "Әрекеттер"; override val handshake = "Handshake"; override val score = "Балл"
    override val tgConnect = "TG-қосылу"; override val socketsOver1m = "Сокеттер >1мин"
    override val over10kb = "Сокеттер >10КБ"; override val over100kb = ">100КБ"; override val workTime = "Жұмыс уақыты"
    override val statsLegend = "Handshake — сәтті қол алысулар (әрекеттердің %-ы) · Балл — тиімділік · " +
        "\"Жұмыс уақыты\" — ≥5КБ әрі 1 минуттан ұзақ сокеттер бойынша жалпы."
    override val resetStats = "Айлалар статистикасын тастау"

    override fun aliveLinks(n: Int) = "Тірі сілтемелер: ${n}"
    override val copyAll = "Барлығын көшіру"
    override val openRandom = "Кездейсоқты ашу"; override val copyRandom = "Кездейсоқты көшіру"; override val allShort = "БАРЛЫҒЫ"
    override val copyTop = "TOP көшіру"; override val randomHost = "Кездейсоқ хост"
    override val exportToFile = "Файлға экспорт"; override val exportSaved = "Файлға сақталды:"
    override val dlNow = "Қазір жүктеу"
    override fun downloadingFmt(sec: Long) = "Жүктеп жатырмын… ${sec} с"
    override val cancel = "Бас тарту"
    override val deleteConfirmTitle = "Жазылымды жою керек пе?"
    override val subscriptionsAddHint = "Жазылымдар немесе прокси-сілтемелер қосу →"
    override val addSourcesTitle = "Қосу"
    override val addSubsLabel = "Жазылымдар (URL, жолына біреуден)"
    override val addSubsHelp = "Дұрыс URL-і бар әр жол жеке жазылым болады әрі мезгіл-мезгіл жүктеледі."
    override val addProxiesLabel = "Дайын прокси-сілтемелер (тұрақты тізім)"
    override val addProxiesHelp = "Нақты проксилерге сілтемелер топтамасын қойыңыз (tg://proxy, https://t.me/proxy, …). Бұл жазылым ЕМЕС — тізім жүктелмейді, проксилер жай каталогқа қосылады."
    override val addButton = "Қосу"
    override fun addedFmt(subs: Int, proxies: Int) = "Қосылды: ${subs} жазылым, ${proxies} прокси"
    override val perSecond = "секундына"
    override val graphSpeed = "Жылдамдық"
    override val graphVolume = "Көлем"
    override val graphLatency = "Ping"
    override val graphConnects = "Қосылулар"
    override val scanNow = "Қазір сканерлеу"; override val scanOnShort = "Скан қосулы"
    override val scanRunning = "Скан жүруде"; override val scanIdle = "Скан idle"; override val scanOffState = "Скан OFF"; override val scanBatchPerThread = "Топтама/ағын"; override val scanPassHosts = "Өтудегі хосттар"; override val minRescanLabel = "Хостты N минутта бір реттен жиі сканерлемеу"
    override val scanPlanTitle = "Жоспар"; override val scanNowTitle = "Қазір"; override val currentScheduleTitle = "Ағымдағы кесте"
    override val scheduleWord = "Кесте"; override val unitPcsPerSec = "дана/с"
    override val scanNowThreadsLabel = "Қазір іске қосылған ағындар"; override val scanNowPerThreadLabel = "1 ағынға тексерулер (жоспар)"; override val scanNowElapsedLabel = "Жұмыс уақыты"
    override val scanOkGraph = "Сәтті скандар"; override val scanFailGraph = "Сәтсіз скандар"; override val scanTrafficGraph = "Скан трафигі"; override val scanAliveGraph = "Барлық тірі прокси"; override val scanPingGraph = "Пинг"; override val threadsGraph = "Ағындар"
    override val scanEvery = "Кезең"; override val scanNextRun = "Келесі іске қосу"
    override val scanThreads = "Ағындар"; override val scanBatch = "Топтамада"
    override val scanElapsed = "Жұмыс істейді"; override val scanIdleNow = "—"
    override val effForFew = "\"Аз\" кезде"; override val effForMany = "\"Көп\" кезде"
    override val effCheck = "Тексеру"; override val effBatch = "Топтама"; override val effPar = "Қатарлас"
    override val effContinuous = "үздіксіз"; override val secShort = "с"; override val minShort = "мин"

    override val appTagline = "Кросс-платформалық авто-коннектор: Telegram жұмыс істейтін MTProto-проксиді " +
        "өзі табады, тексереді әрі көтереді."
    override val version = "Нұсқа"; override val buildDate = "Құрастыру күні"
    override val downloadSources = "Жүктеу және бастапқы код"; override val openOnGithub = "GitHub-та ашу"
    override val feedbackBugs = "Кері байланыс және баг-репорттар"; override val writeTelegram = "Telegram-да жазу"

    override val language = "Тіл"; override val langAuto = "Авто (жүйедегідей)"
    override val langWord = "Тіл"
    override val raceWidthTitle = "Қатарлас қосылулар"
    override val connectionSection = "Қосылу және бұғаттауды айналып өту"
    override val connectionSectionHelp = "Қосылу қозғалтқышы, қатарлас апстримдер саны, проксилеу қозғалтқышы және анти-DPI айлалары — бәрі бір бөлімде."
    override val netLogSection = "Желілік алмасу логы"
    override val platform = "Платформа"

    override val scanModeTitle = "Желі режимі"; override val scanModeAuto = "Авто"; override val scanModeManualLabel = "Қолмен"
    override val activeModeLabel = "Белсенді режим"; override val formingListLabel = "Тізім жасалуда"; override val catalogModeTabs = "Режим"
    override val resetModeRatings = "Хосттар рейтингін нөлдеу"; override val forgetModeHosts = "Режим хосттарын ұмыту"
    override val exportModeTitle = "Режимдер бойынша экспорт"; override val modePickerTitle = "Режим"
    override val modeHelp = "Әр желі режимінде — проксидің жеке рейтингі мен өз сканерлеу әрі жазылым жүктеу қарқыны. \"Авто\" режимді белсенді желіге қарай анықтайды. \"Қолмен\" — режимді өзіңіз таңдайсыз (авто ешқашан таңдамайтын White-ты қоса)."
    override val autoSelect = "Авто таңдау"; override val manualSelect = "Қолмен таңдау"
    override val connStatsTitle = "Қазіргі байланыстар"; override val connOnPort = "Порттағы байланыстар"; override val outgoingConns = "Шығыс байланыстар"
    override val modeChoice = "Режим таңдау"; override val autoChoice = "авто таңдау"; override val manualChoice = "қолмен тұрақты"
    override val directOnVpn = "VPN кезінде TG-ға тікелей қосылу"; override val onWord = "қос"; override val offWord = "өшір"
    override val directStateActive = "белсенді"; override val directStateOff = "баптауларда өшірулі"; override val directStateIdle = "баптауларда қосулы, бірақ белсенді емес"
    override val wpHintTitle = "White деген не?"
    override val wpHint = "White — WhitePages: қолмен орнатылатын желі режимі. Тек қолмен қосылады (авто-таңдау оны қоймайды). " +
        "Хосттардың жеке рейтингін жүргізеді, жазылымдарды жүктейді әрі VPN/Wi-Fi/LTE-ден тәуелсіз сканерлейді."

    // tray
    override val trayOpenWindow = "Терезені ашу"
    override val trayRefreshSubs = "Жазылымдарды жаңарту"
    override val trayExit = "Шығу"
    override fun trayConnectorLabel(on: Boolean) =
        if (on) "Коннектор: ҚОСУЛЫ (өшіру)" else "Коннектор: ӨШУЛІ (қосу)"
    override fun trayScanLabel(on: Boolean) =
        if (on) "Скан: ҚОСУЛЫ (өшіру)" else "Скан: ӨШУЛІ (қосу)"
    override fun trayLive(n: Int) = "Тірі прокси: ${n}"
    override val appearance = "Сыртқы көрінісі"
    override val themeLabel = "Тақырып"
    override val themeAuto = "Авто (жүйеге сәйкес)"
    override val themeLight = "Ашық"
    override val themeDark = "Қараңғы"
    override val drawGraphsLabel = "Графиктерді салу"
    override val drawGraphsSub = "Connector және Scan қойындыларындағы тікелей графиктер — батареяны үнемдеу үшін өшіріңіз"

    override val factoryResetDone = "Бәрі тасталды. Қолданбаны жауып, қайта іске қосыңыз."

    override val recentAttempts = "Соңғы қосылулар мен тексерулер"
    override val kindCheck = "тексеру"
    override val kindTg = "телеграм"
    override val histWho = "Кім"
    override val histWhen = "Қашан"
    override val histReq = "Сұрау"
    override val histSess = "Сессия"
    override val histScan = "скан"
    override val histLegend = "Бағандар — Кім: ✓/✗ TG = нақты Telegram қосылуы, скан = фондық тексеру. Қашан: қанша уақыт бұрын. TCP/TLS/Сұрау: қол алысу мен бірінші сұраудың кідірісі, мс. Сессия: реле сессиясы қанша созылды. ↓/↑: хост арқылы қабылданды / жіберілді байт."
    override val tgOkTotalHint = "Telegram қосылулары / сәтті / барлық тексерулер"
    override val testNow = "Қазір тестілеу"
    override val testShort = "Тест"
    override val testResult = "Тест нәтижесі"
    override val testStop = "Тоқтату"
    override val testingNow = "тест жүруде…"

    override val breadthTitle = "Хост таңдау кеңдігі"
    override val breadthHelp = "Сол жақта — ең жақсы тексерілген хосттарды ұстану; оң жақта — әртүрлі тірі хосттарды барынша кең сынау. Telegram реле порттарын аралап жүргенде, бағдарлама таңдауды автоматты түрде кеңейтеді."
    override val breadthNarrow = "тексерілген"
    override val breadthWide = "кеңірек"
    override val connTimeoutTitle = "Хостқа қосылу таймауты"
    override val connTimeoutHelp = "Келесі проксиді сынамас бұрын бір апстримді (TCP + TLS + бірінші MTProto жауабы) қанша күту керек."

    override val prewarmTitle = "Сокеттерді алдын ала қыздыру (эксперимент)"
    override val prewarmHelp = "Прокси-ге бірнеше сокетті алдын ала ашық ұстау, осылайша жаңа Telegram " +
        "қосылуы қосылу/қол алысуды өткізіп жіберсін. Эксперименттік: фон үнемі қайта қосылады → трафик " +
        "шығыны мен сәл CPU. Жалған трафик жіберілмейді (ол нақты сессияны бұзар еді) — сокеттер тек " +
        "ротацияланады. Ең пайдалысы FakeTLS-проксилермен."
    override val prewarmEnable = "Қыздыруды қосу"
    override val prewarmModeDeferred = "Кейінге қалдырылған (тек TLS)"
    override val prewarmModeDeferredSub = "TCP + FakeTLS ұстаймыз; obfuscated2-init беру кезінде жібереміз. DC коммитленбейді — ең шынайы."
    override val prewarmModeFull = "Толық қол алысу"
    override val prewarmModeFullSub = "Әртүрлі DC бойынша толық қосылған сокеттерді ұстаймыз; тек DC/tag сәйкес келгенде қайта қолданамыз. Олар аз өмір сүреді."
    override val prewarmPoolLabel = "Қор сокеттер"
    override val prewarmHoldLabel = "Ұстау, с"
    override val prewarmNote = "Тек ротация (қолданба деңгейінде keepalive жоқ). Сокет секундтар…~минут өмір сүреді, прокси/DC-ге байланысты."
    override val prewarmStatus = "Қыздыру"
    override fun prewarmStatusVal(ready: Int, holdSecs: Int) = "${ready} дайын · ${holdSecs}с ұстаймын"
    override val prewarmStar = "Қалың қызғылт сары = сокет қыздыру пулынан жылы күйде берілді (қосылу/қол алысусыз)"
    override fun prewarmTableTitle(holdSecs: Int) = "Сокеттерді қыздыру (${holdSecs}с ұстаймын)"
    override val prewarmTableHelp = "\"Сокеттерді қыздыру\" прокси-ге бірнеше сокетті алдын ала ашады, осылайша жаңа " +
        "Telegram қосылуы қосылу/қол алысуды өткізіп жіберсін. Бұл кестеде қыздырылатын хосттар көрсетілген: сокет " +
        "неше секунд өмір сүреді, оны Telegram пайдалана ма, әрі трафик. Қосу/өшіру мен баптауды (режим, сокет саны, " +
        "ұстау уақыты) \"Тағы → Баптаулар → „Сокеттерді қыздыру (эксперимент)“\" бөлімінде жасауға болады."
    override val prewarmNoneWarming = "әзірге қыздырылатын сокеттер жоқ"
    override val prewarmColAge = "өмірі"
    override val prewarmColUse = "TG-да?"
    override val prewarmInUse = "TG-да"
    override val prewarmNew = "жаңа"

    override val lanShareTitle = "Жергілікті желі бойынша тарату (веб-портал)"
    override val lanShareDesc = "Осы Wi-Fi-дағы басқа құрылғыларға бұл АвтоКоннекторды прокси ретінде пайдалануға рұқсат ету; төмендегі мекенжай бойынша браузер ең жақсы проксилермен бетті алады."
    override val lanShareUrlsLabel = "Желідегі көршілер қосылады:"
    override val lanShareNoIp = "жергілікті желіде мекенжай жоқ — Wi-Fi-ға қосылыңыз"
    override val lanFirewallTitle = "Жергілікті желіде рұқсат ету"
    override val lanFirewallBody = "Қосқан кезде реле порттары жергілікті желіге ашылады. Қазір Windows файрволы (немесе басқасы) AutoConnector-ге рұқсат беру керектігін сұрауы мүмкін — \"Рұқсат ету\"/\"Иә\" таңдаңыз. Тыйым салсаңыз, көршілердің АвтоКоннекторға трафигі бұғатталады, бет/прокси қолжетімсіз болады."
    override val lanFirewallConfirm = "Қосу"
    override val lanInfoTitle = "Бұл не үшін?"
    override val lanInfoBody = "АвтоКоннекторды Wi-Fi-ыңыздағы БІР компьютерде немесе телефонда іске қосыңыз — сол желідегі қалған барлық құрылғылар, соның ішінде iPhone (қолданба оны тікелей қолдамайды), браузерде мекенжайды ашып пайдалана алады: олардың Telegram-ына қосу үшін ең жақсы проксилермен бет, немесе осы құрылғының өзі SOCKS-прокси ретінде. Бір құрылғы проксиді тауып ұстайды, қалғандары оны жергілікті желі арқылы пайдаланады."

    override val volTriggerTitle = "Дыбыс түймелерімен триггер"
    override val volTriggerSub = "Дыбыс пернелерінің жылдам үлгісімен проксиді ауыстыру"
    override val volEnableLabel = "Дыбыс түймелерін бақылау"
    override val volHelpTitle = "Бұл не?"
    override val volHelpBody = "Android-та жаһандық пернетақта хоткейлері жоқ, сондықтан ДЫБЫС түймелері қолданылады. Қосулы кезде АвтоКоннектор фонда дыбыс-жоғары/төмен басудың жылдам үлгісін (мысалы жоғары-жоғары-төмен-төмен) бақылайды. Оны танығанда, кездейсоқ жақсы тірі проксидің tg://-сілтемесін ашады — Telegram оны ұстап ауысады. Қолданбаны ашпай проксиді жылдам әрі байқаусыз ротациялаудың тәсілі. Дыбыс әдеттегідей жұмыс істейді (басулар ұсталмайды). Арнайы мүмкіндіктерге (Accessibility) рұқсат қажет (пернелерді фонда оқу әрі сілтемені ашу үшін); құсбелгіні қоспайынша ештеңе сұралмайды. Төменде басулар арасындағы максимал уақытты орнатыңыз; танылатын үлгілер төменде тізілген."
    override val volGrantTitle = "Арнайы мүмкіндіктерді қосыңыз (маңызды)"
    override val volGrantBody = "Android (әсіресе 13+) Google Play-ден ЕМЕС орнатылған қолданбалар үшін арнайы мүмкіндіктерді бұғаттайды — сондықтан AutoConnector сұр түсті әрі \"Қолданбаға рұқсат жоқ\" деп жазады.\n\nҚалай ашу керек:\n1. \"Қолданба туралы\" ашыңыз (төмендегі түйме, немесе: Баптаулар → Қолданбалар → AutoConnector for Telegram).\n2. ⋮ (жоғарғы оң жақтағы үш нүкте) → \"Шектеулі баптауларға рұқсат ету\" → растаңыз.\n3. Қайтыңыз: Баптаулар → Арнайы мүмкіндіктер → AutoConnector for Telegram → қосыңыз.\n\nЕгер \"Шектеулі баптауларға рұқсат ету\" тармағы болмаса — алдымен арнайы мүмкіндіктердегі ауыстырғышты бір рет қосып көріңіз (тыйым туралы хабар шығады), содан кейін 2-қадам қолжетімді болады.\n\nXiaomi/MIUI, Samsung т.б.-да жол сәл өзгеше болуы мүмкін — \"Қолданба туралы\"-да сол ⋮-ні іздеңіз. Android 12 және одан төменде шектеу әдетте жоқ — бірден қосыңыз.\n\nДыбыс пернелері тек оқылады, ешқашан бұғатталмайды."
    override val volOpenAppInfo = "\"Қолданба туралы\" ашу"
    override val volAccessOn = "Арнайы мүмкіндіктер: қосулы"
    override val volAccessOff = "Арнайы мүмкіндіктер: өшірулі"
    override val volOpenAccess = "Арнайы мүмкіндіктер баптауларын ашу"
    override val volGapLabel = "Басулар арасындағы макс. мс"
    override val volPatternsTitle = "Танылатын үлгілер"
    override val volPatternPick = "Үлгі"
    override val volPatternsLegend = "↑ = дыбыс жоғары, ↓ = төмен"
    override val volNoRights = "Қолданбада әзірге дыбыс түймелерін өңдеуге құқық ЖОҚ — бет соңындағы нұсқаулық бойынша рұқсат беріңіз."
    override val volGrantShort = "Арнайы мүмкіндіктерге рұқсат әзірге жоқ. Осы беттің соңындағы толық нұсқаулықты оқып, \"Тексеру\" түймесін басыңыз."
    override val volCheck = "Тексеру"
    override val volCheckOk = "✓ Дайын — рұқсат берілді, триггер жұмыс істейді."
    override val volCheckFail = "✗ Рұқсат әзірге жоқ — жоғарыдағы қадамдарды орындаңыз."
    override val volPatternsList = "↑↑↓↓ · ↓↓↑↑ · ↑↓↑↓ · ↓↑↓↑ · ↑↑↑↑ · ↓↓↓↓ · ↑↓↓↑ · ↓↑↑↓ · ↑↑↑↓↓↓ · ↓↓↓↑↑↑   (↑ = дыбыс жоғары, ↓ = төмен)"
}
