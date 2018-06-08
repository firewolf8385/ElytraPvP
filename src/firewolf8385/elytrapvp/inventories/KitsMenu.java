package firewolf8385.elytrapvp.inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;

public class KitsMenu {

    public static String mainGUI;

    public static void openKits(Player p){


        Inventory kitsMain = Bukkit.createInventory(null, 45, "Kits");
        {
            ItemStack Sniper = new ItemStack(Material.BOW, 1);
            ItemMeta SniperMeta = Sniper.getItemMeta();
            SniperMeta.setDisplayName(ChatColor.GOLD + "Sniper");
            Sniper.setItemMeta(SniperMeta);

            ItemStack Knight = new ItemStack(Material.STONE_SWORD, 1);
            ItemMeta KnightMeta = Knight.getItemMeta();
            KnightMeta.setDisplayName(ChatColor.GOLD + "Knight");
            Knight.setItemMeta(KnightMeta);

            ItemStack Pyro = new ItemStack(Material.FLINT_AND_STEEL, 1);
            ItemMeta PyroMeta = Pyro.getItemMeta();
            PyroMeta.setDisplayName(ChatColor.GOLD + "Pyro");
            Pyro.setItemMeta(PyroMeta);

            ItemStack Tank = new ItemStack(Material.IRON_CHESTPLATE, 1);
            ItemMeta TankMeta = Tank.getItemMeta();
            TankMeta.setDisplayName(ChatColor.GOLD + "Tank");
            Tank.setItemMeta(TankMeta);

            ItemStack Chemist = new ItemStack(Material.POTION);
            PotionMeta ChemistMeta = (PotionMeta) Chemist.getItemMeta();
            ChemistMeta.setDisplayName(ChatColor.GOLD + "Chemist");
            Chemist.setItemMeta(ChemistMeta);

            ItemStack Stickman = new ItemStack(Material.STICK);
            ItemMeta StickmanMeta = Stickman.getItemMeta();
            StickmanMeta.setDisplayName(ChatColor.GOLD + "Stickman");
            Stickman.setItemMeta(StickmanMeta);

            ItemStack Bomber = new ItemStack(Material.TNT);
            ItemMeta BomberMeta = Bomber.getItemMeta();
            BomberMeta.setDisplayName(ChatColor.GOLD + "Bomber");
            Bomber.setItemMeta(BomberMeta);

            ItemStack Healer = new ItemStack(Material.GOLDEN_APPLE);
            ItemMeta HealerMeta = Healer.getItemMeta();
            HealerMeta.setDisplayName(ChatColor.GOLD + "Healer");
            Healer.setItemMeta(HealerMeta);

            kitsMain.setItem(10, Sniper);
            kitsMain.setItem(12, Knight);
            kitsMain.setItem(14, Pyro);
            kitsMain.setItem(16, Tank);
            kitsMain.setItem(28, Chemist);
            kitsMain.setItem(30, Stickman);
            // kitsMain.setItem(32, Bomber);
            kitsMain.setItem(32, Healer);

            mainGUI = kitsMain.getName();

            p.openInventory(kitsMain);
        }

    }


}
