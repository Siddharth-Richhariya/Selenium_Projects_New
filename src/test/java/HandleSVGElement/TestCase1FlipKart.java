package HandleSVGElement;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase1FlipKart {
    static WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new ChromeDriver(options);
    }

    @Test
    public void searchBox() {
        String URL = "https://www.flipkart.com/";
        driver.get(URL);
        WebElement SerchBox = driver.findElement(By.xpath("//input[@class='Pke_EE']"));
        SerchBox.sendKeys("Iphone 15");
        List<WebElement> button = driver.findElements(By.xpath("//*[name()='svg']"));
        button.get(0).click();
    }

    @AfterTest
    public void close() {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        finally {
            driver.quit();
        }
    }
}
