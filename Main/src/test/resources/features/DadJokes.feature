Feature: Retrieving The Same Dad Joke
  Background: getting OG joke
    Given the user has requested a joke
    Then a joke and jokeID must be returned

  Scenario: comparing joke against jokeid 1
    Given The user searches the last joke's id
    Then The joke returned must be consistent