package org.adactin.hotel.pages;

import org.adactin.hotel.utils.WaitMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage {

    protected WebDriver driver;
    WaitMethod wait;

    @FindBy(id = "hotel_name_0")
    @CacheLookup
    WebElement hotelName;

    public SelectHotelPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitMethod(driver);
        PageFactory.initElements(driver, this);
    }

    public String verifySearchedHotelIsDisplaying() {
        wait.waitForElementToDisplay(hotelName, 20);
        return hotelName.getAttribute("value");
    }
}
