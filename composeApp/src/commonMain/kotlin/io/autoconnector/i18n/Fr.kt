package io.autoconnector.i18n

object Fr : Strings {
    override val tabConnector = "Connecteur"; override val tabScan = "Scan"
    override val tabCatalog = "Catalogue"; override val tabLogs = "Journaux"; override val tabMore = "Plus"
    override val logTabTelegram = "Telegram"; override val logTabSubs = "Abonnements"; override val logTabScan = "Scan"
    override val logGeneral = "Général"; override val logEmpty = "vide pour l'instant"
    override val logSessions = "Sessions"; override val logErrorsOnly = "erreurs uniquement"; override val logNoErrors = "aucune session échouée"
    override fun logSession(id: String, port: String) = "#${id} · :${port}"
    override val back = "Retour"; override val copy = "Copier"; override val gotIt = "Compris"
    override val later = "Plus tard"; override val details = "Détails"; override val whatIsThis = "Qu'est-ce que c'est ?"
    override val delete = "Supprimer"

    override val connector = "Connecteur"; override val scan = "Scan"
    override val notConfigured = "Non configuré ! Corriger →"; override val howToSetup = "Comment configurer"
    override val notifOff = "Les notifications sont désactivées ! Corriger →"; override val enable = "Activer"
    override fun fewProxies(n: Int) = "Proxys actifs ${n}, recherche en cours, patientez ~15 min…"
    override fun alivePool(alive: Int, within: Int, total: Int) =
        "Proxys actifs : ${alive}  (15 min : ${within}) · total : ${total}"
    override val notifWhyTitle = "Pourquoi les notifications ?"
    override val notifWhyBody = "Une icône de notification persistante correspond à un service de premier plan Android. " +
        "Sans elle, le système décharge l'application de la mémoire et elle cesse de chercher des proxys et " +
        "de maintenir la connexion en arrière-plan. C'est pourquoi les notifications sont indispensables au " +
        "fonctionnement d'AutoConnector."
    override val notifEnableTitle = "Activer les notifications"
    override val notifEnableBody = "Sans icône de notification, Android considère l'application comme inactive et " +
        "la décharge de la mémoire. AutoConnector cesse alors de chercher des proxys et de maintenir la " +
        "connexion en arrière-plan — Telegram perd son lien.\n\nAppuyez sur \"Activer\" et autorisez les " +
        "notifications pour AutoConnector."
    override val notifPlea = "Activez les notifications ! Sans elles, l'application ne peut pas fonctionner en arrière-plan — " +
        "Android la déchargera et la recherche de proxys et la connexion s'arrêteront."

    override val statusConnected = "Telegram connecté"; override val statusConnecting = "Connexion…"
    override val statusOffline = "Telegram non connecté"; override val statusIdle = "Telegram en veille"
    override val nobodyConnected = "Personne n'est connecté au Connecteur. "; override val howToSetupArrow = "Comment configurer →"
    override val directModeViaVpn = "Mode direct : VPN actif — aucun proxy"
    override val directModeOff = "Mode direct : proxys désactivés"
    override val directDpiSuffix = " · anti-DPI"
    override val connections = "Connexions"; override val sockets = "Sockets"; override val speed = "Débit"
    override val traffic = "Trafic"; override val latency = "Latence"
    override fun pcs(n: Int) = "${n} pcs"
    override fun netNow(label: String) = "Réseau : ${label}"
    override fun tgToConnector(n: Int) = "TG→ ${n}"
    override fun connectorToProxy(n: Int) = "proxy ${n}"
    override val trafficSec = "trafic · 60 s"; override val trafficMin = "trafic · 60 min"
    override val latencySec = "latence · 60 s"; override val latencyMin = "latence · 60 min"
    override val sec60 = "60 s"; override val min60 = "60 min"
    override val unitSec = "s"; override val unitMin = "m"; override val unitHour = "h"; override val dash = "—"
    override val currentProxy = "Proxy actuel"; override val noActiveProxy = "aucun proxy actif (Telegram non connecté)"
    override val host = "Hôte"; override val type = "Type"; override val secret = "Secret"; override val antiDpi = "Anti-DPI"; override val obfEngine = "Moteur d'obfuscation"
    override fun activeSockets(n: Int) = "Sockets Telegram actifs : ${n}"
    override val noConnections = "aucune connexion active"; override val colHost = "Hôte"; override val colTime = "Durée"
    override val modeWord = "Mode"; override val directViaVpnLine = "Requêtes directes vers Telegram (VPN actif)"
    override val connModeHelp = "Les modes (VPN, Wi-Fi, LTE, Ethernet, White) permettent de régler différemment l'intensité du scan et de conserver des notations/statistiques d'hôtes distinctes. La carte réseau est détectée automatiquement ; le mode peut être défini manuellement dans les réglages."

    override val scanOff = "Le scan est désactivé"; override val proxiesInBase = "Proxys en base de données"
    override val total = "total"; override val alive = "actifs"; override val dead = "morts"
    override val tgConnectedTitle = "Telegram connecté via"; override val successful = "réussies"
    override val socketsHeld = "Durée de vie des sockets"; override val over1m = ">1 min"; override val over5m = ">5 min"; override val over15m = ">15 min"
    override val scanCountTitle = "Nombre de vérifications de proxys"; override val checked = "Vérifiés"
    override val forAllTime = "depuis le début"; override val perMinute = "par minute"; override val perHour = "par heure"
    override val subsCountTitle = "Nombre de téléchargements d'abonnements"; override val downloaded = "téléchargés"; override val failed = "échoués"; override val scanTraffic = "trafic de scan"; override val subTraffic = "trafic d'abonnement"; override val subTrafficGraph = "Trafic d'abonnement"
    override val checksMtproto = "Vérifications MTProto (↑ ok · ↓ échec)"

