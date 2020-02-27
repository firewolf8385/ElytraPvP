package firewolf8385.elytrapvp.inventories;

import firewolf8385.elytrapvp.objects.ElytraPlayer;
import firewolf8385.elytrapvp.objects.Kit;
import firewolf8385.elytrapvp.utils.ChatUtils;
import firewolf8385.elytrapvp.utils.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class KitsGUI
{

    public static void view(Player p)
    {
        Inventory inv = Bukkit.createInventory(null, 54, "Kits");

        ItemStack spectator = ItemUtils.createItem(Material.COMPASS, "&aSpectator");

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

        inv.setItem(40, spectator);

        p.openInventory(inv);
    }

    public static void click(Player p, String item, ClickType c)
    {
        ElytraPlayer ep = new ElytraPlayer(p);

        if(item.equals("Spectator"))
        {
            ep.setKit(-1);
            ChatUtils.chat(p, "&2&lSpectator &8- &aEntered spectator mode.");
            return;
        }

        if(item.equals("Back"))
        {
            KitsGUI.view(p);
            return;
        }

        for(Kit k : Kit.list.values())
        {
            if(k.getName().equals(item))
            {
                if(c.isLeftClick())
                {
                    if(ep.getUnlockedKits().contains("" + k.getNumber()) || k.getPrice() == 0)
                    {
                        ep.setKit(k.getNumber());
                        p.closeInventory();
                        ChatUtils.chat(p, "&2&lKit &8- &aYou have selected Kit &f" + k.getName() + "&a.");
                    }
                    else
                    {
                        if(ep.getCoins() >= k.getPrice())
                        {
                            ep.removeCoins(k.getPrice());
                            ChatUtils.chat(p, "&2&lKit &8- &aYou have purchased and equipped Kit &f" + k.getName() + "&a.");
                            ep.setKit(k.getNumber());
                            ep.unlockKit(k.getNumber());
                            p.closeInventory();
                        }
                        else
                        {
                            ChatUtils.chat(p, "&2&lError &8- &cYou do not have enough coins.");
                            p.closeInventory();
                        }
                    }
                }
                else
                {
                    k.preview(p);
                }
            }
        }
    }

}