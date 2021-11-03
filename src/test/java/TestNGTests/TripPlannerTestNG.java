package TestNGTests;

import com.automator.tripplanner.TransportRoute_Service;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TripPlannerTestNG {
    @BeforeClass
    public void setup() {
        TransportRoute_Service.visitUrl();
    }

    @Test
    @Parameters({"to", "from"})
    public void findRoute(String to, String from) {
        TransportRoute_Service.inputDestinations(to, from);
        Assert.assertEquals(TransportRoute_Service.getEarliestArrival(), "00:00");
    }

//    @AfterClass
//    public void tearDown() {
//
//    }
}
