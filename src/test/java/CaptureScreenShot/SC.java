package CaptureScreenShot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class SC {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();

        WebElement FeaturesLogo = driver.findElement(By.xpath("//img[@alt='iPhone 6']"));
        Thread.sleep(5000);
        File src = FeaturesLogo.getScreenshotAs(OutputType.FILE);
        File target = new File("src/main/resources/SC/Feature6.png");

        FileUtils.copyFile(src,target);

        driver.quit();
    }
}
