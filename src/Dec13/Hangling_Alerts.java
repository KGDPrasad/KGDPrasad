package Dec13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hangling_Alerts {

	public static void main(String[] args) throws Throwable {
		WebDriver drFirefox=new FirefoxDriver();
		drFirefox.manage().window().maximize();
		
		drFirefox.navigate().to("http://www.primusbank.qedgetech.com/");
		Thread.sleep(5000);
		drFirefox.findElement(By.name("login")).click();
		Thread.sleep(5000);
		//get alert text
		String alertMsg=drFirefox.switchTo().alert().getText();
		System.out.println("Pop Up message : \n"+alertMsg);
		
		//click on OK
		drFirefox.switchTo().alert().accept();
		Thread.sleep(5000);
		drFirefox.close();
	}

}
