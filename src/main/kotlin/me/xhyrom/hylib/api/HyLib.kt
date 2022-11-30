package me.xhyrom.hylib.api

import me.xhyrom.hylib.api.managers.CommandManager
import me.xhyrom.hylib.api.managers.ConfigManager

class HyLib {
    private val commandManager = CommandManager()
    private val configManager = ConfigManager()
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
}