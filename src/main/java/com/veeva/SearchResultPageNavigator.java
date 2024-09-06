// code that manages navigation of search results

package com.veeva;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPageNavigator extends BasePage {
    
    private List<WebElement> navTableItems;
    private int pageNum = 1;

    public SearchResultPageNavigator(String url) {
        driver.get(url);
        updateNavTable();
    }

    public void moveForward() {
        WebElement nextPageURL = navTableItems.get(navTableItems.size()-1).findElement(By.tagName("a"));
        nextPageURL.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        updateNavTable();
        pageNum++; // TODO fix this
    }

    public Integer getPageNumber() {
        return pageNum;
    }

    private void updateNavTable() {
        navTableItems = driver.findElement(By.tagName("table")).findElements(By.tagName("td"));
    }

}
