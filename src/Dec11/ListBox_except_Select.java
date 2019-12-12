package Dec11;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListBox_except_Select {

	public static void main(String[] args) throws Throwable 
	{
		WebDriver drChrome=new ChromeDriver();
		drChrome.navigate().to("https://www.cleartrip.com/");
		drChrome.manage().window().maximize();

		String ExpectCity="hyderabad";
		String CityFound="N";

		Thread.sleep(2000);
		drChrome.findElement(By.id("FromTag")).sendKeys("hyd");
		Thread.sleep(9000);

		List<WebElement> CityList=drChrome.findElements(By.xpath("/html[1]/body[1]/ul[1]/li/a"));
		System.out.println("no of Cityies in List are : "+CityList.size());

		for(int i=0;i<CityList.size();i++)
		{
			String CityName=CityList.get(i).getText();
			System.out.println(i+1+". "+"City name in List : "+CityName);

			//if(ExpectCity.toUpperCase().contains(CityName.toUpperCase()))
			if(CityName.toUpperCase().contains(ExpectCity.toUpperCase()))
			{
				CityFound="Y";				
				//System.out.println("City found in Item List...1");
				//Thread.sleep(5000);
				//break;				
			}			
		}

		if(CityFound=="Y")
		{
			System.out.println("City found in Item List...");
		}
		else 
		{
			System.out.println("City not found in Item List...");
		}

		drChrome.quit();
	}

}
