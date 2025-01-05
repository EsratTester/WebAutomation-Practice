package dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Index {


    WebDriver driver;

    @BeforeSuite
    public void startChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void openURL() throws InterruptedException{
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Thread.sleep(5000);

       WebElement dropdown = driver.findElement(By.id("dropdown"));
       Select select = new Select(dropdown);
       
       select.selectByIndex(2);

       
       
       Thread.sleep(5000);



 
    }

        @AfterSuite
        public void closeChromeBrowser(){
        driver.quit();

    }
}

