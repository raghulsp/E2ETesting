package com.endtoend.automation.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    public static void captureScreenshot(WebDriver driver, String screenshotPath) {
        try {
            FileUtils.copyFile((((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE)), new File(screenshotPath));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
