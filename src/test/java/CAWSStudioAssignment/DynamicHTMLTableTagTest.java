package CAWSStudioAssignment;

import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

// Test class for verifying dynamic HTML table data functionality
public class DynamicHTMLTableTagTest {
    DynamicHTMLTableTagPage dynamicHTMLTableTagPage;  // Instance of the page object

    // Setup method to initialize WebDriver before any tests are run
    @BeforeClass
    public void setup() {
        BaseClass.getDriver();

    }

    // Test method to verify data entry and validation in the dynamic table
    @Test
    public void testDynamicHTMLTableData() throws InterruptedException, IOException, ParseException {
        dynamicHTMLTableTagPage = new DynamicHTMLTableTagPage(BaseClass.getDriver());
        dynamicHTMLTableTagPage.openUrl(); // Opens the URL
        dynamicHTMLTableTagPage.clickTableDataButton(); // Clicks the button to view text Area and refresh button
        dynamicHTMLTableTagPage.enterText(); // Clear and Enters JSON data in the table
        dynamicHTMLTableTagPage.refreshTable(); // Refreshes the table to view entered data
        dynamicHTMLTableTagPage.validateTableData();  // Validates table data against JSON data

        Thread.sleep(2000); // Pauses briefly for demonstration purposes
    }

    // Cleanup method to close the browser after tests are completed
    @AfterClass
    public void quitBrowser(){
        BaseClass.getDriver().quit();
    }
}
