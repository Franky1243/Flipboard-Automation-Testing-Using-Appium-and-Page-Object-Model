package com.sohel.mobile.automation.base;

import java.awt.event.KeyEvent;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;

public class ScreenBase {

	public static AppiumDriver<MobileElement> driver;
	public WebDriverWait wait;
	
	public ScreenBase(AppiumDriver<MobileElement> driver)
	{
		ScreenBase.driver = driver;
	}
	
	public void hideKeyboard()
	{
		driver.hideKeyboard();
	}
	
	
	
}
