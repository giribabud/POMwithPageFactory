package com.test.automation.uiActions;


import com.test.automation.testBase.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends TestBase {

    public final String tops = "Tops";
    public final String dresses = "Dresses";



    public static final Logger log  = Logger.getLogger(HomePage.class.getName());
    WebDriver driver;

    @FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")
    WebElement signIn;

    @FindBy(xpath = ".//*[@id='email']")
    WebElement loginEmailAdress;

    @FindBy(xpath = ".//*[@id='passwd']")
    WebElement loginPassword;

    @FindBy(id= "SubmitLogin")
    WebElement submitButton;

    @FindBy(xpath = ".//*[@id='center_column']/div[1]/ol/li")
    WebElement authenticationFailed;

    @FindBy(id = "email_create")
            WebElement emailId;
    @FindBy(id = "SubmitCreate")
    WebElement submitCreate;
    @FindBy(id = "id_gender1")
    WebElement idGender;
    @FindBy(id = "customer_firstname")
    WebElement firstName;
    @FindBy(id = "customer_lastname")
    WebElement lastName;

    @FindBy(id = "passwd")
    WebElement password;
    @FindBy(id = "company")
    WebElement company;
    @FindBy(id = "address1")
    WebElement address1;
    @FindBy(id = "city")
    WebElement city;

    @FindBy(xpath = "//div[@id='uniform-id_state']")
    WebElement stdropdown;

   // @FindBy(xpath = "//select[@id='id_state']]")
    //WebElement stdroplist;

    @FindBy(id = "postcode")
    WebElement postCode;

    @FindBy(id = "phone_mobile")
    WebElement phoneMobile;

    @FindBy(id = "alias")
    WebElement alias;

    @FindBy(id = "submitAccount")
    WebElement submitAccount;

    @FindBy(xpath="//div[@class ='header_user_info']/div[1]/span")
    WebElement registermsg;

    @FindBy(xpath="//div[@class='header_user_info'][2]/a[@class='logout']")
    WebElement logOut;


    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public void loginToApplication(String emailAddress, String password){
        signIn.click();
        log.info("Clicking on SignIn object and object is " +signIn.toString());
        loginEmailAdress.sendKeys(emailAddress);
        log.info("Enetred Email adress and object is " +loginEmailAdress.toString());
        loginPassword.sendKeys(password);
        log.info("Enetred Password and object is " +loginPassword.toString());
        submitButton.click();
        log.info("Clicked on Submit and object is " +submitButton.toString());
    }

    public String getInvalidLoginText(){
        log.info("Error message is" +authenticationFailed.getText());
        return authenticationFailed.getText();
    }

    public void registerUser(String emailId, String firstName, String lastName, String password, String company, String address1, String city, String state, String postCode, String phoneMobile,  String alias){
        this.signIn.click();
        log.info("Clicking SignIn Button and object is:" +signIn.toString());
        this.emailId.sendKeys(emailId);
        log.info("entering the email id and object is :" +emailId.toString() );
        this.submitCreate.click();
        log.info("Clicking on submitCreate and object is : " +submitCreate.toString());
        this.idGender.click();
        log.info("Selected Geneder and object is :" +idGender.toString());
        this.firstName.sendKeys(firstName);
        log.info("Entering the firstname and object is :" +firstName.toString());
        this.lastName.sendKeys(lastName);
        log.info("ENtering the last name and object is :" +lastName.toString());
        this.password.sendKeys(password);
        log.info("Enteing the password and object is :" +password.toString());
       // driver.findElement(By.name("firstname")).sendKeys("g");
        //driver.findElement(By.name("lastname")).sendKeys("babu");
        this.company.sendKeys(company);
        log.info("ENtering the company name and object is :" +company.toString());
       this.address1.sendKeys(address1);
       log.info("Entering the Address1 and object is :" +address1.toString());
        this.city.sendKeys(city);
        log.info("Entering the City and Object is :" +city.toString());

        //WebElement divClick = driver.findElement(By.xpath("//div[@id='uniform-id_state']"));
        stdropdown.click();

        WebElement dropdown = driver.findElement(By.xpath("//select[@id='id_state']"));
        Select select = new Select(dropdown);
       select.selectByVisibleText(state);
       log.info("Selceting the state and object is :" +dropdown.toString());
        //Select selectByValue = new Select(driver.findElement(By.id("uniform-id_state")));
        //selectByValue .selectByValue("Alabama");
       this.postCode.sendKeys(postCode);
       log.info("entering the postal code and object is :" +postCode.toString());
       this.phoneMobile.sendKeys(phoneMobile);
       log.info("ENtering the phone mobile and object is :" +phoneMobile.toString());
        this.alias.sendKeys(alias);
        log.info("Entering the alias and object is :" +alias.toString());
        submitAccount.click();
    }
    public String getRegistrationSuccess(){
        log.info("Verify user registration msg:" +registermsg.toString());
        return registermsg.getText();

    }
    public boolean verifyLogoutDisplayed(){
        try{
            //waitForElement(400,logOut);
            logOut.isDisplayed();
            log.info("logout button is displayed and object is" +logOut.toString());
            return true;
            }catch (Exception e){
            return false;
        }
    }
    public void clickOnLogout(){
       // waitForElement(400,logOut);
        logOut.click();
        log.info("Clicked on Logout button and object is "+logOut.toString());
    }
    public void clickOnNavigationMenu(){
        driver.findElement(By.xpath("//li/child::a[@title='Women']")).click();
        log.info("Clicked on the Womens Navigation Button and object is Womens");
    }

    public void clickOnsubcatTops(String subcategory){
        driver.findElement(By.xpath("//div[@class='subcategory-image']/child::a[@title='"+subcategory+"']")).click();

    }
    public void clickOnsubcatDresses(String subcategory){
        driver.findElement(By.xpath("//div[@class='subcategory-image']/child::a[@title='"+subcategory+"']")).click();

    }
}
