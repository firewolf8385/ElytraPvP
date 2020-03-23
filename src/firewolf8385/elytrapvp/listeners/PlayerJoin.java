package firewolf8385.elytrapvp.listeners;

import firewolf8385.elytrapvp.ElytraPvP;
import firewolf8385.elytrapvp.MySQL;
import firewolf8385.elytrapvp.Settings;
import firewolf8385.elytrapvp.enums.Status;
import firewolf8385.elytrapvp.kits.Spectator;
import firewolf8385.elytrapvp.objects.ElytraPlayer;
import firewolf8385.elytrapvp.utils.ItemUtils;
import firewolf8385.elytrapvp.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class PlayerJoin implements Listener
{
    Settings settings = Settings.getInstance();

    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
        Player p = e.getPlayer();
        ElytraPlayer ep = new ElytraPlayer(p);
        ElytraPlayer.players.put(p.getUniqueId(), ep);

        // Set the status of the player.
        ep.setStatus(Status.LOBBY);

        // Ensure Database Connection.
        MySQL.ensureConnection();

        // Create player if haven't joined before.
        if(!ep.hasJoined())
        {
            ep.createPlayer();
            Bukkit.broadcastMessage(StringUtils.translate("&2&lWelcome &8- &f" + p.getName() + " &ahas joined for the first time!"));
        }

        // Exit if plugin is disabled.
        if(!settings.isEnabled())
        {
            return;
        }

        // Hide players in spectator mode.
        for(UUID u : Spectator.spectators)
        {
            p.hidePlayer(ElytraPvP.getPlugin(), Bukkit.getPlayer(u));
        }

        // Teleport player to spawn if spawn is set.
        if(settings.isSpawnSet())
        {
            p.teleport(settings.getSpawn());
        }

        // Fix player's health
        p.setMaxHealth(20);
        p.setHealth(20);

        // Reset player's inventory.
        p.getInventory().clear();
        p.getInventory().setItem(0, ItemUtils.createItem(Material.EMERALD, "&aItem Shop"));
        p.getInventory().setItem(1, ItemUtils.createItem(Material.CHEST, "&aCosmetics"));
        p.getInventory().setItem(4, ItemUtils.createItem(Material.NETHER_STAR, "&aKit Selector"));
        p.getInventory().setItem(7, ItemUtils.createItem(Material.PAPER, "&aStats"));
        p.getInventory().setItem(8, ItemUtils.createItem(Material.BOOK, "&aAchievements"));

        // Set player to adventure mode.
        p.setGameMode(GameMode.ADVENTURE);

    }

}
