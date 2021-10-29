Feature: Public Transport Routing
    Given the following addresses:
    | from | to |
    | 61 John Road Cherrybrook | 130 George Street Parramatta |
    | 42 County Driver Cherrybrook | Kent Street Sydney       |
    When the user is on the TransportNSW trip planner
    And addresses are input as destinations
    Then A quickest route must be returned
#
#Feature: Public Transport Routing
#  Scenario Outline: Earliest Arrival Routing
#    Given the user is on the TransportNSW trip planner
#    When <from> and <to> are input as destinations
#    Then The earliest arrival is <time>
#Examples:
#    | from | to | time |
#    | 61 John Road Cherrybrook | 130 George Street Parramatta | 11:30 |
#    | 42 County Driver Cherrybrook | Kent Street Sydney       | 11:23 |
#