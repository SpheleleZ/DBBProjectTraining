package org.adactin.hotel.pages;

import org.adactin.hotel.utils.ReadImages;
import org.adactin.hotel.utils.WaitMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    protected WebDriver driver;

    WaitMethod wait;

    ReadImages readImages;

    @FindBy(xpath = "//a[text()=\"New User Register Here\"]")
    @CacheLookup
    WebElement newUserRegisterLink;

    @FindBy(id = "username")
    @CacheLookup
    WebElement usernameInputField;

    @FindBy(id = "password")
    @CacheLookup
    WebElement passwordInputField;

    @FindBy(id = "re_password")
    @CacheLookup
    WebElement confirmPasswordInputField;

    @FindBy(id = "full_name")
    @CacheLookup
    WebElement fullNameInputField;

    @FindBy(id = "email_add")
    @CacheLookup
    WebElement emailAddressInputField;

    @FindBy(id = "captcha")
    @CacheLookup
    WebElement captchaImage;

    @FindBy(id = "captcha-form")
    @CacheLookup
    WebElement captchaTextInputField;

    @FindBy(id = "tnc_box")
    @CacheLookup
    WebElement termsAndConditions;

    @FindBy(id = "Submit")
    @CacheLookup
    WebElement registerButton;

    @FindBy(xpath = "//td[text()=\"An email verification code has been sent to your email address. Please check your email (including your spam folder) and verify your email address.\"]")
    @CacheLookup
    WebElement verifyRegistration;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitMethod(driver);
        readImages = new ReadImages(driver);
        PageFactory.initElements(driver, this);
    }

    public void setNewUserRegisterLink() {
        try {
            wait.waitForElementToDisplay(newUserRegisterLink, 20);
            newUserRegisterLink.click();
        } catch (Exception exception) {
            exception.getStackTrace();
        }
    }

    public void setUsernameInputField(String username) {
        try {
            wait.waitForElementToDisplay(usernameInputField, 20);
            usernameInputField.sendKeys(username);
        } catch (Exception exception) {
            exception.getStackTrace();
        }
    }

    public void setPasswordInputField(String password) {
        try {
            wait.waitForElementToDisplay(passwordInputField, 20);
            passwordInputField.sendKeys(password);
        } catch (Exception exception) {
            exception.getStackTrace();
        }
    }

    public void setConfirmPasswordInputField(String confirmPassword) {
        try {
            wait.waitForElementToDisplay(confirmPasswordInputField, 20);
            confirmPasswordInputField.sendKeys(confirmPassword);
        } catch (Exception exception) {
            exception.getStackTrace();
        }
    }

    public void setFullNameInputField(String fullName) {
        try {
            wait.waitForElementToDisplay(fullNameInputField, 20);
            fullNameInputField.sendKeys(fullName);
        } catch (Exception exception) {
            exception.getStackTrace();
        }
    }

    public void setEmailAddressInputField(String emailAddress) {
        try {
            wait.waitForElementToDisplay(emailAddressInputField, 20);
            emailAddressInputField.sendKeys(emailAddress);
        } catch (Exception exception) {
            exception.getStackTrace();
        }
    }

    public void setCaptchaImageAndText() {
        try {
            wait.waitForElementToDisplay(captchaImage, 20);
            String captchaText = readImages.readImageAndGetText(captchaImage);

            wait.waitForElementToDisplay(captchaTextInputField, 20);
            captchaTextInputField.sendKeys(captchaText);

            Thread.sleep(5000);
        } catch (Exception exception) {
            exception.getStackTrace();
        }
    }

    public void setTermsAndConditions() {
        try {
            wait.waitForElementToDisplay(termsAndConditions, 20);
            termsAndConditions.click();
        } catch (Exception exception) {
            exception.getStackTrace();
        }
    }

    public void setRegisterButton() {
        try {
            wait.waitForElementToDisplay(registerButton, 20);
            registerButton.click();
        } catch (Exception exception) {
            exception.getStackTrace();
        }
    }

    public String setVerifyRegistration() {
        try {
            wait.waitForElementToDisplay(verifyRegistration, 20);
        } catch (Exception exception) {
            exception.getStackTrace();
        }
        return verifyRegistration.getText().trim();
    }

    public String verifyRegistrationPageOpen() {
        try {
            wait.waitForUrlToBe(driver.getCurrentUrl(), 20);
        } catch (Exception exception) {
            exception.getStackTrace();
        }
        return driver.getCurrentUrl().trim();
    }
}
