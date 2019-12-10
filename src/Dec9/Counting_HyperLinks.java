package Dec9;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Counting_HyperLinks {

	public static void main(String[] args) 
	{

		WebDriver driverChrome=new ChromeDriver();

		//driverChrome.navigate().to("http://www.newtours.demoaut.com/");
		driverChrome.get("https://www.google.com/");
		driverChrome.manage().window().maximize();

		List<WebElement> HyperLinksAll=driverChrome.findElements(By.tagName("a"));

		System.out.println("Total number of Hyper Links are : "+HyperLinksAll.size());

		for(int i=0;i<HyperLinksAll.size();i++)
		{
			String HyperLinkName=HyperLinksAll.get(i).getText();
			String HyperLinkUrl=HyperLinksAll.get(i).getAttribute("href");

			System.out.println("Hyper Link Name : "+HyperLinkName +"\t\t\t"+"Hyper Link URL : "+HyperLinkUrl);
		}
		driverChrome.close();
	}

}
