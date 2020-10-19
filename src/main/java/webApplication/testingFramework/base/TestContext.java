package webApplication.testingFramework.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import webApplication.testingFramework.seleniumBase.DriverManager;

public class TestContext 
{
	public static Logger log = LogManager.getLogger(TestContext.class.getName());
	private DriverManager driverManager = null;
	private PageObjectManager pageObjectManager = null;
	private WebDriver driver = null;
	
	public TestContext()
	{
		try {
		driverManager = new DriverManager();
		this.driver = driverManager.getDriver();
		pageObjectManager = new PageObjectManager(driver);		
		}
		catch(Throwable t)
		{
			log.error("Error in setting TextContext!", t.fillInStackTrace());
		}		
	}
	
	public DriverManager driverManager() throws Throwable
	{
		try {
			return driverManager;
		}
		catch(Throwable e)
		{
			log.error("Failed to create DriverManager object!", e.fillInStackTrace());
			e.printStackTrace();
			throw e;
		}
	}
	
	public PageObjectManager pageObjectManager() throws Throwable
	{
		try {
			return pageObjectManager;
		}
		catch(Throwable t)
		{
			log.error("Failed to create DriverManager object!", t.fillInStackTrace());
			t.printStackTrace();
			throw t;
		}
	}
	
	public WebDriver driver() throws Throwable
	{
		try {
			return driver;
		}
		catch(Throwable t)
		{
			log.error("Failed to create DriverManager object!", t.fillInStackTrace());
			t.printStackTrace();
			throw t;
		}
	}
}
