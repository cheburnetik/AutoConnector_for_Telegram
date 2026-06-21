package io.autoconnector.i18n

object Uk : Strings {
    override val tabConnector = "Конектор"; override val tabScan = "Сканування"
    override val tabCatalog = "Каталог"; override val tabLogs = "Журнали"; override val tabMore = "Ще"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "Підписки"; override val logTabScan = "Сканування"
    override val logGeneral = "Загальне"; override val logEmpty = "поки порожньо"
    override val logSessions = "Сесії"; override val logErrorsOnly = "лише помилки"; override val logNoErrors = "немає невдалих сесій"
    override fun logSession(id: String, port: String) = "#${id} · :${port}"
    override val back = "Назад"; override val copy = "Копіювати"; override val gotIt = "Зрозуміло"
    override val later = "Пізніше"; override val details = "Деталі"; override val whatIsThis = "Що це?"
    override val delete = "Видалити"

    override val connector = "Конектор"; override val scan = "Сканування"
    override val notConfigured = "Не налаштовано! Виправити →"; override val howToSetup = "Як налаштувати"
    override val notifOff = "Сповіщення вимкнені! Виправити →"; override val enable = "Увімкнути"
    override fun fewProxies(n: Int) = "Живих проксі ${n}, шукаю, зачекайте ~15 хв…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "Живих проксі: ${alive}  (15 хв: ${within}) · всього: ${total}"
    override val notifWhyTitle = "Навіщо сповіщення?"
    override val notifWhyBody = "Постійний значок сповіщення означає фоновий сервіс Android. " +
        "Без нього система вивантажує застосунок з памʼяті, і він припиняє шукати проксі та " +
        "тримати зʼєднання у фоні. Саме тому сповіщення обовʼязкові для роботи " +
        "AutoConnector."
    override val notifEnableTitle = "Увімкніть сповіщення"
    override val notifEnableBody = "Без значка сповіщення Android вважає застосунок неактивним і " +
        "вивантажує його з памʼяті. Тоді AutoConnector припиняє шукати проксі та тримати " +
        "зʼєднання у фоні — Telegram втрачає звʼязок.\n\nНатисніть \"Увімкнути\" та дозвольте " +
        "сповіщення для AutoConnector."
    override val notifPlea = "Увімкніть сповіщення! Без них застосунок не може працювати у фоні — " +
        "Android вивантажить його, і пошук проксі та зʼєднання припиняться."

    override val statusConnected = "Telegram підключено"; override val statusConnecting = "Підключення…"
    override val statusOffline = "Telegram не підключено"; override val statusIdle = "Telegram очікує"
    override val nobodyConnected = "Ніхто не підключився до Конектора. "; override val howToSetupArrow = "Як налаштувати →"
    override val directModeViaVpn = "Прямий режим: VPN активний — без проксі"
    override val directModeOff = "Прямий режим: проксі вимкнені"
    override val directDpiSuffix = " · анти-DPI"
    override val connections = "Зʼєднання"; override val sockets = "Сокети"; override val speed = "Швидкість"
    override val traffic = "Трафік"; override val latency = "Затримка"
    override fun pcs(n: Int) = "${n} шт"
    override fun netNow(label: String) = "Мережа: ${label}"
    override fun tgToConnector(n: Int) = "TG→ ${n}"
    override fun connectorToProxy(n: Int) = "проксі ${n}"
    override val trafficSec = "трафік · 60 с"; override val trafficMin = "трафік · 60 хв"
    override val latencySec = "затримка · 60 с"; override val latencyMin = "затримка · 60 хв"
    override val sec60 = "60 с"; override val min60 = "60 хв"
    override val unitSec = "с"; override val unitMin = "хв"; override val unitHour = "год"; override val dash = "—"
    override val currentProxy = "Поточний проксі"; override val noActiveProxy = "немає активного проксі (Telegram не підключено)"
    override val host = "Хост"; override val type = "Тип"; override val secret = "Секрет"; override val antiDpi = "Анти-DPI"; override val obfEngine = "Рушій обфускації"
    override fun activeSockets(n: Int) = "Активних сокетів Telegram: ${n}"
    override val noConnections = "немає активних зʼєднань"; override val colHost = "Хост"; override val colTime = "Час"
    override val modeWord = "Режим"; override val directViaVpnLine = "Прямі запити до Telegram (VPN активний)"
    override val connModeHelp = "Режими (VPN, Wi-Fi, LTE, Ethernet, White) дозволяють по-різному налаштувати інтенсивність сканування й тримати окремі рейтинги/статистику хостів. Тип мережі визначається автоматично; режим можна задати вручну в налаштуваннях."

    override val scanOff = "Сканування вимкнено"; override val proxiesInBase = "Проксі в базі"
    override val total = "всього"; override val alive = "живих"; override val dead = "мертвих"
    override val tgConnectedTitle = "Telegram підключено через"; override val successful = "успішних"
    override val socketsHeld = "Час життя сокета"; override val over1m = ">1 хв"; override val over5m = ">5 хв"; override val over15m = ">15 хв"
    override val scanCountTitle = "Кількість перевірок проксі"; override val checked = "Перевірено"
    override val forAllTime = "за весь час"; override val perMinute = "за хвилину"; override val perHour = "за годину"
    override val subsCountTitle = "Кількість завантажень підписок"; override val downloaded = "завантажено"; override val failed = "невдалих"; override val scanTraffic = "трафік сканування"; override val subTraffic = "трафік підписок"; override val subTrafficGraph = "Трафік підписок"
    override val checksMtproto = "Перевірки MTProto (↑ успішно · ↓ помилка)"