    override fun catalogEmpty(mode: String) = "Le catalogue ${mode} est vide pour l'instant. Soit aucun hôte n'a été trouvé, soit l'application n'a jamais fonctionné dans ce mode. Vous pouvez changer de mode dans les Réglages. Les modes existent pour collecter les hôtes séparément selon les différents types de connexion internet."
    override val aliveShort = "✓ actif"; override val deadShort = "✗ mort"
    override val statusLabel = "Statut"; override val rating = "Note"; override val port = "Port"
    override val rttPing = "RTT (ping)"; override val checkedField = "Vérifié"; override val okOfTotal = "Vérifications réussies / totales"
    override val tgConnectedField = "Telegram connecté"; override val tgSessions = "Sessions Telegram"; override val trafficThroughProxy = "Trafic via le proxy"
    override val sessionsTotal = "Total des sessions"; override val relayNow = "Relais actuel"; override val tlsDomain = "Domaine TLS (SNI)"
    override val sourceSub = "Source (abonnement)"; override val lastError = "Dernière erreur"; override val yes = "oui"; override val no = "non"
    override val copyAsLink = "Copier comme lien"; override val openInTelegram = "Ouvrir l'hôte dans Telegram"; override val makeNextRelay = "Définir comme prochain relais"
    override val actCopy = "Copier"; override val actOpen = "Ouvrir"; override val actRelay = "Relais"
    override fun agoFmt(v: String) = "il y a ${v}"
    override val catalogTopFor = "Liste/notation des proxys pour"
    override val catalogModeHelpTitle = "Modes et notations"
    override val catalogModeHelp = "L'application compte les hôtes actifs et leurs notations SÉPARÉMENT par mode réseau (VPN, Wi-Fi, LTE, Ethernet et White). \"White\" est un mode MANUEL distinct pour les listes blanches ; le mode auto ne le sélectionne jamais. Ainsi, un même hôte peut être actif dans un mode et mort dans un autre."
    override fun catalogInactiveWarn(section: String, active: String) =
        "Vous consultez la section inactive ${section} — toutes les statistiques actuelles vont vers ${active}, pas ici."
    override val manageModeTitle = "Gérer le mode"
    override val manageResetRating = "Réinitialiser la notation"
    override fun manageResetHint(mode: String) = "Pour ${mode} spécifiquement, vous pouvez réinitialiser la notation et les statistiques d'utilisation des hôtes actifs. C'est pratique quand vous vous êtes connecté à un VPN ou un LTE radicalement différent, pour que les anciennes statistiques n'interfèrent pas. Ou pour observer la vitesse à laquelle le scan revérifie tout depuis zéro."
    override val manageDeleteAll = "Supprimer les hôtes de"
    override fun manageDeleteHint(mode: String) = "Vous pouvez effacer à la fois la notation et les hôtes eux-mêmes de ${mode}. La fonction \"Scanner les proxys\" les rassemblera de nouveau. Ce n'est pas une réinitialisation des abonnements — vous pouvez appuyer dessus, puis attendre ~15 minutes pour un nouveau scan."
    override fun manageCopyFrom(mode: String) = "Copier tous les hôtes et notations vers ce mode (${mode}) depuis un autre mode :"
    override val live = "actifs"; override val deadW = "morts"; override val unitMs = "ms"
    override val agoMin = "min"; override val agoHour = "h"; override val agoDay = "j"

    override val connectTelegram = "Connexion de Telegram"; override val readCarefully = "Lisez attentivement !"
    override val guideIntro = "Cette application ne fonctionnera pas sans configuration. Choisissez l'une des 3 options ci-dessous " +
        "et suivez attentivement les instructions."
    override val variant1 = "Option n°1 — boutons"
    override val variant1Body = "Appuyez sur \"Proxy {A}\" — Telegram s'ouvre, confirmez l'ajout du proxy. Revenez " +
        "à cet écran et appuyez sur \"Proxy {B}\" — confirmez l'ajout une seconde fois.\n\nDésactivez tous les " +
        "autres anciens proxys dans Telegram. Il doit rester exactement 2 proxys — avec les ports {A} et {B}. " +
        "Avec tout autre ensemble, AutoConnector ne fonctionnera pas."
    override val variant2 = "Option n°2 — liens"
    override val variant2Body = "Copiez le texte ci-dessous dans les Messages enregistrés (ou tout autre chat) dans Telegram — " +
        "c'est-à-dire envoyez-le-vous à vous-même. Appuyez sur le premier lien de votre message — le premier proxy est ajouté. " +
        "Appuyez sur le second lien — le second est ajouté. Désactivez ensuite tous les anciens proxys."
    override val variant3 = "Option n°3 — manuellement"
    override val variant3Body = "Ajoutez manuellement un proxy SOCKS5 : serveur localhost (127.0.0.1), port {A}. " +
        "Puis un second proxy : localhost, port {B}. Supprimez tous les anciens proxys."
    override val whatNext = "Et ensuite ?"
    override val whatNextBody = "Dans Telegram, activez \"basculement automatique du proxy\" — 5 secondes. Vous pouvez aider " +
        "Telegram à se connecter en appuyant manuellement sur un proxy (dans Telegram) qui n'est PAS actif ou marqué " +
        "\"indisponible\" — cela pousse Telegram à essayer plus fort de se connecter.\n\nAssurez-vous que tous les autres anciens " +
        "proxys sont supprimés, sauf {A} et {B}. Appuyez sur " +
        "\"Utiliser le proxy\" dans Telegram.\n\nPatientez pendant que l'application trouve et télécharge suffisamment de proxys " +
        "(5–15 minutes). Telegram se connecte alors à AutoConnector de lui-même, qui continuera à acheminer " +
        "Telegram via les meilleurs proxys : vérifiés, actifs et rapides.\n\nSi les instructions vous semblent " +
        "difficiles — désolé, vous ne pourrez pas utiliser l'application : il est impossible de tout configurer " +
        "automatiquement, et trouver des proxys actifs prend du temps.\n\nSi vous avez téléchargé l'application il y a longtemps " +
        "et qu'aucun proxy actif n'a été trouvé — mettez à jour soit l'application, soit la liste des abonnements. Cette application " +
        "n'invente ni ne fournit ses propres proxys, elle ne fait que chercher sur internet à travers des dizaines de " +
        "groupes et de pages."
    override fun proxyBtn(port: Int) = "Proxy ${port}"

