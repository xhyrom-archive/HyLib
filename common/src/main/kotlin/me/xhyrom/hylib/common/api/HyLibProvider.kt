package me.xhyrom.hylib.common.api

abstract class HyLibProvider {
    companion object {
        private lateinit var instance: HyLib

        fun get(): HyLib {
            return instance
        }

        fun register(instance: HyLib) {
            Companion.instance = instance
        }
    }
}