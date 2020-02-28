package firewolf8385.elytrapvp.listeners;

import firewolf8385.elytrapvp.Settings;
import firewolf8385.elytrapvp.objects.ElytraPlayer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;

public class ProjectileLaunch implements Listener
{
    Settings settings = Settings.getInstance();

    @EventHandler
    public void onLaunch(ProjectileLaunchEvent e)
    {
        // Exit if not enabled.
        if(!settings.isEnabled())
        {
            return;
        }

        // Exits if not a player
        if(!(e.getEntity().getShooter() instanceof Player))
        {
            return;
        }

        Player p = (Player) e.getEntity().getShooter();
        ElytraPlayer ep = ElytraPlayer.players.get(p.getUniqueId());

        // Exit if kit is not 10.
        if(ep.getKit() != 10)
        {
            return;
        }

        ItemStack arrow = new ItemStack(Material.SPECTRAL_ARROW, 64);
        p.getInventory().setItem(17, arrow);
    }
}
