package me.xhyrom.hylib

import dev.jorel.commandapi.CommandAPI
import dev.jorel.commandapi.CommandAPIConfig
import me.xhyrom.hylib.api.HyLib
import me.xhyrom.hylib.api.structs.Config
import org.bukkit.plugin.java.JavaPlugin

class HyLibPlugin : JavaPlugin() {
    private var config: Config? = null

    override fun onEnable() {
        CommandAPI.onEnable(this)

        HyLib(this)
        config = HyLib.getInstance().getConfigManager().register(this, "config")

        if (config!!.getBoolean("send-metrics")) {
            HyLib.getInstance().getBStatsManager().register()
        }

        println("HyLib is enabled!")
    }

    override fun onLoad() {
        CommandAPI.onLoad(CommandAPIConfig().silentLogs(true))
    }
}