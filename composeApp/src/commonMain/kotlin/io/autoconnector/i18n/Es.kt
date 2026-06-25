package io.autoconnector.i18n

object Es : Strings {
    override val tabConnector = "Conector"; override val tabScan = "Escaneo"
    override val tabCatalog = "Catálogo"; override val tabLogs = "Registros"; override val tabMore = "Más"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "Suscripciones"; override val logTabScan = "Escaneo"
    override val logGeneral = "General"; override val logEmpty = "vacío por ahora"
    override val logSessions = "Sesiones"; override val logErrorsOnly = "solo errores"; override val logNoErrors = "ninguna sesión fallida"
    override fun logSession(id: String, port: String) = "#${id} · :${port}"
    override val back = "Atrás"; override val copy = "Copiar"; override val gotIt = "Entendido"
    override val later = "Más tarde"; override val details = "Detalles"; override val whatIsThis = "¿Qué es esto?"
    override val delete = "Eliminar"

    override val connector = "Conector"; override val scan = "Escaneo"
    override val notConfigured = "¡Sin configurar! Arreglar →"; override val howToSetup = "Cómo configurar"
    override val notifOff = "¡Las notificaciones están desactivadas! Arreglar →"; override val enable = "Activar"
    override fun fewProxies(n: Int) = "Proxies activos ${n}, buscando, espera ~15 min…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "Proxies activos: ${alive}  (15 min: ${within}) · total: ${total}"
    override val notifWhyTitle = "¿Por qué notificaciones?"
    override val notifWhyBody = "Un icono de notificación permanente significa un servicio en primer plano de Android. " +
        "Sin él, el sistema descarga la app de la memoria y deja de buscar proxies y " +
        "de mantener la conexión en segundo plano. Por eso las notificaciones son necesarias para que " +
        "AutoConnector funcione."
    override val notifEnableTitle = "Activar notificaciones"
    override val notifEnableBody = "Sin un icono de notificación, Android trata la app como inactiva y " +
        "la descarga de la memoria. Entonces AutoConnector deja de buscar proxies y de mantener la " +
        "conexión en segundo plano: Telegram pierde su enlace.\n\nToca \"Activar\" y permite " +
        "las notificaciones de AutoConnector."
    override val notifPlea = "¡Activa las notificaciones! Sin ellas la app no puede funcionar en segundo plano: " +
        "Android la descargará y la búsqueda de proxies y la conexión se detendrán."

    override val statusConnected = "Telegram conectado"; override val statusConnecting = "Conectando…"
    override val statusOffline = "Telegram no conectado"; override val statusIdle = "Telegram en reposo"
    override val nobodyConnected = "Nadie se ha conectado al Conector. "; override val howToSetupArrow = "Cómo configurar →"
    override val directModeViaVpn = "Modo directo: VPN activa, sin proxy"
    override val directModeOff = "Modo directo: proxies desactivados"
    override val directDpiSuffix = " · anti-DPI"
    override val connections = "Conexiones"; override val sockets = "Sockets"; override val speed = "Velocidad"
    override val traffic = "Tráfico"; override val latency = "Latencia"
    override fun pcs(n: Int) = "${n} uds"
    override fun netNow(label: String) = "Red: ${label}"
    override fun tgToConnector(n: Int) = "TG→ ${n}"
    override fun connectorToProxy(n: Int) = "proxy ${n}"
    override val trafficSec = "tráfico · 60 s"; override val trafficMin = "tráfico · 60 min"
    override val latencySec = "latencia · 60 s"; override val latencyMin = "latencia · 60 min"
    override val sec60 = "60 s"; override val min60 = "60 min"
    override val unitSec = "s"; override val unitMin = "m"; override val unitHour = "h"; override val dash = "—"
    override val currentProxy = "Proxy actual"; override val noActiveProxy = "sin proxy activo (Telegram no conectado)"
    override val host = "Host"; override val type = "Tipo"; override val secret = "Secreto"; override val antiDpi = "Anti-DPI"; override val obfEngine = "Motor de ofuscación"
    override fun activeSockets(n: Int) = "Sockets activos de Telegram: ${n}"
    override val noConnections = "sin conexiones activas"; override val colHost = "Host"; override val colTime = "Tiempo"
    override val modeWord = "Modo"; override val directViaVpnLine = "Solicitudes directas a Telegram (VPN activa)"
    override val connModeHelp = "Los modos (VPN, Wi-Fi, LTE, Ethernet, White) te permiten ajustar la intensidad del escaneo de forma distinta y mantener valoraciones/estadísticas de hosts por separado. La tarjeta de red se detecta automáticamente; el modo puede fijarse manualmente en los ajustes."

    override val scanOff = "El escaneo está desactivado"; override val proxiesInBase = "Proxies en la base de datos"
    override val total = "total"; override val alive = "activos"; override val dead = "muertos"
    override val tgConnectedTitle = "Telegram conectado vía"; override val successful = "exitosas"
    override val socketsHeld = "Duración del socket"; override val over1m = ">1 min"; override val over5m = ">5 min"; override val over15m = ">15 min"
    override val scanCountTitle = "Número de comprobaciones de proxy"; override val checked = "Comprobados"
    override val forAllTime = "desde siempre"; override val perMinute = "por minuto"; override val perHour = "por hora"
    override val subsCountTitle = "Número de descargas de suscripción"; override val downloaded = "descargadas"; override val failed = "fallidas"; override val scanTraffic = "tráfico de escaneo"; override val subTraffic = "tráfico de suscripción"; override val subTrafficGraph = "Tráfico de suscripción"
    override val checksMtproto = "Comprobaciones MTProto (↑ ok · ↓ fallo)"

