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

public class Droppable {

	public static Logger log = LogManager.getLogger(Droppable.class.getName());
	private WebDriver driver = null;
	private GenericFunctions gen = null;

	@FindBy(css = "div.main-header")
	private WebElement droppableHeader;

	@FindBy(xpath = "//div[text()= 'Drag me']")
	private WebElement dragMe;

	@FindBy(xpath = "(//p[text()= 'Drop here'])[1]//parent::div")
	private WebElement dropHere;

	@FindBy(xpath = "//p[text()= 'Dropped!']")
	private WebElement dropped;

	public Droppable(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		gen = new GenericFunctions(this.driver);
	}

	public void verifyDroppableHeader() throws Throwable {
		try {
			gen.verifyElementVisible(droppableHeader);
			AssertionsAndVerifications.assertEqualValue(gen.getText(droppableHeader), "Droppable");
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
			gen.verifyElementVisible(dropped);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}
}
