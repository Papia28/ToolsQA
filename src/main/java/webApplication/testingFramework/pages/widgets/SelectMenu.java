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
import webApplication.testingFramework.common.SelectFunctions;
import webApplication.testingFramework.seleniumBase.ReadConfig;

public class SelectMenu {

	public static Logger log = LogManager.getLogger(GenericFunctions.class.getName());
	private WebDriver driver = null;
	private GenericFunctions gen = null;

	@FindBy(css = "div.main-header")
	private WebElement selectMenuHeader;

	@FindBy(css = "div#withOptGroup")
	private WebElement dropdown1;

	@FindBy(css = "div#selectOne")
	private WebElement dropdown2;

	@FindBy(css = "select#oldSelectMenu")
	private WebElement dropdown3;

	@FindBy(xpath = "//b[text()='Multiselect drop down']//following::div[1]")
	private WebElement dropdown4;

	@FindBy(css = "select#cars")
	private WebElement dropdown5;

	private String options = "//div[class='css-2613qy-menu']//*[text()='";
	private String formatter = "']";

	public SelectMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		gen = new GenericFunctions(this.driver);
	}

	public void verifySelectMenuHeader() throws Throwable {
		try {
			gen.verifyElementVisible(selectMenuHeader);
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

	public void hoverOnDropdown1() throws Throwable {
		try {
			ActionFunctions.hoverOnElement(driver, dropdown1);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void clickDropdown1() throws Throwable {
		try {
			gen.click(dropdown1);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in clickDropdown1!", t.fillInStackTrace());
			throw t;
		}
	}

	public void selectDropdown1Option() throws Throwable {
		try {
			String locatorValue = options + ReadConfig.getConfigKeyValue("Dropdown1Value") + formatter;
			SelectFunctions.selectSingleOption(gen, locatorValue);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in clickDropdown5!", t.fillInStackTrace());
			throw t;
		}
	}

	public void hoverOnDropdown2() throws Throwable {
		try {
			ActionFunctions.hoverOnElement(driver, dropdown2);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void clickDropdown2() throws Throwable {
		try {
			gen.click(dropdown2);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in clickDropdown2!", t.fillInStackTrace());
			throw t;
		}
	}

	public void selectDropdown2Option() throws Throwable {
		try {
			String locatorValue = options + ReadConfig.getConfigKeyValue("Dropdown2Value") + formatter;
			SelectFunctions.selectSingleOption(gen, locatorValue);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in clickDropdown5!", t.fillInStackTrace());
			throw t;
		}
	}

	public void hoverOnDropdown3() throws Throwable {
		try {
			ActionFunctions.hoverOnElement(driver, dropdown3);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void selectDropdown3Option() throws Throwable {
		try {
			String value = ReadConfig.getConfigKeyValue("Dropdown3Value");
			SelectFunctions.singleSelectByValue(dropdown3, value);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in clickDropdown5!", t.fillInStackTrace());
			throw t;
		}
	}

	public void hoverOnDropdown4() throws Throwable {
		try {
			ActionFunctions.hoverOnElement(driver, dropdown4);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void clickDropdown4() throws Throwable {
		try {
			gen.click(dropdown4);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in clickDropdown4!", t.fillInStackTrace());
			throw t;
		}
	}

	public void selectDropdown4Options() throws Throwable {
		try {
			String values = ReadConfig.getConfigKeyValue("Dropdown4Values");
			SelectFunctions.selectMultipleOptions(gen, options, formatter, values);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in clickDropdown5!", t.fillInStackTrace());
			throw t;
		}
	}

	public void hoverOnDropdown5() throws Throwable {
		try {
			JavascriptFunctions.scrollDownByPixelValue(driver, 300);
			ActionFunctions.hoverOnElement(driver, dropdown5);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void selectDropdown5Options() throws Throwable {
		try {
			String values = ReadConfig.getConfigKeyValue("Dropdown5Values");
			SelectFunctions.multiSelectByText(driver, dropdown5, values);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in clickDropdown5!", t.fillInStackTrace());
			throw t;
		}
	}
}