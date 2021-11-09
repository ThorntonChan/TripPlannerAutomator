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
//    @Test(dataProvider = "features")
    @Test
    public void feature() {
        Object[][] scenarios =  tngcr.provideScenarios();
        for (Object[] scenario : scenarios) {
            Object wrapper = scenario[0];
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
