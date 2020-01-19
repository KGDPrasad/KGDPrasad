package Jan3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class OrangeHRM_ExtentReports
{
	WebDriver driver;
	FileInputStream fi;
	FileOutputStream fo;
	Workbook wb;
	Sheet ws;
	Row r;
	File screen;
	ExtentReports report;
	ExtentTest test;

	@BeforeTest
	public void setUp()
	{
		report=new ExtentReports("./Reports/MyDataDriven.html");
		driver=new ChromeDriver();
	}
	
	@Test
	public void verifyLogin()throws Throwable
	{
		fi=new FileInputStream("G://LoginHRM.xlsx");
		wb=WorkbookFactory.create(fi);
		ws=wb.getSheet("Login");
		r=ws.getRow(0);
		int rc=ws.getLastRowNum();
		int cc=r.getLastCellNum();
		Reporter.log("No of rows are::"+rc+"  "+"No of columns are::"+cc,true);
	
		for(int i=1;i<=rc;i++)
		{
			test=report.startTest("Login Test", "This test cases access data from excel");
			driver.get("http://orangehrm.qedgetech.com/");
			driver.manage().window().maximize();
			String username=ws.getRow(i).getCell(0).getStringCellValue();
			String password=ws.getRow(i).getCell(1).getStringCellValue();
			driver.findElement(By.name("txtUsername")).sendKeys(username);
			driver.findElement(By.name("txtPassword")).sendKeys(password);
			driver.findElement(By.name("Submit")).click();
			Thread.sleep(5000);
		
			if(driver.getCurrentUrl().contains("dashboard"))
			{
				test.log(LogStatus.PASS, "Username and password are valid");
				//take screenshot for pass
				screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screen, new File("G://OrangeHRM//Screen/Iteration"+i+"Loginpage.png"));
				Reporter.log("Login Success",true);
				
				//write as login success in results column
				ws.getRow(i).createCell(2).setCellValue("Login Success");
				//write as pass in status column
				ws.getRow(i).createCell(3).setCellValue("Pass");
			}
			else
			{
				//take screenshot for fail
				screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screen, new File("G://OrangeHRM//Screen/Iteration"+i+"Loginpage.png"));
				//get error message
				String errormessage=driver.findElement(By.id("spanMessage")).getText();
				Reporter.log(errormessage,true);
				
				test.log(LogStatus.FAIL, errormessage);
				//write as login Fail in results column
				ws.getRow(i).createCell(2).setCellValue(errormessage);
				//write as Fail in status column
				ws.getRow(i).createCell(3).setCellValue("Fail");
			}
			
			report.endTest(test);
			report.flush();
		}
		fi.close();
		fo=new FileOutputStream("G://orangeHRm.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();
	}
	
	@AfterTest
	public void tearDown()throws Throwable
	{
		Thread.sleep(5000);
		driver.close();
	}
}