import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Testcases extends Parameters {
	
	
	@Test(priority = 1)
	public void getTitle() { 
	String myActual=driver.getTitle();
	mySoftAssert.assertEquals(exbectedTitel, myActual);
	mySoftAssert.assertAll();	
		
	}
	
	@Test(priority = 2)
	public void  cheack_the_image_drawer () {
	List < WebElement>MyImages=driver.findElements(By.className("img-fluid"));
	boolean MyImages_cheack1= MyImages.get(0).getAttribute("src")==MyImages.get(1).getAttribute("src");
	boolean MyImages_cheack2= MyImages.get(1).getAttribute("src")==MyImages.get(2).getAttribute("src");
	boolean MyImages_cheack3= MyImages.get(2).getAttribute("src")==MyImages.get(0).getAttribute("src");
	
	mySoftAssert.assertEquals(MyImages_cheack1, false,"image one with image tow ");
	mySoftAssert.assertEquals(MyImages_cheack2, false,"image tow  with image three ");
	mySoftAssert.assertEquals(MyImages_cheack3, false,"image three with image one");
	
	
	mySoftAssert.assertAll();
	}
	
	@Test(priority = 3)
	public void  validate_the_contact_from_information () throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String name_of_emails[] ={"al@gmailnet ","a9gmail.edu","al@gmailnet","uu887@gmail.com","gmail.jo"};
		Random rand =new Random();
		int index =rand.nextInt(4);
		driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a")).click();
		Thread.sleep(3);
		driver.findElement(By.xpath("//*[@id=\"recipient-email\"]")).sendKeys(name_of_emails[index]);
		Thread.sleep(3);
		 String myValue =driver.findElement(By.xpath("//*[@id=\\\"recipient-email\\\"]")).getAttribute("value");
		
		 String regex ="^[A-Za-Z0+9_.-]+@(.+)+.(.+)$";
		 Pattern  pattren =  Pattern.compile(regex);
		 Matcher matcher=pattren.matcher(name_of_emails[index]);
		 System.out.println("***********************");
			
		 System.out.println(name_of_emails[index]+"is valid email"+matcher.matches());
		 System.out.println("***********************");
			boolean myCheackProcessForTheEmaile=matcher.matches();
			mySoftAssert1.assertEquals(myCheackProcessForTheEmaile, true, "the email structure is not matching the correct one");
			mySoftAssert1.assertAll();
		
	}
	
	
	
	
	
	
	
}
