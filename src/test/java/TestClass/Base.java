package TestClass;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Base {


    public static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public static void initConstruction() {
        System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver83\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1600,900");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    //        @AfterSuite
    public void closeBrowser() {
        driver.close();
    }


    public void getScreenShot(String testCaseName) throws IOException {
        TakesScreenshot pic = (TakesScreenshot) driver;
        File source =  pic.getScreenshotAs(OutputType.FILE);
        String locationFile = System.getProperty("user.dir")+"\\report\\" + testCaseName+".png";
        FileUtils.copyFile(source, new File(locationFile));
    }
}
