package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {

	private Page page;

	private String search = "input[placeholder='Search']";
	private String searchIcon = "button.btn.btn-default ";
	private String searchPageHeader = "div#content h1";

	private String loginLink = "a:text('Login')";
	private String myAccountLink = "a[title='My Account']";

	// pg constr
	public HomePage(Page page) {
		this.page = page;
	}

	// page actions
	public String getHomePageTitle() {
		String title = page.title();
		System.out.println("Homepage title is :" + title);
		return title;
	}

	// page actions
	public String getHomePageURL() {
		String url = page.url();
		System.out.println("Homepage url  is :" + url);
		return url;
	}

	public String dosearch(String productName) {
		page.fill(search, productName);
		page.click(searchIcon);
		String header = page.textContent(searchPageHeader);
		System.out.println("header of search is :" + header);

		return header;

	}

	public LoginPage navigateToLoginPage() {
		page.click(myAccountLink);
		page.click(loginLink);
		return new LoginPage(page);
	}

}
