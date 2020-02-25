package firewolf8385.elytrapvp;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/* **************************************************************************************
 *    Title: ElytraPvP
 *    Author: firewolf8385
 *    Date: February 25rd, 2020
 *    Code version: 1.0
 ***************************************************************************************/

public class ElytraPvP extends JavaPlugin
{
    private static Plugin pl;
    private Settings settings = Settings.getInstance();

    /**
     * Get instance of the plugin.
     * @return Plugin
     */
    public static Plugin getPlugin()
    {
        return pl;
    }

    /**
     * Runs neccessary tasks when the plugin is enabled.
     */
    @Override
    public void onEnable()
    {
        pl = this;

        // Create config if it doesn't exist.
        settings.setup(this);

        // Connect to mysql database.
        MySQL.openConnection();
        MySQL.createTables();

        // Enable different aspects of the plugin.
        registerCommands();
        registerEvents();
    }

    /**
     * Runs neccessary tasks when the plugin is disabled.
     */
    @Override
    public void onDisable()
    {
        pl = null;
    }

    /**
     * Register commands used by the plugin.
     */
    public void registerCommands()
    {

    }

    /**
     * Register events used by the plugin.
     */
    public void registerEvents()
    {

    }

}
