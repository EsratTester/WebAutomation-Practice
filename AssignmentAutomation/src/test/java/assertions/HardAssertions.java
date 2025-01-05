package assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HardAssertions {


    WebDriver driver;

    @BeforeSuite
    public void startChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void openURL() throws InterruptedException{
        driver.get("https://the-internet.herokuapp.com/inputs");
        Thread.sleep(5000);

        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);


       WebElement element = driver.findElement(By.xpath("//input[@type='number']"));
       element.sendKeys("30000");
       Thread.sleep(5000);


    }

        @AfterSuite
        public void closeChromeBrowser(){
        driver.close();

    }
}

