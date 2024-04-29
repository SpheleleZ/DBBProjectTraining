package org.adactin.hotel.pages;

import org.adactin.hotel.utils.SelectMethod;
import org.adactin.hotel.utils.WaitMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    protected WebDriver driver;

    WaitMethod wait;

    SelectMethod select;

    @FindBy(id = "username")
    @CacheLookup
    WebElement usernameInputField;

    @FindBy(id = "password")
    @CacheLookup
    WebElement passwordInputField;

    @FindBy(id = "login")
    @CacheLookup
    WebElement loginButton;

    @FindBy(xpath = "//b[text()=\"Invalid Login details or Your Password might have expired. \"]")
    @CacheLookup
    WebElement verifyUnsuccessfulLogin;

    @FindBy(id = "username_span")
    @CacheLookup
    WebElement verifyEmptyUsername;

    @FindBy(id = "password_span")
    @CacheLookup
    WebElement verifyEmptyPassword;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitMethod(driver);
        select = new SelectMethod(driver);
        PageFactory.initElements(driver, this);
    }

    public void setUsernameInputField(String username) {
        try {
            wait.waitForElementToDisplay(usernameInputField, 20);
            usernameInputField.clear();
            usernameInputField.sendKeys(username);
        } catch (Exception exception) {
            exception.getStackTrace();
        }

    }

    public void setPasswordInputField(String password) {
        try {
            wait.waitForElementToDisplay(passwordInputField, 20);
            passwordInputField.clear();
            passwordInputField.sendKeys(password);
        } catch (Exception exception) {
            exception.getStackTrace();
        }
    }

    public SearchHotelPage setLoginButton() {
        try {
            wait.waitForElementToDisplay(loginButton, 20);
            loginButton.click();
        } catch (Exception exception) {
            exception.getStackTrace();
        }
        return new SearchHotelPage(driver);
    }

    public String verifyUserGetWarningMessage() {
        try {
            wait.waitForElementToDisplay(verifyUnsuccessfulLogin, 20);
        } catch (Exception exception) {
            exception.getStackTrace();
        }
        return verifyUnsuccessfulLogin.getText().trim();
    }

    public String verifyLoginPageIsOpen() {
        try {
            wait.waitForUrlToBe(driver.getCurrentUrl(), 20);
        } catch (Exception exception) {
            exception.getStackTrace();
        }
        return driver.getCurrentUrl();
    }

    public String setVerifyEmptyUsername() {
        try {
            wait.waitForElementToDisplay(verifyEmptyUsername, 20);
        } catch (Exception exception) {
            exception.getStackTrace();
        }
        return verifyEmptyUsername.getText().trim();
    }

    public String setVerifyEmptyPassword() {
        try {
            wait.waitForElementToDisplay(verifyEmptyPassword, 20);
        } catch (Exception exception) {
            exception.getStackTrace();
        }
        return verifyEmptyPassword.getText().trim();
    }

    public SearchHotelPage loginToAdactinHotel(String username, String password) {
        try {
            wait.waitForElementToDisplay(usernameInputField, 20);
            usernameInputField.clear();
            usernameInputField.sendKeys(username);

            wait.waitForElementToDisplay(passwordInputField, 20);
            passwordInputField.clear();
            passwordInputField.sendKeys(password);

            wait.waitForElementToDisplay(loginButton, 20);
            loginButton.click();

        } catch (Exception exception) {
            exception.getStackTrace();
        }
        return new SearchHotelPage(driver);
    }
}
