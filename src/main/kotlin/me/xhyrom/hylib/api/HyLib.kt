package me.xhyrom.hylib.api

import me.xhyrom.hylib.api.managers.BStatsManager
import me.xhyrom.hylib.api.managers.CommandManager
import me.xhyrom.hylib.api.managers.ConfigManager
import me.xhyrom.hylib.api.managers.LanguageManager
import org.bukkit.plugin.java.JavaPlugin

class HyLib(val plugin: JavaPlugin) {
    private val commandManager = CommandManager()
    private val configManager = ConfigManager()
    private val languageManager = LanguageManager()
    private val bStatsManager = BStatsManager(plugin)

    companion object {
        private var instance: HyLib? = null

        fun getInstance(): HyLib {
            if (instance == null) throw Exception("HyLib is not initialized!")

            return instance!!
        }
    }

    init {
        instance = this
    }

    fun getCommandManager(): CommandManager {
        return commandManager
    }

    fun getConfigManager(): ConfigManager {
        return configManager
    }

    fun getLanguageManager(): LanguageManager {
        return languageManager
    }

    fun getBStatsManager(): BStatsManager {
        return bStatsManager
    }
}