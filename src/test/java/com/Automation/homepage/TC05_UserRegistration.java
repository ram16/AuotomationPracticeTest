package com.Automation.homepage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Automation.testBase.TestBase;
import com.Automation.uiActions.CreateAccount;

public class TC05_UserRegistration extends TestBase{
	
	

	CreateAccount createaccount;

	@BeforeTest
	public void setup() {
		init();
	
	}
	
	@Test
	public void UserRegistration(String firstName, String lastName, String password, String day, String month, String year) throws InterruptedException{
	//	CreateAccount	createaccount = new createaccount();
		createaccount.selectMrRadionButton();
		createaccount.enterFirstName(firstName);
		createaccount.enterLastName(lastName);
		createaccount.enterPassowrd(password);
		createaccount.selectDaysInDropDown(day);
		createaccount.selectMonthInDropDown(month);
		createaccount.selectYearInDropDown(year);
		createaccount.enterYourAddressFirstName("FirstName");
		createaccount.enterYourAddressLastName("LastName");
		createaccount.enterYourAddressPrimary("Primary Address");
		createaccount.enterYourAddressSecondry("Secondary Address");
		createaccount.enterYourAddressCityName("UnitedKigndom");
		createaccount.selectYourAddressState("London");
		createaccount.enterYourAddressZipCode();
		createaccount.selectYourAddressCountry();
		createaccount.enterYourAddressMobilePhone();
		createaccount.clickOnRegister();
	}
	
	@AfterTest
	public void endTest() {
		driver.close();

	}

}
