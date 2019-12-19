package Dec16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingAlerts {

	public static void main(String[] args) throws Throwable {
		WebDriver drFirefox=new FirefoxDriver();
		drFirefox.get("file:///G:\\promp.html");
		Thread.sleep(5000);
		
		drFirefox.findElement(By.xpath("/html/body/fieldset/button")).click();
		Thread.sleep(5000);
	
		String alertText=drFirefox.switchTo().alert().getText();
		System.out.println(alertText);
		Thread.sleep(5000);
		drFirefox.switchTo().alert().sendKeys("KGDPrasad");
		Thread.sleep(5000);
	
		drFirefox.switchTo().alert().accept();
		Thread.sleep(5000);
	
		String msg=drFirefox.findElement(By.id("promptdemo")).getText();
		System.out.println(msg);
	
		Thread.sleep(5000);
		drFirefox.quit();

	}

}
