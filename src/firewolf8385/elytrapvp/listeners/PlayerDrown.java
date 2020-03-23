package firewolf8385.elytrapvp.listeners;

import firewolf8385.elytrapvp.events.PlayerDrownEvent;
import firewolf8385.elytrapvp.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerDrown implements Listener
{
    @EventHandler
    public void onDrown(PlayerDrownEvent e)
    {
        Player p = e.getPlayer();

        EntityDamageEvent cause = new EntityDamageEvent(p, EntityDamageEvent.DamageCause.CUSTOM, p.getHealth());
        p.setHealth(0);
        p.setLastDamageCause(cause);
        Bukkit.broadcastMessage(StringUtils.translate("&2&lDeath &8- &f" + p.getName() + " &adrowned."));
    }

}