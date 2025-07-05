package com.ae.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ae.base.BaseTest;
import com.ae.objects.Messages;
import com.ae.pages.ContactUsPage;
import com.ae.pages.HomePage;

public class ContactUsTest extends BaseTest {
	HomePage homePage;
	ContactUsPage contactUsPage;

	@Test(priority = 0, groups = {"Sanity", "Regression"}, description = "Test Case 6: Contact Us Form")
	public void testContactUsForm() {
		Messages message = new Messages();
		message.setName("john Doe");
		message.setEmail("jackdoe@email.com");
		message.setSubject("This is the sample Subject.");
		message.setMessage("This is the sample message body");
		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\Sample.txt";

		homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible.");
	
		contactUsPage = homePage.getNavigationBar().clickContactUsLink();
		Assert.assertTrue(contactUsPage.isGetInTouchLabelVisible() && contactUsPage.getGetInTouchText().equals("GET IN TOUCH"),"'GET IN TOUCH' text is missing or not visible.");
		
		contactUsPage = contactUsPage.fillContactForm(message).enterFilePath(filePath).clickSubmit()
				.clickOkOnAlert();
		Assert.assertTrue(contactUsPage.isSuccessMessageVisible() && contactUsPage.getSuccessMessageText().equals("Success! Your details have been submitted successfully."),"'Success! Your details have been submitted successfully.' text is missing or not visible.");
		
		homePage = contactUsPage.clickHome();
		Assert.assertTrue(homePage.isHomePageVisible(), "Home page not visible.");
	}

}