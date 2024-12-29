package com.orange.hrm.e2e.stepDefinitions;

import org.junit.Assert;

import com.orange.hrm.e2e.pages.DashboardPage;

import io.cucumber.java.en.Then;

public class DashBoardStepDefinitions {

    private final DashboardPage dashboardPage;

    public DashBoardStepDefinitions() {
        this.dashboardPage = new DashboardPage();
    }

    @Then("I should be redirected to the dashboard")
    public void iShouldBeRedirectedToTheDashboard() {
        Assert.assertTrue("Dashboard did not load successfully!", dashboardPage.isDashBoardLoaded());
    }
    
}
