package org.adactin.hotel.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public WebDriver driver;

    Properties properties;
    FileInputStream file;

    public WebDriver webDriverManager() throws IOException {

        properties = new Properties();
        file = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/global.properties");
        properties.load(file);
        String url = properties.getProperty("QAUrl");
        String browser = properties.getProperty("browser");

        if (driver == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
                driver.manage().window().maximize();
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
                driver.manage().window().maximize();
            } else if (browser.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
                driver.manage().window().maximize();
            }

            assert driver != null;
            driver.get(url);

        } else {
            return driver;
        }
        return driver;
    }
}
