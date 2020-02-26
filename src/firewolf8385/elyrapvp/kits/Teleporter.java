package firewolf8385.elytrapvp.kits;

import firewolf8385.elytrapvp.objects.ElytraPlayer;
import firewolf8385.elytrapvp.objects.Kit;
import firewolf8385.elytrapvp.utils.StringUtils;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Teleporter extends Kit
{
    public Teleporter()
    {
        super("Teleporter", 9, 23, 400);
        getPreview();
    }

    public ItemStack getIcon(Player p)
    {
        ElytraPlayer ep = new ElytraPlayer(p);

        if(!ep.getUnlockedKits().contains(getNumber()))
        {
            ItemStack icon = new ItemStack(Material.GRAY_DYE);
            ItemMeta meta = icon.getItemMeta();
            meta.setDisplayName(StringUtils.translate("&cTeleporter"));

            List<String> lore = new ArrayList<>();
            lore.add(StringUtils.translate("&7Confuse your enemies"));
            lore.add(StringUtils.translate("&7with enderpearls."));
            lore.add("");
            lore.add(StringUtils.translate("&7Left Click To Purchase"));
            lore.add(StringUtils.translate("&7Right Click To Preview"));
            lore.add("");
            lore.add(StringUtils.translate("&6Price: 500 Coins"));

            meta.setLore(lore);
            icon.setItemMeta(meta);

            return icon;
        }
        else
        {
            ItemStack icon = new ItemStack(Material.ENDER_PEARL);
            ItemMeta meta = icon.getItemMeta();
            meta.setDisplayName(StringUtils.translate("&aTeleporter"));

            List<String> lore = new ArrayList<>();
            lore.add(StringUtils.translate("&7Confuse your enemies"));
            lore.add(StringUtils.translate("&7with enderpearls."));
            lore.add("");
            lore.add(StringUtils.translate("&7Left Click To Select"));
            lore.add(StringUtils.translate("&7Right Click To Preview"));

            meta.setLore(lore);
            icon.setItemMeta(meta);

            return icon;
        }
    }

    public void giveItems(Player p)
    {
        ItemStack bow = new ItemStack(Material.BOW, 1);
        ItemMeta bow2 = bow.getItemMeta();
        bow2.setDisplayName(ChatColor.GREEN + "Teleporter Bow");
        bow2.setUnbreakable(true);
        bow2.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        bow2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
        bow.setItemMeta(bow2);

        ItemStack fireworks = new ItemStack(Material.FIREWORK_ROCKET, 64);

        ItemStack elytra = new ItemStack(Material.ELYTRA, 1);
        ItemMeta elytrameta = elytra.getItemMeta();
        elytrameta.setUnbreakable(true);
        elytra.setItemMeta(elytrameta);

        ItemStack enderpearl = new ItemStack(Material.ENDER_PEARL, 16);
        ItemStack chorusfruit = new ItemStack(Material.CHORUS_FRUIT, 16);

        ItemStack arrow = new ItemStack(Material.ARROW, 1);

        if(!p.getInventory().contains(bow))
        {
            p.getInventory().clear();
            p.getInventory().setItem(0, bow);
            p.getInventory().setItem(1, enderpearl);
            p.getInventory().setItem(2, chorusfruit);
            p.getInventory().setItemInOffHand(fireworks);
            p.getInventory().setChestplate(elytra);
            p.getInventory().setItem(17, arrow);
        }

    }

    public void getPreview()
    {
        Inventory inv = Bukkit.createInventory(null, 54, "Preview");

        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        int[] fillers = new int[]{0, 1, 2,3,4,5,6,7,8,9,11,13,14,15,17,18,20,21,22,23,24,25,26,27,29,35,36,37,38,39,40,41,42,43,44,45,46,47,48,50,51,52,53};

        ItemStack bow = new ItemStack(Material.BOW, 1);
        ItemMeta bow2 = bow.getItemMeta();
        bow2.setDisplayName(ChatColor.GREEN + "Teleporter Bow");
        bow2.setUnbreakable(true);
        bow2.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        bow2.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
        bow.setItemMeta(bow2);

        ItemStack fireworks = new ItemStack(Material.FIREWORK_ROCKET, 64);

        ItemStack elytra = new ItemStack(Material.ELYTRA, 1);
        ItemMeta elytrameta = elytra.getItemMeta();
        elytrameta.setUnbreakable(true);
        elytra.setItemMeta(elytrameta);

        ItemStack enderpearl = new ItemStack(Material.ENDER_PEARL, 16);
        ItemStack chorusfruit = new ItemStack(Material.CHORUS_FRUIT, 16);

        ItemStack arrow = new ItemStack(Material.ARROW, 1);

        ItemStack leave = new ItemStack(Material.BARRIER);
        ItemMeta leaveMeta = leave.getItemMeta();
        leaveMeta.setDisplayName(StringUtils.translate("&cBack"));
        leave.setItemMeta(leaveMeta);

        for(int i : fillers)
        {
            inv.setItem(i, filler);
        }

        inv.setItem(10, elytra);
        inv.setItem(12, fireworks);
        inv.setItem(16, arrow);
        inv.setItem(30, bow);
        inv.setItem(31, enderpearl);
        inv.setItem(32, chorusfruit);
        inv.setItem(49, leave);

        super.setPreviewKit(inv);
    }

}