package firewolf8385.elytrapvp;

import firewolf8385.elytrapvp.commands.EP;
import firewolf8385.elytrapvp.commands.Kits;
import firewolf8385.elytrapvp.commands.Stats;
import firewolf8385.elytrapvp.kits.*;
import firewolf8385.elytrapvp.listeners.*;
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
        registerKits();
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
    private void registerCommands()
    {
        getCommand("elytrapvp").setExecutor(new EP());
        getCommand("kits").setExecutor(new Kits());
        getCommand("stats").setExecutor(new Stats());
    }

    /**
     * Register events used by the plugin.
     */
    private void registerEvents()
    {
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerMove(), this);
        getServer().getPluginManager().registerEvents(new PlayerRespawn(), this);
        getServer().getPluginManager().registerEvents(new PlayerTouchGround(), this);
        getServer().getPluginManager().registerEvents(new PlayerDrown(), this);
        getServer().getPluginManager().registerEvents(new PlayerEscape(), this);
        getServer().getPluginManager().registerEvents(new FoodLevelChange(), this);
        getServer().getPluginManager().registerEvents(new PlayerDropItem(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuit(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteract(), this);
        getServer().getPluginManager().registerEvents(new InventoryClick(), this);
    }

    /**
     * Register pvp kits.
     */
    private void registerKits()
    {
        new Sniper();
        new Knight();
        new Pyro();
        new Tank();
        new Chemist();
        new Stickman();
        new Bomber();
        new Healer();
        new Teleporter();
        new Spectral();
        new Puncher();
        new Cactus();
        new Poseidon();
    }

}
