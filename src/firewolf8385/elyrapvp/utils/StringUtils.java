package firewolf8385.elytrapvp.utils;

import org.bukkit.ChatColor;

public class StringUtils
{

    /**
     * Translate plain text into colored text.
     * @param message Plain text
     * @return Colored Text
     */
    public static String translate(String message)
    {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    /**
     * Translate an array of strings.
     * @param arr Strings
     * @return array of translated strings.
     */
    public static String[] translate(String[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = translate(arr[i]);
        }

        return arr;
    }

}
