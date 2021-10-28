package CucumberTests;

import com.automator.addressgenerator.AddressGenerator_Service;
import com.automator.tripplanner.TransportRoute_Service;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import java.util.List;

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
}
