package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pages.NewUserRegistration;
import pages.ReuseableFunctions;
import pages.ExistingUser;
import pages.HomePage;
import pages.JourneyPage;

public class TestCases extends BaseClass {
	
	@Test(priority=1)
	public void TC1_RegisterUser() throws Exception{
		
		
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	    Date dateobj = new Date();
	    String d = df.format(dateobj).replace("/", "").replace(":", "").replace(" ", "");
		NewUserRegistration.registerNewUser("Fn"+d, "Ln"+d, "BR20QS", d+"@getnada.com");
		//ReuseableFunctions.allowAccesstoDevice();
		WebElement nextButton = driver.findElement(By.id("com.thefloow.thefloowltd.floowdrivedemo.app:id/welcome_next_button"));
		ReuseableFunctions.welcomePage();
		ReuseableFunctions.allowAccesstoDevice();
		ReuseableFunctions.verifyHomepage() ;		
	}
	
	@Test(priority=2)
	public void TC2_ExistingUser() throws Exception{
		ExistingUser.loginExistingUser("190421231215@getnada.com","Test$123");
		ReuseableFunctions.verifyHomepage() ;
	}
	
	@Test(priority=3)
	public void TC3_VerifyAllPages() throws Exception{
		ExistingUser.loginExistingUser("190421231215@getnada.com","Test$123");
		HomePage.VerifyPage("Score", "--");
		HomePage.VerifyPage("Smooth Driving", "--");
		HomePage.VerifyPage("Mobile Use", "--");
		HomePage.VerifyPage("Speed", "--");
		HomePage.VerifyPage("Fatigue", "--");
		HomePage.VerifyPage("Time of Day", "--");	
	}
	
	@Test(priority=4)
	public void TC4_VerifyJourney() throws Exception{
		ExistingUser.loginExistingUser("190421231215@getnada.com","Test$123");
		JourneyPage.journeys("No journeys yet");
	}
	
}
