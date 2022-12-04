package me.xhyrom.hylib.common.api.managers

import me.xhyrom.hylib.common.api.structs.Command

interface UtilsManager {
    fun formatCommandArguments(command: Command): String
}