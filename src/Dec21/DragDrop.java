package Dec21;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop {

	public static void main(String[] args) throws Throwable {
		WebDriver drChrome=new ChromeDriver();
		drChrome.get("https://jqueryui.com/");
		drChrome.manage().window().maximize();

		Thread.sleep(3000);
		drChrome.findElement(By.partialLinkText("Dropp")).click();
		Thread.sleep(3000);

		Actions ac=new Actions(drChrome);

		//ac.sendKeys(Keys.PAGE_DOWN).perform();

		drChrome.switchTo().frame(0);

		WebElement src=drChrome.findElement(By.id("draggable"));
		WebElement dest=drChrome.findElement(By.id("droppable"));

		ac.clickAndHold(src).moveToElement(dest).release().perform();

		Thread.sleep(5000);

		if(dest.getText().contains("Dropped"))
			System.out.println("Dropped Success using moveTo()");
		else
			System.out.println("Dropping Failed...");

		//another method to drag and drop using dragAndDrop()
		//Thread.sleep(3000);
		
		//leave frame and switch to Main browser
		//drChrome.switchTo().defaultContent();
		drChrome.switchTo().parentFrame();

		drChrome.findElement(By.partialLinkText("Dropp")).click();
		Thread.sleep(3000);

		drChrome.switchTo().frame(0);

		ac.dragAndDrop(src, dest).perform();

		Thread.sleep(5000);

		if(dest.getText().contains("Dropped"))
			System.out.println("Dropped Success using dragAndDrop()");
		else
			System.out.println("Dropping Failed...");

		//another method to drag and drop using dragAndDropBy()
		Thread.sleep(3000);
		//leave frame and switch to Main browser
		drChrome.switchTo().defaultContent();
		drChrome.findElement(By.partialLinkText("Dropp")).click();
		Thread.sleep(3000);

		drChrome.switchTo().frame(0);

		int X=dest.getLocation().getX();
		int Y=dest.getLocation().getY();
		System.out.println("Positions of X ------> "+X);
		System.out.println("Positions of Y ------> "+Y);

		ac.dragAndDropBy(src, X, Y).perform();

		Thread.sleep(5000);

		if(dest.getText().contains("Dropped"))
			System.out.println("Dropped Success dragAndDropBy()");
		else
			System.out.println("Dropping Failed...");

		drChrome.close();
	}

}
