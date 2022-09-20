package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.GenericUtils;

public class LandingPage {
	
	private WebDriver driver;
	private GenericUtils genUtils;


	public LandingPage(WebDriver driver) {
		this.driver=driver;
		genUtils = new GenericUtils(driver);
	}

	private By search = By.xpath("//input[@type='search']");
	private By productName = By.xpath("//h4[@class='product-name']");
	private By dealLink=By.linkText("Top Deals");
	private By increment=By.cssSelector(".increment");
	private By addToCart=By.xpath("//button[contains(.,'ADD TO CART')]");
	private By cartIcon=By.cssSelector(".cart-icon");
	private By proceedToCheckout=By.xpath("//button[contains(.,'PROCEED TO CHECKOUT')]");
	
	public void doSearch(String searchFor) throws InterruptedException {
		System.out.println("searching on landing page for "+searchFor);
		driver.findElement(search).sendKeys(searchFor);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.numberOfElementsToBeLessThan(productName, 2));
	}
	
	public void switchToOffersPage() throws InterruptedException {
		driver.findElement(dealLink).click();
	    genUtils.switchNewTab();
	}

	
	
	public String getProductName() {
		String fullString = driver.findElement(productName).getText();
		String pName = fullString.split(" - ")[0];
		System.out.println("product name on landing Page "+pName);
		return pName;
	}
	
	public void increment(Integer number) {
		
		while (number>1) {
			driver.findElement(increment).click();
			number--;
		}
	}
	
	public void clickAddtoCart() {
		driver.findElement(addToCart).click();;
	}
	
	public void clickCartIcon() {
		driver.findElement(cartIcon).click();
	}
	public void clickProceedToCheckout() {
		driver.findElement(proceedToCheckout).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(proceedToCheckout));
	}
	
}
