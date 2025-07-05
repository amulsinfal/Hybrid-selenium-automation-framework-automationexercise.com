package com.ae.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ae.base.BaseTest;
import com.ae.pages.HomePage;
import com.ae.pages.ProductsPage;

public class SearchTest extends BaseTest{
	HomePage homePage;
	ProductsPage productsPage;
	
	@Test (priority = 0, groups = {"Sanity", "Regression"}, description = "Test Case 9: Search Product")
	public void verifyProductsRelatedToSearchAreVisible() {
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isHomePageVisible(),"Home page not visible.");
		
		productsPage = homePage.getNavigationBar().clickProductsLink();
		Assert.assertTrue(productsPage.isProductsPageVisible(),"Products page not visible.");
		
		String searchString = "Men";
		String[] expectedResultList = {"Men Tshirt", "Madame Top For Women", "Lace Top For Women", "GRAPHIC DESIGN MEN T SHIRT - BLUE"};
		productsPage = productsPage.enterSearchText(searchString).clickSearch();
		Assert.assertTrue(productsPage.isProductPresent(expectedResultList), "Product not found in the search list.");
	}
}