package firewolf8385.elytrapvp.listeners;

import firewolf8385.elytrapvp.Settings;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropItem implements Listener
{
    private Settings settings = Settings.getInstance();

    @EventHandler
    public void dropItem(PlayerDropItemEvent e)
    {
        // Exit if not enabled.
        if(!settings.isEnabled())
        {
            return;
        }

        e.setCancelled(true);
    }

}
