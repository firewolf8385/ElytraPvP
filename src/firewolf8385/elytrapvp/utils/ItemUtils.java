package firewolf8385.elytrapvp.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemUtils
{

    /**
     * Add an enchantment to an item.
     * @param i Item
     * @param e Enchantment
     * @param l Level
     * @param b Honestly, I don't really know what this is.
     * @return
     */
    public static ItemStack addEnchantment(ItemStack i, Enchantment e, int l, boolean b)
    {
        ItemMeta meta = i.getItemMeta();
        meta.addEnchant(e, l, b);
        i.setItemMeta(meta);

        return i;
    }

    /**
     * Create item.
     * @param m Material
     * @param name Name of item
     * @return Item
     */
    public static ItemStack createItem(Material m, String name)
    {
        ItemStack item = new ItemStack(m);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(StringUtils.translate(name));
        item.setItemMeta(meta);

        return item;
    }

    /**
     *
     * @param m Material
     * @param name Name of item.
     * @param lore Lore of the item.
     * @return
     */
    public static ItemStack createItem(Material m, String name, String...lore)
    {
        ItemStack item = new ItemStack(m);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(StringUtils.translate(name));
        meta.setLore(Arrays.asList(StringUtils.translate(lore)));
        item.setItemMeta(meta);

        return item;
    }

    /**
     * Set an item as unbreakable
     * @param i Item
     * @param b Unbreakable
     * @return
     */
    public static ItemStack setUnbreakable(ItemStack i, boolean b)
    {
        ItemMeta meta = i.getItemMeta();
        meta.setUnbreakable(b);
        i.setItemMeta(meta);

        return i;
    }

}
