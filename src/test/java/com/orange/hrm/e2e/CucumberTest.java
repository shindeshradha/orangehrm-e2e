package com.orange.hrm.e2e;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Cucumber Test Runner
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        glue = {"com.orange.hrm"}
)
class CucumberTest {
    public static void main(String[] args) {
    }
}
