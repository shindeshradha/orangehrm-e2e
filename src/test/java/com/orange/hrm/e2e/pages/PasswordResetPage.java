package com.orange.hrm.e2e.pages;

import io.cucumber.java.en.Given;
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
 * OrangeHRM Password Reset Page Object
 */
@Slf4j
public class PasswordResetPage {

    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(xpath = "//p[contains(@class, 'orangehrm-forgot-password-title')]")
    private WebElement resetPasswordTitle;

    @FindBy(xpath = "//p[contains(@class, 'orangehrm-login-forgot-header')]")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement resetPasswordButton;

    private final WebDriverWait wait;

    public PasswordResetPage() {
        PageFactory.initElements(getDriver(), this);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
    }

    /**
     * Method to click the forgot password link
     */
    public void clickForgotPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink));
        forgotPasswordLink.click();
    }

    /**
     * isResetPasswordTitleShown
     *
     * @return isResetPasswordTitleShown
     */
    public boolean isResetPasswordTitleShown() {
        try {
            wait.until(ExpectedConditions.visibilityOf(usernameInput));
            return true;
        } catch (Exception e) {
            log.error("Reset Password Title not displayed: {}", e.getMessage());
            return false;
        }
    }

    /**
     * Method to enter the username in the username field
     *
     * @param username the username to be entered
     */
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    /**
     * Method to click the reset password button
     */
    public void clickResetPasswordButton() {
        wait.until(ExpectedConditions.elementToBeClickable(resetPasswordButton));
        resetPasswordButton.click();
    }

    /**
     * Dynamically checks if the reset password success message is displayed
     *
     * @return true if the message is visible, false otherwise
     */
    public boolean isResetPasswordSuccessMessageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));

            WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//p[contains(@class, 'oxd-text') and text()='A reset password link has been sent to you via email.']")
            ));

            String actualText = successMessageElement.getText();
            return actualText.equals("A reset password link has been sent to you via email.");
        } catch (Exception e) {
            log.error("Reset password success message not displayed: {}", e.getMessage());
            return false;
        }
    }


}
