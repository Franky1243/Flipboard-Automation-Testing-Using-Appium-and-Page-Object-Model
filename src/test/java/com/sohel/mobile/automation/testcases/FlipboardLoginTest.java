package com.sohel.mobile.automation.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sohel.mobile.automation.base.TestBase;
import com.sohel.mobile.automation.screens.ChooseTopicsScreen;
import com.sohel.mobile.automation.screens.GetStartedScreen;
import com.sohel.mobile.automation.screens.SkipLogin;
import com.sohel.mobile.automation.utilities.ScrollUtil;

public class FlipboardLoginTest extends TestBase{

	GetStartedScreen getStartedScreenObject;
	ChooseTopicsScreen chooseTopicsScreenObject;
	SkipLogin skipLoginObject;
	
	@BeforeTest
	public void init()
	{
		setup();
		getStartedScreenObject = new GetStartedScreen(driver);
		chooseTopicsScreenObject = new ChooseTopicsScreen(driver);
		skipLoginObject = new SkipLogin(driver);
	}
	
	@Test(priority = 1)
	public void validateGetStartedScreen() throws InterruptedException
	{
		getStartedScreenObject.clickGetStartedBtn();
		Thread.sleep(10000);
	}
	
	@Test(priority = 2)
	public void validateChooseTopicsScreen() throws InterruptedException
	{
		chooseTopicsScreenObject.chooseTopics(4).clickOnContinueBtn();
		Thread.sleep(3000);
		chooseTopicsScreenObject.clickOnAnotherContinueBtn();
		
	}
	
	@Test(priority = 3)
	public void validateSkipLogin() throws InterruptedException
	{
		skipLoginObject.skipButton();
		Thread.sleep(4000);
		ScrollUtil.scrollUp(3, driver);
	}
	
	@AfterTest
	public void quitDriver() throws InterruptedException {
		quit();
	}
	
	
}
