package CucumberTests;

import com.automator.addressgenerator.AddressGenerator_Service;
import com.automator.handler.ReportHandler;
import com.automator.tripplanner.TransportRoute_Service;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Given;
import org.junit.Assert;

import java.util.List;
import java.util.Map;


//pico.addComponent(Dep dep);
//Dep dep = (Juicer) pico.getComponent(dep.class);

//constructor in each class with dta member

public class StepDefinitions {
//    private TransportRoute_Service trs;
    StepUtil shared;
    public StepDefinitions(){};
//    public StepDefinitions(TransportRoute_Service trs) {
//        this.trs = trs;
//    }

    @Before
    public void before(Scenario scenario){
        shared = new StepUtil("bar");
        System.out.println(shared.foo);
        System.out.println("Beginning new scenario");
        ReportHandler.output("Beginning scenario: " + scenario.getName());
    }
    @After
    public void after(){
        System.out.println("End of scenario");
        ReportHandler.output("End of scenario");
    }


    @Given("user is on the Australian subdirectory of the address generator")
    public void navToAddressGenerator(){
        System.out.println(shared.foo);
        AddressGenerator_Service.generateAddresses("Sydney");
//        trs.findRoutes(AddressGenerator_Service.generateAddresses("Sydney"));
    }
//    @And("the city \"(.*?)\" has been selected")
    @And("the city (.*?) has been selected")
    public void theCityHasBeenSelected(String city) {
        System.out.println(shared.foo);
        AddressGenerator_Service.changeCity(city);
    }
    @When("the generate button is clicked")
    public void clickGenerate(){
        System.out.println(shared.foo);
        AddressGenerator_Service.returnResults();
    }
    @Then("10 addresses should be returned")
    public void returnAddresses(){
        Assert.assertEquals(AddressGenerator_Service.getListItems().size(), 10);
    }

    @Given("the user navigates to the TransportNSW trip planner")
    public void theUserIsOnTheTransportNSWTripPlanner() {
        TransportRoute_Service.visitUrl();
    }

    @When("\"(.*?)\" and \"(.*?)\" are input as destinations")
    public void fromAndToAreInputAsDestinations(String from, String to) {
        TransportRoute_Service.inputDestinations(to, from);
    }
    @Then("^The earliest arrival is (.*?)$")
//    @Then("The earliest arrival is (\\[0-9\\]\\{2\\}:\\[0-9\\]\\{2\\}) (.*?[^\s])")
    public void aQuickestRouteMustBeReturned(String arrival) {
        String ea = TransportRoute_Service.getEarliestArrival();
        Assert.assertEquals(ea, arrival);
    }
    @Given("^the following addresses:$")
    public void givenTheAddressesAsDataTable(DataTable table) {
//        List<Map<String, String>> addressesListMap = table.asMaps(String.class, String.class);
//        List<List<String>> addressesListList = table.asLists(String.class);
//        for (Map<String, String> address : addresses) {
//            String from = address.get("from");
//            String to = address.get("to");
//        }
    }

    @Given("user is on tfnsw homepage")
    public void userIsOnTfnswHomepage() {
        //navtohome
    }

    @Then("there must be a link present to tripplanner")
    public void thereMustBeALinkPresentToTripplanner() {
        //new page object with by href to tripplanner
    }

}
