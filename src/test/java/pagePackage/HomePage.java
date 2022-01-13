package pagePackage;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BaseTest {
    WebDriver webDriver;

    By searchBar = new By.ByXPath("//*[@id=\"noo-site\"]/header/div[2]/div/a");

    By searchRequestField = By.className("form-control");

    By tShirt = new By.ByXPath("//*[@id=\"noo-site\"]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div[1]/a");


    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openHomePage() {
        getWebDriver().get("https://shop.demoqa.com/");
    }

    public void openSearchBar() {
        getWebDriver().findElement(searchBar).click();
    }

    public void enterSearchRequest(String input) {
        getWebDriver().findElement(searchRequestField).sendKeys(input, Keys.ENTER);
    }

    public void selectTShirt() {
        Actions action = new Actions(webDriver);

        // Hoover over animation mock
        action
                .moveToElement(getWebDriver().findElement(tShirt))
                .moveToElement(getWebDriver().findElement(tShirt))
                .click()
                .build()
                .perform();
    }

    public boolean atPage() {
        return getWebDriver().getTitle().equals("ToolsQA Demo Site – ToolsQA – Demo E-Commerce Site");
    }

    @Override
    public WebDriver getWebDriver() {
        return webDriver;
    }
}
