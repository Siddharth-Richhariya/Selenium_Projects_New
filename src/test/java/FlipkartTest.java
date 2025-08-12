import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FlipkartTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement seaerchBox = driver.findElement(By.xpath("//input[@name='q']"));
        seaerchBox.sendKeys("Mobile");
        Actions action = new Actions(driver);
        action.keyDown(Keys.ENTER).build().perform();
        List<WebElement> mobileList = driver.findElements(By.xpath("//div[@class='_75nlfW']"));
        WebElement thirdSerch = mobileList.get(2);
        thirdSerch.click();
        WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
        addToCartButton.click();
        String TotalAmmontText = driver.findElement(By.xpath("//div[@class='_1Y9Lgu']/span/div/div/div[2]/span")).getText();
        String ExpectedAmmont = " ₹6,499";

        Assert.assertEquals(TotalAmmontText, ExpectedAmmont);



    }

}
