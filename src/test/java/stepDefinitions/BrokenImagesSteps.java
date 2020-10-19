package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import webApplication.testingFramework.base.TestContext;
import webApplication.testingFramework.pages.Elements;

public final class BrokenImagesSteps 
{	
	public static Logger log = LogManager.getLogger(BrokenImagesSteps.class.getName()); 
	private TestContext testContext = null;
	private Elements elements = null;
	private WebDriver driver = null;
	
	public BrokenImagesSteps(TestContext context)
	{		
		try {
			testContext = context;
			elements = testContext.pageObjectManager().elements();
			driver = testContext.driver();
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}
	}

	@Then("^user verifies if image is valid$")
	public void validImagesVerify() throws Throwable {
		try {
			Thread.sleep(5);
			elements.hoverOnValidImage();
			Thread.sleep(5);
			elements.navigateToValidImageSrc();
			Thread.sleep(50);
			elements.verifyValidImage();
			Thread.sleep(5);
			elements.getGeneric().navigateBack();
			Thread.sleep(50);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error("Error in verifying valid image source!");
			throw t;
		}
	}

	@And("^user verifies if image is broken$")
	public void brokenImagesVerify() throws Throwable {
		try {
			Thread.sleep(5);
			elements.hoverOnBrokenImage();
			Thread.sleep(5);
			elements.navigateToBrokenImageSrc();
			Thread.sleep(50);
			elements.verifyBrokenImage();
			Thread.sleep(5);
			elements.getGeneric().navigateBack();
			Thread.sleep(50);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error("Error in verifying broken image source!");
			throw t;
		}
	}
}
