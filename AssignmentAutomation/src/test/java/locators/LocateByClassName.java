package locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class LocateByClassName {


    WebDriver driver;

    @BeforeSuite
    public void startChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void openURL() throws InterruptedException{
        driver.get("https://www.automationexercise.com/");
        Thread.sleep(5000);

        WebElement element = driver.findElement(By.xpath("//a[@data-product-id='1']"));
        element.click();
        Thread.sleep(5000);


        WebElement viewcart = driver.findElement(By.xpath("//a//u[text()='View Cart']"));
        viewcart.click();
        Thread.sleep(5000);

    }

        @AfterSuite
        public void closeChromeBrowser(){
        driver.close();

    }
}

