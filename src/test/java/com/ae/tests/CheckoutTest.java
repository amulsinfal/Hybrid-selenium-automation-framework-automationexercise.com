package com.ae.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ae.base.BaseTest;
import com.ae.objects.Customers;
import com.ae.objects.Payments;
import com.ae.pages.AccountCreatedPage;
import com.ae.pages.CartPage;
import com.ae.pages.CheckoutPage;
import com.ae.pages.HomePage;
import com.ae.pages.PaymentDonePage;
import com.ae.pages.PaymentPage;
import com.ae.pages.SignupLoginPage;

public class CheckoutTest extends BaseTest {
	HomePage homePage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	SignupLoginPage signupLoginPage;
	PaymentPage paymentPage;
	PaymentDonePage paymentDonePage;
	AccountCreatedPage accountCreatedPage;
	
	@Test(priority = 0, groups = {"Sanity", "Regression"}, description = "Test Case 14: Place Order: Register while Checkout.")
	public void testToRegisterWhileCheckout() {
		
		Customers customer = new Customers();
		customer.setTitle("Mr");
		customer.setPassword("johndoe");
		customer.setDay("15");
		customer.setMonth("August");
		customer.setYear("1990");
		customer.setNewsletter("Yes");
		customer.setSpecialOffer("Yes");
		customer.setFirstName("John");
		customer.setLastName("Doe");
		customer.setCompany("The Lawrence Company");
		customer.setAddress1("1379, Spring Hill Rd");
		customer.setAddress2("Farend avenue");
		customer.setCountry("United States");
		customer.setState("AR");
		customer.setCity("Shreveport");
		customer.setZipcode("50576");
		customer.setMobileNumber("9999999999");
		
		Payments payment = new Payments();
		payment.setNameOnCard("John Doe");
		payment.setCardNumber("6452789545625468");
		payment.setCvc("311");
		payment.setExpiryMonth("05");
		payment.setExpiryYear("2026");
		
		String[] productsToAddToCart = {"Blue Top", "Men Tshirt"};
		
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isHomePageVisible(),"Home page not visible.");
		
		accountCreatedPage = homePage.addToCart(productsToAddToCart).clickCartLink()
				.clickProceedToCheckout().clickRegisterLoginLink()
				.enterSignupName("johndoe05").enterSignupEmail("johndoe05@email.com").clickSignup()
				.fillCustomerInformation(customer).clickCreateAccount();
		Assert.assertTrue(accountCreatedPage.isAccountCreatedLabelVisible(),"'ACCOUNT CREATED!' label is not visible");
		Assert.assertEquals(accountCreatedPage.getAccountCreatedLabelText(), "ACCOUNT CREATED!", "'ACCOUNT CREATED!' label text is incorrect.");
		
		homePage = accountCreatedPage.clickContinue();
		Assert.assertTrue(homePage.getNavigationBar().isLoggedInAsUsernameVisible(), "'Logged in as username' label is missing or not visible.");
		Assert.assertEquals(homePage.getNavigationBar().getLoggedInAsUsernameText(), "Logged in as johndoe05", "'Logged in as username' label text is not matching.");
		
		cartPage = homePage.clickCartLink();
		Assert.assertTrue(cartPage.isCartPageVisible(),"Cart page not visible.");		
		
		cartPage.clickProceedToCheckout();
		checkoutPage = new CheckoutPage(driver);
		Assert.assertEquals(checkoutPage.getCustomerName(), "Mr. John Doe","Customer name is incorrect.");
		Assert.assertEquals(checkoutPage.getCustomerCompany(),"The Lawrence Company","Customer company name is incorrect.");
		Assert.assertEquals(checkoutPage.getCustomerAddress1(), "1379, Spring Hill Rd","Customer address1 is incorrect.");
		Assert.assertEquals(checkoutPage.getCustomerAddress2(), "Farend avenue","Customer address2 is incorrect.");
		Assert.assertEquals(checkoutPage.getCustomerCityStateZip(), "Shreveport AR 50576","Customer city, state and zipcode is incorrect.");
		Assert.assertEquals(checkoutPage.getCustomerCountry(), "United States","Customer country is incorrect.");
		Assert.assertEquals(checkoutPage.getCustomerMobile(), "9999999999","Customer mobile is incorrect.");
		Assert.assertEquals(checkoutPage.getProductPrice("Blue Top"), "500", "Product Price is incorrect.");
		Assert.assertEquals(checkoutPage.getProductQuantity("Blue Top"), "1","Product Quantity is incorrect.");
		Assert.assertEquals(checkoutPage.getProductTotalAmount("Blue Top"), "500","Product Total Amount is incorrect.");
		Assert.assertEquals(checkoutPage.getProductPrice("Men Tshirt"), "400","Product Price is incorrect.");
		Assert.assertEquals(checkoutPage.getProductQuantity("Men Tshirt"),"1","Product Quantity is incorrect.");
		Assert.assertEquals(checkoutPage.getProductTotalAmount("Men Tshirt"), "400","Product Total Amount is incorrect.");		
		
