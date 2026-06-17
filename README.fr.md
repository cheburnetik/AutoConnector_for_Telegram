[ENGLISH](README.en.md) · [ARABIC](README.ar.md) · [BENGALI](README.bn.md) · [BURMESE](README.my.md) · [CHINESE](README.zh.md) · [FRENCH](README.fr.md) · [GERMAN](README.de.md) · [HINDI](README.hi.md) · [INDONESIAN](README.id.md) · [ITALIAN](README.it.md) · [JAPANESE](README.ja.md) · [KOREAN](README.ko.md) · [MARATHI](README.mr.md) · [PERSIAN](README.fa.md) · [POLISH](README.pl.md) · [PORTUGUESE](README.pt.md) · [PUNJABI](README.pa.md) · [RUSSIAN](README.md) · [SPANISH](README.es.md) · [TAMIL](README.ta.md) · [TELUGU](README.te.md) · [THAI](README.th.md) · [TURKISH](README.tr.md) · [UKRAINIAN](README.uk.md) · [URDU](README.ur.md) · [VIETNAMESE](README.vi.md)

**[Télécharger (dernière version)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

# AutoConnector for Telegram

AutoConnector for Telegram — l'application trouve elle-même des proxys MTProto sur Internet, vérifie leur disponibilité et met en place un relais local grâce auquel Telegram fonctionne de manière stable, même là où il est bloqué. L'utilisateur n'a pas besoin de chercher manuellement des proxys qui marchent — AutoConnector for Telegram sélectionne en permanence les plus rapides et les plus actifs, en les testant précisément depuis votre ordinateur/téléphone.

Autrement dit : c'est un scanner de canaux Telegram et de toutes sortes d'abonnements proposant des proxys MTProto publics et gratuits, avec insertion automatique dans votre Telegram. Pas besoin de mettre à jour le client Telegram. La disponibilité des proxys est vérifiée précisément depuis votre appareil et votre environnement réseau. Fonctionne en WiFi+LTE sans VPN.

Plateformes : Android, Windows, Linux, MacBook.

La version Android fonctionne toute seule, tandis que sous Windows il faut activer le moteur de proxy « SPLIT... » ou « COALESCING.. » — dans les paramètres ou via le bouton à droite des mots « Telegram connecté » et du grand cercle gris/vert. Ou choisissez celui qui marchera le mieux pour vous, car les blocages varient partout. Les modes « COALESCING.. » sont un dernier recours — Telegram se met alors à fonctionner, mais l'envoi/affichage du contenu multimédia dans les discussions se dégrade.

Je recommande de désactiver un pare-feu comme COMODO si vous en utilisez un : il enferme l'application dans un bac à sable et son pare-feu casse les connexions sortantes vers les proxys MTProto. Ou bien lancez l'application dans une machine virtuelle : là, la pile TCP change complètement et le comportement d'AutoConnector sera différent.

Aidez aussi Telegram à basculer manuellement entre les ports 55001 et 55002 (dans les paramètres des proxys), afin d'atteindre plus vite un proxy fonctionnel et la mention « Connecté » à l'intérieur de Telegram.

# ✨ Fonctionnalités

- **Recherche automatique de proxys** — analyse des dizaines de pages et d'abonnements ouverts.
- **Vérification de disponibilité** — véritable handshake MTProto, classement par vitesse/stabilité.
- **Relais local** — Telegram se connecte à `127.0.0.1`, tandis qu'AutoConnector for
  Telegram achemine le trafic via le meilleur proxy actif et bascule
  si le proxy actuel tombe.
- **Anti-DPI** — un ensemble d'astuces de camouflage (imitation de navigateurs, fragmentation
  des paquets, FakeTLS, etc.) ; le mode « Balayage automatique » trouve lui-même celui qui fonctionne.
- **Statistiques détaillées** — proxys actifs/morts, vitesse, latence, trafic,
  efficacité de chaque astuce anti-DPI.
- **Catalogue de proxys** — top par classement avec une fiche détaillée pour chaque hôte :
  pour chaque hôte on voit « connexions Telegram / réussies / total des vérifications » et
  l'historique des 25 dernières tentatives (durée TCP/TLS/connexion totale, octets reçus/transmis).
