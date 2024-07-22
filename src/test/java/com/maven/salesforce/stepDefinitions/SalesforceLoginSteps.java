package com.maven.salesforce.stepDefinitions;

import com.maven.salesforce.base.BaseTest;
import com.maven.salesforce.pages.forgotpassword.ForgotPasswordPage;
import com.maven.salesforce.pages.home.HomePage;
import com.maven.salesforce.pages.login.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.en.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class SalesforceLoginSteps extends BaseTest {
	private LoginPage loginPage;
	private HomePage homePage;
	private ForgotPasswordPage forgotPasswordPage;
	private static final Logger logger = LogManager.getLogger(LoginPage.class);

	@Given("I open the Salesforce login page")
	public void iOpenTheSalesforceLoginPage() {
		browserSelect("chrome");
		loginPage = new LoginPage(driver);
		forgotPasswordPage = new ForgotPasswordPage(driver);
		homePage = new HomePage(driver);
		loginPage.openLoginPage(configReader.getProperty("url"));
		logger.info("Navigated to URL: {}", configReader.getProperty("url"));
	}

	@Then("I should see the Salesforce application page")
	public void iShouldSeeTheSalesforceApplicationPage() {
		Assert.assertTrue(driver.getTitle().contains("Login | Salesforce"));
		logger.info("Salesforce application page is displayed.");
	}

	@When("I enter the username as {string}")
	public void iEnterTheUsernameAs(String username) {
		loginPage.enterUsername(configReader.getProperty("username"));
		logger.info("Entered username: {}", username);
	}

	@When("I enter the password as {string}")
	public void iEnterThePasswordAs(String password) {
		loginPage.enterPassword(configReader.getProperty("password"));
		logger.info("Entered password.");
	}

	@When("I clear the password field")
	public void iClearThePasswordField() {
		loginPage.enterPassword("");
		logger.info("Cleared the password field.");
	}

	@When("I click on the Login to Salesforce button")
	public void iClickOnTheLoginToSalesforceButton() {
		loginPage.clickLogin();
		logger.info("Clicked on the Login to Salesforce button.");
	}

	@Then("I should see the error message {string}")
	public void iShouldSeeTheErrorMessage(String errorMessage) {
		Assert.assertEquals(loginPage.getErrorMessage(), errorMessage);
		logger.info("Error message displayed: {}", errorMessage);
	}

	@Then("I should see the Salesforce home page")
	public void iShouldSeeTheSalesforceHomePage() {
		Assert.assertTrue(driver.getTitle().contains("Home Page ~ Salesforce - Developer Edition"));
		logger.info("Salesforce home page is displayed.");
	}

	@When("I select the remember username checkbox")
	public void iSelectTheRememberUsernameCheckbox() {
		loginPage.checkRememberMe();
		logger.info("Selected the remember username checkbox.");
	}

	@When("I click on the user menu dropdown")
	public void iClickOnTheUserMenuDropdown() {
		homePage.menuDropdown();
		logger.info("Clicked on the user menu dropdown.");
	}

	@When("I select the logout link")
	public void iSelectTheLogoutLink() {
		homePage.logout();
		logger.info("Selected the logout link.");

	}

	@Then("the username field should be populated with {string}")
	public void theUsernameFieldShouldBePopulatedWith(String username) {
		Assert.assertEquals(loginPage.getUsername(), configReader.getProperty("username"));
		logger.info("Username field populated with: {}", username);
	}

	@Then("the remember username checkbox should be checked")
	public void theRememberUsernameCheckboxShouldBeChecked() {
		Assert.assertTrue(loginPage.isRememberMeChecked());
		logger.info("Remember username checkbox is checked.");
	}

	@When("I click on the Forgot Password link")
	public void iClickOnTheForgotPasswordLink() {
		loginPage.clickForgotPassword();
		logger.info("Clicked on the Forgot Password link.");
	}

	@Then("I should see the Salesforce forgot password page")
	public void iShouldSeeTheSalesforceForgotPasswordPage() {
		Assert.assertTrue(driver.getTitle().contains("Forgot Your Password | Salesforce"));
		logger.info("Salesforce forgot password page is displayed.");
	}

	@When("I enter {string} in the forgot password username field")
	public void iEnterInTheForgotPasswordUsernameField(String username) {
		forgotPasswordPage.enterForgotUsername(configReader.getProperty("username"));
		logger.info("Entered username in forgot password field: {}", username);
	}

	@When("I click on the Continue button")
	public void iClickOnTheContinueButton() {
		forgotPasswordPage.clickContinue();
		logger.info("Clicked on the Continue button.");
	}

	@Then("I should see the password reset message")
	public void iShouldSeeThePasswordResetMessage() {
		Assert.assertTrue(driver.getTitle().contains("Check Your Email | Salesforce"));
		logger.info("Password reset message is displayed.");
	}

	@Then("an email should be sent to the email associated with {string}")
	public void anEmailShouldBeSentToTheEmailAssociatedWith(String username) {
		Assert.assertTrue(driver.getTitle().contains("Check Your Email | Salesforce"));
		logger.info("email should be sent to the email.");
	}

	@When("I enter {string} in the username field")
	public void iEnterInvalidUsernameAs(String invalidusername) {
		loginPage.enterUsername(configReader.getProperty("invalidusername"));
		logger.info("Entered invalid username" + invalidusername);
	}

	@When("I enter {string} in the password field")
	public void iEnterInvalidPasswordAs(String invalidpassword) {
		loginPage.enterPassword(configReader.getProperty("invalidpassword"));
		logger.info("Entered invalid password" + invalidpassword);
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
