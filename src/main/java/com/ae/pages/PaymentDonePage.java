package com.ae.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ae.base.BasePage;
import com.ae.listeners.ReportListeners;
import com.aventstack.extentreports.Status;

public class PaymentDonePage extends BasePage{

	private static final Logger LOG = LogManager.getLogger(PaymentDonePage.class);
	private static final By CONFIRMED_MESSAGE_LOCAOTR = By.xpath("//h2[@data-qa='order-placed']/following-sibling::p");
	
	public PaymentDonePage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isConfirmedMessageVisible() {
		try {
			WebElement element = waitForElementToBeVisible(CONFIRMED_MESSAGE_LOCAOTR);
			LOG.info("Order confirmed message is displayed on the Payment done page");
			ReportListeners.test.log(Status.PASS, "Order confirmed message is displayed on the Payment done page");
			return element.isDisplayed();
		} catch (Exception e) {
			LOG.info("Order confirmed message not displayed on the Payment done page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Order confirmed message not displayed on the Payment done page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getConfirmedMessageText() {
		try {
			WebElement element = waitForElementToBeVisible(CONFIRMED_MESSAGE_LOCAOTR);
			LOG.info("Order confirmed message text retrived is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS, "Order confirmed message text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			LOG.info("Unable to retrive Order confirmed message text on the Payment done page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive Order confirmed message text on the Payment done page. Error occured : " + e.getMessage());
			return "Unable to retrive Order confirmed message text on the Payment done page.";
		}
	}
	
}