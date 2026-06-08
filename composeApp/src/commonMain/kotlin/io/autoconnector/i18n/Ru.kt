package io.autoconnector.i18n

object Ru : Strings {
    override val tabConnector = "Коннектор"; override val tabScan = "Скан"
    override val tabCatalog = "Каталог"; override val tabLogs = "Логи"; override val tabMore = "Ещё"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "Подписки"; override val logTabScan = "Скан"
    override val logGeneral = "Общее"; override val logEmpty = "пока пусто"
    override val logSessions = "Сессии"; override val logErrorsOnly = "только с ошибками"; override val logNoErrors = "сессий с ошибками нет"
    override fun logSession(id: String, port: String) = "№$id · :$port"
    override val back = "Назад"; override val copy = "Копировать"; override val gotIt = "Понятно"
    override val later = "Позже"; override val details = "Подробнее"; override val whatIsThis = "Что это?"
    override val delete = "Удалить"

    override val connector = "Коннектор"; override val scan = "Скан"
    override val notConfigured = "Не настроено! Исправить →"; override val howToSetup = "Как настроить"
    override val notifOff = "Уведомления выключены! Исправить →"; override val enable = "Включить"
    override fun fewProxies(n: Int) = "Живых проксей $n, ищу, ждите ~15 мин…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "Живых прокси: $alive  (15 мин: $within) · всего: $total"
    override val notifWhyTitle = "Зачем уведомления?"
    override val notifWhyBody = "Уведомление с постоянным значком — это foreground-сервис Android. " +
        "Без него система выгрузит приложение из памяти, и оно перестанет искать прокси и держать " +
        "соединение в фоне. Поэтому уведомления обязательны для работы AutoConnector."
    override val notifEnableTitle = "Включите уведомления"
    override val notifEnableBody = "Без уведомления-значка Android считает приложение неактивным и " +
        "выгружает его из памяти. Тогда AutoConnector перестаёт искать прокси и держать соединение " +
        "в фоне — Telegram теряет связь.\n\nНажмите «Включить» и разрешите уведомления для AutoConnector."
    override val notifPlea = "Включите уведомления! Без них приложение не сможет работать в фоновом " +
        "режиме — Android выгрузит его, поиск прокси и соединение остановятся."

    override val statusConnected = "Telegram подключён"; override val statusConnecting = "Идёт коннект…"
    override val statusOffline = "Telegram не подключён"; override val statusIdle = "Telegram молчит"
    override val nobodyConnected = "Никто не подключился к Коннектору. "; override val howToSetupArrow = "Как настроить →"
    override val directModeViaVpn = "Прямой режим: VPN активен — без прокси"
    override val directModeOff = "Прямой режим: прокси отключены"
    override val directDpiSuffix = " · анти-DPI"
    override val connections = "Подключений"; override val sockets = "Сокеты"; override val speed = "Скорость"
    override val traffic = "Трафик"; override val latency = "Латенси"
    override fun pcs(n: Int) = "$n шт"
    override fun netNow(label: String) = "Сеть: $label"
    override fun tgToConnector(n: Int) = "TG→ $n"
    override fun connectorToProxy(n: Int) = "прокси $n"
    override val trafficSec = "трафик · 60 секунд"; override val trafficMin = "трафик · 60 минут"
    override val latencySec = "латенси · 60 секунд"; override val latencyMin = "латенси · 60 минут"
    override val sec60 = "60 секунд"; override val min60 = "60 минут"
    override val unitSec = "сек"; override val unitMin = "мин"; override val unitHour = "ч"; override val dash = "—"
    override val currentProxy = "Текущий прокси"; override val noActiveProxy = "нет активного прокси (Telegram не подключён)"
    override val host = "Хост"; override val type = "Тип"; override val secret = "Секрет"; override val antiDpi = "Анти-DPI"; override val obfEngine = "Движок обфускации"
    override fun activeSockets(n: Int) = "Активные сокеты Telegram: $n"
    override val noConnections = "нет активных соединений"; override val colHost = "Хост"; override val colTime = "Время"
    override val modeWord = "Режим"; override val directViaVpnLine = "Прямые запросы к Telegram из-за VPN"
    override val connModeHelp = "Режимы (VPN, Wi-Fi, LTE, Ethernet, White) позволяют по-разному настроить интенсивность сканирования и ведут отдельные рейтинги/статистику хостов. Сетевая плата определяется автоматически; режим может быть задан вручную в настройках."

