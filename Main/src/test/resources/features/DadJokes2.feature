Feature: Retrieving Multiple Dad Jokes
  Background: getting OG joke
    Given the user has requested a joke
    Then a joke and jokeID must be returned

  Scenario Outline: comparing joke against jokeid 2
    Given The user searches a <jokeId>
    Then The <joke> returned must be consistent
    Examples:
      | jokeId      | joke                                                            |
      | 82LBXSfaFlb | What kind of tree fits in your hand? A palm tree!               |
      | fiyPR7wPZDd |  When does a joke become a dad joke? When it becomes apparent.  |
      | 0wcFBQfiGBd | Did you hear the joke about the wandering nun? She was a roman catholic. |
