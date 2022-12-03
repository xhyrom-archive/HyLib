package me.xhyrom.hylib.api.managers

import dev.jorel.commandapi.CommandAPICommand
import dev.jorel.commandapi.arguments.CommandAPIArgumentType

object UtilsManager {
    /**
     * I dont want to support legacy formatting bruh
     */
    @Deprecated("Use the MiniMessage formatting")
    fun translateLegacyToMiniMessage(text: String): String {
        return text
            .replace("&0", "<black>")
            .replace("&1", "<dark_blue>")
            .replace("&2", "<dark_green>")
            .replace("&3", "<dark_aqua>")
            .replace("&4", "<dark_red>")
            .replace("&5", "<dark_purple>")
            .replace("&6", "<gold>")
            .replace("&7", "<gray>")
            .replace("&8", "<dark_gray>")
            .replace("&9", "<blue>")
            .replace("&a", "<green>")
            .replace("&b", "<aqua>")
            .replace("&c", "<red>")
            .replace("&d", "<light_purple>")
            .replace("&e", "<yellow>")
            .replace("&f", "<white>")
            .replace("&k", "<obfuscated>")
            .replace("&l", "<bold>")
            .replace("&m", "<strikethrough>")
            .replace("&n", "<underline>")
            .replace("&o", "<italic>")
            .replace("&r", "<reset>")
    }

    fun formatCommandArguments(command: CommandAPICommand): String {
        return command.arguments.joinToString(" ") {
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