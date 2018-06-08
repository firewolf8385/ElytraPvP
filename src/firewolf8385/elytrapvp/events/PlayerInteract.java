package firewolf8385.elytrapvp.events;

import firewolf8385.elytrapvp.SettingsManager;
import firewolf8385.elytrapvp.inventories.AchievementsMenu;
import firewolf8385.elytrapvp.inventories.KitsMenu;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

import net.md_5.bungee.api.ChatColor;

public class PlayerInteract implements Listener{

    SettingsManager settings = SettingsManager.getInstance();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {

        if(settings.getConfig().getBoolean("Enabled")) {

            Player player = e.getPlayer();
            Action action = e.getAction();

            if(action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {

                if(player.getInventory().getItemInMainHand().getType() == Material.PAPER) {
                    player.chat("/stats");
                }

                if(player.getInventory().getItemInMainHand().getType() == Material.NETHER_STAR) {
                    KitsMenu.openKits(player);
                }

                if(player.getInventory().getItemInMainHand().getType() == Material.ARROW) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("Messages.Prefix") + "&cCosmetics are coming soon."));
                }

                if(player.getInventory().getItemInMainHand().getType() == Material.BOOK) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', settings.getConfig().getString("Messages.Prefix") + "&cAchievements are coming soon."));
                    AchievementsMenu.openAcheievements(player);
                }

                if(player.getInventory().getItemInOffHand().getType() == Material.FIREWORK) {
                    player.getInventory().setItemInOffHand(new ItemStack(Material.FIREWORK, 64));
                }

                if(player.getInventory().getItemInMainHand().getType() == Material.FIREWORK) {
                    ItemStack Firework2 = new ItemStack(Material.FIREWORK, 64);
                    FireworkMeta Firework2Meta = (FireworkMeta) Firework2.getItemMeta();
                    Firework2Meta.setDisplayName(ChatColor.GOLD + "Explosive Fireworks");
                    Firework2Meta.addEffects(FireworkEffect.builder().withColor(Color.RED).with(Type.BURST).build());
                    Firework2.setItemMeta(Firework2Meta);

                    player.getInventory().setItem(2, Firework2);
                }

            }

        }

    }

}
