package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import webApplication.testingFramework.base.TestContext;
import webApplication.testingFramework.common.JavascriptFunctions;
import webApplication.testingFramework.pages.elements.BrokenLinksImages;
import webApplication.testingFramework.pages.elements.Elements;

public class BrokenLinksSteps {
	
	public static Logger log = LogManager.getLogger(BrokenLinksSteps.class.getName()); 
	private TestContext testContext = null;
	private Elements elements = null;
	private BrokenLinksImages brokenLinksImages = null;
	private WebDriver driver = null;	
	
	public BrokenLinksSteps(TestContext context)
	{		
		try {
			testContext = context;
			elements = testContext.pageObjectManager().elements();
			brokenLinksImages = testContext.pageObjectManager().brokenLinksImages();
			driver = testContext.driver();
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}
	}

	@When("^user clicks on Broken Links and Images$")
	public void clickBrokenLinksImages() throws Throwable {
		try {
			Thread.sleep(50);
			JavascriptFunctions.scrollToLast(driver);
			Thread.sleep(5);
			JavascriptFunctions.scrollUpByPixelValue(driver,300);
			Thread.sleep(5);
			elements.hoverOnBrokenLinksImages();
			Thread.sleep(5);
			elements.clickBrokenLinksImages();
			Thread.sleep(5);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error("Error in checking valid link!");
			throw t;
		}
	}
	
	@Then("^user verifies valid link$")
	public void verifyValidLink() throws Throwable {
		try {
			Thread.sleep(50);
			JavascriptFunctions.scrollDownByPixelValue(driver, 150);
			Thread.sleep(5);
			brokenLinksImages.hoverOnValidLink();
			Thread.sleep(5);
			brokenLinksImages.verifyValidLink();
			Thread.sleep(5);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error("Error in checking valid link!");
			throw t;
		}
	}

	@And("^user verifies broken link$")
	public void verifyBrokenLink() throws Throwable {
		try {
			Thread.sleep(50);
			brokenLinksImages.hoverOnBrokenLink();
			Thread.sleep(5);
			brokenLinksImages.verifyBrokenLink();
			Thread.sleep(5);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error("Error in checking broken link!");
			throw t;
		}
	}
}
