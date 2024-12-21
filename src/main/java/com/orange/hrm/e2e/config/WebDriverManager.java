package com.orange.hrm.e2e.config;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * WebDriver manager
 */
@Slf4j
public class WebDriverManager {

    /**
     * The thread local web driver
     */
    private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    /**
     * Get web driver
     *
     * @return the web driver
     */
    public static WebDriver getDriver() {
        if (webDriverThreadLocal.get() == null) {
            WebDriver driver = new ChromeDriver(getOptions());
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            webDriverThreadLocal.set(driver);
        }
        return webDriverThreadLocal.get();
    }

    public static void quitDriver() {
        WebDriver driver = webDriverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            webDriverThreadLocal.remove();
        }
    }

    /**
     * Get chrome options
     *
     * @return the chrome options
     */
    private static ChromeOptions getOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-in-process-stack-traces");
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-logging");
        options.addArguments("--log-level=3");
        options.addArguments("--ignore-ssl-errors");
        options.addArguments("--ignore-certificate-errors");
        //options.addArguments("--headless");
        options.addArguments("--window-size=1920x1080");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--remote-debugging-pipe");

        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList(("enable-automation")));

        Map<String, Object> preferences = new HashMap<>();
        preferences.put("credentials_enable_service", false);
        preferences.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", preferences);

        return options;
    }


}
