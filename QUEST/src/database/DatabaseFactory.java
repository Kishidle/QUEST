package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class DatabaseFactory 
{
	
	public static DatabaseFactory getInstance() 
	{
		return new MySQLConnection();
	}

	public static DatabaseFactory getInstance(String u, String p)
	{
		return new MySQLConnection(u, p);
	}

	public abstract Connection getConnection();

	public abstract Connection testConnection(String u, String p);

	public void closeConnection(Connection connection)
	{
		try 
		{
			connection.close();
		}
		catch (Exception e) {
			
		}
	}

	public void closeResultSet(ResultSet resultSet)
	{
		try
		{
			resultSet.close();
		}
		catch (Exception e)
		{
			
		}
	}

	public void closeStatement(Statement statement)
	{
		try
		{
			statement.close();
		}
		catch (Exception e)
		{
			
		}
	}
	
}
