package Jan4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class assertTrue
{
	WebDriver driver;
	@Test
	public void TestCase()
	{
		driver=new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();

		String Exptitle="Googl";
		String Acttitle=driver.getTitle();

		try 
		{
			Assert.assertTrue(Acttitle.equals(Exptitle),"Title is not matching");
		}
		catch(Throwable t)
		{
			System.out.println(t.getMessage());
		}
		driver.close();		
	}
}
