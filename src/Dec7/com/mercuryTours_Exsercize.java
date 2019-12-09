package Dec7.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class mercuryTours_Exsercize {

	public static void main(String[] args) throws Throwable 
	{
		WebDriver drChrome=new ChromeDriver();

		drChrome.navigate().to("http://www.newtours.demoaut.com/");
		drChrome.manage().window().maximize();
		Thread.sleep(5000);

		//drChrome.findElement(By.xpath("REGISTER")).click();
		drChrome.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();
		Thread.sleep(3000);

		drChrome.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Durga");
		Thread.sleep(2000);

		drChrome.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Prasad");
		Thread.sleep(2000);

		drChrome.findElement(By.xpath("//input[@name='phone']")).sendKeys("9158766779");
		Thread.sleep(2000);

		drChrome.findElement(By.xpath("//input[@id='userName']")).sendKeys("kprasad369@gmail.com");
		Thread.sleep(2000);

		drChrome.findElement(By.xpath("//input[@name='address1']")).sendKeys("Flat No: 203, Plot No: 507, Meghana Enclave,");
		Thread.sleep(2000);		

		drChrome.findElement(By.xpath("//input[@name='address2']")).sendKeys("Mathrusri Nagar, Miyapur");
		Thread.sleep(2000);

		drChrome.findElement(By.xpath("//input[@name='city']")).sendKeys("Hyderabad");
		Thread.sleep(2000);		

		drChrome.findElement(By.xpath("//input[@name='state']")).sendKeys("Telangana");
		Thread.sleep(2000);		

		drChrome.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("500049");
		Thread.sleep(2000);		

		Select ddlCntry=new Select(drChrome.findElement(By.xpath("//select[@name='country']")));
		ddlCntry.selectByValue("92");		
		Thread.sleep(2000);

		drChrome.findElement(By.name("email")).sendKeys("kprasad369");
		Thread.sleep(2000);

		drChrome.findElement(By.name("password")).sendKeys("zaqwsx!@#");
		Thread.sleep(2000);

		drChrome.findElement(By.name("confirmPassword")).sendKeys("zaqwsx!@#");
		Thread.sleep(2000);

		drChrome.findElement(By.xpath("//input[@name='register']")).click();
		Thread.sleep(2000);

		if(drChrome.getCurrentUrl().contains("create_account_success"))
		{
			System.out.println("Registration Successful...");
		}
		else
		{
			System.out.println("Registration Failed");
		}

		Thread.sleep(3000);

		//Login Page
		drChrome.navigate().to("http://newtours.demoaut.com/mercurysignon.php");
		drChrome.manage().window().maximize();
		Thread.sleep(2000);

		drChrome.findElement(By.name("userName")).sendKeys("kprasad369");
		Thread.sleep(2000);
		
		drChrome.findElement(By.name("password")).sendKeys("zaqwsx!@#");
		Thread.sleep(2000);
		
		drChrome.findElement(By.name("login")).click();
		Thread.sleep(2000);

		if(drChrome.getCurrentUrl().contains("mercuryreservation"))
		{
			System.out.println("Login Successful...");
		}
		else
		{
			System.out.println("Login Failed");
		}
		
		Thread.sleep(3000);
		drChrome.quit();
	}

}
