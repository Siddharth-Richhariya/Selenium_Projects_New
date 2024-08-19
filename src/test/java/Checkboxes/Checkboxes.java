package Checkboxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Checkboxes {
    @Test
    public void clickCheckboxes() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for(WebElement checkbox : checkboxes)
            if(checkbox.isSelected()){
                checkbox.click();
            }

        if(!checkboxes.isEmpty()){
            checkboxes.get(0).click();
        }

        Thread.sleep(2000);

        driver.close();
    }
}
