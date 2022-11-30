package me.xhyrom.hylib.api.managers

import me.xhyrom.hylib.api.structs.Config
import org.bukkit.plugin.Plugin

class ConfigManager {
    fun registerConfig(plugin: Plugin, name: String): Config {
        return Config(
            plugin,
            name
        )
    }
}