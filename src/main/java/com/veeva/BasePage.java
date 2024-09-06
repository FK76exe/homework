/*
 * Point of access to Google.com's search bar and search results.
 */

 package com.veeva;

 import org.openqa.selenium.edge.EdgeDriver;
 import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
 
 public class BasePage {
 
     protected WebDriver driver;
     private EdgeOptions options;
     protected final String baseURL = "https://google.com";
     
     public BasePage() {
         System.setProperty("webdriver.edge.driver", "./ms_edge/msedgedriver.exe");
         options = new EdgeOptions();
         options.addArguments("--remote-allow-origins=*");
         driver = new EdgeDriver(options);

         driver.get(baseURL);
         driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
     }
 
     public void quit() {
        driver.quit();
     }
 }
 