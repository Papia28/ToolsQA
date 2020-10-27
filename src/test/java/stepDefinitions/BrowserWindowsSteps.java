package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webApplication.testingFramework.base.GenericFunctions;
import webApplication.testingFramework.base.TestContext;
import webApplication.testingFramework.common.JavascriptFunctions;
import webApplication.testingFramework.common.Screenshots;
import webApplication.testingFramework.common.StringUtility;
import webApplication.testingFramework.common.WindowHandler;
import webApplication.testingFramework.pages.AlertsFramesWindows;
import webApplication.testingFramework.pages.HomePage;
import webApplication.testingFramework.reporting.ExtentReportHandler;

public final class BrowserWindowsSteps 
{
	public static Logger log = LogManager.getLogger(BrowserWindowsSteps.class.getName());
	private TestContext testContext = null;
	private HomePage homePage = null;
	private AlertsFramesWindows alertsFramesWindows = null;
	private WebDriver driver = null;	
	private static String parent = null;
	private GenericFunctions gen = null;
	
	public BrowserWindowsSteps(TestContext context)
	{		
		try {
			testContext = context;
			homePage = testContext.pageObjectManager().homePage();
			driver = testContext.driver();
			gen = homePage.genericFunctions();
			alertsFramesWindows = testContext.pageObjectManager().alertsFramesWindows();
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}
	}
	
	@When("^user clicks on Alerts Frames and Windows$")
	public void clickAlerts() throws Throwable
	{		
		ExtentTest stepInfo = null;
		String stepName = StringUtility.getTitleCase("user clicks on Alerts Frames and Windows");
		stepInfo = ExtentReportHandler.createStepInfo("When", stepName);
		Thread.sleep(200);
		
		try {		
			JavascriptFunctions.scrollDownByPixelValue(driver, 300);
			
			//hover on the element to be clicked
			homePage.hoverOnAlerts();
			Thread.sleep(10);
			homePage.clickAlerts();
			
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
	
	@Then("^Alerts Frames and Windows page opens$")
	public void alertsFramesWindowsPage() throws Throwable
	{
		ExtentTest stepInfo = null;
		String stepName = StringUtility.getTitleCase("Alerts Frames and Windows page opens");
		stepInfo = ExtentReportHandler.createStepInfo("When", stepName);
		
		try {					
			//alertsFramesWindows.
			stepInfo.addScreenCaptureFromPath(Screenshots.saveScreenshot(driver, "AlertsFramesWindows_Page"));
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			System.out.println("Error occurred!");
			stepInfo.addScreenCaptureFromPath(Screenshots.saveScreenshot(driver, "AlertsFramesWindows_Page"));
			ExtentReportHandler.testStepStatus("FAIL", "Alerts Frames and Windows page opens", stepInfo, t);
			throw t;
		}
	}
	
	@Given("^user clicks Browser Windows$")
	public void clickBrowserWindows() throws Throwable {
		try {
			alertsFramesWindows.hoverOnBrowserWindows();
			Thread.sleep(10);
			alertsFramesWindows.clickBrowserWindows();
			Thread.sleep(50);
		}
		catch(Throwable e) {
			e.printStackTrace();
			System.out.println("Error in clickBrowserWindows().");
			throw e;
		}
	}
	
	@When("^user clicks New Tab$")
	public void clickNewTab() throws Throwable {
		try {	
			alertsFramesWindows.hoverOnNewTab();
			Thread.sleep(10);
			alertsFramesWindows.clickNewTab();
			Thread.sleep(50);
		}
		catch(Throwable e) {
			e.printStackTrace();
			System.out.println("Error in clickNewTab().");
			throw e;
		}
	}
	
	@When("^user clicks New Window$")
	public void clickNewWindow() throws Throwable {
		try {			
			alertsFramesWindows.hoverOnNewWindow();
			Thread.sleep(10);
			alertsFramesWindows.clickNewWindow();
			Thread.sleep(50);
		}
		catch(Throwable e) {
			e.printStackTrace();
			System.out.println("Error in clickNewWindow().");
			throw e;
		}
	}
	
	@When("^user clicks New Window Message$")
	public void clickNewWindowMessage() throws Throwable {
		try {			
			alertsFramesWindows.hoverOnNewMessageWindow();
			Thread.sleep(10);
			alertsFramesWindows.clickNewMessageWindow();
			Thread.sleep(50);
		}
		catch(Throwable e) {
			e.printStackTrace();
			System.out.println("Error in clickNewWindowMessage().");
			throw e;
		}
	}
	
	@Then("^new tab is opened$")
	@Then("^new window is opened$")
	public void tabWindowOpened() throws Throwable {
		try {
			parent = WindowHandler.getParentWindow(driver);
			WindowHandler.switchToWindowWithElement(driver, parent, alertsFramesWindows.getNewTabWindowTextElement());
			Thread.sleep(50);
		}
		catch(Throwable e) {
			e.printStackTrace();
			System.out.println("Error in tabWindowOpened().");
			throw e;
		}
	}
	
	@Then("^new message window is opened$")
	public void messageWindowOpened() throws Throwable {
		try {
			parent = WindowHandler.getParentWindow(driver);
			//TODO
			WindowHandler.switchUsingJavascriptElement(driver, parent);
			Thread.sleep(100);
		}
		catch(Throwable e) {
			e.printStackTrace();
			System.out.println("Error in messageWindowOpened().");
			throw e;
		}
	}
	
	@And("^user prints text in it$")
	public void printText() throws Throwable {
		try {
			log.info("Message in new tab/window: " + alertsFramesWindows.getNewTabWindowText());
			Thread.sleep(50);
		}
		catch(Throwable e) {
			e.printStackTrace();
			System.out.println("Error in printText().");
			throw e;
		}
	}
	
	@And("^user switches back to parent window$")
	public void switchToParent() throws Throwable {
		try {
			gen.closeCurrentWindow();
			WindowHandler.switchToWindow(driver, parent);
			Thread.sleep(50);
		}
		catch(Throwable e) {
			e.printStackTrace();
			System.out.println("Error in switchToParent().");
			throw e;
		}
	}
}