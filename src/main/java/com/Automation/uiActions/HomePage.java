package com.Automation.uiActions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Automation.testBase.TestBase;

public class HomePage extends TestBase {

	public final String tshirts = "T-shirts";

	public final String casualDresses = "Casual Dresses";

	public final String women = "Women";

	WebDriver driver;

	@FindBy(xpath = ".//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;

	@FindBy(xpath = ".//*[@id='email']")
	WebElement logInEmailAddress;

	@FindBy(xpath = ".//*[@id='passwd']")
	WebElement loginPassword;

	@FindBy(xpath = ".//*[@id='SubmitLogin']")
	WebElement SubmitButton;

	@FindBy(xpath = ".//*[@id='center_column']/div[1]/ol/li")
	WebElement Authenticationfailed;

	@FindBy(xpath = ".//*[@id='center_column']/p")
	WebElement Authenticationpassed;

	@FindBy(xpath = "//a[contains(@class,'sf-with-ul') and contains(text(),'women')]")
	WebElement Women;
	
	@FindBy(xpath = ".//*[@class='price product-price']")
	WebElement Price;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginToApplication(String emailAddress, String password) throws InterruptedException {
		
		signIn.click();
		Thread.sleep(3000);
		logInEmailAddress.sendKeys(emailAddress);
		loginPassword.sendKeys(password);
		SubmitButton.click();

	}

	public String getAuthenticationpassed() throws InterruptedException {
		Thread.sleep(3000);
		return Authenticationpassed.getText();
	}

	public void moveMouseOver(String Categery) {
		WebElement menu = driver
				.findElement(By.xpath(".//a[contains(@class,'sf-with-ul') and contains(text(),'" + Categery + "')]"));

		Actions builder = new Actions(driver);

		builder.moveToElement(menu).build().perform();

	}


	public void ClickOnCategory(String Categery) {
		WebElement menu = driver
				.findElement(By.xpath(".//a[contains(@class,'sf-with-ul') and contains(text(),'" + Categery + "')]"));
		menu.click();

//		Actions builder = new Actions(driver);
//
//		builder.moveToElement(menu).build().perform();

	}

	
	public void clickOnProductInWomensSection(String Product) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath(".//a[contains(@class,'sf-with-ul') and contains(text(),'Women')]/following-sibling::ul/child::li/child::ul/child::li/child::a[contains(text(),"
						+ "'"
						+ Product + "')]")));
		;
		WebElement menuOption = driver.findElement(By
				.xpath(".//a[contains(@class,'sf-with-ul') and contains(text(),'Women')]/following-sibling::ul/child::li/child::ul/child::li/child::a[contains(text(),'"
						+ Product + "')]"));
		menuOption.click();
	}

	public void dropdown(String String) throws InterruptedException {
	
        WebElement MyselectElement = driver.findElement(By.xpath(".//*[@id='selectProductSort']"));
        JavascriptExecutor js = ((JavascriptExecutor) driver);
		// This:
		js.executeScript("arguments[0].scrollIntoView(true);", MyselectElement);
		//targetElement.click();
		Select dropdown= new Select(MyselectElement);
		dropdown.selectByVisibleText(String);
	
		//Select	drpdown = new selectByVisibleText(string);
		
		
		// Or maybe even just:
		//js.executeScript("arguments[0].click();", targetElement);
		// TODO Auto-generated method stub
		
	}
	
	public void SelecMaxPriceItem(){
		 
		List<WebElement> price =  driver.findElements(By.xpath(".//*[@class='price product-price']"));
		ArrayList<Integer> prices=new ArrayList<Integer>();
		for(int i=0;i<price.size();i++){
		Integer priceInt = Integer.valueOf(prices.get(i));
		prices.add(priceInt);
		Integer maxPrice = Collections.max(prices);
		if (priceInt.equals(maxPrice)) {
			price.get(i).click();
			break;
			}
		}
	}
}



