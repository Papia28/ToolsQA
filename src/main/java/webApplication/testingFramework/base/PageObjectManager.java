package webApplication.testingFramework.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import webApplication.testingFramework.pages.AlertsFramesWindows;
import webApplication.testingFramework.pages.Bookstore;
import webApplication.testingFramework.pages.HomePage;
import webApplication.testingFramework.pages.elements.*;
import webApplication.testingFramework.pages.interactions.Droppable;
import webApplication.testingFramework.pages.interactions.Interactions;
import webApplication.testingFramework.pages.interactions.Resizable;
import webApplication.testingFramework.pages.widgets.SelectMenu;
import webApplication.testingFramework.pages.widgets.Tooltips;
import webApplication.testingFramework.pages.widgets.Widgets;

public class PageObjectManager 
{
	public static Logger log = LogManager.getLogger(PageObjectManager.class.getName());
	private WebDriver driver = null;
	private HomePage homePage = null;
	private Elements elements = null;
	private AlertsFramesWindows alertsFramesWindows = null;
	private Interactions interactions = null;
	private Widgets widgets = null;
	private Bookstore bookstore = null;
	private Textbox textbox = null;
	private BrokenLinksImages brokenLinksImages = null;
	private UploadDownload uploadDownload = null;
	private Tooltips tooltips = null;
	private SelectMenu selectMenu = null;
	private Buttons buttons = null;
	private Droppable droppable = null;
	private Resizable resizable = null;
	private WebTables webTables = null;
	
	public PageObjectManager(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public HomePage homePage() throws Throwable
	{
		try {
			if(homePage == null)
				homePage = new HomePage(driver);
			return homePage;
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in creating object of HomePage.");
			throw t;
		}
	}
	
	public Elements elements() throws Throwable
	{
		try {
			if(elements == null)
				elements = new Elements(driver);
			return elements;
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in creating object of Elements.");
			throw t;
		}
	}
	
	public AlertsFramesWindows alertsFramesWindows() throws Throwable
	{
		try {
			if(alertsFramesWindows == null)
				alertsFramesWindows = new AlertsFramesWindows(driver);
			return alertsFramesWindows;
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in creating object of AlertsFramesWindows.");
			throw t;
		}
	}
	
	public Interactions interactions() throws Throwable
	{
		try {
			if(interactions == null)
				interactions = new Interactions(driver);
			return interactions;
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in creating object of Interactions.");
			throw t;
		}
	}

	public Widgets widgets() throws Throwable
	{
		try {
			if(widgets == null)
				widgets = new Widgets(driver);
			return widgets;
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in creating object of Widgets.");
			throw t;
		}
	}

	public Bookstore bookstore() throws Throwable
	{
		try {
			if(bookstore == null)
				bookstore = new Bookstore(driver);
			return bookstore;
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error in creating object of Bookstore.");
			throw t;
		}
	}

	public Textbox textbox() throws Throwable {
		try {
			if (textbox == null)
				textbox = new Textbox(driver);
			return textbox;
		} catch (Throwable t) {
			log.error("Error in creating Textbox object!", t.fillInStackTrace());
			throw t;
		}
	}

	public BrokenLinksImages brokenLinksImages() throws Throwable {
		try {
			if (brokenLinksImages == null)
				brokenLinksImages = new BrokenLinksImages(driver);
			return brokenLinksImages;
		} catch (Throwable t) {
			log.error("Error in creating BrokenLinksImages object!", t.fillInStackTrace());
			throw t;
		}
	}

	public UploadDownload uploadDownload() throws Throwable {
		try {
			if (uploadDownload == null)
				uploadDownload = new UploadDownload(driver);
			return uploadDownload;
		} catch (Throwable t) {
			log.error("Error in creating UploadDownload object!", t.fillInStackTrace());
			throw t;
		}
	}

	public Tooltips tooltips() throws Throwable {
		try {
			if (tooltips == null)
				tooltips = new Tooltips(driver);
			return tooltips;
		} catch (Throwable t) {
			log.error("Error in creating Tooltips object!", t.fillInStackTrace());
			throw t;
		}
	}

	public SelectMenu selectMenu() throws Throwable {
		try {
			if (selectMenu == null)
				selectMenu = new SelectMenu(driver);
			return selectMenu;
		} catch (Throwable t) {
			log.error("Error in creating SelectMenu object!", t.fillInStackTrace());
			throw t;
		}
	}

	public Buttons buttons() throws Throwable {
		try {
			if (buttons == null)
				buttons = new Buttons(driver);
			return buttons;
		} catch (Throwable t) {
			log.error("Error in creating Buttons object!", t.fillInStackTrace());
			throw t;
		}
	}

	public Droppable droppable() throws Throwable {
		try {
			if (droppable == null)
				droppable = new Droppable(driver);
			return droppable;
		} catch (Throwable t) {
			log.error("Error in creating Droppable object!", t.fillInStackTrace());
			throw t;
		}
	}

	public Resizable resizable() throws Throwable {
		try {
			if (resizable == null)
				resizable = new Resizable(driver);
			return resizable;
		} catch (Throwable t) {
			log.error("Error in creating Resizable object!", t.fillInStackTrace());
			throw t;
		}
	}

	public WebTables webTables() throws Throwable {
		try {
			if (webTables == null)
				webTables = new WebTables(driver);
			return webTables;
		} catch (Throwable t) {
			log.error("Error in creating WebTables object!", t.fillInStackTrace());
			throw t;
		}
	}
}