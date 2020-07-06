package Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserStore {

    WebDriver driver;

    public UserStore(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@aria-label='Users and Settings']")
    public WebElement userIcon;

    @FindBy(xpath = "//div[text()='Add People']//parent::div//parent::a")
    public WebElement addPeopleIcon;

    @FindBy(xpath = "(//input[@placeholder='First Name'])[1]") //
    public WebElement firstName1;

    @FindBy(xpath = "(//input[@placeholder='Last Name'])[1]")
    public WebElement lastName1;

    @FindBy(xpath = "(//input[@field='email'])[1]")
    public WebElement emailField1;

    @FindBy(xpath = "//div[@role='button']//span[text()='Add People']")
    public WebElement addPeopleButton;

    @FindBy(xpath = "//div[text()='Congratulations']")
    public WebElement congratulationTitle;

    @FindBy(xpath = "//div[@class='tu mv3 fw6 f3 flex items-center red']")
    public WebElement errorEmailExist;

}
