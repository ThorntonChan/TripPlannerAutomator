Feature: Address Generator
  Scenario: On inputting a city and clicking generate, the address generator page should return a list of addresses

    Given user is on the Australian subdirectory of the address generator
    When the city "Sydney" has been selected
    And the generate button is clicked
    Then a list of addresses should be visible

    Scenario Outline: 



#    Map
#    List
  | city | state |
  | Sydney | NSW |
  | Melbourne | VIC |

  | Sydney | Melbourne | Adelaide |

    | city | Sydney |
    | state | NSW |