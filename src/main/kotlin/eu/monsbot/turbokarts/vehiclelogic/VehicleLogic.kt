package eu.monsbot.turbokarts.vehiclelogic

import eu.monsbot.turbokarts.vehiclelogic.commands.DebugCommand
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.Style
import org.bukkit.Bukkit
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin

class VehicleLogic : JavaPlugin() {
    override fun onEnable() {
        sendPrefixedMessage("Loading Plugin...")
        registerCommands()
        sendPrefixedMessage("Plugin loaded")
    }

    override fun onDisable() {
        sendPrefixedMessage("Unloading Plugin...")
        // Plugin shutdown logic
        sendPrefixedMessage("Plugin unloaded")
    }

    private fun registerCommands() {
        val commands: MutableMap<String, CommandExecutor> = HashMap()

        commands["tkvldebug"] = DebugCommand()

        registerCommands(commands)
    }

    private fun registerCommands(commands: Map<String, CommandExecutor>) {
        sendPrefixedMessage("Registering commands")
        for ((key, value) in commands) {
            try {
                getCommand(key)!!.setExecutor(value)
            } catch (e: Exception) {
                e.printStackTrace()
                sendPrefixedMessage("Error loading command: $key", true)
            }
        }
    }

    companion object {
        val PREFIX: Component = Component.text("TK-VL").style(Style.style()
                .color(TKColors.RED)
                .build())

        @JvmOverloads
        fun sendPrefixedMessage(receiver: CommandSender, content: String?, error: Boolean = false) {
            val openBracket: Component = Component.text("(").color(TKColors.GRAY)
            val closedBracket: Component = Component.text(")").color(TKColors.GRAY)
            val prefix = openBracket.append(PREFIX).append(closedBracket)
            val message: Component = Component.text(content!!).color(if (error) TKColors.RED else TKColors.LIGHT_GRAY)

            receiver.sendMessage(prefix.append(Component.space()).append(message))
        }

        fun sendPrefixedMessage(content: String?, error: Boolean) {
            sendPrefixedMessage(Bukkit.getConsoleSender(), content, error)
        }

        fun sendPrefixedMessage(content: String?) {
            sendPrefixedMessage(Bukkit.getConsoleSender(), content)
        }
    }
}
