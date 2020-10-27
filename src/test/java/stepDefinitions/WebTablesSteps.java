package stepDefinitions;

import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import webApplication.testingFramework.base.TestContext;
import webApplication.testingFramework.common.Screenshots;
import webApplication.testingFramework.common.StringUtility;
import webApplication.testingFramework.pages.elements.WebTables;
import webApplication.testingFramework.reporting.ExtentReportHandler;

public final class WebTablesSteps
{
	public static Logger log = LogManager.getLogger(WebTablesSteps.class.getName());
	private TestContext testContext = null;
	private WebTables webTables = null;
	private WebDriver driver = null;

	public WebTablesSteps(TestContext context)
	{		
		try {
			testContext = context;
			webTables = testContext.pageObjectManager().webTables();
			driver = testContext.driver();
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}
	}

	@Given("^SeleniumEasy Demo Application is launched$")
	public void launchWebTableApplication() throws Throwable {
		try {
			Thread.sleep(5);
			webTables.launchWebTablesURL();
			Thread.sleep(50);
		}
		catch(Throwable e) {
			e.printStackTrace();
			System.out.println("Error in doubleClick().");
			throw e;
		}
	}

	@When("^user enters given \"(.*)\" in searchbox$")
	public void retrieveGivenInfo(String position) throws Throwable
	{
		ExtentTest stepInfo = null;
		String stepName = StringUtility.getTitleCase("user clicks on Alerts Frames and Windows");
		stepInfo = ExtentReportHandler.createStepInfo("When", stepName);
		Thread.sleep(200);

		try {
			//hover on the element to be clicked
			webTables.hoverOnSearchBox();
			Thread.sleep(5);
			webTables.clickSearchBox();
			Thread.sleep(5);
			webTables.clearSearchBox();
			Thread.sleep(5);
			webTables.writeInSearchBox(position);
			//take screenshot of the element to be clicked
			stepInfo.addScreenCaptureFromPath(Screenshots.saveScreenshot(driver, "AlertsFramesWindows_Click"));

			Thread.sleep(50);

			//pass the step status
			ExtentReportHandler.testStepStatus("PASS", stepName, stepInfo, null);
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error occurred clickAlerts()!");
			stepInfo.addScreenCaptureFromPath(Screenshots.saveScreenshot(driver, "AlertsFramesWindows_Click"));
			ExtentReportHandler.testStepStatus("FAIL", stepName, stepInfo, t);
			throw t;
		}
	}

	@Then("^user finds information for given \"(.*)\"$")
	public void retrieveGivenInfo(int age) throws Throwable
	{
		ExtentTest stepInfo = null;
		String stepName = StringUtility.getTitleCase("user clicks on Alerts Frames and Windows");
		stepInfo = ExtentReportHandler.createStepInfo("When", stepName);
		Thread.sleep(200);

		try {
			//hover on the element to be clicked
			webTables.retrieveInformation(age);

			//take screenshot of the element to be clicked
			stepInfo.addScreenCaptureFromPath(Screenshots.saveScreenshot(driver, "AlertsFramesWindows_Click"));

			Thread.sleep(50);

			//pass the step status
			ExtentReportHandler.testStepStatus("PASS", stepName, stepInfo, null);
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error occurred clickAlerts()!");
			stepInfo.addScreenCaptureFromPath(Screenshots.saveScreenshot(driver, "AlertsFramesWindows_Click"));
			ExtentReportHandler.testStepStatus("FAIL", stepName, stepInfo, t);
			throw t;
		}
	}
	
	@Then("^user displays the information$")
	public void verifyButtons() throws Throwable
	{
		ExtentTest stepInfo = null;
		String stepName = StringUtility.getTitleCase("Buttons page is displayed");
		stepInfo = ExtentReportHandler.createStepInfo("When", stepName);
		
		try {					
			webTables.displayInformation();
			stepInfo.addScreenCaptureFromPath(Screenshots.saveScreenshot(driver, "Buttons_Page"));
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			System.out.println("Error occurred in verifyButtons()!");
			stepInfo.addScreenCaptureFromPath(Screenshots.saveScreenshot(driver, "AlertsFramesWindows_Page"));
			ExtentReportHandler.testStepStatus("FAIL", "Alerts Frames and Windows page opens", stepInfo, t);
			throw t;
		}
	}
}