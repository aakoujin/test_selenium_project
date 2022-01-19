package pageFactoryClasses;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPagePageFactory extends BaseTest {
    WebDriver webDriver;
    WebDriverWait wait;

    @FindBy(id = "pa_color")
    WebElement colorSelector;

    @FindBy(xpath = "//*[@id=\"pa_color\"]/option[2]")
    WebElement colorOption;

    @FindBy(id = "pa_size")
    WebElement sizeSelector;

    @FindBy(xpath = "//*[@id=\"pa_size\"]/option[3]")
    WebElement sizeOption;

    @FindBy(xpath = "//*[@id=\"product-1406\"]/div[1]/div[2]/form/div/div[2]/button")
    WebElement addToCartButton;


    public ProductPagePageFactory(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;

        AjaxElementLocatorFactory ajaxFactory = new AjaxElementLocatorFactory(this.webDriver, 2);
        PageFactory.initElements(ajaxFactory, this);
    }

    public void selectColor() {
        wait.until(ExpectedConditions.elementToBeClickable(colorSelector));
        colorSelector.click();
        colorOption.click();
    }

    public void selectSize() {
        wait.until(ExpectedConditions.elementToBeClickable(sizeSelector));
        sizeSelector.click();
        sizeOption.click();
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }

}
