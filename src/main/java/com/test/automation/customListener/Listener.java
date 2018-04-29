package com.test.automation.customListener;

import com.test.automation.testBase.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Listener extends TestBase implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult iTestResult) {

    }

    public void onTestFailure(ITestResult result) {
        Calendar calender = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");

        String methodName = result.getName();

        if (!result.isSuccess()) {

            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            try {
                String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/test/automation/";
                File destFile = new File((String) reportDirectory + "/failure_screenshots/" + methodName + "_" + formater.format(calender.getTime()) + ".png");
                FileUtils.copyFile(scrFile, destFile);
                //this will helps to link screenshot to testNG reporrt
                Reporter.log("<a.href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "'height='100' width='100'/></a>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
