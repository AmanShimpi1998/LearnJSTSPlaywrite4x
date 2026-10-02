package com.example.vwo.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.example.vwo.pages.LoginPage;

public class InvalidLoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeTest
    public void setUp() {
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
    public void invalidCredentialsShowAnAuthenticationError() {
        try {
            loginPage.open();
            loginPage.submitCredentials("invalid.user@example.invalid", "invalid-password");
            Assert.assertTrue(loginPage.waitForAuthenticationError(), "Invalid credentials should show an authentication error");
            Assert.assertFalse(loginPage.getAuthenticationErrorText().isBlank(), "Authentication error text should be visible");
            Assert.assertTrue(loginPage.isLoginFormDisplayed(), "The login form should remain available after rejection");
        } catch (RuntimeException exception) {
            Assert.fail("Invalid-credentials test could not complete", exception);
        }
    }

        @Test
    public void emptyCredentialsAreRejected() {
        try {
            loginPage.open();
            loginPage.submitEmptyCredentials();
            boolean hasValidationFeedback = loginPage.hasNativeValidationMessage()
                || loginPage.waitForAuthenticationError();
            Assert.assertTrue(hasValidationFeedback, "Empty credentials should produce validation feedback");
            Assert.assertTrue(loginPage.isLoginFormDisplayed(), "The login form should remain visible when credentials are empty");
        } catch (RuntimeException exception) {
            Assert.fail("Empty-credentials test could not complete", exception);
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
