package webApplication.testingFramework.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webApplication.testingFramework.base.GenericFunctions;
import webApplication.testingFramework.common.ActionFunctions;

public class Interactions {
	
	public static Logger log = LogManager.getLogger(GenericFunctions.class.getName());
	private WebDriver driver = null;
	private GenericFunctions gen = null;

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

	@FindBy(xpath = "//div[text()= 'Drag me']")
	private WebElement dragMe;

	@FindBy(xpath = "(//p[text()= 'Drop here'])[1]//parent::div")
	private WebElement dropHere;

	@FindBy(xpath = "//p[text()= 'Dropped!']")
	private WebElement dropped;

	public Interactions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		gen = new GenericFunctions(this.driver);
	}

	public void hoverOnDroppable() throws Throwable {
		try {
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

	public void dragAndDrop() throws Throwable {
		try {
			ActionFunctions.dragAndDropElement(driver, dragMe, dropHere);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void isDroppedVisible() throws Throwable {
		try {
			gen.isElementVisible(dropped);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}
}
