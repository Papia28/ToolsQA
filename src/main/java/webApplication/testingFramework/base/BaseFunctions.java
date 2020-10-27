package webApplication.testingFramework.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webApplication.testingFramework.seleniumBase.ReadConfig;

import java.util.List;

public abstract class BaseFunctions {

	private static Logger log = LogManager.getLogger(BaseFunctions.class.getName());
	private WebDriver driver = null;
	
	//constructor for BaseFunctions	
	  public BaseFunctions(WebDriver driver)
	{ 
		  try { 
			  setBaseDriver(driver);
			  } 
		  catch (Throwable e) 
		  {
			  e.printStackTrace();  
		  } 
	}	 

	// getter method for driver
	public WebDriver getBaseDriver() 
	{
		return driver;
	}

	// setter method for driver
	public void setBaseDriver(WebDriver driver) 
	{
		this.driver = driver;
	}

	// method to launch the URL of the application
	public void launchBaseURL() throws Throwable {
		try {
			String URL = ReadConfig.getURL();
			if (URL != "") {
				driver.get(URL);
				Thread.sleep(500);
				System.out.println("URL launched successfully.");
			} else if (URL == "")
				throw new NullPointerException("URL cannot be empty!");
		} catch (Exception e) {
			System.out.println("Error Occured: launchURL()");
			e.printStackTrace();
			throw e;
		}
	}

	// method to return locator type
	public By getLocator(String locatorType, String locatorValue) throws Throwable {
		try {
			switch (locatorType.toUpperCase()) {
			case "XPATH":
				return By.xpath(locatorValue);
			case "ID":
				return By.id(locatorValue);
			case "NAME":
				return By.name(locatorValue);
			case "LINKTEXT":
				return By.linkText(locatorValue);
			case "PARTIALLINKTEXT":
				return By.partialLinkText(locatorValue);
			case "CSSSELECTOR":
				return By.cssSelector(locatorValue);
			case "TAGNAME":
				return By.tagName(locatorValue);
			case "CLASSNAME":
				return By.className(locatorValue);
			default:
				throw new NullPointerException("No match found for Locators!");
				// TODO correct exception name
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getLocator()");
			throw e;
		}
	}

	// method to find element
	public WebElement getElement(String locatorType, String locatorValue) throws Throwable {
		try {
			WebElement element = driver.findElement(getLocator(locatorType, locatorValue));
			log.debug("Element : " + element);
			Thread.sleep(100);
			return element;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getElement()");
			throw e;
		}
	}

	// method to find list of elements
	public List<WebElement> getElements(String locatorType, String locatorValue) throws Throwable {
		try {
			List<WebElement> elements = driver.findElements(getLocator(locatorType, locatorValue));
			log.debug("Elements : \n" + elements);
			Thread.sleep(100);
			return elements;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getElements()");
			throw e;
		}
	}

	// method to find list of elements
	public List<WebElement> getElements(WebElement element, String locatorType, String locatorValue) throws Throwable {
		try {
			List<WebElement> elements = element.findElements(getLocator(locatorType, locatorValue));
			log.debug("Elements : \n" + elements);
			Thread.sleep(100);
			return elements;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getElements()");
			throw e;
		}
	}

	// method to return username
	public String returnUsername() throws Throwable {
		try {
			return ReadConfig.getUsername();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in returnUsername()");
			throw e;
		}
	}

	// method to return password
	public String returnPassword() throws Throwable {
		try {
			return ReadConfig.getPassword();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in returnPassword()");
			throw e;
		}
	}
}
