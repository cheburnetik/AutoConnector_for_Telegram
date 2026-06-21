package io.autoconnector.i18n

object Pt : Strings {
    override val tabConnector = "Conector"; override val tabScan = "Varredura"
    override val tabCatalog = "Catálogo"; override val tabLogs = "Registros"; override val tabMore = "Mais"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "Assinaturas"; override val logTabScan = "Varredura"
    override val logGeneral = "Geral"; override val logEmpty = "vazio por enquanto"
    override val logSessions = "Sessões"; override val logErrorsOnly = "somente erros"; override val logNoErrors = "nenhuma sessão com falha"
    override fun logSession(id: String, port: String) = "#${id} · :${port}"
    override val back = "Voltar"; override val copy = "Copiar"; override val gotIt = "Entendi"
    override val later = "Mais tarde"; override val details = "Detalhes"; override val whatIsThis = "O que é isto?"
    override val delete = "Excluir"

    override val connector = "Conector"; override val scan = "Varredura"
    override val notConfigured = "Não configurado! Corrigir →"; override val howToSetup = "Como configurar"
    override val notifOff = "As notificações estão desativadas! Corrigir →"; override val enable = "Ativar"
    override fun fewProxies(n: Int) = "Proxies ativos ${n}, buscando, aguarde ~15 min…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "Proxies ativos: ${alive}  (15 min: ${within}) · total: ${total}"
    override val notifWhyTitle = "Por que notificações?"
    override val notifWhyBody = "Um ícone de notificação persistente significa um serviço em primeiro plano do Android. " +
        "Sem ele, o sistema descarrega o aplicativo da memória e ele para de buscar proxies e " +
        "de manter a conexão em segundo plano. Por isso as notificações são necessárias para " +
        "o AutoConnector funcionar."
    override val notifEnableTitle = "Ativar notificações"
    override val notifEnableBody = "Sem um ícone de notificação, o Android trata o aplicativo como inativo e " +
        "o descarrega da memória. Então o AutoConnector para de buscar proxies e de manter a " +
        "conexão em segundo plano — o Telegram perde o vínculo.\n\nToque em \"Ativar\" e permita " +
        "notificações para o AutoConnector."
    override val notifPlea = "Ative as notificações! Sem elas o aplicativo não pode rodar em segundo plano — " +
        "o Android vai descarregá-lo e a busca de proxies e a conexão vão parar."

    override val statusConnected = "Telegram conectado"; override val statusConnecting = "Conectando…"
    override val statusOffline = "Telegram não conectado"; override val statusIdle = "Telegram ocioso"
    override val nobodyConnected = "Ninguém conectado ao Conector. "; override val howToSetupArrow = "Como configurar →"
    override val directModeViaVpn = "Modo direto: VPN ativa — sem proxy"
    override val directModeOff = "Modo direto: proxies desativados"
    override val directDpiSuffix = " · anti-DPI"
    override val connections = "Conexões"; override val sockets = "Sockets"; override val speed = "Velocidade"
    override val traffic = "Tráfego"; override val latency = "Latência"
    override fun pcs(n: Int) = "${n} un"
    override fun netNow(label: String) = "Rede: ${label}"
    override fun tgToConnector(n: Int) = "TG→ ${n}"
    override fun connectorToProxy(n: Int) = "proxy ${n}"
    override val trafficSec = "tráfego · 60 seg"; override val trafficMin = "tráfego · 60 min"
    override val latencySec = "latência · 60 seg"; override val latencyMin = "latência · 60 min"
    override val sec60 = "60 seg"; override val min60 = "60 min"
    override val unitSec = "s"; override val unitMin = "m"; override val unitHour = "h"; override val dash = "—"
    override val currentProxy = "Proxy atual"; override val noActiveProxy = "nenhum proxy ativo (Telegram não conectado)"
    override val host = "Host"; override val type = "Tipo"; override val secret = "Segredo"; override val antiDpi = "Anti-DPI"; override val obfEngine = "Motor de ofuscação"
    override fun activeSockets(n: Int) = "Sockets ativos do Telegram: ${n}"
    override val noConnections = "nenhuma conexão ativa"; override val colHost = "Host"; override val colTime = "Tempo"
    override val modeWord = "Modo"; override val directViaVpnLine = "Requisições diretas ao Telegram (VPN ativa)"
    override val connModeHelp = "Os modos (VPN, Wi-Fi, LTE, Ethernet, Branco) permitem ajustar a intensidade da varredura de forma diferente e manter avaliações/estatísticas de hosts separadas. A placa de rede é detectada automaticamente; o modo pode ser definido manualmente nas configurações."

    override val scanOff = "A varredura está desativada"; override val proxiesInBase = "Proxies no banco de dados"
    override val total = "total"; override val alive = "ativos"; override val dead = "inativos"
    override val tgConnectedTitle = "Telegram conectado via"; override val successful = "bem-sucedidas"
    override val socketsHeld = "Tempo de vida do socket"; override val over1m = ">1 min"; override val over5m = ">5 min"; override val over15m = ">15 min"
    override val scanCountTitle = "Quantidade de verificações de proxy"; override val checked = "Verificados"
    override val forAllTime = "todo o período"; override val perMinute = "por minuto"; override val perHour = "por hora"
    override val subsCountTitle = "Quantidade de downloads de assinaturas"; override val downloaded = "baixados"; override val failed = "falharam"; override val scanTraffic = "tráfego de varredura"; override val subTraffic = "tráfego de assinaturas"; override val subTrafficGraph = "Tráfego de assinaturas"
    override val checksMtproto = "Verificações MTProto (↑ ok · ↓ falha)"

