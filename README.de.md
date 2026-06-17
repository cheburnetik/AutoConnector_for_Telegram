[ENGLISH](README.en.md) · [ARABIC](README.ar.md) · [BENGALI](README.bn.md) · [BURMESE](README.my.md) · [CHINESE](README.zh.md) · [FRENCH](README.fr.md) · [GERMAN](README.de.md) · [HINDI](README.hi.md) · [INDONESIAN](README.id.md) · [ITALIAN](README.it.md) · [JAPANESE](README.ja.md) · [KOREAN](README.ko.md) · [MARATHI](README.mr.md) · [PERSIAN](README.fa.md) · [POLISH](README.pl.md) · [PORTUGUESE](README.pt.md) · [PUNJABI](README.pa.md) · [RUSSIAN](README.md) · [SPANISH](README.es.md) · [TAMIL](README.ta.md) · [TELUGU](README.te.md) · [THAI](README.th.md) · [TURKISH](README.tr.md) · [UKRAINIAN](README.uk.md) · [URDU](README.ur.md) · [VIETNAMESE](README.vi.md)

**[Download (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

# AutoConnector for Telegram

AutoConnector for Telegram — die Anwendung findet selbst MTProto-Proxys im Internet, prüft sie auf Erreichbarkeit und startet ein lokales Relay, über das Telegram selbst dort stabil funktioniert, wo es blockiert ist. Der Benutzer muss nicht manuell nach funktionierenden Proxys suchen — AutoConnector for Telegram wählt ständig die schnellsten und erreichbarsten aus und testet sie genau von Ihrem Computer/Telefon aus.

Anders gesagt: Es ist ein Scanner für Telegram-Kanäle und alle möglichen Abonnements mit öffentlichen, kostenlosen MTProto-Proxys, mit automatischer Einrichtung in Ihrem Telegram. Den Telegram-Client muss man nicht aktualisieren. Die Erreichbarkeit der Proxys wird genau von Ihrem Gerät und Ihrer Netzwerkumgebung aus geprüft. Funktioniert über WiFi+LTE ohne VPN.

Plattformen: Android, Windows, Linux, MacBook.

Die Android-Version funktioniert von selbst, unter Windows muss man dagegen die Proxy-Engine „SPLIT…" oder „COALESCING…" einstellen — in den Einstellungen oder über die Schaltfläche rechts neben den Worten „Telegram verbunden" und dem großen grauen/grünen Kreis. Oder wählen Sie diejenige aus, die bei Ihnen persönlich am besten funktioniert, denn die Sperren sind überall unterschiedlich. Die „COALESCING…"-Modi sind für den Notfall — so beginnt Telegram zwar zu funktionieren, aber das Senden/Anzeigen von Medieninhalten in Chats wird beeinträchtigt.

Ich empfehle, eine Firewall wie COMODO zu deaktivieren, falls Sie eine verwenden: Sie sperrt die Anwendung in eine Sandbox, und ihre Firewall beeinträchtigt die ausgehenden Verbindungen zu MTProto-Proxys. Oder starten Sie die Anwendung in einer virtuellen Maschine, dort ändert sich der TCP-Stack vollständig und das Verhalten von AutoConnector ist ein anderes.

Helfen Sie außerdem Telegram per Hand, zwischen den Ports 55001 und 55002 zu wechseln (in den Proxy-Einstellungen), um schneller einen funktionierenden Proxy und die Anzeige „Verbunden" innerhalb von Telegram zu erreichen.

# ✨ Funktionen

- **Automatische Proxy-Suche** — durchsucht Dutzende offener Seiten und Abonnements.
- **Erreichbarkeitsprüfung** — echter MTProto-Handshake, Bewertung nach Geschwindigkeit/Stabilität.
- **Lokales Relay** — Telegram verbindet sich mit `127.0.0.1`, und AutoConnector for
  Telegram leitet den Verkehr über den besten erreichbaren Proxy und wechselt,
  wenn der aktuelle ausfällt.
- **Anti-DPI** — eine Reihe von Tarntricks (Browser-Imitation, Paket-
  Fragmentierung, FakeTLS u. a.); der Modus „Auto-Durchlauf" wählt selbst einen funktionierenden aus.
- **Detaillierte Statistik** — erreichbare/tote Proxys, Geschwindigkeit, Latenz, Verkehr,
  Wirksamkeit jedes Anti-DPI-Tricks.
- **Proxy-Katalog** — Top-Liste nach Bewertung mit detaillierter Karte zu jedem Host:
  für jeden Host sieht man „Telegram-Verbindungen / erfolgreiche / Prüfungen insgesamt" und
  die Historie der letzten 25 Versuche (TCP/TLS/Gesamtdauer der Verbindung, empfangene/gesendete Bytes).
- **Flexible Host-Auswahl** — Schieberegler für die „Breite": von „bei den besten geprüften bleiben"
  bis „so breit wie möglich verschiedene erreichbare ausprobieren"; wenn Telegram zwischen
  den Relay-Ports hin und her springt, erweitert sich die Auswahl automatisch. Ein separater Schieberegler — Verbindungs-
  Timeout (100 ms … 15 s) und „Upstream-Wettrennen" (mehrere Verbindungen parallel).
- **12 Oberflächensprachen** mit automatischer Erkennung, RTL-Unterstützung.

> ### Was ist neu gegenüber 1.0.19
> - **Getrennte Datenbanken und Host-Bewertungen nach Netzwerktyp** — VPN / Wi-Fi / LTE /
>   Ethernet / White: jede Verbindungsart führt ihren eigenen Pool erreichbarer Proxys, um
>   Telegram nicht etwas unterzuschieben, das nur über VPN funktioniert.
> - **Upstream-Wettrennen** — mehrere Verbindungen parallel, der schnellste erreichbare
>   gewinnt; Schieberegler für die „Auswahlbreite" (von den besten geprüften bis zur maximalen
>   Breite) mit automatischer Pool-Erweiterung, wenn Telegram zwischen den Relay-Ports springt;
>   einstellbares Verbindungs-Timeout (100 ms…15 s).
> - **Host-Katalog mit detaillierter Karte** — „Telegram-Verbindungen / erfolgreiche /
>   Prüfungen insgesamt" und Historie der letzten 25 Versuche pro Host (TCP/TLS-Zeit,
>   Verbindungsdauer, empfangene/gesendete Bytes).
> - **Live-Grafiken** für Geschwindigkeit, Ping und Port-Aktivität (nach Sekunden und Minuten)
>   sowie Scan-Grafiken.
> - **Anti-DPI und Proxy-Engines** — eine Reihe von Tarntricks mit
>   „Auto-Durchlauf", Verschleierungs-Engine und experimentelle Engines (Split/
>   Coalescing) für eine konkrete Sperre.
> - **Export/Import** von Einstellungen, Hosts und Abonnements + vollständiges Zurücksetzen auf den Werkszustand.
> - **Schneller Kaltstart** — aggressives mehrsträngiges Laden von Abonnements über
>   mehrere Anonymizer.
> - **26 Oberflächensprachen** mit automatischer Erkennung (+RTL).

