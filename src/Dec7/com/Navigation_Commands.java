package Dec7.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation_Commands {

	
	public static void main(String[] args) throws Throwable {

		WebDriver drChrome=new ChromeDriver();

		drChrome.navigate().to("https://www.facebook.com/");
		drChrome.manage().window().maximize();		
		Thread.sleep(5000);
		System.out.println("Entered Title is : "+drChrome.getTitle());
		drChrome.findElement(By.partialLinkText("Forg")).click();
		Thread.sleep(5000);
		System.out.println("Title after click is : "+drChrome.getTitle());
		Thread.sleep(5000);
		//back
		drChrome.navigate().back();
		System.out.println("Title after back is : "+drChrome.getTitle());
		//forward
		drChrome.navigate().forward();
		System.out.println("Title is forward : "+drChrome.getTitle());
		//refresh
		drChrome.navigate().refresh();
		System.out.println("Title after refresh is : "+drChrome.getTitle());
		Thread.sleep(5000);
		drChrome.quit();
	}
}
