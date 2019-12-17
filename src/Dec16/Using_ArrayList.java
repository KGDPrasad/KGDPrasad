//WAS to handle multiple window using arraylist 

package Dec16;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Using_ArrayList {

	public static void main(String[] args) throws Throwable {

		WebDriver drChrome=new ChromeDriver();
		
		drChrome.get("https://www.naukri.com/");
		drChrome.manage().window().maximize();
		Thread.sleep(5000);
		
		//get collection of all windows into ArrayList
		ArrayList<String> AllBrowsers=new ArrayList<String>(drChrome.getWindowHandles());

		//switch to any specific window
		String Browser1=drChrome.switchTo().window(AllBrowsers.get(1)).getTitle();
		Thread.sleep(5000);
		System.out.println("Title Name 1 : "+Browser1);
		drChrome.manage().window().maximize();
		Thread.sleep(5000);
		drChrome.close();

		//switch to any specific window
		String Browser2=drChrome.switchTo().window(AllBrowsers.get(2)).getTitle();
		Thread.sleep(5000);
		System.out.println("Title Name 2 : "+Browser2);
		drChrome.manage().window().maximize();
		Thread.sleep(5000);
		drChrome.close();

		//switch to parent window
		drChrome.switchTo().window(AllBrowsers.get(0));
		Thread.sleep(5000);
		drChrome.findElement(By.xpath("//input[@class='orangeBtn bifurLightBox']")).click();
		Thread.sleep(5000);
		drChrome.close();
	}

}
