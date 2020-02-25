package firewolf8385.elytrapvp.objects;

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