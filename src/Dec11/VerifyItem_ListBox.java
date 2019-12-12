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
		Select element=new Select(drChrome.findElement(By.name("country")));

		//Select element=new Select(drChrome.findElement(By.id("")));

		List<WebElement>items=element.getOptions();
		System.out.println("no of items are : "+items.size());

		String expectCountry="ANGOLA ";

		for(int i=0; i<items.size();i++)
		{
			String itemList=items.get(i).getText();
			Thread.sleep(1000);
			System.out.println(itemList);

			//verify expectCountry is exist in itemlist or not??

			if(expectCountry.equalsIgnoreCase(itemList))
			{
				System.out.println("Country found in Item List...");
				Thread.sleep(5000);
				break;
			}
		}
		drChrome.close();
	}

}
