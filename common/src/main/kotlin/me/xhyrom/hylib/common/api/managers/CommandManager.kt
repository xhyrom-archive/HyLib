package me.xhyrom.hylib.common.api.managers

import me.xhyrom.hylib.common.api.structs.Command

interface CommandManager {
    /**
     * Register command into default command `/hy`
     */
    fun register(command: Command)

    /**
     * Creates command with automatic generated help
     */
    fun create(name: String): Command
}