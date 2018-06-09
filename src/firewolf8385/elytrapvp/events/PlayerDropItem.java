package firewolf8385.elytrapvp.events;

import firewolf8385.elytrapvp.SettingsManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;



public class PlayerDropItem implements Listener{

    SettingsManager settings = SettingsManager.getInstance();

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent e) {

        if(settings.getConfig().getBoolean("Enabled")) {

            if(settings.getConfig().getBoolean("AllowItemDrop") == false) {
                e.setCancelled(true);
            }

        }

    }


}
