package firewolf8385.elytrapvp.commands.subcommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import firewolf8385.elytrapvp.SettingsManager;
import net.md_5.bungee.api.ChatColor;

public class Disable implements CommandExecutor{

    SettingsManager settings = SettingsManager.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender.hasPermission("ep.admin")){
            settings.getConfig().set("enabled", false);
            settings.saveConfig();

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lElytraPvP &8- &7ElytraPvP has been disabled"));
        }
        else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou don't have access to that command."));
        }

        return true;
    }

}
