package com.ae.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ae.base.BasePage;
import com.ae.listeners.ReportListeners;
import com.aventstack.extentreports.Status;

public class SignupLoginPage extends BasePage {

	private static final Logger LOG = LogManager.getLogger(SignupLoginPage.class);
	private static final By LOGIN_FORM_HEADER_LOCATOR = By.xpath("//div[@class='login-form']/h2");
	private static final By LOGIN_EMAIL_TEXTBOX_LOCATOR = By.name("email");
	private static final By LOGIN_PASSWORD_TEXTBOX_LOCATOR = By.name("password");
	private static final By LOGIN_BUTTON_LOCATOR = By.xpath("//button[@data-qa='login-button']");
	private static final By LOGIN_ERROR_LABEL_LOCATOR = By.xpath("//div[@class='login-form']/form/p");

	private static final By SIGNUP_FORM_HEADER_LOCATOR = By.xpath("//div[@class='signup-form']/h2");
	private static final By SIGNUP_NAME_TEXTBOX_LOCATOR = By.name("name");
	private static final By SIGNUP_EMAIL_TEXTBOX_LOCATOR = By.xpath("//input[@data-qa='signup-email']");
	private static final By SIGNUP_BUTTON_LOCATOR = By.xpath("//button[@data-qa='signup-button']");
	private static final By SIGNUP_ERROR_LABEL_LOCATOR = By.xpath("//div[@class='signup-form']/form/p");

	private static final By HOME_LINK_LOCATOR = By.xpath("//a[@href='/' and contains(text(),'Home')]");

	public SignupLoginPage(WebDriver driver) {
		super(driver);
	}

