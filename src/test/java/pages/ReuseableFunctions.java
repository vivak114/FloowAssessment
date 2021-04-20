package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import tests.BaseClass;

public class ReuseableFunctions extends BaseClass{
	//AllowAccesstodevice after login
			public static void allowAccesstoDevice() throws Exception{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Assert.assertEquals(driver.findElement(By.id("com.thefloow.thefloowltd.floowdrivedemo.app:id/onboarding_header")).getText(), "Allow Location");
				Assert.assertEquals(driver.findElement(By.id("com.thefloow.thefloowltd.floowdrivedemo.app:id/onboarding_body")).getText(), "To track your journeys accurately, select 'Allow all the time'");
				driver.findElement(By.id("com.thefloow.thefloowltd.floowdrivedemo.app:id/onboarding_button")).click();
				driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
				Assert.assertEquals(driver.findElement(By.id("com.thefloow.thefloowltd.floowdrivedemo.app:id/onboarding_header")).getText(), "Allow physical activity");
				Assert.assertEquals(driver.findElement(By.id("com.thefloow.thefloowltd.floowdrivedemo.app:id/onboarding_body")).getText(), "To know when you start and end your journeys 'Allow' physical activity");
				driver.findElement(By.id("com.thefloow.thefloowltd.floowdrivedemo.app:id/onboarding_button")).click();
				driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
				
			}
			
			//Verifying after login
			public static void verifyHomepage() throws Exception{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Assert.assertTrue(driver.findElement(By.id("com.thefloow.thefloowltd.floowdrivedemo.app:id/dashboard_navigation_logo")).isDisplayed());
			}
			
			//Validating welcome page
			public static void welcomePage() throws Exception{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement nextButton = driver.findElement(By.id("com.thefloow.thefloowltd.floowdrivedemo.app:id/welcome_next_button"));
			Assert.assertTrue(driver.findElement(By.id("com.thefloow.thefloowltd.floowdrivedemo.app:id/welcome_page_image")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='Improve your driving']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='Use FloowDrive to learn about how well you drive on a scale 1 - 100. The higher the score, the better your driving behaviour is.']")).isDisplayed());
			nextButton.click();
			Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='Save on your insurance']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='The better your driving scores are, the less you pay for your car insurance.']")).isDisplayed());
			driver.findElement(By.id("com.thefloow.thefloowltd.floowdrivedemo.app:id/welcome_continue_button")).click();
			}
}
