/*WAS to switch to multiple windows
Launch chrome browser and navigate to FB
get parent window id by using getWindowHandle
click on terms link
get the collection of all windowId by usng getWindowHandles
iterate all windows
parent window should not equals to child window
switch to childwindow and login into application
switch back to parent window and do some testing*/

package Dec16;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingMultipleWindows {

	public static void main(String[] args) throws Throwable {
		WebDriver drChrome=new ChromeDriver();
		drChrome.manage().window().maximize();

		drChrome.get("https://www.facebook.com/");
		drChrome.manage().window().maximize();
		Thread.sleep(5000);

		String ParentWindow=drChrome.getWindowHandle();
		System.out.println("Parent Window ID : "+ParentWindow);
		Thread.sleep(5000);

		//click on terms link
		drChrome.findElement(By.partialLinkText("Te")).click();
		Thread.sleep(5000);

		//get collection of all windows ids
		Set<String>AllBrowsersIDs=drChrome.getWindowHandles();
		System.out.println("All Browsers IDs : "+AllBrowsersIDs);

		for(String eachBrowserID:AllBrowsersIDs)
		{
			if(!ParentWindow.equals(eachBrowserID))
			{
				//switch to child window
				drChrome.switchTo().window(eachBrowserID);
				Thread.sleep(5000);

				drChrome.findElement(By.name("email")).sendKeys("kprasad@gmail.com");
				drChrome.findElement(By.name("pass")).sendKeys("zaqwsx_9");
				drChrome.findElement(By.name("email")).sendKeys(Keys.ENTER);
				Thread.sleep(5000);

				//switch to parent window
				drChrome.switchTo().window(ParentWindow);
				drChrome.findElement(By.name("firstname")).sendKeys("KGDP");				
				Thread.sleep(5000);
			}
			Thread.sleep(5000);
		}
		drChrome.quit();
	}

}
