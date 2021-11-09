package TestNGTests;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/resources/features", glue={"CucumberTests"})
public class AddressGeneratorTestNG extends AbstractTestNGCucumberTests {
}
