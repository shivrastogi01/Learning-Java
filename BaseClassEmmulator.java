package tests;

import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClassEmmulator {
	
	public static AppiumDriver<MobileElement> driver;

	public void setup() {
		
		try {
		DesiredCapabilities caps= new DesiredCapabilities();
		

		//caps.setCapability("platformName", "ANDROID");
		caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5");
		caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 3000);
		caps.setCapability("appPackage", "com.snapchat.android");
		caps.setCapability("appActivity", "com.snap.mushroom.MainActivity");
		caps.setCapability("isHeadless", true);
		
		//caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		
		driver =new AppiumDriver<MobileElement>(url,caps);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		System.out.println("Base Class executed successfully");
		MobileDriver.setDriver(driver);
		
		}catch(Exception exp) {
			System.out.println("Cause is :"+exp.getCause());
			System.out.println("Message is :" +exp.getMessage());
			exp.printStackTrace();
			
			
		}
		
		
	}
	
	public void teardown() {
		driver.close();
		driver.quit();
		
	}
	public String getMonth() {
		// TODO Auto-generated method stub
		String month[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		int monthVal = new Random().nextInt(month.length);
		String actualMonth = (month[monthVal]);
		return actualMonth;			

	}
	
	public String getDate() {
		// TODO Auto-generated method stub
		String date[] = {"01","02","03","04","05","06","07","08","09","10","11","12","13","22","23","24","25","26","27","28","17","19","18","21"};
		int dateVal = new Random().nextInt(date.length);
		String actualDate = (date[dateVal]);
		return actualDate;			
	}
	
	public String getYear() {
		// TODO Auto-generated method stub
		String year[] = {"1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000"};
		int yearVal = new Random().nextInt(year.length);
		String actualYear = (year[yearVal]);
		return actualYear;			

	}

}
