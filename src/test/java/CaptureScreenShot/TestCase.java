package CaptureScreenShot;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class TestCase {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();

        TakesScreenshot sc = (TakesScreenshot)driver;
        File screenshot = sc.getScreenshotAs(OutputType.FILE);

        File destination = new File("src/main/resources/SC/Fix.png");

        try {
            // Copy the file to the destination
            FileUtils.copyFile(screenshot, destination);
        } catch (IOException e) {
            e.printStackTrace();//
        }

        // Close the browser
        driver.quit();


    }
}
