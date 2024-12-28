package com.orange.hrm.e2e.stepDefinitions;

import com.orange.hrm.e2e.pages.PasswordResetPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.orange.hrm.e2e.config.WebDriverManager.getDriver;

/**
 * Step Definitions for Password Reset functionality
 */
public class PasswordResetDefinitions {

    private final PasswordResetPage passwordResetPage;

    public PasswordResetDefinitions() {
        this.passwordResetPage = new PasswordResetPage();
    }

    @Given("I navigate to the OrangeHRM login page to reset password")
    public void iNavigateToTheLoginPage() {
        getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/logout");
    }

    @When("I click the forgot password link")
    public void iClickTheForgotPasswordLink() {
        passwordResetPage.clickForgotPassword();
    }

    @Then("I should be taken to the reset password page")
    public void iShouldBeTakenToResetPage() {
        Assert.assertTrue("Error message not displayed!", passwordResetPage.isResetPasswordTitleShown());
    }

    @Given("I am on the password reset page")
    public void iAmOnThePasswordResetPage() {
        getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode");
        passwordResetPage.isResetPasswordTitleShown(); // Ensure the page is fully loaded
    }

    @When("I enter a valid username {string}")
    public void iEnterAValidUsername(String username) {
        passwordResetPage.enterUsername(username);
    }

    @Then("I should see the message {string}")
    public void iShouldSeeTheMessage(String expectedMessage) {
        boolean isMessageDisplayed = passwordResetPage.isResetPasswordSuccessMessageDisplayed();
        Assert.assertTrue("Expected success message not displayed!", isMessageDisplayed);
    }

    @And("I click the Reset Password button")
    public void iClickTheResetPasswordButton() {
        passwordResetPage.clickResetPasswordButton();
    }
}
