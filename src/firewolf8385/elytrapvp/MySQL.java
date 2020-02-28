package firewolf8385.elytrapvp;


import java.sql.*;

public class MySQL
{
    private static Settings settings = Settings.getInstance();

    private static Connection connection;
    private static String host = settings.getConfig().getString("MySQL.host");
    private static String database = settings.getConfig().getString("MySQL.database");
    private static String username = settings.getConfig().getString("MySQL.username");
    private static String password = settings.getConfig().getString("MySQL.password");
    private static int port = settings.getConfig().getInt("MySQL.port");

    public static void closeConnection()
    {
        if(isConnected())
        {
            try
            {
                connection.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * Create tables if they don't exist.
     */
    public static void createTables()
    {
        // Exit if tables exists.
        if(tableExists("ep_users"))
        {
            return;
        }

        try
        {
            PreparedStatement statement = connection.prepareStatement("CREATE TABLE `elytrapvp`.`ep_users` ("+
                    "  `uuid` VARCHAR(36) NULL,"+
                    "  `coins` INT NULL DEFAULT 0,"+
                    "  `bounty` INT NULL DEFAULT 0,"+
                    "  `kills` INT NULL DEFAULT 0,"+
                    "  `deaths` INT NULL DEFAULT 0,"+
                    "  `killstreak` INT NULL DEFAULT 0,"+
                    "  `achievements` VARCHAR(45) NULL,"+
                    "  `selectedKit` INT NULL DEFAULT 0,"+
                    "  `unlockedKits` VARCHAR(45) NULL,"+
                    "  `selectedHat` INT NULL DEFAULT 0,"+
                    "  `unlockedHats` VARCHAR(45) NULL,"+
                    "  `selectedKillMessage` INT NULL DEFAULT 0,"+
                    "  `unlockedKillMessages` VARCHAR(45) NULL,"+
                    "  `selectedTag` INT NULL DEFAULT 0,"+
                    "  `unlockedTags` VARCHAR(45) NULL);");

            statement.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Make sure the database is connected.
     */
    public static void ensureConnection()
    {
        try
        {
            PreparedStatement statement = MySQL.getConnection().prepareStatement("SELECT 1 from ep_users WHERE");
            statement.executeQuery();
        }
        catch(SQLException e)
        {
            // Nothing.
        }
    }

    /**
     * Get the connection.
     * @return Connection
     */
    public static Connection getConnection()
    {
        return connection;
    }

    private static boolean isConnected()
    {
        return (connection == null ? false : true);
    }

    /**
     * Open a MySQL Connection
     */
    public static void openConnection()
    {
        try
        {
            if (connection != null && !connection.isClosed())
            {
                return;
            }

            synchronized(ElytraPvP.class)
            {
                if (connection != null && !connection.isClosed())
                {
                    return;
                }

                String str = "";

                if(settings.getConfig().getBoolean("MySQL.useSSL"))
                {
                    str += "?autoReconnect=true&useSSL=false";
                }

                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + str, username, password);
            }
        }
        catch(SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    /**
     * Check if a table exists.
     * @param table Table to check.
     * @return Whether it exists.
     */
    private static boolean tableExists(String table)
    {
        try
        {
            DatabaseMetaData dbm = connection.getMetaData();
            ResultSet tables = dbm.getTables(null, null, table, null);

            if(tables.next())
            {
                return true;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }
}