    override val scanOff = "Сканирование выключено"; override val proxiesInBase = "Прокси в базе"
    override val total = "всего"; override val alive = "живых"; override val dead = "мёртвых"
    override val tgConnectedTitle = "Telegram подключался"; override val successful = "успешно"
    override val socketsHeld = "Сколько держались сокеты"; override val over1m = ">1 мин"; override val over5m = ">5 мин"; override val over15m = ">15 мин"
    override val scanCountTitle = "Кол-во сканов прокси"; override val checked = "Проверено"
    override val forAllTime = "за всё время"; override val perMinute = "за минуту"; override val perHour = "за час"
    override val subsCountTitle = "Кол-во загрузок подписок"; override val downloaded = "скачано"; override val failed = "неудачно"; override val scanTraffic = "трафик скана"; override val subTraffic = "трафик подписок"; override val subTrafficGraph = "Трафик подписок"
    override val checksMtproto = "Проверки MTProto (↑ ok · ↓ fail)"

    override fun catalogEmpty(mode: String) = "Каталог $mode пока пуст. Либо не нашли ни одного хоста, либо программа никогда не работала в этом режиме. Переключить режим можно из настроек. Режимы придуманы, чтобы вести раздельный сбор хостов для разных видов подключения к интернету."
    override val aliveShort = "✓ жив"; override val deadShort = "✗ мёртв"
    override val statusLabel = "Статус"; override val rating = "Рейтинг"; override val port = "Порт"
    override val rttPing = "RTT (пинг)"; override val checkedField = "Проверен"; override val okOfTotal = "Успешно / всего проверок"
    override val tgConnectedField = "Telegram подключался"; override val tgSessions = "Сессий Telegram"; override val trafficThroughProxy = "Трафик через прокси"
    override val sessionsTotal = "Суммарно сессий"; override val relayNow = "Релей сейчас"; override val tlsDomain = "TLS-домен (SNI)"
    override val sourceSub = "Источник (подписка)"; override val lastError = "Последняя ошибка"; override val yes = "да"; override val no = "нет"
    override val copyAsLink = "Скопировать как ссылку"; override val openInTelegram = "Открыть хост в Telegram"; override val makeNextRelay = "Сделать следующим релеем"
    override val actCopy = "Копировать"; override val actOpen = "Открыть"; override val actRelay = "В реле"
    override fun agoFmt(v: String) = "$v назад"
    override val catalogTopFor = "Список/рейтинг проксей для"
    override val catalogModeHelpTitle = "Режимы и рейтинги"
    override val catalogModeHelp = "Программа считает живых хостов и их рейтинг РАЗДЕЛЬНО по каждому режиму сети (VPN, Wi-Fi, LTE, Ethernet и White). «White» — отдельный РУЧНОЙ режим для белых списков; авто на него никогда не переключается. Поэтому один и тот же хост может быть живым в одном режиме и мёртвым в другом."
    override fun catalogInactiveWarn(section: String, active: String) =
        "Сейчас вы смотрите неактивный раздел $section — вся статистика прямо сейчас собирается не сюда, а в $active."
    override val manageModeTitle = "Управление режимом"
    override val manageResetRating = "Обнулить рейтинг"
    override fun manageResetHint(mode: String) = "Индивидуально для $mode можете обнулить рейтинг и статистику использования живых хостов. Это полезно, когда вы подключились к принципиально другому VPN или LTE, чтобы не влияла старая статистика. Либо для наблюдения, как быстро скан проксей проверит всё с нуля."
    override val manageDeleteAll = "Удалить хосты в"
    override fun manageDeleteHint(mode: String) = "Можно очистить и рейтинг, и сами хосты из $mode. Функция «Скан проксей» соберёт их заново. Это не обнуление подписок — можно нажимать, после чего ожидайте ~15 минут на повторный скан."
    override fun manageCopyFrom(mode: String) = "Скопировать все хосты и рейтинги в этот режим ($mode) из другого режима:"
    override val live = "жив"; override val deadW = "мёртв"; override val unitMs = "мс"
    override val agoMin = "м"; override val agoHour = "ч"; override val agoDay = "д"

