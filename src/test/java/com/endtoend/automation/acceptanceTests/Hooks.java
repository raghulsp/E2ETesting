package com.endtoend.automation.acceptanceTests;

import com.endtoend.automation.utils.ScreenshotUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Hooks {

    public static WebDriver driver;


    @Before
    public void setup() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
//        System.setProperty("webdriver.edge.driver", "/Users/ragkulag/Downloads/msedgedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("WebDriver setup completed.");
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @After(order = 2)
    public void captureScreenshotOnFailure(Scenario scenario) {

        String formattedDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM HH:mm:ss.SSS"));

        if (scenario.isFailed()) {
            String screenshotPath = "src/test/resources/screenshots/" + scenario.getName() + "-" + formattedDateTime + ".png"; // Define your path and filename
            ScreenshotUtils.captureScreenshot(driver, screenshotPath);
        }
    }

    @After(order = 1)
    public void generateReport() {
        String cucumberOutputPath = "cucumber-reports/cucumber.json";
        String reportOutputPath = "cucumber-reports/cucumber-reports";

        File reportOutputDirectory = new File(reportOutputPath);

        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add(cucumberOutputPath);

        Configuration configuration = new Configuration(reportOutputDirectory, "E2E_Testing");
        configuration.setBuildNumber("1");
        configuration.addClassifications("Platform", "macOS"); // Replace with your actual platform
        configuration.addClassifications("Browser", "Edge");

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }

    @After(order = 0)
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Quitting browser");
    }


}
