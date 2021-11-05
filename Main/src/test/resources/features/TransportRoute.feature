Feature: Public Transport Routing
  Background: User is able to navigate to tfnsw tripplanner from homepage
    Given user is on tfnsw homepage
    Then there must be a link present to tripplanner

  @DataTable
  Scenario:
    Given the following addresses:
    | from | to |
    | 61 John Road Cherrybrook | 130 George Street Parramatta |
    | 42 County Driver Cherrybrook | Kent Street Sydney       |
    When the user navigates to the TransportNSW trip planner
    And "from" and "to" are input as destinations
    Then The earliest arrival is returned

##    List<List<String>>
#    | 61 John Road Cherrybrook | 130 George Street Parramatta |
#    | 42 County Driver Cherrybrook | Kent Street Sydney       |
##    Map<String>
#    | from | 61 John Road Cherrybrook |
#    | to | 130 George Street Parramatta |
##    Map <String, List<String>>
#    | route1 | 61 John Road Cherrybrook | 130 George Street Parramatta |
#    | route2 | 42 County Driver Cherrybrook | Kent Street Sydney       |
##    Map<String, Map<String, String>>
#    |        | from                         | to                       |
#    | route1 | 61 John Road Cherrybrook | 130 George Street Parramatta |
#    | route2 | 42 County Driver Cherrybrook | Kent Street Sydney       |


  @ExampleTable
  Scenario Outline: Earliest Arrival Routing
    Given the user navigates to the TransportNSW trip planner
    When "<from>" and "<to>" are input as destinations
    Then The earliest arrival is <time>
  Examples:
    | from | to | time |
    | 61 John Road Cherrybrook | 130 George Street Parramatta | 11:30 |
    | 42 County Driver Cherrybrook | Kent Street Sydney       | 11:23 |