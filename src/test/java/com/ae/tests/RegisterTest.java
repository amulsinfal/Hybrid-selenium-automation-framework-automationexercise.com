package com.ae.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ae.base.BaseTest;
import com.ae.objects.CustomerAccountInformation;
import com.ae.objects.CustomerAddressInformation;
import com.ae.pages.AccountCreatedPage;
import com.ae.pages.AccountDeletedPage;
import com.ae.pages.HomePage;
import com.ae.pages.SignupLoginPage;
import com.ae.pages.SignupPage;

public class RegisterTest extends BaseTest{
	HomePage homePage;
	SignupLoginPage signupLoginPage;
	SignupPage signupPage;
	AccountCreatedPage accountCreatedPage;
	AccountDeletedPage accountDeletedPage;
		
	@Test (priority = 0, groups = {"Sanity", "Regression"}, description = "Test Case 1: Register User")
	public void testToRegisterUserWithNewEmail() {
		CustomerAccountInformation customerAccountInformation = new CustomerAccountInformation();
		customerAccountInformation.setTitle("Mr");
		customerAccountInformation.setPassword("johndoe");
		customerAccountInformation.setDay("15");
		customerAccountInformation.setMonth("August");
		customerAccountInformation.setYear("1990");
		
		CustomerAddressInformation customerAddressInformation = new CustomerAddressInformation();
		customerAddressInformation.setFirstName("John");
		customerAddressInformation.setLastName("Doe");
		customerAddressInformation.setCompany("The Lawrence Company");
		customerAddressInformation.setAddress1("1379, Spring Hill Rd");
		customerAddressInformation.setAddress2("Farend avenue");
		customerAddressInformation.setCountry("United States");
		customerAddressInformation.setState("AR");
		customerAddressInformation.setCity("Shreveport");
		customerAddressInformation.setZipcode("50576");
		customerAddressInformation.setMobileNumber("9999999999");
		
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isHomePageVisible(),"Home page not visible.");

		signupLoginPage = homePage.getNavigationBar().clickSignupLoginLink();
		Assert.assertTrue(signupLoginPage.isNewUserSignupLabelVisible()&&signupLoginPage.getNewUserSignupLabelText().equals("New User Signup!"),"'New User Signup!' label is missing or not visible.");
		
		signupPage = signupLoginPage.enterSignupName("johndoe03").enterSignupEmail("johndoe03@email.com").clickSignup();
		Assert.assertTrue(signupPage.isEnterAccountInformationLabelVisible() && signupPage.getEnterAccountInformationLabelText().equals("ENTER ACCOUNT INFORMATION"), "'ENTER ACCOUNT INFORMATION' label is missing or not visible.");
		
		accountCreatedPage = signupPage.fillCustomerAccountInformation(customerAccountInformation).selectNewsLetter("Yes").selectSpecialOffer("Yes").fillCustomerAddressInformation(customerAddressInformation).clickCreateAccount();
		Assert.assertTrue(accountCreatedPage.isAccountCreatedLabelVisible() && accountCreatedPage.getAccountCreatedLabelText() .equals("ACCOUNT CREATED!"), "'ACCOUNT CREATED!' label is missing or not visible.");
		
		homePage = accountCreatedPage.clickContinue();
		Assert.assertTrue(homePage.getNavigationBar().isLoggedInAsUsernameVisible() && homePage.getNavigationBar().getLoggedInAsUsernameText().equals("Logged in as johndoe03"), "'Logged in as username' label is missing or not visible.");
		
		accountDeletedPage = homePage.getNavigationBar().clickDeleteAccountLink();
		Assert.assertTrue(accountDeletedPage.isAccountDeletedLabelVisible() && accountDeletedPage.getAccountDeletedLabelText().equals("ACCOUNT DELETED!"), "'ACCOUNT DELETED!' label is missing or not visible.");
		
		homePage = accountDeletedPage.clickContinue();
		Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible.");
	}
	
	@Test (priority = 1, groups = {"Regression"}, description = "Test Case 5: Register User with existing email.")
	public void testToRegisterUserWithExistingEmail() {
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isHomePageVisible(),"Home page not visible.");

		signupLoginPage = homePage.getNavigationBar().clickSignupLoginLink();
		Assert.assertTrue(signupLoginPage.isNewUserSignupLabelVisible()&&signupLoginPage.getNewUserSignupLabelText().equals("New User Signup!"),"'New User Signup!' label is missing or not visible.");
		
		signupPage = signupLoginPage.enterSignupName("Johndoe01").enterSignupEmail("johndoe01@email.com").clickSignup();
		signupLoginPage = new SignupLoginPage(driver);
		Assert.assertTrue(signupLoginPage.isSignupErrorVisible() && signupLoginPage.getSignupErrorText().equals("Email Address already exist!"), "'Email Address already exist!' label is missing or not visible.");
	}
}