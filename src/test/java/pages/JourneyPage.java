package pages;
import org.openqa.selenium.By;
import org.testng.Assert;

import tests.BaseClass;

public class JourneyPage extends BaseClass {

	
	//Verifying all screens in Home Page
		public static void journeys(String journey) throws Exception{
			
			driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"JourneyList\"]")).click();
			
			
			if(journey.equals("No journeys yet"))
			{
				Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='No journeys yet']")).isDisplayed());
			}
		}
}
