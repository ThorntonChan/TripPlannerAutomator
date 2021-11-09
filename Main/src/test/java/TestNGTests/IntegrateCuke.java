package TestNGTests;



import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.runtime.model.CucumberFeature;
import org.testng.annotations.*;

@CucumberOptions(features="src/test/resources/features", glue={"CucumberTests"})
public class IntegrateCuke {
    private TestNGCucumberRunner tngcr = new TestNGCucumberRunner(this.getClass());

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        System.out.println("running cucumber from testng");
//        try {
//            if tngcr = new TestNGCucumberRunner(this.getClass());
//        } catch (Exception e) {
//            System.out.println(this.getClass().getName());
//        }
    }
//    @Test(dataProvider = "features")
    @Test
    public void feature() {
        for (CucumberFeature feature : tngcr.getFeatures()) {
            tngcr.runCucumber(feature);
        }
    }

//    @DataProvider
//    public Object[][] features() {
//        return tngcr.provideScenarios();
//    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        tngcr.finish();
    }

}
