package CAWSStudioAssignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            // Initialize the WebDriver only if it is null
            driver = new ChromeDriver();
        }
        return driver;
    }
}
