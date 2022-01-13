package pageFactoryClasses;

import base.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage_PF extends BaseTest {
    WebDriver webDriver;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/header/div[2]/div/a")
    WebElement searchBox;

    @FindBy(className = "form-control")
    WebElement searchInput;

    public HomePage_PF(WebDriver webDriver){
        this.webDriver = webDriver;

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
