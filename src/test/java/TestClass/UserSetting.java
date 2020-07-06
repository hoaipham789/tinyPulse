package TestClass;

import Repository.LoginStore;
import Repository.UserStore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class UserSetting {

    WebDriver driver;
    UserStore user;
    @BeforeTest
    public WebDriver initConstructor() {
        driver = Main.driver;
        user = new UserStore(driver);
        return driver;
    }

    @Test
    public void accessAddPeopleTab() throws InterruptedException {
        user.userIcon.click();
        Thread.sleep(3000);
        user.addPeopleIcon.click();
    }

    @Test(priority = 1)
    public void addPeople() {
        user.firstName1.sendKeys("hoai1");
        user.lastName1.sendKeys("pham1");
        user.emailField1.sendKeys("d-hoai20@mailinator.com");
        user.addPeopleButton.click();

    }

    @Test(priority = 2)
    public void verifyCongratulationPage() throws InterruptedException {
        String congratTitle = user.congratulationTitle.getText();
        congratTitle = congratTitle.replaceAll("check_circle", "");
        congratTitle = congratTitle.replaceAll("\\n", "");
        Assert.assertEquals(congratTitle, "Congratulations");
        Thread.sleep(3000);
    }



    @Test(priority = 3)
    public void duplicatedEmail() {
        user.addPeopleIcon.click();
        user.firstName1.sendKeys("hoai1");
        user.lastName1.sendKeys("pham1");
        user.emailField1.sendKeys("d-hoai10@mailinator.com");
        user.addPeopleButton.click();

        String errorTitle = user.errorEmailExist.getText();
        errorTitle = errorTitle.replaceAll("error", "");
        errorTitle = errorTitle.replaceAll("\\n", "");
        Assert.assertEquals(errorTitle, "Uh oh! Unable to add user because email already exists");
    }


}
