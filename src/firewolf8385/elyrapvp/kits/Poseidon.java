package firewolf8385.elytrapvp.kits;

import firewolf8385.elytrapvp.objects.ElytraPlayer;
import firewolf8385.elytrapvp.objects.Kit;
import firewolf8385.elytrapvp.utils.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Poseidon extends Kit
{
    private ItemStack arrow;
    private ItemStack bow;
    private ItemStack elytra;
    private ItemStack fireworks;
    private ItemStack trident;


    /**
     * Create a new Sniper Kit.
     */
    public Poseidon()
    {
        super("Poseidon", 12, 31, 400);

        // Items
        arrow = new ItemStack(Material.ARROW);
        bow = ItemUtils.createItem(Material.BOW, "&aPoseidon's Bow");
        bow = ItemUtils.addEnchantment(bow, Enchantment.ARROW_DAMAGE, 3, true);
        bow = ItemUtils.addEnchantment(bow, Enchantment.ARROW_INFINITE, 1, true);
        bow = ItemUtils.setUnbreakable(bow, true);
        elytra = ItemUtils.createItem(Material.ELYTRA, "&aElytra");
        elytra = ItemUtils.setUnbreakable(elytra, true);
        fireworks = new ItemStack(Material.FIREWORK_ROCKET, 64);
        trident = ItemUtils.createItem(Material.TRIDENT, "&aPoseidon's Trident");
        trident = ItemUtils.addEnchantment(trident, Enchantment.LOYALTY, 3, true);
        trident = ItemUtils.setUnbreakable(trident, true);

        super.setPreviewKit(preview());
    }

    /**
     * Get the icon of the kit.
     * @param p Player
     * @return
     */
    public ItemStack getIcon(Player p)
    {
        ElytraPlayer ep = new ElytraPlayer(p);

        if(!ep.getUnlockedKits().contains(getNumber() + ""))
        {
            return ItemUtils.createItem(Material.GRAY_DYE, "&cPoseidon", "&7Obliterate your enemies", "&7with a trident.", "", "&7Left Click to Purchase", "&7Right Click to Preview", "", "&6Price: " + getPrice());
        }

        return ItemUtils.createItem(Material.TRIDENT, "&aPoseidon", "&7Obliterate your enemies", "&7with a trident.", "", "&7Left Click to Select", "&7Right Click to Preview");
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
            p.getInventory().setItem(0, trident);
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
        preview.setItem(30, trident);
        preview.setItem(31, bow);
        preview.setItem(49, getLeave());

        return preview;
    }

}