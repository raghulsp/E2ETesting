package com.endtoend.automation.acceptanceTests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Hooks {

     public static WebDriver driver;


    @Before
    public void setup(){
        System.setProperty("webdriver.edge.driver", "/Users/ragkulag/Downloads/msedgedriver");
        driver = new EdgeDriver();
        System.out.println("WebDriver setup completed.");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        if(driver != null){
            driver.quit();
        }
    }
}
