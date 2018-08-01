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


}

}
