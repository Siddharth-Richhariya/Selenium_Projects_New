package WindowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandle {

    static WebDriver driver;
    @BeforeTest
    public void startBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
    }

    @Test
    public void Test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        String mainWindow = driver.getWindowHandle();

        WebElement switchTO = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
        switchTO.click();

        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows){
            driver.switchTo().window(window);
            if(driver.getPageSource().contains("New Window")){
                System.out.println("Test Case Passed");
            }
            Thread.sleep(1000);
            driver.switchTo().window(window);
            if(driver.getPageSource().contains("Opening a new window")){
                System.out.println("Test Case Passed");
            }
        }
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
