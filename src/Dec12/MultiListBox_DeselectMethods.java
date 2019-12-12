package Dec12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiListBox_DeselectMethods {

	public static void main(String[] args) throws Throwable {
		WebDriver drChrome=new ChromeDriver();
		drChrome.get("G:\\Multi.html");
		drChrome.manage().window().maximize();
		Thread.sleep(5000);
		Select dropDown=new Select(drChrome.findElement(By.name("multiSelection")));

		boolean value=dropDown.isMultiple();
		System.out.println("Above drop down box is multi selector..."+value);

		//select 6 items
		dropDown.selectByIndex(3);Thread.sleep(2000);
		dropDown.selectByIndex(5);Thread.sleep(2000);
		dropDown.selectByIndex(0);Thread.sleep(2000);
		dropDown.selectByIndex(6);Thread.sleep(2000);
		dropDown.selectByIndex(9);Thread.sleep(2000);
		dropDown.selectByIndex(1);Thread.sleep(2000);

		//count no of items selected
		List<WebElement> list=dropDown.getAllSelectedOptions();
		System.out.println("no of items selected : "+list.size());

		for(int i=0;i<list.size();i++)
		{
			String itemName=list.get(i).getText();
			System.out.println(itemName);
		}

		dropDown.deselectByIndex(5);Thread.sleep(2000);
		dropDown.deselectByIndex(1);Thread.sleep(2000);
		dropDown.deselectAll();
		drChrome.quit();
	}

}
