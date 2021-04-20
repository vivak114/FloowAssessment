package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;


public class BaseClass {
	
	public static AppiumDriver driver;
	
	@BeforeTest
	public void setup() throws Exception {
		System.out.println("Floow Assessment test run");
	
	}
	@BeforeMethod
	public void init() throws Exception{
		DesiredCapabilities cap = new DesiredCapabilities(); 
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "SamsungNote9");
		cap.setCapability(MobileCapabilityType.UDID, "2899bba9f81c7ece");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "5000");
		cap.setCapability("appPackage", "com.thefloow.thefloowltd.floowdrivedemo.app");
		cap.setCapability("appActivity", "com.thefloow.turnkey.ui.launcher.LauncherActivity");
		URL url;
		url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url,cap);
		System.out.println("Application started");
	}
	
	@AfterMethod
	public void aftereachtestcase() {
		//driver.close();
		driver.quit();
		System.out.println("Driver quited");
		
	}
	
	@AfterTest
	public void tesrDown() {
		System.out.println("Tests Completed");
	}

}
