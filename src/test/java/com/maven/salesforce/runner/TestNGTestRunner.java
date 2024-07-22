package com.maven.salesforce.runner;

import org.testng.annotations.Listeners;

import com.maven.salesforce.utils.TestListener;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "test/resources/features", 
				 glue = "com.maven.salesforce.stepDefinitions",
				 plugin = {"pretty", "html:target/cucumber-reports" }, 
				 monochrome = true)

@Listeners(TestListener.class)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}