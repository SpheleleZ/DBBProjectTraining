package org.adactin.hotel.stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;

import org.adactin.hotel.pages.LoginPage;
import org.adactin.hotel.pages.SearchHotelPage;
import org.adactin.hotel.utils.TestContextSetUp;

import static org.junit.jupiter.api.Assertions.*;

public class LoginSteps {

    TestContextSetUp contextSetUp;

    LoginPage loginPage;

    SearchHotelPage searchHotelPage;

    public LoginSteps(TestContextSetUp contextSetUp) {
        this.contextSetUp = contextSetUp;
        this.loginPage = contextSetUp.pageObjectManager.getLoginPage();
        this.searchHotelPage = contextSetUp.pageObjectManager.getSearchHotelPage();
    }

    @Given("User is on Adactin Hotel login page build two")
    public void user_is_on_adactin_hotel_login_page_build_two() throws Throwable {
        assertTrue(loginPage.verifyLoginPageIsOpen()
                        .contains("/HotelAppBuild2/")
                , "Login page build two is not open");
    }

    @And("Verify login page build two is open")
    public void verify_login_page_build_two_is_open() throws Throwable {
        assertTrue(loginPage.verifyLoginPageIsOpen()
                        .contains("/HotelAppBuild2/")
                , "Login page build two is not open");
    }

    @When("^User enters valid username (.*)$")
    public void user_enters_valid_username_(String username) throws Throwable {
        loginPage.setUsernameInputField(username);
    }

    @When("^User enters invalid username (.*)$")
    public void user_enters_invalid_username_(String username) throws Throwable {
        loginPage.setUsernameInputField(username);
    }

    @And("^Enters valid password (.*)$")
    public void enters_valid_password_(String password) throws Throwable {
        loginPage.setPasswordInputField(password);
    }

    @And("^Enters invalid password (.*)")
    public void enters_invalid_password_(String password) throws Throwable {
        loginPage.setPasswordInputField(password);
    }

    @And("Click on login button")
    public void click_on_login_button() throws Throwable {
        searchHotelPage = loginPage.setLoginButton();
    }

    @Then("user should be take to search Hotel page")
    public void user_should_be_take_to_search_hotel_page() throws Throwable {
        assertTrue(searchHotelPage.verifySearchHotelPageIsOpen()
                        .contains("SearchHotel.php")
                , "Search Hotel page is not open");
    }

    @Then("User should get a proper warning message")
    public void user_should_get_a_proper_warning_message() throws Throwable {
        assertTrue(loginPage.verifyUserGetWarningMessage()
                        .contains("Invalid Login details or Your Password might have expired")
                , "Login message not correct");
    }
}
