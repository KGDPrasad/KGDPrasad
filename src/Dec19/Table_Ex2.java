package Dec19;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table_Ex2 {

	public static void main(String[] args) {

		WebDriver drChrome=new ChromeDriver();
		drChrome.manage().window().maximize();
		drChrome.get("");
		
		//store table
		WebElement table=drChrome.findElement(By.id(""));
		
		//get collection of rows
		List<WebElement>rows=table.findElements(By.tagName("tr"));
		System.out.println("No of rows are : "+rows.size());
		
		String expCountry="Canada";
		for (int i = 0; i < rows.size(); i++) 
		{
			List<WebElement>cols=rows.get(i).findElements(By.tagName("td"));
			System.out.println("No of columns are : "+cols.size());
		}
	}

}
