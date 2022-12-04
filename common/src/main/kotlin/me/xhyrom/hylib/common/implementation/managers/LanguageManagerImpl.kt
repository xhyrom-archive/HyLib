package me.xhyrom.hylib.common.implementation.managers

import me.xhyrom.hylib.common.api.managers.LanguageManager
import me.xhyrom.hylib.common.api.structs.Language
import me.xhyrom.hylib.common.implementation.structs.LanguageImpl
import java.io.InputStream

class LanguageManagerImpl : LanguageManager {
    override fun register(dataFolder: String, getResource: (key: String) -> InputStream): Language {
        return LanguageImpl(dataFolder, getResource)
    }
}