    override fun catalogEmpty(mode: String) = "El catálogo ${mode} está vacío por ahora. O no se encontró ningún host, o la app nunca ha funcionado en este modo. Puedes cambiar el modo en Ajustes. Los modos existen para recopilar hosts por separado según los distintos tipos de conexión a internet."
    override val aliveShort = "✓ activo"; override val deadShort = "✗ muerto"
    override val statusLabel = "Estado"; override val rating = "Valoración"; override val port = "Puerto"
    override val rttPing = "RTT (ping)"; override val checkedField = "Comprobado"; override val okOfTotal = "Comprobaciones exitosas / totales"
    override val tgConnectedField = "Telegram conectado"; override val tgSessions = "Sesiones de Telegram"; override val trafficThroughProxy = "Tráfico a través del proxy"
    override val sessionsTotal = "Sesiones en total"; override val relayNow = "Reenviando ahora"; override val tlsDomain = "Dominio TLS (SNI)"
    override val sourceSub = "Origen (suscripción)"; override val lastError = "Último error"; override val yes = "sí"; override val no = "no"
    override val copyAsLink = "Copiar como enlace"; override val openInTelegram = "Abrir host en Telegram"; override val makeNextRelay = "Usar como próximo relay"
    override val actCopy = "Copiar"; override val actOpen = "Abrir"; override val actRelay = "Relay"
    override fun agoFmt(v: String) = "hace ${v}"
    override val catalogTopFor = "Lista/valoración de proxies para"
    override val catalogModeHelpTitle = "Modos y valoraciones"
    override val catalogModeHelp = "La app cuenta los hosts activos y sus valoraciones POR SEPARADO en cada modo de red (VPN, Wi-Fi, LTE, Ethernet y White). \"White\" es un modo MANUAL aparte para listas blancas; el modo automático nunca cambia a él. Así que el mismo host puede estar activo en un modo y muerto en otro."
    override fun catalogInactiveWarn(section: String, active: String) =
        "Estás viendo la sección inactiva ${section}: todas las estadísticas en este momento van a ${active}, no aquí."
    override val manageModeTitle = "Gestionar modo"
    override val manageResetRating = "Restablecer valoración"
    override fun manageResetHint(mode: String) = "Para ${mode} en concreto puedes restablecer la valoración y las estadísticas de uso de los hosts activos. Esto resulta útil cuando te has conectado a una VPN o LTE fundamentalmente distinta, para que las estadísticas antiguas no interfieran. O para observar lo rápido que el escaneo de proxies vuelve a comprobarlo todo desde cero."
    override val manageDeleteAll = "Eliminar hosts en"
    override fun manageDeleteHint(mode: String) = "Puedes borrar tanto la valoración como los propios hosts de ${mode}. La función \"Escanear proxies\" volverá a reunirlos. Esto no es un restablecimiento de la suscripción: puedes tocarlo y luego esperar ~15 minutos a un reescaneo."
    override fun manageCopyFrom(mode: String) = "Copiar todos los hosts y valoraciones a este modo (${mode}) desde otro modo:"
    override val live = "activos"; override val deadW = "muertos"; override val unitMs = "ms"
    override val agoMin = "m"; override val agoHour = "h"; override val agoDay = "d"

    override val connectTelegram = "Conectar Telegram"; override val readCarefully = "¡Léelo con atención!"
    override val guideIntro = "Esta app no funcionará sin configuración. Elige una cualquiera de las 3 opciones de abajo " +
        "y sigue las instrucciones con cuidado."
    override val variant1 = "Opción n.º 1 — botones"
    override val variant1Body = "Toca \"Proxy {A}\": se abre Telegram, confirma añadir el proxy. Vuelve " +
        "a esta pantalla y toca \"Proxy {B}\": confirma añadir por segunda vez.\n\nDesactiva cualquier " +
        "otro proxy antiguo en Telegram. Deben quedar exactamente 2 proxies, con los puertos {A} y {B}. " +
        "Con cualquier otro conjunto AutoConnector no funcionará."
    override val variant2 = "Opción n.º 2 — enlaces"
    override val variant2Body = "Copia el texto de abajo en Mensajes guardados (o en cualquier chat) de Telegram, " +
        "es decir, envíatelo a ti mismo. Toca el primer enlace de tu mensaje: se añade el primer proxy. " +
        "Toca el segundo enlace: se añade el segundo. Luego desactiva todos los proxies antiguos."
    override val variant3 = "Opción n.º 3 — manualmente"
    override val variant3Body = "Añade manualmente un proxy SOCKS5: servidor localhost (127.0.0.1), puerto {A}. " +
        "Luego un segundo proxy: localhost, puerto {B}. Elimina cualquier proxy antiguo."
    override val whatNext = "¿Y ahora qué?"
    override val whatNextBody = "En Telegram, activa el \"cambio automático de proxy\": 5 segundos. Puedes ayudar " +
        "a Telegram a conectarse tocando manualmente un proxy (dentro de Telegram) que NO esté activo o esté marcado " +
        "como \"no disponible\": eso hace que Telegram se esfuerce más por conectarse.\n\nAsegúrate de que todos los demás " +
        "proxies antiguos se hayan eliminado, salvo {A} y {B}. Toca " +
        "\"Usar proxy\" en Telegram.\n\nEspera mientras la app encuentra y descarga suficientes proxies " +
        "(5–15 minutos). Luego Telegram se conecta a AutoConnector por sí solo, que seguirá enrutando " +
        "Telegram a través de los mejores proxies: verificados, activos y rápidos.\n\nSi las instrucciones te parecen " +
        "difíciles, lo sentimos, no podrás usar la app: es imposible configurarlo todo " +
        "automáticamente, y encontrar proxies activos lleva tiempo.\n\nSi descargaste la app hace mucho " +
        "y no se encontraron proxies activos, actualiza la app o la lista de suscripciones. Esta app " +
        "no inventa ni proporciona sus propios proxies, solo busca en internet a lo largo de docenas " +
        "de grupos y páginas."
    override fun proxyBtn(port: Int) = "Proxy ${port}"

