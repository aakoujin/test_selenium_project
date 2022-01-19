package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;


public class BaseTest {
    private static WebDriver webDriver;
    private static WebDriverWait wait;


    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        setWebDriver(webDriver);
        setWait(webDriver);
    }

    @AfterMethod
    public static void killDriver() {
        BaseTest.webDriver.quit();
    }

    private static void setWebDriver(WebDriver webDriver) {
        BaseTest.webDriver = webDriver;
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void setWait(WebDriver webDriver){
        BaseTest.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public static WebDriverWait getWait() {
        return wait;
    }
}
