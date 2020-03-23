package firewolf8385.elytrapvp.listeners;

import firewolf8385.elytrapvp.enums.Status;
import firewolf8385.elytrapvp.kits.Spectator;
import firewolf8385.elytrapvp.objects.ElytraPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener
{

    @EventHandler
    public void onQuit(PlayerQuitEvent e)
    {
        Player p = e.getPlayer();
        ElytraPlayer ep = ElytraPlayer.players.get(p.getUniqueId());
        ElytraPlayer.players.remove(p.getUniqueId());

        if(ep.getStatus() == Status.SPECTATOR)
        {
            Spectator.remove(p);
        }

        Status.list.remove(e.getPlayer().getUniqueId());
    }

}
