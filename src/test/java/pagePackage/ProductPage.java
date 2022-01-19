package pagePackage;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage{

    By addToWishListButton = new By.ByClassName("add_to_wishlist");

    By colorSelector = new By.ByXPath("//*[@id=\"pa_color\"]");

    By selectorOption = new By.ByXPath("//*[@id=\"pa_color\"]/option[2]");

    By sizeSelector = new By.ByXPath("//*[@id=\"pa_size\"]");

    By sizeSelectorOption = new By.ByXPath("//*[@id=\"pa_size\"]/option[3]");

    By quantitySelector = new By.ByXPath("//*[@id=\"noo-quantity-3005\"]");

    By addToCardButton = new By.ByXPath("//*[@id=\"product-1497\"]/div[1]/div[2]/form/div/div[2]/button");



    public ProductPage(WebDriver webDriver, WebDriverWait wait) {
        super(webDriver, wait);
    }

    public void addToWishList() {
        Actions action = new Actions(webDriver);

        wait.until(ExpectedConditions.presenceOfElementLocated(addToWishListButton));
        wait.until(ExpectedConditions.elementToBeClickable(addToWishListButton));

        action
                .moveToElement(webDriver.findElement(addToWishListButton))
                .doubleClick()
                .build()
                .perform();

        wait.until(ExpectedConditions.elementToBeClickable(addToWishListButton));
    }

    public void selectColor() {
        wait.until(ExpectedConditions.presenceOfElementLocated(colorSelector));
        webDriver.findElement(colorSelector).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(selectorOption));
        webDriver.findElement(selectorOption).click();
    }

    public void selectSize() {
        wait.until(ExpectedConditions.presenceOfElementLocated(sizeSelector));
        webDriver.findElement(sizeSelector).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(sizeSelectorOption));
        webDriver.findElement(sizeSelectorOption).click();
    }

    public void selectQuantity() {
        wait.until(ExpectedConditions.presenceOfElementLocated(quantitySelector));
        webDriver.findElement(quantitySelector).clear();
        wait.until(ExpectedConditions.textToBe(quantitySelector,""));
        webDriver.findElement(quantitySelector).sendKeys("3");
    }

    public void addToCart() {
        wait.until(ExpectedConditions.presenceOfElementLocated(addToCardButton));
        webDriver.findElement(addToCardButton).click();
    }

}
