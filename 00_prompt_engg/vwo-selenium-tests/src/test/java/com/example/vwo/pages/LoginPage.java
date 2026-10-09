package com.example.vwo.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private static final String LOGIN_URL = "https://app.vwo.com/#/login";
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//input[@type='email' or @autocomplete='username' or @placeholder='Email address' or @placeholder='name@yourcompany.com']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit' or normalize-space()='Sign in']")
    private WebElement signInButton;

    @FindBy(xpath = "//label[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'remember me')]")
    private WebElement rememberMeLabel;

    @FindBy(xpath = "//input[@type='checkbox' and (ancestor::label[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'remember me')] or following-sibling::*[contains(translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'remember me')])]")
    private WebElement rememberMeCheckbox;

    @FindBy(xpath = "//*[@role='alert' or @aria-live='assertive' or contains(@class, 'error') or contains(@class, 'alert') or contains(@data-qa, 'error')]")
    private List<WebElement> authenticationErrors;

    public LoginPage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver must not be null");
        }
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void open() {
        try {
            driver.get(LOGIN_URL);
            wait.until(ExpectedConditions.visibilityOf(emailInput));
            wait.until(ExpectedConditions.visibilityOf(passwordInput));
        } catch (WebDriverException exception) {
            throw new IllegalStateException("Unable to open the VWO login page", exception);
        }
    }

    public void setRememberMe(boolean selected) {
        try {
            wait.until(ExpectedConditions.visibilityOf(rememberMeLabel));
            if (rememberMeCheckbox.isSelected() != selected) {
                rememberMeLabel.click();
            }
            if (rememberMeCheckbox.isSelected() != selected) {
                throw new IllegalStateException("Remember me selection did not update");
            }
        } catch (WebDriverException exception) {
            throw new IllegalStateException("Unable to update the Remember me setting", exception);
        }
    }

    public boolean isRememberMeSelected() {
        try {
            return rememberMeCheckbox.isSelected();
        } catch (NoSuchElementException exception) {
            throw new IllegalStateException("Remember me checkbox was not found", exception);
        } catch (WebDriverException exception) {
            throw new IllegalStateException("Unable to read the Remember me setting", exception);
        }
    }

    public void submitCredentials(String email, String password) {
        try {
            wait.until(ExpectedConditions.visibilityOf(emailInput));
            emailInput.clear();
            emailInput.sendKeys(email);
            passwordInput.clear();
            passwordInput.sendKeys(password);
            wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
        } catch (WebDriverException exception) {
            throw new IllegalStateException("Unable to submit login credentials", exception);
        }
    }

    public void submitEmptyCredentials() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
        } catch (WebDriverException exception) {
            throw new IllegalStateException("Unable to submit the empty login form", exception);
        }
    }

    public boolean isLoginFormDisplayed() {
        try {
            return emailInput.isDisplayed() && passwordInput.isDisplayed();
        } catch (NoSuchElementException | TimeoutException exception) {
            return false;
        } catch (WebDriverException exception) {
            throw new IllegalStateException("Unable to determine whether the login form is displayed", exception);
        }
    }

    public boolean waitForAuthenticationError() {
        try {
            return wait.until(currentDriver -> authenticationErrors.stream()
                    .anyMatch(element -> element.isDisplayed() && !element.getText().isBlank()));
        } catch (TimeoutException exception) {
            return false;
        } catch (WebDriverException exception) {
            throw new IllegalStateException("Unable to inspect the login error message", exception);
        }
    }

    public boolean hasNativeValidationMessage() {
        try {
            return !emailInput.getDomProperty("validationMessage").isBlank()
                    || !passwordInput.getDomProperty("validationMessage").isBlank();
        } catch (WebDriverException exception) {
            throw new IllegalStateException("Unable to inspect native form validation", exception);
        }
    }

    public String getAuthenticationErrorText() {
        try {
            return authenticationErrors.stream()
                    .filter(WebElement::isDisplayed)
                    .map(WebElement::getText)
                    .filter(text -> !text.isBlank())
                    .findFirst()
                    .orElse("");
        } catch (WebDriverException exception) {
            throw new IllegalStateException("Unable to read the login error message", exception);
        }
    }

    public boolean waitForSuccessfulLogin() {
        try {
            return wait.until(currentDriver -> !currentDriver.getCurrentUrl().contains("#/login")
                    || !isLoginFormDisplayed());
        } catch (TimeoutException exception) {
            return false;
        } catch (WebDriverException exception) {
            throw new IllegalStateException("Unable to verify successful login", exception);
        }
    }
}
