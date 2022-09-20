package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinitions {
	
	
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	OffersPage offersPage;
	LandingPage landingPage;
	
	public OfferPageStepDefinitions(TestContextSetup testContextSetup) {
		
		this.testContextSetup=testContextSetup;
		this.offersPage=testContextSetup.pageObjectManager.getOffersPage();
		this.landingPage=testContextSetup.pageObjectManager.getLandingPage();
		
	}
	
	@Then("user search with same shortname on offers page")
	public void user_search_with_same_shortname_on_offers_page_to_check_if_product_exists() throws InterruptedException {
		
		landingPage.switchToOffersPage();
		offersPage.searchOffers(testContextSetup.searchString);
		testContextSetup.firstProduct=offersPage.getFistProductName();
		
	}

	@Then("check if product exists")
	public void check_if_product_exists() {
		
	    Assert.assertEquals(testContextSetup.firstProduct, testContextSetup.fullName);

	}
	
	
	
}
