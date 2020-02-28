package firewolf8385.elytrapvp.listeners;

import firewolf8385.elytrapvp.Settings;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChange implements Listener
{
    private static Settings settings = Settings.getInstance();

    @EventHandler
    public void onHunger(FoodLevelChangeEvent e)
    {
        // Exit if not enabled.
        if(!settings.isEnabled())
        {
            return;
        }

        e.setCancelled(true);
    }

}
