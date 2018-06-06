package firewolf8385.elytrapvp.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Help implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender.hasPermission("ep.admin")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8---------- &6&6ElytraPvP &8----------"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/ep disable &8- &fDisable the plugin"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/ep enable &8- &fEnable the plugin"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/ep givecoins &8- &fGive a player coins"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/ep help &8- &fBrings up this page"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/ep info &8- &fShows plugin info"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/ep setspawn &8- &fSet the spawnpoint"));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/ep setstartlevel &8- &fSet the level the  kit is given"));
        }
        else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou do not have access to that command."));
        }

        return true;
    }

}