- **Choix flexible des hôtes** — curseur de « largeur » : de « rester sur les meilleurs éprouvés »
  à « essayer le plus largement possible différents hôtes actifs » ; lorsque Telegram s'agite entre les
  ports du relais, le choix s'élargit automatiquement. Un curseur distinct — le délai d'attente
  de connexion (100 ms … 15 s) et la « course des upstreams » (plusieurs connexions en parallèle).
- **12 langues** d'interface avec détection automatique, prise en charge du RTL.

> ### Nouveautés par rapport à la 1.0.19
> - **Bases et classements des hôtes distincts selon le type de réseau** — VPN / Wi-Fi / LTE /
>   Ethernet / White : chaque type de connexion gère son propre pool de proxys actifs, afin de
>   ne pas proposer à Telegram ce qui ne marche que sous VPN.
> - **Course des upstreams** — plusieurs connexions en parallèle, c'est la plus
>   rapide active qui gagne ; curseur de « largeur de choix » (des meilleurs éprouvés au plus
>   large) avec élargissement automatique du pool quand Telegram s'agite entre les ports du relais ;
>   délai d'attente de connexion réglable (100 ms…15 s).
> - **Catalogue des hôtes avec fiche détaillée** — « connexions Telegram / réussies /
>   total des vérifications » et historique des 25 dernières tentatives par hôte (temps TCP/TLS,
>   durée de connexion, octets reçus/transmis).
> - **Graphiques en direct** de la vitesse, du ping et de l'activité des ports (par secondes et par minutes)
>   et graphiques de scan.
> - **Anti-DPI et moteurs de proxy** — un ensemble d'astuces de camouflage avec
>   « Balayage automatique », moteur d'obfuscation et moteurs expérimentaux (split/
>   coalescing) adaptés à un blocage précis.
> - **Export/import** des paramètres, des hôtes et des abonnements + réinitialisation complète aux réglages d'usine.
> - **Démarrage à froid rapide** — chargement agressif et multithread des abonnements via
>   plusieurs anonymiseurs.
> - **26 langues** d'interface avec détection automatique (+RTL).

# Au premier lancement, c'est important :

- Configurer Telegram en indiquant un proxy SOCKS5 fixe localhost:55001 et localhost:55002.
- Supprimez les autres proxys, en ne gardant que ceux-ci.
- Activez « Utiliser un proxy » dans Telegram.
- Ne bloquez pas les notifications sous Android, sinon l'application ne fonctionnera pas en arrière-plan.
- Au premier lancement, patientez ~15 minutes, le temps qu'elle télécharge et passe en revue les proxys MTProto et que le client Telegram lui-même bascule.

# Si rien ne fonctionne

1. Si RIEN ne fonctionne, utilisez le programme comme un catalogue automatique de proxys actifs. Avec les raccourcis CTRL+WIN+ALT+P et CTRL+SHIFT+ALT+P vous pouvez rapidement, sans ouvrir la fenêtre d'AutoConnector, ajouter un proxy aléatoire directement dans votre Telegram. Telegram ira alors directement vers le proxy, sans passer par AutoConnector, mais vous n'aurez pas à surveiller les discussions où l'on publie des proxys gratuits ni à perdre du temps à les vérifier. Laissez AutoConnector vivre dans la barre des tâches, désactivez l'interrupteur « Connecteur » et laissez l'interrupteur « Scan » activé.

2. Essayez AutoConnector sur un autre appareil : votre téléphone, celui d'un ami, un ordinateur. Sur les différentes plateformes Windows/Android, le principe de contournement des blocages est totalement différent. Il y a de fortes chances que ça marche sous Android sans aucun réglage.

