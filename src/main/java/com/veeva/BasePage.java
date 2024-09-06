/*
 * Point of access to Google.com's search bar and search results.
 */

 package com.veeva;

 import org.openqa.selenium.edge.EdgeDriver;
 import org.openqa.selenium.edge.EdgeOptions;

 import org.openqa.selenium.WebDriver;
 
 public class BasePage {
 
     protected WebDriver driver;
     private EdgeOptions options;
     
     public BasePage() {
         System.setProperty("webdriver.edge.driver", "./ms_edge/msedgedriver.exe");
         options = new EdgeOptions();
         options.addArguments("--remote-allow-origins=*");
         driver = new EdgeDriver(options);
     }
 
     protected void quit() {
        driver.quit();
     }
 }
 