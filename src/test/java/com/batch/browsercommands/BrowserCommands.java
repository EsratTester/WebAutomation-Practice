package com.batch.browsercommands;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BrowserCommands {

    String url = "https://www.w3schools.com/java/default.asp";
    WebDriver driver;

    @BeforeSuite
    public void startChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void getCurrentUrl(){
         driver.get(url);
         String currentURL = driver.getCurrentUrl();
         System.out.println(currentURL);
         if(url.equals(currentURL)){
             System.out.println("Current URL is the same as the mentioned URL");
         }
         else{
             System.out.println("Current URL is not the same as the mentioned URL");
         }

    }

    @AfterSuite
    public void closeChromeBrowser(){
        driver.quit();
    }




}
