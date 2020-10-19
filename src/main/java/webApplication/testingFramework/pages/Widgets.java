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
import webApplication.testingFramework.common.AssertionsAndVerifications;
import webApplication.testingFramework.common.JavascriptFunctions;

public class Widgets {
	
	public static Logger log = LogManager.getLogger(GenericFunctions.class.getName());
	private WebDriver driver = null;
	private GenericFunctions gen = null;
	private String buttonTooltipText = "You hovered over the Button";
	private String textboxTooltipText = "You hovered over the text field";
	private String text1TooltipText = "You hovered over the Contrary";
	private String text2TooltipText = "You hovered over the 1.10.32";

	@FindBy(xpath = "(//div[text()='Widgets'])[1]")
	private WebElement widgetsHeader;

	@FindBy(xpath = "//div[text()='Tool Tips']")
	private WebElement tooltipHeader;

	@FindBy(xpath = "//span[text()='Tool Tips']")
	private WebElement tooltips;

	@FindBy(css = "button#toolTipButton")
	private WebElement button;

	@FindBy(css = "div#buttonToolTip")
	private WebElement buttonTooltip;

	@FindBy(css = "input#toolTipTextField")
	private WebElement textbox;

	@FindBy(css = "div#textFieldToolTip")
	private WebElement textboxTooltip;

	@FindBy(xpath = "//a[text()='Contrary']")
	private WebElement text1;

	@FindBy(css = "div#contraryTexToolTip")
	private WebElement text1Tooltip;

	@FindBy(xpath = "//a[starts-with(text(),'1.')]")
	private WebElement text2;

	@FindBy(css = "div#sectionToolTip")
	private WebElement text2Tooltip;

	public Widgets(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		gen = new GenericFunctions(this.driver);
	}

	public GenericFunctions genericFunctions() {
		return gen;
	}

	public void verifyWidgetsHeader() throws Throwable {
		try {
			gen.isElementVisible(widgetsHeader);
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

	public void verifyTooltipHeader() throws Throwable {
		try {
			gen.isElementVisible(tooltipHeader);
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

	public void hoverOnButton() throws Throwable {
		try {
			ActionFunctions.hoverOnElement(driver, button);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void verifyButtonTooltip() throws Throwable {
		try {
			JavascriptFunctions.highlightElement(driver, buttonTooltip);
			AssertionsAndVerifications.assertEqualValue(gen.getText(buttonTooltip), buttonTooltipText);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (AssertionError e) {
			log.error("Failure! Values do not match!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void hoverOnTextbox() throws Throwable {
		try {
			ActionFunctions.hoverOnElement(driver, textbox);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void verifyTextboxTooltip() throws Throwable {
		try {
			JavascriptFunctions.highlightElement(driver, textboxTooltip);
			AssertionsAndVerifications.assertEqualValue(gen.getText(textboxTooltip), textboxTooltipText);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (AssertionError e) {
			log.error("Failure! Values do not match!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void hoverOnText1() throws Throwable {
		try {
			ActionFunctions.hoverOnElement(driver, text1);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void verifyText1Tooltip() throws Throwable {
		try {
			JavascriptFunctions.highlightElement(driver, text1Tooltip);
			AssertionsAndVerifications.assertEqualValue(gen.getText(text1Tooltip), text1TooltipText);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (AssertionError e) {
			log.error("Failure! Values do not match!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void hoverOnText2() throws Throwable {
		try {
			ActionFunctions.hoverOnElement(driver, text2);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void verifyText2Tooltip() throws Throwable {
		try {
			JavascriptFunctions.highlightElement(driver, text2Tooltip);
			AssertionsAndVerifications.assertEqualValue(gen.getText(text2Tooltip), text2TooltipText);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (AssertionError e) {
			log.error("Failure! Values do not match!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}
}