package com.batch.windowtab;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class SwitchToWindows {

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
    public void switchToWindows() throws InterruptedException {
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        windows.add(driver.getWindowHandle());

        driver.switchTo().newWindow(WindowType.WINDOW);
        windows.add(driver.getWindowHandle());
        driver.navigate().to("https://www.tutorialspoint.com/");
        Thread.sleep(5000);


      driver.switchTo().window(windows.get(0));
      driver.close();
      Thread.sleep(5000);
//      driver.switchTo().window(windows.get(1));
//      Thread.sleep(5000);



    }


    @AfterSuite
    public void closeChromeBrowser(){
        driver.quit();
    }


}

////


