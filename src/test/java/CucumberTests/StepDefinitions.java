package CucumberTests;

import com.automator.addressgenerator.AddressGenerator_Service;
import com.automator.tripplanner.TransportRoute_Service;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class StepDefinitions {

    @Given("user is on the Australian subdirectory of the address generator")
    public void navToAddressGenerator(){
        TransportRoute_Service.findRoutes(AddressGenerator_Service.generateAddresses("Sydney"));
    }
    @When("^the city \"(.*?)\" has been selected$")
    public void selectCity(String cityName){
        List<String> addresses = AddressGenerator_Service.generateAddresses(cityName);
    }
    @And("the generate button is clicked")
    public void clickGenerate(){
        TransportRoute_Service.findRoutes(addresses);
    }
    @Then("a list of addresses should be visible")
    public void retrieveAddresses(){
        TransportRoute_Service.findRoutes(AddressGenerator_Service.generateAddresses("Sydney"));
    }

}
