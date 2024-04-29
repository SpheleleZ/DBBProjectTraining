package org.adactin.hotel.runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.adactin.hotel.stepDefinitions","org.adactin.hotel.hooks"},
        monochrome = true,
        dryRun = false,
        tags = "@login",
        plugin = {
                "pretty",
                "html:target/reports/index.html"
               // "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        })
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios(){
                return super.scenarios();
        }
}
