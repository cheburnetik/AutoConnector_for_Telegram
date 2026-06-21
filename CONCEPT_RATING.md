# Концепт: рейтинг хостов и порядок проб апстримов под запрос Telegram

## Проблема (что нашли в коде)
- **Рейтинг 0–9** = `min(9, max(1, score/10))`, где `score = (ratio*70 + rttFactor*25) * confidence * freshness`,
  `ratio = successes/(successes+failures)` (`check/Rating.java`).
- `successes/failures/score` обновляют **только фоновые проверки** (`CheckRunner` → `Rating.record` → `ProxyStore.updateStats/recordProbe`).
- Реальный **релей Telegram**:
  - УСПЕХ → `markAliveFromRelay` (`successes+1`, без пересчёта score) + `markRelaySuccess` (per-mode `successes+1`).
  - **ПРОВАЛ → `logFailedAttempt` только ПИШЕТ в лог (сэмпл 1/8), НЕ трогает score/failures/alive.**
- Выбор кандидатов (`RelayConnection.acquireUpstream`): sticky → `topAliveForMode` (`ORDER BY score DESC`) → `randomAliveForMode` → global. Реальные исходы Telegram **не учитываются**; cooldown/quarantine для проблемных хостов **нет**.
- Итог: хост, проходящий фоновые проверки, держит **9/9** бесконечно, хотя все реальные коннекты Telegram через него падают — и его продолжают выбирать первым.

## Принципы политики
1. **Реальный исход релея Telegram — первоклассный сигнал**, не слабее фоновой проверки.
2. Провал релея **штрафует** хост (тот же `score`), успех — **поощряет** и пересчитывает score.
3. **Подряд-провалы → временный cooldown**: хост исключается из обычного выбора на растущий backoff; снимается любым успехом релея (или истечением времени).
4. **Разведка сохраняется**: рандом-срез и фоновые проверки дают остывшим хостам шанс восстановиться.
5. **Отображаемый рейтинг отражает реальную пригодность** к Telegram (не только проверки).
6. Деградация **graceful**: если живых/не-остывших хостов не осталось — последний резерв игнорирует cooldown (лучше остывший, чем прямой коннект).

## Механика
### Учёт исходов релея (global + per-mode)
- УСПЕХ (`markRelaySuccess`): `successes+1`, `consec_fail=0`, `cool_until=0`, пересчёт `score`.
- ПРОВАЛ (`markRelayFailure`): `failures+1`, `consec_fail+1`; при `consec_fail >= COOL_AFTER(=3)` → `cool_until = now + backoff(consec_fail)`; пересчёт `score`.
- `backoff = min(30 мин, 60с * 2^(consec_fail-3))` → 60с, 120с, 240с, 480с, 960с, 1800с(кап).
- Анти-шторм: на один и тот же хост учёт провала не чаще раза в `FAIL_DEBOUNCE_MS(=8с)` (Telegram открывает много сокетов; cooldown и так выводит хост из пула после порога).

### Хранилище (DB)
- Новые колонки в таблице хостов `proxies` и в `proxy_mode_stats`: `consec_fail INTEGER DEFAULT 0`, `cool_until INTEGER DEFAULT 0`. Бамп `DB_VERSION` + `onUpgrade` (ALTER ADD COLUMN, без сноса данных).

### Выбор кандидатов
- `topAlive/topAliveForMode/randomAlive/randomAliveForMode`: добавить `AND cool_until < ?(now)` — остывшие не попадают в обычный пул.
- `stickyUpstream`/sticky-кандидат: пропускать, если `cool_until > now`.
- Последний резерв (когда обычный пул пуст): отдельные запросы **без** фильтра cooldown.
- Порядок (`ORDER BY score DESC, rtt_ms ASC`) не меняется — но score теперь включает реальные TG-исходы, так что проблемные хосты сами уезжают вниз и в cooldown.

### Отображение
- Рейтинг 0–9 считается из `score` → автоматически падает у хостов с плохой историей Telegram.
- В карточке хоста: пометка cooldown («⏳ остыл до …») когда `cool_until > now` (информативно).

## Вне рамок (пока)
- Отдельная ML-модель/EWMA по времени суток. Текущая `ratio`-модель достаточно реагирует на реальные исходы.
