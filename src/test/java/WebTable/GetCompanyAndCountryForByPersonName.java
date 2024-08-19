package WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetCompanyAndCountryForByPersonName {
    @Test
    public void getData(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String URL= "https://awesomeqa.com/webtable.html";
        driver.get(URL);

        int row = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td")).size();

        String first_Part = "//table[@id='customers']/tbody/tr[";
        String second_Part = "]/td[";
        String third_part = "]";

        for (int i = 2; i<=row; i++){
            for (int j = 1; j<=col; j++) {
                String Dynamic_Xpath = first_Part + i + second_Part + j + third_part;
                String tabledata = driver.findElement(By.xpath(Dynamic_Xpath)).getText();
                if(tabledata.contains("Roland Mendel")){
                    String countrypath = Dynamic_Xpath+"/following-sibling::td";
                    String companypath = Dynamic_Xpath+"/preceding-sibling::td";
                    String comapany_Name = driver.findElement(By.xpath(companypath)).getText();
                    String coutry_Name = driver.findElement(By.xpath(countrypath)).getText();
                    System.out.println("Company Name : "+ comapany_Name+"\n"+"Country : "+coutry_Name);
                }
            }
        }
    }
}
