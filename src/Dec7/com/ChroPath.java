package Dec7.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChroPath 
{
	public static void main(String[] args) throws Throwable 
	{
		WebDriver drChrome=new ChromeDriver();
		drChrome.navigate().to("http://orangehrm.qedgetech.com/");
		drChrome.manage().window().maximize();
		Thread.sleep(2000);

		//drChrome.findElement(By.id("span[contains(text(),'Username')]")).sendKeys("Admin");
		drChrome.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		Thread.sleep(3000);

		//drChrome.findElement(By.id("txtPassword")).sendKeys("Qedge123!@#");
		drChrome.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Qedge123!@#");
		Thread.sleep(3000);

		//drChrome.findElement(By.id("btnLogin")).click();
		drChrome.findElement(By.xpath("//input[@id='btnLogin']")).click();

		if(drChrome.getCurrentUrl().contains("dshboard"))
		{
			System.out.println("Login Successful.");
		}
		else
		{
			//String msg=drChrome.findElement(By.id("spanMessage")).getText();
			String msg="FAIL";
			System.out.println("Login Failed... "+msg);	
		}
		drChrome.close();
	}
}
