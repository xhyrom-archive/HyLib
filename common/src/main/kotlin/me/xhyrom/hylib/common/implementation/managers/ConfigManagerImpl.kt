package me.xhyrom.hylib.common.implementation.managers

import me.xhyrom.hylib.common.api.managers.ConfigManager
import me.xhyrom.hylib.common.api.structs.Config
import me.xhyrom.hylib.common.implementation.structs.ConfigImpl
import java.io.InputStream

class ConfigManagerImpl : ConfigManager {
    override fun register(path: String, resource: InputStream): Config {
        return ConfigImpl(path, resource)
    }
}