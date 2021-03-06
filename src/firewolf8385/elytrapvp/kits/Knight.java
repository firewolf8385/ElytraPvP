package firewolf8385.elytrapvp.kits;

import firewolf8385.elytrapvp.objects.Kit;
import firewolf8385.elytrapvp.utils.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Knight extends Kit
{
    private ItemStack arrow;
    private ItemStack bow;
    private ItemStack elytra;
    private ItemStack fireworks;
    private ItemStack sword;

    /**
     * Create a new Sniper Kit.
     */
    public Knight()
    {
        super("Knight", 2, 12, 0);

        // Items
        arrow = new ItemStack(Material.ARROW);
        bow = ItemUtils.createItem(Material.BOW, "&aKnight Bow");
        bow = ItemUtils.addEnchantment(bow, Enchantment.ARROW_DAMAGE, 3, true);
        bow = ItemUtils.addEnchantment(bow, Enchantment.ARROW_INFINITE, 1, true);
        bow = ItemUtils.setUnbreakable(bow, true);
        elytra = ItemUtils.createItem(Material.ELYTRA, "&aElytra");
        elytra = ItemUtils.setUnbreakable(elytra, true);
        fireworks = new ItemStack(Material.FIREWORK_ROCKET, 64);
        sword = ItemUtils.createItem(Material.STONE_SWORD, "&aKnight Sword");
        sword = ItemUtils.setUnbreakable(sword, true);

        super.setPreviewKit(preview());
    }

    /**
     * Get the icon of the kit.
     * @param p Player
     * @return
     */
    public ItemStack getIcon(Player p)
    {
        return ItemUtils.createItem(Material.STONE_SWORD, "&aKnight", "&7Slash your way into battle with", "&7a stone sword.", "", "&7Left Click to Select", "&7Right Click to Preview");
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
            p.getInventory().setItem(0, sword);
            p.getInventory().setItem(1, bow);
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

        for(int i : getFillers())
        {
            preview.setItem(i, getFiller());
        }

        preview.setItem(10, elytra);
        preview.setItem(12, fireworks);
        preview.setItem(16, arrow);
        preview.setItem(30, sword);
        preview.setItem(31, bow);
        preview.setItem(49, getLeave());

        return preview;
    }

}