package TestClass;


import Repository.UserStore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserSetting {

    WebDriver driver;
    UserStore user;

    @BeforeTest
    public WebDriver initConstructor() {
        driver = Base.driver;
        user = new UserStore(driver);
        return driver;
    }


    @Test
    public void accessAddPeopleTab() throws InterruptedException {
        user.userIcon.click();
        Thread.sleep(3000);
        user.addPeopleTab.click();
    }


//    @Test(priority = 1)
    public void addPeople() {
        user.firstName1.sendKeys("hoai1");
        user.lastName1.sendKeys("pham1");
        user.emailField1.sendKeys("d-hoai22@mailinator.com");
        user.firstName2.sendKeys("hoai2");
        user.lastName2.sendKeys("pham2");
        user.emailField2.sendKeys("d-hoai23@mailinator.com");
        user.addPeopleButton.click();

    }


//    @Test(priority = 2)
    public void verifyCongratulationPage() throws InterruptedException {
        String congratTitle = user.congratulationTitle.getText();
        Thread.sleep(3000);
        congratTitle = congratTitle.replaceAll("check_circle", "");
        congratTitle = congratTitle.replaceAll("\\n", "");
        Assert.assertEquals(congratTitle, "Congratulations");
    }


    @Test(priority = 3)
    public void verifyPeopleAdded() {
        user.peopleTab.click();
        String[] compareEmail = {"d-hoai22@mailinator.com", "d-hoai23@mailinator.com"};
        List<String> originEmail = Arrays.asList(compareEmail);

        List<String> listWebEmail = new ArrayList<>();
        for (int i = 0; i < user.emailListWeb.size(); i++) {
            String n = user.emailListWeb.get(i).getText();
            listWebEmail.add(n);
        }
        Assert.assertTrue(listWebEmail.containsAll(originEmail));


    }


//    @Test(priority = 4)
    public void duplicatedEmail() throws InterruptedException {
        user.addPeopleTab.click();
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


//    @Test(priority = 5)
    public void verifyAddMore() {
        user.addPeopleTab.click();
        driver.findElement(By.xpath("//span[text()='Add more']//parent::div")).click();
        int numberRow = driver.findElements(By.xpath("//tbody[@class='lh-copy invitation-table']/tr")).size();
        Assert.assertTrue(numberRow > 4);

    }


}