    override fun catalogEmpty(mode: String) = "Каталог ${mode} поки порожній. Або жодного хоста не знайдено, або застосунок ще жодного разу не працював у цьому режимі. Режим можна змінити в Налаштуваннях. Режими існують, щоб збирати хости окремо для різних видів інтернет-зʼєднання."
    override val aliveShort = "✓ живий"; override val deadShort = "✗ мертвий"
    override val statusLabel = "Статус"; override val rating = "Рейтинг"; override val port = "Порт"
    override val rttPing = "RTT (пінг)"; override val checkedField = "Перевірено"; override val okOfTotal = "Успішних / усього перевірок"
    override val tgConnectedField = "Telegram підключено"; override val tgSessions = "Сесії Telegram"; override val trafficThroughProxy = "Трафік через проксі"
    override val sessionsTotal = "Усього сесій"; override val relayNow = "Релей зараз"; override val tlsDomain = "Домен TLS (SNI)"
    override val sourceSub = "Джерело (підписка)"; override val lastError = "Остання помилка"; override val yes = "так"; override val no = "ні"
    override val copyAsLink = "Копіювати як посилання"; override val openInTelegram = "Відкрити хост у Telegram"; override val makeNextRelay = "Зробити наступним релеєм"
    override val actCopy = "Копіювати"; override val actOpen = "Відкрити"; override val actRelay = "Релей"
    override fun agoFmt(v: String) = "${v} тому"
    override val catalogTopFor = "Список/рейтинг проксі для"
    override val catalogModeHelpTitle = "Режими та рейтинги"
    override val catalogModeHelp = "Застосунок рахує живі хости та їхні рейтинги ОКРЕМО для кожного режиму мережі (VPN, Wi-Fi, LTE, Ethernet і White). \"White\" — це окремий РУЧНИЙ режим для білих списків; авто ніколи на нього не перемикається. Тож той самий хост може бути живим в одному режимі й мертвим в іншому."
    override fun catalogInactiveWarn(section: String, active: String) =
        "Ви переглядаєте неактивний розділ ${section} — уся статистика зараз іде в ${active}, а не сюди."
    override val manageModeTitle = "Керування режимом"
    override val manageResetRating = "Скинути рейтинг"
    override fun manageResetHint(mode: String) = "Конкретно для ${mode} можна скинути рейтинг і статистику використання живих хостів. Це зручно, коли ви підключилися до принципово іншого VPN чи LTE, щоб стара статистика не заважала. Або щоб подивитися, як швидко сканування проксі перевіряє все заново."
    override val manageDeleteAll = "Видалити хости в"
    override fun manageDeleteHint(mode: String) = "Можна очистити і рейтинг, і самі хости з ${mode}. Функція \"Сканувати проксі\" збере їх знову. Це не скидання підписок — можна натиснути, а потім зачекати ~15 хвилин на повторне сканування."
    override fun manageCopyFrom(mode: String) = "Скопіювати всі хости й рейтинги до цього режиму (${mode}) з іншого режиму:"
    override val live = "живих"; override val deadW = "мертвих"; override val unitMs = "мс"
    override val agoMin = "хв"; override val agoHour = "год"; override val agoDay = "дн"

    override val connectTelegram = "Підключення Telegram"; override val readCarefully = "Читайте уважно!"
    override val guideIntro = "Цей застосунок не працюватиме без налаштування. Оберіть будь-який один із 3 варіантів нижче " +
        "та уважно виконайте інструкції."
    override val variant1 = "Варіант №1 — кнопки"
    override val variant1Body = "Натисніть \"Проксі {A}\" — відкриється Telegram, підтвердьте додавання проксі. Поверніться " +
        "на цей екран і натисніть \"Проксі {B}\" — підтвердьте додавання вдруге.\n\nВимкніть будь-які " +
        "інші старі проксі в Telegram. Має залишитися рівно 2 проксі — з портами {A} та {B}. " +
        "З будь-яким іншим набором AutoConnector не працюватиме."
    override val variant2 = "Варіант №2 — посилання"
    override val variant2Body = "Скопіюйте текст нижче в Збережені повідомлення (або будь-який чат) у Telegram — " +
        "тобто надішліть його собі. Натисніть перше посилання у своєму повідомленні — перший проксі додано. " +
        "Натисніть друге посилання — другий додано. Потім вимкніть усі старі проксі."
    override val variant3 = "Варіант №3 — вручну"
    override val variant3Body = "Додайте вручну проксі SOCKS5: сервер localhost (127.0.0.1), порт {A}. " +
        "Потім другий проксі: localhost, порт {B}. Видаліть усі старі проксі."
    override val whatNext = "Що далі?"
    override val whatNextBody = "У Telegram увімкніть \"автоперемикання проксі\" — 5 секунд. Ви можете допомогти " +
        "Telegram підключитися, вручну натиснувши проксі (всередині Telegram), який НЕ активний або позначений " +
        "як \"недоступний\" — це змусить Telegram сильніше намагатися підключитися.\n\nПереконайтеся, що всі інші старі " +
        "проксі видалено, окрім {A} та {B}. Натисніть " +
        "\"Використовувати проксі\" в Telegram.\n\nЗачекайте, поки застосунок знайде й завантажить достатньо проксі " +
        "(5–15 хвилин). Тоді Telegram сам підключиться до AutoConnector, який і далі маршрутизуватиме " +
        "Telegram через найкращі проксі: перевірені, живі та швидкі.\n\nЯкщо інструкції здаються " +
        "складними — на жаль, ви не зможете користуватися застосунком: налаштувати все " +
        "автоматично неможливо, а пошук живих проксі займає час.\n\nЯкщо ви завантажили застосунок давно " +
        "і живих проксі не знайдено — оновіть або застосунок, або список підписок. Цей застосунок " +
        "не вигадує й не надає власних проксі, він лише шукає в інтернеті по десятках " +
        "груп і сторінок."
    override fun proxyBtn(port: Int) = "Проксі ${port}"

