package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import tests.BaseClass;

public class ExistingUser extends BaseClass {
	//Login using existing user
			public static void loginExistingUser(String UserName, String Password) throws Exception {
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.findElement(By.id("com.thefloow.thefloowltd.floowdrivedemo.app:id/btn_already_registered")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("com.thefloow.thefloowltd.floowdrivedemo.app:id/email_input")).sendKeys(UserName);
				driver.findElement(By.id("com.thefloow.thefloowltd.floowdrivedemo.app:id/unknown_input")).sendKeys(Password);
				driver.findElement(By.id("com.thefloow.thefloowltd.floowdrivedemo.app:id/btn_login")).click();
				ReuseableFunctions.allowAccesstoDevice();
			}
}
