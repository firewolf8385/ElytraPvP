package firewolf8385.elytrapvp.listeners;

import firewolf8385.elytrapvp.Settings;
import firewolf8385.elytrapvp.events.PlayerKillPlayerEvent;
import firewolf8385.elytrapvp.objects.ElytraPlayer;
import firewolf8385.elytrapvp.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener
{
    Settings settings = Settings.getInstance();

    @EventHandler
    public void onDeath(PlayerDeathEvent e)
    {
        // Exit if not enabled.
        if(!settings.isEnabled())
        {
            return;
        }

        Player p = e.getEntity();
        ElytraPlayer ep = ElytraPlayer.players.get(p.getUniqueId());
        ep.addDeaths(1);
        ep.setKillStreak(0);
        e.setDeathMessage(null);


        EntityDamageEvent cause = p.getLastDamageCause();

        // Exit if killed by server.
        if(cause == null)
        {
            return;
        }

        Player k = p.getKiller();

        // Exit if killer is null.
        if(k == null)
        {
            Bukkit.broadcastMessage(StringUtils.translate("&2&lDeath &8- &f" + p.getName() + " &adied."));
            return;
        }

        // Call custom event.
        Bukkit.getPluginManager().callEvent(new PlayerKillPlayerEvent(p, k));
    }

}
