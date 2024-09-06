Feature: Search Result Page and traversing between them

Scenario: We go to the next page of results
    Given a search result page
    When I move forward
    Then I will get the next result page in the sequence