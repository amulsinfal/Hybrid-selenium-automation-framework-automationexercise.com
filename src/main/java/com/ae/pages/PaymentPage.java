package com.ae.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ae.base.BasePage;
import com.ae.listeners.ReportListeners;
import com.ae.objects.Payments;
import com.aventstack.extentreports.Status;

public class PaymentPage extends BasePage {

	private static final Logger LOG = LogManager.getLogger(HomePage.class);
	private static final By NAME_TEXTBOX_LOCATOR = By.name("name_on_card");
	private static final By CARD_NUMBER_TEXTBOX_LOCATOR = By.name("card_number");
	private static final By CARD_CVC_TEXTBOX_LOCATOR = By.name("cvc");
	private static final By EXPIRY_MONTH_TEXTBOX_LOCATOR = By.name("expiry_month");
	private static final By EXPIRY_YEAR_TEXTBOX_LOCATOR = By.name("expiry_year");
	private static final By PAY_CONFIRM_BUTTON_LOCATOR = By.id("submit");
	private static final By SUCCESS_MESSAGE_LABEL_LOCATOR= By.xpath("//div[@id='success_message']/div[@class='alert-success alert']");

	public PaymentPage(WebDriver driver) {
		super(driver);
	}

	private PaymentPage enterNameOnCard(String name) {
		try {
			WebElement element = waitForElementToBeClickable(NAME_TEXTBOX_LOCATOR);
			element.sendKeys(name);
			LOG.info("'" + name + "' entered in the Name on card text box.");
			ReportListeners.test.log(Status.PASS, "'" + name + "' entered in the Name on card text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + name + "' text in the Name on card text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + name + "' text in the Name on card text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	private PaymentPage enterCardNumber(String cardNumber) {
		try {
			WebElement element = waitForElementToBeClickable(CARD_NUMBER_TEXTBOX_LOCATOR);
			element.sendKeys(cardNumber);
			LOG.info("'" + cardNumber + "' entered in the Card number text box.");
			ReportListeners.test.log(Status.PASS, "'" + cardNumber + "' entered in the Card number text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + cardNumber + "' text in the Card number text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + cardNumber + "' text in the Card number text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	private PaymentPage enterCvc(String cvc) {
		try {
			WebElement element = waitForElementToBeClickable(CARD_CVC_TEXTBOX_LOCATOR);
			element.sendKeys(cvc);
			LOG.info("'" + cvc + "' entered in the cvc text box.");
			ReportListeners.test.log(Status.PASS, "'" + cvc + "' entered in the cvc text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + cvc + "' text in the cvc text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + cvc + "' text in the cvc text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	private PaymentPage enterExpiryMonth(String expiryMonth) {
		try {
			WebElement element = waitForElementToBeClickable(EXPIRY_MONTH_TEXTBOX_LOCATOR);
			element.sendKeys(expiryMonth);
			LOG.info("'" + expiryMonth + "' entered in the Expiry Month text box.");
			ReportListeners.test.log(Status.PASS, "'" + expiryMonth + "' entered in the Expiry Month text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + expiryMonth + "' text in the Expiry Month text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + expiryMonth + "' text in the Expiry Month text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	private PaymentPage enterExpiryYear(String expiryYear) {
		try {
			WebElement element = waitForElementToBeClickable(EXPIRY_YEAR_TEXTBOX_LOCATOR);
			element.sendKeys(expiryYear);
			LOG.info("'" + expiryYear + "' entered in the Expiry Year text box.");
			ReportListeners.test.log(Status.PASS, "'" + expiryYear + "' entered in the Expiry Year text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + expiryYear + "' text in the Expiry Year text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + expiryYear + "' text in the Expiry Year text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	public PaymentDonePage clickPayAndConfirmOrder() {
		try {
			WebElement element = waitForElementToBeClickable(PAY_CONFIRM_BUTTON_LOCATOR);
			element.click();
			LOG.info("Clicked on the Pay And Confirm Order button.");
			LOG.info("Navigating to Home page.");
			ReportListeners.test.log(Status.PASS, "Clicked on the Pay And Confirm Order button.");
			ReportListeners.test.log(Status.PASS, "Navigating to Home page.");
			return new PaymentDonePage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on Login button. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to click on Login button. Error occured : " + e.getMessage());
			return null;
		}
	}

	public PaymentPage fillCardDetails(Payments payment) {
		return enterNameOnCard(payment.getNameOnCard()).enterCardNumber(payment.getCardNumber())
				.enterCvc(payment.getCvc()).enterExpiryMonth(payment.getExpiryMonth())
				.enterExpiryYear(payment.getExpiryYear());
	}

	public boolean isOrderSuccessMessageVisible() {
		try {
			WebElement element = waitForElementToBeVisible(SUCCESS_MESSAGE_LABEL_LOCATOR);
			LOG.info("Order Placed success message header is displayed on the Payment done page");
			ReportListeners.test.log(Status.PASS, "Order Placed success message header is displayed on the Payment done page");
			return element.isDisplayed();
		} catch (Exception e) {
			LOG.error("Order Placed success message header not displayed on the Payment done page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Order Placed success message header not displayed on the Payment done page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getOrderSuccessMessageText() {
		try {
			WebElement element = waitForElementToBeVisible(SUCCESS_MESSAGE_LABEL_LOCATOR);
			LOG.info("Order Placed success message text retrived is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS, "Order Placed success message text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			LOG.error("Unable to retrive Order Placed success message text on the Payment done page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive Order Placed success message text on the Payment done page. Error occured : " + e.getMessage());
			return "Unable to retrive Order Placed success message text on the Payment done page.";
		}
	}

}