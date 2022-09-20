package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {

	public WebDriver driver;
	public String searchString;
	public String fullName;
	public String firstProduct;
	public TestBase testBase;
	public PageObjectManager pageObjectManager;
	public GenericUtils genUtils;
	public int num;
	
	public TestContextSetup() throws IOException {
		testBase = new TestBase();
		genUtils = new GenericUtils(driver);
		driver=testBase.myWebDriverManager();
		pageObjectManager=new PageObjectManager(driver);
	}
	
	
}
