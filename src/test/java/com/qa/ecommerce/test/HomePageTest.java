package com.qa.ecommerce.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.BaseTest;
import com.qa.ecommerce.constants.AppConstants;


public class HomePageTest extends BaseTest{
	
	
	
	@Test(priority=2)
	public void getMyAccountLinkTest() {
		String actualLinkName = homePage.getMyAccountLink();
		System.out.println("actualLinkName : "+actualLinkName);
		Assert.assertEquals(actualLinkName, "My Account");
	}
	
	@Test(priority=1)
	public void getHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		Assert.assertEquals(title, "Your Store");
	}
	
	@Test(priority=3)
	public void doClickLoginLinkTest() {
		loginPage = homePage.doClickLoginLink();
		String loginFormText = loginPage.getLoginPageFormText();
		Assert.assertEquals(loginFormText, AppConstants.LOGIN_FORM_TEXT);
	}

}
