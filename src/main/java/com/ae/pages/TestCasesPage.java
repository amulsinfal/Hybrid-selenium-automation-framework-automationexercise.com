package com.ae.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ae.base.BasePage;
import com.ae.listeners.ReportListeners;
import com.aventstack.extentreports.Status;

public class TestCasesPage extends BasePage {

	private static final Logger LOG = LogManager.getLogger(TestCasesPage.class);
	private static final By TEXTCASES_LABEL_LOCATOR = By.xpath("//h2[@class='title text-center']/b");

	public TestCasesPage(WebDriver driver) {
		super(driver);
	}

	public boolean isOnTestCasesPage() {
		try {
			WebElement element = waitForElementToBeVisible(TEXTCASES_LABEL_LOCATOR);
			LOG.info("Test cases is visible.");
			ReportListeners.test.log(Status.PASS, "Test cases is visible.");
			return element.isDisplayed();
		} catch (Exception e) {
			LOG.error("Test cases not displayed. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Test cases not displayed. Error occured : " + e.getMessage());
			return false;
		}
	}

}