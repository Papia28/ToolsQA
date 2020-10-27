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
import webApplication.testingFramework.common.AssertionsAndVerifications;
import webApplication.testingFramework.common.JavascriptFunctions;

public class Interactions {
	
	public static Logger log = LogManager.getLogger(GenericFunctions.class.getName());
	private WebDriver driver = null;
	private GenericFunctions gen = null;

	@FindBy(css = "div.main-header")
	private WebElement interactionsHeader;

	@FindBy(xpath = "//span[text()= 'Sortable']//parent::li")
	private WebElement sortable;

	@FindBy(xpath = "//span[text()= 'Selectable']//parent::li")
	private WebElement selectable;

	@FindBy(xpath = "//span[text()= 'Resizable']//parent::li")
	private WebElement resizable;

	@FindBy(xpath = "//span[text()= 'Dragabble']//parent::li")
	private WebElement dragabble;

	@FindBy(xpath = "//span[text()= 'Droppable']//parent::li")
	private WebElement droppable;

	public Interactions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		gen = new GenericFunctions(this.driver);
	}

	public void verifyInteractionsHeader() throws Throwable {
		try {
			gen.verifyElementVisible(interactionsHeader);
			AssertionsAndVerifications.assertEqualValue(gen.getText(interactionsHeader), "Interactions");
		} catch(AssertionError e) {
			e.printStackTrace();
			log.error("Failure! Values do not match!");
			throw e;
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void hoverOnDroppable() throws Throwable {
		try {
			JavascriptFunctions.scrollToLast(driver);
			ActionFunctions.hoverOnElement(driver, droppable);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void clickDroppable() throws Throwable {
		try {
			gen.click(droppable);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void hoverOnResizable() throws Throwable {
		try {
			JavascriptFunctions.scrollToLast(driver);
			ActionFunctions.hoverOnElement(driver, resizable);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void clickResizable() throws Throwable {
		try {
			gen.click(resizable);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}
}
