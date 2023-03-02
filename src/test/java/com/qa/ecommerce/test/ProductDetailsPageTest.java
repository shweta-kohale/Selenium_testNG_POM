package com.qa.ecommerce.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.BaseTest;

public class ProductDetailsPageTest extends BaseTest {
	
	@BeforeClass
	public void productDetailsPageSetup() {
		loginPage = homePage.doClickLoginLink();
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("pass"));
	}
	
	@DataProvider
	public Object[][] getProductData(){
		
		return new Object[][] {
			{"MacBook", "MacBook Pro"}
		};
		
	}
	
	@Test(dataProvider = "getProductData")
	public void getProductHeaderNameTest(String productKey, String productName) {
		searchPage = accountPage.performSearch(productKey); 
		pdpPage = searchPage.selectProduct(productName);
		String productHeaderName = pdpPage.getProductHeaderName(productName);
		Assert.assertEquals(productHeaderName, productName);
	}
	
	@Test(dataProvider = "getProductData")
	public void getProductDetailsPageTitleTest(String productKey, String productName) {
		searchPage = accountPage.performSearch(productKey); 
		pdpPage = searchPage.selectProduct(productName);
		String title = pdpPage.getProductDetailsPageTitle();
		Assert.assertEquals(title, productName);
	}
	
	@Test
	public void getProductDetailsPageURLTest() {
		searchPage = accountPage.performSearch("MacBook"); 
		pdpPage = searchPage.selectProduct("MacBook");
		Assert.assertTrue(pdpPage.getProductDetailsPageURL("MacBook"));
	}

	@Test
	public void getProductMetaDataTest() {
		searchPage = accountPage.performSearch("MacBook"); 
		pdpPage = searchPage.selectProduct("MacBook Pro");
		Map<String,String> productData = pdpPage.getProductMetaData();
		Assert.assertEquals(productData.get("Brand"), "Apple");
		Assert.assertEquals(productData.get("Product Code"), "Product 18");
		Assert.assertEquals(productData.get("Reward Points"), "800");
		Assert.assertEquals(productData.get("Availability"), "Out Of Stock");
	}
}
