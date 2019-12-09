package Dec7.com;



import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetSize_Attribute_methods {

	public static void main(String[] args) {
		WebDriver drChrome=new ChromeDriver();
		drChrome.get("https://facebook.com/r.php");
		drChrome.manage().window().maximize();
		
		WebElement mobileTextbox=drChrome.findElement(By.name("reg_email__"));
		 
		Dimension dimMobileTextbox=mobileTextbox.getSize();
		System.out.println("Height is : "+dimMobileTextbox.getHeight());
		System.out.println("Width is : "+dimMobileTextbox.getWidth());

		String linkUrl=drChrome.findElement(By.partialLinkText("Data")).getAttribute("href");
		System.out.println(linkUrl);
		drChrome.quit();
	}

}
