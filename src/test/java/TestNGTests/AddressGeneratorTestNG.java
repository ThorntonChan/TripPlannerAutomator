package TestNGTests;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@CucumberOptions(features="src\\test\\java\\CucumberTests", glue={"StepDefinitions"})
public class AddressGeneratorTestNG extends AbstractTestNGCucumberTests {
//    @BeforeClass
//    public void setup() {
//        //...
//    }
//
//    @Test
//    public void testInstructions() {
//        //...
//    }
//
//    @AfterClass
//    public void tearDown() {
//        //...
//    }
}
