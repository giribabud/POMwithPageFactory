package com.test.automation.testBase;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.customListener.WebEventListener;
import com.test.automation.excelReader.Excel_Reader;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.Reporter;
//import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static final Logger log  = Logger.getLogger(TestBase.class.getName());
    Excel_Reader excel;

    public WebDriver dr;
    String url = "http://automationpractice.com/index.php";
    String browser = "chrome";
    public EventFiringWebDriver driver;
    public WebEventListener eventListener;
    public static ExtentReports extent;
    public static ExtentTest test;



    public EventFiringWebDriver getDriver(){
        return driver;
    }
    static{
        Calendar calender = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_mm_yyyy_hh:mm:ss");
        extent = new ExtentReports(System.getProperty("user.dir")+ "/src/main/java/com/test/automation/reports/test"+formater.format(calender.getTime())+".html",false);

    }

    public void setDriver(EventFiringWebDriver driver){
        this.driver=driver;

    }

    public void init(){
        //loadData();

        selectBrowser(browser);
        getUrl(url);
        String log4jConfPath = "log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
    }

    public void selectBrowser(String browser){
        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
            log.info("create object" +browser);
            dr = new ChromeDriver();
            driver = new EventFiringWebDriver(dr);
            eventListener = new WebEventListener();
            driver.register(eventListener);

        }
    }

    public void getUrl(String url){
        log.info("navigating to" +url);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }
    public String[][] getData(String sheetName, String excelName){
        //String excelName;
        String path = System.getProperty("user.dir")+"/src/main/java/com/test/automation/data/" +excelName;
        excel = new Excel_Reader(path);
        String[][] data= excel.getDataFromSheet(sheetName, excelName);
        return data;

    }
    public void waitForElement(int timeOutInSeconds, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }



    public Iterator<String> getAllWindows(){
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> itr = windows.iterator();
        return itr;
    }
    /*public void getScreenShot(String folderName){
        Calendar calender = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_mm_yyyy_hh:mm:ss");

        String methodName = result.getName();

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try{
            String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/test/automation/screenshot/";
           File destFile = new File((String)reportDirectory + "/" +folderName +"/" +methodName+ "_" + formater.format(calender.getTime())+".png");
            FileUtils.copyFile(scrFile, destFile);
            //this will helps to link screenshot to testNG reporrt
            Reporter.log("<a.href='" +destFile.getAbsolutePath()+"'> <img src='" +destFile.getAbsolutePath()+ "'height='100' width='100'/></a>");
        }catch (IOException e){
            e.printStackTrace();
        }
    }*/



    public String captureScreen(String fileName) {
        if (fileName == ""){
            fileName = "blank";

        }
        File destFile = null;
        Calendar calender = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_mm_yyyy_hh:mm:ss");

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try{
            String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/test/automation/screenshot/";
            destFile = new File((String)reportDirectory + fileName + "_" + formater.format(calender.getTime())+".png");
            FileUtils.copyFile(scrFile, destFile);
            //this will helps to link screenshot to testNG reporrt
            Reporter.log("<a.href='" +destFile.getAbsolutePath()+"'> <img src='" +destFile.getAbsolutePath()+ "'height='100' width='100'/></a>");
        }catch (IOException e){
            e.printStackTrace();
        }
        return destFile.toString();
    }

    public void getResult(ITestResult result){
        if(result.getStatus()==ITestResult.SUCCESS ) {
            test.log(LogStatus.PASS, result.getName() + "test is pass");
        }else if(result.getStatus()==ITestResult.SKIP) {
            test.log(LogStatus.SKIP, result.getName() + " test is skipped and skip test is :-" + result.getThrowable());
        }else if (result.getStatus()==ITestResult.FAILURE) {
            test.log(LogStatus.ERROR, result.getName() + "Test is failed " + result.getThrowable());
            String screen = captureScreen("");
            test.log(LogStatus.FAIL, test.addScreenCapture(screen));
        }else if (result.getStatus()==ITestResult.STARTED) {
            test.log(LogStatus.INFO, result.getName() + " Test is Started");
        }
    }
    @AfterMethod()
    public void afterMethod(ITestResult result){
        getResult(result);
    }
    @BeforeMethod()
    public void beforeMethod(Method result){
        test = extent.startTest(result.getName());
        test.log(LogStatus.INFO, result.getName());
    }
    @AfterClass(alwaysRun =true)
    public void endTest(){
        closeBrowser();
    }
    public void closeBrowser(){
        driver.quit();
        log.info("Browser Closed");
        extent.endTest(test);
        extent.flush();
    }

}