    override val setupPortsTitle = "Configurer les ports dans Telegram"
    override val setupPortsSub = "Comment connecter Telegram au Connecteur (ports 55001/55002)"
    override val settings = "Réglages"; override val settingsSub = "Ports, anti-DPI, scan, réseau, batterie"
    override val subscriptions = "Abonnements"; override val subscriptionsSub = "Sources de proxys à scanner"
    override val statistics = "Statistiques"; override val statisticsSub = "Base de données de proxys + astuces anti-DPI"
    override val export = "Exporter"; override val exportSub = "liens tg:// des proxys actifs"
    override val about = "À propos"; override val aboutSub = "Version, build, téléchargement, retours"
    override val hotkeys = "Raccourcis clavier"
    override val hotkeysSub = "Touches globales : copier / ouvrir un proxy"
    override val hotkeysIntro = "Les raccourcis clavier globaux fonctionnent même lorsque la fenêtre de l'application n'est pas active. Ils choisissent un " +
        "lien de proxy actif aléatoire (tg://) dans le pool — pratique pour changer rapidement de proxy sans " +
        "ouvrir l'application."
    override val hotkeysNote = "Sur macOS, la capture des touches peut nécessiter l'autorisation d'Accessibilité " +
        "(Réglages Système → Confidentialité et sécurité → Accessibilité)."
    override val hotkeyCopyTitle = "Copier le lien du proxy"
    override val hotkeyCopyDesc = "Place un lien tg:// actif aléatoire dans le presse-papiers."
    override val hotkeyEnable = "Activer les raccourcis clavier"; override val hotkeyLetterLabel = "Lettre"; override val hotkeySet = "Définir"; override val hotkeyReset = "Réinitialiser"
    override val hotkeyOpenTitle = "Ouvrir le proxy dans Telegram"
    override val hotkeyOpenDesc = "Ouvre un lien actif aléatoire — Telegram le récupère et propose de connecter le proxy."