    override val connectTelegram = "Подключение Telegram"; override val readCarefully = "Прочитайте внимательно!"
    override val guideIntro = "Без настройки это приложение не будет работать. Выберите любой " +
        "один из 3-х вариантов ниже и аккуратно выполните инструкцию."
    override val variant1 = "Вариант №1 — кнопками"
    override val variant1Body = "Нажмите кнопку «Прокси {A}» — откроется Telegram, согласитесь с " +
        "добавлением прокси. Вернитесь в это окно и нажмите «Прокси {B}» — второй раз согласитесь " +
        "с добавлением.\n\nОтключите в Telegram все иные старые прокси, если были. Должно остаться " +
        "ровно 2 прокси — с портами {A} и {B}. При любом другом наборе AutoConnector работать не будет."
    override val variant2 = "Вариант №2 — ссылками"
    override val variant2Body = "Скопируйте текст ниже в «Избранное» (или любой чат) в Telegram — " +
        "т.е. отправьте его сами себе. Нажмите первую ссылку в своём сообщении — добавится первый " +
        "прокси. Нажмите вторую ссылку — добавится второй. Затем отключите все старые прокси."
    override val variant3 = "Вариант №3 — вручную"
    override val variant3Body = "Вручную добавьте прокси типа SOCKS5: сервер localhost (127.0.0.1), " +
        "порт {A}. Затем второй прокси: localhost, порт {B}. Любые старые прокси удалите."
    override val whatNext = "А дальше что?"
    override val whatNextBody = "В Telegram включите «автопереключение прокси» — 5 секунд. Вы можете " +
        "помочь Telegram подключиться, если будете вручную кликать тот прокси (внутри Telegram), " +
        "который НЕ активен или помечен «недоступен» — так Telegram сделает больше попыток " +
        "подключиться.\n\nУбедитесь, что все другие старые прокси удалены, кроме {A} и {B}. " +
        "Нажмите в Telegram «Использовать прокси».\n\nПодождите, пока приложение найдёт и скачает " +
        "достаточно прокси (5–15 минут). Затем Telegram сам подключится к AutoConnector, который " +
        "будет каждый раз подключать Telegram к наиболее выгодным прокси: проверенным, живым и " +
        "быстрым.\n\nЕсли инструкция кажется сложной — увы, пользоваться приложением не получится: " +
        "автоматически всё настроить невозможно, а поиск живых прокси занимает время.\n\nЕсли вы " +
        "давно скачивали приложение и живых прокси не нашлось — обновите либо приложение, либо " +
        "список подписок. Прокси это приложение не сочиняет и не предоставляет свои, а лишь ищет " +
        "по интернету среди десятков групп и страниц."
    override fun proxyBtn(port: Int) = "Прокси $port"

    override val setupPortsTitle = "Настройка портов в Telegram"
    override val setupPortsSub = "Как подключить Telegram к Коннектору (порты 55001/55002)"
    override val settings = "Настройки"; override val settingsSub = "Порты, анти-DPI, скан, сеть, батарея"
    override val subscriptions = "Подписки"; override val subscriptionsSub = "Источники прокси для скана"
    override val statistics = "Статистика"; override val statisticsSub = "База прокси + анти-DPI хитрости"
    override val export = "Экспорт"; override val exportSub = "tg:// ссылки живых прокси"
    override val about = "О программе"; override val aboutSub = "Версия, сборка, скачать, обратная связь"
    override val hotkeys = "Горячие клавиши"
    override val hotkeysSub = "Глобальные клавиши: копировать / открыть прокси"
    override val hotkeysIntro = "Глобальные горячие клавиши срабатывают, даже когда окно приложения " +
        "не в фокусе. Они берут случайную живую прокси-ссылку (tg://) из базы. Удобно быстро менять " +
        "прокси, не открывая приложение."
    override val hotkeysNote = "На macOS для перехвата клавиш может потребоваться разрешение " +
        "«Универсальный доступ» (Системные настройки → Конфиденциальность и безопасность → Универсальный доступ)."
    override val hotkeyCopyTitle = "Скопировать ссылку прокси"
    override val hotkeyCopyDesc = "Кладёт случайную живую tg://-ссылку в буфер обмена."
    override val hotkeyEnable = "Включить хоткеи"; override val hotkeyLetterLabel = "Буква"; override val hotkeySet = "Задать"; override val hotkeyReset = "Сброс"
    override val hotkeyOpenTitle = "Открыть прокси в Telegram"
    override val hotkeyOpenDesc = "Открывает случайную живую ссылку — Telegram перехватит её и предложит подключить прокси."

