package com.test.automation.homepage;

import com.test.automation.testBase.TestBase;
import com.test.automation.uiActions.HomePage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC001_VerifyLoginWithInvalidCredentials extends TestBase{

    public static final Logger log  = Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());

    HomePage homepage;

    @BeforeTest
    public void setUp(){
       init();
        }
    @Test
    public void verifyLoginWithInvalidCredentials(){
        log.info("==============Starting TC001_VerifyLoginWithInvalidCredentials Test====");
        homepage = new HomePage(driver);
        homepage.loginToApplication("test@gmail.com","password");

        Assert.assertEquals(homepage.getInvalidLoginText(),"Authentication failed.");
        log.info("==============Finished TC001_VerifyLoginWithInvalidCredentials Test====");
    }

}