package com.ae.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ae.base.BaseTest;
import com.ae.pages.HomePage;
import com.ae.pages.ProductDetailsPage;
import com.ae.pages.ProductsPage;

public class ProductsPageTest extends BaseTest {
	HomePage homePage;
	ProductsPage productsPage;
	ProductDetailsPage productDetailsPage;
	
	@Test (priority = 0, groups = {"Sanity", "Regression"}, description = "Test Case 8: Verify All Products and product detail page")
	public void verifyAllProductsAndProductDetailsPage() {
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isHomePageVisible(),"Home page not visible.");
		
		productsPage = homePage.getNavigationBar().clickProductsLink();
		Assert.assertTrue(productsPage.isProductsPageVisible(),"Products page not visible.");
		Assert.assertTrue(productsPage.isProductListVisible(), "Product list is not visible.");
		
		productDetailsPage = productsPage.clickViewProduct(1);
		Assert.assertTrue(productDetailsPage.isProductDetailsPageVisible(),"Product Details page not visible.");
		Assert.assertTrue(productDetailsPage.getProductName().equals("Blue Top"),"Product Name incorrect or not visible.");
		Assert.assertTrue(productDetailsPage.getProductCategory().equals("Women > Tops"),"Product Category incorrect or not visible.");
		Assert.assertTrue(productDetailsPage.getProductPrice().equals("500"),"Product Price incorrect or not visible.");
		Assert.assertTrue(productDetailsPage.getProductAvailability().equals("In Stock"),"Product Availability incorrect or not visible.");
		Assert.assertTrue(productDetailsPage.getProductCondition().equals("New"),"Product Condition or not visible.");
		Assert.assertTrue(productDetailsPage.getProductBrand().equals("Polo"),"Product Brand incorrect or not visible.");
	}
	
}