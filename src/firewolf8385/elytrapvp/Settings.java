package firewolf8385.elytrapvp;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class Settings
{
    Plugin p;
    static Settings instance = new Settings();
    private Settings() { }

    /**
     * Get the config file.
     * @return config
     */
    public FileConfiguration getConfig()
    {
        return p.getConfig();
    }

    /**
     * Get list of death blocks.
     * @return Death Blocks.
     */
    public List<String> getDeathBlocks()
    {
        return getConfig().getStringList("DeathBlocks");
    }

    /**
     * Retrieves the Instance of SettingsManager
     * @return Instance
     */
    public static Settings getInstance()
    {
        return instance;
    }

    /**
     * Get a message from the config.
     * @param msg Message to get.
     * @return The message.
     */
    public String getMessage(String msg)
    {
        return getConfig().getString("Messages." + msg);
    }

    /**
     * Get the spawn location.
     * @return
     */
    public Location getSpawn()
    {
        double x = getConfig().getDouble("Spawn.X");
        double y = getConfig().getDouble("Spawn.Y");
        double z = getConfig().getDouble("Spawn.Z");
        float pitch = (float) getConfig().getDouble("Spawn.Pitch");
        float yaw = (float) getConfig().getDouble("Spawn.Yaw");

        Location spawn = new Location(Bukkit.getWorld("world"), x, y, z, yaw, pitch);

        return spawn;
    }

    /**
     * Get the start level.
     * @return Start level.
     */
    public int getStartLevel()
    {
        return getConfig().getInt("StartLevel");
    }

    /**
     * Check if game is enabled.
     * @return Whether game is enabled.
     */
    public boolean isEnabled()
    {
        return getConfig().getBoolean("Enabled");
    }

    /**
     * Check if spawn is set.
     * @return Whether spawn is set.
     */
    public boolean isSpawnSet()
    {
        return getConfig().getBoolean("Spawn.Set");
    }

    /**
     * Set if the plugin is enabled.
     * @param enabled Whether the plugin is enabled.
     */
    public void setEnabled(boolean enabled)
    {
        getConfig().set("Enabled", enabled);
        reloadConfig();
    }

    /**
     * Set the location of /ep spawn
     * @param spawn Location of spawn.
     */
    public void setSpawn(Location spawn)
    {
        double x = spawn.getX();
        double y = spawn.getY();
        double z = spawn.getZ();
        float pitch = spawn.getPitch();
        float yaw = spawn.getYaw();

        getConfig().set("Spawn.X", x);
        getConfig().set("Spawn.Y", y);
        getConfig().set("Spawn.Z", z);
        getConfig().set("Spawn.Pitch", pitch);
        getConfig().set("Spawn.Yaw", yaw);
        getConfig().set("Spawn.Set", true);

        reloadConfig();
    }

    /**
     * Set the start level.
     * @param startLevel Start level.
     */
    public void setStartLevel(int startLevel)
    {
        getConfig().set("StartLevel", startLevel);
        reloadConfig();
    }

    /**
     * Creates the files if they do not exist.
     * @param p plugin
     */
    public void setup(Plugin p)
    {
        this.p = p;

        // Create the Plugin Folder if it does not exist.
        if (!p.getDataFolder().exists())
        {
            p.getDataFolder().mkdir();
        }

        p.getConfig().options().copyDefaults(true);
        p.saveDefaultConfig();
    }

    /**
     * Save the config file.
     */
    public void saveConfig()
    {
        p.saveConfig();
    }

    /**
     * Reload the config file.
     */
    public void reloadConfig()
    {
        p.saveConfig();
        p.getConfig();
    }
}