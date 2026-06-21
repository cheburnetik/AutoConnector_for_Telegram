package io.autoconnector.i18n

/**
 * One selectable UI language: its 2-letter code, English name, native endonym,
 * and a few flag emojis (space-separated) of the largest countries that speak
 * it — shown AFTER the name in both language pickers. Centralised here so the
 * two pickers stay in sync and adding a language is a one-line change.
 */
data class LangEntry(val code: String, val english: String, val native: String, val flags: String)

/**
 * Every concrete language offered, roughly by global speaker count. "auto"
 * (follow the system) is handled separately by the pickers — its label comes
 * from [Strings.langAuto] — so it is intentionally NOT in this list.
 *
 * Flags are space-separated so they render as distinct flags/country codes
 * rather than running together.
 */
val LANGUAGES: List<LangEntry> = listOf(
    LangEntry("en", "English",              "English",          "🇬🇧 🇺🇸"),
    LangEntry("zh", "Chinese (Simplified)", "简体中文",          "🇨🇳"),
    LangEntry("hi", "Hindi",                "हिन्दी",            "🇮🇳"),
    LangEntry("es", "Spanish",              "Español",          "🇪🇸 🇲🇽"),
    LangEntry("fr", "French",               "Français",         "🇫🇷"),
    LangEntry("ar", "Arabic",               "العربية",          "🇸🇦 🇪🇬"),
    LangEntry("bn", "Bengali",              "বাংলা",            "🇧🇩 🇮🇳"),
    LangEntry("pt", "Portuguese",           "Português",        "🇧🇷 🇵🇹"),
    LangEntry("ru", "Russian",              "Русский",          "🇷🇺"),
    LangEntry("ur", "Urdu",                 "اردو",             "🇵🇰 🇮🇳"),
    LangEntry("id", "Indonesian",           "Bahasa Indonesia", "🇮🇩"),
    LangEntry("de", "German",               "Deutsch",          "🇩🇪 🇦🇹"),
    LangEntry("ja", "Japanese",             "日本語",            "🇯🇵"),
    LangEntry("ko", "Korean",               "한국어",            "🇰🇷"),
    LangEntry("tr", "Turkish",              "Türkçe",           "🇹🇷"),
    LangEntry("vi", "Vietnamese",           "Tiếng Việt",       "🇻🇳"),
    LangEntry("it", "Italian",              "Italiano",         "🇮🇹"),
    LangEntry("th", "Thai",                 "ไทย",              "🇹🇭"),
    LangEntry("pl", "Polish",               "Polski",           "🇵🇱"),
    LangEntry("uk", "Ukrainian",            "Українська",       "🇺🇦"),
    LangEntry("ta", "Tamil",                "தமிழ்",            "🇮🇳 🇱🇰"),
    LangEntry("te", "Telugu",               "తెలుగు",           "🇮🇳"),
    LangEntry("mr", "Marathi",              "मराठी",            "🇮🇳"),
    LangEntry("pa", "Punjabi",              "ਪੰਜਾਬੀ",           "🇮🇳 🇵🇰"),
    LangEntry("fa", "Persian",              "فارسی",            "🇮🇷"),
    LangEntry("my", "Burmese",              "မြန်မာ",           "🇲🇲"),
    // Censorship-priority additions.
    LangEntry("uz", "Uzbek",                "Oʻzbekcha",        "🇺🇿"),
    LangEntry("az", "Azerbaijani",          "Azərbaycan",       "🇦🇿"),
    LangEntry("kk", "Kazakh",               "Қазақша",          "🇰🇿"),
    LangEntry("ps", "Pashto",               "پښتو",             "🇦🇫 🇵🇰"),
    LangEntry("prs", "Dari",                "دری",              "🇦🇫"),
    LangEntry("am", "Amharic",              "አማርኛ",            "🇪🇹"),
    LangEntry("ti", "Tigrinya",             "ትግርኛ",            "🇪🇷 🇪🇹"),
    LangEntry("ha", "Hausa",                "Hausa",            "🇳🇬 🇳🇪"),
)

/** Picker label with flags on the RIGHT, e.g. "Spanish (Español)  🇪🇸 🇲🇽". */
fun langMenuLabel(e: LangEntry): String = "${e.english} (${e.native})  ${e.flags}"
