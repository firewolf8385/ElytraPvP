package firewolf8385.elytrapvp.commands;

import firewolf8385.elytrapvp.ElytraPvP;
import firewolf8385.elytrapvp.Settings;
import firewolf8385.elytrapvp.enums.Status;
import firewolf8385.elytrapvp.objects.ElytraPlayer;
import firewolf8385.elytrapvp.utils.ChatUtils;
import firewolf8385.elytrapvp.utils.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

public class Spawn implements CommandExecutor
{
    Settings settings = Settings.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        // Exit if not a player
        if(!(sender instanceof Player))
        {
            ChatUtils.chat(sender, "&2&lError &8- &cOnly players can use that command.");
            return true;
        }

        Player p = (Player) sender;
        ElytraPlayer ep = ElytraPlayer.players.get(p.getUniqueId());

        // Run if player is not in arena
        if(ep.getStatus() != Status.ARENA)
        {
            p.teleport(settings.getSpawn());
            return true;
        }

        ChatUtils.chat(p, "&2&lTeleport &8- &aTeleporting in &f5 &aseconds...");

        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncDelayedTask(ElytraPvP.getPlugin(), new Runnable()
        {
            @Override
            public void run()
            {
                ep.setStatus(Status.OTHER);

                p.teleport(settings.getSpawn());

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

                ep.setStatus(Status.LOBBY);
            }
        }, 100);


        return true;
    }

}