    override val setupPortsTitle = "Налаштування портів у Telegram"
    override val setupPortsSub = "Як підключити Telegram до Конектора (порти 55001/55002)"
    override val settings = "Налаштування"; override val settingsSub = "Порти, анти-DPI, сканування, мережа, батарея"
    override val subscriptions = "Підписки"; override val subscriptionsSub = "Джерела проксі для сканування"
    override val statistics = "Статистика"; override val statisticsSub = "База проксі + прийоми анти-DPI"
    override val export = "Експорт"; override val exportSub = "tg:// посилання живих проксі"
    override val about = "Про застосунок"; override val aboutSub = "Версія, збірка, завантаження, відгук"
    override val hotkeys = "Гарячі клавіші"
    override val hotkeysSub = "Глобальні клавіші: копіювати / відкрити проксі"
    override val hotkeysIntro = "Глобальні гарячі клавіші спрацьовують навіть коли вікно застосунку не у фокусі. Вони обирають " +
        "випадкове посилання на живий проксі (tg://) з пулу — зручно для швидкого перемикання проксі без " +
        "відкриття застосунку."
    override val hotkeysNote = "На macOS захоплення клавіш може потребувати дозволу Accessibility " +
        "(Системні налаштування → Конфіденційність і безпека → Accessibility)."
    override val hotkeyCopyTitle = "Копіювати посилання на проксі"
    override val hotkeyCopyDesc = "Поміщає випадкове живе посилання tg:// у буфер обміну."
    override val hotkeyEnable = "Увімкнути гарячі клавіші"; override val hotkeyLetterLabel = "Літера"; override val hotkeySet = "Задати"; override val hotkeyReset = "Скинути"
    override val hotkeyOpenTitle = "Відкрити проксі в Telegram"
    override val hotkeyOpenDesc = "Відкриває випадкове живе посилання — Telegram підхоплює його й пропонує підключити проксі."

