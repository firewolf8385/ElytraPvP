package firewolf8385.elytrapvp;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class PlayerData {

    UUID u;
    File pData;
    FileConfiguration pDataConfig;

    public PlayerData(UUID u) {
        this.u = u;

        pData = new File("plugins/ElytraPvP/PlayerData/" + u + ".yml");
        pDataConfig = YamlConfiguration.loadConfiguration(pData);
    }

    public void createPlayerConfig() {
        if(!(pData.exists())) {
            try {
                pData.createNewFile();
            }
            catch (IOException e) {
                Bukkit.getServer().getLogger().severe(ChatColor.RED + "[ElytraPvP] Could not create '" + u.toString() + ".yml'!");
            }
        }
    }

    public void createPlayerDefaults() {
        if(pData.length() <= 0) {
            pDataConfig.set("Name", null);
            pDataConfig.set("Coins", 0);
            pDataConfig.set("Kit", 0);
            pDataConfig.set("Cosmetic", 0);

            pDataConfig.createSection("Stats");
            pDataConfig.set("Stats.Kills", 0);
            pDataConfig.set("Stats.Deaths", 0);
            pDataConfig.set("Stats.Killstreak", 0);
            // By tracking # of times a player logs in,
            // we can easily see whether or not the file
            // is working properly.
            pDataConfig.set("Stats.Logins", 0);

            pDataConfig.createSection("Cosmetics");
            pDataConfig.set("Cosmetics.1", false);

            pDataConfig.createSection("Achievements");
        }
    }

    public FileConfiguration getPlayerConfig() {
        return pDataConfig;
    }

    public void savePlayerConfig() {
        try {
            getPlayerConfig().save(pData);
        }
        catch (IOException e) {
            Bukkit.getServer().getLogger().severe(ChatColor.RED + "[ElytraPvP] Could not save '" + u.toString() + ".yml'!");
        }
    }

// Retrieving Information From The Files

    public int getKit() {
        return pDataConfig.getInt("Kit");
    }

    public int getCoins() {
        return pDataConfig.getInt("Coins");
    }

    public int getKills() {
        return pDataConfig.getInt("Stats.Kills");
    }

    public int getDeaths() {
        return pDataConfig.getInt("Stats.Deaths");
    }

    public int getKillstreak() {
        return pDataConfig.getInt("Stats.Killstreak");
    }

    public int getLogins() {
        return pDataConfig.getInt("Stats.Logins");
    }

    public boolean getAchievement(String type, String number) {
        return pDataConfig.getBoolean("Achievements." + type + "." + number);
    }
    public boolean hasCosmetic(String number){
        return pDataConfig.getBoolean("Cosmetics." + number);
    }

// Adding Information To The Files

    public void addCoins(int number) {
        pDataConfig.set("Coins", getCoins() + number);
    }

    public void addKills(int number) {
        pDataConfig.set("Stats.Kills", getKills() + number);
    }

    public void addDeaths(int number) {
        pDataConfig.set("Stats.Deaths", getDeaths() + number);
    }

    public void addKillstreak(int number) {
        pDataConfig.set("Stats.Killstreak", getKillstreak() + number);
    }

    public void addLogins(int number) {
        pDataConfig.set("Stats.Logins", getLogins() + number);
    }

// Removing Information From The Files

    public void removeCoins(int number) {
        pDataConfig.set("Coins", getCoins() - number);
    }

    public void removeKills(int number) {
        pDataConfig.set("Stats.Kills", getKills() - number);
    }

    public void removeDeaths(int number) {
        pDataConfig.set("Stats.Deaths", getDeaths() - number);
    }

    public void removeKillstreak(int number) {
        pDataConfig.set("Stats.Killstreak", getKillstreak() - number);
    }

    public void removeLogins(int number) {
        pDataConfig.set("Stats.Logins", number);
    }

// Setting Information In The Files

    public void setKit(int number) {
        pDataConfig.set("Kit", number);
    }

    public void setCoins(int number) {
        pDataConfig.set("Coins", number);
    }

    public void setKills(int number) {
        pDataConfig.set("Stats.Kills", number);
    }

    public void setDeaths(int number) {
        pDataConfig.set("Stats.Deaths", number);
    }

    public void setKillstreak(int number) {
        pDataConfig.set("Stats.Killstreak", number);
    }

    public void setLogins(int number) {
        pDataConfig.set("Stats.Logins", number);
    }

    public void setAchievements(String type, String number, Boolean state) {
        pDataConfig.set("Achievements." + type + "." + number, state);
    }
    public void setHasCosmetic(String number, Boolean state){
        pDataConfig.set("Cosmetics." + number, state);
    }

    public void setCosmetic(Integer number){
        pDataConfig.set("Cosmetic", number);
    }

}