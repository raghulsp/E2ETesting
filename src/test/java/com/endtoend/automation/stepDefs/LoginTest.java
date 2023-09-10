package com.endtoend.automation.stepDefs;

import com.endtoend.automation.acceptanceTests.Hooks;
import com.endtoend.automation.pages.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class LoginTest {


    private static final Logger logger = LogManager.getLogger(LoginTest.class);
    private LoginPage loginPage;
    private WebDriver driver = Hooks.getDriver();

    @Given("^Amazon site is launched and sign in link is clicked$")
    public void login(){
        if (loginPage==null){
            loginPage = new LoginPage(driver);
        }
        logger.info("Launching Amazon");
//        driver.get("https://www.amazon.in/");
        logger.info("Clicking login button");
        loginPage.clickLoginButton();
    }

    @And("registered email is entered")
    public void registeredEmailIsEntered() {
        logger.info("Entering registered email");
        loginPage.enterEmail();
    }

    @Given("another scenario")
    public void anotherScenario() {
        System.out.println("Executing another senario");
    }

    @And("continue button is clicked")
    public void continueButtonIsClicked() {

    }
}
