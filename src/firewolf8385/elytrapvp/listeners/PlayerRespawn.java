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
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawn implements Listener
{
    Settings settings = Settings.getInstance();

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e)
    {
        Player p = e.getPlayer();
        ElytraPlayer ep = ElytraPlayer.players.get(p.getUniqueId());

        ep.setStatus(Status.LOBBY);

        e.setRespawnLocation(settings.getSpawn());

        // Fix player's health
        p.setMaxHealth(20);
        p.setHealth(20);

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