    override val relayPorts = "Порти релею"
    override val relayPortsHelp = "Локальні порти, які слухає Конектор. Саме їх ви вводите в " +
        "Telegram як проксі SOCKS5 (127.0.0.1 : порт). Для надійності використовуються два порти — Telegram " +
        "тримає зʼєднання з обома."
    override val portA = "Порт A"; override val portB = "Порт B"
    override val antiDpiTrick = "Прийом анти-DPI"
    override val antiDpiHelp = "Спосіб замаскувати зʼєднання, щоб провайдер/DPI не розпізнав і " +
        "не заблокував його.\n• \"Автоперебір\" сам обирає робочий прийом.\n• \"Без прийомів DPI\" — звичайне " +
        "зʼєднання.\n• Решта — конкретні техніки (імітація браузера, розбиття пакетів тощо)."
    override val onlyFakeTls = "Лише FakeTLS (ee)"
    override val applyDpiTo = "Застосувати анти-DPI до"
    override val applyDpiHelp = "До чого застосувати обраний прийом анти-DPI:\n• Релей Telegram — до " +
        "живого зʼєднання Telegram через Конектор.\n• Проби проксі — до фонових перевірок проксі " +
        "(тоді перевірка поводиться так само, як справжнє зʼєднання, а статистика прийомів точніша).\n" +
        "• При прямому підключенні — коли проксі вимкнені (або пропущені, поки активний VPN) і Telegram " +
        "іде напряму на свої сервери: тут немає проксі, тож прийом зводиться до розбиття " +
        "першого TCP-пакета (рукостискання) на кілька дрібних сегментів, щоб DPI не зміг зіставити його за одне зчитування."
    override val toRelay = "Релей Telegram"; override val toProbes = "Проби проксі"
    override val toDirect = "При прямому підключенні"
    override val vpnSection = "Коли VPN увімкнено"
    override val vpnHelp = "Що робити, коли на пристрої активний VPN:\n• Через проксі MTProto — " +
        "Telegram іде через знайдені проксі як зазвичай (поверх VPN).\n• Напряму — " +
        "Конектор НЕ використовує проксі й підключає Telegram напряму до серверів Telegram: " +
        "VPN уже надає доступ, додатковий шар проксі непотрібний (швидше й стабільніше). " +
        "Без VPN проксі використовуються як зазвичай."
    override val linkFormat = "Формат посилання на проксі"
    override val linkFormatHelp = "Як копіювати й відкривати проксі. tg:// відкриває Telegram напряму (потрібен встановлений Telegram Desktop). http (t.me) відкриває через браузер і пропонує відкрити в Telegram — зручно, якщо tg:// не зареєстровано."
    override val linkTg = "tg:// (відкрити Telegram напряму)"; override val linkTgSub = "tg://proxy?… — відкриває Telegram"
    override val linkHttp = "http (t.me, через браузер)"; override val linkHttpSub = "https://t.me/proxy?… — відкриває браузер"
    override val viaMtproto = "Проксі через MTProto"; override val viaMtprotoSub = "навіть з VPN трафік іде через проксі"
    override val directly = "Підключатися напряму"; override val directlySub = "за активного VPN — обходячи проксі, прямо в Telegram"
    override val notifications = "Сповіщення"
    override val scanCheck = "Сканування й перевірка"
    override val scanCheckHelp = "• Сканування, хв — як часто завантажувати списки проксі з підписок.\n" +
        "• Перевірка, хв — як часто перевіряти проксі в базі на живучість.\n• Розмір пакета — " +
        "скільки проксі перевіряти за один прохід.\n• Паралельно — скільки перевірок виконувати одночасно (більше = " +
        "швидше, але вище навантаження на мережу й батарею)."
    override val scanMin = "Сканування, хв"; override val checkMin = "Перевірка, хв"; override val batchSize = "Розмір пакета"; override val parallel = "Паралельно"
    override val speedByNet = "Інтенсивність сканування за мережею"
    override val speedByNetHelp = "Як часто перевіряти проксі залежно від поточної мережі. " +
        "\"Стандартно\" = базовий інтервал. Зсуньте праворуч для рідшого (повільніше, ощадніше до трафіку/батареї), " +
        "ліворуч для частішого (швидше, агресивніше). Логарифмічна шкала, до ×100 у кожен бік.\n" +
        "• VPN — коли активний зовнішній VPN.\n• Wi-Fi — у мережі Wi-Fi.\n• LTE — у мобільній мережі."
    override val intensStandard = "стандартно"
    override val intensSlower = "повільніше"
    override val intensFaster = "швидше"
    override val maintenance = "Скидання даних"
    override val maintenanceHelp = "• \"Скинути каталог і статистику\" — обнуляє рейтинги, лічильники, трафік " +
        "та журнали перевірок, але зберігає завантажені хости й підписки (усе переоцінюється під час " +
        "наступного сканування).\n• \"Очистити завантажені хости\" — видаляє весь пул проксі, але зберігає " +
        "підписки, щоб сканування знову наповнило пул. Підписки в жодному разі не чіпаються."
    override val backupTitle = "Експорт / Імпорт"
    override val backupHelp = "Збережіть або відновіть дані застосунку у форматі JSON. Позначте, що " +
        "включити — будь-яка комбінація:\n• Налаштування — усі параметри застосунку.\n• Підписки — список " +
        "джерел (URL + увімк/вимк).\n• Каталог живих хостів — кожен живий проксі з його рейтингами й статистикою " +
        "ДЛЯ КОЖНОГО режиму мережі.\n\n\"Експорт\" відкриває сторінку з готовим JSON — скопіюйте його або збережіть у файл. " +
        "\"Імпорт\" — вставте JSON (або завантажте файл), і застосуються лише позначені розділи, наявні в " +
        "ньому. Імпорт ДОДАЄ до поточних даних (без стирання)."
    override val backupSettings = "Налаштування"
    override val backupSubs = "Підписки"
    override val backupHosts = "Каталог живих хостів (за режимами)"
    override val exportWord = "Експорт"
    override val importWord = "Імпорт"
    override val backupExportTitle = "Експорт даних"
    override val backupImportTitle = "Імпорт даних"
    override val backupSelectExport = "Що експортувати:"
    override val backupSelectImport = "Що імпортувати:"
    override val backupCopyBtn = "Копіювати"
    override val backupSaveFile = "Зберегти у файл"
    override val backupLoadFile = "Завантажити з файлу"
    override val backupDoImport = "Імпортувати"
    override val backupPasteLabel = "Вставте сюди JSON резервної копії"
    override val backupJsonLabel = "JSON резервної копії"
    override val backupAndroidFileNote = "Файли тут недоступні — скористайтеся Копіювати / Вставити."
    override val eraseAllHosts = "Стерти всі хости"
    override val factoryReset = "Скинути все (як перший запуск)"
    override val factoryResetConfirm = "Повністю скинути застосунок до заводського стану? УСІ налаштування й увесь " +
        "каталог хостів буде стерто, підписки відновляться до типових. Так само, як перший запуск."
    override val resetCatalog = "Скинути каталог і статистику"
    override val resetCatalogConfirm = "Обнулити всі рейтинги, лічильники й журнали перевірок? " +
        "Завантажені хости й підписки зберігаються та переоцінюються під час наступного сканування."
    override val clearHosts = "Очистити завантажені хости"
    override val clearHostsConfirm = "Видалити весь список завантажених хостів (проксі)? " +
        "Підписки зберігаються, і сканування знову наповнить пул."
    override val doReset = "Скинути"
    override val doCancel = "Скасувати"
    override val adaptiveSpeed = "Адаптивна швидкість"
    override val adaptiveHelp = "Перевірки живучості виконуються з базовим інтервалом (із \"Сканування й перевірка\", також " +
        "помноженим на множник мережі). \"Адаптивна швидкість\" пришвидшує або сповільнює їх " +
        "автоматично залежно від того, скільки проксі зараз живі.\n\n" +
        "• МАЛО живих (нижче порогу \"Мало\") → інтервал × \"Пришвидшення\". Множник менший за 1 = частіше: " +
        "0.5 — удвічі частіше, 0.25 — у 4×. Швидше наповнює пул.\n" +
        "• БАГАТО живих (вище порогу \"Багато\") → інтервал × \"Сповільнення\". Більший за 1 = рідше: 2 — " +
        "удвічі рідше, 4 — учетверо. Економить батарею й трафік.\n" +
        "• Між порогами — базова швидкість (×1).\n\n" +
        "Приклади:\n" +
        "— Збирати проксі швидше: \"Пришвидшення\" 0.25 та/або поріг \"Мало\" 40.\n" +
        "— Економити батарею, коли достатньо: \"Сповільнення\" 8 та/або поріг \"Багато\" 30.\n" +
        "— Вимкнути адаптацію: задайте обидва множники на 1.\n\n" +
        "Типові: Мало 20, Пришвидшення 0.5, Багато 50, Сповільнення 4."
    override val threshMany = "Поріг \"Багато\""; override val threshFew = "Поріг \"Мало\""; override val mulFast = "Пришвидшення ×"; override val mulLazy = "Сповільнення ×"
    override val subIntensityTitle = "Інтенсивність підписок"
    override val subIntensityHint = "Пауза між завантаженнями підписок: скільки хвилин до повторного завантаження списків проксі (окремо для кожного режиму мережі)."
    override val baseScanTitle = "Базова швидкість сканування"
    override val baseScanHelp = "Еталонна швидкість перевірки живучості. \"Адаптивна швидкість\" і множники \"Швидкість за " +
        "режимом\" обчислюються відносно неї.\n\n" +
        "• Як часто запускати, хв — інтервал між проходами перевірки.\n" +
        "• Пакет на потік, хостів — скільки хостів кожен потік перевіряє за прохід.\n" +
        "• Потоки — скільки перевірок виконується одночасно. Прохід пробує \"пакет × потоки\" хостів.\n" +
        "• Не пересканувати хост частіше, ніж раз на N хв — анти-флуд: нещодавно перевірений хост " +
        "пропускається в цьому проході.\n\n" +
        "Більше потоків і більший пакет = швидше зростання пулу, але важче навантаження на мережу й батарею."
    override val baseScanPeriod = "Як часто запускати, хв"
    override val baseScanBatch = "Пакет на потік, хостів"; override val baseScanThreads = "Кількість потоків"
    override val adaptiveDesc = "Якщо живих проксі менше за \"мало\" або більше за \"багато\", застосувати додатковий множник."
    override val fewWord = "Мало"; override val manyWord = "Багато"
    override fun fasterX(x: String) = "×${x} швидше"
    override fun slowerX(x: String) = "×${x} повільніше"
    override fun ifAliveLt(n: Int) = "Якщо живих проксі < ${n}, то:"
    override fun ifAliveGt(n: Int) = "Якщо живих проксі > ${n}, то:"
    override val disabledWord = "вимк"
    override val speedByModeTitle = "Швидкість за режимом"
    override val speedByModeHelp = "Множник швидкості сканування для кожного режиму мережі, поверх базової " +
        "швидкості. \"Стандартно\" (×1) = базовий інтервал. Праворуч — рідше (повільніше, ощадніше до трафіку/" +
        "батареї), ліворуч — частіше (швидше, агресивніше). Логарифмічна шкала, до ×100 у кожен " +
        "бік.\n\n" +
        "Під кожним повзунком — підсумкові параметри проходу з урахуванням адаптивної швидкості — " +
        "показані окремо для \"мало живих\" (× \"Пришвидшення\") і \"багато живих\" (× \"Сповільнення\").\n\n" +
        "Режими:\n• VPN — активний зовнішній VPN.\n• LTE — мобільна мережа.\n• Wi-Fi — мережа Wi-Fi.\n" +
        "• Ethernet — дротове зʼєднання.\n• White — ручний \"білий\" режим проксі."
    override val aliveLt = "живих <"; override val aliveGt = "живих >"
    override val periodWord = "період"; override val nonstopWord = "безперервно"
    override val batchWord = "пакет"; override val threadsWord = "потоки"; override val scanModeOff = "скан вимк"
    override val netBattery = "Мережа й батарея"
    override val netBatteryHelp = "• Лише Wi-Fi — не сканувати в мобільних мережах (економить трафік).\n• Лише при " +
        "зарядці — працювати лише поки телефон заряджається.\n• Пропускати при низькому заряді — призупиняти сканування, коли " +
        "заряд батареї низький."
    override val onlyWifi = "Лише Wi-Fi"; override val onlyCharging = "Лише при зарядці"; override val skipLowBattery = "Пропускати при низькому заряді"
    override val autosaved = "Налаштування зберігаються автоматично."
    override val dpiAutoLabel = "Автоперебір прийомів DPI"; override val dpiNoneLabel = "Без прийомів DPI (звичайне)"
    override val experimental = "Експериментальне"
    override val experimentalHelp = "Альтернативні рушії проксіювання до MTProto-аплінку плюс діагностичний журнал. " +
        "Еталонний (робочий) шлях не змінюється, коли встановлено \"Вимк\". Змінюється лише ТЕ, ЯК зашифрований потік записується " +
        "в TCP-сокет аплінку (розміри сегментів, тайминг, межі TLS-записів) — сам потік залишається байт-у-байт ідентичним. " +
        "Стосується лише живого релею проксі (не проб, не прямого шляху)."
    override val expEngineTitle = "Рушій проксіювання (обфускація сокета)"
    override val expConnectTitle = "Рушій підключення (вибір аплінку)"
    override val expEngineWarn = "⚠ Експериментальний режим. Якщо звʼязність погіршиться, поверніться до \"Вимк (еталонний шлях)\"."
    override val netLog = "Увімкнути журнал мережевого обміну"
    override val netLogSub = "Записує ХТО-КОМУ-КОЛИ та розміри пакетів у файл (БЕЗ даних корисного навантаження) — " +
        "щоб порівняти патерн обміну з VPN і без нього."
    override val openLogFolder = "Відкрити теку журналу"; override val copyPath = "Копіювати шлях"
    override val helpShow = "Довідка"; override val helpHide = "Сховати довідку"
    override val quickSwitchIntro = "Тут можна обрати прийом обходу блокувань. Якщо Telegram показує помилку " +
        "«Проксі, який ви використовуєте, налаштований неправильно й буде вимкнений. Знайдіть, будь ласка, інший», " +
        "поекспериментуйте, який тип обфускації трафіку працює, щоб Telegram перестав її показувати. Почніть " +
        "із режимів split*. Режими coalesce* теж працюють, але зображення/відео в Telegram з ними завантажуються погано."
    override val quickSwitchTitle ="Обхід блокувань"; override val quickSwitchSub = "Шейпінг, підключення, анти-DPI"

