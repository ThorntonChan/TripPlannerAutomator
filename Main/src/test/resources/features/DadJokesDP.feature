@DataProviderRequired
Feature: Retrieving Dad Joke by Dataprovider
  Scenario: comparing joke against jokeId from Dataprovider
    Given The user is provided a valid jokeId matching dataprovider
    Then A joke must be returned matching dataprovider