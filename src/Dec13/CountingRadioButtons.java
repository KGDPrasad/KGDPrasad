// WAS to count no of radio buttons in webpage & print every radiobutton name
// if it is not selected then select

package Dec13;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountingRadioButtons {

	public static void main(String[] args) throws Throwable {

		WebDriver drChrome=new ChromeDriver();
		drChrome.manage().window().maximize();

		drChrome.navigate().to("https://www.cleartrip.com/");

		//get collection of radio buttons
		List<WebElement> radioList=drChrome.findElements(By.xpath("//form/nav/ul/li/label/strong"));
		System.out.println("no of radio buttons : "+radioList.size()+"\n");

		for(int i=0; i<radioList.size();i++)
		{
			//get radio button name
			System.out.println("Radio Button Name : "+radioList.get(i).getText());

			if(!radioList.get(i).isSelected())
				radioList.get(i).click();
			else
				radioList.get(i).click();
			System.out.println(radioList.get(i).getText()+" is selected now.\n");

			Thread.sleep(3000);
		}
		drChrome.close();
	}

}
