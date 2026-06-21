[ENGLISH](README.en.md) · [AMHARIC](README.am.md) · [ARABIC](README.ar.md) · [AZERBAIJANI](README.az.md) · [BENGALI](README.bn.md) · [BURMESE](README.my.md) · [CHINESE](README.zh.md) · [DARI](README.prs.md) · [FRENCH](README.fr.md) · [GERMAN](README.de.md) · [HAUSA](README.ha.md) · [HINDI](README.hi.md) · [INDONESIAN](README.id.md) · [ITALIAN](README.it.md) · [JAPANESE](README.ja.md) · [KAZAKH](README.kk.md) · [KOREAN](README.ko.md) · [MARATHI](README.mr.md) · [PASHTO](README.ps.md) · [PERSIAN](README.fa.md) · [POLISH](README.pl.md) · [PORTUGUESE](README.pt.md) · [PUNJABI](README.pa.md) · [RUSSIAN](README.md) · [SPANISH](README.es.md) · [TAMIL](README.ta.md) · [TELUGU](README.te.md) · [THAI](README.th.md) · [TIGRINYA](README.ti.md) · [TURKISH](README.tr.md) · [UKRAINIAN](README.uk.md) · [URDU](README.ur.md) · [UZBEK](README.uz.md) · [VIETNAMESE](README.vi.md)