    override val setupPortsTitle = "Configurar puertos en Telegram"
    override val setupPortsSub = "Cómo conectar Telegram al Conector (puertos 55001/55002)"
    override val settings = "Ajustes"; override val settingsSub = "Puertos, anti-DPI, escaneo, red, batería"
    override val subscriptions = "Suscripciones"; override val subscriptionsSub = "Fuentes de proxy a escanear"
    override val statistics = "Estadísticas"; override val statisticsSub = "Base de datos de proxies + trucos anti-DPI"
    override val export = "Exportar"; override val exportSub = "Enlaces tg:// de proxies activos"
    override val about = "Acerca de"; override val aboutSub = "Versión, compilación, descarga, comentarios"
    override val hotkeys = "Atajos de teclado"
    override val hotkeysSub = "Teclas globales: copiar / abrir un proxy"
    override val hotkeysIntro = "Los atajos de teclado globales se activan incluso cuando la ventana de la app no está enfocada. Eligen un " +
        "enlace de proxy activo aleatorio (tg://) del grupo, útil para cambiar de proxy rápidamente sin " +
        "abrir la app."
    override val hotkeysNote = "En macOS, capturar teclas puede requerir el permiso de Accesibilidad " +
        "(Ajustes del Sistema → Privacidad y seguridad → Accesibilidad)."
    override val hotkeyCopyTitle = "Copiar enlace de proxy"
    override val hotkeyCopyDesc = "Pone un enlace tg:// activo aleatorio en el portapapeles."
    override val hotkeyEnable = "Activar atajos"; override val hotkeyLetterLabel = "Letra"; override val hotkeySet = "Establecer"; override val hotkeyReset = "Restablecer"
    override val hotkeyOpenTitle = "Abrir proxy en Telegram"
    override val hotkeyOpenDesc = "Abre un enlace activo aleatorio: Telegram lo capta y ofrece conectar el proxy."

