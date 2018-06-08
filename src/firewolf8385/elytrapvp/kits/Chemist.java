package firewolf8385.elytrapvp.kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.ChatColor;

public class Chemist {

    public static ItemStack item;

    public static void giveKit(Player p) {

        ItemStack bow = new ItemStack(Material.BOW, 1);
        ItemMeta bow2 = bow.getItemMeta();
        bow2.setDisplayName(ChatColor.GOLD + "Chemist Bow");
        bow2.setUnbreakable(true);
        bow2.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        bow2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
        bow.setItemMeta(bow2);

        ItemStack potion1 = new ItemStack(Material.SPLASH_POTION, 111);
        PotionMeta potion1meta = (PotionMeta) potion1.getItemMeta();
        potion1meta.setDisplayName(ChatColor.GOLD + "Chemist Potions");
        potion1meta.addCustomEffect(new PotionEffect(PotionEffectType.HARM, 1, 0), true);
        potion1.setItemMeta(potion1meta);

        ItemStack fireworks = new ItemStack(Material.FIREWORK, 64);

        ItemStack elytra = new ItemStack(Material.ELYTRA, 1);
        ItemMeta elytrameta = elytra.getItemMeta();
        elytrameta.setUnbreakable(true);
        elytra.setItemMeta(elytrameta);

        ItemStack arrow = new ItemStack(Material.ARROW, 1);

        if (!(p.getInventory().contains(bow))) {
            p.getInventory().clear();

            p.getInventory().setItem(0, bow);

            p.getInventory().setItem(1, potion1);

            p.getInventory().setItemInOffHand(fireworks);

            p.getInventory().setItem(38, elytra);

            p.getInventory().setItem(17, arrow);
        }

    }

    public static boolean hasKit(Player p){
        if(p.getInventory().contains(item)){
            return true;
        }

        else{
            return false;
        }
    }

}