    override val sourceUrl = "URL джерела"
    override fun sourceAlive(alive: Int, total: Int) = "живих ${alive}/${total}"
    override val open = "Відкрити"; override val active = "Активна"; override val inactive = "Неактивна"
    override val lastDownloaded = "Завантажено"; override val notDownloaded = "ще не завантажено"
    override fun sourceCounts(dead: Int, total: Int) =
        " живих, ${dead} мертвих, ${total} всього"

    override val proxyBase = "База проксі"
    override val totalInBase = "Усього в базі"; override val aliveNow = "Живих зараз"; override val deadStat = "Мертвих"
    override val aliveIn15 = "Живих за 15 хв"; override val checksAllTime = "Перевірок за весь час"
    override val antiDpiTricks = "Прийоми анти-DPI"; override val noStatsYet = "поки немає даних — прийоми накопичуються під час перевірок/зʼєднань"
    override val attempts = "Спроби"; override val handshake = "Рукостискання"; override val score = "Оцінка"
    override val tgConnect = "Підключення TG"; override val socketsOver1m = "Сокети >1хв"
    override val over10kb = "Сокети >10KB"; override val over100kb = ">100KB"; override val workTime = "Час роботи"
    override val statsLegend = "Рукостискання — успішні рукостискання (% спроб) · Оцінка — значення · " +
        "\"Час роботи\" — сумарно по сокетах ≥5KB і довших за 1 хвилину."
    override val resetStats = "Скинути статистику прийомів"

