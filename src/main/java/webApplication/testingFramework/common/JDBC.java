package webApplication.testingFramework.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import webApplication.testingFramework.seleniumBase.ReadConfig;

public class JDBC 
{
	public static Logger log = LogManager.getLogger(JDBC.class.getName());
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static String username = null;
	private static String password = null;
	private static String host = null;
	private static String port = null;
	private static String dbName = null;	
	private static String url = null;	

	public static void openConnection() throws Throwable 
	{
		try {
			log.debug("Establising database connection.");
			username = ReadConfig.getConfigKeyValue("DBusername");
			password = ReadConfig.getConfigKeyValue("DBpassword");
			host = ReadConfig.getConfigKeyValue("host");
			port = ReadConfig.getConfigKeyValue("port");
			dbName = ReadConfig.getConfigKeyValue("DBname");
			
			url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
			log.info(url);
			connection = DriverManager.getConnection(url, username, password);
			log.info("Database connection successfull!");
		} 
		catch (CommunicationsException t) 
		{
			t.printStackTrace();
			log.fatal("Database not connected!");
			throw t;
		}
		catch (SQLTimeoutException t) 
		{
			t.printStackTrace();
			log.fatal("SQL Timeout error while establishing connection to database.");
			throw t;
		}
		catch (SQLException t) 
		{
			t.printStackTrace();
			log.fatal("SQL error while establishing connection to database.");
			throw t;
		}		
		catch (Throwable t) 
		{
			t.printStackTrace();
			log.fatal("Error in establishing connection to database.");
			throw t;
		}
	}

	public static String getFullname(String query) throws Throwable 
	{
		String firstName = null;
		String lastName = null;
		try {
			log.debug("Running given query.");
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			log.info("Query run successfull!");
			log.debug("Getting required data.");			
			if (resultSet.next()) 
			{
				firstName = resultSet.getString("first_name");
				lastName = resultSet.getString("last_name");
			}
			log.info("Data collected successfully!");
			return (firstName + " " + lastName);
		}
		catch (SQLTimeoutException t) 
		{
			t.printStackTrace();
			log.fatal("SQL Timeout error while running query in database.");
			throw t;
		}
		catch (SQLException t) 
		{
			t.printStackTrace();
			log.fatal("SQL error while running query in database.");
			throw t;
		}
		catch (Throwable t) 
		{
			t.printStackTrace();
			log.fatal("Error while running query in database!");
			throw t;
		}
	}
	
	public static void closeConnection() throws Throwable 
	{
		try {
			log.debug("Closing database connection.");
			resultSet.close();
			statement.close();
			connection.close();
			log.info("Database connection closed successfully!");
		} 
		catch (SQLException t) 
		{
			t.printStackTrace();
			log.fatal("SQL error in closing connection to database!");
			throw t;
		}
		catch (Throwable t) 
		{
			t.printStackTrace();
			log.fatal("Error in closing connection to database!");
			throw t;
		}
	}
}
