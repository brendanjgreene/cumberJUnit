package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class CheckoutStepPageDefinitions {
	
	
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	CheckoutPage checkoutPage;
	
	public CheckoutStepPageDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
		this.checkoutPage=testContextSetup.pageObjectManager.getCheckoutPage();
	}
	
	@Then("check if cart is as expected")
	public void check_if_cart_is_as_expected() {
		
		checkoutPage.onCheckout();
		checkoutPage.checkQuantity(testContextSetup.num);
		checkoutPage.checkProName(testContextSetup.fullName);
		Assert.assertTrue(checkoutPage.isPromoButton());
		Assert.assertTrue(checkoutPage.isplaceOrderButton());
	}
}
