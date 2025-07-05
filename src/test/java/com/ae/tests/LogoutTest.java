package com.ae.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ae.base.BaseTest;
import com.ae.pages.HomePage;
import com.ae.pages.SignupLoginPage;

public class LogoutTest extends BaseTest{
	HomePage homePage;
	SignupLoginPage signupLoginPage;
	
	@Test (priority = 0, groups = {"Sanity", "Regression"}, description = "Test Case 4: Logout User")
	public void testToLogoutUser() {
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isHomePageVisible(),"Home page not visible.");
		
		signupLoginPage = homePage.getNavigationBar().clickSignupLoginLink();
		Assert.assertTrue(signupLoginPage.isLoginToYourAccountLabelVisible()&&signupLoginPage.getLoginToYourAccountLabelText().equals("Login to your account"),"'Login to your account' label is missing or not visible.");
		
		homePage = homePage.getNavigationBar().clickSignupLoginLink().enterLoginEmail("johndoe02@email.com").enterLoginPassword("johndoe").clickLogin();
		Assert.assertTrue(homePage.getNavigationBar().isLoggedInAsUsernameVisible() && homePage.getNavigationBar().getLoggedInAsUsernameText().equals("Logged in as johndoe02"), "'Logged in as username' label is missing or not visible.");
		
		signupLoginPage = homePage.getNavigationBar().clickLogoutLink();
		Assert.assertTrue(signupLoginPage.isSignupLoginPageVisible(), "Signup / login page not displayed.");
	}
	
}