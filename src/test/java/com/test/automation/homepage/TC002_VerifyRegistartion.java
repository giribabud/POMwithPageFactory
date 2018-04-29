package com.test.automation.homepage;

import com.test.automation.testBase.TestBase;
import com.test.automation.uiActions.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC002_VerifyRegistartion extends TestBase {

    HomePage homePage;

    String emailId = "giritest8711@gmail.com";
    String firstName = "giri";
    String lastName = "babu";
    String password = "password";
    String company = "testing";
    String city = "Bangalore";
    String address1 = "BTM";
    String postCode = "35006";
    String state = "Alabama";
    String phoneMobile = "86874545";
    String alias ="alias";

    @BeforeClass
    public void setUp(){
        init();
    }
    @Test
    public  void testLogin() {
        homePage = new HomePage(driver);
        homePage.registerUser(emailId, firstName, lastName, password, company, address1, city, state, postCode, phoneMobile,  alias);
        homePage.getRegistrationSuccess();
        Assert.assertEquals("giri babu", homePage.getRegistrationSuccess());
    }

    @AfterClass
    public void endTest(){
        driver.quit();
    }
}
