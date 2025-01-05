package scroll;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ScrollBottom {


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
        String script = "window.scrollTo(0,document.body.scrollHeight);";
        js.executeScript(script);
        Thread.sleep(5000);




 
    }

        @AfterSuite
        public void closeChromeBrowser(){
        driver.quit();

    }
}

