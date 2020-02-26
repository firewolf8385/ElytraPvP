package firewolf8385.elytrapvp.listeners;

import firewolf8385.elytrapvp.Settings;
import firewolf8385.elytrapvp.objects.ElytraPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage implements Listener
{
    Settings settings = Settings.getInstance();

    @EventHandler
    public void onDamage(EntityDamageEvent e)
    {
        // Exit if not enabled.
        if(!settings.isEnabled())
        {
            return;
        }

        // Exit if not a player.
        if(!(e.getEntity() instanceof Player))
        {
            return;
        }

        Player p = (Player) e.getEntity();
        ElytraPlayer ep = new ElytraPlayer(p);

        switch(ep.getKit())
        {
            case 3:
                if(e.getCause().equals(EntityDamageEvent.DamageCause.FIRE))
                {
                    e.setCancelled(true);
                }
                break;

            case 7:
                if(e.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_EXPLOSION))
                {
                    e.setCancelled(true);
                }
                break;
        }
    }

}