package com.Automation.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Automation.testBase.TestBase;

public class MyAccountPage extends TestBase {

	WebDriver driver;

	@FindBy(xpath = ".//*[@id='center_column']/div/div[1]/ul/li[1]/a/span")
	WebElement Orderhistoryanddetails;

	@FindBy(xpath = ".//*[@id='center_column']/div/div[1]/ul/li[4]/a/span")
	WebElement PersonalInformation;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void MyAccountPageUpdate() {

		PersonalInformation.click();

	}

}