    override fun catalogEmpty(mode: String) = "O catálogo ${mode} está vazio por enquanto. Ou nenhum host foi encontrado, ou o aplicativo nunca rodou neste modo. Você pode trocar o modo nas Configurações. Os modos existem para coletar hosts separadamente para diferentes tipos de conexão com a internet."
    override val aliveShort = "✓ ativo"; override val deadShort = "✗ inativo"
    override val statusLabel = "Estado"; override val rating = "Avaliação"; override val port = "Porta"
    override val rttPing = "RTT (ping)"; override val checkedField = "Verificado"; override val okOfTotal = "Verificações bem-sucedidas / total"
    override val tgConnectedField = "Telegram conectado"; override val tgSessions = "Sessões do Telegram"; override val trafficThroughProxy = "Tráfego pelo proxy"
    override val sessionsTotal = "Total de sessões"; override val relayNow = "Retransmitindo agora"; override val tlsDomain = "Domínio TLS (SNI)"
    override val sourceSub = "Fonte (assinatura)"; override val lastError = "Último erro"; override val yes = "sim"; override val no = "não"
    override val copyAsLink = "Copiar como link"; override val openInTelegram = "Abrir host no Telegram"; override val makeNextRelay = "Tornar próxima retransmissão"
    override val actCopy = "Copiar"; override val actOpen = "Abrir"; override val actRelay = "Retransmitir"
    override fun agoFmt(v: String) = "há ${v}"
    override val catalogTopFor = "Lista/avaliação de proxies para"
    override val catalogModeHelpTitle = "Modos e avaliações"
    override val catalogModeHelp = "O aplicativo conta os hosts ativos e suas avaliações SEPARADAMENTE por modo de rede (VPN, Wi-Fi, LTE, Ethernet e Branco). \"Branco\" é um modo MANUAL separado para listas brancas; o automático nunca muda para ele. Por isso o mesmo host pode estar ativo em um modo e inativo em outro."
    override fun catalogInactiveWarn(section: String, active: String) =
        "Você está vendo a seção inativa ${section} — todas as estatísticas agora vão para ${active}, não aqui."
    override val manageModeTitle = "Gerenciar modo"
    override val manageResetRating = "Redefinir avaliação"
    override fun manageResetHint(mode: String) = "Especificamente para ${mode} você pode redefinir a avaliação e as estatísticas de uso dos hosts ativos. Isto é útil quando você se conectou a uma VPN ou LTE fundamentalmente diferente, para que as estatísticas antigas não interfiram. Ou para observar a rapidez com que a varredura de proxies reverifica tudo do zero."
    override val manageDeleteAll = "Excluir hosts em"
    override fun manageDeleteHint(mode: String) = "Você pode limpar tanto a avaliação quanto os próprios hosts de ${mode}. O recurso \"Varrer proxies\" vai reuni-los novamente. Isto não é uma redefinição de assinatura — você pode tocar e depois aguardar ~15 minutos por uma nova varredura."
    override fun manageCopyFrom(mode: String) = "Copiar todos os hosts e avaliações para este modo (${mode}) a partir de outro modo:"
    override val live = "ativos"; override val deadW = "inativos"; override val unitMs = "ms"
    override val agoMin = "m"; override val agoHour = "h"; override val agoDay = "d"

    override val connectTelegram = "Conectando o Telegram"; override val readCarefully = "Leia com atenção!"
    override val guideIntro = "Este aplicativo não funcionará sem configuração. Escolha qualquer uma das 3 opções abaixo " +
        "e siga as instruções com atenção."
    override val variant1 = "Opção #1 — botões"
    override val variant1Body = "Toque em \"Proxy {A}\" — o Telegram abre, confirme a adição do proxy. Volte " +
        "para esta tela e toque em \"Proxy {B}\" — confirme a adição uma segunda vez.\n\nDesative quaisquer " +
        "outros proxies antigos no Telegram. Devem permanecer exatamente 2 proxies — com as portas {A} e {B}. " +
        "Com qualquer outro conjunto o AutoConnector não funcionará."
    override val variant2 = "Opção #2 — links"
    override val variant2Body = "Copie o texto abaixo para as Mensagens Salvas (ou qualquer conversa) no Telegram — " +
        "ou seja, envie para você mesmo. Toque no primeiro link da sua mensagem — o primeiro proxy é adicionado. " +
        "Toque no segundo link — o segundo é adicionado. Depois desative todos os proxies antigos."
    override val variant3 = "Opção #3 — manualmente"
    override val variant3Body = "Adicione manualmente um proxy SOCKS5: servidor localhost (127.0.0.1), porta {A}. " +
        "Depois um segundo proxy: localhost, porta {B}. Exclua quaisquer proxies antigos."
    override val whatNext = "E agora?"
    override val whatNextBody = "No Telegram, ative \"alternância automática de proxy\" — 5 segundos. Você pode ajudar " +
        "o Telegram a conectar tocando manualmente em um proxy (dentro do Telegram) que NÃO esteja ativo ou marcado " +
        "como \"indisponível\" — isso faz o Telegram se esforçar mais para conectar.\n\nCertifique-se de que todos os outros proxies " +
        "antigos foram removidos, exceto {A} e {B}. Toque em " +
        "\"Usar proxy\" no Telegram.\n\nAguarde enquanto o aplicativo encontra e baixa proxies suficientes " +
        "(5–15 minutos). Então o Telegram se conecta ao AutoConnector sozinho, que continuará roteando " +
        "o Telegram pelos melhores proxies: verificados, ativos e rápidos.\n\nSe as instruções parecerem " +
        "difíceis — desculpe, você não conseguirá usar o aplicativo: é impossível configurar tudo " +
        "automaticamente, e encontrar proxies ativos leva tempo.\n\nSe você baixou o aplicativo há muito tempo " +
        "e nenhum proxy ativo foi encontrado — atualize o aplicativo ou a lista de assinaturas. Este aplicativo " +
        "não inventa nem fornece seus próprios proxies, ele apenas busca na internet em dezenas " +
        "de grupos e páginas."
    override fun proxyBtn(port: Int) = "Proxy ${port}"

