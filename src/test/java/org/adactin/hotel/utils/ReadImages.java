package org.adactin.hotel.utils;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ReadImages {

    WebDriver driver;

    public ReadImages(WebDriver driver) {
        this.driver = driver;
    }

    public String readImageAndGetText(WebElement element) throws TesseractException, IOException {
        File file = element.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/src/test/resources/screenshots/captcha.png";
        FileHandler.copy(file, new File(path));

        ITesseract image = new Tesseract();
        image.setDatapath("tessdata");
        return image.doOCR(new File(path)).trim();
    }
}
