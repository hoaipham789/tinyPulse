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
        user.firstName2.sendKeys("hoai2");
        user.lastName2.sendKeys("pham2");
        user.emailField2.sendKeys("d-hoai21@mailinator.com");
        user.addPeopleButton.click();

    }


    @Test(priority = 2)
    public void verifyCongratulationPage() throws InterruptedException {
        String congratTitle = user.congratulationTitle.getText();
        Thread.sleep(3000);
        congratTitle = congratTitle.replaceAll("check_circle", "");
        congratTitle = congratTitle.replaceAll("\\n", "");
        Assert.assertEquals(congratTitle, "Congratulations");
    }


    @Test(priority = 3)
    public void duplicatedEmail() throws InterruptedException {
        user.addPeopleIcon.click();
        user.firstName1.sendKeys("hoai1");
        user.lastName1.sendKeys("pham1");
        user.emailField1.sendKeys("d-hoai10@mailinator.com");
        user.addPeopleButton.click();

        String errorTitle = user.errorEmailExist.getText();
        Thread.sleep(2000);
        errorTitle = errorTitle.replaceAll("error", "");
        errorTitle = errorTitle.replaceAll("\\n", "");
        Assert.assertEquals(errorTitle, "Uh oh! Unable to add user because email already exists");
    }


    @Test(priority = 4)
    public void verifyAddMore() {
        user.addPeopleIcon.click();
        driver.findElement(By.xpath("//span[text()='Add more']//parent::div")).click();
        int numberRow = driver.findElements(By.xpath("//tbody[@class='lh-copy invitation-table']/tr")).size();
        Assert.assertTrue(numberRow > 4);

    }


}
