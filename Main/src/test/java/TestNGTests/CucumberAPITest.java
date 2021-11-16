package TestNGTests;



import com.automator.handler.FileHandler;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.runtime.model.CucumberFeature;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@CucumberOptions(features="src/test/resources/features", glue={"CucumberTests"}, tags="@DataProviderRequired")
public class CucumberAPITest {
    private TestNGCucumberRunner tngcr = new TestNGCucumberRunner(this.getClass());

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
//        try {
//            tngcr = new TestNGCucumberRunner(this.getClass());
//        } catch (Exception e) {
//            System.out.println(this.getClass().getName());
//        }
        System.out.println("running cucumber from testng");
    }

    @Test(dataProvider = "getTestData")
    public void feature(List<String> data) {
        TestNGCucumberParams.dataList = data;
        for (CucumberFeature feature : tngcr.getFeatures()) {
            tngcr.runCucumber(feature);
        }
    }


    @DataProvider
    public Iterator<Object[]> getTestData() {
        List<Object[]> testData = new ArrayList<>();
        List<String> addresses = new ArrayList<String>();
        FileHandler data = new FileHandler("/Users/thornton/Documents/projects/TripPlannerAutomator/joketestdata.txt");
//        FileHandler data = new FileHandler("C:\\Users\\tchan3\\Documents\\dev\\TripPlannerAutomator\\joketestdata.txt");
        while (true){
            String from = data.readLine();
            String to = data.readLine();
            if (from == null || to == null) {
                break;
            } else {
                addresses.add(to);
                addresses.add(from);
                testData.add(new Object[] { addresses });
            }
        }
        data.close();
        return testData.iterator();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        tngcr.finish();
    }

}
