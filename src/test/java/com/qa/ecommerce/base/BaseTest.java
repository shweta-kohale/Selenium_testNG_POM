package com.qa.ecommerce.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import com.qa.ecommerce.factory.DriverFactory;
import com.qa.ecommerce.pages.AccountPage;
import com.qa.ecommerce.pages.HomePage;
import com.qa.ecommerce.pages.LoginPage;
import com.qa.ecommerce.pages.ProductDetailsPage;
import com.qa.ecommerce.pages.SearchResultsPage;


public class BaseTest {
	DriverFactory df;
	public WebDriver driver;
	public Properties prop;
	
	public HomePage homePage;
	public LoginPage loginPage;
	public AccountPage accountPage;
	public ProductDetailsPage pdpPage;
	public SearchResultsPage searchPage;
	
	@BeforeTest
	public void setUp() {
	DriverFactory df = new DriverFactory();
	prop = df.initProp();
	driver = df.initDriver(prop);
	
	homePage = new HomePage(driver);
	//loginPage = new LoginPage(driver);
		 
	}
	
	
	
//	@AfterTest
//	public void closeBrowser() {
//		driver.quit();
//	}

}
