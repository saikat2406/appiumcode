package appiumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumHDFCApp {
	public static void main(String args[]) throws Exception{
		System.out.println("Start");
		AndroidDriver driver = Generals.getDriver();
		System.out.println("End");
		try{
			
			Generals.pageWait(5000);
			
			Generals.LaunchApp();
			
			Thread.sleep(10000);
			
			
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			//Initializing Xpaths
			
			WebElement loginButton = driver.findElement(By.xpath(AppiumConstants.LOGIN_BUTTON));
			
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			Generals.waitForVisiblity(AppiumConstants.LOGIN_BUTTON, 45000, "Home Page");
			
			Generals.waitForVisiblity(AppiumConstants.CUSTID_TAB, 45000, "Customer ID Tab");
			Generals.click(AppiumConstants.CUSTID_TAB,"Customer ID Tab");
			
			Generals.waitForVisiblity(AppiumConstants.CUSTID_FIELD, 45000, "Customer ID Textbox");			
			if(Generals.isElementPresent(AppiumConstants.CUSTID_FIELD, "Customer ID Textbox")){
				Generals.type(AppiumConstants.CUSTID_FIELD, "41812350", "Customer ID Textbox");
				Generals.waitForVisiblity(AppiumConstants.CONTINUE_BTN, 45000, "Continue Button");
				Generals.click(AppiumConstants.CONTINUE_BTN,"Continue Button");
			}
			
			Generals.pageWait(10000);
			
			Generals.waitForVisiblity(AppiumConstants.PWD_FIELD, 45000, "Password Field");
			if(Generals.isElementPresent(AppiumConstants.PWD_FIELD, "Password Field")){
				Generals.type(AppiumConstants.PWD_FIELD, "fifa@0006", "Password field");
				Generals.pageWait(5000);
				Generals.click(AppiumConstants.CHECKBOX, "Confirmation Checkbox");
				Generals.pageWait(5000);
				Generals.click(AppiumConstants.LOGIN_BUTTON, "Login Button");
				
				Generals.pageWait(10000);
				Generals.waitForVisiblity(AppiumConstants.HDFC_HEADER, 45000, "HDFC Dashboard");
				Generals.click(AppiumConstants.ACCT_SUMMARY, "Account Summary Section");
				Generals.pageWait(5000);
				Generals.waitForVisiblity(AppiumConstants.ACCT_BALANCE, 45000, "Account Balance Details");
				Generals.pageWait(5000);
				System.out.println(driver.findElement(By.xpath(AppiumConstants.ACCT_BALANCE)).getAttribute("name"));
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
