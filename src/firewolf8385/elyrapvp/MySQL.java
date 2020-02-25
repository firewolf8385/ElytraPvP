package firewolf8385.elytrapvp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQL
{
    private static Settings settings = Settings.getInstance();

    private static Connection connection;
    private static String host = settings.getConfig().getString("MySQL.host");
    private static String database = settings.getConfig().getString("MySQL.database");
    private static String username = settings.getConfig().getString("MySQL.username");
    private static String password = settings.getConfig().getString("MySQL.password");
    private static int port = settings.getConfig().getInt("MySQL.port");

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
}
