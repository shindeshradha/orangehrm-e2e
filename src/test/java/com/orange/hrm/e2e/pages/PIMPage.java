package com.orange.hrm.e2e.pages;

import static com.orange.hrm.e2e.config.WebDriverManager.getDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[@type='reset']")
    private WebElement resetButton;

    @FindBy(xpath = "//form[contains(@class, 'oxd-form')]")
    private WebElement searchTableElement;

    public PIMPage() {
        PageFactory.initElements(getDriver(), this);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
    }

    public boolean isPIMLoaded() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

            WebElement pimHeaderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h6[contains(@class, 'oxd-topbar-header-breadcrumb-module') and text()='PIM']")));

            return pimHeaderElement.isDisplayed();
        } catch (Exception e) {
            log.error("Reset password success message not displayed: {}", e.getMessage());
            return false;
        }
    }

    /**
     * Method to enter the password in the password field
     *
     *
     */
    public void searchEmployeeFreeText(String searchField, String searchQuery) {
        try {
            Thread.sleep(500);
            String attributeName = "data-v-1f99f73c";
            if (searchField.equals("Employee Name")) {
                System.out.println("***************** Inside bef" + attributeName);
                attributeName = attributeName.replace("1f99f73c", "75e744cd");
                System.out.println("***************** Inside aft " + attributeName);
            }
            String xpath = "//input[@" + attributeName + "]";
            List<WebElement> searchFieldElements = getDriver().findElements(By.xpath(xpath));
            if (searchFieldElements.size() > 1 & searchField.equals("Employee Id")) {
                searchFieldElements.get(1).sendKeys(searchQuery);
                Thread.sleep(500);
                searchFieldElements.get(1).sendKeys(Keys.ENTER);
            } else {
                searchFieldElements.get(0).sendKeys(searchQuery);
                Thread.sleep(5000);
                searchFieldElements.get(0).sendKeys(Keys.ENTER);
                searchFieldElements.get(0).sendKeys(Keys.ENTER);
                Thread.sleep(5000);
                searchButton.click();
            }
        } catch (Exception e) {
            log.error("Search Field was not found: {}", e.getMessage());
        }
    }

    /**
     * Method to click a button
     */
    public void clickButton(String type) {
        if (type.equals("Submit")) {
            this.waitForButtonLoad(searchButton);
            searchButton.click();
        } else {
            this.waitForButtonLoad(resetButton);
            resetButton.click();

        }
    }

    public boolean verifySearchResultMessage(String expectedMessage) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));

            WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//span[@data-v-5a621acd]")));

            String actualText = successMessageElement.getText();
            return actualText.equals(expectedMessage);
        } catch (Exception e) {
            log.error("Search Result message not displayed: {}", e.getMessage());
            return false;
        }
    }

    private void waitForButtonLoad(WebElement button) {
        wait.until(ExpectedConditions.elementToBeClickable(button));
    }

}
