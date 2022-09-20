package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import utils.GenericUtils;

public class CheckoutPage {

	private GenericUtils genUtils;
	private WebDriver driver;
	

	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
		this.genUtils = new GenericUtils(driver);
	}
	
	private By quantity=By.cssSelector(".quantity");
	private By proName=By.cssSelector(".product-name");
	private By promoBtn = By.cssSelector(".promoBtn");
	private By placeOrder = By.xpath("//button[contains(.,'Place Order')]");
	
	public void onCheckout() {
		genUtils.checkURL("cart");
	}
	
	
	public void checkQuantity(int i) {
		int qt = Integer.parseInt(driver.findElement(quantity).getText());
		System.out.println("expected amount "+i);
		System.out.println("actual amount "+qt);
		Assert.assertEquals(qt, i);
	}
	
	public void checkProName(String n) {
		System.out.println("expected name "+n);
		System.out.println("actual name "+driver.findElement(proName).getText());
		Assert.assertTrue(driver.findElement(proName).getText().startsWith(n));
	}
	
	public boolean isPromoButton() {
		return driver.findElement(promoBtn).isDisplayed();
	}
	
	public boolean isplaceOrderButton() {
		return driver.findElement(placeOrder).isDisplayed();
	}
}
