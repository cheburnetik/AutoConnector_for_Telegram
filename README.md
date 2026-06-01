# AutoConnector for Telegram

**AutoConnector for Telegram** — кросс-платформенный авто-коннектор: приложение
само находит в интернете MTProto-прокси, проверяет их на живость и поднимает
локальный релей, через который Telegram стабильно работает даже там, где он
заблокирован. Пользователю не нужно вручную искать рабочие прокси — AutoConnector
for Telegram постоянно подбирает самые быстрые и живые.

## 📥 Скачать

Готовый подписанный APK — на странице релизов GitHub:

### **➡️ [Скачать последний APK (GitHub Releases)](https://github.com/cheburnetik/AutoConnector_for_Telegram/releases/latest)**

APK подписан цифровой подписью. Как проверить подпись и контрольную сумму —
см. раздел [«Проверка подписи»](#-проверка-подписи) ниже.

> Приложение распространяется как APK напрямую (вне Google Play). Прокси
> AutoConnector for Telegram не предоставляет и не «сочиняет» сам — он лишь
> ищет публично доступные прокси по множеству открытых источников.

### Установка

1. Скачайте APK по ссылке выше.
2. При установке Android может попросить разрешить установку из этого источника
   — разрешите для браузера/файлового менеджера, откуда ставите.
3. Google Play Protect может показать «Неизвестное приложение». Это **штатное**
   предупреждение для **любого** приложения вне Google Play, а не признак вируса —
   нажмите «Подробнее» → «Всё равно установить». Чтобы убедиться, что APK
   подлинный и не подменён, сверьте подпись и контрольную сумму (раздел ниже).

APK подписан стабильным release-сертификатом (схемы подписи APK v2 + v3),
поэтому обновления устанавливаются поверх предыдущей версии без переустановки.

## ✨ Возможности

- **Авто-поиск прокси** — сканирует десятки открытых страниц и подписок.
- **Проверка на живость** — реальный MTProto-handshake, рейтинг по скорости/стабильности.
- **Локальный релей** — Telegram подключается к `127.0.0.1`, а AutoConnector for
  Telegram маршрутизирует трафик через лучший живой прокси и переключается,
  если текущий упал.
- **Анти-DPI** — набор хитростей маскировки (имитация браузеров, дробление
  пакетов, FakeTLS и др.); режим «Авто-перебор» сам подбирает рабочий.
- **Подробная статистика** — живые/мёртвые прокси, скорость, латенси, трафик,
  эффективность каждой анти-DPI хитрости.
- **Каталог прокси** — топ по рейтингу с детальной карточкой по каждому хосту.

## 📸 Скриншоты

<table>
<tr>
<td align="center"><img src="docs/screenshots/connector.png" width="200"><br><sub>Коннектор — Telegram подключён</sub></td>
<td align="center"><img src="docs/screenshots/scan.png" width="200"><br><sub>Скан и статистика</sub></td>
<td align="center"><img src="docs/screenshots/catalog.png" width="200"><br><sub>Каталог прокси</sub></td>
<td align="center"><img src="docs/screenshots/logs.png" width="200"><br><sub>Логи релея</sub></td>
</tr>
<tr>
<td align="center"><img src="docs/screenshots/settings.png" width="200"><br><sub>Настройки</sub></td>
<td align="center"><img src="docs/screenshots/subscriptions.png" width="200"><br><sub>Подписки (источники)</sub></td>
<td align="center"><img src="docs/screenshots/export.png" width="200"><br><sub>Экспорт tg://-ссылок</sub></td>
<td align="center"><img src="docs/screenshots/connector-active.png" width="200"><br><sub>Коннектор — активная сессия</sub></td>
</tr>
</table>

## 🏗️ Архитектура

Стек — **Kotlin Multiplatform (KMP) + Compose Multiplatform**.

Суть приложения — нативный сетевой движок (слушающие TCP-сокеты, MTProto-крипто
на сырых сокетах, фоновые задачи, SQLite), поэтому KMP переиспользует один движок
и даёт единый адаптивный UI на все платформы.

| Модуль | Что внутри |
|---|---|
| `commonMain` | общий UI на Compose, модели, бизнес-логика |
| `androidMain` | foreground-service релей, Android-специфика, движок |
| `jvmMain` *(план)* | desktop-релей (Windows/macOS/Linux), tray |
| `iosMain` *(план)* | Kotlin/Native для Network Extension |

Принцип: один Compose-UI в `commonMain`, адаптивный по ширине окна — отдельной
вёрстки под телефон и ПК нет.

### Целевые платформы

Windows, macOS, Linux (desktop), Android, iOS. На текущий момент собрана и
работает **Android-версия**; desktop и iOS — в планах.

> **iOS — особенность платформы.** iOS на уровне ОС запрещает локальный
> релей-демон со слушающими сокетами (только через Network Extension с
> платным Apple Dev-аккаунтом). Это ограничение самой iOS, не фреймворка;
> crypto/relay-логику на Kotlin/Native можно затащить внутрь Network Extension.

## 🔧 Сборка

Требования: JDK 17, Android SDK (compileSdk 34), Gradle 8.7+.

```bash
# Debug-сборка
gradle :composeApp:assembleDebug

# Release-сборка (неподписанная)
gradle :composeApp:assembleRelease
```

Стек версий: Kotlin 2.0.21 · AGP 8.5.2 · Compose Multiplatform 1.6.11.

APK: `composeApp/build/outputs/apk/`.

## 🔐 Проверка подписи

APK из релизов подписан release-ключом. Проверить можно так:

```bash
# Контрольная сумма (сравните с SHA256SUMS.txt из релиза)
sha256sum AutoConnector_for_Telegram.apk

# Цифровая подпись и отпечаток сертификата
apksigner verify --print-certs AutoConnector_for_Telegram.apk
```

Отпечаток сертификата (SHA-256), которым подписаны официальные сборки,
публикуется в описании каждого релиза — сверьте его, чтобы убедиться, что APK
не подменён.

## 📄 Лицензия

[MIT](LICENSE).
