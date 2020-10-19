package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.en.And;
import webApplication.testingFramework.base.TestContext;
import webApplication.testingFramework.pages.Elements;

public final class TextboxSteps {
	
	public static Logger log = LogManager.getLogger(UploadDownloadSteps.class.getName());
	private Elements elements = null;
	private TestContext testContext = null;
	
	public TextboxSteps(TestContext context)
	{		
		try {
			testContext = context;
			elements = testContext.pageObjectManager().elements();
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
			elements.hoverOnFullname();
			Thread.sleep(5);	
			elements.clickFullname();		
			elements.writeFullname();
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			log.error("Error while clicking choose a file!");
			throw t;
		}		
	}
}