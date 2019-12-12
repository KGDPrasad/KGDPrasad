package Dec11;

import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ListBox {

	public static void main(String[] args) throws Throwable 
	{

		WebDriver drChrome=new ChromeDriver();

		drChrome.navigate().to("http://www.newtours.demoaut.com/");
		drChrome.manage().window().maximize();

		drChrome.findElement(By.partialLinkText("REGI")).click();

		Select listBox=new Select(drChrome.findElement(By.name("country")));
		//get collection of items in listBox
		List<WebElement> items=listBox.getOptions();
		System.out.println("no of items :"+items.size());

		for(int i=0;i<items.size();i++)
		{
			//get each item name from items collection
			//Thread.sleep(2000);
			String itemName=items.get(i).getText();
			System.out.println(itemName);
			//Thread.sleep(2000);
			items.get(i).click();
		}
		drChrome.close();

	}

}
