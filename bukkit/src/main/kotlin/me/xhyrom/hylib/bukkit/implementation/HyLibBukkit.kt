package me.xhyrom.hylib.bukkit.implementation

import dev.jorel.commandapi.CommandAPI
import dev.jorel.commandapi.CommandAPIBukkitConfig
import me.xhyrom.hylib.bukkit.implementation.managers.BStatsManagerImpl
import me.xhyrom.hylib.bukkit.implementation.managers.CommandManagerImpl
import me.xhyrom.hylib.bukkit.implementation.managers.UtilsManagerImpl
import me.xhyrom.hylib.common.api.HyLib
import me.xhyrom.hylib.common.api.HyLibProvider
import me.xhyrom.hylib.common.api.managers.*
import me.xhyrom.hylib.common.implementation.managers.ConfigManagerImpl
import me.xhyrom.hylib.common.implementation.managers.LanguageManagerImpl
import org.bukkit.plugin.java.JavaPlugin

class HyLibBukkit : HyLib, JavaPlugin() {
    private var bStatsManager: BStatsManager? = null
    private var configManager: ConfigManager? = null
    private var languageManager: LanguageManager? = null
    private var commandManager: CommandManager? = null

    override fun onEnable() {
        CommandAPI.onEnable()

        bStatsManager = BStatsManagerImpl(this)
        configManager = ConfigManagerImpl()
        languageManager = LanguageManagerImpl()
        commandManager = CommandManagerImpl()

        HyLibProvider.register(this)
    }

    override fun onLoad() {
        CommandAPI.onLoad(CommandAPIBukkitConfig(this).silentLogs(true))
    }

    override fun onDisable() {
        CommandAPI.onDisable()
    }

    override fun getBStatsManager(): BStatsManager {
        return bStatsManager!!
    }

    override fun getConfigManager(): ConfigManager {
        return configManager!!
    }

    override fun getLanguageManager(): LanguageManager {
        return languageManager!!
    }

    override fun getCommandManager(): CommandManager {
        return commandManager!!
    }

    override fun getUtilsManager(): UtilsManager {
        return UtilsManagerImpl
    }
}