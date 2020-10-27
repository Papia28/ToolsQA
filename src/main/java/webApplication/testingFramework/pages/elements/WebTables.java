package webApplication.testingFramework.pages.elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webApplication.testingFramework.base.GenericFunctions;
import webApplication.testingFramework.common.ActionFunctions;
import webApplication.testingFramework.common.JavascriptFunctions;
import webApplication.testingFramework.seleniumBase.ReadConfig;

import java.util.ArrayList;
import java.util.List;

public class WebTables {

    private static final Logger log = LogManager.getLogger(WebTables.class.getName());
    private WebDriver driver = null;
    private GenericFunctions gen = null;

    /*@FindBy(xpath = "//div[@class='main-header' and text()='Web Tables']")
    private WebElement webTablesHeader;

    @FindBy(css = "div.rt-table")
    private WebElement webTable;*/

    @FindBy(css = "input[type='search']")
    private WebElement searchBox;

    @FindBy(css = "thead tr")
    private WebElement webTableHeader;

    @FindBy(css = "tr th")
    private List<WebElement> webTableHeadings;

    @FindBy(css = "tbody tr")
    private List<WebElement> webTableRows;

    private String webTableColsLocator = "tbody tr td";

    @FindBy(css = "a#example_next")
    private WebElement nextButton;

    private int colNum = 0;
    private ArrayList<ArrayList<String>> dataArray = new ArrayList<ArrayList<String>> ();

    public WebTables(WebDriver driver) throws Throwable{
        try{
            this.driver = driver;
            PageFactory.initElements(driver, this);
            gen = new GenericFunctions(this.driver);
        } catch (Throwable t) {
            log.fatal("Error in setting up Textbox constructor!", t.fillInStackTrace());
        }
    }

    public void launchWebTablesURL() throws Throwable {
        try {
            gen.maximizeBrowser();
            gen.navigateToUrl(ReadConfig.getConfigKeyValue("WebTableURL"));
        } catch (Throwable t) {
            log.error("Error in launchWebTablesURL!", t.fillInStackTrace());
            throw t;
        }
    }

    public void hoverOnSearchBox() throws Throwable {
        try {
            ActionFunctions.hoverOnElement(driver, searchBox);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in hoverOnDoubleClickButton!", t.fillInStackTrace());
            throw t;
        }
    }

    public void clickSearchBox() throws Throwable {
        try {
            gen.click(searchBox);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in clickDynamicButton!", t.fillInStackTrace());
            throw t;
        }
    }

    public void clearSearchBox() throws Throwable {
        try {
            gen.clear(searchBox);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in clickDynamicButton!", t.fillInStackTrace());
            throw t;
        }
    }

    public void writeInSearchBox(String searchText) throws Throwable {
        try {
            gen.write(searchBox, searchText);
        } catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in clickDynamicButton!", t.fillInStackTrace());
            throw t;
        }
    }

    public void retrieveInformation(int requiredAge) throws Throwable {
        try {
            ArrayList<String> heading = new ArrayList<String> ();
            for (int i = 0; i < webTableHeadings.size(); i++) {
                heading.add(gen.getText(webTableHeadings.get(i)));
                Thread.sleep(50);
                if (heading.get(i).equalsIgnoreCase("Age")) {
                    colNum = i;
                }
            }

            dataArray.add(heading);

            for(int count =0; ; count++) {
                for (int i = 0; i < webTableRows.size(); i++)
                {
                    List<WebElement> webTableCols = gen.getElements(webTableRows.get(i), "cssselector", webTableColsLocator);
                    Thread.sleep(50);
                    JavascriptFunctions.scrollDownByPixelValue(driver, 30);
                    Thread.sleep(5);
                    ActionFunctions.hoverOnElement(driver, webTableCols.get(colNum));
                    Thread.sleep(5);
                    int age = Integer.parseInt(gen.getText(webTableCols.get(colNum)));
                    if (age >= requiredAge)
                    {
                        ArrayList<String> rows = new ArrayList<String> ();
                        for (int j = 0; j < webTableCols.size(); j++)
                        {
                            rows.add(gen.getText(webTableCols.get(j)));
                            Thread.sleep(5);
                        }
                        dataArray.add(rows);
                    }
                }
                Thread.sleep(5);
                JavascriptFunctions.scrollDownByPixelValue(driver, 200);
                Thread.sleep(5);
                ActionFunctions.hoverOnElement(driver, nextButton);
                if(gen.isElementClickableViaAttributes(nextButton, "class") == true)
                {
                    gen.click(nextButton);
                    JavascriptFunctions.scrollUpByPixelValue(driver, 300);
                    Thread.sleep(50);
                }
                else
                    break;
            }

        }catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in clickDynamicButton!", t.fillInStackTrace());
            throw t;
        }
    }

    public void displayInformation() throws Throwable {
        try {
            for(ArrayList<String> row : dataArray)
            {
                for (String col : row) {
                    System.out.print(col + "\t");
                    }
                System.out.println();
                }
            }catch (NoSuchElementException e) {
            log.error("Element not found!", e.fillInStackTrace());
            throw e;
        } catch (Throwable t) {
            log.error("Error in clickDynamicButton!", t.fillInStackTrace());
            throw t;
        }
    }
}
