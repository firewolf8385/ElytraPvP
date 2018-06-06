package firewolf8385.elytrapvp.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import firewolf8385.elytrapvp.SettingsManager;

public class Setspawn implements CommandExecutor{

    SettingsManager settings = SettingsManager.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender.hasPermission("ep.admin")) {
            Player player = (Player) sender;

            settings.getConfig().set("Spawn.X", Double.valueOf(player.getLocation().getX()));
            settings.getConfig().set("Spawn.Y", Double.valueOf(player.getLocation().getY()));
            settings.getConfig().set("Spawn.Z", Double.valueOf(player.getLocation().getZ()));
            settings.getConfig().set("Spawn.Yaw", Float.valueOf(player.getLocation().getYaw()));
            settings.getConfig().set("Spawn.Pitch", Float.valueOf(player.getLocation().getPitch()));
            settings.saveConfig();

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lElytraPvP &8- &7Spawn has been set."));
        }
        else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou do not have access to that command."));
        }

        return true;
    }
}