    override val relayPorts = "Puertos de relay"
    override val relayPortsHelp = "Puertos locales en los que escucha el Conector. Introduces exactamente estos en " +
        "Telegram como proxy SOCKS5 (127.0.0.1 : puerto). Se usan dos puertos por fiabilidad: Telegram " +
        "mantiene conexiones a ambos."
    override val portA = "Puerto A"; override val portB = "Puerto B"
    override val antiDpiTrick = "Truco anti-DPI"
    override val antiDpiHelp = "Una forma de disfrazar la conexión para que el ISP/DPI no la reconozca y " +
        "la bloquee.\n• \"Rotación automática\" elige por sí solo un truco que funcione.\n• \"Sin trucos DPI\": una " +
        "conexión normal.\n• Los demás son técnicas concretas (imitación de navegador, fragmentación de paquetes, etc.)."
    override val onlyFakeTls = "Solo FakeTLS (ee)"
    override val applyDpiTo = "Aplicar anti-DPI a"
    override val applyDpiHelp = "A qué aplicar el truco anti-DPI elegido:\n• Relay de Telegram: a la " +
        "conexión activa de Telegram a través del Conector.\n• Sondeos de proxy: a las comprobaciones de proxy en segundo plano " +
        "(entonces una comprobación se comporta igual que una conexión real, y las estadísticas de los trucos son más precisas).\n" +
        "• Al conectar directamente: cuando los proxies están desactivados (u omitidos mientras hay una VPN activa) y Telegram " +
        "va directo a sus servidores: aquí no hay proxy, así que el truco se reduce a fragmentar el " +
        "primer paquete TCP (el handshake) en varios segmentos pequeños para que el DPI no pueda emparejarlo en una sola lectura."
    override val toRelay = "Relay de Telegram"; override val toProbes = "Sondeos de proxy"
    override val toDirect = "Al conectar directamente"
    override val vpnSection = "Cuando la VPN está activa"
    override val vpnHelp = "Qué hacer cuando hay una VPN activa en el dispositivo:\n• Vía proxy MTProto: " +
        "Telegram pasa por los proxies encontrados como de costumbre (por encima de la VPN).\n• Directamente: el " +
        "Conector NO usa proxies y conecta Telegram directamente a los servidores de Telegram: la " +
        "VPN ya da acceso, la capa de proxy extra no es necesaria (más rápido y más estable). " +
        "Sin VPN los proxies se usan como de costumbre."
    override val linkFormat = "Formato del enlace de proxy"
    override val linkFormatHelp = "Cómo copiar y abrir proxies. tg:// abre Telegram directamente (requiere tener instalado Telegram Desktop). http (t.me) abre vía navegador y ofrece abrir en Telegram, útil si tg:// no está registrado."
    override val linkTg = "tg:// (abrir Telegram directamente)"; override val linkTgSub = "tg://proxy?… — abre Telegram"
    override val linkHttp = "http (t.me, vía navegador)"; override val linkHttpSub = "https://t.me/proxy?… — abre el navegador"
    override val viaMtproto = "Proxy vía MTProto"; override val viaMtprotoSub = "incluso con VPN, el tráfico pasa por los proxies"
    override val directly = "Conectar directamente"; override val directlySub = "con VPN activa: omite los proxies, directo a Telegram"
    override val notifications = "Notificaciones"
    override val scanCheck = "Escaneo y comprobación"
    override val scanCheckHelp = "• Escaneo, min: con qué frecuencia descargar listas de proxies de las suscripciones.\n" +
        "• Comprobación, min: con qué frecuencia volver a comprobar los proxies de la base de datos.\n• Tamaño del lote: " +
        "cuántos proxies comprobar por pasada.\n• Paralelo: cuántas comprobaciones ejecutar a la vez (más = " +
        "más rápido, pero mayor carga de red y batería)."
    override val scanMin = "Escaneo, min"; override val checkMin = "Comprobación, min"; override val batchSize = "Tamaño del lote"; override val parallel = "Paralelo"
    override val speedByNet = "Intensidad de escaneo por red"
    override val speedByNetHelp = "Con qué frecuencia comprobar los proxies según la red actual. " +
        "\"Estándar\" = intervalo base. Desliza a la derecha para hacerlo más raro (más lento, más suave con tráfico/batería), " +
        "a la izquierda para hacerlo más a menudo (más rápido, más agresivo). Escala logarítmica, hasta ×100 en cada sentido.\n" +
        "• VPN: cuando hay una VPN externa activa.\n• Wi-Fi: en una red Wi-Fi.\n• LTE: en una red móvil."
    override val intensStandard = "estándar"
    override val intensSlower = "más lento"
    override val intensFaster = "más rápido"
    override val maintenance = "Restablecer datos"
    override val maintenanceHelp = "• \"Restablecer catálogo y estadísticas\": pone a cero valoraciones, contadores, tráfico " +
        "y registros de comprobación, pero conserva los hosts descargados y las suscripciones (todo se vuelve a valorar en " +
        "el siguiente escaneo).\n• \"Borrar hosts descargados\": elimina todo el grupo de proxies pero conserva " +
        "las suscripciones para que el escaneo vuelva a llenar el grupo. Las suscripciones nunca se tocan en ningún caso."
    override val backupTitle = "Exportar / Importar"
    override val backupHelp = "Guarda o restaura los datos de la app como JSON. Marca qué " +
        "incluir, cualquier combinación:\n• Ajustes: todos los parámetros de la app.\n• Suscripciones: la lista de fuentes " +
        "(URL + activado/desactivado).\n• Catálogo de hosts activos: cada proxy activo con sus valoraciones y estadísticas " +
        "POR modo de red.\n\n\"Exportar\" abre una página con el JSON listo: cópialo o guárdalo en un archivo. " +
        "\"Importar\": pega el JSON (o carga un archivo) y se aplican solo las secciones marcadas que estén presentes en " +
        "él. La importación AÑADE a los datos actuales (sin borrarlos)."
    override val backupSettings = "Ajustes"
    override val backupSubs = "Suscripciones"
    override val backupHosts = "Catálogo de hosts activos (por modo)"
    override val exportWord = "Exportar"
    override val importWord = "Importar"
    override val backupExportTitle = "Exportar datos"
    override val backupImportTitle = "Importar datos"
    override val backupSelectExport = "Qué exportar:"
    override val backupSelectImport = "Qué importar:"
    override val backupCopyBtn = "Copiar"
    override val backupSaveFile = "Guardar en archivo"
    override val backupLoadFile = "Cargar desde archivo"
    override val backupDoImport = "Importar"
    override val backupPasteLabel = "Pega aquí el JSON de la copia de seguridad"
    override val backupJsonLabel = "JSON de la copia de seguridad"
    override val backupAndroidFileNote = "Los archivos no están disponibles aquí: usa Copiar / Pegar."
    override val eraseAllHosts = "Borrar todos los hosts"
    override val factoryReset = "Restablecer todo (como el primer inicio)"
    override val factoryResetConfirm = "¿Restablecer por completo la app al estado de fábrica? Se borrarán TODOS los ajustes y todo el " +
        "catálogo de hosts, las suscripciones se restaurarán a los valores predeterminados. Igual que un primer inicio."
    override val resetCatalog = "Restablecer catálogo y estadísticas"
    override val resetCatalogConfirm = "¿Poner a cero todas las valoraciones, contadores y registros de comprobación? " +
        "Los hosts descargados y las suscripciones se conservan y se vuelven a valorar en el siguiente escaneo."
    override val clearHosts = "Borrar hosts descargados"
    override val clearHostsConfirm = "¿Eliminar toda la lista de hosts descargados (proxies)? " +
        "Las suscripciones se conservan y el escaneo volverá a llenar el grupo."
    override val doReset = "Restablecer"
    override val doCancel = "Cancelar"
    override val adaptiveSpeed = "Velocidad adaptativa"
    override val adaptiveHelp = "Las comprobaciones de actividad se ejecutan a un intervalo base (de \"Escaneo y comprobación\", también " +
        "multiplicado por el multiplicador de red). \"Velocidad adaptativa\" las acelera o las ralentiza " +
        "automáticamente según cuántos proxies estén activos en ese momento.\n\n" +
        "• POCOS activos (por debajo del umbral \"Pocos\") → intervalo × \"Aceleración\". Un multiplicador menor que 1 = más " +
        "a menudo: 0.5 — el doble de a menudo, 0.25 — 4×. Llena el grupo más rápido.\n" +
        "• MUCHOS activos (por encima del umbral \"Muchos\") → intervalo × \"Ralentización\". Mayor que 1 = más raro: 2 — " +
        "la mitad de a menudo, 4 — la cuarta parte. Ahorra batería y tráfico.\n" +
        "• Entre los umbrales: velocidad base (×1).\n\n" +
        "Ejemplos:\n" +
        "— Reunir proxies más rápido: \"Aceleración\" 0.25 y/o umbral \"Pocos\" 40.\n" +
        "— Ahorrar batería cuando tengas suficientes: \"Ralentización\" 8 y/o umbral \"Muchos\" 30.\n" +
        "— Desactivar la adaptación: pon ambos multiplicadores a 1.\n\n" +
        "Valores predeterminados: Pocos 20, Aceleración 0.5, Muchos 50, Ralentización 4."
    override val threshMany = "Umbral \"Muchos\""; override val threshFew = "Umbral \"Pocos\""; override val mulFast = "Aceleración ×"; override val mulLazy = "Ralentización ×"
    override val subIntensityTitle = "Intensidad de suscripción"
    override val subIntensityHint = "Pausa entre descargas de suscripción: cuántos minutos antes de volver a descargar las listas de proxies (por separado en cada modo de red)."
    override val baseScanTitle = "Velocidad base de escaneo"
    override val baseScanHelp = "La velocidad de referencia de comprobación de actividad. \"Velocidad adaptativa\" y los multiplicadores de \"Velocidad por " +
        "modo\" se calculan en relación con ella.\n\n" +
        "• Con qué frecuencia ejecutar, min: intervalo entre pasadas de comprobación.\n" +
        "• Lote por hilo, hosts: cuántos hosts comprueba cada hilo por pasada.\n" +
        "• Hilos: cuántas comprobaciones se ejecutan a la vez. Una pasada sondea \"lote × hilos\" hosts.\n" +
        "• No reescanear un host más a menudo que cada N min: anti-flood: un host comprobado recientemente se " +
        "omite en esta pasada.\n\n" +
        "Más hilos y un lote mayor = crecimiento más rápido del grupo, pero mayor carga de red y batería."
    override val baseScanPeriod = "Con qué frecuencia ejecutar, min"
    override val baseScanBatch = "Lote por hilo, hosts"; override val baseScanThreads = "Número de hilos"
    override val adaptiveDesc = "Si los proxies activos son menos que \"pocos\" o más que \"muchos\", aplica un multiplicador extra."
    override val fewWord = "Pocos"; override val manyWord = "Muchos"
    override fun fasterX(x: String) = "${x}× más rápido"
    override fun slowerX(x: String) = "${x}× más lento"
    override fun ifAliveLt(n: Int) = "Si los proxies activos < ${n}, entonces:"
    override fun ifAliveGt(n: Int) = "Si los proxies activos > ${n}, entonces:"
    override val disabledWord = "desactivado"
    override val speedByModeTitle = "Velocidad por modo"
    override val speedByModeHelp = "Un multiplicador de velocidad de escaneo para cada modo de red, sobre la velocidad " +
        "base. \"Estándar\" (×1) = el intervalo base. Derecha: más raro (más lento, más suave con tráfico/" +
        "batería), izquierda: más a menudo (más rápido, más agresivo). Escala logarítmica, hasta ×100 en cada " +
        "sentido.\n\n" +
        "Debajo de cada deslizador están los parámetros de pasada resultantes con la velocidad adaptativa aplicada, " +
        "mostrados por separado para \"pocos activos\" (× \"Aceleración\") y \"muchos activos\" (× \"Ralentización\").\n\n" +
        "Modos:\n• VPN: hay una VPN externa activa.\n• LTE: red móvil.\n• Wi-Fi: red Wi-Fi.\n" +
        "• Ethernet: conexión por cable.\n• White: modo de proxy \"white\" manual."
    override val aliveLt = "activos <"; override val aliveGt = "activos >"
    override val periodWord = "periodo"; override val nonstopWord = "sin parar"
    override val batchWord = "lote"; override val threadsWord = "hilos"; override val scanModeOff = "escaneo desactivado"
    override val netBattery = "Red y batería"
    override val netBatteryHelp = "• Solo Wi-Fi: no escanear en redes móviles (ahorra datos).\n• Solo " +
        "cargando: funcionar solo mientras el teléfono se está cargando.\n• Omitir con batería baja: pausar el escaneo cuando la " +
        "batería esté baja."
    override val onlyWifi = "Solo Wi-Fi"; override val onlyCharging = "Solo cargando"; override val skipLowBattery = "Omitir con batería baja"
    override val autosaved = "Los ajustes se guardan automáticamente."
    override val dpiAutoLabel = "Rotación automática de trucos DPI"; override val dpiNoneLabel = "Sin trucos DPI (normal)"
    override val experimental = "Experimental"
    override val experimentalHelp = "Motores de proxy alternativos al upstream MTProto, además de un registro de diagnóstico. " +
        "La ruta de referencia (que funciona) no cambia cuando se ajusta a \"Desactivado\". Solo cambia CÓMO se escribe el flujo cifrado en " +
        "el socket TCP del upstream (tamaños de segmento, temporización, límites de registro TLS): el flujo en sí permanece idéntico byte por byte. " +
        "Se aplica solo al relay del proxy activo (no a los sondeos ni a la ruta directa)."
    override val expEngineTitle = "Motor de proxy (ofuscación de socket)"
    override val expConnectTitle = "Motor de conexión (selección de upstream)"
    override val expEngineWarn = "⚠ Modo experimental. Si la conectividad empeora, vuelve a \"Desactivado (ruta de referencia)\"."
    override val netLog = "Activar registro de intercambio de red"
    override val netLogSub = "Escribe QUIÉN-A-QUIÉN-CUÁNDO y tamaños de paquete en un archivo (SIN datos de carga útil), " +
        "para comparar el patrón de intercambio con y sin VPN."
    override val openLogFolder = "Abrir carpeta de registros"; override val copyPath = "Copiar ruta"
    override val helpShow = "Ayuda"; override val helpHide = "Ocultar ayuda"
    override val quickSwitchIntro = "Aquí puedes elegir un truco para evadir bloqueos. Si Telegram muestra el error " +
        "“The proxy you are using is not configured correctly and will be disabled. Please find another " +
        "one”, experimenta con qué tipo de ofuscación de tráfico funciona para que Telegram deje de mostrarlo. Empieza " +
        "con los modos split*. Los modos coalesce* también funcionan, pero con ellos las imágenes/vídeos cargan mal en Telegram."
    override val quickSwitchTitle ="Evasión de bloqueos"; override val quickSwitchSub = "Modelado, conexión, anti-DPI"

