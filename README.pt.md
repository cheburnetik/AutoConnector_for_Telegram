[ENGLISH](README.en.md) · [ARABIC](README.ar.md) · [BENGALI](README.bn.md) · [BURMESE](README.my.md) · [CHINESE](README.zh.md) · [FRENCH](README.fr.md) · [GERMAN](README.de.md) · [HINDI](README.hi.md) · [INDONESIAN](README.id.md) · [ITALIAN](README.it.md) · [JAPANESE](README.ja.md) · [KOREAN](README.ko.md) · [MARATHI](README.mr.md) · [PERSIAN](README.fa.md) · [POLISH](README.pl.md) · [PORTUGUESE](README.pt.md) · [PUNJABI](README.pa.md) · [RUSSIAN](README.md) · [SPANISH](README.es.md) · [TAMIL](README.ta.md) · [TELUGU](README.te.md) · [THAI](README.th.md) · [TURKISH](README.tr.md) · [UKRAINIAN](README.uk.md) · [URDU](README.ur.md) · [VIETNAMESE](README.vi.md)

**[Download (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

# AutoConnector for Telegram

AutoConnector for Telegram — o aplicativo encontra sozinho na internet proxies MTProto, verifica se estão ativos e levanta um relay local, através do qual o Telegram funciona de forma estável até onde ele está bloqueado. O usuário não precisa procurar manualmente proxies que funcionam — o AutoConnector for Telegram seleciona constantemente os mais rápidos e ativos, testando-os exatamente a partir do seu computador/telefone.

Em outras palavras: é um scanner de canais do Telegram e de todo tipo de assinaturas com proxies MTProto públicos e gratuitos, com substituição automática no seu Telegram. Não é necessário atualizar o cliente do Telegram. A disponibilidade dos proxies é verificada exatamente a partir do seu dispositivo e do seu ambiente de rede. Funciona em Wi-Fi+LTE sem VPN.

Plataformas: Android, Windows, Linux, MacBook.

A versão Android funciona por conta própria, mas no Windows é preciso ativar o motor de proxy "SPLIT..." ou "COALESCING.." — nas configurações ou no botão à direita das palavras "Telegram conectado" e do grande círculo cinza/verde. Ou escolher aquele que funcionar melhor para você pessoalmente, já que os bloqueios são diferentes em todo lugar. Os modos "COALESCING.." são para casos extremos — assim o Telegram começa a funcionar, mas o envio/exibição de conteúdo de mídia nos chats fica prejudicado.

Recomendo desativar firewalls do tipo COMODO, se você os usa: eles colocam o aplicativo em uma sandbox e seu firewall estraga as conexões de saída para os proxies MTProto. Ou execute o aplicativo em uma máquina virtual, lá a pilha TCP muda completamente e o comportamento do AutoConnector será diferente.

E também ajude manualmente o Telegram a alternar entre as portas 55001 e 55002 (nas configurações de proxy), para alcançar mais rápido um proxy que funcione e ver a mensagem "Conectado" dentro do Telegram.

# ✨ Recursos

- **Busca automática de proxies** — varre dezenas de páginas e assinaturas abertas.
- **Verificação de atividade** — handshake MTProto real, classificação por velocidade/estabilidade.
- **Relay local** — o Telegram se conecta a `127.0.0.1`, e o AutoConnector for
  Telegram roteia o tráfego através do melhor proxy ativo e troca,
  se o atual cair.
- **Anti-DPI** — um conjunto de truques de mascaramento (imitação de navegadores, fragmentação
  de pacotes, FakeTLS e outros); o modo «Tentativa automática» seleciona sozinho o que funciona.
- **Estatísticas detalhadas** — proxies ativos/mortos, velocidade, latência, tráfego,
  eficiência de cada truque anti-DPI.
- **Catálogo de proxies** — top por classificação com um cartão detalhado de cada host:
  para cada host é possível ver «conexões do Telegram / bem-sucedidas / total de verificações» e
  o histórico das últimas 25 tentativas (TCP/TLS/duração total da conexão, bytes recebidos/enviados).
- **Seleção flexível de hosts** — controle deslizante de «amplitude»: de «manter-se nos melhores comprovados»
  a «tentar o mais amplamente possível diferentes proxies ativos»; quando o Telegram fica trocando entre
  as portas do relay, a seleção é ampliada automaticamente. Um controle deslizante separado — o timeout
  de conexão (100 ms … 15 s) e a «corrida de upstreams» (várias conexões em paralelo).
- **12 idiomas** de interface com detecção automática, suporte a RTL.

> ### O que há de novo em relação à 1.0.19
> - **Bases e classificações de hosts separadas por tipo de rede** — VPN / Wi-Fi / LTE /
>   Ethernet / White: cada tipo de conexão mantém seu próprio pool de proxies ativos, para
>   não passar ao Telegram algo que só funciona sob VPN.
> - **Corrida de upstreams** — várias conexões em paralelo, vence a mais
>   rápida e ativa; controle deslizante de «amplitude de seleção» (dos melhores comprovados ao mais
>   amplo) com auto-expansão do pool quando o Telegram fica trocando entre as portas do relay;
>   timeout de conexão configurável (100 ms…15 s).
> - **Catálogo de hosts com cartão detalhado** — «conexões do Telegram / bem-sucedidas /
>   total de verificações» e histórico das últimas 25 tentativas por host (tempo de TCP/TLS,
>   duração da conexão, bytes recebidos/enviados).
> - **Gráficos ao vivo** de velocidade, ping e atividade das portas (por segundos e minutos)
>   e gráficos de varredura.
> - **Anti-DPI e motores de proxy** — um conjunto de truques de mascaramento com
>   «Tentativa automática», motor de ofuscação e motores experimentais (split/
>   coalescing) para um bloqueio específico.
> - **Exportar/importar** configurações, hosts e assinaturas + redefinição completa para o estado de fábrica.
> - **Início a frio rápido** — carregamento multithread agressivo de assinaturas através de
>   vários anonimizadores.
> - **26 idiomas** de interface com detecção automática (+RTL).

# Na primeira execução é importante:

- Configurar o Telegram, indicando um proxy SOCKS5 fixo localhost:55001 e localhost:55002.
- Remova outros proxies, exceto esses.
- Ative no Telegram a opção "Usar proxy".
- Não bloquear notificações no Android, caso contrário não funcionará em segundo plano.
- Na primeira execução, espere ~15 minutos enquanto baixa e testa os proxies MTProto e enquanto o próprio cliente do Telegram troca.

# Se nada funcionar

1. Se NADA funcionar, use o programa como um catálogo automático de proxies ativos. Com o atalho CTRL+WIN+ALT+P e CTRL+SHIFT+ALT+P você pode rapidamente, sem abrir a janela do AutoConnector, adicionar um proxy aleatório diretamente no seu Telegram. Assim, o Telegram irá direto ao proxy, sem o AutoConnector, mas você não precisará monitorar os chats onde publicam proxies gratuitos nem gastar tempo verificando-os. Deixe o AutoConnector na bandeja, desligue o interruptor "Conector", deixe o interruptor "Scan" ligado.

2. Experimente o AutoConnector em outro dispositivo: telefone, telefone de um amigo, computador. Em plataformas diferentes Windows/Android o princípio de contorno de bloqueios é completamente diferente. Provavelmente no Android funcionará sem nenhuma configuração.

3. Se nada funcionar, ative temporariamente uma VPN por um dia e teste o AutoConnector + Telegram nesse dia (conecte o Telegram através do AutoConnector, indicando os proxies nas portas 55001 e 55002). Dentro do programa, ative a caixa "Com a VPN ligada -> proxiar para o MTProto". Veja, o AutoConnector começou a funcionar? Se sim, a conclusão é óbvia — o AutoConnector encontra proxies com sucesso, transmite com sucesso o tráfego do Telegram para lá, mas se você desligar a VPN, o sistema de bloqueios no seu país bloqueia de forma muito rígida todas as conexões de saída. Nesse caso, você terá que gastar meia hora testando recursos no AutoConnector para encontrar um que funcione e consiga contornar os bloqueios. O programa ainda não sabe testar automaticamente todas as opções completamente (existe apenas a tentativa automática de truques anti-DPI). Após o experimento, desligue a VPN e devolva a caixa "Com a VPN ligada, proxiar para o MTProto" ao estado "Proxiar diretamente".

4. Alternativa ao item (3). Instale uma máquina virtual no seu host Windows/Linux. Nela, execute o Telegram + AutoConnector. Começou a funcionar perfeitamente mesmo sem VPN? Então é o seu host que estraga suas conexões, e não o sistema de bloqueios do seu país! Causas: firewalls, antivírus, resíduos de VPN. Se o antivírus coloca o AutoConnector em uma sandbox, ou o firewall bloqueia os truques anti-DPI incomuns do AutoConnector, então você terá que ativar o AutoConnector no host contornando (exceções) o antivírus e o firewall. Ou desligue-os completamente por um tempo, reiniciando o computador. Sim, por mais engraçado que pareça aconselhar, reinicie o computador, pois os programas de VPN frequentemente bugam e podem deixar no host um dispositivo TUN em estado semivivo. Após reiniciar, não inicie a VPN, primeiro teste o AutoConnector.

  5. Experimente o contorno de bloqueios. Procure o botão de ativação nas configurações ou na tela inicial (procure o botão à direita do grande círculo de cor cinza/verde). Você terá que dedicar ~15 minutos. Eles consistem em 3 grupos:
	  - Motor de proxy. Experimente qualquer modo Coalescing*. Provavelmente funcionará de imediato. Mas com isso as imagens/vídeos não carregarão no Telegram (isso não é um bug, é um recurso/compromisso). Em seguida, experimente os modos Split*, se funcionar — as imagens carregam. Ou volte para "desativado".
	  - Experimente a "Corrida paralela de upstreams". Isso significa que quando o Telegram faz 1 conexão a um proxy, o AutoConnector faz 5-30 conexões a diferentes proxies MTProto e passa ao Telegram o melhor. Nas configurações do aplicativo é possível escolher os timeouts (3-5 seg) e o número de upstreams paralelos até 30.
	  - Ative a "Tentativa automática de truques anti-DPI", o programa fará a tentativa por conta própria.
	  - Para que o Telegram troque mais rápido, nas configurações de proxy (no Telegram) alterne manualmente a cada 5-10 segundos para a próxima porta em círculo 55001->55002->55001->...

6. A combinação de configurações mais potente/rápida:
	- timeout de conexões 5s
	- amplitude de seleção de hosts 100%
	- conexões paralelas 30
	- tentativa automática de truques DPI
	- corrida paralela de upstreams
	- motor de proxy: Coalescing*
	- dentro do Telegram, na janela de proxies, toque em uma nova porta a cada 10 segundos, em círculo.

7. A política de configuração no Windows e no Android é diferente! Tudo o que está escrito acima refere-se principalmente ao Windows. No Android, para a maioria das pessoas funciona sem nenhuma configuração (com qualquer configuração). No Windows há uma pilha TCP diferente e um aplicativo do Telegram diferente, ele é muito pior em qualidade do que o do Android. Experimente algum outro cliente do Telegram, e não apenas o oficial.

8. Por favor, escreva relatórios de bugs detalhados em qualquer idioma em https://t.me/AutoConnector_for_Telegram — plataforma, quais métodos você tentou (configurações), se você tem firewall/antivírus, se tentou a partir de VPN/máquina virtual. Escreva também quaisquer receitas positivas, o que você tentou e como funcionou.


## 📥 Download

Todas as builds estão na página de releases: **[GitHub Releases (latest)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

| SO | Arquivo | Execução |
|----|------|--------|
| **Android** | `AutoConnector_for_Telegram.apk` | instalar o APK (fora do Google Play — permita a instalação de fonte) |
| **Windows** 10/11 x64 | `AutoConnector-for-Telegram-windows-x64.zip` | descompactar → executar `AutoConnector\AutoConnector.exe` |
| **Linux** x64 | `AutoConnector-for-Telegram-linux-x64.tar.gz` | descompactar → `./AutoConnector/bin/AutoConnector` |
| **macOS** 11+ (Apple Silicon) | `AutoConnector-for-Telegram-macos.tar.gz` | descompactar → duplo clique em `AutoConnector.app` (se bloquear — `xattr -dr com.apple.quarantine AutoConnector.app`) |

### 🔐 Verificação de autenticidade (release 1.1.0)

O APK é assinado com um certificado de release (apksigner, esquemas v1+v2+v3). Antes de instalar, você pode conferir:

- **Certificado de assinatura (SHA-256):** `cb23a18c0cf8a23e43b5b63d199fc1440d3e4d6533e1309d3f92f273fe626a5a`
  (CN=AutoConnector for Telegram) — esta impressão digital é a mesma para todos os releases futuros.
- **APK SHA-256:** `d7652e7f5c3a2174a3b7805c2539df7da080765c9b0f581a7ac5943987c9b935`
- **Windows zip SHA-256:** `1d8d675936387e89038dc4943d7f99200c1b735b86e1f79bd953cd93e60f0217`
- **Linux tar.gz SHA-256:** `9160ea519309dc62750a4a930dc1aae6e20dbcefd21b426fa85b48ace6f3e8f8`
- **macOS tar.gz SHA-256:** `322082ef3f06955ed299be790bce453e47db37fca17daea54724d60698446bc7`

Verificação: `apksigner verify --print-certs AutoConnector_for_Telegram.apk` (certificado) e
`sha256sum -c SHA256SUMS.txt` (integridade dos arquivos; o `SHA256SUMS.txt` está anexado ao release).

## 📸 Capturas de tela

<table>
<tr>
<td align="center"><img src="docs/screenshots/connector.png" width="200"><br><sub>Conector — sessão ativa</sub></td>
<td align="center"><img src="docs/screenshots/scan.png" width="200"><br><sub>Scan e gráficos</sub></td>
<td align="center"><img src="docs/screenshots/catalog.png" width="200"><br><sub>Catálogo de proxies (por modos)</sub></td>
<td align="center"><img src="docs/screenshots/host-card.png" width="200"><br><sub>Cartão do host + histórico</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/logs.png" width="200"><br><sub>Logs do relay</sub></td>
<td align="center"><img src="docs/screenshots/settings.png" width="200"><br><sub>Configurações</sub></td>
<td align="center"><img src="docs/screenshots/export.png" width="200"><br><sub>Exportação de links tg://</sub></td>
<td align="center"><img src="docs/screenshots/hotkeys.png" width="200"><br><sub>Teclas de atalho</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/guide.png" width="200"><br><sub>Guia de conexão</sub></td>
<td align="center"><img src="docs/screenshots/connector-ru.png" width="200"><br><sub>Conector · interface em russo</sub></td>
<td align="center"><img src="docs/screenshots/scan-ru.png" width="200"><br><sub>Scan · interface em russo</sub></td>
<td align="center"><sub>26 idiomas de interface<br>com detecção automática</sub></td>
</tr>
</table>


## Feedback

Envie bugs e observações para cá - https://t.me/AutoConnector_for_Telegram

## 🔐 Verificação de assinatura

O APK dos releases é assinado com uma chave de release. Você pode verificar assim:

```bash
# Soma de verificação (compare com SHA256SUMS.txt do release)
sha256sum AutoConnector_for_Telegram.apk

# Assinatura digital e impressão digital do certificado
apksigner verify --print-certs AutoConnector_for_Telegram.apk
```

A impressão digital do certificado (SHA-256), com a qual as builds oficiais são assinadas,
é publicada na descrição de cada release — confira-a para ter certeza de que o APK
não foi adulterado.

## 📄 Licença

[MIT](LICENSE).
