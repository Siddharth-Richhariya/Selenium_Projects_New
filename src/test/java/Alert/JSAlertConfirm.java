package Alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class JSAlertConfirm {
        @Test
        public void JSAlertConfirm(){
            WebDriver driver = new ChromeDriver();
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
            driver.manage().window().maximize();

            WebElement JSAlertConfirmButton = driver.findElement(By.xpath("//button[contains(text(),'JS Confirm')]"));
            JSAlertConfirmButton.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();
            //alert.accept();
            alert.dismiss();

            String AlertResult_Message = driver.findElement(By.cssSelector("[id='result']")).getText();

            //Assert.assertEquals(AlertResult_Message,"You clicked: Ok");
            Assert.assertEquals(AlertResult_Message,"You clicked: Cancel");
            System.out.println(AlertResult_Message);

            driver.quit();
    }
}
