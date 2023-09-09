package com.endtoend.automation.stepDefs;

import com.endtoend.automation.acceptanceTests.Hooks;
import com.endtoend.automation.pages.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static com.endtoend.automation.acceptanceTests.Hooks.driver;

public class LoginTest {


    private LoginPage loginPage;

    @Before
    public void setUp(){

        loginPage = new LoginPage(driver);
    }


    @Given("^flipkart site is launched and login button is clicked$")
    public void login(){
        driver.get("https://www.flipkart.com/");
        loginPage.clickLoginButton();
    }
}
