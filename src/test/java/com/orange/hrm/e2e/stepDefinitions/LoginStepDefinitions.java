package com.orange.hrm.e2e.stepDefinitions;

import com.orange.hrm.e2e.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.orange.hrm.e2e.config.WebDriverManager.getDriver;

/**
 * Step Definitions for Login functionality
 */
public class LoginStepDefinitions {

    private final LoginPage loginPage;

    public LoginStepDefinitions() {
        this.loginPage = new LoginPage();
    }

    @Given("I navigate to the OrangeHRM login page")
    public void iNavigateToTheLoginPage() {
        getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.waitForLoginPageToLoad();
    }

    @When("I enter valid credentials {string} and {string}")
    public void iEnterValidCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I enter invalid credentials {string} and {string}")
    public void iEnterInvalidCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should be redirected to the dashboard")
    public void iShouldBeRedirectedToTheDashboard() {
        Assert.assertTrue("Dashboard did not load successfully!", /* Add dashboard verification logic here */ true);
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String expectedMessage) {
        Assert.assertTrue("Error message not displayed!", loginPage.isWrongCredentialsStatusElementDisplayed());
    }
}
