package com.orange.hrm.e2e.stepDefinitions;

import static com.orange.hrm.e2e.config.WebDriverManager.getDriver;

import com.orange.hrm.e2e.pages.PIMPage;

import io.cucumber.java.en.Given;

public class PIMStepDefinitions {

    private final PIMPage pimPage;
    
    public PIMStepDefinitions(){
        this.pimPage = new PIMPage();

    }

    @Given("I navigate to the PIM module")
    public void iNavigateToThePIMPage() {
        getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
        pimPage.isPIMLoaded();
    }
}
