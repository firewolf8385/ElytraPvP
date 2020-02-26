package firewolf8385.elytrapvp.kits;

import firewolf8385.elytrapvp.objects.ElytraPlayer;
import firewolf8385.elytrapvp.objects.Kit;
import firewolf8385.elytrapvp.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Poseidon extends Kit
{
    public Poseidon()
    {
        super("Poseidon", 12, 30, 400);
        getPreview();
    }

    public ItemStack getIcon(Player p)
    {
        ElytraPlayer ep = new ElytraPlayer(p);

        if(!ep.getUnlockedKits().contains(getNumber() + ""))
        {
            ItemStack icon = new ItemStack(Material.GRAY_DYE);
            ItemMeta meta = icon.getItemMeta();
            meta.setDisplayName(StringUtils.translate("&cPoseidon"));

            List<String> lore = new ArrayList<>();
            lore.add(StringUtils.translate("&7Obliterate your enemies"));
            lore.add(StringUtils.translate("&7with a trident."));
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
            ItemStack icon = new ItemStack(Material.TRIDENT);
            ItemMeta meta = icon.getItemMeta();
            meta.setDisplayName(StringUtils.translate("&aPoseidon"));

            List<String> lore = new ArrayList<>();
            lore.add(StringUtils.translate("&7Obliterate your enemies"));
            lore.add(StringUtils.translate("&7with a trident."));
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
        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta bowMeta = bow.getItemMeta();
        bowMeta.setDisplayName(StringUtils.translate("&aPoseidon's Bow"));
        bowMeta.setUnbreakable(true);
        bowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        bow.setItemMeta(bowMeta);

        ItemStack trident = new ItemStack(Material.TRIDENT);
        ItemMeta tridentMeta = trident.getItemMeta();
        tridentMeta.setDisplayName(StringUtils.translate("&aPoseidon's Trident"));
        tridentMeta.setUnbreakable(true);
        tridentMeta.addEnchant(Enchantment.LOYALTY, 3, true);
        trident.setItemMeta(tridentMeta);

        ItemStack fireworks = new ItemStack(Material.FIREWORK_ROCKET, 64);

        ItemStack arrow = new ItemStack(Material.ARROW);

        ItemStack elytra = new ItemStack(Material.ELYTRA);
        ItemMeta elytraMeta = elytra.getItemMeta();
        elytraMeta.setUnbreakable(true);
        elytra.setItemMeta(elytraMeta);

        if(!p.getInventory().contains(bow))
        {
            p.getInventory().clear();
            p.getInventory().setItem(1, bow);
            p.getInventory().setItem(0, trident);
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

        ItemStack trident = new ItemStack(Material.TRIDENT);
        ItemMeta tridentMeta = trident.getItemMeta();
        tridentMeta.setDisplayName(StringUtils.translate("&aPoseidon's Trident"));
        tridentMeta.setUnbreakable(true);
        tridentMeta.addEnchant(Enchantment.LOYALTY, 3, true);
        trident.setItemMeta(tridentMeta);

        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta bowMeta = bow.getItemMeta();
        bowMeta.setDisplayName(StringUtils.translate("&aPoseidon's Bow"));
        bowMeta.setUnbreakable(true);
        bowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        bow.setItemMeta(bowMeta);

        ItemStack fireworks = new ItemStack(Material.FIREWORK_ROCKET, 64);

        ItemStack arrow = new ItemStack(Material.ARROW);

        ItemStack elytra = new ItemStack(Material.ELYTRA);
        ItemMeta elytraMeta = elytra.getItemMeta();
        elytraMeta.setUnbreakable(true);
        elytra.setItemMeta(elytraMeta);

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
        inv.setItem(30, trident);
        inv.setItem(31, bow);
        inv.setItem(49, leave);

        super.setPreviewKit(inv);
    }

}