3. Si rien ne fonctionne, activez temporairement un VPN pendant une journée et testez AutoConnector + Telegram ce jour-là (connectez Telegram via AutoConnector en indiquant les proxys sur les ports 55001 et 55002). Dans le programme, cochez la case « Avec le VPN activé -> proxyfier vers MTProto ». Regardez : AutoConnector s'est-il mis à fonctionner ? Si oui, la conclusion est évidente — AutoConnector trouve bien des proxys, relaie bien le trafic de Telegram vers eux, mais si vous coupez le VPN, le système de blocage de votre pays bloque trop sévèrement toutes les connexions sortantes. Dans ce cas, vous devrez consacrer une demi-heure à passer en revue les moyens d'AutoConnector pour en trouver un qui parvienne à contourner les blocages. Le programme ne sait pas encore passer automatiquement en revue toutes les options (il n'y a que le balayage automatique des astuces anti-DPI). Après l'expérience, désactivez le VPN et remettez la case « Avec le VPN activé, proxyfier vers MTProto » sur l'état « Proxyfier directement ».

4. Alternative au point (3). Installez une machine virtuelle sur votre hôte Windows/Linux. Dedans, lancez Telegram + AutoConnector. Ça s'est mis à fonctionner parfaitement même sans VPN ? Cela signifie que c'est votre hôte qui casse vos connexions, et non le système de blocage de votre pays ! Causes : pare-feux, antivirus, restes de VPN. Si l'antivirus place AutoConnector dans un bac à sable, ou si le pare-feu bloque les astuces anti-DPI inhabituelles d'AutoConnector, vous devrez activer AutoConnector sur l'hôte en contournant (exceptions) l'antivirus et le pare-feu. Ou bien désactivez-les complètement pour un temps, en redémarrant l'ordinateur. Oui, aussi risible que ce conseil puisse paraître, redémarrez l'ordinateur, car les programmes VPN buguent souvent et peuvent laisser sur l'hôte un périphérique TUN dans un état semi-vivant. Après le redémarrage, ne lancez pas le VPN, testez d'abord AutoConnector.

  5. Essayez le contournement des blocages. Le bouton d'activation se trouve dans les paramètres ou sur l'écran principal (cherchez le bouton à droite du grand cercle gris/vert). Vous devrez y consacrer ~15 minutes. Il se compose de 3 groupes :
	  - Moteur de proxy. Essayez n'importe quel mode Coalescing*. Il y a de fortes chances que ça marche tout de suite. Mais les images/vidéos ne se chargeront pas dans Telegram (ce n'est pas un bug, mais une fonctionnalité/un compromis). Essayez ensuite les modes Split*, si ça marche — les images se chargent. Ou remettez sur « désactivé ».
	  - Essayez la « Course parallèle des upstreams ». Cela signifie que lorsque Telegram fait 1 connexion vers un proxy, AutoConnector fait 5 à 30 connexions vers différents proxys MTProto et propose le meilleur à Telegram. Dans les paramètres de l'application, vous pouvez choisir les délais d'attente (3-5 s) et le nombre d'upstreams parallèles jusqu'à 30.
	  - Activez le « Balayage automatique des astuces anti-DPI », le programme les passera lui-même en revue.
	  - Pour que Telegram bascule plus vite, dans les paramètres de proxy (dans Telegram) passez manuellement toutes les 5-10 secondes au port suivant en boucle 55001->55002->55001->...

6. La combinaison de réglages la plus puissante/rapide :
	- délai d'attente des connexions 5 s
	- largeur de choix des hôtes 100 %
	- connexions parallèles 30
	- balayage automatique des astuces DPI
	- course parallèle des upstreams
	- moteur de proxy : Coalescing*
	- dans Telegram, dans la fenêtre des proxys, cliquez sur un nouveau port toutes les 10 secondes, en boucle.

7. La logique de configuration sous Windows et Android est différente ! Tout ce qui est écrit ci-dessus concerne principalement Windows. Sous Android, chez la plupart des gens ça marche sans aucun réglage (quels que soient les réglages). Sous Windows, la pile TCP est différente et l'application Telegram aussi, elle est bien moins bonne en qualité que celle d'Android. Essayez un autre client Telegram, et pas seulement l'officiel.

8. Merci d'envoyer des rapports de bug détaillés dans n'importe quelle langue sur https://t.me/AutoConnector_for_Telegram — la plateforme, les méthodes que vous avez essayées (réglages), si vous avez un pare-feu/antivirus, si vous avez essayé depuis un VPN/une machine virtuelle. Partagez aussi toutes vos recettes positives, ce que vous avez essayé et comment ça s'est mis à marcher.


## 📥 Télécharger

