package Dec19;

import java.util.List;

import org.apache.commons.lang3.math.Fraction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames_Ex1 {

	public static void main(String[] args) throws Throwable {

		WebDriver drChrome=new ChromeDriver();

		drChrome.get("https://paytm.com/recharge");
		drChrome.manage().window().maximize();

		//click on login signup page
		drChrome.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div/header/div[3]/ul/li[3]/div/div/ul/li")).click();
		//*[@id="app"]/div/div[2]/div[2]/div[3]/div[4]/div

		//get collection of frames
		List<WebElement> Frames=drChrome.findElements(By.tagName("iframe"));
		System.out.println("no of Frames : "+Frames.size());
		Thread.sleep(5000);
		drChrome.switchTo().frame(0);
		//click on login signup
		drChrome.findElement(By.xpath("//*[@id=\"wallet-container-new qr-bg-white\"]/qr-code-login/div[2]/div[2]/div[3]/span")).click();
		Thread.sleep(5000);
		drChrome.findElement(By.xpath("//*[@id=\"input_0\"]")).sendKeys("abcd");
		drChrome.findElement(By.xpath("//*[@id=\"input_1\"]")).sendKeys("123456");
		drChrome.findElement(By.xpath("//*[@id=\"loginForm\"]/div/md-content/button/span")).click();

		//switch to main window
		drChrome.switchTo().defaultContent();
		drChrome.findElement(By.linkText("X")).click();
		Thread.sleep(5000);
		drChrome.findElement(By.linkText("Electricity")).click();
		drChrome.close();
		
	}

}
