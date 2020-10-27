package stepDefinitions;

import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import webApplication.testingFramework.base.TestContext;
import webApplication.testingFramework.pages.elements.Elements;
import webApplication.testingFramework.pages.elements.Textbox;

public final class TextboxSteps {
	
	public static Logger log = LogManager.getLogger(UploadDownloadSteps.class.getName());
	private Elements elements = null;
	private TestContext testContext = null;
	private Textbox textbox = null;
	
	public TextboxSteps(TestContext context)
	{		
		try {
			testContext = context;
			elements = testContext.pageObjectManager().elements();
			textbox = testContext.pageObjectManager().textbox();
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}
	}
	
	@And("^user clicks Textbox$")
	public void clickTextbox() throws Throwable
	{
		try {			
			elements.hoverOnTextbox();
			Thread.sleep(5);
			elements.clickTextbox();
			Thread.sleep(50);
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error while clicking upload and download!");
			throw t;
		}		
	}
	
	@And("^user writes fullname$")
	public void writeFullName() throws Throwable
	{
		try {
			textbox.hoverOnFullname();
			Thread.sleep(5);
			textbox.clickFullname();
			textbox.writeFullname();
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error while clicking choose a file!");
			throw t;
		}		
	}
}