 package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	
	private WebDriver driver;

	public OffersPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By search = By.xpath("//input[@type='search']");
	private By firstProduct=By.xpath("//tr[1]//td[1]");
	
	
	public void searchOffers(String searchOffersString) throws InterruptedException {
		driver.findElement(search).sendKeys(searchOffersString);

	}
	public String getFistProductName() {
		String firstP = driver.findElement(firstProduct).getText();
	    System.out.println("product name on offer Page "+firstP);
	    return firstP;
	}
	
}
