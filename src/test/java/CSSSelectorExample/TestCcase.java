package CSSSelectorExample;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestCcase {
    static  WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver();

    }
    @Test
    @Description("Test Case Description")
    public void testTrials(){
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement searchBox = driver.findElement(By.cssSelector("input[type='text']"));
        WebElement searchButton = driver.findElement(By.cssSelector("input[type='submit']"));

        searchBox.sendKeys("Macmini");
        searchButton.click();

        List<WebElement> searchTitles = driver.findElements(By.cssSelector("div.s-item__title"));
        List<WebElement> searchTitlesPrices = driver.findElements(By.cssSelector("span.s-item__price"));

        int size = Math.min(searchTitles.size(),searchTitlesPrices.size());

        for(int i = 2; i< size; i++){
            System.out.println("Title : "+searchTitles.get(i).getText()+ "\nPrices : "+searchTitlesPrices.get(i).getText());
        }

    }

    @AfterTest
    public void closeBrowser(){
        try{
            Thread.sleep(2000);
        }
        catch(Exception e){
            throw new RuntimeException();
        }
        //driver.quit();
    }
}
