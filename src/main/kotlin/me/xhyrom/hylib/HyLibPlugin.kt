package me.xhyrom.hylib

import dev.jorel.commandapi.CommandAPI
import dev.jorel.commandapi.CommandAPIConfig
import me.xhyrom.hylib.api.HyLib
import org.bukkit.plugin.java.JavaPlugin

class HyLibPlugin : JavaPlugin() {
    override fun onEnable() {
        CommandAPI.onEnable(this)

        HyLib()

        println("HyLib is enabled!")
    }

    override fun onLoad() {
        CommandAPI.onLoad(CommandAPIConfig().silentLogs(true))
    }
}