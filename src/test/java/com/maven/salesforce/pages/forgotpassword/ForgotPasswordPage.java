package com.maven.salesforce.pages.forgotpassword;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.maven.salesforce.pages.login.LoginPage;

public class ForgotPasswordPage {

	WebDriver driver;
	WebDriverWait wait;
	private static final Logger logger = LogManager.getLogger(LoginPage.class);

	@FindBy(name = "continue")
	WebElement continueButton;

	@FindBy(id = "un")
	WebElement forgotUsernameField;

	@FindBy(linkText = "resend the email")
	WebElement resendEmailLink;

	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}

	public void enterForgotUsername(String username) {
		forgotUsernameField.sendKeys(username);
		logger.info("Entered forgot password username: {}", username);

	}

	public void clickContinue() {
		continueButton.click();
		logger.info("Clicked continue button.");
	}

	

}
