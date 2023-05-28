package me.xhyrom.hylib.common.implementation.structs

import dev.dejvokep.boostedyaml.YamlDocument
import dev.dejvokep.boostedyaml.block.implementation.Section
import dev.dejvokep.boostedyaml.dvs.versioning.BasicVersioning
import dev.dejvokep.boostedyaml.route.Route
import dev.dejvokep.boostedyaml.settings.dumper.DumperSettings
import dev.dejvokep.boostedyaml.settings.general.GeneralSettings
import dev.dejvokep.boostedyaml.settings.loader.LoaderSettings
import dev.dejvokep.boostedyaml.settings.updater.UpdaterSettings
import me.xhyrom.hylib.common.api.structs.Config
import java.io.File
import java.io.InputStream
import java.math.BigInteger
import java.util.*

class ConfigImpl(path: String, resource: InputStream) : Config {
    private val raw = YamlDocument.create(
        File(path),
        resource,
        GeneralSettings.DEFAULT,
        LoaderSettings.builder().setAutoUpdate(true).build(),
        DumperSettings.DEFAULT,
        UpdaterSettings.builder().setVersioning(BasicVersioning("config-version")).build()
    )

    override fun get(key: String): Optional<Any> {
        return raw.getOptional(key)
    }

    fun getSection(key: String): Optional<Section> {
        return raw.getOptionalSection(key)
    }

    fun getSection(route: Route): Optional<Section> {
        return raw.getOptionalSection(route)
    }

    override fun getString(key: String): Optional<String> {
        return raw.getOptionalString(key)
    }

    override fun getByte(key: String): Optional<Byte> {
        return raw.getOptionalByte(key)
    }

    override fun getChar(key: String): Optional<Char> {
        return raw.getOptionalChar(key)
    }

    override fun getStringList(key: String): Optional<List<String>> {
        return raw.getOptionalStringList(key)
    }

    override fun getByteList(key: String): Optional<List<Byte>> {
        return raw.getOptionalByteList(key)
    }

    override fun getInt(key: String): Optional<Int> {
        return raw.getOptionalInt(key)
    }

    override fun getDouble(key: String): Optional<Double> {
        return raw.getOptionalDouble(key)
    }

    override fun getLong(key: String): Optional<Long> {
        return raw.getOptionalLong(key)
    }

    override fun getFloat(key: String): Optional<Float> {
        return raw.getOptionalFloat(key)
    }

    override fun getShort(key: String): Optional<Short> {
        return raw.getOptionalShort(key)
    }

    override fun getBigInt(key: String): Optional<BigInteger> {
        return raw.getOptionalBigInt(key)
    }

    override fun getNumber(key: String): Optional<Number> {
        return raw.getOptionalNumber(key)
    }

    override fun getIntList(key: String): Optional<List<Int>> {
        return raw.getOptionalIntList(key)
    }

    override fun getDoubleList(key: String): Optional<List<Double>> {
        return raw.getOptionalDoubleList(key)
    }

    override fun getLongList(key: String): Optional<List<Long>> {
        return raw.getOptionalLongList(key)
    }

    override fun getFloatList(key: String): Optional<List<Float>> {
        return raw.getOptionalFloatList(key)
    }

    override fun getShortList(key: String): Optional<List<Short>> {
        return raw.getOptionalShortList(key)
    }

    override fun getBigIntList(key: String): Optional<List<BigInteger>> {
        return raw.getOptionalBigIntList(key)
    }

    override fun getBoolean(key: String): Optional<Boolean> {
        return raw.getOptionalBoolean(key)
    }

    override fun set(key: String, value: Any) {
        raw.set(key, value)
    }

    override fun save(): Boolean {
        return try {
            raw.save()
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    override fun reload(): Boolean {
        return try {
            raw.reload()
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    override fun getRaw(): YamlDocument {
        return raw
    }
}