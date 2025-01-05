package navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class NavigateForward {


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


       driver.navigate().to("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");
       Thread.sleep(5000);


       driver.navigate().forward();
       Thread.sleep(5000);

        driver.navigate().back();
        Thread.sleep(5000);





    }

        @AfterSuite
        public void closeChromeBrowser(){
        driver.close();

    }
}

