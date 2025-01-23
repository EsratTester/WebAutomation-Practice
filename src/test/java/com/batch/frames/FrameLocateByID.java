package com.batch.frames;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class FrameLocateByID {

    WebDriver driver;

    @BeforeSuite
    public void startChromeBrowser(){
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
    }
 @Test
    public void openURL() throws InterruptedException{
    driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
    Thread.sleep(5000);

     driver.switchTo().frame("frm2");
     WebElement element = driver.findElement(By.xpath("//input[@id='firstName']"));
     element.sendKeys("Tanim");
     Thread.sleep(5000);

    }

    @AfterSuite
    public void closeChromeBrowser(){
       driver.close();
    }


}


