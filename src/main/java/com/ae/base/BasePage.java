package com.ae.base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ae.factory.DriverFactory;
import com.ae.listeners.ReportListeners;
import com.ae.utilities.ConfigReader;
import com.aventstack.extentreports.Status;

public class BasePage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	private final static Logger LOG = LogManager.getLogger(BasePage.class);

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(ConfigReader.readProperty("explicitWait"))));	
	}
	
	public WebElement waitForElementToBeVisible(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public WebElement waitForElementToBeClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	private static Alert getAlert() {
		try {
			LOG.info("Switching to Alert popup.");
			ReportListeners.test.log(Status.PASS, "Switching to Alert popup.");
			return DriverFactory.getDriver().switchTo().alert();
		} catch (Exception e) {
			LOG.error("Error occured while Switching to Alert popup. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Error occured while Switching to Alert popup. Error occured : " + e.getMessage());
			return null;
		}
	}

	public static void acceptAlert() {
		try {
			getAlert().accept();
			LOG.info("Clicked on 'Ok' on Alert popup.");
			ReportListeners.test.log(Status.PASS, "Clicked on 'Ok' on Alert popup.");
		} catch (Exception e) {
			LOG.error("Error occured while Clicking on 'Ok' on Alert popup. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Error occured while Clicking on 'Ok' on Alert popup. Error occured : " + e.getMessage());
		}
	}

	public static void dismissAlert() {
		try {
			getAlert().dismiss();
			LOG.info("Clicked on 'Cancel' on Alert popup.");
			ReportListeners.test.log(Status.PASS, "Clicked on 'Cancel' on Alert popup.");
		} catch (Exception e) {
			LOG.error("Error occured while Clicking on 'Cancel' on Alert popup. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Error occured while Clicking on 'Cancel' on Alert popup. Error occured : " + e.getMessage());
		}
	}
	
}