package org.adactin.hotel.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.adactin.hotel.utils.TestContextSetUp;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class Hooks {

    TestContextSetUp testContextSetUp;

    public Hooks(TestContextSetUp testContextSetUp) {
        this.testContextSetUp = testContextSetUp;
    }

    @Before
    public void beforeScenario() {
        System.out.println("Launching Adactin Hotel Application .........");
    }

    @AfterStep
    public void takeScreenshot(Scenario scenario) throws IOException {
        WebDriver driver = testContextSetUp.baseTest.webDriverManager();
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
    }

    @After
    public void afterScenario() throws IOException {
        WebDriver driver = testContextSetUp.baseTest.webDriverManager();
        if (driver == null) {
            return;
        }
        driver.quit();
        driver = null;
        System.out.println("Closing the browser............");
    }
}
