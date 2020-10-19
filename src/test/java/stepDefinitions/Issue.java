package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Issue 
{
	public static WebDriver driver = null;

	public static void main(String[] args) 
	{
		long PAGE_LOAD_TIMEOUT = 20;
		long IMPLICIT_WAIT = 30;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(" https://www.brainyquote.com/authors");
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		String authorname = "Adam Smith";
		String tagname1 = "";

		List<WebElement> authors = driver.findElements(By.xpath("//span[text()='" + authorname + "']"));
		for (int i = 0; i < authors.size(); i++) 
		{			
			if (authors.get(i).getText().contains(authorname)) 
			{
				authors.get(i).click();
				List<WebElement> Quotecon = driver.findElements(By.xpath(
						"//a[contains(normalize-space(),'" + tagname1 + "')]//parent::div//parent::div//preceding-sibling::div//preceding-sibling::div//a[@title='view quote']"));
				System.out.println(Quotecon.size());
				int Quotecount = Quotecon.size() - 1;
				if (Quotecon.size() > 0) 
				{
					for (int j = 0; j <= Quotecount; j++) 
					{
						System.out.println(Quotecon.get(j).getText());
						System.out.println(tagname1);
					}
				} 
				else 
				{					
					List<WebElement> Quote1 = driver.findElements(By.xpath("//a[starts-with(@class,'b-qt qt_')]"));
					int Quotecount1 = Quote1.size() - 1;
					for (int k = 0; k <= Quotecount1; k++) 
					{
						System.out.println(Quote1.get(k).getText());
						List<WebElement> tags = driver.findElements(By.xpath("//div[@class='kw-box']"));
						List<WebElement> auth = driver.findElements(By.xpath("//a[@title='view author']"));
						List<WebElement> Quote = driver.findElements(By.xpath("//a[@title='view quote']"));
						List<WebElement> rows = driver.findElements(By.xpath("//div[contains(@class,'qll-bg')]"));
						int rowcount = rows.size();
						for (int l = 2; l <= rowcount; l++) 
						{
							String authname = auth.get(l).getText();
							String tagname = tags.get(l).getText();
							String quotename = Quote.get(i).getText();
							System.out.println("AuthorLinks" + "Quotes" + l + quotename);
							System.out.println("AuthorLinks" + "Authors" + l + authname);
							System.out.println("AuthorLinks" + "Tags" + l + tagname);
						}
					}
				}
			}
		}
		teardown();
	}

	public static void teardown() {
		driver.quit();
	}
}