# Beim ersten Start wichtig:

- Telegram einrichten und einen festen SOCKS5-Proxy localhost:55001 und localhost:55002 angeben.
- Löschen Sie alle anderen Proxys außer diesen.
- Aktivieren Sie in Telegram „Proxy verwenden".
- Benachrichtigungen unter Android nicht blockieren, sonst funktioniert es im Hintergrund nicht.
- Beim ersten Start ~15 Minuten warten, bis MTProto-Proxys heruntergeladen und durchprobiert sind und der Telegram-Client selbst umschaltet.

# Wenn nichts funktioniert

1. Wenn GAR NICHTS funktioniert, nutzen Sie das Programm als automatischen Katalog erreichbarer Proxys. Mit den Tastenkombinationen CTRL+WIN+ALT+P und CTRL+SHIFT+ALT+P können Sie schnell, ohne das AutoConnector-Fenster zu öffnen, einen zufälligen Proxy direkt in Ihr Telegram einfügen. Dabei geht Telegram direkt zum Proxy, ohne AutoConnector, aber Sie müssen keine Chats überwachen, in denen kostenlose Proxys veröffentlicht werden, und keine Zeit mit deren Prüfung verbringen. Lassen Sie AutoConnector im Tray laufen, schalten Sie den Schalter „Connector" aus und lassen Sie den Schalter „Scan" an.

2. Probieren Sie AutoConnector auf einem anderen Gerät: Telefon, Telefon eines Freundes, Computer. Auf verschiedenen Plattformen Windows/Android funktioniert die Umgehung von Sperren nach völlig unterschiedlichen Prinzipien. Höchstwahrscheinlich funktioniert es auf Android ganz ohne Einstellungen.

