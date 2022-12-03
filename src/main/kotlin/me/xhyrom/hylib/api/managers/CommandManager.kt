package me.xhyrom.hylib.api.managers

import dev.jorel.commandapi.CommandAPICommand
import dev.jorel.commandapi.arguments.CommandAPIArgumentType
import dev.jorel.commandapi.executors.CommandExecutor
import me.xhyrom.hylib.api.managers.UtilsManager.formatCommandArguments
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.command.CommandSender
import org.bukkit.plugin.Plugin

class CommandManager {
    private val raw = CommandAPICommand("hy")
        .withShortDescription("A HyLib provided command")
        .withFullDescription("Command for plugins powered by HyLib")
        .withPermission("hy.admin")
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

    /**
     * Create main command for plugin
     * * This function will generate automatically a help command
     *
     * For subcommands, use raw CommandAPICommand from CommandAPI lib
     */
    fun createCommand(name: String): CommandAPICommand {
        var command: CommandAPICommand? = null
        command = CommandAPICommand(name)
            .executes(
                CommandExecutor { sender: CommandSender, _: Array<Any?> ->
                    run {
                        sender.sendMessage(
                            MiniMessage.miniMessage().deserialize(
                                "<gradient:#2fa4c4:#2fbfc4:#2fc4a9>Hy${name[0].uppercase() + name.substring(1)}</gradient> <dark_gray>| <gray>Available commands"
                            )
                        )

                        for (subcommand in command!!.subcommands) {
                            sender.sendMessage(
                                MiniMessage.miniMessage().deserialize(
                                    "<dark_gray>/hy $name <gray>${subcommand.name}${
                                        if (subcommand.arguments.size > 0) " " + formatCommandArguments(subcommand)
                                        else ""
                                    } <dark_gray>» <gray>${subcommand.fullDescription}"
                                )
                            )
                        }
                    }
                }
            )

        return command
    }

    private fun formatCommand(command: CommandAPICommand): String {
        return "<dark_gray>/hy <gray>${command.name}${
            if (command.arguments.size > 0) " " + formatCommandArguments(command)
            else ""
        } <dark_gray>» <gray>${command.fullDescription}"
    }
}