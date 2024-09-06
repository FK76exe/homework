/*
 * Point of access to Google.com's search bar and search results.
 */

package com.veeva;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearch {

    private WebDriver driver;
    private EdgeOptions options;
    
    public GoogleSearch() {
        System.setProperty("webdriver.edge.driver", "./ms_edge/msedgedriver.exe");
        options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new EdgeDriver(options);
    }

    public List<String> getSearchSuggestions(String test) {
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        // get the textarea
        WebElement textArea = driver.findElement(By.tagName("textarea"));

        // insert search term
        textArea.click();
        textArea.sendKeys(test);

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