3. Wenn nichts funktioniert, schalten Sie für einen Tag vorübergehend ein VPN ein und testen Sie AutoConnector + Telegram diesen Tag (Telegram über AutoConnector verbinden, mit Proxy auf den Ports 55001 und 55002). Aktivieren Sie im Programm das Kontrollkästchen „Bei eingeschaltetem VPN -> zu MTProto proxen". Schauen Sie: Hat AutoConnector zu funktionieren begonnen? Wenn ja, ist der Schluss offensichtlich — AutoConnector findet erfolgreich Proxys und leitet den Telegram-Verkehr erfolgreich dorthin, aber wenn man das VPN ausschaltet, blockiert das Sperrsystem in Ihrem Land alle ausgehenden Verbindungen zu hart. In diesem Fall müssen Sie eine halbe Stunde damit verbringen, in AutoConnector die Mittel durchzuprobieren, um ein funktionierendes zu finden, das die Sperren umgehen kann. Alle Varianten vollautomatisch durchzuprobieren kann das Programm noch nicht (es gibt nur einen Auto-Durchlauf der anti-DPI-Tricks). Schalten Sie nach dem Experiment das VPN aus und setzen Sie das Kontrollkästchen „Bei eingeschaltetem VPN zu MTProto proxen" wieder auf „Direkt proxen".

4. Alternative zu Punkt (3). Installieren Sie eine virtuelle Maschine auf Ihrem Windows/Linux-Host. Starten Sie darin Telegram + AutoConnector. Funktioniert es perfekt, sogar ohne VPN? Dann beeinträchtigt Ihr Host Ihre Verbindungen, nicht das Sperrsystem in Ihrem Land! Ursachen: Firewalls, Antivirenprogramme, Reste von VPNs. Wenn das Antivirenprogramm AutoConnector in eine Sandbox sperrt oder die Firewall die ungewöhnlichen anti-DPI-Tricks von AutoConnector blockiert, müssen Sie AutoConnector auf dem Host unter Umgehung (Ausnahmen) von Antivirus und Firewall starten. Oder schalten Sie sie ganz für eine Weile aus und starten Sie den Computer neu. Ja, so lächerlich der Rat auch klingt, starten Sie den Computer neu, denn VPN-Programme spinnen oft und können auf dem Host ein TUN-Gerät in einem halbtoten Zustand hinterlassen. Starten Sie nach dem Neustart kein VPN, testen Sie zuerst AutoConnector.

  5. Probieren Sie die Sperrumgehung. Die Einschalt-Schaltfläche finden Sie in den Einstellungen oder auf dem Hauptbildschirm (suchen Sie die Schaltfläche rechts neben dem großen grauen/grünen Kreis). Sie müssen ~15 Minuten Zeit aufwenden. Sie besteht aus 3 Gruppen:
	  - Proxy-Engine. Probieren Sie irgendeinen Coalescing*-Modus. Höchstwahrscheinlich funktioniert es sofort. Dabei werden aber keine Bilder/Videos in Telegram geladen (das ist kein Bug, sondern ein Feature/Kompromiss). Probieren Sie als Nächstes die Split*-Modi, wenn es funktioniert — werden Bilder geladen. Oder setzen Sie auf „deaktiviert" zurück.
	  - Probieren Sie „Paralleles Upstream-Wettrennen". Das bedeutet, wenn Telegram 1 Verbindung zum Proxy aufbaut, baut AutoConnector 5–30 Verbindungen zu verschiedenen MTProto-Proxys auf und schiebt Telegram den besten unter. In den Anwendungseinstellungen kann man die Timeouts (3–5 Sek.) und die Zahl der parallelen Upstreams bis zu 30 Stück wählen.
	  - Aktivieren Sie „Auto-Durchlauf der anti-DPI-Tricks", das Programm probiert sie selbst durch.
	  - Damit Telegram schneller umschaltet, wechseln Sie in den Proxy-Einstellungen (in Telegram) per Hand alle 5–10 Sekunden zum nächsten Port im Kreis 55001->55002->55001->…
    
6. Die stärkste/schnellste Einstellungskombination:
	- Verbindungs-Timeout 5 s
	- Host-Auswahlbreite 100 %
	- parallele Verbindungen 30
	- Auto-Durchlauf der DPI-Tricks
	- paralleles Upstream-Wettrennen
	- Proxy-Engine: Coalescing*
	- innerhalb von Telegram im Proxy-Fenster alle 10 Sekunden auf einen neuen Port tippen, im Kreis.
  
7. Die Konfigurationspolitik unter Windows und Android ist unterschiedlich! Alles oben Geschriebene betrifft hauptsächlich Windows. Unter Android funktioniert es bei den meisten ganz ohne Einstellungen (bei beliebigen Einstellungen). Unter Windows gibt es einen anderen TCP-Stack und eine andere Telegram-Anwendung, die qualitativ viel schlechter ist als die unter Android. Probieren Sie irgendeinen anderen Telegram-Client, nicht nur den offiziellen.

8. Bitte schreiben Sie ausführliche Bugreports in beliebiger Sprache an https://t.me/AutoConnector_for_Telegram — Plattform, welche Methoden Sie probiert haben (Einstellungen), ob Sie eine Firewall/ein Antivirenprogramm haben, ob Sie es aus einem VPN/einer virtuellen Maschine probiert haben. Schreiben Sie auch beliebige positive Rezepte, was Sie probiert haben und wie es zum Laufen kam.


