package com.batch.tables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;


public class FetchMaxPrice {

    WebDriver driver;

    @BeforeSuite
    public void startChromeBrowser(){
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
    }
 @Test(priority = 0)
    public void openURL() throws InterruptedException{
    driver.get("https://demo.guru99.com/test/web-table-element.php");
    Thread.sleep(5000);

    }

@Test(priority = 1)
    public void fetchHeadingOfTable() throws InterruptedException, ParseException {
        List<WebElement> numberofrows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
    System.out.println("Number of Rows: "+ numberofrows.size());

    String max;
    double m = 0,r = 0;

        for (int i = 1; i<=numberofrows.size();i++){
            WebElement currentPrice = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+i+"]/td[4]"));
            max = currentPrice.getText();
            System.out.println(max);
            NumberFormat formatter = NumberFormat.getNumberInstance();
            Number num = formatter.parse(max);

            max = num.toString();
            m = Double.parseDouble(max);
            if(m>r){
                r = m;
            }
        }
    System.out.println("Max Price: " + r);
    }

    @AfterSuite
    public void closeChromeBrowser(){
       driver.close();
    }


}


