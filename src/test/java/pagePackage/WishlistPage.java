package pagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishlistPage extends BasePage{


    public WishlistPage(WebDriver webDriver, WebDriverWait wait) {
        super(webDriver, wait);
    }

    public void openWishList() {

        webDriver.get("https://shop.demoqa.com/wishlist/");
    }
}
