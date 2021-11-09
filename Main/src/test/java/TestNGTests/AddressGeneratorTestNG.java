package TestNGTests;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/features", glue={"CucumberTests"})
public class AddressGeneratorTestNG extends AbstractTestNGCucumberTests {
}
