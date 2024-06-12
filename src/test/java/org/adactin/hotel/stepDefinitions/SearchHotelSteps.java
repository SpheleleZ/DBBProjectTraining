package org.adactin.hotel.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.adactin.hotel.pages.LoginPage;
import org.adactin.hotel.pages.SearchHotelPage;
import org.adactin.hotel.pages.SelectHotelPage;
import org.adactin.hotel.utils.ExcelReader;
import org.adactin.hotel.utils.TestContextSetUp;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SearchHotelSteps {

    TestContextSetUp testContextSetUp;

    SearchHotelPage searchHotelPage;

    SelectHotelPage selectHotelPage;

    LoginPage loginPage;

    ExcelReader reader;

    public SearchHotelSteps(TestContextSetUp testContextSetUp) {
        this.testContextSetUp = testContextSetUp;
        this.searchHotelPage = testContextSetUp.pageObjectManager.getSearchHotelPage();
        this.selectHotelPage = testContextSetUp.pageObjectManager.getSelectHotelPage();
        this.loginPage = testContextSetUp.pageObjectManager.getLoginPage();
        this.reader = new ExcelReader();
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

    /**************************************************************************
     * this method fills Hotel details reading from Excel sheet
     * it uses the class ExcelReader
     */
    @When("user fills Hotel form from given sheetName {string} and rowNumber {int}")
    public void user_fills_hotel_form_from_given_sheet_name_and_row_number(String sheetName, Integer rowNumber)
            throws IOException {
        List<Map<String, String>> testData = reader.getData("src/test/resources/TestData.xlsx", sheetName);

        //getting Data from excel sheet
        String location = testData.get(rowNumber).get("Location");
        String Hotels = testData.get(rowNumber).get("Hotels");
        String RoomType = testData.get(rowNumber).get("RoomType");
        String NumberOfRooms = testData.get(rowNumber).get("NumberOfRooms");
        String CheckInDate = testData.get(rowNumber).get("CheckInDate");
        String CheckOutDate = testData.get(rowNumber).get("CheckOutDate");
        String AdultsPerRooms = testData.get(rowNumber).get("AdultsPerRooms");
        String ChildrenPerRoom = testData.get(rowNumber).get("ChildrenPerRoom");

        // setting all the Data
        searchHotelPage.setLocation(location);
        searchHotelPage.setHotelType(Hotels);
        searchHotelPage.setRoomType(RoomType);
        searchHotelPage.setNumberOfRooms(NumberOfRooms);
        searchHotelPage.setCheckInDate(CheckInDate);
        searchHotelPage.setCheckOutDate(CheckOutDate);
        searchHotelPage.setAdultsPerRoom(AdultsPerRooms);
        searchHotelPage.setChildrenPerRoom(ChildrenPerRoom);
    }

    @And("Chick on search button")
    public void chick_on_search_button() {
        selectHotelPage = searchHotelPage.setSearchButton();
    }

    @Then("Hotel with a name {string} should display in the list of hotels")
    public void hotel_with_a_name_should_display_in_the_list_of_hotels(String hotelName) throws Throwable {
        assertTrue(selectHotelPage.verifySearchedHotelIsDisplaying()
                        .contains(hotelName)
                , "Searched Hotel is not displaying");
    }

    @Then("Message saying Please select a location should display")
    public void message_saying_please_select_a_location_should_display() throws Throwable {
        assertTrue(searchHotelPage.setVerifyLocationMessage()
                        .contains("Please Select a Location")
                , "Location message did not display");
    }

    @Then("Hotels with all Hotel types names {string} and {string} and {string} and {string} should display in the list of hotels")
    public void hotels_with_all_Hotel_type_names_and_and_and_should_display_in_the_list_of_hotels(
            String hotelCornice, String hotelCreek, String hotelHervey, String hotelSunshine) throws Throwable {
        assertTrue(selectHotelPage.setHotelCornice().contains(hotelCornice)
                , "Hotel Cornice did not display");
        assertTrue(selectHotelPage.setHotelCreek().contains(hotelCreek)
                , "Hotel Creek did not display");
        assertTrue(selectHotelPage.setHotelHervey().contains(hotelHervey)
                , "Hotel Hervey did not display");
        assertTrue(selectHotelPage.setHotelSunshine().contains(hotelSunshine)
                , "Hotel Sunshine did not display");
    }

    @Then("Hotels with all room types {string} and {string} and {string} and {string} should display in the list of hotels")
    public void hotels_with_all_room_types_and_and_and_should_display_in_the_list_of_hotels(
            String standard, String _double, String deluxe, String superDeluxe) throws Throwable {
        assertTrue(selectHotelPage.setRoomTypeStandard().contains(standard)
                , "Standard room type did not display");
        assertTrue(selectHotelPage.setRoomTypeDouble().contains(_double)
                , "double room type did not display");
        assertTrue(selectHotelPage.setRoomTypeDeluxe().contains(deluxe)
                , "Deluxe room type did not display");
        assertTrue(selectHotelPage.setRoomTypeSuperDeluxe().contains(superDeluxe)
                , "Super Deluxe room type did not display");
    }

    @Then("Message saying Please Select Check-In-Date should display")
    public void message_saying_please_select_check_in_date_should_display() throws Throwable {
        assertTrue(searchHotelPage.setVerifyCheckInDateMessage()
                        .contains("Please Select Check-In Date")
                , "check-In-Date message did not display");
    }

    @Then("Message saying Check-In-Date should be either Today or later Date should display")
    public void message_saying_check_in_date_should_be_either_today_or_later_date_should_display() throws Throwable {
        assertTrue(searchHotelPage.setVerifyCheckInDateMessage()
                        .contains("Check-In Date should be either Today or Later Date")
                , "check-In-Date message did not display");
    }

    @Then("Message saying Check-In Date shall be before than Check-Out Date should display")
    public void message_saying_check_in_date_shall_be_before_than_check_out_date_should_display() throws Throwable {
        assertTrue(searchHotelPage.setVerifyCheckInDateFormat()
                        .contains("Check-In Date shall be before than Check-Out Date")
                , "Check-In-Date Message does not display");
    }

    @Then("Message saying Check-Out-Date shall be after than Check-In-Date should display")
    public void message_saying_check_out_date_shall_be_after_than_check_in_date_should_display() throws Throwable {
        assertTrue(searchHotelPage.setVerifyCheckOutDateMessage()
                        .contains("Check-Out Date shall be after than Check-In Date")
                , "Check-Out-Date Message does not display");
    }

    @Then("Message saying Please Select Check-Out Date should display")
    public void message_saying_please_select_check_out_date_should_display() {
        assertTrue(searchHotelPage.setVerifyCheckOutDateMessage()
                        .contains("Please Select Check-Out Date")
                , "Check-Out-Date Message does not display");
    }
}
