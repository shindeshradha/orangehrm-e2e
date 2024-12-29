package com.orange.hrm.e2e.pages;

import static com.orange.hrm.e2e.config.WebDriverManager.getDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lombok.extern.slf4j.Slf4j;

/**
 * OrangeHRM PIM Page Object
 */
@Slf4j
public class PIMPage {

    private final WebDriverWait wait;

    public PIMPage() {
        PageFactory.initElements(getDriver(), this);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
    }

    public boolean isPIMLoaded() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

            WebElement pimHeaderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h6[contains(@class, 'oxd-topbar-header-breadcrumb-module') and text()='PIM']")
            ));

            return pimHeaderElement.isDisplayed();
        } catch (Exception e) {
            log.error("Reset password success message not displayed: {}", e.getMessage());
            return false;
        }
    }
    
}
