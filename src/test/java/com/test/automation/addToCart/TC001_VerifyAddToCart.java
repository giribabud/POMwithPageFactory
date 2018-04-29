package com.test.automation.addToCart;

import com.test.automation.testBase.TestBase;
import com.test.automation.uiActions.HomePage;
import com.test.automation.uiActions.ProductDetailsPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC001_VerifyAddToCart extends TestBase {
    HomePage homePage;

    ProductDetailsPage productDetailsPage;

    @BeforeClass
    public void setUp(){
        init();
    }

    @Test
    public void verifyAddToCart(){
        log.info("=========== Starting Verify add to cart ===========");
        homePage = new HomePage(driver);
        homePage.clickOnNavigationMenu();
        homePage.clickOnsubcatDresses(homePage.tops);
        productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.selectProduct(productDetailsPage.fadedShortSleeve_Tshirts);
    }
    @AfterClass
    public void endTest(){
       closeBrowser();
    }

}
//p[@id='add_to_cart']