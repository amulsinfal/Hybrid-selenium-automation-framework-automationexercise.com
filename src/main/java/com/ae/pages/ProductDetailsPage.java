package com.ae.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ae.base.BasePage;
import com.ae.listeners.ReportListeners;
import com.aventstack.extentreports.Status;

public class ProductDetailsPage extends BasePage {

	private static final Logger LOG = LogManager.getLogger(ProductDetailsPage.class);
	private static final By QUANTITY_TEXTBOX_LOCATOR = By.id("quantity");
	private static final By ADD_TO_CART_BUTTON_LOCATOR = By.xpath("//button[@class='btn btn-default cart']");
	private static final By VIEW_CART_LINK_LOCATOR = By.xpath("//a[@href='/view_cart']/u");
	private static final By WRITE_REVIEW_LINK_LOCATOR = By.xpath("//a[@href='#reviews']");

	private static final By PRODUCT_NAME_LABEL_LOCATOR = By.xpath("//div[@class='product-information']/h2");
	private static final By PRODUCT_CATEGORY_LABEL_LOCATOR = By.xpath("//div[@class='product-information']/p");
	private static final By PRODUCT_PRICE_LABEL_LOCATOR = By.xpath("//div[@class='product-information']/span/span");
	private static final By PRODUCT_AVAILABILITY_LABEL_LOCATOR = By.xpath("//div[@class='product-information']/p[2]");
	private static final By PRODUCT_CONDITION_LABEL_LOCATOR = By.xpath("//div[@class='product-information']/p[3]");
	private static final By PRODUCT_BRAND_LABEL_LOCATOR = By.xpath("//div[@class='product-information']/p[4]");
	
	
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isProductDetailsPageVisible() {
		try {
			WebElement element = waitForElementToBeVisible(WRITE_REVIEW_LINK_LOCATOR);
			LOG.info("Product Details page is visible.");
			ReportListeners.test.log(Status.PASS, "Product Details page is visible.");
			return element.isDisplayed();
		} catch (Exception e) {
			LOG.error("Product Details page not displayed. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Product Details page not displayed. Error occured : " + e.getMessage());
			return false;
		}
	}

	public ProductDetailsPage selectQuantity(String quantity) {
		try {
			WebElement element = waitForElementToBeClickable(QUANTITY_TEXTBOX_LOCATOR);
			element.clear();
			LOG.info("Quantity text box cleared.");
			ReportListeners.test.log(Status.PASS, "Quantity text box cleared.");
			element.sendKeys(quantity);
			LOG.info("'" + quantity + "' entered in the quantity text box.");
			ReportListeners.test.log(Status.PASS, "'" + quantity + "' entered in the quantity text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + quantity + "' text in the quantity text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + quantity + "' text in the quantity text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	public ProductDetailsPage clickAddToCart() {
		try {
			WebElement element = waitForElementToBeClickable(ADD_TO_CART_BUTTON_LOCATOR);
			element.click();
			element.click();
			LOG.info("Clicked on the Add to Cart button.");
			ReportListeners.test.log(Status.PASS, "Clicked on the Add to Cart button.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to click on Add to Cart button. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to click on Add to Cart button. Error occured : " + e.getMessage());
			return null;
		}
	}

	public CartPage clickViewCartLink() {
		try {
			WebElement element = waitForElementToBeClickable(VIEW_CART_LINK_LOCATOR);
			element.click();
			LOG.info("Clicked on the View Cart button.");
			ReportListeners.test.log(Status.PASS, "Clicked on the View Cart button.");
			return new CartPage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on View Cart button. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to click on View Cart button. Error occured : " + e.getMessage());
			return null;
		}
	}
	
	public String getProductName() {
		try {
			WebElement element = waitForElementToBeClickable(PRODUCT_NAME_LABEL_LOCATOR);
			LOG.info("Product Name retrived is '" + element.getText() + "'.");
			ReportListeners.test.log(Status.PASS, "Product Name retrived is '" + element.getText() + "'.");
			return element.getText();
		} catch (Exception e) {
			LOG.error("Unable to retrive Product Name on the Product details page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive Product Name on the Product details page. Error occured : " + e.getMessage());
			return "Unable to retrive Product Name on the Product details page.";
		}
	}
	
	public String getProductCategory() {
		try {
			WebElement element = waitForElementToBeClickable(PRODUCT_CATEGORY_LABEL_LOCATOR);
			LOG.info("Product category retrived is '" + element.getText().split(":")[1].trim() + "'.");
			ReportListeners.test.log(Status.PASS, "Product category retrived is '" + element.getText().split(":")[1].trim() + "'.");
			return element.getText().split(":")[1].toString().trim();
		} catch (Exception e) {
			LOG.error("Unable to retrive Product category on the Product details page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive Product category on the Product details page. Error occured : " + e.getMessage());
			return "Unable to retrive Product category on the Product details page.";
		}
	}
	
	public String getProductPrice() {
		try {
			WebElement element = waitForElementToBeClickable(PRODUCT_PRICE_LABEL_LOCATOR);
			LOG.info("Product Price retrived is '" + element.getText().split("\\s")[1] + "'.");
			ReportListeners.test.log(Status.PASS, "Product Price retrived is '" + element.getText().split("\\s")[1] + "'.");
			return element.getText().split("\\s")[1];
		} catch (Exception e) {
			LOG.error("Unable to retrive Product Price on the Product details page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive Product Price on the Product details page. Error occured : " + e.getMessage());
			return "Unable to retrive Product Price on the Product details page.";
		}
	}
	
	public String getProductAvailability() {
		try {
			WebElement element = waitForElementToBeClickable(PRODUCT_AVAILABILITY_LABEL_LOCATOR);
			LOG.info("Product Availability retrived is '" + element.getText().split(":")[1].trim() + "'.");
			ReportListeners.test.log(Status.PASS, "Product Availability retrived is '" + element.getText().split(":")[1].trim() + "'.");
			return element.getText().split(":")[1].toString().trim();
		} catch (Exception e) {
			LOG.error("Unable to retrive Product Availability on the Product details page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive Product Availability on the Product details page. Error occured : " + e.getMessage());
			return "Unable to retrive Product Availability on the Product details page.";
		}
	}
	
	public String getProductCondition() {
		try {
			WebElement element = waitForElementToBeClickable(PRODUCT_CONDITION_LABEL_LOCATOR);
			LOG.info("Product Condition retrived is '" + element.getText().split(":")[1].trim() + "'.");
			ReportListeners.test.log(Status.PASS, "Product Condition retrived is '" + element.getText().split(":")[1].trim() + "'.");
			return element.getText().split(":")[1].toString().trim();
		} catch (Exception e) {
			LOG.error("Unable to retrive Product Condition on the Product details page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive Product Condition on the Product details page. Error occured : " + e.getMessage());
			return "Unable to retrive Product Condition on the Product details page.";
		}
	}
	
	public String getProductBrand() {
		try {
			WebElement element = waitForElementToBeClickable(PRODUCT_BRAND_LABEL_LOCATOR);
			LOG.info("Product Brand retrived is '" + element.getText().split(":")[1].trim() + "'.");
			ReportListeners.test.log(Status.PASS, "Product Brand retrived is '" + element.getText().split(":")[1].trim() + "'.");
			return element.getText().split(":")[1].toString().trim();
		} catch (Exception e) {
			LOG.error("Unable to retrive Product Brand on the Product details page. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to retrive Product Brand on the Product details page. Error occured : " + e.getMessage());
			return "Unable to retrive Product Brand on the Product details page.";
		}
	}
}