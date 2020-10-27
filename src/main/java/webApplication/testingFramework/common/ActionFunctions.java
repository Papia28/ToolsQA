package webApplication.testingFramework.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionFunctions 
{
	private static Logger log = LogManager.getLogger(ActionFunctions.class.getName());
	//----------------------------------------------------------------------------------------------------------------------------------------------	
		// method to hover on element
		
		public static void hoverOnElement(WebDriver driver, WebElement element) throws Throwable {
			try {
				//create Actions class object of the WebDriver object
				Actions hover = new Actions(driver);
				
				//perform click and hold of the element using the Actions class object
				hover.moveToElement(element);
				hover.perform();
				JavascriptFunctions.highlightElement(driver, element);
				Thread.sleep(100);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
				log.error("Thread interrupted in hoverOnElement().");
				throw e;
			}
			catch (Throwable e) {
				e.printStackTrace();
				log.error("Error in hoverOnElement().");
				throw e;
			}
		}

	//----------------------------------------------------------------------------------------------------------------------------------------------	
	// method to click and hold
	
	public static void clickAndHoldElement(WebDriver driver, WebElement element) throws Throwable {
		try {
			//create Actions class object of the WebDriver object
			Actions hold = new Actions(driver);
			//perform click and hold of the element using the Actions class object
			JavascriptFunctions.highlightElement(driver, element);
			hold.clickAndHold(element);
			hold.perform();
			Thread.sleep(100);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
			log.error("Thread interrupted in clickAndHoldElement().");
			throw e;
		}
		catch (Throwable e) {
			e.printStackTrace();
			log.error("Error in clickAndHoldElement().");
			throw e;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	// method to click and drag

	public static void clickAndDrag(WebDriver driver, WebElement element, int xOffset, int yOffset) throws Throwable {
		try {
			//create Actions class object of the WebDriver object
			Actions holdDrag = new Actions(driver);
			//perform click and hold of the element using the Actions class object
			JavascriptFunctions.highlightElement(driver, element);
			holdDrag.clickAndHold(element).moveByOffset(xOffset, yOffset).build();
			holdDrag.perform();
			Thread.sleep(50);
			holdDrag.release().perform();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
			log.error("Thread interrupted in clickAndHoldElement().");
			throw e;
		}
		catch (Throwable e) {
			e.printStackTrace();
			log.error("Error in clickAndHoldElement().");
			throw e;
		}
	}

	//-----------------------------------------------------------------------------------------------------------------------------------------------
		// method to drag and drop an element
	//DO NOT USE BUILD().IT CAUSES THE DRAG AND DROP TO NOT WORK
		
		public static void dragAndDropElement(WebDriver driver, WebElement sourceElement, WebElement targetElement) throws Throwable {
			try {				
				//create Actions class object of the WebDriver ojbect
				Actions dragDrop = new Actions(driver);
				
				//perform drag and drop of the source element into the target element
				dragDrop.dragAndDrop(sourceElement, targetElement);
				dragDrop.perform();
				Thread.sleep(100);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
				log.error("Thread interrupted in dragAndDropElement().");
				throw e;
			}
			catch (Throwable e) {
				e.printStackTrace();
				log.error("Error in dragAndDropElement().");
				throw e;
			}
		}

	//-----------------------------------------------------------------------------------------------------------------------------------------------

	// method to right click on element
		
		public static void rightClickElement(WebDriver driver, WebElement element) throws Throwable {
			try {
				//create Actions class object of the WebDriver object
				Actions rightClick = new Actions(driver);
				JavascriptFunctions.highlightElement(driver, element);
				//perform click and hold of the element using the Actions class object
				rightClick.contextClick(element);
				rightClick.perform();				
				Thread.sleep(10);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
				log.error("Thread interrupted in rightClickElement().");
				throw e;
			}
			catch (Throwable e) {
				e.printStackTrace();
				log.error("Error in rightClickElement().");
				throw e;
			}
		}
	//-----------------------------------------------------------------------------------------------------------------------------------------------

	// method to double click on element

	public static void doubleClickElement(WebDriver driver, WebElement element) throws Throwable {
		try {
			//create Actions class object of the WebDriver object
			Actions doubleAction = new Actions(driver);
			JavascriptFunctions.highlightElement(driver, element);
			//perform click and hold of the element using the Actions class object
			doubleAction.doubleClick(element);
			doubleAction.perform();
			Thread.sleep(10);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
			log.error("Thread interrupted in doubleClickElement().");
			throw e;
		}
		catch (Throwable e) {
			e.printStackTrace();
			log.error("Error in doubleClickElement().");
			throw e;
		}
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------

}
