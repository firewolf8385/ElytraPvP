package firewolf8385.elytrapvp.listeners;

import firewolf8385.elytrapvp.Settings;
import firewolf8385.elytrapvp.enums.Status;
import firewolf8385.elytrapvp.objects.ElytraPlayer;
import firewolf8385.elytrapvp.utils.StringUtils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntity implements Listener
{
    Settings settings = Settings.getInstance();

    @EventHandler
    public void onDamageByEntity(EntityDamageByEntityEvent e)
    {
        // Exit if not enabled.
        if(!settings.isEnabled())
        {
            return;
        }

        // Exit if entity isn't player.
        if(!(e.getEntity() instanceof Player))
        {
            Player pl = (Player) e.getEntity();
            ElytraPlayer ep = ElytraPlayer.players.get(pl.getUniqueId());

            if(ep.getStatus() == Status.SPECTATOR)
            {
                e.setCancelled(true);
            }

            return;
        }

        // Exit if damager is not an arrow.
        if(!(e.getDamager() instanceof Arrow))
        {
            return;
        }

        Arrow a = (Arrow) e.getDamager();
        Player p = (Player) e.getEntity();

        // Exit if arrow shooter is not a player.
        if(!(a.getShooter() instanceof Player))
        {
            return;
        }

        Player shooter = (Player) a.getShooter();

        shooter.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(StringUtils.translate("&a" + p.getName() + "'s health: &c" + (p.getHealth() - e.getFinalDamage()))));
    }
}
