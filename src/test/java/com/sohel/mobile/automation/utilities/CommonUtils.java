package com.sohel.mobile.automation.utilities;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class CommonUtils {

	public static AppiumDriver<MobileElement> driver;
	public static DesiredCapabilities capabilities = new DesiredCapabilities();
	public static URL serverurl;
	public static String BASE_PKG;
	public static String BASE_ACTIVITY;
	public static String BROWSER_NAME;
	public static String PLATFORM_NAME;
	public static String PLATFORM_VERSION;
	public static String DEVICE_NAME;
	public static String APPIUM_PORT;
	public static String APP_PATH;
	public static int IMPLICIT_WAIT_TIME;
	public static int EXPLICIT_WAIT_TIME;
	
	public static Properties prop = new Properties();
	public static FileInputStream fis;
	
	public static void loadAndroidConfProp(String LoadPropertyFile)
	{
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir")+"/src/test/resources/properties/" + LoadPropertyFile);
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		try {
			prop.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		IMPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("implicit.wait"));
		EXPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("explicit.wait"));
		BASE_PKG = prop.getProperty("base.pgk");
		BASE_ACTIVITY = prop.getProperty("base.activity");
		BROWSER_NAME = prop.getProperty("browser.name");
		PLATFORM_NAME = prop.getProperty("platform.name");
		PLATFORM_VERSION = prop.getProperty("platform.version");
		DEVICE_NAME = prop.getProperty("Android Emulator");
		APPIUM_PORT = prop.getProperty("appium.server.port");
		APP_PATH = prop.getProperty("application.path");
		
		
		
	}
	
	public static void setAndroidCapabilities()
	{
		
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, BASE_PKG);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, BASE_ACTIVITY);
		
	}
	
	public static void loadIOSConfProp()
	{
		
	}
	
	public static void setIOSCapabilities()
	{
		
	}
	
	public static AppiumDriver<MobileElement> getAndroidDriver()
	{
		try {
			serverurl = new URL("http://localhost:" + APPIUM_PORT + "/wd/hub");
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		
		driver = new AndroidDriver<MobileElement>(serverurl, capabilities);
		return driver;
		
	}
	
	
	
}
