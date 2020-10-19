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
import webApplication.testingFramework.common.Waits;

public class Bookstore {
	
	public static Logger log = LogManager.getLogger(Bookstore.class.getName());
	private WebDriver driver = null;
	private GenericFunctions gen = null;

	@FindBy(css = "button#login")
	private WebElement login1;

	@FindBy(css = "input#userName")
	private WebElement username;

	@FindBy(css = "input#password")
	private WebElement password;

	@FindBy(css = "button#login")
	private WebElement login2;

	@FindBy(css = "button#submit")
	private WebElement logout;

	public Bookstore(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		gen = new GenericFunctions(this.driver);
	}

	public void hoverOnLogin1() throws Throwable {
		try {
			ActionFunctions.hoverOnElement(driver, login1);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void clickLogin1() throws Throwable {
		try {
			gen.click(login1);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void hoverOnUsername() throws Throwable {
		try {
			ActionFunctions.hoverOnElement(driver, username);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void clickUsername() throws Throwable {
		try {
			gen.click(username);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void writeUsername(String s) throws Throwable {
		try {
			gen.write(username, s);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void hoverOnPassword() throws Throwable {
		try {
			ActionFunctions.hoverOnElement(driver, password);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void clickPassword() throws Throwable {
		try {
			gen.click(password);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void writePassword(String s) throws Throwable {
		try {
			gen.write(password, s);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void hoverOnLogin2() throws Throwable {
		try {
			ActionFunctions.hoverOnElement(driver, login2);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void clickLogin2() throws Throwable {
		try {
			gen.click(login2);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void hoverOnLogout() throws Throwable {
		try {
			Waits.explicitWaitByVisibility(driver, logout);
			ActionFunctions.hoverOnElement(driver, logout);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void isLogoutVisible() throws Throwable {
		try {
			gen.isElementVisible(logout);
		} catch (AssertionError e) {
			log.error("Failure! Value not true!", e.fillInStackTrace());
			throw e;
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}
}
