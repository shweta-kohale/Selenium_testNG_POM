package com.qa.ecommerce.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.BaseTest;
import com.qa.ecommerce.constants.AppConstants;

public class LoginPageTest extends BaseTest {
	
	@BeforeClass
	public void loginSetup() {
		loginPage = homePage.doClickLoginLink();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String actualLoginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualLoginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
	}

	@Test(priority=2)
	public void loginPageFormTextTest() {
		String actualloginPageFormText = loginPage.getLoginPageFormText();
		Assert.assertEquals(actualloginPageFormText, AppConstants.LOGIN_FORM_TEXT);
	}
	
	@Test(priority=3)
	public void isForgotPasswordLinkTest() {
		boolean forgotLink = loginPage.isForgotPasswordLink();
		Assert.assertEquals(forgotLink, true);
	}
	
	@Test(priority=4)
	public void loginTest() {
		accountPage = 	loginPage.doLogin(prop.getProperty("username"), prop.getProperty("pass"));
		Assert.assertEquals(accountPage.isLogoutLinkExist(), true);
	}
}
