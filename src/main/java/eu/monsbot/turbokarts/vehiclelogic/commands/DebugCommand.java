package eu.monsbot.turbokarts.vehiclelogic.commands;

import eu.monsbot.turbokarts.vehiclelogic.VehicleLogic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class DebugCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        VehicleLogic.sendPrefixedMessage(commandSender, "hai");
        return true;
    }
}