    override val sourceUrl = "URL de origen"
    override fun sourceAlive(alive: Int, total: Int) = "activos ${alive}/${total}"
    override val open = "Abrir"; override val active = "Activo"; override val inactive = "Inactivo"
    override val lastDownloaded = "Descargado"; override val notDownloaded = "aún no descargado"
    override fun sourceCounts(dead: Int, total: Int) =
        " activos, ${dead} muertos, ${total} total"

    override val proxyBase = "Base de datos de proxies"
    override val totalInBase = "Total en la base de datos"; override val aliveNow = "Activos ahora"; override val deadStat = "Muertos"
    override val aliveIn15 = "Activos en 15 min"; override val checksAllTime = "Comprobaciones desde siempre"
    override val antiDpiTricks = "Trucos anti-DPI"; override val noStatsYet = "aún sin datos: los trucos se acumulan a medida que ocurren comprobaciones/conexiones"
    override val attempts = "Intentos"; override val handshake = "Handshake"; override val score = "Puntuación"
    override val tgConnect = "Conexión TG"; override val socketsOver1m = "Sockets >1min"
    override val over10kb = "Sockets >10KB"; override val over100kb = ">100KB"; override val workTime = "Tiempo de trabajo"
    override val statsLegend = "Handshake — handshakes exitosos (% de intentos) · Puntuación — valor · " +
        "\"Tiempo de trabajo\" — total sobre sockets ≥5KB y de más de 1 minuto."
    override val resetStats = "Restablecer estadísticas de trucos"

