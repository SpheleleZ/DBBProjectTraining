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

    @FindBy(id = "location_span")
    @CacheLookup
    WebElement verifyLocationMessage;

    @FindBy(id = "checkin_span")
    @CacheLookup
    WebElement verifyCheckInDateMessage;

    @FindBy(id = "checkin_span")
    @CacheLookup
    WebElement verifyCheckInDateFormat;

    @FindBy(id = "checkout_span")
    @CacheLookup
    WebElement verifyCheckOutDateMessage;

    public SearchHotelPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitMethod(driver);
        select = new SelectMethod(driver);
        PageFactory.initElements(driver, this);
    }

    public void setLocation(String _location) {
        try {
            wait.waitForElementToDisplay(location, 20);
            select.selectElementByValue(location, _location);
        } catch (Exception exception) {
            exception.fillInStackTrace();
        }
    }

    public void setHotelType(String _hotelType) {
        try {
            wait.waitForElementToDisplay(hotelType, 20);
            select.selectElementByValue(hotelType, _hotelType);
        } catch (Exception exception) {
            exception.fillInStackTrace();
        }
    }

    public void setRoomType(String _roomType) {
        try {
            wait.waitForElementToDisplay(roomType, 20);
            select.selectElementByValue(roomType, _roomType);
        } catch (Exception exception) {
            exception.fillInStackTrace();
        }
    }

    public void setNumberOfRooms(String _numberOfRooms) {
        try {
            wait.waitForElementToDisplay(numberOfRooms, 20);
            select.selectElementByValue(numberOfRooms, _numberOfRooms);
        } catch (Exception exception) {
            exception.fillInStackTrace();
        }
    }

    public void setCheckInDate(String _checkInDate) {
        try {
            wait.waitForElementToDisplay(checkInDate, 20);
            checkInDate.clear();
            checkInDate.sendKeys(_checkInDate);
        } catch (Exception exception) {
            exception.fillInStackTrace();
        }
    }

    public void setCheckOutDate(String _checkOutDate) {
        try {
            wait.waitForElementToDisplay(checkOutDate, 20);
            checkOutDate.clear();
            checkOutDate.sendKeys(_checkOutDate);
        } catch (Exception exception) {
            exception.fillInStackTrace();
        }
    }

    public void setAdultsPerRoom(String _adultPerRoom) {
        try {
            wait.waitForElementToDisplay(adultPerRoom, 20);
            select.selectElementByValue(adultPerRoom, _adultPerRoom);
        } catch (Exception exception) {
            exception.fillInStackTrace();
        }
    }

    public void setChildrenPerRoom(String _childrenPerRoom) {
        try {
            wait.waitForElementToDisplay(childrenPerRoom, 20);
            select.selectElementByValue(childrenPerRoom, _childrenPerRoom);
        } catch (Exception exception) {
            exception.fillInStackTrace();
        }
    }

    public SelectHotelPage setSearchButton() {
        try {
            wait.waitForElementToDisplay(searchButton, 20);
            searchButton.click();
        } catch (Exception exception) {
            exception.fillInStackTrace();
        }
        return new SelectHotelPage(driver);
    }

    public String verifySearchHotelPageIsOpen() {
        try {
            wait.waitForUrlToBe(driver.getCurrentUrl(), 20);
        } catch (Exception exception) {
            exception.fillInStackTrace();
        }
        return driver.getCurrentUrl();
    }

    public String setVerifyLocationMessage() {
        try {
            wait.waitForElementToDisplay(verifyLocationMessage, 20);
        } catch (Exception exception) {
            exception.fillInStackTrace();
        }
        return verifyLocationMessage.getText().trim();
    }

    public String setVerifyCheckInDateMessage() {
        try {
            wait.waitForElementToDisplay(verifyCheckInDateMessage, 20);
        } catch (Exception exception) {
            exception.fillInStackTrace();
        }
        return verifyCheckInDateMessage.getText().trim();
    }

    public String setVerifyCheckInDateFormat() {
        try {
            wait.waitForElementToDisplay(verifyCheckInDateFormat, 20);
        } catch (Exception exception) {
            exception.fillInStackTrace();
        }
        return verifyCheckInDateFormat.getText().trim();
    }

    public String setVerifyCheckOutDateMessage() {
        try {
            wait.waitForElementToDisplay(verifyCheckOutDateMessage, 20);
        } catch (Exception exception) {
            exception.fillInStackTrace();
        }
        return verifyCheckOutDateMessage.getText().trim();
    }
}
