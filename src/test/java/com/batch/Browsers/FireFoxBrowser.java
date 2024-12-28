package com.batch.Browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class FireFoxBrowser {

    WebDriver driver;

    @BeforeSuite
    public void startFirefox(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void openURL() throws InterruptedException{
        driver.get("https://www.haphchharischool.edu.bd/");
        Thread.sleep(15000);
    }

    @AfterSuite
    public void closeFirefox(){
        driver.close();
    }
}
