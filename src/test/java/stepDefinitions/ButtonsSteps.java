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
import webApplication.testingFramework.pages.elements.Buttons;
import webApplication.testingFramework.pages.elements.Elements;
import webApplication.testingFramework.reporting.ExtentReportHandler;

public final class ButtonsSteps
{
	public static Logger log = LogManager.getLogger(ButtonsSteps.class.getName());
	private TestContext testContext = null;
	private Buttons buttons = null;
	private Elements elements = null;
	private WebDriver driver = null;

	public ButtonsSteps(TestContext context)
	{		
		try {
			testContext = context;
			elements = testContext.pageObjectManager().elements();
			buttons = testContext.pageObjectManager().buttons();
			driver = testContext.driver();
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}
	}
	
	@When("^user clicks Buttons$")
	public void clickButtons() throws Throwable
	{		
		ExtentTest stepInfo = null;
		String stepName = StringUtility.getTitleCase("user clicks on Alerts Frames and Windows");
		stepInfo = ExtentReportHandler.createStepInfo("When", stepName);
		Thread.sleep(200);
		
		try {
			//hover on the element to be clicked
			elements.hoverOnButtons();
			Thread.sleep(10);
			elements.clickButtons();
			
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
	
	@Then("^Buttons page is displayed$")
	public void verifyButtons() throws Throwable
	{
		ExtentTest stepInfo = null;
		String stepName = StringUtility.getTitleCase("Buttons page is displayed");
		stepInfo = ExtentReportHandler.createStepInfo("When", stepName);
		
		try {					
			buttons.verifyButtonsHeader();
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
	
	@When("^user double cliks on button1$")
	public void doubleClick() throws Throwable {
		try {
			buttons.hoverOnDoubleClickButton();
			Thread.sleep(10);
			buttons.doubleClickButton();
			Thread.sleep(50);
		}
		catch(Throwable e) {
			e.printStackTrace();
			System.out.println("Error in doubleClick().");
			throw e;
		}
	}
	
	@Then("^double click message appears$")
	public void doubleMessage() throws Throwable {
		try {	
			buttons.verifyDoubleClickMessage();
			Thread.sleep(50);
		}
		catch(Throwable e) {
			e.printStackTrace();
			System.out.println("Error in doubleMessage().");
			throw e;
		}
	}
	
	@When("^user right clicks button2$")
	public void rightClick() throws Throwable {
		try {			
			buttons.hoverOnRightClickButton();
			Thread.sleep(10);
			buttons.rightClickButton();
			Thread.sleep(50);
		}
		catch(Throwable e) {
			e.printStackTrace();
			System.out.println("Error in rightClick().");
			throw e;
		}
	}
	
	@Then("^right click message appears$")
	public void rightMessage() throws Throwable {
		try {			
			buttons.verifyRightClickMessage();
			Thread.sleep(50);
		}
		catch(Throwable e) {
			e.printStackTrace();
			System.out.println("Error in rightMessage().");
			throw e;
		}
	}

	@When("^user clicks button3$")
	public void dynamicClick() throws Throwable {
		try {
			buttons.hoverOnDynamicClickButton();
			Thread.sleep(10);
			buttons.clickDynamicButton();
			Thread.sleep(50);
		}
		catch(Throwable e) {
			e.printStackTrace();
			System.out.println("Error in dynamicClick().");
			throw e;
		}
	}
	
	@Then("^dynamic click message appears$")
	public void dynamicMessage() throws Throwable {
		try {
			buttons.verifyDynamicClickMessage();
			Thread.sleep(50);
		}
		catch(Throwable e) {
			e.printStackTrace();
			System.out.println("Error in dynamicMessage().");
			throw e;
		}
	}
}