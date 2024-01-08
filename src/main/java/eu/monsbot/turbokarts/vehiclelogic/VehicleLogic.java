package eu.monsbot.turbokarts.vehiclelogic;

import eu.monsbot.turbokarts.vehiclelogic.commands.DebugCommand;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import net.kyori.adventure.text.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class VehicleLogic extends JavaPlugin {

    public static final Component PREFIX = Component.text("TK-VL").style(Style.style()
                    .color(TKColors.RED)
            .build());

    public static void sendPrefixedMessage(CommandSender receiver, String content, boolean error) {
        Component openBracket = Component.text("(").color(TKColors.GRAY);
        Component closedBracket = Component.text(")").color(TKColors.GRAY);
        Component prefix = openBracket.append(PREFIX).append(closedBracket);
        Component message = Component.text(content).color(error ? TKColors.RED : TKColors.LIGHT_GRAY);

        receiver.sendMessage(prefix.append(Component.space()).append(message));
    }
    public static void sendPrefixedMessage(CommandSender receiver, String content) {
        sendPrefixedMessage(receiver, content, false);
    }
    public static void sendPrefixedMessage(String content, boolean error) {
        sendPrefixedMessage(Bukkit.getConsoleSender(), content, error);
    }
    public static void sendPrefixedMessage(String content) {
        sendPrefixedMessage(Bukkit.getConsoleSender(), content);
    }

    @Override
    public void onEnable() {
        sendPrefixedMessage("Loading Plugin...");
        registerCommands();
        sendPrefixedMessage("Plugin loaded");
    }

    @Override
    public void onDisable() {
        sendPrefixedMessage("Unloading Plugin...");
        // Plugin shutdown logic
        sendPrefixedMessage("Plugin unloaded");
    }

    private void registerCommands() {
        Map<String, CommandExecutor> commands = new HashMap<>();

        commands.put("tkvldebug", new DebugCommand());

        registerCommands(commands);
    }
    private void registerCommands(Map<String, CommandExecutor> commands) {
        sendPrefixedMessage("Registering commands");
        for(Map.Entry<String, CommandExecutor> command : commands.entrySet()) {
            try {
                getCommand(command.getKey()).setExecutor(command.getValue());
            } catch (Exception e) {
                e.printStackTrace();
                sendPrefixedMessage("Error loading command: " + command.getKey(), true);
            }
        }
    }
}
