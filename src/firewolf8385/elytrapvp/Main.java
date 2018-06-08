package firewolf8385.elytrapvp;

import firewolf8385.elytrapvp.commands.ElytraPvP;
import firewolf8385.elytrapvp.commands.Stats;
import firewolf8385.elytrapvp.events.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

    SettingsManager settings = SettingsManager.getInstance();

    public void onEnable() {
        settings.setup(this);

        // Checks if PlaceholderAPI is installed
        if(Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            Bukkit.getLogger().info("[ElytraPVP] PlaceholderAPI detected! Enabling placeholders...");
            new Placeholders(this).hook();
        }
        else {
            Bukkit.getLogger().warning("[ElytraPvP] PlaceholderAPI not found. Placeholders will not work without this!");
        }


        getCommand("stats").setExecutor(new Stats());
        getCommand("elytrapvp").setExecutor(new ElytraPvP());

        getServer().getPluginManager().registerEvents(new EntityDamage(), this);
        getServer().getPluginManager().registerEvents(new FoodLevelChange(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteract(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerRespawn(), this);


    }

}