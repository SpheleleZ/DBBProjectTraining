package org.adactin.hotel.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.adactin.hotel.stepDefinitions","org.adactin.hotel.hooks"},
        monochrome = true,
        dryRun = false,
        tags = "@SearchHotel",
        plugin = {"pretty",
                "rerun:target/FailedScenarios/failed_scenarios.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        })
public class JUnitTestRunner {
}
