package CucumberTests;

import TestNGTests.TestNGCucumberParams;
import com.automator.handler.ReportHandler;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;



public class APIStepDefinitions {
    private DadJokesService dadJokesService = new DadJokesService();

    public APIStepDefinitions(){}

    @Before
    public void before(Scenario scenario){
        System.out.println("Beginning new scenario: " + scenario.getName());
        ReportHandler.output("Beginning scenario: " + scenario.getName());
    }
    @After
    public void after(Scenario scenario){
        System.out.println("End of scenario" + scenario.getName());
        ReportHandler.output("End of scenario");
    }

    @Given("^the user has requested a joke$")
    public void theUserHasRequestedAJoke() {
        dadJokesService.getRandomJoke();
    }

    @Then("^a joke and jokeID must be returned$")
    public void aJokeAndJokeIDMustBeReturned() {
    }

    @Given("^The user searches a jokeID$")
    public void theUserSearchesAJokeID() {
    }

    @Then("^The joke returned must be consistent$")
    public void theJokeReturnedMustBeConsistent() {
    }
}
