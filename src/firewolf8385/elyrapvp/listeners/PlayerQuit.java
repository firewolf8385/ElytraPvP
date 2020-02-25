package firewolf8385.elytrapvp.listeners;

import firewolf8385.elytrapvp.enums.Status;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener
{

    @EventHandler
    public void onQuit(PlayerQuitEvent e)
    {
        Status.list.remove(e.getPlayer().getUniqueId());
    }

}
