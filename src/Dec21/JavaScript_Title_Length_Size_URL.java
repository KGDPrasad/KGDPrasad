package Dec21;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript_Title_Length_Size_URL {

	public static void main(String[] args) {
		WebDriver drChrome=new ChromeDriver();
		drChrome.manage().window().maximize();
		
		JavascriptExecutor js=(JavascriptExecutor)drChrome;
		
		//launch URL
		js.executeScript("window.location='https://www.amazon.com'");
		
		String pageTitle=js.executeScript("return document.title").toString();
		
		System.out.println("Page Title : "+pageTitle);
		System.out.println("Page Length : "+pageTitle.length());
		
		String URL=js.executeScript("return document.URL").toString();
		
		String domain=js.executeScript("return document.domain").toString();
		
		System.out.println("URL : "+URL);
		System.out.println("Length of URL : "+URL.length());
		System.out.println("Domain : "+domain);
		System.out.println("Length of Domain : "+domain.length());
		drChrome.close();
	}

}