    override val relayPorts = "Ports de relais"
    override val relayPortsHelp = "Ports locaux sur lesquels le Connecteur écoute. Vous saisissez exactement ces ports dans " +
        "Telegram comme proxy SOCKS5 (127.0.0.1 : port). Deux ports sont utilisés pour la fiabilité — Telegram " +
        "maintient des connexions vers les deux."
    override val portA = "Port A"; override val portB = "Port B"
    override val antiDpiTrick = "Astuce anti-DPI"
    override val antiDpiHelp = "Une façon de déguiser la connexion pour que le FAI/DPI ne la reconnaisse pas et ne la " +
        "bloque pas.\n• \"Rotation auto\" choisit elle-même une astuce qui fonctionne.\n• \"Aucune astuce DPI\" — une simple " +
        "connexion.\n• Les autres sont des techniques spécifiques (mimétisme de navigateur, fragmentation de paquets, etc.)."
    override val onlyFakeTls = "FakeTLS uniquement (ee)"
    override val applyDpiTo = "Appliquer l'anti-DPI à"
    override val applyDpiHelp = "À quoi appliquer l'astuce anti-DPI choisie :\n• Relais Telegram — à la " +
        "connexion Telegram active via le Connecteur.\n• Sondes de proxy — aux vérifications de proxy en arrière-plan " +
        "(la vérification se comporte alors exactement comme une vraie connexion, et les statistiques d'astuces sont plus précises).\n" +
        "• En connexion directe — quand les proxys sont désactivés (ou ignorés pendant qu'un VPN est actif) et que Telegram " +
        "va directement vers ses serveurs : il n'y a pas de proxy ici, donc l'astuce se réduit à fragmenter le " +
        "premier paquet TCP (le handshake) en plusieurs petits segments pour que le DPI ne puisse pas le reconnaître en une seule lecture."
    override val toRelay = "Relais Telegram"; override val toProbes = "Sondes de proxy"
    override val toDirect = "En connexion directe"
    override val vpnSection = "Quand le VPN est actif"
    override val vpnHelp = "Que faire quand un VPN est actif sur l'appareil :\n• Via proxy MTProto — " +
        "Telegram passe par les proxys trouvés comme d'habitude (par-dessus le VPN).\n• Directement — le " +
        "Connecteur n'utilise PAS de proxys et connecte Telegram directement aux serveurs de Telegram : le " +
        "VPN fournit déjà l'accès, la couche proxy supplémentaire n'est pas nécessaire (plus rapide et plus stable). " +
        "Sans VPN, les proxys sont utilisés comme d'habitude."
    override val linkFormat = "Format du lien de proxy"
    override val linkFormatHelp = "Comment copier et ouvrir les proxys. tg:// ouvre Telegram directement (nécessite Telegram Desktop installé). http (t.me) ouvre via le navigateur et propose d'ouvrir dans Telegram — pratique si tg:// n'est pas enregistré."
    override val linkTg = "tg:// (ouvrir Telegram directement)"; override val linkTgSub = "tg://proxy?… — ouvre Telegram"
    override val linkHttp = "http (t.me, via navigateur)"; override val linkHttpSub = "https://t.me/proxy?… — ouvre le navigateur"
    override val viaMtproto = "Proxy via MTProto"; override val viaMtprotoSub = "même avec VPN, le trafic passe par les proxys"
    override val directly = "Connexion directe"; override val directlySub = "avec VPN actif — contourner les proxys, directement vers Telegram"
    override val notifications = "Notifications"
    override val scanCheck = "Scan et vérification"
    override val scanCheckHelp = "• Scan, min — à quelle fréquence télécharger les listes de proxys depuis les abonnements.\n" +
        "• Vérification, min — à quelle fréquence revérifier l'activité des proxys en base de données.\n• Taille du lot — " +
        "combien de proxys vérifier par passe.\n• Parallèle — combien de vérifications lancer à la fois (plus = " +
        "plus rapide, mais charge réseau et batterie plus élevée)."
    override val scanMin = "Scan, min"; override val checkMin = "Vérification, min"; override val batchSize = "Taille du lot"; override val parallel = "Parallèle"
    override val speedByNet = "Intensité du scan par réseau"
    override val speedByNetHelp = "À quelle fréquence vérifier les proxys selon le réseau actuel. " +
        "\"Standard\" = intervalle de base. Glissez vers la droite pour plus rare (plus lent, plus économe en trafic/batterie), " +
        "vers la gauche pour plus fréquent (plus rapide, plus agressif). Échelle logarithmique, jusqu'à ×100 dans chaque sens.\n" +
        "• VPN — quand un VPN externe est actif.\n• Wi-Fi — sur un réseau Wi-Fi.\n• LTE — sur un réseau mobile."
    override val intensStandard = "standard"
    override val intensSlower = "plus lent"
    override val intensFaster = "plus rapide"
    override val maintenance = "Réinitialiser les données"
    override val maintenanceHelp = "• \"Réinitialiser le catalogue et les statistiques\" — remet à zéro les notations, compteurs, trafic " +
        "et journaux de vérification, mais conserve les hôtes téléchargés et les abonnements (tout est renoté au " +
        "prochain scan).\n• \"Effacer les hôtes téléchargés\" — supprime tout le pool de proxys mais conserve les " +
        "abonnements pour que le scan remplisse de nouveau le pool. Les abonnements ne sont jamais touchés dans les deux cas."
    override val backupTitle = "Exporter / Importer"
    override val backupHelp = "Sauvegardez ou restaurez les données de l'application au format JSON. Cochez ce qu'il faut " +
        "inclure — toute combinaison :\n• Réglages — tous les paramètres de l'application.\n• Abonnements — la liste " +
        "des sources (URL + activé/désactivé).\n• Catalogue d'hôtes actifs — chaque proxy actif avec ses notations et statistiques " +
        "PAR mode réseau.\n\n\"Exporter\" ouvre une page avec le JSON prêt — copiez-le ou enregistrez-le dans un fichier. " +
        "\"Importer\" — collez le JSON (ou chargez un fichier) et il applique uniquement les sections cochées qui y sont présentes. " +
        "L'import AJOUTE aux données actuelles (sans effacement)."
    override val backupSettings = "Réglages"
    override val backupSubs = "Abonnements"
    override val backupHosts = "Catalogue d'hôtes actifs (par mode)"
    override val exportWord = "Exporter"
    override val importWord = "Importer"
    override val backupExportTitle = "Exporter les données"
    override val backupImportTitle = "Importer les données"
    override val backupSelectExport = "Que faut-il exporter :"
    override val backupSelectImport = "Que faut-il importer :"
    override val backupCopyBtn = "Copier"
    override val backupSaveFile = "Enregistrer dans un fichier"
    override val backupLoadFile = "Charger depuis un fichier"
    override val backupDoImport = "Importer"
    override val backupPasteLabel = "Collez le JSON de sauvegarde ici"
    override val backupJsonLabel = "JSON de sauvegarde"
    override val backupAndroidFileNote = "Les fichiers ne sont pas disponibles ici — utilisez Copier / Coller."
    override val eraseAllHosts = "Effacer tous les hôtes"
    override val factoryReset = "Tout réinitialiser (comme au premier lancement)"
    override val factoryResetConfirm = "Réinitialiser entièrement l'application à son état d'usine ? TOUS les réglages et tout le " +
        "catalogue d'hôtes seront effacés, les abonnements rétablis par défaut. Exactement comme un premier lancement."
    override val resetCatalog = "Réinitialiser le catalogue et les statistiques"
    override val resetCatalogConfirm = "Remettre à zéro toutes les notations, compteurs et journaux de vérification ? " +
        "Les hôtes téléchargés et les abonnements sont conservés et renotés au prochain scan."
    override val clearHosts = "Effacer les hôtes téléchargés"
    override val clearHostsConfirm = "Supprimer toute la liste des hôtes (proxys) téléchargés ? " +
        "Les abonnements sont conservés et le scan remplira de nouveau le pool."
    override val doReset = "Réinitialiser"
    override val doCancel = "Annuler"
    override val adaptiveSpeed = "Vitesse adaptative"
    override val adaptiveHelp = "Les vérifications d'activité s'exécutent à un intervalle de base (depuis \"Scan et vérification\", aussi " +
        "multiplié par le multiplicateur réseau). \"Vitesse adaptative\" les accélère ou les ralentit " +
        "automatiquement selon le nombre de proxys actuellement actifs.\n\n" +
        "• PEU d'actifs (sous le seuil \"Peu\") → intervalle × \"Accélération\". Un multiplicateur inférieur à 1 = plus " +
        "fréquent : 0.5 — deux fois plus souvent, 0.25 — 4×. Remplit le pool plus vite.\n" +
        "• BEAUCOUP d'actifs (au-dessus du seuil \"Beaucoup\") → intervalle × \"Ralentissement\". Au-dessus de 1 = plus rare : 2 — " +
        "deux fois moins souvent, 4 — un quart. Économise la batterie et le trafic.\n" +
        "• Entre les seuils — vitesse de base (×1).\n\n" +
        "Exemples :\n" +
        "— Rassembler les proxys plus vite : \"Accélération\" 0.25 et/ou seuil \"Peu\" 40.\n" +
        "— Économiser la batterie quand vous en avez assez : \"Ralentissement\" 8 et/ou seuil \"Beaucoup\" 30.\n" +
        "— Désactiver l'adaptation : réglez les deux multiplicateurs sur 1.\n\n" +
        "Valeurs par défaut : Peu 20, Accélération 0.5, Beaucoup 50, Ralentissement 4."
    override val threshMany = "Seuil \"Beaucoup\""; override val threshFew = "Seuil \"Peu\""; override val mulFast = "Accélération ×"; override val mulLazy = "Ralentissement ×"
    override val subIntensityTitle = "Intensité des abonnements"
    override val subIntensityHint = "Pause entre les téléchargements d'abonnements : combien de minutes avant de retélécharger les listes de proxys (séparément par mode réseau)."
    override val baseScanTitle = "Vitesse de scan de base"
    override val baseScanHelp = "La vitesse de référence des vérifications d'activité. \"Vitesse adaptative\" et les multiplicateurs \"Vitesse par " +
        "mode\" sont calculés par rapport à elle.\n\n" +
        "• Fréquence d'exécution, min — intervalle entre les passes de vérification.\n" +
        "• Lot par thread, hôtes — combien d'hôtes chaque thread vérifie par passe.\n" +
        "• Threads — combien de vérifications s'exécutent à la fois. Une passe sonde \"lot × threads\" hôtes.\n" +
        "• Ne pas rescanner un hôte plus souvent que toutes les N min — anti-flood : un hôte récemment vérifié est " +
        "ignoré lors de cette passe.\n\n" +
        "Plus de threads et un lot plus grand = croissance du pool plus rapide, mais charge plus lourde sur le réseau et la batterie."
    override val baseScanPeriod = "Fréquence d'exécution, min"
    override val baseScanBatch = "Lot par thread, hôtes"; override val baseScanThreads = "Nombre de threads"
    override val adaptiveDesc = "Si les proxys actifs sont moins que \"peu\" ou plus que \"beaucoup\", appliquer un multiplicateur supplémentaire."
    override val fewWord = "Peu"; override val manyWord = "Beaucoup"
    override fun fasterX(x: String) = "${x}× plus rapide"
    override fun slowerX(x: String) = "${x}× plus lent"
    override fun ifAliveLt(n: Int) = "Si proxys actifs < ${n}, alors :"
    override fun ifAliveGt(n: Int) = "Si proxys actifs > ${n}, alors :"
    override val disabledWord = "désactivé"
    override val speedByModeTitle = "Vitesse par mode"
    override val speedByModeHelp = "Un multiplicateur de vitesse de scan pour chaque mode réseau, par-dessus la vitesse " +
        "de base. \"Standard\" (×1) = l'intervalle de base. Droite — plus rare (plus lent, plus économe en trafic/" +
        "batterie), gauche — plus fréquent (plus rapide, plus agressif). Échelle logarithmique, jusqu'à ×100 dans chaque " +
        "sens.\n\n" +
        "Sous chaque curseur figurent les paramètres de passe résultants avec la vitesse adaptative appliquée — " +
        "affichés séparément pour \"peu d'actifs\" (× \"Accélération\") et \"beaucoup d'actifs\" (× \"Ralentissement\").\n\n" +
        "Modes :\n• VPN — un VPN externe est actif.\n• LTE — réseau mobile.\n• Wi-Fi — réseau Wi-Fi.\n" +
        "• Ethernet — connexion filaire.\n• White — mode proxy \"white\" manuel."
    override val aliveLt = "actifs <"; override val aliveGt = "actifs >"
    override val periodWord = "période"; override val nonstopWord = "sans arrêt"
    override val batchWord = "lot"; override val threadsWord = "threads"; override val scanModeOff = "scan désactivé"
    override val netBattery = "Réseau et batterie"
    override val netBatteryHelp = "• Wi-Fi uniquement — ne pas scanner sur les réseaux mobiles (économise les données).\n• En charge " +
        "uniquement — fonctionner seulement pendant que le téléphone est en charge.\n• Ignorer si batterie faible — suspendre le scan quand la " +
        "batterie est faible."
    override val onlyWifi = "Wi-Fi uniquement"; override val onlyCharging = "En charge uniquement"; override val skipLowBattery = "Ignorer si batterie faible"
    override val autosaved = "Les réglages sont enregistrés automatiquement."
    override val dpiAutoLabel = "Rotation auto des astuces DPI"; override val dpiNoneLabel = "Aucune astuce DPI (simple)"
    override val experimental = "Expérimental"
    override val experimentalHelp = "Moteurs de proxy alternatifs à l'upstream MTProto plus un journal de diagnostic. " +
        "Le chemin de référence (qui fonctionne) reste inchangé lorsqu'il est réglé sur \"Désactivé\". Seule CHANGE la FAÇON dont le flux chiffré est écrit vers " +
        "le socket TCP upstream (tailles de segments, timing, limites des enregistrements TLS) — le flux lui-même reste identique octet par octet. " +
        "S'applique uniquement au relais de proxy actif (ni aux sondes, ni au chemin direct)."
    override val expEngineTitle = "Moteur de proxy (obfuscation de socket)"
    override val expConnectTitle = "Moteur de connexion (sélection de l'upstream)"
    override val expEngineWarn = "⚠ Mode expérimental. Si la connectivité se dégrade, revenez à \"Désactivé (chemin de référence)\"."
    override val netLog = "Activer le journal d'échanges réseau"
    override val netLogSub = "Écrit QUI-À-QUI-QUAND et les tailles de paquets dans un fichier (AUCUNE donnée de charge utile) — " +
        "pour comparer le schéma d'échange avec et sans VPN."
    override val openLogFolder = "Ouvrir le dossier de journaux"; override val copyPath = "Copier le chemin"
    override val helpShow = "Aide"; override val helpHide = "Masquer l'aide"
    override val quickSwitchIntro = "Ici, vous pouvez choisir une astuce de contournement de blocage. Si Telegram affiche l'erreur " +
        "« Le proxy que vous utilisez n'est pas configuré correctement et sera désactivé. Veuillez en trouver un " +
        "autre », expérimentez avec le type d'obfuscation de trafic qui fonctionne pour que Telegram cesse de l'afficher. Commencez " +
        "par les modes split*. Les modes coalesce* fonctionnent aussi, mais les images/vidéos se chargent mal dans Telegram avec eux."
    override val quickSwitchTitle ="Contournement de blocage"; override val quickSwitchSub = "Fragmentation, connexion, anti-DPI"

