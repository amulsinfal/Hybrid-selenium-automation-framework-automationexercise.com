package com.ae.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ae.base.BasePage;
import com.ae.listeners.ReportListeners;
import com.aventstack.extentreports.Status;

public class CheckoutPage extends BasePage{

	private static final Logger LOG = LogManager.getLogger(CheckoutPage.class);
	private static final By COMMENT_TEXTBOX_LOCATOR = By.name("message");
	private static final By PLACE_ORDER_BUTTON_LOCATOR = By.xpath("//a[@href='/payment']");
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	public String getCustomerName() {
		try {
            WebElement element = waitForElementToBeVisible(By.xpath("(//ul[@id='address_delivery']/li)[2]"));
			LOG.info("Customer name text retrived is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS, "Customer name text retrived is '" + element.getText() + "'.");
    		return element.getText();
		} catch (Exception e) {
			LOG.info("Unable to retrive Customer name text. Error occured : " +e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive Customer name text. Error occured : " +e.getMessage());
            return "Unable to retrive Customer name text.";
		}
	}
	
	public String getCustomerCompany() {
		try {
            WebElement element = waitForElementToBeVisible(By.xpath("(//ul[@id='address_delivery']/li)[3]"));
			LOG.info("Customer company name text retrived is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS, "Customer company name text retrived is '" + element.getText() + "'.");
    		return element.getText();
		} catch (Exception e) {
			LOG.info("Unable to retrive Customer company name text. Error occured : " +e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive Customer company name text. Error occured : " +e.getMessage());
            return "Unable to retrive Customer company name text.";
		}
	}
	
	public String getCustomerAddress1() {
		try {
	        WebElement element = waitForElementToBeVisible(By.xpath("(//ul[@id='address_delivery']/li)[4]"));
			LOG.info("Customer address1 text retrived is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS, "Customer address1 text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			LOG.info("Unable to retrive Customer address1 text. Error occured : " +e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive Customer address1 text. Error occured : " +e.getMessage());
	        return "Unable to retrive Customer address1 text.";
		}
	}
	
	public String getCustomerAddress2() {
		try {
	        WebElement element = waitForElementToBeVisible(By.xpath("(//ul[@id='address_delivery']/li)[5]"));
			LOG.info("Customer address2 text retrived is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS, "Customer address2 text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			LOG.info("Unable to retrive Customer address2 text. Error occured : " +e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive Customer address2 text. Error occured : " +e.getMessage());
	        return "Unable to retrive Customer address2 text.";
		}
	}
	
	public String getCustomerCityStateZip() {
		try {
	        WebElement element = waitForElementToBeVisible(By.xpath("(//ul[@id='address_delivery']/li)[6]"));
			LOG.info("Customer City State Zipcode text retrived is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS, "Customer City State Zipcode text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			LOG.info("Unable to retrive Customer City State Zipcode text. Error occured : " +e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive Customer City State Zipcode text. Error occured : " +e.getMessage());
	        return "Unable to retrive Customer City State Zipcode text.";
		}
	}
	
	public String getCustomerCountry() {
		try {
	        WebElement element = waitForElementToBeVisible(By.xpath("(//ul[@id='address_delivery']/li)[7]"));
			LOG.info("Customer country text retrived is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS, "Customer country text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			LOG.info("Unable to retrive Customer country text. Error occured : " +e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive Customer country text. Error occured : " +e.getMessage());
	        return "Unable to retrive Customer country text.";
		}
	}
	
	public String getCustomerMobile() {
		try {
	        WebElement element = waitForElementToBeVisible(By.xpath("(//ul[@id='address_delivery']/li)[8]"));
			LOG.info("Customer mobile number text retrived is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS, "Customer mobile number text retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			LOG.info("Unable to retrive Customer mobile number text. Error occured : " +e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive Customer mobile number text. Error occured : " +e.getMessage());
	        return "Unable to retrive Customer mobile number text.";
		}
	}
	
	public CheckoutPage enterComment(String comment) {
		try {
			WebElement element = waitForElementToBeClickable(COMMENT_TEXTBOX_LOCATOR);
			element.sendKeys(comment);
			LOG.info("'" + comment + "' entered in the comment text box.");
			ReportListeners.test.log(Status.PASS, "'" + comment + "' entered in the comment text box.");
			return this;
		} catch (Exception e) {
			LOG.info("Unable to enter '" + comment + "' text in the comment text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + comment + "' text in the comment text box. Error occured : " + e.getMessage());
			return this;
		}
	}
	
	public PaymentPage clickPlaceOrder() {
		try {
			WebElement element = waitForElementToBeClickable(PLACE_ORDER_BUTTON_LOCATOR);
			element.click();
			LOG.info("Clicked on Place Order button.");
			ReportListeners.test.log(Status.PASS, "Clicked on Place Order button.");
			return new PaymentPage(driver);
		} catch (Exception e) {
			LOG.info("Unable to click on Place Order button.");
			ReportListeners.test.log(Status.FAIL, "Unable to click on Place Order button.");
			return null;
		}
	}

	public String getProductPrice(String productName) {
		try {
			String xpathString = "//div[@id='cart_info']//tbody/tr/td[2]/h4/a[text()='" + productName
					+ "']/ancestor::td/following-sibling::td[@class='cart_price']";
			WebElement element = waitForElementToBeVisible(By.xpath(xpathString));
			LOG.info("Price of '" + productName + "' is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS, "Price of '" + productName + "' is '" + element.getText() + "'.");
			return element.getText().split(" ")[1].toString();
		} catch (Exception e) {
			LOG.info("Unable to retrive product price text. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive product price text. Error occured : " + e.getMessage());
			return "Unable to retrive product price text.";
		}
	}

	public String getProductQuantity(String productName) {
		try {
			String xpathString = "//div[@id='cart_info']//tbody/tr/td[2]/h4/a[text()='" + productName
					+ "']/ancestor::td/following-sibling::td[@class='cart_quantity']/button";
			WebElement element = waitForElementToBeVisible(By.xpath(xpathString));
			LOG.info("Quantity of '" + productName + "' is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS, "Quantity of '" + productName + "' is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			LOG.info("Unable to retrive product quantity text. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive product quantity text. Error occured : " + e.getMessage());
			return "Unable to retrive product quantity text.";
		}
	}
	
	public String getProductTotalAmount(String productName) {
		try {
			String xpathString = "//div[@id='cart_info']//tbody/tr/td[2]/h4/a[text()='" + productName
					+ "']/ancestor::td/following-sibling::td[@class='cart_total']/p[@class='cart_total_price']";
			WebElement element = waitForElementToBeVisible(By.xpath(xpathString));
			LOG.info("Total amount of '" + productName + "' is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS, "Total amount of '" + productName + "' is '" + element.getText() + "'.");
			return element.getText().split(" ")[1].toString();
		} catch (Exception e) {
			LOG.info("Unable to retrive product total amount text. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive product total amount text. Error occured : " + e.getMessage());
			return "Unable to retrive product total amount text.";
		}
	}
	
}