    override fun aliveLinks(n: Int) = "Enlaces activos: ${n}"
    override val copyAll = "Copiar todo"
    override val openRandom = "Abrir aleatorio"; override val copyRandom = "Copiar aleatorio"; override val allShort = "TODOS"
    override val copyTop = "Copiar TOP"; override val randomHost = "Host aleatorio"
    override val exportToFile = "Exportar a archivo"; override val exportSaved = "Guardado en archivo:"
    override val dlNow = "Descargar ahora"
    override fun downloadingFmt(sec: Long) = "Descargando… ${sec}s"
    override val cancel = "Cancelar"
    override val deleteConfirmTitle = "¿Eliminar suscripción?"
    override val subscriptionsAddHint = "Añade suscripciones o enlaces de proxy →"
    override val addSourcesTitle = "Añadir"
    override val addSubsLabel = "Suscripciones (una URL por línea)"
    override val addSubsHelp = "Cada línea con una URL válida se convierte en su propia suscripción y se descarga periódicamente."
    override val addProxiesLabel = "Enlaces de proxy listos (lista fija)"
    override val addProxiesHelp = "Pega un lote de enlaces a proxies concretos (tg://proxy, https://t.me/proxy, …). Esto NO es una suscripción: la lista nunca se descarga, los proxies simplemente se añaden al catálogo."
    override val addButton = "Añadir"
    override fun addedFmt(subs: Int, proxies: Int) = "Añadidos: ${subs} suscripciones, ${proxies} proxies"
    override val perSecond = "por s"
    override val graphSpeed = "Velocidad"
    override val graphVolume = "Volumen"
    override val graphLatency = "Ping"
    override val graphConnects = "Conexiones"
    override val scanNow = "Escanear ahora"; override val scanOnShort = "Escaneo on"
    override val scanRunning = "Escaneo en curso"; override val scanIdle = "Escaneo en reposo"; override val scanOffState = "Escaneo OFF"; override val scanBatchPerThread = "Lote/hilo"; override val scanPassHosts = "Hosts en pasada"; override val minRescanLabel = "No reescanear un host más a menudo que cada N min"
    override val scanPlanTitle = "Plan"; override val scanNowTitle = "Ahora"; override val currentScheduleTitle = "Programación actual"
    override val scheduleWord = "Programación"; override val unitPcsPerSec = "uds/s"
    override val scanNowThreadsLabel = "Hilos en ejecución ahora"; override val scanNowPerThreadLabel = "Comprobaciones por hilo (plan)"; override val scanNowElapsedLabel = "Tiempo en ejecución"
    override val scanOkGraph = "Escaneos exitosos"; override val scanFailGraph = "Escaneos fallidos"; override val scanTrafficGraph = "Tráfico de escaneo"; override val scanAliveGraph = "Total de proxies activos"; override val scanPingGraph = "Ping"; override val threadsGraph = "Hilos"
    override val scanEvery = "Cada"; override val scanNextRun = "Próxima ejecución"
    override val scanThreads = "Hilos"; override val scanBatch = "Lote"
    override val scanElapsed = "En ejecución"; override val scanIdleNow = "—"
    override val effForFew = "Cuando pocos"; override val effForMany = "Cuando muchos"
    override val effCheck = "Comprobación"; override val effBatch = "Lote"; override val effPar = "Paralelo"
    override val effContinuous = "continuo"; override val secShort = "s"; override val minShort = "min"

    override val appTagline = "Auto-conector multiplataforma: encuentra, comprueba y ejecuta proxies MTProto " +
        "a través de los cuales funciona Telegram."
    override val version = "Versión"; override val buildDate = "Fecha de compilación"
    override val downloadSources = "Descarga y fuentes"; override val openOnGithub = "Abrir en GitHub"
    override val feedbackBugs = "Comentarios e informes de errores"; override val writeTelegram = "Escribir en Telegram"

    override val language = "Idioma"; override val langAuto = "Automático (sistema)"; override val langRu = "Русский"; override val langEn = "English"
    override val langFa = "فارسی"; override val langZh = "简体中文"; override val langAr = "العربية"; override val langUr = "اردو"
    override val langTr = "Türkçe"; override val langId = "Bahasa Indonesia"; override val langHi = "हिन्दी"; override val langBn = "বাংলা"; override val langMy = "မြန်မာ"
    override val langWord = "Idioma"
    override val raceWidthTitle = "Conexiones paralelas"
    override val connectionSection = "Conexión y evasión de bloqueos"
    override val connectionSectionHelp = "Motor de conexión, upstreams paralelos, motor de proxy y trucos anti-DPI: todo en una sección."
    override val netLogSection = "Registro de intercambio de red"
    override val platform = "Plataforma"

