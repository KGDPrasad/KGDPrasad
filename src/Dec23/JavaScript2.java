package Dec23;

//import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class JavaScript2 {

	public static void main(String[] args) throws Throwable {
		
		WebDriver drChrome=new ChromeDriver();
		drChrome.manage().window().maximize();
		
		JavascriptExecutor js=(JavascriptExecutor)drChrome;
		
		//launch URL
		js.executeScript("window.location='https://www.flipkart.com/'");
		
		Actions ac=new Actions(drChrome);
		ac.sendKeys(Keys.ESCAPE).perform();
		
		Thread.sleep(5000);
		//scroll top to bottom and bottom to top
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(5000);
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		Thread.sleep(5000);
		
		WebElement x=drChrome.findElement(By.linkText("Payments"));
		js.executeScript("window.scrollIntoView",x);
		Thread.sleep(5000);
		drChrome.close();
		
	}

}
