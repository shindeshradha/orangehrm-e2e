package com.orange.hrm.e2e;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Cucumber Spring Configuration
 */
@CucumberContextConfiguration
@SpringBootTest(classes = {OrangeHRME2eApplication.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
class CucumberSpringConfiguration {

}
