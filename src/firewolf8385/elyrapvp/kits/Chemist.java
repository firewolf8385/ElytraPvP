package firewolf8385.elytrapvp.kits;

import firewolf8385.elytrapvp.objects.ElytraPlayer;
import firewolf8385.elytrapvp.objects.Kit;
import firewolf8385.elytrapvp.utils.ItemUtils;
import firewolf8385.elytrapvp.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Chemist extends Kit
{
    private ItemStack arrow;
    private ItemStack bow;
    private ItemStack elytra;
    private ItemStack fireworks;
    private ItemStack potion;


    /**
     * Create a new Sniper Kit.
     */
    public Chemist()
    {
        super("Chemist", 5, 15, 400);

        // Items
        arrow = new ItemStack(Material.ARROW);
        bow = ItemUtils.createItem(Material.BOW, "&aChemist Bow");
        bow = ItemUtils.addEnchantment(bow, Enchantment.ARROW_DAMAGE, 3, true);
        bow = ItemUtils.addEnchantment(bow, Enchantment.ARROW_INFINITE, 1, true);
        bow = ItemUtils.setUnbreakable(bow, true);
        elytra = ItemUtils.createItem(Material.ELYTRA, "&aElytra");
        elytra = ItemUtils.setUnbreakable(elytra, true);
        fireworks = new ItemStack(Material.FIREWORK_ROCKET, 64);
        potion = new ItemStack(Material.SPLASH_POTION, 111);
        PotionMeta potionMeta = (PotionMeta) potion.getItemMeta();
        potionMeta.setDisplayName(StringUtils.translate("&aChemist Potions"));
        potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.HARM, 1, 0), true);
        potion.setItemMeta(potionMeta);

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
            return ItemUtils.createItem(Material.GRAY_DYE, "&cChemist", "&7Force your opponents into submission", "&7with a splash potion.", "", "&7Left Click to Purchase", "&7Right Click to Preview", "", "&6Price: " + getPrice());
        }

        return ItemUtils.createItem(Material.POTION, "&aChemist", "&7Force your opponents into submission", "&7with a splash potion.", "", "&7Left Click to Select", "&7Right Click to Preview");
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
            p.getInventory().setItem(1, potion);
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
        preview.setItem(30, bow);
        preview.setItem(31, potion);
        preview.setItem(49, getLeave());

        return preview;
    }

}