package Dec19;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table_Ex {

	public static void main(String[] args) {

		WebDriver drChrome=new ChromeDriver();
		drChrome.manage().window().maximize();
		drChrome.navigate().to("G:\\qedgetable.html");

		//get data from table
		String tableText=drChrome.findElement(By.xpath("//table/tbody/tr[2]/td[3]")).getText();
		System.out.println(tableText);

		//store table in webelement
		WebElement table=drChrome.findElement(By.name("qedgetech"));

		//get collection of rows in table
		List<WebElement>rows=table.findElements(By.tagName("tr"));
		System.out.println("no of rows : "+rows.size());

		for (int i = 1; i < rows.size(); i++) 
		{
			//get collection of cols in rows
			List<WebElement>cols=rows.get(i).findElements(By.tagName("td"));
			System.out.println("no of rows : "+i+"===="+"no of cols : "+cols.size());			
		}
		drChrome.close();
	}
}
