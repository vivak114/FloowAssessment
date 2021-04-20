package pages;
import tests.BaseClass;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NewUserRegistration extends BaseClass {
		
		//Register new user
		public static void registerNewUser(String FirstName, String LastName, String Postcode, String EmailAddress) throws Exception{
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.findElement(By.id("com.thefloow.thefloowltd.floowdrivedemo.app:id/email_input")).sendKeys(EmailAddress);
			List<WebElement> pwd = driver.findElements(By.id("com.thefloow.thefloowltd.floowdrivedemo.app:id/unknown_input"));		
			for(int i = 0; i<2;i++) {
				pwd.get(i).sendKeys("Test$123");
			}
			List<WebElement> name = driver.findElements(By.id("com.thefloow.thefloowltd.floowdrivedemo.app:id/name_input"));
			name.get(0).sendKeys(FirstName);
			name.get(1).sendKeys(LastName);
			pwd.get(2).sendKeys(Postcode);
			driver.findElement(By.id("com.thefloow.thefloowltd.floowdrivedemo.app:id/chk_agree")).click();
			driver.findElement(By.id("com.thefloow.thefloowltd.floowdrivedemo.app:id/btn_register")).click();
			
		}
	
}

