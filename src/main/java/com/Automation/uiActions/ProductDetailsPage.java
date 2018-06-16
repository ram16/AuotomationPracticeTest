package com.Automation.uiActions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Automation.testBase.TestBase;

public class ProductDetailsPage extends TestBase {

	public final String FadedShortSleeveTshirts = "Faded Short Sleeve T-shirts";

	@FindBy(xpath = ".//*[@id='add_to_cart']/button")
	WebElement AddToCart;

	@FindBy(xpath = ".//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")
	WebElement AddToCartLayerCart;

	@FindBy(xpath = ".//*[@id='center_column']/p[2]/a[1]/span")
	WebElement AddToCartCenter_Summary;

	@FindBy(xpath = ".//*[@id='center_column']/form/p/button")
	WebElement AddToCartCenter_Address;

	@FindBy(xpath = ".//*[@id='form']/p/button")
	WebElement AddToCartCenter_Shipping;

	@FindBy(xpath = ".//*[@id='HOOK_PAYMENT']/div[1]/div/p/a")
	WebElement PaymentByWire;

	@FindBy(xpath = ".//*[@id='HOOK_PAYMENT']/div[2]/div/p/a")
	WebElement PaymentByCheck;

	@FindBy(xpath = ".//*[@id='cart_navigation']/button")
	WebElement OrderConfirmation;

	@FindBy(xpath = ".//*[@id='center_column']/div/p/strong")
	WebElement OrderCompleted;

	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectProdut(String Product) {

		driver.findElement(By.xpath(" //a[(contains(text(),'" + Product + "'))]")).click();

	}

	public List<WebElement> selectProduct() {
		List<WebElement> element = driver.findElements(By.xpath(".//*[@id='center_column']/ul/li"));
		return element;
	}
	
	
	public void addToCart() {
		AddToCart.click();
		waitForElement(driver, 30, AddToCartLayerCart);
		AddToCartLayerCart.click();
		AddToCartCenter_Summary.click();
		AddToCartCenter_Address.click();

	}

	public void ShippingcheckboxToClick() {

		String locator = "//input[@type='checkbox']";
		WebElement CheckBox1 = driver.findElement(By.xpath(locator));
		CheckBox1.click();
		AddToCartCenter_Shipping.click();

	}

	public void PaymentByWire() {
		PaymentByWire.click();
	}

	public void PaymentByCheck() {
		PaymentByCheck.click();
	}

	public void OrderConfirmation() {
		OrderConfirmation.click();

	}

	public String getConfirmationOfOrderDone() throws InterruptedException {

		Thread.sleep(3000);
		return OrderCompleted.getText();

	}
}
