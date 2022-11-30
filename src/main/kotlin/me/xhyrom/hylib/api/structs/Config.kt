package me.xhyrom.hylib.api.structs

import dev.dejvokep.boostedyaml.YamlDocument
import org.bukkit.plugin.Plugin
import java.io.File

class Config(
    plugin: Plugin,
    name: String
) {
    private val raw = YamlDocument.create(
        File(plugin.dataFolder, "$name.yml")
    )

    fun get(path: String): Any? {
        return raw.get(path)
    }

    fun getString(path: String): String? {
        return raw.getString(path)
    }

    fun getBoolean(path: String): Boolean? {
        return raw.getBoolean(path)
    }

    fun getDouble(path: String): Double? {
        return raw.getDouble(path)
    }

    fun getFloat(path: String): Float? {
        return raw.getFloat(path)
    }

    fun getInt(path: String): Int? {
        return raw.getInt(path)
    }

    fun getLong(path: String): Long? {
        return raw.getLong(path)
    }

    fun getShort(path: String): Short? {
        return raw.getShort(path)
    }

    fun getByte(path: String): Byte? {
        return raw.getByte(path)
    }

    fun getChar(path: String): Char? {
        return raw.getChar(path)
    }

    fun getNumber(path: String): Number? {
        return raw.getNumber(path)
    }

    fun set(path: String, value: Any?) {
        raw.set(path, value)
    }

    fun save() {
        raw.save()
    }

    fun reload() {
        raw.reload()
    }

    fun getRaw(): YamlDocument {
        return raw
    }
}