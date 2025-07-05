package com.ae.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ae.base.BasePage;
import com.ae.listeners.ReportListeners;
import com.aventstack.extentreports.Status;

public class AccountDeletedPage extends BasePage {

	private static final Logger LOG = LogManager.getLogger(AccountDeletedPage.class);
	private static final By ACCOUNT_DELETE_LABEL_LOCATOR = By.xpath("//h2[@data-qa='account-deleted']/b");
	private static final By CONTINUE_BUTTON_LOCATOR = By.xpath("//a[@data-qa='continue-button']");

	public AccountDeletedPage(WebDriver driver) {
		super(driver);
	}

	public boolean isAccountDeletedLabelVisible() {
		try {
			WebElement element = waitForElementToBeVisible(ACCOUNT_DELETE_LABEL_LOCATOR);
			LOG.info("Account deleted label is displayed on the Account deleted page");
			ReportListeners.test.log(Status.PASS, "Account deleted label is displayed on the Account deleted page");
			return element.isDisplayed();
		} catch (Exception e) {
			LOG.error("Account deleted label not displayed on the Account deleted  page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Account deleted label not displayed on the Account deleted  page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getAccountDeletedLabelText() {
		try {
			WebElement element = waitForElementToBeVisible(ACCOUNT_DELETE_LABEL_LOCATOR);
			LOG.info("Account deleted label text retrived is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS, "Account deleted label text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			LOG.error("Unable to retrive Account deleted label text on the Account deleted page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive Account deleted label text on the Account deleted page. Error occured : " + e.getMessage());
			return "Unable to retrive Account deleted label text on the Account deleted page.";
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