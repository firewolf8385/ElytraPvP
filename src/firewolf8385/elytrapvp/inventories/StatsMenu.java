package firewolf8385.elytrapvp.inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class StatsMenu {

    public static String mainGUI;

    public void openStats(Player p){

        Inventory statsMain = Bukkit.createInventory(null, 27, "Stats");

        {
            ItemStack kills = new ItemStack(Material.DIAMOND_SWORD,  1);
        }

        {
            ItemStack deaths = new ItemStack(Material.REDSTONE, 1);
        }

        {
            ItemStack coins = new ItemStack(Material.GOLD_INGOT, 1);
        }
    }



}
