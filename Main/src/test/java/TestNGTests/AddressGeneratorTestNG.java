package TestNGTests;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(features="src/test/resources/features", glue={"CucumberTests"}) //CucumberTests.StepDefinitions?
public class AddressGeneratorTestNG extends AbstractTestNGCucumberTests {
}

//@CucumberOptions(features="src\\test\\java\\CucumberTests",glue={"CucumberTests.StepDefinitions"},snippets= CucumberOptions.SnippetType.CAMELCASE, plugin={"pretty", "html:report", "json:reports.json"})
//public class AddressGeneratorTestNG extends AbstractTestNGCucumberTests {
//
//}