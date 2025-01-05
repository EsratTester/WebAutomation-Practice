package assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertions {


    WebDriver driver;

    @BeforeSuite
    public void startChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void openURL() throws InterruptedException{
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(5000);

        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTitle,expectedTitle,"Title is not Matched");


       WebElement addElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
       addElement.click();
       Thread.sleep(5000);


        WebElement delete = driver.findElement(By.xpath("//button[@class='added-manually']"));
        softAssert.assertTrue(delete.isDisplayed(), "Delete button is not displayed!");
        Thread.sleep(5000);


//        WebElement delete = driver.findElement(By.xpath("//button[@class='added-manually']"));
//        if (delete.isDisplayed()){
//            System.out.println(delete.("Delete"));
//            Thread.sleep(5000);
//        }else{
//            System.out.println("Delete is not Dispalyed");
//        }


            String actualText = delete.getText();
            String expectedText = "Delete";
            softAssert.assertEquals(actualText, expectedText, "Delete text did not match!");
            Thread.sleep(5000);




       softAssert.assertAll();


    }

        @AfterSuite
        public void closeChromeBrowser(){
        driver.close();

    }
}

