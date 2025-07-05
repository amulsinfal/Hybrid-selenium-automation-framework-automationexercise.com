package com.ae.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ae.base.BasePage;
import com.ae.listeners.ReportListeners;
import com.aventstack.extentreports.Status;

public class ApplicationFooter extends BasePage{

	private static final Logger LOG = LogManager.getLogger(ApplicationFooter.class);
	private static final By SUBSCRIPTION_LABEL_LOCATOR = By.xpath("//div[@class='single-widget']/h2");
	private static final By SUBSCRIPTION_EMAIL_TEXTBOX_LOCATOR = By.id("susbscribe_email");
	private static final By SUBSCRIBE_BUTTON_LOCATOR = By.id("subscribe");
	private static final By SUCCESS_MESSAGE_LABEL_LOCATOR = By.xpath("//div[@id='success-subscribe']/div[@class='alert-success alert']");
	
	public ApplicationFooter(WebDriver driver) {
		super(driver);
	}
	
	public boolean isSubscriptionLabelDisplayed() {
		try {
			WebElement element = waitForElementToBeVisible(SUBSCRIPTION_LABEL_LOCATOR);
			LOG.info("'Subscription' label is displayed on home page.");
			ReportListeners.test.log(Status.PASS, "'Subscription' label is displayed on home page.");
			return element.isDisplayed();
		} catch (Exception e) {
			LOG.error("'Subscription' label not displayed on home page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL,
					"'Subscription' label not displayed on home page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getSubscriptionText() {
		try {
			WebElement element = waitForElementToBeVisible(SUBSCRIPTION_LABEL_LOCATOR);
			LOG.info("Subscription label text retrived is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS, "Subscription label text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			LOG.error("Unable to retrive Subscription label text. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL,
					"Unable to retrive Subscription label text. Error occured : " + e.getMessage());
			return "Unable to retrive Subscription label text.";
		}
	}

	public ApplicationFooter clickArrowButton() {
		try {
			WebElement element = waitForElementToBeClickable(SUBSCRIBE_BUTTON_LOCATOR);
			element.click();
			LOG.info("Clicked on Subscribe button.");
			ReportListeners.test.log(Status.PASS, "Clicked on Subscribe button.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to click on Subscribe button.");
			ReportListeners.test.log(Status.FAIL, "Unable to click on Subscribe button.");
			return this;
		}
	}

	public ApplicationFooter enterSubscriptionEmail(String email) {
		try {
			WebElement element = waitForElementToBeClickable(SUBSCRIPTION_EMAIL_TEXTBOX_LOCATOR);
			element.sendKeys(email);
			LOG.info("'" + email + "' entered in the subscription email text box.");
			ReportListeners.test.log(Status.PASS, "'" + email + "' entered in the subscription email text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + email + "' text in the subscription email text box. Error occured : "
					+ e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + email
					+ "' text in the subscription email text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	public boolean isSubscriptionSuccessLabelDisplayed() {
		try {
			WebElement element = waitForElementToBeVisible(SUCCESS_MESSAGE_LABEL_LOCATOR);
			LOG.info("Subscription success label is displayed on home page.");
			ReportListeners.test.log(Status.PASS, "Subscription success label is displayed on home page.");
			return element.isDisplayed();
		} catch (Exception e) {
			LOG.error("Subscription success label not displayed on home page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL,
					"Subscription success label not displayed on home page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getSubscriptionSuccessText() {
		try {
			WebElement element = waitForElementToBeVisible(SUCCESS_MESSAGE_LABEL_LOCATOR);
			LOG.info("Subscription success message text retrived is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS,
					"Subscription success message text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			LOG.error("Unable to retrive Subscription success message text. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL,
					"Unable to retrive Subscription success message text. Error occured : " + e.getMessage());
			return "Unable to retrive Subscription success message text.";
		}
	}

	
}
