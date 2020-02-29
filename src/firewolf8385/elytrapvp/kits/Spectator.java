package firewolf8385.elytrapvp.kits;

import firewolf8385.elytrapvp.ElytraPvP;
import firewolf8385.elytrapvp.Settings;
import firewolf8385.elytrapvp.enums.Status;
import firewolf8385.elytrapvp.objects.ElytraPlayer;
import firewolf8385.elytrapvp.utils.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Spectator
{
    static Settings settings = Settings.getInstance();
    public static Set<UUID> spectators = new HashSet<>();

    public static void add(Player p)
    {
        ElytraPlayer ep = ElytraPlayer.players.get(p.getUniqueId());

        ep.setStatus(Status.SPECTATOR);

        for(Player pl : Bukkit.getOnlinePlayers())
        {
            pl.hidePlayer(ElytraPvP.getPlugin(), p);
        }

        spectators.add(p.getUniqueId());

        p.setAllowFlight(true);
        p.setFlying(true);
        p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000 , 2));

        p.getInventory().clear();
        p.getInventory().setItem(0, ItemUtils.createItem(Material.BARRIER, "&cLeave"));
    }

    public static void remove(Player p)
    {
        ElytraPlayer ep = ElytraPlayer.players.get(p.getUniqueId());

        p.teleport(settings.getSpawn());
        ep.setStatus(Status.LOBBY);

        for(Player pl : Bukkit.getOnlinePlayers())
        {
            p.showPlayer(ElytraPvP.getPlugin(), pl);
        }

        spectators.remove(p.getUniqueId());

        p.setFlying(false);
        p.setAllowFlight(false);
        p.removePotionEffect(PotionEffectType.INVISIBILITY);

        p.getInventory().clear();
        p.getInventory().setItem(1, ItemUtils.createItem(Material.EMERALD, "&aCosmetics"));
        p.getInventory().setItem(4, ItemUtils.createItem(Material.NETHER_STAR, "&aKit Selector"));
        p.getInventory().setItem(7, ItemUtils.createItem(Material.PAPER, "&aStats"));
        p.getInventory().setItem(8, ItemUtils.createItem(Material.BOOK, "&aAchievements"));
    }

}