    override val setupPortsTitle = "Configurar portas no Telegram"
    override val setupPortsSub = "Como conectar o Telegram ao Conector (portas 55001/55002)"
    override val settings = "Configurações"; override val settingsSub = "Portas, anti-DPI, varredura, rede, bateria"
    override val subscriptions = "Assinaturas"; override val subscriptionsSub = "Fontes de proxy para varrer"
    override val statistics = "Estatísticas"; override val statisticsSub = "Banco de proxies + truques anti-DPI"
    override val export = "Exportar"; override val exportSub = "links tg:// dos proxies ativos"
    override val about = "Sobre"; override val aboutSub = "Versão, build, download, feedback"
    override val hotkeys = "Atalhos"
    override val hotkeysSub = "Teclas globais: copiar / abrir um proxy"
    override val hotkeysIntro = "Os atalhos globais funcionam mesmo quando a janela do aplicativo não está em foco. Eles escolhem um " +
        "link de proxy ativo aleatório (tg://) do conjunto — útil para alternar proxies rapidamente sem " +
        "abrir o aplicativo."
    override val hotkeysNote = "No macOS, capturar teclas pode exigir a permissão de Acessibilidade " +
        "(Configurações do Sistema → Privacidade e Segurança → Acessibilidade)."
    override val hotkeyCopyTitle = "Copiar link do proxy"
    override val hotkeyCopyDesc = "Coloca um link tg:// ativo aleatório na área de transferência."
    override val hotkeyEnable = "Ativar atalhos"; override val hotkeyLetterLabel = "Letra"; override val hotkeySet = "Definir"; override val hotkeyReset = "Redefinir"
    override val hotkeyOpenTitle = "Abrir proxy no Telegram"
    override val hotkeyOpenDesc = "Abre um link ativo aleatório — o Telegram o captura e oferece para conectar o proxy."

