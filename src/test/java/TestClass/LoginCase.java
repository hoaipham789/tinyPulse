package TestClass;

import Repository.LoginStore;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginCase {

    WebDriver driver;
    LoginStore lg;
    @BeforeTest
    public WebDriver initConstructor() {
        driver = Main.driver;
        driver.get("https://staging.tinyserver.info/engage/signup");
        lg = new LoginStore(driver);
        return driver;
    }

    @Test
    public void accessLoginPage(){
        lg.loginLink.click();
    }

    @Test(priority = 1)
    public void signIn() {
        lg.loginEmail.sendKeys("d-hoai@mailinator.com");
        lg.loginPasswd.sendKeys("123456?Aa");
        lg.loginButton.click();


    }


}
