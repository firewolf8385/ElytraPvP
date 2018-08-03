package firewolf8385.elytrapvp.inventories;

import firewolf8385.elytrapvp.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CosmeticsMenu {

    public static String mainGUI;

    public static void openCosmetics(Player p){
        PlayerData player = new PlayerData(p.getUniqueId());

        Inventory cosmeticsMain = Bukkit.createInventory(null, 27, "Cosmetics");

        {
            if(player.hasCosmetic("1")){
                ItemStack atRed = new ItemStack(Material.DRAGON_BREATH,  1);
                ItemMeta atRedMeta = atRed.getItemMeta();
                atRedMeta.setDisplayName(ChatColor.GOLD + "Arrow Trail - Dragon's Breath");

                List<String> atRedLore = new ArrayList<String>();
                atRedLore.add(ChatColor.GRAY + "Unlocked");
                atRedMeta.setLore(atRedLore);

                atRed.setItemMeta(atRedMeta);

                cosmeticsMain.setItem(10, atRed);
            }
            else{
                ItemStack atRed = new ItemStack(Material.DRAGON_BREATH,  1);
                ItemMeta atRedMeta = atRed.getItemMeta();
                atRedMeta.setDisplayName(ChatColor.GOLD + "Arrow Trail - Dragon's Breath");

                List<String> atRedLore = new ArrayList<String>();
                atRedLore.add(ChatColor.GRAY + "Costs: " + ChatColor.GOLD + "500 coins");
                atRedMeta.setLore(atRedLore);

                atRed.setItemMeta(atRedMeta);

                cosmeticsMain.setItem(10, atRed);
            }
        }
        {
            if(player.hasCosmetic("2")){
                ItemStack atOrange = new ItemStack(Material.INK_SAC,  1);
                ItemMeta atOrangeMeta = atOrange.getItemMeta();
                atOrangeMeta.setDisplayName(ChatColor.GOLD + "Arrow Trail - Squid Ink");

                List<String> atOrangeLore = new ArrayList<String>();
                atOrangeLore.add(ChatColor.GRAY + "Unlocked");
                atOrangeMeta.setLore(atOrangeLore);

                atOrange.setItemMeta(atOrangeMeta);

                cosmeticsMain.setItem(11, atOrange);
            }
            else{
                ItemStack atOrange = new ItemStack(Material.INK_SAC,  1);
                ItemMeta atOrangeMeta = atOrange.getItemMeta();
                atOrangeMeta.setDisplayName(ChatColor.GOLD + "Arrow Trail - Squid Ink");

                List<String> atOrangeLore = new ArrayList<String>();
                atOrangeLore.add(ChatColor.GRAY + "Costs: " + ChatColor.GOLD + "500 coins");
                atOrangeMeta.setLore(atOrangeLore);

                atOrange.setItemMeta(atOrangeMeta);

                cosmeticsMain.setItem(11, atOrange);
            }
        }
        {
            if(player.hasCosmetic("3")){
                ItemStack nautilus = new ItemStack(Material.NAUTILUS_SHELL,  1);
                ItemMeta nautilusMeta = nautilus.getItemMeta();
                nautilusMeta.setDisplayName(ChatColor.GOLD + "Arrow Trail - Nautilus");

                List<String> atOrangeLore = new ArrayList<String>();
                atOrangeLore.add(ChatColor.GRAY + "Unlocked");
                nautilusMeta.setLore(atOrangeLore);

                nautilus.setItemMeta(nautilusMeta);

                cosmeticsMain.setItem(12, nautilus);
            }
            else{
                ItemStack nautilus = new ItemStack(Material.NAUTILUS_SHELL,  1);
                ItemMeta nautilusMeta = nautilus.getItemMeta();
                nautilusMeta.setDisplayName(ChatColor.GOLD + "Arrow Trail - Nautilus");

                List<String> atOrangeLore = new ArrayList<String>();
                atOrangeLore.add(ChatColor.GRAY + "Costs: " + ChatColor.GOLD + "300 coins");
                nautilusMeta.setLore(atOrangeLore);

                nautilus.setItemMeta(nautilusMeta);

                cosmeticsMain.setItem(12, nautilus);
            }

        }
        {
            if(player.hasCosmetic("4")){
                ItemStack nautilus = new ItemStack(Material.TOTEM_OF_UNDYING,  1);
                ItemMeta nautilusMeta = nautilus.getItemMeta();
                nautilusMeta.setDisplayName(ChatColor.GOLD + "Arrow Trail - Totem");

                List<String> atOrangeLore = new ArrayList<String>();
                atOrangeLore.add(ChatColor.GRAY + "Unlocked");
                nautilusMeta.setLore(atOrangeLore);

                nautilus.setItemMeta(nautilusMeta);

                cosmeticsMain.setItem(13, nautilus);
            }
            else{
                ItemStack nautilus = new ItemStack(Material.TOTEM_OF_UNDYING,  1);
                ItemMeta nautilusMeta = nautilus.getItemMeta();
                nautilusMeta.setDisplayName(ChatColor.GOLD + "Arrow Trail - Totem");

                List<String> atOrangeLore = new ArrayList<String>();
                atOrangeLore.add(ChatColor.GRAY + "Costs: " + ChatColor.GOLD + "300 coins");
                nautilusMeta.setLore(atOrangeLore);

                nautilus.setItemMeta(nautilusMeta);

                cosmeticsMain.setItem(13, nautilus);
            }

        }
        {
            if(player.hasCosmetic("5")){
                ItemStack nautilus = new ItemStack(Material.APPLE,  1);
                ItemMeta nautilusMeta = nautilus.getItemMeta();
                nautilusMeta.setDisplayName(ChatColor.GOLD + "Arrow Trail - Heart");

                List<String> atOrangeLore = new ArrayList<String>();
                atOrangeLore.add(ChatColor.GRAY + "Unlocked");
                nautilusMeta.setLore(atOrangeLore);

                nautilus.setItemMeta(nautilusMeta);

                cosmeticsMain.setItem(14, nautilus);
            }
            else{
                ItemStack nautilus = new ItemStack(Material.APPLE,  1);
                ItemMeta nautilusMeta = nautilus.getItemMeta();
                nautilusMeta.setDisplayName(ChatColor.GOLD + "Arrow Trail - Heart");

                List<String> atOrangeLore = new ArrayList<String>();
                atOrangeLore.add(ChatColor.GRAY + "Costs: " + ChatColor.GOLD + "200 coins");
                nautilusMeta.setLore(atOrangeLore);

                nautilus.setItemMeta(nautilusMeta);

                cosmeticsMain.setItem(14, nautilus);
            }

        }
        {
            if(player.hasCosmetic("6")){
                ItemStack nautilus = new ItemStack(Material.FIRE_CHARGE,  1);
                ItemMeta nautilusMeta = nautilus.getItemMeta();
                nautilusMeta.setDisplayName(ChatColor.GOLD + "Arrow Trail - Flame");

                List<String> atOrangeLore = new ArrayList<String>();
                atOrangeLore.add(ChatColor.GRAY + "Unlocked");
                nautilusMeta.setLore(atOrangeLore);

                nautilus.setItemMeta(nautilusMeta);

                cosmeticsMain.setItem(15, nautilus);
            }
            else{
                ItemStack nautilus = new ItemStack(Material.FIRE_CHARGE,  1);
                ItemMeta nautilusMeta = nautilus.getItemMeta();
                nautilusMeta.setDisplayName(ChatColor.GOLD + "Arrow Trail - Flame");

                List<String> atOrangeLore = new ArrayList<String>();
                atOrangeLore.add(ChatColor.GRAY + "Costs: " + ChatColor.GOLD + "200 coins");
                nautilusMeta.setLore(atOrangeLore);

                nautilus.setItemMeta(nautilusMeta);

                cosmeticsMain.setItem(15, nautilus);
            }

        }
        {
            if(player.hasCosmetic("7")){
                ItemStack nautilus = new ItemStack(Material.EMERALD,  1);
                ItemMeta nautilusMeta = nautilus.getItemMeta();
                nautilusMeta.setDisplayName(ChatColor.GOLD + "Arrow Trail - Happy Villager");

                List<String> atOrangeLore = new ArrayList<String>();
                atOrangeLore.add(ChatColor.GRAY + "Unlocked");
                nautilusMeta.setLore(atOrangeLore);

                nautilus.setItemMeta(nautilusMeta);

                cosmeticsMain.setItem(16, nautilus);
            }
            else{
                ItemStack nautilus = new ItemStack(Material.EMERALD,  1);
                ItemMeta nautilusMeta = nautilus.getItemMeta();
                nautilusMeta.setDisplayName(ChatColor.GOLD + "Arrow Trail - Happy Villager");

                List<String> atOrangeLore = new ArrayList<String>();
                atOrangeLore.add(ChatColor.GRAY + "Costs: " + ChatColor.GOLD + "200 coins");
                nautilusMeta.setLore(atOrangeLore);

                nautilus.setItemMeta(nautilusMeta);

                cosmeticsMain.setItem(16, nautilus);
            }

        }

        mainGUI = cosmeticsMain.getName();

        p.openInventory(cosmeticsMain);
    }

}