    override val relayPorts = "Portas de retransmissão"
    override val relayPortsHelp = "Portas locais nas quais o Conector escuta. Você as informa exatamente assim no " +
        "Telegram como um proxy SOCKS5 (127.0.0.1 : porta). Duas portas são usadas para confiabilidade — o Telegram " +
        "mantém conexões com ambas."
    override val portA = "Porta A"; override val portB = "Porta B"
    override val antiDpiTrick = "Truque anti-DPI"
    override val antiDpiHelp = "Uma forma de disfarçar a conexão para que o provedor/DPI não a reconheça e " +
        "bloqueie.\n• \"Rotação automática\" escolhe um truque que funcione sozinha.\n• \"Sem truques DPI\" — uma " +
        "conexão simples.\n• Os demais são técnicas específicas (imitação de navegador, divisão de pacotes etc.)."
    override val onlyFakeTls = "Somente FakeTLS (ee)"
    override val applyDpiTo = "Aplicar anti-DPI a"
    override val applyDpiHelp = "A que aplicar o truque anti-DPI escolhido:\n• Retransmissão do Telegram — à " +
        "conexão ativa do Telegram pelo Conector.\n• Sondas de proxy — às verificações de proxy em segundo plano " +
        "(então a verificação se comporta como uma conexão real, e as estatísticas dos truques ficam mais precisas).\n" +
        "• Ao conectar diretamente — quando os proxies estão desativados (ou ignorados com uma VPN ativa) e o Telegram " +
        "vai direto aos seus servidores: aqui não há proxy, então o truque se reduz a dividir o " +
        "primeiro pacote TCP (o handshake) em vários segmentos pequenos para que o DPI não consiga reconhecê-lo numa única leitura."
    override val toRelay = "Retransmissão do Telegram"; override val toProbes = "Sondas de proxy"
    override val toDirect = "Ao conectar diretamente"
    override val vpnSection = "Quando a VPN está ativa"
    override val vpnHelp = "O que fazer quando uma VPN está ativa no dispositivo:\n• Via proxy MTProto — " +
        "o Telegram passa pelos proxies encontrados como de costume (por cima da VPN).\n• Diretamente — o " +
        "Conector NÃO usa proxies e conecta o Telegram direto aos servidores do Telegram: a " +
        "VPN já fornece acesso, a camada extra de proxy não é necessária (mais rápido e mais estável). " +
        "Sem VPN os proxies são usados como de costume."
    override val linkFormat = "Formato do link de proxy"
    override val linkFormatHelp = "Como copiar e abrir proxies. tg:// abre o Telegram diretamente (precisa do Telegram Desktop instalado). http (t.me) abre pelo navegador e oferece abrir no Telegram — útil se tg:// não estiver registrado."
    override val linkTg = "tg:// (abrir o Telegram diretamente)"; override val linkTgSub = "tg://proxy?… — abre o Telegram"
    override val linkHttp = "http (t.me, pelo navegador)"; override val linkHttpSub = "https://t.me/proxy?… — abre o navegador"
    override val viaMtproto = "Proxy via MTProto"; override val viaMtprotoSub = "mesmo com VPN, o tráfego passa pelos proxies"
    override val directly = "Conectar diretamente"; override val directlySub = "com a VPN ativa — ignora os proxies, direto ao Telegram"
    override val notifications = "Notificações"
    override val scanCheck = "Varredura e verificação"
    override val scanCheckHelp = "• Varredura, min — com que frequência baixar as listas de proxies das assinaturas.\n" +
        "• Verificação, min — com que frequência reverificar os proxies do banco quanto à atividade.\n• Tamanho do lote — " +
        "quantos proxies verificar por execução.\n• Paralelo — quantas verificações rodar ao mesmo tempo (mais = " +
        "mais rápido, mas maior carga de rede e bateria)."
    override val scanMin = "Varredura, min"; override val checkMin = "Verificação, min"; override val batchSize = "Tamanho do lote"; override val parallel = "Paralelo"
    override val speedByNet = "Intensidade da varredura por rede"
    override val speedByNetHelp = "Com que frequência verificar os proxies dependendo da rede atual. " +
        "\"Padrão\" = intervalo base. Deslize para a direita para mais raro (mais lento, mais suave com tráfego/bateria), " +
        "para a esquerda para mais frequente (mais rápido, mais agressivo). Escala logarítmica, até ×100 em cada sentido.\n" +
        "• VPN — quando uma VPN externa está ativa.\n• Wi-Fi — em uma rede Wi-Fi.\n• LTE — em uma rede móvel."
    override val intensStandard = "padrão"
    override val intensSlower = "mais lento"
    override val intensFaster = "mais rápido"
    override val maintenance = "Redefinir dados"
    override val maintenanceHelp = "• \"Redefinir catálogo e estatísticas\" — zera avaliações, contadores, tráfego " +
        "e registros de verificação, mas mantém os hosts baixados e as assinaturas (tudo é reavaliado na " +
        "próxima varredura).\n• \"Limpar hosts baixados\" — exclui todo o conjunto de proxies, mas mantém as " +
        "assinaturas para que a varredura reabasteça o conjunto. As assinaturas nunca são tocadas de qualquer forma."
    override val backupTitle = "Exportar / Importar"
    override val backupHelp = "Salve ou restaure os dados do aplicativo como JSON. Marque o que " +
        "incluir — qualquer combinação:\n• Configurações — todos os parâmetros do aplicativo.\n• Assinaturas — a lista " +
        "de fontes (URL + ligar/desligar).\n• Catálogo de hosts ativos — cada proxy ativo com suas avaliações e estatísticas " +
        "POR modo de rede.\n\n\"Exportar\" abre uma página com o JSON pronto — copie-o ou salve em um arquivo. " +
        "\"Importar\" — cole o JSON (ou carregue um arquivo) e ele aplica apenas as seções marcadas presentes " +
        "nele. A importação ACRESCENTA aos dados atuais (sem apagar)."
    override val backupSettings = "Configurações"
    override val backupSubs = "Assinaturas"
    override val backupHosts = "Catálogo de hosts ativos (por modo)"
    override val exportWord = "Exportar"
    override val importWord = "Importar"
    override val backupExportTitle = "Exportar dados"
    override val backupImportTitle = "Importar dados"
    override val backupSelectExport = "O que exportar:"
    override val backupSelectImport = "O que importar:"
    override val backupCopyBtn = "Copiar"
    override val backupSaveFile = "Salvar em arquivo"
    override val backupLoadFile = "Carregar de arquivo"
    override val backupDoImport = "Importar"
    override val backupPasteLabel = "Cole aqui o JSON de backup"
    override val backupJsonLabel = "JSON de backup"
    override val backupAndroidFileNote = "Arquivos não estão disponíveis aqui — use Copiar / Colar."
    override val eraseAllHosts = "Apagar todos os hosts"
    override val factoryReset = "Redefinir tudo (como na primeira abertura)"
    override val factoryResetConfirm = "Redefinir totalmente o aplicativo ao estado de fábrica? TODAS as configurações e todo o " +
        "catálogo de hosts serão apagados, as assinaturas restauradas para os padrões. Como na primeira abertura."
    override val resetCatalog = "Redefinir catálogo e estatísticas"
    override val resetCatalogConfirm = "Zerar todas as avaliações, contadores e registros de verificação? " +
        "Os hosts baixados e as assinaturas são mantidos e reavaliados na próxima varredura."
    override val clearHosts = "Limpar hosts baixados"
    override val clearHostsConfirm = "Excluir toda a lista de hosts baixados (proxies)? " +
        "As assinaturas são mantidas e a varredura reabastecerá o conjunto."
    override val doReset = "Redefinir"
    override val doCancel = "Cancelar"
    override val adaptiveSpeed = "Velocidade adaptativa"
    override val adaptiveHelp = "As verificações de atividade rodam em um intervalo base (de \"Varredura e verificação\", também " +
        "multiplicado pelo multiplicador de rede). A \"Velocidade adaptativa\" as acelera ou desacelera " +
        "automaticamente com base em quantos proxies estão ativos no momento.\n\n" +
        "• POUCOS ativos (abaixo do limite \"Poucos\") → intervalo × \"Aceleração\". Um multiplicador abaixo de 1 = mais " +
        "frequente: 0,5 — duas vezes mais frequente, 0,25 — 4×. Reabastece o conjunto mais rápido.\n" +
        "• MUITOS ativos (acima do limite \"Muitos\") → intervalo × \"Desaceleração\". Acima de 1 = mais raro: 2 — " +
        "metade da frequência, 4 — um quarto. Economiza bateria e tráfego.\n" +
        "• Entre os limites — velocidade base (×1).\n\n" +
        "Exemplos:\n" +
        "— Reunir proxies mais rápido: \"Aceleração\" 0,25 e/ou limite \"Poucos\" 40.\n" +
        "— Economizar bateria quando tiver o suficiente: \"Desaceleração\" 8 e/ou limite \"Muitos\" 30.\n" +
        "— Desativar a adaptação: defina ambos os multiplicadores como 1.\n\n" +
        "Padrões: Poucos 20, Aceleração 0,5, Muitos 50, Desaceleração 4."
    override val threshMany = "Limite \"Muitos\""; override val threshFew = "Limite \"Poucos\""; override val mulFast = "Aceleração ×"; override val mulLazy = "Desaceleração ×"
    override val subIntensityTitle = "Intensidade das assinaturas"
    override val subIntensityHint = "Pausa entre downloads de assinaturas: quantos minutos antes de baixar novamente as listas de proxies (separadamente por modo de rede)."
    override val baseScanTitle = "Velocidade base da varredura"
    override val baseScanHelp = "A velocidade de referência da verificação de atividade. A \"Velocidade adaptativa\" e os multiplicadores de \"Velocidade " +
        "por modo\" são calculados em relação a ela.\n\n" +
        "• Com que frequência rodar, min — intervalo entre as passagens de verificação.\n" +
        "• Lote por thread, hosts — quantos hosts cada thread verifica por passagem.\n" +
        "• Threads — quantas verificações rodam ao mesmo tempo. Uma passagem sonda \"lote × threads\" hosts.\n" +
        "• Não reverificar um host com frequência maior que a cada N min — anti-flood: um host verificado recentemente é " +
        "ignorado nesta passagem.\n\n" +
        "Mais threads e um lote maior = crescimento mais rápido do conjunto, mas carga mais pesada na rede e na bateria."
    override val baseScanPeriod = "Com que frequência rodar, min"
    override val baseScanBatch = "Lote por thread, hosts"; override val baseScanThreads = "Número de threads"
    override val adaptiveDesc = "Se os proxies ativos forem menos que \"poucos\" ou mais que \"muitos\", aplica um multiplicador extra."
    override val fewWord = "Poucos"; override val manyWord = "Muitos"
    override fun fasterX(x: String) = "${x}× mais rápido"
    override fun slowerX(x: String) = "${x}× mais lento"
    override fun ifAliveLt(n: Int) = "Se proxies ativos < ${n}, então:"
    override fun ifAliveGt(n: Int) = "Se proxies ativos > ${n}, então:"
    override val disabledWord = "desligado"
    override val speedByModeTitle = "Velocidade por modo"
    override val speedByModeHelp = "Um multiplicador de velocidade de varredura para cada modo de rede, por cima da velocidade " +
        "base. \"Padrão\" (×1) = o intervalo base. Direita — mais raro (mais lento, mais suave com tráfego/" +
        "bateria), esquerda — mais frequente (mais rápido, mais agressivo). Escala logarítmica, até ×100 em cada " +
        "sentido.\n\n" +
        "Abaixo de cada controle estão os parâmetros de passagem resultantes com a velocidade adaptativa aplicada — " +
        "mostrados separadamente para \"poucos ativos\" (× \"Aceleração\") e \"muitos ativos\" (× \"Desaceleração\").\n\n" +
        "Modos:\n• VPN — uma VPN externa está ativa.\n• LTE — rede móvel.\n• Wi-Fi — rede Wi-Fi.\n" +
        "• Ethernet — conexão com fio.\n• Branco — modo de proxy \"branco\" manual."
    override val aliveLt = "ativos <"; override val aliveGt = "ativos >"
    override val periodWord = "período"; override val nonstopWord = "sem parar"
    override val batchWord = "lote"; override val threadsWord = "threads"; override val scanModeOff = "varredura desligada"
    override val netBattery = "Rede e bateria"
    override val netBatteryHelp = "• Somente Wi-Fi — não varrer em redes móveis (economiza dados).\n• Somente carregando " +
        "— trabalhar apenas enquanto o celular estiver carregando.\n• Pular com bateria baixa — pausar a varredura quando a " +
        "bateria estiver baixa."
    override val onlyWifi = "Somente Wi-Fi"; override val onlyCharging = "Somente carregando"; override val skipLowBattery = "Pular com bateria baixa"
    override val autosaved = "As configurações são salvas automaticamente."
    override val dpiAutoLabel = "Rotação automática de truques DPI"; override val dpiNoneLabel = "Sem truques DPI (simples)"
    override val experimental = "Experimental"
    override val experimentalHelp = "Motores de proxy alternativos ao upstream MTProto, além de um registro de diagnóstico. " +
        "O caminho de referência (que funciona) permanece inalterado quando definido como \"Desligado\". Muda apenas COMO o fluxo criptografado é escrito no " +
        "socket TCP de upstream (tamanhos de segmento, temporização, limites de registro TLS) — o fluxo em si permanece byte a byte idêntico. " +
        "Aplica-se apenas à retransmissão de proxy ativa (não às sondas, nem ao caminho direto)."
    override val expEngineTitle = "Motor de proxy (ofuscação de socket)"
    override val expConnectTitle = "Motor de conexão (seleção de upstream)"
    override val expEngineWarn = "⚠ Modo experimental. Se a conectividade piorar, volte para \"Desligado (caminho de referência)\"."
    override val netLog = "Ativar registro de troca de rede"
    override val netLogSub = "Grava QUEM-PARA-QUEM-QUANDO e tamanhos de pacote em um arquivo (SEM dados de payload) — " +
        "para comparar o padrão de troca com vs. sem uma VPN."
    override val openLogFolder = "Abrir pasta de registros"; override val copyPath = "Copiar caminho"
    override val helpShow = "Ajuda"; override val helpHide = "Ocultar ajuda"
    override val quickSwitchIntro = "Aqui você pode escolher um truque de contorno de bloqueio. Se o Telegram mostrar o erro " +
        "“The proxy you are using is not configured correctly and will be disabled. Please find another " +
        "one”, experimente qual tipo de ofuscação de tráfego funciona para que o Telegram pare de mostrá-lo. Comece " +
        "com os modos split*. Os modos coalesce* também funcionam, mas imagens/vídeos carregam mal no Telegram com eles."
    override val quickSwitchTitle ="Contorno de bloqueio"; override val quickSwitchSub = "Fragmentação, conexão, anti-DPI"

