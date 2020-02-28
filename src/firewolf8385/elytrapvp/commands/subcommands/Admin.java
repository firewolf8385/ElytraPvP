package firewolf8385.elytrapvp.commands.subcommands;

import firewolf8385.elytrapvp.objects.ElytraPlayer;
import firewolf8385.elytrapvp.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Admin implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        // Exit if no arguments
        if(args.length < 3)
        {
            ChatUtils.chat(sender, "&2&l]&8&m---------------------------------------------------&2&l[");
            ChatUtils.centeredChat(sender, "&2&lAdmin Help &a[1/1]");
            ChatUtils.chat(sender, "  &8» &a/ep admin addcoins&8- &fGive a player coins.");
            ChatUtils.chat(sender, "  &8» &a/ep admin setcoins&8- &fSet the coins of a player.");
            ChatUtils.chat(sender, "  &8» &a/ep admin setdeaths&8- &fSet deaths of a player.");
            ChatUtils.chat(sender, "  &8» &a/ep admin setkills&8- &fSet kills of a player..");
            ChatUtils.chat(sender, "&2&l]&8&m---------------------------------------------------&2&l[");
            return true;
        }

        // Exit if player never joined.
        OfflinePlayer p = Bukkit.getOfflinePlayer(args[1]);
        ElytraPlayer ep = new ElytraPlayer(p.getUniqueId());
        if(!ep.hasJoined())
        {
            return true;
        }

        int i = Integer.parseInt(args[2]);

        switch(args[0])
        {
            case "addcoins":
                addCoins(sender, p, i);
                break;

            case "setcoins":
                setCoins(sender, p, i);
                break;

            case "setdeaths":
                setDeaths(sender, p, i);
                break;

            case "setkills":
                setKills(sender, p, i);
                break;
        }

        return true;
    }

    private void addCoins(CommandSender sender, OfflinePlayer p, int i)
    {
        ElytraPlayer ep = new ElytraPlayer(p.getUniqueId());
        ep.addCoins(i);
        ChatUtils.chat(sender, "&2&lElytraPvP &8- &aGave &f" + p.getName() + " " + i + " &acoins.");
    }

    private void setCoins(CommandSender sender, OfflinePlayer p, int i)
    {
        ElytraPlayer ep = new ElytraPlayer(p.getUniqueId());
        ep.setCoins(i);
        ChatUtils.chat(sender, "&2&lElytraPvP &8- &aSet &f" + p.getName() + "&a's coins to &f" + i + "&a.");
    }

    private void setDeaths(CommandSender sender, OfflinePlayer p, int i)
    {
        ElytraPlayer ep = new ElytraPlayer(p.getUniqueId());
        ep.setDeaths(i);
        ChatUtils.chat(sender, "&2&lElytraPvP &8- &aSet &f" + p.getName() + "&a's deaths to &f" + i + "&a.");
    }

    private void setKills(CommandSender sender, OfflinePlayer p, int i)
    {
        ElytraPlayer ep = new ElytraPlayer(p.getUniqueId());
        ep.setKills(i);
        ChatUtils.chat(sender, "&2&lElytraPvP &8- &aSet &f" + p.getName() + "&a's kills to &f" + i + "&a.");
    }
}