    override val sourceUrl = "URL de la source"
    override fun sourceAlive(alive: Int, total: Int) = "actifs ${alive}/${total}"
    override val open = "Ouvrir"; override val active = "Actif"; override val inactive = "Inactif"
    override val lastDownloaded = "Téléchargé"; override val notDownloaded = "pas encore téléchargé"
    override fun sourceCounts(dead: Int, total: Int) =
        " actifs, ${dead} morts, ${total} au total"

    override val proxyBase = "Base de données de proxys"
    override val totalInBase = "Total en base de données"; override val aliveNow = "Actifs maintenant"; override val deadStat = "Morts"
    override val aliveIn15 = "Actifs en 15 min"; override val checksAllTime = "Vérifications depuis le début"
    override val antiDpiTricks = "Astuces anti-DPI"; override val noStatsYet = "pas encore de données — les astuces s'accumulent au fil des vérifications/connexions"
    override val attempts = "Tentatives"; override val handshake = "Handshake"; override val score = "Score"
    override val tgConnect = "Connexion TG"; override val socketsOver1m = "Sockets >1min"
    override val over10kb = "Sockets >10Ko"; override val over100kb = ">100Ko"; override val workTime = "Temps de travail"
    override val statsLegend = "Handshake — handshakes réussis (% des tentatives) · Score — valeur · " +
        "\"Temps de travail\" — total sur les sockets ≥5Ko et durant plus d'une minute."
    override val resetStats = "Réinitialiser les statistiques d'astuces"

