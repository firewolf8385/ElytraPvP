package firewolf8385.elytrapvp.events;

import firewolf8385.elytrapvp.PlayerData;
import firewolf8385.elytrapvp.inventories.AchievementsMenu;
import firewolf8385.elytrapvp.inventories.CosmeticsMenu;
import firewolf8385.elytrapvp.inventories.KitsMenu;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

import static org.bukkit.Bukkit.getServer;

public class InventoryClick implements Listener{

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();
        PlayerData player = new PlayerData(p.getUniqueId());

        ItemStack clicked = e.getCurrentItem();
        Inventory inventory = e.getInventory();

        if(inventory.getName().equals(KitsMenu.mainGUI)) {
            if(clicked.getType() == Material.BOW) {
                e.setCancelled(true);
                p.closeInventory();
                player.setKit(1);
                player.savePlayerConfig();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&lKit &8- &aYou Have Selected Kit Sniper"));
            }
            else if(clicked.getType() == Material.STONE_SWORD) {
                e.setCancelled(true);
                p.closeInventory();
                player.setKit(2);
                player.savePlayerConfig();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&lKit &8- &aYou Have Selected Kit Knight"));
            }
            else if(clicked.getType() == Material.FLINT_AND_STEEL) {
                e.setCancelled(true);
                p.closeInventory();
                player.setKit(3);
                player.savePlayerConfig();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&lKit &8- &aYou Have Selected Kit Pyro"));
            }
            else if(clicked.getType() == Material.IRON_CHESTPLATE) {
                e.setCancelled(true);
                p.closeInventory();
                player.setKit(4);
                player.savePlayerConfig();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&lKit &8- &aYou Have Selected Kit Tank"));
            }
            else if(clicked.getType() == Material.POTION) {
                e.setCancelled(true);
                p.closeInventory();
                player.setKit(5);
                player.savePlayerConfig();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&lKit &8- &aYou Have Selected Kit Chemist"));
            }
            else if(clicked.getType() == Material.STICK) {
                e.setCancelled(true);
                p.closeInventory();
                player.setKit(6);
                player.savePlayerConfig();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&lKit &8- &aYou Have Selected Kit Stickman"));
            }
            else if(clicked.getType() == Material.TNT) {
                e.setCancelled(true);
                p.closeInventory();
                player.setKit(7);
                player.savePlayerConfig();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&lKit &8- &aYou Have Selected Kit Bomber"));
            }
            else if(clicked.getType() == Material.GOLDEN_APPLE) {
                e.setCancelled(true);
                p.closeInventory();
                player.setKit(8);
                player.savePlayerConfig();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&lKit &8- &aYou Have Selected Kit Healer"));
            }
            else if(clicked.getType() == Material.ENDER_PEARL) {
                e.setCancelled(true);
                p.closeInventory();
                player.setKit(9);
                player.savePlayerConfig();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&lKit &8- &aYou Have Selected Kit Teleporter"));
            }
            else if(clicked.getType() == Material.SPECTRAL_ARROW) {
                e.setCancelled(true);
                p.closeInventory();
                player.setKit(10);
                player.savePlayerConfig();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&lKit &8- &aYou Have Selected Kit Spectral"));
            }
            else if(clicked.getType().equals(Material.ENCHANTED_BOOK)) {
                e.setCancelled(true);
                p.closeInventory();
                player.setKit(11);
                player.savePlayerConfig();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&lKit &8- &aYou Have Selected Kit Puncher"));
            }
            else {
                e.setCancelled(true);
            }
        }

