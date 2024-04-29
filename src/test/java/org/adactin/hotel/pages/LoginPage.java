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

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitMethod(driver);
        select = new SelectMethod(driver);
        PageFactory.initElements(driver, this);
    }

    public void setUsernameInputField(String username) {
        wait.waitForElementToDisplay(usernameInputField, 20);
        usernameInputField.clear();
        usernameInputField.sendKeys(username);
    }

    public void setPasswordInputField(String password) {
        wait.waitForElementToDisplay(passwordInputField, 20);
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
    }

    public SearchHotelPage setLoginButton() {
        wait.waitForElementToDisplay(loginButton, 20);
        loginButton.click();
        return new SearchHotelPage(driver);
    }

    public String verifyUserGetWarningMessage() {
        wait.waitForElementToDisplay(verifyUnsuccessfulLogin, 20);
        return verifyUnsuccessfulLogin.getText();
    }

    public String verifyLoginPageIsOpen() {
         wait.waitForUrlToBe(driver.getCurrentUrl(), 20);
         return driver.getCurrentUrl();
    }

    public SearchHotelPage loginToAdactinHotel(String username, String password) {
        wait.waitForElementToDisplay(usernameInputField, 20);
        usernameInputField.clear();
        usernameInputField.sendKeys(username);

        wait.waitForElementToDisplay(passwordInputField, 20);
        passwordInputField.clear();
        passwordInputField.sendKeys(password);

        wait.waitForElementToDisplay(loginButton, 20);
        loginButton.click();

        return new SearchHotelPage(driver);
    }
}
