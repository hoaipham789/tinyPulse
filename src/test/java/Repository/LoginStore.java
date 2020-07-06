package Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginStore {

    WebDriver driver;
    public LoginStore(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Login")
    public WebElement loginLink;

    @FindBy(id = "session_email")
    public WebElement loginEmail;

    @FindBy(id = "session_password")
    public WebElement loginPasswd;

    @FindBy(xpath = "//button[@name='button']")
    public WebElement loginButton;

}
