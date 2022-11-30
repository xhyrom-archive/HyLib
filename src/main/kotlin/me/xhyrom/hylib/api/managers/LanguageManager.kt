package me.xhyrom.hylib.api.managers

import me.xhyrom.hylib.api.structs.Language
import org.bukkit.plugin.Plugin

class LanguageManager {
    fun register(plugin: Plugin): Language {
        return Language(
            plugin
        )
    }
}