    override fun aliveLinks(n: Int) = "Живих посилань: ${n}"
    override val copyAll = "Копіювати все"
    override val openRandom = "Відкрити випадковий"; override val copyRandom = "Копіювати випадковий"; override val allShort = "УСІ"
    override val copyTop = "Копіювати TOP"; override val randomHost = "Випадковий хост"
    override val exportToFile = "Експортувати у файл"; override val exportSaved = "Збережено у файл:"
    override val dlNow = "Завантажити зараз"
    override fun downloadingFmt(sec: Long) = "Завантаження… ${sec}с"
    override val cancel = "Скасувати"
    override val deleteConfirmTitle = "Видалити підписку?"
    override val subscriptionsAddHint = "Додайте підписки або посилання на проксі →"
    override val addSourcesTitle = "Додати"
    override val addSubsLabel = "Підписки (один URL на рядок)"
    override val addSubsHelp = "Кожен рядок із дійсним URL стає окремою підпискою й періодично завантажується."
    override val addProxiesLabel = "Готові посилання на проксі (фіксований список)"
    override val addProxiesHelp = "Вставте пакет посилань на конкретні проксі (tg://proxy, https://t.me/proxy, …). Це НЕ підписка — список ніколи не завантажується, проксі просто додаються до каталогу."
    override val addButton = "Додати"
    override fun addedFmt(subs: Int, proxies: Int) = "Додано: ${subs} підписок, ${proxies} проксі"
    override val perSecond = "за с"
    override val graphSpeed = "Швидкість"
    override val graphVolume = "Обсяг"
    override val graphLatency = "Пінг"
    override val graphConnects = "Підключення"
    override val scanNow = "Сканувати зараз"; override val scanOnShort = "Скан увімк"
    override val scanRunning = "Сканування виконується"; override val scanIdle = "Сканування очікує"; override val scanOffState = "Скан ВИМК"; override val scanBatchPerThread = "Пакет/потік"; override val scanPassHosts = "Хостів у проході"; override val minRescanLabel = "Не пересканувати хост частіше, ніж раз на N хв"
    override val scanPlanTitle = "План"; override val scanNowTitle = "Зараз"; override val currentScheduleTitle = "Поточний розклад"
    override val scheduleWord = "Розклад"; override val unitPcsPerSec = "шт/с"
    override val scanNowThreadsLabel = "Потоків працює зараз"; override val scanNowPerThreadLabel = "Перевірок на потік (план)"; override val scanNowElapsedLabel = "Час роботи"
    override val scanOkGraph = "Успішні сканування"; override val scanFailGraph = "Невдалі сканування"; override val scanTrafficGraph = "Трафік сканування"; override val scanAliveGraph = "Усього живих проксі"; override val scanPingGraph = "Пінг"; override val threadsGraph = "Потоки"
    override val scanEvery = "Кожні"; override val scanNextRun = "Наступний запуск"
    override val scanThreads = "Потоки"; override val scanBatch = "Пакет"
    override val scanElapsed = "Працює"; override val scanIdleNow = "—"
    override val effForFew = "Коли мало"; override val effForMany = "Коли багато"
    override val effCheck = "Перевірка"; override val effBatch = "Пакет"; override val effPar = "Паралельно"
    override val effContinuous = "безперервно"; override val secShort = "с"; override val minShort = "хв"

    override val appTagline = "Кросплатформний автоконектор: знаходить, перевіряє та запускає MTProto-проксі, " +
        "через які працює Telegram."
    override val version = "Версія"; override val buildDate = "Дата збірки"
    override val downloadSources = "Завантаження й джерела"; override val openOnGithub = "Відкрити на GitHub"
    override val feedbackBugs = "Відгуки й звіти про помилки"; override val writeTelegram = "Написати в Telegram"

    override val language = "Мова"; override val langAuto = "Авто (система)"; override val langRu = "Русский"; override val langEn = "English"
    override val langFa = "فارسی"; override val langZh = "简体中文"; override val langAr = "العربية"; override val langUr = "اردو"
    override val langTr = "Türkçe"; override val langId = "Bahasa Indonesia"; override val langHi = "हिन्दी"; override val langBn = "বাংলা"; override val langMy = "မြန်မာ"
    override val langWord = "Мова"
    override val raceWidthTitle = "Паралельні підключення"
    override val connectionSection = "Зʼєднання й обхід блокувань"
    override val connectionSectionHelp = "Рушій підключення, паралельні аплінки, рушій проксіювання та прийоми анти-DPI — усе в одному розділі."
    override val netLogSection = "Журнал мережевого обміну"
    override val platform = "Платформа"

