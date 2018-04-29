package com.test.automation.customListener;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

import java.util.logging.Logger;

public class WebEventListener implements WebDriverEventListener{
    public static final Logger log = Logger.getLogger(WebEventListener.class.getName());
    public void beforeAlertAccept(WebDriver driver) {

    }

    public void afterAlertAccept(WebDriver driver) {

    }

    public void afterAlertDismiss(WebDriver driver) {

    }

    public void beforeAlertDismiss(WebDriver driver) {

    }

    public void beforeNavigateTo(String url, WebDriver driver) {

    }

    public void afterNavigateTo(String url, WebDriver driver) {

    }

    public void beforeNavigateBack(WebDriver driver) {

    }

    public void afterNavigateBack(WebDriver driver) {

    }

    public void beforeNavigateForward(WebDriver driver) {

    }

    public void afterNavigateForward(WebDriver driver) {

    }

    public void beforeNavigateRefresh(WebDriver driver) {

    }

    public void afterNavigateRefresh(WebDriver driver) {

    }

    public void beforeFindBy(By by, WebElement element, WebDriver driver) {

    }

    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        log("Found Element By " + by.toString());

    }

    public void beforeClickOn(WebElement element, WebDriver driver) {

    }

    public void afterClickOn(WebElement element, WebDriver driver) {

    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    public void beforeScript(String script, WebDriver driver) {

    }

    public void afterScript(String script, WebDriver driver) {

    }

    public void beforeSwitchToWindow(String windowName, WebDriver driver) {

    }

    public void afterSwitchToWindow(String windowName, WebDriver driver) {

    }

    public void onException(Throwable throwable, WebDriver driver) {

    }
    public void log(String data){
        log.info(data);
        Reporter.log(data);
    }
}
