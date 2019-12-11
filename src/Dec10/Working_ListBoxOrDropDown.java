package Dec10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Working_ListBoxOrDropDown 
{

	public static void main(String[] args) throws Throwable 
	{
		WebDriver drChrome=new ChromeDriver();
		drChrome.get("https://www.facebook.com/r.php");
		drChrome.manage().window().maximize();

		//Storing day list box into Select Class
		Select dayList=new Select(drChrome.findElement(By.id("day")));
		//verifying month list is multiple select or not
		boolean dayValue=dayList.isMultiple();
		System.out.println("is Day List box is multiple Select? \t"+dayValue);

		//Storing month list box into Select Class
		Select monthList=new Select(drChrome.findElement(By.id("month")));
		//verifying month list is multiple select or not
		boolean monthValue=monthList.isMultiple();
		System.out.println("is Month List box is multiple Select? \t"+monthValue);

		//Storing year list box into Select Class
		Select yearList=new Select(drChrome.findElement(By.id("year")));
		//verifying month list is multiple select or not
		boolean yearValue=yearList.isMultiple();
		System.out.println("is Year List box is multiple Select? \t"+yearValue+"\n");

		Thread.sleep(3000);

		//select one item in day listbox
		dayList.selectByVisibleText("13");
		System.out.println("Selected Day by selectByVisibleText : \t"+dayList.getFirstSelectedOption().getText());
		Thread.sleep(2000);

		//select one item in month listbox		
		monthList.selectByVisibleText("Jun");		
		System.out.println("Selected Month by selectByVisibleText : "+monthList.getFirstSelectedOption().getText());		
		Thread.sleep(2000);

		//select one item in year listbox
		yearList.selectByVisibleText("1984");
		System.out.println("Selected Year by selectByVisibleText : \t"+yearList.getFirstSelectedOption().getText());
		Thread.sleep(2000);

		dayList.selectByValue("6");
		System.out.println("Selected Day by selectByValue : \t"+dayList.getFirstSelectedOption().getText());
		Thread.sleep(2000);

		yearList.selectByValue("1975");
		System.out.println("Selected Year by selectByValue : \t"+yearList.getFirstSelectedOption().getText());
		Thread.sleep(2000);

		dayList.selectByIndex(25);
		System.out.println("Selected Day by selectByIndex : \t"+dayList.getFirstSelectedOption().getText());
		Thread.sleep(2000);

		monthList.selectByIndex(5);
		System.out.println("Selected Month by selectByIndex : \t"+monthList.getFirstSelectedOption().getText());
		Thread.sleep(2000);

		yearList.selectByIndex(15);
		System.out.println("Selected Year by selectByIndex : \t"+yearList.getFirstSelectedOption().getText());

		Thread.sleep(3000);

		drChrome.close();
	}
}
