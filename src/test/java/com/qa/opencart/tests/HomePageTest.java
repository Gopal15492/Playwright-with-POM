package com.qa.opencart.tests;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.factory.PlaywrightFactory2;
import com.qa.opencart.pages.HomePage;

public class HomePageTest extends BaseTest {

	@Test
	public void homePageTitleTest() {
		String actualTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_PAGE_TITLE);
	}

	@Test
	public void HomePageURLTest() {
		String actualUrl = homePage.getHomePageURL();

		Assert.assertEquals(actualUrl, prop.getProperty("url"));
	}

	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] { { "Macbook" }, { "Mac" }, { "Samsung" } };
	}

	@Test(dataProvider = "getProductData")

	public void searchTest(String productName) {
		String actualSearch = homePage.dosearch(productName); // mac
		Assert.assertEquals(actualSearch, "Search - " + productName);
	}

}
