import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parameters {
	public WebDriver driver;
	String myURL ="https://www.demoblaze.com/";
	SoftAssert mySoftAssert= new SoftAssert();
	String exbectedTitel="STORE";
	SoftAssert mySoftAssert1= new SoftAssert();
	@BeforeTest
	public void mySetup() {
	WebDriverManager.chromedriver().setup();

	 driver=new ChromeDriver();
		
	 driver.manage().window().maximize();
	 driver.get(myURL);
		
		
		
	}
	
	
	
	
}
