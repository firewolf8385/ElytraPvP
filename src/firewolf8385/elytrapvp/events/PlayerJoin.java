package firewolf8385.elytrapvp.events;

import firewolf8385.elytrapvp.utils.SpawnItems;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffectType;

import firewolf8385.elytrapvp.PlayerData;
import firewolf8385.elytrapvp.SettingsManager;



public class PlayerJoin implements Listener{

    SettingsManager settings = SettingsManager.getInstance();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        // Only Runs When The plugin Is Enabled
        if(settings.getConfig().getBoolean("Enabled")) {
            Player p = e.getPlayer();

            PlayerData player = new PlayerData(p.getUniqueId());
            player.createPlayerConfig();
            player.createPlayerDefaults();
            player.savePlayerConfig();

            player.addLogins(1);
            player.savePlayerConfig();

            Double x = settings.getConfig().getDouble("Spawn.X");
            Double y = settings.getConfig().getDouble("Spawn.Y");
            Double z = settings.getConfig().getDouble("Spawn.Z");
            Float pitch = (float) settings.getConfig().getDouble("Spawn.Pitch");
            Float yaw = (float) settings.getConfig().getDouble("Spawn.Yaw");
            World world = p.getWorld();

            Location spawn = new Location(world, x, y, z, yaw, pitch);
            p.teleport(spawn);

            p.getInventory().clear();

            SpawnItems.giveItems(p);

            p.setMaxHealth(20.0);
            p.setHealth(20.0);

            p.removePotionEffect(PotionEffectType.REGENERATION);

            p.setGameMode(GameMode.ADVENTURE);
        }

    }

}