    override val relayPorts = "Порты релея"
    override val relayPortsHelp = "Локальные порты, которые слушает Коннектор. Именно их вы указываете " +
        "в Telegram как SOCKS5-прокси (127.0.0.1 : порт). Два порта нужны для надёжности — Telegram " +
        "держит соединения к обоим."
    override val portA = "Порт A"; override val portB = "Порт B"
    override val antiDpiTrick = "Анти-DPI хитрость"
    override val antiDpiHelp = "Способ маскировки соединения, чтобы провайдер/DPI не распознал и не " +
        "заблокировал его.\n• «Авто-перебор» сам подбирает рабочий трюк.\n• «Без DPI-трюков» — обычное " +
        "соединение.\n• Остальные — конкретные приёмы (имитация браузеров, дробление пакетов и т.п.)."
    override val onlyFakeTls = "Только FakeTLS (ee)"
    override val applyDpiTo = "Применять анти-DPI к"
    override val applyDpiHelp = "К чему применять выбранный анти-DPI трюк:\n• Релею Telegram — к живому " +
        "соединению Telegram через Коннектор.\n• Пробам прокси — к фоновым проверкам прокси (тогда " +
        "проверка ведёт себя так же, как реальное подключение, и статистика хитростей точнее).\n" +
        "• При проксировании напрямую — когда прокси отключены (или пропускаются при VPN) и Telegram " +
        "идёт прямо к серверам: прокси тут нет, поэтому трюк сводится к дроблению первого TCP-пакета " +
        "(рукопожатия) на несколько мелких сегментов, чтобы DPI не распознал его в одном куске."
    override val toRelay = "Релею Telegram"; override val toProbes = "Пробам прокси"
    override val toDirect = "При проксировании напрямую"
    override val vpnSection = "При включённом VPN"
    override val vpnHelp = "Что делать, когда на устройстве активен VPN:\n• Через MTProto-прокси — " +
        "Telegram, как обычно, идёт через найденные прокси (поверх VPN).\n• Напрямую — Коннектор НЕ " +
        "использует прокси и соединяет Telegram напрямую с серверами Telegram: VPN уже даёт доступ, " +
        "лишний прокси-слой не нужен (быстрее и стабильнее). Без VPN прокси используются как обычно."
    override val linkFormat = "Формат ссылок прокси"
    override val linkFormatHelp = "Как копировать и открывать прокси. tg:// открывается сразу в Telegram (нужен установленный Telegram Desktop). http (t.me) открывается через браузер и предлагает открыть в Telegram — полезно, если tg:// не открывается."
    override val linkTg = "tg:// (в Telegram напрямую)"; override val linkTgSub = "tg://proxy?… — открывает Telegram"
    override val linkHttp = "http (t.me, через браузер)"; override val linkHttpSub = "https://t.me/proxy?… — открывает браузер"
    override val viaMtproto = "Проксировать через MTProto"; override val viaMtprotoSub = "даже при VPN трафик идёт через прокси"
    override val directly = "Проксировать напрямую"; override val directlySub = "при активном VPN — в обход прокси, прямо к Telegram"
    override val notifications = "Уведомления"
    override val scanCheck = "Скан и проверка"
    override val scanCheckHelp = "• Скан, мин — как часто скачивать списки прокси из подписок.\n" +
        "• Проверка, мин — как часто перепроверять прокси из базы на живость.\n• Размер пачки — " +
        "сколько прокси проверять за один прогон.\n• Параллельно — сколько проверок выполнять " +
        "одновременно (больше = быстрее, но выше нагрузка на сеть и батарею)."
    override val scanMin = "Скан, мин"; override val checkMin = "Проверка, мин"; override val batchSize = "Размер пачки"; override val parallel = "Параллельно"
    override val speedByNet = "Интенсивность скана по сети"
    override val speedByNetHelp = "Как часто проверять прокси в зависимости от текущей сети. " +
        "«Стандарт» = базовый интервал. Сдвиг вправо — реже (медленнее, бережнее к трафику/" +
        "батарее), влево — чаще (быстрее, агрессивнее). Шкала логарифмическая, до ×100 в каждую " +
        "сторону.\n• VPN — когда активен внешний VPN.\n• Wi-Fi — в Wi-Fi сети.\n• LTE — в мобильной сети."
    override val intensStandard = "стандарт"
    override val intensSlower = "медленнее"
    override val intensFaster = "быстрее"
    override val maintenance = "Сброс данных"
    override val maintenanceHelp = "• «Сбросить каталог и статистику» — обнуляет оценки, счётчики, " +
        "трафик и логи проверок, но сохраняет сами скачанные хосты и подписки (всё переоценится " +
        "при следующем скане).\n• «Очистить скачанные хосты» — удаляет весь пул прокси, но " +
        "оставляет подписки, чтобы скан набрал пул заново. Подписки не трогаются ни в одном случае."
    override val backupTitle = "Экспорт / Импорт"
    override val backupHelp = "Сохранить или восстановить данные приложения одним JSON-файлом. " +
        "Отметь, что включить — любую комбинацию:\n• Настройки — все параметры приложения.\n" +
        "• Подписки — список источников (URL + вкл/выкл).\n• Каталог живых хостов — все живые " +
        "прокси с их оценками и статистикой ПО РЕЖИМАМ сети.\n\n«Экспорт» спросит, куда сохранить " +
        "файл; «Импорт» — какой файл открыть, и применит только отмеченные разделы, что есть в файле. " +
        "Импорт ДОБАВЛЯЕТ к текущим данным (не стирает)."
    override val backupSettings = "Настройки"
    override val backupSubs = "Подписки"
    override val backupHosts = "Каталог живых хостов (по режимам)"
    override val exportWord = "Экспорт"
    override val importWord = "Импорт"
    override val eraseAllHosts = "Стереть все хосты"
    override val factoryReset = "Сбросить всё (как при первом запуске)"
    override val factoryResetConfirm = "Полностью сбросить приложение к заводскому виду? Будут стёрты " +
        "ВСЕ настройки и весь каталог хостов, подписки вернутся к стандартным. Это как первый запуск."
    override val resetCatalog = "Сбросить каталог и статистику"
    override val resetCatalogConfirm = "Обнулить оценки, счётчики и логи проверок? " +
        "Скачанные хосты и подписки сохранятся, всё переоценится при следующем скане."
    override val clearHosts = "Очистить скачанные хосты"
    override val clearHostsConfirm = "Удалить весь список скачанных хостов (прокси)? " +
        "Подписки сохранятся, и скан наберёт пул заново."
    override val doReset = "Сбросить"
    override val doCancel = "Отмена"
    override val adaptiveSpeed = "Адаптивная скорость"
    override val adaptiveHelp = "Проверки живости идут с базовым интервалом (из раздела «Скан и " +
        "проверка», ещё умноженным на множитель сети). «Адаптивная скорость» сама ускоряет или " +
        "замедляет их в зависимости от того, сколько прокси сейчас живых.\n\n" +
        "• Живых МАЛО (меньше «Порога мало») → интервал × «Ускорение». Множитель меньше 1 = чаще: " +
        "0.5 — вдвое чаще, 0.25 — вчетверо. Пул быстрее наполняется.\n" +
        "• Живых МНОГО (больше «Порога много») → интервал × «Замедление». Множитель больше 1 = реже: " +
        "2 — вдвое реже, 4 — вчетверо. Бережёт батарею и трафик.\n" +
        "• Между порогами — базовая скорость (×1).\n\n" +
        "Примеры:\n" +
        "— Быстрее набрать прокси: «Ускорение» 0.25 и/или «Порог мало» 40.\n" +
        "— Экономить батарею при достатке: «Замедление» 8 и/или «Порог много» 30.\n" +
        "— Отключить адаптацию: оба множителя = 1.\n\n" +
        "По умолчанию: Порог мало 20, Ускорение 0.5, Порог много 50, Замедление 4."
    override val threshMany = "Порог «мало»"; override val threshFew = "Порог «много»"; override val mulFast = "Ускорение ×"; override val mulLazy = "Замедление ×"
    override val subIntensityTitle = "Интенсивность подписок"
    override val subIntensityHint = "Пауза между скачиваниями подписок: раз в сколько минут заново скачивать списки прокси (отдельно для каждого режима сети)."
    override val baseScanTitle = "Базовая скорость скана"
    override val baseScanHelp = "Опорная скорость проверки прокси на живость. От неё считаются " +
        "«Адаптивная скорость» и множители в «Скорость по режимам».\n\n" +
        "• Раз в сколько мин. запускать — период между проходами проверки.\n" +
        "• Пачка на поток, шт хостов — сколько хостов проверяет каждый поток за один проход.\n" +
        "• Кол-во потоков — сколько проверок идёт одновременно. За проход проверяется " +
        "«пачка × потоки» хостов.\n" +
        "• Не сканировать хост чаще, чем раз в N мин — защита от флуда: недавно проверенный хост " +
        "в проход не попадёт.\n\n" +
        "Больше потоков и пачка = быстрее набор пула, но выше нагрузка на сеть и батарею."
    override val baseScanPeriod = "Раз в сколько мин. запускать"
    override val baseScanBatch = "Пачка на поток, шт хостов"; override val baseScanThreads = "Кол-во потоков"
    override val adaptiveDesc = "Если живых проксей меньше «мало» или больше «много» — включить свой дополнительный коэффициент."
    override val fewWord = "Мало"; override val manyWord = "Много"
    override fun fasterX(x: String) = "быстрее в $x раз"
    override fun slowerX(x: String) = "медленнее в $x раз"
    override fun ifAliveLt(n: Int) = "Если живых проксей < $n шт, то:"
    override fun ifAliveGt(n: Int) = "Если живых проксей > $n шт, то:"
    override val disabledWord = "отключено"
    override val speedByModeTitle = "Скорость по режимам"
    override val speedByModeHelp = "Множитель скорости скана для каждого режима сети, поверх " +
        "базовой скорости. «Стандарт» (×1) = базовый интервал. Вправо — реже (медленнее, бережнее " +
        "к трафику/батарее), влево — чаще (быстрее, агрессивнее). Шкала логарифмическая, до ×100 в " +
        "каждую сторону.\n\n" +
        "Под каждым ползунком — итоговые параметры прохода с учётом адаптивной скорости: отдельно " +
        "для случая «живых мало» (× «Ускорение») и «живых много» (× «Замедление»).\n\n" +
        "Режимы:\n• VPN — активен внешний VPN.\n• LTE — мобильная сеть.\n• Wi-Fi — сеть Wi-Fi.\n" +
        "• Ethernet — проводное подключение.\n• White — ручной режим «белых» прокси."
    override val aliveLt = "живых <"; override val aliveGt = "живых >"
    override val periodWord = "период"; override val nonstopWord = "постоянно"
    override val batchWord = "пачка"; override val threadsWord = "потоков"; override val scanModeOff = "скан выключен"
    override val netBattery = "Сеть и батарея"
    override val netBatteryHelp = "• Только по Wi-Fi — не сканировать в мобильной сети (экономия трафика).\n" +
        "• Только при зарядке — работать, лишь когда телефон на зарядке.\n• Пропускать при низком " +
        "заряде — приостанавливать скан при низком заряде батареи."
    override val onlyWifi = "Только по Wi-Fi"; override val onlyCharging = "Только при зарядке"; override val skipLowBattery = "Пропускать при низком заряде"
    override val autosaved = "Настройки сохраняются автоматически."
    override val dpiAutoLabel = "Авто-перебор DPI-трюков"; override val dpiNoneLabel = "Без DPI-трюков (обычный)"
    override val experimental = "Экспериментально"
    override val experimentalHelp = "Альтернативные движки проксирования к MTProto-прокси и диагностический лог. " +
        "Эталонный (рабочий) путь при «Выключено» не меняется. Меняется только то, КАК зашифрованный поток " +
        "пишется в TCP-сокет апстрима (размер сегментов, тайминг, границы TLS-records) — сам поток байт-в-байт тот же. " +
        "Применяется к живому релею через прокси (не к пробам и не к прямому выходу)."
    override val expEngineTitle = "Движок проксирования (обфускация сокетов)"
    override val expConnectTitle = "Движок коннекта (поиск апстрима)"
    override val expEngineWarn = "⚠ Экспериментальный режим. Если связь стала хуже — верните «Выключено (эталонный путь)»."
    override val netLog = "Включить лог сетевого обмена"
    override val netLogSub = "Пишет в файл КТО-КОМУ-КОГДА и размеры пакетов (БЕЗ содержимого данных) — " +
        "чтобы сравнить характер обмена с VPN и без него."
    override val openLogFolder = "Открыть папку лога"; override val copyPath = "Скопировать путь"
    override val quickSwitchTitle = "Обход блокировок"; override val quickSwitchSub = "Дробление, коннект, анти-DPI"
    override val helpShow = "Справка"; override val helpHide = "Скрыть справку"
    override val quickSwitchIntro = "Здесь вы можете подобрать трюки обхода блокировок. Если телеграм " +
        "выдаёт ошибку «The proxy you are using is not configured correctly and will be disabled. " +
        "Please find another one», подбирайте экспериментально, какой из видов обфускации трафика " +
        "сработает и Телеграм бы не выдавал эту ошибку. Начните со сплит* режимов. Ещё работают " +
        "коалесинг*, но при этом в телеграме плохо грузятся картинки/видео."

