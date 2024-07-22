package com.maven.salesforce.pages.home;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.maven.salesforce.pages.login.LoginPage;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	private static final Logger logger = LogManager.getLogger(LoginPage.class);

	@FindBy(id = "userNavButton")
	WebElement userMenu;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logoutLink;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}

	public void menuDropdown() {
		userMenu.click();
		logger.info("Clicked user menu dropdown.");
	}

	public void logout() {
		logoutLink.click();
		logger.info("Clicked logout link.");
	}

}
