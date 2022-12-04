package me.xhyrom.hylib.common.api.managers

import me.xhyrom.hylib.common.api.structs.Config

interface BStatsManager {
    fun registerAddon(name: String)
    fun registerAddon(plugin: Any, id: Int, config: Config)

    fun init()
}