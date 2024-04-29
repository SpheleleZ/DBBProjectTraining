package org.adactin.hotel.pages;

import org.adactin.hotel.utils.SelectMethod;
import org.adactin.hotel.utils.WaitMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage {

    protected WebDriver driver;

    WaitMethod wait;

    SelectMethod select;

    @FindBy(id = "location")
    @CacheLookup
    WebElement location;

    @FindBy(id = "hotels")
    @CacheLookup
    WebElement hotelType;

    @FindBy(id = "room_type")
    @CacheLookup
    WebElement roomType;

    @FindBy(id = "room_nos")
    @CacheLookup
    WebElement numberOfRooms;

    @FindBy(id = "datepick_in")
    @CacheLookup
    WebElement checkInDate;

    @FindBy(id = "datepick_out")
    @CacheLookup
    WebElement checkOutDate;

    @FindBy(id = "adult_room")
    @CacheLookup
    WebElement adultPerRoom;

    @FindBy(id = "child_room")
    @CacheLookup
    WebElement childrenPerRoom;

    @FindBy(id = "Submit")
    @CacheLookup
    WebElement searchButton;

    public SearchHotelPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitMethod(driver);
        select = new SelectMethod(driver);
        PageFactory.initElements(driver, this);
    }

    public void setLocation(String _location) {
        wait.waitForElementToDisplay(location, 20);
        select.selectElementByValue(location, _location);
    }

    public void setHotelType(String _hotelType) {
        wait.waitForElementToDisplay(hotelType, 20);
        select.selectElementByValue(hotelType, _hotelType);
    }

    public void setRoomType(String _roomType) {
        wait.waitForElementToDisplay(roomType, 20);
        select.selectElementByValue(roomType, _roomType);
    }

    public void setNumberOfRooms(String _numberOfRooms) {
        wait.waitForElementToDisplay(numberOfRooms, 20);
        select.selectElementByValue(numberOfRooms, _numberOfRooms);
    }

    public void setCheckInDate(String _checkInDate) {
        wait.waitForElementToDisplay(checkInDate, 20);
        checkInDate.clear();
        checkInDate.sendKeys(_checkInDate);
    }

    public void setCheckOutDate(String _checkOutDate) {
        wait.waitForElementToDisplay(checkOutDate, 20);
        checkOutDate.clear();
        checkOutDate.sendKeys(_checkOutDate);
    }

    public void setAdultsPerRoom(String _adultPerRoom) {
        wait.waitForElementToDisplay(adultPerRoom, 20);
        select.selectElementByValue(adultPerRoom, _adultPerRoom);
    }

    public void setChildrenPerRoom(String _childrenPerRoom) {
        wait.waitForElementToDisplay(childrenPerRoom, 20);
        select.selectElementByValue(childrenPerRoom, _childrenPerRoom);
    }

    public SelectHotelPage setSearchButton() {
        wait.waitForElementToDisplay(searchButton, 20);
        searchButton.click();
        return new SelectHotelPage(driver);
    }

    public String verifySearchHotelPageIsOpen() {
        wait.waitForUrlToBe(driver.getCurrentUrl(), 20);
        return driver.getCurrentUrl();
    }
}
