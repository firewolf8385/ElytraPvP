package firewolf8385.elytrapvp.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import firewolf8385.elytrapvp.PlayerData;
import firewolf8385.elytrapvp.SettingsManager;

public class EntityDamage implements Listener{

    SettingsManager settings = SettingsManager.getInstance();

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {

        if(settings.getConfig().getBoolean("Enabled")) {

            if(e.getEntity() instanceof Player) {

                Player p = (Player) e.getEntity();
                PlayerData player = new PlayerData(p.getUniqueId());

                if(player.getKit() == 3) {
                    if(e.getCause() == DamageCause.FIRE) {
                        e.setCancelled(true);
                    }
                }
                else if(player.getKit() == 7) {
                    if(e.getCause() == DamageCause.ENTITY_EXPLOSION) {
                        e.setCancelled(true);
                    }
                }
            }
        }
    }
}