    override val sourceUrl = "URL da fonte"
    override fun sourceAlive(alive: Int, total: Int) = "ativos ${alive}/${total}"
    override val open = "Abrir"; override val active = "Ativo"; override val inactive = "Inativo"
    override val lastDownloaded = "Baixado"; override val notDownloaded = "ainda não baixado"
    override fun sourceCounts(dead: Int, total: Int) =
        " ativos, ${dead} inativos, ${total} total"

    override val proxyBase = "Banco de proxies"
    override val totalInBase = "Total no banco"; override val aliveNow = "Ativos agora"; override val deadStat = "Inativos"
    override val aliveIn15 = "Ativos em 15 min"; override val checksAllTime = "Verificações no total"
    override val antiDpiTricks = "Truques anti-DPI"; override val noStatsYet = "sem dados ainda — os truques acumulam conforme verificações/conexões acontecem"
    override val attempts = "Tentativas"; override val handshake = "Handshake"; override val score = "Pontuação"
    override val tgConnect = "Conexão TG"; override val socketsOver1m = "Sockets >1min"
    override val over10kb = "Sockets >10KB"; override val over100kb = ">100KB"; override val workTime = "Tempo de trabalho"
    override val statsLegend = "Handshake — handshakes bem-sucedidos (% das tentativas) · Pontuação — valor · " +
        "\"Tempo de trabalho\" — total em sockets ≥5KB e com duração maior que 1 minuto."
    override val resetStats = "Redefinir estatísticas dos truques"

