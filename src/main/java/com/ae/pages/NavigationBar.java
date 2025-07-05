package com.ae.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ae.base.BasePage;
import com.ae.listeners.ReportListeners;
import com.aventstack.extentreports.Status;

public class NavigationBar extends BasePage{

	private final static Logger LOG = LogManager.getLogger(NavigationBar.class);

	private static final By SIGNUP_LOGIN_LINK_LOCATOR = By.xpath("//a[@href='/login']");
	private static final By LOGGED_IN_AS_LABEL_LOCATOR = By.xpath("//a[contains(text(),'Logged in as')]");
	private static final By DELETE_ACCOUNT_LINK_lOCATOR = By.xpath("//a[@href='/delete_account']");
	private static final By LOGOUT_LINK_lOCATOR = By.xpath("//a[@href='/logout']");
	private static final By CONTACT_US_LINK_LOCATOR = By.xpath("//a[@href='/contact_us']");
	private static final By PRODUCTS_LINK_LOCATOR = By.xpath("//a[@href='/products']");
	private static final By TESTCASES_LINK_LOCATOR = By.xpath("//a[@href='/test_cases']");

	public NavigationBar(WebDriver driver) {
		super(driver);
	}
	
	public SignupLoginPage clickSignupLoginLink() {
		try {
			WebElement element = waitForElementToBeVisible(SIGNUP_LOGIN_LINK_LOCATOR);
			element.click();
			LOG.info("Clicked on Signup / Login Link.");
			ReportListeners.test.log(Status.PASS, "Clicked on Signup / Login Link.");
			return new SignupLoginPage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on Signup / Login Link." + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to click on Signup / Login Link." + e.getMessage());
			return null;
		}
	}

	public AccountDeletedPage clickDeleteAccountLink() {
		try {
			WebElement element = waitForElementToBeVisible(DELETE_ACCOUNT_LINK_lOCATOR);
			element.click();
			LOG.info("Clicked on Delete Account Link.");
			ReportListeners.test.log(Status.PASS, "Clicked on Delete Account Link.");
			LOG.info("Navigating to Account deleted page.");
			ReportListeners.test.log(Status.PASS, "Navigating to Account deleted page.");
			return new AccountDeletedPage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on Delete Account Link. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL,
					"Unable to click on Delete Account Link. Error occured : " + e.getMessage());
			return null;
		}
	}

	public TestCasesPage clickTestCasesLink() {
		try {
			WebElement element = waitForElementToBeClickable(TESTCASES_LINK_LOCATOR);
			element.click();
			LOG.info("Clicked on Test cases Link.");
			ReportListeners.test.log(Status.PASS, "Clicked on Test cases Link.");
			return new TestCasesPage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on Test cases Link. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL,
					"Unable to click on Test cases Link. Error occured : " + e.getMessage());
			return null;
		}
	}

	public boolean isLoggedInAsUsernameVisible() {
		try {
			WebElement element = waitForElementToBeVisible(LOGGED_IN_AS_LABEL_LOCATOR);
			LOG.info("'Logged in as username' label is displayed on home page.");
			ReportListeners.test.log(Status.PASS, "'Logged in as username' label is displayed on home page.");
			return element.isDisplayed();
		} catch (Exception e) {
			LOG.error("'Logged in as username' label not displayed on home page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL,
					"'Logged in as username' label not displayed on home page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getLoggedInAsUsernameText() {
		try {
			WebElement element = waitForElementToBeVisible(LOGGED_IN_AS_LABEL_LOCATOR);
			LOG.info("'Logged in as username' text retrived is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS,
					"'Logged in as username' text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			LOG.error("Unable to retrive 'Logged in as username'  text. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL,
					"Unable to retrive 'Logged in as username'  text. Error occured : " + e.getMessage());
			return "Unable to retrive 'Logged in as username' text.";
		}
	}

	public SignupLoginPage clickLogoutLink() {
		try {
			WebElement element = waitForElementToBeVisible(LOGOUT_LINK_lOCATOR);
			element.click();
			LOG.info("Clicked on Logout Link.");
			ReportListeners.test.log(Status.PASS, "Clicked on Logout Link.");
			LOG.info("Navigating to Signup / Login page.");
			ReportListeners.test.log(Status.PASS, "Navigating to Signup / Login page.");
			return new SignupLoginPage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on Logout Link.");
			ReportListeners.test.log(Status.FAIL, "Unable to click on Logout Link.");
			return null;
		}
	}

	public ContactUsPage clickContactUsLink() {
		try {
			WebElement element = waitForElementToBeVisible(CONTACT_US_LINK_LOCATOR);
			element.click();
			LOG.info("Clicked on Contact us Link.");
			ReportListeners.test.log(Status.PASS, "Clicked on Contact us Link.");
			LOG.info("Navigating to Contact us page.");
			ReportListeners.test.log(Status.PASS, "Navigating to Contact us page.");
			return new ContactUsPage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on Contact us Link.");
			ReportListeners.test.log(Status.FAIL, "Unable to click on Contact us Link.");
			return null;
		}
	}

	public ProductsPage clickProductsLink() {
		try {
			WebElement element = waitForElementToBeVisible(PRODUCTS_LINK_LOCATOR);
			element.click();
			LOG.info("Clicked on Products Link.");
			ReportListeners.test.log(Status.PASS, "Clicked on Products Link.");
			return new ProductsPage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on Products Link. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL,
					"Unable to click on Products Link. Error occured : " + e.getMessage());
			return null;
		}
	}
	

}