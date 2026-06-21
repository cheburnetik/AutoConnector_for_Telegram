[ENGLISH](README.en.md) · [AMHARIC](README.am.md) · [ARABIC](README.ar.md) · [AZERBAIJANI](README.az.md) · [BENGALI](README.bn.md) · [BURMESE](README.my.md) · [CHINESE](README.zh.md) · [DARI](README.prs.md) · [FRENCH](README.fr.md) · [GERMAN](README.de.md) · [HAUSA](README.ha.md) · [HINDI](README.hi.md) · [INDONESIAN](README.id.md) · [ITALIAN](README.it.md) · [JAPANESE](README.ja.md) · [KAZAKH](README.kk.md) · [KOREAN](README.ko.md) · [MARATHI](README.mr.md) · [PASHTO](README.ps.md) · [PERSIAN](README.fa.md) · [POLISH](README.pl.md) · [PORTUGUESE](README.pt.md) · [PUNJABI](README.pa.md) · [RUSSIAN](README.md) · [SPANISH](README.es.md) · [TAMIL](README.ta.md) · [TELUGU](README.te.md) · [THAI](README.th.md) · [TIGRINYA](README.ti.md) · [TURKISH](README.tr.md) · [UKRAINIAN](README.uk.md) · [URDU](README.ur.md) · [UZBEK](README.uz.md) · [VIETNAMESE](README.vi.md)

