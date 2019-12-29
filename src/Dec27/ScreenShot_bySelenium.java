package Dec27;


import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScreenShot_bySelenium {

	WebDriver drChrome;

	@Test
	public void TakeScreenShot() throws Throwable
	{
		drChrome=new ChromeDriver();
		drChrome.get("https://www.google.com/");
		drChrome.manage().window().maximize();

		Thread.sleep(5000);

		//creating java time stamp
		DateFormat df=new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
		Date d=new Date();
		String dateF=df.format(d);

		//take screenshot & store in drive
		//File screen=((TakesScreenshot)drChrome).getScreenshotAs(OutputType.FILE);
		File screens=((TakesScreenshot)drChrome).getScreenshotAs(OutputType.FILE);

		//coply screen into local drive
		FileUtils.copyFile(screens, new File("G://KGDP//kgdp//"+dateF+".png"));
		drChrome.close();
	}
}
