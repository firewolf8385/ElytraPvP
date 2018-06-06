package firewolf8385.elytrapvp.commands.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import firewolf8385.elytrapvp.PlayerData;
import net.md_5.bungee.api.ChatColor;

public class Givecoins implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender.hasPermission("ep.admin")) {
            if(args.length == 2) {
                Player target = Bukkit.getPlayer(args[0]);

                PlayerData player = new PlayerData(target.getUniqueId());
                player.addCoins(Integer.valueOf(args[1]));

                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lUsage &8- &7Gave player &e" + target.getName() + args[1] + " &7coins."));
            }
            else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lUsage &8- &7/ep givecoins [player] [amount]"));
            }
        }
        else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou do not have access to that command/"));
        }

        return true;
    }
}
