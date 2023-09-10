package com.endtoend.automation.stepDefs;

import com.endtoend.automation.acceptanceTests.Hooks;
import com.endtoend.automation.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;


public class LoginTest {


    private LoginPage loginPage;
    private WebDriver driver = Hooks.getDriver();

    @Given("^Amazon site is launched and sign in link is clicked$")
    public void login(){
        if (loginPage==null){
            loginPage = new LoginPage(driver);
        }
//        driver.get("https://www.amazon.in/");
        loginPage.clickLoginButton();
    }

    @And("registered email is entered")
    public void registeredEmailIsEntered() {
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
