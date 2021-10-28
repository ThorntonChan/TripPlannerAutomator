Feature: Address Generator
  Scenario: On inputting a city and clicking generate, the address generator page should return a list of addresses

    Given when user is on the Australian subdirectory of the address generator
    When the city has been selected
    And the generate button is clicked
    Then a list of addresses should be visible