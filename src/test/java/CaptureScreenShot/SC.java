package CaptureScreenShot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class SC {
    static WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new ChromeDriver(options);
    }

        @Test
        public void sc() throws IOException, InterruptedException {

        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();
        Thread.sleep(4000);

        WebElement FeaturesLogo = driver.findElement(By.xpath("//img[@alt='iPhone 6']"));
        File src = FeaturesLogo.getScreenshotAs(OutputType.FILE);
        File target = new File("src/main/resources/SC/Feature9.png");

        FileUtils.copyFile(src,target);

        driver.quit();
    }
}
