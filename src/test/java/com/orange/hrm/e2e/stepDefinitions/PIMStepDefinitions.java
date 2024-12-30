package com.orange.hrm.e2e.stepDefinitions;

import static com.orange.hrm.e2e.config.WebDriverManager.getDriver;

import org.junit.Assert;
import com.orange.hrm.e2e.pages.PIMPage;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PIMStepDefinitions {


    private final PIMPage pimPage;
    
    public PIMStepDefinitions(){
        this.pimPage = new PIMPage();
    }

    @After
    public void iLogOut(Scenario scenario){
        getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/logout");
    }

    @Given("I navigate to the PIM module")
    public void iNavigateToThePIMPage() {
        getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
        pimPage.isPIMLoaded();
    }

    @When("I search for an employee with {string} of {string}")
    public void iEnterValidCredentials(String searchField, String searchQuery) {
        pimPage.searchEmployeeFreeText(searchField, searchQuery);
    }

    @When("I click {string}")
    public void iClickButton(String button) {
        pimPage.clickButton(button);
    }

    @Then("the system should report {string}")
    public void theSystemShouldReport(String expectedMessage) {
        Assert.assertTrue("Expected message not displayed!", pimPage.verifySearchResultMessage(expectedMessage));
    }
}
