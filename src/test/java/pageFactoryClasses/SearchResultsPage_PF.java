package pageFactoryClasses;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SearchResultsPage_PF extends BaseTest {
    WebDriver webDriver;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[1]/div/div[2]/form[2]/select")
    WebElement sizeSelector;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[1]/div/div[2]/form[2]/select/option[5]")
    WebElement sizeSelectorOption;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[1]/div")
    WebElement filteredOption;

    public SearchResultsPage_PF(WebDriver webDriver){
        this.webDriver = webDriver;

        AjaxElementLocatorFactory ajaxFactory = new AjaxElementLocatorFactory(this.webDriver, 2);
        PageFactory.initElements(ajaxFactory, this);
    }

    public void openSizeSelector(){
        sizeSelector.click();
    }

    public void selectSizeOption(){
        sizeSelectorOption.click();
    }

    public void selectFirstFilteredOption(){
        filteredOption.click();
    }
}
