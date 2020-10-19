package webApplication.testingFramework.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import webApplication.testingFramework.base.GenericFunctions;
import webApplication.testingFramework.common.*;

public class Elements {
	
	public static Logger log = LogManager.getLogger(GenericFunctions.class.getName());
	private WebDriver driver = null;
	private GenericFunctions gen = null;
	private String query = "select t.first_name, t.last_name from sakila.actor t where t.actor_id = 1";
	private String exeFilePath = "G:/AutoIt3/Scripts/FileUpload.exe";
	private String fileToUpload = "\"G:\\Study Materials\\Selenium\\Basics.txt\"";
	private String expectedFileName = null;
	private String baseURL = "https://demoqa.com/";

	@FindBy(xpath = "//span[text()='Text Box']")
	private WebElement textbox;

	@FindBy(css = "input#userName")
	private WebElement fullname;

	@FindBy(xpath = "//span[text()= 'Broken Links - Images']")
	private WebElement brokenLinksImages;

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

	// Here the choose a file button click is not working hence the label has been
	// clicked which works
	@FindBy(xpath = "//span[text()=\"Upload and Download\"]")
	private WebElement uploadAndDownload;

	@FindBy(css = "a#downloadButton")
	private WebElement download;

	@FindBy(xpath = "//label[text()='Select a file']")
	private WebElement selectFile;

	@FindBy(css = "p#uploadedFilePath")
	private WebElement uploadedFile;

	public Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		gen = new GenericFunctions(this.driver);
	}

	public GenericFunctions getGeneric() {
		return gen;
	}

	public String getQuery() {
		return query;
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


	public void clickTextbox() throws Throwable {
		try {
			gen.click(textbox);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
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

	public void hoverOnUploadAndDownload() throws Throwable {
		try {
			ActionFunctions.hoverOnElement(driver, uploadAndDownload);
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
			gen.click(uploadAndDownload);
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
	
	public void uploadFile() throws Throwable
	{
		try {
			expectedFileName = UploadDownloadFiles.uploadSampleFile(fileToUpload, exeFilePath);
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error while uploading file!");
			throw t;
		}		
	}
	
	public void isUploadedFileVisible() throws Throwable {
		try {
			Waits.explicitWaitByVisibility(driver, uploadedFile);
			gen.isElementVisible(uploadedFile);
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
			String actualFileName = gen.getText(uploadedFile).substring(index+1);
			return actualFileName;
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
		}catch (AssertionError e) {
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

	public void hoverOnBrokenLinksImages() throws Throwable {
		try {
			ActionFunctions.hoverOnElement(driver, brokenLinksImages);
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
			gen.click(brokenLinksImages);
		} catch (NoSuchElementException e) {
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} catch (Throwable t) {
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
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
		}catch (AssertionError e) {
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
		}catch (AssertionError e) {
			log.error("Link is not broken!", e.fillInStackTrace());
			throw e;
		}catch (NoSuchElementException e) {
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
			gen.isElementVisible(image);
			log.info("Success! Element found! Image is valid!");
		}catch (AssertionError e) {
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
			gen.isElementNotVisible(image);
			log.info("Element not found! Image is broken!");
		}catch (NoSuchElementException e) {
			log.info("Element not found! Image is broken!");
		}catch (AssertionError e) {
			log.info("Image is not broken!", e.fillInStackTrace());
			throw e;
		}  catch (Throwable t) {
			log.error("Error in verifyValidImage!", t.fillInStackTrace());
			throw t;
		}
	}
}