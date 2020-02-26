package firewolf8385.elytrapvp.listeners;

import firewolf8385.elytrapvp.events.PlayerKillPlayerEvent;
import firewolf8385.elytrapvp.objects.ElytraPlayer;
import firewolf8385.elytrapvp.utils.ChatUtils;
import firewolf8385.elytrapvp.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerKillPlayer implements Listener
{

    @EventHandler
    public void onKill(PlayerKillPlayerEvent e)
    {
        Player p = e.getPlayer();
        Player k = e.getKiller();

        // Check if player killed themselves.
        if(p.equals(k))
        {
            Bukkit.broadcastMessage(StringUtils.translate("&2&lDeath &8- &f" + p.getName() + " &aattacked themselves."));
           return;
        }

        ElytraPlayer ep = new ElytraPlayer(p);
        ElytraPlayer kp = new ElytraPlayer(k);
        kp.addKills(1);
        kp.addKillStreak(1);

        Bukkit.broadcastMessage(StringUtils.translate("&2&lDeath &8- &f" + p.getName() + " &awas rekt by " + k.getName() + "&a."));

        int coins = 5 + (kp.getKillStreak() / 3) + ep.getBounty();
        kp.addCoins(coins);

        if(ep.getBounty() > 0)
        {
            ChatUtils.chat(k, "&2&lBounty &8- &aYou have killed a wanted player and collected &f" + ep.getBounty() + "&acoins.");
            ep.setBounty(0);
        }

        if(kp.getKillStreak() % 3 == 0)
        {
            Bukkit.broadcastMessage(StringUtils.translate("&2&lKill Streak &8- &f" + k.getName() + " &ais on a kill streak of &f" + kp.getKillStreak() + "&a!"));
        }
    }

}
