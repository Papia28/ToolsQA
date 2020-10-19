package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webApplication.testingFramework.base.TestContext;
import webApplication.testingFramework.common.JavascriptFunctions;
import webApplication.testingFramework.pages.Elements;
import webApplication.testingFramework.pages.HomePage;

public class UploadDownloadSteps {
	
	public static Logger log = LogManager.getLogger(UploadDownloadSteps.class.getName());
	private WebDriver driver = null;
	private HomePage homePage = null;
	private Elements elements = null;
	private TestContext testContext = null;
	
	public UploadDownloadSteps(TestContext context)
	{		
		try {
			testContext = context;
			homePage = testContext.pageObjectManager().homePage();
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
			elements = homePage.clickElements();
			Thread.sleep(50);
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error while clicking elements!");
			throw t;
		}		
	}
	
	@And("^user clicks on Upload and Download$")
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
	
	@And("^user clicks on choose a file$")
	public void chooseFile() throws Throwable
	{
		try {
			elements.hoverOnSelectFile();
			Thread.sleep(5);
			elements.clickSelectFile();
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
			elements.uploadFile();
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
			elements.isUploadedFileVisible();
			Thread.sleep(5);			
			elements.verifyUploadedFile(elements.getUploadedFileName());
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
