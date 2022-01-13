package Tests;

import base.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pageFactoryClasses.*;
import pagePackage.CartPage;
import pagePackage.HomePage;
import pagePackage.ProductPage;
import org.openqa.selenium.JavascriptExecutor;
import pagePackage.WishlistPage;

import static org.assertj.core.api.Assertions.assertThat;

public class WebTest extends BaseTest {
    BaseTest baseTest;
    HomePage homePage;
    ProductPage productPage;
    JavascriptExecutor js;
    WishlistPage wishlistPage;
    CartPage cartPage;
    BlogPage_PF blogPage_pf;
    SaddleBagBlogPage_PF saddleBagBlogPage_pf;
    SearchResultsPage_PF searchResultsPage_pf;
    ProductPage_PF productPage_pf;
    HomePage_PF homePage_pf;

    @Before
    public void initTest() {
        this.baseTest = new BaseTest();
        baseTest.setup();

        this.homePage = new HomePage(baseTest.getWebDriver());
        this.productPage = new ProductPage(baseTest.getWebDriver());
        this.wishlistPage = new WishlistPage(baseTest.getWebDriver());
        this.cartPage = new CartPage(baseTest.getWebDriver());
        this.js = (JavascriptExecutor) baseTest.getWebDriver();

        this.homePage_pf = new HomePage_PF(baseTest.getWebDriver());
        this.blogPage_pf = new BlogPage_PF(baseTest.getWebDriver());
        this.saddleBagBlogPage_pf = new SaddleBagBlogPage_PF(baseTest.getWebDriver());
        this.searchResultsPage_pf = new SearchResultsPage_PF(baseTest.getWebDriver());
        this.productPage_pf = new ProductPage_PF(baseTest.getWebDriver());
    }

//    @After
//    public void endTest(){
//        baseTest.killDriver();
//    }

    //Task B
    @Test
    public void wishlistTest() {
        homePage.openHomePage();
        homePage.openSearchBar();
        homePage.enterSearchRequest("TOKYO TALKIES");
        js.executeScript("window.scrollBy(0,850)", "");
        productPage.addToWishList("/html/body/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/div/a");
        wishlistPage.openWishList();
    }


    //Task C
    @Test
    public void tShirtTest() {
        homePage.openHomePage();
        js.executeScript("window.scrollBy(0,850)", "");
        homePage.selectTShirt();
        js.executeScript("window.scrollBy(0,850)", "");
        productPage.selectColor();
        productPage.selectSize();
        productPage.selectQuantity();
        productPage.addToCart();
        cartPage.openCart();
    }

    //Task D
    @Test
    public void captchaCommentTest(){
        blogPage_pf.openBlogPage();
        blogPage_pf.openReadMore();
        js.executeScript("window.scrollBy(0,2050)", "");

        saddleBagBlogPage_pf.enterName("TestName");
        saddleBagBlogPage_pf.enterEmail("test@gmail.com");
        saddleBagBlogPage_pf.enterComment("Sample comment");
        saddleBagBlogPage_pf.enterURL("sample url");
        saddleBagBlogPage_pf.submit();
    }

    //Task E
    @Test
    public void pageFactoryTest(){
        homePage_pf.openHomePage();
        homePage_pf.openSearchBox();
        homePage_pf.inputSearchRequest("BLUE");
        searchResultsPage_pf.openSizeSelector();
        searchResultsPage_pf.selectSizeOption();
        searchResultsPage_pf.selectFirstFilteredOption();
        js.executeScript("window.scrollBy(0,850)", "");
        productPage_pf.selectColor();
        productPage_pf.selectSize();
        productPage_pf.addToCart();
        cartPage.openCart();
    }

}
