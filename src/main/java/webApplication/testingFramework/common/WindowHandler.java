package webApplication.testingFramework.common;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WindowHandler 
{
	private static Logger log = LogManager.getLogger(WindowHandler.class.getName());

	public static String getParentWindow(WebDriver driver) throws Throwable {
		try {
			return driver.getWindowHandle();
		} 
		catch (Throwable e) {
			log.error("Error in getting parent window handle!", e.fillInStackTrace());
			throw e;
		}
	}

	public static Set<String> getChildWindows(WebDriver driver) throws Throwable {
		try {
			return driver.getWindowHandles();
		} 
		catch (Throwable e) {
			log.error("Error in getting child window handles!", e.fillInStackTrace());
			throw e;
		}
	}
	
	public static void switchToWindow(WebDriver driver, String windowHandle) throws Throwable {
		try {
			driver.switchTo().window(windowHandle);
		} 
		catch (Throwable e) {
			log.error("Error in getting child window handles!", e.fillInStackTrace());
			throw e;
		}
	}

	public static void switchToNthWindow(WebDriver driver, String parent, int n) throws Throwable 
	{
		int count = 0;
		Set<String> windows = getChildWindows(driver);

		try {
			windows.remove(parent);
			for (String child : windows) {
				driver.switchTo().window(child);
				count++;
				if (count == n)
					break;
			}
		} catch (Throwable e) {
			log.error("Error while switching windows!", e.fillInStackTrace());
			throw e;
		}
	}

	public static WebElement switchToWindowWithElement(WebDriver driver, String parent, WebElement element) throws Throwable 
	{
		int count = 0;
		Set<String> windows = getChildWindows(driver);
		try {
			windows.remove(parent);
			for (String child : windows) 
			{
				driver.switchTo().window(child);
				try 
				{
					if (element.getTagName() != null)
						break;
				}
				catch(Throwable t)
				{
					count++;
					if (count > 5)
						break;
					else
						continue;
				}
			}
			return element;
		} 
		catch (Throwable e) 
		{
			log.error("Error while switching windows!", e.fillInStackTrace());
			throw e;
		}
	}
	
	public static void switchUsingJavascriptElement(WebDriver driver, String parent) throws Throwable 
	{
		//int count = 0;
		Set<String> windows = getChildWindows(driver);		
		//WebElement element = null;
		try {
			windows.remove(parent);
			for (String child : windows) 
			{
				driver.switchTo().window(child);
				/*
				 * try { element = JavascriptFunctions.getElementByJavascript(driver); if
				 * (element.getTagName() != null) break; } catch(Throwable t) { count++; if
				 * (count > 5) break; else continue; }
				 */
			}
			//return element;
		} 
		catch (Throwable e) 
		{
			log.error("Error while switching windows!", e.fillInStackTrace());
			throw e;
		}
	}

	public static void openNewTab(WebDriver driver) throws Throwable 
	{
		try {
			// get parent window handle
			String parent = getParentWindow(driver);

			// get body element of the page
			WebElement body = driver.findElement(By.xpath("//body"));

			// open a new tab
			body.sendKeys(Keys.chord(Keys.CONTROL, "t"));

			// get child window handles
			Set<String> set1 = getChildWindows(driver);

			// switch to new tab
			set1.remove(parent);
			for (String child : set1)
				driver.switchTo().window(child);
		} 
		catch (Throwable t) 
		{
			t.printStackTrace();
			log.error("not able to switch to new tab!");
			throw t;
		}
	}
}
