package me.xhyrom.hylib.api.managers

import dev.jorel.commandapi.CommandAPICommand
import dev.jorel.commandapi.arguments.CommandAPIArgumentType
import dev.jorel.commandapi.executors.CommandExecutor
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.command.CommandSender
import org.bukkit.plugin.Plugin

class CommandManager {
    private val raw = CommandAPICommand("hy")
        .withShortDescription("A HyLib provided command")
        .withFullDescription("Command for plugins powered by HyLib")
        .executes(
            CommandExecutor { sender: CommandSender, _: Array<Any?>? ->
                run {
                    sender.sendMessage(
                        MiniMessage.miniMessage().deserialize(
                            "<gradient:#2fa4c4:#2fbfc4:#2fc4a9>HyLib</gradient> <dark_gray>| <gray>Available commands"
                        )
                    )

                    for (subcommand in this.getSubCommands()) {
                        sender.sendMessage(
                            MiniMessage.miniMessage().deserialize(formatCommand(subcommand))
                        )
                    }
                }
            }
        )

    fun addSubCommand(command: CommandAPICommand) {
        raw.withSubcommand(command)
        raw.register()
    }

    fun getSubCommands(): MutableList<CommandAPICommand> {
        return raw.subcommands
    }

    fun createCommand(name: String): CommandAPICommand {
        return CommandAPICommand(name)
    }

    private fun formatCommand(command: CommandAPICommand): String {
        return "<dark_gray>/hy <gray>${command.name} <reset>${command.arguments.joinToString(" ") {
            run {
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
        }} <dark_gray>» <gray>${command.fullDescription}"
    }
}