    override val scanModeTitle = "Modo de red"; override val scanModeAuto = "Automático"; override val scanModeManualLabel = "Manual"
    override val activeModeLabel = "Modo activo"; override val formingListLabel = "Construyendo lista"; override val catalogModeTabs = "Modo"
    override val resetModeRatings = "Restablecer valoraciones de hosts"; override val forgetModeHosts = "Olvidar hosts del modo"
    override val exportModeTitle = "Exportar por modo"; override val modePickerTitle = "Modo"
    override val modeHelp = "Cada modo de red mantiene sus propias valoraciones de proxies y su propia intensidad de escaneo + descarga de suscripciones. \"Automático\" elige el modo según la red activa. \"Manual\" te permite elegir cualquier modo tú mismo (incluido White, que el modo automático nunca selecciona)."
    override val autoSelect = "Selección automática"; override val manualSelect = "Selección manual"
    override val connStatsTitle = "Conexiones ahora"; override val connOnPort = "Conexiones en el puerto"; override val outgoingConns = "Conexiones salientes"
    override val modeChoice = "Selección de modo"; override val autoChoice = "selección automática"; override val manualChoice = "fijo manual"
    override val directOnVpn = "Conexión directa a TG con VPN"; override val onWord = "on"; override val offWord = "off"
    override val directStateActive = "activo"; override val directStateOff = "desactivado en ajustes"; override val directStateIdle = "activado en ajustes, pero no activo"
    override val wpHintTitle = "¿Qué es White?"
    override val wpHint = "White — WhitePages: un perfil de red manual. Se activa solo a mano (la selección automática nunca lo elige). " +
        "Mantiene sus propias valoraciones de hosts, descarga suscripciones y escanea independientemente de VPN/Wi-Fi/LTE."

