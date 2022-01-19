package pagePackage;

import base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends BaseTest {

    WebDriver webDriver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public BasePage(WebDriver webDriver, WebDriverWait wait){
        this.webDriver = webDriver;
        this.wait = wait;
        this.js = (JavascriptExecutor) this.webDriver;
    }

    public void scrollDown(int scrollDepth){
        js.executeScript("window.scrollBy(0," + scrollDepth +")", "");
    }
    public boolean atPage() {
        return webDriver.getTitle().equals("ToolsQA Demo Site – ToolsQA – Demo E-Commerce Site");
    }

}
