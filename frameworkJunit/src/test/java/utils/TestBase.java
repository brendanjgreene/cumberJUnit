package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	WebDriver driver;
	private String browserType;
	private String url;
	
	TestBase() throws IOException{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String browser_maven = System.getProperty("browser");
		String browser_properties = prop.getProperty("browser");
		// result = testCondition ? value1 : value2
		String assignedBrowser = browser_maven!=null ? browser_maven : browser_properties;
		browserType=assignedBrowser.toLowerCase();
		String url_properties = prop.getProperty("QAurl");
		String url_maven = System.getProperty("url");
		url=url_maven!=null ? url_maven : url_properties;
		
	}
	

	public WebDriver myWebDriverManager() {
		
		ChromeOptions chromeOptions = new ChromeOptions();
        
			if (driver==null){
				switch (browserType) {
	            case "chrome": 
	        		WebDriverManager.chromedriver().setup();
	        		driver = new ChromeDriver(chromeOptions);
	        		break;
	            case "firefox":  
	            	WebDriverManager.firefoxdriver().setup();
	            	driver = new FirefoxDriver();
	        		break;
	            case "ie":
	            	WebDriverManager.iedriver().setup();
	            	driver = new InternetExplorerDriver();
	            	break;
	            case "safari":
	            	driver = new SafariDriver();
	            	break;
	            default : 
	        		WebDriverManager.chromedriver().setup();
	        		driver = new ChromeDriver(chromeOptions);
	        }
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
		
     }
	

	
	public void openLandingPage() {
		driver.get(url);
	}
	
	

}
