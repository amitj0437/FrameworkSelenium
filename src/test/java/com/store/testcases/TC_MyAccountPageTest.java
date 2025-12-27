package com.store.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.store.pageobject.AccountCreationDetails;
import com.store.pageobject.IndexPage;
import com.store.pageobject.My_Account;
import com.store.pageobject.SignoutPage;

public class TC_MyAccountPageTest extends BaseClass {

	@Test(enabled = false)
	public void verifyRegAndLogin() {

//		driver.get(url);
//		logger.info("Url opened");
	//	this
		IndexPage idx = new IndexPage(driver);
		idx.clickOnSignInBtn();
		logger.info("Clicked on sign in link");

		My_Account myAccount = new My_Account(driver);
		myAccount.accountCreate("amit0@gmail.com");
		logger.info("Email address entered successfully");
		myAccount.clickSubmit();
		logger.info("Clicked on the create an account button");

		AccountCreationDetails account = new AccountCreationDetails(driver);
		account.selectTitleMr();
		account.enterCustFName("Amit");
		account.enterCustLName("Jangra");
		account.enterPass("Amit@123");
		logger.info("User Detailed entered");
		account.clickOnRegBtn();
		logger.info("Registered button clicked");

		SignoutPage sign = new SignoutPage(driver);
		String username = sign.userLoginDetialsLink();
		Assert.assertEquals("Amit Jangra", username);
	}

	@Test()
	public void verifyLoginDetails() throws IOException {

		IndexPage idx = new IndexPage(driver);
		idx.clickOnSignInBtn();
		logger.info("Clicked on sign in link");

		My_Account acc = new My_Account(driver);
		acc.enterEmail("amit0@gmail.com");
		logger.info("Email entered...........");
		acc.enterPass("Amit@123");
		logger.info("Password entered.........");
		acc.submitBtn();
		logger.info("Submit successfully");
		SignoutPage sign = new SignoutPage(driver);
		String username = sign.userLoginDetialsLink();
		if(username.equals("Amit Jangra")) {
			logger.info("Verify login - Passed");
			
			Assert.assertTrue(true);
		}
		else {
			logger.info("Verify login - Failed");
			captureScreenshot(driver, "verifyLoginDetails");
			Assert.assertTrue(false);
		}
	}

}
