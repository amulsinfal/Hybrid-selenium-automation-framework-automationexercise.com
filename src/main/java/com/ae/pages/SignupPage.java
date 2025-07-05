package com.ae.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ae.base.BasePage;
import com.ae.listeners.ReportListeners;
import com.ae.objects.CustomerAccountInformation;
import com.ae.objects.CustomerAddressInformation;
import com.ae.objects.Customers;
import com.aventstack.extentreports.Status;

public class SignupPage extends BasePage {

	private static final Logger LOG = LogManager.getLogger(SignupPage.class);
	private static final By PASSWORD_TEXTBOX_LOCATOR = By.id("password");
	private static final By DAYS_DROPDOWN_LOCATOR = By.id("days");
	private static final By MONTHS_DROPDOWN_LOCATOR = By.id("months");
	private static final By YEARS_DROPDOWN_LOCATOR = By.id("years");
	private static final By NEWSLETTER_CHECKBOX_LOCATOR = By.id("newsletter");
	private static final By SPECIAL_OFFER_CHECKBOX_LOCATOR = By.id("optin");
	private static final By FIRSTNAME_TEXTBOX_LOCATOR = By.id("first_name");
	private static final By LASTNAME_TEXTBOX_LOCATOR = By.id("last_name");
	private static final By COMPANY_TEXTBOX_LOCATOR = By.id("company");
	private static final By ADDRESS1_TEXTBOX_LOCATOR = By.id("address1");
	private static final By ADDRESS2_TEXTBOX_LOCATOR = By.id("address2");
	private static final By COUNTRY_DROPDOWN_LOCATOR = By.id("country");
	private static final By STATE_TEXTBOX_LOCATOR = By.id("state");
	private static final By CITY_TEXTBOX_LOCATOR = By.id("city");
	private static final By ZIPCODE_TEXTBOX_LOCATOR = By.id("zipcode");
	private static final By MOBILE_TEXTBOX_LOCATOR = By.id("mobile_number");
	private static final By CREATE_ACCOUNT_BUTTON_LOCATOR= By.xpath("//button[@data-qa='create-account']");
	private static final By ENTER_ACC_INFO_LABEL_LOCATOR = By.xpath("//div[@class='login-form']/h2/b");

	public SignupPage(WebDriver driver) {
		super(driver);
	}

	private SignupPage selectTitle(String title) {
		try {
			String xpathString = "//input[@name='title' and @value='" + title + "']";
			WebElement element = waitForElementToBeClickable(By.xpath(xpathString));
			element.click();
			LOG.info("Clicked on the title: " + title);
			ReportListeners.test.log(Status.PASS, "Clicked on the title: " + title);
			return this;
		} catch (Exception e) {
			LOG.error("Unable to click on the title: " + title + ". Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to click on the title: " + title + ". Error occured : " + e.getMessage());
			return this;
		}
	}

