package pagePackage;

import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver webDriver;

    public CartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openCart() {
        this.webDriver.get("https://shop.demoqa.com/cart/");
    }
}
