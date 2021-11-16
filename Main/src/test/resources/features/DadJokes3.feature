#Feature: Retrieving Multiple Dad Jokes with DataTable
#  Scenario: comparing joke to jokeId
#    Given The following Jokes:
#      | jokeId      | joke                                                            |
#      | 82LBXSfaFlb | What kind of tree fits in your hand? A palm tree!               |
#      | fiyPR7wPZDd |  When does a joke become a dad joke? When it becomes apparent.  |
#      | 0wcFBQfiGBd | Did you hear the joke about the wandering nun? She was a roman catholic. |
#    When the jokeId is searched
#    Then The joke must be exactly returned