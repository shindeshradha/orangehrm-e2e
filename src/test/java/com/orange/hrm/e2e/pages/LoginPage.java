package com.orange.hrm.e2e.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.orange.hrm.e2e.config.WebDriverManager.getDriver;

/**
 * OrangeHRM Login Page Object
 */
@Slf4j
public class LoginPage {

    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[contains(@class, 'oxd-alert-content-text')]")
    private WebElement wrongCredentialsStatusElement;

    private final WebDriverWait wait;

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
    }

    /**
     * Method to enter the username in the login field
     *
     * @param username the username to be entered
     */
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    /**
     * Method to enter the password in the password field
     *
     * @param password the password to be entered
     */
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    /**
     * Method to click the login button
     */
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }


    /**
     * Method to wait for the login page to load
     */
    public void waitForLoginPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
    }

    /**
     * Checks if the "Wrong credentials" message is displayed
     *
     * @return true if the message is visible, false otherwise
     */
    public boolean isWrongCredentialsStatusElementDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(wrongCredentialsStatusElement));
            return true;
        } catch (Exception e) {
            log.error("Wrong credentials status element not displayed: {}", e.getMessage());
            return false;
        }
    }

    public boolean isPasswordFieldSecure() {
        WebElement passwordField = getDriver().findElement(By.name("password"));
        return passwordField.getAttribute("type").equals("password");
    }
}
