package com.qa.ecommerce.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.BaseTest;

public class SearchResultsPageTest extends BaseTest {
	
	@BeforeClass
	public void searchPageSetup() {
		loginPage = homePage.doClickLoginLink();
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("pass"));
	}

	@DataProvider
	public Object[][] getSearchData(){
		return new Object[][] {
			{"Macbook"},
			{"Samsung"}
			
		};
	}
	
	@Test(dataProvider = "getSearchData")
	public void isSearchSuccessfullTest(String searchKey) {
		searchPage = accountPage.performSearch(searchKey);
		boolean isSearch = searchPage.isSearchSuccessful();
		Assert.assertEquals(isSearch, true);
	}
	
	@DataProvider
	public Object[][] getProductData(){
		return new Object[][] {
			{"Macbook","MacBook Pro"},
			{"Samsung","Samsung Galaxy Tab 10.1"}
			
		};
	}
	
	@Test(dataProvider = "getProductData")
	public void selectProductTest(String searchKey, String productName) {
		searchPage = accountPage.performSearch(searchKey);
		pdpPage = searchPage.selectProduct(productName);
		String actualHeaderName = pdpPage.getProductHeaderName(productName);
		Assert.assertEquals(actualHeaderName, productName);
	}
}
