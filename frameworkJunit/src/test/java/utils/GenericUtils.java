package utils;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class GenericUtils {
	
	private WebDriver driver;

	public GenericUtils(WebDriver driver) {
		this.driver=driver;
	}

	public void switchNewTab() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	    String newTab = tabs.get(1);
	    driver.switchTo().window(newTab);
	}
	
	public void checkURL(String expected) {
		String actualURL = driver.getCurrentUrl();
		System.out.println(actualURL);
		System.out.println(expected);
		Assert.assertTrue(actualURL.endsWith(expected));
	}
	
}
