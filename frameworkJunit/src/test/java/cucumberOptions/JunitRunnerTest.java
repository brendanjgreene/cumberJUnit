package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features",
		glue ="stepDefinitions",
//		dryRun=true,
//		tags ="@OffersPage",
//		tags ="@PlaceOrder",
		monochrome=true,
		plugin= {
				"pretty","html:target/cucumber.html", 
				"json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failed_scenarios.txt"
				}
		)
public class JunitRunnerTest{
	
	
}
