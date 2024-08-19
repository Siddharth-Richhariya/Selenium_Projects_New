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

public class Logo {
    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();

        WebElement logo = driver.findElement(By.xpath("//img[@title='Your Store']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(logo));
        Thread.sleep(1000); //Adding small delay to randering stablity

        File sc = logo.getScreenshotAs(OutputType.FILE);
        File target = new File("src/main/resources/SC/Feature1.png");

        FileUtils.copyFile(sc, target);

        driver.quit();

    }
}
