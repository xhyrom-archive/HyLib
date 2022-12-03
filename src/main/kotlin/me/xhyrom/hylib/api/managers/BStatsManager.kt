package me.xhyrom.hylib.api.managers

import me.xhyrom.hylib.api.structs.Config
import org.bstats.bukkit.Metrics
import org.bstats.charts.AdvancedPie
import org.bukkit.plugin.java.JavaPlugin

class BStatsManager(private val hyPlugin: JavaPlugin) {
    private var bStats: Metrics? = null
    private val addons = arrayListOf<String>()

    fun registerAddon(plugin: JavaPlugin) {
        addons.add(plugin.name)
    }

    fun registerAddon(plugin: JavaPlugin, id: Int, config: Config) {
        addons.add(plugin.name)

        if (config.getBoolean("send-metrics")) {
            Metrics(plugin, id)
        }
    }

    fun register() {
        bStats = Metrics(hyPlugin, 16983)
        bStats?.addCustomChart(AdvancedPie("hylib_addons") {
            val valueMap = HashMap<String, Int>()
            for (addon in addons) {
                valueMap[addon] = 1
            }

            valueMap
        })
    }
}