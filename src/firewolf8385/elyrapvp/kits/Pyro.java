package firewolf8385.elytrapvp.kits;

import firewolf8385.elytrapvp.objects.Kit;
import firewolf8385.elytrapvp.utils.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Pyro extends Kit
{

    /**
     * Create a new Sniper Kit.
     */
    public Pyro()
    {
        super("Pyro", 3, 13, 0);
        super.setPreviewKit(preview());
    }

    /**
     * Get the icon of the kit.
     * @param p Player
     * @return
     */
    public ItemStack getIcon(Player p)
    {
        return ItemUtils.createItem(Material.FLINT_AND_STEEL, "&aPyro", "&7Light up the knight, or", "&7your eneimies.", "", "&7Left Click to Select", "&7Right Click to Preview");
    }

    /**
     * Give the player the kit's items.
     * @param p Player.
     */
    public void giveItems(Player p)
    {
        ItemStack bow = ItemUtils.createItem(Material.BOW, "&aPyro Bow");
        bow = ItemUtils.addEnchantment(bow, Enchantment.ARROW_DAMAGE, 2, true);
        bow = ItemUtils.addEnchantment(bow, Enchantment.ARROW_INFINITE, 1, true);
        bow = ItemUtils.addEnchantment(bow, Enchantment.ARROW_FIRE, 1, true);
        bow = ItemUtils.setUnbreakable(bow, true);

        ItemStack fireworks = new ItemStack(Material.FIREWORK_ROCKET, 64);
        ItemStack arrow = new ItemStack(Material.ARROW);

        ItemStack elytra = ItemUtils.createItem(Material.ELYTRA, "&aElytra");
        elytra = ItemUtils.setUnbreakable(elytra, true);

        if(!p.getInventory().contains(bow))
        {
            p.getInventory().clear();
            p.getInventory().setItem(0, bow);
            p.getInventory().setItemInOffHand(fireworks);
            p.getInventory().setChestplate(elytra);
            p.getInventory().setItem(17, arrow);
        }
    }

    /**
     * Get the kit preview gui.
     * @return Preview GUI
     */
    private Inventory preview()
    {
        Inventory preview = Bukkit.createInventory(null, 54, "Preview");

        ItemStack bow = ItemUtils.createItem(Material.BOW, "&aPyro Bow");
        bow = ItemUtils.addEnchantment(bow, Enchantment.ARROW_DAMAGE, 2, true);
        bow = ItemUtils.addEnchantment(bow, Enchantment.ARROW_INFINITE, 1, true);
        bow = ItemUtils.addEnchantment(bow, Enchantment.ARROW_FIRE, 1, true);
        bow = ItemUtils.setUnbreakable(bow, true);

        ItemStack fireworks = new ItemStack(Material.FIREWORK_ROCKET, 64);
        ItemStack arrow = new ItemStack(Material.ARROW);

        ItemStack elytra = ItemUtils.createItem(Material.ELYTRA, "&aElytra");
        elytra = ItemUtils.setUnbreakable(elytra, true);

        ItemStack leave = ItemUtils.createItem(Material.BARRIER, "&cBack");
        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);

        int[] fillers = new int[]{0, 1, 2,3,4,5,6,7,8,9,11,13,14,15,17,18,20,21,22,23,24,25,26,27,29,35,36,37,38,39,40,41,42,43,44,45,46,47,48,50,51,52,53};

        for(int i : fillers)
        {
            preview.setItem(i, filler);
        }

        preview.setItem(10, elytra);
        preview.setItem(12, fireworks);
        preview.setItem(16, arrow);
        preview.setItem(30, bow);
        preview.setItem(49, leave);

        return preview;
    }

}