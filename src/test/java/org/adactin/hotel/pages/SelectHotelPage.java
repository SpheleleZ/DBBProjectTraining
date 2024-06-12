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

    @FindBy(id = "hotel_name_1")
    @CacheLookup
    WebElement hotelCornice;

    @FindBy(id = "hotel_name_2")
    @CacheLookup
    WebElement hotelCreek;

    @FindBy(id = "hotel_name_3")
    @CacheLookup
    WebElement hotelHervey;

    @FindBy(id = "hotel_name_4")
    @CacheLookup
    WebElement hotelSunshine;

    @FindBy(id = "room_type_1")
    @CacheLookup
    WebElement roomTypeStandard;

    @FindBy(id = "room_type_2")
    @CacheLookup
    WebElement roomTypeDouble;

    @FindBy(id = "room_type_3")
    @CacheLookup
    WebElement roomTypeDeluxe;

    @FindBy(id = "room_type_4")
    @CacheLookup
    WebElement roomTypeSuperDeluxe;

    public SelectHotelPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitMethod(driver);
        PageFactory.initElements(driver, this);
    }

    public String verifySearchedHotelIsDisplaying() throws Throwable {
        wait.waitForElementToDisplay(hotelName, 20);
        return hotelName.getAttribute("value");
    }

    public String setHotelCreek() throws Throwable {
        wait.waitForElementToDisplay(hotelCreek, 20);
        return hotelCreek.getAttribute("value");
    }

    public String setHotelHervey() throws Throwable {
        wait.waitForElementToDisplay(hotelHervey, 20);
        return hotelHervey.getAttribute("value");
    }

    public String setHotelSunshine() throws Throwable {
        wait.waitForElementToDisplay(hotelSunshine, 20);
        return hotelSunshine.getAttribute("value");
    }

    public String setHotelCornice() throws Throwable {
        wait.waitForElementToDisplay(hotelCornice, 20);
        return hotelCornice.getAttribute("value");
    }

    public String setRoomTypeStandard() throws Throwable {
        wait.waitForElementToDisplay(roomTypeStandard, 20);
        return roomTypeStandard.getAttribute("value");
    }

    public String setRoomTypeDouble() throws Throwable {
        wait.waitForElementToDisplay(roomTypeDouble, 20);
        return roomTypeDouble.getAttribute("value");
    }

    public String setRoomTypeDeluxe() throws Throwable {
        wait.waitForElementToDisplay(roomTypeDeluxe, 20);
        return roomTypeDeluxe.getAttribute("value");
    }

    public String setRoomTypeSuperDeluxe() throws Throwable {
        wait.waitForElementToDisplay(roomTypeSuperDeluxe, 20);
        return roomTypeSuperDeluxe.getAttribute("value");
    }
}
