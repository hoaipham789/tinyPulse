package Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserStore {

    WebDriver driver;
    public UserStore(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[@aria-label='Users and Settings']")
    public WebElement userIcon;

    @FindBy(xpath = "//div[text()='Add People']//ancestor::a")
    public WebElement addPeopleTab;

    @FindBy(xpath = "//div[text()='People']//ancestor::a")
    public WebElement peopleTab;

    @FindBy(xpath = "(//input[@placeholder='First Name'])[1]")
    public WebElement firstName1;

    @FindBy(xpath = "(//input[@placeholder='Last Name'])[1]")
    public WebElement lastName1;

    @FindBy(xpath = "(//input[@field='email'])[1]")
    public WebElement emailField1;

    @FindBy(xpath = "(//input[@placeholder='First Name'])[2]")
    public WebElement firstName2;

    @FindBy(xpath = "(//input[@placeholder='Last Name'])[2]")
    public WebElement lastName2;

    @FindBy(xpath = "(//input[@field='email'])[2]")
    public WebElement emailField2;

    @FindBy(xpath = "//div[@role='button']//span[text()='Add People']")
    public WebElement addPeopleButton;

    @FindBy(xpath = "//div[text()='Congratulations']")
    public WebElement congratulationTitle;

    @FindBy(xpath = "//div[@class='tu mv3 fw6 f3 flex items-center red']")
    public WebElement errorEmailExist;

    @FindBy(xpath = "//div[contains(@data-original-title,'.com')]/div[@class='Tooltip__tooltip___17_Ie']")
    public List<WebElement> emailListWeb;



}
