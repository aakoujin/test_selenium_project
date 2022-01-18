package pageFactoryClasses;

import base.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePagePageFactory extends BaseTest {
    WebDriver webDriver;
    WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/header/div[2]/div/a")
    WebElement searchBox;

    @FindBy(className = "form-control")
    WebElement searchInput;

    public HomePagePageFactory(WebDriver webDriver, WebDriverWait wait){
        this.webDriver = webDriver;
        this.wait = wait;

        AjaxElementLocatorFactory ajaxFactory = new AjaxElementLocatorFactory(this.webDriver, 2);
        PageFactory.initElements(ajaxFactory, this);
    }

    public void openHomePage(){
        webDriver.get("https://shop.demoqa.com/");
    }

    public void openSearchBox(){
        searchBox.click();
    }

    public void inputSearchRequest(String request){
        searchInput.sendKeys(request, Keys.ENTER);
    }

}
