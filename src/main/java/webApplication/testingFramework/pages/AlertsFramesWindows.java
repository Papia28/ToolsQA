package webApplication.testingFramework.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webApplication.testingFramework.base.GenericFunctions;
import webApplication.testingFramework.common.ActionFunctions;

public class AlertsFramesWindows 
{	
	public static Logger log = LogManager.getLogger(GenericFunctions.class.getName());
	private WebDriver driver = null;
	private GenericFunctions gen = null;
	
	@FindBy(xpath="//span[text()='Browser Windows']")
	private WebElement browserWindows; 
	
	@FindBy(css="button#tabButton")
	private WebElement newTab;
	
	@FindBy(css="button#windowButton")
	private WebElement newWindow;
	
	@FindBy(css="h1#sampleHeading")
	private WebElement newTabText;
	
	@FindBy(css="button#messageWindowButton")
	private WebElement newMessageWindow;	
	
	@FindBy(xpath="//*[starts-with(text(), 'Knowledge')]")
	private WebElement NewMessageWindowText;	
	
	public AlertsFramesWindows(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,  this);
		gen = new GenericFunctions(this.driver);
	}
	
	public void hoverOnBrowserWindows() throws Throwable
	{
		try {
			ActionFunctions.hoverOnElement(driver, browserWindows);
		}
		catch(NoSuchElementException e)
		{
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		}
		catch(Throwable t)
		{
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}
	
	public void clickBrowserWindows() throws Throwable
	{
		try {			
			gen.click(browserWindows);		
		}
		catch(NoSuchElementException e)
		{
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		}
		catch(Throwable t)
		{
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}
	
	public void hoverOnNewTab() throws Throwable
	{
		try {
			ActionFunctions.hoverOnElement(driver, newTab);
		}
		catch(NoSuchElementException e)
		{
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		}
		catch(Throwable t)
		{
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}
	
	public void clickNewTab() throws Throwable
	{
		try {
			gen.click(newTab);
			Thread.sleep(10);			
		}
		catch(NoSuchElementException e)
		{
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		}
		catch(Throwable t)
		{
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}
	
	public WebElement getNewTabWindowTextElement()throws Throwable
	{
		try {				
			return newTabText;
		}
		catch(NoSuchElementException e)
		{
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		}
		catch(Throwable t)
		{
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}
	
	public String getNewTabWindowText() throws Throwable
	{
		try {				
			return gen.getText(getNewTabWindowTextElement());
		}
		catch(NoSuchElementException e)
		{
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		}
		catch(Throwable t)
		{
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}
	
	public void hoverOnNewWindow() throws Throwable
	{
		try {
			ActionFunctions.hoverOnElement(driver, newWindow);
		}
		catch(NoSuchElementException e)
		{
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		}
		catch(Throwable t)
		{
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}
	
	public void clickNewWindow() throws Throwable
	{
		try {
			gen.click(newWindow);		
		}
		catch(NoSuchElementException e)
		{
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		}
		catch(Throwable t)
		{
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}
	
	public void hoverOnNewMessageWindow() throws Throwable
	{
		try {
			ActionFunctions.hoverOnElement(driver, newMessageWindow);
		}
		catch(NoSuchElementException e)
		{
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		}
		catch(Throwable t)
		{
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}
	
	public void clickNewMessageWindow() throws Throwable
	{
		try {
			gen.click(newMessageWindow);	
		}
		catch(NoSuchElementException e)
		{
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		}
		catch(Throwable t)
		{
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}
}
