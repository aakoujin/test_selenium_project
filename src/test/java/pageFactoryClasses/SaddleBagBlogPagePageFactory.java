package pageFactoryClasses;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SaddleBagBlogPagePageFactory extends BaseTest {
    WebDriver webDriver;
    WebDriverWait wait;

    @FindBy(id = "author")
    WebElement nameField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "url")
    WebElement urlField;

    @FindBy(id = "comment")
    WebElement commentBox;

    @FindBy(id = "submit")
    WebElement submitButton;

    public SaddleBagBlogPagePageFactory(WebDriver webDriver, WebDriverWait wait){
        this.webDriver = webDriver;
        this.wait = wait;

        AjaxElementLocatorFactory ajaxFactory = new AjaxElementLocatorFactory(this.webDriver, 2);
        PageFactory.initElements(ajaxFactory, this);
    }

    public void enterName(String name){
        nameField.sendKeys(name);
    }

    public void enterEmail(String email){
        emailField.sendKeys(email);
    }

    public void enterURL(String url){
        urlField.sendKeys(url);
    }

    public void enterComment(String comment){
        commentBox.sendKeys(comment);
    }

    public void submit(){
        submitButton.click();
    }

}
