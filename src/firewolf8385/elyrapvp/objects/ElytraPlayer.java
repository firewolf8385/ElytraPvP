package firewolf8385.elytrapvp.objects;

import firewolf8385.elytrapvp.MySQL;
import firewolf8385.elytrapvp.enums.Status;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ElytraPlayer
{
    private UUID uuid;

    /**
     * Create an ElytraPlayer
     * @param p Player
     */
    public ElytraPlayer(Player p)
    {
        this.uuid = p.getUniqueId();
    }

    /**
     * Create an ElytraPlayer
     * @param uuid UUID of Player
     */
    public ElytraPlayer(UUID uuid)
    {
        this.uuid = uuid;
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
    }

    /**
     * Get the player's current bounty.
     * @return Current bounty.
     */
    public int getBounty()
    {
        int i = 0;

        try
        {
            PreparedStatement statement = MySQL.getConnection().prepareStatement("SELECT * from ep_users WHERE uuid = ?");
            statement.setString(1, uuid.toString());
            ResultSet results = statement.executeQuery();
            results.next();

            i = results.getInt(3);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return  i;
    }

    /**
     * Get the player's coin amount.
     * @return Coin amount.
     */
    public int getCoins()
    {
        int i = 0;

        try
        {
            PreparedStatement statement = MySQL.getConnection().prepareStatement("SELECT * from ep_users WHERE uuid = ?");
            statement.setString(1, uuid.toString());
            ResultSet results = statement.executeQuery();
            results.next();

            i = results.getInt(2);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return  i;
    }

    /**
     * Get the player's death count.
     * @return Death count.
     */
    public int getDeaths()
    {
        int i = 0;

        try
        {
            PreparedStatement statement = MySQL.getConnection().prepareStatement("SELECT * from ep_users WHERE uuid = ?");
            statement.setString(1, uuid.toString());
            ResultSet results = statement.executeQuery();
            results.next();

            i = results.getInt(5);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return  i;
    }

    /**
     * Get the player's kill count.
     * @return Kill count.
     */
    public int getKills()
    {
        int i = 0;

        try
        {
            PreparedStatement statement = MySQL.getConnection().prepareStatement("SELECT * from ep_users WHERE uuid = ?");
            statement.setString(1, uuid.toString());
            ResultSet results = statement.executeQuery();
            results.next();

            i = results.getInt(4);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return  i;
    }

    /**
     * Get the players current kill streak.
     * @return Kill streak.
     */
    public int getKillStreak()
    {
        int i = 0;

        try
        {
            PreparedStatement statement = MySQL.getConnection().prepareStatement("SELECT * from ep_users WHERE uuid = ?");
            statement.setString(1, uuid.toString());
            ResultSet results = statement.executeQuery();
            results.next();

            i = results.getInt(6);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return  i;
    }

    /**
     * Get the player's current kit.
     * @return Current kit.
     */
    public int getKit()
    {
        int i = 0;

        try
        {
            PreparedStatement statement = MySQL.getConnection().prepareStatement("SELECT * from ep_users WHERE uuid = ?");
            statement.setString(1, uuid.toString());
            ResultSet results = statement.executeQuery();
            results.next();

            i = results.getInt(8);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return  i;
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
     * Check if player has joined before.
     * @return Whether they have joined before.
     */
    public boolean hasJoined()
    {
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

        return false;
    }

    /**
     * Set the player's bounty.
     * @param bounty Bounty.
     */
    public void setBounty(int bounty)
    {
        try
        {
            PreparedStatement statement = MySQL.getConnection().prepareStatement("UPDATE ep_users SET bounty=? WHERE uuid = ?");
            statement.setInt(1, bounty);
            statement.setString(2, uuid.toString());
            statement.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Set the player's coin count.
     * @param coins Coins.
     */
    public void setCoins(int coins)
    {
        try
        {
            PreparedStatement statement = MySQL.getConnection().prepareStatement("UPDATE ep_users SET coins=? WHERE uuid = ?");
            statement.setInt(1, coins);
            statement.setString(2, uuid.toString());
            statement.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Set the player's death count.
     * @param deaths Deaths.
     */
    public void setDeaths(int deaths)
    {
        try
        {
            PreparedStatement statement = MySQL.getConnection().prepareStatement("UPDATE ep_users SET deaths=? WHERE uuid = ?");
            statement.setInt(1, deaths);
            statement.setString(2, uuid.toString());
            statement.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Set a player's kill count.
     * @param kills Kills.
     */
    public void setKills(int kills)
    {
        try
        {
            PreparedStatement statement = MySQL.getConnection().prepareStatement("UPDATE ep_users SET kills=? WHERE uuid = ?");
            statement.setInt(1, kills);
            statement.setString(2, uuid.toString());
            statement.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Set the player's kill streak.
     * @param killStreak Kill Streak.
     */
    public void setKillStreak(int killStreak)
    {
        try
        {
            PreparedStatement statement = MySQL.getConnection().prepareStatement("UPDATE ep_users SET killstreak=? WHERE uuid = ?");
            statement.setInt(1, killStreak);
            statement.setString(2, uuid.toString());
            statement.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Set a player's kit.
     * @param kit Kit.
     */
    public void setKit(int kit)
    {
        try
        {
            PreparedStatement statement = MySQL.getConnection().prepareStatement("UPDATE ep_users SET selectedKit=? WHERE uuid = ?");
            statement.setInt(1, kit);
            statement.setString(2, uuid.toString());
            statement.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
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
     * Remove coins from a player.
     * @param coins Coins to be removed.
     */
    public void removeCoins(int coins)
    {
        setCoins(getCoins() - coins);
    }
}
