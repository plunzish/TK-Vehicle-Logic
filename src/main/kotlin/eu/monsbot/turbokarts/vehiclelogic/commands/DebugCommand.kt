package eu.monsbot.turbokarts.vehiclelogic.commands

import eu.monsbot.turbokarts.vehiclelogic.VehicleLogic
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class DebugCommand : CommandExecutor {
    override fun onCommand(commandSender: CommandSender, command: Command, s: String, strings: Array<String>): Boolean {
        VehicleLogic.sendPrefixedMessage(commandSender, "hai")
        return true
    }
}
