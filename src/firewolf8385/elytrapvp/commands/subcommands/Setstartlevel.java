package firewolf8385.elytrapvp.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import firewolf8385.elytrapvp.SettingsManager;

public class Setstartlevel implements CommandExecutor{

    SettingsManager settings = SettingsManager.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender.hasPermission("ep.admin")) {
            if(args.length > 0) {
                int level = Integer.parseInt(args[1]);
                settings.getConfig().set("StartLevel", level);
                settings.saveConfig();
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lElytraPvP &8- &7Start Level has been set."));
            }
            else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lUsage &8- &7/ep startlevel [y-level]"));
            }
        }
        else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou do not have access to that command."));
        }

        return true;
    }

}
