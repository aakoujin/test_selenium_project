package pageFactoryClasses;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BlogPage_PF extends BaseTest {
    WebDriver webDriver;

    @FindBy(xpath = "//*[@id=\"post-505\"]/div[2]/a")
    WebElement readMore1;

    public BlogPage_PF(WebDriver webDriver){
        this.webDriver = webDriver;

        AjaxElementLocatorFactory ajaxFactory = new AjaxElementLocatorFactory(this.webDriver, 2);
        PageFactory.initElements(ajaxFactory, this);
    }

    public void openBlogPage(){
        webDriver.get("https://shop.demoqa.com/author/lsharm/");
    }

    public void openReadMore(){
        readMore1.click();
    }
}
