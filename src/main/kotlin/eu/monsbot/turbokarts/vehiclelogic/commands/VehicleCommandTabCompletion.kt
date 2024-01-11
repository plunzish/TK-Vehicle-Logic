package eu.monsbot.turbokarts.vehiclelogic.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter

class VehicleCommandTabCompletion : TabCompleter {
    override fun onTabComplete(commandSender: CommandSender, command: Command, s: String, strings: Array<String>): List<String>? {
        return null
    }
}
