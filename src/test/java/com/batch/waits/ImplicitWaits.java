package com.batch.waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitWaits {

    WebDriver driver ;



    @BeforeSuite
    public void  startChromeBrowser(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }


        @Test
        public void openURL() throws InterruptedException{
            driver.get("https://www.daraz.com.bd/");
            driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));

        }

        @AfterSuite
        public void closeChromeBrowser(){
            driver.close();
        }
}
