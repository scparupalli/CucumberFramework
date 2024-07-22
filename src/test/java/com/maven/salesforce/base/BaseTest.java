package com.maven.salesforce.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.maven.salesforce.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
		protected static WebDriver driver;
		protected static WebDriverWait wait = null;
	    protected ConfigReader configReader;
	    private static final Logger logger = LogManager.getLogger(BaseTest.class);

	    public BaseTest() {
	        configReader = new ConfigReader();
	        try {
	            FileInputStream configFile = new FileInputStream("test/resources/config.properties");
	            configReader.load(configFile);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
    @BeforeClass
	public static void browserSelect(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
            	WebDriverManager.chromedriver().setup();
        		driver = new ChromeDriver();
                break;
            case "firefox":
            	System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox");
        		WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
            	WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "ie":
            	WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "safari":
            	WebDriverManager.safaridriver().setup();
        		driver = new SafariDriver();
        }
        wait = new WebDriverWait(driver, 20);
	}
    
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