    override val sourceUrl = "URL источника"
    override fun sourceAlive(alive: Int, total: Int) = "живых $alive/$total"
    override val open = "Открыть"; override val active = "Активна"; override val inactive = "Не активна"
    override val lastDownloaded = "Скачано"; override val notDownloaded = "ещё не скачивалась"
    override fun sourceCounts(dead: Int, total: Int) =
        " живых, $dead мёртвых, $total всего"

    override val proxyBase = "База прокси"
    override val totalInBase = "Всего в базе"; override val aliveNow = "Живых сейчас"; override val deadStat = "Мёртвых"
    override val aliveIn15 = "Живых за 15 мин"; override val checksAllTime = "Проверок за всё время"
    override val antiDpiTricks = "Анти-DPI хитрости"; override val noStatsYet = "ещё нет данных — хитрости накапливаются по мере проверок/подключений"
    override val attempts = "Попыток"; override val handshake = "Handshake"; override val score = "Балл"
    override val tgConnect = "TG-коннект"; override val socketsOver1m = "Сокеты >1мин"
    override val over10kb = "Сокеты >10КБ"; override val over100kb = ">100КБ"; override val workTime = "Время работы"
    override val statsLegend = "Handshake — успешных рукопожатий (% от попыток) · Балл — выгодность · " +
        "«Время работы» — суммарно по сокетам ≥5КБ и дольше 1 минуты."
    override val resetStats = "Сбросить статистику хитростей"

