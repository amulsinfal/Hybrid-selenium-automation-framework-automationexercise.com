package com.ae.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ae.base.BasePage;
import com.ae.listeners.ReportListeners;
import com.aventstack.extentreports.Status;

public class AccountCreatedPage extends BasePage {

	private static final Logger LOG = LogManager.getLogger(AccountCreatedPage.class);
	private static final By ACCOUNT_CREATED_LABEL_LOCATOR = By.xpath("//h2[@data-qa='account-created']/b");
	private static final By CONTINUE_BUTTON_LOCATOR = By.xpath("//a[@data-qa='continue-button']");

	public AccountCreatedPage(WebDriver driver) {
		super(driver);
	}

	public boolean isAccountCreatedLabelVisible() {
		try {
			WebElement element = waitForElementToBeVisible(ACCOUNT_CREATED_LABEL_LOCATOR);
			LOG.info("Account created page header is displayed on the Account created page");
			ReportListeners.test.log(Status.PASS, "Account created page header is displayed on the Account created page");
			return element.isDisplayed();
		} catch (Exception e) {
			LOG.error("Account created page header not displayed on the Account created  page. Error occured : "	+ e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Account created page header not displayed on the Account created  page. Error occured : "	+ e.getMessage());
			return false;
		}
	}

	public String getAccountCreatedLabelText() {
		try {
			WebElement element = waitForElementToBeVisible(ACCOUNT_CREATED_LABEL_LOCATOR);
			LOG.info("Account created header text retrived is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS, "Account created header text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			LOG.error("Unable to retrive Account created page header text on the Account created page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive Account created page header text on the Account created page. Error occured : " + e.getMessage());
			return "Unable to retrive Account created page header text on the Account created page.";
		}
	}

	public HomePage clickContinue() {
		try {
			WebElement element = waitForElementToBeClickable(CONTINUE_BUTTON_LOCATOR);
			element.click();
			LOG.info("Clicked on the Continue button.");
			ReportListeners.test.log(Status.PASS, "Clicked on the Continue button.");
			LOG.info("Navigating to Home page.");
			ReportListeners.test.log(Status.PASS, "Navigating to Home page.");
			return new HomePage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on Continue button. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to click on Continue button. Error occured : " + e.getMessage());
			return null;
		}
	}
	
}