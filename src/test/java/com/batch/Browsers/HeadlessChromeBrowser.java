package com.batch.Browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class HeadlessChromeBrowser {


    WebDriver driver;


    @BeforeSuite
    public void startChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);

    }
    @Test
    public void openURL() throws InterruptedException{
        driver.get("https://www.tutorialspoint.com");
        Thread.sleep(5000);
        System.out.println(driver.getTitle());

    }

    @AfterSuite
    public void closeChromeBrowser(){
        driver.quit();
    }
}