	public boolean isLoginToYourAccountLabelVisible() {
		try {
			WebElement element = waitForElementToBeVisible(LOGIN_FORM_HEADER_LOCATOR);
			LOG.info("Login To Your Account Label is displayed on the Signup / login page");
			ReportListeners.test.log(Status.PASS, "Login To Your Account Label is displayed on the Signup / login page");
			return element.isDisplayed();
		} catch (Exception e) {
			LOG.error("Login To Your Account Label not displayed on the Signup / login page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Login To Your Account Label not displayed on the Signup / login page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getLoginToYourAccountLabelText() {
		try {
			WebElement element = waitForElementToBeVisible(LOGIN_FORM_HEADER_LOCATOR);
			LOG.info("Login To Your Account Label text retrived is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS, "Login To Your Account Label text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			LOG.error("Unable to retrive Login To Your Account Label text on the Signup / login page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive Login To Your Account Label text on the Signup / login page. Error occured : " + e.getMessage());
			return "Unable to retrive Login To Your Account Label text on the Signup / login page.";
		}
	}

	public SignupLoginPage enterLoginEmail(String email) {
		try {
			WebElement element = waitForElementToBeClickable(LOGIN_EMAIL_TEXTBOX_LOCATOR);
			element.sendKeys(email);
			LOG.info("'" + email + "' entered in the login email text box.");
			ReportListeners.test.log(Status.PASS, "'" + email + "' entered in the login email text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + email + "' text in the login email text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + email + "' text in the login email text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	public SignupLoginPage enterLoginPassword(String password) {
		try {
			WebElement element = waitForElementToBeClickable(LOGIN_PASSWORD_TEXTBOX_LOCATOR);
			element.sendKeys(password);
			LOG.info("'" + password + "' entered in the login password text box.");
			ReportListeners.test.log(Status.PASS, "'" + password + "' entered in the login password text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + password + "' text in the login password text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + password + "' text in the login password text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	public HomePage clickLogin() {
		try {
			WebElement element = waitForElementToBeClickable(LOGIN_BUTTON_LOCATOR);
			element.click();
			LOG.info("Clicked on the Login button.");
			ReportListeners.test.log(Status.PASS, "Clicked on the Login button.");
			return new HomePage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on Login button. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to click on Login button. Error occured : " + e.getMessage());
			return null;
		}
	}

	public boolean isLoginErrorVisible() {
		try {
			WebElement element = waitForElementToBeVisible(LOGIN_ERROR_LABEL_LOCATOR);
			LOG.info("Login error label is displayed on the Signup / login page");
			ReportListeners.test.log(Status.PASS, "Login error label is displayed on the Signup / login page");
			return element.isDisplayed();
		} catch (Exception e) {
			LOG.error("Login error lable not displayed on the Signup / login page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Login error lable not displayed on the Signup / login page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getLoginErrorText() {
		try {
			WebElement element = waitForElementToBeVisible(LOGIN_ERROR_LABEL_LOCATOR);
			LOG.info("Login error text retrived is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS, "Login error text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			LOG.error("Unable to retrive Login error text on the Signup / login page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive Login error text on the Signup / login page. Error occured : " + e.getMessage());
			return "Unable to retrive Login error text on the Signup / login page.";
		}
	}

	public boolean isSignupLoginPageVisible() {
		try {
			WebElement element = waitForElementToBeVisible(LOGIN_BUTTON_LOCATOR);
			LOG.info("Signup / Login page is displayed.");
			ReportListeners.test.log(Status.PASS, "Signup / Login page is displayed.");
			return element.isDisplayed();
		} catch (Exception e) {
			LOG.error("Signup / Login page not displayed. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Signup / Login page not displayed. Error occured : " + e.getMessage());
			return false;
		}
	}

	public boolean isNewUserSignupLabelVisible() {
		try {
			WebElement element = waitForElementToBeVisible(SIGNUP_FORM_HEADER_LOCATOR);
			LOG.info("New user signup label is displayed on the Signup / login page");
			ReportListeners.test.log(Status.PASS, "New user signup label is displayed on the Signup / login page");
			return element.isDisplayed();
		} catch (Exception e) {
			LOG.error("New user signup label not displayed on the Signup / login page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "New user signup label not displayed on the Signup / login page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getNewUserSignupLabelText() {
		try {
			WebElement element = waitForElementToBeVisible(SIGNUP_FORM_HEADER_LOCATOR);
			LOG.info("New user signup text retrived is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS, "New user signup text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			LOG.error("Unable to retrive New user signup text on the Signup / login page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive New user signup text on the Signup / login page. Error occured : " + e.getMessage());
			return "Unable to retrive New user signup text on the Signup / login page.";
		}
	}

	public SignupLoginPage enterSignupName(String name) {
		try {
			WebElement element = waitForElementToBeClickable(SIGNUP_NAME_TEXTBOX_LOCATOR);
			element.sendKeys(name);
			LOG.info("'" + name + "' entered in the signup name text box.");
			ReportListeners.test.log(Status.PASS, "'" + name + "' entered in the signup name text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + name + "' text in the signup name text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + name + "' text in the signup name text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	public SignupLoginPage enterSignupEmail(String email) {
		try {
			WebElement element = waitForElementToBeClickable(SIGNUP_EMAIL_TEXTBOX_LOCATOR);
			element.sendKeys(email);
			LOG.info("'" + email + "' entered in the signup email text box.");
			ReportListeners.test.log(Status.PASS, "'" + email + "' entered in the signup email text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + email + "' text in the signup email text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + email + "' text in the signup email text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	public SignupPage clickSignup() {
		try {
			WebElement element = waitForElementToBeClickable(SIGNUP_BUTTON_LOCATOR);
			element.click();
			LOG.info("Clicked on the Signup button.");
			ReportListeners.test.log(Status.PASS, "Clicked on the Signup button.");
			return new SignupPage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on Signup button. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to click on Signup button. Error occured : " + e.getMessage());
			return null;
		}
	}

	public boolean isSignupErrorVisible() {
		try {
			WebElement element = waitForElementToBeVisible(SIGNUP_ERROR_LABEL_LOCATOR);
			LOG.info("Signup error label is displayed on the Signup / login page");
			ReportListeners.test.log(Status.PASS, "Signup error label is displayed on the Signup / login page");
			return element.isDisplayed();
		} catch (Exception e) {
			LOG.error("Signup error lable not displayed on the Signup / login page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Signup error lable not displayed on the Signup / login page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getSignupErrorText() {
		try {
			WebElement element = waitForElementToBeVisible(SIGNUP_ERROR_LABEL_LOCATOR);
			LOG.info("Signup error text retrived is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS, "Signup error text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			LOG.error("Unable to retrive Signup error text on the Signup / login page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive Signup error text on the Signup / login page. Error occured : " + e.getMessage());
			return "Unable to retrive Signup error text on the Signup / login page.";
		}
	}

	public HomePage clickHomeLink() {
		try {
			WebElement element = waitForElementToBeVisible(HOME_LINK_LOCATOR);
			element.click();
			LOG.info("Clicked on Home Link.");
			ReportListeners.test.log(Status.PASS, "Clicked on Home Link.");
			return new HomePage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on Home Link." + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to click on Home Link." + e.getMessage());
			return null;
		}
	}
}