package firewolf8385.elytrapvp.listeners;

import firewolf8385.elytrapvp.Settings;
import firewolf8385.elytrapvp.enums.Status;
import firewolf8385.elytrapvp.objects.ElytraPlayer;
import firewolf8385.elytrapvp.utils.ItemUtils;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener
{
    Settings settings = Settings.getInstance();

    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
        Player p = e.getPlayer();
        ElytraPlayer ep = new ElytraPlayer(p);

        // Set the status of the player.
        ep.setStatus(Status.LOBBY);

        // Create player if haven't joined before.
        if(!ep.hasJoined())
        {
            ep.createPlayer();
        }

        // Exit if plugin is disabled.
        if(!settings.isEnabled())
        {
            return;
        }

        // Teleport player to spawn if spawn is set.
        if(settings.isSpawnSet())
        {
            p.teleport(settings.getSpawn());
        }

        // Fix player's health
        p.setHealth(20);
        p.setMaxHealth(20);

        // Reset player's inventory.
        p.getInventory().clear();
        p.getInventory().setItem(1, ItemUtils.createItem(Material.EMERALD, "&aCosmetics"));
        p.getInventory().setItem(4, ItemUtils.createItem(Material.NETHER_STAR, "&aKit Selector"));
        p.getInventory().setItem(7, ItemUtils.createItem(Material.PAPER, "&aStats"));
        p.getInventory().setItem(8, ItemUtils.createItem(Material.BOOK, "&aAchievements"));

        // Set player to adventure mode.
        p.setGameMode(GameMode.ADVENTURE);

    }

}