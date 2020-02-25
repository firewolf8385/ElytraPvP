package firewolf8385.elytrapvp.commands;

import firewolf8385.elytrapvp.Settings;
import firewolf8385.elytrapvp.objects.ElytraPlayer;
import firewolf8385.elytrapvp.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

public class Stats implements CommandExecutor
{
    Settings settings = Settings.getInstance();

    @EventHandler
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        // Exit if not player.
        if(!(sender instanceof Player))
        {
            ChatUtils.chat(sender, settings.getMessage("MustBePlayer"));
            return true;
        }

        Player p = (Player) sender;
        ElytraPlayer ep = new ElytraPlayer(p);

        int kills = ep.getKills();
        int deaths = ep.getDeaths();
        double kdr = ((double) kills) / ((double) deaths);

        if(deaths == 0) kdr = kills;

        ChatUtils.chat(sender, "&2&l]&8&m---------------------------------------------------&2&l[");
        ChatUtils.centeredChat(sender, "&2&lStats");
        ChatUtils.chat(sender, "  &8» &aKills &8- &f" + kills);
        ChatUtils.chat(sender, "  &8» &aDeaths &8- &f" + deaths);
        ChatUtils.chat(sender, "  &8» &aKDR &8- &f" + kdr);
        ChatUtils.chat(sender, "  &8» &aCoins &8- &f" + ep.getCoins());
        ChatUtils.chat(sender, "  &8» &aBounty &8- &f" + ep.getBounty());
        ChatUtils.chat(sender, "&2&l]&8&m---------------------------------------------------&2&l[");

        return true;
    }

}
