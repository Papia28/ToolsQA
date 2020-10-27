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
import webApplication.testingFramework.common.JavascriptFunctions;

public class Elements {

    private static Logger log = LogManager.getLogger(GenericFunctions.class.getName());
    private WebDriver driver = null;
    private GenericFunctions gen = null;

    @FindBy(css = "div.main-header")
    private WebElement elementsHeader;

	@FindBy(xpath = "//span[text()='Text Box']")
	private WebElement elemTextbox;

    @FindBy(xpath = "//span[text()= 'Broken Links - Images']")
    private WebElement elemBrokenLinksImages;

    // Here the choose a file button click is not working hence the label has been
    // clicked which works
    @FindBy(xpath = "//span[text()=\"Upload and Download\"]")
    private WebElement elemUploadAndDownload;

    @FindBy(xpath = "//span[text()='Buttons']")
    private WebElement buttons;

    public Elements(WebDriver driver) throws Throwable {
        try {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            this.gen = new GenericFunctions(this.driver);
        } catch (Throwable t) {
            log.fatal("Error in setting up Elements constructor!", t.fillInStackTrace());
        }
    }

    public GenericFunctions getGeneric() {
        return this.gen;
    }

    public void verifyElementsHeader() throws Throwable {
        try {
            gen.verifyElementVisible(elementsHeader);
            AssertionsAndVerifications.assertEqualValue(gen.getText(elementsHeader), "Elements");
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

	public void hoverOnTextbox() throws Throwable {
		try {
			ActionFunctions.hoverOnElement(driver, elemTextbox);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

	public void clickTextbox() throws Throwable {
		try {
			gen.click(elemTextbox);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}

    public void hoverOnUploadAndDownload() throws Throwable {
        try {
            ActionFunctions.hoverOnElement(driver, elemUploadAndDownload);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in locating element!", t.fillInStackTrace());
            throw t;
        }
    }

    public void clickUploadAndDownload() throws Throwable {
        try {
            gen.click(elemUploadAndDownload);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in locating element!", t.fillInStackTrace());
            throw t;
        }
    }

    public void hoverOnBrokenLinksImages() throws Throwable {
        try {
            ActionFunctions.hoverOnElement(driver, elemBrokenLinksImages);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in locating element!", t.fillInStackTrace());
            throw t;
        }
    }

    public void clickBrokenLinksImages() throws Throwable {
        try {
            gen.click(elemBrokenLinksImages);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in locating element!", t.fillInStackTrace());
            throw t;
        }
    }

    public void hoverOnButtons() throws Throwable {
        try {
            JavascriptFunctions.scrollDownByPixelValue(driver, 300);
            ActionFunctions.hoverOnElement(driver, buttons);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in locating element!", t.fillInStackTrace());
            throw t;
        }
    }

    public void clickButtons() throws Throwable {
        try {
            gen.click(buttons);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in locating element!", t.fillInStackTrace());
            throw t;
        }
    }
}