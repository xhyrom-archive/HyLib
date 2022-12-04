package me.xhyrom.hylib.common.api.managers

import me.xhyrom.hylib.common.api.structs.Config
import java.io.InputStream

interface ConfigManager {
    fun register(path: String, resource: InputStream): Config
}