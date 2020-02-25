package firewolf8385.elytrapvp.inventories;

import firewolf8385.elytrapvp.objects.Kit;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class KitsGUI
{

    public static void view(Player p)
    {
        Inventory inv = Bukkit.createInventory(null, 54, "Kits");

        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        int[] fillers = new int[]{0,1,2,3,4,5,6,7,8,9,17,18,26,27,35,36,44,45,46,47,48,49,50,51,52,53};

        for(int i : fillers)
        {
            inv.setItem(i, filler);
        }

        for(Kit k : Kit.list.values())
        {
            inv.setItem(k.getSlot(), k.getIcon(p));
        }

        p.openInventory(inv);
    }

}