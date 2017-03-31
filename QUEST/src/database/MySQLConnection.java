package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection extends DatabaseFactory
{

    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3307/Classroom";
    private String username;
    private String password;
    
    public MySQLConnection(String u, String p)
    {
        this.username = u;
        this.password = p;
    }

    public MySQLConnection()
    {
    }
    
    @Override
    public Connection getConnection()
    {
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        return null;
    }
    
    @Override
    public Connection testConnection(String u, String p)
    {
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, u, p);
            return connection;
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        return null;
    }

	public void setUsername(String username)
	{
		this.username = username;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
}

