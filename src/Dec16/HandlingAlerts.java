package Dec16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingAlerts {

	public static void main(String[] args) {
		WebDriver drFirefox=new FirefoxDriver();
		drFirefox.get("");
		drFirefox.findElement(By.xpath("")).click();

		String alertText=drFirefox.switchTo().alert().getText();
		System.out.println(alertText);

		drFirefox.switchTo().alert().sendKeys("KGDPrasad");
		drFirefox.switchTo().alert().accept();

		String msg=drFirefox.findElement(By.id("promptdemo")).getText();
		System.out.println(msg);

		drFirefox.quit();

	}

}