    override val scanModeTitle = "Режим мережі"; override val scanModeAuto = "Авто"; override val scanModeManualLabel = "Вручну"
    override val activeModeLabel = "Активний режим"; override val formingListLabel = "Формування списку"; override val catalogModeTabs = "Режим"
    override val resetModeRatings = "Скинути рейтинги хостів"; override val forgetModeHosts = "Забути хости режиму"
    override val exportModeTitle = "Експорт за режимом"; override val modePickerTitle = "Режим"
    override val modeHelp = "Кожен режим мережі тримає власні рейтинги проксі та власну інтенсивність сканування + завантаження підписок. \"Авто\" обирає режим за активною мережею. \"Вручну\" дозволяє самостійно обрати будь-який режим (включно з White, який авто ніколи не обирає)."
    override val autoSelect = "Авто-вибір"; override val manualSelect = "Ручний вибір"
    override val connStatsTitle = "Зʼєднання зараз"; override val connOnPort = "Зʼєднань на порту"; override val outgoingConns = "Вихідні зʼєднання"
    override val modeChoice = "Вибір режиму"; override val autoChoice = "авто-вибір"; override val manualChoice = "фіксований вручну"
    override val directOnVpn = "Пряме підключення до TG за VPN"; override val onWord = "увімк"; override val offWord = "вимк"
    override val directStateActive = "активно"; override val directStateOff = "вимкнено в налаштуваннях"; override val directStateIdle = "увімкнено в налаштуваннях, але не активне"
    override val wpHintTitle = "Що таке White?"
    override val wpHint = "White — WhitePages: ручний мережевий профіль. Вмикається лише вручну (авто-вибір ніколи його не обирає). " +
        "Тримає власні рейтинги хостів, завантажує підписки та сканує незалежно від VPN/Wi-Fi/LTE."

