package com.endtoend.automation.pages;

import com.endtoend.automation.config.ElementLocator;
import com.endtoend.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private final WaitUtils waitUtils;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.waitUtils = new WaitUtils(driver,10);
//        PageFactory.initElements(driver,this);
    }


    private final By loginButton = By.xpath(ElementLocator.getLocator("login.loginButton"));
    private final By emailField = By.xpath(ElementLocator.getLocator("login.emailField"));

    public void clickLoginButton() {
        navigateTo("https://www.amazon.com");
        WebElement element = findTheElement(loginButton);
        waitUtils.waitForElementVisible(element);
        clickElement(element);
    }

    public void enterEmail(){
//        WebElement element = driver.findElement(emailField);
//        waitUtils.waitForElementVisible(element);
//        element.click();
        waitForVisibleAndClickAndEnterText(waitUtils, emailField,"raghu.kulgeri@gmail.com");

    }

    public boolean isEmailFieldDisplayed(){
      return findTheElement(emailField).isDisplayed();
    }
}
