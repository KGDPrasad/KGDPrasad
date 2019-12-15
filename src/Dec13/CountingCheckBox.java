// WAS to get collection of checkbox in a webpage and verify which checkbox is true or false
// print name of each checkbox which checkbox is selected uncheck it and select which checkbox is not selected

package Dec13;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountingCheckBox {

	public static void main(String[] args) throws InterruptedException {

		WebDriver drChrome=new ChromeDriver();
		drChrome.manage().window().maximize();

		drChrome.navigate().to("G:\\checkbox.html");

		//get collection of checkboxes
		List<WebElement> chkList=drChrome.findElements(By.tagName("input"));
		System.out.println("no of checkboxes : "+chkList.size());

		for(int i=0; i<chkList.size(); i++)
		{
			//verify checkbox is true or false
			boolean value=chkList.get(i).isSelected();
			//System.out.println(value);

			//getting check box name
			String chkName=chkList.get(i).getAttribute("value");
			System.out.println("Check Box Name : "+chkName);

			System.out.println(chkName+" is checked : "+value+"\n");

			if(!chkList.get(i).isSelected())
				chkList.get(i).click();
			else
				chkList.get(i).click();

			Thread.sleep(2000);
		}

		drChrome.close();
	}

}
