package Dec27;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

public class TestNG_Annotations_BeforeTest_Project_with_Priority {

	static WebDriver drChrome;

	@BeforeTest
	public void Setup()throws Throwable
	{
		drChrome=new ChromeDriver();
		drChrome.manage().window().maximize();
		Thread.sleep(3000);
		drChrome.get("http://www.newtours.demoaut.com/");
		Reporter.log("Running Setup in BeforeTest...",true);
	}
	@Test(description="working with RegisterLink",priority=1,invocationCount=4,enabled=false)
	public void RegisterLink()throws Throwable
	{
		Thread.sleep(4000);
		drChrome.findElement(By.partialLinkText("REG")).click();
		Reporter.log("Executing RegisterLink",true);
	}
	@Test(description="working with HotelsLink",priority=1,invocationCount=2)
	public void HotelsLink()throws Throwable
	{
		Thread.sleep(4000);
		drChrome.findElement(By.partialLinkText("Hot")).click();
		Reporter.log("Executing HotelsLink",true);
	}
	@Test(description="working with SignOnLink",priority=0)
	public void SignOnLink()throws Throwable
	{
		Thread.sleep(4000);
		drChrome.findElement(By.partialLinkText("SIG")).click();
		Reporter.log("Executing SignOnLink",true);
	}
	@AfterTest
	public void TearDown()throws Throwable
	{
		Thread.sleep(4000);
		Reporter.log("Executing TearDown in AfterTest...",true);
		Reporter.log("           ",true);
		drChrome.close();
	}
}
