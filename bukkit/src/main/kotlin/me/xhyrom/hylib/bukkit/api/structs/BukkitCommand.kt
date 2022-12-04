package me.xhyrom.hylib.bukkit.api.structs

import dev.jorel.commandapi.CommandAPICommand
import me.xhyrom.hylib.common.api.structs.Command

class BukkitCommand(name: String) : CommandAPICommand(name), Command {}