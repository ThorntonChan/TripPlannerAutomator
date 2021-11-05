package TestNGTests;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.*;

@CucumberOptions(features="src\\test\\resources\\features", glue={"CucumberTests"})
public class IntegrateCuke {
    private TestNGCucumberRunner tngcr;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        try {
            tngcr = new TestNGCucumberRunner(this.getClass());
        } catch (Exception e) {
            System.out.println(this.getClass().getName());
        }
    }
    @Test(dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        tngcr.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return tngcr.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        tngcr.finish();
    }

}
