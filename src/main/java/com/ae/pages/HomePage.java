package com.ae.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ae.base.BasePage;
import com.ae.listeners.ReportListeners;
import com.aventstack.extentreports.Status;

public class HomePage extends BasePage {

	private static final Logger LOG = LogManager.getLogger(HomePage.class);
	private static final By SLIDER_CAROUSEL_LOCATOR = By.id("slider-carousel");
	private static final By CART_LINK_LOCATOR = By.xpath("//a[@href='/view_cart']");
	private static final By CONTINUE_SHOPPING_LOCATOR = By.xpath("//button[@class='btn btn-success close-modal btn-block']");
	private static final By SUBSCRIPTION_LABEL_LOCATOR = By.xpath("//div[@class='single-widget']/h2");
	public NavigationBar navigationBar;
	public ApplicationFooter applicationFooter;
	
	public HomePage(WebDriver driver) {
		super(driver);
		navigationBar = new NavigationBar(driver);
		applicationFooter = new ApplicationFooter(driver);
	}
	
	public NavigationBar getNavigationBar() {
		return navigationBar;
	}
	
	public ApplicationFooter getApplicationFooter() { 
		return applicationFooter;
	}

	public boolean isHomePageVisible() {
		try {
			WebElement element = waitForElementToBeVisible(SLIDER_CAROUSEL_LOCATOR);
			LOG.info("Home page is visible.");
			ReportListeners.test.log(Status.PASS, "Home page is visible.");
			return element.isDisplayed();
		} catch (Exception e) {
			LOG.error("HomePage not displayed. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "HomePage not displayed. Error occured : " + e.getMessage());
			return false;
		}
	}

	public CartPage clickCartLink() {
		try {
			WebElement element = waitForElementToBeVisible(CART_LINK_LOCATOR);
			element.click();
			LOG.info("Clicked on Cart Link.");
			ReportListeners.test.log(Status.PASS, "Clicked on Cart Link.");
			LOG.info("Navigating to Cart page.");
			ReportListeners.test.log(Status.PASS, "Navigating to Cart page.");
			return new CartPage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on Cart Link." + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to click on Cart Link." + e.getMessage());
			return null;
		}
	}

	public ProductDetailsPage clickViewProduct(String productName) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(
					By.xpath("//div[@class='productinfo text-center']/p[text()='" + productName + "']/parent::div")));
			LOG.info("Scrolling to products : " + productName);
			ReportListeners.test.log(Status.PASS, "Scrolling to products : " + productName);
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//div[@class='productinfo text-center']/p[text()='"
					+ productName
					+ "']/ancestor::div[@class='single-products']//following-sibling::div[@class='choose']/descendant::a")))
					.perform();
			LOG.info("Hovering over the product : " + productName);
			ReportListeners.test.log(Status.PASS, "Hovering over the product : " + productName);
			driver.findElement(By.xpath("//div[@class='productinfo text-center']/p[text()='" + productName
					+ "']/ancestor::div[@class='single-products']//following-sibling::div[@class='choose']/descendant::a"))
					.click();
			LOG.info("Clicking on the view product link of product : " + productName);
			ReportListeners.test.log(Status.PASS, "Clicking on the view product link of product : " + productName);
			return new ProductDetailsPage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on the view product link of product : " + productName + ". Error occured : "
					+ e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to click on the view product link of product : " + productName
					+ ". Error occured : " + e.getMessage());
			return null;
		}
	}

	// Add multiple products to cart.
	public HomePage addToCart(String[] productNames) {
		List<String> foundProducts = new ArrayList<String>();
		List<String> productNamesList = Arrays.asList(productNames);
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
		int counter = 0;
		for (int i = 0; i <= elements.size() - 1; i++) {
			if (productNamesList.contains(elements.get(i).getText())) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
						driver.findElement(By.xpath("//div[@class='productinfo text-center']/p[text()='"
								+ elements.get(i).getText() + "']/parent::div")));
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElement(By.xpath("//div[@class='productinfo text-center']/p[text()='"
						+ elements.get(i).getText() + "']/parent::div/a[@class='btn btn-default add-to-cart']")))
						.perform();
				LOG.info("Hovering over Product : '" + elements.get(i).getText() + "'.");
				ReportListeners.test.log(Status.PASS, "Hovering over Product : '" + elements.get(i).getText() + "'.");
				driver.findElement(By.xpath("//div[@class='productinfo text-center']/p[text()='"
						+ elements.get(i).getText() + "']/parent::div/following-sibling::div/div/p[text()='"
						+ elements.get(i).getText() + "']/parent::div/a[@class='btn btn-default add-to-cart']"))
						.click();
				LOG.info("Clicked on Add to cart on product : '" + elements.get(i).getText() + "'.");
				ReportListeners.test.log(Status.PASS,
						"Clicked on Add to cart on product : '" + elements.get(i).getText() + "'.");
				driver.findElement(CONTINUE_SHOPPING_LOCATOR).click();
				LOG.info("Clicked on continue shopping link.");
				ReportListeners.test.log(Status.PASS, "Clicked on continue shopping link.");
				foundProducts.add(elements.get(i).getText());
				LOG.info("Products added to cart : '" + foundProducts + "'.");
				ReportListeners.test.log(Status.PASS, "Products added to cart : '" + foundProducts + "'.");
				counter++;
				if (counter == productNames.length) {
					break;
				}
			}
		}
		return this;
	}
	
	public HomePage scrollToFooter() {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
					waitForElementToBeVisible(SUBSCRIPTION_LABEL_LOCATOR));
			LOG.info("Scrolling to footer section.");
			ReportListeners.test.log(Status.PASS, "Scrolling to footer section.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to Scroll to footer section. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL,
					"Unable to Scroll to footer section. Error occured : " + e.getMessage());
			return null;
		}
	}
}