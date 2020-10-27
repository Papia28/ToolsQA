package stepDefinitions;

import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import webApplication.testingFramework.base.TestContext;
import webApplication.testingFramework.common.Screenshots;
import webApplication.testingFramework.common.StringUtility;
import webApplication.testingFramework.pages.HomePage;
import webApplication.testingFramework.pages.widgets.Tooltips;
import webApplication.testingFramework.pages.widgets.Widgets;
import webApplication.testingFramework.reporting.ExtentReportHandler;

public final class ToolTipsSteps {
	
	public static Logger log = LogManager.getLogger(ToolTipsSteps.class.getName());
	private TestContext testContext = null;
	private HomePage homePage = null;
	private Widgets widgets = null;
	private Tooltips tooltips = null;
	private WebDriver driver = null;

	public ToolTipsSteps(TestContext context) {
		try {
			testContext = context;
			homePage = testContext.pageObjectManager().homePage();
			widgets = testContext.pageObjectManager().widgets();
			tooltips = testContext.pageObjectManager().tooltips();
			driver = testContext.driver();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@When("^user clicks Widgets$")
	public void clickWidgets() throws Throwable {
		ExtentTest stepInfo = null;
		String stepName = StringUtility.getTitleCase("user clicks on Widgets");
		stepInfo = ExtentReportHandler.createStepInfo("When", stepName);
		Thread.sleep(200);

		try {
			// hover on the element to be clicked
			homePage.hoverOnWidgets();
			Thread.sleep(10);
			homePage.clickWidgets();

			// take screenshot of the element to be clicked
			stepInfo.addScreenCaptureFromPath(Screenshots.saveScreenshot(driver, "Widgets_Click"));

			Thread.sleep(50);

			// pass the step status
			ExtentReportHandler.testStepStatus("PASS", stepName, stepInfo, null);
		} catch (Throwable t) {
			t.printStackTrace();
			log.error("Error occurred clickAlerts()!");
			stepInfo.addScreenCaptureFromPath(Screenshots.saveScreenshot(driver, "AlertsFramesWindows_Click"));
			ExtentReportHandler.testStepStatus("FAIL", stepName, stepInfo, t);
			throw t;
		}
	}

	@Then("^widgets page displayed$")
	public void widgetsPage() throws Throwable {
		ExtentTest stepInfo = null;
		String stepName = StringUtility.getTitleCase("Alerts Frames and Windows page opens");
		stepInfo = ExtentReportHandler.createStepInfo("When", stepName);

		try {
			widgets.verifyWidgetsHeader();
			stepInfo.addScreenCaptureFromPath(Screenshots.saveScreenshot(driver, "AlertsFramesWindows_Page"));
		} catch (Throwable t) {
			t.printStackTrace();
			System.out.println("Error occurred!");
			stepInfo.addScreenCaptureFromPath(Screenshots.saveScreenshot(driver, "AlertsFramesWindows_Page"));
			ExtentReportHandler.testStepStatus("FAIL", "Alerts Frames and Windows page opens", stepInfo, t);
			throw t;
		}
	}

	@When("^user clicks Tooltips$")
	public void clickTooltips() throws Throwable {
		try {
			Thread.sleep(10);
			widgets.hoverOnTooltips();
			Thread.sleep(10);
			widgets.clickTooltips();
			Thread.sleep(50);
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Error in clickTooltips().");
			throw e;
		}
	}

	@Then("^tooltips page is displayed$")
	public void verifyTooltipPage() throws Throwable {
		try {
			tooltips.verifyTooltipHeader();
			Thread.sleep(50);
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Error in verifyTooltipPage().");
			throw e;
		}
	}

	@When("^user hovers on button$")
	public void hoverButton() throws Throwable {
		try {
			Thread.sleep(500);
			tooltips.hoverOnButton();
			Thread.sleep(1000);
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Error in hoverButton().");
			throw e;
		}
	}

	@Then("^button tooltip is displayed$")
	public void buttonTooltipDisplayed() throws Throwable {
		try {
			tooltips.verifyButtonTooltip();
			Thread.sleep(1000);
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Error in buttonTooltipDisplayed().");
			throw e;
		}
	}

	@When("^user hovers on textbox$")
	public void hoverTextbox() throws Throwable {
		try {
			tooltips.hoverOnTextbox();
			Thread.sleep(1000);
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Error in hoverTextbox().");
			throw e;
		}
	}

	@Then("^textbox tooltip is displayed$")
	public void textboxTooltipDisplayed() throws Throwable {
		try {
			tooltips.verifyTextboxTooltip();
			Thread.sleep(1000);
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Error in textboxTooltipDisplayed().");
			throw e;
		}
	}

	@When("^user hovers on text1$")
	public void hoverText1() throws Throwable {
		try {
			tooltips.hoverOnText1();
			Thread.sleep(1000);
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Error in hoverText1().");
			throw e;
		}
	}

	@Then("^text1 tooltip is displayed$")
	public void text1TooltipDisplayed() throws Throwable {
		try {
			tooltips.verifyText1Tooltip();
			Thread.sleep(1000);
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Error in text1TooltipDisplayed().");
			throw e;
		}
	}

	@When("^user hovers on text2$")
	public void hoverText2() throws Throwable {
		try {
			tooltips.hoverOnText2();
			Thread.sleep(1000);
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Error in hoverText2().");
			throw e;
		}
	}

	@Then("^text2 tooltip is displayed$")
	public void text2TooltipDisplayed() throws Throwable {
		try {
			tooltips.verifyText2Tooltip();
			Thread.sleep(1000);
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Error in text2TooltipDisplayed().");
			throw e;
		}
	}
}