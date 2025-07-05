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

public class ProductsPage extends BasePage {

	private static final Logger LOG = LogManager.getLogger(ProductsPage.class);
	private static final By SEARCH_TEXTBOX_LOCATOR = By.id("search_product");
	private static final By SEARCH_BUTTON_LOCATOR = By.id("submit_search");
	private static final By CONTINUE_SHOPPING_BUTTON_LOCATOR = By.xpath("//button[@class='btn btn-success close-modal btn-block']");
	private static final By CART_LINK_LOCATOR = By.xpath("//a[@href='/view_cart']");
	private static final By SALE_IMAGE_LOCATOR = By.id("sale_image");
	private static final By PRODUCT_ITEM_LOCATOR = By.xpath("//div[@class='productinfo text-center']/p");

	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	public boolean isProductsPageVisible() {
		try {
			WebElement element = waitForElementToBeVisible(SALE_IMAGE_LOCATOR);
			LOG.info("Products page is visible.");
			ReportListeners.test.log(Status.PASS, "Products page is visible.");
			return element.isDisplayed();
		} catch (Exception e) {
			LOG.error("Products page not displayed. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Products page not displayed. Error occured : " + e.getMessage());
			return false;
		}
	}

	public boolean isProductListVisible() {
		try {
			List<WebElement> elements = driver.findElements(PRODUCT_ITEM_LOCATOR);
			if (!elements.isEmpty()) {
				LOG.info("Products list are visible.");
				ReportListeners.test.log(Status.PASS, "Products list are visible.");
				return true;
			} else {
				LOG.info("Products list is visible but empty.");
				ReportListeners.test.log(Status.PASS, "Products list is visible but empty.");
				return false;
			}
		} catch (Exception e) {
			LOG.error("Products list not displayed. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Products list not displayed. Error occured : " + e.getMessage());
			return false;
		}
	}

	public ProductsPage enterSearchText(String searchItem) {
		try {
			WebElement element = waitForElementToBeClickable(SEARCH_TEXTBOX_LOCATOR);
			element.sendKeys(searchItem);
			LOG.info("'" + searchItem + "' entered in the search text box.");
			ReportListeners.test.log(Status.PASS, "'" + searchItem + "' entered in the search text box.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to enter '" + searchItem + "' text in the search text box. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to enter '" + searchItem + "' text in the search text box. Error occured : " + e.getMessage());
			return this;
		}
	}

	public ProductsPage clickSearch() {
		try {
			WebElement element = waitForElementToBeClickable(SEARCH_BUTTON_LOCATOR);
			element.click();
			LOG.info("Clicked on the Search button.");
			ReportListeners.test.log(Status.PASS, "Clicked on the Search button.");
			return this;
		} catch (Exception e) {
			LOG.error("Unable to click on search button. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to click on search button. Error occured : " + e.getMessage());
			return null;
		}
	}

	// Add multiple products to cart.
	public ProductsPage addToCart(String[] productNames) {
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
				ReportListeners.test.log(Status.PASS, "Clicked on Add to cart on product : '" + elements.get(i).getText() + "'.");
				driver.findElement(CONTINUE_SHOPPING_BUTTON_LOCATOR).click();
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

	public boolean isProductPresent(String[] productNames) {
		boolean flag = false;
		List<String> foundProducts = new ArrayList<String>();
		List<String> missingProducts = new ArrayList<String>();
		for (String productName : productNames) {
			if (!driver
					.findElements(By.xpath(
							"//div[@class='productinfo text-center']/p[text()='" + productName + "']/parent::div"))
					.isEmpty()) {
				foundProducts.add(productName);
			} else {
				missingProducts.add(productName);
			}
		}
		if (missingProducts.size() > 0) {
			flag = false;
			LOG.info("Products missing in the list : " + missingProducts);
			ReportListeners.test.log(Status.PASS, "Products missing in the list : " + missingProducts);
		} else {
			flag = true;
			LOG.error("Products found in the list : " + foundProducts);
			ReportListeners.test.log(Status.PASS, "Products found in the list : " + foundProducts);
		}
		return flag;
	}

	public CartPage clickCartLink() {
		try {
			WebElement element = waitForElementToBeClickable(CART_LINK_LOCATOR);
			element.click();
			LOG.info("Clicked on the Cart link.");
			ReportListeners.test.log(Status.PASS, "Clicked on the Cart link.");
			return new CartPage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on Cart link. Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to click on Cart link. Error occured : " + e.getMessage());
			return null;
		}
	}

	public ProductDetailsPage clickViewProduct(int index) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver
					.findElement(By.xpath("(//div[@class='productinfo text-center']/p/parent::div)[" + index + "]")));
			LOG.info("Scrolling to product with index " + index);
			ReportListeners.test.log(Status.PASS, "Scrolling to product with index " + index);
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath(
					"(//div[@class='productinfo text-center']/p/ancestor::div[@class='single-products']//following-sibling::div[@class='choose']/descendant::a)["
							+ index + "]")))
					.perform();
			LOG.info("Hovering over the product with index " + index);
			ReportListeners.test.log(Status.PASS, "Hovering over the product with index " + index);
			driver.findElement(By.xpath(
					"(//div[@class='productinfo text-center']/p/ancestor::div[@class='single-products']//following-sibling::div[@class='choose']/descendant::a)["
							+ index + "]"))
					.click();
			LOG.info("Clicking on the view product link of product with index " + index);
			ReportListeners.test.log(Status.PASS, "Clicking on the view product link of product with index " + index);
			return new ProductDetailsPage(driver);
		} catch (Exception e) {
			LOG.error("Unable to click on the view product link of product with index " + index + ". Error occured : " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to click on the view product link of product with index " + index + ". Error occured : " + e.getMessage());
			return null;
		}
	}

}