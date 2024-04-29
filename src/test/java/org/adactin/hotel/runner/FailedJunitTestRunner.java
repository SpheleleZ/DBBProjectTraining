package org.adactin.hotel.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/FailedScenarios/failed_scenarios.txt",
        glue = {"org.adactin.hotel.stepDefinitions","org.adactin.hotel.hooks"},
        monochrome = true,
        dryRun = false,
        plugin = {"pretty",
                "json:target/JSONReports/Index.json",
                //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        })
public class FailedJunitTestRunner {
}
