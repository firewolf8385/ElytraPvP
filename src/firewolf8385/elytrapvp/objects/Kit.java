package firewolf8385.elytrapvp.objects;

import firewolf8385.elytrapvp.utils.ItemUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public abstract class Kit
{
    private String name;
    private int number;
    private int price;
    private int slot;
    private Inventory previewKit;

    public static HashMap<Integer, Kit> list = new HashMap();

    /**
     * Create a new kit.
     * @param name Name of the kit.
     * @param number Number of the kit.
     * @param slot Slot in the Kit Selector.
     * @param price Price of the kit.
     */
    public Kit(String name, int number, int slot, int price)
    {
        this.name = name;
        this.number = number;
        this.slot = slot;
        this.price = price;

        list.put(number, this);
    }

    /**
     * Get the icon of the kit based off the player.
     * @param p Player
     * @return Icon
     */
    public abstract ItemStack getIcon(Player p);

    /**
     * Get the filler ItemStack.
     * @return Filler
     */
    public ItemStack getFiller()
    {
        return ItemUtils.createItem(Material.GRAY_STAINED_GLASS_PANE, " ");
    }

    /**
     * Get Preview GUI Fillers
     * @return
     */
    public int[] getFillers()
    {
        return new int[]{0, 1, 2,3,4,5,6,7,8,9,11,13,14,15,17,18,20,21,22,23,24,25,26,27,29,35,36,37,38,39,40,41,42,43,44,45,46,47,48,50,51,52,53};
    }

    /**
     * Get the leave itemstack
     * @return Itemstack.
     */
    public ItemStack getLeave()
    {
        return ItemUtils.createItem(Material.BARRIER, "&cBack");
    }

    /**
     * Get the name of a kit.
     * @return Name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Get the number of a kit.
     * @return
     */
    public int getNumber()
    {
        return number;
    }

    /**
     * Get the price of a kit.
     * @return Price
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Get the slot of a kit.
     * @return slot
     */
    public int getSlot()
    {
        return slot;
    }

    /**
     * Give a player the kit's items.
     * @param p Player.
     */
    public abstract void giveItems(Player p);

    /**
     * Preview a kit
     * @param p Player
     */
    public void preview(Player p)
    {
        p.openInventory(previewKit);
    }

    /**
     * Set the preview kit gui.
     * @param previewKit GUI.
     */
    public void setPreviewKit(Inventory previewKit)
    {
        this.previewKit = previewKit;
    }
}