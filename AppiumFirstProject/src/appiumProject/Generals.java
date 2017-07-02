package appiumProject;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Generals {

	public static AndroidDriver driver;
	
	public static AndroidDriver getDriver() throws MalformedURLException{
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Nexus_5_API_23");
		cap.setCapability("browserName", "Android");
		cap.setCapability("platformVersion", "6.0");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appPackage", "com.snapwork.hdfc");
		cap.setCapability("appActivity", "com.snapwork.hdfc.HDFCBank");
		cap.setCapability("autoLaunch",false);
		
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		return driver;
		
	}
	
	public static void LaunchApp() throws Exception{
		
		driver.launchApp();
		
	}
	
	public static void click(String locator, String elementName) throws Exception{
		driver.findElement(By.xpath(locator)).click();
		
		System.out.println("Element "+ elementName + " is clicked");
	}
	
	public static void waitForVisiblity(String locator,long time,String elementName){
		
		WebDriverWait waitDriver = new WebDriverWait(driver, time);
		
		waitDriver.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locator))));
		WebElement el = driver.findElement(By.xpath(locator));
		
		if(el.isDisplayed()){
			System.out.println("Element "+ elementName + " is displayed");
		}else{
			System.out.println("Element "+ elementName + " is not displayed");
		}
		
	}
	
	public static void type(String locator, String strValue, String elementName) throws Exception{
		driver.findElement(By.xpath(locator)).sendKeys(strValue);
		
		System.out.println("Element - "+ elementName + " is Set with Value - " + strValue);
	}
	
	public static boolean isElementPresent(String locator, String elementName) throws Exception{
		
		boolean returnFlag = false;
		
		if(driver.findElement(By.xpath(locator)).isDisplayed()){
			System.out.println("Element - "+ elementName + " is present");
			returnFlag = true;
		}else{
			System.out.println("Element - "+ elementName + " is not present");
		}
		
		return returnFlag;
		
	}
	
	public static void pageWait(long time){
		try{
			Thread.sleep(time);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
