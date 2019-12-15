package Dec12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtons {

	public static void main(String[] args) throws Throwable 
	{
		WebDriver drChrome=new ChromeDriver();
		drChrome.manage().window().maximize();

		drChrome.get("https://facebook.com/r.php");
		
		/*
		 * ANOTHER EX:
		drChrome.get("https://www.naukri.com");
		Thread.sleep(3000);
		drChrome.findElement(By.id("login_Layer")).click();
		Thread.sleep(3000);
		drChrome.findElement(By.xpath("//div[@class='row txtC']//a[contains(text(),'Register Now')]")).click();
		Thread.sleep(3000);
		drChrome.findElement(By.xpath("//button[contains(text(),'I am a Professional')]")).click();*/
		Thread.sleep(3000);
		
		List<WebElement>L=drChrome.findElements(By.tagName("input"));

		System.out.println("no of input tags : "+L.size());

		int nor=0;

		for(int i=0;i<L.size();i++)
		{
			String x=L.get(i).getAttribute("type");
			if(x.equals("radio"))
			{
				nor=nor+1;
			}
		}
		System.out.println("no of Radio Buttons : "+nor);
		drChrome.quit();
	}

}
