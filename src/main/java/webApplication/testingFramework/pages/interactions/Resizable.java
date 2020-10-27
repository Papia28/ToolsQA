package webApplication.testingFramework.pages.interactions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webApplication.testingFramework.base.GenericFunctions;
import webApplication.testingFramework.common.ActionFunctions;
import webApplication.testingFramework.common.JavascriptFunctions;

public class Resizable {

	public static Logger log = LogManager.getLogger(Resizable.class.getName());
	private WebDriver driver = null;
	private GenericFunctions gen = null;

	@FindBy(css = "div.main-header")
	private WebElement resizableHeader;

	@FindBy(xpath = "(//span[starts-with(@class, 'react-resizable')])[1]")
	private WebElement resizableHandle1;

	@FindBy(xpath = "(//span[starts-with(@class, 'react-resizable')])[2]")
	private WebElement resizableHandle2;

	public Resizable(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		gen = new GenericFunctions(this.driver);
	}

	public void verifyResizableHeader() throws Throwable {
		try {
			gen.verifyElementVisible(resizableHeader);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void hoverOnResizable1() throws Throwable {
		try {
			ActionFunctions.hoverOnElement(driver, resizableHandle1);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void clickDragResizable1() throws Throwable {
		try {
			ActionFunctions.clickAndDrag(driver, resizableHandle1, 500, 300);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void hoverOnResizable2() throws Throwable {
		try {
			JavascriptFunctions.scrollDownByPixelValue(driver, 200);
			ActionFunctions.hoverOnElement(driver, resizableHandle2);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void clickDragResizable2() throws Throwable {
		try {
			ActionFunctions.clickAndDrag(driver, resizableHandle2, 1000, 600);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}
}
