package com.orange.hrm.e2e;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Cucumber Spring Configuration
 */
@CucumberContextConfiguration
@SpringBootTest(classes = {OrangeHRME2eApplication.class})
class CucumberSpringConfiguration {

}
