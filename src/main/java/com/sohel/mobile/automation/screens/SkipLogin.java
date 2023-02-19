package com.sohel.mobile.automation.screens;

import org.openqa.selenium.support.PageFactory;

import com.sohel.mobile.automation.base.ScreenBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SkipLogin extends ScreenBase {

	public static AppiumDriver<MobileElement> driver;
	
	public SkipLogin(AppiumDriver<MobileElement> driver)
	{
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="flipboard.app:id/account_login_buttons_skip")
	public AndroidElement skipButton;
	
	public void skipButton()
	{
		skipButton.click();
	}
	
}
