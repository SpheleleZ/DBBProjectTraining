package org.adactin.hotel.pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public WebDriver driver;
    public LoginPage loginPage;
    public SearchHotelPage searchHotelPage;
    public SelectHotelPage selectHotelPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        loginPage = new LoginPage(driver);
        return loginPage;
    }

    public SearchHotelPage getSearchHotelPage() {
        searchHotelPage = new SearchHotelPage(driver);
        return searchHotelPage;
    }

    public SelectHotelPage getSelectHotelPage() {
        selectHotelPage = new SelectHotelPage(driver);
        return selectHotelPage;
    }
}
