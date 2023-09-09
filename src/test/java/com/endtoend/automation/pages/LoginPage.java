package com.endtoend.automation.pages;

import com.endtoend.automation.acceptanceTests.Hooks;
import com.endtoend.automation.config.ElementLocator;
import com.endtoend.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver,10);
//        PageFactory.initElements(driver,this);
    }


    private final By loginButton = By.xpath(ElementLocator.getLocator("login.loginButton"));
    private final By emailField = By.xpath(ElementLocator.getLocator("login.emailField"));

    public void clickLoginButton() {
        WebElement element = driver.findElement(loginButton);
        waitUtils.waitForElementVisible(element);
        element.click();
    }

    public void enterEmail(){
        WebElement element = driver.findElement(emailField);
        waitUtils.waitForElementVisible(element);
        element.click();
        element.sendKeys("raghu.kulgeri@gmail.com");
    }
}