    override fun aliveLinks(n: Int) = "Links ativos: ${n}"
    override val copyAll = "Copiar tudo"
    override val openRandom = "Abrir aleatório"; override val copyRandom = "Copiar aleatório"; override val allShort = "TODOS"
    override val copyTop = "Copiar TOP"; override val randomHost = "Host aleatório"
    override val exportToFile = "Exportar para arquivo"; override val exportSaved = "Salvo em arquivo:"
    override val dlNow = "Baixar agora"
    override fun downloadingFmt(sec: Long) = "Baixando… ${sec}s"
    override val cancel = "Cancelar"
    override val deleteConfirmTitle = "Excluir assinatura?"
    override val subscriptionsAddHint = "Adicione assinaturas ou links de proxy →"
    override val addSourcesTitle = "Adicionar"
    override val addSubsLabel = "Assinaturas (uma URL por linha)"
    override val addSubsHelp = "Cada linha com uma URL válida vira sua própria assinatura e é baixada periodicamente."
    override val addProxiesLabel = "Links de proxy prontos (lista fixa)"
    override val addProxiesHelp = "Cole um lote de links para proxies específicos (tg://proxy, https://t.me/proxy, …). Isto NÃO é uma assinatura — a lista nunca é baixada, os proxies são apenas adicionados ao catálogo."
    override val addButton = "Adicionar"
    override fun addedFmt(subs: Int, proxies: Int) = "Adicionados: ${subs} assinaturas, ${proxies} proxies"
    override val perSecond = "por seg"
    override val graphSpeed = "Velocidade"
    override val graphVolume = "Volume"
    override val graphLatency = "Ping"
    override val graphConnects = "Conexões"
    override val scanNow = "Varrer agora"; override val scanOnShort = "Varredura ligada"
    override val scanRunning = "Varredura em execução"; override val scanIdle = "Varredura ociosa"; override val scanOffState = "Varredura DESLIGADA"; override val scanBatchPerThread = "Lote/thread"; override val scanPassHosts = "Hosts na passagem"; override val minRescanLabel = "Não reverificar um host com frequência maior que a cada N min"
    override val scanPlanTitle = "Plano"; override val scanNowTitle = "Agora"; override val currentScheduleTitle = "Agenda atual"
    override val scheduleWord = "Agenda"; override val unitPcsPerSec = "un/s"
    override val scanNowThreadsLabel = "Threads rodando agora"; override val scanNowPerThreadLabel = "Verificações por thread (plano)"; override val scanNowElapsedLabel = "Tempo de execução"
    override val scanOkGraph = "Varreduras bem-sucedidas"; override val scanFailGraph = "Varreduras com falha"; override val scanTrafficGraph = "Tráfego de varredura"; override val scanAliveGraph = "Total de proxies ativos"; override val scanPingGraph = "Ping"; override val threadsGraph = "Threads"
    override val scanEvery = "A cada"; override val scanNextRun = "Próxima execução"
    override val scanThreads = "Threads"; override val scanBatch = "Lote"
    override val scanElapsed = "Em execução"; override val scanIdleNow = "—"
    override val effForFew = "Quando poucos"; override val effForMany = "Quando muitos"
    override val effCheck = "Verificação"; override val effBatch = "Lote"; override val effPar = "Paralelo"
    override val effContinuous = "contínuo"; override val secShort = "s"; override val minShort = "min"

    override val appTagline = "Conector automático multiplataforma: encontra, verifica e executa proxies MTProto " +
        "pelos quais o Telegram funciona."
    override val version = "Versão"; override val buildDate = "Data do build"
    override val downloadSources = "Download e fontes"; override val openOnGithub = "Abrir no GitHub"
    override val feedbackBugs = "Feedback e relatórios de bug"; override val writeTelegram = "Escrever no Telegram"

    override val language = "Idioma"; override val langAuto = "Automático (sistema)"; override val langRu = "Русский"; override val langEn = "English"
    override val langFa = "فارسی"; override val langZh = "简体中文"; override val langAr = "العربية"; override val langUr = "اردو"
    override val langTr = "Türkçe"; override val langId = "Bahasa Indonesia"; override val langHi = "हिन्दी"; override val langBn = "বাংলা"; override val langMy = "မြန်မာ"
    override val langWord = "Idioma"
    override val raceWidthTitle = "Conexões paralelas"
    override val connectionSection = "Conexão e contorno de bloqueio"
    override val connectionSectionHelp = "Motor de conexão, upstreams paralelos, motor de proxy e truques anti-DPI — tudo em uma seção."
    override val netLogSection = "Registro de troca de rede"
    override val platform = "Plataforma"

