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
import webApplication.testingFramework.common.UploadDownloadFiles;
import webApplication.testingFramework.common.Waits;
import webApplication.testingFramework.seleniumBase.ReadConfig;

public class UploadDownload {

    private static Logger log = LogManager.getLogger(UploadDownload.class.getName());
    private WebDriver driver = null;
    private GenericFunctions gen = null;
    //private String fileToUpload = "\"G:\\Study Materials\\Selenium\\Basics.txt\"";
    private String expectedFileName = null;

    // Here the choose a file button click is not working hence the label has been
    // clicked which works

    @FindBy(css = "a#downloadButton")
    private WebElement download;

    @FindBy(xpath = "//label[text()='Select a file']")
    private WebElement selectFile;

    @FindBy(css = "p#uploadedFilePath")
    private WebElement uploadedFile;

    public UploadDownload(WebDriver driver) throws Throwable {
        try {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            gen = new GenericFunctions(this.driver);
        } catch (Throwable t) {
            log.fatal("Error in setting up UploadDownload constructor!", t.fillInStackTrace());
        }
    }

    public GenericFunctions getGeneric() {
        return gen;
    }

    public void hoverOnDownload() throws Throwable {
        try {
            ActionFunctions.hoverOnElement(driver, download);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in locating element!", t.fillInStackTrace());
            throw t;
        }
    }

    public void clickDownload() throws Throwable {
        try {
            gen.click(download);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in locating element!", t.fillInStackTrace());
            throw t;
        }
    }

    public void verifyDownloadedFile() throws Throwable {
        try {
            //TODO
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in locating element!", t.fillInStackTrace());
            throw t;
        }
    }

    public void hoverOnSelectFile() throws Throwable {
        try {
            ActionFunctions.hoverOnElement(driver, selectFile);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in locating element!", t.fillInStackTrace());
            throw t;
        }
    }

    public void clickSelectFile() throws Throwable {
        try {
            gen.click(selectFile);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in locating element!", t.fillInStackTrace());
            throw t;
        }
    }

    public void uploadFile() throws Throwable {
        try {
            String exeFilePath = ReadConfig.getConfigKeyValue("scriptPath");
            String fileToUpload = ReadConfig.getConfigKeyValue("fileToUpload");
            expectedFileName = UploadDownloadFiles.uploadSampleFile(fileToUpload, exeFilePath);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error("Error while uploading file!");
            throw t;
        }
    }

    public void isUploadedFileVisible() throws Throwable {
        try {
            Waits.explicitWaitByVisibility(driver, uploadedFile);
            gen.verifyElementVisible(uploadedFile);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (AssertionError e) {
            e.printStackTrace();
            log.error("Failure! " + uploadedFile + " is not visible!");
            throw e;
        } catch (Throwable t) {
            log.error("Error isUploadedFileVisible!", t.fillInStackTrace());
            throw t;
        }
    }

    public String getUploadedFileName() throws Throwable {
        try {
            int index = gen.getText(uploadedFile).lastIndexOf('\\');
            return gen.getText(uploadedFile).substring(index + 1);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in locating element!", t.fillInStackTrace());
            throw t;
        }
    }

    public void verifyUploadedFile(String actualFileName) throws Throwable {
        try {
            AssertionsAndVerifications.assertEqualValue(actualFileName, expectedFileName);
        } catch (AssertionError e) {
            e.printStackTrace();
            log.error("Failure! values do not match!");
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