package firewolf8385.elytrapvp.listeners;

import firewolf8385.elytrapvp.Settings;
import firewolf8385.elytrapvp.enums.Status;
import firewolf8385.elytrapvp.events.PlayerDrownEvent;
import firewolf8385.elytrapvp.events.PlayerEscapeEvent;
import firewolf8385.elytrapvp.events.PlayerTouchGroundEvent;
import firewolf8385.elytrapvp.objects.ElytraPlayer;
import firewolf8385.elytrapvp.objects.Kit;
import firewolf8385.elytrapvp.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener
{
    Settings settings = Settings.getInstance();

    @EventHandler
    public void onMove(PlayerMoveEvent e)
    {
        Player p = e.getPlayer();
        ElytraPlayer ep = new ElytraPlayer(p);

        // Exit if not enabled.
        if(!settings.isEnabled())
        {
            return;
        }

        // Exit if not in lobby or in game.
        if(ep.getStatus() == Status.OTHER)
        {
            return;
        }

        // Exit if not kit selected.
        if (ep.getKit() == 0 && p.getLocation().getY() <= settings.getStartLevel()) {
            p.teleport(settings.getSpawn());
            ChatUtils.chat(p, "&2&lError &8- &cYou have not selected a kit.");
            return;
        }

        // Give a player their kit.
        if(ep.getKit() != 0 && p.getLocation().getY() <= settings.getStartLevel())
        {
            Kit k = Kit.list.get(ep.getKit());

            k.giveItems(p);
        }

        // Change player's status to arena
        if(p.getLocation().getY() < settings.getStartLevel() && ep.getStatus() == Status.LOBBY)
        {
            ep.setStatus(Status.ARENA);
        }

        // Exit if in Lobby
        if(ep.getStatus() == Status.LOBBY)
        {
            return;
        }

        // Check if player tries to escape.
        if(p.getLocation().getY() > settings.getStartLevel() && ep.getStatus() == Status.ARENA)
        {
            Bukkit.getPluginManager().callEvent(new PlayerEscapeEvent(p));
            return;
        }

        // Check if player is touching the ground.
        if(!p.isGliding())
        {
            Block block = p.getLocation().getBlock().getRelative(BlockFace.DOWN);
            Block block2 = p.getLocation().getBlock();

            // Calls PlayerDrownEvent is player is touching the water.
            if (block.getType() == Material.WATER || block2.getType() == Material.WATER)
            {
                Bukkit.getPluginManager().callEvent(new PlayerDrownEvent(p));
            }

            // Calls PlayerTouchGroundEvent if player touches the ground.
            else if (settings.getDeathBlocks().contains(block.getType().toString()))
            {
                Bukkit.getPluginManager().callEvent(new PlayerTouchGroundEvent(p));
            }
        }
    }

}
