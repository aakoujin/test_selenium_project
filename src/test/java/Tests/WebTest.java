package Tests;

import base.BaseTest;
import org.junit.Before;
import org.junit.Test;
import pageFactoryClasses.*;
import pagePackage.*;

import static org.assertj.core.api.Assertions.assertThat;

public class WebTest extends BaseTest {
    BasePage basePage;
    HomePage homePage;
    ProductPage productPage;
    WishlistPage wishlistPage;
    CartPage cartPage;
    BlogPagePageFactory blogPagePageFactory;
    SaddleBagBlogPagePageFactory saddleBagBlogPagePageFactory;
    SearchResultsPageFactory searchResultsPagePageFactory;
    ProductPagePageFactory productPagePageFactory;
    HomePagePageFactory homePagePageFactory;


    @Before
    public void initTest() {
        this.basePage = new BasePage(BaseTest.getWebDriver(), BaseTest.getWait());
        this.homePage = new HomePage(BaseTest.getWebDriver(), BaseTest.getWait());
        this.productPage = new ProductPage(BaseTest.getWebDriver(), BaseTest.getWait());
        this.wishlistPage = new WishlistPage(BaseTest.getWebDriver(), BaseTest.getWait());
        this.cartPage = new CartPage(BaseTest.getWebDriver(), BaseTest.getWait());

        this.homePagePageFactory = new HomePagePageFactory(BaseTest.getWebDriver(), BaseTest.getWait());
        this.blogPagePageFactory = new BlogPagePageFactory(BaseTest.getWebDriver(), BaseTest.getWait());
        this.saddleBagBlogPagePageFactory = new SaddleBagBlogPagePageFactory(BaseTest.getWebDriver(), BaseTest.getWait());
        this.searchResultsPagePageFactory = new SearchResultsPageFactory(BaseTest.getWebDriver(), BaseTest.getWait());
        this.productPagePageFactory = new ProductPagePageFactory(BaseTest.getWebDriver(), BaseTest.getWait());
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
