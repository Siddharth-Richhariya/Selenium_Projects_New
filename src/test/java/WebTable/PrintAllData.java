package WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class PrintAllData {
    @Test
    public void printAllData(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String URL = "https://awesomeqa.com/webtable.html";
        driver.get(URL);

        int row = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td")).size();

        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th"));
        for(WebElement header : headers){
            System.out.print(header.getText()+" \t");
        }
        System.out.println();

        String first_Part = "//table[@id='customers']/tbody/tr[";
        String second_Part = "]/td[";
        String third_part = "]";

        for (int i = 2; i<=row; i++){
            for (int j = 1; j<=col; j++){
                String Dynamic_Xpath = first_Part+i+second_Part+j+third_part;
                String tabledata = driver.findElement(By.xpath(Dynamic_Xpath)).getText();
                System.out.print(tabledata+"\t");
            }
            System.out.println();
        }
        driver.quit();

    }
}
