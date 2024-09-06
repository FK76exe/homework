package com.veeva.homework;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.veeva.GoogleSearch;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class GoogleSearchTest {
    private String searchTerm;
    private List<String> actualSuggestions;
    private GoogleSearch searchDriver = new GoogleSearch();
    
    @Given("the term test")
    public void the_term_test() {
        searchTerm = "test";
    }  

    @When("I type it into the search box")
    public void i_type_it_into_the_search_box() {
        actualSuggestions = searchDriver.getSearchSuggestions(searchTerm);
    }

    @Then("I should be given suggestions containing test")
    public void i_should_be_given_suggestions_containing_test() {
        boolean allSuggestionsContainTerm = true;
        for (String suggestion : actualSuggestions) {
            
            if (!suggestion.contains(searchTerm)) {
                allSuggestionsContainTerm = false;
                
                break;
            }
        }
        assertEquals(true, allSuggestionsContainTerm);
    }

}
