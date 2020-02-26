package firewolf8385.elytrapvp.kits;

import firewolf8385.elytrapvp.objects.Kit;
import firewolf8385.elytrapvp.utils.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Sniper extends Kit
{
    private ItemStack arrow;
    private ItemStack bow;
    private ItemStack elytra;
    private ItemStack fireworks;

    /**
     * Create a new Sniper Kit.
     */
    public Sniper()
    {
        super("Sniper", 1, 11, 0);

        // Items
        arrow = new ItemStack(Material.ARROW);
        bow = ItemUtils.createItem(Material.BOW, "&aSniper Bow");
        bow = ItemUtils.addEnchantment(bow, Enchantment.ARROW_DAMAGE, 5, true);
        bow = ItemUtils.addEnchantment(bow, Enchantment.ARROW_INFINITE, 1, true);
        bow = ItemUtils.setUnbreakable(bow, true);
        elytra = ItemUtils.createItem(Material.ELYTRA, "&aElytra");
        elytra = ItemUtils.setUnbreakable(elytra, true);
        fireworks = new ItemStack(Material.FIREWORK_ROCKET, 64);

        super.setPreviewKit(preview());
    }

    /**
     * Get the icon of the kit.
     * @param p Player
     * @return
     */
    public ItemStack getIcon(Player p)
    {
        return ItemUtils.createItem(Material.BOW, "&aSniper", "&7A strong bow to snipe", "&7your opponents.", "", "&7Left Click to Select", "&7Right Click to Preview");
    }

    /**
     * Give the player the kit's items.
     * @param p Player.
     */
    public void giveItems(Player p)
    {

        if(!p.getInventory().contains(bow))
        {
            p.getInventory().clear();
            p.getInventory().setItem(0, bow);
            p.getInventory().setItemInOffHand(fireworks);
            p.getInventory().setChestplate(elytra);
            p.getInventory().setItem(17, arrow);
            p.setMaxHealth(12);
            p.setHealth(12);
        }
    }

    /**
     * Get the kit preview gui.
     * @return Preview GUI
     */
    private Inventory preview()
    {
        Inventory preview = Bukkit.createInventory(null, 54, "Preview");

        for(int i : getFillers())
        {
            preview.setItem(i, getFiller());
        }

        preview.setItem(10, elytra);
        preview.setItem(12, fireworks);
        preview.setItem(16, arrow);
        preview.setItem(30, bow);
        preview.setItem(49, getLeave());

        return preview;
    }

}