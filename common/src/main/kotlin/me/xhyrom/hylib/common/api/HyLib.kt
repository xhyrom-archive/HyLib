package me.xhyrom.hylib.common.api

import me.xhyrom.hylib.common.api.managers.*

interface HyLib {
    fun getBStatsManager(): BStatsManager

    fun getConfigManager(): ConfigManager
    fun getLanguageManager(): LanguageManager

    fun getCommandManager(): CommandManager

    fun getUtilsManager(): UtilsManager
}