package firewolf8385.elytrapvp.listeners;

import firewolf8385.elytrapvp.events.PlayerTouchGroundEvent;
import firewolf8385.elytrapvp.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerTouchGround implements Listener
{
    @EventHandler
    public void onTouchGround(PlayerTouchGroundEvent e)
    {
        Player p = e.getPlayer();

        p.setHealth(0);
        Bukkit.broadcastMessage(StringUtils.translate("&2&lDeath &8- &f" + p.getName() + " &atried to land."));
    }

}
