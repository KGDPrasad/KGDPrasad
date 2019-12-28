package Dec27;

import org.testng.Reporter;
import org.testng.annotations.*;
/*import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
*/
public class TestNG_Annotations_BeforeTest_Sample {

	@BeforeTest
	public void Setup()
	{
		Reporter.log("Running BeforeMethod...",true);
	}
	@Test
	public void Login()
	{
		Reporter.log("Executing Login Test.",true);
	}
	@Test
	public void Compose()
	{
		Reporter.log("Executing Compose.",true);
	}
	@Test
	public void Reply()
	{
		Reporter.log("Executing Reply",true);
	}
	@AfterTest
	public void TearDown()
	{
		Reporter.log("Running AfterMethod...",true);
		Reporter.log("        ",true);
	}
}
