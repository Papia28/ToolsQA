package webApplication.testingFramework.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;

public class HttpFunctions {
	
	public static Logger log = LogManager.getLogger(HttpFunctions.class.getName()); 
	private static HttpURLConnection connection = null;

	public static URL getNewURL(String s) throws Throwable {
		try {
			return new URL(s);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error("Error while converting to URL!");
			throw t;
		}
	}
	
	public static int getResponseCode(URL url) throws Throwable
	{		
		try {		
			connection = (HttpURLConnection) url.openConnection();
			connection.connect();
			return connection.getResponseCode();
		}
		catch(UnknownHostException e)
		{
			return 400;
		}
		catch(SocketTimeoutException t)
		{
			t.printStackTrace();
			log.error("Timeout error while connecting!");
			throw t;
		}
		catch(IOException t)
		{
			t.printStackTrace();
			log.error("IO error while opening connection or getting response code!");
			throw t;
		}		
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in getting the response code.");
			throw t;
		}
		finally
		{
			connection.disconnect();
		}
	}

	public static boolean isURLValid(URL url) throws Throwable {
		boolean result = false;
		try {
			if(getResponseCode(url) < 400)
				result = true;
			else if(getResponseCode(url) >= 400)
				result = false;
		}
		catch(UnknownHostException e)
		{
			result = false;
		}
		catch (Throwable t) {
			t.printStackTrace();
			log.error("Error in isURLValid()!");
			throw t;
		}
		return result;
	}
}
