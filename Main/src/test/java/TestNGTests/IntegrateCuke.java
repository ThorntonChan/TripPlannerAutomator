package TestNGTests;



<<<<<<< HEAD
import com.automator.handler.FileHandler;
import io.cucumber.testng.*;
=======
import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.runtime.model.CucumberFeature;
>>>>>>> versiontesting
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

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
<<<<<<< HEAD
    @Test(dataProvider = "features")
    public void feature(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper, List<String> listData) {
        if (listData != null){
            TestNGCucumberParams.dataList = listData;
            tngcr.runScenario(pickleWrapper.getPickle());
        }
    }
    @DataProvider
    public Object[][] features() {
        FileHandler data = new FileHandler("C:\\Users\\tchan3\\Documents\\dev\\TripPlannerAutomator\\testdata.txt");
        Object[][] rawScenarios = tngcr.provideScenarios();
        Object[][] scenariosObj = new Object[rawScenarios.length][3];
        for (int i = 0; i < rawScenarios.length; i ++) {
            scenariosObj[i][0] = rawScenarios[i][0];
            scenariosObj[i][1] = rawScenarios[i][1];
            String from = data.readLine();
            String to = data.readLine();
            if (from != null || to != null) {
                List<String> listData= new ArrayList<String>();
                listData.add(from);
                listData.add(to);
                scenariosObj[i][2] = listData;
            } else {
                scenariosObj[i][2] = null;
            }
=======
//    @Test(dataProvider = "features")
    @Test
    public void feature() {
        for (CucumberFeature feature : tngcr.getFeatures()) {
            tngcr.runCucumber(feature);
>>>>>>> versiontesting
        }
        return scenariosObj;
    }


//    @DataProvider(name = "provideAddresses")
//    public Iterator<Object[]> testData() {
//        List<Object[]> addresses = new ArrayList<>();
//        FileHandler data = new FileHandler("C:\\Users\\tchan3\\Documents\\dev\\TripPlannerAutomator\\testdata.txt");
//        while (true){
//            String from = data.readLine();
//            String to = data.readLine();
//            if (from == null || to == null) {
//                break;
//            } else {
//                addresses.add(new Object[] { from, to });
//            }
//        }
//        data.close();
//        return addresses.iterator();
//    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        tngcr.finish();
    }

}
