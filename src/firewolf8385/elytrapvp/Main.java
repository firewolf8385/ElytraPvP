package firewolf8385.elytrapvp;

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
    }

}