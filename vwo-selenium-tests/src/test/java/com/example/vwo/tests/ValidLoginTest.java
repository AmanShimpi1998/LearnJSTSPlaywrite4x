package com.example.vwo.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.example.vwo.pages.LoginPage;

public class ValidLoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private String username;
    private String password;

    @BeforeTest
    public void setUp() {
        username = System.getenv("VWO_USERNAME");
        password = System.getenv("VWO_PASSWORD");
        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            throw new SkipException("Set VWO_USERNAME and VWO_PASSWORD to run valid-login tests");
        }

        try {
            ChromeOptions options = new ChromeOptions();
            if (Boolean.parseBoolean(System.getProperty("headless", "true"))) {
                options.addArguments("--headless=new");
            }
            options.addArguments("--window-size=1440,1000", "--disable-dev-shm-usage", "--no-sandbox");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().pageLoadTimeout(java.time.Duration.ofSeconds(30));
            loginPage = new LoginPage(driver);
        } catch (WebDriverException exception) {
            throw new IllegalStateException("Unable to initialize Chrome WebDriver", exception);
        }
    }

    @Test
    public void validCredentialsOpenTheAccount() {
        try {
            loginPage.open();
            loginPage.setRememberMe(true);
            Assert.assertTrue(loginPage.isRememberMeSelected(), "Remember me should be selected");
            loginPage.submitCredentials(username, password);
            Assert.assertTrue(loginPage.waitForSuccessfulLogin(), "Valid credentials should open the account");
        } catch (RuntimeException exception) {
            Assert.fail("Valid-login test could not complete", exception);
        }
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (WebDriverException exception) {
                throw new IllegalStateException("Unable to close Chrome WebDriver", exception);
            }
        }
    }
}
