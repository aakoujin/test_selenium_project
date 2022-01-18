package Tests;

import base.BaseTest;
import org.junit.Before;
import org.junit.Test;
import pageFactoryClasses.*;
import pagePackage.*;

import static org.assertj.core.api.Assertions.assertThat;

public class WebTest extends BaseTest {
    BaseTest baseTest;
    BasePage basePage;
    HomePage homePage;
    ProductPage productPage;
//    JavascriptExecutor js;
    WishlistPage wishlistPage;
    CartPage cartPage;
    BlogPagePageFactory blogPagePageFactory;
    SaddleBagBlogPagePageFactory saddleBagBlogPagePageFactory;
    SearchResultsPageFactory searchResultsPagePageFactory;
    ProductPagePageFactory productPagePageFactory;
    HomePagePageFactory homePagePageFactory;

    @Before
    public void initTest() {
        this.baseTest = new BaseTest();
        baseTest.setup();

        this.basePage = new BasePage(baseTest.getWebDriver(), baseTest.getWait());
        this.homePage = new HomePage(baseTest.getWebDriver(), baseTest.getWait());
        this.productPage = new ProductPage(baseTest.getWebDriver(), baseTest.getWait());
        this.wishlistPage = new WishlistPage(baseTest.getWebDriver(), baseTest.getWait());
        this.cartPage = new CartPage(baseTest.getWebDriver(), baseTest.getWait());
        //this.js = (JavascriptExecutor) baseTest.getWebDriver();

        this.homePagePageFactory = new HomePagePageFactory(baseTest.getWebDriver(), baseTest.getWait());
        this.blogPagePageFactory = new BlogPagePageFactory(baseTest.getWebDriver(), baseTest.getWait());
        this.saddleBagBlogPagePageFactory = new SaddleBagBlogPagePageFactory(baseTest.getWebDriver(), baseTest.getWait());
        this.searchResultsPagePageFactory = new SearchResultsPageFactory(baseTest.getWebDriver(), baseTest.getWait());
        this.productPagePageFactory = new ProductPagePageFactory(baseTest.getWebDriver(), baseTest.getWait());
    }

//    @After
//    public void endTest(){
//        baseTest.killDriver();
//    }

    //Task B
    //sometimes fails for no reason at "Add to wishlist" step/ requires refreshing Wishlist page
    @Test
    public void wishlistTest() {
        homePage.openHomePage();
        homePage.openSearchBar();
        homePage.enterSearchRequest("TOKYO TALKIES");
        basePage.scrollDown(850);
        productPage.addToWishList();
        wishlistPage.openWishList();

    }


    //Task C
    @Test
    public void tShirtTest() {
        homePage.openHomePage();
        basePage.scrollDown(850);
        homePage.selectTShirt();
        basePage.scrollDown(850);
        productPage.selectColor();
        productPage.selectSize();
        productPage.selectQuantity();
        productPage.addToCart();
        cartPage.openCart();
    }

    //Task D
    @Test
    public void captchaCommentTest(){
        blogPagePageFactory.openBlogPage();
        blogPagePageFactory.openReadMore();
        basePage.scrollDown(2050);

        saddleBagBlogPagePageFactory.enterName("TestName");
        saddleBagBlogPagePageFactory.enterEmail("test@gmail.com");
        saddleBagBlogPagePageFactory.enterComment("Sample comment");
        saddleBagBlogPagePageFactory.enterURL("sample url");
        saddleBagBlogPagePageFactory.submit();
    }

    //Task E
    @Test
    public void pageFactoryTest(){
        homePagePageFactory.openHomePage();
        homePagePageFactory.openSearchBox();
        homePagePageFactory.inputSearchRequest("BLUE");
        searchResultsPagePageFactory.openSizeSelector();
        searchResultsPagePageFactory.selectSizeOption();
        searchResultsPagePageFactory.selectFirstFilteredOption();
        basePage.scrollDown(850);
        productPagePageFactory.selectColor();
        productPagePageFactory.selectSize();
        productPagePageFactory.addToCart();
        cartPage.openCart();
    }

}