    override val scanModeTitle = "Modo de rede"; override val scanModeAuto = "Automático"; override val scanModeManualLabel = "Manual"
    override val activeModeLabel = "Modo ativo"; override val formingListLabel = "Montando lista"; override val catalogModeTabs = "Modo"
    override val resetModeRatings = "Redefinir avaliações dos hosts"; override val forgetModeHosts = "Esquecer hosts do modo"
    override val exportModeTitle = "Exportar por modo"; override val modePickerTitle = "Modo"
    override val modeHelp = "Cada modo de rede mantém suas próprias avaliações de proxy e sua própria intensidade de varredura + download de assinaturas. \"Automático\" escolhe o modo a partir da rede ativa. \"Manual\" permite que você escolha qualquer modo (incluindo Branco, que o automático nunca seleciona)."
    override val autoSelect = "Seleção automática"; override val manualSelect = "Seleção manual"
    override val connStatsTitle = "Conexões agora"; override val connOnPort = "Conexões na porta"; override val outgoingConns = "Conexões de saída"
    override val modeChoice = "Seleção de modo"; override val autoChoice = "seleção automática"; override val manualChoice = "fixo manual"
    override val directOnVpn = "Conexão direta ao TG com VPN"; override val onWord = "ligado"; override val offWord = "desligado"
    override val directStateActive = "ativo"; override val directStateOff = "desligado nas configurações"; override val directStateIdle = "ligado nas configurações, mas não ativo"
    override val wpHintTitle = "O que é o Branco?"
    override val wpHint = "Branco — WhitePages: um perfil de rede manual. Ativado somente à mão (a seleção automática nunca o escolhe). " +
        "Mantém suas próprias avaliações de hosts, baixa assinaturas e varre independentemente de VPN/Wi-Fi/LTE."

