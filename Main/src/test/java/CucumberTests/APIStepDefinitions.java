package CucumberTests;

import DadJokeAPIExample.DadJokesService;
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
    private String cachedJoke;
    private String cachedJokeId;

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
        dadJokesService.getRandomDadJoke();
    }

    @Then("^a joke and jokeID must be returned$")
    public void aJokeAndJokeIDMustBeReturned() {
        Assert.assertNotNull(dadJokesService.lastJoke);
        Assert.assertNotNull(dadJokesService.lastJokeId);
    }

    @Given("^The user searches a jokeID$")
    public void theUserSearchesAJokeID() {
        cachedJoke = dadJokesService.lastJoke;
        cachedJokeId = dadJokesService.lastJokeId;
        dadJokesService.getJoke(cachedJokeId);
    }

    @Then("^The joke returned must be consistent$")
    public void theJokeReturnedMustBeConsistent() {
        Assert.assertEquals(cachedJoke, dadJokesService.lastJoke);
    }
}
