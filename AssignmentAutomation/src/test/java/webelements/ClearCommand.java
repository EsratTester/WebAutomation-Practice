package webelements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ClearCommand {


    WebDriver driver;

    @BeforeSuite
    public void startChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void openURL() throws InterruptedException{
        driver.get("https://practicetestautomation.com/practice-test-login/");
        Thread.sleep(5000);

        WebElement name = driver.findElement(By.xpath("//input[@id='username']"));
        name.sendKeys("student");
        Thread.sleep(5000);



        WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
        pass.sendKeys("Password123");
        Thread.sleep(5000);



        driver.findElement(By.xpath("//input[@id='username']")).clear();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='password']")).clear();
        Thread.sleep(2000);




    }

    @AfterSuite
    public void closeChromeBrowser(){
        driver.close();
    }
}
