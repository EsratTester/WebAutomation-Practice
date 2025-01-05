package scroll;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SpecificElement {


    WebDriver driver;

    @BeforeSuite
    public void startChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void openURL() throws InterruptedException{
        driver.get("https://the-internet.herokuapp.com/large");
        Thread.sleep(5000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//h4[contains(text(),'Table')]"));
        js.executeScript("arguments[0].scrollIntoView()",element);
        Thread.sleep(5000);

    }

        @AfterSuite
        public void closeChromeBrowser(){
        driver.quit();

    }
}

