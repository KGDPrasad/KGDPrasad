package Browser_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Prasad {

	/*	public static void main(String[] args) {

		// instance object for Chrome, Firefox, IE Browsers
		WebDriver driverChrome=new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");

		WebDriver driverGecko = new FirefoxDriver();
		System.setProperty("webdriver.gecko.driver", "G:\\geckodriver.exe");

		WebDriver driverIE =new InternetExplorerDriver();
		System.setProperty("webdriver.ie.driver", "G:\\IEDriverServer.exe");

		driverChrome.get("http://www.facebook.com");
		driverGecko.get("http://www.gmail.com");
		driverIE.get("http://www.google.com");

		driverChrome.quit();
	}
	 */
	/*	public static void main(String[] args) throws Throwable{

		ChromeDriver driverChrome=new ChromeDriver();
	driverChrome.get("http://orangehrm.qedgetech.com/");
	driverChrome.manage().window().maximize();
	Thread.sleep(5000);

	driverChrome.findElement(By.id("txtUsername")).sendKeys("Admin");
	driverChrome.findElement(By.id("txtPassword")).sendKeys("Qedge123!@#");
	driverChrome.findElement(By.id("btnLogin")).click();
	Thread.sleep(5000);
	driverChrome.findElement(By.id("welcome")).click();
	Thread.sleep(5000);
	driverChrome.findElement(By.linkText("Logout")).click();
	Thread.sleep(5000);
	  driverChrome.close();
	}
	 */
	public static void main(String[] args) throws Throwable{
		WebDriver driverChrome = new ChromeDriver();
		driverChrome.get("https://www.snapdeal.com/");
		driverChrome.manage().window().maximize();

		// Print Title & Length of Title
		String strTitle=driverChrome.getTitle();
		System.out.println("Title of the Page is : "+ strTitle);
		System.out.println("Title length is : "+strTitle.length());

		// Print Url & length of Url
		String strURL=driverChrome.getCurrentUrl();
		System.out.println("URL of the page is : "+ strURL);
		System.out.println("Length of URL is : "+strURL.length());
		Thread.sleep(5000);

		String str1="prasad";
		String str2="Prasad";
		String str3="prasad";
		String str4="Prasad looks very handsome";
		System.out.println(str2.equals(str1));
		System.out.println(str3.equals(str1));
		System.out.println(str2.equalsIgnoreCase(str2));
		System.out.println(str4.contains("Handsome"));
		driverChrome.close();

	}
}
