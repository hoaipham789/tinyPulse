package TestClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class Main {


    public static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public static void initConstuction() {
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
}
