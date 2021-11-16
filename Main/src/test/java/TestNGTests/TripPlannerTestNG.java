package TestNGTests;


import com.automator.tripplanner.TransportRoute_Service;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TripPlannerTestNG {
    @BeforeClass
    public void setup() {
        theUserIsOnTheTransportNSWTripPlanner();
    }

    @Test
    @Parameters({"to", "from"})
    public void findRoute(String to, String from) {
        fromAndToAreInputAsDestinations(to, from);
        //pass condition aQuickestRouteMustBeReturned
    }

    private void theUserIsOnTheTransportNSWTripPlanner() {
        TransportRoute_Service.visitUrl();
    }

    private void fromAndToAreInputAsDestinations(String from, String to) {
        TransportRoute_Service.inputDestinations(to, from);
    }
    private void aQuickestRouteMustBeReturned(String arrival) {
        String ea = TransportRoute_Service.getEarliestArrival();
        System.out.println(ea);
        Assert.assertEquals(ea, arrival);
    }
    @Test
    public void omit(){
        Assert.assertEquals((1 + 1), 2);
    }


//    @Test(dataProvider = "provideAddresses")
//    public void findRoute(String to, String from) {
//        System.out.println(to + from);
//        fromAndToAreInputAsDestinations(to, from);
//        aQuickestRouteMustBeReturned("00:00");
//    }

//    @DataProvider(name = "provideNumbers")
//    public Object[][] destinationProvider() {
//        return new Object[][] {
//                { "130 George St, Parramatta", "61 John Road Cherrybrook" },
//                { "42 County Drive Cherrybrook", "Woolworths Metro Castle Hill" },
//                { "130 George St Parramatta", "Menya Mappen Sydney 2000" }
//        };
//    }
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


}
