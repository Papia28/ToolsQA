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
import webApplication.testingFramework.common.JDBC;
import webApplication.testingFramework.seleniumBase.ReadConfig;

public class Textbox {

    private static final Logger log = LogManager.getLogger(Textbox.class.getName());
    private WebDriver driver = null;
    private GenericFunctions gen = null;

    @FindBy(css = "input#userName")
    private WebElement fullname;

    public Textbox(WebDriver driver) throws Throwable{
        try{
            this.driver = driver;
            PageFactory.initElements(driver, this);
            gen = new GenericFunctions(this.driver);
        } catch (Throwable t) {
            log.fatal("Error in setting up Textbox constructor!", t.fillInStackTrace());
        }
    }

    public void hoverOnFullname() throws Throwable {
        try {
            ActionFunctions.hoverOnElement(driver, fullname);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in locating element!", t.fillInStackTrace());
            throw t;
        }
    }

    public void clickFullname() throws Throwable {
        try {
            gen.click(fullname);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in locating element!", t.fillInStackTrace());
            throw t;
        }
    }

    public void writeFullname() throws Throwable {
        try {
            String query = ReadConfig.getConfigKeyValue("query");
            JDBC.openConnection();
            Thread.sleep(500);
            gen.write(fullname, JDBC.getFullname(query));
            Thread.sleep(10);
            JDBC.closeConnection();
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in locating element!", t.fillInStackTrace());
            throw t;
        }
    }
}
