package com.batch.Browsers;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class ChromeBrowser{

    WebDriver driver;

    @BeforeSuite
    public void startChromeBrowser(){
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
    }
 @Test
    public void openURL() throws InterruptedException{
    driver.get("https://www.facebook.com/");
    Thread.sleep(15000);

    }

    @AfterSuite
    public void closeChromeBrowser(){
       driver.close();
    }


}


