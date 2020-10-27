package webApplication.testingFramework.pages.elements;

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

public class Buttons {

    private static final Logger log = LogManager.getLogger(Buttons.class.getName());
    private WebDriver driver = null;
    private GenericFunctions gen = null;

    @FindBy(css = "div.main-header")
    private WebElement buttonsHeader;

    @FindBy(css = "button#doubleClickBtn")
    private WebElement doubleClick;

    @FindBy(css = "p#doubleClickMessage")
    private WebElement doubleClickMessage;

    @FindBy(css = "button#rightClickBtn")
    private WebElement rightClick;

    @FindBy(css = "p#rightClickMessage")
    private WebElement rightClickMessage;

    @FindBy(xpath = "//button[text()='Click Me']")
    private WebElement dynamicClick;

    @FindBy(css = "p#dynamicClickMessage")
    private WebElement dynamicClickMessage;



    public Buttons(WebDriver driver) throws Throwable{
        try{
            this.driver = driver;
            PageFactory.initElements(driver, this);
            gen = new GenericFunctions(this.driver);
        } catch (Throwable t) {
            log.fatal("Error in setting up Textbox constructor!", t.fillInStackTrace());
        }
    }

    public void verifyButtonsHeader() throws Throwable {
        try {
            gen.verifyElementVisible(buttonsHeader);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in verifyButtonHeader!", t.fillInStackTrace());
            throw t;
        }
    }

    public void hoverOnDoubleClickButton() throws Throwable {
        try {
            ActionFunctions.hoverOnElement(driver, doubleClick);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in hoverOnDoubleClickButton!", t.fillInStackTrace());
            throw t;
        }
    }

    public void doubleClickButton() throws Throwable {
        try {
            ActionFunctions.doubleClickElement(driver, doubleClick);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in doubleClickButton!", t.fillInStackTrace());
            throw t;
        }
    }

    public void verifyDoubleClickMessage() throws Throwable {
        try {
            gen.verifyElementVisible(doubleClickMessage);
            String message = gen.getText(doubleClickMessage);
            AssertionsAndVerifications.assertEqualValue(message, "You have done a double click");
            log.info("Message: " + message);
        } catch(AssertionError e) {
            e.printStackTrace();
            log.error("assertEqualValue(): Failure! Values do not match!");
            throw e;
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in verifyDoubleClickMessage!", t.fillInStackTrace());
            throw t;
        }
    }

    public void hoverOnRightClickButton() throws Throwable {
        try {
            ActionFunctions.hoverOnElement(driver, rightClick);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in hoverOnRightClickButton!", t.fillInStackTrace());
            throw t;
        }
    }

    public void rightClickButton() throws Throwable {
        try {
            ActionFunctions.rightClickElement(driver, rightClick);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in rightClickButton!", t.fillInStackTrace());
            throw t;
        }
    }

    public void verifyRightClickMessage() throws Throwable {
        try {
            gen.verifyElementVisible(rightClickMessage);
            String message = gen.getText(rightClickMessage);
            AssertionsAndVerifications.assertEqualValue(message, "You have done a right click");
            log.info("Message: " + message);
        } catch(AssertionError e) {
            e.printStackTrace();
            log.error("assertEqualValue(): Failure! Values do not match!");
            throw e;
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in verifyRightClickMessage!", t.fillInStackTrace());
            throw t;
        }
    }

    public void hoverOnDynamicClickButton() throws Throwable {
        try {
            ActionFunctions.hoverOnElement(driver, dynamicClick);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in hoverOnDynbamicClickButton!", t.fillInStackTrace());
            throw t;
        }
    }

    public void clickDynamicButton() throws Throwable {
        try {
            gen.click(dynamicClick);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in clickDynamicButton!", t.fillInStackTrace());
            throw t;
        }
    }

    public void verifyDynamicClickMessage() throws Throwable {
        try {
            gen.verifyElementVisible(dynamicClickMessage);
            String message = gen.getText(dynamicClickMessage);
            AssertionsAndVerifications.assertEqualValue(message, "You have done a dynamic click");
            log.info("Message: " + message);
        } catch(AssertionError e) {
            e.printStackTrace();
            log.error("assertEqualValue(): Failure! Values do not match!");
            throw e;
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in verifyDynamicClickMessage!", t.fillInStackTrace());
            throw t;
        }
    }
}
