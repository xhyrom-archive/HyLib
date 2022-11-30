package me.xhyrom.hylib.api.managers

import org.bstats.bukkit.Metrics
import org.bstats.charts.AdvancedPie
import org.bukkit.plugin.java.JavaPlugin

class BStatsManager(plugin: JavaPlugin) {
    private val bStats = Metrics(plugin, 16983)
    private val addons = arrayListOf<String>()

    fun registerAddon(plugin: JavaPlugin) {
        addons.add(plugin.name)
    }

    fun register() {
        bStats.addCustomChart(AdvancedPie("hylib_addons") {
            val valueMap = HashMap<String, Int>()
            for (addon in addons) {
                valueMap[addon] = 1
            }

            valueMap
        })
    }
}