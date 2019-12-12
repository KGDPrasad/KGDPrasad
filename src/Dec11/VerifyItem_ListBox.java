package Dec11;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class VerifyItem_ListBox {

	public static void main(String[] args) throws Throwable 
	{
		WebDriver drChrome=new ChromeDriver();

		drChrome.navigate().to("http://www.newtours.demoaut.com/");
		//drChrome.navigate().to("https://www.amazon.in/");
		drChrome.manage().window().maximize();		

		drChrome.findElement(By.partialLinkText("REGI")).click();

		Select CountryElement=new Select(drChrome.findElement(By.name("country")));

		//Select element=new Select(drChrome.findElement(By.id("")));

		List<WebElement>allCountry=CountryElement.getOptions();
		System.out.println("no of Countries are : "+allCountry.size());

		String expectCountry="ANGOLA ";

		for(int i=0; i<allCountry.size();i++)
		{
			String itemInList=allCountry.get(i).getText();
			Thread.sleep(1000);
			System.out.println(i+1+". "+itemInList);

			//verify expectCountry is exist in All Country list or not??

			if(expectCountry.equalsIgnoreCase(itemInList))
			{
				System.out.println("Country found in List...");
				//Thread.sleep(5000);
				break;
			}
		}
		drChrome.close();

		// checking in another way using amazon site.

		WebDriver drChrome2=new ChromeDriver();
		drChrome2.navigate().to("https://www.amazon.in/");
		drChrome2.manage().window().maximize();		

		Select searchElement=new Select(drChrome2.findElement(By.id("searchDropdownBox")));

		List<WebElement>AllItems=searchElement.getOptions();
		System.out.println("no of items are : "+AllItems.size());

		String expectItem="books";

		for(int j=0;j<AllItems.size();j++)
		{
			String ItemInList=AllItems.get(j).getText();
			Thread.sleep(1000);
			System.out.println(j+1+". "+ItemInList);
			if(expectItem.equalsIgnoreCase(ItemInList))
			{
				System.out.println("Item found in List...");
				//Thread.sleep(5000);
				break;
			}
		}
		drChrome2.close();
	}

}
