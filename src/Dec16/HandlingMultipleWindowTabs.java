package Dec16;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingMultipleWindowTabs {

	public static void main(String[] args) throws Throwable {
		WebDriver drChrome=new ChromeDriver();
		drChrome.manage().window().maximize();

		drChrome.get("https://www.google.co.in/");
		Thread.sleep(5000);

		drChrome.findElement(By.partialLinkText("Gma")).click();
		Thread.sleep(5000);
		drChrome.findElement(By.partialLinkText("For W")).click();
		Thread.sleep(5000);
		drChrome.findElement(By.partialLinkText("Crea")).click();
		Thread.sleep(5000);
		drChrome.findElement(By.partialLinkText("Sig")).click();
		Thread.sleep(5000);

		//get parent window id
		String ParentID=drChrome.getWindowHandle();
		System.out.println("Parent Browser ID : "+ParentID);
		Thread.sleep(5000);

		//get collection of all windows ids
		Set<String>AllBrowsersIDs=drChrome.getWindowHandles();
		System.out.println("All Browsers IDs : "+AllBrowsersIDs);

		for(String eachBrowser:AllBrowsersIDs )
		{
			if(!ParentID.equals(eachBrowser))
			{
				//switch to first window
				String BrowserTab= drChrome.switchTo().window(eachBrowser).getTitle();
				System.out.println(BrowserTab);
				drChrome.findElement(By.id("identifierId")).sendKeys("KGDP");
				Thread.sleep(5000);
				drChrome.close();
			}
		}

		drChrome.quit();
	}
}
