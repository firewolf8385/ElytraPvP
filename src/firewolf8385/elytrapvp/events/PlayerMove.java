package firewolf8385.elytrapvp.events;

import firewolf8385.elytrapvp.PlayerData;
import firewolf8385.elytrapvp.SettingsManager;
import firewolf8385.elytrapvp.inventories.KitsMenu;
import firewolf8385.elytrapvp.kits.*;
import firewolf8385.elytrapvp.utils.SpawnItems;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.List;

public class PlayerMove implements Listener {

    SettingsManager settings = SettingsManager.getInstance();

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        if(settings.getConfig().getBoolean("Enabled")){
            Player p = e.getPlayer();
            PlayerData player = new PlayerData(p.getUniqueId());

            if(p.getLocation().getY() > settings.getConfig().getInt("StartLevel")){
                if(p.getInventory().contains(Material.BOW)){
                    p.setHealth(0.0);
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&6&lDeath &8- &e" + p.getName() + " &ftried to escape."));
                }
            }
            else{
                switch(player.getKit()){
                    case 1:
                        if(!Sniper.hasKit(p)){ Sniper.giveKit(p); }
                        break;
                    case 2:
                        if(!Sniper.hasKit(p)){ Knight.giveKit(p); }
                        break;
                    case 3:
                        if(!Sniper.hasKit(p)){ Pyro.giveKit(p); }
                        break;
                    case 4:
                        if(!Sniper.hasKit(p)){ Tank.giveKit(p); }
                        break;
                    case 5:
                        if(!Sniper.hasKit(p)){ Chemist.giveKit(p); }
                        break;
                    case 6:
                        if(!Sniper.hasKit(p)){ Stickman.giveKit(p); }
                        break;
                    case 7:
                        if(!Sniper.hasKit(p)){ Bomber.giveKit(p); }
                        break;
                    case 8:
                        if(!Sniper.hasKit(p)){ Healer.giveKit(p); }
                        break;
                    case 9:
                        if(!Teleporter.hasKit(p)){ Teleporter.giveKit(p); }
                        break;
                    case 10:
                        if(!Spectral.hasKit(p)){ Spectral.giveKit(p);}
                        break;
                    case 11:
                        if(!Puncher.hasKit(p)){ Puncher.giveKit(p); }
                    default:
                        Double x = settings.getConfig().getDouble("Spawn.X");
                        Double y = settings.getConfig().getDouble("Spawn.Y");
                        Double z = settings.getConfig().getDouble("Spawn.Z");
                        Float pitch = (float) settings.getConfig().getDouble("Spawn.Pitch");
                        Float yaw = (float) settings.getConfig().getDouble("Spawn.Yaw");
                        World world = p.getWorld();

                        Location spawn = new Location(world, x, y, z, yaw, pitch);
                        p.teleport(spawn);

                        SpawnItems.giveItems(p);

                        KitsMenu.openKits(p);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("Messages.Prefix") + "&cYou need to select a kit first!"));
                        break;
                }

                Block block = p.getLocation().getBlock().getRelative(BlockFace.DOWN);
                if (settings.getConfig().getBoolean("DieOnWater")) {
                    if (block.getType() == Material.WATER) {
                        p.setHealth(0);
                        String dm1 = settings.getConfig().getString("DeathMessages.Water");
                        String dm2 = dm1.replace("%player%", p.getName());
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', dm2));
                    }
                }

                List<String> deathBlocks = settings.getConfig().getStringList("DeathBlocks");
                if (deathBlocks.contains(block.getType().toString())) {
                    p.setHealth(0);
                    String dm3 = settings.getConfig().getString("DeathMessages.Block");
                    String dm4 = dm3.replace("%player%", p.getName());
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', dm4));
                }
            }
        }
    }

}
