package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import webApplication.testingFramework.base.TestContext;
import webApplication.testingFramework.pages.widgets.SelectMenu;
import webApplication.testingFramework.pages.widgets.Widgets;

public final class SelectMenuSteps {

	public static Logger log = LogManager.getLogger(SelectMenuSteps.class.getName());
	private TestContext testContext = null;
	private Widgets widgets = null;
	private SelectMenu selectMenu = null;

	public SelectMenuSteps(TestContext context) {
		try {
			testContext = context;
			widgets = testContext.pageObjectManager().widgets();
			selectMenu = testContext.pageObjectManager().selectMenu();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@When("^user clicks Select Menu$")
	public void clickSelectMenuOption() throws Throwable {
		try {
			Thread.sleep(10);
			widgets.hoverOnSelectMenu();
			Thread.sleep(10);
			widgets.clickSelectMenu();
			Thread.sleep(50);
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Error in clickSelectMenuOption().");
			throw e;
		}
	}

	@Then("^select menu page is displayed$")
	public void verifySelectMenuPage() throws Throwable {
		try {
			selectMenu.verifySelectMenuHeader();
			Thread.sleep(50);
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Error in verifySelectMenuPage().");
			throw e;
		}
	}

	@When("^user selects from first dropdown$")
	public void selectFirstDropdownOption() throws Throwable {
		try {
			selectMenu.hoverOnDropdown1();
			Thread.sleep(5);
			selectMenu.clickDropdown1();
			Thread.sleep(5);
			selectMenu.selectDropdown1Option();
			Thread.sleep(50);
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Error in selectFirstDropdownOption().");
			throw e;
		}
	}

	@Then("^user verifies selected option is displayed$")
	public void verifyOptionSelected() throws Throwable {
		try {
			//TODO
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Error in verifyOptionSelected().");
			throw e;
		}
	}

	@When("^user selects from second dropdown$")
	public void selectSecondDropdownOption() throws Throwable {
		try {
			selectMenu.hoverOnDropdown2();
			Thread.sleep(5);
			selectMenu.clickDropdown2();
			Thread.sleep(5);
			selectMenu.selectDropdown2Option();
			Thread.sleep(50);
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Error in selectSecondDropdownOption().");
			throw e;
		}
	}

	@When("^user selects from third dropdown$")
	public void selectThirdDropdownOption() throws Throwable {
		try {
			selectMenu.hoverOnDropdown3();
			Thread.sleep(5);
			selectMenu.selectDropdown3Option();
			Thread.sleep(50);
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Error in selectThirdDropdownOption().");
			throw e;
		}
	}

	@When("^user selects from fourth dropdown$")
	public void selectFourthDropdownOption() throws Throwable {
		try {
			selectMenu.hoverOnDropdown4();
			Thread.sleep(5);
			selectMenu.clickDropdown4();
			Thread.sleep(5);
			selectMenu.selectDropdown4Options();
			Thread.sleep(50);
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Error in selectFourthDropdownOption().");
			throw e;
		}
	}

	@When("^user selects from fifth dropdown$")
	public void selectFifthDropdownOption() throws Throwable {
		try {
			selectMenu.hoverOnDropdown5();
			Thread.sleep(5);
			selectMenu.selectDropdown5Options();
			Thread.sleep(50);
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Error in selectFifthDropdownOption().");
			throw e;
		}
	}
}