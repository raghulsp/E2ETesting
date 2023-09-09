package com.endtoend.automation.utils;

import com.endtoend.automation.acceptanceTests.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils extends Hooks {


    private final WebDriverWait wait;

    public WaitUtils(WebDriver driver, long timeOutInSeconds) {
        Hooks.driver = driver;
        this.wait = new WebDriverWait(driver, timeOutInSeconds);

    }

    public void waitForElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
