package Jan4;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Demo_Extenreport 
{
	ExtentReports report;
	ExtentTest test;

	@BeforeTest
	public void generateReport()
	{
		//set path of html report
		report=new ExtentReports("./Reports/MyReports.html");
	}
	
	@Test
	public void demoTestPass1()
	{
		test = report.startTest("demoTestPass1", "This test will demonstrate the PASS test case");
		test.log(LogStatus.PASS, "Test Case pass");
		Assert.assertFalse(true);
	}
	@Test
	public void demoTestPass2()
	{
		test = report.startTest("demoTestPass2", "This test will demonstrate the PASS test case");
		test.log(LogStatus.PASS, "Test Case pass");
		Assert.assertFalse(true);
	}
	@Test
	public void demoTestFail()
	{
		test = report.startTest("demoTestFail", "This test will demonstrate the FAIL test case");
		test.log(LogStatus.FAIL, "Test Case Fail");
		Assert.assertTrue(false);
	}
	@Test
	public void demoTestSkip()
	{
		test = report.startTest("demoTestSkip", "This test will demonstrate the SKIP test case");
		test.log(LogStatus.SKIP, "Test Case Skip");
		throw new SkipException("This test case not ready for execution");
	}
	
	@AfterMethod
	public void endreport()
	{
		report.endTest(test);
		report.flush();
	}
}
