package Dec27;

import org.testng.Reporter;
import org.testng.annotations.*;
/*import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
*/
public class TestNG_Annotations_BeforeTest_Sample_with_Priority {

	@BeforeTest
	public void Setup()
	{
		Reporter.log("Running BeforeTest...",true);
	}
	
	@Test(description="This is Login", priority=0, enabled=true)
	public void Login()
	{
		Reporter.log("Executing Login Test.",true);
	}
	
	@Test(description="This is Compose", priority=2, enabled=true)
	public void Compose()
	{
		Reporter.log("Executing Compose.",true);
	}
	
	@Test(description="This is Reply", priority=1, enabled=true, invocationCount=3)
	public void Reply()
	{
		Reporter.log("Executing Reply",true);
	}
	
	@AfterTest
	public void TearDown()
	{
		Reporter.log("Running AfterTest...",true);
		Reporter.log("        ",true);
	}
}
