package firewolf8385.elytrapvp.commands;

import firewolf8385.elytrapvp.objects.ElytraPlayer;
import firewolf8385.elytrapvp.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Pay implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        // Exit if sender is not a player.
        if(!(sender instanceof Player))
        {
            ChatUtils.chat(sender, "&2&lError &8- &cOnly players can use that command.");
            return true;
        }

        // Exit if not enough args
        if(args.length < 2)
        {
            ChatUtils.chat(sender, "&2&lUsage &8- &c/pay [player] [amount]");
            return true;
        }
        Player p = (Player) sender;
        ElytraPlayer ep = ElytraPlayer.players.get(p.getUniqueId());
        OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
        ElytraPlayer et = new ElytraPlayer(target.getUniqueId());
        int amount = Integer.parseInt(args[1]);

        // Exit if target hasn't joined.
        if(!et.hasJoined())
        {
            ChatUtils.chat(sender, "&2&lError &8- &cThat player has not joined before.");
            return true;
        }

        // Exit if less than 1.
        if(amount < 0)
        {
            ChatUtils.chat(sender, "&2&lError &8- &cAmount must be at least 1 coin.");
            return true;
        }

        // Exit if player does not have enough coins.
        if(amount > ep.getCoins())
        {
            ChatUtils.chat(sender, "&2&lError &8- &cYou do not have enough coins.");
            return true;
        }

        ep.removeCoins(amount);
        et.addCoins(amount);

        return true;
    }

}
