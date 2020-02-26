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

    /**
     * Create a new Sniper Kit.
     */
    public Chemist()
    {
        super("Chemist", 5, 15, 400);
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

        if(!ep.getUnlockedKits().contains(5 + ""))
        {
            return ItemUtils.createItem(Material.GRAY_DYE, "&cChemist", "&7Force your opponents into submission", "&7with a splash potion.", "", "&7Left Click to Select", "&7Right Click to Preview");
        }

        return ItemUtils.createItem(Material.POTION, "&aChemist", "&7Force your opponents into submission", "&7with a splash potion.", "", "&7Left Click to Select", "&7Right Click to Preview");
    }

    /**
     * Give the player the kit's items.
     * @param p Player.
     */
    public void giveItems(Player p)
    {
        ItemStack bow = ItemUtils.createItem(Material.BOW, "&aChemist Bow");
        bow = ItemUtils.addEnchantment(bow, Enchantment.ARROW_DAMAGE, 3, true);
        bow = ItemUtils.addEnchantment(bow, Enchantment.ARROW_INFINITE, 1, true);
        bow = ItemUtils.setUnbreakable(bow, true);

        ItemStack fireworks = new ItemStack(Material.FIREWORK_ROCKET, 64);
        ItemStack arrow = new ItemStack(Material.ARROW);

        ItemStack elytra = ItemUtils.createItem(Material.ELYTRA, "&aElytra");
        elytra = ItemUtils.setUnbreakable(elytra, true);

        ItemStack potion = new ItemStack(Material.SPLASH_POTION, 111);
        PotionMeta potionMeta = (PotionMeta) potion.getItemMeta();
        potionMeta.setDisplayName(StringUtils.translate("&aChemist Potions"));
        potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.HARM, 1, 0), true);
        potion.setItemMeta(potionMeta);

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

        ItemStack bow = ItemUtils.createItem(Material.BOW, "&aChemist Bow");
        bow = ItemUtils.addEnchantment(bow, Enchantment.ARROW_DAMAGE, 3, true);
        bow = ItemUtils.addEnchantment(bow, Enchantment.ARROW_INFINITE, 1, true);
        bow = ItemUtils.setUnbreakable(bow, true);

        ItemStack fireworks = new ItemStack(Material.FIREWORK_ROCKET, 64);
        ItemStack arrow = new ItemStack(Material.ARROW);

        ItemStack elytra = ItemUtils.createItem(Material.ELYTRA, "&aElytra");
        elytra = ItemUtils.setUnbreakable(elytra, true);

        ItemStack potion = new ItemStack(Material.SPLASH_POTION, 111);
        PotionMeta potionMeta = (PotionMeta) potion.getItemMeta();
        potionMeta.setDisplayName(StringUtils.translate("&aChemist Potions"));
        potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.HARM, 1, 0), true);
        potion.setItemMeta(potionMeta);

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
        preview.setItem(31, potion);
        preview.setItem(49, leave);

        return preview;
    }

}