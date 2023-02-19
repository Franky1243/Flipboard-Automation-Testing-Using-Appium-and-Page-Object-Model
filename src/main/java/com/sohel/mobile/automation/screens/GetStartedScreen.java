package com.sohel.mobile.automation.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.sohel.mobile.automation.base.ScreenBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GetStartedScreen extends ScreenBase{

	public static AppiumDriver<MobileElement> driver;
	
	@AndroidFindBy(id="flipboard.app:id/first_launch_get_started_button")
	public AndroidElement getStartedBtn;
	
	public GetStartedScreen(AppiumDriver<MobileElement> driver)
	{
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickGetStartedBtn()
	{
		getStartedBtn.click();
		
		
	}
	
}
