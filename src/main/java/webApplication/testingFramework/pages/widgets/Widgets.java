package webApplication.testingFramework.pages.widgets;

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

public class Widgets {
	
	public static Logger log = LogManager.getLogger(GenericFunctions.class.getName());
	private WebDriver driver = null;
	private GenericFunctions gen = null;

	@FindBy(xpath = "(//div[text()='Widgets'])[1]")
	private WebElement widgetsHeader;

	@FindBy(xpath = "//span[text()='Tool Tips']")
	private WebElement tooltips;

	@FindBy(xpath = "//span[text()='Select Menu']")
	private WebElement selectmenu;

	public Widgets(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		gen = new GenericFunctions(this.driver);
	}

	public void verifyWidgetsHeader() throws Throwable {
		try {
			gen.verifyElementVisible(widgetsHeader);
		} catch (AssertionError e) {
			log.error("Failure! Values do not match!", e.fillInStackTrace());
			throw e;
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void hoverOnTooltips() throws Throwable {
		try {
			JavascriptFunctions.scrollToLast(driver);
			ActionFunctions.hoverOnElement(driver, tooltips);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void clickTooltips() throws Throwable {
		try {
			gen.click(tooltips);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void hoverOnSelectMenu() throws Throwable {
		try {
			JavascriptFunctions.scrollToLast(driver);
			ActionFunctions.hoverOnElement(driver, selectmenu);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void clickSelectMenu() throws Throwable {
		try {
			gen.click(selectmenu);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}
}