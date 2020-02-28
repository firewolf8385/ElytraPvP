package firewolf8385.elytrapvp.objects;

import firewolf8385.elytrapvp.MySQL;
import firewolf8385.elytrapvp.enums.Status;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ElytraPlayer
{
    private UUID uuid;
    private int bounty;
    private int coins;
    private int kills;
    private int killStreak;
    private int kit;
    private int deaths;

    public static HashMap<UUID, ElytraPlayer> players = new HashMap<>();

    /**
     * Create an ElytraPlayer
     * @param p Player
     */
    public ElytraPlayer(Player p)
    {
        this.uuid = p.getUniqueId();

        getMySQL();
    }

    /**
     * Create an ElytraPlayer
     * @param uuid UUID of Player
     */
    public ElytraPlayer(UUID uuid)
    {
        this.uuid = uuid;

        getMySQL();
    }

    /**
     * Add to the player's bounty.
     * @param bounty Amount to be added.
     */
    public void addBounty(int bounty)
    {
        setBounty(getBounty() + bounty);
    }

    /**
     * Add coins to a player.
     * @param coins Coins to be added.
     */
    public void addCoins(int coins)
    {
        setCoins(getCoins() + coins);
    }

    /**
     * Add deaths to a player.
     * @param deaths Deaths to be added.
     */
    public void addDeaths(int deaths)
    {
        setDeaths(getDeaths() + deaths);
    }

    /**
     * Add kills to a player.
     * @param kills Kills to be added.
     */
    public void addKills(int kills)
    {
        setKills(getKills() + kills);
    }

    /**
     * Add to a player's kill streak.
     * @param killStreak kills to add to the streaks.
     */
    public void addKillStreak(int killStreak)
    {
        setKillStreak(getKillStreak() + killStreak);
    }

    /**
     * Add a player to the database.
     */
    public void createPlayer()
    {
        // Exit if player exists.
        if (hasJoined())
        {
            return;
        }

        MySQL.openConnection();
        try
        {
            PreparedStatement statement = MySQL.getConnection().prepareStatement("INSERT INTO ep_users (uuid) VALUES (?)");
            statement.setString(1, uuid.toString());

            statement.executeUpdate();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        MySQL.closeConnection();
    }

    /**
     * Get the player's current bounty.
     * @return Current bounty.
     */
    public int getBounty()
    {
        return bounty;
    }

    /**
     * Get the player's coin amount.
     * @return Coin amount.
     */
    public int getCoins()
    {
        return coins;
    }

    /**
     * Get the player's death count.
     * @return Death count.
     */
    public int getDeaths()
    {
        return deaths;
    }

    /**
     * Get the player's kill count.
     * @return Kill count.
     */
    public int getKills()
    {
        return kills;
    }

    /**
     * Get the players current kill streak.
     * @return Kill streak.
     */
    public int getKillStreak()
    {
        return killStreak;
    }

    /**
     * Get the player's current kit.
     * @return Current kit.
     */
    public int getKit()
    {
        return kit;
    }

    /**
     * Update the cached MySQL data.
     */
    public void getMySQL()
    {
        MySQL.openConnection();
        try
        {
            PreparedStatement statement = MySQL.getConnection().prepareStatement("SELECT * from ep_users WHERE uuid = ?");
            statement.setString(1, uuid.toString());
            ResultSet results = statement.executeQuery();
            results.next();

            coins = results.getInt(2);
            bounty = results.getInt(3);
            kills = results.getInt(4);
            deaths = results.getInt(5);
            killStreak = results.getInt(6);
            kit = results.getInt(8);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        MySQL.closeConnection();
    }

    /**
     * Get the player's status.
     * @return Player's status.
     */
    public Status getStatus()
    {
        return Status.list.get(uuid);
    }

    /**
     * Get a String array from unlocked kits.
     * @return Unlocked kits.
     */
    public List<String> getUnlockedKits()
    {
        String unlockedKits = "";

        MySQL.openConnection();
        try
        {
            PreparedStatement statement = MySQL.getConnection().prepareStatement("SELECT * from ep_users WHERE uuid = ?");
            statement.setString(1, uuid.toString());
            ResultSet results = statement.executeQuery();
            results.next();

            unlockedKits += results.getString(9);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        MySQL.closeConnection();

        return Arrays.asList(unlockedKits.split(","));
    }

    /**
     * Check if player has joined before.
     * @return Whether they have joined before.
     */
    public boolean hasJoined()
    {
        MySQL.openConnection();
        try
        {
            PreparedStatement statement = MySQL.getConnection().prepareStatement("SELECT * from ep_users WHERE uuid = ?");
            statement.setString(1,uuid.toString());
            ResultSet results = statement.executeQuery();

            return results.next();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        MySQL.closeConnection();
        return false;
    }

    /**
     * Remove coins from a player.
     * @param coins Coins to be removed.
     */
    public void removeCoins(int coins)
    {
        setCoins(getCoins() - coins);
    }

    /**
     * Set the player's bounty.
     * @param bounty Bounty.
     */
    public void setBounty(int bounty)
    {
        MySQL.openConnection();
        try
        {
            PreparedStatement statement = MySQL.getConnection().prepareStatement("UPDATE ep_users SET bounty=? WHERE uuid = ?");
            statement.setInt(1, bounty);
            statement.setString(2, uuid.toString());
            statement.executeUpdate();

            this.bounty = bounty;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        MySQL.closeConnection();
    }

    /**
     * Set the player's coin count.
     * @param coins Coins.
     */
    public void setCoins(int coins)
    {
        MySQL.openConnection();
        try
        {
            PreparedStatement statement = MySQL.getConnection().prepareStatement("UPDATE ep_users SET coins=? WHERE uuid = ?");
            statement.setInt(1, coins);
            statement.setString(2, uuid.toString());
            statement.executeUpdate();

            this.coins = coins;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        MySQL.closeConnection();
    }

    /**
     * Set the player's death count.
     * @param deaths Deaths.
     */
    public void setDeaths(int deaths)
    {
        MySQL.openConnection();
        try
        {
            PreparedStatement statement = MySQL.getConnection().prepareStatement("UPDATE ep_users SET deaths=? WHERE uuid = ?");
            statement.setInt(1, deaths);
            statement.setString(2, uuid.toString());
            statement.executeUpdate();

            this.deaths = deaths;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        MySQL.closeConnection();
    }

    /**
     * Set a player's kill count.
     * @param kills Kills.
     */
    public void setKills(int kills)
    {
        MySQL.openConnection();
        try
        {
            PreparedStatement statement = MySQL.getConnection().prepareStatement("UPDATE ep_users SET kills=? WHERE uuid = ?");
            statement.setInt(1, kills);
            statement.setString(2, uuid.toString());
            statement.executeUpdate();

            this.kills = kills;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        MySQL.closeConnection();
    }

    /**
     * Set the player's kill streak.
     * @param killStreak Kill Streak.
     */
    public void setKillStreak(int killStreak)
    {
        MySQL.openConnection();
        try
        {
            PreparedStatement statement = MySQL.getConnection().prepareStatement("UPDATE ep_users SET killstreak=? WHERE uuid = ?");
            statement.setInt(1, killStreak);
            statement.setString(2, uuid.toString());
            statement.executeUpdate();

            this.killStreak = killStreak;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        MySQL.closeConnection();
    }

    /**
     * Set a player's kit.
     * @param kit Kit.
     */
    public void setKit(int kit)
    {
        MySQL.openConnection();
        try
        {
            PreparedStatement statement = MySQL.getConnection().prepareStatement("UPDATE ep_users SET selectedKit=? WHERE uuid = ?");
            statement.setInt(1, kit);
            statement.setString(2, uuid.toString());
            statement.executeUpdate();

            this.kit = kit;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        MySQL.closeConnection();
    }

    /**
     * Set the player's status.
     * @param status Status.
     */
    public void setStatus(Status status)
    {
        Status.list.put(uuid, status);
    }

    /**
     * Unlock a kit
     * @param kit Kit to unlock.
     */
    public void unlockKit(int kit)
    {
        String unlockedKits = "";

        MySQL.openConnection();

        try
        {
            PreparedStatement statement = MySQL.getConnection().prepareStatement("SELECT * from ep_users WHERE uuid = ?");
            statement.setString(1, uuid.toString());
            ResultSet results = statement.executeQuery();
            results.next();

            unlockedKits += results.getString(9);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        if(unlockedKits.length() != 0)
        {
            unlockedKits += "," + kit;
        }
        else
        {
            unlockedKits += kit;
        }

        try
        {
            PreparedStatement statement = MySQL.getConnection().prepareStatement("UPDATE ep_users SET unlockedKits=? WHERE uuid = ?");
            statement.setString(1, unlockedKits);
            statement.setString(2, uuid.toString());
            statement.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        MySQL.closeConnection();
    }
}