    override fun aliveLinks(n: Int) = "Liens actifs : ${n}"
    override val copyAll = "Tout copier"
    override val openRandom = "Ouvrir aléatoire"; override val copyRandom = "Copier aléatoire"; override val allShort = "TOUT"
    override val copyTop = "Copier le TOP"; override val randomHost = "Hôte aléatoire"
    override val exportToFile = "Exporter dans un fichier"; override val exportSaved = "Enregistré dans le fichier :"
    override val dlNow = "Télécharger maintenant"
    override fun downloadingFmt(sec: Long) = "Téléchargement… ${sec}s"
    override val cancel = "Annuler"
    override val deleteConfirmTitle = "Supprimer l'abonnement ?"
    override val subscriptionsAddHint = "Ajoutez des abonnements ou des liens de proxy →"
    override val addSourcesTitle = "Ajouter"
    override val addSubsLabel = "Abonnements (une URL par ligne)"
    override val addSubsHelp = "Chaque ligne avec une URL valide devient son propre abonnement et est récupérée périodiquement."
    override val addProxiesLabel = "Liens de proxys prêts (liste fixe)"
    override val addProxiesHelp = "Collez un lot de liens vers des proxys spécifiques (tg://proxy, https://t.me/proxy, …). Ce n'est PAS un abonnement — la liste n'est jamais téléchargée, les proxys sont simplement ajoutés au catalogue."
    override val addButton = "Ajouter"
    override fun addedFmt(subs: Int, proxies: Int) = "Ajoutés : ${subs} abonnements, ${proxies} proxys"
    override val perSecond = "par s"
    override val graphSpeed = "Débit"
    override val graphVolume = "Volume"
    override val graphLatency = "Ping"
    override val graphConnects = "Connexions"
    override val scanNow = "Scanner maintenant"; override val scanOnShort = "Scan activé"
    override val scanRunning = "Scan en cours"; override val scanIdle = "Scan en veille"; override val scanOffState = "Scan DÉSACTIVÉ"; override val scanBatchPerThread = "Lot/thread"; override val scanPassHosts = "Hôtes par passe"; override val minRescanLabel = "Ne pas rescanner un hôte plus souvent que toutes les N min"
    override val scanPlanTitle = "Plan"; override val scanNowTitle = "Maintenant"; override val currentScheduleTitle = "Planning actuel"
    override val scheduleWord = "Planning"; override val unitPcsPerSec = "pcs/s"
    override val scanNowThreadsLabel = "Threads en cours"; override val scanNowPerThreadLabel = "Vérifications par thread (plan)"; override val scanNowElapsedLabel = "Temps d'exécution"
    override val scanOkGraph = "Scans réussis"; override val scanFailGraph = "Scans échoués"; override val scanTrafficGraph = "Trafic de scan"; override val scanAliveGraph = "Total des proxys actifs"; override val scanPingGraph = "Ping"; override val threadsGraph = "Threads"
    override val scanEvery = "Toutes les"; override val scanNextRun = "Prochaine exécution"
    override val scanThreads = "Threads"; override val scanBatch = "Lot"
    override val scanElapsed = "En cours"; override val scanIdleNow = "—"
    override val effForFew = "Quand peu"; override val effForMany = "Quand beaucoup"
    override val effCheck = "Vérifier"; override val effBatch = "Lot"; override val effPar = "Parallèle"
    override val effContinuous = "continu"; override val secShort = "s"; override val minShort = "min"

    override val appTagline = "Auto-connecteur multiplateforme : il trouve, vérifie et exécute des proxys MTProto " +
        "via lesquels Telegram fonctionne."
    override val version = "Version"; override val buildDate = "Date de build"
    override val downloadSources = "Téléchargement et sources"; override val openOnGithub = "Ouvrir sur GitHub"
    override val feedbackBugs = "Retours et rapports de bugs"; override val writeTelegram = "Écrire sur Telegram"

    override val language = "Langue"; override val langAuto = "Auto (système)"; override val langRu = "Русский"; override val langEn = "English"
    override val langFa = "فارسی"; override val langZh = "简体中文"; override val langAr = "العربية"; override val langUr = "اردو"
    override val langTr = "Türkçe"; override val langId = "Bahasa Indonesia"; override val langHi = "हिन्दी"; override val langBn = "বাংলা"; override val langMy = "မြန်မာ"
    override val langWord = "Langue"
    override val raceWidthTitle = "Connexions parallèles"
    override val connectionSection = "Connexion et contournement de blocage"
    override val connectionSectionHelp = "Moteur de connexion, upstreams parallèles, moteur de proxy et astuces anti-DPI — le tout dans une seule section."
    override val netLogSection = "Journal d'échanges réseau"
    override val platform = "Plateforme"

