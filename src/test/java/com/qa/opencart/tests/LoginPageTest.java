package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void clickOnLogin() {
		loginPage = homePage.navigateToLoginPage();
		String actTitle = loginPage.getLoginPageTitle();
		System.out.println("account page title is :" + actTitle);
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void forgotPwdExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdExist());
	}

	@Test(priority = 3)
	public void appLoginTest() {
		loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

	}

}
