Feature: Do search suggestions contain the search term?
    Our search functionality needs to contain relevant keywords, such as the search term provided

    Scenario: The search term "test" is presented in the search suggestion list
        Given the term test
        When I type it into the search box
        Then I should be given suggestions containing test

    Scenario: Requesting a search term's results leads to a new search result pages
        Given the search term
        When I request search results
        Then I should be given a search result page