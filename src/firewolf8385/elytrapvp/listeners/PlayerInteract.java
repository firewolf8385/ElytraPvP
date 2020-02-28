package firewolf8385.elytrapvp.listeners;

import firewolf8385.elytrapvp.Settings;
import firewolf8385.elytrapvp.inventories.KitsGUI;
import firewolf8385.elytrapvp.kits.Spectator;
import firewolf8385.elytrapvp.objects.ElytraPlayer;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteract implements Listener
{
    Settings settings = Settings.getInstance();

    @EventHandler
    public void onInteract(PlayerInteractEvent e)
    {
        Player p = e.getPlayer();

        // Exit if not enabled.
        if(!settings.isEnabled())
        {
            return;
        }

        // Exit if item is null.
        if(e.getItem() == null)
        {
            return;
        }

        // Replace fireworks when used.
        if(e.getItem().getType() == Material.FIREWORK_ROCKET)
        {
            e.getPlayer().getInventory().setItemInOffHand(new ItemStack(Material.FIREWORK_ROCKET, 64));
            return;
        }

        // Exit if item meta is null.
        if(e.getItem().getItemMeta() == null)
        {
            return;
        }

        String item = ChatColor.stripColor(e.getItem().getItemMeta().getDisplayName());

        switch(item)
        {
            case "Kit Selector":
                KitsGUI.view(e.getPlayer());
                break;

            case "Stats":
                e.getPlayer().performCommand("stats");
                break;
            case "Leave":
                Spectator.remove(p);
                break;
        }
    }

}
