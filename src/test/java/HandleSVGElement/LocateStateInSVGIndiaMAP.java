package HandleSVGElement;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
//not working properly
public class LocateStateInSVGIndiaMAP {
    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize(); // Moved here for consistency
    }

    @Test
    public void testPositive() {
        String URL = "https://www.amcharts.com/svg-maps/?map=india";
        driver.get(URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Wait for the SVG element to be visible
        WebElement svgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[name()='svg']")));

        // Wait for the specific group within the SVG to be present
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']")));

        List<WebElement> states = driver.findElements(By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));

        for (WebElement state : states) {
            if (state.getAttribute("aria-label") != null && state.getAttribute("aria-label").contains("Tripura")) {
                // Scroll the element into view
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", state);

                // Wait for the element to be clickable
                wait.until(ExpectedConditions.elementToBeClickable(state));

                // Attempt to click the element
                try {
                    state.click();
                    System.out.println("Clicked on Tripura");
                } catch (Exception e) {
                    System.out.println("Error clicking on element: " + e.getMessage());
                    // Attempt a JavaScript click if standard click fails
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", state);
                }
                break;
            }
        }
    }

    @AfterTest
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
