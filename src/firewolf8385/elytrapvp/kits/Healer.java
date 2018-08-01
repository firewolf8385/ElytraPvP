package firewolf8385.elytrapvp.kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.ChatColor;

public class Healer {

    public static ItemStack item;

    public static void giveKit(Player p) {

        ItemStack bow = new ItemStack(Material.BOW, 1);
        ItemMeta bow2 = bow.getItemMeta();
        bow2.setDisplayName(ChatColor.GOLD + "Healer Bow");
        bow2.setUnbreakable(true);
        bow2.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        bow2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
        bow.setItemMeta(bow2);

        ItemStack fireworks = new ItemStack(Material.FIREWORK_ROCKET, 64);

        ItemStack elytra = new ItemStack(Material.ELYTRA, 1);
        ItemMeta elytrameta = elytra.getItemMeta();
        elytrameta.setUnbreakable(true);
        elytra.setItemMeta(elytrameta);

        ItemStack arrow = new ItemStack(Material.ARROW, 1);

        if (!(p.getInventory().contains(bow))) {
            p.getInventory().clear();

            p.getInventory().setItem(0, bow);

            p.getInventory().setItemInOffHand(fireworks);

            p.getInventory().setItem(38, elytra);

            p.getInventory().setItem(17, arrow);

            p.setMaxHealth(16);
            p.setHealth(16);

            p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000 , 0));

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
