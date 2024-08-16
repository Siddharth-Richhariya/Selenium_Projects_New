package VWOlogin;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class VWOLogin {

    @Test
    public void loginVWOLogin(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();

        WebElement email = driver.findElement(By.xpath("//input[@id='login-username']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signinButton = driver.findElement(By.xpath("//button[@id='js-login-btn']"));

        email.sendKeys("siddharth.richhariya123@gmail.com");
        password.sendKeys("Sid@1997");
        signinButton.click();


        String actualURLs = "https://app.vwo.com/#/login";
        String expectedURLs = driver.getCurrentUrl();

        Assert.assertEquals(expectedURLs, actualURLs);



        driver.quit();
    }
}
