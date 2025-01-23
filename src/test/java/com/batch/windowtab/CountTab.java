package com.batch.windowtab;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Set;


public class CountTab {

    WebDriver driver;

    @BeforeSuite
    public void startChromeBrowser(){
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
    }

 @Test(priority = 0)
    public void openURL() throws InterruptedException{
    driver.get("https://www.facebook.com/");
    Thread.sleep(5000);

    }
@Test(priority = 1)
    public void countTabNumber() throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.tutorialspoint.com/");
        Thread.sleep(5000);

        Set<String> tabs = driver.getWindowHandles();
        System.out.println("Number of tab is: " + tabs.size());

    }


    @AfterSuite
    public void closeChromeBrowser(){
        driver.quit();
    }


}


