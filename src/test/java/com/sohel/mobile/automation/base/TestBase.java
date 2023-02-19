package com.sohel.mobile.automation.base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.sohel.mobile.automation.utilities.AppiumServer;
import com.sohel.mobile.automation.utilities.CommonUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestBase {

	public static AppiumDriver<MobileElement> driver;
	public static Logger log = Logger.getLogger(TestBase.class);
	public static String LoadPropertyFile = "flipboard_properties.properties";
	
	
	public void setup()
	{
		if(driver == null)
		{
			PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\log4j.properties");
			
			if(LoadPropertyFile.startsWith("flipboard_"))
			{
				
				AppiumServer.start();
				log.info("Server Successfully Started");
				
				CommonUtils.loadAndroidConfProp(LoadPropertyFile);
				log.info(LoadPropertyFile+" Property file loaded.");
				
				CommonUtils.setAndroidCapabilities();
				driver = CommonUtils.getAndroidDriver();
			}
			else if(LoadPropertyFile.startsWith("IOS_"))
			{
				
			}
		}
	}
	
	public void quit() throws InterruptedException
	{
		try {
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		driver.quit();
		log.info("Test Cases executed successfully");
		AppiumServer.quitService();
		log.info("Server stopped");
		
	}
	
	
}
