package pageFactoryClasses;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ProductPage_PF extends BaseTest {
    WebDriver webDriver;

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


    public ProductPage_PF(WebDriver webDriver) {
        this.webDriver = webDriver;

        AjaxElementLocatorFactory ajaxFactory = new AjaxElementLocatorFactory(this.webDriver, 2);
        PageFactory.initElements(ajaxFactory, this);
    }

    public void selectColor() {
        colorSelector.click();
        colorOption.click();
    }

    public void selectSize() {
        sizeSelector.click();
        sizeOption.click();
    }

    public void addToCart() {
        addToCartButton.click();
    }

}
