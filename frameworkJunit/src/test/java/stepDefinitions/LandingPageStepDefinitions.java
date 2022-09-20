package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class LandingPageStepDefinitions {
	
	String firstProduct;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	LandingPage landingPage;
	
	public LandingPageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
		this.landingPage=testContextSetup.pageObjectManager.getLandingPage();
	}
	
	@Given("User on Green Cart Landing Page")
	public void user_on_green_cart_landing_page() {
		testContextSetup.testBase.openLandingPage();
	}
	
	@When("^user search with shortname (.+) and extracts name of product$")
	public void user_search_with_shortname_and_extracts_name_of_product(String searchFor) throws InterruptedException {
		testContextSetup.searchString=searchFor;
		
		landingPage.doSearch(searchFor);
	    testContextSetup.fullName=landingPage.getProductName();
	    
	}
	
	@When("^adds (.+) to cart$")
	public void adds_number_to_cart(int number) throws InterruptedException {
		testContextSetup.num=number;
	    landingPage.increment(number);
	    
	    landingPage.clickAddtoCart();
//	    Thread.sleep(1000);
	}
	
	@Then("proceeds to checkout")
	public void proceeds_to_checkout() throws InterruptedException {
	    landingPage.clickCartIcon();
	    landingPage.clickProceedToCheckout();
//	    Thread.sleep(5000);
	}
	
}
