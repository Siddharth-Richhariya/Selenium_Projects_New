package PracticeLoginPage;

import org.testng.annotations.Test;

public class TestClass extends BaseClass{
    @Test
    public void test(){
        LoginPage lg = new LoginPage(driver);
        lg.Logintest("standard_user", "secret_sauce");
    }
}
