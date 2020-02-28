package firewolf8385.elytrapvp.listeners;

import firewolf8385.elytrapvp.Settings;
import firewolf8385.elytrapvp.inventories.KitsGUI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick implements Listener
{
    Settings settings = Settings.getInstance();

    @EventHandler
    public void onClick(InventoryClickEvent e)
    {
        // Exit of not enabled.
        if(!settings.isEnabled())
        {
            return;
        }

        // Exit if item is null
        if(e.getCurrentItem() == null || e.getCurrentItem().getItemMeta() == null)
        {
            return;
        }

        String name = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName());
        name = name.replace("&c", "").replace("&a", "");
        Player p = (Player) e.getWhoClicked();

        switch(e.getView().getTitle())
        {
            case "Kits":
                KitsGUI.click(p, name, e.getClick());
                e.setCancelled(true);
                break;
            case "Preview":
                KitsGUI.click(p, name, e.getClick());
                e.setCancelled(true);
                break;
        }
    }

}
