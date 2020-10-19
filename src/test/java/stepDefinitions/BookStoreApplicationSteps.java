package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webApplication.testingFramework.base.TestContext;
import webApplication.testingFramework.pages.Bookstore;
import webApplication.testingFramework.pages.HomePage;

public final class BookStoreApplicationSteps {
	
	public static Logger log = LogManager.getLogger(BookStoreApplicationSteps.class.getName());
	private TestContext testContext = null;
	private HomePage homePage = null;
	private Bookstore bookstore = null;

	public BookStoreApplicationSteps(TestContext context) {
		try {
			testContext = context;
			homePage = testContext.pageObjectManager().homePage();
		} catch (Throwable e) {
			log.error("Error in BookStoreApplicationSteps constructors!", e.fillInStackTrace());
		}
	}

	@Given("^application is launched$")
	public void launchApplication() throws Throwable {
		try {
			homePage.genericFunctions().maximizeBrowser();
			Thread.sleep(5);
			homePage.genericFunctions().launchBaseURL();
			Thread.sleep(50);
		} catch (Throwable e) {
			log.error("Error occurred: launchApplication()", e.fillInStackTrace());
			throw e;
		}
	}

	@When("^user clicks Book Store Application$")
	public void clickBookstore() throws Throwable {
		try {
			homePage.hoverOnBookstore();
			Thread.sleep(5);
			bookstore = homePage.clickBookstore();
			Thread.sleep(50);
		} catch (Throwable e) {
			log.error("Error occurred: clickBookstore()", e.fillInStackTrace());
			throw e;
		}
	}

	@And("^user clicks Login$")
	public void clickLogin() throws Throwable {
		try {
			bookstore.hoverOnLogin1();
			Thread.sleep(5);
			bookstore.clickLogin1();
			Thread.sleep(50);
		} catch (Throwable e) {
			log.error("Error occurred: clickLogin()", e.fillInStackTrace());
			throw e;
		}
	}

	@Then("^user provides \"(.*)\" and \"(.*)\"$")
	public void provideCredentials(String username, String password) throws Throwable {
		try {
			bookstore.hoverOnUsername();
			Thread.sleep(5);
			bookstore.clickUsername();
			Thread.sleep(5);
			bookstore.writeUsername(username);
			Thread.sleep(10);
			bookstore.hoverOnPassword();
			Thread.sleep(5);
			bookstore.clickPassword();
			Thread.sleep(5);
			bookstore.writePassword(password);
			Thread.sleep(50);
		} catch (Throwable e) {
			log.error("Error occurred: provideCredentials()", e.fillInStackTrace());
			throw e;
		}
	}

	@And("^user clicks Login again$")
	public void clickLoginAgain() throws Throwable {
		try {
			bookstore.hoverOnLogin2();
			Thread.sleep(5);
			bookstore.clickLogin2();
			Thread.sleep(50);
		} catch (Throwable e) {
			log.error("Error occurred: clickLoginAgain()", e.fillInStackTrace());
			throw e;
		}
	}

	@Then("^user successfully logs into Book Store$")
	public void verifyBookstore() throws Throwable {
		try {
			bookstore.hoverOnLogout();
			Thread.sleep(5);
			bookstore.isLogoutVisible();
			Thread.sleep(50);
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Error in clickLogin()");
		}
	}
}