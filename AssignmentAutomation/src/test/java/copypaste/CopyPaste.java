package copypaste;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CopyPaste {

    WebDriver driver;

    @BeforeSuite
    public void startChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void openURL() throws InterruptedException {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        Thread.sleep(3000);

        //Actions class
        Actions actions = new Actions(driver);


        WebElement usernameCopy = driver.findElement(By.xpath("(//b[contains(text(),'student')])[1]"));

        //copy username
        actions.doubleClick(usernameCopy);
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("c");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        Thread.sleep(3000);

        // username
        WebElement username = driver.findElement(By.id("username"));
        username.click();

        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        Thread.sleep(1000);


        WebElement passwordCopy = driver.findElement(By.xpath("(//b[contains(text(),'Password123')])[1]"));

        //Password copy
        actions.doubleClick(passwordCopy);
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("c");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        Thread.sleep(3000);


        // password
        WebElement pass = driver.findElement(By.id("password"));
        pass.click();

        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        Thread.sleep(1000);



        WebElement login = driver.findElement(By.id("submit"));
        login.click();
        Thread.sleep(3000);


        WebElement successMessage = driver.findElement(By.xpath("//h1[contains(text(),'Logged In Successfully')]"));
        Thread.sleep(3000);

//        WebElement logOut = driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
//        logOut.click();
//        Thread.sleep(3000);


    }

    @AfterSuite
    public void closeChromeBrowser() {
        driver.quit();
    }
}
