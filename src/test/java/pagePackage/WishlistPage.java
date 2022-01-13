package pagePackage;

import org.openqa.selenium.WebDriver;

public class WishlistPage {
    WebDriver webDriver;

    public WishlistPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openWishList() {
        webDriver.get("https://shop.demoqa.com/wishlist/");
    }
}
