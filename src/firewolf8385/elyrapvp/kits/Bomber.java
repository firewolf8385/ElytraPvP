package firewolf8385.elytrapvp.kits;

import firewolf8385.elytrapvp.objects.ElytraPlayer;
import firewolf8385.elytrapvp.objects.Kit;
import firewolf8385.elytrapvp.utils.ItemUtils;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

public class Bomber extends Kit
{
    private ItemStack arrow;
    private ItemStack bow;
    private ItemStack elytra;
    private ItemStack fireworks;
    private ItemStack Firework2;


    /**
     * Create a new Sniper Kit.
     */
    public Bomber()
    {
        super("Bomber", 7, 21, 400);

        // Items
        arrow = new ItemStack(Material.ARROW);
        bow = ItemUtils.createItem(Material.BOW, "&aBomber Bow");
        bow = ItemUtils.addEnchantment(bow, Enchantment.ARROW_DAMAGE, 3, true);
        bow = ItemUtils.addEnchantment(bow, Enchantment.ARROW_INFINITE, 1, true);
        bow = ItemUtils.setUnbreakable(bow, true);
        elytra = ItemUtils.createItem(Material.ELYTRA, "&aElytra");
        elytra = ItemUtils.setUnbreakable(elytra, true);
        fireworks = new ItemStack(Material.FIREWORK_ROCKET, 64);
        Firework2 = new ItemStack(Material.FIREWORK_ROCKET, 64);
        FireworkMeta Firework2Meta = (FireworkMeta) Firework2.getItemMeta();
        Firework2Meta.setDisplayName(ChatColor.GREEN + "Explosive Fireworks");
        Firework2Meta
                .addEffects(FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL_LARGE).build());
        Firework2.setItemMeta(Firework2Meta);

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
            return ItemUtils.createItem(Material.GRAY_DYE, "&cBomber", "&7Blow the competition away", "&7with explosive fireworks.", "", "&7Left Click to Purchase", "&7Right Click to Preview", "", "&6Price: " + getPrice());
        }

        return ItemUtils.createItem(Material.TNT, "&aBomber", "&7Blow the competition away", "&7with explosive fireworks.", "", "&7Left Click to Select", "&7Right Click to Preview");
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
            p.getInventory().setItem(1, bow);
            p.getInventory().setItem(3, Firework2);
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
        preview.setItem(31, bow);
        preview.setItem(33, Firework2);
        preview.setItem(49, getLeave());

        return preview;
    }

}