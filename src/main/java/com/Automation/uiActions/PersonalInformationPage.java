package com.Automation.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Automation.testBase.TestBase;

public class PersonalInformationPage extends TestBase {

	WebDriver driver;

	@FindBy(id = "firstname")
	WebElement firstname;

	@FindBy(id = "old_passwd")
	WebElement oldpasswd;

	@FindBy(id = "passwd")
	WebElement passwd;

	@FindBy(id = "confirmation")
	WebElement confirmation;

	@FindBy(xpath = ".//*[@id='center_column']/div/form/fieldset/div[11]/button")
	WebElement Save;

	@FindBy(xpath = ".//*[@id='center_column']/div/p")
	WebElement UpdatedSucess;

	public PersonalInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void UpdatePersonalInformation(String firstName, String oldpasswd, String passwd, String confirmation) {
		{

			this.firstname.clear();
			this.firstname.sendKeys(firstName);
			this.oldpasswd.sendKeys(oldpasswd);
			this.passwd.sendKeys(passwd);
			this.confirmation.sendKeys(confirmation);
			Save.click();

		}

	}

	public String Message() {

		return UpdatedSucess.getText();
	}
}
