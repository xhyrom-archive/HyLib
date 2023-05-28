package me.xhyrom.hylib.bukkit.implementation.managers

import dev.jorel.commandapi.CommandAPICommand
import dev.jorel.commandapi.executors.CommandArguments
import dev.jorel.commandapi.executors.CommandExecutor
import me.xhyrom.hylib.bukkit.api.structs.BukkitCommand
import me.xhyrom.hylib.bukkit.implementation.managers.UtilsManagerImpl.formatCommandArguments
import me.xhyrom.hylib.common.api.managers.CommandManager
import me.xhyrom.hylib.common.api.structs.Command
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.command.CommandSender

class CommandManagerImpl : CommandManager {
    private var raw: CommandAPICommand? = null

    init {
        raw = CommandAPICommand("hy")
            .withShortDescription("A HyLib provided command")
            .withFullDescription("Command for plugins powered by HyLib")
            .withPermission("hy.admin")
            .executes(
                CommandExecutor { sender: CommandSender, _: CommandArguments ->
                    run {
                        sender.sendMessage(
                            MiniMessage.miniMessage().deserialize(
                                "<gradient:#2fa4c4:#2fbfc4:#2fc4a9>HyLib</gradient> <dark_gray>| <gray>Available commands"
                            )
                        )

                        for (subcommand in raw!!.subcommands) {
                            sender.sendMessage(
                                MiniMessage.miniMessage().deserialize(
                                    "<dark_gray>/hy <gray>${subcommand.name}${
                                        if (subcommand.arguments.size > 0) " " + formatCommandArguments(subcommand as Command)
                                        else ""
                                    } <dark_gray>» <gray>${subcommand.fullDescription}"
                                )
                            )
                        }
                    }
                }
            )

        raw!!.register()
    }

    override fun register(command: Command) {
        raw!!.withSubcommand(command as BukkitCommand)
        raw!!.register()
    }

    override fun create(name: String): Command {
        var command: BukkitCommand? = null
        command = BukkitCommand(name)
            .executes(
                CommandExecutor { sender: CommandSender, _: CommandArguments ->
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
                                        if (subcommand.arguments.size > 0) " " + formatCommandArguments(subcommand as Command)
                                        else ""
                                    } <dark_gray>» <gray>${subcommand.fullDescription}"
                                )
                            )
                        }
                    }
                }
            ) as BukkitCommand

        return command
    }
}