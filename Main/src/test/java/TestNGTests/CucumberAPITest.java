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
    public void feature(Object[] testData) {
        List<String> data = new ArrayList<String>();
        data.add((String) testData[0]);
        data.add((String) testData[1]);
        CucumberAPIParams.dataList = data;
        for (CucumberFeature feature : tngcr.getFeatures()) {
            tngcr.runCucumber(feature);
        }
    }


    @DataProvider
    public Object[][] getTestData() {
        Object[][] testData = new Object[3][2];
        FileHandler data = new FileHandler("C:\\Users\\tchan3\\Documents\\dev\\TripPlannerAutomator\\joketestdata.txt");
        int i = 0;
        while (true){
            String input1 = data.readLine();
            String input2 = data.readLine();
            if (input1 == null || input2 == null) {
                break;
            } else {
                testData[i] = new Object[] { input1, input2 };
                ++ i;
            }
        }
        data.close();
        return testData;
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        tngcr.finish();
    }

}