    override val recentAttempts = "Conexiones y comprobaciones recientes"
    override val kindCheck = "comprobación"
    override val kindTg = "telegram"
    override val histWho = "Quién"
    override val histWhen = "Cuándo"
    override val histReq = "Solicitud"
    override val histSess = "Sesión"
    override val histScan = "escaneo"
    override val testNow = "Probar ahora"
    override val testShort = "Probar"
    override val testResult = "Resultado de la prueba"
    override val testStop = "Detener"
    override val testingNow = "probando…"
    override val prewarmTitle = "Precalentar sockets (experimental)"
    override val prewarmHelp = "Mantén unos cuantos sockets de proxy upstream conectados por " +
        "adelantado para que una nueva conexión de Telegram pueda saltarse la conexión/handshake. Experimental: se " +
        "reconecta constantemente en segundo plano, así que consume tráfico y un poco de CPU. No se envía tráfico " +
        "falso (eso corrompería la sesión real): los sockets simplemente se rotan. Más útil con proxies FakeTLS."
    override val prewarmEnable = "Activar precalentamiento"
    override val prewarmModeDeferred = "Diferido (solo TLS)"
    override val prewarmModeDeferredSub = "Mantiene TCP + FakeTLS; completa la inicialización al traspaso. Sin DC comprometido: lo más realista."
    override val prewarmModeFull = "Handshake completo"
    override val prewarmModeFullSub = "Mantiene sockets totalmente conectados en distintos DC; se reutilizan solo si coinciden DC/tag. Duran menos."
    override val prewarmPoolLabel = "Sockets en reserva"
    override val prewarmHoldLabel = "Mantener cada uno, s"
    override val prewarmNote = "Solo rotación (sin keepalive a nivel de app). Un socket dura de segundos a ~un minuto según el proxy/DC."
    override val prewarmStatus = "Precalentamiento"
    override fun prewarmStatusVal(ready: Int, holdSecs: Int) = "$ready listos · mantengo ${holdSecs}s"
    override val prewarmStar = "Naranja en negrita = socket entregado caliente desde el grupo de precalentamiento (sin conexión/handshake)"
    override fun prewarmTableTitle(holdSecs: Int) = "Sockets precalentados (mantengo ${holdSecs}s)"
    override val prewarmTableHelp = "\"Precalentar sockets\" abre unos cuantos sockets de proxy por adelantado para que una " +
        "nueva conexión de Telegram pueda saltarse la conexión/handshake. Esta tabla muestra los sockets que se están " +
        "precalentando: cuánto ha vivido cada uno, si Telegram lo está usando, y el tráfico. Actívalo/desactívalo y " +
        "configúralo (modo, número de sockets, tiempo de retención) en Más → Ajustes → \"Precalentar sockets (experimental)\"."
    override val prewarmNoneWarming = "aún no hay sockets precalentándose"
    override val prewarmColAge = "edad"
    override val prewarmColUse = "¿en TG?"
    override val prewarmInUse = "en TG"
    override val prewarmNew = "nuevo"
    override val lanShareTitle = "Compartir por LAN (portal web)"
    override val lanShareDesc = "Permite que otros dispositivos en esta Wi-Fi usen este AutoConnector como proxy; un navegador que abra la dirección de abajo obtiene una página con los mejores proxies."
    override val lanShareUrlsLabel = "Los vecinos de red se conectan en:"
    override val lanShareNoIp = "sin dirección en la red local: conéctate a Wi-Fi"
    override val lanFirewallTitle = "Permitir en la red local"
    override val lanFirewallBody = "Al activarlo se abren los puertos del relay a tu red local. El firewall de Windows (u otro) puede preguntar ahora si permitir AutoConnector: elige Permitir / Sí. Si lo deniegas, el tráfico de los vecinos hacia AutoConnector quedará bloqueado y la página/proxy no estará accesible."
    override val lanFirewallConfirm = "Activar"
    override val lanInfoTitle = "¿Para qué sirve esto?"
    override val lanInfoBody = "Ejecuta AutoConnector en UN solo ordenador o teléfono de tu Wi-Fi, y todos los demás dispositivos de la misma red, incluido un iPhone (que esta app no admite directamente), pueden simplemente abrir la dirección en un navegador y usarlo: una página con los mejores proxies para añadir a su Telegram, o este propio dispositivo como proxy SOCKS. Un dispositivo encuentra y mantiene los proxies; el resto lo aprovechan por la LAN."
    override val volTriggerTitle = "Activador con botones de volumen"
    override val volTriggerSub = "Cambia de proxy con un patrón rápido de teclas de volumen"
    override val volEnableLabel = "Vigilar los botones de volumen"
    override val volHelpTitle = "¿Qué es esto?"
    override val volHelpBody = "En Android no hay atajos de teclado globales, así que esto usa los botones de VOLUMEN en su lugar. Mientras está activado, AutoConnector vigila en segundo plano un patrón rápido de pulsaciones de Volumen-Arriba/Abajo (p. ej. arriba-arriba-abajo-abajo). Cuando reconoce uno, abre un enlace tg:// de un proxy activo bueno al azar para que Telegram lo capte y cambie: una forma rápida y discreta de rotar el proxy sin abrir la app. El volumen sigue funcionando con normalidad (las pulsaciones no se interceptan). Esto necesita acceso de Accessibility (para leer las teclas de volumen en segundo plano y abrir el enlace); no se solicita nada hasta que actives la casilla. Configura abajo el tiempo máximo entre pulsaciones; los patrones reconocidos se enumeran al final."
    override val volGrantTitle = "Activa Accessibility (importante)"
    override val volGrantBody = "Android (especialmente 13+) bloquea Accessibility para apps NO instaladas desde Google Play: por eso AutoConnector aparece atenuado y dice \"Ajuste restringido\" / \"acceso no permitido\".\n\nCómo desbloquear:\n1. Abre \"Información de la app\" (botón abajo, o Ajustes → Aplicaciones → AutoConnector for Telegram).\n2. Toca el menú ⋮ (arriba a la derecha) → \"Permitir ajustes restringidos\" → confirma.\n3. Vuelve: Ajustes → Accessibility → AutoConnector for Telegram → actívalo.\n\nSi no ves \"Permitir ajustes restringidos\", primero intenta activarlo una vez en Accessibility (recibirás el mensaje de bloqueo) y entonces aparecerá el paso 2.\n\nEn Xiaomi/MIUI, Samsung, etc. la ruta puede variar ligeramente: busca el mismo ⋮ en \"Información de la app\". En Android 12 y anteriores normalmente no hay restricción: actívalo directamente en Accessibility.\n\nLas teclas de volumen solo se observan, nunca se bloquean."
    override val volOpenAppInfo = "Abrir Información de la app"
    override val volAccessOn = "Accessibility: concedida"
    override val volAccessOff = "Accessibility: no concedida"
    override val volOpenAccess = "Abrir ajustes de Accessibility"
    override val volGapLabel = "Máx. ms entre pulsaciones"
    override val volPatternsTitle = "Patrones reconocidos"
    override val volPatternPick = "Patrón"
    override val volPatternsLegend = "↑ = subir volumen, ↓ = bajar volumen"
    override val volNoRights = "La app aún NO tiene permiso para gestionar los botones de volumen: concede el acceso siguiendo los pasos del final de esta página."
    override val volGrantShort = "Aún sin acceso de Accessibility. Lee los pasos detallados al final de esta página y luego toca \"Comprobar\"."
    override val volCheck = "Comprobar"
    override val volCheckOk = "✓ Listo: acceso concedido, el activador funciona."
    override val volCheckFail = "✗ Aún sin acceso: completa los pasos de arriba."
    override val volPatternsList = "↑↑↓↓ · ↓↓↑↑ · ↑↓↑↓ · ↓↑↓↑ · ↑↑↑↑ · ↓↓↓↓ · ↑↓↓↑ · ↓↑↑↓ · ↑↑↑↓↓↓ · ↓↓↓↑↑↑   (↑ = subir volumen, ↓ = bajar volumen)"
    override val histLegend = "Columnas — Quién: ✓/✗ TG = conexión real de Telegram, escaneo = comprobación en segundo plano. Cuándo: hace cuánto. TCP/TLS/Solicitud: latencia del handshake y de la primera solicitud, ms. Sesión: cuánto duró la sesión de relay. ↓/↑: bytes recibidos / enviados a través del host."
    override val tgOkTotalHint = "Conexiones de Telegram / exitosas / comprobaciones totales"
    override val breadthTitle = "Amplitud de selección de hosts"
    override val breadthHelp = "Izquierda = ceñirse a los mejores hosts probados; derecha = probar lo más ampliamente posible entre todos los hosts activos. Cuando Telegram cambia constantemente de puerto de relay, la app amplía la búsqueda automáticamente."
    override val breadthNarrow = "probados"
    override val breadthWide = "más amplio"
    override val connTimeoutTitle = "Tiempo de espera de conexión por host"
    override val connTimeoutHelp = "Cuánto esperar por un upstream (TCP + TLS + primera respuesta MTProto) antes de pasar al siguiente proxy."
    override val factoryResetDone = "Todo se ha restablecido. Cierra la app y vuelve a abrirla."

    // tray
    override val trayOpenWindow = "Abrir ventana"
    override val trayRefreshSubs = "Actualizar suscripciones"
    override val trayExit = "Salir"
    override fun trayConnectorLabel(on: Boolean) =
        if (on) "Conector: ON (apagar)" else "Conector: OFF (encender)"
    override fun trayScanLabel(on: Boolean) =
        if (on) "Escaneo: ON (apagar)" else "Escaneo: OFF (encender)"
    override fun trayLive(n: Int) = "Proxies activos: ${n}"
    override val appearance = "Apariencia"
    override val themeLabel = "Tema"
    override val themeAuto = "Automático (según el sistema)"
    override val themeLight = "Claro"
    override val themeDark = "Oscuro"
    override val drawGraphsLabel = "Dibujar gráficos"
    override val drawGraphsSub = "Gráficos en vivo en las pestañas Conector y Escaneo — desactívalo para ahorrar batería"
}
