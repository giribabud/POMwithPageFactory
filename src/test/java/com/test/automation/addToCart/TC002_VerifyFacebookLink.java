package com.test.automation.addToCart;

import com.test.automation.testBase.TestBase;
import com.test.automation.uiActions.AddToCart;
import com.test.automation.uiActions.HomePage;
import com.test.automation.uiActions.ProductDetailsPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class TC002_VerifyFacebookLink extends TestBase {

    HomePage homePage;
    ProductDetailsPage productDetailsPage;
    AddToCart addToCart;


    @BeforeClass
    public void setUp(){
    init();
    }
    @Test
    public void verifyFacebookLink(){
        log.info("=========== Starting Verify add to cart ===========");
        homePage = new HomePage(driver);
        homePage.clickOnNavigationMenu();
        homePage.clickOnsubcatDresses(homePage.tops);
        productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.selectProduct(productDetailsPage.fadedShortSleeve_Tshirts);
        addToCart = new AddToCart(driver);

        addToCart.clickOnFacebookLink();
        Iterator<String> itr = getAllWindows();
        String parentWindow = itr.next();
        String childWindow = itr.next();
        driver.switchTo().window(childWindow);
       boolean status = addToCart.verifyFacebookLogo();
       driver.switchTo().window(parentWindow);
        Assert.assertEquals(true, status);


    }
    @AfterClass
    public void endTest(){
        closeBrowser();

    }


}
