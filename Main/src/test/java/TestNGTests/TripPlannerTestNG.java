package TestNGTests;

import com.automator.tripplanner.TransportRoute_Service;
import org.testng.Assert;
import org.testng.annotations.*;
// TODO: reformat to feature file structure
public class TripPlannerTestNG {
    @BeforeClass
    public void setup() {
        TransportRoute_Service.visitUrl();
    }

//    Run cucumber FF from command line
//
//    Run TestNG test from Command line
//
//    Make TestNG tet identical to FF
//
//    Read test data from a file in DataProvider
//
//    Run a FF from a TestNG test method
//
//    Utilize TstNG data provider while running a FF from testNG test method

//    @Test
//    @Parameters({"to", "from"})
//    public void findRoute(String to, String from) {
//        TransportRoute_Service.inputDestinations(to, from);
//        Assert.assertEquals(TransportRoute_Service.getEarliestArrival(), "00:00");
//    }
    @Test(dataProvider = "provideNumbers")
    public void findRoute(String to, String from) {
        TransportRoute_Service.inputDestinations(to, from);
        Assert.assertEquals(TransportRoute_Service.getEarliestArrival(), "00:00");
    }

    @DataProvider(name = "provideNumbers")
    public Object[][] destinationProvider() {
        return new Object[][] {
                { "130 George St, Parramatta", "61 John Road Cherrybrook" },
                { "42 County Drive Cherrybrook", "Woolworths Metro Castle Hill" },
                { "130 George St Parramatta", "Menya Mappen Sydney 2000" }
        };
    }


}
