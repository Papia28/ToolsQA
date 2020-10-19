package webApplication.testingFramework.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import webApplication.testingFramework.pages.AlertsFramesWindows;
import webApplication.testingFramework.pages.Elements;
import webApplication.testingFramework.pages.HomePage;
import webApplication.testingFramework.pages.Interactions;

public class PageObjectManager 
{
	public static Logger log = LogManager.getLogger(PageObjectManager.class.getName());
	private WebDriver driver = null;
	private HomePage homePage = null;
	private Elements elements = null;
	private AlertsFramesWindows alertsFramesWindows = null;
	private Interactions interactions = null;
	
	public PageObjectManager(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public HomePage homePage() throws Throwable
	{
		try {
			if(homePage == null)
				homePage = new HomePage(driver);
			return homePage;
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in creating object of HomePage.");
			throw t;
		}
	}
	
	public Elements elements() throws Throwable
	{
		try {
			if(elements == null)
				elements = new Elements(driver);
			return elements;
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in creating object of Elements.");
			throw t;
		}
	}
	
	public AlertsFramesWindows alertsFramesWindows() throws Throwable
	{
		try {
			if(alertsFramesWindows == null)
				alertsFramesWindows = new AlertsFramesWindows(driver);
			return alertsFramesWindows;
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in creating object of Elements.");
			throw t;
		}
	}
	
	public Interactions interactions() throws Throwable
	{
		try {
			if(interactions == null)
				interactions = new Interactions(driver);
			return interactions;
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in creating object of Elements.");
			throw t;
		}
	}

}
