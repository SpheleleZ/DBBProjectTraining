package org.adactin.hotel.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.adactin.hotel.pages.LoginPage;
import org.adactin.hotel.pages.SearchHotelPage;
import org.adactin.hotel.pages.SelectHotelPage;
import org.adactin.hotel.utils.TestContextSetUp;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SearchHotelSteps {

    TestContextSetUp testContextSetUp;

    SearchHotelPage searchHotelPage;

    SelectHotelPage selectHotelPage;

    LoginPage loginPage;

    public SearchHotelSteps(TestContextSetUp testContextSetUp) {
        this.testContextSetUp = testContextSetUp;
        this.searchHotelPage = testContextSetUp.pageObjectManager.getSearchHotelPage();
        this.selectHotelPage = testContextSetUp.pageObjectManager.getSelectHotelPage();
        this.loginPage = testContextSetUp.pageObjectManager.getLoginPage();
    }

    @Given("User is on search Hotel page")
    public void user_is_on_search_hotel_page() throws Throwable {
        assertTrue(searchHotelPage.verifySearchHotelPageIsOpen().contains("SearchHotel")
                , "search hotel page not open");
    }

    @And("User is successfully logged in with username {string} and password {string}")
    public void user_is_successfully_logged_in_with_username_and_password(String username, String password) throws Throwable {
        loginPage.loginToAdactinHotel(username, password);
    }

    @When("^user enters Hotel details$")
    public void user_enters_hotel_details(DataTable hotelDetails) throws Throwable {
        //Map
        List<Map<String, String>> data = hotelDetails.asMaps(String.class, String.class);

        searchHotelPage.setLocation(data.get(0).get("location"));
        searchHotelPage.setHotelType(data.get(0).get("hotel"));
        searchHotelPage.setRoomType(data.get(0).get("roomType"));
        searchHotelPage.setNumberOfRooms(data.get(0).get("numberOfRooms"));
        searchHotelPage.setCheckInDate(data.get(0).get("checkInDate"));
        searchHotelPage.setCheckOutDate(data.get(0).get("checkOutDate"));
        searchHotelPage.setAdultsPerRoom(data.get(0).get("adultsPerRoom"));
        searchHotelPage.setChildrenPerRoom(data.get(0).get("childrenPerRoom"));
    }

    @And("Chick on search button")
    public void chick_on_search_button() {
        selectHotelPage = searchHotelPage.setSearchButton();
    }

    @Then("Hotel with a name {string} should display in the list of hotels")
    public void hotel_with_a_name_should_display_in_the_list_of_hotels(String hotelName) throws Throwable {
        assertTrue(selectHotelPage.verifySearchedHotelIsDisplaying().contains(hotelName)
                , "Searched Hotel is not displaying");
    }
}
