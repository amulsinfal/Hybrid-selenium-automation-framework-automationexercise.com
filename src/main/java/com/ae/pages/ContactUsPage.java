package com.ae.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ae.base.BasePage;
import com.ae.listeners.ReportListeners;
import com.ae.objects.Messages;
import com.aventstack.extentreports.Status;

public class ContactUsPage extends BasePage {

	private static final Logger LOG = LogManager.getLogger(ContactUsPage.class);
	private static final By GET_IN_TOUCH_LABEL_LOCATOR = By.xpath("//div[@class='contact-form']/child::h2");
	private static final By NAME_TEXTBOX_LOCATOR = By.name("name");
	private static final By EMAIL_TEXTBOX_LOCATOR = By.name("email");
	private static final By SUBJECT_TEXTBOX_LOCATOR = By.name("subject");
	private static final By MESSAGE_TEXTBOX_LOCATOR = By.id("message");
	private static final By UPLOAD_TEXTBOX_LOCATOR = By.name("upload_file");
	private static final By SUBMIT_BUTTON_LOCATOR = By.name("submit");
	private static final By SUCCESS_MESSAGE_LABEL_LOCATOR = By.xpath("//div[@class='status alert alert-success']");
	private static final By HOME_BUTTON_LOCATOR = By.xpath("//a[@class='btn btn-success']/span/i");

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	private ContactUsPage enterName(String name) {
		try {
			WebElement element = waitForElementToBeClickable(NAME_TEXTBOX_LOCATOR);
			element.sendKeys(name);
			LOG.info("'" + name + "' entered in the name text box.");
			ReportListeners.test.log(Status.PASS, "'" + name + "' entered in the name text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + name + "' text in the name text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + name + "' text in the name text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	private ContactUsPage enterEmail(String email) {
		try {
			WebElement element = waitForElementToBeClickable(EMAIL_TEXTBOX_LOCATOR);
			element.sendKeys(email);
			LOG.info("'" + email + "' entered in the email text box.");
			ReportListeners.test.log(Status.PASS, "'" + email + "' entered in the email text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + email + "' text in the email text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + email + "' text in the email text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	private ContactUsPage enterSubject(String subject) {
		try {
			WebElement element = waitForElementToBeClickable(SUBJECT_TEXTBOX_LOCATOR);
			element.sendKeys(subject);
			LOG.info("'" + subject + "' entered in the subject text box.");
			ReportListeners.test.log(Status.PASS, "'" + subject + "' entered in the subject text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + subject + "' text in the subject text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + subject + "' text in the subject text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	private ContactUsPage enterMessage(String Message) {
		try {
			WebElement element = waitForElementToBeClickable(MESSAGE_TEXTBOX_LOCATOR);
			element.sendKeys(Message);
			LOG.info("'" + Message + "' entered in the Message text box.");
			ReportListeners.test.log(Status.PASS, "'" + Message + "' entered in the Message text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + Message + "' text in the Message text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + Message + "' text in the Message text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	public ContactUsPage enterFilePath(String filePath) {
		try {
			WebElement element = waitForElementToBeClickable(UPLOAD_TEXTBOX_LOCATOR);
			element.sendKeys(filePath);
			LOG.info("'" + filePath + "' entered in the choose file text box.");
			ReportListeners.test.log(Status.PASS, "'" + filePath + "' entered in the choose file text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + filePath + "' text in the choose file text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + filePath + "' text in the choose file text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	public ContactUsPage clickSubmit() {
		try {
			WebElement element = waitForElementToBeClickable(SUBMIT_BUTTON_LOCATOR);
			element.click();
			LOG.info("Clicked on the Submit button.");
			ReportListeners.test.log(Status.PASS, "Clicked on the Submit button.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to click on Submit button. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to click on Submit button. Error occured : " + e.getMessage());
			return null;
		}
	}

	public boolean isGetInTouchLabelVisible() {
		try {
			WebElement element = waitForElementToBeVisible(GET_IN_TOUCH_LABEL_LOCATOR);
			LOG.info("Contact us form header is displayed on the Contact us page");
			ReportListeners.test.log(Status.PASS, "Contact us form header is displayed on the Contact us page");
			return element.isDisplayed();
		} catch (Exception e) {
			LOG.error("Contact us form header not displayed on the Contact us page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Contact us form header not displayed on the Contact us page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getGetInTouchText() {
		try {
			WebElement element = waitForElementToBeVisible(GET_IN_TOUCH_LABEL_LOCATOR);
			LOG.info("Contact us form header text retrived is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS, "Contact us form header text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			LOG.error("Unable to retrive Contact us form header text on the Contact us page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive Contact us form header text on the Contact us page. Error occured : " + e.getMessage());
			return "Unable to retrive Contact us form header text on the Contact us page.";
		}
	}

	public ContactUsPage fillContactForm(Messages message) {
		return enterName(message.getName()).enterEmail(message.getEmail()).enterSubject(message.getSubject())
				.enterMessage(message.getMessage());
	}

	public HomePage clickHome() {
		try {
			WebElement element = waitForElementToBeClickable(HOME_BUTTON_LOCATOR);
			element.click();
			LOG.info("Clicked on the Home button.");
			ReportListeners.test.log(Status.PASS, "Clicked on the Home button.");
			return new HomePage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on Home button. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to click on Home button. Error occured : " + e.getMessage());
			return null;
		}
	}

	public boolean isSuccessMessageVisible() {
		try {
			WebElement element = waitForElementToBeVisible(SUCCESS_MESSAGE_LABEL_LOCATOR);
			LOG.info("Success message is displayed on the Contact us page");
			ReportListeners.test.log(Status.PASS, "Success message is displayed on the Contact us page");
			return element.isDisplayed();
		} catch (Exception e) {
			LOG.error("Success message is not displayed on the Contact us page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Success message is not displayed on the Contact us page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getSuccessMessageText() {
		try {
			WebElement element = waitForElementToBeVisible(SUCCESS_MESSAGE_LABEL_LOCATOR);
			LOG.info("Success message text on Contact us page retrived is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS, "Success message text on Contact us page retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			LOG.error("Unable to retrive Success message text on Contact us page . Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive Success message text on Contact us page . Error occured : " + e.getMessage());
			return "Unable to retrive Success message text on Contact us page .";
		}
	}
	
	public ContactUsPage clickOkOnAlert() {
		acceptAlert();
		return this;
	}
	
	public ContactUsPage clickDismissOnAlert() {
		dismissAlert();
		return this;
	}

}