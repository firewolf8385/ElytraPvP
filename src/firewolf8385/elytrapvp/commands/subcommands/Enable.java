package firewolf8385.elytrapvp.commands.subcommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import firewolf8385.elytrapvp.SettingsManager;
import net.md_5.bungee.api.ChatColor;

public class Enable implements CommandExecutor{

    SettingsManager settings = SettingsManager.getInstance();

    Boolean spawn = settings.getConfig().getBoolean("Spawn.Set");


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender.hasPermission("ep.admin")){
            if(spawn) {
                settings.getConfig().set("enabled", true);
                settings.saveConfig();

                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lElytraPvP &8- &7ElytraPvP has been disabled"));
            }
            else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lElytraPvP &8- &7Failed to enable ElytraPvP. Spawn has not been set!"));
            }
        }
        else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou don't have access to that command."));
        }

        return true;
    }

}