		paymentDonePage = checkoutPage.enterComment("This is the sample comment on the checkoutpage.").clickPlaceOrder()
				.fillCardDetails(payment).clickPayAndConfirmOrder();
		Assert.assertTrue(paymentDonePage.isConfirmedMessageVisible(), "Confirm message is not displayed.");
		Assert.assertEquals(paymentDonePage.getConfirmedMessageText(), "Congratulations! Your order has been confirmed!", "Confirmation message is incorrect.");
		
		homePage = homePage.getNavigationBar().clickDeleteAccountLink()
				.clickContinue();
		Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible.");
	}
	
	@Test(priority = 1, groups = {"Sanity", "Regression"}, description = "Test Case 15: Place Order: Register before Checkout")
	public void testToRegisterBeforeCheckout() {
		
		Customers customer = new Customers();
		customer.setTitle("Mr");
		customer.setPassword("johndoe");
		customer.setDay("15");
		customer.setMonth("August");
		customer.setYear("1990");
		customer.setNewsletter("Yes");
		customer.setSpecialOffer("Yes");
		customer.setFirstName("John");
		customer.setLastName("Doe");
		customer.setCompany("The Lawrence Company");
		customer.setAddress1("1379, Spring Hill Rd");
		customer.setAddress2("Farend avenue");
		customer.setCountry("United States");
		customer.setState("AR");
		customer.setCity("Shreveport");
		customer.setZipcode("50576");
		customer.setMobileNumber("9999999999");
		
		Payments payment = new Payments();
		payment.setNameOnCard("John Doe");
		payment.setCardNumber("6452789545625468");
		payment.setCvc("311");
		payment.setExpiryMonth("05");
		payment.setExpiryYear("2026");
		
		String[] productsToAddToCart = {"Blue Top", "Men Tshirt"};
		
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isHomePageVisible(),"Home page not visible.");
		
		accountCreatedPage = homePage.getNavigationBar().clickSignupLoginLink()
				.enterSignupName("johndoe05").enterSignupEmail("johndoe05@email.com").clickSignup()
				.fillCustomerInformation(customer).clickCreateAccount();
		Assert.assertTrue(accountCreatedPage.isAccountCreatedLabelVisible() && accountCreatedPage.getAccountCreatedLabelText() .equals("ACCOUNT CREATED!"), "'ACCOUNT CREATED!' label is missing or not visible.");
		
		homePage = accountCreatedPage.clickContinue();
		Assert.assertTrue(homePage.getNavigationBar().isLoggedInAsUsernameVisible() && homePage.getNavigationBar().getLoggedInAsUsernameText().equals("Logged in as johndoe05"), "'Logged in as username' label is missing or not visible.");
		
		cartPage = homePage.addToCart(productsToAddToCart)
				.clickCartLink();
		Assert.assertTrue(cartPage.isCartPageVisible(), "Cart Page is not visible.");
		
		cartPage = cartPage.clickProceedToCheckout();
		checkoutPage = new CheckoutPage(driver);
		Assert.assertEquals(checkoutPage.getCustomerName(), "Mr. John Doe","Customer name is incorrect.");
		Assert.assertEquals(checkoutPage.getCustomerCompany(),"The Lawrence Company","Customer company name is incorrect.");
		Assert.assertEquals(checkoutPage.getCustomerAddress1(), "1379, Spring Hill Rd","Customer address1 is incorrect.");
		Assert.assertEquals(checkoutPage.getCustomerAddress2(), "Farend avenue","Customer address2 is incorrect.");
		Assert.assertEquals(checkoutPage.getCustomerCityStateZip(), "Shreveport AR 50576","Customer city, state and zipcode is incorrect.");
		Assert.assertEquals(checkoutPage.getCustomerCountry(), "United States","Customer country is incorrect.");
		Assert.assertEquals(checkoutPage.getCustomerMobile(), "9999999999","Customer mobile is incorrect.");
		Assert.assertEquals(checkoutPage.getProductPrice("Blue Top"), "500", "Product Price is incorrect.");
		Assert.assertEquals(checkoutPage.getProductQuantity("Blue Top"), "1","Product Quantity is incorrect.");
		Assert.assertEquals(checkoutPage.getProductTotalAmount("Blue Top"), "500","Product Total Amount is incorrect.");
		Assert.assertEquals(checkoutPage.getProductPrice("Men Tshirt"), "400","Product Price is incorrect.");
		Assert.assertEquals(checkoutPage.getProductQuantity("Men Tshirt"),"1","Product Quantity is incorrect.");
		Assert.assertEquals(checkoutPage.getProductTotalAmount("Men Tshirt"), "400","Product Total Amount is incorrect.");		
		
		paymentDonePage = checkoutPage.enterComment("This is the sample comment on the checkoutpage.").clickPlaceOrder()
				.fillCardDetails(payment).clickPayAndConfirmOrder();
		Assert.assertTrue(paymentDonePage.isConfirmedMessageVisible(), "Confirm message is not displayed.");
		Assert.assertEquals(paymentDonePage.getConfirmedMessageText(), "Congratulations! Your order has been confirmed!", "Confirmation message is incorrect.");
		
		homePage = homePage.getNavigationBar().clickDeleteAccountLink()
				.clickContinue();
		Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible.");
	}
	
	@Test(priority = 2, groups = {"Sanity", "Regression"}, description = "Test Case 16: Place Order: Login before Checkout")
	public void testToLoginBeforeCheckout() {
		
		Customers customer = new Customers();
		customer.setTitle("Mr");
		customer.setPassword("johndoe");
		customer.setDay("15");
		customer.setMonth("August");
		customer.setYear("1990");
		customer.setNewsletter("Yes");
		customer.setSpecialOffer("Yes");
		customer.setFirstName("John");
		customer.setLastName("Doe");
		customer.setCompany("The Lawrence Company");
		customer.setAddress1("1379, Spring Hill Rd");
		customer.setAddress2("Farend avenue");
		customer.setCountry("United States");
		customer.setState("AR");
		customer.setCity("Shreveport");
		customer.setZipcode("50576");
		customer.setMobileNumber("9999999999");
		
		Payments payment = new Payments();
		payment.setNameOnCard("John Doe");
		payment.setCardNumber("6452789545625468");
		payment.setCvc("311");
		payment.setExpiryMonth("05");
		payment.setExpiryYear("2026");
		
		String[] productsToAddToCart = {"Blue Top", "Men Tshirt"};
		
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isHomePageVisible(),"Home page not visible.");
		
		homePage = homePage.getNavigationBar().clickSignupLoginLink()
				.enterSignupName("johndoe06").enterSignupEmail("johndoe06@email.com").clickSignup()
				.fillCustomerInformation(customer).clickCreateAccount()
				.clickContinue()
				.getNavigationBar().clickLogoutLink()
				.clickHomeLink();		
		Assert.assertTrue(homePage.isHomePageVisible(),"Home page not visible.");

		homePage = homePage.getNavigationBar().clickSignupLoginLink()
				.enterLoginEmail("johndoe06@email.com").enterLoginPassword("johndoe").clickLogin();
		Assert.assertTrue(homePage.getNavigationBar().isLoggedInAsUsernameVisible(),"'Logged in as username' label is missing or not visible.");
		Assert.assertEquals(homePage.getNavigationBar().getLoggedInAsUsernameText(), "Logged in as johndoe06", "'Logged in as username' label text is incorrect."); 
		
		cartPage = homePage.getNavigationBar().clickProductsLink()
				.addToCart(productsToAddToCart)
				.clickCartLink();
		Assert.assertTrue(cartPage.isCartPageVisible(), "Cart Page is not visible.");
		
		cartPage = cartPage.clickProceedToCheckout();
		checkoutPage = new CheckoutPage(driver);
		Assert.assertEquals(checkoutPage.getCustomerName(), "Mr. John Doe","Customer name is incorrect.");
		Assert.assertEquals(checkoutPage.getCustomerCompany(),"The Lawrence Company","Customer company name is incorrect.");
		Assert.assertEquals(checkoutPage.getCustomerAddress1(), "1379, Spring Hill Rd","Customer address1 is incorrect.");
		Assert.assertEquals(checkoutPage.getCustomerAddress2(), "Farend avenue","Customer address2 is incorrect.");
		Assert.assertEquals(checkoutPage.getCustomerCityStateZip(), "Shreveport AR 50576","Customer city, state and zipcode is incorrect.");
		Assert.assertEquals(checkoutPage.getCustomerCountry(), "United States","Customer country is incorrect.");
		Assert.assertEquals(checkoutPage.getCustomerMobile(), "9999999999","Customer mobile is incorrect.");
		Assert.assertEquals(checkoutPage.getProductPrice("Blue Top"), "500", "Product Price is incorrect.");
		Assert.assertEquals(checkoutPage.getProductQuantity("Blue Top"), "1","Product Quantity is incorrect.");
		Assert.assertEquals(checkoutPage.getProductTotalAmount("Blue Top"), "500","Product Total Amount is incorrect.");
		Assert.assertEquals(checkoutPage.getProductPrice("Men Tshirt"), "400","Product Price is incorrect.");
		Assert.assertEquals(checkoutPage.getProductQuantity("Men Tshirt"),"1","Product Quantity is incorrect.");
		Assert.assertEquals(checkoutPage.getProductTotalAmount("Men Tshirt"), "400","Product Total Amount is incorrect.");		
		
		paymentDonePage = checkoutPage.enterComment("This is the sample comment on the checkoutpage.").clickPlaceOrder()
				.fillCardDetails(payment).clickPayAndConfirmOrder();
		Assert.assertTrue(paymentDonePage.isConfirmedMessageVisible(), "Confirm message is not displayed.");
		Assert.assertEquals(paymentDonePage.getConfirmedMessageText(), "Congratulations! Your order has been confirmed!", "Confirmation message is incorrect.");
		
		homePage = homePage.getNavigationBar().clickDeleteAccountLink()
				.clickContinue();
		Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible.");
		
	}
	
}