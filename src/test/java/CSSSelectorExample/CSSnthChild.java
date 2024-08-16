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

public class CSSnthChild {
    static WebDriver driver;
    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver();
    }
    @Test
    @Description("Test Case Description")
    public void testTrials(){
        driver.get("https://awesomeqa.com/css/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //To Print odd Span Results
        List<WebElement> oddSpanResults = driver.findElements(By.cssSelector("div.first > span:nth-child(2n+1)"));
        for(WebElement oddresults : oddSpanResults){
            System.out.println(oddresults.getText());
        }

        //To Print first and Last Span results
        WebElement firstSpanResults = driver.findElement(By.cssSelector("div.first > span:first-child"));
        WebElement lastSpanResults = driver.findElement(By.cssSelector("div.first > span:last-child"));
        System.out.println("First span Result : "+ firstSpanResults.getText()+"\nLast span Results : "+lastSpanResults.getText());

    }
    @AfterTest
    public void closeBrowser(){
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){
            throw new RuntimeException();
        }
        driver.quit();
    }
}
