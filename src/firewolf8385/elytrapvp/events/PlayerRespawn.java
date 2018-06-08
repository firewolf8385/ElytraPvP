package firewolf8385.elytrapvp.events;

import firewolf8385.elytrapvp.SettingsManager;
import firewolf8385.elytrapvp.utils.SpawnItems;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawn implements Listener{

    SettingsManager settings = SettingsManager.getInstance();

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {

        // Checks if the plugin is enabled
        if(settings.getConfig().getBoolean("Enabled")) {

            Player p = e.getPlayer();

            Double x = settings.getConfig().getDouble("Spawn.X");
            Double y = settings.getConfig().getDouble("Spawn.Y");
            Double z = settings.getConfig().getDouble("Spawn.Z");
            Float pitch = (float) settings.getConfig().getDouble("Spawn.Pitch");
            Float yaw = (float) settings.getConfig().getDouble("Spawn.Yaw");
            World world = p.getWorld();

            Location spawn = new Location(world, x, y, z, yaw, pitch);
            e.setRespawnLocation(spawn);


            SpawnItems.giveItems(p);

            p.setMaxHealth(20);
            p.setHealth(20);


        }

    }

}
