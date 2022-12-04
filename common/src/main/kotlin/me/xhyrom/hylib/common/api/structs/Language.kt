package me.xhyrom.hylib.common.api.structs

interface Language {
    fun getLang(key: String): Config
    fun getDefaultLang(): Config
}