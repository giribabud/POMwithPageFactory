package com.test.automation.uiActions;

import com.test.automation.testBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.logging.Logger;

public class ProductDetailsPage extends TestBase {
    WebDriver driver;
    public final static Logger log = Logger.getLogger(ProductDetailsPage.class.getName());

    public final String fadedShortSleeve_Tshirts = "Faded Short Sleeve T-shirts";
    public final String blouse = "Blouse";

    @FindBy(xpath ="//h5/child::a")
    List<WebElement> products;

    public ProductDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public void selectProduct(String product){
        driver.findElement(By.xpath("//a[@title ='"+product+"']")).click();

        log.info(product+"has been selected");
    }
    public List<WebElement> selectProduct(){
    List<WebElement> element = products;
    return element;
    }


}
