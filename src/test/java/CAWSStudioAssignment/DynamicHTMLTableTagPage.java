package CAWSStudioAssignment;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Page class for interacting with a dynamic HTML table
public class DynamicHTMLTableTagPage {
    WebDriver driver;
    JSONUtils jsonUtils = new JSONUtils();   // Instance of JSONUtils for JSON operations
    String filepath = "src/test/java/CAWSStudioAssignment/data.json";

    // Constructor initializes the WebDriver and PageFactory for this page
    public DynamicHTMLTableTagPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    // Locators for elements on the web page
    By TableDataButton = By.xpath("//*[normalize-space()='Table Data']");
    By TextArea = By.xpath("//textarea[@id='jsondata']");
    By RefreshButton = By.xpath("//button[@id='refreshtable']");
    By TableRows = By.xpath("//table[@id='dynamictable']/tr");

    // Opens the specified URL in the browser
    public void openUrl(){
        driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
    }

    // Clicks the button to display text Area and refresh button
    public void clickTableDataButton(){
        driver.findElement(TableDataButton).click();
    }

    // Reads data from a JSON file and enters it in a text area on the page
    public void enterText() throws IOException, ParseException {

        String JSONData = jsonUtils.readDataFromJSON(filepath);
        WebElement inputBox = driver.findElement(TextArea);
        inputBox.clear();
        inputBox.sendKeys(JSONData);

    }

    // Clicks the refresh button to reload the table data
    public void refreshTable(){
        WebElement refreshButton = driver.findElement(RefreshButton);
        refreshButton.click();
    }

    // Retrieves data from the table and stores it in a List
    public List<String> getDataFromTable(){
        List<String> tableData = new ArrayList<>();
        List<WebElement> rows = driver.findElements(TableRows);

        for(WebElement row : rows){
            List<WebElement> columns = row.findElements(By.tagName("td"));
            for(WebElement col: columns){
                tableData.add(col.getText().trim());
            }
        }
        return tableData;
    }

    // Validates that table data matches JSON data
    public void validateTableData() throws IOException, ParseException{
        String JSONData = jsonUtils.readDataFromJSON(filepath);
        List<String> tabledata = getDataFromTable();
        jsonUtils.assertTable(tabledata, JSONData);
    }
}