**[Download (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

# AutoConnector for Telegram

AutoConnector for Telegram — l'applicazione trova da sola in rete i proxy MTProto, ne verifica la reattività e avvia un relay locale attraverso cui Telegram funziona in modo stabile anche dove è bloccato. L'utente non deve cercare manualmente i proxy funzionanti — AutoConnector for Telegram seleziona costantemente i più veloci e attivi, testandoli proprio dal vostro computer/telefono.

In altre parole: è uno scanner di canali Telegram e di ogni sorta di abbonamenti con proxy MTProto pubblici e gratuiti, con inserimento automatico nel vostro Telegram. Non è necessario aggiornare il client Telegram. La disponibilità dei proxy viene verificata proprio dal vostro dispositivo e dal vostro ambiente di rete. Funziona su Wi-Fi+LTE senza VPN.

Piattaforme: Android, Windows, Linux, MacBook.

La versione Android funziona da sola, mentre su Windows occorre attivare il motore di proxy "SPLIT..." o "COALESCING.." — nelle impostazioni oppure con il pulsante a destra delle parole "Telegram connesso" e del grande cerchio grigio/verde. Oppure scegliete quello che funziona meglio per voi, poiché i blocchi sono diversi ovunque. Le modalità "COALESCING.." sono per casi estremi — così Telegram inizierà a funzionare, ma l'invio/visualizzazione dei contenuti multimediali nelle chat ne risentirà.

Consiglio di disattivare un firewall come COMODO, se lo usate: confina l'applicazione in una sandbox e il suo firewall rovina le connessioni in uscita verso i proxy MTProto. Oppure avviate l'applicazione in una macchina virtuale, lì lo stack TCP cambia completamente e il comportamento di AutoConnector sarà diverso.

E aiutate anche manualmente Telegram a passare tra le porte 55001 e 55002 (nelle impostazioni dei proxy), per raggiungere più velocemente un proxy funzionante e la scritta "Connesso" all'interno di Telegram.

# ✨ Funzionalità

- **Ricerca automatica dei proxy** — scansiona decine di pagine e abbonamenti aperti.
- **Verifica della reattività** — vero handshake MTProto, classifica per velocità/stabilità.
- **Relay locale** — Telegram si connette a `127.0.0.1`, mentre AutoConnector for
  Telegram instrada il traffico attraverso il miglior proxy attivo e cambia
  se quello corrente cade.
- **Anti-DPI** — un insieme di trucchi di mascheramento (imitazione di browser, frammentazione
  dei pacchetti, FakeTLS e altri); la modalità «Auto-ricerca» seleziona da sola quello funzionante.
- **Statistiche dettagliate** — proxy attivi/morti, velocità, latenza, traffico,
  efficacia di ciascun trucco anti-DPI.
- **Catalogo dei proxy** — classifica per punteggio con scheda dettagliata per ogni host:
  per ciascun host si vedono «connessioni Telegram / riuscite / verifiche totali» e
  la cronologia degli ultimi 25 tentativi (durata connessione TCP/TLS/totale, byte ricevuti/inviati).
- **Selezione flessibile degli host** — cursore di «ampiezza»: da «restare sui migliori già verificati»
  a «provare il più ampiamente possibile diversi attivi»; quando Telegram salta tra le
  porte del relay, la selezione si amplia automaticamente. Un cursore a parte — il timeout
  di connessione (100 ms … 15 s) e la «gara degli upstream» (più connessioni in parallelo).
- **12 lingue** dell'interfaccia con rilevamento automatico, supporto RTL.

> ### Novità rispetto alla 1.0.19
> - **Basi e classifiche degli host separate per tipo di rete** — VPN / Wi-Fi / LTE /
>   Ethernet / White: ogni tipo di connessione mantiene il proprio pool di proxy attivi, per
>   non fornire a Telegram ciò che funziona solo sotto VPN.
> - **Gara degli upstream** — più connessioni in parallelo, vince il più
>   veloce tra quelli attivi; cursore di «ampiezza della selezione» (dai migliori verificati al più
>   ampio possibile) con auto-espansione del pool quando Telegram salta tra le porte del relay;
>   timeout di connessione configurabile (100 ms…15 s).
> - **Catalogo degli host con scheda dettagliata** — «connessioni Telegram / riuscite /
>   verifiche totali» e cronologia degli ultimi 25 tentativi per host (tempi TCP/TLS,
>   durata connessione, byte ricevuti/inviati).
> - **Grafici dal vivo** di velocità, ping e attività delle porte (per secondi e minuti)
>   e grafici di scansione.
> - **Anti-DPI e motori di proxy** — un insieme di trucchi di mascheramento con
>   «Auto-ricerca», motore di offuscamento e motori sperimentali (split/
>   coalescing) per il blocco specifico.
> - **Esportazione/importazione** di impostazioni, host e abbonamenti + ripristino completo allo stato di fabbrica.
> - **Avvio a freddo rapido** — caricamento aggressivo e multithread degli abbonamenti tramite
>   più anonimizzatori.
> - **26 lingue** dell'interfaccia con rilevamento automatico (+RTL).

# Al primo avvio è importante:

- Configurare Telegram, indicando un proxy SOCKS5 fisso localhost:55001 e localhost:55002.
- Eliminate gli altri proxy, tranne questi.
- Attivate in Telegram «Usa proxy».
- Non bloccare le notifiche su Android, altrimenti non funzionerà in background.
- Al primo avvio attendere ~15 minuti, mentre scarica e seleziona i proxy MTProto e finché il client Telegram stesso non commuta.

# Se niente funziona

1. Se NIENTE funziona, usate il programma come catalogo automatico di proxy attivi. Con la scorciatoia CTRL+WIN+ALT+P e CTRL+SHIFT+ALT+P potete aggiungere rapidamente, senza aprire la finestra di AutoConnector, un proxy casuale direttamente nel vostro Telegram. In questo modo Telegram andrà direttamente al proxy, senza AutoConnector, ma non dovrete monitorare le chat dove vengono pubblicati i proxy gratuiti e perdere tempo a verificarli. Lasciate che AutoConnector viva nella tray, disattivate l'interruttore "Connettore", lasciate l'interruttore "Scan".

2. Provate AutoConnector su un altro dispositivo: telefono, telefono di un amico, computer. Su piattaforme diverse Windows/Android il principio di aggiramento dei blocchi è completamente diverso. Molto probabilmente su Android funzionerà senza alcuna impostazione.

3. Se niente funziona, attivate temporaneamente una VPN per un giorno e testate AutoConnector + Telegram per quel giorno (collegate Telegram tramite AutoConnector, indicando i proxy sulle porte 55001 e 55002). All'interno del programma attivate la casella "Con VPN attiva -> usa proxy verso MTProto". Guardate, AutoConnector ha iniziato a funzionare? Se sì, la conclusione è ovvia — AutoConnector cerca con successo i proxy, vi trasmette con successo il traffico di Telegram, ma se la VPN viene disattivata, il sistema di blocchi nel vostro paese blocca troppo duramente tutte le connessioni in uscita. In tal caso dovrete dedicare mezz'ora a provare i vari strumenti in AutoConnector, per trovarne uno funzionante capace di aggirare i blocchi. Il programma non sa ancora provare automaticamente tutte le varianti (esiste solo l'auto-ricerca dei trucchi anti-DPI). Dopo l'esperimento disattivate la VPN e riportate la casella "Con VPN attiva usa proxy verso MTProto" nello stato "Usa proxy direttamente".

4. Alternativa al punto (3). Installate una macchina virtuale sul vostro host Windows/Linux. Al suo interno avviate Telegram + AutoConnector. Ha iniziato a funzionare perfettamente anche senza VPN? Significa che è il vostro host a rovinare le connessioni, non il sistema di blocchi nel vostro paese! Cause: firewall, antivirus, residui di VPN. Se l'antivirus mette AutoConnector in una sandbox, oppure il firewall blocca gli insoliti trucchi anti-DPI di AutoConnector, dovrete attivare AutoConnector sull'host aggirando (eccezioni) antivirus e firewall. Oppure disattivateli del tutto per un po', riavviando il computer. Sì, per quanto possa sembrare ridicolo consigliarlo, riavviate il computer, perché i programmi VPN spesso vanno in errore e possono lasciare sull'host un dispositivo TUN in uno stato semi-vivo. Dopo il riavvio non avviate la VPN, prima testate AutoConnector.

  5. Provate l'aggiramento dei blocchi. Il pulsante di attivazione cercatelo nelle impostazioni o nella schermata principale (cercate il pulsante a destra del grande cerchio di colore grigio/verde). Dovrete dedicare ~15 minuti. Si compone di 3 gruppi:
	  - Motore di proxy. Provate una qualsiasi modalità Coalescing*. Molto probabilmente funzionerà subito. Ma allo stesso tempo non si caricheranno immagini/video in Telegram (non è un bug, ma una caratteristica/compromesso). Poi provate le modalità Split*, se funziona — le immagini si caricano. Oppure riportate su "disattivato".
	  - Provate la "Gara parallela degli upstream". Significa che quando Telegram fa 1 connessione al proxy, AutoConnector fa 5-30 connessioni a diversi proxy MTProto e fornisce a Telegram il migliore. Nelle impostazioni dell'applicazione si possono scegliere i timeout (3-5 sec) e il numero di upstream paralleli fino a 30.
	  - Attivate "Auto-ricerca dei trucchi anti-DPI", il programma li proverà da solo.
	  - Per far commutare Telegram più velocemente, nelle impostazioni dei proxy (in Telegram) passate manualmente ogni 5-10 secondi alla porta successiva a rotazione 55001->55002->55001->...

6. La combinazione di impostazioni più potente/veloce:
	- timeout di connessione 5s
	- ampiezza di selezione degli host 100%
	- connessioni parallele 30
	- auto-ricerca dei trucchi DPI
	- gara parallela degli upstream
	- motore di proxy: Coalescing*
	- all'interno di Telegram, nella finestra dei proxy, ogni 10 secondi toccate una nuova porta, a rotazione.

7. La politica di configurazione su Windows e Android è diversa! Tutto ciò che è scritto sopra riguarda principalmente Windows. Su Android per la maggior parte funziona senza alcuna impostazione (con qualsiasi impostazione). Su Windows c'è uno stack TCP diverso e un'applicazione Telegram diversa, di qualità molto peggiore rispetto ad Android. Provate qualche altro client Telegram, non solo quello ufficiale.

8. Per favore, scrivete bug report dettagliati in qualsiasi lingua su https://t.me/AutoConnector_for_Telegram — piattaforma, quali metodi avete provato (impostazioni), se avete firewall/antivirus, se avete provato da VPN/macchina virtuale. Scrivete anche qualsiasi ricetta positiva: cosa avete provato e come ha iniziato a funzionare.


## 📥 Download

Tutte le build — nella pagina dei rilasci: **[GitHub Releases (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

| OS | File | Avvio |
|----|------|--------|
| **Android** | `AutoConnector_for_Telegram.apk` | installare l'APK (al di fuori di Google Play — consentite l'installazione dalla sorgente) |
| **Windows** 10/11 x64 | `AutoConnector-for-Telegram-windows-x64.zip` | estrarre → avviare `AutoConnector\AutoConnector.exe` |
| **Linux** x64 | `AutoConnector-for-Telegram-linux-x64.tar.gz` | estrarre → `./AutoConnector/bin/AutoConnector` |
| **macOS** 11+ (Apple Silicon) | `AutoConnector-for-Telegram-macos.tar.gz` | estrarre → doppio clic su `AutoConnector.app` (se blocca — `xattr -dr com.apple.quarantine AutoConnector.app`) |

### 🔐 Verifica dell'autenticità (release 1.1.0)

L'APK è firmato con un certificato di release (apksigner, schemi v1+v2+v3). Prima dell'installazione potete confrontare:

- **Certificato di firma (SHA-256):** `cb23a18c0cf8a23e43b5b63d199fc1440d3e4d6533e1309d3f92f273fe626a5a`
  (CN=AutoConnector for Telegram) — questa impronta è identica per tutti i rilasci futuri.
- **APK SHA-256:** `d7652e7f5c3a2174a3b7805c2539df7da080765c9b0f581a7ac5943987c9b935`
- **Windows zip SHA-256:** `1d8d675936387e89038dc4943d7f99200c1b735b86e1f79bd953cd93e60f0217`
- **Linux tar.gz SHA-256:** `9160ea519309dc62750a4a930dc1aae6e20dbcefd21b426fa85b48ace6f3e8f8`
- **macOS tar.gz SHA-256:** `322082ef3f06955ed299be790bce453e47db37fca17daea54724d60698446bc7`

Verifica: `apksigner verify --print-certs AutoConnector_for_Telegram.apk` (certificato) e
`sha256sum -c SHA256SUMS.txt` (integrità dei file; `SHA256SUMS.txt` è allegato al rilascio).

## 📸 Screenshot

<table>
<tr>
<td align="center"><img src="docs/screenshots/connector.png" width="200"><br><sub>Connettore — sessione attiva</sub></td>
<td align="center"><img src="docs/screenshots/scan.png" width="200"><br><sub>Scan e grafici</sub></td>
<td align="center"><img src="docs/screenshots/catalog.png" width="200"><br><sub>Catalogo dei proxy (per modalità)</sub></td>
<td align="center"><img src="docs/screenshots/host-card.png" width="200"><br><sub>Scheda dell'host + cronologia</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/logs.png" width="200"><br><sub>Log del relay</sub></td>
<td align="center"><img src="docs/screenshots/settings.png" width="200"><br><sub>Impostazioni</sub></td>
<td align="center"><img src="docs/screenshots/export.png" width="200"><br><sub>Esportazione di link tg://</sub></td>
<td align="center"><img src="docs/screenshots/hotkeys.png" width="200"><br><sub>Scorciatoie da tastiera</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/guide.png" width="200"><br><sub>Guida alla connessione</sub></td>
<td align="center"><img src="docs/screenshots/connector-ru.png" width="200"><br><sub>Connettore · UI russa</sub></td>
<td align="center"><img src="docs/screenshots/scan-ru.png" width="200"><br><sub>Scan · UI russa</sub></td>
<td align="center"><sub>26 lingue dell'interfaccia<br>con rilevamento automatico</sub></td>
</tr>
</table>


## Feedback

Bug e osservazioni inviateli qui - https://t.me/AutoConnector_for_Telegram

## 🔐 Verifica della firma

L'APK dei rilasci è firmato con una chiave di release. Si può verificare così:

```bash
# Checksum (confrontatelo con SHA256SUMS.txt del rilascio)
sha256sum AutoConnector_for_Telegram.apk

# Firma digitale e impronta del certificato
apksigner verify --print-certs AutoConnector_for_Telegram.apk
```

L'impronta del certificato (SHA-256) con cui sono firmate le build ufficiali
viene pubblicata nella descrizione di ogni rilascio — confrontatela per assicurarvi che l'APK
non sia stato manomesso.

## 📄 Licenza

[MIT](LICENSE).
