package com.orange.hrm.e2e.pages;
import lombok.extern.slf4j.Slf4j;
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

    private WebDriverWait wait;

    public PasswordResetPage() {
        PageFactory.initElements(getDriver(), this);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
    }

    public boolean isResetPasswordTitleShown() {
        try {
            wait.until(ExpectedConditions.visibilityOf(usernameInput));
            return true;
        } catch (Exception e) {
            log.error("Reset Password Title not displayed: {}", e.getMessage());
            return false;
        }
    }
    
}
