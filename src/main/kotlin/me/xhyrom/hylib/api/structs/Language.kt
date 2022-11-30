package me.xhyrom.hylib.api.structs

import me.xhyrom.hylib.api.HyLib
import org.bukkit.plugin.Plugin
import java.io.File

class Language(
    private val plugin: Plugin
) {
    private val registeredLocales = HashMap<String, Config>()

    fun getLocale(key: String): Config {
        return getLocale(key, false)
    }

    fun getLocale(key: String, bypassCheck: Boolean): Config {
        if (!bypassCheck && key !in registeredLocales && !File(plugin.dataFolder, "lang/$key.yml").exists()) {
            return getLocale("en-US", true)
        }

        if (key !in registeredLocales) {
            val conf = HyLib.getInstance().getConfigManager().register(plugin, "lang/$key")
            conf.save()
            registeredLocales[key] = conf
        }

        return registeredLocales[key]!!
    }
}