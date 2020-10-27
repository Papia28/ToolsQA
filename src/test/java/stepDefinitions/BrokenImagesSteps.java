package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import webApplication.testingFramework.base.TestContext;
import webApplication.testingFramework.pages.elements.BrokenLinksImages;
import webApplication.testingFramework.pages.elements.Elements;

public final class BrokenImagesSteps 
{	
	public static Logger log = LogManager.getLogger(BrokenImagesSteps.class.getName()); 
	private TestContext testContext = null;
	private Elements elements = null;
	private BrokenLinksImages brokenLinksImages = null;
	
	public BrokenImagesSteps(TestContext context)
	{		
		try {
			testContext = context;
			elements = testContext.pageObjectManager().elements();
			brokenLinksImages = testContext.pageObjectManager().brokenLinksImages();
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
			brokenLinksImages.hoverOnValidImage();
			Thread.sleep(5);
			brokenLinksImages.navigateToValidImageSrc();
			Thread.sleep(50);
			brokenLinksImages.verifyValidImage();
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
			brokenLinksImages.hoverOnBrokenImage();
			Thread.sleep(5);
			brokenLinksImages.navigateToBrokenImageSrc();
			Thread.sleep(50);
			brokenLinksImages.verifyBrokenImage();
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