    override fun aliveLinks(n: Int) = "Живых ссылок: $n"
    override val copyAll = "Скопировать все"
    override val openRandom = "Открыть случайный"; override val copyRandom = "Копировать случайный"; override val allShort = "ВСЕ"
    override val copyTop = "Копировать TOP"; override val randomHost = "Случайный хост"
    override val exportToFile = "Экспорт в файл"; override val exportSaved = "Сохранено в файл:"
    override val dlNow = "Скачать сейчас"
    override fun downloadingFmt(sec: Long) = "Загружаю… $sec с"
    override val cancel = "Отмена"
    override val deleteConfirmTitle = "Удалить подписку?"
    override val subscriptionsAddHint = "Добавить подписки или прокси-ссылки →"
    override val addSourcesTitle = "Добавить"
    override val addSubsLabel = "Подписки (URL, по одной в строке)"
    override val addSubsHelp = "Каждая строка с корректным URL станет отдельной подпиской и будет скачиваться периодически."
    override val addProxiesLabel = "Готовые прокси-ссылки (фикс-список)"
    override val addProxiesHelp = "Вставь пачку ссылок на конкретные прокси (tg://proxy, https://t.me/proxy, …). Это НЕ подписка — список не скачивается, прокси просто добавляются в каталог."
    override val addButton = "Добавить"
    override fun addedFmt(subs: Int, proxies: Int) = "Добавлено: подписок $subs, прокси $proxies"
    override val perSecond = "за сек"
    override val graphSpeed = "Скорость"
    override val graphVolume = "Объём"
    override val graphLatency = "Ping"
    override val graphConnects = "Коннекты"
    override val scanNow = "Сканировать сейчас"; override val scanOnShort = "Скан включён"
    override val scanRunning = "Скан идёт"; override val scanIdle = "Скан idle"; override val scanOffState = "Скан OFF"; override val scanBatchPerThread = "Пачка/поток"; override val scanPassHosts = "Хостов в проходе"; override val minRescanLabel = "Не сканировать хост чаще, чем раз в N мин"
    override val scanPlanTitle = "План"; override val scanNowTitle = "Сейчас"; override val currentScheduleTitle = "Текущее расписание"
    override val scheduleWord = "Расписание"; override val unitPcsPerSec = "шт/с"
    override val scanNowThreadsLabel = "Сейчас запущено потоков"; override val scanNowPerThreadLabel = "Проверок на 1 поток (план)"; override val scanNowElapsedLabel = "Время работы"
    override val scanOkGraph = "Успешные сканы"; override val scanFailGraph = "Неуспешные сканы"; override val scanTrafficGraph = "Трафик скана"; override val scanAliveGraph = "Живых прокси всего"; override val scanPingGraph = "Пинг"; override val threadsGraph = "Потоки"
    override val scanEvery = "Период"; override val scanNextRun = "След. запуск"
    override val scanThreads = "Потоков"; override val scanBatch = "В пачке"
    override val scanElapsed = "Работает"; override val scanIdleNow = "—"
    override val effForFew = "При «мало»"; override val effForMany = "При «много»"
    override val effCheck = "Проверка"; override val effBatch = "Пачка"; override val effPar = "Параллельно"
    override val effContinuous = "непрерывно"; override val secShort = "с"; override val minShort = "мин"

