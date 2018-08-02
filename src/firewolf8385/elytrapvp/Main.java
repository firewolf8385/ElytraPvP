package firewolf8385.elytrapvp;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

    SettingsManager settings = SettingsManager.getInstance();

    public void onEnable() {

        settings.setup(this);
    }

}