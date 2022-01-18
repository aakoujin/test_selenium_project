package pagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    public CartPage(WebDriver webDriver, WebDriverWait wait) {
        super(webDriver, wait);
    }

    public void openCart() {
        this.webDriver.get("https://shop.demoqa.com/cart/");
    }
}