    override val appTagline = "Кросс-платформенный авто-коннектор: сам находит, проверяет и поднимает " +
        "MTProto-прокси, через которые работает Telegram."
    override val version = "Версия"; override val buildDate = "Дата сборки"
    override val downloadSources = "Скачать и исходники"; override val openOnGithub = "Открыть на GitHub"
    override val feedbackBugs = "Обратная связь и баг-репорты"; override val writeTelegram = "Написать в Telegram"

    override val language = "Язык"; override val langAuto = "Авто (как в системе)"; override val langRu = "Русский"; override val langEn = "English"

    override val scanModeTitle = "Режим сети"; override val scanModeAuto = "Авто"; override val scanModeManualLabel = "Вручную"
    override val activeModeLabel = "Активный режим"; override val formingListLabel = "Формирую список"; override val catalogModeTabs = "Режим"
    override val resetModeRatings = "Обнулить рейтинг хостов"; override val forgetModeHosts = "Забыть хосты режима"
    override val exportModeTitle = "Экспорт по режимам"; override val modePickerTitle = "Режим"
    override val modeHelp = "В каждом режиме сети — отдельный рейтинг прокси и своя интенсивность сканирования и скачивания подписок. «Авто» определяет режим по активной сети. «Ручной» — вы задаёте режим сами (включая White, который авто никогда не выбирает)."
    override val autoSelect = "Авто выбор"; override val manualSelect = "Ручной выбор"
    override val connStatsTitle = "Соединения сейчас"; override val connOnPort = "Соединений на порту"; override val outgoingConns = "Исходящих соединений"
    override val modeChoice = "Выбор режима"; override val autoChoice = "авто выбор"; override val manualChoice = "ручной фиксированный"
    override val directOnVpn = "Прямой коннект к TG при VPN"; override val onWord = "вкл"; override val offWord = "выкл"
    override val directStateActive = "активно"; override val directStateOff = "выключено в настройках"; override val directStateIdle = "включено в настройках, но не активно"
    override val wpHintTitle = "Что такое White?"
    override val wpHint = "White — WhitePages: ручной режим сети. Включается только вручную (авто-выбор его не ставит). " +
        "Ведёт отдельный рейтинг хостов, качает подписки и сканирует независимо от VPN/Wi-Fi/LTE."
}
