package firewolf8385.elytrapvp.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Info implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8---------- &6&lElytraPvP &8----------"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Author &8- &ffirewolf8385"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Version &8- &f3.0"));
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Spigot &8- &fComing Soon"));

        return true;
    }

}
