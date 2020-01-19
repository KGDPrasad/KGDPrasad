package Jan4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class assertEquals 
{
	WebDriver driver;

	@Test
	public void TestCase1()
	{
		driver=new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();

		String Exptitle="Google";
		String Acttitle=driver.getTitle();

		try 
		{
			Assert.assertEquals(Acttitle, Exptitle,"Given Expected Title is not matching with Actual Title");
		}
		catch(Throwable t)
		{
			System.out.println(t.getMessage());
		}
		driver.close();		
	}
}