        if(inventory.getName().equals(CosmeticsMenu.mainGUI)){
            if(clicked.getType().equals(Material.DRAGON_BREATH)){
                if(clicked.getItemMeta().getLore().contains(ChatColor.GRAY + "Unlocked")){
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCosmetics &8- &7You Have Selected &eArrow Trail - Dragon's Breath"));
                    getServer().dispatchCommand(getServer().getConsoleSender(), "atrail " + p.getName() + " dragon_breath");
                }
                else{
                    if(player.getCoins() >= 500){
                        e.setCancelled(true);
                        player.removeCoins(500);
                        player.setHasCosmetic("1", true);
                        player.savePlayerConfig();
                        CosmeticsMenu.openCosmetics(p);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCosmetics &8- &7You Have Successfully Purchased &eArrow Trail - Dragon's Breath"));
                    }
                    else{
                        e.setCancelled(true);
                        p.closeInventory();
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCosmetics &8- &cYou do not have enough coins for that"));
                    }
                }
            }
            if(clicked.getType().equals(Material.INK_SAC)){
                if(clicked.getItemMeta().getLore().contains(ChatColor.GRAY + "Unlocked")){
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCosmetics &8- &7You Have Selected &eArrow Trail - Squid Ink"));
                    getServer().dispatchCommand(getServer().getConsoleSender(), "atrail " + p.getName() + " squid_ink");
                }
                else{
                    if(player.getCoins() >= 500){
                        e.setCancelled(true);
                        player.removeCoins(500);
                        player.setHasCosmetic("2", true);
                        player.savePlayerConfig();
                        CosmeticsMenu.openCosmetics(p);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCosmetics &8- &7You Have Successfully Purchased &eArrow Trail - Squid Ink"));
                    }
                    else{
                        e.setCancelled(true);
                        p.closeInventory();
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCosmetics &8- &cYou do not have enough coins for that"));
                    }
                }
            }
            if(clicked.getType().equals(Material.NAUTILUS_SHELL)){
                if(clicked.getItemMeta().getLore().contains(ChatColor.GRAY + "Unlocked")){
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCosmetics &8- &7You Have Selected &eArrow Trail - Nautilus"));
                    getServer().dispatchCommand(getServer().getConsoleSender(), "atrail " + p.getName() + " nautilus");
                }
                else{
                    if(player.getCoins() >= 300){
                        e.setCancelled(true);
                        player.removeCoins(300);
                        player.setHasCosmetic("3", true);
                        player.savePlayerConfig();
                        CosmeticsMenu.openCosmetics(p);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCosmetics &8- &7You Have Successfully Purchased &eArrow Trail - Nautilus"));
                    }
                    else{
                        e.setCancelled(true);
                        p.closeInventory();
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCosmetics &8- &cYou do not have enough coins for that"));
                    }
                }
            }
            if(clicked.getType().equals(Material.TOTEM_OF_UNDYING)){
                if(clicked.getItemMeta().getLore().contains(ChatColor.GRAY + "Unlocked")){
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCosmetics &8- &7You Have aSelected &eArrow Trail - Totem"));
                    getServer().dispatchCommand(getServer().getConsoleSender(), "atrail " + p.getName() + " totem");
                }
                else{
                    if(player.getCoins() >= 300){
                        e.setCancelled(true);
                        player.removeCoins(300);
                        player.setHasCosmetic("4", true);
                        player.savePlayerConfig();
                        CosmeticsMenu.openCosmetics(p);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCosmetics &8- &7You Have Successfully Purchased &eArrow Trail - Totem"));
                    }
                    else{
                        e.setCancelled(true);
                        p.closeInventory();
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCosmetics &8- &cYou do not have enough coins for that"));
                    }
                }
            }
            if(clicked.getType().equals(Material.APPLE)){
                if(clicked.getItemMeta().getLore().contains(ChatColor.GRAY + "Unlocked")){
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCosmetics &8- &7You Have aSelected &eArrow Trail - Heart"));
                    getServer().dispatchCommand(getServer().getConsoleSender(), "atrail " + p.getName() + " heart");
                }
                else{
                    if(player.getCoins() >= 200){
                        e.setCancelled(true);
                        player.removeCoins(200);
                        player.setHasCosmetic("5", true);
                        player.savePlayerConfig();
                        CosmeticsMenu.openCosmetics(p);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCosmetics &8- &7You Have Successfully Purchased &eArrow Trail - Heart"));
                    }
                    else{
                        e.setCancelled(true);
                        p.closeInventory();
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCosmetics &8- &cYou do not have enough coins for that"));
                    }
                }
            }
            if(clicked.getType().equals(Material.FIRE_CHARGE)){
                if(clicked.getItemMeta().getLore().contains(ChatColor.GRAY + "Unlocked")){
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCosmetics &8- &7You Have aSelected &eArrow Trail - Flame"));
                    getServer().dispatchCommand(getServer().getConsoleSender(), "atrail " + p.getName() + " flame");
                }
                else{
                    if(player.getCoins() >= 200){
                        e.setCancelled(true);
                        player.removeCoins(200);
                        player.setHasCosmetic("6", true);
                        player.savePlayerConfig();
                        CosmeticsMenu.openCosmetics(p);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCosmetics &8- &7You Have Successfully Purchased &eArrow Trail - Flame"));
                    }
                    else{
                        e.setCancelled(true);
                        p.closeInventory();
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCosmetics &8- &cYou do not have enough coins for that"));
                    }
                }
            }
            if(clicked.getType().equals(Material.EMERALD)){
                if(clicked.getItemMeta().getLore().contains(ChatColor.GRAY + "Unlocked")){
                    p.closeInventory();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCosmetics &8- &7You Have aSelected &eArrow Trail - Happy Villager"));
                    getServer().dispatchCommand(getServer().getConsoleSender(), "atrail " + p.getName() + " villager_happy");
                }
                else{
                    if(player.getCoins() >= 200){
                        e.setCancelled(true);
                        player.removeCoins(200);
                        player.setHasCosmetic("7", true);
                        player.savePlayerConfig();
                        CosmeticsMenu.openCosmetics(p);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCosmetics &8- &7You Have Successfully Purchased &eArrow Trail - Happy Villager"));
                    }
                    else{
                        e.setCancelled(true);
                        p.closeInventory();
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCosmetics &8- &cYou do not have enough coins for that"));
                    }
                }
            }

        }


}

}
