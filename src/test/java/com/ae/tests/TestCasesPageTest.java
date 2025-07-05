package com.ae.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ae.base.BaseTest;
import com.ae.pages.HomePage;

public class TestCasesPageTest extends BaseTest{
	HomePage homePage;
	
	@Test (priority = 0, groups = {"Regression"}, description = "Test Case 7: Verify Test Cases Page")
	public void testToVerifyTestCasesPage() {
		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.getNavigationBar().clickTestCasesLink().isOnTestCasesPage(), "Test cases page is not visible.");
	}
}