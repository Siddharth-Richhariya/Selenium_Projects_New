package PracticeLoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@type = 'text' and @id = 'user-name']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@type = 'password' and @id = 'password']")
    private WebElement passwordField;

    @FindBy (xpath = "//input[@type = 'submit' and @id = 'login-button']")
    private WebElement loginButton;

    public LoginPage (WebDriver driver){
        super(driver);
    }
    public void Logintest(String userName, String password){
        type(usernameField, userName);
        type(passwordField, password);
        click(loginButton);

    }
}
