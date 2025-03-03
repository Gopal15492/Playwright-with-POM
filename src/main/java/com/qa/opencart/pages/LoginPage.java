package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	private Page page;

	private String emailId = "#input-email";
	private String password = "#input-password";
	private String loginBtn = "//input[@value='Login']";
	private String forgotPwd = "(//a[contains(text(),'Forgotten Password')])[1]";
	private String logoutCheck = "//div[@id='content']/h2[1]";

	LoginPage(Page page) {
		this.page = page;
	}

	public String getLoginPageTitle() {
		return page.title();
	}

	public boolean isForgotPwdExist() {
		return page.isVisible(emailId);
	}

	public boolean doLogin(String appUserName, String appPassword) {
		System.out.println("App cred are :" + appUserName + " : " + appPassword);

		page.fill(emailId, appUserName);
		page.fill(password, appPassword);
		page.click(loginBtn);

		if (page.isVisible(logoutCheck)) {
			System.out.println("user is login successfully");
			return true;
		}
		return false;

	}
}