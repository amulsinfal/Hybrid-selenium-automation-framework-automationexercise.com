package com.ae.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ae.base.BaseTest;
import com.ae.pages.CartPage;
import com.ae.pages.HomePage;
import com.ae.pages.ProductDetailsPage;
import com.ae.pages.ProductsPage;

public class CartPageTest extends BaseTest {
	HomePage homePage; 
	ProductsPage productsPage;
	CartPage cartPage;
	ProductDetailsPage productDetailsPage;
	
	@Test (priority = 0, groups = {"Sanity", "Regression"}, description = "Test to verify quantity of the product in the cart.")
	public void testToVerifyProductQuantityInCart() {
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isHomePageVisible(),"Home page not visible.");
		productDetailsPage = homePage.clickViewProduct("Blue Top");
		Assert.assertTrue(productDetailsPage.isProductDetailsPageVisible(),"Products details page is not Visible.");
		cartPage = productDetailsPage.selectQuantity("4").clickAddToCart().clickViewCartLink();
		Assert.assertEquals(cartPage.getProductQuantity("Blue Top"), "4","Product quantity in the cart Page is not matching");
	}
	
	@Test (priority = 1, groups = {"Sanity", "Regression"}, description = "Test Case 17: Remove Products From Cart.")
	public void testToRemoveProductsFromCart() {
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isHomePageVisible(),"Home page not visible.");
		String[] products = {"Blue Top", "Men Tshirt"};
		productsPage = homePage.getNavigationBar().clickProductsLink().addToCart(products);
		cartPage = productsPage.clickCartLink();
		Assert.assertTrue(cartPage.isCartPageVisible(),"Cart page not visible.");
		cartPage = cartPage.clickXButton(products);
		Assert.assertTrue(cartPage.isCartEmpty(), "Cart is not empty.");
	}

}