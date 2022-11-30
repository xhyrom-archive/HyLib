package me.xhyrom.hylib.api.structs

import dev.dejvokep.boostedyaml.YamlDocument
import dev.dejvokep.boostedyaml.dvs.versioning.BasicVersioning
import dev.dejvokep.boostedyaml.settings.dumper.DumperSettings
import dev.dejvokep.boostedyaml.settings.general.GeneralSettings
import dev.dejvokep.boostedyaml.settings.loader.LoaderSettings
import dev.dejvokep.boostedyaml.settings.updater.UpdaterSettings
import org.bukkit.plugin.Plugin
import java.io.File
import java.util.Optional

class Config(
    plugin: Plugin,
    name: String
) {
    private val raw = YamlDocument.create(
        File(plugin.dataFolder, "$name.yml"),
        plugin.getResource("$name.yml")!!,
        GeneralSettings.DEFAULT,
        LoaderSettings.builder().setAutoUpdate(true).build(),
        DumperSettings.DEFAULT,
        UpdaterSettings.builder().setVersioning(BasicVersioning("config-version")).build()
    )

    fun get(path: String): Any {
        return raw.get(path)
    }
    fun getString(path: String): String {
        return raw.getString(path)
    }
    fun getStringList(path: String): List<String> {
        return raw.getStringList(path)
    }
    fun getBoolean(path: String): Boolean {
        return raw.getBoolean(path)
    }
    fun getDouble(path: String): Double {
        return raw.getDouble(path)
    }
    fun getFloat(path: String): Float {
        return raw.getFloat(path)
    }
    fun getInt(path: String): Int {
        return raw.getInt(path)
    }
    fun getLong(path: String): Long {
        return raw.getLong(path)
    }
    fun getShort(path: String): Short {
        return raw.getShort(path)
    }
    fun getByte(path: String): Byte {
        return raw.getByte(path)
    }
    fun getChar(path: String): Char {
        return raw.getChar(path)
    }
    fun getNumber(path: String): Number {
        return raw.getNumber(path)
    }

    fun getOptional(path: String): Optional<Any> {
        return raw.getOptional(path)
    }
    fun getOptionalString(path: String): Optional<String> {
        return raw.getOptionalString(path)
    }
    fun getOptionalStringList(path: String): Optional<List<String>> {
        return raw.getOptionalStringList(path)
    }
    fun getOptionalBoolean(path: String): Optional<Boolean> {
        return raw.getOptionalBoolean(path)
    }
    fun getOptionalDouble(path: String): Optional<Double> {
        return raw.getOptionalDouble(path)
    }
    fun getOptionalFloat(path: String): Optional<Float> {
        return raw.getOptionalFloat(path)
    }
    fun getOptionalInt(path: String): Optional<Int> {
        return raw.getOptionalInt(path)
    }
    fun getOptionalLong(path: String): Optional<Long> {
        return raw.getOptionalLong(path)
    }
    fun getOptionalShort(path: String): Optional<Short> {
        return raw.getOptionalShort(path)
    }
    fun getOptionalByte(path: String): Optional<Byte> {
        return raw.getOptionalByte(path)
    }
    fun getOptionalChar(path: String): Optional<Char> {
        return raw.getOptionalChar(path)
    }
    fun getOptionalNumber(path: String): Optional<Number> {
        return raw.getOptionalNumber(path)
    }

    fun set(path: String, value: Any?) {
        raw.set(path, value)
    }

    fun save(): Boolean {
        return try {
            raw.save()
        } catch (e: Exception) {
            false
        }
    }

    fun reload(): Boolean {
        return try {
            raw.reload()
        } catch (e: Exception) {
            false
        }
    }

    fun getRaw(): YamlDocument {
        return raw
    }
}