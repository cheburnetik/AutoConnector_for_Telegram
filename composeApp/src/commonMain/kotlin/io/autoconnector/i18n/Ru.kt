package io.autoconnector.i18n

object Ru : Strings {
    override val tabConnector = "Коннектор"; override val tabScan = "Скан"
    override val tabCatalog = "Каталог"; override val tabLogs = "Логи"; override val tabMore = "Ещё"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "Подписки"; override val logTabScan = "Скан"
    override val logGeneral = "Общее"; override val logEmpty = "пока пусто"
    override fun logSession(id: String, port: String) = "Сессия $id · порт $port"
    override val back = "Назад"; override val copy = "Копировать"; override val gotIt = "Понятно"
    override val later = "Позже"; override val details = "Подробнее"; override val whatIsThis = "Что это?"
    override val delete = "Удалить"

    override val connector = "Коннектор"; override val scan = "Скан"
    override val notConfigured = "Не настроено! Исправить →"; override val howToSetup = "Как настроить"
    override val notifOff = "Уведомления выключены! Исправить →"; override val enable = "Включить"
    override fun fewProxies(n: Int) = "Мало живых проксей: $n! Ищу… Ждите ~15 минут"
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
    override fun tgToConnector(n: Int) = "TG→ $n"
    override fun connectorToProxy(n: Int) = "прокси $n"
    override val trafficSec = "трафик · 60 секунд"; override val trafficMin = "трафик · 60 минут"
    override val latencySec = "латенси · 60 секунд"; override val latencyMin = "латенси · 60 минут"
    override val sec60 = "60 секунд"; override val min60 = "60 минут"
    override val unitSec = "сек"; override val unitMin = "мин"; override val unitHour = "ч"; override val dash = "—"
    override val currentProxy = "Текущий прокси"; override val noActiveProxy = "нет активного прокси (Telegram не подключён)"
    override val host = "Хост"; override val type = "Тип"; override val secret = "Секрет"; override val antiDpi = "Анти-DPI"
    override fun activeSockets(n: Int) = "Активные сокеты Telegram: $n"
    override val noConnections = "нет активных соединений"; override val colHost = "Хост"; override val colTime = "Время"

    override val scanOff = "Сканирование выключено"; override val proxiesInBase = "Прокси в базе"
    override val total = "всего"; override val alive = "живых"; override val dead = "мёртвых"
    override val tgConnectedTitle = "Telegram подключался"; override val successful = "успешно"
    override val socketsHeld = "Сколько держались сокеты"; override val over1m = ">1 мин"; override val over5m = ">5 мин"; override val over15m = ">15 мин"
    override val scanCountTitle = "Кол-во сканов прокси"; override val checked = "Проверено"
    override val forAllTime = "за всё время"; override val perMinute = "за минуту"; override val perHour = "за час"
    override val subsCountTitle = "Кол-во загрузок подписок"; override val downloaded = "скачано"; override val failed = "неудачно"; override val scanTraffic = "трафик скана"
    override val checksMtproto = "Проверки MTProto (↑ ok · ↓ fail)"

    override val catalogEmpty = "Каталог пуст — идёт первичный сбор прокси…"
    override val aliveShort = "✓ жив"; override val deadShort = "✗ мёртв"
    override val statusLabel = "Статус"; override val rating = "Рейтинг"; override val port = "Порт"
    override val rttPing = "RTT (пинг)"; override val checkedField = "Проверен"; override val okOfTotal = "Успешно / всего проверок"
    override val tgConnectedField = "Telegram подключался"; override val tgSessions = "Сессий Telegram"; override val trafficThroughProxy = "Трафик через прокси"
    override val sessionsTotal = "Суммарно сессий"; override val relayNow = "Релей сейчас"; override val tlsDomain = "TLS-домен (SNI)"
    override val sourceSub = "Источник (подписка)"; override val lastError = "Последняя ошибка"; override val yes = "да"; override val no = "нет"
    override val copyAsLink = "Скопировать как ссылку"; override val openInTelegram = "Открыть хост в Telegram"; override val makeNextRelay = "Сделать следующим релеем"
    override fun agoFmt(v: String) = "$v назад"
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
    override val whatNextBody = "Убедитесь, что все другие старые прокси удалены, кроме {A} и {B}. " +
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
    override val viaMtproto = "Проксировать через MTProto"; override val viaMtprotoSub = "даже при VPN трафик идёт через прокси"
    override val directly = "Проксировать напрямую"; override val directlySub = "при активном VPN — в обход прокси, прямо к Telegram"
    override val notifications = "Уведомления"
    override val scanCheck = "Скан и проверка"
    override val scanCheckHelp = "• Скан, мин — как часто скачивать списки прокси из подписок.\n" +
        "• Проверка, мин — как часто перепроверять прокси из базы на живость.\n• Размер пачки — " +
        "сколько прокси проверять за один прогон.\n• Параллельно — сколько проверок выполнять " +
        "одновременно (больше = быстрее, но выше нагрузка на сеть и батарею)."
    override val scanMin = "Скан, мин"; override val checkMin = "Проверка, мин"; override val batchSize = "Размер пачки"; override val parallel = "Параллельно"
    override val speedByNet = "Скорость по сети"
    override val speedByNetHelp = "Множители скорости проверок в зависимости от текущей сети. 1.0 = " +
        "базовая скорость. Меньше — бережнее к трафику/батарее, больше — агрессивнее.\n• VPN — когда " +
        "активен внешний VPN.\n• Wi-Fi — в Wi-Fi сети.\n• LTE — в мобильной сети."
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
    override val netBattery = "Сеть и батарея"
    override val netBatteryHelp = "• Только по Wi-Fi — не сканировать в мобильной сети (экономия трафика).\n" +
        "• Только при зарядке — работать, лишь когда телефон на зарядке.\n• Пропускать при низком " +
        "заряде — приостанавливать скан при низком заряде батареи."
    override val onlyWifi = "Только по Wi-Fi"; override val onlyCharging = "Только при зарядке"; override val skipLowBattery = "Пропускать при низком заряде"
    override val autosaved = "Настройки сохраняются автоматически."
    override val dpiAutoLabel = "Авто-перебор DPI-трюков"; override val dpiNoneLabel = "Без DPI-трюков (обычный)"

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

    override val appTagline = "Кросс-платформенный авто-коннектор: сам находит, проверяет и поднимает " +
        "MTProto-прокси, через которые работает Telegram."
    override val version = "Версия"; override val buildDate = "Дата сборки"
    override val downloadSources = "Скачать и исходники"; override val openOnGithub = "Открыть на GitHub"
    override val feedbackBugs = "Обратная связь и баг-репорты"; override val writeTelegram = "Написать в Telegram"

    override val language = "Язык"; override val langAuto = "Авто (как в системе)"; override val langRu = "Русский"; override val langEn = "English"
}
