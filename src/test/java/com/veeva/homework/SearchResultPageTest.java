package com.veeva.homework;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.veeva.GoogleSearch;
import com.veeva.SearchResultPageNavigator;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class SearchResultPageTest {

    private String searchTerm = "test";
    private GoogleSearch googleSearch = new GoogleSearch();
    private SearchResultPageNavigator searchResult;
    private int prevPageNum;

    @Given("a search result page") 
    public void a_search_result_page(){
        searchResult = googleSearch.getSearchResultPage(searchTerm);
        googleSearch.quit();
        prevPageNum = searchResult.getPageNumber();
    }

    @When("I move forward")
    public void i_move_forward(){
        searchResult.moveForward();
    }

    @Then("I will get the next result page in the sequence")
    public void i_will_get_the_next_result_page_in_the_sequence(){
        assertEquals(prevPageNum, searchResult.getPageNumber()+1); // TODO fix this
    }

    @After
    public void cleanUp(){
        searchResult.quit();
    }

}