	public SignupPage enterPassword(String password) {
		try {
			WebElement element = waitForElementToBeClickable(PASSWORD_TEXTBOX_LOCATOR);
			element.sendKeys(password);
			LOG.info("'" + password + "' entered in the password text box.");
			ReportListeners.test.log(Status.PASS, "'" + password + "' entered in the password text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + password + "' text in the password text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + password + "' text in the password text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	private SignupPage selectDay(String day) {
		try {
			WebElement element = waitForElementToBeClickable(DAYS_DROPDOWN_LOCATOR);
			Select select = new Select(element);
			select.selectByVisibleText(day);
			LOG.info("'" + day + "' selected in the day dropdown list box.");
			ReportListeners.test.log(Status.PASS, "'" + day + "' selected in the day dropdown list box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to select '" + day + "' text in the the day dropdown list box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to select '" + day + "' text in the the day dropdown list box. Error occured : " + e.getMessage());
			return this;
		}
	}

	private SignupPage selectMonth(String month) {
		try {
			WebElement element = waitForElementToBeClickable(MONTHS_DROPDOWN_LOCATOR);
			Select select = new Select(element);
			select.selectByVisibleText(month);
			LOG.info("'" + month + "' selected in the month dropdown list box.");
			ReportListeners.test.log(Status.PASS, "'" + month + "' selected in the month dropdown list box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to select '" + month + "' text in the the month dropdown list box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to select '" + month + "' text in the the month dropdown list box. Error occured : " + e.getMessage());
			return this;
		}
	}

	private SignupPage selectYear(String year) {
		try {
			WebElement element = waitForElementToBeClickable(YEARS_DROPDOWN_LOCATOR);
			Select select = new Select(element);
			select.selectByVisibleText(year);
			LOG.info("'" + year + "' selected in the year dropdown list box.");
			ReportListeners.test.log(Status.PASS, "'" + year + "' selected in the year dropdown list box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to select '" + year + "' text in the the year dropdown list box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to select '" + year + "' text in the the year dropdown list box. Error occured : " + e.getMessage());
			return this;
		}
	}

	public SignupPage selectNewsLetter(String value) {
		try {
			WebElement element = waitForElementToBeClickable(NEWSLETTER_CHECKBOX_LOCATOR);
			if (value.equalsIgnoreCase("Yes")) {
				element.click();
				LOG.info("NewsLetter checkbox selected.");
				ReportListeners.test.log(Status.PASS, "NewsLetter checkbox selected.");
			} else {
				LOG.info("NewsLetter checkbox not selected.");
				ReportListeners.test.log(Status.PASS, "NewsLetter checkbox not selected.");
			}
			return this;
		} catch (Exception e) {
			LOG.error("Unable to click on the newletters checkbox. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to click on the newletters checkbox. Error occured : " + e.getMessage());
			return this;
		}
	}

	public SignupPage selectSpecialOffer(String value) {
		try {
			WebElement element = waitForElementToBeClickable(SPECIAL_OFFER_CHECKBOX_LOCATOR);
			if (value.equalsIgnoreCase("Yes")) {
				element.click();
				LOG.info("Speical offer checkbox selected.");
				ReportListeners.test.log(Status.PASS, "Speical offer checkbox selected.");
			} else {
				LOG.info("Speical offer checkbox not selected.");
				ReportListeners.test.log(Status.PASS, "Speical offer checkbox not selected.");
			}
			return this;
		} catch (Exception e) {
			LOG.error("Unable to click on the Speical offer checkbox. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to click on the Speical offer checkbox. Error occured : " + e.getMessage());
			return this;
		}
	}

	private SignupPage enterFirstName(String firstName) {
		try {
			WebElement element = waitForElementToBeClickable(FIRSTNAME_TEXTBOX_LOCATOR);
			element.sendKeys(firstName);
			LOG.info("'" + firstName + "' entered in the firstName text box.");
			ReportListeners.test.log(Status.PASS, "'" + firstName + "' entered in the firstName text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + firstName + "' text in the firstName text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + firstName + "' text in the firstName text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	private SignupPage enterLastName(String lastName) {
		try {
			WebElement element = waitForElementToBeClickable(LASTNAME_TEXTBOX_LOCATOR);
			element.sendKeys(lastName);
			LOG.info("'" + lastName + "' entered in the lastName text box.");
			ReportListeners.test.log(Status.PASS, "'" + lastName + "' entered in the lastName text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + lastName + "' text in the lastName text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + lastName + "' text in the lastName text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	private SignupPage enterCompany(String company) {
		try {
			WebElement element = waitForElementToBeClickable(COMPANY_TEXTBOX_LOCATOR);
			element.sendKeys(company);
			LOG.info("'" + company + "' entered in the company text box.");
			ReportListeners.test.log(Status.PASS, "'" + company + "' entered in the company text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + company + "' text in the company text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + company + "' text in the company text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	private SignupPage enterAddress1(String address1) {
		try {
			WebElement element = waitForElementToBeClickable(ADDRESS1_TEXTBOX_LOCATOR);
			element.sendKeys(address1);
			LOG.info("'" + address1 + "' entered in the address1 text box.");
			ReportListeners.test.log(Status.PASS, "'" + address1 + "' entered in the address1 text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + address1 + "' text in the address1 text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + address1 + "' text in the address1 text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	private SignupPage enterAddress2(String address2) {
		try {
			WebElement element = waitForElementToBeClickable(ADDRESS2_TEXTBOX_LOCATOR);
			element.sendKeys(address2);
			LOG.info("'" + address2 + "' entered in the address2 text box.");
			ReportListeners.test.log(Status.PASS, "'" + address2 + "' entered in the address2 text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + address2 + "' text in the address2 text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + address2 + "' text in the address2 text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	private SignupPage selectCountry(String country) {
		try {
			WebElement element = waitForElementToBeClickable(COUNTRY_DROPDOWN_LOCATOR);
			Select select = new Select(element);
			select.selectByVisibleText(country);
			LOG.info("'" + country + "' selected in the country dropdown list box.");
			ReportListeners.test.log(Status.PASS, "'" + country + "' selected in the country dropdown list box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to select '" + country + "' text in the the country dropdown list box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to select '" + country + "' text in the the country dropdown list box. Error occured : " + e.getMessage());
			return this;
		}
	}

	private SignupPage enterState(String state) {
		try {
			WebElement element = waitForElementToBeClickable(STATE_TEXTBOX_LOCATOR);
			element.sendKeys(state);
			LOG.info("'" + state + "' entered in the state text box.");
			ReportListeners.test.log(Status.PASS, "'" + state + "' entered in the state text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + state + "' text in the state text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + state + "' text in the state text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	private SignupPage enterCity(String city) {
		try {
			WebElement element = waitForElementToBeClickable(CITY_TEXTBOX_LOCATOR);
			element.sendKeys(city);
			LOG.info("'" + city + "' entered in the city text box.");
			ReportListeners.test.log(Status.PASS, "'" + city + "' entered in the city text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + city + "' text in the city text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + city + "' text in the city text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	private SignupPage enterZipcode(String zipcode) {
		try {
			WebElement element = waitForElementToBeClickable(ZIPCODE_TEXTBOX_LOCATOR);
			element.sendKeys(zipcode);
			LOG.info("'" + zipcode + "' entered in the zipcode text box.");
			ReportListeners.test.log(Status.PASS, "'" + zipcode + "' entered in the zipcode text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + zipcode + "' text in the zipcode text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + zipcode + "' text in the zipcode text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	private SignupPage enterMobile(String mobileNumber) {
		try {
			WebElement element = waitForElementToBeClickable(MOBILE_TEXTBOX_LOCATOR);
			element.sendKeys(mobileNumber);
			LOG.info("'" + mobileNumber + "' entered in the mobile number text box.");
			ReportListeners.test.log(Status.PASS, "'" + mobileNumber + "' entered in the mobile number text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + mobileNumber + "' text in the mobile number text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + mobileNumber + "' text in the mobile number text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	public AccountCreatedPage clickCreateAccount() {
		try {
			WebElement element = waitForElementToBeClickable(CREATE_ACCOUNT_BUTTON_LOCATOR);
			element.click();
			LOG.info("Clicked on the Create Account button.");
			ReportListeners.test.log(Status.PASS, "Clicked on the Create Account button.");
			LOG.info("Navigating to Account created page.");
			ReportListeners.test.log(Status.PASS, "Navigating to Account created page.");
			return new AccountCreatedPage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on Craete Account button. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to click on Craete Account button. Error occured : " + e.getMessage());
			return null;
		}
	}

	public SignupPage fillCustomerAccountInformation(CustomerAccountInformation customerAccountInformation) {
		return selectTitle(customerAccountInformation.getTitle()).enterPassword(customerAccountInformation.getPassword()).selectDay(customerAccountInformation.getDay())
				.selectMonth(customerAccountInformation.getMonth()).selectYear(customerAccountInformation.getYear());
	}
	
	public SignupPage fillCustomerAddressInformation(CustomerAddressInformation customerAddressInformation) {
		return enterFirstName(customerAddressInformation.getFirstName()).enterLastName(customerAddressInformation.getLastName())
				.enterCompany(customerAddressInformation.getCompany()).enterAddress1(customerAddressInformation.getAddress1())
				.enterAddress2(customerAddressInformation.getAddress2()).selectCountry(customerAddressInformation.getCountry())
				.enterState(customerAddressInformation.getState()).enterCity(customerAddressInformation.getCity()).enterZipcode(customerAddressInformation.getZipcode())
				.enterMobile(customerAddressInformation.getMobileNumber());
	}

	public SignupPage fillCustomerInformation(Customers customer) {
		return selectTitle(customer.getTitle()).enterPassword(customer.getPassword()).selectDay(customer.getDay())
				.selectMonth(customer.getMonth()).selectYear(customer.getYear())
				.selectNewsLetter(customer.getNewsletter()).selectSpecialOffer(customer.getSpecialOffer())
				.enterFirstName(customer.getFirstName()).enterLastName(customer.getLastName())
				.enterCompany(customer.getCompany()).enterAddress1(customer.getAddress1())
				.enterAddress2(customer.getAddress2()).selectCountry(customer.getCountry())
				.enterState(customer.getState()).enterCity(customer.getCity()).enterZipcode(customer.getZipcode())
				.enterMobile(customer.getMobileNumber());
	}

	public boolean isEnterAccountInformationLabelVisible() {
		try {
			WebElement element = waitForElementToBeVisible(ENTER_ACC_INFO_LABEL_LOCATOR);
			LOG.info("Account information header is displayed on the Signup page");
			ReportListeners.test.log(Status.PASS, "Account information header is displayed on the Signup page");
			return element.isDisplayed();
		} catch (Exception e) {
			LOG.error("Account information header not displayed on the Signup page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Account information header not displayed on the Signup page. Error occured : " + e.getMessage());
			return false;
		}
	}

	public String getEnterAccountInformationLabelText() {
		try {
			WebElement element = waitForElementToBeVisible(ENTER_ACC_INFO_LABEL_LOCATOR);
			LOG.info("Account information header text retrived is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS, "Account information header text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			LOG.error("Unable to retrive Account information header text on the Signup page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive Account information header text on the Signup page. Error occured : " + e.getMessage());
			return "Unable to retrive Account information header text on the Signup page.";
		}
	}

}