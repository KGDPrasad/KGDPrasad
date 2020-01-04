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

public class OrangeHRM {

	WebDriver drChrome;
	FileInputStream fi;
	FileOutputStream fo;
	Workbook WB;
	Sheet WS;
	Row R;
	File Screen;

	@BeforeTest
	public void setUp()
	{
		drChrome=new ChromeDriver();
	}

	@Test
	public void VerifyLogin() throws Throwable
	{
		fi=new FileInputStream("G://LoginHRM.xlsx");
		WB=WorkbookFactory.create(fi);
		WS=WB.getSheet("Login");
		R=WS.getRow(0);
		int RowCount=WS.getLastRowNum();
		int ColCount=R.getLastCellNum();

		Reporter.log("No of Rows : "+RowCount+" and No of Columns : "+ColCount,true);

		for(int i=1; i<=RowCount; i++)
		{
			drChrome.get("http://orangehrm.qedgetech.com/");
			drChrome.manage().window().maximize();

			String userName=WS.getRow(i).getCell(0).getStringCellValue();
			String password=WS.getRow(i).getCell(1).getStringCellValue();

			drChrome.findElement(By.name("txtUsername")).sendKeys(userName);
			drChrome.findElement(By.name("txtPassword")).sendKeys(password);
			drChrome.findElement(By.name("Submit")).click();
			Thread.sleep(5000);

			if(drChrome.getCurrentUrl().contains("dashboard"))
			{
				//taking screen shot
				Screen=((TakesScreenshot)drChrome).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(Screen, new File("G://OrangeHRM//Screens/Iteration_"+i+"_Login.png"));
				Reporter.log("Login Success",true);

				//write as login success in result column
				WS.getRow(i).createCell(2).setCellValue("Login Success...");
				//write as pass in status column
				WS.getRow(i).createCell(3).setCellValue("Pass.");
			}
			else
			{
				//takes screen shot for fail
				Screen=((TakesScreenshot)drChrome).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(Screen, new File("G://OrangeHRM//Screens/Iteration_"+i+"Login.png"));
				//get error message
				String errorMsg=drChrome.findElement(By.id("spanMessage")).getText();
				Reporter.log(errorMsg,true);

				//write as login fail in result column
				WS.getRow(i).createCell(2).setCellValue(errorMsg);
				//write as fail in status column
				WS.getRow(i).createCell(3).setCellValue("Fail.");
			}
		}

		fi.close();
		fo=new FileOutputStream("G://OrangeHRM//LoginHRM.xlsx");
		WB.write(fo);
		fo.close();
		WB.close();
	}

	@AfterTest
	public void DownTear() throws Throwable
	{
		Thread.sleep(5000);
		drChrome.close();
	}
}
