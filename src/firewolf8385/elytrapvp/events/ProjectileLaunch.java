package firewolf8385.elytrapvp.events;

import firewolf8385.elytrapvp.PlayerData;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;

public class ProjectileLaunch implements Listener {

    @EventHandler
    public void onShoot(ProjectileLaunchEvent e){


        if(e.getEntity().getShooter() instanceof Player){

            Player p = ((Player) e.getEntity().getShooter()).getPlayer();
            PlayerData player = new PlayerData(p.getUniqueId());

            if(player.getKit() == 10){
                ItemStack arrow = new ItemStack(Material.SPECTRAL_ARROW, 64);
                p.getInventory().setItem(1, arrow);
            }

        }

    }

}
