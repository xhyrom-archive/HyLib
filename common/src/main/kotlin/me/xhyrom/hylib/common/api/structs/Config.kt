package me.xhyrom.hylib.common.api.structs

import java.math.BigInteger
import java.util.*

interface Config {
    fun get(key: String): Optional<Any>

    fun getString(key: String): Optional<String>
    fun getByte(key: String): Optional<Byte>
    fun getChar(key: String): Optional<Char>

    // Lists
    fun getStringList(key: String): Optional<List<String>>
    fun getByteList(key: String): Optional<List<Byte>>

    // Numbers
    fun getInt(key: String): Optional<Int>
    fun getDouble(key: String): Optional<Double>
    fun getLong(key: String): Optional<Long>
    fun getFloat(key: String): Optional<Float>
    fun getShort(key: String): Optional<Short>
    fun getBigInt(key: String): Optional<BigInteger>
    fun getNumber(key: String): Optional<Number>

    // Numbers lists
    fun getIntList(key: String): Optional<List<Int>>
    fun getDoubleList(key: String): Optional<List<Double>>
    fun getLongList(key: String): Optional<List<Long>>
    fun getFloatList(key: String): Optional<List<Float>>
    fun getShortList(key: String): Optional<List<Short>>
    fun getBigIntList(key: String): Optional<List<BigInteger>>

    fun getBoolean(key: String): Optional<Boolean>

    fun set(key: String, value: Any)

    fun save(): Boolean
    fun reload(): Boolean
}