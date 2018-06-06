package firewolf8385.elytrapvp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import firewolf8385.elytrapvp.PlayerData;
import net.md_5.bungee.api.ChatColor;

public class Stats implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if(args.length == 0) {
            Player p = (Player) sender;
            PlayerData player = new PlayerData(p.getUniqueId());

            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8---------- &6&lStats &8----------"));
            sender.sendMessage("");
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eKills: &f" + player.getKills()));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eDeaths: &f" + player.getDeaths()));
            sender.sendMessage("");
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eCoins: &f" + player.getCoins()));
        }

        return true;
    }

}
