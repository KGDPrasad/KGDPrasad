package Dec12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxEx {

	public static void main(String[] args) throws Throwable 
	{
		WebDriver drChrome=new ChromeDriver();
		drChrome.get("https://www.rediff.com/");
		drChrome.manage().window().maximize();

		Thread.sleep(3000);
		drChrome.findElement(By.partialLinkText("Sign")).click();

		WebElement checkBox=drChrome.findElement(By.id("remember"));
		Thread.sleep(3000);

		boolean value=checkBox.isSelected();
		System.out.println("checkbox is selected "+value);

		if(checkBox.isSelected())
		{
			checkBox.click();
			System.out.println("already checked, now unChecked");
			Thread.sleep(3000);
		}
		else 
		{
			checkBox.click();
			System.out.println("Checked");
			Thread.sleep(3000);
		}
		drChrome.quit();
	}

}
