package Dec17;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAllWindows_Iterator {

	public static void main(String[] args) throws Throwable {
		WebDriver drChrome=new ChromeDriver();
		drChrome.get("https://www.naukri.com/");
		drChrome.manage().window().maximize();
		
		String ParentWindow=drChrome.getWindowHandle();
		
		//storing collection of windows
		ArrayList<String> BrwAllWindows=new ArrayList<String>(drChrome.getWindowHandles());
		System.out.println(BrwAllWindows);
		
		Iterator<String>x=BrwAllWindows.iterator();
		while(x.hasNext())
		{
			String ChildWindow=x.next();
			if(!ParentWindow.equals(ChildWindow))
			{
				//switch to child windows
				String pateTitle=drChrome.switchTo().window(ChildWindow).getTitle();
				System.out.println("Control in Child Window...");
				System.out.println(pateTitle);
				drChrome.manage().window().maximize();
				Thread.sleep(4000);
				drChrome.close();
			}
		}
		drChrome.switchTo().window(BrwAllWindows.get(0));
		System.out.println("Control in Parent Window...");
		Thread.sleep(4000);
		drChrome.findElement(By.xpath("//input[@class='orangeBtn bifurLightBox']")).click();
		Thread.sleep(4000);
		drChrome.findElement(By.xpath("//button[contains(text(),'I am a Professional')]")).click();
		Thread.sleep(4000);
		drChrome.findElement(By.xpath("//input[@id='fname']")).sendKeys("KGDP");
		Thread.sleep(4000);
		drChrome.findElement(By.xpath("//input[@id='email']")).sendKeys("kprasad369@gmail.com");
		Thread.sleep(4000);
		drChrome.findElement(By.xpath("//button[@name='basicDetailSubmit']")).click();
		Thread.sleep(4000);
		drChrome.close();
	}
}
