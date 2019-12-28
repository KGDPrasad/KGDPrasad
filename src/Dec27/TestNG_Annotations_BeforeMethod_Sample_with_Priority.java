package Dec27;

import org.testng.Reporter;
import org.testng.annotations.*;
/*import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
*/
public class TestNG_Annotations_BeforeMethod_Sample_with_Priority {

	@BeforeMethod
	public void Setup()
	{
		Reporter.log("Running BeforeMethod...",true);
	}
	
	@Test(description="This is Login", priority=0, enabled=true)
	public void Login()
	{
		Reporter.log("Executing Login Test.",true);
	}
	
	// By default all test cases are true
	//if you want to avoid any test case from execution then make it as enable=false 
	@Test(description="This is Compose", priority=2, enabled=false)
	public void Compose()
	{
		Reporter.log("Executing Compose.",true);
	}
	
	@Test(description="This is Reply", priority=1, enabled=true, invocationCount=2)
	public void Reply()
	{
		Reporter.log("Executing Reply",true);
	}
	
	@AfterMethod
	public void TearDown()
	{
		Reporter.log("Running AfterMethod...",true);
		Reporter.log("        ",true);
	}
}
