package com.qa.ecommerce.test;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.BaseTest;
import com.qa.ecommerce.constants.AppConstants;
import com.qa.ecommerce.pages.ProductDetailsPage;

public class AccountPageTest extends BaseTest {
	
	@BeforeClass
	public void accountSetup() {
		loginPage = homePage.doClickLoginLink();
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("pass"));
	}
	
	@Test(priority=1)
	public void getAccountPageTitleTest() {
		
		String title = accountPage.getAccountPageTitle();
		Assert.assertEquals(title, AppConstants.ACCOUNT_TITLE);
	}

	@Test(priority=2)
	public void getAccountPageURLTest() {
		
		boolean isURL = accountPage.getAccountPageURL();
		Assert.assertEquals(isURL, true);
	}
	
	@Test(priority=3)
	public void getAcountPageLogoutLinkExist() {
		
		boolean isLogout = accountPage.isLogoutLinkExist();
		Assert.assertEquals(isLogout, true);
	}
	
	@Test(priority=4)
	public void getAccountPageHeaderList() {
		
		ArrayList<String> accHeaderList = accountPage.getAccountHeaderList();
		System.out.println("accHeaderList"+ accHeaderList);
		Assert.assertEquals(accHeaderList, AppConstants.ACC_PAGE_SEC_HEADERS);
	}
	
	
}
