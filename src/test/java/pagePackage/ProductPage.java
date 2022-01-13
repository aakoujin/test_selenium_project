package pagePackage;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductPage extends BaseTest {
    WebDriver webDriver;

    By addToWishListButton = new By.ByXPath("/html/body/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/div/a");

    By colorSelector = new By.ByXPath("//*[@id=\"pa_color\"]");

    By selectorOption = new By.ByXPath("//*[@id=\"pa_color\"]/option[2]");

    By sizeSelector = new By.ByXPath("//*[@id=\"pa_size\"]");

    By sizeSelectorOption = new By.ByXPath("//*[@id=\"pa_size\"]/option[3]");

    By quantitySelector = new By.ByXPath("//*[@id=\"noo-quantity-4643\"]");

    By addToCardButton = new By.ByXPath("//*[@id=\"product-1497\"]/div[1]/div[2]/form/div/div[2]/button");

    public ProductPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void addToWishList(String xpath) {
        Actions action = new Actions(webDriver);

        // Hoover over animation mock
        action
                .moveToElement(webDriver.findElement(addToWishListButton))
                .moveToElement(webDriver.findElement(addToWishListButton))
                .click()
                .build()
                .perform();

        webDriver.findElement(addToWishListButton).click();
    }

    public void selectColor() {
        webDriver.findElement(colorSelector).click();
        webDriver.findElement(selectorOption).click();
    }

    public void selectSize() {
        webDriver.findElement(sizeSelector).click();
        webDriver.findElement(sizeSelectorOption).click();
    }

    public void selectQuantity() {
        webDriver.findElement(quantitySelector).clear();
        webDriver.findElement(quantitySelector).sendKeys("3");
    }

    public void addToCart() {
        webDriver.findElement(addToCardButton).click();
    }

}
