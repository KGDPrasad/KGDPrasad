package Dec23;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript_LoginCheck {

	public static void main(String[] args) throws Throwable {

		WebDriver drChrome=new ChromeDriver();
		drChrome.manage().window().maximize();

		JavascriptExecutor js=(JavascriptExecutor)drChrome;

		Thread.sleep(3000);
		js.executeScript("window.location='http://www.primusbank.qedgetech.com/'");Thread.sleep(3000);
		js.executeScript("document.getElementById('txtuId').value='Admin'");Thread.sleep(3000);
		js.executeScript("document.getElementById('txtPword').value='Admin'");Thread.sleep(3000);
		js.executeScript("document.querySelector('#login').click()");Thread.sleep(3000);
		Thread.sleep(3000);
		
		if(js.executeScript("return document.URL").toString().contains("adminflow"))
			System.out.println("Success...");
		else
			System.out.println("Fail...");
		
		drChrome.close();
	}

}
