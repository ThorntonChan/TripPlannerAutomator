package CucumberTests;

import com.automator.addressgenerator.AddressGenerator_Service;
import com.automator.tripplanner.TransportRoute_Service;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import java.util.List;
import java.util.Map;

public class StepDefinitions {
    @Given("user is on the Australian subdirectory of the address generator")
    public void navToAddressGenerator(){
        TransportRoute_Service.findRoutes(AddressGenerator_Service.generateAddresses("Sydney"));
    }
//    @And("the city \"(.*?)\" has been selected")
    @And("the city (.*?) has been selected")
    public void theCityHasBeenSelected(String city) {
        AddressGenerator_Service.changeCity(city);
    }
    @When("the generate button is clicked")
    public void clickGenerate(){
        AddressGenerator_Service.returnResults();
    }
    @Then("10 addresses should be returned")
    public void returnAddresses(){
        Assert.assertEquals(AddressGenerator_Service.getListItems().size(), 10);
    }

    @Given("the user is on the TransportNSW trip planner")
    public void theUserIsOnTheTransportNSWTripPlanner() {
        TransportRoute_Service.visitUrl();
    }

    @When("(.*?) and (.*?) are input as destinations")
    public void fromAndToAreInputAsDestinations(String from, String to) {
        TransportRoute_Service.inputDestinations(to, from);
    }

    @Then("The earliest arrival is (.*?)")
    public void aQuickestRouteMustBeReturned(String arrival) {
        String ea = TransportRoute_Service.getEarliestArrival();
        Assert.assertEquals(ea, arrival);
    }
    @Given("The following addresses")
    public void givenTheAddressesAsDataTable(List<Map<String, String>> addresses) {
        for (Map<String, String> address : addresses) {
            String from = address.get("from");
            String to = address.get("to");
        }
    }



}
