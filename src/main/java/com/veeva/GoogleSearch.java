/*
 * Point of access to Google.com's search bar and search results.
 */

package com.veeva;
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class GoogleSearch extends BasePage {
    
    public GoogleSearch() {
        super();
    }

    public SearchResultPageNavigator getSearchResultPage(String term) {
        WebElement textArea = driver.findElement(By.tagName("textarea"));

        textArea.click();
        textArea.sendKeys(term);
        textArea.sendKeys(Keys.RETURN);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        return new SearchResultPageNavigator(driver.getCurrentUrl());
    }

    public List<String> getSearchSuggestions(String term) {

        // get the textarea
        WebElement textArea = driver.findElement(By.tagName("textarea"));

        // insert search term
        textArea.click();
        textArea.sendKeys(term);

        // wait again for search suggestions to reload
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        // get search suggestions and their text
        List<WebElement> listItems = driver.findElements(
            By.tagName("li")
        );

        return getSuggestionStrings(listItems);
    }

    private List<String> getSuggestionStrings(List<WebElement> items) {
        // only contain title or first text element
        List<String> suggestions = new ArrayList<String>();
        for (WebElement item : items) {
            if (item.getAttribute("data-attrid") != null) {
                if (item.getAttribute("data-attrid").equals("AutocompletePrediction")) {
                    String item_text = item.findElement(By.tagName("span")).getText();
                    if (!item_text.isBlank()) {
                        suggestions.add(item_text);
                    }
                }
            }
        }
        return suggestions;
    }

}
