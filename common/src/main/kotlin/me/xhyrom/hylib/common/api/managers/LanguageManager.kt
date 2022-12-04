package me.xhyrom.hylib.common.api.managers

import me.xhyrom.hylib.common.api.structs.Language
import java.io.InputStream

interface LanguageManager {
    fun register(dataFolder: String, getResource: (key: String) -> InputStream): Language
}