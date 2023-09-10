package com.endtoend.automation.pages;

import com.endtoend.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public WebElement findTheElement(By by) {
        return driver.findElement(by);
    }

    public void waitForVisibleAndClickAndEnterText(WaitUtils utils, By by, String input) {
        WebElement element = findTheElement(by);
        utils.waitForElementVisible(element);
        clickElement(element);
        element.sendKeys(input);
    }


}