    override val recentAttempts = "Conexões e verificações recentes"
    override val kindCheck = "verificação"
    override val kindTg = "telegram"
    override val histWho = "Quem"
    override val histWhen = "Quando"
    override val histReq = "Requisição"
    override val histSess = "Sessão"
    override val histScan = "varredura"
    override val testNow = "Testar agora"
    override val testShort = "Teste"
    override val testResult = "Resultado do teste"
    override val testStop = "Parar"
    override val testingNow = "testando…"
    override val prewarmTitle = "Pré-aquecimento de sockets (experimental)"
    override val prewarmHelp = "Manter alguns sockets de proxy upstream conectados com antecedência para que uma " +
        "nova conexão do Telegram possa pular o connect/handshake. Experimental: o segundo plano fica " +
        "reconectando → gasta tráfego e um pouco de CPU. Nenhum tráfego falso é enviado (isso corromperia " +
        "a sessão real) — os sockets apenas são rotacionados. Mais útil com proxies FakeTLS."
    override val prewarmEnable = "Ativar pré-aquecimento"
    override val prewarmModeDeferred = "Adiado (somente TLS)"
    override val prewarmModeDeferredSub = "Mantemos TCP + FakeTLS; o init obfuscated2 é enviado na transferência. O DC não é fixado — o mais realista."
    override val prewarmModeFull = "Handshake completo"
    override val prewarmModeFullSub = "Mantemos sockets totalmente conectados em diferentes DCs; reutilizados apenas quando o DC/tag coincide. Vivem menos."
    override val prewarmPoolLabel = "Sockets de reserva"
    override val prewarmHoldLabel = "Manter cada, s"
    override val prewarmNote = "Somente rotação (sem keepalive no nível do aplicativo). Um socket vive de segundos a ~um minuto, dependendo do proxy/DC."
    override val prewarmStatus = "Pré-aquecimento"
    override fun prewarmStatusVal(ready: Int, holdSecs: Int) = "$ready prontos · mantendo ${holdSecs}s"
    override val prewarmStar = "Laranja em negrito = socket entregue quente do pool de pré-aquecimento (sem connect/handshake)"
    override fun prewarmTableTitle(holdSecs: Int) = "Pré-aquecimento de sockets (mantendo ${holdSecs}s)"
    override val prewarmTableHelp = "«Pré-aquecimento de sockets» abre alguns sockets de proxy com antecedência para que uma nova " +
        "conexão do Telegram possa pular o connect/handshake. Esta tabela lista os sockets em aquecimento: por quantos segundos " +
        "cada um vive, se o Telegram o está usando e o tráfego. Você pode ligar/desligar e configurar (modo, número de sockets, " +
        "tempo de retenção) em «Mais → Configurações → „Pré-aquecimento de sockets (experimental)“»."
    override val prewarmNoneWarming = "ainda não há sockets em aquecimento"
    override val prewarmColAge = "vive"
    override val prewarmColUse = "em TG?"
    override val prewarmInUse = "em TG"
    override val prewarmNew = "novo"
    override val lanShareTitle = "Compartilhar na rede local (portal web)"
    override val lanShareDesc = "Permitir que outros dispositivos neste Wi-Fi usem este AutoConnector como proxy; um navegador no endereço abaixo recebe uma página com os melhores proxies."
    override val lanShareUrlsLabel = "Vizinhos de rede se conectam em:"
    override val lanShareNoIp = "sem endereço na rede local — conecte-se ao Wi-Fi"
    override val lanFirewallTitle = "Permitir na rede local"
    override val lanFirewallBody = "Ao ativar, as portas de retransmissão se abrem para a rede local. Agora o firewall do Windows (ou outro) pode perguntar se deseja permitir o AutoConnector — escolha «Permitir»/«Sim». Se você negar, o tráfego dos vizinhos para o AutoConnector será bloqueado e a página/proxy ficarão inacessíveis."
    override val lanFirewallConfirm = "Ativar"
    override val lanInfoTitle = "Para que serve isto?"
    override val lanInfoBody = "Execute o AutoConnector em UM computador ou telefone no seu Wi-Fi — e todos os outros dispositivos na mesma rede, incluindo um iPhone (que o aplicativo não suporta diretamente), poderão simplesmente abrir o endereço em um navegador e usar: uma página com os melhores proxies para adicionar ao seu Telegram, ou este próprio dispositivo como um proxy SOCKS. Um dispositivo encontra e mantém os proxies, os demais o utilizam pela rede local."
    override val volTriggerTitle = "Gatilho por botões de volume"
    override val volTriggerSub = "Trocar de proxy com um padrão rápido de teclas de volume"
    override val volEnableLabel = "Observar os botões de volume"
    override val volHelpTitle = "O que é isto?"
    override val volHelpBody = "No Android não há atalhos de teclado globais, por isso usam-se os botões de VOLUME. Quando ativado, o AutoConnector observa em segundo plano um padrão rápido de pressionamentos de volume-cima/baixo (por exemplo cima-cima-baixo-baixo). Ao reconhecê-lo, ele abre um link tg:// de um proxy bom e ativo aleatório — o Telegram o intercepta e troca. Uma forma rápida e discreta de rotacionar o proxy sem abrir o aplicativo. O volume continua funcionando normalmente (os pressionamentos não são interceptados). É necessário o acesso de Acessibilidade (para ler as teclas de volume em segundo plano e abrir o link); nada é solicitado até você ativar a opção. Defina abaixo o tempo máximo entre os pressionamentos; os padrões reconhecidos estão listados no final."
    override val volGrantTitle = "Ative a Acessibilidade (importante)"
    override val volGrantBody = "O Android (especialmente 13+) bloqueia a Acessibilidade para aplicativos NÃO instalados pela Google Play — por isso o AutoConnector fica em cinza e diz «Configuração restrita» / «acesso não permitido».\n\nComo desbloquear:\n1. Abra «Informações do app» (botão abaixo, ou: Configurações → Aplicativos → AutoConnector for Telegram).\n2. Toque no menu ⋮ (canto superior direito) → «Permitir configurações restritas» → confirme.\n3. Volte: Configurações → Acessibilidade → AutoConnector for Telegram → ative.\n\nSe não houver a opção «Permitir configurações restritas» — primeiro tente ativar o interruptor na Acessibilidade uma vez (aparecerá a mensagem de bloqueio), depois o passo 2 ficará disponível.\n\nEm Xiaomi/MIUI, Samsung etc. o caminho pode variar um pouco — procure o mesmo ⋮ em «Informações do app». No Android 12 e anteriores normalmente não há restrição — ative diretamente.\n\nAs teclas de volume são apenas lidas, nunca bloqueadas."
    override val volOpenAppInfo = "Abrir «Informações do app»"
    override val volAccessOn = "Acessibilidade: ativada"
    override val volAccessOff = "Acessibilidade: desativada"
    override val volOpenAccess = "Abrir configurações de Acessibilidade"
    override val volGapLabel = "Máx. ms entre pressionamentos"
    override val volPatternsTitle = "Padrões reconhecidos"
    override val volPatternPick = "Padrão"
    override val volPatternsLegend = "↑ = volume para cima, ↓ = para baixo"
    override val volNoRights = "O aplicativo ainda NÃO tem permissão para processar os botões de volume — conceda o acesso seguindo as instruções no final da página."
    override val volGrantShort = "Ainda sem acesso de Acessibilidade. Leia as instruções detalhadas no final desta página e toque em «Verificar»."
    override val volCheck = "Verificar"
    override val volCheckOk = "✓ Pronto — acesso concedido, o gatilho funciona."
    override val volCheckFail = "✗ Ainda sem acesso — execute os passos acima."
    override val volPatternsList = "↑↑↓↓ · ↓↓↑↑ · ↑↓↑↓ · ↓↑↓↑ · ↑↑↑↑ · ↓↓↓↓ · ↑↓↓↑ · ↓↑↑↓ · ↑↑↑↓↓↓ · ↓↓↓↑↑↑   (↑ = volume para cima, ↓ = para baixo)"
    override val histLegend = "Colunas — Quem: ✓/✗ TG = conexão real do Telegram, varredura = verificação em segundo plano. Quando: há quanto tempo. TCP/TLS/Requisição: latência do handshake e da primeira requisição, ms. Sessão: quanto durou a sessão de retransmissão. ↓/↑: bytes recebidos / enviados pelo host."
    override val tgOkTotalHint = "Conexões do Telegram / bem-sucedidas / total de verificações"
    override val breadthTitle = "Amplitude da seleção de hosts"
    override val breadthHelp = "À esquerda — manter-se nos melhores hosts comprovados; à direita — tentar o mais amplamente possível entre todos os hosts ativos. Quando o Telegram fica alternando entre as portas de retransmissão, o aplicativo amplia a seleção automaticamente."
    override val breadthNarrow = "comprovados"
    override val breadthWide = "mais amplo"
    override val connTimeoutTitle = "Tempo limite de conexão por host"
    override val connTimeoutHelp = "Quanto esperar por um upstream (TCP + TLS + primeira resposta MTProto) antes de passar para o próximo proxy."
    override val factoryResetDone = "Tudo foi redefinido. Feche o aplicativo e abra novamente."
}
