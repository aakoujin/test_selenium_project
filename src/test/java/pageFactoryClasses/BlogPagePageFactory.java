package pageFactoryClasses;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlogPagePageFactory extends BaseTest {
    WebDriver webDriver;
    WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"post-505\"]/div[2]/a")
    WebElement readMore1;

    public BlogPagePageFactory(WebDriver webDriver, WebDriverWait wait){
        this.webDriver = webDriver;
        this.wait = wait;

        AjaxElementLocatorFactory ajaxFactory = new AjaxElementLocatorFactory(this.webDriver, 2);
        PageFactory.initElements(ajaxFactory, this);
    }

    public void openBlogPage(){
        webDriver.get("https://shop.demoqa.com/author/lsharm/");
    }

    public void openReadMore(){
        wait.until(ExpectedConditions.elementToBeClickable(readMore1));
        readMore1.click();
    }
}
