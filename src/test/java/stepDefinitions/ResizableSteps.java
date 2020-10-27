package stepDefinitions;

import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import webApplication.testingFramework.base.TestContext;
import webApplication.testingFramework.common.Screenshots;
import webApplication.testingFramework.common.StringUtility;
import webApplication.testingFramework.pages.interactions.Interactions;
import webApplication.testingFramework.pages.interactions.Resizable;
import webApplication.testingFramework.reporting.ExtentReportHandler;

public final class ResizableSteps {

	private WebDriver driver = null;
	public static Logger log = LogManager.getLogger(ResizableSteps.class.getName());
	private TestContext testContext = null;
	private Resizable resizable = null;
	private Interactions interactions = null;

	public ResizableSteps(TestContext context) {
		try {
			testContext = context;
			interactions = testContext.pageObjectManager().interactions();
			resizable = testContext.pageObjectManager().resizable();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@When("^user selects Resizable$")
	public void clickInteractions() throws Throwable {
		
		ExtentTest stepInfo = null;
		String stepName = StringUtility.getTitleCase("user clicks Interactions");
		try {
			stepInfo = ExtentReportHandler.createStepInfo("When", stepName);
			Thread.sleep(200);

			// hover on the element to be clicked
			interactions.hoverOnResizable();
			interactions.clickResizable();

			// take screenshot of the element to be clicked
			//stepInfo.addScreenCaptureFromPath(Screenshots.saveScreenshot(driver, "Interactions_Click"));
			Thread.sleep(50);

			// pass the step status
			ExtentReportHandler.testStepStatus("PASS", stepName, stepInfo, null);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error("Error occurred clickInteractions()!");
			stepInfo.addScreenCaptureFromPath(Screenshots.saveScreenshot(driver, "Interactions_Click"));
			ExtentReportHandler.testStepStatus("FAIL", stepName, stepInfo, t);
			throw t;
		}
	}

	@Then("^Resizable page is displayed$")
	public void resizablePage() throws Throwable {
		
		ExtentTest stepInfo = null;
		try {
			stepInfo = ExtentReportHandler.createStepInfo("When", "Interactions page opens");
			resizable.verifyResizableHeader();
			// take screenshot of the element to be clicked
			//stepInfo.addScreenCaptureFromPath(Screenshots.saveScreenshot(driver, "Interactions_Page"));
		} catch (Throwable t) {
			t.printStackTrace();
			System.out.println("Error occurred!");
			stepInfo.addScreenCaptureFromPath(Screenshots.saveScreenshot(driver, "Interactions_Page"));
			ExtentReportHandler.testStepStatus("FAIL", "user clicks Interactions", stepInfo, t);
			throw t;
		}
	}

	@And("^user drags and resizes item1$")
	public void resizeItem1() throws Throwable {
		try {
			Thread.sleep(5);
			resizable.hoverOnResizable1();
			Thread.sleep(5);
			resizable.clickDragResizable1();
			Thread.sleep(50);
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Error in selectDragDrop().");
			throw e;
		}
	}

	@And("^user drags and resizes item2$")
	public void resizeItem2() throws Throwable {
		try {
			Thread.sleep(5);
			resizable.hoverOnResizable2();
			Thread.sleep(5);
			resizable.clickDragResizable2();
			Thread.sleep(50);
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Error in selectDragDrop().");
			throw e;
		}
	}
}