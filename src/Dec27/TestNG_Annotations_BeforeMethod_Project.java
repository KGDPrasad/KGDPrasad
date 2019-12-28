package Dec27;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

public class TestNG_Annotations_BeforeMethod_Project {

	static WebDriver drChrome;

	@BeforeMethod
	public void Setup()throws Throwable
	{
		drChrome=new ChromeDriver();
		drChrome.manage().window().maximize();
		Thread.sleep(3000);
		drChrome.get("http://www.newtours.demoaut.com/");
		Reporter.log("Running Setup in BeforeMethod...",true);
	}
	@Test
	public void RegisterLink()throws Throwable
	{
		Thread.sleep(4000);
		drChrome.findElement(By.partialLinkText("REG")).click();
		Reporter.log("Executing RegisterLink",true);
	}
	@Test
	public void HotelsLink()throws Throwable
	{
		Thread.sleep(4000);
		drChrome.findElement(By.partialLinkText("Hot")).click();
		Reporter.log("Executing HotelsLink",true);
	}
	@Test
	public void SignOnLink()throws Throwable
	{
		Thread.sleep(4000);
		drChrome.findElement(By.partialLinkText("SIG")).click();
		Reporter.log("Executing SignOnLink",true);
	}
	@AfterMethod
	public void TearDown()throws Throwable
	{
		Thread.sleep(4000);
		Reporter.log("Executing TearDown in AfterMethod...",true);
		Reporter.log("           ",true);
		drChrome.close();
	}
}
