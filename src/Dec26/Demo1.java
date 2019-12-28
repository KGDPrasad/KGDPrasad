package Dec26;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Demo1 {
  
  @BeforeTest
  public void beforeTest() {
	  Reporter.log("Running BeforeTest",true);
  }
  
  @Test
  public void Login() {
	  Reporter.log("Executing Login",true);
  }

  @Test
  public void Compose() {
	  Reporter.log("Executing Compose",true);
  }
  @Test
  public void Reply() {
	  Reporter.log("Executing Reply",true);
  }
  @AfterTest
  public void afterTest() {
	  Reporter.log("Running AfterTest",true);
  }

}