**[Descargar (última versión)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

# AutoConnector for Telegram

AutoConnector for Telegram — la aplicación encuentra por sí misma proxies MTProto en internet, comprueba que estén activos y levanta un relé local a través del cual Telegram funciona de forma estable incluso allí donde está bloqueado. El usuario no necesita buscar proxies funcionales a mano: AutoConnector for Telegram selecciona constantemente los más rápidos y activos, probándolos precisamente desde tu ordenador o teléfono.

En otras palabras: es un escáner de canales de Telegram y de todo tipo de suscripciones con proxies MTProto públicos y gratuitos, con autoconfiguración en tu Telegram. No hace falta actualizar el cliente de Telegram. Comprueba la disponibilidad de los proxies precisamente desde tu dispositivo y tu entorno de red. Funciona con Wi-Fi y LTE sin VPN.

Plataformas: Android, Windows, Linux, MacBook.

La versión de Android funciona por sí sola, pero en Windows hay que activar el motor de proxy "SPLIT..." o "COALESCING.." — en los ajustes o con el botón situado a la derecha del texto "Telegram conectado" y del gran círculo gris/verde. O bien elegir el que mejor te funcione personalmente, ya que los bloqueos son distintos en cada sitio. Los modos "COALESCING.." son para casos extremos: así Telegram empezará a funcionar, pero se estropeará el envío/visualización de contenido multimedia en los chats.

Recomiendo desactivar cortafuegos del tipo COMODO si los usas: meten la aplicación en un sandbox y su cortafuegos arruina las conexiones salientes hacia los proxies MTProto. O bien ejecuta la aplicación en una máquina virtual: allí cambia por completo la pila TCP y el comportamiento de AutoConnector será distinto.

Y además ayuda a Telegram a mano a cambiar entre los puertos 55001 y 55002 (en los ajustes de proxy), para alcanzar más rápido un proxy funcional y que aparezca el mensaje "Conectado" dentro de Telegram.

# ✨ Funcionalidades

- **Búsqueda automática de proxies** — escanea decenas de páginas y suscripciones abiertas.
- **Comprobación de actividad** — handshake MTProto real, clasificación por velocidad/estabilidad.
- **Relé local** — Telegram se conecta a `127.0.0.1`, y AutoConnector for
  Telegram enruta el tráfico a través del mejor proxy activo y cambia de proxy
  si el actual se cae.
- **Anti-DPI** — un conjunto de trucos de enmascaramiento (imitación de navegadores, fragmentación
  de paquetes, FakeTLS, etc.); el modo «Prueba automática» selecciona por sí mismo el que funciona.
- **Estadísticas detalladas** — proxies activos/muertos, velocidad, latencia, tráfico,
  eficacia de cada truco anti-DPI.
- **Catálogo de proxies** — top por valoración con una ficha detallada de cada host:
  para cada host se muestra «conexiones de Telegram / exitosas / comprobaciones totales» y
  el historial de los últimos 25 intentos (TCP/TLS/duración total de la conexión, bytes recibidos/enviados).
- **Selección flexible de hosts** — control deslizante de «amplitud»: desde «atenerse a los mejores ya verificados»
  hasta «probar lo más ampliamente posible distintos hosts activos»; cuando Telegram va y viene entre los
  puertos del relé, la selección se amplía automáticamente. Un control deslizante aparte: el tiempo de espera
  de conexión (100 ms … 15 s) y la «carrera de upstreams» (varias conexiones en paralelo).
- **12 idiomas** de interfaz con detección automática, soporte RTL.

> ### Novedades respecto a 1.0.19
> - **Bases de datos y valoraciones de hosts separadas por tipo de red** — VPN / Wi-Fi / LTE /
>   Ethernet / White: cada tipo de conexión mantiene su propio grupo de proxies activos, para
>   no ofrecerle a Telegram algo que solo funciona bajo VPN.
> - **Carrera de upstreams** — varias conexiones en paralelo, gana la más rápida y activa;
>   control deslizante de «amplitud de selección» (desde los mejores verificados hasta lo más
>   amplio posible) con ampliación automática del grupo cuando Telegram va y viene entre los puertos del relé;
>   tiempo de espera de conexión configurable (100 ms…15 s).
> - **Catálogo de hosts con ficha detallada** — «conexiones de Telegram / exitosas /
>   comprobaciones totales» y el historial de los últimos 25 intentos por host (tiempos TCP/TLS,
>   duración de la conexión, bytes recibidos/enviados).
> - **Gráficos en vivo** de velocidad, ping y actividad de puertos (por segundos y por minutos)
>   y gráficos de escaneo.
> - **Anti-DPI y motores de proxy** — un conjunto de trucos de enmascaramiento con
>   «Prueba automática», motor de ofuscación y motores experimentales (split/
>   coalescing) para un bloqueo concreto.
> - **Exportación/importación** de ajustes, hosts y suscripciones + restablecimiento completo a valores de fábrica.
> - **Arranque en frío rápido** — descarga multihilo agresiva de suscripciones a través de
>   varios anonimizadores.
> - **26 idiomas** de interfaz con detección automática (+RTL).

# Al primer arranque es importante:

- Configurar Telegram indicando un proxy SOCKS5 fijo localhost:55001 y localhost:55002.
- Elimina los demás proxies, salvo estos.
- Activa en Telegram "Usar proxy".
- No bloquear las notificaciones en Android, de lo contrario no funcionará en segundo plano.
- En el primer arranque, espera ~15 minutos mientras descarga y prueba los proxies MTProto y mientras el propio cliente de Telegram cambia de proxy.

# Si no funciona nada

1. Si NO funciona NADA, usa el programa como un catálogo automático de proxies activos. Con las teclas rápidas CTRL+WIN+ALT+P y CTRL+SHIFT+ALT+P puedes añadir rápidamente, sin abrir la ventana de AutoConnector, un proxy aleatorio directamente a tu Telegram. Así, Telegram irá directamente al proxy, sin AutoConnector, pero no tendrás que monitorizar los chats donde publican proxies gratuitos ni perder tiempo comprobándolos. Deja que AutoConnector viva en la bandeja del sistema, desactiva el interruptor "Conector" y deja activado el interruptor "Escaneo".

2. Prueba AutoConnector en otro dispositivo: tu teléfono, el teléfono de un amigo, un ordenador. En distintas plataformas Windows/Android el principio para sortear los bloqueos es completamente diferente. Lo más probable es que en Android funcione sin ningún ajuste.

3. Si no funciona nada, activa temporalmente una VPN durante un día y prueba AutoConnector + Telegram ese día (conecta Telegram a través de AutoConnector, indicando el proxy en los puertos 55001 y 55002). Dentro del programa activa la casilla "Con la VPN activada -> proxiar hacia MTProto". Comprueba: ¿AutoConnector ha empezado a funcionar? Si es así, la conclusión es evidente: AutoConnector encuentra proxies correctamente, transmite correctamente hacia ellos el tráfico de Telegram, pero si apagas la VPN, el sistema de bloqueos de tu país bloquea de forma demasiado estricta todas las conexiones salientes. En ese caso tendrás que dedicar media hora a probar las distintas opciones de AutoConnector para encontrar una que funcione y sea capaz de sortear los bloqueos. El programa todavía no sabe probar automáticamente todas las variantes por completo (solo dispone de la prueba automática de trucos anti-DPI). Tras el experimento, apaga la VPN y devuelve la casilla "Con la VPN activada, proxiar hacia MTProto" al estado "Proxiar directamente".

4. Alternativa al punto (3). Instala una máquina virtual en tu host de Windows/Linux. En ella ejecuta Telegram + AutoConnector. ¿Ha empezado a funcionar perfectamente incluso sin VPN? ¡Entonces es tu host el que estropea tus conexiones, y no el sistema de bloqueos de tu país! Causas: cortafuegos, antivirus, restos de VPN. Si el antivirus mete AutoConnector en un sandbox, o el cortafuegos bloquea los inusuales trucos anti-DPI de AutoConnector, tendrás que ejecutar AutoConnector en el host saltándote (excepciones) el antivirus y el cortafuegos. O bien desactívalos por completo durante un tiempo y reinicia el ordenador. Sí, por muy gracioso que parezca el consejo, reinicia el ordenador, ya que los programas de VPN suelen fallar y pueden dejar en el host un dispositivo TUN en estado medio vivo. Tras reiniciar, no inicies la VPN: prueba primero AutoConnector.

  5. Prueba el sorteo de bloqueos. El botón de activación búscalo en los ajustes o en la pantalla principal (busca el botón a la derecha del gran círculo de color gris/verde). Tendrás que dedicarle unos ~15 minutos. Se compone de 3 grupos:
	  - Motor de proxy. Prueba cualquier modo Coalescing*. Lo más probable es que funcione enseguida. Pero entonces no se cargarán las imágenes/vídeos en Telegram (no es un bug, sino una característica/compromiso). Luego prueba los modos Split*: si funcionan, las imágenes sí se cargan. O bien vuelve a "desactivado".
	  - Prueba la "Carrera paralela de upstreams". Esto significa que cuando Telegram hace 1 conexión a un proxy, AutoConnector hace 5-30 conexiones a distintos proxies MTProto y le pasa a Telegram el mejor. En los ajustes de la aplicación puedes elegir los tiempos de espera (3-5 s) y el número de upstreams paralelos, hasta 30.
	  - Activa la "Prueba automática de trucos anti-DPI": el programa los irá probando por sí mismo.
	  - Para que Telegram cambie de proxy más rápido, en los ajustes de proxy (dentro de Telegram) cambia a mano cada 5-10 segundos al siguiente puerto, en círculo 55001->55002->55001->...
    
6. La combinación de ajustes más potente/rápida:
	- tiempo de espera de conexión 5 s
	- amplitud de selección de hosts 100 %
	- conexiones paralelas 30
	- prueba automática de trucos DPI
	- carrera paralela de upstreams
	- motor de proxy: Coalescing*
	- dentro de Telegram, en la ventana de proxies, pulsa cada 10 segundos en un puerto nuevo, en círculo.
  
7. ¡La política de configuración en Windows y Android es distinta! Todo lo escrito arriba se refiere principalmente a Windows. En Android, a la mayoría le funciona sin ningún ajuste (con cualquier configuración). En Windows hay otra pila TCP y otra aplicación de Telegram, que es mucho peor en calidad que la de Android. Prueba algún otro cliente de Telegram, no solo el oficial.

8. Por favor, escribe informes de errores detallados en cualquier idioma en https://t.me/AutoConnector_for_Telegram — la plataforma, qué métodos probaste (ajustes), si tienes cortafuegos/antivirus, si lo probaste desde VPN/máquina virtual. Escribe también cualquier receta positiva: qué probaste y cómo conseguiste que funcionara.


## 📥 Descargar

Todas las versiones están en la página de releases: **[GitHub Releases (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

| SO | Archivo | Ejecución |
|----|------|--------|
| **Android** | `AutoConnector_for_Telegram.apk` | instalar el APK (fuera de Google Play — permite la instalación desde la fuente) |
| **Windows** 10/11 x64 | `AutoConnector-for-Telegram-windows-x64.zip` | descomprimir → ejecutar `AutoConnector\AutoConnector.exe` |
| **Linux** x64 | `AutoConnector-for-Telegram-linux-x64.tar.gz` | descomprimir → `./AutoConnector/bin/AutoConnector` |
| **macOS** 11+ (Apple Silicon) | `AutoConnector-for-Telegram-macos.tar.gz` | descomprimir → doble clic en `AutoConnector.app` (si lo bloquea — `xattr -dr com.apple.quarantine AutoConnector.app`) |

### 🔐 Verificación de autenticidad (release 1.1.0)

El APK está firmado con un certificado de release (apksigner, esquemas v1+v2+v3). Antes de instalarlo puedes verificarlo:

- **Certificado de firma (SHA-256):** `cb23a18c0cf8a23e43b5b63d199fc1440d3e4d6533e1309d3f92f273fe626a5a`
  (CN=AutoConnector for Telegram) — esta huella es la misma para todos los releases futuros.
- **APK SHA-256:** `d7652e7f5c3a2174a3b7805c2539df7da080765c9b0f581a7ac5943987c9b935`
- **Windows zip SHA-256:** `1d8d675936387e89038dc4943d7f99200c1b735b86e1f79bd953cd93e60f0217`
- **Linux tar.gz SHA-256:** `9160ea519309dc62750a4a930dc1aae6e20dbcefd21b426fa85b48ace6f3e8f8`
- **macOS tar.gz SHA-256:** `322082ef3f06955ed299be790bce453e47db37fca17daea54724d60698446bc7`

Verificación: `apksigner verify --print-certs AutoConnector_for_Telegram.apk` (certificado) y
`sha256sum -c SHA256SUMS.txt` (integridad de los archivos; `SHA256SUMS.txt` se adjunta al release).

## 📸 Capturas de pantalla

<table>
<tr>
<td align="center"><img src="docs/screenshots/connector.png" width="200"><br><sub>Conector — sesión activa</sub></td>
<td align="center"><img src="docs/screenshots/scan.png" width="200"><br><sub>Escaneo y gráficos</sub></td>
<td align="center"><img src="docs/screenshots/catalog.png" width="200"><br><sub>Catálogo de proxies (por modos)</sub></td>
<td align="center"><img src="docs/screenshots/host-card.png" width="200"><br><sub>Ficha del host + historial</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/logs.png" width="200"><br><sub>Registros del relé</sub></td>
<td align="center"><img src="docs/screenshots/settings.png" width="200"><br><sub>Ajustes</sub></td>
<td align="center"><img src="docs/screenshots/export.png" width="200"><br><sub>Exportación de enlaces tg://</sub></td>
<td align="center"><img src="docs/screenshots/hotkeys.png" width="200"><br><sub>Teclas rápidas</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/guide.png" width="200"><br><sub>Guía de conexión</sub></td>
<td align="center"><img src="docs/screenshots/connector-ru.png" width="200"><br><sub>Conector · interfaz en ruso</sub></td>
<td align="center"><img src="docs/screenshots/scan-ru.png" width="200"><br><sub>Escaneo · interfaz en ruso</sub></td>
<td align="center"><sub>26 idiomas de interfaz<br>con detección automática</sub></td>
</tr>
</table>


## Comentarios

Envía los errores y observaciones aquí - https://t.me/AutoConnector_for_Telegram

## 🔐 Verificación de la firma

El APK de los releases está firmado con una clave de release. Se puede verificar así:

```bash
# Suma de comprobación (compárala con SHA256SUMS.txt del release)
sha256sum AutoConnector_for_Telegram.apk

# Firma digital y huella del certificado
apksigner verify --print-certs AutoConnector_for_Telegram.apk
```

La huella del certificado (SHA-256) con la que se firman las versiones oficiales
se publica en la descripción de cada release: compárala para asegurarte de que el APK
no ha sido alterado.

## 📄 Licencia

[MIT](LICENSE).
