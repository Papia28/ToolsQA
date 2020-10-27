package webApplication.testingFramework.pages.elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import webApplication.testingFramework.base.GenericFunctions;
import webApplication.testingFramework.common.ActionFunctions;
import webApplication.testingFramework.common.AssertionsAndVerifications;
import webApplication.testingFramework.common.HttpFunctions;

public class BrokenLinksImages {

    private static final Logger log = LogManager.getLogger(BrokenLinksImages.class.getName());
    private WebDriver driver = null;
    private GenericFunctions gen = null;

    @FindBy(xpath = "//p[text()='Valid image']//following-sibling::img[1]")
    private WebElement validImage;

    @FindBy(xpath = "//p[text()='Broken image']//following-sibling::img")
    private WebElement brokenImage;

    @FindBy(how = How.CSS, using = "img")
    private WebElement image;

    @FindBy(linkText = "Click Here for Valid Link")
    private WebElement validLink;

    @FindBy(linkText = "Click Here for Broken Link")
    private WebElement brokenLink;

    public BrokenLinksImages(WebDriver driver){
        try{
            this.driver = driver;
            PageFactory.initElements(driver, this);
            gen = new GenericFunctions(this.driver);
        } catch (Throwable t) {
            log.fatal("Error in setting up Textbox constructor!", t.fillInStackTrace());
        }
    }

    public void hoverOnValidLink() throws Throwable {
        try {
            ActionFunctions.hoverOnElement(driver, validLink);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in locating element!", t.fillInStackTrace());
            throw t;
        }
    }

    public void verifyValidLink() throws Throwable {
        try {
            AssertionsAndVerifications.assertTrueValue(HttpFunctions.isURLValid(gen.getURL(validLink)));
            log.info("Link is valid!");
        } catch (AssertionError e) {
            log.error("Link is broken!", e.fillInStackTrace());
            throw e;
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in locating element!", t.fillInStackTrace());
            throw t;
        }
    }

    public void hoverOnBrokenLink() throws Throwable {
        try {
            ActionFunctions.hoverOnElement(driver, brokenLink);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in locating element!", t.fillInStackTrace());
            throw t;
        }
    }

    public void verifyBrokenLink() throws Throwable {
        try {
            AssertionsAndVerifications.assertFalseValue(HttpFunctions.isURLValid(gen.getURL(brokenLink)));
            log.info("Link is broken!");
        } catch (AssertionError e) {
            log.error("Link is not broken!", e.fillInStackTrace());
            throw e;
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in locating element!", t.fillInStackTrace());
            throw t;
        }
    }

    public void hoverOnValidImage() throws Throwable {
        try {
            ActionFunctions.hoverOnElement(driver, validImage);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in locating element!", t.fillInStackTrace());
            throw t;
        }
    }

    public void navigateToValidImageSrc() throws Throwable {
        try {
            String completeImgSrc = gen.getImageSrc(validImage);
			/*URL imgSrcUrl = new URL(completeImgSrc);
			AssertionsAndVerifications.assertTrueValue(HttpFunctions.isURLValid(imgSrcUrl));*/
            gen.navigateToUrl(completeImgSrc);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in verifyValidImage!", t.fillInStackTrace());
            throw t;
        }
    }

    public void verifyValidImage() throws Throwable {
        try {
            gen.verifyElementVisible(image);
            log.info("Success! Element found! Image is valid!");
        } catch (AssertionError e) {
            log.error("Image is broken!", e.fillInStackTrace());
            throw e;
        } catch (NoSuchElementException e) {
            log.error("Element not found! Image is broken!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in verifyValidImage!", t.fillInStackTrace());
            throw t;
        }
    }

    public void hoverOnBrokenImage() throws Throwable {
        try {
            ActionFunctions.hoverOnElement(driver, brokenImage);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in locating element!", t.fillInStackTrace());
            throw t;
        }
    }

    public void navigateToBrokenImageSrc() throws Throwable {
        try {
            String completeImgSrc = gen.getImageSrc(brokenImage);
			/*URL imgSrcUrl = new URL(completeImgSrc);
			AssertionsAndVerifications.assertTrueValue(HttpFunctions.isURLValid(imgSrcUrl));*/
            gen.navigateToUrl(completeImgSrc);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in verifyValidImage!", t.fillInStackTrace());
            throw t;
        }
    }

    public void verifyBrokenImage() throws Throwable {
        try {
            gen.verifyElementNotVisible(image);
            log.info("Element not found! Image is broken!");
        } catch (NoSuchElementException e) {
            log.info("Element not found! Image is broken!");
        } catch (AssertionError e) {
            log.info("Image is not broken!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in verifyValidImage!", t.fillInStackTrace());
            throw t;
        }
    }
}
