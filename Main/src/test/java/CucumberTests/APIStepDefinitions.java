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
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;


public class APIStepDefinitions {
    private DadJokesService dadJokesService = new DadJokesService();
    private String cachedJoke;
    private String cachedJokeId;
    List<Map<String, String>> jokesTable;

    public APIStepDefinitions(){}

    @Before
    public void before(Scenario scenario){
//        System.out.println("Beginning new scenario: " + scenario.getName());
        ReportHandler.output("Beginning scenario: " + scenario.getName());
    }
    @After
    public void after(Scenario scenario){
//        System.out.println("End of scenario: " + scenario.getName());
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

    @Then("^The (.*?) returned must be consistent$")
    public void theJokeReturnedMustBeConsistent(String joke) {
        if (joke.equals("joke")) {
            Assert.assertEquals(cachedJoke, dadJokesService.lastJoke);
        } else {
            Assert.assertEquals(dadJokesService.lastJoke, joke);
        }
    }

    @Given("^The user searches the last joke's id$")
    public void theUserSearchesTheLastJokeSId() {
        cachedJoke = dadJokesService.lastJoke;
        cachedJokeId = dadJokesService.lastJokeId;
        dadJokesService.getJoke(cachedJokeId);
    }

    @Given("^The user searches a (.*?)$")
    public void theUserSearchesAJokeID(String jokeId) {
        dadJokesService.getJoke(jokeId);
    }

    @Given("^The user is provided a valid jokeId matching dataprovider$")
    public void theUserIsProvidedAValidJokeIdMatchingDataprovider() {
        dadJokesService.getJoke(TestNGCucumberParams.dataList.get(0));
    }

    @Then("^A joke must be returned matching dataprovider$")
    public void aJokeMustBeReturnedMatchingDataprovider() {
        Assert.assertEquals(dadJokesService.lastJoke, TestNGCucumberParams.dataList.get(1));
    }

//
//    @Given("^The following Jokes:$")
//    public void theFollowingJokes(DataTable table) {
//        jokesTable = table.asMaps(String.class, String.class);
//    }
//
//    @When("^the jokeId is searched$")
//    public void theJokeIdIsSearched() {
//    }
//
//    @Then("^The joke must be exactly returned$")
//    public void theJokeMustBeExactlyReturned() {
//    }
}
