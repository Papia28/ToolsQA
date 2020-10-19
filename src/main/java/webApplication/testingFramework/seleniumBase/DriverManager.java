package webApplication.testingFramework.seleniumBase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public final class DriverManager 
{
	private WebDriver driver = null;
	private static Logger log = LogManager.getLogger(DriverManager.class.getName());
	private BaseDriverFactory sbd = null;
	
	public DriverManager() throws Throwable
	{
		try {
		openBrowser();
		}
		catch(Throwable t)
		{
			log.error("Error in creating DriverManager object!", t.fillInStackTrace());
			throw t;
		}
	}
	
	//accessor method for driver
	public WebDriver getDriver()
	{			
		//return the driver
		return driver;
	} 
	
	//mutator method for driver
	public void setDriver(WebDriver driver)
	{
		//set value of the driver
		this.driver = driver;
	}
	
	// launch the browser
	public void openBrowser() throws Throwable 
	{
		try {
			
			/*
			 * System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
			 * WebDriverManager.chromedriver().setup(); 
			 * driver = new ChromeDriver();
			 */	
			
			ReadConfig.setReadConfig();
			
			// set value for browser
			log.debug("Setting browser.");
			
			//To run via .propeties file use below command
			BaseDriverFactory.setBrowser(ReadConfig.getBrowser());
			
			/** This is running via maven command.
			 * For maven command System.getProperty is required to get the value of any system property.
			 * Browser is regarded as a system property.
			 * Its value is provided by maven commands via Jenkins or command prompt
			 */
			//BaseDriverFactory.setBrowser(System.getProperty("browser"));
						
			//set the webDriverManager as per the browser
			log.debug("Setting WebDriverManager.");
			BaseDriverManager.setWebDriverManager(); 
			
			//set the WebDriver driver object
			log.debug("Setting driver.");
			sbd = new BaseDriverFactory();
			
			//get the WebDriver driver object
			setDriver(sbd.getDriver());
		}
		
		catch (Throwable e) {
			log.error("Failure! openBrowser() not executed correctly.");
			e.printStackTrace();
			throw e;
		}
	}	

	// close all opened browsers
	public void closeBrowser() 
	{			
		try {
			log.debug("************Quitting Browser**************");
			Thread.sleep(1000);
			driver.quit();
		} 
		catch (Throwable e) {
			log.error("Failure! Error occurred during closeBrowser().");
			e.printStackTrace();
			//System.exit(0);
		} 
		finally 
		{ 
			setDriver(null);
			sbd.deleteInstance();
			sbd = null;					
		}
	}
}