    override val scanModeTitle = "Mode réseau"; override val scanModeAuto = "Auto"; override val scanModeManualLabel = "Manuel"
    override val activeModeLabel = "Mode actif"; override val formingListLabel = "Constitution de la liste"; override val catalogModeTabs = "Mode"
    override val resetModeRatings = "Réinitialiser les notations des hôtes"; override val forgetModeHosts = "Oublier les hôtes du mode"
    override val exportModeTitle = "Exporter par mode"; override val modePickerTitle = "Mode"
    override val modeHelp = "Chaque mode réseau conserve ses propres notations de proxys et sa propre intensité de scan + téléchargement d'abonnements. \"Auto\" choisit le mode selon le réseau actif. \"Manuel\" vous laisse choisir vous-même n'importe quel mode (y compris White, que le mode auto ne sélectionne jamais)."
    override val autoSelect = "Sélection auto"; override val manualSelect = "Sélection manuelle"
    override val connStatsTitle = "Connexions maintenant"; override val connOnPort = "Connexions sur le port"; override val outgoingConns = "Connexions sortantes"
    override val modeChoice = "Sélection du mode"; override val autoChoice = "sélection auto"; override val manualChoice = "fixé manuellement"
    override val directOnVpn = "Connexion directe à TG sur VPN"; override val onWord = "activé"; override val offWord = "désactivé"
    override val directStateActive = "actif"; override val directStateOff = "désactivé dans les réglages"; override val directStateIdle = "activé dans les réglages, mais pas actif"
    override val wpHintTitle = "Qu'est-ce que White ?"
    override val wpHint = "White — WhitePages : un profil réseau manuel. Activé uniquement à la main (la sélection auto ne le choisit jamais). " +
        "Conserve ses propres notations d'hôtes, télécharge les abonnements et scanne indépendamment du VPN/Wi-Fi/LTE."

    // host detail history + selection sliders
    override val recentAttempts = "Connexions et vérifications récentes"
    override val kindCheck = "vérification"
    override val kindTg = "telegram"
    override val histWho = "Qui"
    override val histWhen = "Quand"
    override val histReq = "Req"
    override val histSess = "Session"
    override val histScan = "scan"
    override val testNow = "Tester maintenant"
    override val testShort = "Test"
    override val testResult = "Résultat du test"
    override val testStop = "Arrêter"
    override val testingNow = "test en cours…"

    // pre-warm standby sockets
    override val prewarmTitle = "Préchauffage des sockets (expérimental)"
    override val prewarmHelp = "Garder à l'avance quelques sockets de proxy upstream connectés pour qu'une " +
        "nouvelle connexion Telegram puisse sauter le connect/handshake. Expérimental : il se reconnecte sans " +
        "cesse en arrière-plan, donc il consomme du trafic et un peu de CPU. Aucun trafic factice n'est envoyé " +
        "(cela corromprait la vraie session) — les sockets sont simplement renouvelés. Surtout utile avec les proxys FakeTLS."
    override val prewarmEnable = "Activer le préchauffage"
    override val prewarmModeDeferred = "Différé (TLS uniquement)"
    override val prewarmModeDeferredSub = "Garder TCP + FakeTLS ; l'init est terminée au moment du passage. Aucun DC engagé — le plus réaliste."
    override val prewarmModeFull = "Handshake complet"
    override val prewarmModeFullSub = "Garder des sockets entièrement connectés sur plusieurs DC ; réutilisés uniquement en cas de correspondance DC/tag. Durée de vie plus courte."
    override val prewarmPoolLabel = "Sockets en réserve"
    override val prewarmHoldLabel = "Garder chacun, s"
    override val prewarmNote = "Rotation uniquement (pas de keepalive au niveau de l'application). Un socket dure de quelques secondes à ~une minute selon le proxy/DC."
    override val prewarmStatus = "Préchauffage"
    override fun prewarmStatusVal(ready: Int, holdSecs: Int) = "${ready} prêts · garde ${holdSecs}s"
    override val prewarmStar = "Orange gras = socket remis tiède depuis le pool de préchauffage (connect/handshake évité)"
    override fun prewarmTableTitle(holdSecs: Int) = "Préchauffage des sockets (garde ${holdSecs}s)"
    override val prewarmTableHelp = "« Préchauffage des sockets » ouvre à l'avance quelques sockets de proxy pour qu'une " +
        "nouvelle connexion Telegram puisse sauter le connect/handshake. Ce tableau liste les sockets en cours de " +
        "préchauffage : depuis combien de temps chacun vit, si Telegram l'utilise, et le trafic. Activez/désactivez et " +
        "configurez (mode, nombre de sockets, durée de maintien) dans Plus → Réglages → « Préchauffage des sockets (expérimental) »."
    override val prewarmNoneWarming = "aucun socket en préchauffage pour l'instant"
    override val prewarmColAge = "âge"
    override val prewarmColUse = "dans TG ?"
    override val prewarmInUse = "dans TG"
    override val prewarmNew = "nouveau"

