package me.xhyrom.hylib.common.implementation.structs

import me.xhyrom.hylib.common.api.HyLibProvider
import me.xhyrom.hylib.common.api.structs.Config
import me.xhyrom.hylib.common.api.structs.Language
import java.io.File
import java.io.InputStream

class LanguageImpl(
    private val dataFolder: String,
    private val getResource: (key: String) -> InputStream
) : Language {
    private val registeredLocales = HashMap<String, Config>()

    override fun getLang(key: String): Config {
        return getLang(key, true)
    }

    private fun getLang(key: String, check: Boolean): Config {
        if (check && key !in registeredLocales && !File(dataFolder, "lang/$key.yml").exists()) return getDefaultLang()

        if (key !in registeredLocales) {
            val conf = HyLibProvider.get().getConfigManager().register(
                File(dataFolder, "lang/$key.yml").path,
                getResource("lang/$key.yml")
            )
            conf.save()
            registeredLocales[key] = conf
        }

        return registeredLocales[key]!!
    }

    override fun getDefaultLang(): Config {
        return getLang("en-US", false)
    }
}