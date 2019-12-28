package Dec21;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) throws Throwable {

		WebDriver drChrome=new ChromeDriver();
		drChrome.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		drChrome.manage().window().maximize();

		Actions ac=new Actions(drChrome);

		Thread.sleep(5000);
		
		//close login banner
		ac.sendKeys(Keys.ESCAPE).build().perform();

		Thread.sleep(5000);
		
		//findout Baby & Kids
		WebElement BabyKids=drChrome.findElement(By.xpath("//ul/li[5]/span"));
		//mousehover on Baby & Kids
		ac.moveToElement(BabyKids);
		ac.build().perform();
		//above code can write in single line also
		//ac.moveToElement(BabyKids).build().perform();

		Thread.sleep(5000);

		
		ac.moveToElement(drChrome.findElement(By.linkText("Puzzles")));
		ac.click();
		ac.pause(4000);		
		ac.build().perform();
		//ac.moveToElement(drChrome.findElement(By.linkText("Puzzles"))).click().build().perform();
		
		System.out.println("Page Title : "+drChrome.getTitle());

		Thread.sleep(5000);

		drChrome.close();

	}

}
