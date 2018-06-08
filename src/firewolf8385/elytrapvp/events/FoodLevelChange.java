package firewolf8385.elytrapvp.events;

import firewolf8385.elytrapvp.SettingsManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;


public class FoodLevelChange implements Listener{

    SettingsManager settings = SettingsManager.getInstance();

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e) {

        // Checks if the plugin is enabled
        if(settings.getConfig().getBoolean("Enabled")) {

            //Checks If Hunger Is Disabled
            if(settings.getConfig().getBoolean("Disable-Hunger")) {
                e.setFoodLevel(20);
            }
        }
    }

}
