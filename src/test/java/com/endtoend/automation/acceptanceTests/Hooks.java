package com.endtoend.automation.acceptanceTests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Hooks {

     public static WebDriver driver;


    @Before
    public void setup(){
        System.setProperty("webdriver.edge.driver", "/Users/ragkulag/Downloads/msedgedriver");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        System.out.println("WebDriver setup completed.");
    }

    public static WebDriver getDriver(){
        return driver;
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        if(driver != null){
            driver.quit();
        }
        System.out.println("Quitting browser");
    }

    @After
    public void generateReport() {
        String cucumberOutputPath = "target/cucumber.json";
        String reportOutputPath = "target/cucumber-reports";

        File reportOutputDirectory = new File(reportOutputPath);

        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add(cucumberOutputPath);

        Configuration configuration = new Configuration(reportOutputDirectory, "Your Project Name");
        configuration.setBuildNumber("1");
        configuration.addClassifications("Platform", "macOS"); // Replace with your actual platform
        configuration.addClassifications("Browser", "Edge");

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}
