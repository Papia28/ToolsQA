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

public class HomePage 
{	
	public static Logger log = LogManager.getLogger(HomePage.class.getName());
	private WebDriver driver = null;
	private GenericFunctions gen = null;
	
	@FindBy(xpath="//h5[text()= 'Elements']//ancestor::div[2]")
	private WebElement elements; 
	
	@FindBy(xpath="//h5[starts-with(text(),'Alerts')]//ancestor::div[2]")
	private WebElement alerts;
	
	@FindBy(xpath="//h5[text()= 'Interactions']//ancestor::div[2]")
	private WebElement interactions;
	
	@FindBy(xpath="//h5[text()= 'Forms']//ancestor::div[2]")
	private WebElement forms; 
	
	@FindBy(xpath="//h5[text() = 'Widgets']//ancestor::div[2]")
	private WebElement widgets;
	
	@FindBy(xpath="//h5[starts-with(text(), 'Book')]//ancestor::div[2]")
	private WebElement bookStore;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,  this);
		gen = new GenericFunctions(this.driver);
	}
	
	public GenericFunctions genericFunctions()
	{
		return gen;
	}
	
	public void hoverOnElements()throws Throwable
	{
		try {
			ActionFunctions.hoverOnElement(driver, elements);
		}
		catch (NoSuchElementException e) 
		{
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} 
		catch (Throwable t) 
		{
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}
	
	public Elements clickElements() throws Throwable
	{
		try {
			gen.click(elements);
			return new Elements(driver);
		} 
		catch (NoSuchElementException e) 
		{
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} 
		catch (Throwable t) 
		{
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}
	
	public void hoverOnAlerts()throws Throwable
	{
		try {
			ActionFunctions.hoverOnElement(driver, alerts);
		}
		catch (NoSuchElementException e) 
		{
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} 
		catch (Throwable t) 
		{
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}
	
	public AlertsFramesWindows clickAlerts() throws Throwable
	{
		try {			
			gen.click(alerts);
			return new AlertsFramesWindows(driver);
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
	
	public void hoverOnWidgets()throws Throwable
	{
		try {
			ActionFunctions.hoverOnElement(driver, widgets);
		}
		catch (NoSuchElementException e) 
		{
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} 
		catch (Throwable t) 
		{
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}
	
	public Widgets clickWidgets() throws Throwable
	{
		try {			
			gen.click(widgets);	
			return new Widgets(driver);
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
	
	public void hoverOnInteractions()throws Throwable
	{
		try {
			ActionFunctions.hoverOnElement(driver, interactions);
		}
		catch (NoSuchElementException e) 
		{
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} 
		catch (Throwable t) 
		{
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}
	
	public Interactions clickInteractions() throws Throwable
	{
		try {			
			gen.click(interactions);	
			return new Interactions(driver);
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
	
	public void hoverOnBookstore()throws Throwable
	{
		try {
			ActionFunctions.hoverOnElement(driver, bookStore);
		}
		catch (NoSuchElementException e) 
		{
			log.error("Element not found!", e.fillInStackTrace());
			throw e;
		} 
		catch (Throwable t) 
		{
			log.error("Error in locating element!", t.fillInStackTrace());
			throw t;
		}
	}
	
	public Bookstore clickBookstore() throws Throwable
	{
		try {			
			gen.click(bookStore);	
			return new Bookstore(driver);
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
