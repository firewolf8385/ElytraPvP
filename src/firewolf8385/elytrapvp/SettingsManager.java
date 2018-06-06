package firewolf8385.elytrapvp;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class SettingsManager {

    private SettingsManager() { }

    static SettingsManager instance = new SettingsManager();

    public static SettingsManager getInstance() {
        return instance;
    }

    Plugin p;

    // Creates the PlayerData file if it does not exist
    public void setup(Plugin p) {

        if (!p.getDataFolder().exists()) {
            p.getDataFolder().mkdir();
        }

        this.p = p;
        p.getConfig().options().copyDefaults(true);
        p.saveDefaultConfig();

    }


    public FileConfiguration getConfig() {
        return p.getConfig(); // Allows us to get data from config.yml
    }

    public void saveConfig() { // Attempts to save config.yml
        p.saveConfig();
    }

    public void reloadConfig() {
        p.saveConfig();
        p.getConfig();
    }

}
