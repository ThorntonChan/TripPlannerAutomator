package TestNGTests;



import io.cucumber.testng.*;
import org.testng.annotations.*;

@CucumberOptions(features="src/test/resources/features", glue={"CucumberTests"})
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
    public void feature(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        tngcr.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] features() {
        return tngcr.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        tngcr.finish();
    }

}
