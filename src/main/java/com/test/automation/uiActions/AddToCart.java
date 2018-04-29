package com.test.automation.uiActions;

import com.test.automation.testBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class AddToCart extends TestBase {

    public final static Logger log = Logger.getLogger(AddToCart.class.getName());
    WebDriver driver;

    @FindBy(xpath="//button[@class='btn btn-default btn-facebook']")
    WebElement facebookLink;

    @FindBy(xpath="//button[@class='btn btn-default btn-twitter']")
    WebElement twitterLink;

    @FindBy(xpath="//button[@class='btn btn-default btn-google-plus']']")
    WebElement googlepluslink;

    @FindBy(xpath="//button[@class='btn btn-default btn-pinterest']")
    WebElement pinterestLink;

    @FindBy(xpath = "//p[@id='add_to_cart']")
    WebElement addtoCart;

    @FindBy(xpath="//h2[@id='homelink']")
    WebElement facebookLogo;

    public AddToCart(WebDriver driver){
        this.driver = this.driver;
        PageFactory.initElements(this.driver,this);

    }
    public void clickOnFacebookLink(){
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        facebookLink.click();
        log.info("Clicked on facebook link and object is :" +facebookLink.toString());

    }
    public void twitterLink(){
        twitterLink.click();
        log.info("Clicked on twitter link and object is :" +twitterLink.toString());

    }

    public boolean verifyFacebookLogo(){
        try{
            facebookLogo.isDisplayed();
            return true;
        }catch (Exception e) {
            return false;

        }
    }



}
