package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import webApplication.testingFramework.base.TestContext;
import webApplication.testingFramework.common.JavascriptFunctions;
import webApplication.testingFramework.pages.HomePage;
import webApplication.testingFramework.pages.elements.Elements;
import webApplication.testingFramework.pages.elements.UploadDownload;

public class UploadDownloadSteps {
	
	public static Logger log = LogManager.getLogger(UploadDownloadSteps.class.getName());
	private WebDriver driver = null;
	private HomePage homePage = null;
	private Elements elements = null;
	private TestContext testContext = null;
	private UploadDownload uploadDownload = null;
	
	public UploadDownloadSteps(TestContext context)
	{		
		try {
			testContext = context;
			homePage = testContext.pageObjectManager().homePage();
			elements = testContext.pageObjectManager().elements();
			uploadDownload = testContext.pageObjectManager().uploadDownload();
					driver = testContext.driver();
		} 
		catch (Throwable e) 
		{
			log.error("Error while clicking elements!", e.fillInStackTrace());
		}
	}
	
	@When("^user clicks Elements$")
	public void clickElements() throws Throwable
	{
		try {			
			JavascriptFunctions.scrollDownByPixelValue(driver, 300);
			homePage.hoverOnElements();
			Thread.sleep(10);
			homePage.clickElements();
			Thread.sleep(50);
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error while clicking elements!");
			throw t;
		}		
	}
	
	@When("^user clicks on Upload and Download$")
	public void clickUploadDownload() throws Throwable
	{
		try {
			Thread.sleep(50);
			JavascriptFunctions.scrollToLast(driver);
			Thread.sleep(50);
			JavascriptFunctions.scrollUpByPixelValue(driver, 300);
			Thread.sleep(50);
			elements.hoverOnUploadAndDownload();
			Thread.sleep(5);
			elements.clickUploadAndDownload();
			Thread.sleep(50);
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error while clicking upload and download!");
			throw t;
		}		
	}

	@And("^user clicks on download button$")
	public void clickDownload() throws Throwable
	{
		try {
			uploadDownload.hoverOnDownload();
			Thread.sleep(5);
			uploadDownload.clickDownload();
			Thread.sleep(50);
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error while clicking choose a file!");
			throw t;
		}
	}

	@Then("^file is downloaded successfully$")
	public void verifyDownload() throws Throwable
	{
		try {
			uploadDownload.verifyDownloadedFile();
			Thread.sleep(50);
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error while clicking choose a file!");
			throw t;
		}
	}
	
	@When("^user clicks on choose a file$")
	public void chooseFile() throws Throwable
	{
		try {
			uploadDownload.hoverOnSelectFile();
			Thread.sleep(5);
			uploadDownload.clickSelectFile();
			Thread.sleep(2000);
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error while clicking choose a file!");
			throw t;
		}		
	}
	
	@And("^user uploads a file$")
	public void uploadFile() throws Throwable
	{
		try {
			uploadDownload.uploadFile();
			Thread.sleep(50);
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error while uploading file!");
			throw t;
		}		
	}
	
	@Then("^chosen file is uploaded$")
	public void verifyFileUpload() throws Throwable
	{
		try {
			uploadDownload.isUploadedFileVisible();
			Thread.sleep(5);
			uploadDownload.verifyUploadedFile(uploadDownload.getUploadedFileName());
			Thread.sleep(50);
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error while verifying file upload!");
			throw t;
		}		
	}

}
