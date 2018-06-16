package com.Automation.homepage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Automation.testBase.TestBase;
import com.Automation.uiActions.HomePage;
import com.Automation.uiActions.ProductDetailsPage;



public class TC02_VerifyAddToCart extends TestBase{
	
	HomePage homepage;
	ProductDetailsPage productDetailsPage;

	@BeforeTest
	public void setup() {
		init();
	}

	@Test
	public void VerifyItemsInOrderHistory () throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.loginToApplication("panjala.ramu16@gmail.com", "password321");
		Assert.assertEquals(homepage.getAuthenticationpassed(),
				"Welcome to your account. Here you can manage all of your personal information and orders.");
		homepage.moveMouseOver(homepage.women);
		homepage.clickOnProductInWomensSection(homepage.tshirts);
		productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.selectProdut(productDetailsPage.FadedShortSleeveTshirts);
		productDetailsPage.addToCart();
		productDetailsPage.ShippingcheckboxToClick();
		productDetailsPage.PaymentByWire();
		productDetailsPage.OrderConfirmation();
		Assert.assertEquals(productDetailsPage.getConfirmationOfOrderDone(), "Your order on My Store is complete.");

	}



	@AfterTest
	public void endTest() {
		driver.close();

	}
}


