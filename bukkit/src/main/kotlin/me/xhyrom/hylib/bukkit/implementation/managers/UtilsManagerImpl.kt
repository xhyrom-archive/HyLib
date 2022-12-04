package me.xhyrom.hylib.bukkit.implementation.managers

import dev.jorel.commandapi.arguments.CommandAPIArgumentType
import me.xhyrom.hylib.bukkit.api.structs.BukkitCommand
import me.xhyrom.hylib.common.api.managers.UtilsManager
import me.xhyrom.hylib.common.api.structs.Command

object UtilsManagerImpl : UtilsManager {
    override fun formatCommandArguments(command: Command): String {
        return (command as BukkitCommand).arguments.joinToString(" ") {
            return@joinToString when (it.argumentType) {
                CommandAPIArgumentType.PRIMITIVE_STRING -> "<#34abeb>"
                CommandAPIArgumentType.PRIMITIVE_GREEDY_STRING -> "<#2f90c4>"
                CommandAPIArgumentType.PRIMITIVE_INTEGER -> "<#ebc934>"
                CommandAPIArgumentType.PRIMITIVE_FLOAT -> "<#c7a43c>"
                CommandAPIArgumentType.PRIMITIVE_DOUBLE -> "<#c7923c>"
                CommandAPIArgumentType.PRIMITIVE_LONG -> "<#c7743c>"
                CommandAPIArgumentType.PRIMITIVE_BOOLEAN -> "<#c73c5a>"
                CommandAPIArgumentType.LITERAL -> "<gray>"
                else -> "<#8f2856>"
            } + it.nodeName
        }
    }
}