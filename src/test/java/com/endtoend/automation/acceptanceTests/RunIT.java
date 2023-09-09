package com.endtoend.automation.acceptanceTests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.endtoend.automation.stepDefs", "com.endtoend.automation.acceptanceTests"}
)

public class RunIT {

}
