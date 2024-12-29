package com.orange.hrm.e2e.pages;

import static com.orange.hrm.e2e.config.WebDriverManager.getDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DashboardPage {

    private final WebDriverWait wait;

    public DashboardPage() {
        PageFactory.initElements(getDriver(), this);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
    }

    /**
     * isDashBoardLoaded
     *
     * @return isDashBoardLoaded
     */
    public boolean isDashBoardLoaded() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

            WebElement moduleHeaderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h6[contains(@class, 'oxd-topbar-header-breadcrumb-module') and text()='Dashboard']")
            ));

            return moduleHeaderElement.isDisplayed();
        } catch (Exception e) {
            log.error("Reset password success message not displayed: {}", e.getMessage());
            return false;
        }
    }
    
}
