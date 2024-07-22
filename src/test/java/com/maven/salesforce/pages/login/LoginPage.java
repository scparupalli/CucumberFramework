package com.maven.salesforce.pages.login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(LoginPage.class);


    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "Login")
    WebElement loginButton;

    @FindBy(id = "rememberUn")
    WebElement rememberMeCheckbox;

    @FindBy(id = "error")
    WebElement errorMessage;

    @FindBy(linkText = "Forgot Your Password?")
    WebElement forgotPasswordLink;
    
    @FindBy(id = "idcard-identity")
	WebElement logoutUsernameField;
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openLoginPage(String url) {
        driver.get(url);
    }

    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
        logger.info("Entered username: {}", username);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        logger.info("Entered password.");
    }

    public void clickLogin() {
        loginButton.click();
        this.wait = new WebDriverWait(driver, 10);
        logger.info("Clicked login button.");
    }

    public void checkRememberMe() {
        if (!rememberMeCheckbox.isSelected()) {
            rememberMeCheckbox.click();
            logger.info("Remember username checkbox selected.");
        }
    }
    
     public String getErrorMessage() {
    	String message = errorMessage.getText();
        logger.info("Error message displayed: {}", message);
        return message;
    }

     public boolean isRememberMeChecked() {
    	 boolean isChecked = rememberMeCheckbox.isSelected();
         logger.info("Remember username checkbox is checked: {}", isChecked);
         return isChecked;
    }

    public void clickForgotPassword() {
        forgotPasswordLink.click();
        logger.info("Clicked forgot password link.");
    }
    
    public String getUsername() {
    	wait.until(ExpectedConditions.visibilityOf(logoutUsernameField));
        String username = logoutUsernameField.getText();
        logger.info("Username field value: {}", username);
        return username;
	}
    
}
