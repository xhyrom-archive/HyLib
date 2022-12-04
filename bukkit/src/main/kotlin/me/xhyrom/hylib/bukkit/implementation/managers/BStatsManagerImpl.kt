package me.xhyrom.hylib.bukkit.implementation.managers

import me.xhyrom.hylib.common.api.managers.BStatsManager
import me.xhyrom.hylib.common.api.structs.Config
import org.bstats.bukkit.Metrics
import org.bstats.charts.AdvancedPie
import org.bukkit.plugin.java.JavaPlugin

class BStatsManagerImpl(private val hyPlugin: JavaPlugin) : BStatsManager {
    private var bStats: Metrics? = null
    private val addons = arrayListOf<String>()

    override fun registerAddon(name: String) {
        addons.add(name)
    }

    override fun registerAddon(plugin: Any, id: Int, config: Config) {
        addons.add((plugin as JavaPlugin).name)

        if (config.getBoolean("send-metrics").orElse(false)) {
            bStats = Metrics(plugin, id)
        }
    }

    override fun init() {
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