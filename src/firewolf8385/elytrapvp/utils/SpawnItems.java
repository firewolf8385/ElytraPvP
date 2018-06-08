package firewolf8385.elytrapvp.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpawnItems {

    public static void giveItems(Player p){

        ItemStack stats = new ItemStack(Material.PAPER);
        ItemMeta stats2 = stats.getItemMeta();
        stats2.setDisplayName(ChatColor.GOLD + "Stats");
        stats.setItemMeta(stats2);

        ItemStack kits = new ItemStack(Material.NETHER_STAR);
        ItemMeta kits2 = kits.getItemMeta();
        kits2.setDisplayName(ChatColor.GOLD + "Kit Selector");
        kits.setItemMeta(kits2);

        ItemStack upgrades = new ItemStack(Material.ARROW);
        ItemMeta upgrades2 = upgrades.getItemMeta();
        upgrades2.setDisplayName(ChatColor.GOLD + "Shop");
        upgrades.setItemMeta(upgrades2);

        ItemStack achievements = new ItemStack(Material.BOOK);
        ItemMeta achievements2 = achievements.getItemMeta();
        achievements2.setDisplayName(ChatColor.GOLD + "Achievements");
        achievements.setItemMeta(achievements2);

        p.getInventory().setItem(1, stats);
        p.getInventory().setItem(4, kits);
        p.getInventory().setItem(7, upgrades);
        p.getInventory().setItem(8, achievements);

    }

}
