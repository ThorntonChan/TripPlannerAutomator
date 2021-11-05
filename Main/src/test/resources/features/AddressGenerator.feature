Feature: Address Generator
  Scenario Outline: Generating addresses
    Given user is on the Australian subdirectory of the address generator
    And the city <city> has been selected
    When the generate button is clicked
    Then 10 addresses should be returned
    Examples:
  | city |
  | Sydney |
  | Melbourne |
  | Adelaide |
#  | Sydney | Melbourne | Adelaide |



#    Map
#    List
#  | city | state |
#  | Sydney | NSW |
#  | Melbourne | VIC |
#
#
#    | city | Sydney |
#    | state | NSW |

#Feature
#  Rule (as of Gherkin 6)
#  Example (or Scenario)
#  Given, When, Then, And, But for steps (or *)
#  Background
#  Scenario Outline (or Scenario Template)
#    Examples (or Scenarios)