    // host detail history + selection sliders
    override val recentAttempts = "Останні підключення та перевірки"
    override val kindCheck = "перевірка"
    override val kindTg = "телеграм"
    override val histWho = "Хто"
    override val histWhen = "Коли"
    override val histReq = "Запит"
    override val histSess = "Сесія"
    override val histScan = "скан"
    override val testNow = "Тестувати зараз"
    override val testShort = "Тест"
    override val testResult = "Результат тесту"
    override val testStop = "Стоп"
    override val testingNow = "триває тест…"
    override val prewarmTitle = "Прогрів сокетів (експеримент)"
    override val prewarmHelp = "Тримати заздалегідь відкритими кілька сокетів до проксі, щоб нове " +
        "підключення Telegram пропускало конект/рукостискання. Експериментально: фон постійно " +
        "перепідключається → витрата трафіку й трохи CPU. Фейковий трафік не надсилається (він зламав би " +
        "справжню сесію) — сокети просто ротуються. Найкорисніше з проксі FakeTLS."
    override val prewarmEnable = "Увімкнути прогрів"
    override val prewarmModeDeferred = "Відкладений (лише TLS)"
    override val prewarmModeDeferredSub = "Тримаємо TCP + FakeTLS; obfuscated2-init досилаємо при передачі. DC не фіксується — найреалістичніше."
    override val prewarmModeFull = "Повне рукостискання"
    override val prewarmModeFullSub = "Тримаємо повністю підключені сокети по різних DC; повторно використовуємо лише за збігом DC/tag. Живуть менше."
    override val prewarmPoolLabel = "Сокетів про запас"
    override val prewarmHoldLabel = "Тримати, с"
    override val prewarmNote = "Лише ротація (без keepalive на рівні застосунку). Сокет живе секунди…~хвилину, залежно від проксі/DC."
    override val prewarmStatus = "Прогрів"
    override fun prewarmStatusVal(ready: Int, holdSecs: Int) = "$ready готові · тримаю ${holdSecs}с"
    override val prewarmStar = "Жирний помаранчевий = сокет відданий теплим із пулу прогріву (без конекта/рукостискання)"
    override fun prewarmTableTitle(holdSecs: Int) = "Прогрів сокетів (тримаю ${holdSecs}с)"
    override val prewarmTableHelp = "«Прогрів сокетів» заздалегідь відкриває кілька сокетів до проксі, щоб нове " +
        "підключення Telegram пропускало конект/рукостискання. У цій таблиці показані прогрівані хости: скільки секунд " +
        "живе сокет, чи використовує його Telegram, і трафік. Увімкнути/вимкнути та налаштувати (режим, кількість сокетів, " +
        "час утримання) можна в «Ще → Налаштування → „Прогрів сокетів (експеримент)“»."
    override val prewarmNoneWarming = "поки немає прогріваних сокетів"
    override val prewarmColAge = "живе"
    override val prewarmColUse = "в TG?"
    override val prewarmInUse = "в TG"
    override val prewarmNew = "новий"
    override val lanShareTitle = "Роздача по локальній мережі (веб-портал)"
    override val lanShareDesc = "Дозволити іншим пристроям у цьому Wi-Fi використовувати цей АвтоКонектор як проксі; браузер за адресою нижче отримає сторінку з найкращими проксі."
    override val lanShareUrlsLabel = "Сусіди по мережі підключаються:"
    override val lanShareNoIp = "немає адреси в локальній мережі — підключіться до Wi-Fi"
    override val lanFirewallTitle = "Дозволити в локальній мережі"
    override val lanFirewallBody = "Під час увімкнення порти релею відкриються в локальну мережу. Зараз файрвол Windows (або інший) може запитати, чи дозволити AutoConnector — оберіть «Дозволити»/«Так». Якщо заборонити, трафік сусідів до АвтоКонектора буде заблоковано, і сторінка/проксі будуть недоступні."
    override val lanFirewallConfirm = "Увімкнути"
    override val lanInfoTitle = "Навіщо це?"
    override val lanInfoBody = "Запустіть АвтоКонектор на ОДНОМУ компʼютері чи телефоні у вашому Wi-Fi — і всі інші пристрої в тій самій мережі, включно з iPhone (який застосунок напряму не підтримує), зможуть просто відкрити адресу в браузері й користуватися: сторінка з найкращими проксі для додавання в їхній Telegram, або сам цей пристрій як SOCKS-проксі. Один пристрій знаходить і тримає проксі, інші користуються ним по локальній мережі."
    override val volTriggerTitle = "Тригер кнопками гучності"
    override val volTriggerSub = "Перемикання проксі швидким патерном клавіш гучності"
    override val volEnableLabel = "Стежити за кнопками гучності"
    override val volHelpTitle = "Що це?"
    override val volHelpBody = "На Android немає глобальних клавіатурних хоткеїв, тому використовуються кнопки ГУЧНОСТІ. Коли увімкнено, АвтоКонектор у фоні стежить за швидким патерном натискань гучність-вгору/вниз (наприклад вгору-вгору-вниз-вниз). Розпізнавши його, він відкриває tg://-посилання випадкового хорошого живого проксі — Telegram його перехоплює й перемикається. Швидкий непомітний спосіб ротації проксі, не відкриваючи застосунок. Гучність працює як зазвичай (натискання не перехоплюються). Потрібен доступ Accessibility (щоб читати клавіші у фоні й відкривати посилання); нічого не запитується, поки не ввімкнете галочку. Нижче задайте максимум часу між натисканнями; розпізнавані патерни перелічені внизу."
    override val volGrantTitle = "Увімкніть Accessibility (важливо)"
    override val volGrantBody = "Android (особливо 13+) блокує Accessibility для застосунків, встановлених НЕ з Google Play — тому AutoConnector сірий і пише «Доступ для застосунку заборонено».\n\nЯк розблокувати:\n1. Відкрийте «Про застосунок» (кнопка нижче, або: Налаштування → Застосунки → AutoConnector for Telegram).\n2. Натисніть ⋮ (три крапки вгорі праворуч) → «Дозволити обмежені налаштування» → підтвердьте.\n3. Поверніться: Налаштування → Accessibility → AutoConnector for Telegram → увімкніть.\n\nЯкщо пункту «Дозволити обмежені налаштування» немає — спершу один раз спробуйте увімкнути перемикач в Accessibility (зʼявиться повідомлення про заборону), потім крок 2 стане доступним.\n\nНа Xiaomi/MIUI, Samsung та ін. шлях може трохи відрізнятися — шукайте той самий ⋮ у «Про застосунок». На Android 12 і старіших обмеження зазвичай немає — вмикайте одразу.\n\nКлавіші гучності лише читаються, ніколи не блокуються."
    override val volOpenAppInfo = "Відкрити «Про застосунок»"
    override val volAccessOn = "Accessibility: увімкнено"
    override val volAccessOff = "Accessibility: вимкнено"
    override val volOpenAccess = "Відкрити налаштування Accessibility"
    override val volGapLabel = "Макс. мс між натисканнями"
    override val volPatternsTitle = "Розпізнавані патерни"
    override val volPatternPick = "Патерн"
    override val volPatternsLegend = "↑ = гучність вгору, ↓ = вниз"
    override val volNoRights = "Застосунок поки НЕ має прав на обробку кнопок гучності — надайте доступ за інструкцією внизу сторінки."
    override val volGrantShort = "Доступу Accessibility поки немає. Прочитайте докладну інструкцію внизу цієї сторінки й натисніть «Перевірити»."
    override val volCheck = "Перевірити"
    override val volCheckOk = "✓ Готово — доступ надано, тригер працює."
    override val volCheckFail = "✗ Доступу поки немає — виконайте кроки вище."
    override val volPatternsList = "↑↑↓↓ · ↓↓↑↑ · ↑↓↑↓ · ↓↑↓↑ · ↑↑↑↑ · ↓↓↓↓ · ↑↓↓↑ · ↓↑↑↓ · ↑↑↑↓↓↓ · ↓↓↓↑↑↑   (↑ = гучність вгору, ↓ = вниз)"
    override val histLegend = "Колонки — Хто: ✓/✗ TG = справжнє підключення Telegram, скан = фонова перевірка. Коли: скільки часу тому. TCP/TLS/Запит: затримки рукостискання та першого запиту, мс. Сесія: скільки тривала сесія релею. ↓/↑: прийнято / надіслано байтів через хост."
    override val tgOkTotalHint = "Підключень Telegram / успішних / усього перевірок"
    override val breadthTitle = "Широта вибору хостів"
    override val breadthHelp = "Ліворуч — триматися найкращих перевірених хостів; праворуч — максимально широко пробувати різні живі. Коли Telegram метається по портах релею, програма розширює вибір автоматично."
    override val breadthNarrow = "перевірені"
    override val breadthWide = "ширше"
    override val connTimeoutTitle = "Таймаут підключення до хоста"
    override val connTimeoutHelp = "Скільки чекати один аплінк (TCP + TLS + перша відповідь MTProto), перш ніж пробувати наступний проксі."
    override val factoryResetDone = "Усе скинуто. Закрийте застосунок і запустіть заново."
}