## 📥 Download

Alle Builds — auf der Releases-Seite: **[GitHub Releases (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

| OS | Datei | Start |
|----|------|--------|
| **Android** | `AutoConnector_for_Telegram.apk` | APK installieren (außerhalb von Google Play — Installation aus der Quelle erlauben) |
| **Windows** 10/11 x64 | `AutoConnector-for-Telegram-windows-x64.zip` | entpacken → `AutoConnector\AutoConnector.exe` starten |
| **Linux** x64 | `AutoConnector-for-Telegram-linux-x64.tar.gz` | entpacken → `./AutoConnector/bin/AutoConnector` |
| **macOS** 11+ (Apple Silicon) | `AutoConnector-for-Telegram-macos.tar.gz` | entpacken → Doppelklick auf `AutoConnector.app` (falls blockiert — `xattr -dr com.apple.quarantine AutoConnector.app`) |

### 🔐 Authentizitätsprüfung (release 1.1.0)

Das APK ist mit einem Release-Zertifikat signiert (apksigner, Schemata v1+v2+v3). Vor der Installation kann man abgleichen:

- **Signaturzertifikat (SHA-256):** `cb23a18c0cf8a23e43b5b63d199fc1440d3e4d6533e1309d3f92f273fe626a5a`
  (CN=AutoConnector for Telegram) — dieser Fingerabdruck ist für alle zukünftigen Releases identisch.
- **APK SHA-256:** `d7652e7f5c3a2174a3b7805c2539df7da080765c9b0f581a7ac5943987c9b935`
- **Windows zip SHA-256:** `1d8d675936387e89038dc4943d7f99200c1b735b86e1f79bd953cd93e60f0217`
- **Linux tar.gz SHA-256:** `9160ea519309dc62750a4a930dc1aae6e20dbcefd21b426fa85b48ace6f3e8f8`
- **macOS tar.gz SHA-256:** `322082ef3f06955ed299be790bce453e47db37fca17daea54724d60698446bc7`

Prüfung: `apksigner verify --print-certs AutoConnector_for_Telegram.apk` (Zertifikat) und
`sha256sum -c SHA256SUMS.txt` (Dateiintegrität; `SHA256SUMS.txt` ist dem Release beigefügt).

## 📸 Screenshots

<table>
<tr>
<td align="center"><img src="docs/screenshots/connector.png" width="200"><br><sub>Connector — aktive Sitzung</sub></td>
<td align="center"><img src="docs/screenshots/scan.png" width="200"><br><sub>Scan und Grafiken</sub></td>
<td align="center"><img src="docs/screenshots/catalog.png" width="200"><br><sub>Proxy-Katalog (nach Modi)</sub></td>
<td align="center"><img src="docs/screenshots/host-card.png" width="200"><br><sub>Host-Karte + Historie</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/logs.png" width="200"><br><sub>Relay-Logs</sub></td>
<td align="center"><img src="docs/screenshots/settings.png" width="200"><br><sub>Einstellungen</sub></td>
<td align="center"><img src="docs/screenshots/export.png" width="200"><br><sub>Export von tg://-Links</sub></td>
<td align="center"><img src="docs/screenshots/hotkeys.png" width="200"><br><sub>Tastenkürzel</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/guide.png" width="200"><br><sub>Verbindungsanleitung</sub></td>
<td align="center"><img src="docs/screenshots/connector-ru.png" width="200"><br><sub>Connector · russische UI</sub></td>
<td align="center"><img src="docs/screenshots/scan-ru.png" width="200"><br><sub>Scan · russische UI</sub></td>
<td align="center"><sub>26 Oberflächensprachen<br>mit automatischer Erkennung</sub></td>
</tr>
</table>


## Feedback

Bugs und Anmerkungen schicken Sie hierher - https://t.me/AutoConnector_for_Telegram

## 🔐 Signaturprüfung

Das APK aus den Releases ist mit einem Release-Schlüssel signiert. Prüfen kann man es so:

```bash
# Prüfsumme (mit SHA256SUMS.txt aus dem Release vergleichen)
sha256sum AutoConnector_for_Telegram.apk

# Digitale Signatur und Zertifikat-Fingerabdruck
apksigner verify --print-certs AutoConnector_for_Telegram.apk
```

Der Zertifikat-Fingerabdruck (SHA-256), mit dem die offiziellen Builds signiert sind,
wird in der Beschreibung jedes Releases veröffentlicht — gleichen Sie ihn ab, um sicherzustellen, dass das APK
nicht manipuliert wurde.

## 📄 Lizenz

[MIT](LICENSE).
