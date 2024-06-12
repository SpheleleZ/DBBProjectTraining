package org.adactin.hotel.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.adactin.hotel.pages.RegistrationPage;
import org.adactin.hotel.utils.TestContextSetUp;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class RegistrationSteps {

    TestContextSetUp contextSetUp;

    RegistrationPage registrationPage;

    public RegistrationSteps(TestContextSetUp contextSetUp) throws Throwable {
        this.contextSetUp = contextSetUp;
        this.registrationPage = contextSetUp.pageObjectManager.getRegistrationPage();
    }

    @And("Click on New User Register Here link")
    public void click_on_new_user_register_here_link() throws Throwable {
        registrationPage.setNewUserRegisterLink();
    }

    @Then("Verify registration page is open")
    public void verify_registration_page_is_open() throws Throwable {
        assertTrue(registrationPage.verifyRegistrationPageOpen()
                .contains("Register.php"));
    }

    @When("User enters registration details")
    public void user_enters_registration_details(DataTable registrationDetails) throws Throwable {
        //Map
        List<Map<String, String>> data = registrationDetails.asMaps(String.class, String.class);

        registrationPage.setUsernameInputField(data.get(0).get("Username"));
        registrationPage.setPasswordInputField(data.get(0).get("Password"));
        registrationPage.setConfirmPasswordInputField(data.get(0).get("ConfirmPassword"));
        registrationPage.setFullNameInputField(data.get(0).get("FullName"));
        registrationPage.setEmailAddressInputField(data.get(0).get("EmailAddress"));
    }

    @And("Fill captcha text")
    public void fill_captcha_text() throws Throwable {
        registrationPage.setCaptchaImageAndText();
    }

    @And("Click on Terms and Conditions")
    public void click_on_terms_and_conditions() throws Throwable {
        registrationPage.setTermsAndConditions();
    }

    @Then("Click on register button")
    public void click_on_register_button() throws Throwable {
        registrationPage.setRegisterButton();
    }

    @And("A page stating an email verification code has been sent to your email address should display")
    public void a_page_stating_an_email_verification_code_has_been_sent_to_your_email_address_should_display()
            throws Throwable {
        assertTrue(registrationPage.setVerifyRegistration()
                .contains("An email verification code has been sent to your email"));
    }
}
