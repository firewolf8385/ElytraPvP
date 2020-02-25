package firewolf8385.elytrapvp.listeners;

import firewolf8385.elytrapvp.Settings;
import firewolf8385.elytrapvp.enums.Status;
import firewolf8385.elytrapvp.events.PlayerDrownEvent;
import firewolf8385.elytrapvp.events.PlayerEscapeEvent;
import firewolf8385.elytrapvp.events.PlayerTouchGroundEvent;
import firewolf8385.elytrapvp.objects.ElytraPlayer;
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
        if(ep.getStatus().equals(Status.OTHER))
        {
            return;
        }

        // Change player's status to arena
        if(p.getLocation().getY() <= settings.getStartLevel() && ep.getStatus().equals(Status.LOBBY))
        {
            ep.setStatus(Status.ARENA);
        }

        // Check if player tries to escape.
        if(p.getLocation().getY() > settings.getStartLevel() && ep.getStatus().equals(Status.ARENA))
        {
            Bukkit.getPluginManager().callEvent(new PlayerEscapeEvent(p));
            p.setHealth(0);
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
                p.setHealth(0);
            }

            // Calls PlayerTouchGroundEvent if player touches the ground.
            if (settings.getDeathBlocks().contains(block.getType().toString()))
            {
                Bukkit.getPluginManager().callEvent(new PlayerTouchGroundEvent(p));
                p.setHealth(0);
            }
        }
    }

}