Toutes les builds se trouvent sur la page des releases : **[GitHub Releases (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

| OS | Fichier | Lancement |
|----|------|--------|
| **Android** | `AutoConnector_for_Telegram.apk` | installer l'APK (hors Google Play — autorisez l'installation depuis cette source) |
| **Windows** 10/11 x64 | `AutoConnector-for-Telegram-windows-x64.zip` | décompresser → lancer `AutoConnector\AutoConnector.exe` |
| **Linux** x64 | `AutoConnector-for-Telegram-linux-x64.tar.gz` | décompresser → `./AutoConnector/bin/AutoConnector` |
| **macOS** 11+ (Apple Silicon) | `AutoConnector-for-Telegram-macos.tar.gz` | décompresser → double-cliquer sur `AutoConnector.app` (si c'est bloqué — `xattr -dr com.apple.quarantine AutoConnector.app`) |

### 🔐 Vérification de l'authenticité (release 1.1.0)

L'APK est signé avec un certificat de release (apksigner, schémas v1+v2+v3). Avant l'installation, vous pouvez vérifier :

- **Certificat de signature (SHA-256) :** `cb23a18c0cf8a23e43b5b63d199fc1440d3e4d6533e1309d3f92f273fe626a5a`
  (CN=AutoConnector for Telegram) — cette empreinte est identique pour toutes les futures releases.
- **APK SHA-256 :** `d7652e7f5c3a2174a3b7805c2539df7da080765c9b0f581a7ac5943987c9b935`
- **Windows zip SHA-256 :** `1d8d675936387e89038dc4943d7f99200c1b735b86e1f79bd953cd93e60f0217`
- **Linux tar.gz SHA-256 :** `9160ea519309dc62750a4a930dc1aae6e20dbcefd21b426fa85b48ace6f3e8f8`
- **macOS tar.gz SHA-256 :** `322082ef3f06955ed299be790bce453e47db37fca17daea54724d60698446bc7`

Vérification : `apksigner verify --print-certs AutoConnector_for_Telegram.apk` (certificat) et
`sha256sum -c SHA256SUMS.txt` (intégrité des fichiers ; `SHA256SUMS.txt` est joint à la release).

## 📸 Captures d'écran

<table>
<tr>
<td align="center"><img src="docs/screenshots/connector.png" width="200"><br><sub>Connecteur — session active</sub></td>
<td align="center"><img src="docs/screenshots/scan.png" width="200"><br><sub>Scan et graphiques</sub></td>
<td align="center"><img src="docs/screenshots/catalog.png" width="200"><br><sub>Catalogue de proxys (par mode)</sub></td>
<td align="center"><img src="docs/screenshots/host-card.png" width="200"><br><sub>Fiche d'hôte + historique</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/logs.png" width="200"><br><sub>Journaux du relais</sub></td>
<td align="center"><img src="docs/screenshots/settings.png" width="200"><br><sub>Paramètres</sub></td>
<td align="center"><img src="docs/screenshots/export.png" width="200"><br><sub>Export des liens tg://</sub></td>
<td align="center"><img src="docs/screenshots/hotkeys.png" width="200"><br><sub>Raccourcis clavier</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/guide.png" width="200"><br><sub>Guide de connexion</sub></td>
<td align="center"><img src="docs/screenshots/connector-ru.png" width="200"><br><sub>Connecteur · interface russe</sub></td>
<td align="center"><img src="docs/screenshots/scan-ru.png" width="200"><br><sub>Scan · interface russe</sub></td>
<td align="center"><sub>26 langues d'interface<br>avec détection automatique</sub></td>
</tr>
</table>


## Retour d'expérience

Envoyez les bugs et remarques ici - https://t.me/AutoConnector_for_Telegram

## 🔐 Vérification de la signature

L'APK des releases est signé avec une clé de release. Voici comment vérifier :

```bash
# Somme de contrôle (comparez avec SHA256SUMS.txt de la release)
sha256sum AutoConnector_for_Telegram.apk

# Signature numérique et empreinte du certificat
apksigner verify --print-certs AutoConnector_for_Telegram.apk
```

L'empreinte du certificat (SHA-256) avec laquelle les builds officielles sont signées
est publiée dans la description de chaque release — vérifiez-la pour vous assurer que l'APK
n'a pas été altéré.

## 📄 Licence

[MIT](LICENSE).