    // LAN sharing / web portal
    override val lanShareTitle = "Partage sur le réseau local (portail web)"
    override val lanShareDesc = "Permettre aux autres appareils de ce Wi-Fi d'utiliser cet AutoConnector comme proxy ; un navigateur ouvrant l'adresse ci-dessous obtient une page des meilleurs proxys."
    override val lanShareUrlsLabel = "Les voisins du réseau se connectent à :"
    override val lanShareNoIp = "aucune adresse sur le réseau local — connectez-vous au Wi-Fi"
    override val lanFirewallTitle = "Autoriser sur le réseau local"
    override val lanFirewallBody = "Activer ceci ouvre les ports de relais à votre réseau local. Le pare-feu Windows (ou un autre) peut maintenant demander s'il faut autoriser AutoConnector — choisissez Autoriser / Oui. Si vous refusez, le trafic des voisins vers AutoConnector sera bloqué et la page/le proxy seront inaccessibles."
    override val lanFirewallConfirm = "Activer"
    override val lanInfoTitle = "À quoi ça sert ?"
    override val lanInfoBody = "Lancez AutoConnector sur UN seul ordinateur ou téléphone de votre Wi-Fi, et tous les autres appareils du même réseau — y compris un iPhone, que cette application ne prend pas en charge directement — peuvent simplement ouvrir l'adresse dans un navigateur et l'utiliser : une page des meilleurs proxys à ajouter à leur Telegram, ou cet appareil lui-même comme proxy SOCKS. Un appareil trouve et maintient les proxys ; les autres l'empruntent via le réseau local."

    // Android volume-button pattern trigger
    override val volTriggerTitle = "Déclencheur par boutons de volume"
    override val volTriggerSub = "Changer de proxy avec un motif rapide de touches de volume"
    override val volEnableLabel = "Surveiller les boutons de volume"
    override val volHelpTitle = "Qu'est-ce que c'est ?"
    override val volHelpBody = "Sur Android, il n'y a pas de raccourcis clavier globaux, donc ceci utilise les boutons de VOLUME à la place. Lorsqu'il est activé, AutoConnector surveille en arrière-plan un motif rapide d'appuis Volume-Haut/Bas (par ex. haut-haut-bas-bas). Quand il en reconnaît un, il ouvre un lien tg:// d'un bon proxy actif aléatoire pour que Telegram le récupère et bascule — un moyen rapide et discret de changer de proxy sans ouvrir l'application. Le volume continue de fonctionner normalement (les appuis ne sont pas interceptés). Cela nécessite l'accès à l'Accessibilité (pour lire les touches de volume en arrière-plan et lancer le lien) ; rien n'est demandé tant que vous n'activez pas l'option. Définissez ci-dessous le temps maximal entre les appuis ; les motifs reconnus sont listés en bas."
    override val volGrantTitle = "Activez l'Accessibilité (important)"
    override val volGrantBody = "Android (surtout 13+) bloque l'Accessibilité pour les applications NON installées depuis Google Play — c'est pourquoi AutoConnector est grisé et affiche « Paramètre restreint » / « accès non autorisé ».\n\nComment débloquer :\n1. Ouvrez « Infos sur l'appli » (bouton ci-dessous, ou Réglages → Applications → AutoConnector for Telegram).\n2. Appuyez sur le menu ⋮ (en haut à droite) → « Autoriser les paramètres restreints » → confirmez.\n3. Revenez : Réglages → Accessibilité → AutoConnector for Telegram → activez-le.\n\nSi vous ne voyez pas « Autoriser les paramètres restreints », essayez d'abord de l'activer une fois dans l'Accessibilité (vous obtiendrez le message de blocage), puis l'étape 2 apparaît.\n\nSur Xiaomi/MIUI, Samsung, etc. le chemin peut légèrement différer — cherchez le même ⋮ dans « Infos sur l'appli ». Sur Android 12 et antérieur, il n'y a généralement pas de restriction — activez-le simplement dans l'Accessibilité.\n\nLes touches de volume sont seulement observées, jamais bloquées."
    override val volOpenAppInfo = "Ouvrir « Infos sur l'appli »"
    override val volAccessOn = "Accessibilité : accordée"
    override val volAccessOff = "Accessibilité : non accordée"
    override val volOpenAccess = "Ouvrir les réglages d'Accessibilité"
    override val volGapLabel = "Ms max entre les appuis"
    override val volPatternsTitle = "Motifs reconnus"
    override val volPatternPick = "Motif"
    override val volPatternsLegend = "↑ = volume haut, ↓ = volume bas"
    override val volNoRights = "L'application n'a PAS encore l'autorisation de gérer les boutons de volume — accordez l'accès en suivant les étapes en bas de cette page."
    override val volGrantShort = "Pas encore d'accès à l'Accessibilité. Lisez les étapes détaillées en bas de cette page, puis appuyez sur « Vérifier »."
    override val volCheck = "Vérifier"
    override val volCheckOk = "✓ Terminé — accès accordé, le déclencheur fonctionne."
    override val volCheckFail = "✗ Toujours pas d'accès — effectuez les étapes ci-dessus."
    override val volPatternsList = "↑↑↓↓ · ↓↓↑↑ · ↑↓↑↓ · ↓↑↓↑ · ↑↑↑↑ · ↓↓↓↓ · ↑↓↓↑ · ↓↑↑↓ · ↑↑↑↓↓↓ · ↓↓↓↑↑↑   (↑ = volume haut, ↓ = volume bas)"

    // catalog host-card history legend + selection sliders
    override val histLegend = "Colonnes — Qui : ✓/✗ TG = vraie connexion Telegram, scan = vérification en arrière-plan. Quand : il y a combien de temps. TCP/TLS/Req : latence du handshake et de la première requête, ms. Session : durée de la session de relais. ↓/↑ : octets reçus / envoyés via l'hôte."
    override val tgOkTotalHint = "Connexions Telegram / réussies / total des vérifications"
    override val breadthTitle = "Largeur de sélection des hôtes"
    override val breadthHelp = "Gauche = s'en tenir aux meilleurs hôtes éprouvés ; droite = essayer le plus largement possible parmi tous les hôtes actifs. Quand Telegram change sans cesse de port de relais, l'application élargit la recherche automatiquement."
    override val breadthNarrow = "éprouvés"
    override val breadthWide = "plus large"
    override val connTimeoutTitle = "Délai de connexion par hôte"
    override val connTimeoutHelp = "Combien de temps attendre un upstream (TCP + TLS + première réponse MTProto) avant de passer au proxy suivant."

    override val factoryResetDone = "Tout a été réinitialisé. Fermez l'application et rouvrez-la."
}
