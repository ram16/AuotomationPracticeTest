package com.Automation.homepage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Automation.testBase.TestBase;
import com.Automation.uiActions.HomePage;

public class TC01_VerifyLoginWithValidCredentails extends TestBase {

	HomePage homepage;

	@BeforeTest
	public void setup() {
		init();
	}

	@Test
	public void VerifyLoginWithValidCredentails() throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.loginToApplication("panjala.ramu16@gmail.com", "password321");
		Assert.assertEquals(homepage.getAuthenticationpassed(),
				"Welcome to your account. Here you can manage all of your personal information and orders.");

	}

	@AfterTest
	public void endTest() {
		driver.close();

	}
}