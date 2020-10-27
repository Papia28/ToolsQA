package webApplication.testingFramework.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webApplication.testingFramework.common.AssertionsAndVerifications;
import webApplication.testingFramework.common.HttpFunctions;
import webApplication.testingFramework.common.JavascriptFunctions;
import webApplication.testingFramework.seleniumBase.ReadConfig;

import java.net.URL;


public class GenericFunctions extends BaseFunctions {

	private WebDriver driver = null;
	public static Logger log = LogManager.getLogger(GenericFunctions.class.getName());
	
	//----------------------------------------------------------------------------------------------------------------------------------------------
	
	//privatised constructor of genericFunctions
	public GenericFunctions(WebDriver driver)
	{	
		super(driver);
		setDriver();
	}
	
	//accessor method for driver
	public WebDriver getDriver()
	{
		return driver;
	}

	//mutator method for driver
	public void setDriver()
	{			
		this.driver = getBaseDriver();
	}
	
	//----------------------------------------------------------------------------------------------------------------------------------------------
	
	// method to maximize open browser window
	
	public void maximizeBrowser() throws Throwable {
		try {
			//code to maximize the browser window
			log.debug("Maximizing browser");
			driver.manage().window().maximize();
			Thread.sleep(5);
			log.info("Successfully maximized browser!");
		} 
		catch (Throwable e) {
			log.error("Error occurred: maximizeBrowser()");
			e.printStackTrace();
			throw e;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	// method to perform mouse click on items
	
	public void click(WebElement element) throws Throwable {
		try {
			JavascriptFunctions.highlightElement(driver, element);
			Thread.sleep(5);
			log.debug("Clicking element " + element);
			element.click();
			Thread.sleep(5);
			log.info("Element clicked successfully!");
		} 
		catch (Throwable e) {
			e.printStackTrace();
			log.error("Error in click()");
			throw e;
		}
	}

	//-----------------------------------------------------------------------------------------------------------------------------------------------
	// method to clear text field contents
	
	public void clear(WebElement element) throws Throwable {
		try {			
			JavascriptFunctions.highlightElement(driver, element);
			Thread.sleep(5);
			log.debug("Clearing element " + element);
			element.clear();
			Thread.sleep(5);
			log.info("Element cleared successfully!");
		} 
		catch (Throwable e) {
			e.printStackTrace();
			log.error("Error in clearText()");
			throw e;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	// method to write in the text fields
	
	public void write(WebElement element, String fieldValue) throws Throwable {
		try {
			JavascriptFunctions.highlightElement(driver, element);
			Thread.sleep(5);
			log.debug("Writing text to element " + element);
			element.sendKeys(fieldValue);
			Thread.sleep(5);
			log.info("Text written successfully!");
		} 
		catch (Throwable e) {
			e.printStackTrace();
			log.error("Error in writeValue()");
			throw e;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	// method to return current page title
	
	public String getCurrentPageTitle() throws Throwable {
		try {
			Thread.sleep(5);
			log.debug("Getting current page title");
			return driver.getTitle();
		} 
		catch (Throwable e) {
			e.printStackTrace();
			log.error("Error in getActualPageTitle()");
			throw e;
		}
	}

	//-----------------------------------------------------------------------------------------------------------------------------------------------
	// method to verify actual and expected page Titles
	
	public void verifyPageTitle(String expectedTitle) throws Throwable {
		try {			
			//get the actual value of the expected page title by reading the objectProperties file
			String expectedPageTitle = ReadConfig.getConfigKeyValue(expectedTitle);
			Thread.sleep(5);
			
			//call function to return current web page title
			String actualPageTitle = getCurrentPageTitle();
			log.debug("Verifying page title");
			//assert the actual and expected page titles
			AssertionsAndVerifications.assertEqualValue(actualPageTitle, expectedPageTitle);
			log.info("Title verified successfully!");
		}
		catch(AssertionError e)
		{
			e.printStackTrace();
			log.error("Failure! Page title is not as expected!");
			throw e;
		}
		catch (Throwable e) {
			e.printStackTrace();
			log.error("Error in verifyPageTitle()");
			throw e;
		}
	}

	//-----------------------------------------------------------------------------------------------------------------------------------------------
	// method to check element visibility
	
	public void verifyElementVisible(WebElement element) throws Throwable {
		try {
			log.debug("Verifying " + element + "is visible or not");
			//assert visibility of element
			AssertionsAndVerifications.assertTrueValue(element.isDisplayed());
			Thread.sleep(5);
			JavascriptFunctions.highlightElement(driver, element);
			log.info("Success! " + element + " is visible!");
		} 
		catch(AssertionError e)
		{
			e.printStackTrace();
			log.error("Failure! " + element + " is not visible!");
			throw e;
		}
		catch (Throwable e) {
			e.printStackTrace();
			log.error("Error in isElementVisible().");
			throw e;
		}
	}

	//-----------------------------------------------------------------------------------------------------------------------------------------------

	// method to check element visibility

	public void verifyElementNotVisible(WebElement element) throws Throwable {
		try {
			log.debug("Verifying " + element + "is visible or not");
			//assert visibility of element
			AssertionsAndVerifications.assertFalseValue(element.isDisplayed());
			Thread.sleep(5);
			log.info("Success! " + element + " is not visible!");
		}
		catch (NoSuchElementException e) {
			log.info("Element not found!");
			throw e;
		}
		catch(AssertionError e)
		{
			e.printStackTrace();
			log.error("Failure! " + element + " is visible!");
			JavascriptFunctions.highlightElement(driver, element);
			throw e;
		}
		catch (Throwable e) {
			e.printStackTrace();
			log.error("Error in isElementVisible().");
			throw e;
		}
	}

	//-----------------------------------------------------------------------------------------------------------------------------------------------
	// method to return inner text from element
	
		public String getText(WebElement element) throws Throwable {
			try {
				JavascriptFunctions.highlightElement(driver, element);
				Thread.sleep(5);
				log.debug("Getting inner text of " + element);
				//return the inner text from the element
				return element.getText();
			} 
			catch (Throwable e) {
				e.printStackTrace();
				log.error("Error in getText().");
				throw e;
			}
		}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
		// method to close current window
		
			public void closeCurrentWindow() throws Throwable {
				try {
					log.debug("Closing current window");
					Thread.sleep(5);
					driver.close();
				} 
				catch (Throwable e) {
					e.printStackTrace();
					log.error("Error in closeCurrentWindow().");
					throw e;
				}
			}
		
		//-----------------------------------------------------------------------------------------------------------------------------------------------
	// method to get URL from a link

	public URL getURL(WebElement element) throws Throwable {
		try {
			JavascriptFunctions.highlightElement(driver, element);
			Thread.sleep(5);
			log.debug("Getting URL from element " + element);
			return HttpFunctions.getNewURL(getAttribute(element,"href"));
		}
		catch (Throwable e) {
			e.printStackTrace();
			log.error("Error in getURL().");
			throw e;
		}
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------

	// method to get attribute value of an element

	public String getAttribute(WebElement element, String attributeName) throws Throwable {
		try {
			JavascriptFunctions.highlightElement(driver, element);
			Thread.sleep(5);
			log.debug("Getting value of " + attributeName + " of element " + element);
			return element.getAttribute(attributeName);
		}
		catch (Throwable e) {
			e.printStackTrace();
			log.error("Error in getAttribute().");
			throw e;
		}
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------

	// method to get Src from an image
	public String getImageSrc(WebElement element) throws Throwable {
		try {
			JavascriptFunctions.highlightElement(driver, element);
			Thread.sleep(5);
			log.debug("Getting Image Source URL from element " + element);
			return getAttribute(element,"src");
		}
		catch (Throwable e) {
			e.printStackTrace();
			log.error("Error in getImageSrc().");
			throw e;
		}
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------

	// method to navigate to an url
	public void navigateToUrl(String url) throws Throwable {
		try {
			Thread.sleep(5);
			log.debug("Navigating to " + url);
			driver.navigate().to(url);
			log.info("Navigated to " + url + " successfully!");
		}
		catch (Throwable e) {
			e.printStackTrace();
			log.error("Error in navigateToUrl().");
			throw e;
		}
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------

	// method to navigate back
	public void navigateBack() throws Throwable {
		try {
			Thread.sleep(5);
			log.debug("Navigating back to previous page");
			driver.navigate().back();
			log.info("Navigated to previous page successfully!");
		}
		catch (Throwable e) {
			e.printStackTrace();
			log.error("Error in navigateBack().");
			throw e;
		}
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------

	// method to navigate back
	public void navigateForward() throws Throwable {
		try {
			Thread.sleep(5);
			log.debug("Navigating back to next page");
			driver.navigate().forward();
			log.info("Navigated to next page successfully!");
		}
		catch (Throwable e) {
			e.printStackTrace();
			log.error("Error in navigateForward().");
			throw e;
		}
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------

	// method to navigate back
	public void refresh() throws Throwable {
		try {
			Thread.sleep(5);
			log.debug("Refreshing current page");
			driver.navigate().forward();
			log.info("Current page refreshed successfully!");
		}
		catch (Throwable e) {
			e.printStackTrace();
			log.error("Error in refresh().");
			throw e;
		}
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	// end of class
}
