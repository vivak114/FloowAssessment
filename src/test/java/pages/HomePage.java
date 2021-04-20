package pages;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import tests.BaseClass;

public class HomePage extends BaseClass {

	
	
	//Verifying all screens in Home Page
	public static void VerifyPage(String pageName,String score) throws Exception{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		WebElement prevScreen = driver.findElement(By.id("com.thefloow.thefloowltd.floowdrivedemo.app:id/btn_prev"));
		WebElement nextScreen = driver.findElement(By.id("com.thefloow.thefloowltd.floowdrivedemo.app:id/btn_next"));
		WebElement pageTitle = driver.findElement(By.id("com.thefloow.thefloowltd.floowdrivedemo.app:id/score_title"));
		WebElement scoreValue = driver.findElement(By.id("com.thefloow.thefloowltd.floowdrivedemo.app:id/score"));
		List<WebElement> noofPages = driver.findElements(By.xpath("//android.widget.ImageView[contains(@resource-id,'com.thefloow.thefloowltd.floowdrivedemo.app:id/page')]"));
		
		for (int i = 0;i<noofPages.size();i++)
		{
			if(pageTitle.getText().equals(pageName)) {
				Assert.assertEquals(scoreValue.getText(), score);
				break;
			}else {
				nextScreen.click();
			}
		}
		
	}
	
	
}
