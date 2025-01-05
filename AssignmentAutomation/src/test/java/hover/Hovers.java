package hover;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Hovers {


    WebDriver driver;

    @BeforeSuite
    public void startChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void openURL() throws InterruptedException{
        driver.get("https://the-internet.herokuapp.com/hovers");
        Thread.sleep(5000);



       WebElement element = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[2]"));
       Actions action = new Actions(driver);
       action.moveToElement(element).perform();
       Thread.sleep(5000);

       WebElement user = driver.findElement(By.xpath("//a[@href='/users/2']"));
       user.click();
       Thread.sleep(5000);


    }

        @AfterSuite
        public void closeChromeBrowser(){
        driver.close();

    }
}

