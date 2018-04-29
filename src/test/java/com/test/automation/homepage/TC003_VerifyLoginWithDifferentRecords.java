package com.test.automation.homepage;

import com.test.automation.testBase.TestBase;
import com.test.automation.uiActions.HomePage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC003_VerifyLoginWithDifferentRecords extends TestBase {
    public static final Logger log  = Logger.getLogger(TC003_VerifyLoginWithDifferentRecords.class.getName());

    HomePage homepage;
    //WebDriver driver;
    //String emailAddress = "testgiri12345@gmail.com";
    //String password = "password";


    @DataProvider(name="loginData")
    public String[][] getTestData(){
        String[][] testRecords = getData("LoginTestData","TestData.xlsx");
        return testRecords;
    }

    @BeforeClass
    public void  setUp(){
        init();
    }


    @Test(dataProvider = "loginData")
    public void testLogin(String emailAddress, String password, String runMode){
        if(runMode.equalsIgnoreCase("n")){
            throw new SkipException("User Mark this as a Norun");
        }
        homepage = new HomePage(driver);
        homepage.loginToApplication(emailAddress, password );
        boolean status = homepage.verifyLogoutDisplayed();
       // getScreenShot("verifyLoginWithDifferentRecords");

        if(status){
            homepage.clickOnLogout();
        }
        Assert.assertEquals(status, true );

    }

}
