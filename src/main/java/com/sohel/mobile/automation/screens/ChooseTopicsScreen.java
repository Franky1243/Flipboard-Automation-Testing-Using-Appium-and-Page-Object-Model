package com.sohel.mobile.automation.screens;

import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sohel.mobile.automation.base.ScreenBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ChooseTopicsScreen extends ScreenBase {

	public static AppiumDriver<MobileElement> driver;
	public WebDriverWait wait;
	
	public ChooseTopicsScreen(AppiumDriver<MobileElement> driver)
	{
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="flipboard.app:id/topic_picker_topic_row_topic_tag")
	public List <AndroidElement> topic;
	
	@AndroidFindBy(id="flipboard.app:id/topic_picker_continue_button")
	public MobileElement pickerContinueBtn;
	
	@AndroidFindBy(id="flipboard.app:id/icon_button_text")
	public MobileElement anotherContinueBtn;
	
	public ChooseTopicsScreen chooseTopics(int topicsCount)
	{
		for(int i = 0 ; i < topicsCount ; i++)
		{
			topic.get(i).click();
		}
		return this;
	}
	
	public void clickOnContinueBtn()
	{
		pickerContinueBtn.click();
	}
	
	public void clickOnAnotherContinueBtn()
	{
		anotherContinueBtn.click();
	}
	
}
