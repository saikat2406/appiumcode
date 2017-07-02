package appiumProject;

import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AppiumHDFCWeb {

	public static void main(String args[]) throws Exception{
		
		AndroidDriver driver;
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Nexus_5_API_23");
		cap.setCapability("browserName", "Browser");
		cap.setCapability("platformVersion", "6.0");
		cap.setCapability("platformName", "Android");
//		cap.setCapability("appPackage", "com.android.chrome");
//		cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		//cap.setCapability("autoLaunch",false);
		
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		driver.get("http://www.hdfcbank.com/personal/login");
		
		Generals.pageWait(25000);
		
//		Set<String> context = driver.getContextHandles();
//		for(String con:context){
//			System.out.println(con);
//			if(con.contains("WEBVIEW")){
//				driver.context(con);
//			}
//		}
		
		
		Generals.pageWait(5000);
		
		//driver.findElement(By.xpath("//android.view.View[@content-desc='login']")).click();
		//Generals.click("//android.view.View[@content-desc='login']", "Take To Login Page Button");
		
		Generals.pageWait(5000);
		System.out.println("Now Click");
		Generals.click("//android.view.View[@content-desc='Continue to Netbanking']", "Continue To Netbanking Link");
		
		Generals.pageWait(5000);
		
		Generals.type("//android.widget.EditText[@index='0']", "41812350", "Username Field");
		
		Generals.pageWait(5000);
		
		Generals.click("//android.widget.Button[@content-desc='Continue']", "Continue Button");
		
		Generals.pageWait(5000);
				
		if(Generals.isElementPresent("//android.widget.EditText[@content-desc='This is my zone']", "My Zone")){
			System.out.println("Username Correct");
		}else{
			System.out.println("Username Is Incorrect");
		}
		
	}
	
}
